package com.ibm.icu.impl.coll;

import com.ibm.icu.impl.Norm2AllModes;
import com.ibm.icu.impl.Normalizer2Impl;
import com.ibm.icu.text.CanonicalIterator;
import com.ibm.icu.text.DateTimePatternGenerator;
import com.ibm.icu.text.Normalizer2;
import com.ibm.icu.text.UnicodeSet;
import com.ibm.icu.text.UnicodeSetIterator;
import com.ibm.icu.util.ICUInputTooLongException;
import com.ibm.icu.util.ULocale;
import defpackage.dk0;
import defpackage.og;
import java.text.ParseException;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class CollationBuilder extends CollationRuleParser.Sink {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final UnicodeSet COMPOSITES;
    private static final boolean DEBUG = false;
    private static final int HAS_BEFORE2 = 64;
    private static final int HAS_BEFORE3 = 32;
    private static final int IS_TAILORED = 8;
    private static final int MAX_INDEX = 1048575;
    private static int kClosureLoopLimit = 2400;
    private CollationTailoring base;
    private CollationData baseData;
    private int cesLength;
    private CollationDataBuilder dataBuilder;
    private boolean fastLatinEnabled;
    private UVector64 nodes;
    private CollationRootElements rootElements;
    private UVector32 rootPrimaryIndexes;
    private long variableTop;
    private UnicodeSet optimizeSet = new UnicodeSet();
    private long[] ces = new long[31];
    private Normalizer2 nfd = Normalizer2.getNFDInstance();
    private Normalizer2 fcd = Norm2AllModes.getFCDNormalizer2();
    private Normalizer2Impl nfcImpl = Norm2AllModes.getNFCInstance().impl;

    /* JADX INFO: renamed from: com.ibm.icu.impl.coll.CollationBuilder$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ibm$icu$impl$coll$CollationRuleParser$Position;

        static {
            int[] iArr = new int[CollationRuleParser.Position.values().length];
            $SwitchMap$com$ibm$icu$impl$coll$CollationRuleParser$Position = iArr;
            try {
                iArr[CollationRuleParser.Position.FIRST_TERTIARY_IGNORABLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ibm$icu$impl$coll$CollationRuleParser$Position[CollationRuleParser.Position.LAST_TERTIARY_IGNORABLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$ibm$icu$impl$coll$CollationRuleParser$Position[CollationRuleParser.Position.FIRST_SECONDARY_IGNORABLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$ibm$icu$impl$coll$CollationRuleParser$Position[CollationRuleParser.Position.LAST_SECONDARY_IGNORABLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$ibm$icu$impl$coll$CollationRuleParser$Position[CollationRuleParser.Position.FIRST_PRIMARY_IGNORABLE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$ibm$icu$impl$coll$CollationRuleParser$Position[CollationRuleParser.Position.LAST_PRIMARY_IGNORABLE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$ibm$icu$impl$coll$CollationRuleParser$Position[CollationRuleParser.Position.FIRST_VARIABLE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$ibm$icu$impl$coll$CollationRuleParser$Position[CollationRuleParser.Position.LAST_VARIABLE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$ibm$icu$impl$coll$CollationRuleParser$Position[CollationRuleParser.Position.FIRST_REGULAR.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$ibm$icu$impl$coll$CollationRuleParser$Position[CollationRuleParser.Position.LAST_REGULAR.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$ibm$icu$impl$coll$CollationRuleParser$Position[CollationRuleParser.Position.FIRST_IMPLICIT.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$ibm$icu$impl$coll$CollationRuleParser$Position[CollationRuleParser.Position.LAST_IMPLICIT.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$ibm$icu$impl$coll$CollationRuleParser$Position[CollationRuleParser.Position.FIRST_TRAILING.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$ibm$icu$impl$coll$CollationRuleParser$Position[CollationRuleParser.Position.LAST_TRAILING.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class BundleImporter implements CollationRuleParser.Importer {
        @Override // com.ibm.icu.impl.coll.CollationRuleParser.Importer
        public String getRules(String str, String str2) {
            return CollationLoader.loadRules(new ULocale(str), str2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class CEFinalizer implements CollationDataBuilder.CEModifier {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private long[] finalCEs;

        public CEFinalizer(long[] jArr) {
            this.finalCEs = jArr;
        }

        @Override // com.ibm.icu.impl.coll.CollationDataBuilder.CEModifier
        public long modifyCE(long j) {
            if (!CollationBuilder.isTempCE(j)) {
                return Collation.NO_CE;
            }
            return (j & 49152) | this.finalCEs[CollationBuilder.indexFromTempCE(j)];
        }

        @Override // com.ibm.icu.impl.coll.CollationDataBuilder.CEModifier
        public long modifyCE32(int i) {
            if (!CollationBuilder.isTempCE32(i)) {
                return Collation.NO_CE;
            }
            return ((long) ((i & 192) << 8)) | this.finalCEs[CollationBuilder.indexFromTempCE32(i)];
        }
    }

    static {
        UnicodeSet unicodeSet = new UnicodeSet("[:NFD_QC=N:]");
        COMPOSITES = unicodeSet;
        unicodeSet.remove(Normalizer2Impl.Hangul.HANGUL_BASE, Normalizer2Impl.Hangul.HANGUL_END);
    }

    public CollationBuilder(CollationTailoring collationTailoring) {
        this.base = collationTailoring;
        CollationData collationData = collationTailoring.data;
        this.baseData = collationData;
        this.rootElements = new CollationRootElements(collationData.rootElements);
        this.variableTop = 0L;
        this.dataBuilder = new CollationDataBuilder();
        this.fastLatinEnabled = true;
        this.cesLength = 0;
        this.rootPrimaryIndexes = new UVector32();
        this.nodes = new UVector64();
        this.nfcImpl.ensureCanonIterData();
        this.dataBuilder.initForTailoring(this.baseData);
    }

    private int addIfDifferent(CharSequence charSequence, CharSequence charSequence2, long[] jArr, int i, int i2) {
        long[] jArr2 = new long[31];
        if (!sameCEs(jArr, i, jArr2, this.dataBuilder.getCEs(charSequence, charSequence2, jArr2, 0))) {
            if (i2 == -1) {
                i2 = this.dataBuilder.encodeCEs(jArr, i);
            }
            this.dataBuilder.addCE32(charSequence, charSequence2, i2);
        }
        return i2;
    }

    private int addOnlyClosure(CharSequence charSequence, CharSequence charSequence2, long[] jArr, int i, int i2) {
        int i3 = 0;
        if (charSequence.length() == 0) {
            CanonicalIterator canonicalIterator = new CanonicalIterator(charSequence2.toString());
            int iAddIfDifferent = i2;
            while (true) {
                String next = canonicalIterator.next();
                if (next == null) {
                    return iAddIfDifferent;
                }
                if (this.ignoreString(next) || next.contentEquals(charSequence2)) {
                    this = this;
                    jArr = jArr;
                    i = i;
                } else {
                    int i4 = i3 + 1;
                    if (i3 > kClosureLoopLimit) {
                        throw new ICUInputTooLongException("Too many closure");
                    }
                    long[] jArr2 = jArr;
                    iAddIfDifferent = this.addIfDifferent("", next, jArr2, i, iAddIfDifferent);
                    i3 = i4;
                    jArr = jArr2;
                }
            }
        } else {
            CanonicalIterator canonicalIterator2 = new CanonicalIterator(charSequence.toString());
            CanonicalIterator canonicalIterator3 = new CanonicalIterator(charSequence2.toString());
            CollationBuilder collationBuilder = this;
            while (true) {
                String next2 = canonicalIterator2.next();
                if (next2 == null) {
                    return i2;
                }
                if (!collationBuilder.ignorePrefix(next2)) {
                    boolean zContentEquals = next2.contentEquals(charSequence);
                    int iAddIfDifferent2 = i2;
                    while (true) {
                        String next3 = canonicalIterator3.next();
                        if (next3 == null) {
                            canonicalIterator3.reset();
                            i2 = iAddIfDifferent2;
                            break;
                        }
                        if (collationBuilder.ignoreString(next3) || (zContentEquals && next3.contentEquals(charSequence2))) {
                            next2 = next2;
                            collationBuilder = collationBuilder;
                        } else {
                            int i5 = i3 + 1;
                            if (i3 > kClosureLoopLimit) {
                                throw new ICUInputTooLongException("Too many closure");
                            }
                            iAddIfDifferent2 = collationBuilder.addIfDifferent(next2, next3, jArr, i, iAddIfDifferent2);
                            i3 = i5;
                        }
                    }
                }
            }
        }
    }

    private void addTailComposites(CharSequence charSequence, CharSequence charSequence2) {
        int cEs;
        StringBuilder sb;
        int length = charSequence2.length();
        while (length != 0) {
            int iCodePointBefore = Character.codePointBefore(charSequence2, length);
            if (this.nfd.getCombiningClass(iCodePointBefore) == 0) {
                if (Normalizer2Impl.Hangul.isJamoL(iCodePointBefore)) {
                    return;
                }
                UnicodeSet unicodeSet = new UnicodeSet();
                if (this.nfcImpl.getCanonStartSet(iCodePointBefore, unicodeSet)) {
                    StringBuilder sb2 = new StringBuilder();
                    StringBuilder sb3 = new StringBuilder();
                    long[] jArr = new long[31];
                    UnicodeSetIterator unicodeSetIterator = new UnicodeSetIterator(unicodeSet);
                    while (unicodeSetIterator.next()) {
                        int i = unicodeSetIterator.codepoint;
                        boolean zMergeCompositeIntoString = mergeCompositeIntoString(charSequence2, length, i, this.nfd.getDecomposition(i), sb2, sb3);
                        StringBuilder sb4 = sb3;
                        int i2 = length;
                        StringBuilder sb5 = sb2;
                        if (zMergeCompositeIntoString && (cEs = this.dataBuilder.getCEs(charSequence, sb5, jArr, 0)) <= 31) {
                            long[] jArr2 = jArr;
                            int iAddIfDifferent = addIfDifferent(charSequence, sb4, jArr2, cEs, -1);
                            if (iAddIfDifferent != -1) {
                                sb = sb5;
                                addOnlyClosure(charSequence, sb, jArr2, cEs, iAddIfDifferent);
                            } else {
                                sb = sb5;
                            }
                            sb2 = sb;
                            length = i2;
                            sb3 = sb4;
                            jArr = jArr2;
                        } else {
                            sb3 = sb4;
                            length = i2;
                            sb2 = sb5;
                        }
                    }
                    return;
                }
                return;
            }
            length -= Character.charCount(iCodePointBefore);
        }
    }

    private int addWithClosure(CharSequence charSequence, CharSequence charSequence2, long[] jArr, int i, int i2) {
        int iAddOnlyClosure = addOnlyClosure(charSequence, charSequence2, jArr, i, addIfDifferent(charSequence, charSequence2, jArr, i, i2));
        addTailComposites(charSequence, charSequence2);
        return iAddOnlyClosure;
    }

    private static final int alignWeightRight(int i) {
        if (i != 0) {
            while ((i & 255) == 0) {
                i >>>= 8;
            }
        }
        return i;
    }

    private static final int binarySearchForRootPrimaryNode(int[] iArr, int i, long[] jArr, long j) {
        if (i == 0) {
            return -1;
        }
        int i2 = 0;
        while (true) {
            int i3 = (int) ((((long) i2) + ((long) i)) / 2);
            long j2 = jArr[iArr[i3]] >>> 32;
            if (j == j2) {
                return i3;
            }
            if (j < j2) {
                if (i3 == i2) {
                    return ~i2;
                }
                i = i3;
            } else {
                if (i3 == i2) {
                    return ~(i2 + 1);
                }
                i2 = i3;
            }
        }
    }

    private static int ceStrength(long j) {
        if (isTempCE(j)) {
            return strengthFromTempCE(j);
        }
        if (((-72057594037927936L) & j) != 0) {
            return 0;
        }
        if ((((int) j) & (-16777216)) != 0) {
            return 1;
        }
        return j != 0 ? 2 : 15;
    }

    private static long changeNodeNextIndex(long j, int i) {
        return (j & (-268435201)) | nodeFromNextIndex(i);
    }

    private static long changeNodePreviousIndex(long j, int i) {
        return (j & (-281474708275201L)) | nodeFromPreviousIndex(i);
    }

    private void closeOverComposites() {
        UnicodeSetIterator unicodeSetIterator = new UnicodeSetIterator(COMPOSITES);
        while (unicodeSetIterator.next()) {
            int cEs = this.dataBuilder.getCEs(this.nfd.getDecomposition(unicodeSetIterator.codepoint), this.ces, 0);
            this.cesLength = cEs;
            if (cEs <= 31) {
                addIfDifferent("", unicodeSetIterator.getString(), this.ces, this.cesLength, -1);
            }
        }
    }

    private static int countTailoredNodes(long[] jArr, int i, int i2) {
        int i3 = 0;
        while (i != 0) {
            long j = jArr[i];
            if (strengthFromNode(j) < i2) {
                break;
            }
            if (strengthFromNode(j) == i2) {
                if (!isTailoredNode(j)) {
                    break;
                }
                i3++;
            }
            i = nextIndexFromNode(j);
        }
        return i3;
    }

    private boolean equalSubSequences(CharSequence charSequence, int i, CharSequence charSequence2, int i2) {
        int length = charSequence.length();
        if (length - i != charSequence2.length() - i2) {
            return false;
        }
        while (i < length) {
            int i3 = i + 1;
            int i4 = i2 + 1;
            if (charSequence.charAt(i) != charSequence2.charAt(i2)) {
                return false;
            }
            i = i3;
            i2 = i4;
        }
        return true;
    }

    private void finalizeCEs() {
        CollationDataBuilder collationDataBuilder = new CollationDataBuilder();
        collationDataBuilder.initForTailoring(this.baseData);
        collationDataBuilder.copyFrom(this.dataBuilder, new CEFinalizer(this.nodes.getBuffer()));
        this.dataBuilder = collationDataBuilder;
    }

    private int findCommonNode(int i, int i2) {
        long jElementAti = this.nodes.elementAti(i);
        if (strengthFromNode(jElementAti) >= i2 || (i2 != 1 ? !nodeHasBefore3(jElementAti) : !nodeHasBefore2(jElementAti))) {
            return i;
        }
        long jElementAti2 = this.nodes.elementAti(nextIndexFromNode(jElementAti));
        while (true) {
            int iNextIndexFromNode = nextIndexFromNode(jElementAti2);
            jElementAti2 = this.nodes.elementAti(iNextIndexFromNode);
            if (!isTailoredNode(jElementAti2) && strengthFromNode(jElementAti2) <= i2 && weight16FromNode(jElementAti2) >= 1280) {
                return iNextIndexFromNode;
            }
        }
    }

    private int findOrInsertNodeForCEs(int i) {
        long j;
        while (true) {
            int i2 = this.cesLength;
            long[] jArr = this.ces;
            if (i2 == 0) {
                j = 0;
                jArr[0] = 0;
                this.cesLength = 1;
                break;
            }
            j = jArr[i2 - 1];
            if (ceStrength(j) <= i) {
                break;
            }
            this.cesLength--;
        }
        if (isTempCE(j)) {
            return indexFromTempCE(j);
        }
        if (((int) (j >>> 56)) != 254) {
            return findOrInsertNodeForRootCE(j, i);
        }
        dk0.r("tailoring relative to an unassigned code point not supported");
        return 0;
    }

    private int findOrInsertNodeForPrimary(long j) {
        int iBinarySearchForRootPrimaryNode = binarySearchForRootPrimaryNode(this.rootPrimaryIndexes.getBuffer(), this.rootPrimaryIndexes.size(), this.nodes.getBuffer(), j);
        if (iBinarySearchForRootPrimaryNode >= 0) {
            return this.rootPrimaryIndexes.elementAti(iBinarySearchForRootPrimaryNode);
        }
        int size = this.nodes.size();
        this.nodes.addElement(nodeFromWeight32(j));
        this.rootPrimaryIndexes.insertElementAt(size, ~iBinarySearchForRootPrimaryNode);
        return size;
    }

    private int findOrInsertNodeForRootCE(long j, int i) {
        int iFindOrInsertNodeForPrimary = findOrInsertNodeForPrimary(j >>> 32);
        if (i < 1) {
            return iFindOrInsertNodeForPrimary;
        }
        int i2 = (int) j;
        int iFindOrInsertWeakNode = findOrInsertWeakNode(iFindOrInsertNodeForPrimary, i2 >>> 16, 1);
        return i >= 2 ? findOrInsertWeakNode(iFindOrInsertWeakNode, i2 & Collation.ONLY_TERTIARY_MASK, 2) : iFindOrInsertWeakNode;
    }

    private int findOrInsertWeakNode(int i, int i2, int i3) {
        int iNextIndexFromNode;
        if (i2 == 1280) {
            return findCommonNode(i, i3);
        }
        long jElementAti = this.nodes.elementAti(i);
        if (i2 != 0 && i2 < 1280) {
            long j = i3 == 1 ? 64 : 32;
            if ((jElementAti & j) == 0) {
                long jNodeFromWeight16 = nodeFromWeight16(Collation.COMMON_WEIGHT16) | nodeFromStrength(i3);
                if (i3 == 1) {
                    jNodeFromWeight16 |= 32 & jElementAti;
                    jElementAti &= -33;
                }
                this.nodes.setElementAt(jElementAti | j, i);
                int iNextIndexFromNode2 = nextIndexFromNode(jElementAti);
                int iInsertNodeBetween = insertNodeBetween(i, iNextIndexFromNode2, nodeFromStrength(i3) | nodeFromWeight16(i2));
                insertNodeBetween(iInsertNodeBetween, iNextIndexFromNode2, jNodeFromWeight16);
                return iInsertNodeBetween;
            }
        }
        while (true) {
            iNextIndexFromNode = nextIndexFromNode(jElementAti);
            if (iNextIndexFromNode == 0) {
                break;
            }
            jElementAti = this.nodes.elementAti(iNextIndexFromNode);
            int iStrengthFromNode = strengthFromNode(jElementAti);
            if (iStrengthFromNode <= i3) {
                if (iStrengthFromNode < i3) {
                    break;
                }
                if (isTailoredNode(jElementAti)) {
                    continue;
                } else {
                    int iWeight16FromNode = weight16FromNode(jElementAti);
                    if (iWeight16FromNode == i2) {
                        return iNextIndexFromNode;
                    }
                    if (iWeight16FromNode > i2) {
                        break;
                    }
                }
            }
            i = iNextIndexFromNode;
        }
        return insertNodeBetween(i, iNextIndexFromNode, nodeFromStrength(i3) | nodeFromWeight16(i2));
    }

    /* JADX WARN: Code duplicated, block: B:38:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:40:0x00d9 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:43:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:44:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:47:0x0116  */
    /* JADX WARN: Code duplicated, block: B:49:0x011c  */
    /* JADX WARN: Code duplicated, block: B:52:0x0136  */
    /* JADX WARN: Code duplicated, block: B:55:0x0149 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:56:0x014a A[LOOP:0: B:56:0x014a->B:66:0x0169, LOOP_START, PHI: r5 r8
      0x014a: PHI (r5v2 int) = (r5v1 int), (r5v3 int) binds: [B:37:0x00d1, B:66:0x0169] A[DONT_GENERATE, DONT_INLINE]
      0x014a: PHI (r8v1 long) = (r8v0 long), (r8v2 long) binds: [B:37:0x00d1, B:66:0x0169] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:59:0x0151  */
    /* JADX WARN: Code duplicated, block: B:63:0x0163  */
    /* JADX WARN: Code duplicated, block: B:65:0x0168 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:66:0x0169 A[LOOP:0: B:56:0x014a->B:66:0x0169, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:78:0x015d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:79:0x015d A[SYNTHETIC] */
    private long getSpecialResetPosition(CharSequence charSequence) {
        long lastTertiaryCE;
        int i;
        int iStrengthFromNode;
        boolean z;
        int iFindOrInsertNodeForRootCE;
        long jElementAti;
        int iNextIndexFromNode;
        long jElementAti2;
        CollationRuleParser.Position position = CollationRuleParser.POSITION_VALUES[charSequence.charAt(1) - 10240];
        switch (AnonymousClass1.$SwitchMap$com$ibm$icu$impl$coll$CollationRuleParser$Position[position.ordinal()]) {
            case 1:
            case 2:
                return 0L;
            case 3:
                int iNextIndexFromNode2 = nextIndexFromNode(this.nodes.elementAti(findOrInsertNodeForRootCE(0L, 2)));
                if (iNextIndexFromNode2 != 0) {
                    long jElementAti3 = this.nodes.elementAti(iNextIndexFromNode2);
                    if (isTailoredNode(jElementAti3) && strengthFromNode(jElementAti3) == 2) {
                        return tempCEFromIndexAndStrength(iNextIndexFromNode2, 2);
                    }
                }
                return this.rootElements.getFirstTertiaryCE();
            case 4:
                lastTertiaryCE = this.rootElements.getLastTertiaryCE();
                i = 2;
                z = false;
                iFindOrInsertNodeForRootCE = findOrInsertNodeForRootCE(lastTertiaryCE, i);
                jElementAti = this.nodes.elementAti(iFindOrInsertNodeForRootCE);
                if ((position.ordinal() & 1) != 0) {
                    while (true) {
                        iNextIndexFromNode = nextIndexFromNode(jElementAti);
                        if (iNextIndexFromNode != 0) {
                            jElementAti2 = this.nodes.elementAti(iNextIndexFromNode);
                            if (strengthFromNode(jElementAti2) >= i) {
                                iFindOrInsertNodeForRootCE = iNextIndexFromNode;
                                jElementAti = jElementAti2;
                            }
                        }
                    }
                    if (isTailoredNode(jElementAti)) {
                        return tempCEFromIndexAndStrength(iFindOrInsertNodeForRootCE, i);
                    }
                    return lastTertiaryCE;
                }
                if (!nodeHasAnyBefore(jElementAti) && z) {
                    iFindOrInsertNodeForRootCE = nextIndexFromNode(jElementAti);
                    if (iFindOrInsertNodeForRootCE != 0) {
                        jElementAti = this.nodes.elementAti(iFindOrInsertNodeForRootCE);
                        lastTertiaryCE = tempCEFromIndexAndStrength(iFindOrInsertNodeForRootCE, i);
                    } else {
                        long j = lastTertiaryCE >>> 32;
                        lastTertiaryCE = Collation.makeCE(this.rootElements.getPrimaryAfter(j, this.rootElements.findPrimary(j), this.baseData.isCompressiblePrimary(j)));
                        iFindOrInsertNodeForRootCE = findOrInsertNodeForRootCE(lastTertiaryCE, 0);
                        jElementAti = this.nodes.elementAti(iFindOrInsertNodeForRootCE);
                    }
                }
                if (!nodeHasAnyBefore(jElementAti)) {
                    return lastTertiaryCE;
                }
                if (nodeHasBefore2(jElementAti)) {
                    iFindOrInsertNodeForRootCE = nextIndexFromNode(this.nodes.elementAti(nextIndexFromNode(jElementAti)));
                    jElementAti = this.nodes.elementAti(iFindOrInsertNodeForRootCE);
                }
                if (nodeHasBefore3(jElementAti)) {
                    iFindOrInsertNodeForRootCE = nextIndexFromNode(this.nodes.elementAti(nextIndexFromNode(jElementAti)));
                }
                return tempCEFromIndexAndStrength(iFindOrInsertNodeForRootCE, i);
            case 5:
                long jElementAti4 = this.nodes.elementAti(findOrInsertNodeForRootCE(0L, 1));
                while (true) {
                    int iNextIndexFromNode3 = nextIndexFromNode(jElementAti4);
                    if (iNextIndexFromNode3 != 0 && (iStrengthFromNode = strengthFromNode((jElementAti4 = this.nodes.elementAti(iNextIndexFromNode3)))) >= 1) {
                        if (iStrengthFromNode == 1) {
                            if (isTailoredNode(jElementAti4)) {
                                if (nodeHasBefore3(jElementAti4)) {
                                    iNextIndexFromNode3 = nextIndexFromNode(this.nodes.elementAti(nextIndexFromNode(jElementAti4)));
                                }
                                return tempCEFromIndexAndStrength(iNextIndexFromNode3, 1);
                            }
                        }
                    }
                }
                lastTertiaryCE = this.rootElements.getFirstSecondaryCE();
                i = 1;
                z = false;
                iFindOrInsertNodeForRootCE = findOrInsertNodeForRootCE(lastTertiaryCE, i);
                jElementAti = this.nodes.elementAti(iFindOrInsertNodeForRootCE);
                if ((position.ordinal() & 1) != 0) {
                    while (true) {
                        iNextIndexFromNode = nextIndexFromNode(jElementAti);
                        if (iNextIndexFromNode != 0) {
                            jElementAti2 = this.nodes.elementAti(iNextIndexFromNode);
                            if (strengthFromNode(jElementAti2) >= i) {
                                iFindOrInsertNodeForRootCE = iNextIndexFromNode;
                                jElementAti = jElementAti2;
                            }
                        }
                    }
                    if (isTailoredNode(jElementAti)) {
                        return tempCEFromIndexAndStrength(iFindOrInsertNodeForRootCE, i);
                    }
                    return lastTertiaryCE;
                }
                if (!nodeHasAnyBefore(jElementAti)) {
                    iFindOrInsertNodeForRootCE = nextIndexFromNode(jElementAti);
                    if (iFindOrInsertNodeForRootCE != 0) {
                        jElementAti = this.nodes.elementAti(iFindOrInsertNodeForRootCE);
                        lastTertiaryCE = tempCEFromIndexAndStrength(iFindOrInsertNodeForRootCE, i);
                    } else {
                        long j2 = lastTertiaryCE >>> 32;
                        lastTertiaryCE = Collation.makeCE(this.rootElements.getPrimaryAfter(j2, this.rootElements.findPrimary(j2), this.baseData.isCompressiblePrimary(j2)));
                        iFindOrInsertNodeForRootCE = findOrInsertNodeForRootCE(lastTertiaryCE, 0);
                        jElementAti = this.nodes.elementAti(iFindOrInsertNodeForRootCE);
                    }
                }
                if (!nodeHasAnyBefore(jElementAti)) {
                    return lastTertiaryCE;
                }
                if (nodeHasBefore2(jElementAti)) {
                    iFindOrInsertNodeForRootCE = nextIndexFromNode(this.nodes.elementAti(nextIndexFromNode(jElementAti)));
                    jElementAti = this.nodes.elementAti(iFindOrInsertNodeForRootCE);
                }
                if (nodeHasBefore3(jElementAti)) {
                    iFindOrInsertNodeForRootCE = nextIndexFromNode(this.nodes.elementAti(nextIndexFromNode(jElementAti)));
                }
                return tempCEFromIndexAndStrength(iFindOrInsertNodeForRootCE, i);
            case 6:
                lastTertiaryCE = this.rootElements.getLastSecondaryCE();
                i = 1;
                z = false;
                iFindOrInsertNodeForRootCE = findOrInsertNodeForRootCE(lastTertiaryCE, i);
                jElementAti = this.nodes.elementAti(iFindOrInsertNodeForRootCE);
                if ((position.ordinal() & 1) != 0) {
                    while (true) {
                        iNextIndexFromNode = nextIndexFromNode(jElementAti);
                        if (iNextIndexFromNode != 0) {
                            jElementAti2 = this.nodes.elementAti(iNextIndexFromNode);
                            if (strengthFromNode(jElementAti2) >= i) {
                                iFindOrInsertNodeForRootCE = iNextIndexFromNode;
                                jElementAti = jElementAti2;
                            }
                        }
                    }
                    if (isTailoredNode(jElementAti)) {
                        return tempCEFromIndexAndStrength(iFindOrInsertNodeForRootCE, i);
                    }
                    return lastTertiaryCE;
                }
                if (!nodeHasAnyBefore(jElementAti)) {
                    iFindOrInsertNodeForRootCE = nextIndexFromNode(jElementAti);
                    if (iFindOrInsertNodeForRootCE != 0) {
                        jElementAti = this.nodes.elementAti(iFindOrInsertNodeForRootCE);
                        lastTertiaryCE = tempCEFromIndexAndStrength(iFindOrInsertNodeForRootCE, i);
                    } else {
                        long j3 = lastTertiaryCE >>> 32;
                        lastTertiaryCE = Collation.makeCE(this.rootElements.getPrimaryAfter(j3, this.rootElements.findPrimary(j3), this.baseData.isCompressiblePrimary(j3)));
                        iFindOrInsertNodeForRootCE = findOrInsertNodeForRootCE(lastTertiaryCE, 0);
                        jElementAti = this.nodes.elementAti(iFindOrInsertNodeForRootCE);
                    }
                }
                if (!nodeHasAnyBefore(jElementAti)) {
                    return lastTertiaryCE;
                }
                if (nodeHasBefore2(jElementAti)) {
                    iFindOrInsertNodeForRootCE = nextIndexFromNode(this.nodes.elementAti(nextIndexFromNode(jElementAti)));
                    jElementAti = this.nodes.elementAti(iFindOrInsertNodeForRootCE);
                }
                if (nodeHasBefore3(jElementAti)) {
                    iFindOrInsertNodeForRootCE = nextIndexFromNode(this.nodes.elementAti(nextIndexFromNode(jElementAti)));
                }
                return tempCEFromIndexAndStrength(iFindOrInsertNodeForRootCE, i);
            case 7:
                lastTertiaryCE = this.rootElements.getFirstPrimaryCE();
                z = true;
                i = 0;
                iFindOrInsertNodeForRootCE = findOrInsertNodeForRootCE(lastTertiaryCE, i);
                jElementAti = this.nodes.elementAti(iFindOrInsertNodeForRootCE);
                if ((position.ordinal() & 1) != 0) {
                    while (true) {
                        iNextIndexFromNode = nextIndexFromNode(jElementAti);
                        if (iNextIndexFromNode != 0) {
                            jElementAti2 = this.nodes.elementAti(iNextIndexFromNode);
                            if (strengthFromNode(jElementAti2) >= i) {
                                iFindOrInsertNodeForRootCE = iNextIndexFromNode;
                                jElementAti = jElementAti2;
                            }
                        }
                    }
                    if (isTailoredNode(jElementAti)) {
                        return tempCEFromIndexAndStrength(iFindOrInsertNodeForRootCE, i);
                    }
                    return lastTertiaryCE;
                }
                if (!nodeHasAnyBefore(jElementAti)) {
                    iFindOrInsertNodeForRootCE = nextIndexFromNode(jElementAti);
                    if (iFindOrInsertNodeForRootCE != 0) {
                        jElementAti = this.nodes.elementAti(iFindOrInsertNodeForRootCE);
                        lastTertiaryCE = tempCEFromIndexAndStrength(iFindOrInsertNodeForRootCE, i);
                    } else {
                        long j4 = lastTertiaryCE >>> 32;
                        lastTertiaryCE = Collation.makeCE(this.rootElements.getPrimaryAfter(j4, this.rootElements.findPrimary(j4), this.baseData.isCompressiblePrimary(j4)));
                        iFindOrInsertNodeForRootCE = findOrInsertNodeForRootCE(lastTertiaryCE, 0);
                        jElementAti = this.nodes.elementAti(iFindOrInsertNodeForRootCE);
                    }
                }
                if (!nodeHasAnyBefore(jElementAti)) {
                    return lastTertiaryCE;
                }
                if (nodeHasBefore2(jElementAti)) {
                    iFindOrInsertNodeForRootCE = nextIndexFromNode(this.nodes.elementAti(nextIndexFromNode(jElementAti)));
                    jElementAti = this.nodes.elementAti(iFindOrInsertNodeForRootCE);
                }
                if (nodeHasBefore3(jElementAti)) {
                    iFindOrInsertNodeForRootCE = nextIndexFromNode(this.nodes.elementAti(nextIndexFromNode(jElementAti)));
                }
                return tempCEFromIndexAndStrength(iFindOrInsertNodeForRootCE, i);
            case 8:
                lastTertiaryCE = this.rootElements.lastCEWithPrimaryBefore(this.variableTop + 1);
                i = 0;
                z = false;
                iFindOrInsertNodeForRootCE = findOrInsertNodeForRootCE(lastTertiaryCE, i);
                jElementAti = this.nodes.elementAti(iFindOrInsertNodeForRootCE);
                if ((position.ordinal() & 1) != 0) {
                    while (true) {
                        iNextIndexFromNode = nextIndexFromNode(jElementAti);
                        if (iNextIndexFromNode != 0) {
                            jElementAti2 = this.nodes.elementAti(iNextIndexFromNode);
                            if (strengthFromNode(jElementAti2) >= i) {
                                iFindOrInsertNodeForRootCE = iNextIndexFromNode;
                                jElementAti = jElementAti2;
                            }
                        }
                    }
                    if (isTailoredNode(jElementAti)) {
                        return tempCEFromIndexAndStrength(iFindOrInsertNodeForRootCE, i);
                    }
                    return lastTertiaryCE;
                }
                if (!nodeHasAnyBefore(jElementAti)) {
                    iFindOrInsertNodeForRootCE = nextIndexFromNode(jElementAti);
                    if (iFindOrInsertNodeForRootCE != 0) {
                        jElementAti = this.nodes.elementAti(iFindOrInsertNodeForRootCE);
                        lastTertiaryCE = tempCEFromIndexAndStrength(iFindOrInsertNodeForRootCE, i);
                    } else {
                        long j5 = lastTertiaryCE >>> 32;
                        lastTertiaryCE = Collation.makeCE(this.rootElements.getPrimaryAfter(j5, this.rootElements.findPrimary(j5), this.baseData.isCompressiblePrimary(j5)));
                        iFindOrInsertNodeForRootCE = findOrInsertNodeForRootCE(lastTertiaryCE, 0);
                        jElementAti = this.nodes.elementAti(iFindOrInsertNodeForRootCE);
                    }
                }
                if (!nodeHasAnyBefore(jElementAti)) {
                    return lastTertiaryCE;
                }
                if (nodeHasBefore2(jElementAti)) {
                    iFindOrInsertNodeForRootCE = nextIndexFromNode(this.nodes.elementAti(nextIndexFromNode(jElementAti)));
                    jElementAti = this.nodes.elementAti(iFindOrInsertNodeForRootCE);
                }
                if (nodeHasBefore3(jElementAti)) {
                    iFindOrInsertNodeForRootCE = nextIndexFromNode(this.nodes.elementAti(nextIndexFromNode(jElementAti)));
                }
                return tempCEFromIndexAndStrength(iFindOrInsertNodeForRootCE, i);
            case 9:
                lastTertiaryCE = this.rootElements.firstCEWithPrimaryAtLeast(this.variableTop + 1);
                z = true;
                i = 0;
                iFindOrInsertNodeForRootCE = findOrInsertNodeForRootCE(lastTertiaryCE, i);
                jElementAti = this.nodes.elementAti(iFindOrInsertNodeForRootCE);
                if ((position.ordinal() & 1) != 0) {
                    while (true) {
                        iNextIndexFromNode = nextIndexFromNode(jElementAti);
                        if (iNextIndexFromNode != 0) {
                            jElementAti2 = this.nodes.elementAti(iNextIndexFromNode);
                            if (strengthFromNode(jElementAti2) >= i) {
                                iFindOrInsertNodeForRootCE = iNextIndexFromNode;
                                jElementAti = jElementAti2;
                            }
                        }
                    }
                    if (isTailoredNode(jElementAti)) {
                        return tempCEFromIndexAndStrength(iFindOrInsertNodeForRootCE, i);
                    }
                    return lastTertiaryCE;
                }
                if (!nodeHasAnyBefore(jElementAti)) {
                    iFindOrInsertNodeForRootCE = nextIndexFromNode(jElementAti);
                    if (iFindOrInsertNodeForRootCE != 0) {
                        jElementAti = this.nodes.elementAti(iFindOrInsertNodeForRootCE);
                        lastTertiaryCE = tempCEFromIndexAndStrength(iFindOrInsertNodeForRootCE, i);
                    } else {
                        long j6 = lastTertiaryCE >>> 32;
                        lastTertiaryCE = Collation.makeCE(this.rootElements.getPrimaryAfter(j6, this.rootElements.findPrimary(j6), this.baseData.isCompressiblePrimary(j6)));
                        iFindOrInsertNodeForRootCE = findOrInsertNodeForRootCE(lastTertiaryCE, 0);
                        jElementAti = this.nodes.elementAti(iFindOrInsertNodeForRootCE);
                    }
                }
                if (!nodeHasAnyBefore(jElementAti)) {
                    return lastTertiaryCE;
                }
                if (nodeHasBefore2(jElementAti)) {
                    iFindOrInsertNodeForRootCE = nextIndexFromNode(this.nodes.elementAti(nextIndexFromNode(jElementAti)));
                    jElementAti = this.nodes.elementAti(iFindOrInsertNodeForRootCE);
                }
                if (nodeHasBefore3(jElementAti)) {
                    iFindOrInsertNodeForRootCE = nextIndexFromNode(this.nodes.elementAti(nextIndexFromNode(jElementAti)));
                }
                return tempCEFromIndexAndStrength(iFindOrInsertNodeForRootCE, i);
            case 10:
                lastTertiaryCE = this.rootElements.firstCEWithPrimaryAtLeast(this.baseData.getFirstPrimaryForGroup(17));
                i = 0;
                z = false;
                iFindOrInsertNodeForRootCE = findOrInsertNodeForRootCE(lastTertiaryCE, i);
                jElementAti = this.nodes.elementAti(iFindOrInsertNodeForRootCE);
                if ((position.ordinal() & 1) != 0) {
                    while (true) {
                        iNextIndexFromNode = nextIndexFromNode(jElementAti);
                        if (iNextIndexFromNode != 0) {
                            jElementAti2 = this.nodes.elementAti(iNextIndexFromNode);
                            if (strengthFromNode(jElementAti2) >= i) {
                                iFindOrInsertNodeForRootCE = iNextIndexFromNode;
                                jElementAti = jElementAti2;
                            }
                        }
                    }
                    if (isTailoredNode(jElementAti)) {
                        return tempCEFromIndexAndStrength(iFindOrInsertNodeForRootCE, i);
                    }
                    return lastTertiaryCE;
                }
                if (!nodeHasAnyBefore(jElementAti)) {
                    iFindOrInsertNodeForRootCE = nextIndexFromNode(jElementAti);
                    if (iFindOrInsertNodeForRootCE != 0) {
                        jElementAti = this.nodes.elementAti(iFindOrInsertNodeForRootCE);
                        lastTertiaryCE = tempCEFromIndexAndStrength(iFindOrInsertNodeForRootCE, i);
                    } else {
                        long j7 = lastTertiaryCE >>> 32;
                        lastTertiaryCE = Collation.makeCE(this.rootElements.getPrimaryAfter(j7, this.rootElements.findPrimary(j7), this.baseData.isCompressiblePrimary(j7)));
                        iFindOrInsertNodeForRootCE = findOrInsertNodeForRootCE(lastTertiaryCE, 0);
                        jElementAti = this.nodes.elementAti(iFindOrInsertNodeForRootCE);
                    }
                }
                if (!nodeHasAnyBefore(jElementAti)) {
                    return lastTertiaryCE;
                }
                if (nodeHasBefore2(jElementAti)) {
                    iFindOrInsertNodeForRootCE = nextIndexFromNode(this.nodes.elementAti(nextIndexFromNode(jElementAti)));
                    jElementAti = this.nodes.elementAti(iFindOrInsertNodeForRootCE);
                }
                if (nodeHasBefore3(jElementAti)) {
                    iFindOrInsertNodeForRootCE = nextIndexFromNode(this.nodes.elementAti(nextIndexFromNode(jElementAti)));
                }
                return tempCEFromIndexAndStrength(iFindOrInsertNodeForRootCE, i);
            case 11:
                lastTertiaryCE = this.baseData.getSingleCE(19968);
                i = 0;
                z = false;
                iFindOrInsertNodeForRootCE = findOrInsertNodeForRootCE(lastTertiaryCE, i);
                jElementAti = this.nodes.elementAti(iFindOrInsertNodeForRootCE);
                if ((position.ordinal() & 1) != 0) {
                    while (true) {
                        iNextIndexFromNode = nextIndexFromNode(jElementAti);
                        if (iNextIndexFromNode != 0) {
                            jElementAti2 = this.nodes.elementAti(iNextIndexFromNode);
                            if (strengthFromNode(jElementAti2) >= i) {
                                iFindOrInsertNodeForRootCE = iNextIndexFromNode;
                                jElementAti = jElementAti2;
                            }
                        }
                    }
                    if (isTailoredNode(jElementAti)) {
                        return tempCEFromIndexAndStrength(iFindOrInsertNodeForRootCE, i);
                    }
                    return lastTertiaryCE;
                }
                if (!nodeHasAnyBefore(jElementAti)) {
                    iFindOrInsertNodeForRootCE = nextIndexFromNode(jElementAti);
                    if (iFindOrInsertNodeForRootCE != 0) {
                        jElementAti = this.nodes.elementAti(iFindOrInsertNodeForRootCE);
                        lastTertiaryCE = tempCEFromIndexAndStrength(iFindOrInsertNodeForRootCE, i);
                    } else {
                        long j8 = lastTertiaryCE >>> 32;
                        lastTertiaryCE = Collation.makeCE(this.rootElements.getPrimaryAfter(j8, this.rootElements.findPrimary(j8), this.baseData.isCompressiblePrimary(j8)));
                        iFindOrInsertNodeForRootCE = findOrInsertNodeForRootCE(lastTertiaryCE, 0);
                        jElementAti = this.nodes.elementAti(iFindOrInsertNodeForRootCE);
                    }
                }
                if (!nodeHasAnyBefore(jElementAti)) {
                    return lastTertiaryCE;
                }
                if (nodeHasBefore2(jElementAti)) {
                    iFindOrInsertNodeForRootCE = nextIndexFromNode(this.nodes.elementAti(nextIndexFromNode(jElementAti)));
                    jElementAti = this.nodes.elementAti(iFindOrInsertNodeForRootCE);
                }
                if (nodeHasBefore3(jElementAti)) {
                    iFindOrInsertNodeForRootCE = nextIndexFromNode(this.nodes.elementAti(nextIndexFromNode(jElementAti)));
                }
                return tempCEFromIndexAndStrength(iFindOrInsertNodeForRootCE, i);
            case 12:
                dk0.r("reset to [last implicit] not supported");
                return 0L;
            case 13:
                lastTertiaryCE = Collation.makeCE(4278321664L);
                z = true;
                i = 0;
                iFindOrInsertNodeForRootCE = findOrInsertNodeForRootCE(lastTertiaryCE, i);
                jElementAti = this.nodes.elementAti(iFindOrInsertNodeForRootCE);
                if ((position.ordinal() & 1) != 0) {
                    while (true) {
                        iNextIndexFromNode = nextIndexFromNode(jElementAti);
                        if (iNextIndexFromNode != 0) {
                            jElementAti2 = this.nodes.elementAti(iNextIndexFromNode);
                            if (strengthFromNode(jElementAti2) >= i) {
                                iFindOrInsertNodeForRootCE = iNextIndexFromNode;
                                jElementAti = jElementAti2;
                            }
                        }
                    }
                    if (isTailoredNode(jElementAti)) {
                        return tempCEFromIndexAndStrength(iFindOrInsertNodeForRootCE, i);
                    }
                    return lastTertiaryCE;
                }
                if (!nodeHasAnyBefore(jElementAti)) {
                    iFindOrInsertNodeForRootCE = nextIndexFromNode(jElementAti);
                    if (iFindOrInsertNodeForRootCE != 0) {
                        jElementAti = this.nodes.elementAti(iFindOrInsertNodeForRootCE);
                        lastTertiaryCE = tempCEFromIndexAndStrength(iFindOrInsertNodeForRootCE, i);
                    } else {
                        long j9 = lastTertiaryCE >>> 32;
                        lastTertiaryCE = Collation.makeCE(this.rootElements.getPrimaryAfter(j9, this.rootElements.findPrimary(j9), this.baseData.isCompressiblePrimary(j9)));
                        iFindOrInsertNodeForRootCE = findOrInsertNodeForRootCE(lastTertiaryCE, 0);
                        jElementAti = this.nodes.elementAti(iFindOrInsertNodeForRootCE);
                    }
                }
                if (!nodeHasAnyBefore(jElementAti)) {
                    return lastTertiaryCE;
                }
                if (nodeHasBefore2(jElementAti)) {
                    iFindOrInsertNodeForRootCE = nextIndexFromNode(this.nodes.elementAti(nextIndexFromNode(jElementAti)));
                    jElementAti = this.nodes.elementAti(iFindOrInsertNodeForRootCE);
                }
                if (nodeHasBefore3(jElementAti)) {
                    iFindOrInsertNodeForRootCE = nextIndexFromNode(this.nodes.elementAti(nextIndexFromNode(jElementAti)));
                }
                return tempCEFromIndexAndStrength(iFindOrInsertNodeForRootCE, i);
            case 14:
                og.i("LDML forbids tailoring to U+FFFF");
                return 0L;
            default:
                return 0L;
        }
    }

    private int getWeight16Before(int i, long j, int i2) {
        int iStrengthFromNode = strengthFromNode(j);
        int iWeight16FromNode = Collation.COMMON_WEIGHT16;
        int iWeight16FromNode2 = iStrengthFromNode == 2 ? weight16FromNode(j) : 1280;
        while (strengthFromNode(j) > 1) {
            j = this.nodes.elementAti(previousIndexFromNode(j));
        }
        if (isTailoredNode(j)) {
            return 256;
        }
        if (strengthFromNode(j) == 1) {
            iWeight16FromNode = weight16FromNode(j);
        }
        while (strengthFromNode(j) > 0) {
            j = this.nodes.elementAti(previousIndexFromNode(j));
        }
        if (isTailoredNode(j)) {
            return 256;
        }
        long jWeight32FromNode = weight32FromNode(j);
        CollationRootElements collationRootElements = this.rootElements;
        return i2 == 1 ? collationRootElements.getSecondaryBefore(jWeight32FromNode, iWeight16FromNode) : collationRootElements.getTertiaryBefore(jWeight32FromNode, iWeight16FromNode, iWeight16FromNode2);
    }

    private boolean ignorePrefix(CharSequence charSequence) {
        return !isFCD(charSequence);
    }

    private boolean ignoreString(CharSequence charSequence) {
        return !isFCD(charSequence) || Normalizer2Impl.Hangul.isHangul(charSequence.charAt(0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int indexFromTempCE(long j) {
        long j2 = j - 4629700417037541376L;
        return (((int) (j2 >> 24)) & 63) | (((int) (j2 >> 43)) & 1040384) | (((int) (j2 >> 42)) & 8128);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int indexFromTempCE32(int i) {
        int i2 = i - 1077937696;
        return ((i2 >> 8) & 63) | ((i2 >> 11) & 1040384) | ((i2 >> 10) & 8128);
    }

    private int insertNodeBetween(int i, int i2, long j) {
        int size = this.nodes.size();
        this.nodes.addElement(j | nodeFromPreviousIndex(i) | nodeFromNextIndex(i2));
        this.nodes.setElementAt(changeNodeNextIndex(this.nodes.elementAti(i), size), i);
        if (i2 != 0) {
            this.nodes.setElementAt(changeNodePreviousIndex(this.nodes.elementAti(i2), size), i2);
        }
        return size;
    }

    private int insertTailoredNodeAfter(int i, int i2) {
        int iNextIndexFromNode;
        if (i2 >= 1) {
            i = findCommonNode(i, 1);
            if (i2 >= 2) {
                i = findCommonNode(i, 2);
            }
        }
        long jElementAti = this.nodes.elementAti(i);
        while (true) {
            iNextIndexFromNode = nextIndexFromNode(jElementAti);
            if (iNextIndexFromNode == 0) {
                break;
            }
            long jElementAti2 = this.nodes.elementAti(iNextIndexFromNode);
            if (strengthFromNode(jElementAti2) <= i2) {
                break;
            }
            i = iNextIndexFromNode;
            jElementAti = jElementAti2;
        }
        return insertNodeBetween(i, iNextIndexFromNode, 8 | nodeFromStrength(i2));
    }

    private boolean isFCD(CharSequence charSequence) {
        return this.fcd.isNormalized(charSequence);
    }

    private static boolean isTailoredNode(long j) {
        return (j & 8) != 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isTempCE(long j) {
        int i = ((int) j) >>> 24;
        return 6 <= i && i <= 69;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isTempCE32(int i) {
        int i2;
        return (i & 255) >= 2 && 6 <= (i2 = (i >> 8) & 255) && i2 <= 69;
    }

    private void makeTailoredCEs() {
        long[] jArr;
        int i;
        int i2;
        int iWeight16FromNode;
        int secondaryBoundary;
        int i3;
        long j;
        long[] jArr2;
        int tertiaryBoundary;
        CollationWeights collationWeights = new CollationWeights();
        CollationWeights collationWeights2 = new CollationWeights();
        CollationWeights collationWeights3 = new CollationWeights();
        long[] buffer = this.nodes.getBuffer();
        for (int i4 = 0; i4 < this.rootPrimaryIndexes.size(); i4++) {
            long j2 = buffer[this.rootPrimaryIndexes.elementAti(i4)];
            long jWeight32FromNode = weight32FromNode(j2);
            int i5 = jWeight32FromNode == 0 ? 0 : Collation.COMMON_WEIGHT16;
            int iFindPrimary = jWeight32FromNode == 0 ? 0 : this.rootElements.findPrimary(jWeight32FromNode);
            int iWeight16FromNode2 = i5;
            int i6 = 0;
            int i7 = 0;
            boolean z = false;
            boolean z2 = false;
            int iNextIndexFromNode = nextIndexFromNode(j2);
            int tertiaryBoundary2 = iWeight16FromNode2;
            while (iNextIndexFromNode != 0) {
                long j3 = buffer[iNextIndexFromNode];
                int iNextIndexFromNode2 = nextIndexFromNode(j3);
                int iStrengthFromNode = strengthFromNode(j3);
                CollationWeights collationWeights4 = collationWeights2;
                if (iStrengthFromNode != 3) {
                    if (iStrengthFromNode == 2) {
                        if (isTailoredNode(j3)) {
                            if (i6 == 0) {
                                int iCountTailoredNodes = countTailoredNodes(buffer, iNextIndexFromNode2, 2) + 1;
                                if (tertiaryBoundary2 == 0) {
                                    tertiaryBoundary2 = this.rootElements.getTertiaryBoundary() - 256;
                                    jArr2 = buffer;
                                    tertiaryBoundary = ((int) this.rootElements.getFirstTertiaryCE()) & Collation.ONLY_TERTIARY_MASK;
                                } else {
                                    jArr2 = buffer;
                                    tertiaryBoundary = (z2 || z) ? tertiaryBoundary2 == 256 ? Collation.COMMON_WEIGHT16 : this.rootElements.getTertiaryBoundary() : this.rootElements.getTertiaryAfter(iFindPrimary, iWeight16FromNode2, tertiaryBoundary2);
                                }
                                collationWeights3.initForTertiary();
                                if (!collationWeights3.allocWeights(tertiaryBoundary2, tertiaryBoundary, iCountTailoredNodes)) {
                                    dk0.r("tertiary tailoring gap too small");
                                    return;
                                }
                                i6 = 1;
                            } else {
                                jArr2 = buffer;
                            }
                            iWeight16FromNode = (int) collationWeights3.nextWeight();
                            jArr = jArr2;
                        } else {
                            collationWeights3 = collationWeights3;
                            jWeight32FromNode = jWeight32FromNode;
                            iWeight16FromNode = weight16FromNode(j3);
                            jArr = buffer;
                            i6 = 0;
                        }
                        i2 = 0;
                    } else {
                        jWeight32FromNode = jWeight32FromNode;
                        long[] jArr3 = buffer;
                        collationWeights3 = collationWeights3;
                        if (iStrengthFromNode != 1) {
                            jArr = jArr3;
                            i = Collation.COMMON_WEIGHT16;
                            i2 = 0;
                            if (!z2) {
                                int iCountTailoredNodes2 = countTailoredNodes(jArr, iNextIndexFromNode2, 0) + 1;
                                boolean zIsCompressiblePrimary = this.baseData.isCompressiblePrimary(jWeight32FromNode);
                                long primaryAfter = this.rootElements.getPrimaryAfter(jWeight32FromNode, iFindPrimary, zIsCompressiblePrimary);
                                collationWeights.initForPrimary(zIsCompressiblePrimary);
                                if (!collationWeights.allocWeights(jWeight32FromNode, primaryAfter, iCountTailoredNodes2)) {
                                    dk0.r("primary tailoring gap too small");
                                    return;
                                }
                                z2 = true;
                            }
                            jWeight32FromNode = collationWeights.nextWeight();
                            z = false;
                            iWeight16FromNode2 = 1280;
                        } else if (isTailoredNode(j3)) {
                            jArr = jArr3;
                            if (z) {
                                i = Collation.COMMON_WEIGHT16;
                            } else {
                                int iCountTailoredNodes3 = countTailoredNodes(jArr, iNextIndexFromNode2, 1) + 1;
                                if (iWeight16FromNode2 == 0) {
                                    iWeight16FromNode2 = this.rootElements.getSecondaryBoundary() - 256;
                                    secondaryBoundary = (int) (this.rootElements.getFirstSecondaryCE() >> 16);
                                } else if (z2) {
                                    secondaryBoundary = iWeight16FromNode2 == 256 ? Collation.COMMON_WEIGHT16 : this.rootElements.getSecondaryBoundary();
                                } else {
                                    secondaryBoundary = this.rootElements.getSecondaryAfter(iFindPrimary, iWeight16FromNode2);
                                }
                                if (iWeight16FromNode2 == 1280) {
                                    iWeight16FromNode2 = this.rootElements.getLastCommonSecondary();
                                }
                                collationWeights4.initForSecondary();
                                i = Collation.COMMON_WEIGHT16;
                                if (!collationWeights4.allocWeights(iWeight16FromNode2, secondaryBoundary, iCountTailoredNodes3)) {
                                    dk0.r("secondary tailoring gap too small");
                                    return;
                                }
                                z = true;
                            }
                            iWeight16FromNode2 = (int) collationWeights4.nextWeight();
                            i2 = 0;
                        } else {
                            jArr = jArr3;
                            i = Collation.COMMON_WEIGHT16;
                            iWeight16FromNode2 = weight16FromNode(j3);
                            i2 = 0;
                            z = false;
                        }
                        iWeight16FromNode = iWeight16FromNode2 == 0 ? i2 : i;
                        i6 = i2;
                    }
                    tertiaryBoundary2 = iWeight16FromNode;
                    i3 = i2;
                    j = jWeight32FromNode;
                } else {
                    if (i7 == 3) {
                        dk0.r("quaternary tailoring gap too small");
                        return;
                    }
                    int i8 = i7 + 1;
                    collationWeights3 = collationWeights3;
                    j = jWeight32FromNode;
                    i3 = i8;
                    jArr = buffer;
                }
                if (isTailoredNode(j3)) {
                    jArr[iNextIndexFromNode] = Collation.makeCE(j, iWeight16FromNode2, tertiaryBoundary2, i3);
                }
                CollationWeights collationWeights5 = collationWeights3;
                i7 = i3;
                jWeight32FromNode = j;
                collationWeights3 = collationWeights5;
                iNextIndexFromNode = iNextIndexFromNode2;
                buffer = jArr;
                collationWeights2 = collationWeights4;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0064  */
    /* JADX WARN: Code duplicated, block: B:30:0x0076  */
    /* JADX WARN: Code duplicated, block: B:31:0x0080 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:33:0x0083  */
    /* JADX WARN: Code duplicated, block: B:36:0x0042 A[EDGE_INSN: B:36:0x0042->B:16:0x0042 BREAK  A[LOOP:0: B:9:0x0029->B:34:0x0093], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:39:0x0082 A[SYNTHETIC] */
    private boolean mergeCompositeIntoString(CharSequence charSequence, int i, int i2, CharSequence charSequence2, StringBuilder sb, StringBuilder sb2) {
        int iCodePointAt;
        int combiningClass;
        int iOffsetByCodePoints = Character.offsetByCodePoints(charSequence2, 0, 1);
        if (iOffsetByCodePoints == charSequence2.length() || equalSubSequences(charSequence, i, charSequence2, iOffsetByCodePoints)) {
            return false;
        }
        sb.setLength(0);
        sb.append(charSequence, 0, i);
        sb2.setLength(0);
        sb2.append(charSequence, 0, i - iOffsetByCodePoints);
        sb2.appendCodePoint(i2);
        int iCodePointAt2 = -1;
        int combiningClass2 = 0;
        int i3 = 0;
        while (true) {
            if (iCodePointAt2 >= 0) {
                if (iOffsetByCodePoints >= charSequence2.length()) {
                    break;
                }
                iCodePointAt = Character.codePointAt(charSequence2, iOffsetByCodePoints);
                combiningClass = this.nfd.getCombiningClass(iCodePointAt);
                if (combiningClass != 0 || combiningClass2 < combiningClass) {
                    return false;
                }
                if (combiningClass < combiningClass2) {
                    sb.appendCodePoint(iCodePointAt);
                    iOffsetByCodePoints = Character.charCount(iCodePointAt) + iOffsetByCodePoints;
                } else {
                    if (iCodePointAt != iCodePointAt2) {
                        return false;
                    }
                    sb.appendCodePoint(iCodePointAt);
                    int iCharCount = Character.charCount(iCodePointAt) + iOffsetByCodePoints;
                    i = Character.charCount(iCodePointAt) + i;
                    iOffsetByCodePoints = iCharCount;
                    iCodePointAt2 = -1;
                }
                i3 = combiningClass;
            } else {
                if (i >= charSequence.length()) {
                    break;
                }
                iCodePointAt2 = Character.codePointAt(charSequence, i);
                combiningClass2 = this.nfd.getCombiningClass(iCodePointAt2);
                if (iOffsetByCodePoints >= charSequence2.length()) {
                    break;
                    break;
                }
                iCodePointAt = Character.codePointAt(charSequence2, iOffsetByCodePoints);
                combiningClass = this.nfd.getCombiningClass(iCodePointAt);
                if (combiningClass != 0) {
                    return false;
                }
                if (combiningClass < combiningClass2) {
                    sb.appendCodePoint(iCodePointAt);
                    iOffsetByCodePoints = Character.charCount(iCodePointAt) + iOffsetByCodePoints;
                } else {
                    if (iCodePointAt != iCodePointAt2) {
                        return false;
                    }
                    sb.appendCodePoint(iCodePointAt);
                    int iCharCount2 = Character.charCount(iCodePointAt) + iOffsetByCodePoints;
                    i = Character.charCount(iCodePointAt) + i;
                    iOffsetByCodePoints = iCharCount2;
                    iCodePointAt2 = -1;
                }
                i3 = combiningClass;
            }
        }
        if (iCodePointAt2 >= 0) {
            if (combiningClass2 < i3) {
                return false;
            }
            sb.append(charSequence, i, charSequence.length());
            sb2.append(charSequence, i, charSequence.length());
        } else if (iOffsetByCodePoints < charSequence2.length()) {
            sb.append(charSequence2, iOffsetByCodePoints, charSequence2.length());
        }
        return true;
    }

    private static int nextIndexFromNode(long j) {
        return (((int) j) >> 8) & MAX_INDEX;
    }

    private static long nodeFromNextIndex(int i) {
        return ((long) i) << 8;
    }

    private static long nodeFromPreviousIndex(int i) {
        return ((long) i) << 28;
    }

    private static long nodeFromStrength(int i) {
        return i;
    }

    private static long nodeFromWeight16(int i) {
        return ((long) i) << 48;
    }

    private static long nodeFromWeight32(long j) {
        return j << 32;
    }

    private static boolean nodeHasAnyBefore(long j) {
        return (j & 96) != 0;
    }

    private static boolean nodeHasBefore2(long j) {
        return (j & 64) != 0;
    }

    private static boolean nodeHasBefore3(long j) {
        return (j & 32) != 0;
    }

    private static int previousIndexFromNode(long j) {
        return ((int) (j >> 28)) & MAX_INDEX;
    }

    private static boolean sameCEs(long[] jArr, int i, long[] jArr2, int i2) {
        if (i != i2) {
            return false;
        }
        for (int i3 = 0; i3 < i; i3++) {
            if (jArr[i3] != jArr2[i3]) {
                return false;
            }
        }
        return true;
    }

    private void setCaseBits(CharSequence charSequence) {
        char c;
        long j;
        int i = 0;
        for (int i2 = 0; i2 < this.cesLength; i2++) {
            if (ceStrength(this.ces[i2]) == 0) {
                i++;
            }
        }
        long j2 = 0;
        if (i > 0) {
            UTF16CollationIterator uTF16CollationIterator = new UTF16CollationIterator(this.baseData, false, charSequence, 0);
            int iFetchCEs = uTF16CollationIterator.fetchCEs() - 1;
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            long j3 = 0;
            while (true) {
                c = 14;
                if (i3 >= iFetchCEs) {
                    break;
                }
                long ce = uTF16CollationIterator.getCE(i3);
                if ((ce >>> 32) != j2) {
                    int i6 = i4 + 1;
                    int i7 = (((int) ce) >> 14) & 3;
                    if (i6 >= i) {
                        if (i6 != i) {
                            i4 = i6;
                            if (i7 != i5) {
                                i5 = 1;
                                break;
                            }
                        } else {
                            i5 = i7;
                        }
                    } else {
                        j3 |= ((long) i7) << (i4 * 2);
                    }
                    i4 = i6;
                }
                i3++;
                j2 = 0;
            }
            j = i4 >= i ? j3 | (((long) i5) << ((i - 1) * 2)) : j3;
        } else {
            c = 14;
            j = 0;
        }
        for (int i8 = 0; i8 < this.cesLength; i8++) {
            long j4 = (-49153) & this.ces[i8];
            int iCeStrength = ceStrength(j4);
            if (iCeStrength == 0) {
                j4 |= (3 & j) << c;
                j >>>= 2;
            } else if (iCeStrength == 2) {
                j4 |= 32768;
            }
            this.ces[i8] = j4;
        }
    }

    private static int strengthFromNode(long j) {
        return ((int) j) & 3;
    }

    private static int strengthFromTempCE(long j) {
        return (((int) j) >> 8) & 3;
    }

    private static long tempCEFromIndexAndStrength(int i, int i2) {
        return (((long) (1040384 & i)) << 43) + 4629700417037541376L + (((long) (i & 8128)) << 42) + ((long) ((i & 63) << 24)) + ((long) (i2 << 8));
    }

    private static int weight16FromNode(long j) {
        return ((int) (j >> 48)) & DateTimePatternGenerator.MATCH_ALL_FIELDS_LENGTH;
    }

    private static long weight32FromNode(long j) {
        return j >>> 32;
    }

    @Override // com.ibm.icu.impl.coll.CollationRuleParser.Sink
    public void addRelation(int i, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3) {
        CollationBuilder collationBuilder;
        String strNormalize = charSequence.length() == 0 ? "" : this.nfd.normalize(charSequence);
        String strNormalize2 = this.nfd.normalize(charSequence2);
        int length = strNormalize2.length();
        if (length >= 2) {
            char cCharAt = strNormalize2.charAt(0);
            if (Normalizer2Impl.Hangul.isJamoL(cCharAt) || Normalizer2Impl.Hangul.isJamoV(cCharAt)) {
                dk0.r("contractions starting with conjoining Jamo L or V not supported");
                return;
            }
            char cCharAt2 = strNormalize2.charAt(length - 1);
            if (Normalizer2Impl.Hangul.isJamoL(cCharAt2) || (Normalizer2Impl.Hangul.isJamoV(cCharAt2) && Normalizer2Impl.Hangul.isJamoL(strNormalize2.charAt(length - 2)))) {
                dk0.r("contractions ending with conjoining Jamo L or L+V not supported");
                return;
            }
        }
        if (i != 15) {
            int iFindOrInsertNodeForCEs = findOrInsertNodeForCEs(i);
            long j = this.ces[this.cesLength - 1];
            if (i == 0 && !isTempCE(j) && (j >>> 32) == 0) {
                dk0.r("tailoring primary after ignorables not supported");
                return;
            }
            if (i == 3 && j == 0) {
                dk0.r("tailoring quaternary after tertiary ignorables not supported");
                return;
            }
            int iInsertTailoredNodeAfter = insertTailoredNodeAfter(iFindOrInsertNodeForCEs, i);
            int iCeStrength = ceStrength(j);
            if (i >= iCeStrength) {
                i = iCeStrength;
            }
            this.ces[this.cesLength - 1] = tempCEFromIndexAndStrength(iInsertTailoredNodeAfter, i);
        }
        setCaseBits(strNormalize2);
        int i2 = this.cesLength;
        if (charSequence3.length() != 0) {
            int cEs = this.dataBuilder.getCEs(this.nfd.normalize(charSequence3), this.ces, this.cesLength);
            this.cesLength = cEs;
            if (cEs > 31) {
                og.i("extension string adds too many collation elements (more than 31 total)");
                return;
            }
        }
        int iAddIfDifferent = -1;
        if ((strNormalize.contentEquals(charSequence) && strNormalize2.contentEquals(charSequence2)) || ignorePrefix(charSequence) || ignoreString(charSequence2)) {
            collationBuilder = this;
        } else {
            iAddIfDifferent = addIfDifferent(charSequence, charSequence2, this.ces, this.cesLength, -1);
            collationBuilder = this;
        }
        collationBuilder.addWithClosure(strNormalize, strNormalize2, collationBuilder.ces, collationBuilder.cesLength, iAddIfDifferent);
        collationBuilder.cesLength = i2;
    }

    @Override // com.ibm.icu.impl.coll.CollationRuleParser.Sink
    public void addReset(int i, CharSequence charSequence) {
        int iFindOrInsertWeakNode;
        int iWeight16FromNode;
        if (charSequence.charAt(0) == 65534) {
            this.ces[0] = getSpecialResetPosition(charSequence);
            this.cesLength = 1;
        } else {
            int cEs = this.dataBuilder.getCEs(this.nfd.normalize(charSequence), this.ces, 0);
            this.cesLength = cEs;
            if (cEs > 31) {
                og.i("reset position maps to too many collation elements (more than 31)");
                return;
            }
        }
        if (i == 15) {
            return;
        }
        int iFindOrInsertNodeForCEs = findOrInsertNodeForCEs(i);
        long jElementAti = this.nodes.elementAti(iFindOrInsertNodeForCEs);
        while (strengthFromNode(jElementAti) > i) {
            iFindOrInsertNodeForCEs = previousIndexFromNode(jElementAti);
            jElementAti = this.nodes.elementAti(iFindOrInsertNodeForCEs);
        }
        if (strengthFromNode(jElementAti) == i && isTailoredNode(jElementAti)) {
            iFindOrInsertWeakNode = previousIndexFromNode(jElementAti);
        } else if (i == 0) {
            long jWeight32FromNode = weight32FromNode(jElementAti);
            if (jWeight32FromNode == 0) {
                dk0.r("reset primary-before ignorable not possible");
                return;
            }
            if (jWeight32FromNode <= this.rootElements.getFirstPrimary()) {
                dk0.r("reset primary-before first non-ignorable not supported");
                return;
            }
            if (jWeight32FromNode == 4278321664L) {
                dk0.r("reset primary-before [first trailing] not supported");
                return;
            }
            iFindOrInsertWeakNode = findOrInsertNodeForPrimary(this.rootElements.getPrimaryBefore(jWeight32FromNode, this.baseData.isCompressiblePrimary(jWeight32FromNode)));
            while (true) {
                int iNextIndexFromNode = nextIndexFromNode(this.nodes.elementAti(iFindOrInsertWeakNode));
                if (iNextIndexFromNode == 0) {
                    break;
                } else {
                    iFindOrInsertWeakNode = iNextIndexFromNode;
                }
            }
        } else {
            int iFindCommonNode = findCommonNode(iFindOrInsertNodeForCEs, 1);
            if (i >= 2) {
                iFindCommonNode = findCommonNode(iFindCommonNode, 2);
            }
            long jElementAti2 = this.nodes.elementAti(iFindCommonNode);
            if (strengthFromNode(jElementAti2) != i) {
                iFindOrInsertWeakNode = findOrInsertWeakNode(iFindCommonNode, getWeight16Before(iFindCommonNode, jElementAti2, i), i);
            } else {
                if (weight16FromNode(jElementAti2) == 0) {
                    throw new UnsupportedOperationException(i == 1 ? "reset secondary-before secondary ignorable not possible" : "reset tertiary-before completely ignorable not possible");
                }
                int weight16Before = getWeight16Before(iFindCommonNode, jElementAti2, i);
                int iPreviousIndexFromNode = previousIndexFromNode(jElementAti2);
                int iPreviousIndexFromNode2 = iPreviousIndexFromNode;
                while (true) {
                    long jElementAti3 = this.nodes.elementAti(iPreviousIndexFromNode2);
                    int iStrengthFromNode = strengthFromNode(jElementAti3);
                    if (iStrengthFromNode >= i) {
                        if (iStrengthFromNode == i && !isTailoredNode(jElementAti3)) {
                            iWeight16FromNode = weight16FromNode(jElementAti3);
                            break;
                        }
                        iPreviousIndexFromNode2 = previousIndexFromNode(jElementAti3);
                    } else {
                        iWeight16FromNode = Collation.COMMON_WEIGHT16;
                        break;
                    }
                }
                if (iWeight16FromNode != weight16Before) {
                    iPreviousIndexFromNode = insertNodeBetween(iPreviousIndexFromNode, iFindCommonNode, nodeFromWeight16(weight16Before) | nodeFromStrength(i));
                }
                iFindOrInsertWeakNode = iPreviousIndexFromNode;
            }
            i = ceStrength(this.ces[this.cesLength - 1]);
        }
        this.ces[this.cesLength - 1] = tempCEFromIndexAndStrength(iFindOrInsertWeakNode, i);
    }

    @Override // com.ibm.icu.impl.coll.CollationRuleParser.Sink
    public void optimize(UnicodeSet unicodeSet) {
        this.optimizeSet.addAll(unicodeSet);
    }

    public CollationTailoring parseAndBuild(String str) throws ParseException {
        if (this.baseData.rootElements == null) {
            dk0.r("missing root elements data, tailoring not supported");
            return null;
        }
        CollationTailoring collationTailoring = new CollationTailoring(this.base.settings);
        CollationRuleParser collationRuleParser = new CollationRuleParser(this.baseData);
        this.variableTop = ((CollationSettings) this.base.settings.readOnly()).variableTop;
        collationRuleParser.setSink(this);
        collationRuleParser.setImporter(new BundleImporter());
        CollationSettings collationSettings = (CollationSettings) collationTailoring.settings.copyOnWrite();
        collationRuleParser.parse(str, collationSettings);
        if (this.dataBuilder.hasMappings()) {
            makeTailoredCEs();
            closeOverComposites();
            finalizeCEs();
            this.optimizeSet.add(0, 127);
            this.optimizeSet.add(192, 255);
            this.optimizeSet.remove(Normalizer2Impl.Hangul.HANGUL_BASE, Normalizer2Impl.Hangul.HANGUL_END);
            this.dataBuilder.optimize(this.optimizeSet);
            collationTailoring.ensureOwnedData();
            if (this.fastLatinEnabled) {
                this.dataBuilder.enableFastLatin();
            }
            this.dataBuilder.build(collationTailoring.ownedData);
            this.dataBuilder = null;
        } else {
            collationTailoring.data = this.baseData;
        }
        collationSettings.fastLatinOptions = CollationFastLatin.getOptions(collationTailoring.data, collationSettings, collationSettings.fastLatinPrimaries);
        collationTailoring.setRules(str);
        collationTailoring.setVersion(this.base.version, 0);
        return collationTailoring;
    }

    @Override // com.ibm.icu.impl.coll.CollationRuleParser.Sink
    public void suppressContractions(UnicodeSet unicodeSet) {
        this.dataBuilder.suppressContractions(unicodeSet);
    }
}
