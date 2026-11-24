package com.ibm.icu.text;

import com.ibm.icu.impl.coll.Collation;
import com.ibm.icu.util.ULocale;
import defpackage.cq;
import defpackage.dk0;
import defpackage.og;
import java.text.CharacterIterator;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class StringSearch extends SearchIterator {
    private static int CE_LEVEL2_BASE = 5;
    private static int CE_LEVEL3_BASE = 327680;
    private static final int CE_MATCH = -1;
    private static final int CE_NO_MATCH = 0;
    private static final int CE_SKIP_PATN = 2;
    private static final int CE_SKIP_TARG = 1;
    private static final int INITIAL_ARRAY_SIZE_ = 256;
    private static final int PRIMARYORDERMASK = -65536;
    private static final int SECONDARYORDERMASK = 65280;
    private static final int TERTIARYORDERMASK = 255;
    int ceMask_;
    private RuleBasedCollator collator_;
    private Normalizer2 nfd_;
    private Pattern pattern_;
    private int strength_;
    private CollationElementIterator textIter_;
    private CollationPCE textProcessedIter_;
    private boolean toShift_;
    private CollationElementIterator utilIter_;
    int variableTop_;

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class CEBuffer {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        static final int CEBUFFER_EXTRA = 32;
        static final int MAX_TARGET_IGNORABLES_PER_PAT_JAMO_L = 8;
        static final int MAX_TARGET_IGNORABLES_PER_PAT_OTHER = 3;
        int bufSize_;
        CEI[] buf_;
        int firstIx_;
        int limitIx_;
        StringSearch strSearch_;

        public CEBuffer(StringSearch stringSearch) {
            String str;
            this.strSearch_ = stringSearch;
            this.bufSize_ = stringSearch.pattern_.PCELength_ + 32;
            if (stringSearch.search_.elementComparisonType_ != SearchIterator.ElementComparisonType.STANDARD_ELEMENT_COMPARISON && (str = stringSearch.pattern_.text_) != null) {
                for (int i = 0; i < str.length(); i++) {
                    boolean zMIGHT_BE_JAMO_L = MIGHT_BE_JAMO_L(str.charAt(i));
                    int i2 = this.bufSize_;
                    if (zMIGHT_BE_JAMO_L) {
                        this.bufSize_ = i2 + 8;
                    } else {
                        this.bufSize_ = i2 + 3;
                    }
                }
            }
            this.firstIx_ = 0;
            this.limitIx_ = 0;
            if (stringSearch.initTextProcessedIter()) {
                this.buf_ = new CEI[this.bufSize_];
            }
        }

        public static boolean MIGHT_BE_JAMO_L(char c) {
            if (c >= 4352 && c <= 4446) {
                return true;
            }
            if (c < 12593 || c > 12622) {
                return c >= 12645 && c <= 12678;
            }
            return true;
        }

        public CEI get(int i) {
            int i2 = this.bufSize_;
            int i3 = i % i2;
            int i4 = this.firstIx_;
            if (i >= i4 && i < this.limitIx_) {
                return this.buf_[i3];
            }
            int i5 = this.limitIx_;
            if (i != i5) {
                return null;
            }
            int i6 = i5 + 1;
            this.limitIx_ = i6;
            if (i6 - i4 >= i2) {
                this.firstIx_ = i4 + 1;
            }
            CollationPCE.Range range = new CollationPCE.Range();
            CEI[] ceiArr = this.buf_;
            if (ceiArr[i3] == null) {
                ceiArr[i3] = new CEI(0);
            }
            this.buf_[i3].ce_ = this.strSearch_.textProcessedIter_.nextProcessed(range);
            CEI cei = this.buf_[i3];
            cei.lowIndex_ = range.ixLow_;
            cei.highIndex_ = range.ixHigh_;
            return cei;
        }

        public CEI getPrevious(int i) {
            int i2 = this.bufSize_;
            int i3 = i % i2;
            int i4 = this.firstIx_;
            if (i >= i4 && i < this.limitIx_) {
                return this.buf_[i3];
            }
            int i5 = this.limitIx_;
            if (i != i5) {
                return null;
            }
            int i6 = i5 + 1;
            this.limitIx_ = i6;
            if (i6 - i4 >= i2) {
                this.firstIx_ = i4 + 1;
            }
            CollationPCE.Range range = new CollationPCE.Range();
            CEI[] ceiArr = this.buf_;
            if (ceiArr[i3] == null) {
                ceiArr[i3] = new CEI(0);
            }
            this.buf_[i3].ce_ = this.strSearch_.textProcessedIter_.previousProcessed(range);
            CEI cei = this.buf_[i3];
            cei.lowIndex_ = range.ixLow_;
            cei.highIndex_ = range.ixHigh_;
            return cei;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class Pattern {
        int[] CE_;
        long[] PCE_;
        String text_;
        int PCELength_ = 0;
        int CELength_ = 0;

        public Pattern(String str) {
            this.text_ = str;
        }
    }

    public StringSearch(String str, CharacterIterator characterIterator, RuleBasedCollator ruleBasedCollator, BreakIterator breakIterator) {
        super(characterIterator, breakIterator);
        if (ruleBasedCollator.getNumericCollation()) {
            dk0.r("Numeric collation is not supported by StringSearch");
            throw null;
        }
        this.collator_ = ruleBasedCollator;
        int strength = ruleBasedCollator.getStrength();
        this.strength_ = strength;
        this.ceMask_ = getMask(strength);
        this.toShift_ = ruleBasedCollator.isAlternateHandlingShifted();
        this.variableTop_ = ruleBasedCollator.getVariableTop();
        this.nfd_ = Normalizer2.getNFDInstance();
        this.pattern_ = new Pattern(str);
        this.search_.setMatchedLength(0);
        this.search_.matchedIndex_ = -1;
        this.utilIter_ = null;
        this.textIter_ = new CollationElementIterator(characterIterator, ruleBasedCollator);
        this.textProcessedIter_ = null;
        ULocale locale = ruleBasedCollator.getLocale(ULocale.VALID_LOCALE);
        this.search_.internalBreakIter_ = BreakIterator.getCharacterInstance(locale == null ? ULocale.ROOT : locale);
        this.search_.internalBreakIter_.setText((CharacterIterator) characterIterator.clone());
        initialize();
    }

    private static int[] addToIntArray(int[] iArr, int i, int i2, int i3) {
        if (i >= iArr.length) {
            int[] iArr2 = new int[i3 + i];
            System.arraycopy(iArr, 0, iArr2, 0, i);
            iArr = iArr2;
        }
        iArr[i] = i2;
        return iArr;
    }

    private static long[] addToLongArray(long[] jArr, int i, long j, int i2) {
        if (i >= jArr.length) {
            long[] jArr2 = new long[i2 + i];
            System.arraycopy(jArr, 0, jArr2, 0, i);
            jArr = jArr2;
        }
        jArr[i] = j;
        return jArr;
    }

    private boolean checkIdentical(int i, int i2) {
        if (this.strength_ != 15) {
            return true;
        }
        String string = getString(this.targetText, i, i2 - i);
        Normalizer.Mode mode = Normalizer.NFD;
        Normalizer.QuickCheckResult quickCheckResultQuickCheck = Normalizer.quickCheck(string, mode, 0);
        Normalizer.QuickCheckResult quickCheckResult = Normalizer.NO;
        if (quickCheckResultQuickCheck == quickCheckResult) {
            string = Normalizer.decompose(string, false);
        }
        String strDecompose = this.pattern_.text_;
        if (Normalizer.quickCheck(strDecompose, mode, 0) == quickCheckResult) {
            strDecompose = Normalizer.decompose(strDecompose, false);
        }
        return string.equals(strDecompose);
    }

    private static int codePointAt(CharacterIterator characterIterator, int i) {
        int index = characterIterator.getIndex();
        char index2 = characterIterator.setIndex(i);
        boolean zIsHighSurrogate = Character.isHighSurrogate(index2);
        int codePoint = index2;
        if (zIsHighSurrogate) {
            char next = characterIterator.next();
            codePoint = index2;
            if (Character.isLowSurrogate(next)) {
                codePoint = Character.toCodePoint(index2, next);
            }
        }
        characterIterator.setIndex(index);
        return codePoint;
    }

    private static int codePointBefore(CharacterIterator characterIterator, int i) {
        int index = characterIterator.getIndex();
        characterIterator.setIndex(i);
        char cPrevious = characterIterator.previous();
        boolean zIsLowSurrogate = Character.isLowSurrogate(cPrevious);
        int codePoint = cPrevious;
        if (zIsLowSurrogate) {
            char cPrevious2 = characterIterator.previous();
            codePoint = cPrevious;
            if (Character.isHighSurrogate(cPrevious2)) {
                codePoint = Character.toCodePoint(cPrevious2, cPrevious);
            }
        }
        characterIterator.setIndex(index);
        return codePoint;
    }

    private static int compareCE64s(long j, long j2, SearchIterator.ElementComparisonType elementComparisonType) {
        if (j == j2) {
            return -1;
        }
        if (elementComparisonType == SearchIterator.ElementComparisonType.STANDARD_ELEMENT_COMPARISON) {
            return 0;
        }
        long j3 = j >>> 32;
        long j4 = j2 >>> 32;
        int i = (int) (j3 & Collation.MAX_PRIMARY);
        int i2 = (int) (j4 & Collation.MAX_PRIMARY);
        if (i != i2) {
            if (i == 0) {
                return 1;
            }
            return (i2 == 0 && elementComparisonType == SearchIterator.ElementComparisonType.ANY_BASE_WEIGHT_IS_WILDCARD) ? 2 : 0;
        }
        int i3 = (int) (j3 & 65535);
        int i4 = (int) (j4 & 65535);
        if (i3 == i4) {
            int i5 = (int) (j & Collation.MAX_PRIMARY);
            int i6 = (int) (j2 & Collation.MAX_PRIMARY);
            return (i5 == i6 || i6 == CE_LEVEL3_BASE || (elementComparisonType == SearchIterator.ElementComparisonType.ANY_BASE_WEIGHT_IS_WILDCARD && i5 == CE_LEVEL3_BASE)) ? -1 : 0;
        }
        if (i3 == 0) {
            return 1;
        }
        if (i4 == 0 && elementComparisonType == SearchIterator.ElementComparisonType.ANY_BASE_WEIGHT_IS_WILDCARD) {
            return 2;
        }
        return (i4 == CE_LEVEL2_BASE || (elementComparisonType == SearchIterator.ElementComparisonType.ANY_BASE_WEIGHT_IS_WILDCARD && i3 == CE_LEVEL2_BASE)) ? -1 : 0;
    }

    private int getCE(int i) {
        int i2 = i & this.ceMask_;
        if (this.toShift_) {
            if (this.variableTop_ > i2) {
                if (this.strength_ >= 3) {
                    return PRIMARYORDERMASK & i2;
                }
                return 0;
            }
        } else if (this.strength_ >= 3 && i2 == 0) {
            return DateTimePatternGenerator.MATCH_ALL_FIELDS_LENGTH;
        }
        return i2;
    }

    private static int getMask(int i) {
        if (i != 0) {
            return i != 1 ? -1 : -256;
        }
        return PRIMARYORDERMASK;
    }

    private static final String getString(CharacterIterator characterIterator, int i, int i2) {
        StringBuilder sb = new StringBuilder(i2);
        int index = characterIterator.getIndex();
        characterIterator.setIndex(i);
        for (int i3 = 0; i3 < i2; i3++) {
            sb.append(characterIterator.current());
            characterIterator.next();
        }
        characterIterator.setIndex(index);
        return sb.toString();
    }

    private boolean handleNextCanonical() {
        return handleNextCommonImpl();
    }

    private boolean handleNextCommonImpl() {
        int offset = this.textIter_.getOffset();
        Match match = new Match(0);
        if (!search(offset, match)) {
            setMatchNotFound();
            return false;
        }
        SearchIterator.Search search = this.search_;
        int i = match.start_;
        search.matchedIndex_ = i;
        search.setMatchedLength(match.limit_ - i);
        return true;
    }

    private boolean handleNextExact() {
        return handleNextCommonImpl();
    }

    private boolean handlePreviousCanonical() {
        return handlePreviousCommonImpl();
    }

    private boolean handlePreviousCommonImpl() {
        int offset;
        SearchIterator.Search search = this.search_;
        int i = 0;
        if (search.isOverlap_) {
            int i2 = search.matchedIndex_;
            if (i2 != -1) {
                offset = (i2 + search.matchedLength()) - 1;
            } else {
                initializePatternPCETable();
                if (!initTextProcessedIter()) {
                    setMatchNotFound();
                    return false;
                }
                for (int i3 = 0; i3 < this.pattern_.PCELength_ - 1 && this.textProcessedIter_.nextProcessed(null) != -1; i3++) {
                }
                offset = this.textIter_.getOffset();
            }
        } else {
            offset = this.textIter_.getOffset();
        }
        Match match = new Match(i);
        if (!searchBackwards(offset, match)) {
            setMatchNotFound();
            return false;
        }
        SearchIterator.Search search2 = this.search_;
        int i4 = match.start_;
        search2.matchedIndex_ = i4;
        search2.setMatchedLength(match.limit_ - i4);
        return true;
    }

    private boolean handlePreviousExact() {
        return handlePreviousCommonImpl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean initTextProcessedIter() {
        CollationPCE collationPCE = this.textProcessedIter_;
        CollationElementIterator collationElementIterator = this.textIter_;
        if (collationPCE == null) {
            this.textProcessedIter_ = new CollationPCE(collationElementIterator);
            return true;
        }
        collationPCE.init(collationElementIterator);
        return true;
    }

    private void initialize() {
        initializePattern();
    }

    private int initializePattern() {
        this.pattern_.PCE_ = null;
        return initializePatternCETable();
    }

    private int initializePatternCETable() {
        int[] iArrAddToIntArray = new int[256];
        int length = this.pattern_.text_.length();
        CollationElementIterator collationElementIterator = this.utilIter_;
        Pattern pattern = this.pattern_;
        if (collationElementIterator == null) {
            collationElementIterator = new CollationElementIterator(pattern.text_, this.collator_);
            this.utilIter_ = collationElementIterator;
        } else {
            collationElementIterator.setText(pattern.text_);
        }
        int i = 0;
        int maxExpansion = 0;
        while (true) {
            int next = collationElementIterator.next();
            if (next == -1) {
                int[] iArrAddToIntArray2 = addToIntArray(iArrAddToIntArray, i, 0, 1);
                Pattern pattern2 = this.pattern_;
                pattern2.CE_ = iArrAddToIntArray2;
                pattern2.CELength_ = i;
                return maxExpansion;
            }
            int ce = getCE(next);
            if (ce != 0) {
                iArrAddToIntArray = addToIntArray(iArrAddToIntArray, i, ce, (length - collationElementIterator.getOffset()) + 1);
                i++;
            }
            maxExpansion += collationElementIterator.getMaxExpansion(next) - 1;
        }
    }

    private int initializePatternPCETable() {
        long[] jArrAddToLongArray = new long[256];
        int length = this.pattern_.text_.length();
        CollationElementIterator collationElementIterator = this.utilIter_;
        Pattern pattern = this.pattern_;
        if (collationElementIterator == null) {
            collationElementIterator = new CollationElementIterator(pattern.text_, this.collator_);
            this.utilIter_ = collationElementIterator;
        } else {
            collationElementIterator.setText(pattern.text_);
        }
        CollationPCE collationPCE = new CollationPCE(collationElementIterator);
        int i = 0;
        while (true) {
            long jNextProcessed = collationPCE.nextProcessed(null);
            if (jNextProcessed == -1) {
                long[] jArrAddToLongArray2 = addToLongArray(jArrAddToLongArray, i, 0L, 1);
                Pattern pattern2 = this.pattern_;
                pattern2.PCE_ = jArrAddToLongArray2;
                pattern2.PCELength_ = i;
                return 0;
            }
            jArrAddToLongArray = addToLongArray(jArrAddToLongArray, i, jNextProcessed, (length - collationElementIterator.getOffset()) + 1);
            i++;
        }
    }

    private boolean isBreakBoundary(int i) {
        BreakIterator breakIteratorBreakIter = this.search_.breakIter();
        if (breakIteratorBreakIter == null) {
            breakIteratorBreakIter = this.search_.internalBreakIter_;
        }
        return breakIteratorBreakIter != null && breakIteratorBreakIter.isBoundary(i);
    }

    private static final boolean isOutOfBounds(int i, int i2, int i3) {
        return i3 < i || i3 > i2;
    }

    private int nextBoundaryAfter(int i) {
        BreakIterator breakIteratorBreakIter = this.search_.breakIter();
        if (breakIteratorBreakIter == null) {
            breakIteratorBreakIter = this.search_.internalBreakIter_;
        }
        return breakIteratorBreakIter != null ? breakIteratorBreakIter.following(i) : i;
    }

    /* JADX WARN: Code duplicated, block: B:89:0x0154  */
    private boolean search(int i, Match match) {
        boolean z;
        long j;
        CEBuffer cEBuffer;
        CEI cei;
        int i2;
        if (this.pattern_.CELength_ == 0 || i < this.search_.beginIndex() || i > this.search_.endIndex()) {
            og.e(this.search_.endIndex(), cq.p("search(", i, ", m) - expected position to be between ", this.search_.beginIndex(), " and "));
            return false;
        }
        if (this.pattern_.PCE_ == null) {
            initializePatternPCETable();
        }
        this.textIter_.setOffset(i);
        CEBuffer cEBuffer2 = new CEBuffer(this);
        CEI cei2 = null;
        int i3 = 0;
        int i4 = -1;
        int i5 = -1;
        while (true) {
            CEI cei3 = cEBuffer2.get(i3);
            if (cei3 == null) {
                og.q(cq.h("CEBuffer.get(", i3, ") returned null."));
                return false;
            }
            int i6 = 0;
            int i7 = 0;
            long j2 = 0;
            while (true) {
                Pattern pattern = this.pattern_;
                if (i6 >= pattern.PCELength_) {
                    z = true;
                    break;
                }
                j2 = pattern.PCE_[i6];
                cei2 = cEBuffer2.get(i3 + i6 + i7);
                int iCompareCE64s = compareCE64s(cei2.ce_, j2, this.search_.elementComparisonType_);
                if (iCompareCE64s == 0) {
                    z = false;
                    break;
                }
                if (iCompareCE64s > 0) {
                    if (iCompareCE64s == 1) {
                        i6--;
                        i7++;
                    } else {
                        i7--;
                    }
                }
                i6++;
            }
            int i8 = i7 + this.pattern_.PCELength_;
            if (z) {
                j = -1;
            } else {
                if (cei2 != null) {
                    j = -1;
                    if (cei2.ce_ != -1) {
                    }
                    i3++;
                    cEBuffer2 = cEBuffer;
                }
                cEBuffer = cEBuffer2;
                i3++;
                cEBuffer2 = cEBuffer;
            }
            if (!z) {
                break;
            }
            int i9 = i3 + i8;
            CEI cei4 = cEBuffer2.get(i9 - 1);
            int i10 = cei3.lowIndex_;
            int i11 = cei4.lowIndex_;
            if (this.search_.elementComparisonType_ != SearchIterator.ElementComparisonType.STANDARD_ELEMENT_COMPARISON) {
                while (true) {
                    cei = cEBuffer2.get(i3 + i8);
                    i2 = cei.lowIndex_;
                    int i12 = i8;
                    long j3 = cei.ce_;
                    if (j3 != j) {
                        if (((j3 >>> 32) & Collation.MAX_PRIMARY) != 0) {
                            cEBuffer = cEBuffer2;
                            if (i2 != cei.highIndex_) {
                                break;
                            }
                            break;
                        }
                        cEBuffer = cEBuffer2;
                        int iCompareCE64s2 = compareCE64s(j3, j2, this.search_.elementComparisonType_);
                        if (iCompareCE64s2 != 0 && iCompareCE64s2 != 2) {
                            i8 = i12 + 1;
                            cEBuffer2 = cEBuffer;
                        }
                        z = false;
                        break;
                    }
                    cEBuffer = cEBuffer2;
                    break;
                }
            }
            cei = cEBuffer2.get(i9);
            i2 = cei.lowIndex_;
            if (i2 == cei.highIndex_ && cei.ce_ != j) {
                cEBuffer = cEBuffer2;
                z = false;
                break;
            }
            cEBuffer = cEBuffer2;
            break;
            if (!isBreakBoundary(i10)) {
                z = false;
            }
            if (i10 == cei3.highIndex_) {
                z = false;
            }
            boolean z2 = this.breakIterator == null && ((cei.ce_ >>> 32) & Collation.MAX_PRIMARY) != 0 && i2 >= cei4.highIndex_ && cei.highIndex_ > i2 && (this.nfd_.hasBoundaryBefore(codePointAt(this.targetText, i2)) || this.nfd_.hasBoundaryAfter(codePointBefore(this.targetText, i2)));
            if (i11 >= i2) {
                i5 = i2;
            } else if (i11 == cei4.highIndex_ && isBreakBoundary(i11)) {
                i5 = i11;
            } else {
                int iNextBoundaryAfter = nextBoundaryAfter(i11);
                if (iNextBoundaryAfter < cei4.highIndex_ || (z2 && iNextBoundaryAfter >= i2)) {
                    i5 = i2;
                } else {
                    i5 = iNextBoundaryAfter;
                }
            }
            if (!z2) {
                if (i5 > i2) {
                    z = false;
                }
                if (!isBreakBoundary(i5)) {
                    z = false;
                }
            }
            if (!checkIdentical(i10, i5)) {
                z = false;
            }
            i4 = i10;
            if (z) {
                break;
            }
            i3++;
            cEBuffer2 = cEBuffer;
        }
        if (!z) {
            i4 = -1;
            i5 = -1;
        }
        if (match != null) {
            match.start_ = i4;
            match.limit_ = i5;
        }
        return z;
    }

    private boolean searchBackwards(int i, Match match) {
        int i2;
        int i3;
        int i4;
        boolean z;
        int i5;
        boolean z2;
        int i6;
        int iNextBoundaryAfter;
        if (this.pattern_.CELength_ == 0 || i < this.search_.beginIndex() || i > this.search_.endIndex()) {
            og.e(this.search_.endIndex(), cq.p("searchBackwards(", i, ", m) - expected position to be between ", this.search_.beginIndex(), " and "));
            return false;
        }
        if (this.pattern_.PCE_ == null) {
            initializePatternPCETable();
        }
        CEBuffer cEBuffer = new CEBuffer(this);
        if (i < this.search_.endIndex()) {
            this.textIter_.setOffset(this.search_.internalBreakIter_.following(i));
            i2 = 0;
            while (cEBuffer.getPrevious(i2).lowIndex_ >= i) {
                i2++;
            }
        } else {
            this.textIter_.setOffset(i);
            i2 = 0;
        }
        CEI previous = null;
        int i7 = -1;
        int i8 = -1;
        while (true) {
            CEI previous2 = cEBuffer.getPrevious(i2);
            if (previous2 == null) {
                og.q(cq.h("CEBuffer.getPrevious(", i2, ") returned null."));
                return false;
            }
            int i9 = 1;
            int i10 = this.pattern_.PCELength_ - 1;
            int i11 = 0;
            while (true) {
                if (i10 < 0) {
                    i3 = i2;
                    i4 = i11;
                    z = false;
                    i5 = -1;
                    z2 = true;
                    break;
                }
                Pattern pattern = this.pattern_;
                i3 = i2;
                z = false;
                long j = pattern.PCE_[i10];
                previous = cEBuffer.getPrevious((((i3 + pattern.PCELength_) - i9) - i10) + i11);
                i4 = i11;
                i5 = -1;
                int iCompareCE64s = compareCE64s(previous.ce_, j, this.search_.elementComparisonType_);
                if (iCompareCE64s == 0) {
                    z2 = false;
                    break;
                }
                if (iCompareCE64s <= 0) {
                    i11 = i4;
                } else if (iCompareCE64s == 1) {
                    i10++;
                    i11 = i4 + 1;
                } else {
                    i11 = i4 - 1;
                }
                i10--;
                i2 = i3;
                i9 = 1;
            }
            if (z2 || (previous != null && previous.ce_ == -1)) {
                if (!z2) {
                    break;
                }
                boolean z3 = true;
                CEI previous3 = cEBuffer.getPrevious(((i3 + this.pattern_.PCELength_) - 1) + i4);
                int i12 = previous3.lowIndex_;
                if (!isBreakBoundary(i12)) {
                    z2 = z;
                }
                if (i12 == previous3.highIndex_) {
                    z2 = z;
                }
                int i13 = previous2.lowIndex_;
                if (i3 > 0) {
                    CEI previous4 = cEBuffer.getPrevious(i3 - 1);
                    int i14 = previous4.lowIndex_;
                    int i15 = previous4.highIndex_;
                    if (i14 == i15 && previous4.ce_ != -1) {
                        z2 = z;
                    }
                    if (this.breakIterator != null || ((previous4.ce_ >>> 32) & Collation.MAX_PRIMARY) == 0 || i14 < previous2.highIndex_ || i15 <= i14 || (!this.nfd_.hasBoundaryBefore(codePointAt(this.targetText, i14)) && !this.nfd_.hasBoundaryAfter(codePointBefore(this.targetText, i14)))) {
                        z3 = z;
                    }
                    if (i13 >= i14 || (iNextBoundaryAfter = nextBoundaryAfter(i13)) < previous2.highIndex_ || (z3 && iNextBoundaryAfter >= i14)) {
                        iNextBoundaryAfter = i14;
                    }
                    if (!z3) {
                        if (iNextBoundaryAfter > i14) {
                            z2 = z;
                        }
                        if (!isBreakBoundary(iNextBoundaryAfter)) {
                            z2 = z;
                        }
                    }
                } else {
                    iNextBoundaryAfter = nextBoundaryAfter(i13);
                    if (iNextBoundaryAfter <= 0 || i <= iNextBoundaryAfter) {
                        iNextBoundaryAfter = i;
                    }
                }
                if (!checkIdentical(i12, iNextBoundaryAfter)) {
                    z2 = z;
                }
                i7 = i12;
                i8 = iNextBoundaryAfter;
                if (z2) {
                    break;
                }
            }
            i2 = i3 + 1;
        }
        if (z2) {
            i6 = i7;
        } else {
            i6 = i5;
            i8 = i6;
        }
        if (match != null) {
            match.start_ = i6;
            match.limit_ = i8;
        }
        return z2;
    }

    public RuleBasedCollator getCollator() {
        return this.collator_;
    }

    @Override // com.ibm.icu.text.SearchIterator
    public int getIndex() {
        int offset = this.textIter_.getOffset();
        if (isOutOfBounds(this.search_.beginIndex(), this.search_.endIndex(), offset)) {
            return -1;
        }
        return offset;
    }

    public String getPattern() {
        return this.pattern_.text_;
    }

    @Override // com.ibm.icu.text.SearchIterator
    public int handleNext(int i) {
        int i2 = this.pattern_.CELength_;
        SearchIterator.Search search = this.search_;
        if (i2 == 0) {
            int i3 = search.matchedIndex_;
            search.matchedIndex_ = i3 == -1 ? getIndex() : i3 + 1;
            this.search_.setMatchedLength(0);
            this.textIter_.setOffset(this.search_.matchedIndex_);
            SearchIterator.Search search2 = this.search_;
            if (search2.matchedIndex_ == search2.endIndex()) {
                this.search_.matchedIndex_ = -1;
            }
            return -1;
        }
        if (search.matchedLength() <= 0) {
            this.search_.matchedIndex_ = i - 1;
        }
        this.textIter_.setOffset(i);
        if (this.search_.isCanonicalMatch_) {
            handleNextCanonical();
        } else {
            handleNextExact();
        }
        SearchIterator.Search search3 = this.search_;
        int i4 = search3.matchedIndex_;
        CollationElementIterator collationElementIterator = this.textIter_;
        if (i4 == -1) {
            collationElementIterator.setOffset(search3.endIndex());
        } else {
            collationElementIterator.setOffset(i4);
        }
        return this.search_.matchedIndex_;
    }

    @Override // com.ibm.icu.text.SearchIterator
    public int handlePrevious(int i) {
        if (this.pattern_.CELength_ == 0) {
            SearchIterator.Search search = this.search_;
            int index = search.matchedIndex_;
            if (index == -1) {
                index = getIndex();
            }
            search.matchedIndex_ = index;
            SearchIterator.Search search2 = this.search_;
            if (search2.matchedIndex_ == search2.beginIndex()) {
                setMatchNotFound();
            } else {
                SearchIterator.Search search3 = this.search_;
                int i2 = search3.matchedIndex_ - 1;
                search3.matchedIndex_ = i2;
                this.textIter_.setOffset(i2);
                this.search_.setMatchedLength(0);
            }
        } else {
            this.textIter_.setOffset(i);
            if (this.search_.isCanonicalMatch_) {
                handlePreviousCanonical();
            } else {
                handlePreviousExact();
            }
        }
        return this.search_.matchedIndex_;
    }

    public boolean isCanonical() {
        return this.search_.isCanonicalMatch_;
    }

    @Override // com.ibm.icu.text.SearchIterator
    public void reset() {
        int strength = this.collator_.getStrength();
        int i = this.strength_;
        boolean z = (i >= 3 || strength < 3) && (i < 3 || strength >= 3);
        int strength2 = this.collator_.getStrength();
        this.strength_ = strength2;
        int mask = getMask(strength2);
        if (this.ceMask_ != mask) {
            this.ceMask_ = mask;
            z = false;
        }
        boolean zIsAlternateHandlingShifted = this.collator_.isAlternateHandlingShifted();
        if (this.toShift_ != zIsAlternateHandlingShifted) {
            this.toShift_ = zIsAlternateHandlingShifted;
            z = false;
        }
        int variableTop = this.collator_.getVariableTop();
        if (this.variableTop_ != variableTop) {
            this.variableTop_ = variableTop;
            z = false;
        }
        if (!z) {
            initialize();
        }
        this.textIter_.setText(this.search_.text());
        this.search_.setMatchedLength(0);
        SearchIterator.Search search = this.search_;
        search.matchedIndex_ = -1;
        search.isOverlap_ = false;
        search.isCanonicalMatch_ = false;
        search.elementComparisonType_ = SearchIterator.ElementComparisonType.STANDARD_ELEMENT_COMPARISON;
        search.isForwardSearching_ = true;
        search.reset_ = true;
    }

    public void setCanonical(boolean z) {
        this.search_.isCanonicalMatch_ = z;
    }

    public void setCollator(RuleBasedCollator ruleBasedCollator) {
        if (ruleBasedCollator == null) {
            og.i("Collator can not be null");
            return;
        }
        this.collator_ = ruleBasedCollator;
        this.ceMask_ = getMask(ruleBasedCollator.getStrength());
        ULocale locale = ruleBasedCollator.getLocale(ULocale.VALID_LOCALE);
        SearchIterator.Search search = this.search_;
        if (locale == null) {
            locale = ULocale.ROOT;
        }
        search.internalBreakIter_ = BreakIterator.getCharacterInstance(locale);
        SearchIterator.Search search2 = this.search_;
        search2.internalBreakIter_.setText((CharacterIterator) search2.text().clone());
        this.toShift_ = ruleBasedCollator.isAlternateHandlingShifted();
        this.variableTop_ = ruleBasedCollator.getVariableTop();
        this.textIter_ = new CollationElementIterator(this.pattern_.text_, ruleBasedCollator);
        this.utilIter_ = new CollationElementIterator(this.pattern_.text_, ruleBasedCollator);
        initialize();
    }

    @Override // com.ibm.icu.text.SearchIterator
    public void setIndex(int i) {
        super.setIndex(i);
        this.textIter_.setOffset(i);
    }

    @Override // com.ibm.icu.text.SearchIterator
    @Deprecated
    public void setMatchNotFound() {
        super.setMatchNotFound();
        SearchIterator.Search search = this.search_;
        boolean z = search.isForwardSearching_;
        CollationElementIterator collationElementIterator = this.textIter_;
        if (z) {
            collationElementIterator.setOffset(search.text().getEndIndex());
        } else {
            collationElementIterator.setOffset(0);
        }
    }

    public void setPattern(String str) {
        if (str == null || str.length() <= 0) {
            og.i("Pattern to search for can not be null or of length 0");
        } else {
            this.pattern_.text_ = str;
            initialize();
        }
    }

    @Override // com.ibm.icu.text.SearchIterator
    public void setTarget(CharacterIterator characterIterator) {
        super.setTarget(characterIterator);
        this.textIter_.setText(characterIterator);
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class CollationPCE {
        private static final int BUFFER_GROW = 8;
        private static final int CONTINUATION_MARKER = 192;
        private static final int DEFAULT_BUFFER_SIZE = 16;
        private static final int PRIMARYORDERMASK = -65536;
        public static final long PROCESSED_NULLORDER = -1;
        private CollationElementIterator cei_;
        private boolean isShifted_;
        private PCEBuffer pceBuffer_ = new PCEBuffer(0);
        private int strength_;
        private boolean toShift_;
        private int variableTop_;

        /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
        public static final class Range {
            int ixHigh_;
            int ixLow_;
        }

        public CollationPCE(CollationElementIterator collationElementIterator) {
            init(collationElementIterator);
        }

        private void init(RuleBasedCollator ruleBasedCollator) {
            this.strength_ = ruleBasedCollator.getStrength();
            this.toShift_ = ruleBasedCollator.isAlternateHandlingShifted();
            this.isShifted_ = false;
            this.variableTop_ = ruleBasedCollator.getVariableTop();
        }

        private static boolean isContinuation(int i) {
            return (i & 192) == 192;
        }

        private long processCE(int i) {
            long jTertiaryOrder;
            long jSecondaryOrder;
            int i2 = this.strength_;
            long j = 0;
            if (i2 != 0) {
                jTertiaryOrder = i2 != 1 ? CollationElementIterator.tertiaryOrder(i) : 0L;
                jSecondaryOrder = CollationElementIterator.secondaryOrder(i);
            } else {
                jTertiaryOrder = 0;
                jSecondaryOrder = 0;
            }
            long jPrimaryOrder = CollationElementIterator.primaryOrder(i);
            if ((!this.toShift_ || this.variableTop_ <= i || jPrimaryOrder == 0) && !(this.isShifted_ && jPrimaryOrder == 0)) {
                j = this.strength_ >= 3 ? 65535L : 0L;
                this.isShifted_ = false;
                jPrimaryOrder = j;
                j = jPrimaryOrder;
            } else {
                if (jPrimaryOrder == 0) {
                    return 0L;
                }
                if (this.strength_ < 3) {
                    jPrimaryOrder = 0;
                }
                this.isShifted_ = true;
                jTertiaryOrder = 0;
                jSecondaryOrder = 0;
            }
            return (j << 48) | (jSecondaryOrder << 32) | (jTertiaryOrder << 16) | jPrimaryOrder;
        }

        public long nextProcessed(Range range) {
            int offset;
            int offset2;
            long jProcessCE;
            this.pceBuffer_.reset();
            do {
                offset = this.cei_.getOffset();
                int next = this.cei_.next();
                offset2 = this.cei_.getOffset();
                if (next == -1) {
                    jProcessCE = -1;
                    break;
                }
                jProcessCE = processCE(next);
            } while (jProcessCE == 0);
            if (range != null) {
                range.ixLow_ = offset;
                range.ixHigh_ = offset2;
            }
            return jProcessCE;
        }

        public long previousProcessed(Range range) {
            while (this.pceBuffer_.empty()) {
                RCEBuffer rCEBuffer = new RCEBuffer(0);
                while (true) {
                    int offset = this.cei_.getOffset();
                    int iPrevious = this.cei_.previous();
                    int offset2 = this.cei_.getOffset();
                    if (iPrevious != -1) {
                        rCEBuffer.put(iPrevious, offset2, offset);
                        if ((PRIMARYORDERMASK & iPrevious) != 0 && !isContinuation(iPrevious)) {
                            break;
                        }
                    } else {
                        if (!rCEBuffer.empty()) {
                            break;
                        }
                        break;
                    }
                }
                while (!rCEBuffer.empty()) {
                    RCEI rcei = rCEBuffer.get();
                    long jProcessCE = processCE(rcei.ce_);
                    if (jProcessCE != 0) {
                        this.pceBuffer_.put(jProcessCE, rcei.low_, rcei.high_);
                    }
                }
            }
            if (this.pceBuffer_.empty()) {
                if (range == null) {
                    return -1L;
                }
                range.ixLow_ = -1;
                range.ixHigh_ = -1;
                return -1L;
            }
            PCEI pcei = this.pceBuffer_.get();
            if (range != null) {
                range.ixLow_ = pcei.low_;
                range.ixHigh_ = pcei.high_;
            }
            return pcei.ce_;
        }

        /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
        public static final class PCEI {
            long ce_;
            int high_;
            int low_;

            public /* synthetic */ PCEI(int i) {
                this();
            }

            private PCEI() {
            }
        }

        /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
        public static final class RCEI {
            int ce_;
            int high_;
            int low_;

            public /* synthetic */ RCEI(int i) {
                this();
            }

            private RCEI() {
            }
        }

        /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
        public static final class PCEBuffer {
            private int bufferIndex_;
            private PCEI[] buffer_;

            private PCEBuffer() {
                this.buffer_ = new PCEI[16];
                this.bufferIndex_ = 0;
            }

            public boolean empty() {
                return this.bufferIndex_ <= 0;
            }

            public PCEI get() {
                int i = this.bufferIndex_;
                if (i <= 0) {
                    return null;
                }
                PCEI[] pceiArr = this.buffer_;
                int i2 = i - 1;
                this.bufferIndex_ = i2;
                return pceiArr[i2];
            }

            public void put(long j, int i, int i2) {
                int i3 = this.bufferIndex_;
                PCEI[] pceiArr = this.buffer_;
                int i4 = 0;
                if (i3 >= pceiArr.length) {
                    PCEI[] pceiArr2 = new PCEI[pceiArr.length + 8];
                    System.arraycopy(pceiArr, 0, pceiArr2, 0, pceiArr.length);
                    this.buffer_ = pceiArr2;
                }
                this.buffer_[this.bufferIndex_] = new PCEI(i4);
                PCEI[] pceiArr3 = this.buffer_;
                int i5 = this.bufferIndex_;
                PCEI pcei = pceiArr3[i5];
                pcei.ce_ = j;
                pcei.low_ = i;
                pcei.high_ = i2;
                this.bufferIndex_ = i5 + 1;
            }

            public void reset() {
                this.bufferIndex_ = 0;
            }

            public /* synthetic */ PCEBuffer(int i) {
                this();
            }
        }

        /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
        public static final class RCEBuffer {
            private int bufferIndex_;
            private RCEI[] buffer_;

            private RCEBuffer() {
                this.buffer_ = new RCEI[16];
                this.bufferIndex_ = 0;
            }

            public boolean empty() {
                return this.bufferIndex_ <= 0;
            }

            public RCEI get() {
                int i = this.bufferIndex_;
                if (i <= 0) {
                    return null;
                }
                RCEI[] rceiArr = this.buffer_;
                int i2 = i - 1;
                this.bufferIndex_ = i2;
                return rceiArr[i2];
            }

            public void put(int i, int i2, int i3) {
                int i4 = this.bufferIndex_;
                RCEI[] rceiArr = this.buffer_;
                int i5 = 0;
                if (i4 >= rceiArr.length) {
                    RCEI[] rceiArr2 = new RCEI[rceiArr.length + 8];
                    System.arraycopy(rceiArr, 0, rceiArr2, 0, rceiArr.length);
                    this.buffer_ = rceiArr2;
                }
                this.buffer_[this.bufferIndex_] = new RCEI(i5);
                RCEI[] rceiArr3 = this.buffer_;
                int i6 = this.bufferIndex_;
                RCEI rcei = rceiArr3[i6];
                rcei.ce_ = i;
                rcei.low_ = i2;
                rcei.high_ = i3;
                this.bufferIndex_ = i6 + 1;
            }

            public /* synthetic */ RCEBuffer(int i) {
                this();
            }
        }

        public void init(CollationElementIterator collationElementIterator) {
            this.cei_ = collationElementIterator;
            init(collationElementIterator.getRuleBasedCollator());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class CEI {
        long ce_;
        int highIndex_;
        int lowIndex_;

        public /* synthetic */ CEI(int i) {
            this();
        }

        private CEI() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class Match {
        int limit_;
        int start_;

        private Match() {
            this.start_ = -1;
            this.limit_ = -1;
        }

        public /* synthetic */ Match(int i) {
            this();
        }
    }

    public StringSearch(String str, CharacterIterator characterIterator, RuleBasedCollator ruleBasedCollator) {
        this(str, characterIterator, ruleBasedCollator, null);
    }

    public StringSearch(String str, CharacterIterator characterIterator, Locale locale) {
        this(str, characterIterator, ULocale.forLocale(locale));
    }

    public StringSearch(String str, CharacterIterator characterIterator, ULocale uLocale) {
        this(str, characterIterator, (RuleBasedCollator) Collator.getInstance(uLocale), null);
    }

    public StringSearch(String str, String str2) {
        this(str, new java.text.StringCharacterIterator(str2), (RuleBasedCollator) Collator.getInstance(), null);
    }
}
