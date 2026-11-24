package com.ibm.icu.impl.coll;

import com.ibm.icu.impl.Norm2AllModes;
import com.ibm.icu.impl.Normalizer2Impl;
import com.ibm.icu.impl.Trie2;
import com.ibm.icu.impl.Trie2Writable;
import com.ibm.icu.impl.UCharacterProperty;
import com.ibm.icu.lang.UCharacter;
import com.ibm.icu.text.UnicodeSet;
import com.ibm.icu.text.UnicodeSetIterator;
import com.ibm.icu.util.CharsTrie;
import com.ibm.icu.util.CharsTrieBuilder;
import com.ibm.icu.util.StringTrieBuilder;
import defpackage.dk0;
import defpackage.og;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
final class CollationDataBuilder {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int IS_BUILDER_JAMO_CE32 = 256;
    protected UnicodeSet contextChars = new UnicodeSet();
    protected StringBuilder contexts = new StringBuilder();
    private int contextsEra = 0;
    protected UnicodeSet unsafeBackwardSet = new UnicodeSet();
    protected Normalizer2Impl nfcImpl = Norm2AllModes.getNFCInstance().impl;
    protected CollationData base = null;
    protected CollationSettings baseSettings = null;
    protected Trie2Writable trie = null;
    protected UVector32 ce32s = new UVector32();
    protected UVector64 ce64s = new UVector64();
    protected ArrayList<ConditionalCE32> conditionalCE32s = new ArrayList<>();
    protected boolean modified = false;
    protected boolean fastLatinEnabled = false;
    protected CollationFastLatinBuilder fastLatinBuilder = null;
    protected DataBuilderCollationIterator collIter = null;

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public interface CEModifier {
        long modifyCE(long j);

        long modifyCE32(int i);
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class ConditionalCE32 {
        int ce32;
        String context;
        int era = -1;
        int defaultCE32 = 1;
        int builtCE32 = 1;
        int next = -1;

        public ConditionalCE32(String str, int i) {
            this.context = str;
            this.ce32 = i;
        }

        public boolean hasContext() {
            return this.context.length() > 1;
        }

        public int prefixLength() {
            return this.context.charAt(0);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class CopyHelper {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        CollationDataBuilder dest;
        long[] modifiedCEs = new long[31];
        CEModifier modifier;
        CollationDataBuilder src;

        public CopyHelper(CollationDataBuilder collationDataBuilder, CollationDataBuilder collationDataBuilder2, CEModifier cEModifier) {
            this.src = collationDataBuilder;
            this.dest = collationDataBuilder2;
            this.modifier = cEModifier;
        }

        /* JADX WARN: Code duplicated, block: B:24:0x0069 A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:25:0x006b  */
        /* JADX WARN: Code duplicated, block: B:65:0x0073 A[SYNTHETIC] */
        public int copyCE32(int i) {
            if (!Collation.isSpecialCE32(i)) {
                long jModifyCE32 = this.modifier.modifyCE32(i);
                return jModifyCE32 != Collation.NO_CE ? this.dest.encodeOneCE(jModifyCE32) : i;
            }
            int iTagFromCE32 = Collation.tagFromCE32(i);
            if (iTagFromCE32 == 5) {
                int[] buffer = this.src.ce32s.getBuffer();
                int iIndexFromCE32 = Collation.indexFromCE32(i);
                int iLengthFromCE32 = Collation.lengthFromCE32(i);
                boolean z = false;
                for (int i2 = 0; i2 < iLengthFromCE32; i2++) {
                    int i3 = buffer[iIndexFromCE32 + i2];
                    if (!Collation.isSpecialCE32(i3)) {
                        long jModifyCE33 = this.modifier.modifyCE32(i3);
                        if (jModifyCE33 != Collation.NO_CE) {
                            if (!z) {
                                for (int i4 = 0; i4 < i2; i4++) {
                                    this.modifiedCEs[i4] = Collation.ceFromCE32(buffer[iIndexFromCE32 + i4]);
                                }
                                z = true;
                            }
                            this.modifiedCEs[i2] = jModifyCE33;
                        } else if (z) {
                            this.modifiedCEs[i2] = Collation.ceFromCE32(i3);
                        }
                    } else if (z) {
                        this.modifiedCEs[i2] = Collation.ceFromCE32(i3);
                    }
                }
                CollationDataBuilder collationDataBuilder = this.dest;
                return z ? collationDataBuilder.encodeCEs(this.modifiedCEs, iLengthFromCE32) : collationDataBuilder.encodeExpansion32(buffer, iIndexFromCE32, iLengthFromCE32);
            }
            if (iTagFromCE32 == 6) {
                long[] buffer2 = this.src.ce64s.getBuffer();
                int iIndexFromCE33 = Collation.indexFromCE32(i);
                int iLengthFromCE33 = Collation.lengthFromCE32(i);
                boolean z2 = false;
                for (int i5 = 0; i5 < iLengthFromCE33; i5++) {
                    long j = buffer2[iIndexFromCE33 + i5];
                    long jModifyCE = this.modifier.modifyCE(j);
                    if (jModifyCE != Collation.NO_CE) {
                        if (!z2) {
                            for (int i6 = 0; i6 < i5; i6++) {
                                this.modifiedCEs[i6] = buffer2[iIndexFromCE33 + i6];
                            }
                            z2 = true;
                        }
                        this.modifiedCEs[i5] = jModifyCE;
                    } else if (z2) {
                        this.modifiedCEs[i5] = j;
                    }
                }
                CollationDataBuilder collationDataBuilder2 = this.dest;
                return z2 ? collationDataBuilder2.encodeCEs(this.modifiedCEs, iLengthFromCE33) : collationDataBuilder2.encodeExpansion(buffer2, iIndexFromCE33, iLengthFromCE33);
            }
            if (iTagFromCE32 != 7) {
                return i;
            }
            ConditionalCE32 conditionalCE32ForCE32 = this.src.getConditionalCE32ForCE32(i);
            int iAddConditionalCE32 = this.dest.addConditionalCE32(conditionalCE32ForCE32.context, copyCE32(conditionalCE32ForCE32.ce32));
            int iMakeBuilderContextCE32 = CollationDataBuilder.makeBuilderContextCE32(iAddConditionalCE32);
            while (true) {
                int i7 = conditionalCE32ForCE32.next;
                if (i7 < 0) {
                    return iMakeBuilderContextCE32;
                }
                conditionalCE32ForCE32 = this.src.getConditionalCE32(i7);
                ConditionalCE32 conditionalCE32 = this.dest.getConditionalCE32(iAddConditionalCE32);
                int iAddConditionalCE33 = this.dest.addConditionalCE32(conditionalCE32ForCE32.context, copyCE32(conditionalCE32ForCE32.ce32));
                this.dest.unsafeBackwardSet.addAll(conditionalCE32ForCE32.context.substring(conditionalCE32ForCE32.prefixLength() + 1));
                conditionalCE32.next = iAddConditionalCE33;
                iAddConditionalCE32 = iAddConditionalCE33;
            }
        }

        public void copyRangeCE32(int i, int i2, int i3) {
            int iCopyCE32 = copyCE32(i3);
            this.dest.trie.setRange(i, i2, iCopyCE32, true);
            if (CollationDataBuilder.isBuilderContextCE32(iCopyCE32)) {
                this.dest.contextChars.add(i, i2);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class DataBuilderCollationIterator extends CollationIterator {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        protected final CollationDataBuilder builder;
        protected final CollationData builderData;
        protected final int[] jamoCE32s;
        protected int pos;
        protected CharSequence s;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DataBuilderCollationIterator(CollationDataBuilder collationDataBuilder, CollationData collationData) {
            super(collationData, false);
            this.jamoCE32s = new int[67];
            this.builder = collationDataBuilder;
            this.builderData = collationData;
            collationData.base = collationDataBuilder.base;
            for (int i = 0; i < 67; i++) {
                this.jamoCE32s[i] = Collation.makeCE32FromTagAndIndex(7, CollationDataBuilder.jamoCpFromIndex(i)) | 256;
            }
            this.builderData.jamoCE32s = this.jamoCE32s;
        }

        @Override // com.ibm.icu.impl.coll.CollationIterator
        public void backwardNumCodePoints(int i) {
            this.pos = Character.offsetByCodePoints(this.s, this.pos, -i);
        }

        public int fetchCEs(CharSequence charSequence, int i, long[] jArr, int i2) {
            int ce32;
            CollationData collationData;
            this.builderData.ce32s = this.builder.ce32s.getBuffer();
            this.builderData.ces = this.builder.ce64s.getBuffer();
            this.builderData.contexts = this.builder.contexts.toString();
            reset();
            this.s = charSequence;
            this.pos = i;
            while (this.pos < this.s.length()) {
                clearCEs();
                int iCodePointAt = Character.codePointAt(this.s, this.pos);
                this.pos = Character.charCount(iCodePointAt) + this.pos;
                int i3 = this.builder.trie.get(iCodePointAt);
                if (i3 == 192) {
                    collationData = this.builder.base;
                    ce32 = collationData.getCE32(iCodePointAt);
                } else {
                    ce32 = i3;
                    collationData = this.builderData;
                }
                appendCEsFromCE32(collationData, iCodePointAt, ce32, true);
                for (int i4 = 0; i4 < getCEsLength(); i4++) {
                    long ce = getCE(i4);
                    if (ce != 0) {
                        if (i2 < 31) {
                            jArr[i2] = ce;
                        }
                        i2++;
                    }
                }
            }
            return i2;
        }

        @Override // com.ibm.icu.impl.coll.CollationIterator
        public void forwardNumCodePoints(int i) {
            this.pos = Character.offsetByCodePoints(this.s, this.pos, i);
        }

        @Override // com.ibm.icu.impl.coll.CollationIterator
        public int getCE32FromBuilderData(int i) {
            if ((i & 256) != 0) {
                return this.builder.trie.get(Collation.indexFromCE32(i));
            }
            ConditionalCE32 conditionalCE32ForCE32 = this.builder.getConditionalCE32ForCE32(i);
            if (conditionalCE32ForCE32.builtCE32 == 1 || conditionalCE32ForCE32.era != this.builder.contextsEra) {
                try {
                    conditionalCE32ForCE32.builtCE32 = this.builder.buildContext(conditionalCE32ForCE32);
                } catch (IndexOutOfBoundsException unused) {
                    this.builder.clearContexts();
                    conditionalCE32ForCE32.builtCE32 = this.builder.buildContext(conditionalCE32ForCE32);
                }
                conditionalCE32ForCE32.era = this.builder.contextsEra;
                this.builderData.contexts = this.builder.contexts.toString();
            }
            return conditionalCE32ForCE32.builtCE32;
        }

        @Override // com.ibm.icu.impl.coll.CollationIterator
        public int getDataCE32(int i) {
            return this.builder.trie.get(i);
        }

        @Override // com.ibm.icu.impl.coll.CollationIterator
        public int getOffset() {
            return this.pos;
        }

        @Override // com.ibm.icu.impl.coll.CollationIterator
        public int nextCodePoint() {
            if (this.pos == this.s.length()) {
                return -1;
            }
            int iCodePointAt = Character.codePointAt(this.s, this.pos);
            this.pos = Character.charCount(iCodePointAt) + this.pos;
            return iCodePointAt;
        }

        @Override // com.ibm.icu.impl.coll.CollationIterator
        public int previousCodePoint() {
            int i = this.pos;
            if (i == 0) {
                return -1;
            }
            int iCodePointBefore = Character.codePointBefore(this.s, i);
            this.pos -= Character.charCount(iCodePointBefore);
            return iCodePointBefore;
        }

        @Override // com.ibm.icu.impl.coll.CollationIterator
        public void resetToOffset(int i) {
            reset();
            this.pos = i;
        }
    }

    public CollationDataBuilder() {
        this.ce32s.addElement(0);
    }

    public static int encodeOneCEAsCE32(long j) {
        long j2 = j >>> 32;
        int i = (int) j;
        int i2 = 65535 & i;
        if ((281470698455295L & j) == 0) {
            return ((int) j2) | (i >>> 16) | (i2 >> 8);
        }
        if ((j & 1099511627775L) == 83887360) {
            return Collation.makeLongPrimaryCE32(j2);
        }
        if (j2 == 0 && (i & 255) == 0) {
            return Collation.makeLongSecondaryCE32(i);
        }
        return 1;
    }

    private static void enumRangeForCopy(int i, int i2, int i3, CopyHelper copyHelper) {
        if (i3 == -1 || i3 == 192) {
            return;
        }
        copyHelper.copyRangeCE32(i, i2, i3);
    }

    public static boolean isBuilderContextCE32(int i) {
        return Collation.hasCE32Tag(i, 7);
    }

    public static int jamoCpFromIndex(int i) {
        if (i < 19) {
            return i + Normalizer2Impl.Hangul.JAMO_L_BASE;
        }
        return i + (-19) < 21 ? i + 4430 : i + 4480;
    }

    public static int makeBuilderContextCE32(int i) {
        return Collation.makeCE32FromTagAndIndex(7, i);
    }

    public void add(CharSequence charSequence, CharSequence charSequence2, long[] jArr, int i) {
        addCE32(charSequence, charSequence2, encodeCEs(jArr, i));
    }

    public int addCE(long j) {
        int size = this.ce64s.size();
        int i = 0;
        while (true) {
            UVector64 uVector64 = this.ce64s;
            if (i >= size) {
                uVector64.addElement(j);
                return size;
            }
            if (j == uVector64.elementAti(i)) {
                return i;
            }
            i++;
        }
    }

    public void addCE32(CharSequence charSequence, CharSequence charSequence2, int i) {
        ConditionalCE32 conditionalCE32ForCE32;
        if (charSequence2.length() == 0) {
            og.i("mapping from empty string");
            return;
        }
        if (!isMutable()) {
            og.n("attempt to add mappings after build()");
            return;
        }
        int iCodePointAt = Character.codePointAt(charSequence2, 0);
        int iCharCount = Character.charCount(iCodePointAt);
        int iCopyFromBaseCE32 = this.trie.get(iCodePointAt);
        boolean z = charSequence.length() != 0 || charSequence2.length() > iCharCount;
        if (iCopyFromBaseCE32 == 192) {
            CollationData collationData = this.base;
            int finalCE32 = collationData.getFinalCE32(collationData.getCE32(iCodePointAt));
            if (z || Collation.ce32HasContext(finalCE32)) {
                iCopyFromBaseCE32 = copyFromBaseCE32(iCodePointAt, finalCE32, true);
                this.trie.set(iCodePointAt, iCopyFromBaseCE32);
            }
        }
        if (z) {
            if (isBuilderContextCE32(iCopyFromBaseCE32)) {
                conditionalCE32ForCE32 = getConditionalCE32ForCE32(iCopyFromBaseCE32);
                conditionalCE32ForCE32.builtCE32 = 1;
            } else {
                int iAddConditionalCE32 = addConditionalCE32("\u0000", iCopyFromBaseCE32);
                this.trie.set(iCodePointAt, makeBuilderContextCE32(iAddConditionalCE32));
                this.contextChars.add(iCodePointAt);
                conditionalCE32ForCE32 = getConditionalCE32(iAddConditionalCE32);
            }
            CharSequence charSequenceSubSequence = charSequence2.subSequence(iCharCount, charSequence2.length());
            StringBuilder sb = new StringBuilder();
            sb.append((char) charSequence.length());
            sb.append(charSequence);
            sb.append(charSequenceSubSequence);
            String string = sb.toString();
            this.unsafeBackwardSet.addAll(charSequenceSubSequence);
            while (true) {
                int i2 = conditionalCE32ForCE32.next;
                if (i2 < 0) {
                    conditionalCE32ForCE32.next = addConditionalCE32(string, i);
                    break;
                }
                ConditionalCE32 conditionalCE32 = getConditionalCE32(i2);
                int iCompareTo = string.compareTo(conditionalCE32.context);
                if (iCompareTo < 0) {
                    int iAddConditionalCE33 = addConditionalCE32(string, i);
                    conditionalCE32ForCE32.next = iAddConditionalCE33;
                    getConditionalCE32(iAddConditionalCE33).next = i2;
                    break;
                } else {
                    if (iCompareTo == 0) {
                        conditionalCE32.ce32 = i;
                        break;
                    }
                    conditionalCE32ForCE32 = conditionalCE32;
                }
            }
        } else if (isBuilderContextCE32(iCopyFromBaseCE32)) {
            ConditionalCE32 conditionalCE32ForCE33 = getConditionalCE32ForCE32(iCopyFromBaseCE32);
            conditionalCE32ForCE33.builtCE32 = 1;
            conditionalCE32ForCE33.ce32 = i;
        } else {
            this.trie.set(iCodePointAt, i);
        }
        this.modified = true;
    }

    public int addConditionalCE32(String str, int i) {
        int size = this.conditionalCE32s.size();
        if (size > 524287) {
            og.o("too many context-sensitive mappings");
            return 0;
        }
        this.conditionalCE32s.add(new ConditionalCE32(str, i));
        return size;
    }

    public int addContextTrie(int i, CharsTrieBuilder charsTrieBuilder) {
        StringBuilder sb = new StringBuilder();
        sb.append((char) (i >> 16));
        sb.append((char) i);
        sb.append(charsTrieBuilder.buildCharSequence(StringTrieBuilder.Option.SMALL));
        int iIndexOf = this.contexts.indexOf(sb.toString());
        if (iIndexOf >= 0) {
            return iIndexOf;
        }
        int length = this.contexts.length();
        if (sb.length() + length <= 524287) {
            this.contexts.append((CharSequence) sb);
            return length;
        }
        og.o("Too many context tries");
        return 0;
    }

    public void build(CollationData collationData) {
        buildMappings(collationData);
        CollationData collationData2 = this.base;
        if (collationData2 != null) {
            collationData.numericPrimary = collationData2.numericPrimary;
            collationData.compressibleBytes = collationData2.compressibleBytes;
            collationData.numScripts = collationData2.numScripts;
            collationData.scriptsIndex = collationData2.scriptsIndex;
            collationData.scriptStarts = collationData2.scriptStarts;
        }
        buildFastLatinTable(collationData);
    }

    public int buildContext(ConditionalCE32 conditionalCE32) {
        int i;
        int i2;
        ConditionalCE32 conditionalCE33;
        CharsTrieBuilder charsTrieBuilder;
        int iMakeCE32FromTagAndIndex;
        CharsTrieBuilder charsTrieBuilder2 = null;
        ConditionalCE32 conditionalCE34 = conditionalCE32;
        CharsTrieBuilder charsTrieBuilder3 = null;
        while (true) {
            int iPrefixLength = conditionalCE34.prefixLength();
            StringBuilder sb = new StringBuilder();
            int i3 = iPrefixLength + 1;
            int i4 = 0;
            sb.append((CharSequence) conditionalCE34.context, 0, i3);
            String string = sb.toString();
            ConditionalCE32 conditionalCE35 = conditionalCE34;
            while (true) {
                conditionalCE35.defaultCE32 = 1;
                int i5 = conditionalCE35.next;
                if (i5 < 0) {
                    break;
                }
                ConditionalCE32 conditionalCE36 = getConditionalCE32(i5);
                if (!conditionalCE36.context.startsWith(string)) {
                    break;
                }
                conditionalCE35 = conditionalCE36;
            }
            if (conditionalCE35.context.length() == i3) {
                iMakeCE32FromTagAndIndex = conditionalCE35.ce32;
            } else {
                if (charsTrieBuilder2 == null) {
                    charsTrieBuilder2 = new CharsTrieBuilder();
                } else {
                    charsTrieBuilder2.clear();
                }
                if (conditionalCE34.context.length() == i3) {
                    int i6 = conditionalCE34.ce32;
                    conditionalCE33 = getConditionalCE32(conditionalCE34.next);
                    i = i6;
                    i2 = 0;
                } else {
                    ConditionalCE32 conditionalCE37 = conditionalCE32;
                    i = 1;
                    while (true) {
                        int iPrefixLength2 = conditionalCE37.prefixLength();
                        if (iPrefixLength2 == iPrefixLength) {
                            break;
                        }
                        int i7 = i4;
                        if (conditionalCE37.defaultCE32 != 1) {
                            if (iPrefixLength2 != 0) {
                                charsTrieBuilder = charsTrieBuilder2;
                                if (string.regionMatches(sb.length() - iPrefixLength2, conditionalCE37.context, 1, iPrefixLength2)) {
                                }
                            } else {
                                charsTrieBuilder = charsTrieBuilder2;
                            }
                            i = conditionalCE37.defaultCE32;
                        } else {
                            charsTrieBuilder = charsTrieBuilder2;
                        }
                        conditionalCE37 = getConditionalCE32(conditionalCE37.next);
                        charsTrieBuilder2 = charsTrieBuilder;
                        i4 = i7;
                    }
                    i2 = 256;
                    conditionalCE33 = conditionalCE34;
                }
                int i8 = i2 | 512;
                while (true) {
                    String strSubstring = conditionalCE33.context.substring(i3);
                    if (this.nfcImpl.getFCD16(strSubstring.codePointAt(i4)) <= 255) {
                        i8 &= -513;
                    }
                    if (this.nfcImpl.getFCD16(strSubstring.codePointBefore(strSubstring.length())) > 255) {
                        i8 |= 1024;
                    }
                    charsTrieBuilder2.add(strSubstring, conditionalCE33.ce32);
                    if (conditionalCE33 == conditionalCE35) {
                        break;
                    }
                    conditionalCE33 = getConditionalCE32(conditionalCE33.next);
                    i4 = 0;
                }
                int iAddContextTrie = addContextTrie(i, charsTrieBuilder2);
                if (iAddContextTrie > 524287) {
                    og.o("too many context-sensitive mappings");
                    return 0;
                }
                iMakeCE32FromTagAndIndex = i8 | Collation.makeCE32FromTagAndIndex(9, iAddContextTrie);
                conditionalCE35 = conditionalCE33;
            }
            conditionalCE34.defaultCE32 = iMakeCE32FromTagAndIndex;
            if (iPrefixLength != 0) {
                sb.delete(0, 1);
                sb.reverse();
                if (charsTrieBuilder3 == null) {
                    charsTrieBuilder3 = new CharsTrieBuilder();
                }
                charsTrieBuilder3.add(sb, iMakeCE32FromTagAndIndex);
                if (conditionalCE35.next < 0) {
                    int iAddContextTrie2 = addContextTrie(conditionalCE32.defaultCE32, charsTrieBuilder3);
                    if (iAddContextTrie2 <= 524287) {
                        return Collation.makeCE32FromTagAndIndex(8, iAddContextTrie2);
                    }
                    og.o("too many context-sensitive mappings");
                    return 0;
                }
            } else if (conditionalCE35.next < 0) {
                return iMakeCE32FromTagAndIndex;
            }
            conditionalCE34 = getConditionalCE32(conditionalCE35.next);
        }
    }

    public void buildContexts() {
        clearContexts();
        UnicodeSetIterator unicodeSetIterator = new UnicodeSetIterator(this.contextChars);
        while (unicodeSetIterator.next()) {
            int i = unicodeSetIterator.codepoint;
            int i2 = this.trie.get(i);
            if (!isBuilderContextCE32(i2)) {
                og.m("Impossible: No context data for c in contextChars.");
                return;
            } else {
                this.trie.set(i, buildContext(getConditionalCE32ForCE32(i2)));
            }
        }
    }

    public void buildFastLatinTable(CollationData collationData) {
        if (this.fastLatinEnabled) {
            CollationFastLatinBuilder collationFastLatinBuilder = new CollationFastLatinBuilder();
            this.fastLatinBuilder = collationFastLatinBuilder;
            if (!collationFastLatinBuilder.forData(collationData)) {
                this.fastLatinBuilder = null;
                return;
            }
            char[] header = this.fastLatinBuilder.getHeader();
            char[] table = this.fastLatinBuilder.getTable();
            CollationData collationData2 = this.base;
            if (collationData2 != null && Arrays.equals(header, collationData2.fastLatinTableHeader) && Arrays.equals(table, this.base.fastLatinTable)) {
                this.fastLatinBuilder = null;
                CollationData collationData3 = this.base;
                header = collationData3.fastLatinTableHeader;
                table = collationData3.fastLatinTable;
            }
            collationData.fastLatinTableHeader = header;
            collationData.fastLatinTable = table;
        }
    }

    public void buildMappings(CollationData collationData) {
        int size;
        UnicodeSet unicodeSet;
        boolean z;
        if (!isMutable()) {
            og.n("attempt to build() after build()");
            return;
        }
        buildContexts();
        int[] iArr = new int[67];
        boolean jamoCE32s = getJamoCE32s(iArr);
        int i = Normalizer2Impl.Hangul.HANGUL_BASE;
        if (jamoCE32s) {
            size = this.ce32s.size();
            for (int i2 = 0; i2 < 67; i2++) {
                this.ce32s.addElement(iArr[i2]);
            }
            int i3 = 19;
            while (true) {
                if (i3 >= 67) {
                    z = false;
                    break;
                } else {
                    if (Collation.isSpecialCE32(iArr[i3])) {
                        z = true;
                        break;
                    }
                    i3++;
                }
            }
            int iMakeCE32FromTagAndIndex = Collation.makeCE32FromTagAndIndex(12, 0);
            int i4 = 0;
            while (i4 < 19) {
                int i5 = (z || Collation.isSpecialCE32(iArr[i4])) ? iMakeCE32FromTagAndIndex : iMakeCE32FromTagAndIndex | 256;
                int i6 = i + Normalizer2Impl.Hangul.JAMO_VT_COUNT;
                this.trie.setRange(i, i + 587, i5, true);
                i4++;
                i = i6;
            }
        } else {
            while (i < 55204) {
                int ce32 = this.base.getCE32(i);
                int i7 = i + Normalizer2Impl.Hangul.JAMO_VT_COUNT;
                this.trie.setRange(i, i + 587, ce32, true);
                i = i7;
            }
            size = -1;
        }
        setDigitTags();
        setLeadSurrogates();
        this.ce32s.setElementAt(this.trie.get(0), 0);
        this.trie.set(0, Collation.makeCE32FromTagAndIndex(11, 0));
        collationData.trie = this.trie.toTrie2_32();
        int i8 = 65536;
        char c = 55296;
        while (true) {
            unicodeSet = this.unsafeBackwardSet;
            if (c >= 56320) {
                break;
            }
            if (unicodeSet.containsSome(i8, i8 + UCharacterProperty.MAX_SCRIPT)) {
                this.unsafeBackwardSet.add(c);
            }
            c = (char) (c + 1);
            i8 += 1024;
        }
        unicodeSet.freeze();
        collationData.ce32s = this.ce32s.getBuffer();
        collationData.ces = this.ce64s.getBuffer();
        collationData.contexts = this.contexts.toString();
        CollationData collationData2 = this.base;
        collationData.base = collationData2;
        if (size >= 0) {
            collationData.jamoCE32s = iArr;
        } else {
            collationData.jamoCE32s = collationData2.jamoCE32s;
        }
        collationData.unsafeBackwardSet = this.unsafeBackwardSet;
    }

    public void clearContexts() {
        this.contexts.setLength(0);
        this.contextsEra++;
    }

    public int copyContractionsFromBaseCE32(StringBuilder sb, int i, int i2, ConditionalCE32 conditionalCE32) {
        int iAddConditionalCE32;
        int iIndexFromCE32 = Collation.indexFromCE32(i2);
        if ((i2 & 256) != 0) {
            iAddConditionalCE32 = -1;
        } else {
            iAddConditionalCE32 = addConditionalCE32(sb.toString(), copyFromBaseCE32(i, this.base.getCE32FromContexts(iIndexFromCE32), true));
            conditionalCE32.next = iAddConditionalCE32;
            conditionalCE32 = getConditionalCE32(iAddConditionalCE32);
        }
        int length = sb.length();
        CharsTrie.Iterator it = CharsTrie.iterator(this.base.contexts, iIndexFromCE32 + 2, 0);
        while (it.hasNext()) {
            CharsTrie.Entry next = it.next();
            sb.append(next.chars);
            iAddConditionalCE32 = addConditionalCE32(sb.toString(), copyFromBaseCE32(i, next.value, true));
            conditionalCE32.next = iAddConditionalCE32;
            conditionalCE32 = getConditionalCE32(iAddConditionalCE32);
            sb.setLength(length);
        }
        return iAddConditionalCE32;
    }

    public void copyFrom(CollationDataBuilder collationDataBuilder, CEModifier cEModifier) {
        if (!isMutable()) {
            og.n("attempt to copyFrom() after build()");
            return;
        }
        CopyHelper copyHelper = new CopyHelper(collationDataBuilder, this, cEModifier);
        for (Trie2.Range range : collationDataBuilder.trie) {
            if (range.leadSurrogate) {
                break;
            } else {
                enumRangeForCopy(range.startCodePoint, range.endCodePoint, range.value, copyHelper);
            }
        }
        this.modified = collationDataBuilder.modified | this.modified;
    }

    public int copyFromBaseCE32(int i, int i2, boolean z) {
        int iTagFromCE32;
        int iAddConditionalCE32;
        int iCopyContractionsFromBaseCE32;
        if (!Collation.isSpecialCE32(i2) || (iTagFromCE32 = Collation.tagFromCE32(i2)) == 1 || iTagFromCE32 == 2 || iTagFromCE32 == 4) {
            return i2;
        }
        if (iTagFromCE32 == 5) {
            return encodeExpansion32(this.base.ce32s, Collation.indexFromCE32(i2), Collation.lengthFromCE32(i2));
        }
        if (iTagFromCE32 == 6) {
            return encodeExpansion(this.base.ces, Collation.indexFromCE32(i2), Collation.lengthFromCE32(i2));
        }
        if (iTagFromCE32 != 8) {
            if (iTagFromCE32 == 9) {
                if (!z) {
                    return copyFromBaseCE32(i, this.base.getCE32FromContexts(Collation.indexFromCE32(i2)), false);
                }
                ConditionalCE32 conditionalCE32 = new ConditionalCE32("", 0);
                copyContractionsFromBaseCE32(new StringBuilder("\u0000"), i, i2, conditionalCE32);
                int iMakeBuilderContextCE32 = makeBuilderContextCE32(conditionalCE32.next);
                this.contextChars.add(i);
                return iMakeBuilderContextCE32;
            }
            if (iTagFromCE32 == 12) {
                dk0.r("We forbid tailoring of Hangul syllables.");
                return 0;
            }
            if (iTagFromCE32 == 14) {
                return getCE32FromOffsetCE32(true, i, i2);
            }
            if (iTagFromCE32 == 15) {
                return encodeOneCE(Collation.unassignedCEFromCodePoint(i));
            }
            og.m("copyFromBaseCE32(c, ce32, withContext) requires ce32 == base.getFinalCE32(ce32)");
            return 0;
        }
        int iIndexFromCE32 = Collation.indexFromCE32(i2);
        int cE32FromContexts = this.base.getCE32FromContexts(iIndexFromCE32);
        if (!z) {
            return copyFromBaseCE32(i, cE32FromContexts, false);
        }
        ConditionalCE32 conditionalCE33 = new ConditionalCE32("", 0);
        StringBuilder sb = new StringBuilder("\u0000");
        if (Collation.isContractionCE32(cE32FromContexts)) {
            iAddConditionalCE32 = copyContractionsFromBaseCE32(sb, i, cE32FromContexts, conditionalCE33);
        } else {
            iAddConditionalCE32 = addConditionalCE32(sb.toString(), copyFromBaseCE32(i, cE32FromContexts, true));
            conditionalCE33.next = iAddConditionalCE32;
        }
        ConditionalCE32 conditionalCE34 = getConditionalCE32(iAddConditionalCE32);
        CharsTrie.Iterator it = CharsTrie.iterator(this.base.contexts, iIndexFromCE32 + 2, 0);
        while (it.hasNext()) {
            CharsTrie.Entry next = it.next();
            sb.setLength(0);
            sb.append(next.chars);
            sb.reverse().insert(0, (char) next.chars.length());
            int i3 = next.value;
            if (Collation.isContractionCE32(i3)) {
                iCopyContractionsFromBaseCE32 = copyContractionsFromBaseCE32(sb, i, i3, conditionalCE34);
            } else {
                int iAddConditionalCE33 = addConditionalCE32(sb.toString(), copyFromBaseCE32(i, i3, true));
                conditionalCE34.next = iAddConditionalCE33;
                iCopyContractionsFromBaseCE32 = iAddConditionalCE33;
            }
            conditionalCE34 = getConditionalCE32(iCopyContractionsFromBaseCE32);
        }
        int iMakeBuilderContextCE33 = makeBuilderContextCE32(conditionalCE33.next);
        this.contextChars.add(i);
        return iMakeBuilderContextCE33;
    }

    public void enableFastLatin() {
        this.fastLatinEnabled = true;
    }

    public int encodeCEs(long[] jArr, int i) {
        if (i < 0 || i > 31) {
            og.i("mapping to too many CEs");
            return 0;
        }
        if (!isMutable()) {
            og.n("attempt to add mappings after build()");
            return 0;
        }
        if (i == 0) {
            return encodeOneCEAsCE32(0L);
        }
        if (i == 1) {
            return encodeOneCE(jArr[0]);
        }
        if (i == 2) {
            long j = jArr[0];
            long j2 = jArr[1];
            long j3 = j >>> 32;
            if ((72057594037862655L & j) == 83886080 && ((-4278190081L) & j2) == 1280 && j3 != 0) {
                return ((int) j3) | ((((int) j) & 65280) << 8) | ((((int) j2) >> 16) & 65280) | 196;
            }
        }
        int[] iArr = new int[31];
        for (int i2 = 0; i2 != i; i2++) {
            int iEncodeOneCEAsCE32 = encodeOneCEAsCE32(jArr[i2]);
            if (iEncodeOneCEAsCE32 == 1) {
                return encodeExpansion(jArr, 0, i);
            }
            iArr[i2] = iEncodeOneCEAsCE32;
        }
        return encodeExpansion32(iArr, 0, i);
    }

    public int encodeExpansion(long[] jArr, int i, int i2) {
        long j = jArr[i];
        int size = this.ce64s.size() - i2;
        int i3 = 0;
        while (true) {
            UVector64 uVector64 = this.ce64s;
            if (i3 > size) {
                int size2 = uVector64.size();
                if (size2 > 524287) {
                    og.o("too many mappings");
                    return 0;
                }
                for (int i4 = 0; i4 < i2; i4++) {
                    this.ce64s.addElement(jArr[i + i4]);
                }
                return Collation.makeCE32FromTagIndexAndLength(6, size2, i2);
            }
            if (j == uVector64.elementAti(i3)) {
                if (i3 > 524287) {
                    og.o("too many mappings");
                    return 0;
                }
                for (int i5 = 1; i5 != i2; i5++) {
                    if (this.ce64s.elementAti(i3 + i5) == jArr[i + i5]) {
                    }
                }
                return Collation.makeCE32FromTagIndexAndLength(6, i3, i2);
            }
            i3++;
        }
    }

    public int encodeExpansion32(int[] iArr, int i, int i2) {
        int i3 = iArr[i];
        int size = this.ce32s.size() - i2;
        int i4 = 0;
        while (true) {
            UVector32 uVector32 = this.ce32s;
            if (i4 > size) {
                int size2 = uVector32.size();
                if (size2 > 524287) {
                    og.o("too many mappings");
                    return 0;
                }
                for (int i5 = 0; i5 < i2; i5++) {
                    this.ce32s.addElement(iArr[i + i5]);
                }
                return Collation.makeCE32FromTagIndexAndLength(5, size2, i2);
            }
            if (i3 == uVector32.elementAti(i4)) {
                if (i4 > 524287) {
                    og.o("too many mappings");
                    return 0;
                }
                for (int i6 = 1; i6 != i2; i6++) {
                    if (this.ce32s.elementAti(i4 + i6) == iArr[i + i6]) {
                    }
                }
                return Collation.makeCE32FromTagIndexAndLength(5, i4, i2);
            }
            i4++;
        }
    }

    public int encodeOneCE(long j) {
        int iEncodeOneCEAsCE32 = encodeOneCEAsCE32(j);
        if (iEncodeOneCEAsCE32 != 1) {
            return iEncodeOneCEAsCE32;
        }
        int iAddCE = addCE(j);
        if (iAddCE <= 524287) {
            return Collation.makeCE32FromTagIndexAndLength(6, iAddCE, 1);
        }
        og.o("too many mappings");
        return 0;
    }

    public int getCE32FromOffsetCE32(boolean z, int i, int i2) {
        int iIndexFromCE32 = Collation.indexFromCE32(i2);
        return Collation.makeLongPrimaryCE32(Collation.getThreeBytePrimaryForOffsetData(i, z ? this.base.ces[iIndexFromCE32] : this.ce64s.elementAti(iIndexFromCE32)));
    }

    public int getCEs(CharSequence charSequence, CharSequence charSequence2, long[] jArr, int i) {
        int length = charSequence.length();
        if (length == 0) {
            return getCEs(charSequence2, 0, jArr, i);
        }
        StringBuilder sb = new StringBuilder(charSequence);
        sb.append(charSequence2);
        return getCEs(sb, length, jArr, i);
    }

    public ConditionalCE32 getConditionalCE32(int i) {
        return this.conditionalCE32s.get(i);
    }

    public ConditionalCE32 getConditionalCE32ForCE32(int i) {
        return getConditionalCE32(Collation.indexFromCE32(i));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:21:0x003e  */
    public boolean getJamoCE32s(int[] iArr) {
        boolean z;
        boolean zIsAssignedCE32 = this.base == null;
        int i = 0;
        boolean z2 = false;
        while (true) {
            int cE32FromOffsetCE32 = 192;
            if (i >= 67) {
                if (zIsAssignedCE32 && z2) {
                    for (int i2 = 0; i2 < 67; i2++) {
                        if (iArr[i2] == 192) {
                            int iJamoCpFromIndex = jamoCpFromIndex(i2);
                            iArr[i2] = copyFromBaseCE32(iJamoCpFromIndex, this.base.getCE32(iJamoCpFromIndex), true);
                        }
                    }
                }
                return zIsAssignedCE32;
            }
            int iJamoCpFromIndex2 = jamoCpFromIndex(i);
            cE32FromOffsetCE32 = this.trie.get(iJamoCpFromIndex2);
            zIsAssignedCE32 |= Collation.isAssignedCE32(cE32FromOffsetCE32);
            if (cE32FromOffsetCE32 == 192) {
                cE32FromOffsetCE32 = this.base.getCE32(iJamoCpFromIndex2);
                z = true;
            } else {
                z = false;
            }
            if (Collation.isSpecialCE32(cE32FromOffsetCE32)) {
                int iTagFromCE32 = Collation.tagFromCE32(cE32FromOffsetCE32);
                if (iTagFromCE32 != 0 && iTagFromCE32 != 3) {
                    switch (iTagFromCE32) {
                        case 5:
                        case 6:
                        case 8:
                        case 9:
                            if (z) {
                                z2 = true;
                            }
                            iArr[i] = cE32FromOffsetCE32;
                            i++;
                            break;
                        case 7:
                        case 10:
                        case 11:
                        case 12:
                        case 13:
                            break;
                        case 14:
                            cE32FromOffsetCE32 = getCE32FromOffsetCE32(z, iJamoCpFromIndex2, cE32FromOffsetCE32);
                            iArr[i] = cE32FromOffsetCE32;
                            i++;
                            break;
                        case 15:
                            z2 = true;
                            iArr[i] = cE32FromOffsetCE32;
                            i++;
                            break;
                        default:
                            break;
                    }
                }
                throw new AssertionError(String.format("unexpected special tag in ce32=0x%08x", Integer.valueOf(cE32FromOffsetCE32)));
            }
            iArr[i] = cE32FromOffsetCE32;
            i++;
        }
    }

    public boolean hasMappings() {
        return this.modified;
    }

    public void initForTailoring(CollationData collationData) {
        if (this.trie != null) {
            og.n("attempt to reuse a CollationDataBuilder");
            return;
        }
        if (collationData == null) {
            og.i("null CollationData");
            return;
        }
        this.base = collationData;
        this.trie = new Trie2Writable(192, -195323);
        for (int i = 192; i <= 255; i++) {
            this.trie.set(i, 192);
        }
        this.trie.setRange(Normalizer2Impl.Hangul.HANGUL_BASE, Normalizer2Impl.Hangul.HANGUL_END, Collation.makeCE32FromTagAndIndex(12, 0), true);
        this.unsafeBackwardSet.addAll(collationData.unsafeBackwardSet);
    }

    public boolean isAssigned(int i) {
        return Collation.isAssignedCE32(this.trie.get(i));
    }

    public boolean isCompressibleLeadByte(int i) {
        return this.base.isCompressibleLeadByte(i);
    }

    public boolean isCompressiblePrimary(long j) {
        return isCompressibleLeadByte(((int) j) >>> 24);
    }

    public final boolean isMutable() {
        UnicodeSet unicodeSet;
        return (this.trie == null || (unicodeSet = this.unsafeBackwardSet) == null || unicodeSet.isFrozen()) ? false : true;
    }

    public void optimize(UnicodeSet unicodeSet) {
        int i;
        if (unicodeSet.isEmpty()) {
            return;
        }
        UnicodeSetIterator unicodeSetIterator = new UnicodeSetIterator(unicodeSet);
        while (unicodeSetIterator.next() && (i = unicodeSetIterator.codepoint) != -1) {
            if (this.trie.get(i) == 192) {
                CollationData collationData = this.base;
                this.trie.set(i, copyFromBaseCE32(i, collationData.getFinalCE32(collationData.getCE32(i)), true));
            }
        }
        this.modified = true;
    }

    public void setDigitTags() {
        UnicodeSetIterator unicodeSetIterator = new UnicodeSetIterator(new UnicodeSet("[:Nd:]"));
        while (unicodeSetIterator.next()) {
            int i = unicodeSetIterator.codepoint;
            int i2 = this.trie.get(i);
            if (i2 != 192 && i2 != -1) {
                int iAddCE32 = addCE32(i2);
                if (iAddCE32 > 524287) {
                    og.o("too many mappings");
                    return;
                } else {
                    this.trie.set(i, Collation.makeCE32FromTagIndexAndLength(10, iAddCE32, UCharacter.digit(i)));
                }
            }
        }
    }

    public void setLeadSurrogates() {
        int i;
        for (char c = 55296; c < 56320; c = (char) (c + 1)) {
            Iterator<Trie2.Range> itIteratorForLeadSurrogate = this.trie.iteratorForLeadSurrogate(c);
            int i2 = -1;
            while (itIteratorForLeadSurrogate.hasNext()) {
                int i3 = itIteratorForLeadSurrogate.next().value;
                if (i3 != -1) {
                    if (i3 == 192) {
                        i = 256;
                    }
                    i2 = 512;
                    break;
                }
                i = 0;
                if (i2 >= 0) {
                    if (i2 != i) {
                        i2 = 512;
                        break;
                        break;
                    }
                } else {
                    i2 = i;
                }
            }
            this.trie.setForLeadSurrogateCodeUnit(c, Collation.makeCE32FromTagAndIndex(13, 0) | i2);
        }
    }

    public void suppressContractions(UnicodeSet unicodeSet) {
        int i;
        if (unicodeSet.isEmpty()) {
            return;
        }
        UnicodeSetIterator unicodeSetIterator = new UnicodeSetIterator(unicodeSet);
        while (unicodeSetIterator.next() && (i = unicodeSetIterator.codepoint) != -1) {
            int i2 = this.trie.get(i);
            if (i2 == 192) {
                CollationData collationData = this.base;
                int finalCE32 = collationData.getFinalCE32(collationData.getCE32(i));
                if (Collation.ce32HasContext(finalCE32)) {
                    this.trie.set(i, copyFromBaseCE32(i, finalCE32, false));
                }
            } else if (isBuilderContextCE32(i2)) {
                this.trie.set(i, getConditionalCE32ForCE32(i2).ce32);
                this.contextChars.remove(i);
            }
        }
        this.modified = true;
    }

    public int getCEs(CharSequence charSequence, long[] jArr, int i) {
        return getCEs(charSequence, 0, jArr, i);
    }

    public int getCEs(CharSequence charSequence, int i, long[] jArr, int i2) {
        if (this.collIter == null) {
            this.collIter = new DataBuilderCollationIterator(this, new CollationData(this.nfcImpl));
        }
        return this.collIter.fetchCEs(charSequence, i, jArr, i2);
    }

    public int addCE32(int i) {
        int size = this.ce32s.size();
        int i2 = 0;
        while (true) {
            UVector32 uVector32 = this.ce32s;
            if (i2 < size) {
                if (i == uVector32.elementAti(i2)) {
                    return i2;
                }
                i2++;
            } else {
                uVector32.addElement(i);
                return size;
            }
        }
    }
}
