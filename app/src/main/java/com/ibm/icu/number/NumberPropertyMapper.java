package com.ibm.icu.number;

import com.ibm.icu.impl.number.AffixPatternProvider;
import com.ibm.icu.impl.number.CustomSymbolCurrency;
import com.ibm.icu.impl.number.DecimalFormatProperties;
import com.ibm.icu.impl.number.Grouper;
import com.ibm.icu.impl.number.MacroProps;
import com.ibm.icu.impl.number.Padder;
import com.ibm.icu.impl.number.PatternStringParser;
import com.ibm.icu.impl.number.PatternStringUtils;
import com.ibm.icu.impl.number.PropertiesAffixPatternProvider;
import com.ibm.icu.impl.number.RoundingUtils;
import com.ibm.icu.text.CompactDecimalFormat;
import com.ibm.icu.text.DecimalFormatSymbols;
import com.ibm.icu.text.PluralRules;
import com.ibm.icu.util.Currency;
import com.ibm.icu.util.ULocale;
import java.math.BigDecimal;
import java.math.MathContext;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
final class NumberPropertyMapper {
    public static UnlocalizedNumberFormatter create(DecimalFormatProperties decimalFormatProperties, DecimalFormatSymbols decimalFormatSymbols) {
        return NumberFormatter.with().macros(oldToNew(decimalFormatProperties, decimalFormatSymbols, null));
    }

    /* JADX WARN: Code duplicated, block: B:72:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:94:0x0127  */
    public static MacroProps oldToNew(DecimalFormatProperties decimalFormatProperties, DecimalFormatSymbols decimalFormatSymbols, DecimalFormatProperties decimalFormatProperties2) {
        Precision precisionConstructCurrency;
        BigDecimal bigDecimal;
        MacroProps macroProps = new MacroProps();
        ULocale uLocale = decimalFormatSymbols.getULocale();
        macroProps.symbols = decimalFormatSymbols;
        PluralRules pluralRules = decimalFormatProperties.getPluralRules();
        if (pluralRules == null && decimalFormatProperties.getCurrencyPluralInfo() != null) {
            pluralRules = decimalFormatProperties.getCurrencyPluralInfo().getPluralRules();
        }
        macroProps.rules = pluralRules;
        AffixPatternProvider affixPatternProviderForProperties = PropertiesAffixPatternProvider.forProperties(decimalFormatProperties);
        macroProps.affixProvider = affixPatternProviderForProperties;
        boolean z = (decimalFormatProperties.getCurrency() == null && decimalFormatProperties.getCurrencyPluralInfo() == null && decimalFormatProperties.getCurrencyUsage() == null && !affixPatternProviderForProperties.hasCurrencySign()) ? false : true;
        Currency currencyResolve = CustomSymbolCurrency.resolve(decimalFormatProperties.getCurrency(), uLocale, decimalFormatSymbols);
        Currency.CurrencyUsage currencyUsage = decimalFormatProperties.getCurrencyUsage();
        boolean z2 = currencyUsage != null;
        if (!z2) {
            currencyUsage = Currency.CurrencyUsage.STANDARD;
        }
        if (z) {
            macroProps.unit = currencyResolve;
        }
        int maximumIntegerDigits = decimalFormatProperties.getMaximumIntegerDigits();
        int minimumIntegerDigits = decimalFormatProperties.getMinimumIntegerDigits();
        int maximumFractionDigits = decimalFormatProperties.getMaximumFractionDigits();
        int minimumFractionDigits = decimalFormatProperties.getMinimumFractionDigits();
        int minimumSignificantDigits = decimalFormatProperties.getMinimumSignificantDigits();
        int maximumSignificantDigits = decimalFormatProperties.getMaximumSignificantDigits();
        BigDecimal roundingIncrement = decimalFormatProperties.getRoundingIncrement();
        MathContext mathContextOrUnlimited = RoundingUtils.getMathContextOrUnlimited(decimalFormatProperties);
        boolean z3 = (minimumFractionDigits == -1 && maximumFractionDigits == -1) ? false : true;
        boolean z4 = (minimumSignificantDigits == -1 && maximumSignificantDigits == -1) ? false : true;
        if (z) {
            if (minimumFractionDigits == -1 && maximumFractionDigits == -1) {
                minimumFractionDigits = currencyResolve.getDefaultFractionDigits(currencyUsage);
                maximumFractionDigits = currencyResolve.getDefaultFractionDigits(currencyUsage);
            } else if (minimumFractionDigits == -1) {
                minimumFractionDigits = Math.min(maximumFractionDigits, currencyResolve.getDefaultFractionDigits(currencyUsage));
            } else if (maximumFractionDigits == -1) {
                maximumFractionDigits = Math.max(minimumFractionDigits, currencyResolve.getDefaultFractionDigits(currencyUsage));
            }
        }
        if (minimumIntegerDigits != 0 || maximumFractionDigits == 0) {
            if (minimumFractionDigits < 0) {
                minimumFractionDigits = 0;
            }
            if (maximumFractionDigits < 0) {
                maximumFractionDigits = -1;
            } else if (maximumFractionDigits < minimumFractionDigits) {
                maximumFractionDigits = minimumFractionDigits;
            }
            if (minimumIntegerDigits <= 0 || minimumIntegerDigits > 999) {
                minimumIntegerDigits = 1;
            }
            if (maximumIntegerDigits < 0) {
                maximumIntegerDigits = -1;
            } else if (maximumIntegerDigits < minimumIntegerDigits) {
                maximumIntegerDigits = minimumIntegerDigits;
            } else if (maximumIntegerDigits > 999) {
                maximumIntegerDigits = -1;
            }
        } else {
            if (minimumFractionDigits < 0 || (minimumFractionDigits == 0 && maximumIntegerDigits == 0)) {
                minimumFractionDigits = 1;
            }
            if (maximumFractionDigits < 0) {
                maximumFractionDigits = -1;
            } else if (maximumFractionDigits < minimumFractionDigits) {
                maximumFractionDigits = minimumFractionDigits;
            }
            if (maximumIntegerDigits < 0 || maximumIntegerDigits > 999) {
                maximumIntegerDigits = -1;
            }
            minimumIntegerDigits = 0;
        }
        if (z2) {
            precisionConstructCurrency = Precision.constructCurrency(currencyUsage).withCurrency(currencyResolve);
        } else if (roundingIncrement != null) {
            if (PatternStringUtils.ignoreRoundingIncrement(roundingIncrement, maximumFractionDigits)) {
                precisionConstructCurrency = Precision.constructFraction(minimumFractionDigits, maximumFractionDigits);
            } else {
                if (minimumFractionDigits > roundingIncrement.scale()) {
                    roundingIncrement = roundingIncrement.setScale(minimumFractionDigits);
                }
                precisionConstructCurrency = Precision.constructIncrement(roundingIncrement);
            }
        } else if (z4) {
            if (minimumSignificantDigits < 1) {
                minimumSignificantDigits = 1;
            } else if (minimumSignificantDigits > 999) {
                minimumSignificantDigits = 999;
            }
            if (maximumSignificantDigits < 0) {
                maximumSignificantDigits = 999;
            } else if (maximumSignificantDigits < minimumSignificantDigits) {
                maximumSignificantDigits = minimumSignificantDigits;
            } else if (maximumSignificantDigits > 999) {
                maximumSignificantDigits = 999;
            }
            precisionConstructCurrency = Precision.constructSignificant(minimumSignificantDigits, maximumSignificantDigits);
        } else if (z3) {
            precisionConstructCurrency = Precision.constructFraction(minimumFractionDigits, maximumFractionDigits);
        } else {
            precisionConstructCurrency = z ? Precision.constructCurrency(currencyUsage) : null;
        }
        if (precisionConstructCurrency != null) {
            precisionConstructCurrency = precisionConstructCurrency.withMode(mathContextOrUnlimited);
            macroProps.precision = precisionConstructCurrency;
        }
        macroProps.integerWidth = IntegerWidth.zeroFillTo(minimumIntegerDigits).truncateAt(maximumIntegerDigits);
        macroProps.grouping = Grouper.forProperties(decimalFormatProperties);
        if (decimalFormatProperties.getFormatWidth() > 0) {
            macroProps.padder = Padder.forProperties(decimalFormatProperties);
        }
        macroProps.decimal = decimalFormatProperties.getDecimalSeparatorAlwaysShown() ? NumberFormatter.DecimalSeparatorDisplay.ALWAYS : NumberFormatter.DecimalSeparatorDisplay.AUTO;
        macroProps.sign = decimalFormatProperties.getSignAlwaysShown() ? NumberFormatter.SignDisplay.ALWAYS : NumberFormatter.SignDisplay.AUTO;
        if (decimalFormatProperties.getMinimumExponentDigits() != -1) {
            if (maximumIntegerDigits > 8) {
                macroProps.integerWidth = IntegerWidth.zeroFillTo(minimumIntegerDigits).truncateAt(minimumIntegerDigits);
                maximumIntegerDigits = minimumIntegerDigits;
            } else if (maximumIntegerDigits > minimumIntegerDigits && minimumIntegerDigits > 1) {
                macroProps.integerWidth = IntegerWidth.zeroFillTo(1).truncateAt(maximumIntegerDigits);
                minimumIntegerDigits = 1;
            }
            int i = maximumIntegerDigits < 0 ? -1 : maximumIntegerDigits;
            macroProps.notation = new ScientificNotation(i, i == minimumIntegerDigits, decimalFormatProperties.getMinimumExponentDigits(), decimalFormatProperties.getExponentSignAlwaysShown() ? NumberFormatter.SignDisplay.ALWAYS : NumberFormatter.SignDisplay.AUTO);
            if (macroProps.precision instanceof FractionPrecision) {
                int maximumIntegerDigits2 = decimalFormatProperties.getMaximumIntegerDigits();
                int minimumIntegerDigits2 = decimalFormatProperties.getMinimumIntegerDigits();
                int minimumFractionDigits2 = decimalFormatProperties.getMinimumFractionDigits();
                int maximumFractionDigits2 = decimalFormatProperties.getMaximumFractionDigits();
                if (minimumIntegerDigits2 == 0 && maximumFractionDigits2 == 0) {
                    macroProps.precision = Precision.constructInfinite().withMode(mathContextOrUnlimited);
                } else if (minimumIntegerDigits2 == 0 && minimumFractionDigits2 == 0) {
                    macroProps.precision = Precision.constructSignificant(1, maximumFractionDigits2 + 1).withMode(mathContextOrUnlimited);
                } else {
                    int i2 = 1;
                    int i3 = maximumFractionDigits2 + minimumIntegerDigits2;
                    if (maximumIntegerDigits2 <= minimumIntegerDigits2 || minimumIntegerDigits2 <= 1) {
                        i2 = minimumIntegerDigits2;
                    }
                    macroProps.precision = Precision.constructSignificant(i2 + minimumFractionDigits2, i3).withMode(mathContextOrUnlimited);
                }
            }
        }
        if (decimalFormatProperties.getCompactStyle() != null) {
            if (decimalFormatProperties.getCompactCustomData() != null) {
                macroProps.notation = new CompactNotation(decimalFormatProperties.getCompactCustomData());
            } else if (decimalFormatProperties.getCompactStyle() == CompactDecimalFormat.CompactStyle.LONG) {
                macroProps.notation = Notation.compactLong();
            } else {
                macroProps.notation = Notation.compactShort();
            }
        }
        macroProps.scale = RoundingUtils.scaleFromProperties(decimalFormatProperties);
        if (decimalFormatProperties2 != null) {
            decimalFormatProperties2.setCurrency(currencyResolve);
            decimalFormatProperties2.setMathContext(mathContextOrUnlimited);
            decimalFormatProperties2.setRoundingMode(mathContextOrUnlimited.getRoundingMode());
            decimalFormatProperties2.setMinimumIntegerDigits(minimumIntegerDigits);
            if (maximumIntegerDigits == -1) {
                maximumIntegerDigits = Integer.MAX_VALUE;
            }
            decimalFormatProperties2.setMaximumIntegerDigits(maximumIntegerDigits);
            if (precisionConstructCurrency instanceof CurrencyPrecision) {
                precisionConstructCurrency = ((CurrencyPrecision) precisionConstructCurrency).withCurrency(currencyResolve);
            }
            if (precisionConstructCurrency instanceof Precision.FractionRounderImpl) {
                Precision.FractionRounderImpl fractionRounderImpl = (Precision.FractionRounderImpl) precisionConstructCurrency;
                minimumFractionDigits = fractionRounderImpl.minFrac;
                maximumFractionDigits = fractionRounderImpl.maxFrac;
            } else {
                if (precisionConstructCurrency instanceof Precision.IncrementRounderImpl) {
                    bigDecimal = ((Precision.IncrementRounderImpl) precisionConstructCurrency).increment;
                    minimumFractionDigits = bigDecimal.scale();
                    maximumFractionDigits = bigDecimal.scale();
                } else if (precisionConstructCurrency instanceof Precision.SignificantRounderImpl) {
                    Precision.SignificantRounderImpl significantRounderImpl = (Precision.SignificantRounderImpl) precisionConstructCurrency;
                    minimumSignificantDigits = significantRounderImpl.minSig;
                    maximumSignificantDigits = significantRounderImpl.maxSig;
                }
                decimalFormatProperties2.setMinimumFractionDigits(minimumFractionDigits);
                decimalFormatProperties2.setMaximumFractionDigits(maximumFractionDigits);
                decimalFormatProperties2.setMinimumSignificantDigits(minimumSignificantDigits);
                decimalFormatProperties2.setMaximumSignificantDigits(maximumSignificantDigits);
                decimalFormatProperties2.setRoundingIncrement(bigDecimal);
            }
            bigDecimal = null;
            decimalFormatProperties2.setMinimumFractionDigits(minimumFractionDigits);
            decimalFormatProperties2.setMaximumFractionDigits(maximumFractionDigits);
            decimalFormatProperties2.setMinimumSignificantDigits(minimumSignificantDigits);
            decimalFormatProperties2.setMaximumSignificantDigits(maximumSignificantDigits);
            decimalFormatProperties2.setRoundingIncrement(bigDecimal);
        }
        return macroProps;
    }

    public static UnlocalizedNumberFormatter create(DecimalFormatProperties decimalFormatProperties, DecimalFormatSymbols decimalFormatSymbols, DecimalFormatProperties decimalFormatProperties2) {
        return NumberFormatter.with().macros(oldToNew(decimalFormatProperties, decimalFormatSymbols, decimalFormatProperties2));
    }

    public static UnlocalizedNumberFormatter create(String str, DecimalFormatSymbols decimalFormatSymbols) {
        return create(PatternStringParser.parseToProperties(str), decimalFormatSymbols);
    }
}
