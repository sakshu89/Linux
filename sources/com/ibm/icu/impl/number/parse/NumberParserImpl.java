package com.ibm.icu.impl.number.parse;

import com.ibm.icu.impl.StringSegment;
import com.ibm.icu.impl.number.AffixPatternProvider;
import com.ibm.icu.impl.number.CustomSymbolCurrency;
import com.ibm.icu.impl.number.DecimalFormatProperties;
import com.ibm.icu.impl.number.Grouper;
import com.ibm.icu.impl.number.PatternStringParser;
import com.ibm.icu.impl.number.PropertiesAffixPatternProvider;
import com.ibm.icu.impl.number.RoundingUtils;
import com.ibm.icu.number.NumberFormatter;
import com.ibm.icu.number.Scale;
import com.ibm.icu.text.DecimalFormatSymbols;
import com.ibm.icu.util.Currency;
import com.ibm.icu.util.CurrencyAmount;
import com.ibm.icu.util.ULocale;
import defpackage.cq;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class NumberParserImpl {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final int parseFlags;
    private final List<NumberParseMatcher> matchers = new ArrayList();
    private boolean frozen = false;

    public NumberParserImpl(int i) {
        this.parseFlags = i;
    }

    public static NumberParserImpl createDefaultParserForLocale(ULocale uLocale) {
        return createParserFromProperties(PatternStringParser.parseToProperties("0"), DecimalFormatSymbols.getInstance(uLocale), false);
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0053  */
    /* JADX WARN: Code duplicated, block: B:28:0x005d  */
    /* JADX WARN: Code duplicated, block: B:30:0x0061  */
    /* JADX WARN: Code duplicated, block: B:35:0x0086  */
    /* JADX WARN: Code duplicated, block: B:47:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:57:0x0102  */
    /* JADX WARN: Code duplicated, block: B:60:0x0113  */
    /* JADX WARN: Code duplicated, block: B:62:0x011d  */
    /* JADX WARN: Code duplicated, block: B:65:0x012b  */
    /* JADX WARN: Code duplicated, block: B:74:0x0146  */
    public static NumberParserImpl createParserFromProperties(DecimalFormatProperties decimalFormatProperties, DecimalFormatSymbols decimalFormatSymbols, boolean z) {
        int i;
        int i2;
        NumberParserImpl numberParserImpl;
        DecimalFormatProperties.ParseMode parseMode;
        String padString;
        Scale scaleScaleFromProperties;
        ULocale uLocale = decimalFormatSymbols.getULocale();
        AffixPatternProvider affixPatternProviderForProperties = PropertiesAffixPatternProvider.forProperties(decimalFormatProperties);
        Currency currencyResolve = CustomSymbolCurrency.resolve(decimalFormatProperties.getCurrency(), uLocale, decimalFormatSymbols);
        DecimalFormatProperties.ParseMode parseMode2 = decimalFormatProperties.getParseMode();
        if (parseMode2 == null) {
            parseMode2 = DecimalFormatProperties.ParseMode.LENIENT;
        }
        Grouper grouperForProperties = Grouper.forProperties(decimalFormatProperties);
        boolean z2 = true;
        int i3 = !decimalFormatProperties.getParseCaseSensitive() ? 1 : 0;
        if (decimalFormatProperties.getParseIntegerOnly()) {
            i3 |= 16;
        }
        if (decimalFormatProperties.getParseToBigDecimal()) {
            i3 |= 4096;
        }
        if (decimalFormatProperties.getSignAlwaysShown()) {
            i3 |= 1024;
        }
        if (parseMode2 != DecimalFormatProperties.ParseMode.JAVA_COMPATIBILITY) {
            if (parseMode2 == DecimalFormatProperties.ParseMode.STRICT) {
                i2 = 33548;
            } else {
                i = i3 | 128;
            }
            if (grouperForProperties.getPrimary() <= 0) {
                i |= 32;
            }
            if (z || affixPatternProviderForProperties.hasCurrencySign()) {
                i |= 2;
            }
            if (!z) {
                i |= 8192;
            }
            numberParserImpl = new NumberParserImpl(i);
            IgnorablesMatcher ignorablesMatcher = IgnorablesMatcher.getInstance(i);
            AffixTokenMatcherFactory affixTokenMatcherFactory = new AffixTokenMatcherFactory();
            affixTokenMatcherFactory.currency = currencyResolve;
            affixTokenMatcherFactory.symbols = decimalFormatSymbols;
            affixTokenMatcherFactory.ignorables = ignorablesMatcher;
            affixTokenMatcherFactory.locale = uLocale;
            affixTokenMatcherFactory.parseFlags = i;
            AffixMatcher.createMatchers(affixPatternProviderForProperties, numberParserImpl, affixTokenMatcherFactory, ignorablesMatcher, i);
            if (z || affixPatternProviderForProperties.hasCurrencySign()) {
                numberParserImpl.addMatcher(CombinedCurrencyMatcher.getInstance(currencyResolve, decimalFormatSymbols, i));
            }
            parseMode = DecimalFormatProperties.ParseMode.LENIENT;
            if (parseMode2 == parseMode && affixPatternProviderForProperties.containsSymbolType(-4)) {
                numberParserImpl.addMatcher(PercentMatcher.getInstance(decimalFormatSymbols));
            }
            if (parseMode2 == parseMode && affixPatternProviderForProperties.containsSymbolType(-5)) {
                numberParserImpl.addMatcher(PermilleMatcher.getInstance(decimalFormatSymbols));
            }
            if (parseMode2 == parseMode) {
                numberParserImpl.addMatcher(PlusSignMatcher.getInstance(decimalFormatSymbols, false));
                numberParserImpl.addMatcher(MinusSignMatcher.getInstance(decimalFormatSymbols, false));
                numberParserImpl.addMatcher(ApproximatelySignMatcher.getInstance(decimalFormatSymbols, false));
            }
            numberParserImpl.addMatcher(NanMatcher.getInstance(decimalFormatSymbols, i));
            numberParserImpl.addMatcher(InfinityMatcher.getInstance(decimalFormatSymbols));
            padString = decimalFormatProperties.getPadString();
            if (padString != null && !ignorablesMatcher.getSet().contains(padString)) {
                numberParserImpl.addMatcher(PaddingMatcher.getInstance(padString));
            }
            numberParserImpl.addMatcher(ignorablesMatcher);
            numberParserImpl.addMatcher(DecimalMatcher.getInstance(decimalFormatSymbols, grouperForProperties, i));
            if (decimalFormatProperties.getParseNoExponent() || decimalFormatProperties.getMinimumExponentDigits() > 0) {
                numberParserImpl.addMatcher(ScientificMatcher.getInstance(decimalFormatSymbols, grouperForProperties));
            }
            numberParserImpl.addMatcher(new RequireNumberValidator());
            if (parseMode2 != parseMode) {
                numberParserImpl.addMatcher(new RequireAffixValidator());
            }
            if (z) {
                numberParserImpl.addMatcher(new RequireCurrencyValidator());
            }
            if (decimalFormatProperties.getDecimalPatternMatchRequired()) {
                if (!decimalFormatProperties.getDecimalSeparatorAlwaysShown() && decimalFormatProperties.getMaximumFractionDigits() == 0) {
                    z2 = false;
                }
                numberParserImpl.addMatcher(RequireDecimalSeparatorValidator.getInstance(z2));
            }
            scaleScaleFromProperties = RoundingUtils.scaleFromProperties(decimalFormatProperties);
            if (scaleScaleFromProperties != null) {
                numberParserImpl.addMatcher(new MultiplierParseHandler(scaleScaleFromProperties));
            }
            numberParserImpl.freeze();
            return numberParserImpl;
        }
        i2 = 66308;
        i = i3 | i2;
        if (grouperForProperties.getPrimary() <= 0) {
            i |= 32;
        }
        if (z) {
            i |= 2;
        } else {
            i |= 2;
        }
        if (!z) {
            i |= 8192;
        }
        numberParserImpl = new NumberParserImpl(i);
        IgnorablesMatcher ignorablesMatcher2 = IgnorablesMatcher.getInstance(i);
        AffixTokenMatcherFactory affixTokenMatcherFactory2 = new AffixTokenMatcherFactory();
        affixTokenMatcherFactory2.currency = currencyResolve;
        affixTokenMatcherFactory2.symbols = decimalFormatSymbols;
        affixTokenMatcherFactory2.ignorables = ignorablesMatcher2;
        affixTokenMatcherFactory2.locale = uLocale;
        affixTokenMatcherFactory2.parseFlags = i;
        AffixMatcher.createMatchers(affixPatternProviderForProperties, numberParserImpl, affixTokenMatcherFactory2, ignorablesMatcher2, i);
        if (z) {
            numberParserImpl.addMatcher(CombinedCurrencyMatcher.getInstance(currencyResolve, decimalFormatSymbols, i));
        } else {
            numberParserImpl.addMatcher(CombinedCurrencyMatcher.getInstance(currencyResolve, decimalFormatSymbols, i));
        }
        parseMode = DecimalFormatProperties.ParseMode.LENIENT;
        if (parseMode2 == parseMode) {
            numberParserImpl.addMatcher(PercentMatcher.getInstance(decimalFormatSymbols));
        }
        if (parseMode2 == parseMode) {
            numberParserImpl.addMatcher(PermilleMatcher.getInstance(decimalFormatSymbols));
        }
        if (parseMode2 == parseMode) {
            numberParserImpl.addMatcher(PlusSignMatcher.getInstance(decimalFormatSymbols, false));
            numberParserImpl.addMatcher(MinusSignMatcher.getInstance(decimalFormatSymbols, false));
            numberParserImpl.addMatcher(ApproximatelySignMatcher.getInstance(decimalFormatSymbols, false));
        }
        numberParserImpl.addMatcher(NanMatcher.getInstance(decimalFormatSymbols, i));
        numberParserImpl.addMatcher(InfinityMatcher.getInstance(decimalFormatSymbols));
        padString = decimalFormatProperties.getPadString();
        if (padString != null) {
            numberParserImpl.addMatcher(PaddingMatcher.getInstance(padString));
        }
        numberParserImpl.addMatcher(ignorablesMatcher2);
        numberParserImpl.addMatcher(DecimalMatcher.getInstance(decimalFormatSymbols, grouperForProperties, i));
        if (decimalFormatProperties.getParseNoExponent()) {
            numberParserImpl.addMatcher(ScientificMatcher.getInstance(decimalFormatSymbols, grouperForProperties));
        } else {
            numberParserImpl.addMatcher(ScientificMatcher.getInstance(decimalFormatSymbols, grouperForProperties));
        }
        numberParserImpl.addMatcher(new RequireNumberValidator());
        if (parseMode2 != parseMode) {
            numberParserImpl.addMatcher(new RequireAffixValidator());
        }
        if (z) {
            numberParserImpl.addMatcher(new RequireCurrencyValidator());
        }
        if (decimalFormatProperties.getDecimalPatternMatchRequired()) {
            if (!decimalFormatProperties.getDecimalSeparatorAlwaysShown()) {
                z2 = false;
            }
            numberParserImpl.addMatcher(RequireDecimalSeparatorValidator.getInstance(z2));
        }
        scaleScaleFromProperties = RoundingUtils.scaleFromProperties(decimalFormatProperties);
        if (scaleScaleFromProperties != null) {
            numberParserImpl.addMatcher(new MultiplierParseHandler(scaleScaleFromProperties));
        }
        numberParserImpl.freeze();
        return numberParserImpl;
    }

    public static NumberParserImpl createSimpleParser(ULocale uLocale, String str, int i) {
        NumberParserImpl numberParserImpl = new NumberParserImpl(i);
        Currency currency = Currency.getInstance("USD");
        DecimalFormatSymbols decimalFormatSymbols = DecimalFormatSymbols.getInstance(uLocale);
        IgnorablesMatcher ignorablesMatcher = IgnorablesMatcher.getInstance(i);
        AffixTokenMatcherFactory affixTokenMatcherFactory = new AffixTokenMatcherFactory();
        affixTokenMatcherFactory.currency = currency;
        affixTokenMatcherFactory.symbols = decimalFormatSymbols;
        affixTokenMatcherFactory.ignorables = ignorablesMatcher;
        affixTokenMatcherFactory.locale = uLocale;
        affixTokenMatcherFactory.parseFlags = i;
        PatternStringParser.ParsedPatternInfo toPatternInfo = PatternStringParser.parseToPatternInfo(str);
        AffixMatcher.createMatchers(toPatternInfo, numberParserImpl, affixTokenMatcherFactory, ignorablesMatcher, i);
        Grouper grouperWithLocaleData = Grouper.forStrategy(NumberFormatter.GroupingStrategy.AUTO).withLocaleData(uLocale, toPatternInfo);
        numberParserImpl.addMatcher(ignorablesMatcher);
        numberParserImpl.addMatcher(DecimalMatcher.getInstance(decimalFormatSymbols, grouperWithLocaleData, i));
        numberParserImpl.addMatcher(MinusSignMatcher.getInstance(decimalFormatSymbols, false));
        numberParserImpl.addMatcher(PlusSignMatcher.getInstance(decimalFormatSymbols, false));
        numberParserImpl.addMatcher(ApproximatelySignMatcher.getInstance(decimalFormatSymbols, false));
        numberParserImpl.addMatcher(PercentMatcher.getInstance(decimalFormatSymbols));
        numberParserImpl.addMatcher(PermilleMatcher.getInstance(decimalFormatSymbols));
        numberParserImpl.addMatcher(NanMatcher.getInstance(decimalFormatSymbols, i));
        numberParserImpl.addMatcher(InfinityMatcher.getInstance(decimalFormatSymbols));
        numberParserImpl.addMatcher(PaddingMatcher.getInstance("@"));
        numberParserImpl.addMatcher(ScientificMatcher.getInstance(decimalFormatSymbols, grouperWithLocaleData));
        numberParserImpl.addMatcher(CombinedCurrencyMatcher.getInstance(currency, decimalFormatSymbols, i));
        numberParserImpl.addMatcher(new RequireNumberValidator());
        numberParserImpl.freeze();
        return numberParserImpl;
    }

    private void parseGreedy(StringSegment stringSegment, ParsedNumber parsedNumber) {
        while (true) {
            for (int i = 0; i < this.matchers.size() && stringSegment.length() != 0; i++) {
                NumberParseMatcher numberParseMatcher = this.matchers.get(i);
                if (numberParseMatcher.smokeTest(stringSegment)) {
                    int offset = stringSegment.getOffset();
                    numberParseMatcher.match(stringSegment, parsedNumber);
                    if (stringSegment.getOffset() != offset) {
                    }
                }
            }
            return;
        }
    }

    private void parseLongestRecursive(StringSegment stringSegment, ParsedNumber parsedNumber, int i) {
        if (stringSegment.length() == 0 || i == 0) {
            return;
        }
        ParsedNumber parsedNumber2 = new ParsedNumber();
        parsedNumber2.copyFrom(parsedNumber);
        ParsedNumber parsedNumber3 = new ParsedNumber();
        int offset = stringSegment.getOffset();
        for (int i2 = 0; i2 < this.matchers.size(); i2++) {
            NumberParseMatcher numberParseMatcher = this.matchers.get(i2);
            if (numberParseMatcher.smokeTest(stringSegment)) {
                int iCharCount = 0;
                while (iCharCount < stringSegment.length()) {
                    iCharCount += Character.charCount(stringSegment.codePointAt(iCharCount));
                    parsedNumber3.copyFrom(parsedNumber2);
                    stringSegment.setLength(iCharCount);
                    boolean zMatch = numberParseMatcher.match(stringSegment, parsedNumber3);
                    stringSegment.resetLength();
                    if (stringSegment.getOffset() - offset == iCharCount) {
                        parseLongestRecursive(stringSegment, parsedNumber3, i + 1);
                        if (parsedNumber3.isBetterThan(parsedNumber)) {
                            parsedNumber.copyFrom(parsedNumber3);
                        }
                    }
                    stringSegment.setOffset(offset);
                    if (!zMatch) {
                        break;
                    }
                }
            }
        }
    }

    public static Number parseStatic(String str, ParsePosition parsePosition, DecimalFormatProperties decimalFormatProperties, DecimalFormatSymbols decimalFormatSymbols) {
        NumberParserImpl numberParserImplCreateParserFromProperties = createParserFromProperties(decimalFormatProperties, decimalFormatSymbols, false);
        ParsedNumber parsedNumber = new ParsedNumber();
        numberParserImplCreateParserFromProperties.parse(str, true, parsedNumber);
        boolean zSuccess = parsedNumber.success();
        int i = parsedNumber.charEnd;
        if (zSuccess) {
            parsePosition.setIndex(i);
            return parsedNumber.getNumber();
        }
        parsePosition.setErrorIndex(i);
        return null;
    }

    public static CurrencyAmount parseStaticCurrency(String str, ParsePosition parsePosition, DecimalFormatProperties decimalFormatProperties, DecimalFormatSymbols decimalFormatSymbols) {
        NumberParserImpl numberParserImplCreateParserFromProperties = createParserFromProperties(decimalFormatProperties, decimalFormatSymbols, true);
        ParsedNumber parsedNumber = new ParsedNumber();
        numberParserImplCreateParserFromProperties.parse(str, true, parsedNumber);
        boolean zSuccess = parsedNumber.success();
        int i = parsedNumber.charEnd;
        if (zSuccess) {
            parsePosition.setIndex(i);
            return new CurrencyAmount(parsedNumber.getNumber(), Currency.getInstance(parsedNumber.currencyCode));
        }
        parsePosition.setErrorIndex(i);
        return null;
    }

    public void addMatcher(NumberParseMatcher numberParseMatcher) {
        this.matchers.add(numberParseMatcher);
    }

    public void addMatchers(Collection<? extends NumberParseMatcher> collection) {
        this.matchers.addAll(collection);
    }

    public void freeze() {
        this.frozen = true;
    }

    public int getParseFlags() {
        return this.parseFlags;
    }

    public void parse(String str, int i, boolean z, ParsedNumber parsedNumber) {
        StringSegment stringSegment = new StringSegment(str, (this.parseFlags & 1) != 0);
        stringSegment.adjustOffset(i);
        if (z) {
            parseGreedy(stringSegment, parsedNumber);
        } else if ((this.parseFlags & 16384) != 0) {
            parseLongestRecursive(stringSegment, parsedNumber, 1);
        } else {
            parseLongestRecursive(stringSegment, parsedNumber, -100);
        }
        Iterator<NumberParseMatcher> it = this.matchers.iterator();
        while (it.hasNext()) {
            it.next().postProcess(parsedNumber);
        }
        parsedNumber.postProcess();
    }

    public String toString() {
        return cq.v("<NumberParserImpl matchers=", this.matchers.toString(), ">");
    }

    public void parse(String str, boolean z, ParsedNumber parsedNumber) {
        parse(str, 0, z, parsedNumber);
    }
}
