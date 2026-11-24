package com.ibm.icu.text;

import com.ibm.icu.impl.FormattedStringBuilder;
import com.ibm.icu.impl.FormattedValueStringBuilderImpl;
import com.ibm.icu.impl.Utility;
import com.ibm.icu.impl.number.AffixUtils;
import com.ibm.icu.impl.number.DecimalFormatProperties;
import com.ibm.icu.impl.number.DecimalQuantity;
import com.ibm.icu.impl.number.DecimalQuantity_DualStorageBCD;
import com.ibm.icu.impl.number.Padder;
import com.ibm.icu.impl.number.PatternStringParser;
import com.ibm.icu.impl.number.PatternStringUtils;
import com.ibm.icu.impl.number.Properties;
import com.ibm.icu.impl.number.parse.NumberParserImpl;
import com.ibm.icu.impl.number.parse.ParsedNumber;
import com.ibm.icu.math.MathContext;
import com.ibm.icu.number.LocalizedNumberFormatter;
import com.ibm.icu.number.NumberFormatter;
import com.ibm.icu.util.Currency;
import com.ibm.icu.util.CurrencyAmount;
import com.ibm.icu.util.ULocale;
import defpackage.cq;
import defpackage.dk0;
import defpackage.og;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.text.AttributedCharacterIterator;
import java.text.FieldPosition;
import java.text.ParsePosition;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class DecimalFormat extends NumberFormat implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int MINIMUM_GROUPING_DIGITS_AUTO = -2;
    public static final int MINIMUM_GROUPING_DIGITS_MIN2 = -3;
    public static final int PAD_AFTER_PREFIX = 1;
    public static final int PAD_AFTER_SUFFIX = 3;
    public static final int PAD_BEFORE_PREFIX = 0;
    public static final int PAD_BEFORE_SUFFIX = 2;
    private static final long serialVersionUID = 864413376551465018L;
    volatile transient NumberParserImpl currencyParser;
    volatile transient DecimalFormatProperties exportedProperties;
    volatile transient LocalizedNumberFormatter formatter;
    private transient int icuMathContextForm;
    volatile transient NumberParserImpl parser;
    transient DecimalFormatProperties properties;
    private final int serialVersionOnStream;
    volatile transient DecimalFormatSymbols symbols;

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    @Deprecated
    public interface PropertySetter {
        @Deprecated
        void set(DecimalFormatProperties decimalFormatProperties);
    }

    public DecimalFormat(String str, DecimalFormatSymbols decimalFormatSymbols, int i) {
        this.serialVersionOnStream = 5;
        this.icuMathContextForm = 0;
        this.symbols = decimalFormatSymbols.m17clone();
        this.properties = new DecimalFormatProperties();
        this.exportedProperties = new DecimalFormatProperties();
        if (i == 1 || i == 5 || i == 7 || i == 8 || i == 9 || i == 6) {
            setPropertiesFromPattern(str, 2);
        } else {
            setPropertiesFromPattern(str, 1);
        }
        refreshFormatter();
    }

    public static void fieldPositionHelper(DecimalQuantity decimalQuantity, FormattedStringBuilder formattedStringBuilder, FieldPosition fieldPosition, int i) {
        fieldPosition.setBeginIndex(0);
        fieldPosition.setEndIndex(0);
        decimalQuantity.populateUFieldPosition(fieldPosition);
        if (!FormattedValueStringBuilderImpl.nextFieldPosition(formattedStringBuilder, fieldPosition) || i == 0) {
            return;
        }
        fieldPosition.setBeginIndex(fieldPosition.getBeginIndex() + i);
        fieldPosition.setEndIndex(fieldPosition.getEndIndex() + i);
    }

    private static DecimalFormatSymbols getDefaultSymbols() {
        return DecimalFormatSymbols.getInstance();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3, types: [boolean, byte, int] */
    /* JADX WARN: Type inference failed for: r5v56 */
    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        ObjectInputStream.GetField fields = objectInputStream.readFields();
        ObjectStreamField[] fields2 = fields.getObjectStreamClass().getFields();
        int i = fields.get("serialVersionOnStream", -1);
        if (i > 5) {
            dk0.h(cq.h("Cannot deserialize newer com.ibm.icu.text.DecimalFormat (v", i, ")"));
            return;
        }
        if (i == 5) {
            if (fields2.length > 1) {
                dk0.h("Too many fields when reading serial version 5");
                return;
            }
            objectInputStream.readInt();
            Object object = objectInputStream.readObject();
            if (object instanceof DecimalFormatProperties) {
                this.properties = (DecimalFormatProperties) object;
            } else {
                this.properties = ((Properties) object).getInstance();
            }
            this.symbols = (DecimalFormatSymbols) objectInputStream.readObject();
            this.exportedProperties = new DecimalFormatProperties();
            refreshFormatter();
            return;
        }
        this.properties = new DecimalFormatProperties();
        int length = fields2.length;
        var r5 = 0;
        int i2 = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        String str8 = null;
        while (i2 < length) {
            String name = fields2[i2].getName();
            if (name.equals("decimalSeparatorAlwaysShown")) {
                setDecimalSeparatorAlwaysShown(fields.get("decimalSeparatorAlwaysShown", (boolean) r5));
            } else if (name.equals("exponentSignAlwaysShown")) {
                setExponentSignAlwaysShown(fields.get("exponentSignAlwaysShown", (boolean) r5));
            } else if (name.equals("formatWidth")) {
                setFormatWidth(fields.get("formatWidth", (int) r5));
            } else if (name.equals("groupingSize")) {
                setGroupingSize(fields.get("groupingSize", (byte) 3));
            } else if (name.equals("groupingSize2")) {
                setSecondaryGroupingSize(fields.get("groupingSize2", (byte) r5));
            } else if (name.equals("maxSignificantDigits")) {
                setMaximumSignificantDigits(fields.get("maxSignificantDigits", 6));
            } else if (name.equals("minExponentDigits")) {
                setMinimumExponentDigits(fields.get("minExponentDigits", (byte) r5));
            } else if (name.equals("minSignificantDigits")) {
                setMinimumSignificantDigits(fields.get("minSignificantDigits", 1));
            } else if (name.equals("multiplier")) {
                setMultiplier(fields.get("multiplier", 1));
            } else if (name.equals("pad")) {
                setPadCharacter(fields.get("pad", ' '));
            } else if (name.equals("padPosition")) {
                setPadPosition(fields.get("padPosition", 0));
            } else if (name.equals("parseBigDecimal")) {
                setParseBigDecimal(fields.get("parseBigDecimal", false));
            } else if (name.equals("parseRequireDecimalPoint")) {
                setDecimalPatternMatchRequired(fields.get("parseRequireDecimalPoint", false));
            } else if (name.equals("roundingMode")) {
                setRoundingMode(fields.get("roundingMode", 0));
            } else if (name.equals("useExponentialNotation")) {
                setScientificNotation(fields.get("useExponentialNotation", false));
            } else {
                if (name.equals("useSignificantDigits")) {
                    setSignificantDigitsUsed(fields.get("useSignificantDigits", false));
                } else if (name.equals("currencyPluralInfo")) {
                    setCurrencyPluralInfo((CurrencyPluralInfo) fields.get("currencyPluralInfo", (Object) null));
                } else if (name.equals("mathContext")) {
                    setMathContextICU((MathContext) fields.get("mathContext", (Object) null));
                } else if (name.equals("negPrefixPattern")) {
                    str = (String) fields.get("negPrefixPattern", (Object) null);
                } else if (name.equals("negSuffixPattern")) {
                    str3 = (String) fields.get("negSuffixPattern", (Object) null);
                } else if (name.equals("negativePrefix")) {
                    str2 = (String) fields.get("negativePrefix", (Object) null);
                } else if (name.equals("negativeSuffix")) {
                    str4 = (String) fields.get("negativeSuffix", (Object) null);
                } else if (name.equals("posPrefixPattern")) {
                    str5 = (String) fields.get("posPrefixPattern", (Object) null);
                } else if (name.equals("posSuffixPattern")) {
                    str7 = (String) fields.get("posSuffixPattern", (Object) null);
                } else if (name.equals("positivePrefix")) {
                    str6 = (String) fields.get("positivePrefix", (Object) null);
                } else if (name.equals("positiveSuffix")) {
                    str8 = (String) fields.get("positiveSuffix", (Object) null);
                } else if (name.equals("roundingIncrement")) {
                    setRoundingIncrement((BigDecimal) fields.get("roundingIncrement", (Object) null));
                } else if (name.equals("symbols")) {
                    setDecimalFormatSymbols((DecimalFormatSymbols) fields.get("symbols", (Object) null));
                }
                i2++;
                r5 = 0;
            }
            i2++;
            r5 = 0;
        }
        DecimalFormatProperties decimalFormatProperties = this.properties;
        if (str == null) {
            decimalFormatProperties.setNegativePrefix(str2);
        } else {
            decimalFormatProperties.setNegativePrefixPattern(str);
        }
        DecimalFormatProperties decimalFormatProperties2 = this.properties;
        if (str3 == null) {
            decimalFormatProperties2.setNegativeSuffix(str4);
        } else {
            decimalFormatProperties2.setNegativeSuffixPattern(str3);
        }
        DecimalFormatProperties decimalFormatProperties3 = this.properties;
        if (str5 == null) {
            decimalFormatProperties3.setPositivePrefix(str6);
        } else {
            decimalFormatProperties3.setPositivePrefixPattern(str5);
        }
        DecimalFormatProperties decimalFormatProperties4 = this.properties;
        if (str7 == null) {
            decimalFormatProperties4.setPositiveSuffix(str8);
        } else {
            decimalFormatProperties4.setPositiveSuffixPattern(str7);
        }
        try {
            Field declaredField = NumberFormat.class.getDeclaredField("groupingUsed");
            declaredField.setAccessible(true);
            setGroupingUsed(((Boolean) declaredField.get(this)).booleanValue());
            Field declaredField2 = NumberFormat.class.getDeclaredField("parseIntegerOnly");
            declaredField2.setAccessible(true);
            setParseIntegerOnly(((Boolean) declaredField2.get(this)).booleanValue());
            Field declaredField3 = NumberFormat.class.getDeclaredField("maximumIntegerDigits");
            declaredField3.setAccessible(true);
            setMaximumIntegerDigits(((Integer) declaredField3.get(this)).intValue());
            Field declaredField4 = NumberFormat.class.getDeclaredField("minimumIntegerDigits");
            declaredField4.setAccessible(true);
            setMinimumIntegerDigits(((Integer) declaredField4.get(this)).intValue());
            Field declaredField5 = NumberFormat.class.getDeclaredField("maximumFractionDigits");
            declaredField5.setAccessible(true);
            setMaximumFractionDigits(((Integer) declaredField5.get(this)).intValue());
            Field declaredField6 = NumberFormat.class.getDeclaredField("minimumFractionDigits");
            declaredField6.setAccessible(true);
            setMinimumFractionDigits(((Integer) declaredField6.get(this)).intValue());
            Field declaredField7 = NumberFormat.class.getDeclaredField("currency");
            declaredField7.setAccessible(true);
            setCurrency((Currency) declaredField7.get(this));
            Field declaredField8 = NumberFormat.class.getDeclaredField("parseStrict");
            declaredField8.setAccessible(true);
            setParseStrict(((Boolean) declaredField8.get(this)).booleanValue());
            if (this.symbols == null) {
                this.symbols = getDefaultSymbols();
            }
            this.exportedProperties = new DecimalFormatProperties();
            refreshFormatter();
        } catch (IllegalAccessException e) {
            throw new IOException(e);
        } catch (IllegalArgumentException e2) {
            throw new IOException(e2);
        } catch (NoSuchFieldException e3) {
            throw new IOException(e3);
        } catch (SecurityException e4) {
            throw new IOException(e4);
        }
    }

    private Number safeConvertBigDecimal(BigDecimal bigDecimal) {
        try {
            return new com.ibm.icu.math.BigDecimal(bigDecimal);
        } catch (NumberFormatException unused) {
            if (bigDecimal.signum() > 0 && bigDecimal.scale() < 0) {
                return Double.valueOf(Double.POSITIVE_INFINITY);
            }
            if (bigDecimal.scale() < 0) {
                return Double.valueOf(Double.NEGATIVE_INFINITY);
            }
            return bigDecimal.signum() < 0 ? Double.valueOf(-0.0d) : Double.valueOf(0.0d);
        }
    }

    private synchronized void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(0);
        objectOutputStream.writeObject(this.properties);
        objectOutputStream.writeObject(this.symbols);
    }

    public synchronized void applyLocalizedPattern(String str) {
        applyPattern(PatternStringUtils.convertLocalized(str, this.symbols, false));
    }

    public synchronized void applyPattern(String str) {
        setPropertiesFromPattern(str, 0);
        this.properties.setPositivePrefix(null);
        this.properties.setNegativePrefix(null);
        this.properties.setPositiveSuffix(null);
        this.properties.setNegativeSuffix(null);
        this.properties.setCurrencyPluralInfo(null);
        refreshFormatter();
    }

    public synchronized boolean areSignificantDigitsUsed() {
        return (this.properties.getMinimumSignificantDigits() == -1 && this.properties.getMaximumSignificantDigits() == -1) ? false : true;
    }

    @Override // com.ibm.icu.text.NumberFormat, java.text.Format
    public DecimalFormat clone() {
        DecimalFormat decimalFormat = (DecimalFormat) super.clone();
        decimalFormat.symbols = this.symbols.m17clone();
        decimalFormat.properties = this.properties.m9clone();
        decimalFormat.exportedProperties = new DecimalFormatProperties();
        decimalFormat.refreshFormatter();
        return decimalFormat;
    }

    @Override // com.ibm.icu.text.NumberFormat
    public synchronized boolean equals(Object obj) {
        boolean z = false;
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DecimalFormat)) {
            return false;
        }
        DecimalFormat decimalFormat = (DecimalFormat) obj;
        if (this.properties.equals(decimalFormat.properties) && this.symbols.equals(decimalFormat.symbols)) {
            z = true;
        }
        return z;
    }

    @Override // com.ibm.icu.text.NumberFormat
    public StringBuffer format(CurrencyAmount currencyAmount, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        DecimalFormatSymbols decimalFormatSymbolsM17clone = this.symbols.m17clone();
        decimalFormatSymbolsM17clone.setCurrency(currencyAmount.getCurrency());
        DecimalQuantity_DualStorageBCD decimalQuantity_DualStorageBCD = new DecimalQuantity_DualStorageBCD(currencyAmount.getNumber());
        FormattedStringBuilder formattedStringBuilder = new FormattedStringBuilder();
        this.formatter.symbols(decimalFormatSymbolsM17clone).unit(currencyAmount.getCurrency()).formatImpl(decimalQuantity_DualStorageBCD, formattedStringBuilder);
        fieldPositionHelper(decimalQuantity_DualStorageBCD, formattedStringBuilder, fieldPosition, stringBuffer.length());
        Utility.appendTo(formattedStringBuilder, stringBuffer);
        return stringBuffer;
    }

    @Override // java.text.Format
    public AttributedCharacterIterator formatToCharacterIterator(Object obj) {
        if (obj instanceof Number) {
            return this.formatter.format((Number) obj).toCharacterIterator();
        }
        dk0.v();
        return null;
    }

    @Override // com.ibm.icu.text.NumberFormat
    public synchronized Currency getCurrency() {
        return this.exportedProperties.getCurrency();
    }

    public NumberParserImpl getCurrencyParser() {
        if (this.currencyParser == null) {
            this.currencyParser = NumberParserImpl.createParserFromProperties(this.properties, this.symbols, true);
        }
        return this.currencyParser;
    }

    public synchronized CurrencyPluralInfo getCurrencyPluralInfo() {
        return this.properties.getCurrencyPluralInfo();
    }

    public synchronized Currency.CurrencyUsage getCurrencyUsage() {
        Currency.CurrencyUsage currencyUsage;
        currencyUsage = this.properties.getCurrencyUsage();
        if (currencyUsage == null) {
            currencyUsage = Currency.CurrencyUsage.STANDARD;
        }
        return currencyUsage;
    }

    public synchronized DecimalFormatSymbols getDecimalFormatSymbols() {
        return this.symbols.m17clone();
    }

    @Deprecated
    public PluralRules.IFixedDecimal getFixedDecimal(double d) {
        return this.formatter.format(d).getFixedDecimal();
    }

    public synchronized int getFormatWidth() {
        return this.properties.getFormatWidth();
    }

    public synchronized int getGroupingSize() {
        if (this.properties.getGroupingSize() < 0) {
            return 0;
        }
        return this.properties.getGroupingSize();
    }

    public synchronized java.math.MathContext getMathContext() {
        return this.exportedProperties.getMathContext();
    }

    public synchronized MathContext getMathContextICU() {
        java.math.MathContext mathContext;
        mathContext = getMathContext();
        return new MathContext(mathContext.getPrecision(), this.icuMathContextForm, false, mathContext.getRoundingMode().ordinal());
    }

    @Override // com.ibm.icu.text.NumberFormat
    public synchronized int getMaximumFractionDigits() {
        return this.exportedProperties.getMaximumFractionDigits();
    }

    @Override // com.ibm.icu.text.NumberFormat
    public synchronized int getMaximumIntegerDigits() {
        return this.exportedProperties.getMaximumIntegerDigits();
    }

    public synchronized int getMaximumSignificantDigits() {
        return this.exportedProperties.getMaximumSignificantDigits();
    }

    public synchronized byte getMinimumExponentDigits() {
        return (byte) this.properties.getMinimumExponentDigits();
    }

    @Override // com.ibm.icu.text.NumberFormat
    public synchronized int getMinimumFractionDigits() {
        return this.exportedProperties.getMinimumFractionDigits();
    }

    public synchronized int getMinimumGroupingDigits() {
        if (this.properties.getMinimumGroupingDigits() <= 0) {
            return 1;
        }
        return this.properties.getMinimumGroupingDigits();
    }

    @Override // com.ibm.icu.text.NumberFormat
    public synchronized int getMinimumIntegerDigits() {
        return this.exportedProperties.getMinimumIntegerDigits();
    }

    public synchronized int getMinimumSignificantDigits() {
        return this.exportedProperties.getMinimumSignificantDigits();
    }

    public synchronized int getMultiplier() {
        BigDecimal multiplier = this.properties.getMultiplier();
        DecimalFormatProperties decimalFormatProperties = this.properties;
        if (multiplier != null) {
            return decimalFormatProperties.getMultiplier().intValue();
        }
        return (int) Math.pow(10.0d, decimalFormatProperties.getMagnitudeMultiplier());
    }

    public synchronized String getNegativePrefix() {
        return this.formatter.getAffixImpl(true, true);
    }

    public synchronized String getNegativeSuffix() {
        return this.formatter.getAffixImpl(false, true);
    }

    public synchronized char getPadCharacter() {
        String padString = this.properties.getPadString();
        if (padString == null) {
            return Padder.FALLBACK_PADDING_STRING.charAt(0);
        }
        return padString.charAt(0);
    }

    public synchronized int getPadPosition() {
        Padder.PadPosition padPosition;
        padPosition = this.properties.getPadPosition();
        return padPosition == null ? 0 : padPosition.toOld();
    }

    @Deprecated
    public int getParseMaxDigits() {
        return 1000;
    }

    public NumberParserImpl getParser() {
        if (this.parser == null) {
            this.parser = NumberParserImpl.createParserFromProperties(this.properties, this.symbols, false);
        }
        return this.parser;
    }

    public synchronized String getPositivePrefix() {
        return this.formatter.getAffixImpl(true, false);
    }

    public synchronized String getPositiveSuffix() {
        return this.formatter.getAffixImpl(false, false);
    }

    public synchronized BigDecimal getRoundingIncrement() {
        return this.exportedProperties.getRoundingIncrement();
    }

    @Override // com.ibm.icu.text.NumberFormat
    public synchronized int getRoundingMode() {
        RoundingMode roundingMode;
        roundingMode = this.exportedProperties.getRoundingMode();
        return roundingMode == null ? 0 : roundingMode.ordinal();
    }

    public synchronized int getSecondaryGroupingSize() {
        int secondaryGroupingSize = this.properties.getSecondaryGroupingSize();
        if (secondaryGroupingSize < 0) {
            return 0;
        }
        return secondaryGroupingSize;
    }

    @Override // com.ibm.icu.text.NumberFormat
    public synchronized int hashCode() {
        return this.properties.hashCode() ^ this.symbols.hashCode();
    }

    public synchronized boolean isDecimalPatternMatchRequired() {
        return this.properties.getDecimalPatternMatchRequired();
    }

    public synchronized boolean isDecimalSeparatorAlwaysShown() {
        return this.properties.getDecimalSeparatorAlwaysShown();
    }

    public synchronized boolean isExponentSignAlwaysShown() {
        return this.properties.getExponentSignAlwaysShown();
    }

    @Override // com.ibm.icu.text.NumberFormat
    public synchronized boolean isGroupingUsed() {
        return this.properties.getGroupingUsed();
    }

    public synchronized boolean isParseBigDecimal() {
        return this.properties.getParseToBigDecimal();
    }

    public synchronized boolean isParseCaseSensitive() {
        return this.properties.getParseCaseSensitive();
    }

    @Override // com.ibm.icu.text.NumberFormat
    public synchronized boolean isParseIntegerOnly() {
        return this.properties.getParseIntegerOnly();
    }

    public synchronized boolean isParseNoExponent() {
        return this.properties.getParseNoExponent();
    }

    @Override // com.ibm.icu.text.NumberFormat
    public synchronized boolean isParseStrict() {
        return this.properties.getParseMode() == DecimalFormatProperties.ParseMode.STRICT;
    }

    public synchronized boolean isScientificNotation() {
        return this.properties.getMinimumExponentDigits() != -1;
    }

    public synchronized boolean isSignAlwaysShown() {
        return this.properties.getSignAlwaysShown();
    }

    @Override // com.ibm.icu.text.NumberFormat
    public Number parse(String str, ParsePosition parsePosition) {
        if (str == null) {
            og.i("Text cannot be null");
            return null;
        }
        if (parsePosition == null) {
            parsePosition = new ParsePosition(0);
        }
        if (parsePosition.getIndex() < 0) {
            og.i("Cannot start parsing at a negative offset");
            return null;
        }
        if (parsePosition.getIndex() >= str.length()) {
            return null;
        }
        ParsedNumber parsedNumber = new ParsedNumber();
        int index = parsePosition.getIndex();
        NumberParserImpl parser = getParser();
        parser.parse(str, index, true, parsedNumber);
        boolean zSuccess = parsedNumber.success();
        int i = parsedNumber.charEnd;
        if (!zSuccess) {
            parsePosition.setErrorIndex(index + i);
            return null;
        }
        parsePosition.setIndex(i);
        Number number = parsedNumber.getNumber(parser.getParseFlags());
        return number instanceof BigDecimal ? safeConvertBigDecimal((BigDecimal) number) : number;
    }

    @Override // com.ibm.icu.text.NumberFormat
    public CurrencyAmount parseCurrency(CharSequence charSequence, ParsePosition parsePosition) {
        if (charSequence == null) {
            og.i("Text cannot be null");
            return null;
        }
        if (parsePosition == null) {
            parsePosition = new ParsePosition(0);
        }
        if (parsePosition.getIndex() < 0) {
            og.i("Cannot start parsing at a negative offset");
            return null;
        }
        if (parsePosition.getIndex() >= charSequence.length()) {
            return null;
        }
        ParsedNumber parsedNumber = new ParsedNumber();
        int index = parsePosition.getIndex();
        NumberParserImpl currencyParser = getCurrencyParser();
        currencyParser.parse(charSequence.toString(), index, true, parsedNumber);
        boolean zSuccess = parsedNumber.success();
        int i = parsedNumber.charEnd;
        if (!zSuccess) {
            parsePosition.setErrorIndex(index + i);
            return null;
        }
        parsePosition.setIndex(i);
        Number number = parsedNumber.getNumber(currencyParser.getParseFlags());
        if (number instanceof BigDecimal) {
            number = safeConvertBigDecimal((BigDecimal) number);
        }
        return new CurrencyAmount(number, Currency.getInstance(parsedNumber.currencyCode));
    }

    public void refreshFormatter() {
        if (this.exportedProperties == null) {
            return;
        }
        ULocale locale = getLocale(ULocale.ACTUAL_LOCALE);
        if (locale == null) {
            locale = this.symbols.getLocale(ULocale.ACTUAL_LOCALE);
        }
        if (locale == null) {
            locale = this.symbols.getULocale();
        }
        this.formatter = NumberFormatter.fromDecimalFormat(this.properties, this.symbols, this.exportedProperties).locale(locale);
        this.parser = null;
        this.currencyParser = null;
    }

    @Override // com.ibm.icu.text.NumberFormat
    public synchronized void setCurrency(Currency currency) {
        try {
            this.properties.setCurrency(currency);
            if (currency != null) {
                this.symbols.setCurrency(currency);
            }
            refreshFormatter();
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void setCurrencyPluralInfo(CurrencyPluralInfo currencyPluralInfo) {
        this.properties.setCurrencyPluralInfo(currencyPluralInfo);
        refreshFormatter();
    }

    public synchronized void setCurrencyUsage(Currency.CurrencyUsage currencyUsage) {
        this.properties.setCurrencyUsage(currencyUsage);
        refreshFormatter();
    }

    public synchronized void setDecimalFormatSymbols(DecimalFormatSymbols decimalFormatSymbols) {
        this.symbols = decimalFormatSymbols.m17clone();
        refreshFormatter();
    }

    public synchronized void setDecimalPatternMatchRequired(boolean z) {
        this.properties.setDecimalPatternMatchRequired(z);
        refreshFormatter();
    }

    public synchronized void setDecimalSeparatorAlwaysShown(boolean z) {
        this.properties.setDecimalSeparatorAlwaysShown(z);
        refreshFormatter();
    }

    public synchronized void setExponentSignAlwaysShown(boolean z) {
        this.properties.setExponentSignAlwaysShown(z);
        refreshFormatter();
    }

    public synchronized void setFormatWidth(int i) {
        this.properties.setFormatWidth(i);
        refreshFormatter();
    }

    public synchronized void setGroupingSize(int i) {
        this.properties.setGroupingSize(i);
        refreshFormatter();
    }

    @Override // com.ibm.icu.text.NumberFormat
    public synchronized void setGroupingUsed(boolean z) {
        this.properties.setGroupingUsed(z);
        refreshFormatter();
    }

    public synchronized void setMathContext(java.math.MathContext mathContext) {
        this.properties.setMathContext(mathContext);
        refreshFormatter();
    }

    public synchronized void setMathContextICU(MathContext mathContext) {
        try {
            this.icuMathContextForm = mathContext.getForm();
            setMathContext(mathContext.getLostDigits() ? new java.math.MathContext(mathContext.getDigits(), RoundingMode.UNNECESSARY) : new java.math.MathContext(mathContext.getDigits(), RoundingMode.valueOf(mathContext.getRoundingMode())));
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.ibm.icu.text.NumberFormat
    public synchronized void setMaximumFractionDigits(int i) {
        try {
            int minimumFractionDigits = this.properties.getMinimumFractionDigits();
            if (minimumFractionDigits >= 0 && minimumFractionDigits > i) {
                this.properties.setMinimumFractionDigits(i);
            }
            this.properties.setMaximumFractionDigits(i);
            refreshFormatter();
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.ibm.icu.text.NumberFormat
    public synchronized void setMaximumIntegerDigits(int i) {
        try {
            int minimumIntegerDigits = this.properties.getMinimumIntegerDigits();
            if (minimumIntegerDigits >= 0 && minimumIntegerDigits > i) {
                this.properties.setMinimumIntegerDigits(i);
            }
            this.properties.setMaximumIntegerDigits(i);
            refreshFormatter();
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void setMaximumSignificantDigits(int i) {
        try {
            int minimumSignificantDigits = this.properties.getMinimumSignificantDigits();
            if (minimumSignificantDigits >= 0 && minimumSignificantDigits > i) {
                this.properties.setMinimumSignificantDigits(i);
            }
            this.properties.setMaximumSignificantDigits(i);
            refreshFormatter();
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void setMinimumExponentDigits(byte b) {
        this.properties.setMinimumExponentDigits(b);
        refreshFormatter();
    }

    @Override // com.ibm.icu.text.NumberFormat
    public synchronized void setMinimumFractionDigits(int i) {
        try {
            int maximumFractionDigits = this.properties.getMaximumFractionDigits();
            if (maximumFractionDigits >= 0 && maximumFractionDigits < i) {
                this.properties.setMaximumFractionDigits(i);
            }
            this.properties.setMinimumFractionDigits(i);
            refreshFormatter();
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void setMinimumGroupingDigits(int i) {
        this.properties.setMinimumGroupingDigits(i);
        refreshFormatter();
    }

    @Override // com.ibm.icu.text.NumberFormat
    public synchronized void setMinimumIntegerDigits(int i) {
        try {
            int maximumIntegerDigits = this.properties.getMaximumIntegerDigits();
            if (maximumIntegerDigits >= 0 && maximumIntegerDigits < i) {
                this.properties.setMaximumIntegerDigits(i);
            }
            this.properties.setMinimumIntegerDigits(i);
            refreshFormatter();
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void setMinimumSignificantDigits(int i) {
        try {
            int maximumSignificantDigits = this.properties.getMaximumSignificantDigits();
            if (maximumSignificantDigits >= 0 && maximumSignificantDigits < i) {
                this.properties.setMaximumSignificantDigits(i);
            }
            this.properties.setMinimumSignificantDigits(i);
            refreshFormatter();
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void setMultiplier(int i) {
        try {
            if (i == 0) {
                throw new IllegalArgumentException("Multiplier must be nonzero.");
            }
            int i2 = i;
            int i3 = 0;
            while (i2 != 1) {
                i3++;
                int i4 = i2 / 10;
                if (i4 * 10 != i2) {
                    i3 = -1;
                    break;
                }
                i2 = i4;
            }
            DecimalFormatProperties decimalFormatProperties = this.properties;
            if (i3 != -1) {
                decimalFormatProperties.setMagnitudeMultiplier(i3);
                this.properties.setMultiplier(null);
            } else {
                decimalFormatProperties.setMagnitudeMultiplier(0);
                this.properties.setMultiplier(BigDecimal.valueOf(i));
            }
            refreshFormatter();
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void setNegativePrefix(String str) {
        try {
            if (str == null) {
                throw new NullPointerException();
            }
            this.properties.setNegativePrefix(str);
            refreshFormatter();
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void setNegativeSuffix(String str) {
        try {
            if (str == null) {
                throw new NullPointerException();
            }
            this.properties.setNegativeSuffix(str);
            refreshFormatter();
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void setPadCharacter(char c) {
        this.properties.setPadString(Character.toString(c));
        refreshFormatter();
    }

    public synchronized void setPadPosition(int i) {
        this.properties.setPadPosition(Padder.PadPosition.fromOld(i));
        refreshFormatter();
    }

    public synchronized void setParseBigDecimal(boolean z) {
        this.properties.setParseToBigDecimal(z);
        refreshFormatter();
    }

    public synchronized void setParseCaseSensitive(boolean z) {
        this.properties.setParseCaseSensitive(z);
        refreshFormatter();
    }

    @Override // com.ibm.icu.text.NumberFormat
    public synchronized void setParseIntegerOnly(boolean z) {
        this.properties.setParseIntegerOnly(z);
        refreshFormatter();
    }

    public synchronized void setParseNoExponent(boolean z) {
        this.properties.setParseNoExponent(z);
        refreshFormatter();
    }

    @Override // com.ibm.icu.text.NumberFormat
    public synchronized void setParseStrict(boolean z) {
        try {
            this.properties.setParseMode(z ? DecimalFormatProperties.ParseMode.STRICT : DecimalFormatProperties.ParseMode.LENIENT);
            refreshFormatter();
        } catch (Throwable th) {
            throw th;
        }
    }

    @Deprecated
    public synchronized void setParseStrictMode(DecimalFormatProperties.ParseMode parseMode) {
        this.properties.setParseMode(parseMode);
        refreshFormatter();
    }

    public synchronized void setPositivePrefix(String str) {
        try {
            if (str == null) {
                throw new NullPointerException();
            }
            this.properties.setPositivePrefix(str);
            refreshFormatter();
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void setPositiveSuffix(String str) {
        try {
            if (str == null) {
                throw new NullPointerException();
            }
            this.properties.setPositiveSuffix(str);
            refreshFormatter();
        } catch (Throwable th) {
            throw th;
        }
    }

    @Deprecated
    public synchronized void setProperties(PropertySetter propertySetter) {
        propertySetter.set(this.properties);
        refreshFormatter();
    }

    public void setPropertiesFromPattern(String str, int i) {
        str.getClass();
        PatternStringParser.parseToExistingProperties(str, this.properties, i);
    }

    public synchronized void setRoundingIncrement(double d) {
        try {
            if (d == 0.0d) {
                setRoundingIncrement((BigDecimal) null);
            } else {
                BigDecimal bigDecimalValueOf = BigDecimal.valueOf(d);
                setRoundingIncrement(bigDecimalValueOf.signum() == 0 ? new BigDecimal(BigInteger.ZERO, 0) : bigDecimalValueOf.stripTrailingZeros());
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.ibm.icu.text.NumberFormat
    public synchronized void setRoundingMode(int i) {
        this.properties.setRoundingMode(RoundingMode.valueOf(i));
        refreshFormatter();
    }

    public synchronized void setScientificNotation(boolean z) {
        DecimalFormatProperties decimalFormatProperties = this.properties;
        try {
            if (z) {
                decimalFormatProperties.setMinimumExponentDigits(1);
            } else {
                decimalFormatProperties.setMinimumExponentDigits(-1);
            }
            refreshFormatter();
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void setSecondaryGroupingSize(int i) {
        this.properties.setSecondaryGroupingSize(i);
        refreshFormatter();
    }

    public synchronized void setSignAlwaysShown(boolean z) {
        this.properties.setSignAlwaysShown(z);
        refreshFormatter();
    }

    public synchronized void setSignificantDigitsUsed(boolean z) {
        int minimumSignificantDigits = this.properties.getMinimumSignificantDigits();
        int maximumSignificantDigits = this.properties.getMaximumSignificantDigits();
        if (z) {
            if (minimumSignificantDigits != -1 || maximumSignificantDigits != -1) {
                return;
            }
        } else if (minimumSignificantDigits == -1 && maximumSignificantDigits == -1) {
            return;
        }
        int i = z ? 1 : -1;
        int i2 = z ? 6 : -1;
        this.properties.setMinimumSignificantDigits(i);
        this.properties.setMaximumSignificantDigits(i2);
        refreshFormatter();
    }

    public synchronized String toLocalizedPattern() {
        return PatternStringUtils.convertLocalized(toPattern(), this.symbols, true);
    }

    public LocalizedNumberFormatter toNumberFormatter() {
        return this.formatter;
    }

    public synchronized String toPattern() {
        DecimalFormatProperties decimalFormatPropertiesCopyFrom;
        try {
            decimalFormatPropertiesCopyFrom = new DecimalFormatProperties().copyFrom(this.properties);
            if (decimalFormatPropertiesCopyFrom.getCurrency() != null || decimalFormatPropertiesCopyFrom.getCurrencyPluralInfo() != null || decimalFormatPropertiesCopyFrom.getCurrencyUsage() != null || decimalFormatPropertiesCopyFrom.getCurrencyAsDecimal() || AffixUtils.hasCurrencySymbols(decimalFormatPropertiesCopyFrom.getPositivePrefixPattern()) || AffixUtils.hasCurrencySymbols(decimalFormatPropertiesCopyFrom.getPositiveSuffixPattern()) || AffixUtils.hasCurrencySymbols(decimalFormatPropertiesCopyFrom.getNegativePrefixPattern()) || AffixUtils.hasCurrencySymbols(decimalFormatPropertiesCopyFrom.getNegativeSuffixPattern())) {
                decimalFormatPropertiesCopyFrom.setMinimumFractionDigits(this.exportedProperties.getMinimumFractionDigits());
                decimalFormatPropertiesCopyFrom.setMaximumFractionDigits(this.exportedProperties.getMaximumFractionDigits());
                decimalFormatPropertiesCopyFrom.setRoundingIncrement(this.exportedProperties.getRoundingIncrement());
            }
        } catch (Throwable th) {
            throw th;
        }
        return PatternStringUtils.propertiesToPatternString(decimalFormatPropertiesCopyFrom);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getName());
        sb.append("@");
        sb.append(Integer.toHexString(hashCode()));
        sb.append(" { symbols@");
        sb.append(Integer.toHexString(this.symbols.hashCode()));
        synchronized (this) {
            this.properties.toStringBare(sb);
        }
        sb.append(" }");
        return sb.toString();
    }

    @Deprecated
    public void setParseMaxDigits(int i) {
    }

    public synchronized void setRoundingIncrement(com.ibm.icu.math.BigDecimal bigDecimal) {
        setRoundingIncrement(bigDecimal == null ? null : bigDecimal.toBigDecimal());
    }

    public synchronized void setRoundingIncrement(BigDecimal bigDecimal) {
        if (bigDecimal != null) {
            if (bigDecimal.compareTo(BigDecimal.ZERO) == 0) {
                this.properties.setMaximumFractionDigits(Integer.MAX_VALUE);
                return;
            }
        }
        this.properties.setRoundingIncrement(bigDecimal);
        refreshFormatter();
    }

    @Override // com.ibm.icu.text.NumberFormat
    public StringBuffer format(long j, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        DecimalQuantity_DualStorageBCD decimalQuantity_DualStorageBCD = new DecimalQuantity_DualStorageBCD(j);
        FormattedStringBuilder formattedStringBuilder = new FormattedStringBuilder();
        this.formatter.formatImpl(decimalQuantity_DualStorageBCD, formattedStringBuilder);
        fieldPositionHelper(decimalQuantity_DualStorageBCD, formattedStringBuilder, fieldPosition, stringBuffer.length());
        Utility.appendTo(formattedStringBuilder, stringBuffer);
        return stringBuffer;
    }

    public DecimalFormat(String str) {
        this.serialVersionOnStream = 5;
        this.icuMathContextForm = 0;
        this.symbols = getDefaultSymbols();
        this.properties = new DecimalFormatProperties();
        this.exportedProperties = new DecimalFormatProperties();
        setPropertiesFromPattern(str, 1);
        refreshFormatter();
    }

    @Override // com.ibm.icu.text.NumberFormat
    public StringBuffer format(BigInteger bigInteger, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        DecimalQuantity_DualStorageBCD decimalQuantity_DualStorageBCD = new DecimalQuantity_DualStorageBCD(bigInteger);
        FormattedStringBuilder formattedStringBuilder = new FormattedStringBuilder();
        this.formatter.formatImpl(decimalQuantity_DualStorageBCD, formattedStringBuilder);
        fieldPositionHelper(decimalQuantity_DualStorageBCD, formattedStringBuilder, fieldPosition, stringBuffer.length());
        Utility.appendTo(formattedStringBuilder, stringBuffer);
        return stringBuffer;
    }

    public DecimalFormat(String str, DecimalFormatSymbols decimalFormatSymbols) {
        this.serialVersionOnStream = 5;
        this.icuMathContextForm = 0;
        this.symbols = decimalFormatSymbols.m17clone();
        this.properties = new DecimalFormatProperties();
        this.exportedProperties = new DecimalFormatProperties();
        setPropertiesFromPattern(str, 1);
        refreshFormatter();
    }

    @Override // com.ibm.icu.text.NumberFormat
    public StringBuffer format(BigDecimal bigDecimal, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        DecimalQuantity_DualStorageBCD decimalQuantity_DualStorageBCD = new DecimalQuantity_DualStorageBCD(bigDecimal);
        FormattedStringBuilder formattedStringBuilder = new FormattedStringBuilder();
        this.formatter.formatImpl(decimalQuantity_DualStorageBCD, formattedStringBuilder);
        fieldPositionHelper(decimalQuantity_DualStorageBCD, formattedStringBuilder, fieldPosition, stringBuffer.length());
        Utility.appendTo(formattedStringBuilder, stringBuffer);
        return stringBuffer;
    }

    @Override // com.ibm.icu.text.NumberFormat
    public StringBuffer format(com.ibm.icu.math.BigDecimal bigDecimal, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        DecimalQuantity_DualStorageBCD decimalQuantity_DualStorageBCD = new DecimalQuantity_DualStorageBCD(bigDecimal);
        FormattedStringBuilder formattedStringBuilder = new FormattedStringBuilder();
        this.formatter.formatImpl(decimalQuantity_DualStorageBCD, formattedStringBuilder);
        fieldPositionHelper(decimalQuantity_DualStorageBCD, formattedStringBuilder, fieldPosition, stringBuffer.length());
        Utility.appendTo(formattedStringBuilder, stringBuffer);
        return stringBuffer;
    }

    public DecimalFormat(String str, DecimalFormatSymbols decimalFormatSymbols, CurrencyPluralInfo currencyPluralInfo, int i) {
        this(str, decimalFormatSymbols, i);
        this.properties.setCurrencyPluralInfo(currencyPluralInfo);
        refreshFormatter();
    }

    @Override // com.ibm.icu.text.NumberFormat
    public StringBuffer format(double d, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        DecimalQuantity_DualStorageBCD decimalQuantity_DualStorageBCD = new DecimalQuantity_DualStorageBCD(d);
        FormattedStringBuilder formattedStringBuilder = new FormattedStringBuilder();
        this.formatter.formatImpl(decimalQuantity_DualStorageBCD, formattedStringBuilder);
        fieldPositionHelper(decimalQuantity_DualStorageBCD, formattedStringBuilder, fieldPosition, stringBuffer.length());
        Utility.appendTo(formattedStringBuilder, stringBuffer);
        return stringBuffer;
    }

    public DecimalFormat() {
        this.serialVersionOnStream = 5;
        this.icuMathContextForm = 0;
        String pattern = NumberFormat.getPattern(ULocale.getDefault(ULocale.Category.FORMAT), 0);
        this.symbols = getDefaultSymbols();
        this.properties = new DecimalFormatProperties();
        this.exportedProperties = new DecimalFormatProperties();
        setPropertiesFromPattern(pattern, 1);
        refreshFormatter();
    }
}
