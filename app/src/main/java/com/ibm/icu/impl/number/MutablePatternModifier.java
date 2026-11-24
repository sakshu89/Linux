package com.ibm.icu.impl.number;

import com.ibm.icu.impl.FormattedStringBuilder;
import com.ibm.icu.impl.StandardPlural;
import com.ibm.icu.number.NumberFormatter;
import com.ibm.icu.number.Precision;
import com.ibm.icu.text.DecimalFormatSymbols;
import com.ibm.icu.text.NumberFormat;
import com.ibm.icu.text.PluralRules;
import com.ibm.icu.util.Currency;
import java.text.Format;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class MutablePatternModifier implements Modifier, AffixUtils.SymbolProvider, MicroPropsGenerator {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    boolean approximately;
    Currency currency;
    StringBuilder currentAffix;
    NumberFormat.Field field;
    final boolean isStrong;
    MicroPropsGenerator parent;
    AffixPatternProvider patternInfo;
    boolean perMilleReplacesPercent;
    StandardPlural plural;
    PluralRules rules;
    NumberFormatter.SignDisplay signDisplay;
    Modifier.Signum signum;
    DecimalFormatSymbols symbols;
    NumberFormatter.UnitWidth unitWidth;

    /* JADX INFO: renamed from: com.ibm.icu.impl.number.MutablePatternModifier$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ibm$icu$number$NumberFormatter$UnitWidth;

        static {
            int[] iArr = new int[NumberFormatter.UnitWidth.values().length];
            $SwitchMap$com$ibm$icu$number$NumberFormatter$UnitWidth = iArr;
            try {
                iArr[NumberFormatter.UnitWidth.SHORT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ibm$icu$number$NumberFormatter$UnitWidth[NumberFormatter.UnitWidth.NARROW.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$ibm$icu$number$NumberFormatter$UnitWidth[NumberFormatter.UnitWidth.FORMAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$ibm$icu$number$NumberFormatter$UnitWidth[NumberFormatter.UnitWidth.VARIANT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class ImmutablePatternModifier implements MicroPropsGenerator {
        MicroPropsGenerator parent = null;
        final AdoptingModifierStore pm;
        final PluralRules rules;

        public ImmutablePatternModifier(AdoptingModifierStore adoptingModifierStore, PluralRules pluralRules) {
            this.pm = adoptingModifierStore;
            this.rules = pluralRules;
        }

        public ImmutablePatternModifier addToChain(MicroPropsGenerator microPropsGenerator) {
            this.parent = microPropsGenerator;
            return this;
        }

        public void applyToMicros(MicroProps microProps, DecimalQuantity decimalQuantity) {
            PluralRules pluralRules = this.rules;
            if (pluralRules == null) {
                microProps.modMiddle = this.pm.getModifierWithoutPlural(decimalQuantity.signum());
            } else {
                microProps.modMiddle = this.pm.getModifier(decimalQuantity.signum(), RoundingUtils.getPluralSafe(microProps.rounder, pluralRules, decimalQuantity));
            }
        }

        @Override // com.ibm.icu.impl.number.MicroPropsGenerator
        public MicroProps processQuantity(DecimalQuantity decimalQuantity) {
            MicroProps microPropsProcessQuantity = this.parent.processQuantity(decimalQuantity);
            Precision precision = microPropsProcessQuantity.rounder;
            if (precision != null) {
                precision.apply(decimalQuantity);
            }
            if (microPropsProcessQuantity.modMiddle != null) {
                return microPropsProcessQuantity;
            }
            applyToMicros(microPropsProcessQuantity, decimalQuantity);
            return microPropsProcessQuantity;
        }
    }

    public MutablePatternModifier(boolean z) {
        this.isStrong = z;
    }

    private ConstantMultiFieldModifier createConstantModifier(FormattedStringBuilder formattedStringBuilder, FormattedStringBuilder formattedStringBuilder2) {
        insertPrefix(formattedStringBuilder.clear(), 0);
        insertSuffix(formattedStringBuilder2.clear(), 0);
        return this.patternInfo.hasCurrencySign() ? new CurrencySpacingEnabledModifier(formattedStringBuilder, formattedStringBuilder2, !this.patternInfo.hasBody(), this.isStrong, this.symbols) : new ConstantMultiFieldModifier(formattedStringBuilder, formattedStringBuilder2, !this.patternInfo.hasBody(), this.isStrong);
    }

    private int insertPrefix(FormattedStringBuilder formattedStringBuilder, int i) {
        prepareAffix(true);
        return AffixUtils.unescape(this.currentAffix, formattedStringBuilder, i, this, this.field);
    }

    private int insertSuffix(FormattedStringBuilder formattedStringBuilder, int i) {
        prepareAffix(false);
        return AffixUtils.unescape(this.currentAffix, formattedStringBuilder, i, this, this.field);
    }

    private void prepareAffix(boolean z) {
        if (this.currentAffix == null) {
            this.currentAffix = new StringBuilder();
        }
        PatternStringUtils.patternInfoToStringBuilder(this.patternInfo, z, PatternStringUtils.resolveSignDisplay(this.signDisplay, this.signum), this.approximately, this.plural, this.perMilleReplacesPercent, this.currentAffix);
    }

    public MicroPropsGenerator addToChain(MicroPropsGenerator microPropsGenerator) {
        this.parent = microPropsGenerator;
        return this;
    }

    @Override // com.ibm.icu.impl.number.Modifier
    public int apply(FormattedStringBuilder formattedStringBuilder, int i, int i2) {
        FormattedStringBuilder formattedStringBuilder2;
        int iSplice;
        int iInsertPrefix = insertPrefix(formattedStringBuilder, i);
        int i3 = i2 + iInsertPrefix;
        int iInsertSuffix = insertSuffix(formattedStringBuilder, i3);
        if (this.patternInfo.hasBody()) {
            formattedStringBuilder2 = formattedStringBuilder;
            iSplice = 0;
        } else {
            iSplice = formattedStringBuilder.splice(i + iInsertPrefix, i3, "", 0, 0, null);
            formattedStringBuilder2 = formattedStringBuilder;
        }
        CurrencySpacingEnabledModifier.applyCurrencySpacing(formattedStringBuilder2, i, iInsertPrefix, i3 + iSplice, iInsertSuffix, this.symbols);
        return iInsertPrefix + iSplice + iInsertSuffix;
    }

    @Override // com.ibm.icu.impl.number.Modifier
    public boolean containsField(Format.Field field) {
        return false;
    }

    public ImmutablePatternModifier createImmutable() {
        FormattedStringBuilder formattedStringBuilder = new FormattedStringBuilder();
        FormattedStringBuilder formattedStringBuilder2 = new FormattedStringBuilder();
        if (!needsPlurals()) {
            setNumberProperties(Modifier.Signum.POS, null);
            ConstantMultiFieldModifier constantMultiFieldModifierCreateConstantModifier = createConstantModifier(formattedStringBuilder, formattedStringBuilder2);
            setNumberProperties(Modifier.Signum.POS_ZERO, null);
            ConstantMultiFieldModifier constantMultiFieldModifierCreateConstantModifier2 = createConstantModifier(formattedStringBuilder, formattedStringBuilder2);
            setNumberProperties(Modifier.Signum.NEG_ZERO, null);
            ConstantMultiFieldModifier constantMultiFieldModifierCreateConstantModifier3 = createConstantModifier(formattedStringBuilder, formattedStringBuilder2);
            setNumberProperties(Modifier.Signum.NEG, null);
            return new ImmutablePatternModifier(new AdoptingModifierStore(constantMultiFieldModifierCreateConstantModifier, constantMultiFieldModifierCreateConstantModifier2, constantMultiFieldModifierCreateConstantModifier3, createConstantModifier(formattedStringBuilder, formattedStringBuilder2)), null);
        }
        AdoptingModifierStore adoptingModifierStore = new AdoptingModifierStore();
        for (StandardPlural standardPlural : StandardPlural.VALUES) {
            Modifier.Signum signum = Modifier.Signum.POS;
            setNumberProperties(signum, standardPlural);
            adoptingModifierStore.setModifier(signum, standardPlural, createConstantModifier(formattedStringBuilder, formattedStringBuilder2));
            Modifier.Signum signum2 = Modifier.Signum.POS_ZERO;
            setNumberProperties(signum2, standardPlural);
            adoptingModifierStore.setModifier(signum2, standardPlural, createConstantModifier(formattedStringBuilder, formattedStringBuilder2));
            Modifier.Signum signum3 = Modifier.Signum.NEG_ZERO;
            setNumberProperties(signum3, standardPlural);
            adoptingModifierStore.setModifier(signum3, standardPlural, createConstantModifier(formattedStringBuilder, formattedStringBuilder2));
            Modifier.Signum signum4 = Modifier.Signum.NEG;
            setNumberProperties(signum4, standardPlural);
            adoptingModifierStore.setModifier(signum4, standardPlural, createConstantModifier(formattedStringBuilder, formattedStringBuilder2));
        }
        adoptingModifierStore.freeze();
        return new ImmutablePatternModifier(adoptingModifierStore, this.rules);
    }

    @Override // com.ibm.icu.impl.number.Modifier
    public int getCodePointCount() {
        prepareAffix(true);
        int iUnescapedCount = AffixUtils.unescapedCount(this.currentAffix, false, this);
        prepareAffix(false);
        return AffixUtils.unescapedCount(this.currentAffix, false, this) + iUnescapedCount;
    }

    public String getCurrencySymbolForUnitWidth() {
        int i;
        NumberFormatter.UnitWidth unitWidth = this.unitWidth;
        if (unitWidth == NumberFormatter.UnitWidth.ISO_CODE) {
            return this.currency.getCurrencyCode();
        }
        if (unitWidth == NumberFormatter.UnitWidth.HIDDEN) {
            return "";
        }
        int i2 = AnonymousClass1.$SwitchMap$com$ibm$icu$number$NumberFormatter$UnitWidth[unitWidth.ordinal()];
        if (i2 != 1) {
            i = 3;
            if (i2 != 2) {
                if (i2 == 3) {
                    i = 4;
                } else {
                    if (i2 != 4) {
                        throw new AssertionError();
                    }
                    i = 5;
                }
            }
        } else {
            i = 0;
        }
        return this.currency.getName(this.symbols.getULocale(), i, (boolean[]) null);
    }

    @Override // com.ibm.icu.impl.number.Modifier
    public Modifier.Parameters getParameters() {
        return null;
    }

    @Override // com.ibm.icu.impl.number.Modifier
    public int getPrefixLength() {
        prepareAffix(true);
        return AffixUtils.unescapedCount(this.currentAffix, true, this);
    }

    @Override // com.ibm.icu.impl.number.AffixUtils.SymbolProvider
    public CharSequence getSymbol(int i) {
        switch (i) {
            case AffixUtils.TYPE_CURRENCY_QUINT /* -10 */:
                return this.currency.getName(this.symbols.getULocale(), 3, (boolean[]) null);
            case AffixUtils.TYPE_CURRENCY_QUAD /* -9 */:
                return "�";
            case AffixUtils.TYPE_CURRENCY_TRIPLE /* -8 */:
                return this.currency.getName(this.symbols.getULocale(), 2, this.plural.getKeyword(), (boolean[]) null);
            case AffixUtils.TYPE_CURRENCY_DOUBLE /* -7 */:
                return this.currency.getCurrencyCode();
            case AffixUtils.TYPE_CURRENCY_SINGLE /* -6 */:
                return getCurrencySymbolForUnitWidth();
            case AffixUtils.TYPE_PERMILLE /* -5 */:
                return this.symbols.getPerMillString();
            case AffixUtils.TYPE_PERCENT /* -4 */:
                return this.symbols.getPercentString();
            case -3:
                return this.symbols.getApproximatelySignString();
            case -2:
                return this.symbols.getPlusSignString();
            case -1:
                return this.symbols.getMinusSignString();
            default:
                throw new AssertionError();
        }
    }

    @Override // com.ibm.icu.impl.number.Modifier
    public boolean isStrong() {
        return this.isStrong;
    }

    public boolean needsPlurals() {
        return this.patternInfo.containsSymbolType(-8);
    }

    @Override // com.ibm.icu.impl.number.MicroPropsGenerator
    public MicroProps processQuantity(DecimalQuantity decimalQuantity) {
        MicroProps microPropsProcessQuantity = this.parent.processQuantity(decimalQuantity);
        Precision precision = microPropsProcessQuantity.rounder;
        if (precision != null) {
            precision.apply(decimalQuantity);
        }
        if (microPropsProcessQuantity.modMiddle != null) {
            return microPropsProcessQuantity;
        }
        if (needsPlurals()) {
            setNumberProperties(decimalQuantity.signum(), RoundingUtils.getPluralSafe(microPropsProcessQuantity.rounder, this.rules, decimalQuantity));
        } else {
            setNumberProperties(decimalQuantity.signum(), null);
        }
        microPropsProcessQuantity.modMiddle = this;
        return microPropsProcessQuantity;
    }

    public void setNumberProperties(Modifier.Signum signum, StandardPlural standardPlural) {
        this.signum = signum;
        this.plural = standardPlural;
    }

    public void setPatternAttributes(NumberFormatter.SignDisplay signDisplay, boolean z, boolean z2) {
        this.signDisplay = signDisplay;
        this.perMilleReplacesPercent = z;
        this.approximately = z2;
    }

    public void setPatternInfo(AffixPatternProvider affixPatternProvider, NumberFormat.Field field) {
        this.patternInfo = affixPatternProvider;
        this.field = field;
    }

    public void setSymbols(DecimalFormatSymbols decimalFormatSymbols, Currency currency, NumberFormatter.UnitWidth unitWidth, PluralRules pluralRules) {
        this.symbols = decimalFormatSymbols;
        this.currency = currency;
        this.unitWidth = unitWidth;
        this.rules = pluralRules;
    }

    @Override // com.ibm.icu.impl.number.Modifier
    public boolean strictEquals(Modifier modifier) {
        return false;
    }
}
