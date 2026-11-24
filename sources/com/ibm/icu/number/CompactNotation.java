package com.ibm.icu.number;

import com.ibm.icu.impl.number.CompactData;
import com.ibm.icu.impl.number.DecimalQuantity;
import com.ibm.icu.impl.number.MicroProps;
import com.ibm.icu.impl.number.MicroPropsGenerator;
import com.ibm.icu.impl.number.MutablePatternModifier;
import com.ibm.icu.impl.number.PatternStringParser;
import com.ibm.icu.text.CompactDecimalFormat;
import com.ibm.icu.text.NumberFormat;
import com.ibm.icu.text.PluralRules;
import com.ibm.icu.util.ULocale;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class CompactNotation extends Notation {
    final Map<String, Map<String, String>> compactCustomData;
    final CompactDecimalFormat.CompactStyle compactStyle;

    public CompactNotation(CompactDecimalFormat.CompactStyle compactStyle) {
        this.compactCustomData = null;
        this.compactStyle = compactStyle;
    }

    @Deprecated
    public static CompactNotation forCustomData(Map<String, Map<String, String>> map) {
        return new CompactNotation(map);
    }

    public MicroPropsGenerator withLocaleData(ULocale uLocale, String str, CompactData.CompactType compactType, PluralRules pluralRules, MutablePatternModifier mutablePatternModifier, boolean z, MicroPropsGenerator microPropsGenerator) {
        return new CompactHandler(this, uLocale, str, compactType, pluralRules, mutablePatternModifier, z, microPropsGenerator, 0);
    }

    public CompactNotation(Map<String, Map<String, String>> map) {
        this.compactStyle = null;
        this.compactCustomData = map;
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class CompactHandler implements MicroPropsGenerator {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        final CompactData data;
        final MicroPropsGenerator parent;
        final Map<String, MutablePatternModifier.ImmutablePatternModifier> precomputedMods;
        final PluralRules rules;
        final MutablePatternModifier unsafePatternModifier;

        private CompactHandler(CompactNotation compactNotation, ULocale uLocale, String str, CompactData.CompactType compactType, PluralRules pluralRules, MutablePatternModifier mutablePatternModifier, boolean z, MicroPropsGenerator microPropsGenerator) {
            this.rules = pluralRules;
            this.parent = microPropsGenerator;
            CompactData compactData = new CompactData();
            this.data = compactData;
            CompactDecimalFormat.CompactStyle compactStyle = compactNotation.compactStyle;
            if (compactStyle != null) {
                compactData.populate(uLocale, str, compactStyle, compactType);
            } else {
                compactData.populate(compactNotation.compactCustomData);
            }
            if (!z) {
                this.precomputedMods = null;
                this.unsafePatternModifier = mutablePatternModifier;
            } else {
                this.precomputedMods = new HashMap();
                precomputeAllModifiers(mutablePatternModifier);
                this.unsafePatternModifier = null;
            }
        }

        private void precomputeAllModifiers(MutablePatternModifier mutablePatternModifier) {
            HashSet<String> hashSet = new HashSet();
            this.data.getUniquePatterns(hashSet);
            for (String str : hashSet) {
                mutablePatternModifier.setPatternInfo(PatternStringParser.parseToPatternInfo(str), NumberFormat.Field.COMPACT);
                this.precomputedMods.put(str, mutablePatternModifier.createImmutable());
            }
        }

        @Override // com.ibm.icu.impl.number.MicroPropsGenerator
        public MicroProps processQuantity(DecimalQuantity decimalQuantity) {
            int iChooseMultiplierAndApply;
            MicroProps microPropsProcessQuantity = this.parent.processQuantity(decimalQuantity);
            int magnitude = 0;
            if (decimalQuantity.isZeroish()) {
                microPropsProcessQuantity.rounder.apply(decimalQuantity);
                iChooseMultiplierAndApply = 0;
            } else {
                iChooseMultiplierAndApply = microPropsProcessQuantity.rounder.chooseMultiplierAndApply(decimalQuantity, this.data);
                magnitude = (decimalQuantity.isZeroish() ? 0 : decimalQuantity.getMagnitude()) - iChooseMultiplierAndApply;
            }
            String pattern = this.data.getPattern(magnitude, this.rules, decimalQuantity);
            if (pattern != null) {
                Map<String, MutablePatternModifier.ImmutablePatternModifier> map = this.precomputedMods;
                if (map != null) {
                    map.get(pattern).applyToMicros(microPropsProcessQuantity, decimalQuantity);
                } else {
                    this.unsafePatternModifier.setPatternInfo(PatternStringParser.parseToPatternInfo(pattern), NumberFormat.Field.COMPACT);
                    this.unsafePatternModifier.setNumberProperties(decimalQuantity.signum(), null);
                    microPropsProcessQuantity.modMiddle = this.unsafePatternModifier;
                }
            }
            decimalQuantity.adjustExponent(iChooseMultiplierAndApply * (-1));
            microPropsProcessQuantity.rounder = null;
            return microPropsProcessQuantity;
        }

        public /* synthetic */ CompactHandler(CompactNotation compactNotation, ULocale uLocale, String str, CompactData.CompactType compactType, PluralRules pluralRules, MutablePatternModifier mutablePatternModifier, boolean z, MicroPropsGenerator microPropsGenerator, int i) {
            this(compactNotation, uLocale, str, compactType, pluralRules, mutablePatternModifier, z, microPropsGenerator);
        }
    }
}
