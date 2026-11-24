package com.ibm.icu.text;

import com.ibm.icu.impl.Norm2AllModes;
import com.ibm.icu.impl.Normalizer2Impl;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
final class NormalizationTransliterator extends Transliterator {
    static final ConcurrentHashMap<Normalizer2, SourceTargetUtility> SOURCE_CACHE = new ConcurrentHashMap<>();
    private final Normalizer2 norm2;

    private NormalizationTransliterator(String str, Normalizer2 normalizer2) {
        super(str, null);
        this.norm2 = normalizer2;
    }

    public static void register() {
        Transliterator.registerFactory("Any-NFC", new Transliterator.Factory() { // from class: com.ibm.icu.text.NormalizationTransliterator.1
            @Override // com.ibm.icu.text.Transliterator.Factory
            public Transliterator getInstance(String str) {
                return new NormalizationTransliterator("NFC", Normalizer2.getNFCInstance(), 0);
            }
        });
        Transliterator.registerFactory("Any-NFD", new Transliterator.Factory() { // from class: com.ibm.icu.text.NormalizationTransliterator.2
            @Override // com.ibm.icu.text.Transliterator.Factory
            public Transliterator getInstance(String str) {
                return new NormalizationTransliterator("NFD", Normalizer2.getNFDInstance(), 0);
            }
        });
        Transliterator.registerFactory("Any-NFKC", new Transliterator.Factory() { // from class: com.ibm.icu.text.NormalizationTransliterator.3
            @Override // com.ibm.icu.text.Transliterator.Factory
            public Transliterator getInstance(String str) {
                return new NormalizationTransliterator("NFKC", Normalizer2.getNFKCInstance(), 0);
            }
        });
        Transliterator.registerFactory("Any-NFKD", new Transliterator.Factory() { // from class: com.ibm.icu.text.NormalizationTransliterator.4
            @Override // com.ibm.icu.text.Transliterator.Factory
            public Transliterator getInstance(String str) {
                return new NormalizationTransliterator("NFKD", Normalizer2.getNFKDInstance(), 0);
            }
        });
        Transliterator.registerFactory("Any-FCD", new Transliterator.Factory() { // from class: com.ibm.icu.text.NormalizationTransliterator.5
            @Override // com.ibm.icu.text.Transliterator.Factory
            public Transliterator getInstance(String str) {
                return new NormalizationTransliterator("FCD", Norm2AllModes.getFCDNormalizer2(), 0);
            }
        });
        Transliterator.registerFactory("Any-FCC", new Transliterator.Factory() { // from class: com.ibm.icu.text.NormalizationTransliterator.6
            @Override // com.ibm.icu.text.Transliterator.Factory
            public Transliterator getInstance(String str) {
                return new NormalizationTransliterator("FCC", Norm2AllModes.getNFCInstance().fcc, 0);
            }
        });
        Transliterator.registerSpecialInverse("NFC", "NFD", true);
        Transliterator.registerSpecialInverse("NFKC", "NFKD", true);
        Transliterator.registerSpecialInverse("FCC", "NFD", false);
        Transliterator.registerSpecialInverse("FCD", "FCD", false);
    }

    @Override // com.ibm.icu.text.Transliterator
    public void addSourceTargetSet(UnicodeSet unicodeSet, UnicodeSet unicodeSet2, UnicodeSet unicodeSet3) {
        SourceTargetUtility sourceTargetUtilityPutIfAbsent;
        ConcurrentHashMap<Normalizer2, SourceTargetUtility> concurrentHashMap = SOURCE_CACHE;
        SourceTargetUtility sourceTargetUtility = concurrentHashMap.get(this.norm2);
        if (sourceTargetUtility == null && (sourceTargetUtilityPutIfAbsent = concurrentHashMap.putIfAbsent(this.norm2, (sourceTargetUtility = new SourceTargetUtility(new NormalizingTransform(this.norm2), this.norm2)))) != null) {
            sourceTargetUtility = sourceTargetUtilityPutIfAbsent;
        }
        sourceTargetUtility.addSourceTargetSet(this, unicodeSet, unicodeSet2, unicodeSet3);
    }

    @Override // com.ibm.icu.text.Transliterator
    public void handleTransliterate(Replaceable replaceable, Transliterator.Position position, boolean z) {
        int i = position.start;
        int i2 = position.limit;
        if (i >= i2) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        int iChar32At = replaceable.char32At(i);
        do {
            sb.setLength(0);
            int iCharCount = i;
            while (true) {
                sb.appendCodePoint(iChar32At);
                iCharCount += Character.charCount(iChar32At);
                if (iCharCount >= i2) {
                    break;
                }
                Normalizer2 normalizer2 = this.norm2;
                int iChar32At2 = replaceable.char32At(iCharCount);
                if (normalizer2.hasBoundaryBefore(iChar32At2)) {
                    iChar32At = iChar32At2;
                    break;
                }
                iChar32At = iChar32At2;
            }
            if (iCharCount == i2 && z && !this.norm2.hasBoundaryAfter(iChar32At)) {
                break;
            }
            this.norm2.normalize((CharSequence) sb, sb2);
            if (!Normalizer2Impl.UTF16Plus.equal(sb, sb2)) {
                replaceable.replace(i, iCharCount, sb2.toString());
                int length = sb2.length() - (iCharCount - i);
                iCharCount += length;
                i2 += length;
            }
            i = iCharCount;
        } while (i < i2);
        position.start = i;
        position.contextLimit = (i2 - position.limit) + position.contextLimit;
        position.limit = i2;
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class NormalizingTransform implements Transform<String, String> {
        final Normalizer2 norm2;

        public NormalizingTransform(Normalizer2 normalizer2) {
            this.norm2 = normalizer2;
        }

        @Override // com.ibm.icu.text.Transform
        public String transform(String str) {
            return this.norm2.normalize(str);
        }
    }

    public /* synthetic */ NormalizationTransliterator(String str, Normalizer2 normalizer2, int i) {
        this(str, normalizer2);
    }
}
