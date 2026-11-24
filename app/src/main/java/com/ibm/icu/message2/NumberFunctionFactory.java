package com.ibm.icu.message2;

import com.ibm.icu.math.BigDecimal;
import com.ibm.icu.number.FormattedNumber;
import com.ibm.icu.number.LocalizedNumberFormatter;
import com.ibm.icu.number.Notation;
import com.ibm.icu.number.NumberFormatter;
import com.ibm.icu.number.Precision;
import com.ibm.icu.number.UnlocalizedNumberFormatter;
import com.ibm.icu.text.FormattedValue;
import com.ibm.icu.text.NumberingSystem;
import com.ibm.icu.text.PluralRules;
import com.ibm.icu.util.Currency;
import com.ibm.icu.util.CurrencyAmount;
import com.ibm.icu.util.NoUnit;
import defpackage.cq;
import defpackage.dk0;
import defpackage.og;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
class NumberFunctionFactory implements FunctionFactory {
    private static final Pattern CURRENCY_ISO_CODE = Pattern.compile("^[A-Z][A-Z][A-Z]$", 2);
    private final String kind;

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class ResolvedOffsetOptions {
        final int operand;
        final boolean reportErrors;

        public ResolvedOffsetOptions(int i, boolean z) {
            this.operand = i;
            this.reportErrors = z;
        }

        public static ResolvedOffsetOptions of(Map<String, ?> map) {
            int iIntValue;
            boolean zReportErrors = OptUtils.reportErrors(map);
            Integer digitSizeOption = OptUtils.getDigitSizeOption(map, zReportErrors, "add");
            Integer digitSizeOption2 = OptUtils.getDigitSizeOption(map, zReportErrors, "subtract");
            if (digitSizeOption == null) {
                if (digitSizeOption2 == null) {
                    og.i("bad-option: :offset function needs an `add` or `subtract` option.");
                    return null;
                }
                iIntValue = -OptUtils.asNumber(zReportErrors, "subtract", digitSizeOption2).intValue();
            } else {
                if (digitSizeOption2 != null) {
                    og.i("bad-option: :offset function can't have both `add` and `subtract` options.");
                    return null;
                }
                iIntValue = OptUtils.asNumber(zReportErrors, "add", digitSizeOption).intValue();
            }
            return new ResolvedOffsetOptions(iIntValue, zReportErrors);
        }
    }

    public NumberFunctionFactory(String str) {
        str.getClass();
        switch (str) {
            case "number":
            case "offset":
            case "percent":
            case "currency":
            case "integer":
                break;
            default:
                str = "number";
                break;
        }
        this.kind = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:30:0x0086  */
    /* JADX WARN: Code duplicated, block: B:62:0x0154  */
    /* JADX WARN: Code duplicated, block: B:76:0x018c  */
    public static LocalizedNumberFormatter functionForOptions(Locale locale, Map<String, ?> map, String str) {
        NumberFormatter.SignDisplay signDisplay;
        NumberFormatter.GroupingStrategy groupingStrategy;
        NumberFormatter.UnitWidth unitWidth;
        Notation notationSimple;
        boolean zReportErrors = OptUtils.reportErrors(map);
        String string = OptUtils.getString(map, "icu:skeleton");
        if (string != null) {
            return NumberFormatter.forSkeleton(string).locale(locale);
        }
        UnlocalizedNumberFormatter unlocalizedNumberFormatterWith = NumberFormatter.with();
        if (Objects.equals(str, "number")) {
            String string2 = OptUtils.getString(map, "notation", "standard");
            switch (string2.hashCode()) {
                case 950483747:
                    if (!string2.equals("compact")) {
                        notationSimple = Notation.simple();
                    } else {
                        String string3 = OptUtils.getString(map, "compactDisplay", "short");
                        int iHashCode = string3.hashCode();
                        if (iHashCode == 3327612) {
                            if (string3.equals("long")) {
                                notationSimple = Notation.compactLong();
                            }
                        } else if (iHashCode == 109413500) {
                            string3.equals("short");
                        }
                        notationSimple = Notation.compactShort();
                    }
                    break;
                case 1312628413:
                    string2.equals("standard");
                    notationSimple = Notation.simple();
                    break;
                case 1341032489:
                    if (!string2.equals("scientific")) {
                        notationSimple = Notation.simple();
                    } else {
                        notationSimple = Notation.scientific();
                    }
                    break;
                case 1706610451:
                    if (!string2.equals("engineering")) {
                        notationSimple = Notation.simple();
                    } else {
                        notationSimple = Notation.engineering();
                    }
                    break;
                default:
                    notationSimple = Notation.simple();
                    break;
            }
            unlocalizedNumberFormatterWith = unlocalizedNumberFormatterWith.notation(notationSimple);
            OptUtils.getString(map, "style", "decimal");
            Integer digitSizeOption = OptUtils.getDigitSizeOption(map, zReportErrors, "minimumFractionDigits");
            if (digitSizeOption != null) {
                unlocalizedNumberFormatterWith = unlocalizedNumberFormatterWith.precision(Precision.minFraction(digitSizeOption.intValue()));
            }
            Integer digitSizeOption2 = OptUtils.getDigitSizeOption(map, zReportErrors, "maximumFractionDigits");
            if (digitSizeOption2 != null) {
                unlocalizedNumberFormatterWith = unlocalizedNumberFormatterWith.precision(Precision.maxFraction(digitSizeOption2.intValue()));
            }
            Integer digitSizeOption3 = OptUtils.getDigitSizeOption(map, zReportErrors, "minimumSignificantDigits");
            if (digitSizeOption3 != null) {
                unlocalizedNumberFormatterWith = unlocalizedNumberFormatterWith.precision(Precision.minSignificantDigits(digitSizeOption3.intValue()));
            }
        }
        String string4 = OptUtils.getString(map, "numberingSystem", "");
        if (!string4.isEmpty()) {
            unlocalizedNumberFormatterWith = unlocalizedNumberFormatterWith.symbols(NumberingSystem.getInstanceByName(string4.toLowerCase(Locale.US)));
        }
        OptUtils.getDigitSizeOption(map, zReportErrors, "minimumIntegerDigits");
        Integer digitSizeOption4 = OptUtils.getDigitSizeOption(map, zReportErrors, "maximumSignificantDigits");
        if (digitSizeOption4 != null) {
            unlocalizedNumberFormatterWith = unlocalizedNumberFormatterWith.precision(Precision.maxSignificantDigits(digitSizeOption4.intValue()));
        }
        String string5 = OptUtils.getString(map, "signDisplay", "auto");
        switch (string5.hashCode()) {
            case -1414557169:
                if (!string5.equals("always")) {
                    signDisplay = NumberFormatter.SignDisplay.AUTO;
                } else {
                    signDisplay = NumberFormatter.SignDisplay.ALWAYS;
                }
                break;
            case -1314700447:
                if (!string5.equals("exceptZero")) {
                    signDisplay = NumberFormatter.SignDisplay.AUTO;
                } else {
                    signDisplay = NumberFormatter.SignDisplay.EXCEPT_ZERO;
                }
                break;
            case 3005871:
                string5.equals("auto");
                signDisplay = NumberFormatter.SignDisplay.AUTO;
                break;
            case 104712844:
                if (!string5.equals("never")) {
                    signDisplay = NumberFormatter.SignDisplay.AUTO;
                } else {
                    signDisplay = NumberFormatter.SignDisplay.NEVER;
                }
                break;
            case 921111605:
                if (!string5.equals("negative")) {
                    signDisplay = NumberFormatter.SignDisplay.AUTO;
                } else {
                    signDisplay = NumberFormatter.SignDisplay.NEGATIVE;
                }
                break;
            default:
                signDisplay = NumberFormatter.SignDisplay.AUTO;
                break;
        }
        UnlocalizedNumberFormatter unlocalizedNumberFormatterSign = unlocalizedNumberFormatterWith.sign(signDisplay);
        String string6 = OptUtils.getString(map, "useGrouping", "auto");
        switch (string6.hashCode()) {
            case -1414557169:
                if (!string6.equals("always")) {
                    groupingStrategy = NumberFormatter.GroupingStrategy.AUTO;
                } else {
                    groupingStrategy = NumberFormatter.GroupingStrategy.ON_ALIGNED;
                }
                break;
            case 3005871:
                string6.equals("auto");
                groupingStrategy = NumberFormatter.GroupingStrategy.AUTO;
                break;
            case 3351584:
                if (!string6.equals("min2")) {
                    groupingStrategy = NumberFormatter.GroupingStrategy.AUTO;
                } else {
                    groupingStrategy = NumberFormatter.GroupingStrategy.MIN2;
                }
                break;
            case 104712844:
                if (!string6.equals("never")) {
                    groupingStrategy = NumberFormatter.GroupingStrategy.AUTO;
                } else {
                    groupingStrategy = NumberFormatter.GroupingStrategy.OFF;
                }
                break;
            default:
                groupingStrategy = NumberFormatter.GroupingStrategy.AUTO;
                break;
        }
        UnlocalizedNumberFormatter unlocalizedNumberFormatterGrouping = unlocalizedNumberFormatterSign.grouping(groupingStrategy);
        if (str.equals("integer")) {
            unlocalizedNumberFormatterGrouping = unlocalizedNumberFormatterGrouping.precision(Precision.integer());
        }
        if (str.equals("currency")) {
            String currency = getCurrency(map);
            if (currency != null) {
                unlocalizedNumberFormatterGrouping = unlocalizedNumberFormatterGrouping.unit(Currency.getInstance(currency));
            }
            String string7 = OptUtils.getString(map, "currencySign", "standard");
            int iHashCode2 = string7.hashCode();
            if (iHashCode2 == -803323243) {
                string7.equals("accounting");
            } else if (iHashCode2 == 1312628413) {
                string7.equals("standard");
            }
            String string8 = OptUtils.getString(map, "currencyDisplay", "symbol");
            string8.getClass();
            switch (string8) {
                case "narrowSymbol":
                    unitWidth = NumberFormatter.UnitWidth.NARROW;
                    break;
                case "symbol":
                    unitWidth = NumberFormatter.UnitWidth.SHORT;
                    break;
                case "formalSymbol":
                    unitWidth = NumberFormatter.UnitWidth.FORMAL;
                    break;
                case "code":
                    unitWidth = NumberFormatter.UnitWidth.ISO_CODE;
                    break;
                case "name":
                    unitWidth = NumberFormatter.UnitWidth.FULL_NAME;
                    break;
                case "never":
                    unitWidth = NumberFormatter.UnitWidth.HIDDEN;
                    break;
                default:
                    unitWidth = NumberFormatter.UnitWidth.SHORT;
                    break;
            }
            unlocalizedNumberFormatterGrouping = unlocalizedNumberFormatterGrouping.unitWidth(unitWidth);
        }
        if (str.equals("percent")) {
            unlocalizedNumberFormatterGrouping = unlocalizedNumberFormatterGrouping.unit(NoUnit.PERCENT);
        }
        return unlocalizedNumberFormatterGrouping.locale(locale);
    }

    public static String getCurrency(Map<String, ?> map) {
        String string = OptUtils.getString(map, "currency", null);
        if (string != null) {
            if (CURRENCY_ISO_CODE.matcher(string).find()) {
                return string;
            }
            if (OptUtils.reportErrors(map)) {
                og.i("bad-option: the `currency` must be an ISO 4217 code.");
            }
        }
        return null;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.ibm.icu.message2.FunctionFactory
    public Function create(Locale locale, Map<String, ?> map) {
        PluralRules.PluralType pluralType;
        boolean zReportErrors = OptUtils.reportErrors(map);
        String string = OptUtils.getString(map, "select", "");
        string.getClass();
        byte b = -1;
        switch (string.hashCode()) {
            case -1206994319:
                if (string.equals("ordinal")) {
                    b = 0;
                }
                break;
            case -7612640:
                if (string.equals("cardinal")) {
                    b = 1;
                }
                break;
            case 0:
                if (string.equals("")) {
                    b = 2;
                }
                break;
            case 96946943:
                if (string.equals("exact")) {
                    b = 3;
                }
                break;
        }
        switch (b) {
            case 0:
                pluralType = PluralRules.PluralType.ORDINAL;
                break;
            case 1:
            case 2:
                pluralType = PluralRules.PluralType.CARDINAL;
                break;
            case 3:
                pluralType = null;
                break;
            default:
                if (zReportErrors) {
                    og.i(cq.v("bad-option: invalid value `", string, "` for `select`."));
                    return null;
                }
                pluralType = PluralRules.PluralType.CARDINAL;
                break;
        }
        return new NumberFunctionImpl(locale, pluralType != null ? PluralRules.forLocale(locale, pluralType) : null, map, this.kind);
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class NumberFunctionImpl implements Function {
        private static final String NO_MATCH = "�NO_MATCH\ufffe";
        private final Map<String, ?> fixedOptions;
        private final LocalizedNumberFormatter icuFormatter;
        private final String kind;
        private final Locale locale;
        private final PluralRules rules;

        public NumberFunctionImpl(Locale locale, PluralRules pluralRules, Map<String, ?> map, String str) {
            Locale bestLocale = OptUtils.getBestLocale(map, locale);
            this.locale = bestLocale;
            this.fixedOptions = new HashMap(map);
            OptUtils.getString(map, "icu:skeleton");
            this.icuFormatter = NumberFunctionFactory.functionForOptions(bestLocale, map, str);
            this.kind = str;
            this.rules = pluralRules;
        }

        private boolean matches(Object obj, String str, Map<String, ?> map) {
            Number numberResolveValue;
            String strSelect;
            if (MFDataModel.CatchallKey.isCatchAll(str)) {
                return true;
            }
            OptUtils.reportErrors(this.fixedOptions);
            if (obj instanceof FormattedPlaceholder) {
                obj = ((FormattedPlaceholder) obj).getInput();
            }
            if ((!(obj instanceof Number) && !(obj instanceof CharSequence)) || (numberResolveValue = resolveValue(obj, map)) == null) {
                return false;
            }
            if (Objects.equals(this.kind, "integer")) {
                numberResolveValue = Long.valueOf(numberResolveValue.longValue());
            }
            Number numberAsNumber = OptUtils.asNumber(str);
            if (numberAsNumber != null && numberResolveValue.doubleValue() == numberAsNumber.doubleValue()) {
                return true;
            }
            FormattedNumber formattedNumber = this.icuFormatter.format(numberResolveValue.doubleValue());
            PluralRules pluralRules = this.rules;
            if (pluralRules != null) {
                strSelect = pluralRules.select(formattedNumber);
            } else {
                strSelect = str.equals(formattedNumber.toString()) ? str : PluralRules.KEYWORD_OTHER;
            }
            if (strSelect.equals(PluralRules.KEYWORD_OTHER)) {
                strSelect = "<<::CatchallKey::>>";
            }
            return strSelect.equals(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static int pluralComparator(String str, String str2) {
            if (str.equals(str2)) {
                return 0;
            }
            if (NO_MATCH.equals(str)) {
                return 1;
            }
            if (NO_MATCH.equals(str2)) {
                return -1;
            }
            if (MFDataModel.CatchallKey.isCatchAll(str)) {
                return 1;
            }
            if (MFDataModel.CatchallKey.isCatchAll(str2) || OptUtils.asNumber(str) != null) {
                return -1;
            }
            if (OptUtils.asNumber(str2) != null) {
                return 1;
            }
            return str.compareTo(str2);
        }

        private Number resolveValue(Object obj, Map<String, ?> map) {
            Map<String, ?> map2;
            HashMap map3 = new HashMap(this.fixedOptions);
            if (!map.isEmpty()) {
                map3.putAll(map);
            }
            boolean zReportErrors = OptUtils.reportErrors(map3);
            Integer integer = OptUtils.getInteger(map3, zReportErrors, "icu:offset");
            if (integer == null && (map2 = this.fixedOptions) != null) {
                integer = OptUtils.getInteger(map2, zReportErrors, "icu:offset");
            }
            if (integer == null) {
                integer = 0;
            }
            int i = Objects.equals(this.kind, "offset") ? ResolvedOffsetOptions.of(map3).operand : 0;
            if (this.kind.equals("currency") && NumberFunctionFactory.getCurrency(map3) == null && !(obj instanceof CurrencyAmount)) {
                og.i("bad-option: the `currency` must be an ISO 4217 code.");
                return null;
            }
            boolean zEquals = this.kind.equals("percent");
            boolean zEquals2 = this.kind.equals("integer");
            if (obj == null) {
                dk0.n("Argument to format can't be null");
                return null;
            }
            if (obj instanceof Double) {
                if (zEquals2) {
                    obj = Double.valueOf(Math.floor(((Double) obj).doubleValue()));
                }
                double dDoubleValue = (((Double) obj).doubleValue() - ((double) integer.intValue())) + ((double) i);
                if (zEquals) {
                    dDoubleValue *= 100.0d;
                }
                return Double.valueOf(dDoubleValue);
            }
            if (obj instanceof Long) {
                long jLongValue = (((Long) obj).longValue() - ((long) integer.intValue())) + ((long) i);
                if (zEquals) {
                    jLongValue *= 100;
                }
                return Long.valueOf(jLongValue);
            }
            if (obj instanceof Integer) {
                int iIntValue = (((Integer) obj).intValue() - integer.intValue()) + i;
                if (zEquals) {
                    iIntValue *= 100;
                }
                return Integer.valueOf(iIntValue);
            }
            if (obj instanceof BigDecimal) {
                BigDecimal bigDecimalMultiply = (BigDecimal) obj;
                if (zEquals) {
                    bigDecimalMultiply = bigDecimalMultiply.multiply(BigDecimal.valueOf(100L));
                }
                if (zEquals2) {
                    bigDecimalMultiply.longValue();
                }
                BigDecimal bigDecimalSubtract = bigDecimalMultiply.subtract(BigDecimal.valueOf(integer.intValue()));
                return i != 0 ? bigDecimalSubtract.add(BigDecimal.valueOf(i)) : bigDecimalSubtract;
            }
            if (obj instanceof Number) {
                if (zEquals2) {
                    obj = Double.valueOf(Math.floor(((Number) obj).doubleValue()));
                }
                double dDoubleValue2 = (((Number) obj).doubleValue() - ((double) integer.intValue())) + ((double) i);
                if (zEquals) {
                    dDoubleValue2 *= 100.0d;
                }
                return Double.valueOf(dDoubleValue2);
            }
            if (obj instanceof CurrencyAmount) {
                return ((CurrencyAmount) obj).getNumber();
            }
            Number numberAsNumber = OptUtils.asNumber(zReportErrors, "argument", Objects.toString(obj));
            if (numberAsNumber == null) {
                return null;
            }
            double dIntValue = zEquals2 ? numberAsNumber.intValue() : (numberAsNumber.doubleValue() - ((double) integer.intValue())) + ((double) i);
            if (zEquals) {
                dIntValue *= 100.0d;
            }
            return Double.valueOf(dIntValue);
        }

        @Override // com.ibm.icu.message2.Function
        public FormattedPlaceholder format(Object obj, Map<String, ?> map) {
            LocalizedNumberFormatter localizedNumberFormatterFunctionForOptions;
            FormattedValue plainStringFormattedValue;
            HashMap map2 = new HashMap(this.fixedOptions);
            if (map.isEmpty()) {
                localizedNumberFormatterFunctionForOptions = this.icuFormatter;
            } else {
                map2.putAll(map);
                localizedNumberFormatterFunctionForOptions = NumberFunctionFactory.functionForOptions(this.locale, map2, this.kind);
            }
            if (obj == null) {
                dk0.n("Argument to format can't be null");
                return null;
            }
            if (obj instanceof CurrencyAmount) {
                plainStringFormattedValue = localizedNumberFormatterFunctionForOptions.format((CurrencyAmount) obj);
            } else {
                if (this.kind.equals("integer")) {
                    if (obj instanceof CharSequence) {
                        obj = OptUtils.asNumber(obj);
                    }
                    if (obj instanceof Number) {
                        obj = Long.valueOf(((Number) obj).longValue());
                    }
                }
                Number numberResolveValue = resolveValue(obj, map);
                plainStringFormattedValue = numberResolveValue == null ? new PlainStringFormattedValue(cq.v("{|", Objects.toString(obj), "|}")) : localizedNumberFormatterFunctionForOptions.format(numberResolveValue);
            }
            return new FormattedPlaceholder(obj, plainStringFormattedValue, OptUtils.getBestDirectionality(map, this.locale), false);
        }

        @Override // com.ibm.icu.message2.Function
        public String formatToString(Object obj, Map<String, ?> map) {
            return format(obj, map).toString();
        }

        public LocalizedNumberFormatter getIcuFormatter() {
            return this.icuFormatter;
        }

        @Override // com.ibm.icu.message2.Function
        public List<String> matches(Object obj, List<String> list, Map<String, ?> map) {
            if (this.kind.equals("currency")) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (obj == null) {
                return arrayList;
            }
            for (String str : list) {
                if (matches(obj, str, map)) {
                    arrayList.add(str);
                } else {
                    arrayList.add(NO_MATCH);
                }
            }
            arrayList.sort(new a(1));
            return arrayList;
        }
    }
}
