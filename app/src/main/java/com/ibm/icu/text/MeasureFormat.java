package com.ibm.icu.text;

import com.ibm.icu.impl.DontCareFieldPosition;
import com.ibm.icu.impl.FormattedStringBuilder;
import com.ibm.icu.impl.FormattedValueStringBuilderImpl;
import com.ibm.icu.impl.ICUData;
import com.ibm.icu.impl.ICUResourceBundle;
import com.ibm.icu.impl.SimpleCache;
import com.ibm.icu.impl.SimpleFormatterImpl;
import com.ibm.icu.impl.Utility;
import com.ibm.icu.impl.number.DecimalQuantity_DualStorageBCD;
import com.ibm.icu.impl.number.LongNameHandler;
import com.ibm.icu.impl.number.RoundingUtils;
import com.ibm.icu.lang.UCharacterEnums;
import com.ibm.icu.number.IntegerWidth;
import com.ibm.icu.number.LocalizedNumberFormatter;
import com.ibm.icu.number.NumberFormatter;
import com.ibm.icu.number.Precision;
import com.ibm.icu.util.Currency;
import com.ibm.icu.util.Measure;
import com.ibm.icu.util.MeasureUnit;
import com.ibm.icu.util.ULocale;
import com.ibm.icu.util.UResourceBundle;
import defpackage.dk0;
import defpackage.kf2;
import defpackage.ky0;
import defpackage.og;
import java.io.Externalizable;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.math.RoundingMode;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class MeasureFormat extends UFormat {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int CURRENCY_FORMAT = 2;
    private static final int MEASURE_FORMAT = 0;
    static final int NUMBER_FORMATTER_CURRENCY = 2;
    static final int NUMBER_FORMATTER_INTEGER = 3;
    static final int NUMBER_FORMATTER_STANDARD = 1;
    private static final int TIME_UNIT_FORMAT = 1;
    private static final Map<MeasureUnit, Integer> hmsTo012;
    private static final Map<ULocale, String> localeIdToRangeFormat;
    private static final SimpleCache<ULocale, NumericFormatters> localeToNumericDurationFormatters = new SimpleCache<>();
    static final long serialVersionUID = -7182021401701778240L;
    private final transient FormatWidth formatWidth;
    private transient ConcurrentHashMap<NumberFormatterCacheKey, LocalizedNumberFormatter> formatterCache;
    private final transient NumberFormat numberFormat;
    private final transient LocalizedNumberFormatter numberFormatter;
    private final transient NumericFormatters numericFormatters;
    private final transient PluralRules rules;

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'WIDE' uses external variables
    	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:485)
    	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:422)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:351)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:284)
    	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:153)
    	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
     */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class FormatWidth {
        private static final /* synthetic */ FormatWidth[] $VALUES;

        @Deprecated
        public static final FormatWidth DEFAULT_CURRENCY;
        public static final FormatWidth NARROW;
        public static final FormatWidth NUMERIC;
        public static final FormatWidth SHORT;
        public static final FormatWidth WIDE;
        final NumberFormatter.UnitWidth currencyWidth;
        final ListFormatter.Width listWidth;
        final NumberFormatter.UnitWidth unitWidth;

        static {
            ListFormatter.Width width = ListFormatter.Width.WIDE;
            NumberFormatter.UnitWidth unitWidth = NumberFormatter.UnitWidth.FULL_NAME;
            FormatWidth formatWidth = new FormatWidth("WIDE", 0, width, unitWidth, unitWidth);
            WIDE = formatWidth;
            ListFormatter.Width width2 = ListFormatter.Width.SHORT;
            NumberFormatter.UnitWidth unitWidth2 = NumberFormatter.UnitWidth.SHORT;
            FormatWidth formatWidth2 = new FormatWidth("SHORT", 1, width2, unitWidth2, NumberFormatter.UnitWidth.ISO_CODE);
            SHORT = formatWidth2;
            ListFormatter.Width width3 = ListFormatter.Width.NARROW;
            NumberFormatter.UnitWidth unitWidth3 = NumberFormatter.UnitWidth.NARROW;
            FormatWidth formatWidth3 = new FormatWidth("NARROW", 2, width3, unitWidth3, unitWidth2);
            NARROW = formatWidth3;
            FormatWidth formatWidth4 = new FormatWidth("NUMERIC", 3, width3, unitWidth3, unitWidth2);
            NUMERIC = formatWidth4;
            FormatWidth formatWidth5 = new FormatWidth("DEFAULT_CURRENCY", 4, width2, unitWidth, unitWidth2);
            DEFAULT_CURRENCY = formatWidth5;
            $VALUES = new FormatWidth[]{formatWidth, formatWidth2, formatWidth3, formatWidth4, formatWidth5};
        }

        private FormatWidth(String str, int i, ListFormatter.Width width, NumberFormatter.UnitWidth unitWidth, NumberFormatter.UnitWidth unitWidth2) {
            super(str, i);
            this.listWidth = width;
            this.unitWidth = unitWidth;
            this.currencyWidth = unitWidth2;
        }

        public static FormatWidth valueOf(String str) {
            return (FormatWidth) Enum.valueOf(FormatWidth.class, str);
        }

        public static FormatWidth[] values() {
            return (FormatWidth[]) $VALUES.clone();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class NumberFormatterCacheKey {
        final MeasureUnit perUnit;
        final int type;
        final MeasureUnit unit;

        public NumberFormatterCacheKey(int i, MeasureUnit measureUnit, MeasureUnit measureUnit2) {
            this.type = i;
            this.unit = measureUnit;
            this.perUnit = measureUnit2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof NumberFormatterCacheKey)) {
                return false;
            }
            NumberFormatterCacheKey numberFormatterCacheKey = (NumberFormatterCacheKey) obj;
            if (this.type == numberFormatterCacheKey.type && this.unit.equals(numberFormatterCacheKey.unit)) {
                MeasureUnit measureUnit = this.perUnit;
                MeasureUnit measureUnit2 = numberFormatterCacheKey.perUnit;
                if (measureUnit != null ? measureUnit.equals(measureUnit2) : measureUnit2 == null) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            int iHashCode = (this.unit.hashCode() + (this.type * 31)) * 31;
            MeasureUnit measureUnit = this.perUnit;
            return iHashCode + (measureUnit != null ? measureUnit.hashCode() : 0);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class NumericFormatters {
        private String hourMinute;
        private String hourMinuteSecond;
        private String minuteSecond;

        public NumericFormatters(String str, String str2, String str3) {
            this.hourMinute = str;
            this.minuteSecond = str2;
            this.hourMinuteSecond = str3;
        }

        public String getHourMinute() {
            return this.hourMinute;
        }

        public String getHourMinuteSecond() {
            return this.hourMinuteSecond;
        }

        public String getMinuteSecond() {
            return this.minuteSecond;
        }
    }

    static {
        HashMap map = new HashMap();
        hmsTo012 = map;
        map.put(MeasureUnit.HOUR, 0);
        map.put(MeasureUnit.MINUTE, 1);
        map.put(MeasureUnit.SECOND, 2);
        localeIdToRangeFormat = new ConcurrentHashMap();
    }

    private MeasureFormat(ULocale uLocale, FormatWidth formatWidth, NumberFormat numberFormat, PluralRules pluralRules, NumericFormatters numericFormatters) {
        SimpleCache<ULocale, NumericFormatters> simpleCache;
        this.formatterCache = new ConcurrentHashMap<>();
        setLocale(uLocale, uLocale);
        this.formatWidth = formatWidth;
        this.rules = pluralRules == null ? PluralRules.forLocale(uLocale) : pluralRules;
        NumberFormat numberFormat2 = numberFormat == null ? NumberFormat.getInstance(uLocale) : numberFormat.clone();
        this.numberFormat = numberFormat2;
        if (numericFormatters == null && formatWidth == FormatWidth.NUMERIC && (numericFormatters = (simpleCache = localeToNumericDurationFormatters).get(uLocale)) == null) {
            numericFormatters = loadNumericFormatters(uLocale);
            simpleCache.put(uLocale, numericFormatters);
        }
        this.numericFormatters = numericFormatters;
        if (numberFormat2 instanceof DecimalFormat) {
            this.numberFormatter = ((DecimalFormat) numberFormat2).toNumberFormatter().unitWidth(formatWidth.unitWidth);
        } else {
            dk0.v();
            throw null;
        }
    }

    private FormattedStringBuilder formatMeasure(Measure measure) {
        MeasureUnit unit = measure.getUnit();
        DecimalQuantity_DualStorageBCD decimalQuantity_DualStorageBCD = new DecimalQuantity_DualStorageBCD(measure.getNumber());
        FormattedStringBuilder formattedStringBuilder = new FormattedStringBuilder();
        if (unit instanceof Currency) {
            getUnitFormatterFromCache(2, unit, null).formatImpl(decimalQuantity_DualStorageBCD, formattedStringBuilder);
            return formattedStringBuilder;
        }
        getUnitFormatterFromCache(1, unit, null).formatImpl(decimalQuantity_DualStorageBCD, formattedStringBuilder);
        return formattedStringBuilder;
    }

    private FormattedStringBuilder formatMeasureInteger(Measure measure) {
        DecimalQuantity_DualStorageBCD decimalQuantity_DualStorageBCD = new DecimalQuantity_DualStorageBCD(measure.getNumber());
        FormattedStringBuilder formattedStringBuilder = new FormattedStringBuilder();
        getUnitFormatterFromCache(3, measure.getUnit(), null).formatImpl(decimalQuantity_DualStorageBCD, formattedStringBuilder);
        return formattedStringBuilder;
    }

    private void formatMeasuresInternal(Appendable appendable, FieldPosition fieldPosition, Measure... measureArr) {
        Number[] hms;
        if (measureArr.length == 0) {
            return;
        }
        if (measureArr.length == 1) {
            FormattedStringBuilder measure = formatMeasure(measureArr[0]);
            FormattedValueStringBuilderImpl.nextFieldPosition(measure, fieldPosition);
            Utility.appendTo(measure, appendable);
            return;
        }
        if (this.formatWidth == FormatWidth.NUMERIC && (hms = toHMS(measureArr)) != null) {
            formatNumeric(hms, appendable);
            return;
        }
        ListFormatter listFormatter = ListFormatter.getInstance(getLocale(), ListFormatter.Type.UNITS, this.formatWidth.listWidth);
        if (fieldPosition != DontCareFieldPosition.INSTANCE) {
            formatMeasuresSlowTrack(listFormatter, appendable, fieldPosition, measureArr);
            return;
        }
        String[] strArr = new String[measureArr.length];
        for (int i = 0; i < measureArr.length; i++) {
            if (i == measureArr.length - 1) {
                strArr[i] = formatMeasure(measureArr[i]).toString();
            } else {
                strArr[i] = formatMeasureInteger(measureArr[i]).toString();
            }
        }
        listFormatter.formatImpl(Arrays.asList(strArr), false).appendTo(appendable);
    }

    private void formatMeasuresSlowTrack(ListFormatter listFormatter, Appendable appendable, FieldPosition fieldPosition, Measure... measureArr) {
        String[] strArr = new String[measureArr.length];
        FieldPosition fieldPosition2 = new FieldPosition(fieldPosition.getFieldAttribute(), fieldPosition.getField());
        int i = 0;
        int i2 = -1;
        while (i < measureArr.length) {
            FormattedStringBuilder measure = i == measureArr.length - 1 ? formatMeasure(measureArr[i]) : formatMeasureInteger(measureArr[i]);
            if (i2 == -1) {
                FormattedValueStringBuilderImpl.nextFieldPosition(measure, fieldPosition2);
                if (fieldPosition2.getEndIndex() != 0) {
                    i2 = i;
                }
            }
            strArr[i] = measure.toString();
            i++;
        }
        ListFormatter.FormattedListBuilder impl = listFormatter.formatImpl(Arrays.asList(strArr), true);
        int offset = impl.getOffset(i2);
        if (offset != -1) {
            fieldPosition.setBeginIndex(fieldPosition2.getBeginIndex() + offset);
            fieldPosition.setEndIndex(fieldPosition2.getEndIndex() + offset);
        }
        impl.appendTo(appendable);
    }

    private void formatNumeric(Number[] numberArr, Appendable appendable) {
        String minuteSecond;
        Number number;
        int i;
        char c = 0;
        Number number2 = numberArr[0];
        if (number2 != null && numberArr[2] != null) {
            minuteSecond = this.numericFormatters.getHourMinuteSecond();
            if (numberArr[1] == null) {
                numberArr[1] = 0;
            }
            numberArr[1] = Double.valueOf(Math.floor(numberArr[1].doubleValue()));
            numberArr[0] = Double.valueOf(Math.floor(numberArr[0].doubleValue()));
        } else if (number2 != null && numberArr[1] != null) {
            minuteSecond = this.numericFormatters.getHourMinute();
            numberArr[0] = Double.valueOf(Math.floor(numberArr[0].doubleValue()));
        } else {
            if (numberArr[1] == null || numberArr[2] == null) {
                throw new IllegalStateException();
            }
            minuteSecond = this.numericFormatters.getMinuteSecond();
            numberArr[1] = Double.valueOf(Math.floor(numberArr[1].doubleValue()));
        }
        LocalizedNumberFormatter localizedNumberFormatterIntegerWidth = this.numberFormatter.integerWidth(IntegerWidth.zeroFillTo(2));
        FormattedStringBuilder formattedStringBuilder = new FormattedStringBuilder();
        int i2 = 0;
        boolean z = false;
        while (i2 < minuteSecond.length()) {
            char cCharAt = minuteSecond.charAt(i2);
            if (cCharAt == 'H') {
                number = numberArr[c];
            } else if (cCharAt != 'm') {
                number = cCharAt != 's' ? 0 : numberArr[2];
            } else {
                number = numberArr[1];
            }
            if (cCharAt == '\'') {
                i = i2 + 1;
                if (i >= minuteSecond.length() || minuteSecond.charAt(i) != cCharAt) {
                    z = !z;
                } else {
                    formattedStringBuilder.appendChar16(cCharAt, null);
                    i2 = i;
                }
            } else if (cCharAt != 'H' && cCharAt != 'm' && cCharAt != 's') {
                formattedStringBuilder.appendChar16(cCharAt, null);
            } else if (z) {
                formattedStringBuilder.appendChar16(cCharAt, null);
            } else {
                i = i2 + 1;
                if (i >= minuteSecond.length() || minuteSecond.charAt(i) != cCharAt) {
                    formattedStringBuilder.append(this.numberFormatter.format(number), (Object) null);
                } else {
                    formattedStringBuilder.append(localizedNumberFormatterIntegerWidth.format(number), (Object) null);
                    i2 = i;
                }
            }
            i2++;
            c = 0;
        }
        try {
            appendable.append(formattedStringBuilder);
        } catch (IOException e) {
            kf2.h(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static FormatWidth fromFormatWidthOrdinal(int i) {
        FormatWidth[] formatWidthArrValues = FormatWidth.values();
        return (i < 0 || i >= formatWidthArrValues.length) ? FormatWidth.SHORT : formatWidthArrValues[i];
    }

    public static MeasureFormat getCurrencyFormat() {
        return getCurrencyFormat(ULocale.getDefault(ULocale.Category.FORMAT));
    }

    public static MeasureFormat getInstance(ULocale uLocale, FormatWidth formatWidth, NumberFormat numberFormat) {
        return new MeasureFormat(uLocale, formatWidth, numberFormat, null, null);
    }

    @Deprecated
    public static String getRangeFormat(ULocale uLocale, FormatWidth formatWidth) {
        String stringWithFallback;
        String str;
        if (uLocale.getLanguage().equals("fr")) {
            return getRangeFormat(ULocale.ROOT, formatWidth);
        }
        Map<ULocale, String> map = localeIdToRangeFormat;
        String str2 = map.get(uLocale);
        if (str2 != null) {
            return str2;
        }
        ICUResourceBundle iCUResourceBundle = (ICUResourceBundle) UResourceBundle.getBundleInstance(ICUData.ICU_BASE_NAME, uLocale);
        ULocale uLocale2 = iCUResourceBundle.getULocale();
        if (!uLocale.equals(uLocale2) && (str = map.get(uLocale)) != null) {
            map.put(uLocale, str);
            return str;
        }
        try {
            stringWithFallback = iCUResourceBundle.getStringWithFallback("NumberElements/" + NumberingSystem.getInstance(uLocale).getName() + "/miscPatterns/range");
        } catch (MissingResourceException unused) {
            stringWithFallback = iCUResourceBundle.getStringWithFallback("NumberElements/latn/patterns/range");
        }
        String strCompileToStringMinMaxArguments = SimpleFormatterImpl.compileToStringMinMaxArguments(stringWithFallback, new StringBuilder(), 2, 2);
        Map<ULocale, String> map2 = localeIdToRangeFormat;
        map2.put(uLocale, strCompileToStringMinMaxArguments);
        if (!uLocale.equals(uLocale2)) {
            map2.put(uLocale2, strCompileToStringMinMaxArguments);
        }
        return strCompileToStringMinMaxArguments;
    }

    private LocalizedNumberFormatter getUnitFormatterFromCache(int i, MeasureUnit measureUnit, MeasureUnit measureUnit2) {
        return this.formatterCache.computeIfAbsent(new NumberFormatterCacheKey(i, measureUnit, measureUnit2), new Function() { // from class: com.ibm.icu.text.a
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.a.lambda$getUnitFormatterFromCache$0((MeasureFormat.NumberFormatterCacheKey) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ LocalizedNumberFormatter lambda$getUnitFormatterFromCache$0(NumberFormatterCacheKey numberFormatterCacheKey) {
        int i = numberFormatterCacheKey.type;
        if (i == 1) {
            return getNumberFormatter().unit(numberFormatterCacheKey.unit).perUnit(numberFormatterCacheKey.perUnit).unitWidth(this.formatWidth.unitWidth);
        }
        return i == 2 ? NumberFormatter.withLocale(getLocale()).unit(numberFormatterCacheKey.unit).perUnit(numberFormatterCacheKey.perUnit).unitWidth(this.formatWidth.currencyWidth) : getNumberFormatter().unit(numberFormatterCacheKey.unit).perUnit(numberFormatterCacheKey.perUnit).unitWidth(this.formatWidth.unitWidth).precision(Precision.integer().withMode(RoundingUtils.mathContextUnlimited(RoundingMode.DOWN)));
    }

    private static String loadNumericDurationFormat(ICUResourceBundle iCUResourceBundle, String str) {
        return iCUResourceBundle.getWithFallback("durationUnits/" + str).getString().replace("h", DateFormat.HOUR24);
    }

    private static NumericFormatters loadNumericFormatters(ULocale uLocale) {
        ICUResourceBundle iCUResourceBundle = (ICUResourceBundle) UResourceBundle.getBundleInstance(ICUData.ICU_UNIT_BASE_NAME, uLocale);
        return new NumericFormatters(loadNumericDurationFormat(iCUResourceBundle, "hm"), loadNumericDurationFormat(iCUResourceBundle, DateFormat.MINUTE_SECOND), loadNumericDurationFormat(iCUResourceBundle, "hms"));
    }

    private static Number[] toHMS(Measure[] measureArr) {
        Integer num;
        int iIntValue;
        Number[] numberArr = new Number[3];
        int length = measureArr.length;
        int i = -1;
        int i2 = 0;
        while (i2 < length) {
            Measure measure = measureArr[i2];
            if (measure.getNumber().doubleValue() < 0.0d || (num = hmsTo012.get(measure.getUnit())) == null || (iIntValue = num.intValue()) <= i) {
                return null;
            }
            numberArr[iIntValue] = measure.getNumber();
            i2++;
            i = iIntValue;
        }
        return numberArr;
    }

    private Object writeReplace() {
        return new MeasureProxy(getLocale(), this.formatWidth, getNumberFormatInternal(), 0);
    }

    public void clearCache() {
        this.formatterCache.clear();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MeasureFormat)) {
            return false;
        }
        MeasureFormat measureFormat = (MeasureFormat) obj;
        return getWidth() == measureFormat.getWidth() && getLocale().equals(measureFormat.getLocale()) && getNumberFormatInternal().equals(measureFormat.getNumberFormatInternal());
    }

    @Override // java.text.Format
    public StringBuffer format(Object obj, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        int length = stringBuffer.length();
        int i = 0;
        fieldPosition.setBeginIndex(0);
        fieldPosition.setEndIndex(0);
        if (obj instanceof Collection) {
            Collection collection = (Collection) obj;
            Measure[] measureArr = new Measure[collection.size()];
            for (Object obj2 : collection) {
                if (!(obj2 instanceof Measure)) {
                    og.g(obj);
                    return null;
                }
                measureArr[i] = (Measure) obj2;
                i++;
            }
            formatMeasuresInternal(stringBuffer, fieldPosition, measureArr);
        } else if (obj instanceof Measure[]) {
            formatMeasuresInternal(stringBuffer, fieldPosition, (Measure[]) obj);
        } else {
            if (!(obj instanceof Measure)) {
                og.g(obj);
                return null;
            }
            FormattedStringBuilder measure = formatMeasure((Measure) obj);
            FormattedValueStringBuilderImpl.nextFieldPosition(measure, fieldPosition);
            Utility.appendTo(measure, stringBuffer);
        }
        if (length > 0 && fieldPosition.getEndIndex() != 0) {
            fieldPosition.setBeginIndex(fieldPosition.getBeginIndex() + length);
            fieldPosition.setEndIndex(fieldPosition.getEndIndex() + length);
        }
        return stringBuffer;
    }

    public StringBuilder formatMeasurePerUnit(Measure measure, MeasureUnit measureUnit, StringBuilder sb, FieldPosition fieldPosition) {
        DecimalQuantity_DualStorageBCD decimalQuantity_DualStorageBCD = new DecimalQuantity_DualStorageBCD(measure.getNumber());
        FormattedStringBuilder formattedStringBuilder = new FormattedStringBuilder();
        getUnitFormatterFromCache(1, measure.getUnit(), measureUnit).formatImpl(decimalQuantity_DualStorageBCD, formattedStringBuilder);
        DecimalFormat.fieldPositionHelper(decimalQuantity_DualStorageBCD, formattedStringBuilder, fieldPosition, sb.length());
        Utility.appendTo(formattedStringBuilder, sb);
        return sb;
    }

    public StringBuilder formatMeasures(StringBuilder sb, FieldPosition fieldPosition, Measure... measureArr) {
        int length = sb.length();
        formatMeasuresInternal(sb, fieldPosition, measureArr);
        if (length > 0 && fieldPosition.getEndIndex() > 0) {
            fieldPosition.setBeginIndex(fieldPosition.getBeginIndex() + length);
            fieldPosition.setEndIndex(fieldPosition.getEndIndex() + length);
        }
        return sb;
    }

    public final ULocale getLocale() {
        return getLocale(ULocale.VALID_LOCALE);
    }

    public NumberFormat getNumberFormat() {
        return this.numberFormat.clone();
    }

    public NumberFormat getNumberFormatInternal() {
        return this.numberFormat;
    }

    public LocalizedNumberFormatter getNumberFormatter() {
        return this.numberFormatter;
    }

    public String getUnitDisplayName(MeasureUnit measureUnit) {
        return LongNameHandler.getUnitDisplayName(getLocale(), measureUnit, this.formatWidth.unitWidth);
    }

    public FormatWidth getWidth() {
        FormatWidth formatWidth = this.formatWidth;
        return formatWidth == FormatWidth.DEFAULT_CURRENCY ? FormatWidth.WIDE : formatWidth;
    }

    public final int hashCode() {
        return getWidth().hashCode() + ((getNumberFormatInternal().hashCode() + (getLocale().hashCode() * 31)) * 31);
    }

    @Override // java.text.Format
    public Measure parseObject(String str, ParsePosition parsePosition) {
        throw new UnsupportedOperationException();
    }

    public Object toCurrencyProxy() {
        return new MeasureProxy(getLocale(), this.formatWidth, getNumberFormatInternal(), 2);
    }

    public Object toTimeUnitProxy() {
        return new MeasureProxy(getLocale(), this.formatWidth, getNumberFormatInternal(), 1);
    }

    public MeasureFormat withLocale(ULocale uLocale) {
        return getInstance(uLocale, getWidth());
    }

    public MeasureFormat withNumberFormat(NumberFormat numberFormat) {
        return new MeasureFormat(getLocale(), this.formatWidth, numberFormat, this.rules, this.numericFormatters);
    }

    public static MeasureFormat getCurrencyFormat(Locale locale) {
        return getCurrencyFormat(ULocale.forLocale(locale));
    }

    public static MeasureFormat getInstance(Locale locale, FormatWidth formatWidth) {
        return getInstance(ULocale.forLocale(locale), formatWidth);
    }

    public static MeasureFormat getCurrencyFormat(ULocale uLocale) {
        return new CurrencyFormat(uLocale);
    }

    public static MeasureFormat getInstance(ULocale uLocale, FormatWidth formatWidth) {
        return getInstance(uLocale, formatWidth, NumberFormat.getInstance(uLocale));
    }

    public static MeasureFormat getInstance(Locale locale, FormatWidth formatWidth, NumberFormat numberFormat) {
        return getInstance(ULocale.forLocale(locale), formatWidth, numberFormat);
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class MeasureProxy implements Externalizable {
        private static final long serialVersionUID = -6033308329886716770L;
        private FormatWidth formatWidth;
        private HashMap<Object, Object> keyValues;
        private ULocale locale;
        private NumberFormat numberFormat;
        private int subClass;

        public MeasureProxy(ULocale uLocale, FormatWidth formatWidth, NumberFormat numberFormat, int i) {
            this.locale = uLocale;
            this.formatWidth = formatWidth;
            this.numberFormat = numberFormat;
            this.subClass = i;
            this.keyValues = new HashMap<>();
        }

        private TimeUnitFormat createTimeUnitFormat() throws InvalidObjectException {
            int i;
            FormatWidth formatWidth = this.formatWidth;
            if (formatWidth == FormatWidth.WIDE) {
                i = 0;
            } else {
                if (formatWidth != FormatWidth.SHORT) {
                    kf2.i("Bad width: ".concat(String.valueOf(formatWidth)));
                    return null;
                }
                i = 1;
            }
            TimeUnitFormat timeUnitFormat = new TimeUnitFormat(this.locale, i);
            timeUnitFormat.setNumberFormat(this.numberFormat);
            return timeUnitFormat;
        }

        private Object readResolve() throws InvalidObjectException {
            int i = this.subClass;
            if (i == 0) {
                return MeasureFormat.getInstance(this.locale, this.formatWidth, this.numberFormat);
            }
            if (i == 1) {
                return createTimeUnitFormat();
            }
            if (i == 2) {
                return MeasureFormat.getCurrencyFormat(this.locale);
            }
            kf2.i(ky0.h(i, "Unknown subclass: "));
            return null;
        }

        @Override // java.io.Externalizable
        public void readExternal(ObjectInput objectInput) throws IOException {
            objectInput.readByte();
            this.locale = ULocale.forLanguageTag(objectInput.readUTF());
            this.formatWidth = MeasureFormat.fromFormatWidthOrdinal(objectInput.readByte() & UCharacterEnums.ECharacterDirection.DIRECTIONALITY_UNDEFINED);
            NumberFormat numberFormat = (NumberFormat) objectInput.readObject();
            this.numberFormat = numberFormat;
            if (numberFormat == null) {
                kf2.i("Missing number format.");
                return;
            }
            this.subClass = objectInput.readByte() & UCharacterEnums.ECharacterDirection.DIRECTIONALITY_UNDEFINED;
            HashMap<Object, Object> map = (HashMap) objectInput.readObject();
            this.keyValues = map;
            if (map != null) {
                return;
            }
            kf2.i("Missing optional values map.");
        }

        @Override // java.io.Externalizable
        public void writeExternal(ObjectOutput objectOutput) throws IOException {
            objectOutput.writeByte(0);
            objectOutput.writeUTF(this.locale.toLanguageTag());
            objectOutput.writeByte(this.formatWidth.ordinal());
            objectOutput.writeObject(this.numberFormat);
            objectOutput.writeByte(this.subClass);
            objectOutput.writeObject(this.keyValues);
        }

        public MeasureProxy() {
        }
    }

    public final String formatMeasures(Measure... measureArr) {
        return formatMeasures(new StringBuilder(), DontCareFieldPosition.INSTANCE, measureArr).toString();
    }

    public MeasureFormat(ULocale uLocale, FormatWidth formatWidth) {
        this(uLocale, formatWidth, null, null, null);
    }

    public MeasureFormat(ULocale uLocale, FormatWidth formatWidth, NumberFormat numberFormat, PluralRules pluralRules) {
        this(uLocale, formatWidth, numberFormat, pluralRules, null);
        if (formatWidth != FormatWidth.NUMERIC) {
            return;
        }
        og.i("The format width 'numeric' is not allowed by this constructor");
        throw null;
    }
}
