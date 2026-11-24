package com.ibm.icu.text;

import com.ibm.icu.impl.Assert;
import com.ibm.icu.impl.locale.LanguageTag;
import com.ibm.icu.impl.number.Padder;
import com.ibm.icu.util.CodePointTrie;
import com.ibm.icu.util.MutableCodePointTrie;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
class RBBISetBuilder {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int MAX_CHAR_CATEGORIES_FOR_8BITS_TRIE = 255;
    int fDictCategoriesStart;
    CodePointTrie fFrozenTrie;
    int fGroupCount;
    RBBIRuleBuilder fRB;
    RangeDescriptor fRangeList;
    MutableCodePointTrie fTrie;

    public RBBISetBuilder(RBBIRuleBuilder rBBIRuleBuilder) {
        this.fRB = rBBIRuleBuilder;
    }

    public void addValToSet(RBBINode rBBINode, int i) {
        RBBINode rBBINode2 = new RBBINode(3);
        rBBINode2.fVal = i;
        if (rBBINode.fLeftChild == null) {
            rBBINode.fLeftChild = rBBINode2;
            rBBINode2.fParent = rBBINode;
            return;
        }
        RBBINode rBBINode3 = new RBBINode(9);
        RBBINode rBBINode4 = rBBINode.fLeftChild;
        rBBINode3.fLeftChild = rBBINode4;
        rBBINode3.fRightChild = rBBINode2;
        rBBINode4.fParent = rBBINode3;
        rBBINode2.fParent = rBBINode3;
        rBBINode.fLeftChild = rBBINode3;
        rBBINode3.fParent = rBBINode;
    }

    public void addValToSets(List<RBBINode> list, int i) {
        Iterator<RBBINode> it = list.iterator();
        while (it.hasNext()) {
            addValToSet(it.next(), i);
        }
    }

    public void buildRanges() {
        int i;
        String str = this.fRB.fDebugEnv;
        if (str != null && str.indexOf("usets") >= 0) {
            printSets();
        }
        RangeDescriptor rangeDescriptor = new RangeDescriptor();
        this.fRangeList = rangeDescriptor;
        int i2 = 0;
        rangeDescriptor.fStartChar = 0;
        rangeDescriptor.fEndChar = 1114111;
        for (RBBINode rBBINode : this.fRB.fUSetNodes) {
            UnicodeSet unicodeSet = rBBINode.fInputSet;
            int rangeCount = unicodeSet.getRangeCount();
            RangeDescriptor rangeDescriptor2 = this.fRangeList;
            int i3 = 0;
            while (i3 < rangeCount) {
                int rangeStart = unicodeSet.getRangeStart(i3);
                int rangeEnd = unicodeSet.getRangeEnd(i3);
                while (true) {
                    i = rangeDescriptor2.fEndChar;
                    if (i >= rangeStart) {
                        break;
                    } else {
                        rangeDescriptor2 = rangeDescriptor2.fNext;
                    }
                }
                if (rangeDescriptor2.fStartChar < rangeStart) {
                    rangeDescriptor2.split(rangeStart);
                } else {
                    if (i > rangeEnd) {
                        rangeDescriptor2.split(rangeEnd + 1);
                    }
                    if (rangeDescriptor2.fIncludesSets.indexOf(rBBINode) == -1) {
                        rangeDescriptor2.fIncludesSets.add(rBBINode);
                    }
                    if (rangeEnd == rangeDescriptor2.fEndChar) {
                        i3++;
                    }
                    rangeDescriptor2 = rangeDescriptor2.fNext;
                }
            }
        }
        String str2 = this.fRB.fDebugEnv;
        if (str2 != null && str2.indexOf("range") >= 0) {
            printRanges();
        }
        for (RangeDescriptor rangeDescriptor3 = this.fRangeList; rangeDescriptor3 != null; rangeDescriptor3 = rangeDescriptor3.fNext) {
            for (RangeDescriptor rangeDescriptor4 = this.fRangeList; rangeDescriptor4 != rangeDescriptor3; rangeDescriptor4 = rangeDescriptor4.fNext) {
                if (rangeDescriptor3.fIncludesSets.equals(rangeDescriptor4.fIncludesSets)) {
                    rangeDescriptor3.fNum = rangeDescriptor4.fNum;
                    rangeDescriptor3.fIncludesDict = rangeDescriptor4.fIncludesDict;
                    break;
                }
            }
            if (rangeDescriptor3.fNum == 0) {
                rangeDescriptor3.fFirstInGroup = true;
                if (rangeDescriptor3.isDictionaryRange()) {
                    i2++;
                    rangeDescriptor3.fNum = i2;
                    rangeDescriptor3.fIncludesDict = true;
                } else {
                    int i4 = this.fGroupCount;
                    this.fGroupCount = i4 + 1;
                    rangeDescriptor3.fNum = i4 + 3;
                    addValToSets(rangeDescriptor3.fIncludesSets, i4 + 3);
                }
            }
        }
        this.fDictCategoriesStart = this.fGroupCount + 3;
        for (RangeDescriptor rangeDescriptor5 = this.fRangeList; rangeDescriptor5 != null; rangeDescriptor5 = rangeDescriptor5.fNext) {
            if (rangeDescriptor5.fIncludesDict) {
                int i5 = (this.fDictCategoriesStart - 1) + rangeDescriptor5.fNum;
                rangeDescriptor5.fNum = i5;
                if (rangeDescriptor5.fFirstInGroup) {
                    addValToSets(rangeDescriptor5.fIncludesSets, i5);
                }
            }
        }
        this.fGroupCount += i2;
        for (RBBINode rBBINode2 : this.fRB.fUSetNodes) {
            if (rBBINode2.fInputSet.contains("eof")) {
                addValToSet(rBBINode2, 1);
            }
        }
        String str3 = this.fRB.fDebugEnv;
        if (str3 != null && str3.indexOf("rgroup") >= 0) {
            printRangeGroups();
        }
        String str4 = this.fRB.fDebugEnv;
        if (str4 == null || str4.indexOf("esets") < 0) {
            return;
        }
        printSets();
    }

    public void buildTrie() {
        this.fTrie = new MutableCodePointTrie(0, 0);
        for (RangeDescriptor rangeDescriptor = this.fRangeList; rangeDescriptor != null; rangeDescriptor = rangeDescriptor.fNext) {
            this.fTrie.setRange(rangeDescriptor.fStartChar, rangeDescriptor.fEndChar, rangeDescriptor.fNum);
        }
    }

    public void freezeTrieIfNotYet() {
        if (this.fFrozenTrie == null) {
            this.fFrozenTrie = this.fTrie.buildImmutable(CodePointTrie.Type.FAST, getNumCharCategories() <= 255 ? CodePointTrie.ValueWidth.BITS_8 : CodePointTrie.ValueWidth.BITS_16);
            this.fTrie = null;
        }
    }

    public int getDictCategoriesStart() {
        return this.fDictCategoriesStart;
    }

    public int getFirstChar(int i) {
        for (RangeDescriptor rangeDescriptor = this.fRangeList; rangeDescriptor != null; rangeDescriptor = rangeDescriptor.fNext) {
            if (rangeDescriptor.fNum == i) {
                return rangeDescriptor.fStartChar;
            }
        }
        return -1;
    }

    public int getNumCharCategories() {
        return this.fGroupCount + 3;
    }

    public int getTrieSize() {
        freezeTrieIfNotYet();
        return this.fFrozenTrie.toBinary(new ByteArrayOutputStream());
    }

    public void mergeCategories(RBBIRuleBuilder.IntPair intPair) {
        for (RangeDescriptor rangeDescriptor = this.fRangeList; rangeDescriptor != null; rangeDescriptor = rangeDescriptor.fNext) {
            int i = rangeDescriptor.fNum;
            int i2 = intPair.second;
            if (i == i2) {
                rangeDescriptor.fNum = intPair.first;
            } else if (i > i2) {
                rangeDescriptor.fNum = i - 1;
            }
        }
        this.fGroupCount--;
        int i3 = intPair.second;
        int i4 = this.fDictCategoriesStart;
        if (i3 <= i4) {
            this.fDictCategoriesStart = i4 - 1;
        }
    }

    public void printRangeGroups() {
        RBBINode rBBINode;
        System.out.print("\nRanges grouped by Unicode Set Membership...\n");
        for (RangeDescriptor rangeDescriptor = this.fRangeList; rangeDescriptor != null; rangeDescriptor = rangeDescriptor.fNext) {
            if (rangeDescriptor.fFirstInGroup) {
                int i = rangeDescriptor.fNum;
                if (i < 10) {
                    System.out.print(Padder.FALLBACK_PADDING_STRING);
                }
                System.out.print(i + Padder.FALLBACK_PADDING_STRING);
                if (i >= this.fDictCategoriesStart) {
                    System.out.print(" <DICT> ");
                }
                for (int i2 = 0; i2 < rangeDescriptor.fIncludesSets.size(); i2++) {
                    RBBINode rBBINode2 = rangeDescriptor.fIncludesSets.get(i2).fParent;
                    System.out.print((rBBINode2 == null || (rBBINode = rBBINode2.fParent) == null || rBBINode.fType != 2) ? "anon" : rBBINode.fText);
                    System.out.print(Padder.FALLBACK_PADDING_STRING);
                }
                int i3 = 0;
                for (RangeDescriptor rangeDescriptor2 = rangeDescriptor; rangeDescriptor2 != null; rangeDescriptor2 = rangeDescriptor2.fNext) {
                    if (rangeDescriptor2.fNum == rangeDescriptor.fNum) {
                        int i4 = i3 + 1;
                        if (i3 % 5 == 0) {
                            System.out.print("\n    ");
                        }
                        RBBINode.printHex(rangeDescriptor2.fStartChar, -1);
                        System.out.print(LanguageTag.SEP);
                        RBBINode.printHex(rangeDescriptor2.fEndChar, 0);
                        i3 = i4;
                    }
                }
                System.out.print("\n");
            }
        }
        System.out.print("\n");
    }

    public void printRanges() {
        RBBINode rBBINode;
        System.out.print("\n\n Nonoverlapping Ranges ...\n");
        for (RangeDescriptor rangeDescriptor = this.fRangeList; rangeDescriptor != null; rangeDescriptor = rangeDescriptor.fNext) {
            System.out.printf("%04x-%04x ", Integer.valueOf(rangeDescriptor.fStartChar), Integer.valueOf(rangeDescriptor.fEndChar));
            for (int i = 0; i < rangeDescriptor.fIncludesSets.size(); i++) {
                RBBINode rBBINode2 = rangeDescriptor.fIncludesSets.get(i).fParent;
                System.out.print((rBBINode2 == null || (rBBINode = rBBINode2.fParent) == null || rBBINode.fType != 2) ? "anon" : rBBINode.fText);
                System.out.print("  ");
            }
            System.out.println("");
        }
    }

    public void printSets() {
        RBBINode rBBINode;
        System.out.print("\n\nUnicode Sets List\n------------------\n");
        for (int i = 0; i < this.fRB.fUSetNodes.size(); i++) {
            RBBINode rBBINode2 = this.fRB.fUSetNodes.get(i);
            RBBINode.printInt(2, i);
            RBBINode rBBINode3 = rBBINode2.fParent;
            String str = (rBBINode3 == null || (rBBINode = rBBINode3.fParent) == null || rBBINode.fType != 2) ? "anonymous" : rBBINode.fText;
            System.out.print("  " + str);
            System.out.print("   ");
            System.out.print(rBBINode2.fText);
            System.out.print("\n");
            RBBINode rBBINode4 = rBBINode2.fLeftChild;
            if (rBBINode4 != null) {
                rBBINode4.printTree(true);
            }
        }
        System.out.print("\n");
    }

    public void serializeTrie(OutputStream outputStream) {
        freezeTrieIfNotYet();
        this.fFrozenTrie.toBinary(outputStream);
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class RangeDescriptor {
        int fEndChar;
        boolean fFirstInGroup;
        boolean fIncludesDict;
        List<RBBINode> fIncludesSets;
        RangeDescriptor fNext;
        int fNum;
        int fStartChar;

        public RangeDescriptor(RangeDescriptor rangeDescriptor) {
            this.fStartChar = 0;
            this.fEndChar = 0;
            this.fNum = 0;
            this.fIncludesDict = false;
            this.fFirstInGroup = false;
            this.fStartChar = rangeDescriptor.fStartChar;
            this.fEndChar = rangeDescriptor.fEndChar;
            this.fNum = rangeDescriptor.fNum;
            this.fIncludesDict = rangeDescriptor.fIncludesDict;
            this.fFirstInGroup = rangeDescriptor.fFirstInGroup;
            this.fIncludesSets = new ArrayList(rangeDescriptor.fIncludesSets);
        }

        public boolean isDictionaryRange() {
            RBBINode rBBINode;
            for (int i = 0; i < this.fIncludesSets.size(); i++) {
                RBBINode rBBINode2 = this.fIncludesSets.get(i).fParent;
                if (((rBBINode2 == null || (rBBINode = rBBINode2.fParent) == null || rBBINode.fType != 2) ? "" : rBBINode.fText).equals("dictionary")) {
                    return true;
                }
            }
            return false;
        }

        public void split(int i) {
            Assert.assrt(i > this.fStartChar && i <= this.fEndChar);
            RangeDescriptor rangeDescriptor = new RangeDescriptor(this);
            rangeDescriptor.fStartChar = i;
            this.fEndChar = i - 1;
            rangeDescriptor.fNext = this.fNext;
            this.fNext = rangeDescriptor;
        }

        public RangeDescriptor() {
            this.fStartChar = 0;
            this.fEndChar = 0;
            this.fNum = 0;
            this.fIncludesDict = false;
            this.fFirstInGroup = false;
            this.fIncludesSets = new ArrayList();
        }
    }
}
