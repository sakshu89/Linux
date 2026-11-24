package com.ibm.icu.impl.coll;

import com.ibm.icu.impl.Normalizer2Impl;
import com.ibm.icu.impl.Trie2;
import com.ibm.icu.impl.Utility;
import com.ibm.icu.text.UnicodeSet;
import com.ibm.icu.util.CharsTrie;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class TailoredSet {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private CollationData baseData;
    private CollationData data;
    private String suffix;
    private UnicodeSet tailored;
    private StringBuilder unreversedPrefix = new StringBuilder();

    public TailoredSet(UnicodeSet unicodeSet) {
        this.tailored = unicodeSet;
    }

    private void add(int i) {
        if (this.unreversedPrefix.length() == 0 && this.suffix == null) {
            this.tailored.add(i);
            return;
        }
        StringBuilder sb = new StringBuilder(this.unreversedPrefix);
        sb.appendCodePoint(i);
        String str = this.suffix;
        if (str != null) {
            sb.append(str);
        }
        this.tailored.add(sb);
    }

    private void addContractions(int i, CharSequence charSequence, int i2) {
        Iterator<CharsTrie.Entry> itIterator2 = new CharsTrie(charSequence, i2).iterator2();
        while (itIterator2.hasNext()) {
            addSuffix(i, itIterator2.next().chars);
        }
    }

    private void addPrefix(CollationData collationData, CharSequence charSequence, int i, int i2) {
        setPrefix(charSequence);
        int finalCE32 = collationData.getFinalCE32(i2);
        if (Collation.isContractionCE32(finalCE32)) {
            addContractions(i, collationData.contexts, Collation.indexFromCE32(finalCE32) + 2);
        }
        this.tailored.add(new StringBuilder(this.unreversedPrefix.appendCodePoint(i)));
        resetPrefix();
    }

    private void addPrefixes(CollationData collationData, int i, CharSequence charSequence, int i2) {
        Iterator<CharsTrie.Entry> itIterator2 = new CharsTrie(charSequence, i2).iterator2();
        while (itIterator2.hasNext()) {
            CharsTrie.Entry next = itIterator2.next();
            addPrefix(collationData, next.chars, i, next.value);
        }
    }

    private void addSuffix(int i, CharSequence charSequence) {
        UnicodeSet unicodeSet = this.tailored;
        StringBuilder sbAppendCodePoint = new StringBuilder(this.unreversedPrefix).appendCodePoint(i);
        sbAppendCodePoint.append(charSequence);
        unicodeSet.add(sbAppendCodePoint);
    }

    private void compare(int i, int i2, int i3) {
        int finalCE32;
        int finalCE33;
        int finalCE34;
        int finalCE35;
        if (Collation.isPrefixCE32(i2)) {
            int iIndexFromCE32 = Collation.indexFromCE32(i2);
            CollationData collationData = this.data;
            finalCE32 = collationData.getFinalCE32(collationData.getCE32FromContexts(iIndexFromCE32));
            if (Collation.isPrefixCE32(i3)) {
                int iIndexFromCE33 = Collation.indexFromCE32(i3);
                CollationData collationData2 = this.baseData;
                finalCE35 = collationData2.getFinalCE32(collationData2.getCE32FromContexts(iIndexFromCE33));
                comparePrefixes(i, this.data.contexts, iIndexFromCE32 + 2, this.baseData.contexts, iIndexFromCE33 + 2);
            } else {
                CollationData collationData3 = this.data;
                addPrefixes(collationData3, i, collationData3.contexts, iIndexFromCE32 + 2);
                finalCE35 = i3;
            }
            finalCE33 = finalCE35;
        } else if (Collation.isPrefixCE32(i3)) {
            int iIndexFromCE34 = Collation.indexFromCE32(i3);
            CollationData collationData4 = this.baseData;
            finalCE33 = collationData4.getFinalCE32(collationData4.getCE32FromContexts(iIndexFromCE34));
            CollationData collationData5 = this.baseData;
            addPrefixes(collationData5, i, collationData5.contexts, iIndexFromCE34 + 2);
            finalCE32 = i2;
        } else {
            finalCE32 = i2;
            finalCE33 = i3;
        }
        if (Collation.isContractionCE32(finalCE32)) {
            int iIndexFromCE35 = Collation.indexFromCE32(finalCE32);
            if ((finalCE32 & 256) != 0) {
                finalCE32 = 1;
            } else {
                CollationData collationData6 = this.data;
                finalCE32 = collationData6.getFinalCE32(collationData6.getCE32FromContexts(iIndexFromCE35));
            }
            if (Collation.isContractionCE32(finalCE33)) {
                int iIndexFromCE36 = Collation.indexFromCE32(finalCE33);
                if ((finalCE33 & 256) != 0) {
                    finalCE34 = 1;
                } else {
                    CollationData collationData7 = this.baseData;
                    finalCE34 = collationData7.getFinalCE32(collationData7.getCE32FromContexts(iIndexFromCE36));
                }
                compareContractions(i, this.data.contexts, iIndexFromCE35 + 2, this.baseData.contexts, iIndexFromCE36 + 2);
                finalCE33 = finalCE34;
            } else {
                addContractions(i, this.data.contexts, iIndexFromCE35 + 2);
            }
        } else if (Collation.isContractionCE32(finalCE33)) {
            int iIndexFromCE37 = Collation.indexFromCE32(finalCE33);
            CollationData collationData8 = this.baseData;
            finalCE33 = collationData8.getFinalCE32(collationData8.getCE32FromContexts(iIndexFromCE37));
            addContractions(i, this.baseData.contexts, iIndexFromCE37 + 2);
        }
        int iTagFromCE32 = Collation.isSpecialCE32(finalCE32) ? Collation.tagFromCE32(finalCE32) : -1;
        int iTagFromCE33 = Collation.isSpecialCE32(finalCE33) ? Collation.tagFromCE32(finalCE33) : -1;
        if (iTagFromCE33 == 14) {
            if (!Collation.isLongPrimaryCE32(finalCE32)) {
                add(i);
                return;
            } else {
                if (Collation.primaryFromLongPrimaryCE32(finalCE32) != Collation.getThreeBytePrimaryForOffsetData(i, this.baseData.ces[Collation.indexFromCE32(finalCE33)])) {
                    add(i);
                    return;
                }
            }
        }
        if (iTagFromCE32 != iTagFromCE33) {
            add(i);
            return;
        }
        int i4 = 0;
        if (iTagFromCE32 == 5) {
            int iLengthFromCE32 = Collation.lengthFromCE32(finalCE32);
            if (iLengthFromCE32 != Collation.lengthFromCE32(finalCE33)) {
                add(i);
                return;
            }
            int iIndexFromCE38 = Collation.indexFromCE32(finalCE32);
            int iIndexFromCE39 = Collation.indexFromCE32(finalCE33);
            while (i4 < iLengthFromCE32) {
                if (this.data.ce32s[iIndexFromCE38 + i4] != this.baseData.ce32s[iIndexFromCE39 + i4]) {
                    add(i);
                    return;
                }
                i4++;
            }
            return;
        }
        if (iTagFromCE32 == 6) {
            int iLengthFromCE33 = Collation.lengthFromCE32(finalCE32);
            if (iLengthFromCE33 != Collation.lengthFromCE32(finalCE33)) {
                add(i);
                return;
            }
            int iIndexFromCE310 = Collation.indexFromCE32(finalCE32);
            int iIndexFromCE311 = Collation.indexFromCE32(finalCE33);
            while (i4 < iLengthFromCE33) {
                if (this.data.ces[iIndexFromCE310 + i4] != this.baseData.ces[iIndexFromCE311 + i4]) {
                    add(i);
                    return;
                }
                i4++;
            }
            return;
        }
        if (iTagFromCE32 != 12) {
            if (finalCE32 != finalCE33) {
                add(i);
                return;
            }
            return;
        }
        StringBuilder sb = new StringBuilder();
        int iDecompose = Normalizer2Impl.Hangul.decompose(i, sb);
        if (this.tailored.contains(sb.charAt(0)) || this.tailored.contains(sb.charAt(1)) || (iDecompose == 3 && this.tailored.contains(sb.charAt(2)))) {
            add(i);
        }
    }

    private void compareContractions(int i, CharSequence charSequence, int i2, CharSequence charSequence2, int i3) {
        Iterator<CharsTrie.Entry> itIterator2 = new CharsTrie(charSequence, i2).iterator2();
        Iterator<CharsTrie.Entry> itIterator3 = new CharsTrie(charSequence2, i3).iterator2();
        while (true) {
            String string = null;
            String string2 = null;
            CharsTrie.Entry next = null;
            CharsTrie.Entry next2 = null;
            while (true) {
                if (string == null) {
                    if (itIterator2.hasNext()) {
                        next = itIterator2.next();
                        string = next.chars.toString();
                    } else {
                        next = null;
                        string = "\uffff\uffff";
                    }
                }
                if (string2 == null) {
                    if (itIterator3.hasNext()) {
                        next2 = itIterator3.next();
                        string2 = next2.chars.toString();
                    } else {
                        next2 = null;
                        string2 = "\uffff\uffff";
                    }
                }
                if (Utility.sameObjects(string, "\uffff\uffff") && Utility.sameObjects(string2, "\uffff\uffff")) {
                    return;
                }
                int iCompareTo = string.compareTo(string2);
                if (iCompareTo < 0) {
                    addSuffix(i, string);
                    string = null;
                    next = null;
                } else if (iCompareTo > 0) {
                    addSuffix(i, string2);
                    string2 = null;
                    next2 = null;
                }
            }
            this.suffix = string;
            compare(i, next.value, next2.value);
            this.suffix = null;
        }
    }

    private void comparePrefixes(int i, CharSequence charSequence, int i2, CharSequence charSequence2, int i3) {
        Iterator<CharsTrie.Entry> itIterator2 = new CharsTrie(charSequence, i2).iterator2();
        Iterator<CharsTrie.Entry> itIterator3 = new CharsTrie(charSequence2, i3).iterator2();
        while (true) {
            String string = null;
            String string2 = null;
            CharsTrie.Entry next = null;
            CharsTrie.Entry next2 = null;
            while (true) {
                if (string == null) {
                    if (itIterator2.hasNext()) {
                        next = itIterator2.next();
                        string = next.chars.toString();
                    } else {
                        next = null;
                        string = "\uffff";
                    }
                }
                if (string2 == null) {
                    if (itIterator3.hasNext()) {
                        next2 = itIterator3.next();
                        string2 = next2.chars.toString();
                    } else {
                        next2 = null;
                        string2 = "\uffff";
                    }
                }
                if (Utility.sameObjects(string, "\uffff") && Utility.sameObjects(string2, "\uffff")) {
                    return;
                }
                int iCompareTo = string.compareTo(string2);
                if (iCompareTo < 0) {
                    addPrefix(this.data, string, i, next.value);
                    string = null;
                    next = null;
                } else if (iCompareTo > 0) {
                    addPrefix(this.baseData, string2, i, next2.value);
                    string2 = null;
                    next2 = null;
                }
            }
            setPrefix(string);
            compare(i, next.value, next2.value);
            resetPrefix();
        }
    }

    private void enumTailoredRange(int i, int i2, int i3, TailoredSet tailoredSet) {
        if (i3 == 192) {
            return;
        }
        tailoredSet.handleCE32(i, i2, i3);
    }

    private void handleCE32(int i, int i2, int i3) {
        if (Collation.isSpecialCE32(i3) && (i3 = this.data.getIndirectCE32(i3)) == 192) {
            return;
        }
        do {
            CollationData collationData = this.baseData;
            int finalCE32 = collationData.getFinalCE32(collationData.getCE32(i));
            if (!Collation.isSelfContainedCE32(i3) || !Collation.isSelfContainedCE32(finalCE32)) {
                compare(i, i3, finalCE32);
            } else if (i3 != finalCE32) {
                this.tailored.add(i);
            }
            i++;
        } while (i <= i2);
    }

    private void resetPrefix() {
        this.unreversedPrefix.setLength(0);
    }

    private void setPrefix(CharSequence charSequence) {
        this.unreversedPrefix.setLength(0);
        StringBuilder sb = this.unreversedPrefix;
        sb.append(charSequence);
        sb.reverse();
    }

    public void forData(CollationData collationData) {
        this.data = collationData;
        this.baseData = collationData.base;
        for (Trie2.Range range : collationData.trie) {
            if (range.leadSurrogate) {
                return;
            } else {
                enumTailoredRange(range.startCodePoint, range.endCodePoint, range.value, this);
            }
        }
    }
}
