package com.ibm.icu.impl.number.parse;

import com.ibm.icu.impl.number.AffixUtils;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class AffixPatternMatcher extends SeriesMatcher implements AffixUtils.TokenConsumer {
    private final String affixPattern;
    private AffixTokenMatcherFactory factory;
    private IgnorablesMatcher ignorables;
    private int lastTypeOrCp;

    private AffixPatternMatcher(String str) {
        this.affixPattern = str;
    }

    public static AffixPatternMatcher fromAffixPattern(String str, AffixTokenMatcherFactory affixTokenMatcherFactory, int i) {
        if (str.isEmpty()) {
            return null;
        }
        AffixPatternMatcher affixPatternMatcher = new AffixPatternMatcher(str);
        affixPatternMatcher.factory = affixTokenMatcherFactory;
        affixPatternMatcher.ignorables = (i & 512) != 0 ? null : affixTokenMatcherFactory.ignorables();
        affixPatternMatcher.lastTypeOrCp = 0;
        AffixUtils.iterateWithConsumer(str, affixPatternMatcher);
        affixPatternMatcher.factory = null;
        affixPatternMatcher.ignorables = null;
        affixPatternMatcher.lastTypeOrCp = 0;
        affixPatternMatcher.freeze();
        return affixPatternMatcher;
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0062  */
    @Override // com.ibm.icu.impl.number.AffixUtils.TokenConsumer
    public void consumeToken(int i) {
        if (this.ignorables != null && length() > 0 && (this.lastTypeOrCp < 0 || !this.ignorables.getSet().contains(this.lastTypeOrCp))) {
            addMatcher(this.ignorables);
        }
        if (i >= 0) {
            IgnorablesMatcher ignorablesMatcher = this.ignorables;
            if (ignorablesMatcher == null || !ignorablesMatcher.getSet().contains(i)) {
                addMatcher(CodePointMatcher.getInstance(i));
            }
        } else if (i != -15) {
            switch (i) {
                case AffixUtils.TYPE_CURRENCY_QUINT /* -10 */:
                case AffixUtils.TYPE_CURRENCY_QUAD /* -9 */:
                case AffixUtils.TYPE_CURRENCY_TRIPLE /* -8 */:
                case AffixUtils.TYPE_CURRENCY_DOUBLE /* -7 */:
                case AffixUtils.TYPE_CURRENCY_SINGLE /* -6 */:
                    addMatcher(this.factory.currency());
                    break;
                case AffixUtils.TYPE_PERMILLE /* -5 */:
                    addMatcher(this.factory.permille());
                    break;
                case AffixUtils.TYPE_PERCENT /* -4 */:
                    addMatcher(this.factory.percent());
                    break;
                case -3:
                    addMatcher(this.factory.approximatelySign());
                    break;
                case -2:
                    addMatcher(this.factory.plusSign());
                    break;
                case -1:
                    addMatcher(this.factory.minusSign());
                    break;
                default:
                    throw new AssertionError();
            }
        } else {
            addMatcher(this.factory.currency());
        }
        this.lastTypeOrCp = i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AffixPatternMatcher) {
            return this.affixPattern.equals(((AffixPatternMatcher) obj).affixPattern);
        }
        return false;
    }

    public String getPattern() {
        return this.affixPattern;
    }

    public int hashCode() {
        return this.affixPattern.hashCode();
    }

    @Override // com.ibm.icu.impl.number.parse.SeriesMatcher
    public String toString() {
        return this.affixPattern;
    }
}
