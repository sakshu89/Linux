package com.ibm.icu.impl;

import com.ibm.icu.text.UTF16;
import com.ibm.icu.text.UnicodeSet;
import com.ibm.icu.util.OutputInt;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class UnicodeSetStringSpan {
    public static final int ALL = 127;
    static final short ALL_CP_CONTAINED = 255;
    public static final int BACK = 16;
    public static final int BACK_UTF16_CONTAINED = 18;
    public static final int BACK_UTF16_NOT_CONTAINED = 17;
    public static final int CONTAINED = 2;
    public static final int FWD = 32;
    public static final int FWD_UTF16_CONTAINED = 34;
    public static final int FWD_UTF16_NOT_CONTAINED = 33;
    static final short LONG_SPAN = 254;
    public static final int NOT_CONTAINED = 1;
    public static final int WITH_COUNT = 64;
    private boolean all;
    private final int maxLength16;
    private OffsetList offsets;
    private boolean someRelevant;
    private short[] spanLengths;
    private UnicodeSet spanNotSet;
    private UnicodeSet spanSet;
    private ArrayList<String> strings;

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class OffsetList {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private int length;
        private int[] list = new int[16];
        private int start;

        public void addOffset(int i) {
            int length = this.start + i;
            int[] iArr = this.list;
            if (length >= iArr.length) {
                length -= iArr.length;
            }
            iArr[length] = 1;
            this.length++;
        }

        public void addOffsetAndCount(int i, int i2) {
            int length = this.start + i;
            int[] iArr = this.list;
            if (length >= iArr.length) {
                length -= iArr.length;
            }
            int i3 = iArr[length];
            if (i3 == 0) {
                iArr[length] = i2;
                this.length++;
            } else if (i2 < i3) {
                iArr[length] = i2;
            }
        }

        public void clear() {
            int length = this.list.length;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    this.length = 0;
                    this.start = 0;
                    return;
                } else {
                    this.list[i] = 0;
                    length = i;
                }
            }
        }

        public boolean containsOffset(int i) {
            int length = this.start + i;
            int[] iArr = this.list;
            if (length >= iArr.length) {
                length -= iArr.length;
            }
            return iArr[length] != 0;
        }

        public boolean hasCountAtOffset(int i, int i2) {
            int length = this.start + i;
            int[] iArr = this.list;
            if (length >= iArr.length) {
                length -= iArr.length;
            }
            int i3 = iArr[length];
            return i3 != 0 && i3 <= i2;
        }

        public boolean isEmpty() {
            return this.length == 0;
        }

        public int popMinimum(OutputInt outputInt) {
            int[] iArr;
            int[] iArr2;
            int i;
            int i2;
            int i3 = this.start;
            do {
                i3++;
                iArr = this.list;
                if (i3 >= iArr.length) {
                    int length = iArr.length - this.start;
                    int i4 = 0;
                    while (true) {
                        iArr2 = this.list;
                        i = iArr2[i4];
                        if (i != 0) {
                            break;
                        }
                        i4++;
                    }
                    iArr2[i4] = 0;
                    this.length--;
                    this.start = i4;
                    if (outputInt != null) {
                        outputInt.value = i;
                    }
                    return length + i4;
                }
                i2 = iArr[i3];
            } while (i2 == 0);
            iArr[i3] = 0;
            this.length--;
            int i5 = i3 - this.start;
            this.start = i3;
            if (outputInt != null) {
                outputInt.value = i2;
            }
            return i5;
        }

        public void setMaxLength(int i) {
            if (i > this.list.length) {
                this.list = new int[i];
            }
            clear();
        }

        public void shift(int i) {
            int length = this.start + i;
            int[] iArr = this.list;
            if (length >= iArr.length) {
                length -= iArr.length;
            }
            if (iArr[length] != 0) {
                iArr[length] = 0;
                this.length--;
            }
            this.start = length;
        }
    }

    public UnicodeSetStringSpan(UnicodeSet unicodeSet, ArrayList<String> arrayList, int i) {
        UnicodeSet unicodeSet2 = new UnicodeSet(0, 1114111);
        this.spanSet = unicodeSet2;
        this.strings = arrayList;
        this.all = i == 127;
        unicodeSet2.retainAll(unicodeSet);
        int i2 = i & 1;
        if (i2 != 0) {
            this.spanNotSet = this.spanSet;
        }
        this.offsets = new OffsetList();
        int size = this.strings.size();
        this.someRelevant = false;
        int i3 = 0;
        int i4 = 0;
        while (i3 < size) {
            String str = this.strings.get(i3);
            int length = str.length();
            if (length == 0) {
                this.strings.remove(i3);
                size--;
            } else {
                if (this.spanSet.span(str, UnicodeSet.SpanCondition.CONTAINED) < length) {
                    this.someRelevant = true;
                }
                i4 = length > i4 ? length : i4;
                i3++;
            }
        }
        this.maxLength16 = i4;
        if (this.someRelevant || (i & 64) != 0) {
            if (this.all) {
                this.spanSet.freeze();
            }
            boolean z = this.all;
            this.spanLengths = new short[z ? size * 2 : size];
            int i5 = z ? size : 0;
            for (int i6 = 0; i6 < size; i6++) {
                String str2 = this.strings.get(i6);
                int length2 = str2.length();
                UnicodeSet unicodeSet3 = this.spanSet;
                UnicodeSet.SpanCondition spanCondition = UnicodeSet.SpanCondition.CONTAINED;
                int iSpan = unicodeSet3.span(str2, spanCondition);
                if (iSpan < length2) {
                    if ((i & 2) != 0) {
                        if ((i & 32) != 0) {
                            this.spanLengths[i6] = makeSpanLengthByte(iSpan);
                        }
                        if ((i & 16) != 0) {
                            this.spanLengths[i5 + i6] = makeSpanLengthByte(length2 - this.spanSet.spanBack(str2, length2, spanCondition));
                        }
                    } else {
                        short[] sArr = this.spanLengths;
                        sArr[i5 + i6] = 0;
                        sArr[i6] = 0;
                    }
                    if (i2 != 0) {
                        if ((i & 32) != 0) {
                            addToSpanNotSet(str2.codePointAt(0));
                        }
                        if ((i & 16) != 0) {
                            addToSpanNotSet(str2.codePointBefore(length2));
                        }
                    }
                } else {
                    boolean z2 = this.all;
                    short[] sArr2 = this.spanLengths;
                    if (z2) {
                        sArr2[i5 + i6] = ALL_CP_CONTAINED;
                        sArr2[i6] = ALL_CP_CONTAINED;
                    } else {
                        sArr2[i6] = ALL_CP_CONTAINED;
                    }
                }
            }
            if (this.all) {
                this.spanNotSet.freeze();
            }
        }
    }

    private void addToSpanNotSet(int i) {
        if (Utility.sameObjects(this.spanNotSet, null) || Utility.sameObjects(this.spanNotSet, this.spanSet)) {
            if (this.spanSet.contains(i)) {
                return;
            } else {
                this.spanNotSet = this.spanSet.cloneAsThawed();
            }
        }
        this.spanNotSet.add(i);
    }

    public static short makeSpanLengthByte(int i) {
        return i < 254 ? (short) i : LONG_SPAN;
    }

    private static boolean matches16(CharSequence charSequence, int i, String str, int i2) {
        int i3 = i + i2;
        while (true) {
            int i4 = i2 - 1;
            if (i2 <= 0) {
                return true;
            }
            i3--;
            if (charSequence.charAt(i3) != str.charAt(i4)) {
                return false;
            }
            i2 = i4;
        }
    }

    public static boolean matches16CPB(CharSequence charSequence, int i, int i2, String str, int i3) {
        if (!matches16(charSequence, i, str, i3)) {
            return false;
        }
        if (i > 0 && Character.isHighSurrogate(charSequence.charAt(i - 1)) && Character.isLowSurrogate(charSequence.charAt(i))) {
            return false;
        }
        int i4 = i + i3;
        return (i4 < i2 && Character.isHighSurrogate(charSequence.charAt(i4 + (-1))) && Character.isLowSurrogate(charSequence.charAt(i4))) ? false : true;
    }

    private synchronized int spanContainedAndCount(CharSequence charSequence, int i, OutputInt outputInt) {
        try {
            this.offsets.setMaxLength(this.maxLength16);
            int size = this.strings.size();
            int length = charSequence.length();
            int i2 = length - i;
            int i3 = 0;
            while (i2 != 0) {
                int iSpanOne = spanOne(this.spanSet, charSequence, i, i2);
                if (iSpanOne > 0) {
                    this.offsets.addOffsetAndCount(iSpanOne, i3 + 1);
                }
                for (int i4 = 0; i4 < size; i4++) {
                    String str = this.strings.get(i4);
                    int length2 = str.length();
                    if (length2 <= i2) {
                        int i5 = i3 + 1;
                        if (!this.offsets.hasCountAtOffset(length2, i5) && matches16CPB(charSequence, i, length, str, length2)) {
                            this.offsets.addOffsetAndCount(length2, i5);
                        }
                    }
                }
                if (this.offsets.isEmpty()) {
                    outputInt.value = i3;
                    return i;
                }
                int iPopMinimum = this.offsets.popMinimum(outputInt);
                i += iPopMinimum;
                i2 -= iPopMinimum;
                i3 = outputInt.value;
            }
            outputInt.value = i3;
            return i;
        } catch (Throwable th) {
            throw th;
        }
    }

    private int spanNot(CharSequence charSequence, int i, OutputInt outputInt) {
        int iSpanAndCount;
        int i2;
        int iSpanOne;
        String str;
        int length;
        int length2 = charSequence.length();
        int size = this.strings.size();
        int i3 = 0;
        do {
            UnicodeSet unicodeSet = this.spanNotSet;
            if (outputInt == null) {
                iSpanAndCount = unicodeSet.span(charSequence, i, UnicodeSet.SpanCondition.NOT_CONTAINED);
            } else {
                iSpanAndCount = unicodeSet.spanAndCount(charSequence, i, UnicodeSet.SpanCondition.NOT_CONTAINED, outputInt);
                i3 += outputInt.value;
                outputInt.value = i3;
            }
            if (iSpanAndCount != length2) {
                i2 = length2 - iSpanAndCount;
                iSpanOne = spanOne(this.spanSet, charSequence, iSpanAndCount, i2);
                if (iSpanOne <= 0) {
                    for (int i4 = 0; i4 < size; i4++) {
                        if (this.spanLengths[i4] == 255 || (length = (str = this.strings.get(i4)).length()) > i2 || !matches16CPB(charSequence, iSpanAndCount, length2, str, length)) {
                        }
                    }
                    i = iSpanAndCount - iSpanOne;
                    i3++;
                }
                return iSpanAndCount;
            }
            return length2;
        } while (i2 + iSpanOne != 0);
        if (outputInt != null) {
            outputInt.value = i3;
        }
        return length2;
    }

    private int spanNotBack(CharSequence charSequence, int i) {
        String str;
        int length;
        int size = this.strings.size();
        int i2 = i;
        do {
            int iSpanBack = this.spanNotSet.spanBack(charSequence, i2, UnicodeSet.SpanCondition.NOT_CONTAINED);
            if (iSpanBack == 0) {
                return 0;
            }
            int iSpanOneBack = spanOneBack(this.spanSet, charSequence, iSpanBack);
            if (iSpanOneBack <= 0) {
                for (int i3 = 0; i3 < size; i3++) {
                    if (this.spanLengths[i3] == 255 || (length = (str = this.strings.get(i3)).length()) > iSpanBack || !matches16CPB(charSequence, iSpanBack - length, i, str, length)) {
                    }
                }
                i2 = iSpanBack + iSpanOneBack;
            }
            return iSpanBack;
        } while (i2 != 0);
        return 0;
    }

    public static int spanOne(UnicodeSet unicodeSet, CharSequence charSequence, int i, int i2) {
        char cCharAt = charSequence.charAt(i);
        if (cCharAt >= 55296 && cCharAt <= 56319 && i2 >= 2) {
            char cCharAt2 = charSequence.charAt(i + 1);
            if (UTF16.isTrailSurrogate(cCharAt2)) {
                return unicodeSet.contains(Character.toCodePoint(cCharAt, cCharAt2)) ? 2 : -2;
            }
        }
        return unicodeSet.contains(cCharAt) ? 1 : -1;
    }

    public static int spanOneBack(UnicodeSet unicodeSet, CharSequence charSequence, int i) {
        char cCharAt = charSequence.charAt(i - 1);
        if (cCharAt >= 56320 && cCharAt <= 57343 && i >= 2) {
            char cCharAt2 = charSequence.charAt(i - 2);
            if (UTF16.isLeadSurrogate(cCharAt2)) {
                return unicodeSet.contains(Character.toCodePoint(cCharAt2, cCharAt)) ? 2 : -2;
            }
        }
        return unicodeSet.contains(cCharAt) ? 1 : -1;
    }

    private synchronized int spanWithStrings(CharSequence charSequence, int i, int i2, UnicodeSet.SpanCondition spanCondition) {
        try {
            this.offsets.setMaxLength(spanCondition == UnicodeSet.SpanCondition.CONTAINED ? this.maxLength16 : 0);
            int length = charSequence.length();
            int size = this.strings.size();
            int i3 = i2 - i;
            int i4 = length - i2;
            int i5 = i2;
            while (true) {
                UnicodeSet.SpanCondition spanCondition2 = UnicodeSet.SpanCondition.CONTAINED;
                short s = LONG_SPAN;
                if (spanCondition == spanCondition2) {
                    for (int i6 = 0; i6 < size; i6++) {
                        short s2 = this.spanLengths[i6];
                        if (s2 != 255) {
                            String str = this.strings.get(i6);
                            int length2 = str.length();
                            int iOffsetByCodePoints = s2;
                            if (s2 >= 254) {
                                iOffsetByCodePoints = str.offsetByCodePoints(length2, -1);
                            }
                            if (iOffsetByCodePoints > i3) {
                                iOffsetByCodePoints = i3;
                            }
                            int i7 = length2 - iOffsetByCodePoints;
                            int i8 = iOffsetByCodePoints;
                            while (i7 <= i4) {
                                if (!this.offsets.containsOffset(i7) && matches16CPB(charSequence, i5 - i8, length, str, length2)) {
                                    if (i7 == i4) {
                                        return length;
                                    }
                                    this.offsets.addOffset(i7);
                                }
                                if (i8 == 0) {
                                    break;
                                }
                                i7++;
                                i8--;
                            }
                        }
                    }
                } else {
                    int i9 = 0;
                    int i10 = 0;
                    int i11 = 0;
                    while (i9 < size) {
                        short s3 = this.spanLengths[i9];
                        String str2 = this.strings.get(i9);
                        int length3 = str2.length();
                        int i12 = s3;
                        if (s3 >= s) {
                            i12 = length3;
                        }
                        if (i12 > i3) {
                            i12 = i3;
                        }
                        int i13 = length3 - i12;
                        for (int i14 = i12; i13 <= i4 && i14 >= i11; i14--) {
                            if ((i14 > i11 || i13 > i10) && matches16CPB(charSequence, i5 - i14, length, str2, length3)) {
                                i10 = i13;
                                i11 = i14;
                                break;
                            }
                            i13++;
                        }
                        i9++;
                        s = LONG_SPAN;
                        i11 = i11;
                    }
                    if (i10 != 0 || i11 != 0) {
                        i5 += i10;
                        i4 -= i10;
                        if (i4 == 0) {
                            return length;
                        }
                    }
                    i3 = 0;
                }
                if (i3 == 0 && i5 != 0) {
                    boolean zIsEmpty = this.offsets.isEmpty();
                    UnicodeSet unicodeSet = this.spanSet;
                    if (zIsEmpty) {
                        int iSpan = unicodeSet.span(charSequence, i5, UnicodeSet.SpanCondition.CONTAINED);
                        i3 = iSpan - i5;
                        if (i3 == i4 || i3 == 0) {
                            return iSpan;
                        }
                        i5 += i3;
                        i4 -= i3;
                    } else {
                        int iSpanOne = spanOne(unicodeSet, charSequence, i5, i4);
                        if (iSpanOne > 0) {
                            if (iSpanOne == i4) {
                                return length;
                            }
                            i5 += iSpanOne;
                            i4 -= iSpanOne;
                            this.offsets.shift(iSpanOne);
                        }
                        i3 = 0;
                    }
                } else if (this.offsets.isEmpty()) {
                    return i5;
                }
                int iPopMinimum = this.offsets.popMinimum(null);
                i5 += iPopMinimum;
                i4 -= iPopMinimum;
                i3 = 0;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public boolean contains(int i) {
        return this.spanSet.contains(i);
    }

    public boolean needsStringSpanUTF16() {
        return this.someRelevant;
    }

    public int span(CharSequence charSequence, int i, UnicodeSet.SpanCondition spanCondition) {
        if (spanCondition == UnicodeSet.SpanCondition.NOT_CONTAINED) {
            return spanNot(charSequence, i, null);
        }
        int iSpan = this.spanSet.span(charSequence, i, UnicodeSet.SpanCondition.CONTAINED);
        return iSpan == charSequence.length() ? iSpan : spanWithStrings(charSequence, i, iSpan, spanCondition);
    }

    /*  JADX ERROR: JadxOverflowException in pass: LoopRegionVisitor
        jadx.core.utils.exceptions.JadxOverflowException: LoopRegionVisitor.assignOnlyInLoop endless recursion
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public int spanAndCount(java.lang.CharSequence r9, int r10, com.ibm.icu.text.UnicodeSet.SpanCondition r11, com.ibm.icu.util.OutputInt r12) {
        /*
            r8 = this;
            com.ibm.icu.text.UnicodeSet$SpanCondition r0 = com.ibm.icu.text.UnicodeSet.SpanCondition.NOT_CONTAINED
            if (r11 != r0) goto L9
            int r8 = r8.spanNot(r9, r10, r12)
            return r8
        L9:
            com.ibm.icu.text.UnicodeSet$SpanCondition r0 = com.ibm.icu.text.UnicodeSet.SpanCondition.CONTAINED
            if (r11 != r0) goto L12
            int r8 = r8.spanContainedAndCount(r9, r10, r12)
            return r8
        L12:
            java.util.ArrayList<java.lang.String> r11 = r8.strings
            int r11 = r11.size()
            int r0 = r9.length()
            int r1 = r0 - r10
            r2 = 0
            r3 = r2
        L20:
            if (r1 == 0) goto L53
            com.ibm.icu.text.UnicodeSet r4 = r8.spanSet
            int r4 = spanOne(r4, r9, r10, r1)
            if (r4 <= 0) goto L2b
            goto L2c
        L2b:
            r4 = r2
        L2c:
            r5 = r2
        L2d:
            if (r5 >= r11) goto L49
            java.util.ArrayList<java.lang.String> r6 = r8.strings
            java.lang.Object r6 = r6.get(r5)
            java.lang.String r6 = (java.lang.String) r6
            int r7 = r6.length()
            if (r4 >= r7) goto L46
            if (r7 > r1) goto L46
            boolean r6 = matches16CPB(r9, r10, r0, r6, r7)
            if (r6 == 0) goto L46
            r4 = r7
        L46:
            int r5 = r5 + 1
            goto L2d
        L49:
            if (r4 != 0) goto L4e
            r12.value = r3
            return r10
        L4e:
            int r3 = r3 + 1
            int r10 = r10 + r4
            int r1 = r1 - r4
            goto L20
        L53:
            r12.value = r3
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ibm.icu.impl.UnicodeSetStringSpan.spanAndCount(java.lang.CharSequence, int, com.ibm.icu.text.UnicodeSet$SpanCondition, com.ibm.icu.util.OutputInt):int");
    }

    public synchronized int spanBack(CharSequence charSequence, int i, UnicodeSet.SpanCondition spanCondition) {
        int i2;
        if (spanCondition == UnicodeSet.SpanCondition.NOT_CONTAINED) {
            return spanNotBack(charSequence, i);
        }
        UnicodeSet unicodeSet = this.spanSet;
        UnicodeSet.SpanCondition spanCondition2 = UnicodeSet.SpanCondition.CONTAINED;
        int iSpanBack = unicodeSet.spanBack(charSequence, i, spanCondition2);
        int i3 = 0;
        if (iSpanBack == 0) {
            return 0;
        }
        int i4 = i - iSpanBack;
        this.offsets.setMaxLength(spanCondition == spanCondition2 ? this.maxLength16 : 0);
        int size = this.strings.size();
        int i5 = this.all ? size : 0;
        while (true) {
            UnicodeSet.SpanCondition spanCondition3 = UnicodeSet.SpanCondition.CONTAINED;
            short s = LONG_SPAN;
            if (spanCondition == spanCondition3) {
                for (int i6 = i3; i6 < size; i6++) {
                    short s2 = this.spanLengths[i5 + i6];
                    if (s2 != 255) {
                        String str = this.strings.get(i6);
                        int length = str.length();
                        int iOffsetByCodePoints = s2;
                        if (s2 >= 254) {
                            iOffsetByCodePoints = length - str.offsetByCodePoints(i3, 1);
                        }
                        if (iOffsetByCodePoints > i4) {
                            iOffsetByCodePoints = i4;
                        }
                        int i7 = length - iOffsetByCodePoints;
                        int i8 = iOffsetByCodePoints;
                        while (i7 <= iSpanBack) {
                            if (!this.offsets.containsOffset(i7) && matches16CPB(charSequence, iSpanBack - i7, i, str, length)) {
                                if (i7 == iSpanBack) {
                                    return i3;
                                }
                                this.offsets.addOffset(i7);
                            }
                            if (i8 == 0) {
                                break;
                            }
                            i7++;
                            i8--;
                        }
                    }
                }
                i2 = i3;
            } else {
                int i9 = i3;
                int i10 = i9;
                int i11 = i10;
                while (i9 < size) {
                    short s3 = this.spanLengths[i5 + i9];
                    String str2 = this.strings.get(i9);
                    int length2 = str2.length();
                    int i12 = s3;
                    if (s3 >= s) {
                        i12 = length2;
                    }
                    if (i12 > i4) {
                        i12 = i4;
                    }
                    int i13 = i3;
                    int i14 = length2 - i12;
                    for (int i15 = i12; i14 <= iSpanBack && i15 >= i11; i15--) {
                        if ((i15 > i11 || i14 > i10) && matches16CPB(charSequence, iSpanBack - i14, i, str2, length2)) {
                            i10 = i14;
                            i11 = i15;
                            break;
                        }
                        i14++;
                    }
                    i9++;
                    i3 = i13;
                    s = LONG_SPAN;
                    i11 = i11;
                }
                i2 = i3;
                if (i10 != 0 || i11 != 0) {
                    iSpanBack -= i10;
                    if (iSpanBack == 0) {
                        return i2;
                    }
                }
                i3 = i2;
                i4 = i3;
            }
            if (i4 == 0 && iSpanBack != i) {
                boolean zIsEmpty = this.offsets.isEmpty();
                UnicodeSet unicodeSet2 = this.spanSet;
                if (zIsEmpty) {
                    int iSpanBack2 = unicodeSet2.spanBack(charSequence, iSpanBack, UnicodeSet.SpanCondition.CONTAINED);
                    i4 = iSpanBack - iSpanBack2;
                    if (iSpanBack2 == 0 || i4 == 0) {
                        return iSpanBack2;
                    }
                    iSpanBack = iSpanBack2;
                    i3 = i2;
                } else {
                    int iSpanOneBack = spanOneBack(unicodeSet2, charSequence, iSpanBack);
                    if (iSpanOneBack > 0) {
                        if (iSpanOneBack == iSpanBack) {
                            return i2;
                        }
                        iSpanBack -= iSpanOneBack;
                        this.offsets.shift(iSpanOneBack);
                    }
                    i3 = i2;
                    i4 = i3;
                }
            } else if (this.offsets.isEmpty()) {
                return iSpanBack;
            }
            iSpanBack -= this.offsets.popMinimum(null);
            i3 = i2;
            i4 = i3;
        }
    }

    public UnicodeSetStringSpan(UnicodeSetStringSpan unicodeSetStringSpan, ArrayList<String> arrayList) {
        this.spanSet = unicodeSetStringSpan.spanSet;
        this.strings = arrayList;
        this.maxLength16 = unicodeSetStringSpan.maxLength16;
        this.someRelevant = unicodeSetStringSpan.someRelevant;
        this.all = true;
        if (Utility.sameObjects(unicodeSetStringSpan.spanNotSet, unicodeSetStringSpan.spanSet)) {
            this.spanNotSet = this.spanSet;
        } else {
            this.spanNotSet = unicodeSetStringSpan.spanNotSet.m20clone();
        }
        this.offsets = new OffsetList();
        this.spanLengths = (short[]) unicodeSetStringSpan.spanLengths.clone();
    }
}
