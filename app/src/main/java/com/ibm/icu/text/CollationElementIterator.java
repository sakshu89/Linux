package com.ibm.icu.text;

import com.ibm.icu.impl.CharacterIteratorWrapper;
import com.ibm.icu.impl.coll.Collation;
import com.ibm.icu.impl.coll.CollationData;
import com.ibm.icu.impl.coll.CollationIterator;
import com.ibm.icu.impl.coll.CollationSettings;
import com.ibm.icu.impl.coll.ContractionsAndExpansions;
import com.ibm.icu.impl.coll.FCDIterCollationIterator;
import com.ibm.icu.impl.coll.FCDUTF16CollationIterator;
import com.ibm.icu.impl.coll.IterCollationIterator;
import com.ibm.icu.impl.coll.UTF16CollationIterator;
import com.ibm.icu.impl.coll.UVector32;
import defpackage.og;
import java.text.CharacterIterator;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class CollationElementIterator {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int IGNORABLE = 0;
    public static final int NULLORDER = -1;
    private byte dir_;
    private CollationIterator iter_;
    private UVector32 offsets_;
    private int otherHalf_;
    private RuleBasedCollator rbc_;
    private String string_;

    private CollationElementIterator(RuleBasedCollator ruleBasedCollator) {
        this.iter_ = null;
        this.rbc_ = ruleBasedCollator;
        this.otherHalf_ = 0;
        this.dir_ = (byte) 0;
        this.offsets_ = null;
    }

    public static /* bridge */ /* synthetic */ int b(int i, long j) {
        return getFirstHalf(j, i);
    }

    public static /* bridge */ /* synthetic */ int c(int i, long j) {
        return getSecondHalf(j, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean ceNeedsTwoParts(long j) {
        return (j & 281470698455103L) != 0;
    }

    public static final Map<Integer, Integer> computeMaxExpansions(CollationData collationData) {
        HashMap map = new HashMap();
        new ContractionsAndExpansions(null, null, new MaxExpSink(map), true).forData(collationData);
        return map;
    }

    private static final int getFirstHalf(long j, int i) {
        return (((int) j) & (-65536)) | ((i >> 16) & 65280) | ((i >> 8) & 255);
    }

    public static int getMaxExpansion(Map<Integer, Integer> map, int i) {
        Integer num;
        if (i == 0) {
            return 1;
        }
        if (map == null || (num = map.get(Integer.valueOf(i))) == null) {
            return (i & 192) == 192 ? 2 : 1;
        }
        return num.intValue();
    }

    private static final int getSecondHalf(long j, int i) {
        return (((int) j) << 16) | ((i >> 8) & 65280) | (i & 63);
    }

    private byte normalizeDir() {
        byte b = this.dir_;
        if (b == 1) {
            return (byte) 0;
        }
        return b;
    }

    public static final int primaryOrder(int i) {
        return (i >>> 16) & DateTimePatternGenerator.MATCH_ALL_FIELDS_LENGTH;
    }

    public static final int secondaryOrder(int i) {
        return (i >>> 8) & 255;
    }

    public static final int tertiaryOrder(int i) {
        return i & 255;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof CollationElementIterator) {
            CollationElementIterator collationElementIterator = (CollationElementIterator) obj;
            if (this.rbc_.equals(collationElementIterator.rbc_) && this.otherHalf_ == collationElementIterator.otherHalf_ && normalizeDir() == collationElementIterator.normalizeDir() && this.string_.equals(collationElementIterator.string_) && this.iter_.equals(collationElementIterator.iter_)) {
                return true;
            }
        }
        return false;
    }

    public int getOffset() {
        UVector32 uVector32;
        if (this.dir_ >= 0 || (uVector32 = this.offsets_) == null || uVector32.isEmpty()) {
            return this.iter_.getOffset();
        }
        int cEsLength = this.iter_.getCEsLength();
        if (this.otherHalf_ != 0) {
            cEsLength++;
        }
        return this.offsets_.elementAti(cEsLength);
    }

    @Deprecated
    public RuleBasedCollator getRuleBasedCollator() {
        return this.rbc_;
    }

    public int hashCode() {
        return 42;
    }

    public int next() {
        byte b = this.dir_;
        if (b > 1) {
            int i = this.otherHalf_;
            if (i != 0) {
                this.otherHalf_ = 0;
                return i;
            }
        } else {
            if (b != 1 && b != 0) {
                og.n("Illegal change of direction");
                return 0;
            }
            this.dir_ = (byte) 2;
        }
        this.iter_.clearCEsIfNoneRemaining();
        long jNextCE = this.iter_.nextCE();
        if (jNextCE == Collation.NO_CE) {
            return -1;
        }
        long j = jNextCE >>> 32;
        int i2 = (int) jNextCE;
        int firstHalf = getFirstHalf(j, i2);
        int secondHalf = getSecondHalf(j, i2);
        if (secondHalf != 0) {
            this.otherHalf_ = secondHalf | 192;
        }
        return firstHalf;
    }

    public int previous() {
        byte b = this.dir_;
        if (b < 0) {
            int i = this.otherHalf_;
            if (i != 0) {
                this.otherHalf_ = 0;
                return i;
            }
        } else if (b == 0) {
            this.iter_.resetToOffset(this.string_.length());
            this.dir_ = (byte) -1;
        } else {
            if (b != 1) {
                og.n("Illegal change of direction");
                return 0;
            }
            this.dir_ = (byte) -1;
        }
        if (this.offsets_ == null) {
            this.offsets_ = new UVector32();
        }
        int offset = this.iter_.getCEsLength() == 0 ? this.iter_.getOffset() : 0;
        long jPreviousCE = this.iter_.previousCE(this.offsets_);
        if (jPreviousCE == Collation.NO_CE) {
            return -1;
        }
        long j = jPreviousCE >>> 32;
        int i2 = (int) jPreviousCE;
        int firstHalf = getFirstHalf(j, i2);
        int secondHalf = getSecondHalf(j, i2);
        if (secondHalf == 0) {
            return firstHalf;
        }
        if (this.offsets_.isEmpty()) {
            this.offsets_.addElement(this.iter_.getOffset());
            this.offsets_.addElement(offset);
        }
        this.otherHalf_ = firstHalf;
        return secondHalf | 192;
    }

    public void reset() {
        this.iter_.resetToOffset(0);
        this.otherHalf_ = 0;
        this.dir_ = (byte) 0;
    }

    public void setOffset(int i) {
        int offset;
        if (i > 0 && i < this.string_.length()) {
            int i2 = i;
            do {
                char cCharAt = this.string_.charAt(i2);
                if (!this.rbc_.isUnsafe(cCharAt) || (Character.isHighSurrogate(cCharAt) && !this.rbc_.isUnsafe(this.string_.codePointAt(i2)))) {
                    break;
                } else {
                    i2--;
                }
            } while (i2 > 0);
            if (i2 < i) {
                do {
                    this.iter_.resetToOffset(i2);
                    do {
                        this.iter_.nextCE();
                        offset = this.iter_.getOffset();
                    } while (offset == i2);
                    if (offset <= i) {
                        i2 = offset;
                    }
                } while (offset < i);
                i = i2;
            }
        }
        this.iter_.resetToOffset(i);
        this.otherHalf_ = 0;
        this.dir_ = (byte) 1;
    }

    public void setText(UCharacterIterator uCharacterIterator) {
        this.string_ = uCharacterIterator.getText();
        try {
            UCharacterIterator uCharacterIteratorMo2clone = uCharacterIterator.mo2clone();
            uCharacterIteratorMo2clone.setToStart();
            boolean zIsNumeric = ((CollationSettings) this.rbc_.settings.readOnly()).isNumeric();
            boolean zDontCheckFCD = ((CollationSettings) this.rbc_.settings.readOnly()).dontCheckFCD();
            RuleBasedCollator ruleBasedCollator = this.rbc_;
            this.iter_ = zDontCheckFCD ? new IterCollationIterator(ruleBasedCollator.data, zIsNumeric, uCharacterIteratorMo2clone) : new FCDIterCollationIterator(ruleBasedCollator.data, zIsNumeric, uCharacterIteratorMo2clone, 0);
            this.otherHalf_ = 0;
            this.dir_ = (byte) 0;
        } catch (CloneNotSupportedException unused) {
            setText(uCharacterIterator.getText());
        }
    }

    public CollationElementIterator(String str, RuleBasedCollator ruleBasedCollator) {
        this(ruleBasedCollator);
        setText(str);
    }

    public CollationElementIterator(CharacterIterator characterIterator, RuleBasedCollator ruleBasedCollator) {
        this(ruleBasedCollator);
        setText(characterIterator);
    }

    public CollationElementIterator(UCharacterIterator uCharacterIterator, RuleBasedCollator ruleBasedCollator) {
        this(ruleBasedCollator);
        setText(uCharacterIterator);
    }

    public int getMaxExpansion(int i) {
        return getMaxExpansion(this.rbc_.tailoring.maxExpansions, i);
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class MaxExpSink implements ContractionsAndExpansions.CESink {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private Map<Integer, Integer> maxExpansions;

        public MaxExpSink(Map<Integer, Integer> map) {
            this.maxExpansions = map;
        }

        @Override // com.ibm.icu.impl.coll.ContractionsAndExpansions.CESink
        public void handleExpansion(long[] jArr, int i, int i2) {
            if (i2 <= 1) {
                return;
            }
            int i3 = 0;
            for (int i4 = 0; i4 < i2; i4++) {
                i3 += CollationElementIterator.ceNeedsTwoParts(jArr[i + i4]) ? 2 : 1;
            }
            long j = jArr[(i + i2) - 1];
            long j2 = j >>> 32;
            int i5 = (int) j;
            int iC = CollationElementIterator.c(i5, j2);
            int iB = iC == 0 ? CollationElementIterator.b(i5, j2) : iC | 192;
            Integer num = this.maxExpansions.get(Integer.valueOf(iB));
            if (num == null || i3 > num.intValue()) {
                this.maxExpansions.put(Integer.valueOf(iB), Integer.valueOf(i3));
            }
        }

        @Override // com.ibm.icu.impl.coll.ContractionsAndExpansions.CESink
        public void handleCE(long j) {
        }
    }

    public void setText(String str) {
        CollationIterator fCDUTF16CollationIterator;
        this.string_ = str;
        boolean zIsNumeric = ((CollationSettings) this.rbc_.settings.readOnly()).isNumeric();
        boolean zDontCheckFCD = ((CollationSettings) this.rbc_.settings.readOnly()).dontCheckFCD();
        RuleBasedCollator ruleBasedCollator = this.rbc_;
        if (zDontCheckFCD) {
            fCDUTF16CollationIterator = new UTF16CollationIterator(ruleBasedCollator.data, zIsNumeric, this.string_, 0);
        } else {
            fCDUTF16CollationIterator = new FCDUTF16CollationIterator(ruleBasedCollator.data, zIsNumeric, this.string_, 0);
        }
        this.iter_ = fCDUTF16CollationIterator;
        this.otherHalf_ = 0;
        this.dir_ = (byte) 0;
    }

    public void setText(CharacterIterator characterIterator) {
        CollationIterator fCDIterCollationIterator;
        CharacterIteratorWrapper characterIteratorWrapper = new CharacterIteratorWrapper(characterIterator);
        characterIteratorWrapper.setToStart();
        this.string_ = characterIteratorWrapper.getText();
        boolean zIsNumeric = ((CollationSettings) this.rbc_.settings.readOnly()).isNumeric();
        boolean zDontCheckFCD = ((CollationSettings) this.rbc_.settings.readOnly()).dontCheckFCD();
        RuleBasedCollator ruleBasedCollator = this.rbc_;
        if (zDontCheckFCD) {
            fCDIterCollationIterator = new IterCollationIterator(ruleBasedCollator.data, zIsNumeric, characterIteratorWrapper);
        } else {
            fCDIterCollationIterator = new FCDIterCollationIterator(ruleBasedCollator.data, zIsNumeric, characterIteratorWrapper, 0);
        }
        this.iter_ = fCDIterCollationIterator;
        this.otherHalf_ = 0;
        this.dir_ = (byte) 0;
    }
}
