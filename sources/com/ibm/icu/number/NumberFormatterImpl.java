package com.ibm.icu.number;

import com.ibm.icu.impl.FormattedStringBuilder;
import com.ibm.icu.impl.IllegalIcuArgumentException;
import com.ibm.icu.impl.StandardPlural;
import com.ibm.icu.impl.number.AffixPatternProvider;
import com.ibm.icu.impl.number.CompactData;
import com.ibm.icu.impl.number.ConstantAffixModifier;
import com.ibm.icu.impl.number.DecimalQuantity;
import com.ibm.icu.impl.number.DecimalQuantity_DualStorageBCD;
import com.ibm.icu.impl.number.Grouper;
import com.ibm.icu.impl.number.LongNameHandler;
import com.ibm.icu.impl.number.LongNameMultiplexer;
import com.ibm.icu.impl.number.MacroProps;
import com.ibm.icu.impl.number.MicroProps;
import com.ibm.icu.impl.number.MicroPropsGenerator;
import com.ibm.icu.impl.number.MixedUnitLongNameHandler;
import com.ibm.icu.impl.number.MultiplierFormatHandler;
import com.ibm.icu.impl.number.MutablePatternModifier;
import com.ibm.icu.impl.number.Padder;
import com.ibm.icu.impl.number.PatternStringParser;
import com.ibm.icu.impl.number.RoundingUtils;
import com.ibm.icu.impl.number.UnitConversionHandler;
import com.ibm.icu.impl.number.UsagePrefsHandler;
import com.ibm.icu.text.DecimalFormatSymbols;
import com.ibm.icu.text.NumberFormat;
import com.ibm.icu.text.NumberingSystem;
import com.ibm.icu.text.PluralRules;
import com.ibm.icu.util.Currency;
import com.ibm.icu.util.MeasureUnit;
import defpackage.dk0;
import defpackage.og;
import java.math.RoundingMode;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
class NumberFormatterImpl {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Currency DEFAULT_CURRENCY = Currency.getInstance("XXX");
    private static final int MAX_FORMATTED_DIGITS = 999999;
    final MicroPropsGenerator microPropsGenerator;
    final MicroProps micros;

    public NumberFormatterImpl(MacroProps macroProps) {
        MicroProps microProps = new MicroProps(true);
        this.micros = microProps;
        this.microPropsGenerator = macrosToMicroGenerator(macroProps, microProps, true);
    }

    public static MicroProps formatStatic(MacroProps macroProps, DecimalQuantity decimalQuantity, FormattedStringBuilder formattedStringBuilder) {
        MicroProps microPropsPreProcessUnsafe = preProcessUnsafe(macroProps, decimalQuantity);
        writeAffixes(microPropsPreProcessUnsafe, formattedStringBuilder, 0, writeNumber(microPropsPreProcessUnsafe, decimalQuantity, formattedStringBuilder, 0));
        return microPropsPreProcessUnsafe;
    }

    private static int getPrefixSuffixImpl(MicroPropsGenerator microPropsGenerator, byte b, FormattedStringBuilder formattedStringBuilder) {
        DecimalQuantity_DualStorageBCD decimalQuantity_DualStorageBCD = new DecimalQuantity_DualStorageBCD(0);
        if (b < 0) {
            decimalQuantity_DualStorageBCD.negate();
        }
        MicroProps microPropsProcessQuantity = microPropsGenerator.processQuantity(decimalQuantity_DualStorageBCD);
        microPropsProcessQuantity.modMiddle.apply(formattedStringBuilder, 0, 0);
        return microPropsProcessQuantity.modMiddle.getPrefixLength();
    }

    public static int getPrefixSuffixStatic(MacroProps macroProps, byte b, StandardPlural standardPlural, FormattedStringBuilder formattedStringBuilder) {
        return getPrefixSuffixImpl(macrosToMicroGenerator(macroProps, new MicroProps(false), false), b, formattedStringBuilder);
    }

    /* JADX WARN: Code duplicated, block: B:126:0x01d9  */
    /* JADX WARN: Code duplicated, block: B:51:0x00c3  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private static MicroPropsGenerator macrosToMicroGenerator(MacroProps macroProps, MicroProps microProps, boolean z) {
        MicroPropsGenerator unitConversionHandler;
        UsagePrefsHandler usagePrefsHandler;
        MicroPropsGenerator microPropsGeneratorForCurrencyLongNames;
        MutablePatternModifier mutablePatternModifier;
        MicroPropsGenerator microPropsGeneratorForMeasureUnit;
        int i;
        boolean zUnitIsCurrency = unitIsCurrency(macroProps.unit);
        boolean zUnitIsBaseUnit = unitIsBaseUnit(macroProps.unit);
        boolean zUnitIsPercent = unitIsPercent(macroProps.unit);
        boolean zUnitIsPermille = unitIsPermille(macroProps.unit);
        boolean z2 = macroProps.notation instanceof CompactNotation;
        NumberFormatter.SignDisplay signDisplay = macroProps.sign;
        boolean z3 = signDisplay == NumberFormatter.SignDisplay.ACCOUNTING || signDisplay == NumberFormatter.SignDisplay.ACCOUNTING_ALWAYS || signDisplay == NumberFormatter.SignDisplay.ACCOUNTING_EXCEPT_ZERO || signDisplay == NumberFormatter.SignDisplay.ACCOUNTING_NEGATIVE;
        Currency currency = zUnitIsCurrency ? (Currency) macroProps.unit : DEFAULT_CURRENCY;
        NumberFormatter.UnitWidth unitWidth = NumberFormatter.UnitWidth.SHORT;
        NumberFormatter.UnitWidth unitWidth2 = macroProps.unitWidth;
        if (unitWidth2 != null) {
            unitWidth = unitWidth2;
        }
        boolean z4 = (zUnitIsCurrency || zUnitIsBaseUnit || (unitWidth != NumberFormatter.UnitWidth.FULL_NAME && ((zUnitIsPercent || zUnitIsPermille) && !z2))) ? false : true;
        boolean z5 = z4 && macroProps.unit.getType() == null && macroProps.unit.getComplexity() == MeasureUnit.Complexity.MIXED;
        PluralRules pluralRulesForLocale = macroProps.rules;
        Object obj = macroProps.symbols;
        NumberingSystem numberingSystem = obj instanceof NumberingSystem ? (NumberingSystem) obj : NumberingSystem.getInstance(macroProps.loc);
        microProps.nsName = numberingSystem.getName();
        microProps.gender = "";
        Object obj2 = macroProps.symbols;
        if (obj2 instanceof DecimalFormatSymbols) {
            microProps.symbols = (DecimalFormatSymbols) obj2;
        } else {
            microProps.symbols = DecimalFormatSymbols.forNumberingSystem(macroProps.loc.setKeywordValue("currency", currency.toString()), numberingSystem);
        }
        String currencyPattern = (!zUnitIsCurrency || microProps.symbols.getCurrencyPattern() == null) ? null : microProps.symbols.getCurrencyPattern();
        if (currencyPattern == null) {
            if (z4) {
                i = 0;
            } else if (zUnitIsPercent || zUnitIsPermille) {
                i = 2;
            } else if (!zUnitIsCurrency || unitWidth == NumberFormatter.UnitWidth.FULL_NAME) {
                i = 0;
            } else {
                i = z3 ? 7 : 1;
            }
            currencyPattern = NumberFormat.getPatternForStyleAndNumberingSystem(macroProps.loc, microProps.nsName, i);
        }
        PatternStringParser.ParsedPatternInfo toPatternInfo = PatternStringParser.parseToPatternInfo(currencyPattern);
        String str = macroProps.usage;
        if (str == null) {
            unitConversionHandler = z5 ? new UnitConversionHandler(macroProps.unit, microProps) : microProps;
            usagePrefsHandler = 0;
        } else {
            if (z4 == 0) {
                throw new IllegalIcuArgumentException("We only support \"usage\" when the input unit is specified, and is a CLDR Unit.");
            }
            unitConversionHandler = new UsagePrefsHandler(macroProps.loc, macroProps.unit, str, microProps);
            usagePrefsHandler = unitConversionHandler;
        }
        Scale scale = macroProps.scale;
        if (scale != null) {
            unitConversionHandler = new MultiplierFormatHandler(scale, unitConversionHandler);
        }
        Precision precision = macroProps.precision;
        if (precision != null) {
            microProps.rounder = precision;
        } else if (z2) {
            microProps.rounder = Precision.COMPACT_STRATEGY;
        } else if (zUnitIsCurrency) {
            microProps.rounder = Precision.MONETARY_STANDARD;
        } else if (macroProps.usage != null) {
            microProps.rounder = Precision.BOGUS_PRECISION;
        } else {
            microProps.rounder = Precision.DEFAULT_MAX_FRAC_6;
        }
        RoundingMode roundingMode = macroProps.roundingMode;
        if (roundingMode != null) {
            microProps.rounder = microProps.rounder.withMode(RoundingUtils.mathContextUnlimited(roundingMode));
        }
        microProps.rounder = microProps.rounder.withLocaleData(currency);
        Object obj3 = macroProps.grouping;
        if (obj3 instanceof Grouper) {
            microProps.grouping = (Grouper) obj3;
        } else if (obj3 instanceof NumberFormatter.GroupingStrategy) {
            microProps.grouping = Grouper.forStrategy((NumberFormatter.GroupingStrategy) obj3);
        } else if (z2) {
            microProps.grouping = Grouper.forStrategy(NumberFormatter.GroupingStrategy.MIN2);
        } else {
            microProps.grouping = Grouper.forStrategy(NumberFormatter.GroupingStrategy.AUTO);
        }
        microProps.grouping = microProps.grouping.withLocaleData(macroProps.loc, toPatternInfo);
        Padder padder = macroProps.padder;
        if (padder != null) {
            microProps.padding = padder;
        } else {
            microProps.padding = Padder.NONE;
        }
        IntegerWidth integerWidth = macroProps.integerWidth;
        if (integerWidth != null) {
            microProps.integerWidth = integerWidth;
        } else {
            microProps.integerWidth = IntegerWidth.DEFAULT;
        }
        NumberFormatter.SignDisplay signDisplay2 = macroProps.sign;
        if (signDisplay2 != null) {
            microProps.sign = signDisplay2;
        } else {
            microProps.sign = NumberFormatter.SignDisplay.AUTO;
        }
        NumberFormatter.DecimalSeparatorDisplay decimalSeparatorDisplay = macroProps.decimal;
        if (decimalSeparatorDisplay != null) {
            microProps.decimal = decimalSeparatorDisplay;
        } else {
            microProps.decimal = NumberFormatter.DecimalSeparatorDisplay.AUTO;
        }
        microProps.useCurrency = zUnitIsCurrency;
        Notation notation = macroProps.notation;
        if (notation instanceof ScientificNotation) {
            unitConversionHandler = ((ScientificNotation) notation).withLocaleData(microProps.symbols, z, unitConversionHandler);
        } else {
            microProps.modInner = ConstantAffixModifier.EMPTY;
        }
        MicroPropsGenerator microPropsGenerator = unitConversionHandler;
        MutablePatternModifier mutablePatternModifier2 = new MutablePatternModifier(false);
        AffixPatternProvider affixPatternProvider = macroProps.affixProvider;
        AffixPatternProvider affixPatternProvider2 = toPatternInfo;
        if (affixPatternProvider != null) {
            if (z2) {
                affixPatternProvider2 = toPatternInfo;
                if (zUnitIsCurrency == affixPatternProvider.hasCurrencySign()) {
                    affixPatternProvider2 = macroProps.affixProvider;
                }
            } else {
                affixPatternProvider2 = macroProps.affixProvider;
            }
        }
        mutablePatternModifier2.setPatternInfo(affixPatternProvider2, null);
        Boolean bool = macroProps.approximately;
        mutablePatternModifier2.setPatternAttributes(microProps.sign, zUnitIsPermille, bool != null ? bool.booleanValue() : false);
        if (mutablePatternModifier2.needsPlurals()) {
            if (pluralRulesForLocale == null) {
                pluralRulesForLocale = PluralRules.forLocale(macroProps.loc);
            }
            mutablePatternModifier2.setSymbols(microProps.symbols, currency, unitWidth, pluralRulesForLocale);
        } else {
            mutablePatternModifier2.setSymbols(microProps.symbols, currency, unitWidth, null);
        }
        MutablePatternModifier.ImmutablePatternModifier immutablePatternModifierCreateImmutable = z ? mutablePatternModifier2.createImmutable() : null;
        if (affixPatternProvider2.currencyAsDecimal()) {
            microProps.currencyAsDecimal = mutablePatternModifier2.getCurrencySymbolForUnitWidth();
        }
        if (z4 != 0) {
            String str2 = macroProps.unitDisplayCase;
            String str3 = str2 != null ? str2 : null;
            PluralRules pluralRulesForLocale2 = pluralRulesForLocale == null ? PluralRules.forLocale(macroProps.loc) : pluralRulesForLocale;
            PluralRules pluralRulesForLocale3 = macroProps.rules;
            if (pluralRulesForLocale3 == null) {
                pluralRulesForLocale3 = PluralRules.forLocale(macroProps.loc);
            }
            PluralRules pluralRules = pluralRulesForLocale3;
            if (macroProps.usage != null) {
                microPropsGeneratorForMeasureUnit = LongNameMultiplexer.forMeasureUnits(macroProps.loc, usagePrefsHandler.getOutputUnits(), unitWidth, str3, pluralRules, microPropsGenerator);
            } else {
                NumberFormatter.UnitWidth unitWidth3 = unitWidth;
                if (z5) {
                    microPropsGeneratorForMeasureUnit = MixedUnitLongNameHandler.forMeasureUnit(macroProps.loc, macroProps.unit, unitWidth3, str3, pluralRules, microPropsGenerator);
                } else {
                    MeasureUnit measureUnitProduct = macroProps.unit;
                    MeasureUnit measureUnit = macroProps.perUnit;
                    if (measureUnit != null) {
                        measureUnitProduct = measureUnitProduct.product(measureUnit.reciprocal());
                        if (measureUnitProduct.getType() == null && (macroProps.unit.getType() == null || macroProps.perUnit.getType() == null)) {
                            dk0.r("perUnit() can only be used if unit and perUnit are both built-ins, or the combination is a built-in");
                            return null;
                        }
                    }
                    microPropsGeneratorForMeasureUnit = LongNameHandler.forMeasureUnit(macroProps.loc, measureUnitProduct, unitWidth3, str3, pluralRules, microPropsGenerator);
                }
            }
            microPropsGeneratorForCurrencyLongNames = microPropsGeneratorForMeasureUnit;
            pluralRulesForLocale = pluralRulesForLocale2;
        } else {
            NumberFormatter.UnitWidth unitWidth4 = unitWidth;
            if (zUnitIsCurrency && unitWidth4 == NumberFormatter.UnitWidth.FULL_NAME) {
                if (pluralRulesForLocale == null) {
                    pluralRulesForLocale = PluralRules.forLocale(macroProps.loc);
                }
                microPropsGeneratorForCurrencyLongNames = LongNameHandler.forCurrencyLongNames(macroProps.loc, currency, pluralRulesForLocale, microPropsGenerator);
            } else {
                microProps.modOuter = ConstantAffixModifier.EMPTY;
                microPropsGeneratorForCurrencyLongNames = microPropsGenerator;
            }
        }
        if (z2) {
            if (pluralRulesForLocale == null) {
                pluralRulesForLocale = PluralRules.forLocale(macroProps.loc);
            }
            MutablePatternModifier mutablePatternModifier3 = mutablePatternModifier2;
            microPropsGeneratorForCurrencyLongNames = ((CompactNotation) macroProps.notation).withLocaleData(macroProps.loc, microProps.nsName, (!(macroProps.unit instanceof Currency) || macroProps.unitWidth == NumberFormatter.UnitWidth.FULL_NAME) ? CompactData.CompactType.DECIMAL : CompactData.CompactType.CURRENCY, pluralRulesForLocale, mutablePatternModifier3, z, microPropsGeneratorForCurrencyLongNames);
            mutablePatternModifier = mutablePatternModifier3;
        } else {
            mutablePatternModifier = mutablePatternModifier2;
        }
        MicroPropsGenerator microPropsGenerator2 = microPropsGeneratorForCurrencyLongNames;
        return z ? immutablePatternModifierCreateImmutable.addToChain(microPropsGenerator2) : mutablePatternModifier.addToChain(microPropsGenerator2);
    }

    private static MicroProps preProcessUnsafe(MacroProps macroProps, DecimalQuantity decimalQuantity) {
        MicroProps microPropsProcessQuantity = macrosToMicroGenerator(macroProps, new MicroProps(false), false).processQuantity(decimalQuantity);
        IntegerWidth integerWidth = microPropsProcessQuantity.integerWidth;
        if (integerWidth.maxInt == -1) {
            decimalQuantity.setMinInteger(integerWidth.minInt);
            return microPropsProcessQuantity;
        }
        decimalQuantity.setMinInteger(integerWidth.minInt);
        decimalQuantity.applyMaxInteger(microPropsProcessQuantity.integerWidth.maxInt);
        return microPropsProcessQuantity;
    }

    private static boolean unitIsBaseUnit(MeasureUnit measureUnit) {
        return measureUnit == null;
    }

    private static boolean unitIsCurrency(MeasureUnit measureUnit) {
        return measureUnit != null && "currency".equals(measureUnit.getType());
    }

    private static boolean unitIsPercent(MeasureUnit measureUnit) {
        return measureUnit != null && "percent".equals(measureUnit.getSubtype());
    }

    private static boolean unitIsPermille(MeasureUnit measureUnit) {
        return measureUnit != null && "permille".equals(measureUnit.getSubtype());
    }

    public static int writeAffixes(MicroProps microProps, FormattedStringBuilder formattedStringBuilder, int i, int i2) {
        int iApply = microProps.modInner.apply(formattedStringBuilder, i, i2);
        if (microProps.padding.isValid()) {
            microProps.padding.padAndApply(microProps.modMiddle, microProps.modOuter, formattedStringBuilder, i, i2 + iApply);
            return iApply;
        }
        int iApply2 = microProps.modMiddle.apply(formattedStringBuilder, i, i2 + iApply) + iApply;
        return microProps.modOuter.apply(formattedStringBuilder, i, i2 + iApply2) + iApply2;
    }

    private static int writeFractionDigits(MicroProps microProps, DecimalQuantity decimalQuantity, FormattedStringBuilder formattedStringBuilder, int i) {
        int i2 = -decimalQuantity.getLowerDisplayMagnitude();
        if (i2 > MAX_FORMATTED_DIGITS) {
            og.i("Magnitude exceeds maximum required fraction digits.");
            return 0;
        }
        int iInsertCodePoint = 0;
        for (int i3 = 0; i3 < i2; i3++) {
            byte digit = decimalQuantity.getDigit((-i3) - 1);
            int codePointZero = microProps.symbols.getCodePointZero();
            DecimalFormatSymbols decimalFormatSymbols = microProps.symbols;
            iInsertCodePoint = (codePointZero != -1 ? formattedStringBuilder.insertCodePoint(iInsertCodePoint + i, decimalFormatSymbols.getCodePointZero() + digit, NumberFormat.Field.FRACTION) : formattedStringBuilder.insert(iInsertCodePoint + i, decimalFormatSymbols.getDigitStringsLocal()[digit], NumberFormat.Field.FRACTION)) + iInsertCodePoint;
        }
        return iInsertCodePoint;
    }

    private static int writeIntegerDigits(MicroProps microProps, DecimalQuantity decimalQuantity, FormattedStringBuilder formattedStringBuilder, int i) {
        int upperDisplayMagnitude = decimalQuantity.getUpperDisplayMagnitude() + 1;
        if (upperDisplayMagnitude > MAX_FORMATTED_DIGITS) {
            og.i("Magnitude exceeds maximum required integer digits.");
            return 0;
        }
        int iInsertCodePoint = 0;
        for (int i2 = 0; i2 < upperDisplayMagnitude; i2++) {
            if (microProps.grouping.groupAtPosition(i2, decimalQuantity)) {
                boolean z = microProps.useCurrency;
                DecimalFormatSymbols decimalFormatSymbols = microProps.symbols;
                iInsertCodePoint += formattedStringBuilder.insert(i, z ? decimalFormatSymbols.getMonetaryGroupingSeparatorString() : decimalFormatSymbols.getGroupingSeparatorString(), NumberFormat.Field.GROUPING_SEPARATOR);
            }
            byte digit = decimalQuantity.getDigit(i2);
            int codePointZero = microProps.symbols.getCodePointZero();
            DecimalFormatSymbols decimalFormatSymbols2 = microProps.symbols;
            iInsertCodePoint = (codePointZero != -1 ? formattedStringBuilder.insertCodePoint(i, decimalFormatSymbols2.getCodePointZero() + digit, NumberFormat.Field.INTEGER) : formattedStringBuilder.insert(i, decimalFormatSymbols2.getDigitStringsLocal()[digit], NumberFormat.Field.INTEGER)) + iInsertCodePoint;
        }
        return iInsertCodePoint;
    }

    public static int writeNumber(MicroProps microProps, DecimalQuantity decimalQuantity, FormattedStringBuilder formattedStringBuilder, int i) {
        int iInsert;
        if (decimalQuantity.isInfinite()) {
            return formattedStringBuilder.insert(i, microProps.symbols.getInfinity(), NumberFormat.Field.INTEGER);
        }
        if (decimalQuantity.isNaN()) {
            return formattedStringBuilder.insert(i, microProps.symbols.getNaN(), NumberFormat.Field.INTEGER);
        }
        if (decimalQuantity.getUpperDisplayMagnitude() + 1 > MAX_FORMATTED_DIGITS || (-decimalQuantity.getLowerDisplayMagnitude()) > MAX_FORMATTED_DIGITS) {
            og.i("Magnitude exceeds maximum required integer or fraction digits.");
            return 0;
        }
        int iWriteIntegerDigits = writeIntegerDigits(microProps, decimalQuantity, formattedStringBuilder, i);
        if (decimalQuantity.getLowerDisplayMagnitude() < 0 || microProps.decimal == NumberFormatter.DecimalSeparatorDisplay.ALWAYS) {
            String str = microProps.currencyAsDecimal;
            if (str != null) {
                iInsert = formattedStringBuilder.insert(iWriteIntegerDigits + i, str, NumberFormat.Field.CURRENCY);
            } else {
                boolean z = microProps.useCurrency;
                DecimalFormatSymbols decimalFormatSymbols = microProps.symbols;
                iInsert = z ? formattedStringBuilder.insert(iWriteIntegerDigits + i, decimalFormatSymbols.getMonetaryDecimalSeparatorString(), NumberFormat.Field.DECIMAL_SEPARATOR) : formattedStringBuilder.insert(iWriteIntegerDigits + i, decimalFormatSymbols.getDecimalSeparatorString(), NumberFormat.Field.DECIMAL_SEPARATOR);
            }
            iWriteIntegerDigits += iInsert;
        }
        int iWriteFractionDigits = iWriteIntegerDigits + writeFractionDigits(microProps, decimalQuantity, formattedStringBuilder, iWriteIntegerDigits + i);
        if (iWriteFractionDigits != 0) {
            return iWriteFractionDigits;
        }
        int codePointZero = microProps.symbols.getCodePointZero();
        DecimalFormatSymbols decimalFormatSymbols2 = microProps.symbols;
        return codePointZero != -1 ? formattedStringBuilder.insertCodePoint(i, decimalFormatSymbols2.getCodePointZero(), NumberFormat.Field.INTEGER) + iWriteFractionDigits : formattedStringBuilder.insert(i, decimalFormatSymbols2.getDigitStringsLocal()[0], NumberFormat.Field.INTEGER) + iWriteFractionDigits;
    }

    public MicroProps format(DecimalQuantity decimalQuantity, FormattedStringBuilder formattedStringBuilder) {
        MicroProps microPropsPreProcess = preProcess(decimalQuantity);
        writeAffixes(microPropsPreProcess, formattedStringBuilder, 0, writeNumber(microPropsPreProcess, decimalQuantity, formattedStringBuilder, 0));
        return microPropsPreProcess;
    }

    public int getPrefixSuffix(byte b, StandardPlural standardPlural, FormattedStringBuilder formattedStringBuilder) {
        return getPrefixSuffixImpl(this.microPropsGenerator, b, formattedStringBuilder);
    }

    public MicroProps getRawMicroProps() {
        return this.micros;
    }

    public MicroProps preProcess(DecimalQuantity decimalQuantity) {
        MicroProps microPropsProcessQuantity = this.microPropsGenerator.processQuantity(decimalQuantity);
        IntegerWidth integerWidth = microPropsProcessQuantity.integerWidth;
        if (integerWidth.maxInt == -1) {
            decimalQuantity.setMinInteger(integerWidth.minInt);
            return microPropsProcessQuantity;
        }
        decimalQuantity.setMinInteger(integerWidth.minInt);
        decimalQuantity.applyMaxInteger(microPropsProcessQuantity.integerWidth.maxInt);
        return microPropsProcessQuantity;
    }
}
