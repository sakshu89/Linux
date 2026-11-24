package com.ibm.icu.text;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class RuleBasedTransliterator extends Transliterator {
    private final Data data;

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class Data {
        Object[] variables;
        char variablesBase;
        Map<String, char[]> variableNames = new HashMap();
        public TransliterationRuleSet ruleSet = new TransliterationRuleSet();

        public UnicodeMatcher lookupMatcher(int i) {
            int i2 = i - this.variablesBase;
            if (i2 < 0) {
                return null;
            }
            Object[] objArr = this.variables;
            if (i2 < objArr.length) {
                return (UnicodeMatcher) objArr[i2];
            }
            return null;
        }

        public UnicodeReplacer lookupReplacer(int i) {
            int i2 = i - this.variablesBase;
            if (i2 < 0) {
                return null;
            }
            Object[] objArr = this.variables;
            if (i2 < objArr.length) {
                return (UnicodeReplacer) objArr[i2];
            }
            return null;
        }
    }

    public RuleBasedTransliterator(String str, Data data, UnicodeFilter unicodeFilter) {
        super(str, unicodeFilter);
        this.data = data;
        setMaximumContextLength(data.ruleSet.getMaximumContextLength());
    }

    @Override // com.ibm.icu.text.Transliterator
    @Deprecated
    public void addSourceTargetSet(UnicodeSet unicodeSet, UnicodeSet unicodeSet2, UnicodeSet unicodeSet3) {
        this.data.ruleSet.addSourceTargetSet(unicodeSet, unicodeSet2, unicodeSet3);
    }

    @Override // com.ibm.icu.text.Transliterator
    @Deprecated
    public void handleTransliterate(Replaceable replaceable, Transliterator.Position position, boolean z) {
        synchronized (this.data) {
            try {
                int i = (position.limit - position.start) << 4;
                if (i < 0) {
                    i = Integer.MAX_VALUE;
                }
                for (int i2 = 0; position.start < position.limit && i2 <= i && this.data.ruleSet.transliterate(replaceable, position, z); i2++) {
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Deprecated
    public Transliterator safeClone() {
        UnicodeFilter filter = getFilter();
        if (filter != null && (filter instanceof UnicodeSet)) {
            filter = new UnicodeSet((UnicodeSet) filter);
        }
        return new RuleBasedTransliterator(getID(), this.data, filter);
    }

    @Override // com.ibm.icu.text.Transliterator
    @Deprecated
    public String toRules(boolean z) {
        return this.data.ruleSet.toRules(z);
    }
}
