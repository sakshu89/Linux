package com.ibm.icu.util;

import com.ibm.icu.impl.CacheBase;
import com.ibm.icu.impl.ICUCache;
import com.ibm.icu.impl.ICUData;
import com.ibm.icu.impl.ICUDebug;
import com.ibm.icu.impl.ICULocaleService;
import com.ibm.icu.impl.ICUResourceBundle;
import com.ibm.icu.impl.SimpleCache;
import com.ibm.icu.impl.SoftCache;
import com.ibm.icu.impl.StaticUnicodeSets;
import com.ibm.icu.impl.TextTrieMap;
import com.ibm.icu.text.CurrencyDisplayNames;
import com.ibm.icu.text.CurrencyMetaInfo;
import defpackage.dk0;
import defpackage.ky0;
import defpackage.og;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class Currency extends MeasureUnit {
    public static final int FORMAL_SYMBOL_NAME = 4;
    public static final int LONG_NAME = 1;
    public static final int NARROW_SYMBOL_NAME = 3;
    public static final int PLURAL_LONG_NAME = 2;
    public static final int SYMBOL_NAME = 0;
    public static final int VARIANT_SYMBOL_NAME = 5;
    private static final long serialVersionUID = -5839973855554750484L;
    private static ServiceShim shim;
    private final String isoCode;
    private static final boolean DEBUG = ICUDebug.enabled("currency");
    private static final ICUCache<ULocale, List<TextTrieMap<CurrencyStringInfo>>> CURRENCY_NAME_CACHE = new SimpleCache();
    private static final CacheBase<String, Currency, Void> regionCurrencyCache = new SoftCache<String, Currency, Void>() { // from class: com.ibm.icu.util.Currency.1
        @Override // com.ibm.icu.impl.CacheBase
        public Currency createInstance(String str, Void r2) {
            return Currency.loadCurrency(str);
        }
    };
    private static final ULocale UND = new ULocale("und");
    private static final String[] EMPTY_STRING_ARRAY = new String[0];
    private static final int[] POW10 = {1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000};

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class AllCodesAsSetHolder {
        static final Set<String> ALL_CODES_AS_SET;

        static {
            List<String> listCurrencies = CurrencyMetaInfo.getInstance().currencies(CurrencyMetaInfo.CurrencyFilter.all());
            HashSet hashSet = new HashSet(listCurrencies.size());
            for (String str : listCurrencies) {
                Objects.requireNonNull(str);
                hashSet.add(str);
            }
            ALL_CODES_AS_SET = Collections.unmodifiableSet(hashSet);
        }

        private AllCodesAsSetHolder() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class AllTenderCodesHolder {
        static final List<String> ALL_TENDER_CODES;

        static {
            List tenderCurrencies = Currency.getTenderCurrencies(CurrencyMetaInfo.CurrencyFilter.all());
            ArrayList arrayList = new ArrayList(tenderCurrencies.size());
            for (Object obj : tenderCurrencies) {
                Objects.requireNonNull(obj);
                arrayList.add(obj);
            }
            ALL_TENDER_CODES = Collections.unmodifiableList(arrayList);
        }

        private AllTenderCodesHolder() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    @Deprecated
    public static final class CurrencyStringInfo {
        private String currencyString;
        private String isoCode;

        @Deprecated
        public CurrencyStringInfo(String str, String str2) {
            this.isoCode = str;
            this.currencyString = str2;
        }

        @Deprecated
        public String getCurrencyString() {
            return this.currencyString;
        }

        @Deprecated
        public String getISOCode() {
            return this.isoCode;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public enum CurrencyUsage {
        STANDARD,
        CASH
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static abstract class ServiceShim {
        public abstract Currency createInstance(ULocale uLocale);

        public abstract Locale[] getAvailableLocales();

        public abstract ULocale[] getAvailableULocales();

        public abstract Object registerInstance(Currency currency, ULocale uLocale);

        public abstract boolean unregister(Object obj);
    }

    public Currency(String str) {
        super("currency", str);
        this.isoCode = str;
    }

    public static Currency createCurrency(ULocale uLocale) {
        return regionCurrencyCache.getInstance(ULocale.getRegionForSupplementalData(uLocale, false), null);
    }

    public static Currency fromJavaCurrency(java.util.Currency currency) {
        return getInstance(currency.getCurrencyCode());
    }

    private static Set<String> getAllCurrenciesAsSet() {
        return AllCodesAsSetHolder.ALL_CODES_AS_SET;
    }

    private static List<String> getAllTenderCurrencies() {
        return AllTenderCodesHolder.ALL_TENDER_CODES;
    }

    public static Set<Currency> getAvailableCurrencies() {
        List<String> listCurrencies = CurrencyMetaInfo.getInstance().currencies(CurrencyMetaInfo.CurrencyFilter.all());
        HashSet hashSet = new HashSet(listCurrencies.size());
        Iterator<String> it = listCurrencies.iterator();
        while (it.hasNext()) {
            hashSet.add(getInstance(it.next()));
        }
        return hashSet;
    }

    public static String[] getAvailableCurrencyCodes(ULocale uLocale, Date date) {
        List<String> tenderCurrencies = getTenderCurrencies(CurrencyMetaInfo.CurrencyFilter.onDate(date).withRegion(ULocale.getRegionForSupplementalData(uLocale, false)));
        if (tenderCurrencies.isEmpty()) {
            return null;
        }
        return (String[]) tenderCurrencies.toArray(new String[tenderCurrencies.size()]);
    }

    public static Locale[] getAvailableLocales() {
        ServiceShim serviceShim = shim;
        return serviceShim == null ? ICUResourceBundle.getAvailableLocales() : serviceShim.getAvailableLocales();
    }

    public static ULocale[] getAvailableULocales() {
        ServiceShim serviceShim = shim;
        return serviceShim == null ? ICUResourceBundle.getAvailableULocales() : serviceShim.getAvailableULocales();
    }

    private static List<TextTrieMap<CurrencyStringInfo>> getCurrencyTrieVec(ULocale uLocale) {
        ICUCache<ULocale, List<TextTrieMap<CurrencyStringInfo>>> iCUCache = CURRENCY_NAME_CACHE;
        List<TextTrieMap<CurrencyStringInfo>> list = iCUCache.get(uLocale);
        if (list != null) {
            return list;
        }
        TextTrieMap textTrieMap = new TextTrieMap(true);
        TextTrieMap textTrieMap2 = new TextTrieMap(false);
        ArrayList arrayList = new ArrayList();
        arrayList.add(textTrieMap2);
        arrayList.add(textTrieMap);
        setupCurrencyTrieVec(uLocale, arrayList);
        iCUCache.put(uLocale, arrayList);
        return arrayList;
    }

    public static Currency getInstance(String str) {
        if (str == null) {
            dk0.n("The input currency code is null.");
            return null;
        }
        if (isAlpha3Code(str)) {
            return (Currency) MeasureUnit.internalGetInstance("currency", str.toUpperCase(Locale.ENGLISH));
        }
        og.i("The input currency code is not 3-letter alphabetic code.");
        return null;
    }

    public static final String[] getKeywordValuesForLocale(String str, ULocale uLocale, boolean z) {
        if (!"currency".equals(str)) {
            return EMPTY_STRING_ARRAY;
        }
        if (!z) {
            return (String[]) getAllTenderCurrencies().toArray(new String[0]);
        }
        if (UND.equals(uLocale)) {
            return EMPTY_STRING_ARRAY;
        }
        List<String> tenderCurrencies = getTenderCurrencies(CurrencyMetaInfo.CurrencyFilter.now().withRegion(ULocale.getRegionForSupplementalData(uLocale, true)));
        return tenderCurrencies.size() == 0 ? EMPTY_STRING_ARRAY : (String[]) tenderCurrencies.toArray(new String[tenderCurrencies.size()]);
    }

    @Deprecated
    public static TextTrieMap<CurrencyStringInfo> getParsingTrie(ULocale uLocale, int i) {
        List<TextTrieMap<CurrencyStringInfo>> currencyTrieVec = getCurrencyTrieVec(uLocale);
        return i == 1 ? currencyTrieVec.get(1) : currencyTrieVec.get(0);
    }

    private static ServiceShim getShim() {
        if (shim == null) {
            try {
                ICULocaleService iCULocaleService = CurrencyServiceShim.service;
                shim = (ServiceShim) CurrencyServiceShim.class.newInstance();
            } catch (Exception e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
                og.p(e.getMessage());
                return null;
            }
        }
        return shim;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<String> getTenderCurrencies(CurrencyMetaInfo.CurrencyFilter currencyFilter) {
        return CurrencyMetaInfo.getInstance().currencies(currencyFilter.withTender());
    }

    private static boolean isAlpha3Code(String str) {
        if (str.length() != 3) {
            return false;
        }
        for (int i = 0; i < 3; i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt < 'A' || ((cCharAt > 'Z' && cCharAt < 'a') || cCharAt > 'z')) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAvailable(String str, Date date, Date date2) {
        if (!isAlpha3Code(str)) {
            return false;
        }
        if (date != null && date2 != null && date.after(date2)) {
            og.i("To is before from");
            return false;
        }
        String upperCase = str.toUpperCase(Locale.ENGLISH);
        if (!getAllCurrenciesAsSet().contains(upperCase)) {
            return false;
        }
        if (date == null && date2 == null) {
            return true;
        }
        return CurrencyMetaInfo.getInstance().currencies(CurrencyMetaInfo.CurrencyFilter.onDateRange(date, date2).withCurrency(upperCase)).contains(upperCase);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Currency loadCurrency(String str) {
        CurrencyMetaInfo currencyMetaInfo = CurrencyMetaInfo.getInstance();
        List<String> listCurrencies = currencyMetaInfo.currencies(CurrencyMetaInfo.CurrencyFilter.onRegion(str).withTender());
        if (listCurrencies.isEmpty()) {
            listCurrencies = currencyMetaInfo.currencies(CurrencyMetaInfo.CurrencyFilter.onRegion(str));
        }
        if (listCurrencies.isEmpty()) {
            return null;
        }
        return getInstance(listCurrencies.get(0));
    }

    @Deprecated
    public static String parse(ULocale uLocale, String str, int i, ParsePosition parsePosition) {
        List<TextTrieMap<CurrencyStringInfo>> currencyTrieVec = getCurrencyTrieVec(uLocale);
        TextTrieMap textTrieMap = currencyTrieVec.get(1);
        int i2 = 0;
        CurrencyNameResultHandler currencyNameResultHandler = new CurrencyNameResultHandler(i2);
        textTrieMap.find(str, parsePosition.getIndex(), currencyNameResultHandler);
        String bestCurrencyISOCode = currencyNameResultHandler.getBestCurrencyISOCode();
        int bestMatchLength = currencyNameResultHandler.getBestMatchLength();
        if (i != 1) {
            TextTrieMap textTrieMap2 = currencyTrieVec.get(0);
            CurrencyNameResultHandler currencyNameResultHandler2 = new CurrencyNameResultHandler(i2);
            textTrieMap2.find(str, parsePosition.getIndex(), currencyNameResultHandler2);
            if (currencyNameResultHandler2.getBestMatchLength() > bestMatchLength) {
                bestCurrencyISOCode = currencyNameResultHandler2.getBestCurrencyISOCode();
                bestMatchLength = currencyNameResultHandler2.getBestMatchLength();
            }
        }
        parsePosition.setIndex(parsePosition.getIndex() + bestMatchLength);
        return bestCurrencyISOCode;
    }

    private Object readResolve() {
        return getInstance(this.isoCode);
    }

    public static Object registerInstance(Currency currency, ULocale uLocale) {
        return getShim().registerInstance(currency, uLocale);
    }

    private static void setupCurrencyTrieVec(ULocale uLocale, List<TextTrieMap<CurrencyStringInfo>> list) {
        TextTrieMap<CurrencyStringInfo> textTrieMap = list.get(0);
        TextTrieMap<CurrencyStringInfo> textTrieMap2 = list.get(1);
        CurrencyDisplayNames currencyDisplayNames = CurrencyDisplayNames.getInstance(uLocale);
        for (Map.Entry<String, String> entry : currencyDisplayNames.symbolMap().entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            StaticUnicodeSets.Key keyChooseCurrency = StaticUnicodeSets.chooseCurrency(key);
            CurrencyStringInfo currencyStringInfo = new CurrencyStringInfo(value, key);
            if (keyChooseCurrency != null) {
                Iterator<String> it = StaticUnicodeSets.get(keyChooseCurrency).iterator();
                while (it.hasNext()) {
                    textTrieMap.put(it.next(), currencyStringInfo);
                }
            } else {
                textTrieMap.put(key, currencyStringInfo);
            }
        }
        for (Map.Entry<String, String> entry2 : currencyDisplayNames.nameMap().entrySet()) {
            String key2 = entry2.getKey();
            textTrieMap2.put(key2, new CurrencyStringInfo(entry2.getValue(), key2));
        }
    }

    public static boolean unregister(Object obj) {
        if (obj == null) {
            og.i("registryKey must not be null");
            return false;
        }
        ServiceShim serviceShim = shim;
        if (serviceShim == null) {
            return false;
        }
        return serviceShim.unregister(obj);
    }

    private Object writeReplace() {
        return new MeasureUnit.MeasureUnitProxy(this.type, this.subType);
    }

    public String getCurrencyCode() {
        return this.subType;
    }

    public int getDefaultFractionDigits(CurrencyUsage currencyUsage) {
        return CurrencyMetaInfo.getInstance().currencyDigits(this.subType, currencyUsage).fractionDigits;
    }

    public String getDisplayName() {
        return getName(Locale.getDefault(), 1, (boolean[]) null);
    }

    public String getName(ULocale uLocale, int i, boolean[] zArr) {
        if (zArr != null) {
            zArr[0] = false;
        }
        CurrencyDisplayNames currencyDisplayNames = CurrencyDisplayNames.getInstance(uLocale);
        if (i == 0) {
            return currencyDisplayNames.getSymbol(this.subType);
        }
        if (i == 1) {
            return currencyDisplayNames.getName(this.subType);
        }
        if (i == 3) {
            return currencyDisplayNames.getNarrowSymbol(this.subType);
        }
        if (i == 4) {
            return currencyDisplayNames.getFormalSymbol(this.subType);
        }
        if (i == 5) {
            return currencyDisplayNames.getVariantSymbol(this.subType);
        }
        og.i(ky0.h(i, "bad name style: "));
        return null;
    }

    public int getNumericCode() {
        try {
            return UResourceBundle.getBundleInstance(ICUData.ICU_BASE_NAME, "currencyNumericCodes", ICUResourceBundle.ICU_DATA_CLASS_LOADER).get("codeMap").get(this.subType).getInt();
        } catch (MissingResourceException unused) {
            return 0;
        }
    }

    public double getRoundingIncrement(CurrencyUsage currencyUsage) {
        int i;
        CurrencyMetaInfo.CurrencyDigits currencyDigits = CurrencyMetaInfo.getInstance().currencyDigits(this.subType, currencyUsage);
        int i2 = currencyDigits.roundingIncrement;
        if (i2 == 0 || (i = currencyDigits.fractionDigits) < 0) {
            return 0.0d;
        }
        int[] iArr = POW10;
        if (i >= iArr.length) {
            return 0.0d;
        }
        return ((double) i2) / ((double) iArr[i]);
    }

    public String getSymbol() {
        return getSymbol(ULocale.getDefault(ULocale.Category.DISPLAY));
    }

    public java.util.Currency toJavaCurrency() {
        return java.util.Currency.getInstance(getCurrencyCode());
    }

    @Override // com.ibm.icu.util.MeasureUnit
    public String toString() {
        return this.subType;
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class CurrencyNameResultHandler implements TextTrieMap.ResultHandler<CurrencyStringInfo> {
        private String bestCurrencyISOCode;
        private int bestMatchLength;

        public /* synthetic */ CurrencyNameResultHandler(int i) {
            this();
        }

        public String getBestCurrencyISOCode() {
            return this.bestCurrencyISOCode;
        }

        public int getBestMatchLength() {
            return this.bestMatchLength;
        }

        @Override // com.ibm.icu.impl.TextTrieMap.ResultHandler
        public boolean handlePrefixMatch(int i, Iterator<CurrencyStringInfo> it) {
            if (!it.hasNext()) {
                return true;
            }
            this.bestCurrencyISOCode = it.next().getISOCode();
            this.bestMatchLength = i;
            return true;
        }

        private CurrencyNameResultHandler() {
        }
    }

    public String getDisplayName(Locale locale) {
        return getName(locale, 1, (boolean[]) null);
    }

    public String getSymbol(Locale locale) {
        return getSymbol(ULocale.forLocale(locale));
    }

    public String getSymbol(ULocale uLocale) {
        return getName(uLocale, 0, (boolean[]) null);
    }

    public int getDefaultFractionDigits() {
        return getDefaultFractionDigits(CurrencyUsage.STANDARD);
    }

    public double getRoundingIncrement() {
        return getRoundingIncrement(CurrencyUsage.STANDARD);
    }

    public static Currency getInstance(ULocale uLocale) {
        String keywordValue = uLocale.getKeywordValue("currency");
        if (keywordValue != null) {
            return getInstance(keywordValue);
        }
        ServiceShim serviceShim = shim;
        if (serviceShim == null) {
            return createCurrency(uLocale);
        }
        return serviceShim.createInstance(uLocale);
    }

    public static String[] getAvailableCurrencyCodes(Locale locale, Date date) {
        return getAvailableCurrencyCodes(ULocale.forLocale(locale), date);
    }

    public static Currency getInstance(Locale locale) {
        return getInstance(ULocale.forLocale(locale));
    }

    public String getName(Locale locale, int i, boolean[] zArr) {
        return getName(ULocale.forLocale(locale), i, zArr);
    }

    public String getName(Locale locale, int i, String str, boolean[] zArr) {
        return getName(ULocale.forLocale(locale), i, str, zArr);
    }

    public String getName(ULocale uLocale, int i, String str, boolean[] zArr) {
        if (i != 2) {
            return getName(uLocale, i, zArr);
        }
        if (zArr != null) {
            zArr[0] = false;
        }
        return CurrencyDisplayNames.getInstance(uLocale).getPluralName(this.subType, str);
    }
}
