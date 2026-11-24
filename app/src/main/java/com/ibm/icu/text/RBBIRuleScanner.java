package com.ibm.icu.text;

import com.ibm.icu.impl.Assert;
import com.ibm.icu.impl.Utility;
import com.ibm.icu.lang.UCharacter;
import defpackage.cq;
import java.text.ParsePosition;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
class RBBIRuleScanner {
    static final int chLS = 8232;
    static final int chNEL = 133;
    private static String gRuleSet_digit_char_pattern = "[0-9]";
    private static String gRuleSet_name_char_pattern = "[_\\p{L}\\p{N}]";
    private static String gRuleSet_name_start_char_pattern = "[_\\p{L}]";
    private static String gRuleSet_rule_char_pattern = "[^[\\p{Z}\\u0020-\\u007f]-[\\p{L}]-[\\p{N}]]";
    private static String gRuleSet_white_space_pattern = "[\\p{Pattern_White_Space}]";
    private static String kAny = "any";
    private static final int kStackSize = 100;
    int fCharNum;
    int fLastChar;
    boolean fLookAheadRule;
    int fNextIndex;
    boolean fNoChainInRule;
    int fNodeStackPtr;
    int fOptionStart;
    boolean fQuoteMode;
    RBBIRuleBuilder fRB;
    boolean fReverseRule;
    int fRuleNum;
    UnicodeSet[] fRuleSets;
    int fScanIndex;
    int fStackPtr;
    RBBISymbolTable fSymbolTable;
    SymbolTable fXSymbolTable;
    RBBIRuleChar fC = new RBBIRuleChar();
    short[] fStack = new short[100];
    RBBINode[] fNodeStack = new RBBINode[100];
    HashMap<String, RBBISetTableEl> fSetTable = new HashMap<>();
    int fLineNum = 1;

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class RBBIRuleChar {
        int fChar;
        boolean fEscaped;
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class RBBISetTableEl {
        String key;
        RBBINode val;
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class RBBIXSymbolTable extends UnicodeSet.XSymbolTable {
        private UnicodeSet.XSymbolTable propertyTable;
        private RBBISymbolTable variableTable;

        public RBBIXSymbolTable(RBBISymbolTable rBBISymbolTable, UnicodeSet.XSymbolTable xSymbolTable) {
            this.variableTable = rBBISymbolTable;
            this.propertyTable = xSymbolTable;
        }

        @Override // com.ibm.icu.text.UnicodeSet.XSymbolTable
        public boolean applyPropertyAlias(String str, String str2, UnicodeSet unicodeSet) {
            return this.propertyTable.applyPropertyAlias(str, str2, unicodeSet);
        }

        @Override // com.ibm.icu.text.UnicodeSet.XSymbolTable, com.ibm.icu.text.SymbolTable
        public char[] lookup(String str) {
            return this.variableTable.lookup(str);
        }

        @Override // com.ibm.icu.text.SymbolTable
        public UnicodeSet lookupSet(String str) {
            return this.variableTable.lookupSet(str);
        }

        @Override // com.ibm.icu.text.UnicodeSet.XSymbolTable, com.ibm.icu.text.SymbolTable
        public String parseReference(String str, ParsePosition parsePosition, int i) {
            return this.variableTable.parseReference(str, parsePosition, i);
        }
    }

    public RBBIRuleScanner(RBBIRuleBuilder rBBIRuleBuilder, UnicodeSet.XSymbolTable xSymbolTable) {
        UnicodeSet[] unicodeSetArr = new UnicodeSet[10];
        this.fRuleSets = unicodeSetArr;
        this.fRB = rBBIRuleBuilder;
        unicodeSetArr[3] = new UnicodeSet(gRuleSet_rule_char_pattern);
        this.fRuleSets[4] = new UnicodeSet(gRuleSet_white_space_pattern);
        this.fRuleSets[1] = new UnicodeSet(gRuleSet_name_char_pattern);
        this.fRuleSets[2] = new UnicodeSet(gRuleSet_name_start_char_pattern);
        this.fRuleSets[0] = new UnicodeSet(gRuleSet_digit_char_pattern);
        RBBISymbolTable rBBISymbolTable = new RBBISymbolTable(this);
        this.fSymbolTable = rBBISymbolTable;
        if (xSymbolTable != null) {
            this.fXSymbolTable = new RBBIXSymbolTable(rBBISymbolTable, xSymbolTable);
        } else {
            this.fXSymbolTable = rBBISymbolTable;
        }
    }

    public static String stripRules(String str) {
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        int iOffsetByCodePoints = 0;
        while (iOffsetByCodePoints < length) {
            int iCodePointAt = str.codePointAt(iOffsetByCodePoints);
            if (!UCharacter.hasBinaryProperty(iCodePointAt, 43)) {
                sb.appendCodePoint(iCodePointAt);
            }
            iOffsetByCodePoints = str.offsetByCodePoints(iOffsetByCodePoints, 1);
        }
        return sb.toString();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public boolean doParseActions(int i) {
        switch (i) {
            case 1:
                if (this.fNodeStack[this.fNodeStackPtr].fLeftChild == null) {
                    error(66058);
                    return false;
                }
                return true;
            case 2:
                RBBINode rBBINodePushNewNode = pushNewNode(0);
                findSetFor(kAny, rBBINodePushNewNode, null);
                int i2 = this.fScanIndex;
                rBBINodePushNewNode.fFirstPos = i2;
                int i3 = this.fNextIndex;
                rBBINodePushNewNode.fLastPos = i3;
                rBBINodePushNewNode.fText = this.fRB.fRules.substring(i2, i3);
                return true;
            case 3:
                fixOpStack(1);
                RBBINode[] rBBINodeArr = this.fNodeStack;
                int i4 = this.fNodeStackPtr;
                RBBINode rBBINode = rBBINodeArr[i4 - 2];
                RBBINode rBBINode2 = rBBINodeArr[i4 - 1];
                RBBINode rBBINode3 = rBBINodeArr[i4];
                int i5 = rBBINode.fFirstPos;
                rBBINode3.fFirstPos = i5;
                int i6 = this.fScanIndex;
                rBBINode3.fLastPos = i6;
                rBBINode3.fText = this.fRB.fRules.substring(i5, i6);
                rBBINode2.fLeftChild = rBBINode3;
                rBBINode3.fParent = rBBINode2;
                this.fSymbolTable.addEntry(rBBINode2.fText, rBBINode2);
                this.fNodeStackPtr -= 3;
                return true;
            case 4:
                fixOpStack(1);
                String str = this.fRB.fDebugEnv;
                if (str != null && str.indexOf("rtree") >= 0) {
                    printNodeStack("end of rule");
                }
                Assert.assrt(this.fNodeStackPtr == 1);
                RBBINode rBBINode4 = this.fNodeStack[this.fNodeStackPtr];
                if (this.fLookAheadRule) {
                    RBBINode rBBINodePushNewNode2 = pushNewNode(6);
                    RBBINode rBBINodePushNewNode3 = pushNewNode(8);
                    int i7 = this.fNodeStackPtr - 2;
                    this.fNodeStackPtr = i7;
                    rBBINodePushNewNode3.fLeftChild = rBBINode4;
                    rBBINodePushNewNode3.fRightChild = rBBINodePushNewNode2;
                    this.fNodeStack[i7] = rBBINodePushNewNode3;
                    rBBINodePushNewNode2.fVal = this.fRuleNum;
                    rBBINodePushNewNode2.fLookAheadEnd = true;
                    rBBINode4 = rBBINodePushNewNode3;
                }
                rBBINode4.fRuleRoot = true;
                RBBIRuleBuilder rBBIRuleBuilder = this.fRB;
                if (rBBIRuleBuilder.fChainRules && !this.fNoChainInRule) {
                    rBBINode4.fChainIn = true;
                }
                int i8 = this.fReverseRule ? 3 : rBBIRuleBuilder.fDefaultTree;
                RBBINode[] rBBINodeArr2 = rBBIRuleBuilder.fTreeRoots;
                RBBINode rBBINode5 = rBBINodeArr2[i8];
                RBBINode[] rBBINodeArr3 = this.fNodeStack;
                if (rBBINode5 != null) {
                    RBBINode rBBINode6 = rBBINodeArr3[this.fNodeStackPtr];
                    RBBINode rBBINodePushNewNode4 = pushNewNode(9);
                    rBBINodePushNewNode4.fLeftChild = rBBINode5;
                    rBBINode5.fParent = rBBINodePushNewNode4;
                    rBBINodePushNewNode4.fRightChild = rBBINode6;
                    rBBINode6.fParent = rBBINodePushNewNode4;
                    this.fRB.fTreeRoots[i8] = rBBINodePushNewNode4;
                } else {
                    rBBINodeArr2[i8] = rBBINodeArr3[this.fNodeStackPtr];
                }
                this.fReverseRule = false;
                this.fLookAheadRule = false;
                this.fNoChainInRule = false;
                this.fNodeStackPtr = 0;
                return true;
            case 5:
                RBBINode rBBINode7 = this.fNodeStack[this.fNodeStackPtr];
                if (rBBINode7 == null || rBBINode7.fType != 2) {
                    error(66049);
                    return true;
                }
                int i9 = this.fScanIndex;
                rBBINode7.fLastPos = i9;
                String strSubstring = this.fRB.fRules.substring(rBBINode7.fFirstPos + 1, i9);
                rBBINode7.fText = strSubstring;
                rBBINode7.fLeftChild = this.fSymbolTable.lookupNode(strSubstring);
                return true;
            case 6:
                return false;
            case 7:
                fixOpStack(4);
                RBBINode[] rBBINodeArr4 = this.fNodeStack;
                int i10 = this.fNodeStackPtr;
                this.fNodeStackPtr = i10 - 1;
                RBBINode rBBINode8 = rBBINodeArr4[i10];
                RBBINode rBBINodePushNewNode5 = pushNewNode(8);
                rBBINodePushNewNode5.fLeftChild = rBBINode8;
                rBBINode8.fParent = rBBINodePushNewNode5;
                return true;
            case 8:
            case 13:
                return true;
            case 9:
                fixOpStack(4);
                RBBINode[] rBBINodeArr5 = this.fNodeStack;
                int i11 = this.fNodeStackPtr;
                this.fNodeStackPtr = i11 - 1;
                RBBINode rBBINode9 = rBBINodeArr5[i11];
                RBBINode rBBINodePushNewNode6 = pushNewNode(9);
                rBBINodePushNewNode6.fLeftChild = rBBINode9;
                rBBINode9.fParent = rBBINodePushNewNode6;
                return true;
            case 10:
                fixOpStack(2);
                return true;
            case 11:
                pushNewNode(7);
                this.fRuleNum++;
                return true;
            case 12:
                pushNewNode(15);
                return true;
            case 14:
                this.fNoChainInRule = true;
                return true;
            case 15:
                String strSubstring2 = this.fRB.fRules.substring(this.fOptionStart, this.fScanIndex);
                if (strSubstring2.equals("chain")) {
                    this.fRB.fChainRules = true;
                    return true;
                }
                if (strSubstring2.equals("forward")) {
                    this.fRB.fDefaultTree = 0;
                    return true;
                }
                if (strSubstring2.equals("reverse")) {
                    this.fRB.fDefaultTree = 1;
                    return true;
                }
                if (strSubstring2.equals("safe_forward")) {
                    this.fRB.fDefaultTree = 2;
                    return true;
                }
                if (strSubstring2.equals("safe_reverse")) {
                    this.fRB.fDefaultTree = 3;
                    return true;
                }
                if (strSubstring2.equals("lookAheadHardBreak")) {
                    this.fRB.fLookAheadHardBreak = true;
                    return true;
                }
                if (strSubstring2.equals("quoted_literals_only")) {
                    this.fRuleSets[3].clear();
                    return true;
                }
                if (strSubstring2.equals("unquoted_literals")) {
                    this.fRuleSets[3].applyPattern(gRuleSet_rule_char_pattern);
                    return true;
                }
                error(66061);
                return true;
            case 16:
                this.fOptionStart = this.fScanIndex;
                return true;
            case 17:
                this.fReverseRule = true;
                return true;
            case 18:
                RBBINode rBBINodePushNewNode7 = pushNewNode(0);
                findSetFor(String.valueOf((char) this.fC.fChar), rBBINodePushNewNode7, null);
                int i12 = this.fScanIndex;
                rBBINodePushNewNode7.fFirstPos = i12;
                int i13 = this.fNextIndex;
                rBBINodePushNewNode7.fLastPos = i13;
                rBBINodePushNewNode7.fText = this.fRB.fRules.substring(i12, i13);
                return true;
            case 19:
                error(66052);
                return false;
            case 20:
                error(66054);
                return false;
            case 21:
                scanSet();
                return true;
            case 22:
                RBBINode rBBINodePushNewNode8 = pushNewNode(4);
                rBBINodePushNewNode8.fVal = this.fRuleNum;
                int i14 = this.fScanIndex;
                rBBINodePushNewNode8.fFirstPos = i14;
                int i15 = this.fNextIndex;
                rBBINodePushNewNode8.fLastPos = i15;
                rBBINodePushNewNode8.fText = this.fRB.fRules.substring(i14, i15);
                this.fLookAheadRule = true;
                return true;
            case 23:
                this.fNodeStack[this.fNodeStackPtr - 1].fFirstPos = this.fNextIndex;
                pushNewNode(7);
                return true;
            case 24:
                RBBINode rBBINodePushNewNode9 = pushNewNode(5);
                rBBINodePushNewNode9.fVal = 0;
                rBBINodePushNewNode9.fFirstPos = this.fScanIndex;
                rBBINodePushNewNode9.fLastPos = this.fNextIndex;
                return true;
            case 25:
                pushNewNode(2).fFirstPos = this.fScanIndex;
                return true;
            case 26:
                RBBINode rBBINode10 = this.fNodeStack[this.fNodeStackPtr];
                long jDigit = (((long) rBBINode10.fVal) * 10) + ((long) UCharacter.digit((char) this.fC.fChar, 10));
                if (jDigit > 2147483647L) {
                    error(66052);
                }
                rBBINode10.fVal = (int) jDigit;
                return true;
            case 27:
                error(66062);
                return false;
            case 28:
                RBBINode rBBINode11 = this.fNodeStack[this.fNodeStackPtr];
                int i16 = this.fNextIndex;
                rBBINode11.fLastPos = i16;
                rBBINode11.fText = this.fRB.fRules.substring(rBBINode11.fFirstPos, i16);
                return true;
            case 29:
                RBBINode[] rBBINodeArr6 = this.fNodeStack;
                int i17 = this.fNodeStackPtr;
                this.fNodeStackPtr = i17 - 1;
                RBBINode rBBINode12 = rBBINodeArr6[i17];
                RBBINode rBBINodePushNewNode10 = pushNewNode(11);
                rBBINodePushNewNode10.fLeftChild = rBBINode12;
                rBBINode12.fParent = rBBINodePushNewNode10;
                return true;
            case 30:
                RBBINode[] rBBINodeArr7 = this.fNodeStack;
                int i18 = this.fNodeStackPtr;
                this.fNodeStackPtr = i18 - 1;
                RBBINode rBBINode13 = rBBINodeArr7[i18];
                RBBINode rBBINodePushNewNode11 = pushNewNode(12);
                rBBINodePushNewNode11.fLeftChild = rBBINode13;
                rBBINode13.fParent = rBBINodePushNewNode11;
                return true;
            case 31:
                RBBINode[] rBBINodeArr8 = this.fNodeStack;
                int i19 = this.fNodeStackPtr;
                this.fNodeStackPtr = i19 - 1;
                RBBINode rBBINode14 = rBBINodeArr8[i19];
                RBBINode rBBINodePushNewNode12 = pushNewNode(10);
                rBBINodePushNewNode12.fLeftChild = rBBINode14;
                rBBINode14.fParent = rBBINodePushNewNode12;
                return true;
            case 32:
                error(66052);
                return true;
            default:
                error(66049);
                return false;
        }
    }

    public void error(int i) {
        int i2 = this.fLineNum;
        int i3 = this.fCharNum;
        StringBuilder sbP = cq.p("Error ", i, " at line ", i2, " column ");
        sbP.append(i3);
        throw new IllegalArgumentException(sbP.toString());
    }

    public void findSetFor(String str, RBBINode rBBINode, UnicodeSet unicodeSet) {
        RBBISetTableEl rBBISetTableEl = this.fSetTable.get(str);
        if (rBBISetTableEl != null) {
            RBBINode rBBINode2 = rBBISetTableEl.val;
            rBBINode.fLeftChild = rBBINode2;
            Assert.assrt(rBBINode2.fType == 1);
            return;
        }
        if (unicodeSet == null) {
            if (str.equals(kAny)) {
                unicodeSet = new UnicodeSet(0, 1114111);
            } else {
                int iCharAt = UTF16.charAt(str, 0);
                unicodeSet = new UnicodeSet(iCharAt, iCharAt);
            }
        }
        RBBINode rBBINode3 = new RBBINode(1);
        rBBINode3.fInputSet = unicodeSet;
        rBBINode3.fParent = rBBINode;
        rBBINode.fLeftChild = rBBINode3;
        rBBINode3.fText = str;
        this.fRB.fUSetNodes.add(rBBINode3);
        RBBISetTableEl rBBISetTableEl2 = new RBBISetTableEl();
        rBBISetTableEl2.key = str;
        rBBISetTableEl2.val = rBBINode3;
        this.fSetTable.put(str, rBBISetTableEl2);
    }

    public void fixOpStack(int i) {
        while (true) {
            RBBINode[] rBBINodeArr = this.fNodeStack;
            int i2 = this.fNodeStackPtr;
            RBBINode rBBINode = rBBINodeArr[i2 - 1];
            int i3 = rBBINode.fPrecedence;
            if (i3 == 0) {
                System.out.print("RBBIRuleScanner.fixOpStack, bad operator node");
                error(66049);
                return;
            }
            if (i3 < i || i3 <= 2) {
                if (i <= 2) {
                    if (i3 != i) {
                        error(66056);
                    }
                    RBBINode[] rBBINodeArr2 = this.fNodeStack;
                    int i4 = this.fNodeStackPtr;
                    rBBINodeArr2[i4 - 1] = rBBINodeArr2[i4];
                    this.fNodeStackPtr = i4 - 1;
                    return;
                }
                return;
            }
            RBBINode rBBINode2 = rBBINodeArr[i2];
            rBBINode.fRightChild = rBBINode2;
            rBBINode2.fParent = rBBINode;
            this.fNodeStackPtr = i2 - 1;
        }
    }

    public void nextChar(RBBIRuleChar rBBIRuleChar) {
        int iNextCharLL;
        this.fScanIndex = this.fNextIndex;
        int iNextCharLL2 = nextCharLL();
        rBBIRuleChar.fChar = iNextCharLL2;
        rBBIRuleChar.fEscaped = false;
        if (iNextCharLL2 == 39) {
            if (this.fNextIndex >= this.fRB.fRules.length() || UTF16.charAt(this.fRB.fRules, this.fNextIndex) != 39) {
                boolean z = !this.fQuoteMode;
                this.fQuoteMode = z;
                if (z) {
                    rBBIRuleChar.fChar = 40;
                } else {
                    rBBIRuleChar.fChar = 41;
                }
                rBBIRuleChar.fEscaped = false;
                return;
            }
            rBBIRuleChar.fChar = nextCharLL();
            rBBIRuleChar.fEscaped = true;
        }
        int i = rBBIRuleChar.fChar;
        if (i == -1) {
            return;
        }
        if (this.fQuoteMode) {
            rBBIRuleChar.fEscaped = true;
            return;
        }
        if (i == 35) {
            do {
                iNextCharLL = nextCharLL();
                rBBIRuleChar.fChar = iNextCharLL;
                if (iNextCharLL == -1 || iNextCharLL == 13 || iNextCharLL == 10 || iNextCharLL == 133) {
                    break;
                }
            } while (iNextCharLL != chLS);
            for (int i2 = this.fScanIndex; i2 < this.fNextIndex - 1; i2++) {
                this.fRB.fStrippedRules.setCharAt(i2, ' ');
            }
        }
        int i3 = rBBIRuleChar.fChar;
        if (i3 != -1 && i3 == 92) {
            rBBIRuleChar.fEscaped = true;
            int iUnescapeAndLengthAt = Utility.unescapeAndLengthAt(this.fRB.fRules, this.fNextIndex);
            if (iUnescapeAndLengthAt < 0) {
                error(66050);
            }
            rBBIRuleChar.fChar = Utility.cpFromCodePointAndLength(iUnescapeAndLengthAt);
            int iLengthFromCodePointAndLength = Utility.lengthFromCodePointAndLength(iUnescapeAndLengthAt);
            this.fCharNum += iLengthFromCodePointAndLength;
            this.fNextIndex += iLengthFromCodePointAndLength;
        }
    }

    public int nextCharLL() {
        if (this.fNextIndex >= this.fRB.fRules.length()) {
            return -1;
        }
        int iCharAt = UTF16.charAt(this.fRB.fRules, this.fNextIndex);
        if (Character.isBmpCodePoint(iCharAt) && Character.isSurrogate((char) iCharAt)) {
            error(12);
        }
        this.fNextIndex = UTF16.moveCodePointOffset(this.fRB.fRules, this.fNextIndex, 1);
        if (iCharAt == 13 || iCharAt == 133 || iCharAt == chLS || (iCharAt == 10 && this.fLastChar != 13)) {
            this.fLineNum++;
            this.fCharNum = 0;
            if (this.fQuoteMode) {
                error(66057);
                this.fQuoteMode = false;
            }
        } else if (iCharAt != 10) {
            this.fCharNum++;
        }
        this.fLastChar = iCharAt;
        return iCharAt;
    }

    public int numRules() {
        return this.fRuleNum;
    }

    /* JADX WARN: Code duplicated, block: B:113:0x01b2 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:22:0x007d  */
    /* JADX WARN: Code duplicated, block: B:31:0x008f  */
    /* JADX WARN: Code duplicated, block: B:38:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:40:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:43:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:45:0x00b0  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v28, types: [int] */
    /* JADX WARN: Type inference failed for: r1v29, types: [int] */
    /* JADX WARN: Type inference failed for: r1v36, types: [short] */
    /* JADX WARN: Type inference failed for: r1v37 */
    /* JADX WARN: Type inference failed for: r1v39, types: [short] */
    public void parse() {
        RBBIRuleParseTable.RBBIRuleTableElement rBBIRuleTableElement;
        int i;
        RBBIRuleChar rBBIRuleChar;
        int i2;
        nextChar(this.fC);
        short s = 1;
        while (s != 0) {
            RBBIRuleParseTable.RBBIRuleTableElement rBBIRuleTableElement2 = RBBIRuleParseTable.gRuleParseStateTable[s];
            String str = this.fRB.fDebugEnv;
            if (str != null && str.indexOf("scan") >= 0) {
                System.out.println("char, line, col = ('" + ((char) this.fC.fChar) + "', " + this.fLineNum + ", " + this.fCharNum + "    state = " + rBBIRuleTableElement2.fStateName);
            }
            while (true) {
                rBBIRuleTableElement = RBBIRuleParseTable.gRuleParseStateTable[s];
                String str2 = this.fRB.fDebugEnv;
                if (str2 != null && str2.indexOf("scan") >= 0) {
                    System.out.print(".");
                }
                short s2 = rBBIRuleTableElement.fCharClass;
                if (s2 < 127) {
                    RBBIRuleChar rBBIRuleChar2 = this.fC;
                    if (!rBBIRuleChar2.fEscaped && s2 == rBBIRuleChar2.fChar) {
                        break;
                    }
                    if (s2 != 255 || (s2 == 254 && this.fC.fEscaped)) {
                        break;
                    }
                    if (s2 == 253) {
                        rBBIRuleChar = this.fC;
                        if (!rBBIRuleChar.fEscaped && ((i2 = rBBIRuleChar.fChar) == 80 || i2 == 112)) {
                            break;
                        }
                        if (s2 != 252 && this.fC.fChar == -1) {
                            break;
                        }
                        if (s2 < 128 && s2 < 240) {
                            RBBIRuleChar rBBIRuleChar3 = this.fC;
                            if (!rBBIRuleChar3.fEscaped && (i = rBBIRuleChar3.fChar) != -1 && this.fRuleSets[s2 - 128].contains(i)) {
                                break;
                            }
                        }
                        s++;
                    } else if (s2 != 252) {
                        if (s2 < 128) {
                        }
                        s++;
                    } else {
                        if (s2 < 128) {
                        }
                        s++;
                    }
                } else {
                    if (s2 != 255) {
                        break;
                    }
                    if (s2 == 253) {
                        rBBIRuleChar = this.fC;
                        if (!rBBIRuleChar.fEscaped) {
                            if (s2 != 252) {
                                if (s2 < 128) {
                                }
                                s++;
                            } else {
                                if (s2 < 128) {
                                }
                                s++;
                            }
                        } else if (s2 != 252) {
                            if (s2 < 128) {
                            }
                            s++;
                        } else {
                            if (s2 < 128) {
                            }
                            s++;
                        }
                    } else if (s2 != 252) {
                        if (s2 < 128) {
                        }
                        s++;
                    } else {
                        if (s2 < 128) {
                        }
                        s++;
                    }
                }
            }
            String str3 = this.fRB.fDebugEnv;
            if (str3 != null && str3.indexOf("scan") >= 0) {
                System.out.println("");
            }
            if (!doParseActions(rBBIRuleTableElement.fAction)) {
                break;
            }
            if (rBBIRuleTableElement.fPushState != 0) {
                int i3 = this.fStackPtr + 1;
                this.fStackPtr = i3;
                if (i3 >= 100) {
                    System.out.println("RBBIRuleScanner.parse() - state stack overflow.");
                    error(66049);
                }
                this.fStack[this.fStackPtr] = rBBIRuleTableElement.fPushState;
            }
            if (rBBIRuleTableElement.fNextChar) {
                nextChar(this.fC);
            }
            s = rBBIRuleTableElement.fNextState;
            if (s == 255) {
                short[] sArr = this.fStack;
                int i4 = this.fStackPtr;
                s = sArr[i4];
                int i5 = i4 - 1;
                this.fStackPtr = i5;
                if (i5 < 0) {
                    System.out.println("RBBIRuleScanner.parse() - state stack underflow.");
                    error(66049);
                }
            }
        }
        if (this.fRB.fTreeRoots[0] == null) {
            error(66052);
        }
        String str4 = this.fRB.fDebugEnv;
        if (str4 != null && str4.indexOf("symbols") >= 0) {
            this.fSymbolTable.rbbiSymtablePrint();
        }
        String str5 = this.fRB.fDebugEnv;
        if (str5 == null || str5.indexOf("ptree") < 0) {
            return;
        }
        System.out.println("Completed Forward Rules Parse Tree...");
        this.fRB.fTreeRoots[0].printTree(true);
        System.out.println("\nCompleted Reverse Rules Parse Tree...");
        this.fRB.fTreeRoots[1].printTree(true);
        System.out.println("\nCompleted Safe Point Forward Rules Parse Tree...");
        RBBINode rBBINode = this.fRB.fTreeRoots[2];
        if (rBBINode == null) {
            System.out.println("  -- null -- ");
        } else {
            rBBINode.printTree(true);
        }
        System.out.println("\nCompleted Safe Point Reverse Rules Parse Tree...");
        RBBINode rBBINode2 = this.fRB.fTreeRoots[3];
        if (rBBINode2 == null) {
            System.out.println("  -- null -- ");
        } else {
            rBBINode2.printTree(true);
        }
    }

    public void printNodeStack(String str) {
        System.out.println(str + ".  Dumping node stack...\n");
        for (int i = this.fNodeStackPtr; i > 0; i--) {
            this.fNodeStack[i].printTree(true);
        }
    }

    public RBBINode pushNewNode(int i) {
        int i2 = this.fNodeStackPtr + 1;
        this.fNodeStackPtr = i2;
        if (i2 >= 100) {
            System.out.println("RBBIRuleScanner.pushNewNode - stack overflow.");
            error(66049);
        }
        this.fNodeStack[this.fNodeStackPtr] = new RBBINode(i);
        return this.fNodeStack[this.fNodeStackPtr];
    }

    public void scanSet() {
        UnicodeSet unicodeSet;
        ParsePosition parsePosition = new ParsePosition(this.fScanIndex);
        int i = this.fScanIndex;
        try {
            unicodeSet = new UnicodeSet(this.fRB.fRules, parsePosition, this.fXSymbolTable, 1);
        } catch (Exception unused) {
            error(66063);
            unicodeSet = null;
        }
        UnicodeSet unicodeSet2 = new UnicodeSet(unicodeSet);
        unicodeSet2.removeAllStrings();
        if (unicodeSet2.isEmpty() && !unicodeSet.contains("eof")) {
            error(66060);
        }
        int index = parsePosition.getIndex();
        while (this.fNextIndex < index) {
            nextCharLL();
        }
        RBBINode rBBINodePushNewNode = pushNewNode(0);
        rBBINodePushNewNode.fFirstPos = i;
        int i2 = this.fNextIndex;
        rBBINodePushNewNode.fLastPos = i2;
        String strSubstring = this.fRB.fRules.substring(i, i2);
        rBBINodePushNewNode.fText = strSubstring;
        findSetFor(strSubstring, rBBINodePushNewNode, unicodeSet);
    }
}
