package com.ibm.icu.text;

import defpackage.cq;
import defpackage.og;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
class CompoundTransliterator extends Transliterator {
    private int numAnonymousRBTs;
    private Transliterator[] trans;

    public CompoundTransliterator(List<Transliterator> list, int i) {
        super("", null);
        this.numAnonymousRBTs = 0;
        this.trans = null;
        init(list, 0, false);
        this.numAnonymousRBTs = i;
    }

    private static void _smartAppend(StringBuilder sb, char c) {
        if (sb.length() == 0 || sb.charAt(sb.length() - 1) == c) {
            return;
        }
        sb.append(c);
    }

    private void computeMaximumContextLength() {
        int i = 0;
        int i2 = 0;
        while (true) {
            Transliterator[] transliteratorArr = this.trans;
            if (i >= transliteratorArr.length) {
                setMaximumContextLength(i2);
                return;
            }
            int maximumContextLength = transliteratorArr[i].getMaximumContextLength();
            if (maximumContextLength > i2) {
                i2 = maximumContextLength;
            }
            i++;
        }
    }

    private void init(List<Transliterator> list, int i, boolean z) {
        int size = list.size();
        this.trans = new Transliterator[size];
        for (int i2 = 0; i2 < size; i2++) {
            this.trans[i2] = list.get(i == 0 ? i2 : (size - 1) - i2);
        }
        if (i == 1 && z) {
            StringBuilder sb = new StringBuilder();
            for (int i3 = 0; i3 < size; i3++) {
                if (i3 > 0) {
                    sb.append(';');
                }
                sb.append(this.trans[i3].getID());
            }
            setID(sb.toString());
        }
        computeMaximumContextLength();
    }

    @Override // com.ibm.icu.text.Transliterator
    public void addSourceTargetSet(UnicodeSet unicodeSet, UnicodeSet unicodeSet2, UnicodeSet unicodeSet3) {
        UnicodeSet unicodeSet4 = new UnicodeSet(getFilterAsUnicodeSet(unicodeSet));
        UnicodeSet unicodeSet5 = new UnicodeSet();
        for (int i = 0; i < this.trans.length; i++) {
            unicodeSet5.clear();
            this.trans[i].addSourceTargetSet(unicodeSet4, unicodeSet2, unicodeSet5);
            unicodeSet3.addAll(unicodeSet5);
            unicodeSet4.addAll(unicodeSet5);
        }
    }

    public int getCount() {
        return this.trans.length;
    }

    public Transliterator getTransliterator(int i) {
        return this.trans[i];
    }

    @Override // com.ibm.icu.text.Transliterator
    public void handleTransliterate(Replaceable replaceable, Transliterator.Position position, boolean z) {
        if (this.trans.length < 1) {
            position.start = position.limit;
            return;
        }
        int i = position.limit;
        int i2 = position.start;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            Transliterator[] transliteratorArr = this.trans;
            if (i3 >= transliteratorArr.length) {
                break;
            }
            position.start = i2;
            int i5 = position.limit;
            if (i2 == i5) {
                break;
            }
            transliteratorArr[i3].filteredTransliterate(replaceable, position, z);
            if (!z && position.start != position.limit) {
                og.p(cq.j("ERROR: Incomplete non-incremental transliteration by ", this.trans[i3].getID()));
                return;
            }
            i4 += position.limit - i5;
            if (z) {
                position.limit = position.start;
            }
            i3++;
        }
        position.limit = i + i4;
    }

    public Transliterator safeClone() {
        UnicodeFilter filter = getFilter();
        if (filter != null && (filter instanceof UnicodeSet)) {
            filter = new UnicodeSet((UnicodeSet) filter);
        }
        return new CompoundTransliterator(getID(), filter, this.trans, this.numAnonymousRBTs);
    }

    @Override // com.ibm.icu.text.Transliterator
    public String toRules(boolean z) {
        String rules;
        StringBuilder sb = new StringBuilder();
        if (this.numAnonymousRBTs >= 1 && getFilter() != null) {
            sb.append("::");
            sb.append(getFilter().toPattern(z));
            sb.append(';');
        }
        int i = 0;
        while (true) {
            Transliterator[] transliteratorArr = this.trans;
            if (i >= transliteratorArr.length) {
                return sb.toString();
            }
            boolean zStartsWith = transliteratorArr[i].getID().startsWith("%Pass");
            Transliterator[] transliteratorArr2 = this.trans;
            if (zStartsWith) {
                rules = transliteratorArr2[i].toRules(z);
                if (this.numAnonymousRBTs > 1 && i > 0 && this.trans[i - 1].getID().startsWith("%Pass")) {
                    rules = cq.j("::Null;", rules);
                }
            } else {
                int iIndexOf = transliteratorArr2[i].getID().indexOf(59);
                Transliterator[] transliteratorArr3 = this.trans;
                rules = iIndexOf >= 0 ? transliteratorArr3[i].toRules(z) : transliteratorArr3[i].baseToRules(z);
            }
            _smartAppend(sb, '\n');
            sb.append(rules);
            _smartAppend(sb, ';');
            i++;
        }
    }

    public CompoundTransliterator(List<Transliterator> list) {
        this(list, 0);
    }

    public CompoundTransliterator(String str, UnicodeFilter unicodeFilter, Transliterator[] transliteratorArr, int i) {
        super(str, unicodeFilter);
        this.trans = transliteratorArr;
        this.numAnonymousRBTs = i;
    }
}
