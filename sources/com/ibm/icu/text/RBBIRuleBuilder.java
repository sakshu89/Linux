package com.ibm.icu.text;

import com.ibm.icu.impl.Assert;
import com.ibm.icu.impl.ICUBinary;
import com.ibm.icu.impl.ICUDebug;
import com.ibm.icu.impl.RBBIDataWrapper;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
class RBBIRuleBuilder {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final int U_BRK_ASSIGN_ERROR = 66054;
    static final int U_BRK_ERROR_LIMIT = 66064;
    static final int U_BRK_ERROR_START = 66048;
    static final int U_BRK_HEX_DIGITS_EXPECTED = 66050;
    static final int U_BRK_INIT_ERROR = 66059;
    static final int U_BRK_INTERNAL_ERROR = 66049;
    static final int U_BRK_MALFORMED_RULE_TAG = 66062;
    static final int U_BRK_MALFORMED_SET = 66063;
    static final int U_BRK_MISMATCHED_PAREN = 66056;
    static final int U_BRK_NEW_LINE_IN_QUOTED_STRING = 66057;
    static final int U_BRK_RULE_EMPTY_SET = 66060;
    static final int U_BRK_RULE_SYNTAX = 66052;
    static final int U_BRK_SEMICOLON_EXPECTED = 66051;
    static final int U_BRK_UNCLOSED_SET = 66053;
    static final int U_BRK_UNDEFINED_VARIABLE = 66058;
    static final int U_BRK_UNRECOGNIZED_OPTION = 66061;
    static final int U_BRK_VARIABLE_REDFINITION = 66055;
    static final int U_ILLEGAL_CHAR_FOUND = 12;
    static final int fForwardTree = 0;
    static final int fReverseTree = 1;
    static final int fSafeFwdTree = 2;
    static final int fSafeRevTree = 3;
    boolean fChainRules;
    String fDebugEnv;
    RBBITableBuilder fForwardTable;
    boolean fLookAheadHardBreak;
    List<Integer> fRuleStatusVals;
    String fRules;
    RBBIRuleScanner fScanner;
    RBBISetBuilder fSetBuilder;
    StringBuilder fStrippedRules;
    List<RBBINode> fUSetNodes;
    RBBINode[] fTreeRoots = new RBBINode[4];
    int fDefaultTree = 0;
    Map<Set<Integer>, Integer> fStatusSets = new HashMap();

    public RBBIRuleBuilder(String str, UnicodeSet.XSymbolTable xSymbolTable) {
        this.fDebugEnv = ICUDebug.enabled("rbbi") ? ICUDebug.value("rbbi") : null;
        this.fRules = str;
        this.fStrippedRules = new StringBuilder(str);
        this.fUSetNodes = new ArrayList();
        this.fRuleStatusVals = new ArrayList();
        this.fScanner = new RBBIRuleScanner(this, xSymbolTable);
        this.fSetBuilder = new RBBISetBuilder(this);
    }

    public static final int align8(int i) {
        return (i + 7) & (-8);
    }

    public static void compileRules(String str, OutputStream outputStream, UnicodeSet.XSymbolTable xSymbolTable) throws IOException {
        new RBBIRuleBuilder(str, xSymbolTable).build(outputStream);
    }

    public void build(OutputStream outputStream) throws IOException {
        this.fScanner.parse();
        this.fSetBuilder.buildRanges();
        RBBITableBuilder rBBITableBuilder = new RBBITableBuilder(this, 0);
        this.fForwardTable = rBBITableBuilder;
        rBBITableBuilder.buildForwardTable();
        optimizeTables();
        this.fForwardTable.buildSafeReverseTable();
        String str = this.fDebugEnv;
        if (str != null && str.indexOf("states") >= 0) {
            this.fForwardTable.printStates();
            this.fForwardTable.printRuleStatusTable();
            this.fForwardTable.printReverseTable();
        }
        this.fSetBuilder.buildTrie();
        flattenData(outputStream);
    }

    public void flattenData(OutputStream outputStream) throws IOException {
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        String strStripRules = RBBIRuleScanner.stripRules(this.fStrippedRules.toString());
        int iAlign8 = align8(this.fForwardTable.getTableSize());
        int iAlign9 = align8(this.fForwardTable.getSafeTableSize());
        int iAlign10 = align8(this.fSetBuilder.getTrieSize());
        int iAlign11 = align8(this.fRuleStatusVals.size() * 4);
        byte[] bytes = strStripRules.getBytes(StandardCharsets.UTF_8);
        int iAlign12 = iAlign8 + 80 + iAlign9 + iAlign11 + iAlign10 + align8(bytes.length + 1);
        ICUBinary.writeHeader(RBBIDataWrapper.DATA_FORMAT, RBBIDataWrapper.FORMAT_VERSION, 0, dataOutputStream);
        int i = 80 + iAlign8;
        int i2 = iArr[8] + iAlign10;
        int[] iArr = {45472, RBBIDataWrapper.FORMAT_VERSION, iAlign12, this.fSetBuilder.getNumCharCategories(), 80, iAlign8, i, iAlign9, i + iAlign9, this.fSetBuilder.getTrieSize(), i2 + iAlign11, bytes.length, i2, iAlign11, 0, 0, 0, 0, 0, 0};
        int i3 = 0;
        for (int i4 = 0; i4 < 20; i4++) {
            dataOutputStream.writeInt(iArr[i4]);
            i3 += 4;
        }
        int iPut = this.fForwardTable.exportTable().put(dataOutputStream) + i3;
        RBBIDataWrapper.RBBIStateTable rBBIStateTableExportSafeTable = this.fForwardTable.exportSafeTable();
        Assert.assrt(iPut == iArr[6]);
        int iPut2 = rBBIStateTableExportSafeTable.put(dataOutputStream) + iPut;
        Assert.assrt(iPut2 == iArr[8]);
        this.fSetBuilder.serializeTrie(outputStream);
        int i5 = iPut2 + iArr[9];
        while (i5 % 8 != 0) {
            dataOutputStream.write(0);
            i5++;
        }
        Assert.assrt(i5 == iArr[12]);
        Iterator<Integer> it = this.fRuleStatusVals.iterator();
        while (it.hasNext()) {
            dataOutputStream.writeInt(it.next().intValue());
            i5 += 4;
        }
        while (i5 % 8 != 0) {
            dataOutputStream.write(0);
            i5++;
        }
        Assert.assrt(i5 == iArr[10]);
        dataOutputStream.write(bytes, 0, bytes.length);
        dataOutputStream.write(0);
        for (int length = bytes.length + 1 + i5; length % 8 != 0; length++) {
            dataOutputStream.write(0);
        }
    }

    public void optimizeTables() {
        boolean z;
        this.fForwardTable.minimizeLookaheads();
        do {
            z = false;
            IntPair intPair = new IntPair(1, 0);
            while (this.fForwardTable.findDuplCharClassFrom(intPair)) {
                this.fSetBuilder.mergeCategories(intPair);
                this.fForwardTable.removeColumn(intPair.second);
                z = true;
            }
            while (this.fForwardTable.removeDuplicateStates() > 0) {
                z = true;
            }
        } while (z);
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class IntPair {
        int first;
        int second;

        public IntPair() {
            this.first = 0;
            this.second = 0;
        }

        public IntPair(int i, int i2) {
            this.first = i;
            this.second = i2;
        }
    }
}
