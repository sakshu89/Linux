package com.ibm.icu.text;

import com.ibm.icu.impl.ICUDebug;
import com.ibm.icu.impl.ICUResourceBundle;
import com.ibm.icu.impl.UResource;
import com.ibm.icu.impl.coll.CollationRoot;
import com.ibm.icu.impl.units.UnitsData;
import com.ibm.icu.lang.UCharacter;
import com.ibm.icu.lang.UProperty;
import com.ibm.icu.util.Freezable;
import com.ibm.icu.util.ICUException;
import com.ibm.icu.util.ULocale;
import com.ibm.icu.util.UResourceBundle;
import com.ibm.icu.util.VersionInfo;
import defpackage.cq;
import defpackage.dk0;
import defpackage.og;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class Collator implements Comparator<Object>, Freezable<Collator>, Cloneable {
    private static final String BASE = "com/ibm/icu/impl/data/icudata/coll";
    public static final int CANONICAL_DECOMPOSITION = 17;
    public static final int FULL_DECOMPOSITION = 15;
    public static final int IDENTICAL = 15;
    public static final int NO_DECOMPOSITION = 16;
    public static final int PRIMARY = 0;
    public static final int QUATERNARY = 3;
    private static final String RESOURCE = "collations";
    public static final int SECONDARY = 1;
    public static final int TERTIARY = 2;
    private static ServiceShim shim;
    private static final String[] KEYWORDS = {"collation"};
    private static final boolean DEBUG = ICUDebug.enabled("collator");

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class ASCII {
        private ASCII() {
        }

        public static boolean equalIgnoreCase(CharSequence charSequence, CharSequence charSequence2) {
            int length = charSequence.length();
            if (length != charSequence2.length()) {
                return false;
            }
            for (int i = 0; i < length; i++) {
                char cCharAt = charSequence.charAt(i);
                char cCharAt2 = charSequence2.charAt(i);
                if (cCharAt != cCharAt2) {
                    if ('A' > cCharAt || cCharAt > 'Z') {
                        if ('A' > cCharAt2 || cCharAt2 > 'Z' || cCharAt2 + ' ' != cCharAt) {
                            return false;
                        }
                    } else if (cCharAt + ' ' != cCharAt2) {
                        return false;
                    }
                }
            }
            return true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public interface ReorderCodes {
        public static final int CURRENCY = 4099;
        public static final int DEFAULT = -1;
        public static final int DIGIT = 4100;
        public static final int FIRST = 4096;

        @Deprecated
        public static final int LIMIT = 4101;
        public static final int NONE = 103;
        public static final int OTHERS = 103;
        public static final int PUNCTUATION = 4097;
        public static final int SPACE = 4096;
        public static final int SYMBOL = 4098;
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static abstract class ServiceShim {
        public abstract Locale[] getAvailableLocales();

        public abstract ULocale[] getAvailableULocales();

        public abstract String getDisplayName(ULocale uLocale, ULocale uLocale2);

        public abstract Collator getInstance(ULocale uLocale);

        public abstract Object registerFactory(CollatorFactory collatorFactory);

        public abstract Object registerInstance(Collator collator, ULocale uLocale);

        public abstract boolean unregister(Object obj);
    }

    private void checkNotFrozen() {
        if (isFrozen()) {
            dk0.r("Attempt to modify frozen Collator");
        }
    }

    public static Locale[] getAvailableLocales() {
        ServiceShim serviceShim = shim;
        return serviceShim == null ? ICUResourceBundle.getAvailableLocales("com/ibm/icu/impl/data/icudata/coll", ICUResourceBundle.ICU_DATA_CLASS_LOADER) : serviceShim.getAvailableLocales();
    }

    public static final ULocale[] getAvailableULocales() {
        ServiceShim serviceShim = shim;
        return serviceShim == null ? ICUResourceBundle.getAvailableULocales("com/ibm/icu/impl/data/icudata/coll", ICUResourceBundle.ICU_DATA_CLASS_LOADER) : serviceShim.getAvailableULocales();
    }

    public static String getDisplayName(Locale locale) {
        return getShim().getDisplayName(ULocale.forLocale(locale), ULocale.getDefault(ULocale.Category.DISPLAY));
    }

    public static int[] getEquivalentReorderCodes(int i) {
        return CollationRoot.getData().getEquivalentScripts(i);
    }

    public static final ULocale getFunctionalEquivalent(String str, ULocale uLocale, boolean[] zArr) {
        return ICUResourceBundle.getFunctionalEquivalent("com/ibm/icu/impl/data/icudata/coll", ICUResourceBundle.ICU_DATA_CLASS_LOADER, RESOURCE, str, uLocale, zArr, true);
    }

    public static final Collator getInstance(ULocale uLocale) {
        if (uLocale == null) {
            uLocale = ULocale.getDefault();
        }
        Collator serviceShim = getShim().getInstance(uLocale);
        if (!uLocale.getName().equals(uLocale.getBaseName())) {
            setAttributesFromKeywords(uLocale, serviceShim, serviceShim instanceof RuleBasedCollator ? (RuleBasedCollator) serviceShim : null);
        }
        return serviceShim;
    }

    private static final int getIntValue(String str, String str2, String... strArr) {
        for (int i = 0; i < strArr.length; i++) {
            if (ASCII.equalIgnoreCase(str2, strArr[i])) {
                return i;
            }
        }
        og.i(cq.l("illegal locale keyword=value: ", str, "=", str2));
        return 0;
    }

    public static final String[] getKeywordValues(String str) {
        if (str.equals(KEYWORDS[0])) {
            return ICUResourceBundle.getKeywordValues("com/ibm/icu/impl/data/icudata/coll", RESOURCE);
        }
        og.i("Invalid keyword: ".concat(str));
        return null;
    }

    public static final String[] getKeywordValuesForLocale(String str, ULocale uLocale, boolean z) {
        ICUResourceBundle iCUResourceBundle = (ICUResourceBundle) UResourceBundle.getBundleInstance("com/ibm/icu/impl/data/icudata/coll", uLocale);
        KeywordsSink keywordsSink = new KeywordsSink(0);
        iCUResourceBundle.getAllItemsWithFallback(RESOURCE, keywordsSink);
        LinkedList<String> linkedList = keywordsSink.values;
        return (String[]) linkedList.toArray(new String[linkedList.size()]);
    }

    public static final String[] getKeywords() {
        return KEYWORDS;
    }

    private static final int getReorderCode(String str, String str2) {
        return getIntValue(str, str2, "space", "punct", "symbol", "currency", "digit") + 4096;
    }

    private static ServiceShim getShim() {
        if (shim == null) {
            try {
                int i = CollatorServiceShim.a;
                shim = (ServiceShim) CollatorServiceShim.class.newInstance();
            } catch (MissingResourceException e) {
                throw e;
            } catch (Exception e2) {
                if (DEBUG) {
                    e2.printStackTrace();
                }
                throw new ICUException(e2);
            }
        }
        return shim;
    }

    private static final boolean getYesOrNo(String str, String str2) {
        if (ASCII.equalIgnoreCase(str2, "yes")) {
            return true;
        }
        if (ASCII.equalIgnoreCase(str2, "no")) {
            return false;
        }
        og.i(cq.l("illegal locale keyword=value: ", str, "=", str2));
        return false;
    }

    public static final Object registerFactory(CollatorFactory collatorFactory) {
        return getShim().registerFactory(collatorFactory);
    }

    public static final Object registerInstance(Collator collator, ULocale uLocale) {
        return getShim().registerInstance(collator, uLocale);
    }

    private static void setAttributesFromKeywords(ULocale uLocale, Collator collator, RuleBasedCollator ruleBasedCollator) {
        if (uLocale.getKeywordValue("colHiraganaQuaternary") != null) {
            dk0.r("locale keyword kh/colHiraganaQuaternary");
            return;
        }
        if (uLocale.getKeywordValue("variableTop") != null) {
            dk0.r("locale keyword vt/variableTop");
            return;
        }
        String keywordValue = uLocale.getKeywordValue("colStrength");
        if (keywordValue != null) {
            int intValue = getIntValue("colStrength", keywordValue, "primary", "secondary", "tertiary", "quaternary", "identical");
            if (intValue > 3) {
                intValue = 15;
            }
            collator.setStrength(intValue);
        }
        String keywordValue2 = uLocale.getKeywordValue("colBackwards");
        if (keywordValue2 != null) {
            if (ruleBasedCollator == null) {
                dk0.r("locale keyword kb/colBackwards only settable for RuleBasedCollator");
                return;
            }
            ruleBasedCollator.setFrenchCollation(getYesOrNo("colBackwards", keywordValue2));
        }
        String keywordValue3 = uLocale.getKeywordValue("colCaseLevel");
        if (keywordValue3 != null) {
            if (ruleBasedCollator == null) {
                dk0.r("locale keyword kb/colBackwards only settable for RuleBasedCollator");
                return;
            }
            ruleBasedCollator.setCaseLevel(getYesOrNo("colCaseLevel", keywordValue3));
        }
        String keywordValue4 = uLocale.getKeywordValue("colCaseFirst");
        if (keywordValue4 != null) {
            if (ruleBasedCollator == null) {
                dk0.r("locale keyword kf/colCaseFirst only settable for RuleBasedCollator");
                return;
            }
            int intValue2 = getIntValue("colCaseFirst", keywordValue4, "no", "lower", "upper");
            if (intValue2 == 0) {
                ruleBasedCollator.setLowerCaseFirst(false);
                ruleBasedCollator.setUpperCaseFirst(false);
            } else if (intValue2 == 1) {
                ruleBasedCollator.setLowerCaseFirst(true);
            } else {
                ruleBasedCollator.setUpperCaseFirst(true);
            }
        }
        String keywordValue5 = uLocale.getKeywordValue("colAlternate");
        if (keywordValue5 != null) {
            if (ruleBasedCollator == null) {
                dk0.r("locale keyword ka/colAlternate only settable for RuleBasedCollator");
                return;
            }
            ruleBasedCollator.setAlternateHandlingShifted(getIntValue("colAlternate", keywordValue5, "non-ignorable", "shifted") != 0);
        }
        String keywordValue6 = uLocale.getKeywordValue("colNormalization");
        if (keywordValue6 != null) {
            collator.setDecomposition(getYesOrNo("colNormalization", keywordValue6) ? 17 : 16);
        }
        String keywordValue7 = uLocale.getKeywordValue("colNumeric");
        if (keywordValue7 != null) {
            if (ruleBasedCollator == null) {
                dk0.r("locale keyword kn/colNumeric only settable for RuleBasedCollator");
                return;
            }
            ruleBasedCollator.setNumericCollation(getYesOrNo("colNumeric", keywordValue7));
        }
        String keywordValue8 = uLocale.getKeywordValue("colReorder");
        if (keywordValue8 != null) {
            int[] iArr = new int[UCharacter.UnicodeBlock.TAKRI_ID];
            int i = 0;
            int i2 = 0;
            while (true) {
                if (i == 220) {
                    og.i("too many script codes for colReorder locale keyword: ".concat(keywordValue8));
                    return;
                }
                int i3 = i2;
                while (i3 < keywordValue8.length() && keywordValue8.charAt(i3) != '-') {
                    i3++;
                }
                String strSubstring = keywordValue8.substring(i2, i3);
                int i4 = i + 1;
                iArr[i] = strSubstring.length() == 4 ? UCharacter.getPropertyValueEnum(UProperty.SCRIPT, strSubstring) : getReorderCode("colReorder", strSubstring);
                if (i3 == keywordValue8.length()) {
                    if (i4 == 0) {
                        og.i("no script codes for colReorder locale keyword");
                        return;
                    }
                    int[] iArr2 = new int[i4];
                    System.arraycopy(iArr, 0, iArr2, 0, i4);
                    collator.setReorderCodes(iArr2);
                    break;
                }
                i2 = i3 + 1;
                i = i4;
            }
        }
        String keywordValue9 = uLocale.getKeywordValue("kv");
        if (keywordValue9 != null) {
            collator.setMaxVariable(getReorderCode("kv", keywordValue9));
        }
    }

    public static final boolean unregister(Object obj) {
        ServiceShim serviceShim = shim;
        if (serviceShim == null) {
            return false;
        }
        return serviceShim.unregister(obj);
    }

    @Override // 
    /* JADX INFO: renamed from: clone */
    public Collator mo12clone() {
        return (Collator) super.clone();
    }

    @Override // com.ibm.icu.util.Freezable
    public Collator cloneAsThawed() {
        throw new UnsupportedOperationException("Needs to be implemented by the subclass.");
    }

    @Override // java.util.Comparator
    public int compare(Object obj, Object obj2) {
        return doCompare((CharSequence) obj, (CharSequence) obj2);
    }

    public abstract int compare(String str, String str2);

    @Deprecated
    public int doCompare(CharSequence charSequence, CharSequence charSequence2) {
        return compare(charSequence.toString(), charSequence2.toString());
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        if (this != obj) {
            return obj != null && getClass() == obj.getClass();
        }
        return true;
    }

    @Override // com.ibm.icu.util.Freezable
    public Collator freeze() {
        throw new UnsupportedOperationException("Needs to be implemented by the subclass.");
    }

    public abstract CollationKey getCollationKey(String str);

    public int getDecomposition() {
        return 16;
    }

    public ULocale getLocale(ULocale.Type type) {
        return ULocale.ROOT;
    }

    public int getMaxVariable() {
        return 4097;
    }

    public abstract RawCollationKey getRawCollationKey(String str, RawCollationKey rawCollationKey);

    public int[] getReorderCodes() {
        throw new UnsupportedOperationException("Needs to be implemented by the subclass.");
    }

    public int getStrength() {
        return 2;
    }

    public UnicodeSet getTailoredSet() {
        return new UnicodeSet(0, 1114111);
    }

    public abstract VersionInfo getUCAVersion();

    public abstract int getVariableTop();

    public abstract VersionInfo getVersion();

    public int hashCode() {
        return 0;
    }

    @Override // com.ibm.icu.util.Freezable
    public boolean isFrozen() {
        return false;
    }

    public void setDecomposition(int i) {
        checkNotFrozen();
    }

    public Collator setMaxVariable(int i) {
        throw new UnsupportedOperationException("Needs to be implemented by the subclass.");
    }

    public void setReorderCodes(int... iArr) {
        throw new UnsupportedOperationException("Needs to be implemented by the subclass.");
    }

    public void setStrength(int i) {
        checkNotFrozen();
    }

    @Deprecated
    public Collator setStrength2(int i) {
        setStrength(i);
        return this;
    }

    @Deprecated
    public abstract int setVariableTop(String str);

    @Deprecated
    public abstract void setVariableTop(int i);

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static abstract class CollatorFactory {
        public Collator createCollator(ULocale uLocale) {
            return createCollator(uLocale.toLocale());
        }

        public String getDisplayName(ULocale uLocale, ULocale uLocale2) {
            if (visible() && getSupportedLocaleIDs().contains(uLocale.getBaseName())) {
                return uLocale.getDisplayName(uLocale2);
            }
            return null;
        }

        public abstract Set<String> getSupportedLocaleIDs();

        public boolean visible() {
            return true;
        }

        public Collator createCollator(Locale locale) {
            return createCollator(ULocale.forLocale(locale));
        }

        public String getDisplayName(Locale locale, Locale locale2) {
            return getDisplayName(ULocale.forLocale(locale), ULocale.forLocale(locale2));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class KeywordsSink extends UResource.Sink {
        boolean hasDefault;
        LinkedList<String> values;

        private KeywordsSink() {
            this.values = new LinkedList<>();
            this.hasDefault = false;
        }

        @Override // com.ibm.icu.impl.UResource.Sink
        public void put(UResource.Key key, UResource.Value value, boolean z) {
            UResource.Table table = value.getTable();
            for (int i = 0; table.getKeyAndValue(i, key, value); i++) {
                int type = value.getType();
                if (type == 0) {
                    if (!this.hasDefault && key.contentEquals(UnitsData.Constants.DEFAULT_USAGE)) {
                        String string = value.getString();
                        if (!string.isEmpty()) {
                            this.values.remove(string);
                            this.values.addFirst(string);
                            this.hasDefault = true;
                        }
                    }
                } else if (type == 2 && !key.startsWith("private-")) {
                    String string2 = key.toString();
                    if (!this.values.contains(string2)) {
                        this.values.add(string2);
                    }
                }
            }
        }

        public /* synthetic */ KeywordsSink(int i) {
            this();
        }
    }

    public static final ULocale getFunctionalEquivalent(String str, ULocale uLocale) {
        return getFunctionalEquivalent(str, uLocale, null);
    }

    public static String getDisplayName(ULocale uLocale, ULocale uLocale2) {
        return getShim().getDisplayName(uLocale, uLocale2);
    }

    public boolean equals(String str, String str2) {
        return compare(str, str2) == 0;
    }

    public static String getDisplayName(Locale locale, Locale locale2) {
        return getShim().getDisplayName(ULocale.forLocale(locale), ULocale.forLocale(locale2));
    }

    public static String getDisplayName(ULocale uLocale) {
        return getShim().getDisplayName(uLocale, ULocale.getDefault(ULocale.Category.DISPLAY));
    }

    public static final Collator getInstance() {
        return getInstance(ULocale.getDefault());
    }

    public static final Collator getInstance(Locale locale) {
        return getInstance(ULocale.forLocale(locale));
    }

    public void setLocale(ULocale uLocale, ULocale uLocale2) {
    }
}
