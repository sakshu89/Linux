package com.ibm.icu.impl.number.parse;

import com.ibm.icu.impl.StandardPlural;
import com.ibm.icu.impl.StringSegment;
import com.ibm.icu.impl.number.AffixPatternProvider;
import com.ibm.icu.impl.number.AffixUtils;
import com.ibm.icu.impl.number.Padder;
import com.ibm.icu.impl.number.PatternStringUtils;
import defpackage.cq;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class AffixMatcher implements NumberParseMatcher {
    public static final Comparator<AffixMatcher> COMPARATOR = new Comparator<AffixMatcher>() { // from class: com.ibm.icu.impl.number.parse.AffixMatcher.1
        @Override // java.util.Comparator
        public int compare(AffixMatcher affixMatcher, AffixMatcher affixMatcher2) {
            if (AffixMatcher.length(affixMatcher.prefix) != AffixMatcher.length(affixMatcher2.prefix)) {
                return AffixMatcher.length(affixMatcher.prefix) > AffixMatcher.length(affixMatcher2.prefix) ? -1 : 1;
            }
            if (AffixMatcher.length(affixMatcher.suffix) != AffixMatcher.length(affixMatcher2.suffix)) {
                return AffixMatcher.length(affixMatcher.suffix) > AffixMatcher.length(affixMatcher2.suffix) ? -1 : 1;
            }
            if (affixMatcher.equals(affixMatcher2)) {
                return 0;
            }
            return affixMatcher.hashCode() > affixMatcher2.hashCode() ? -1 : 1;
        }
    };
    private final int flags;
    private final AffixPatternMatcher prefix;
    private final AffixPatternMatcher suffix;

    private AffixMatcher(AffixPatternMatcher affixPatternMatcher, AffixPatternMatcher affixPatternMatcher2, int i) {
        this.prefix = affixPatternMatcher;
        this.suffix = affixPatternMatcher2;
        this.flags = i;
    }

    /* JADX WARN: Code duplicated, block: B:47:0x00b4  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r10v10 */
    /* JADX WARN: Type inference failed for: r10v11 */
    /* JADX WARN: Type inference failed for: r10v12 */
    /* JADX WARN: Type inference failed for: r10v13 */
    /* JADX WARN: Type inference failed for: r10v14 */
    /* JADX WARN: Type inference failed for: r10v15 */
    /* JADX WARN: Type inference failed for: r10v16 */
    /* JADX WARN: Type inference failed for: r10v17 */
    /* JADX WARN: Type inference failed for: r10v2, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARN: Type inference failed for: r10v5 */
    /* JADX WARN: Type inference failed for: r10v6 */
    /* JADX WARN: Type inference failed for: r10v7 */
    /* JADX WARN: Type inference failed for: r10v9 */
    /* JADX WARN: Type inference failed for: r11v0, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r11v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r11v10 */
    /* JADX WARN: Type inference failed for: r11v11 */
    /* JADX WARN: Type inference failed for: r11v12 */
    /* JADX WARN: Type inference failed for: r11v13 */
    /* JADX WARN: Type inference failed for: r11v14 */
    /* JADX WARN: Type inference failed for: r11v2 */
    /* JADX WARN: Type inference failed for: r11v3 */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r11v5 */
    /* JADX WARN: Type inference failed for: r11v6 */
    /* JADX WARN: Type inference failed for: r11v7 */
    /* JADX WARN: Type inference failed for: r11v8 */
    /* JADX WARN: Type inference failed for: r11v9 */
    /* JADX WARN: Type inference failed for: r18v0 */
    /* JADX WARN: Type inference failed for: r1v3, types: [com.ibm.icu.impl.number.parse.AffixPatternMatcher, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r21v0, types: [com.ibm.icu.impl.number.parse.NumberParserImpl] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v3, types: [com.ibm.icu.impl.number.parse.AffixPatternMatcher, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r5v0 */
    public static void createMatchers(AffixPatternProvider affixPatternProvider, NumberParserImpl numberParserImpl, AffixTokenMatcherFactory affixTokenMatcherFactory, IgnorablesMatcher ignorablesMatcher, int i) {
        int i2;
        boolean z;
        Object r11;
        Object r10;
        AffixPatternMatcher affixPatternMatcher;
        Object r12;
        Object r13;
        Object r14;
        Object r15;
        AffixPatternProvider affixPatternProvider2 = affixPatternProvider;
        if (isInteresting(affixPatternProvider2, ignorablesMatcher, i)) {
            StringBuilder sb = new StringBuilder();
            ArrayList arrayList = new ArrayList(6);
            boolean z2 = (i & 128) != 0;
            PatternStringUtils.PatternSignType[] patternSignTypeArr = PatternStringUtils.PatternSignType.VALUES;
            int length = patternSignTypeArr.length;
            int i3 = 0;
            var r3 = 0;
            var r4 = 0;
            while (i3 < length) {
                var r5 = r3;
                PatternStringUtils.PatternSignType patternSignType = patternSignTypeArr[i3];
                PatternStringUtils.PatternSignType patternSignType2 = PatternStringUtils.PatternSignType.POS;
                if ((patternSignType != patternSignType2 || (i & 1024) == 0) && !(patternSignType == PatternStringUtils.PatternSignType.POS_SIGN && (i & 1024) == 0)) {
                    var r16 = r5;
                    StandardPlural standardPlural = StandardPlural.OTHER;
                    i2 = i3;
                    var r17 = r4;
                    PatternStringUtils.patternInfoToStringBuilder(affixPatternProvider2, true, patternSignType, false, standardPlural, false, sb);
                    var FromAffixPattern = AffixPatternMatcher.fromAffixPattern(sb.toString(), affixTokenMatcherFactory, i);
                    z = z2;
                    PatternStringUtils.patternInfoToStringBuilder(affixPatternProvider, false, patternSignType, false, standardPlural, false, sb);
                    var FromAffixPattern2 = AffixPatternMatcher.fromAffixPattern(sb.toString(), affixTokenMatcherFactory, i);
                    if (patternSignType == patternSignType2) {
                        r11 = FromAffixPattern2;
                        r10 = FromAffixPattern;
                    } else {
                        boolean zEquals = Objects.equals(FromAffixPattern, r16);
                        r10 = r16;
                        r11 = r17;
                        if (zEquals) {
                            boolean zEquals2 = Objects.equals(FromAffixPattern2, r17);
                            r15 = r16;
                            r14 = r17;
                            r10 = r16;
                            r11 = r17;
                            if (zEquals2) {
                            }
                        }
                        r3 = r13;
                        r4 = r12;
                        i3 = i2 + 1;
                        z2 = z;
                        affixPatternProvider2 = affixPatternProvider;
                    }
                    int i4 = patternSignType == PatternStringUtils.PatternSignType.NEG ? 1 : 0;
                    arrayList.add(getInstance(FromAffixPattern, FromAffixPattern2, i4));
                    r15 = r10;
                    r15 = r10;
                    r15 = r10;
                    r14 = r11;
                    r14 = r11;
                    r14 = r11;
                    if (z && FromAffixPattern != 0 && FromAffixPattern2 != 0) {
                        if (patternSignType == patternSignType2 || !FromAffixPattern.equals(r10)) {
                            affixPatternMatcher = null;
                            arrayList.add(getInstance(FromAffixPattern, null, i4));
                        } else {
                            affixPatternMatcher = null;
                        }
                        if (patternSignType != patternSignType2) {
                            boolean zEquals3 = FromAffixPattern2.equals(r11);
                            r13 = r10;
                            r12 = r11;
                            if (!zEquals3) {
                                arrayList.add(getInstance(affixPatternMatcher, FromAffixPattern2, i4));
                                r13 = r10;
                                r12 = r11;
                            }
                        } else {
                            arrayList.add(getInstance(affixPatternMatcher, FromAffixPattern2, i4));
                            r13 = r10;
                            r12 = r11;
                        }
                    }
                    r3 = r13;
                    r4 = r12;
                    i3 = i2 + 1;
                    z2 = z;
                    affixPatternProvider2 = affixPatternProvider;
                } else {
                    i2 = i3;
                    r14 = r4;
                    r15 = r5;
                    z = z2;
                }
                r13 = r15;
                r12 = r14;
                r3 = r13;
                r4 = r12;
                i3 = i2 + 1;
                z2 = z;
                affixPatternProvider2 = affixPatternProvider;
            }
            Collections.sort(arrayList, COMPARATOR);
            numberParserImpl.addMatchers(arrayList);
        }
    }

    private static final AffixMatcher getInstance(AffixPatternMatcher affixPatternMatcher, AffixPatternMatcher affixPatternMatcher2, int i) {
        return new AffixMatcher(affixPatternMatcher, affixPatternMatcher2, i);
    }

    private static boolean isInteresting(AffixPatternProvider affixPatternProvider, IgnorablesMatcher ignorablesMatcher, int i) {
        String string;
        String string2;
        String string3 = affixPatternProvider.getString(256);
        String string4 = affixPatternProvider.getString(0);
        if (affixPatternProvider.hasNegativeSubpattern()) {
            string = affixPatternProvider.getString(768);
            string2 = affixPatternProvider.getString(512);
        } else {
            string = null;
            string2 = null;
        }
        return ((i & 256) == 0 && AffixUtils.containsOnlySymbolsAndIgnorables(string3, ignorablesMatcher.getSet()) && AffixUtils.containsOnlySymbolsAndIgnorables(string4, ignorablesMatcher.getSet()) && AffixUtils.containsOnlySymbolsAndIgnorables(string, ignorablesMatcher.getSet()) && AffixUtils.containsOnlySymbolsAndIgnorables(string2, ignorablesMatcher.getSet()) && !AffixUtils.containsType(string4, -2) && !AffixUtils.containsType(string4, -1) && !AffixUtils.containsType(string2, -2) && !AffixUtils.containsType(string2, -1)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int length(AffixPatternMatcher affixPatternMatcher) {
        if (affixPatternMatcher == null) {
            return 0;
        }
        return affixPatternMatcher.getPattern().length();
    }

    public static boolean matched(AffixPatternMatcher affixPatternMatcher, String str) {
        if (affixPatternMatcher == null && str == null) {
            return true;
        }
        return affixPatternMatcher != null && affixPatternMatcher.getPattern().equals(str);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AffixMatcher)) {
            return false;
        }
        AffixMatcher affixMatcher = (AffixMatcher) obj;
        return Objects.equals(this.prefix, affixMatcher.prefix) && Objects.equals(this.suffix, affixMatcher.suffix) && this.flags == affixMatcher.flags;
    }

    public int hashCode() {
        return this.flags ^ (Objects.hashCode(this.prefix) ^ Objects.hashCode(this.suffix));
    }

    @Override // com.ibm.icu.impl.number.parse.NumberParseMatcher
    public boolean match(StringSegment stringSegment, ParsedNumber parsedNumber) {
        boolean zMatch = false;
        if (!parsedNumber.seenNumber()) {
            if (parsedNumber.prefix == null && this.prefix != null) {
                int offset = stringSegment.getOffset();
                zMatch = this.prefix.match(stringSegment, parsedNumber);
                if (offset != stringSegment.getOffset()) {
                    parsedNumber.prefix = this.prefix.getPattern();
                }
            }
            return zMatch;
        }
        if (parsedNumber.suffix == null && this.suffix != null && matched(this.prefix, parsedNumber.prefix)) {
            int offset2 = stringSegment.getOffset();
            zMatch = this.suffix.match(stringSegment, parsedNumber);
            if (offset2 != stringSegment.getOffset()) {
                parsedNumber.suffix = this.suffix.getPattern();
            }
        }
        return zMatch;
    }

    @Override // com.ibm.icu.impl.number.parse.NumberParseMatcher
    public void postProcess(ParsedNumber parsedNumber) {
        if (matched(this.prefix, parsedNumber.prefix) && matched(this.suffix, parsedNumber.suffix)) {
            if (parsedNumber.prefix == null) {
                parsedNumber.prefix = "";
            }
            if (parsedNumber.suffix == null) {
                parsedNumber.suffix = "";
            }
            parsedNumber.flags |= this.flags;
            AffixPatternMatcher affixPatternMatcher = this.prefix;
            if (affixPatternMatcher != null) {
                affixPatternMatcher.postProcess(parsedNumber);
            }
            AffixPatternMatcher affixPatternMatcher2 = this.suffix;
            if (affixPatternMatcher2 != null) {
                affixPatternMatcher2.postProcess(parsedNumber);
            }
        }
    }

    @Override // com.ibm.icu.impl.number.parse.NumberParseMatcher
    public boolean smokeTest(StringSegment stringSegment) {
        AffixPatternMatcher affixPatternMatcher = this.prefix;
        if (affixPatternMatcher != null && affixPatternMatcher.smokeTest(stringSegment)) {
            return true;
        }
        AffixPatternMatcher affixPatternMatcher2 = this.suffix;
        return affixPatternMatcher2 != null && affixPatternMatcher2.smokeTest(stringSegment);
    }

    public String toString() {
        StringBuilder sbQ = cq.q("<AffixMatcher", (this.flags & 1) != 0 ? ":negative " : Padder.FALLBACK_PADDING_STRING, String.valueOf(this.prefix), "#", String.valueOf(this.suffix));
        sbQ.append(">");
        return sbQ.toString();
    }
}
