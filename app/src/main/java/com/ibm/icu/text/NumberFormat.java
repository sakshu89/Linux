package com.ibm.icu.text;

import com.ibm.icu.impl.ICUData;
import com.ibm.icu.impl.ICUResourceBundle;
import com.ibm.icu.math.BigDecimal;
import com.ibm.icu.util.Currency;
import com.ibm.icu.util.CurrencyAmount;
import com.ibm.icu.util.ULocale;
import com.ibm.icu.util.UResourceBundle;
import defpackage.cq;
import defpackage.kf2;
import defpackage.og;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.text.FieldPosition;
import java.text.Format;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Collections;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class NumberFormat extends UFormat implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int ACCOUNTINGCURRENCYSTYLE = 7;
    public static final int CASHCURRENCYSTYLE = 8;
    public static final int CURRENCYSTYLE = 1;
    public static final int FRACTION_FIELD = 1;
    public static final int INTEGERSTYLE = 4;
    public static final int INTEGER_FIELD = 0;
    public static final int ISOCURRENCYSTYLE = 5;
    public static final int NUMBERSTYLE = 0;
    public static final int PERCENTSTYLE = 2;
    public static final int PLURALCURRENCYSTYLE = 6;
    public static final int SCIENTIFICSTYLE = 3;
    public static final int STANDARDCURRENCYSTYLE = 9;
    static final int currentSerialVersion = 2;
    private static final char[] doubleCurrencySign;
    private static final String doubleCurrencyStr;
    private static final long serialVersionUID = -2308460125733713944L;
    private static NumberFormatShim shim;
    private Currency currency;
    private boolean parseStrict;
    private boolean groupingUsed = true;
    private byte maxIntegerDigits = 40;
    private byte minIntegerDigits = 1;
    private byte maxFractionDigits = 3;
    private byte minFractionDigits = 0;
    private boolean parseIntegerOnly = false;
    private int maximumIntegerDigits = 40;
    private int minimumIntegerDigits = 1;
    private int maximumFractionDigits = 3;
    private int minimumFractionDigits = 0;
    private int serialVersionOnStream = 2;
    private DisplayContext capitalizationSetting = DisplayContext.CAPITALIZATION_NONE;

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class Field extends Format.Field {
        static final long serialVersionUID = -4516273749929385842L;
        public static final Field SIGN = new Field("sign");
        public static final Field INTEGER = new Field("integer");
        public static final Field FRACTION = new Field("fraction");
        public static final Field EXPONENT = new Field("exponent");
        public static final Field EXPONENT_SIGN = new Field("exponent sign");
        public static final Field EXPONENT_SYMBOL = new Field("exponent symbol");
        public static final Field DECIMAL_SEPARATOR = new Field("decimal separator");
        public static final Field GROUPING_SEPARATOR = new Field("grouping separator");
        public static final Field PERCENT = new Field("percent");
        public static final Field PERMILLE = new Field("per mille");
        public static final Field CURRENCY = new Field("currency");
        public static final Field MEASURE_UNIT = new Field("measure unit");
        public static final Field COMPACT = new Field("compact");
        public static final Field APPROXIMATELY_SIGN = new Field("approximately sign");

        public Field(String str) {
            super(str);
        }

        @Override // java.text.AttributedCharacterIterator.Attribute
        public Object readResolve() throws InvalidObjectException {
            String name = getName();
            Field field = INTEGER;
            if (name.equals(field.getName())) {
                return field;
            }
            String name2 = getName();
            Field field2 = FRACTION;
            if (name2.equals(field2.getName())) {
                return field2;
            }
            String name3 = getName();
            Field field3 = EXPONENT;
            if (name3.equals(field3.getName())) {
                return field3;
            }
            String name4 = getName();
            Field field4 = EXPONENT_SIGN;
            if (name4.equals(field4.getName())) {
                return field4;
            }
            String name5 = getName();
            Field field5 = EXPONENT_SYMBOL;
            if (name5.equals(field5.getName())) {
                return field5;
            }
            String name6 = getName();
            Field field6 = CURRENCY;
            if (name6.equals(field6.getName())) {
                return field6;
            }
            String name7 = getName();
            Field field7 = DECIMAL_SEPARATOR;
            if (name7.equals(field7.getName())) {
                return field7;
            }
            String name8 = getName();
            Field field8 = GROUPING_SEPARATOR;
            if (name8.equals(field8.getName())) {
                return field8;
            }
            String name9 = getName();
            Field field9 = PERCENT;
            if (name9.equals(field9.getName())) {
                return field9;
            }
            String name10 = getName();
            Field field10 = PERMILLE;
            if (name10.equals(field10.getName())) {
                return field10;
            }
            String name11 = getName();
            Field field11 = SIGN;
            if (name11.equals(field11.getName())) {
                return field11;
            }
            String name12 = getName();
            Field field12 = MEASURE_UNIT;
            if (name12.equals(field12.getName())) {
                return field12;
            }
            String name13 = getName();
            Field field13 = COMPACT;
            if (name13.equals(field13.getName())) {
                return field13;
            }
            kf2.i("An invalid object.");
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static abstract class NumberFormatShim {
        public abstract NumberFormat createInstance(ULocale uLocale, int i);

        public abstract Locale[] getAvailableLocales();

        public abstract ULocale[] getAvailableULocales();

        public abstract Object registerFactory(NumberFormatFactory numberFormatFactory);

        public abstract boolean unregister(Object obj);
    }

    static {
        char[] cArr = {164, 164};
        doubleCurrencySign = cArr;
        doubleCurrencyStr = new String(cArr);
    }

    public static NumberFormat createInstance(ULocale uLocale, int i) {
        String currencyPattern;
        NumberFormat numberFormat;
        String pattern = getPattern(uLocale, i);
        DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols(uLocale);
        if ((i == 1 || i == 5 || i == 7 || i == 8 || i == 9) && (currencyPattern = decimalFormatSymbols.getCurrencyPattern()) != null) {
            pattern = currencyPattern;
        }
        if (i == 5) {
            pattern = pattern.replace("¤", doubleCurrencyStr);
        }
        NumberingSystem numberingSystem = NumberingSystem.getInstance(uLocale);
        if (numberingSystem == null) {
            return null;
        }
        int i2 = 4;
        if (numberingSystem.isAlgorithmic()) {
            String description = numberingSystem.getDescription();
            int iIndexOf = description.indexOf("/");
            int iLastIndexOf = description.lastIndexOf("/");
            if (iLastIndexOf > iIndexOf) {
                String strSubstring = description.substring(0, iIndexOf);
                String strSubstring2 = description.substring(iIndexOf + 1, iLastIndexOf);
                description = description.substring(iLastIndexOf + 1);
                uLocale = new ULocale(strSubstring);
                i2 = strSubstring2.equals("SpelloutRules") ? 1 : 4;
            }
            RuleBasedNumberFormat ruleBasedNumberFormat = new RuleBasedNumberFormat(uLocale, i2);
            ruleBasedNumberFormat.setDefaultRuleSet(description);
            numberFormat = ruleBasedNumberFormat;
        } else {
            DecimalFormat decimalFormat = new DecimalFormat(pattern, decimalFormatSymbols, i);
            if (i == 4) {
                decimalFormat.setMaximumFractionDigits(0);
                decimalFormat.setDecimalSeparatorAlwaysShown(false);
                decimalFormat.setParseIntegerOnly(true);
            }
            if (i == 8) {
                decimalFormat.setCurrencyUsage(Currency.CurrencyUsage.CASH);
            }
            if (i == 6) {
                decimalFormat.setCurrencyPluralInfo(CurrencyPluralInfo.getInstance(uLocale));
            }
            numberFormat = decimalFormat;
        }
        numberFormat.setLocale(decimalFormatSymbols.getLocale(ULocale.VALID_LOCALE), decimalFormatSymbols.getLocale(ULocale.ACTUAL_LOCALE));
        return numberFormat;
    }

    public static Locale[] getAvailableLocales() {
        return shim == null ? ICUResourceBundle.getAvailableLocales() : getShim().getAvailableLocales();
    }

    public static ULocale[] getAvailableULocales() {
        return shim == null ? ICUResourceBundle.getAvailableULocales() : getShim().getAvailableULocales();
    }

    public static final NumberFormat getCurrencyInstance() {
        return getInstance(ULocale.getDefault(ULocale.Category.FORMAT), 1);
    }

    public static NumberFormat getInstance(ULocale uLocale, int i) {
        if (i >= 0 && i <= 9) {
            return getShim().createInstance(uLocale, i);
        }
        og.i("choice should be from NUMBERSTYLE to STANDARDCURRENCYSTYLE");
        return null;
    }

    public static final NumberFormat getIntegerInstance() {
        return getInstance(ULocale.getDefault(ULocale.Category.FORMAT), 4);
    }

    public static final NumberFormat getNumberInstance() {
        return getInstance(ULocale.getDefault(ULocale.Category.FORMAT), 0);
    }

    @Deprecated
    public static String getPattern(Locale locale, int i) {
        return getPattern(ULocale.forLocale(locale), i);
    }

    @Deprecated
    public static String getPatternForStyle(ULocale uLocale, int i) {
        return getPatternForStyleAndNumberingSystem(uLocale, NumberingSystem.getInstance(uLocale).getName(), i);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:5:0x000b  */
    @Deprecated
    public static String getPatternForStyleAndNumberingSystem(ULocale uLocale, String str, int i) {
        String str2 = "currencyFormat";
        switch (i) {
            case 0:
            case 4:
            case 6:
            default:
                str2 = "decimalFormat";
                break;
            case 1:
                String keywordValue = uLocale.getKeywordValue("cf");
                if (keywordValue != null && keywordValue.equals("account")) {
                    str2 = "accountingFormat";
                }
                break;
            case 2:
                str2 = "percentFormat";
                break;
            case 3:
                str2 = "scientificFormat";
                break;
            case 5:
            case 8:
            case 9:
                break;
            case 7:
                str2 = "accountingFormat";
                break;
        }
        ICUResourceBundle iCUResourceBundle = (ICUResourceBundle) UResourceBundle.getBundleInstance(ICUData.ICU_BASE_NAME, uLocale);
        String strFindStringWithFallback = iCUResourceBundle.findStringWithFallback("NumberElements/" + str + "/patterns/" + str2);
        return strFindStringWithFallback == null ? iCUResourceBundle.getStringWithFallback("NumberElements/latn/patterns/".concat(str2)) : strFindStringWithFallback;
    }

    public static final NumberFormat getPercentInstance() {
        return getInstance(ULocale.getDefault(ULocale.Category.FORMAT), 2);
    }

    public static final NumberFormat getScientificInstance() {
        return getInstance(ULocale.getDefault(ULocale.Category.FORMAT), 3);
    }

    private static NumberFormatShim getShim() {
        if (shim == null) {
            try {
                int i = NumberFormatServiceShim.a;
                shim = (NumberFormatShim) NumberFormatServiceShim.class.newInstance();
            } catch (MissingResourceException e) {
                throw e;
            } catch (Exception e2) {
                og.p(e2.getMessage());
                return null;
            }
        }
        return shim;
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        int i;
        objectInputStream.defaultReadObject();
        int i2 = this.serialVersionOnStream;
        if (i2 < 1) {
            this.maximumIntegerDigits = this.maxIntegerDigits;
            this.minimumIntegerDigits = this.minIntegerDigits;
            this.maximumFractionDigits = this.maxFractionDigits;
            this.minimumFractionDigits = this.minFractionDigits;
        }
        if (i2 < 2) {
            this.capitalizationSetting = DisplayContext.CAPITALIZATION_NONE;
        }
        int i3 = this.minimumIntegerDigits;
        if (i3 > this.maximumIntegerDigits || (i = this.minimumFractionDigits) > this.maximumFractionDigits || i3 < 0 || i < 0) {
            kf2.i("Digit count range invalid");
        } else {
            this.serialVersionOnStream = 2;
        }
    }

    public static Object registerFactory(NumberFormatFactory numberFormatFactory) {
        if (numberFormatFactory != null) {
            return getShim().registerFactory(numberFormatFactory);
        }
        og.i("factory must not be null");
        return null;
    }

    public static boolean unregister(Object obj) {
        if (obj == null) {
            og.i("registryKey must not be null");
            return false;
        }
        NumberFormatShim numberFormatShim = shim;
        if (numberFormatShim == null) {
            return false;
        }
        return numberFormatShim.unregister(obj);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        int i = this.maximumIntegerDigits;
        byte b = Bidi.LEVEL_DEFAULT_RTL;
        this.maxIntegerDigits = i > 127 ? (byte) 127 : (byte) i;
        int i2 = this.minimumIntegerDigits;
        this.minIntegerDigits = i2 > 127 ? (byte) 127 : (byte) i2;
        int i3 = this.maximumFractionDigits;
        this.maxFractionDigits = i3 > 127 ? (byte) 127 : (byte) i3;
        int i4 = this.minimumFractionDigits;
        if (i4 <= 127) {
            b = (byte) i4;
        }
        this.minFractionDigits = b;
        objectOutputStream.defaultWriteObject();
    }

    @Override // java.text.Format
    public NumberFormat clone() {
        return (NumberFormat) super.clone();
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        NumberFormat numberFormat = (NumberFormat) obj;
        return this.maximumIntegerDigits == numberFormat.maximumIntegerDigits && this.minimumIntegerDigits == numberFormat.minimumIntegerDigits && this.maximumFractionDigits == numberFormat.maximumFractionDigits && this.minimumFractionDigits == numberFormat.minimumFractionDigits && this.groupingUsed == numberFormat.groupingUsed && this.parseIntegerOnly == numberFormat.parseIntegerOnly && this.parseStrict == numberFormat.parseStrict && this.capitalizationSetting == numberFormat.capitalizationSetting;
    }

    public abstract StringBuffer format(double d, StringBuffer stringBuffer, FieldPosition fieldPosition);

    public abstract StringBuffer format(long j, StringBuffer stringBuffer, FieldPosition fieldPosition);

    public abstract StringBuffer format(BigDecimal bigDecimal, StringBuffer stringBuffer, FieldPosition fieldPosition);

    @Override // java.text.Format
    public StringBuffer format(Object obj, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        if (obj instanceof Long) {
            return format(((Long) obj).longValue(), stringBuffer, fieldPosition);
        }
        if (obj instanceof BigInteger) {
            return format((BigInteger) obj, stringBuffer, fieldPosition);
        }
        if (obj instanceof java.math.BigDecimal) {
            return format((java.math.BigDecimal) obj, stringBuffer, fieldPosition);
        }
        if (obj instanceof BigDecimal) {
            return format((BigDecimal) obj, stringBuffer, fieldPosition);
        }
        if (obj instanceof CurrencyAmount) {
            return format((CurrencyAmount) obj, stringBuffer, fieldPosition);
        }
        if (obj instanceof Number) {
            return format(((Number) obj).doubleValue(), stringBuffer, fieldPosition);
        }
        og.i("Cannot format given Object as a Number");
        return null;
    }

    public abstract StringBuffer format(java.math.BigDecimal bigDecimal, StringBuffer stringBuffer, FieldPosition fieldPosition);

    public abstract StringBuffer format(BigInteger bigInteger, StringBuffer stringBuffer, FieldPosition fieldPosition);

    public DisplayContext getContext(DisplayContext.Type type) {
        DisplayContext displayContext;
        return (type != DisplayContext.Type.CAPITALIZATION || (displayContext = this.capitalizationSetting) == null) ? DisplayContext.CAPITALIZATION_NONE : displayContext;
    }

    public Currency getCurrency() {
        return this.currency;
    }

    @Deprecated
    public Currency getEffectiveCurrency() {
        Currency currency = getCurrency();
        if (currency != null) {
            return currency;
        }
        ULocale locale = getLocale(ULocale.VALID_LOCALE);
        if (locale == null) {
            locale = ULocale.getDefault(ULocale.Category.FORMAT);
        }
        return Currency.getInstance(locale);
    }

    public int getMaximumFractionDigits() {
        return this.maximumFractionDigits;
    }

    public int getMaximumIntegerDigits() {
        return this.maximumIntegerDigits;
    }

    public int getMinimumFractionDigits() {
        return this.minimumFractionDigits;
    }

    public int getMinimumIntegerDigits() {
        return this.minimumIntegerDigits;
    }

    public int getRoundingMode() {
        throw new UnsupportedOperationException("getRoundingMode must be implemented by the subclass implementation.");
    }

    public int hashCode() {
        return (this.maximumIntegerDigits * 37) + this.maxFractionDigits;
    }

    public boolean isGroupingUsed() {
        return this.groupingUsed;
    }

    public boolean isParseIntegerOnly() {
        return this.parseIntegerOnly;
    }

    public boolean isParseStrict() {
        return this.parseStrict;
    }

    public Number parse(String str) throws ParseException {
        ParsePosition parsePosition = new ParsePosition(0);
        Number number = parse(str, parsePosition);
        if (parsePosition.getIndex() != 0) {
            return number;
        }
        throw new ParseException(cq.v("Unparseable number: \"", str, "\""), parsePosition.getErrorIndex());
    }

    public abstract Number parse(String str, ParsePosition parsePosition);

    public CurrencyAmount parseCurrency(CharSequence charSequence, ParsePosition parsePosition) {
        Number number = parse(charSequence.toString(), parsePosition);
        if (number == null) {
            return null;
        }
        return new CurrencyAmount(number, getEffectiveCurrency());
    }

    @Override // java.text.Format
    public final Object parseObject(String str, ParsePosition parsePosition) {
        return parse(str, parsePosition);
    }

    public void setContext(DisplayContext displayContext) {
        if (displayContext.type() == DisplayContext.Type.CAPITALIZATION) {
            this.capitalizationSetting = displayContext;
        }
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public void setGroupingUsed(boolean z) {
        this.groupingUsed = z;
    }

    public void setMaximumFractionDigits(int i) {
        int iMax = Math.max(0, i);
        this.maximumFractionDigits = iMax;
        if (iMax < this.minimumFractionDigits) {
            this.minimumFractionDigits = iMax;
        }
    }

    public void setMaximumIntegerDigits(int i) {
        int iMax = Math.max(0, i);
        this.maximumIntegerDigits = iMax;
        if (this.minimumIntegerDigits > iMax) {
            this.minimumIntegerDigits = iMax;
        }
    }

    public void setMinimumFractionDigits(int i) {
        int iMax = Math.max(0, i);
        this.minimumFractionDigits = iMax;
        if (this.maximumFractionDigits < iMax) {
            this.maximumFractionDigits = iMax;
        }
    }

    public void setMinimumIntegerDigits(int i) {
        int iMax = Math.max(0, i);
        this.minimumIntegerDigits = iMax;
        if (iMax > this.maximumIntegerDigits) {
            this.maximumIntegerDigits = iMax;
        }
    }

    public void setParseIntegerOnly(boolean z) {
        this.parseIntegerOnly = z;
    }

    public void setParseStrict(boolean z) {
        this.parseStrict = z;
    }

    public void setRoundingMode(int i) {
        throw new UnsupportedOperationException("setRoundingMode must be implemented by the subclass implementation.");
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static abstract class NumberFormatFactory {
        public static final int FORMAT_CURRENCY = 1;
        public static final int FORMAT_INTEGER = 4;
        public static final int FORMAT_NUMBER = 0;
        public static final int FORMAT_PERCENT = 2;
        public static final int FORMAT_SCIENTIFIC = 3;

        public NumberFormat createFormat(ULocale uLocale, int i) {
            return createFormat(uLocale.toLocale(), i);
        }

        public abstract Set<String> getSupportedLocaleNames();

        public boolean visible() {
            return true;
        }

        public NumberFormat createFormat(Locale locale, int i) {
            return createFormat(ULocale.forLocale(locale), i);
        }
    }

    public static String getPattern(ULocale uLocale, int i) {
        return getPatternForStyle(uLocale, i);
    }

    public static NumberFormat getCurrencyInstance(Locale locale) {
        return getInstance(ULocale.forLocale(locale), 1);
    }

    public static NumberFormat getIntegerInstance(Locale locale) {
        return getInstance(ULocale.forLocale(locale), 4);
    }

    public static NumberFormat getNumberInstance(Locale locale) {
        return getInstance(ULocale.forLocale(locale), 0);
    }

    public static NumberFormat getPercentInstance(Locale locale) {
        return getInstance(ULocale.forLocale(locale), 2);
    }

    public static NumberFormat getScientificInstance(Locale locale) {
        return getInstance(ULocale.forLocale(locale), 3);
    }

    public static NumberFormat getCurrencyInstance(ULocale uLocale) {
        return getInstance(uLocale, 1);
    }

    public static NumberFormat getIntegerInstance(ULocale uLocale) {
        return getInstance(uLocale, 4);
    }

    public static NumberFormat getNumberInstance(ULocale uLocale) {
        return getInstance(uLocale, 0);
    }

    public static NumberFormat getPercentInstance(ULocale uLocale) {
        return getInstance(uLocale, 2);
    }

    public static NumberFormat getScientificInstance(ULocale uLocale) {
        return getInstance(uLocale, 3);
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static abstract class SimpleNumberFormatFactory extends NumberFormatFactory {
        final Set<String> localeNames;
        final boolean visible;

        public SimpleNumberFormatFactory(Locale locale, boolean z) {
            this.localeNames = Collections.singleton(ULocale.forLocale(locale).getBaseName());
            this.visible = z;
        }

        @Override // com.ibm.icu.text.NumberFormat.NumberFormatFactory
        public final Set<String> getSupportedLocaleNames() {
            return this.localeNames;
        }

        @Override // com.ibm.icu.text.NumberFormat.NumberFormatFactory
        public final boolean visible() {
            return this.visible;
        }

        public SimpleNumberFormatFactory(Locale locale) {
            this(locale, true);
        }

        public SimpleNumberFormatFactory(ULocale uLocale) {
            this(uLocale, true);
        }

        public SimpleNumberFormatFactory(ULocale uLocale, boolean z) {
            this.localeNames = Collections.singleton(uLocale.getBaseName());
            this.visible = z;
        }
    }

    public static NumberFormat getInstance(Locale locale) {
        return getInstance(ULocale.forLocale(locale), 0);
    }

    public static NumberFormat getInstance(ULocale uLocale) {
        return getInstance(uLocale, 0);
    }

    public static final NumberFormat getInstance(int i) {
        return getInstance(ULocale.getDefault(ULocale.Category.FORMAT), i);
    }

    public static NumberFormat getInstance(Locale locale, int i) {
        return getInstance(ULocale.forLocale(locale), i);
    }

    public static final NumberFormat getInstance() {
        return getInstance(ULocale.getDefault(ULocale.Category.FORMAT), 0);
    }

    public final String format(double d) {
        return format(d, new StringBuffer(), new FieldPosition(0)).toString();
    }

    public final String format(long j) {
        StringBuffer stringBuffer = new StringBuffer(19);
        format(j, stringBuffer, new FieldPosition(0));
        return stringBuffer.toString();
    }

    public final String format(BigInteger bigInteger) {
        return format(bigInteger, new StringBuffer(), new FieldPosition(0)).toString();
    }

    public final String format(java.math.BigDecimal bigDecimal) {
        return format(bigDecimal, new StringBuffer(), new FieldPosition(0)).toString();
    }

    public final String format(BigDecimal bigDecimal) {
        return format(bigDecimal, new StringBuffer(), new FieldPosition(0)).toString();
    }

    public final String format(CurrencyAmount currencyAmount) {
        return format(currencyAmount, new StringBuffer(), new FieldPosition(0)).toString();
    }

    public StringBuffer format(CurrencyAmount currencyAmount, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        synchronized (this) {
            try {
                Currency currency = getCurrency();
                Currency currency2 = currencyAmount.getCurrency();
                boolean zEquals = currency2.equals(currency);
                if (!zEquals) {
                    setCurrency(currency2);
                }
                format(currencyAmount.getNumber(), stringBuffer, fieldPosition);
                if (!zEquals) {
                    setCurrency(currency);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return stringBuffer;
    }
}
