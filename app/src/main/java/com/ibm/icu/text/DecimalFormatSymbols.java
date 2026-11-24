package com.ibm.icu.text;

import com.ibm.icu.impl.CacheBase;
import com.ibm.icu.impl.CurrencyData;
import com.ibm.icu.impl.ICUData;
import com.ibm.icu.impl.ICUResourceBundle;
import com.ibm.icu.impl.SoftCache;
import com.ibm.icu.impl.UResource;
import com.ibm.icu.util.Currency;
import com.ibm.icu.util.ICUCloneNotSupportedException;
import com.ibm.icu.util.ULocale;
import com.ibm.icu.util.UResourceBundle;
import defpackage.dk0;
import defpackage.ky0;
import defpackage.og;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Locale;
import java.util.MissingResourceException;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class DecimalFormatSymbols implements Cloneable, Serializable {
    public static final int CURRENCY_SPC_CURRENCY_MATCH = 0;
    public static final int CURRENCY_SPC_INSERT = 2;
    public static final int CURRENCY_SPC_SURROUNDING_MATCH = 1;
    private static final String LATIN_NUMBERING_SYSTEM = "latn";
    private static final String NUMBER_ELEMENTS = "NumberElements";
    private static final String SYMBOLS = "symbols";
    private static final int currentSerialVersion = 10;
    private static final long serialVersionUID = 5772796243397350300L;
    private String NaN;
    private ULocale actualLocale;
    private String approximatelyString;
    private transient int codePointZero;
    private transient Currency currency;
    private String currencyPattern;
    private String[] currencySpcAfterSym;
    private String[] currencySpcBeforeSym;
    private String currencySymbol;
    private char decimalSeparator;
    private String decimalSeparatorString;
    private char digit;
    private String[] digitStrings;
    private char[] digits;
    private String exponentMultiplicationSign;
    private String exponentSeparator;
    private char exponential;
    private char groupingSeparator;
    private String groupingSeparatorString;
    private String infinity;
    private String intlCurrencySymbol;
    private char minusSign;
    private String minusString;
    private char monetaryGroupingSeparator;
    private String monetaryGroupingSeparatorString;
    private char monetarySeparator;
    private String monetarySeparatorString;
    private char padEscape;
    private char patternSeparator;
    private char perMill;
    private String perMillString;
    private char percent;
    private String percentString;
    private char plusSign;
    private String plusString;
    private Locale requestedLocale;
    private int serialVersionOnStream;
    private char sigDigit;
    private ULocale ulocale;
    private ULocale validLocale;
    private char zeroDigit;
    private static final String[] SYMBOL_KEYS = {"decimal", "group", "percentSign", "minusSign", "plusSign", "exponential", "perMille", "infinity", "nan", "currencyDecimal", "currencyGroup", "superscriptingExponent", "approximatelySign"};
    private static final String[] DEF_DIGIT_STRINGS_ARRAY = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
    private static final char[] DEF_DIGIT_CHARS_ARRAY = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    private static final char DEF_DECIMAL_SEPARATOR = '.';
    private static final char DEF_GROUPING_SEPARATOR = ',';
    private static final char DEF_PERCENT = '%';
    private static final char DEF_MINUS_SIGN = '-';
    private static final char DEF_PLUS_SIGN = '+';
    private static final char DEF_PERMILL = 8240;
    private static final String[] SYMBOL_DEFAULTS = {String.valueOf(DEF_DECIMAL_SEPARATOR), String.valueOf(DEF_GROUPING_SEPARATOR), String.valueOf(DEF_PERCENT), String.valueOf(DEF_MINUS_SIGN), String.valueOf(DEF_PLUS_SIGN), DateFormat.ABBR_WEEKDAY, String.valueOf(DEF_PERMILL), "∞", "NaN", null, null, "×", "~"};
    private static final CacheBase<ULocale, CacheData, Void> cachedLocaleData = new SoftCache<ULocale, CacheData, Void>() { // from class: com.ibm.icu.text.DecimalFormatSymbols.1
        @Override // com.ibm.icu.impl.CacheBase
        public CacheData createInstance(ULocale uLocale, Void r2) {
            return DecimalFormatSymbols.loadData(uLocale);
        }
    };

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class CacheData {
        final String[] digits;
        final String[] numberElements;
        final ULocale validLocale;

        public CacheData(ULocale uLocale, String[] strArr, String[] strArr2) {
            this.validLocale = uLocale;
            this.digits = strArr;
            this.numberElements = strArr2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class DecFmtDataSink extends UResource.Sink {
        private String[] numberElements;

        public DecFmtDataSink(String[] strArr) {
            this.numberElements = strArr;
        }

        @Override // com.ibm.icu.impl.UResource.Sink
        public void put(UResource.Key key, UResource.Value value, boolean z) {
            UResource.Table table = value.getTable();
            for (int i = 0; table.getKeyAndValue(i, key, value); i++) {
                for (int i2 = 0; i2 < DecimalFormatSymbols.SYMBOL_KEYS.length; i2++) {
                    if (key.contentEquals(DecimalFormatSymbols.SYMBOL_KEYS[i2])) {
                        String[] strArr = this.numberElements;
                        if (strArr[i2] != null) {
                            break;
                        }
                        strArr[i2] = value.toString();
                        break;
                    }
                }
            }
        }
    }

    public DecimalFormatSymbols(ULocale uLocale) {
        this.exponentMultiplicationSign = null;
        this.serialVersionOnStream = 10;
        this.currencyPattern = null;
        initialize(uLocale, null);
    }

    public static DecimalFormatSymbols forNumberingSystem(Locale locale, NumberingSystem numberingSystem) {
        return new DecimalFormatSymbols(locale, numberingSystem);
    }

    public static Locale[] getAvailableLocales() {
        return ICUResourceBundle.getAvailableLocales();
    }

    public static ULocale[] getAvailableULocales() {
        return ICUResourceBundle.getAvailableULocales();
    }

    public static DecimalFormatSymbols getInstance() {
        return new DecimalFormatSymbols();
    }

    private void initSpacingInfo(CurrencyData.CurrencySpacingInfo currencySpacingInfo) {
        this.currencySpcBeforeSym = currencySpacingInfo.getBeforeSymbols();
        this.currencySpcAfterSym = currencySpacingInfo.getAfterSymbols();
    }

    private void initialize(ULocale uLocale, NumberingSystem numberingSystem) {
        this.requestedLocale = uLocale.toLocale();
        this.ulocale = uLocale;
        if (numberingSystem != null) {
            uLocale = uLocale.setKeywordValue("numbers", numberingSystem.getName());
        }
        CacheData cacheBase = cachedLocaleData.getInstance(uLocale, null);
        ULocale uLocale2 = cacheBase.validLocale;
        setLocale(uLocale2, uLocale2);
        setDigitStrings(cacheBase.digits);
        String[] strArr = cacheBase.numberElements;
        setDecimalSeparatorString(strArr[0]);
        setGroupingSeparatorString(strArr[1]);
        this.patternSeparator = ';';
        setPercentString(strArr[2]);
        setMinusSignString(strArr[3]);
        setPlusSignString(strArr[4]);
        setExponentSeparator(strArr[5]);
        setPerMillString(strArr[6]);
        setInfinity(strArr[7]);
        setNaN(strArr[8]);
        setMonetaryDecimalSeparatorString(strArr[9]);
        setMonetaryGroupingSeparatorString(strArr[10]);
        setExponentMultiplicationSign(strArr[11]);
        setApproximatelySignString(strArr[12]);
        this.digit = '#';
        this.padEscape = '*';
        this.sigDigit = '@';
        CurrencyData.CurrencyDisplayInfo currencyDisplayInfoProvider = CurrencyData.provider.getInstance(this.ulocale, true);
        initSpacingInfo(currencyDisplayInfoProvider.getSpacingInfo());
        setCurrencyOrNull(Currency.getInstance(this.ulocale), currencyDisplayInfoProvider);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static CacheData loadData(ULocale uLocale) {
        String name;
        NumberingSystem numberingSystem = NumberingSystem.getInstance(uLocale);
        String[] strArr = new String[10];
        if (numberingSystem == null || numberingSystem.getRadix() != 10 || numberingSystem.isAlgorithmic() || !NumberingSystem.isValidDigitString(numberingSystem.getDescription())) {
            strArr = DEF_DIGIT_STRINGS_ARRAY;
            name = LATIN_NUMBERING_SYSTEM;
        } else {
            String description = numberingSystem.getDescription();
            int i = 0;
            int i2 = 0;
            while (i < 10) {
                int iCharCount = Character.charCount(description.codePointAt(i2)) + i2;
                strArr[i] = description.substring(i2, iCharCount);
                i++;
                i2 = iCharCount;
            }
            name = numberingSystem.getName();
        }
        ICUResourceBundle iCUResourceBundle = (ICUResourceBundle) UResourceBundle.getBundleInstance(ICUData.ICU_BASE_NAME, uLocale);
        ULocale uLocale2 = iCUResourceBundle.getULocale();
        int length = SYMBOL_KEYS.length;
        String[] strArr2 = new String[length];
        DecFmtDataSink decFmtDataSink = new DecFmtDataSink(strArr2);
        try {
            iCUResourceBundle.getAllItemsWithFallback("NumberElements/" + name + "/symbols", decFmtDataSink);
        } catch (MissingResourceException unused) {
        }
        for (int i3 = 0; i3 < length; i3++) {
            if (strArr2[i3] == null) {
                if (!name.equals(LATIN_NUMBERING_SYSTEM)) {
                    iCUResourceBundle.getAllItemsWithFallback("NumberElements/latn/symbols", decFmtDataSink);
                    break;
                }
                break;
            }
        }
        for (int i4 = 0; i4 < SYMBOL_KEYS.length; i4++) {
            if (strArr2[i4] == null) {
                strArr2[i4] = SYMBOL_DEFAULTS[i4];
            }
        }
        if (strArr2[9] == null) {
            strArr2[9] = strArr2[0];
        }
        if (strArr2[10] == null) {
            strArr2[10] = strArr2[1];
        }
        return new CacheData(uLocale2, strArr, strArr2);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        int i = this.serialVersionOnStream;
        if (i < 1) {
            this.monetarySeparator = this.decimalSeparator;
            this.exponential = 'E';
        }
        if (i < 2) {
            this.padEscape = '*';
            this.plusSign = DEF_PLUS_SIGN;
            this.exponentSeparator = String.valueOf(this.exponential);
        }
        if (this.serialVersionOnStream < 3) {
            this.requestedLocale = Locale.getDefault();
        }
        if (this.serialVersionOnStream < 4) {
            this.ulocale = ULocale.forLocale(this.requestedLocale);
        }
        int i2 = this.serialVersionOnStream;
        if (i2 < 5) {
            this.monetaryGroupingSeparator = this.groupingSeparator;
        }
        if (i2 < 6) {
            if (this.currencySpcBeforeSym == null) {
                this.currencySpcBeforeSym = new String[3];
            }
            if (this.currencySpcAfterSym == null) {
                this.currencySpcAfterSym = new String[3];
            }
            initSpacingInfo(CurrencyData.CurrencySpacingInfo.DEFAULT);
        }
        if (this.serialVersionOnStream < 7) {
            if (this.minusString == null) {
                this.minusString = String.valueOf(this.minusSign);
            }
            if (this.plusString == null) {
                this.plusString = String.valueOf(this.plusSign);
            }
        }
        int i3 = this.serialVersionOnStream;
        if (i3 < 8 && this.exponentMultiplicationSign == null) {
            this.exponentMultiplicationSign = "×";
        }
        if (i3 < 9) {
            if (this.digitStrings == null) {
                this.digitStrings = new String[10];
                char[] cArr = this.digits;
                int i4 = 0;
                if (cArr == null || cArr.length != 10) {
                    char c = this.zeroDigit;
                    if (cArr == null) {
                        this.digits = new char[10];
                    }
                    while (i4 < 10) {
                        this.digits[i4] = c;
                        this.digitStrings[i4] = String.valueOf(c);
                        c = (char) (c + 1);
                        i4++;
                    }
                } else {
                    this.zeroDigit = cArr[0];
                    while (i4 < 10) {
                        this.digitStrings[i4] = String.valueOf(this.digits[i4]);
                        i4++;
                    }
                }
            }
            if (this.decimalSeparatorString == null) {
                this.decimalSeparatorString = String.valueOf(this.decimalSeparator);
            }
            if (this.groupingSeparatorString == null) {
                this.groupingSeparatorString = String.valueOf(this.groupingSeparator);
            }
            if (this.percentString == null) {
                this.percentString = String.valueOf(this.percent);
            }
            if (this.perMillString == null) {
                this.perMillString = String.valueOf(this.perMill);
            }
            if (this.monetarySeparatorString == null) {
                this.monetarySeparatorString = String.valueOf(this.monetarySeparator);
            }
            if (this.monetaryGroupingSeparatorString == null) {
                this.monetaryGroupingSeparatorString = String.valueOf(this.monetaryGroupingSeparator);
            }
        }
        if (this.serialVersionOnStream < 10) {
            this.approximatelyString = "~";
        }
        this.serialVersionOnStream = 10;
        this.currency = Currency.getInstance(this.intlCurrencySymbol);
        setDigitStrings(this.digitStrings);
    }

    private void setCurrencyOrNull(Currency currency, CurrencyData.CurrencyDisplayInfo currencyDisplayInfo) {
        this.currency = currency;
        if (currency == null) {
            this.intlCurrencySymbol = "XXX";
            this.currencySymbol = "¤";
            this.currencyPattern = null;
            return;
        }
        this.intlCurrencySymbol = currency.getCurrencyCode();
        this.currencySymbol = currency.getSymbol(this.ulocale);
        CurrencyData.CurrencyFormatInfo formatInfo = currencyDisplayInfo.getFormatInfo(currency.getCurrencyCode());
        if (formatInfo != null) {
            setMonetaryDecimalSeparatorString(formatInfo.monetaryDecimalSeparator);
            setMonetaryGroupingSeparatorString(formatInfo.monetaryGroupingSeparator);
            this.currencyPattern = formatInfo.currencyPattern;
        }
    }

    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public DecimalFormatSymbols m17clone() {
        try {
            return (DecimalFormatSymbols) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new ICUCloneNotSupportedException(e);
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof DecimalFormatSymbols)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        DecimalFormatSymbols decimalFormatSymbols = (DecimalFormatSymbols) obj;
        for (int i = 0; i <= 2; i++) {
            if (!this.currencySpcBeforeSym[i].equals(decimalFormatSymbols.currencySpcBeforeSym[i]) || !this.currencySpcAfterSym[i].equals(decimalFormatSymbols.currencySpcAfterSym[i])) {
                return false;
            }
        }
        char[] cArr = decimalFormatSymbols.digits;
        if (cArr == null) {
            for (int i2 = 0; i2 < 10; i2++) {
                if (this.digits[i2] != decimalFormatSymbols.zeroDigit + i2) {
                    return false;
                }
            }
        } else if (!Arrays.equals(this.digits, cArr)) {
            return false;
        }
        return this.groupingSeparator == decimalFormatSymbols.groupingSeparator && this.decimalSeparator == decimalFormatSymbols.decimalSeparator && this.percent == decimalFormatSymbols.percent && this.perMill == decimalFormatSymbols.perMill && this.digit == decimalFormatSymbols.digit && this.minusSign == decimalFormatSymbols.minusSign && this.minusString.equals(decimalFormatSymbols.minusString) && this.patternSeparator == decimalFormatSymbols.patternSeparator && this.infinity.equals(decimalFormatSymbols.infinity) && this.NaN.equals(decimalFormatSymbols.NaN) && this.currencySymbol.equals(decimalFormatSymbols.currencySymbol) && this.intlCurrencySymbol.equals(decimalFormatSymbols.intlCurrencySymbol) && this.padEscape == decimalFormatSymbols.padEscape && this.plusSign == decimalFormatSymbols.plusSign && this.plusString.equals(decimalFormatSymbols.plusString) && this.approximatelyString.equals(decimalFormatSymbols.approximatelyString) && this.exponentSeparator.equals(decimalFormatSymbols.exponentSeparator) && this.monetarySeparator == decimalFormatSymbols.monetarySeparator && this.monetaryGroupingSeparator == decimalFormatSymbols.monetaryGroupingSeparator && this.exponentMultiplicationSign.equals(decimalFormatSymbols.exponentMultiplicationSign);
    }

    @Deprecated
    public String getApproximatelySignString() {
        return this.approximatelyString;
    }

    @Deprecated
    public int getCodePointZero() {
        return this.codePointZero;
    }

    public Currency getCurrency() {
        return this.currency;
    }

    @Deprecated
    public String getCurrencyPattern() {
        return this.currencyPattern;
    }

    public String getCurrencySymbol() {
        return this.currencySymbol;
    }

    public char getDecimalSeparator() {
        return this.decimalSeparator;
    }

    public String getDecimalSeparatorString() {
        return this.decimalSeparatorString;
    }

    public char getDigit() {
        return this.digit;
    }

    public String[] getDigitStrings() {
        return (String[]) this.digitStrings.clone();
    }

    @Deprecated
    public String[] getDigitStringsLocal() {
        return this.digitStrings;
    }

    public char[] getDigits() {
        return (char[]) this.digits.clone();
    }

    public String getExponentMultiplicationSign() {
        return this.exponentMultiplicationSign;
    }

    public String getExponentSeparator() {
        return this.exponentSeparator;
    }

    public char getGroupingSeparator() {
        return this.groupingSeparator;
    }

    public String getGroupingSeparatorString() {
        return this.groupingSeparatorString;
    }

    public String getInfinity() {
        return this.infinity;
    }

    public String getInternationalCurrencySymbol() {
        return this.intlCurrencySymbol;
    }

    public final ULocale getLocale(ULocale.Type type) {
        return type == ULocale.ACTUAL_LOCALE ? this.actualLocale : this.validLocale;
    }

    public char getMinusSign() {
        return this.minusSign;
    }

    public String getMinusSignString() {
        return this.minusString;
    }

    public char getMonetaryDecimalSeparator() {
        return this.monetarySeparator;
    }

    public String getMonetaryDecimalSeparatorString() {
        return this.monetarySeparatorString;
    }

    public char getMonetaryGroupingSeparator() {
        return this.monetaryGroupingSeparator;
    }

    public String getMonetaryGroupingSeparatorString() {
        return this.monetaryGroupingSeparatorString;
    }

    public String getNaN() {
        return this.NaN;
    }

    public char getPadEscape() {
        return this.padEscape;
    }

    public String getPatternForCurrencySpacing(int i, boolean z) {
        if (i >= 0 && i <= 2) {
            return z ? this.currencySpcBeforeSym[i] : this.currencySpcAfterSym[i];
        }
        og.i(ky0.h(i, "unknown currency spacing: "));
        return null;
    }

    public char getPatternSeparator() {
        return this.patternSeparator;
    }

    public char getPerMill() {
        return this.perMill;
    }

    public String getPerMillString() {
        return this.perMillString;
    }

    public char getPercent() {
        return this.percent;
    }

    public String getPercentString() {
        return this.percentString;
    }

    public char getPlusSign() {
        return this.plusSign;
    }

    public String getPlusSignString() {
        return this.plusString;
    }

    public char getSignificantDigit() {
        return this.sigDigit;
    }

    public ULocale getULocale() {
        return this.ulocale;
    }

    public char getZeroDigit() {
        return this.zeroDigit;
    }

    public int hashCode() {
        return (((this.digits[0] * DEF_PERCENT) + this.groupingSeparator) * 37) + this.decimalSeparator;
    }

    @Deprecated
    public void setApproximatelySignString(String str) {
        if (str != null) {
            this.approximatelyString = str;
        } else {
            dk0.n("The input plus sign is null");
        }
    }

    public void setCurrency(Currency currency) {
        currency.getClass();
        if (currency.equals(this.currency)) {
            return;
        }
        setCurrencyOrNull(currency, CurrencyData.provider.getInstance(this.ulocale, true));
    }

    public void setCurrencySymbol(String str) {
        this.currencySymbol = str;
    }

    public void setDecimalSeparator(char c) {
        this.decimalSeparator = c;
        this.decimalSeparatorString = String.valueOf(c);
    }

    public void setDecimalSeparatorString(String str) {
        if (str == null) {
            dk0.n("The input decimal separator is null");
            return;
        }
        this.decimalSeparatorString = str;
        if (str.length() == 1) {
            this.decimalSeparator = str.charAt(0);
        } else {
            this.decimalSeparator = DEF_DECIMAL_SEPARATOR;
        }
    }

    public void setDigit(char c) {
        this.digit = c;
    }

    public void setDigitStrings(String[] strArr) {
        int iCodePointAt;
        int iCharCount;
        if (strArr == null) {
            dk0.n("The input digit string array is null");
            return;
        }
        if (strArr.length != 10) {
            og.i("Number of digit strings is not 10");
            return;
        }
        String[] strArr2 = new String[10];
        char[] cArr = new char[10];
        int i = -1;
        for (int i2 = 0; i2 < 10; i2++) {
            String str = strArr[i2];
            if (str == null) {
                og.i("The input digit string array contains a null element");
                return;
            }
            strArr2[i2] = str;
            if (str.length() == 0) {
                iCodePointAt = -1;
                iCharCount = 0;
            } else {
                iCodePointAt = Character.codePointAt(strArr[i2], 0);
                iCharCount = Character.charCount(iCodePointAt);
            }
            if (iCharCount == str.length()) {
                if (iCharCount != 1 || cArr == null) {
                    cArr = null;
                } else {
                    cArr[i2] = (char) iCodePointAt;
                }
                if (i2 == 0) {
                    i = iCodePointAt;
                } else if (iCodePointAt != i + i2) {
                    i = -1;
                }
            } else {
                i = -1;
                cArr = null;
            }
        }
        this.digitStrings = strArr2;
        this.codePointZero = i;
        if (cArr != null) {
            this.zeroDigit = cArr[0];
            this.digits = cArr;
        } else {
            char[] cArr2 = DEF_DIGIT_CHARS_ARRAY;
            this.zeroDigit = cArr2[0];
            this.digits = cArr2;
        }
    }

    public void setExponentMultiplicationSign(String str) {
        this.exponentMultiplicationSign = str;
    }

    public void setExponentSeparator(String str) {
        this.exponentSeparator = str;
    }

    public void setGroupingSeparator(char c) {
        this.groupingSeparator = c;
        this.groupingSeparatorString = String.valueOf(c);
    }

    public void setGroupingSeparatorString(String str) {
        if (str == null) {
            dk0.n("The input grouping separator is null");
            return;
        }
        this.groupingSeparatorString = str;
        if (str.length() == 1) {
            this.groupingSeparator = str.charAt(0);
        } else {
            this.groupingSeparator = DEF_GROUPING_SEPARATOR;
        }
    }

    public void setInfinity(String str) {
        this.infinity = str;
    }

    public void setInternationalCurrencySymbol(String str) {
        this.intlCurrencySymbol = str;
    }

    public final void setLocale(ULocale uLocale, ULocale uLocale2) {
        if ((uLocale == null) != (uLocale2 == null)) {
            dk0.v();
        } else {
            this.validLocale = uLocale;
            this.actualLocale = uLocale2;
        }
    }

    public void setMinusSign(char c) {
        this.minusSign = c;
        this.minusString = String.valueOf(c);
    }

    public void setMinusSignString(String str) {
        if (str == null) {
            dk0.n("The input minus sign is null");
            return;
        }
        this.minusString = str;
        if (str.length() == 1) {
            this.minusSign = str.charAt(0);
        } else {
            this.minusSign = DEF_MINUS_SIGN;
        }
    }

    public void setMonetaryDecimalSeparator(char c) {
        this.monetarySeparator = c;
        this.monetarySeparatorString = String.valueOf(c);
    }

    public void setMonetaryDecimalSeparatorString(String str) {
        if (str == null) {
            dk0.n("The input monetary decimal separator is null");
            return;
        }
        this.monetarySeparatorString = str;
        if (str.length() == 1) {
            this.monetarySeparator = str.charAt(0);
        } else {
            this.monetarySeparator = DEF_DECIMAL_SEPARATOR;
        }
    }

    public void setMonetaryGroupingSeparator(char c) {
        this.monetaryGroupingSeparator = c;
        this.monetaryGroupingSeparatorString = String.valueOf(c);
    }

    public void setMonetaryGroupingSeparatorString(String str) {
        if (str == null) {
            dk0.n("The input monetary grouping separator is null");
            return;
        }
        this.monetaryGroupingSeparatorString = str;
        if (str.length() == 1) {
            this.monetaryGroupingSeparator = str.charAt(0);
        } else {
            this.monetaryGroupingSeparator = DEF_GROUPING_SEPARATOR;
        }
    }

    public void setNaN(String str) {
        this.NaN = str;
    }

    public void setPadEscape(char c) {
        this.padEscape = c;
    }

    public void setPatternForCurrencySpacing(int i, boolean z, String str) {
        if (i < 0 || i > 2) {
            og.i(ky0.h(i, "unknown currency spacing: "));
            return;
        }
        if (z) {
            String[] strArr = (String[]) this.currencySpcBeforeSym.clone();
            this.currencySpcBeforeSym = strArr;
            strArr[i] = str;
        } else {
            String[] strArr2 = (String[]) this.currencySpcAfterSym.clone();
            this.currencySpcAfterSym = strArr2;
            strArr2[i] = str;
        }
    }

    public void setPatternSeparator(char c) {
        this.patternSeparator = c;
    }

    public void setPerMill(char c) {
        this.perMill = c;
        this.perMillString = String.valueOf(c);
    }

    public void setPerMillString(String str) {
        if (str == null) {
            dk0.n("The input permille string is null");
            return;
        }
        this.perMillString = str;
        if (str.length() == 1) {
            this.perMill = str.charAt(0);
        } else {
            this.perMill = DEF_PERMILL;
        }
    }

    public void setPercent(char c) {
        this.percent = c;
        this.percentString = String.valueOf(c);
    }

    public void setPercentString(String str) {
        if (str == null) {
            dk0.n("The input percent sign is null");
            return;
        }
        this.percentString = str;
        if (str.length() == 1) {
            this.percent = str.charAt(0);
        } else {
            this.percent = DEF_PERCENT;
        }
    }

    public void setPlusSign(char c) {
        this.plusSign = c;
        this.plusString = String.valueOf(c);
    }

    public void setPlusSignString(String str) {
        if (str == null) {
            dk0.n("The input plus sign is null");
            return;
        }
        this.plusString = str;
        if (str.length() == 1) {
            this.plusSign = str.charAt(0);
        } else {
            this.plusSign = DEF_PLUS_SIGN;
        }
    }

    public void setSignificantDigit(char c) {
        this.sigDigit = c;
    }

    public void setZeroDigit(char c) {
        this.zeroDigit = c;
        this.digitStrings = (String[]) this.digitStrings.clone();
        this.digits = (char[]) this.digits.clone();
        this.digitStrings[0] = String.valueOf(c);
        this.digits[0] = c;
        for (int i = 1; i < 10; i++) {
            char c2 = (char) (c + i);
            this.digitStrings[i] = String.valueOf(c2);
            this.digits[i] = c2;
        }
        this.codePointZero = c;
    }

    public static DecimalFormatSymbols forNumberingSystem(ULocale uLocale, NumberingSystem numberingSystem) {
        return new DecimalFormatSymbols(uLocale, numberingSystem);
    }

    public static DecimalFormatSymbols getInstance(Locale locale) {
        return new DecimalFormatSymbols(locale);
    }

    public static DecimalFormatSymbols getInstance(ULocale uLocale) {
        return new DecimalFormatSymbols(uLocale);
    }

    public Locale getLocale() {
        return this.requestedLocale;
    }

    public DecimalFormatSymbols(Locale locale) {
        this(ULocale.forLocale(locale));
    }

    public DecimalFormatSymbols() {
        this(ULocale.getDefault(ULocale.Category.FORMAT));
    }

    private DecimalFormatSymbols(Locale locale, NumberingSystem numberingSystem) {
        this(ULocale.forLocale(locale), numberingSystem);
    }

    private DecimalFormatSymbols(ULocale uLocale, NumberingSystem numberingSystem) {
        this.exponentMultiplicationSign = null;
        this.serialVersionOnStream = 10;
        this.currencyPattern = null;
        initialize(uLocale, numberingSystem);
    }
}
