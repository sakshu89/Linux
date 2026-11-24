package com.ibm.icu.impl;

import com.ibm.icu.impl.locale.LanguageTag;
import com.ibm.icu.impl.number.Padder;
import com.ibm.icu.lang.UCharacterEnums;
import com.ibm.icu.text.RuleBasedBreakIterator;
import com.ibm.icu.util.CodePointTrie;
import defpackage.cq;
import defpackage.dk0;
import defpackage.ky0;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class RBBIDataWrapper {
    public static final int ACCEPTING = 0;
    public static final int ACCEPTING_UNCONDITIONAL = 1;
    public static final int DATA_FORMAT = 1114794784;
    public static final int DH_CATCOUNT = 3;
    public static final int DH_FORMATVERSION = 1;
    public static final int DH_FTABLE = 4;
    public static final int DH_FTABLELEN = 5;
    public static final int DH_LENGTH = 2;
    public static final int DH_MAGIC = 0;
    public static final int DH_RTABLE = 6;
    public static final int DH_RTABLELEN = 7;
    public static final int DH_RULESOURCE = 10;
    public static final int DH_RULESOURCELEN = 11;
    public static final int DH_SIZE = 20;
    public static final int DH_STATUSTABLE = 12;
    public static final int DH_STATUSTABLELEN = 13;
    public static final int DH_TRIE = 8;
    public static final int DH_TRIELEN = 9;
    public static final int FORMAT_VERSION = 117440512;
    private static final IsAcceptable IS_ACCEPTABLE = new IsAcceptable(0);
    public static final int LOOKAHEAD = 1;
    public static final int NEXTSTATES = 3;
    public static final int RBBI_8BITS_ROWS = 4;
    public static final int RBBI_LOOKAHEAD_HARD_BREAK = 1;
    public static final int TAGSIDX = 2;
    public RBBIStateTable fFTable;
    public RBBIDataHeader fHeader;
    public RBBIStateTable fRTable;
    public String fRuleSource;
    public int[] fStatusTable;
    public CodePointTrie fTrie;

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class RBBIDataHeader {
        public int fCatCount;
        int fFTable;
        int fFTableLen;
        int fLength;
        int fRTable;
        int fRTableLen;
        int fRuleSource;
        int fRuleSourceLen;
        int fStatusTable;
        int fStatusTableLen;
        int fTrie;
        int fTrieLen;
        int fMagic = 0;
        byte[] fFormatVersion = new byte[4];
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class RBBIStateTable {
        public static int fHeaderSize = 20;
        public int fDictCategoriesStart;
        public int fFlags;
        public int fLookAheadResultsSize;
        public int fNumStates;
        public int fRowLen;
        public char[] fTable;

        public static RBBIStateTable get(ByteBuffer byteBuffer, int i) throws IOException {
            if (i == 0) {
                return null;
            }
            if (i < fHeaderSize) {
                dk0.h("Invalid RBBI state table length.");
                return null;
            }
            RBBIStateTable rBBIStateTable = new RBBIStateTable();
            rBBIStateTable.fNumStates = byteBuffer.getInt();
            rBBIStateTable.fRowLen = byteBuffer.getInt();
            rBBIStateTable.fDictCategoriesStart = byteBuffer.getInt();
            rBBIStateTable.fLookAheadResultsSize = byteBuffer.getInt();
            int i2 = byteBuffer.getInt();
            rBBIStateTable.fFlags = i2;
            int i3 = i - fHeaderSize;
            if ((i2 & 4) != 4) {
                rBBIStateTable.fTable = ICUBinary.getChars(byteBuffer, i3 / 2, i3 & 1);
                return rBBIStateTable;
            }
            rBBIStateTable.fTable = new char[i3];
            for (int i4 = 0; i4 < i3; i4++) {
                rBBIStateTable.fTable[i4] = (char) (byteBuffer.get() & UCharacterEnums.ECharacterDirection.DIRECTIONALITY_UNDEFINED);
            }
            ICUBinary.skipBytes(byteBuffer, i3 & 1);
            return rBBIStateTable;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof RBBIStateTable)) {
                return false;
            }
            RBBIStateTable rBBIStateTable = (RBBIStateTable) obj;
            if (this.fNumStates == rBBIStateTable.fNumStates && this.fRowLen == rBBIStateTable.fRowLen && this.fDictCategoriesStart == rBBIStateTable.fDictCategoriesStart && this.fLookAheadResultsSize == rBBIStateTable.fLookAheadResultsSize && this.fFlags == rBBIStateTable.fFlags) {
                return Arrays.equals(this.fTable, rBBIStateTable.fTable);
            }
            return false;
        }

        public int hashCode() {
            return Objects.hash(Integer.valueOf(this.fDictCategoriesStart), Integer.valueOf(this.fFlags), Integer.valueOf(this.fLookAheadResultsSize), Integer.valueOf(this.fNumStates), Integer.valueOf(this.fRowLen)) + ((Arrays.hashCode(this.fTable) + 31) * 31);
        }

        public int put(DataOutputStream dataOutputStream) throws IOException {
            dataOutputStream.writeInt(this.fNumStates);
            dataOutputStream.writeInt(this.fRowLen);
            dataOutputStream.writeInt(this.fDictCategoriesStart);
            dataOutputStream.writeInt(this.fLookAheadResultsSize);
            dataOutputStream.writeInt(this.fFlags);
            int i = this.fFlags & 4;
            int i2 = this.fRowLen;
            if (i == 4) {
                int i3 = i2 * this.fNumStates;
                for (int i4 = 0; i4 < i3; i4++) {
                    dataOutputStream.writeByte((byte) (this.fTable[i4] & 255));
                }
            } else {
                int i5 = (i2 * this.fNumStates) / 2;
                for (int i6 = 0; i6 < i5; i6++) {
                    dataOutputStream.writeChar(this.fTable[i6]);
                }
            }
            int i7 = (this.fRowLen * this.fNumStates) + fHeaderSize;
            while (i7 % 8 != 0) {
                dataOutputStream.writeByte(0);
                i7++;
            }
            return i7;
        }
    }

    public static String charToString(char c, int i) {
        StringBuilder sb = new StringBuilder(i);
        sb.append(c);
        while (sb.length() < i) {
            sb.insert(0, ' ');
        }
        return sb.toString();
    }

    private void dumpCharCategories(PrintStream printStream) {
        int i = this.fHeader.fCatCount + 1;
        String[] strArr = new String[i];
        int[] iArr = new int[i];
        for (int i2 = 0; i2 <= this.fHeader.fCatCount; i2++) {
            strArr[i2] = "";
        }
        printStream.println("\nCharacter Categories");
        printStream.println("--------------------");
        int i3 = -1;
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 0; i6 <= 1114111; i6++) {
            int i7 = this.fTrie.get(i6);
            if (i7 < 0 || i7 > this.fHeader.fCatCount) {
                printStream.println("Error, bad category " + Integer.toHexString(i7) + " for char " + Integer.toHexString(i6));
                break;
            }
            if (i7 != i3) {
                if (i3 >= 0) {
                    if (strArr[i3].length() > iArr[i3] + 70) {
                        iArr[i3] = strArr[i3].length() + 10;
                        strArr[i3] = ky0.j(strArr[i3], "\n       ");
                    }
                    String strK = cq.k(strArr[i3], Padder.FALLBACK_PADDING_STRING, Integer.toHexString(i4));
                    strArr[i3] = strK;
                    if (i5 != i4) {
                        strArr[i3] = cq.k(strK, LanguageTag.SEP, Integer.toHexString(i5));
                    }
                }
                i4 = i6;
                i3 = i7;
            }
            i5 = i6;
        }
        String strK2 = cq.k(strArr[i3], Padder.FALLBACK_PADDING_STRING, Integer.toHexString(i4));
        strArr[i3] = strK2;
        if (i5 != i4) {
            strArr[i3] = cq.k(strK2, LanguageTag.SEP, Integer.toHexString(i5));
        }
        for (int i8 = 0; i8 <= this.fHeader.fCatCount; i8++) {
            printStream.println(intToString(i8, 5) + "  " + strArr[i8]);
        }
        printStream.println();
    }

    private void dumpRow(PrintStream printStream, RBBIStateTable rBBIStateTable, char c) {
        StringBuilder sb = new StringBuilder((this.fHeader.fCatCount * 5) + 20);
        sb.append(intToString(c, 4));
        int rowIndex = getRowIndex(c);
        char c2 = rBBIStateTable.fTable[rowIndex];
        if (c2 != 0) {
            sb.append(intToString(c2, 5));
        } else {
            sb.append("     ");
        }
        char c3 = rBBIStateTable.fTable[rowIndex + 1];
        if (c3 != 0) {
            sb.append(intToString(c3, 5));
        } else {
            sb.append("     ");
        }
        sb.append(intToString(rBBIStateTable.fTable[rowIndex + 2], 5));
        for (int i = 0; i < this.fHeader.fCatCount; i++) {
            sb.append(intToString(rBBIStateTable.fTable[rowIndex + 3 + i], 5));
        }
        printStream.println(sb);
    }

    private void dumpTable(PrintStream printStream, RBBIStateTable rBBIStateTable) {
        if (rBBIStateTable == null || rBBIStateTable.fTable.length == 0) {
            printStream.println("  -- null -- ");
            return;
        }
        StringBuilder sb = new StringBuilder(" Row  Acc Look  Tag");
        for (char c = 0; c < this.fHeader.fCatCount; c = (char) (c + 1)) {
            sb.append(intToString(c, 5));
        }
        printStream.println(sb.toString());
        for (char c2 = 0; c2 < sb.length(); c2 = (char) (c2 + 1)) {
            printStream.print(LanguageTag.SEP);
        }
        printStream.println();
        for (char c3 = 0; c3 < rBBIStateTable.fNumStates; c3 = (char) (c3 + 1)) {
            dumpRow(printStream, rBBIStateTable, c3);
        }
        printStream.println();
    }

    public static boolean equals(RBBIStateTable rBBIStateTable, RBBIStateTable rBBIStateTable2) {
        if (rBBIStateTable == rBBIStateTable2) {
            return true;
        }
        if (rBBIStateTable == null || rBBIStateTable2 == null) {
            return false;
        }
        return rBBIStateTable.equals(rBBIStateTable2);
    }

    public static RBBIDataWrapper get(ByteBuffer byteBuffer) {
        RBBIDataWrapper rBBIDataWrapper = new RBBIDataWrapper();
        IsAcceptable isAcceptable = IS_ACCEPTABLE;
        ICUBinary.readHeader(byteBuffer, DATA_FORMAT, isAcceptable);
        RBBIDataHeader rBBIDataHeader = new RBBIDataHeader();
        rBBIDataWrapper.fHeader = rBBIDataHeader;
        rBBIDataHeader.fMagic = byteBuffer.getInt();
        rBBIDataWrapper.fHeader.fFormatVersion[0] = byteBuffer.get();
        rBBIDataWrapper.fHeader.fFormatVersion[1] = byteBuffer.get();
        rBBIDataWrapper.fHeader.fFormatVersion[2] = byteBuffer.get();
        rBBIDataWrapper.fHeader.fFormatVersion[3] = byteBuffer.get();
        rBBIDataWrapper.fHeader.fLength = byteBuffer.getInt();
        rBBIDataWrapper.fHeader.fCatCount = byteBuffer.getInt();
        rBBIDataWrapper.fHeader.fFTable = byteBuffer.getInt();
        rBBIDataWrapper.fHeader.fFTableLen = byteBuffer.getInt();
        rBBIDataWrapper.fHeader.fRTable = byteBuffer.getInt();
        rBBIDataWrapper.fHeader.fRTableLen = byteBuffer.getInt();
        rBBIDataWrapper.fHeader.fTrie = byteBuffer.getInt();
        rBBIDataWrapper.fHeader.fTrieLen = byteBuffer.getInt();
        rBBIDataWrapper.fHeader.fRuleSource = byteBuffer.getInt();
        rBBIDataWrapper.fHeader.fRuleSourceLen = byteBuffer.getInt();
        rBBIDataWrapper.fHeader.fStatusTable = byteBuffer.getInt();
        rBBIDataWrapper.fHeader.fStatusTableLen = byteBuffer.getInt();
        ICUBinary.skipBytes(byteBuffer, 24);
        RBBIDataHeader rBBIDataHeader2 = rBBIDataWrapper.fHeader;
        if (rBBIDataHeader2.fMagic != 45472 || !isAcceptable.isDataVersionAcceptable(rBBIDataHeader2.fFormatVersion)) {
            dk0.h("Break Iterator Rule Data Magic Number Incorrect, or unsupported data version.");
            return null;
        }
        RBBIDataHeader rBBIDataHeader3 = rBBIDataWrapper.fHeader;
        int i = rBBIDataHeader3.fFTable;
        if (i < 80 || i > rBBIDataHeader3.fLength) {
            dk0.h("Break iterator Rule data corrupt");
            return null;
        }
        ICUBinary.skipBytes(byteBuffer, i - 80);
        RBBIDataHeader rBBIDataHeader4 = rBBIDataWrapper.fHeader;
        int i2 = rBBIDataHeader4.fFTable;
        rBBIDataWrapper.fFTable = RBBIStateTable.get(byteBuffer, rBBIDataHeader4.fFTableLen);
        RBBIDataHeader rBBIDataHeader5 = rBBIDataWrapper.fHeader;
        ICUBinary.skipBytes(byteBuffer, rBBIDataHeader5.fRTable - (i2 + rBBIDataHeader5.fFTableLen));
        RBBIDataHeader rBBIDataHeader6 = rBBIDataWrapper.fHeader;
        int i3 = rBBIDataHeader6.fRTable;
        rBBIDataWrapper.fRTable = RBBIStateTable.get(byteBuffer, rBBIDataHeader6.fRTableLen);
        RBBIDataHeader rBBIDataHeader7 = rBBIDataWrapper.fHeader;
        ICUBinary.skipBytes(byteBuffer, rBBIDataHeader7.fTrie - (i3 + rBBIDataHeader7.fRTableLen));
        int i4 = rBBIDataWrapper.fHeader.fTrie;
        rBBIDataWrapper.fTrie = CodePointTrie.fromBinary(CodePointTrie.Type.FAST, null, byteBuffer);
        int i5 = rBBIDataWrapper.fHeader.fStatusTable;
        if (i4 > i5) {
            dk0.h("Break iterator Rule data corrupt");
            return null;
        }
        ICUBinary.skipBytes(byteBuffer, i5 - i4);
        RBBIDataHeader rBBIDataHeader8 = rBBIDataWrapper.fHeader;
        int i6 = rBBIDataHeader8.fStatusTable;
        int i7 = rBBIDataHeader8.fStatusTableLen;
        rBBIDataWrapper.fStatusTable = ICUBinary.getInts(byteBuffer, i7 / 4, i7 & 3);
        RBBIDataHeader rBBIDataHeader9 = rBBIDataWrapper.fHeader;
        int i8 = i6 + rBBIDataHeader9.fStatusTableLen;
        int i9 = rBBIDataHeader9.fRuleSource;
        if (i8 > i9) {
            dk0.h("Break iterator Rule data corrupt");
            return null;
        }
        ICUBinary.skipBytes(byteBuffer, i9 - i8);
        rBBIDataWrapper.fRuleSource = new String(ICUBinary.getBytes(byteBuffer, rBBIDataWrapper.fHeader.fRuleSourceLen, 0), StandardCharsets.UTF_8);
        String str = RuleBasedBreakIterator.fDebugEnv;
        if (str != null && str.indexOf("data") >= 0) {
            rBBIDataWrapper.dump(System.out);
        }
        return rBBIDataWrapper;
    }

    public static String intToHexString(int i, int i2) {
        StringBuilder sb = new StringBuilder(i2);
        sb.append(Integer.toHexString(i));
        while (sb.length() < i2) {
            sb.insert(0, ' ');
        }
        return sb.toString();
    }

    public static String intToString(int i, int i2) {
        StringBuilder sb = new StringBuilder(i2);
        sb.append(i);
        while (sb.length() < i2) {
            sb.insert(0, ' ');
        }
        return sb.toString();
    }

    public void dump(PrintStream printStream) {
        this.fFTable.getClass();
        printStream.println("RBBI Data Wrapper dump ...");
        printStream.println();
        printStream.println("Forward State Table");
        dumpTable(printStream, this.fFTable);
        printStream.println("Reverse State Table");
        dumpTable(printStream, this.fRTable);
        dumpCharCategories(printStream);
        ky0.y("Source Rules: ", this.fRuleSource, printStream);
    }

    public int getRowIndex(int i) {
        return (this.fHeader.fCatCount + 3) * i;
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class IsAcceptable implements ICUBinary.Authenticate {
        public /* synthetic */ IsAcceptable(int i) {
            this();
        }

        @Override // com.ibm.icu.impl.ICUBinary.Authenticate
        public boolean isDataVersionAcceptable(byte[] bArr) {
            return (((bArr[0] << UCharacterEnums.ECharacterCategory.MATH_SYMBOL) + (bArr[1] << 16)) + (bArr[2] << 8)) + bArr[3] == 117440512;
        }

        private IsAcceptable() {
        }
    }
}
