package com.ibm.icu.text;

import com.ibm.icu.impl.CacheBase;
import com.ibm.icu.impl.ICUData;
import com.ibm.icu.impl.ICUResourceBundle;
import com.ibm.icu.impl.SoftCache;
import com.ibm.icu.impl.units.UnitsData;
import com.ibm.icu.util.ULocale;
import com.ibm.icu.util.UResourceBundle;
import com.ibm.icu.util.UResourceBundleIterator;
import defpackage.cq;
import defpackage.og;
import java.util.ArrayList;
import java.util.Locale;
import java.util.MissingResourceException;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class NumberingSystem {
    private static final String[] OTHER_NS_KEYWORDS = {"native", "traditional", "finance"};
    public static final NumberingSystem LATIN = lookupInstanceByName("latn");
    private static CacheBase<String, NumberingSystem, LocaleLookupData> cachedLocaleData = new SoftCache<String, NumberingSystem, LocaleLookupData>() { // from class: com.ibm.icu.text.NumberingSystem.1
        @Override // com.ibm.icu.impl.CacheBase
        public NumberingSystem createInstance(String str, LocaleLookupData localeLookupData) {
            return NumberingSystem.lookupInstanceByLocale(localeLookupData);
        }
    };
    private static CacheBase<String, NumberingSystem, Void> cachedStringData = new SoftCache<String, NumberingSystem, Void>() { // from class: com.ibm.icu.text.NumberingSystem.2
        @Override // com.ibm.icu.impl.CacheBase
        public NumberingSystem createInstance(String str, Void r2) {
            return NumberingSystem.lookupInstanceByName(str);
        }
    };
    private int radix = 10;
    private boolean algorithmic = false;
    private String desc = "0123456789";
    private String name = "latn";

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class LocaleLookupData {
        public final ULocale locale;
        public final String numbersKeyword;

        public LocaleLookupData(ULocale uLocale, String str) {
            this.locale = uLocale;
            this.numbersKeyword = str;
        }
    }

    public static String[] getAvailableNames() {
        UResourceBundle uResourceBundle = UResourceBundle.getBundleInstance(ICUData.ICU_BASE_NAME, "numberingSystems").get("numberingSystems");
        ArrayList arrayList = new ArrayList();
        UResourceBundleIterator iterator = uResourceBundle.getIterator();
        while (iterator.hasNext()) {
            arrayList.add(iterator.next().getKey());
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static NumberingSystem getInstance(ULocale uLocale) {
        String keywordValue = uLocale.getKeywordValue("numbers");
        String str = UnitsData.Constants.DEFAULT_USAGE;
        boolean z = false;
        if (keywordValue != null) {
            String[] strArr = OTHER_NS_KEYWORDS;
            int length = strArr.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    z = true;
                    break;
                }
                if (keywordValue.equals(strArr[i])) {
                    break;
                }
                i++;
            }
        } else {
            keywordValue = UnitsData.Constants.DEFAULT_USAGE;
        }
        if (z) {
            NumberingSystem instanceByName = getInstanceByName(keywordValue);
            if (instanceByName != null) {
                return instanceByName;
            }
        } else {
            str = keywordValue;
        }
        return cachedLocaleData.getInstance(cq.k(uLocale.getBaseName(), "@numbers=", str), new LocaleLookupData(uLocale, str));
    }

    public static NumberingSystem getInstanceByName(String str) {
        return cachedStringData.getInstance(str, null);
    }

    public static boolean isValidDigitString(String str) {
        return str.codePointCount(0, str.length()) == 10;
    }

    public static NumberingSystem lookupInstanceByLocale(LocaleLookupData localeLookupData) {
        String stringWithFallback;
        try {
            ICUResourceBundle withFallback = ((ICUResourceBundle) UResourceBundle.getBundleInstance(ICUData.ICU_BASE_NAME, localeLookupData.locale)).getWithFallback("NumberElements");
            String str = localeLookupData.numbersKeyword;
            while (true) {
                try {
                    stringWithFallback = withFallback.getStringWithFallback(str);
                    break;
                } catch (MissingResourceException unused) {
                    if (!str.equals("native") && !str.equals("finance")) {
                        if (!str.equals("traditional")) {
                            stringWithFallback = null;
                            break;
                        }
                        str = "native";
                    } else {
                        str = UnitsData.Constants.DEFAULT_USAGE;
                    }
                }
            }
            NumberingSystem instanceByName = stringWithFallback != null ? getInstanceByName(stringWithFallback) : null;
            return instanceByName == null ? new NumberingSystem() : instanceByName;
        } catch (MissingResourceException unused2) {
            return new NumberingSystem();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static NumberingSystem lookupInstanceByName(String str) {
        try {
            UResourceBundle uResourceBundle = UResourceBundle.getBundleInstance(ICUData.ICU_BASE_NAME, "numberingSystems").get("numberingSystems").get(str);
            return getInstance(str, uResourceBundle.get("radix").getInt(), uResourceBundle.get("algorithmic").getInt() == 1, uResourceBundle.getString("desc"));
        } catch (MissingResourceException unused) {
            return null;
        }
    }

    public String getDescription() {
        return this.desc;
    }

    public String getName() {
        return this.name;
    }

    public int getRadix() {
        return this.radix;
    }

    public boolean isAlgorithmic() {
        return this.algorithmic;
    }

    private static NumberingSystem getInstance(String str, int i, boolean z, String str2) {
        if (i >= 2) {
            if (!z && (str2.codePointCount(0, str2.length()) != i || !isValidDigitString(str2))) {
                og.i("Invalid digit string for numbering system");
                return null;
            }
            NumberingSystem numberingSystem = new NumberingSystem();
            numberingSystem.radix = i;
            numberingSystem.algorithmic = z;
            numberingSystem.desc = str2;
            numberingSystem.name = str;
            return numberingSystem;
        }
        og.i("Invalid radix for numbering system");
        return null;
    }

    public static NumberingSystem getInstance(Locale locale) {
        return getInstance(ULocale.forLocale(locale));
    }

    public static NumberingSystem getInstance(int i, boolean z, String str) {
        return getInstance(null, i, z, str);
    }

    public static NumberingSystem getInstance() {
        return getInstance(ULocale.getDefault(ULocale.Category.FORMAT));
    }
}
