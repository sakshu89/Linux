package com.ibm.icu.impl;

import defpackage.dk0;
import defpackage.ky0;
import defpackage.og;
import java.util.Arrays;
import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class PropsVectors {
    public static final int ERROR_VALUE_CP = 1114113;
    public static final int FIRST_SPECIAL_CP = 1114112;
    public static final int INITIAL_ROWS = 4096;
    public static final int INITIAL_VALUE_CP = 1114112;
    public static final int MAX_CP = 1114113;
    public static final int MAX_ROWS = 1114114;
    public static final int MEDIUM_ROWS = 65536;
    private int columns;
    private boolean isCompacted;
    private int maxRows;
    private int prevRow;
    private int rows;
    private int[] v;

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public interface CompactHandler {
        void setRowIndexForErrorValue(int i);

        void setRowIndexForInitialValue(int i);

        void setRowIndexForRange(int i, int i2, int i3);

        void startRealValues(int i);
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class DefaultGetFoldedValue implements TrieBuilder.DataManipulate {
        private IntTrieBuilder builder;

        public DefaultGetFoldedValue(IntTrieBuilder intTrieBuilder) {
            this.builder = intTrieBuilder;
        }

        @Override // com.ibm.icu.impl.TrieBuilder.DataManipulate
        public int getFoldedValue(int i, int i2) {
            int i3 = this.builder.m_initialValue_;
            int i4 = i + 1024;
            while (i < i4) {
                boolean[] zArr = new boolean[1];
                int value = this.builder.getValue(i, zArr);
                if (zArr[0]) {
                    i += 32;
                } else {
                    if (value != i3) {
                        return i2;
                    }
                    i++;
                }
            }
            return 0;
        }
    }

    public PropsVectors(int i) {
        if (i < 1) {
            og.i(ky0.h(i, "numOfColumns need to be no less than 1; but it is "));
            throw null;
        }
        int i2 = i + 2;
        this.columns = i2;
        int[] iArr = new int[i2 * 4096];
        this.v = iArr;
        this.maxRows = 4096;
        this.rows = 3;
        this.prevRow = 0;
        this.isCompacted = false;
        iArr[0] = 0;
        int i3 = 1114112;
        iArr[1] = 1114112;
        while (i3 <= 1114113) {
            int[] iArr2 = this.v;
            iArr2[i2] = i3;
            i3++;
            iArr2[i2 + 1] = i3;
            i2 += this.columns;
        }
    }

    private boolean areElementsSame(int i, int[] iArr, int i2, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            if (this.v[i + i4] != iArr[i2 + i4]) {
                return false;
            }
        }
        return true;
    }

    private int findRow(int i) {
        int i2 = this.prevRow;
        int i3 = this.columns;
        int i4 = i2 * i3;
        int[] iArr = this.v;
        int i5 = 0;
        if (i >= iArr[i4]) {
            if (i < iArr[i4 + 1]) {
                return i4;
            }
            int i6 = i4 + i3;
            if (i < iArr[i6 + 1]) {
                this.prevRow = i2 + 1;
                return i6;
            }
            int i7 = i6 + i3;
            int i8 = iArr[i7 + 1];
            if (i < i8) {
                this.prevRow = i2 + 2;
                return i7;
            }
            if (i - i8 < 10) {
                this.prevRow = i2 + 2;
                do {
                    this.prevRow++;
                    i7 += this.columns;
                } while (i >= this.v[i7 + 1]);
                return i7;
            }
        } else if (i < iArr[1]) {
            this.prevRow = 0;
            return 0;
        }
        int i9 = this.rows;
        while (i5 < i9 - 1) {
            int i10 = (i5 + i9) / 2;
            int i11 = this.columns * i10;
            int[] iArr2 = this.v;
            if (i < iArr2[i11]) {
                i9 = i10;
            } else {
                if (i < iArr2[i11 + 1]) {
                    this.prevRow = i10;
                    return i11;
                }
                i5 = i10;
            }
        }
        this.prevRow = i5;
        return i5 * this.columns;
    }

    public void compact(CompactHandler compactHandler) {
        if (this.isCompacted) {
            return;
        }
        this.isCompacted = true;
        int i = this.columns - 2;
        Integer[] numArr = new Integer[this.rows];
        for (int i2 = 0; i2 < this.rows; i2++) {
            numArr[i2] = Integer.valueOf(this.columns * i2);
        }
        Arrays.sort(numArr, new Comparator<Integer>() { // from class: com.ibm.icu.impl.PropsVectors.1
            @Override // java.util.Comparator
            public int compare(Integer num, Integer num2) {
                int iIntValue = num.intValue();
                int iIntValue2 = num2.intValue();
                int i3 = PropsVectors.this.columns;
                int i4 = 2;
                do {
                    int i5 = iIntValue + i4;
                    int i6 = PropsVectors.this.v[i5];
                    int i7 = iIntValue2 + i4;
                    int i8 = PropsVectors.this.v[i7];
                    PropsVectors propsVectors = PropsVectors.this;
                    if (i6 != i8) {
                        return propsVectors.v[i5] < PropsVectors.this.v[i7] ? -1 : 1;
                    }
                    i4++;
                    if (i4 == propsVectors.columns) {
                        i4 = 0;
                    }
                    i3--;
                } while (i3 > 0);
                return 0;
            }
        });
        int i3 = -i;
        int i4 = i3;
        for (int i5 = 0; i5 < this.rows; i5++) {
            int i6 = this.v[numArr[i5].intValue()];
            if (i4 < 0 || !areElementsSame(numArr[i5].intValue() + 2, this.v, numArr[i5 - 1].intValue() + 2, i)) {
                i4 += i;
            }
            if (i6 == 1114112) {
                compactHandler.setRowIndexForInitialValue(i4);
            } else if (i6 == 1114113) {
                compactHandler.setRowIndexForErrorValue(i4);
            }
        }
        int i7 = i4 + i;
        compactHandler.startRealValues(i7);
        int[] iArr = new int[i7];
        for (int i8 = 0; i8 < this.rows; i8++) {
            int i9 = this.v[numArr[i8].intValue()];
            int i10 = this.v[numArr[i8].intValue() + 1];
            if (i3 < 0 || !areElementsSame(numArr[i8].intValue() + 2, iArr, i3, i)) {
                i3 += i;
                System.arraycopy(this.v, numArr[i8].intValue() + 2, iArr, i3, i);
            }
            if (i9 < 1114112) {
                compactHandler.setRowIndexForRange(i9, i10 - 1, i3);
            }
        }
        this.v = iArr;
        this.rows = (i3 / i) + 1;
    }

    public IntTrie compactToTrieWithRowIndexes() {
        PVecToTrieCompactHandler pVecToTrieCompactHandler = new PVecToTrieCompactHandler();
        compact(pVecToTrieCompactHandler);
        IntTrieBuilder intTrieBuilder = pVecToTrieCompactHandler.builder;
        return intTrieBuilder.serialize(new DefaultGetFoldedValue(intTrieBuilder), new DefaultGetFoldingOffset(0));
    }

    public int[] getCompactedArray() {
        if (this.isCompacted) {
            return this.v;
        }
        og.n("Illegal Invocation of the method before compact()");
        return null;
    }

    public int getCompactedColumns() {
        if (this.isCompacted) {
            return this.columns - 2;
        }
        og.n("Illegal Invocation of the method before compact()");
        return 0;
    }

    public int getCompactedRows() {
        if (this.isCompacted) {
            return this.rows;
        }
        og.n("Illegal Invocation of the method before compact()");
        return 0;
    }

    public int[] getRow(int i) {
        if (this.isCompacted) {
            og.n("Illegal Invocation of the method after compact()");
            return null;
        }
        if (i < 0 || i > this.rows) {
            og.i("rowIndex out of bound!");
            return null;
        }
        int i2 = this.columns;
        int[] iArr = new int[i2 - 2];
        System.arraycopy(this.v, (i * i2) + 2, iArr, 0, i2 - 2);
        return iArr;
    }

    public int getRowEnd(int i) {
        if (this.isCompacted) {
            og.n("Illegal Invocation of the method after compact()");
            return 0;
        }
        if (i >= 0 && i <= this.rows) {
            return this.v[(i * this.columns) + 1] - 1;
        }
        og.i("rowIndex out of bound!");
        return 0;
    }

    public int getRowStart(int i) {
        if (this.isCompacted) {
            og.n("Illegal Invocation of the method after compact()");
            return 0;
        }
        if (i >= 0 && i <= this.rows) {
            return this.v[i * this.columns];
        }
        og.i("rowIndex out of bound!");
        return 0;
    }

    public int getValue(int i, int i2) {
        if (this.isCompacted || i < 0 || i > 1114113 || i2 < 0 || i2 >= this.columns - 2) {
            return 0;
        }
        return this.v[findRow(i) + 2 + i2];
    }

    public void setValue(int i, int i2, int i3, int i4, int i5) {
        if (i < 0 || i > i2 || i2 > 1114113 || i3 < 0 || i3 >= this.columns - 2) {
            dk0.v();
            return;
        }
        if (this.isCompacted) {
            og.n("Shouldn't be called aftercompact()!");
            return;
        }
        int i6 = i2 + 1;
        int i7 = i3 + 2;
        int i8 = i4 & i5;
        int iFindRow = findRow(i);
        int iFindRow2 = findRow(i2);
        int[] iArr = this.v;
        int i9 = (i == iArr[iFindRow] || i8 == (iArr[iFindRow + i7] & i5)) ? 0 : 1;
        boolean z = (i6 == iArr[iFindRow2 + 1] || i8 == (iArr[iFindRow2 + i7] & i5)) ? false : true;
        if (i9 != 0 || z) {
            int i10 = z ? i9 + 1 : i9;
            int i11 = this.rows;
            int i12 = i11 + i10;
            int i13 = this.maxRows;
            if (i12 > i13) {
                int i14 = 65536;
                if (i13 >= 65536) {
                    i14 = MAX_ROWS;
                    if (i13 >= 1114114) {
                        og.o("MAX_ROWS exceeded! Increase it to a higher valuein the implementation");
                        return;
                    }
                }
                int i15 = this.columns;
                int[] iArr2 = new int[i14 * i15];
                System.arraycopy(iArr, 0, iArr2, 0, i11 * i15);
                this.v = iArr2;
                this.maxRows = i14;
            }
            int i16 = this.rows;
            int i17 = this.columns;
            int i18 = (i16 * i17) - (iFindRow2 + i17);
            if (i18 > 0) {
                int[] iArr3 = this.v;
                System.arraycopy(iArr3, iFindRow2 + i17, iArr3, ((i10 + 1) * i17) + iFindRow2, i18);
            }
            this.rows += i10;
            if (i9 != 0) {
                int i19 = this.columns;
                int[] iArr4 = this.v;
                System.arraycopy(iArr4, iFindRow, iArr4, i19 + iFindRow, (iFindRow2 - iFindRow) + i19);
                int i20 = this.columns;
                iFindRow2 += i20;
                int[] iArr5 = this.v;
                iArr5[iFindRow + i20] = i;
                iArr5[iFindRow + 1] = i;
                iFindRow += i20;
            }
            if (z) {
                int[] iArr6 = this.v;
                int i21 = this.columns;
                System.arraycopy(iArr6, iFindRow2, iArr6, iFindRow2 + i21, i21);
                int[] iArr7 = this.v;
                iArr7[this.columns + iFindRow2] = i6;
                iArr7[iFindRow2 + 1] = i6;
            }
        }
        this.prevRow = iFindRow2 / this.columns;
        int i22 = iFindRow + i7;
        int i23 = iFindRow2 + i7;
        int i24 = ~i5;
        while (true) {
            int[] iArr8 = this.v;
            iArr8[i22] = (iArr8[i22] & i24) | i8;
            if (i22 == i23) {
                return;
            } else {
                i22 += this.columns;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class DefaultGetFoldingOffset implements Trie.DataManipulate {
        public /* synthetic */ DefaultGetFoldingOffset(int i) {
            this();
        }

        private DefaultGetFoldingOffset() {
        }

        @Override // com.ibm.icu.impl.Trie.DataManipulate
        public int getFoldingOffset(int i) {
            return i;
        }
    }
}
