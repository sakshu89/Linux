package com.ibm.icu.text;

import com.ibm.icu.lang.UCharacter;
import java.text.ParsePosition;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
class RBBISymbolTable implements SymbolTable {
    HashMap<String, RBBISymbolTableEntry> fHashTable = new HashMap<>();
    RBBIRuleScanner fRuleScanner;

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class RBBISymbolTableEntry {
        String key;
        RBBINode val;
    }

    public RBBISymbolTable(RBBIRuleScanner rBBIRuleScanner) {
        this.fRuleScanner = rBBIRuleScanner;
    }

    public void addEntry(String str, RBBINode rBBINode) {
        if (this.fHashTable.get(str) != null) {
            this.fRuleScanner.error(66055);
            return;
        }
        RBBISymbolTableEntry rBBISymbolTableEntry = new RBBISymbolTableEntry();
        rBBISymbolTableEntry.key = str;
        rBBISymbolTableEntry.val = rBBINode;
        this.fHashTable.put(str, rBBISymbolTableEntry);
    }

    @Override // com.ibm.icu.text.SymbolTable
    public char[] lookup(String str) {
        RBBISymbolTableEntry rBBISymbolTableEntry = this.fHashTable.get(str);
        if (rBBISymbolTableEntry == null) {
            return null;
        }
        return rBBISymbolTableEntry.val.fLeftChild.fText.toCharArray();
    }

    @Override // com.ibm.icu.text.SymbolTable
    public UnicodeMatcher lookupMatcher(int i) {
        return null;
    }

    public RBBINode lookupNode(String str) {
        RBBISymbolTableEntry rBBISymbolTableEntry = this.fHashTable.get(str);
        if (rBBISymbolTableEntry != null) {
            return rBBISymbolTableEntry.val;
        }
        return null;
    }

    @Override // com.ibm.icu.text.SymbolTable
    public UnicodeSet lookupSet(String str) {
        RBBISymbolTableEntry rBBISymbolTableEntry = this.fHashTable.get(str);
        if (rBBISymbolTableEntry == null) {
            return null;
        }
        RBBINode rBBINode = rBBISymbolTableEntry.val.fLeftChild;
        if (rBBINode.fType == 0) {
            return rBBINode.fLeftChild.fInputSet;
        }
        return null;
    }

    @Override // com.ibm.icu.text.SymbolTable
    public String parseReference(String str, ParsePosition parsePosition, int i) {
        int index = parsePosition.getIndex();
        int charCount = index;
        while (charCount < i) {
            int iCharAt = UTF16.charAt(str, charCount);
            if ((charCount == index && !UCharacter.isUnicodeIdentifierStart(iCharAt)) || !UCharacter.isUnicodeIdentifierPart(iCharAt)) {
                break;
            }
            charCount += UTF16.getCharCount(iCharAt);
        }
        if (charCount == index) {
            return "";
        }
        parsePosition.setIndex(charCount);
        return str.substring(index, charCount);
    }

    public void rbbiSymtablePrint() {
        System.out.print("Variable Definitions\nName               Node Val     String Val\n----------------------------------------------------------------------\n");
        RBBISymbolTableEntry[] rBBISymbolTableEntryArr = (RBBISymbolTableEntry[]) this.fHashTable.values().toArray(new RBBISymbolTableEntry[0]);
        for (RBBISymbolTableEntry rBBISymbolTableEntry : rBBISymbolTableEntryArr) {
            System.out.print("  " + rBBISymbolTableEntry.key + "  ");
            System.out.print("  " + String.valueOf(rBBISymbolTableEntry.val) + "  ");
            System.out.print(rBBISymbolTableEntry.val.fLeftChild.fText);
            System.out.print("\n");
        }
        System.out.println("\nParsed Variable Definitions\n");
        for (RBBISymbolTableEntry rBBISymbolTableEntry2 : rBBISymbolTableEntryArr) {
            System.out.print(rBBISymbolTableEntry2.key);
            rBBISymbolTableEntry2.val.fLeftChild.printTree(true);
            System.out.print("\n");
        }
    }
}
