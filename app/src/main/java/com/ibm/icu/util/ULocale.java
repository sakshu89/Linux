package com.ibm.icu.util;

import com.ibm.icu.impl.CacheBase;
import com.ibm.icu.impl.ICUData;
import com.ibm.icu.impl.ICUResourceBundle;
import com.ibm.icu.impl.ICUResourceTableAccess;
import com.ibm.icu.impl.LocaleIDParser;
import com.ibm.icu.impl.LocaleIDs;
import com.ibm.icu.impl.SoftCache;
import com.ibm.icu.impl.Utility;
import com.ibm.icu.impl.locale.AsciiUtil;
import com.ibm.icu.impl.locale.BaseLocale;
import com.ibm.icu.impl.locale.Extension;
import com.ibm.icu.impl.locale.InternalLocaleBuilder;
import com.ibm.icu.impl.locale.KeyTypeData;
import com.ibm.icu.impl.locale.LSR;
import com.ibm.icu.impl.locale.LanguageTag;
import com.ibm.icu.impl.locale.LikelySubtags;
import com.ibm.icu.impl.locale.LocaleExtensions;
import com.ibm.icu.impl.locale.LocaleSyntaxException;
import com.ibm.icu.impl.locale.ParseStatus;
import com.ibm.icu.impl.locale.UnicodeLocaleExtension;
import com.ibm.icu.impl.number.Padder;
import com.ibm.icu.lang.UProperty;
import com.ibm.icu.lang.UScript;
import com.ibm.icu.text.DateFormat;
import com.ibm.icu.text.LocaleDisplayNames;
import defpackage.cq;
import defpackage.dk0;
import defpackage.ky0;
import defpackage.og;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ULocale implements Serializable, Comparable<ULocale>, Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static Type ACTUAL_LOCALE = null;
    private static final SoftCache<Locale, ULocale, Void> CACHE;
    public static final ULocale CANADA;
    public static final ULocale CANADA_FRENCH;
    private static final String[][] CANONICALIZE_MAP;
    public static final ULocale CHINA;
    private static final Locale EMPTY_LOCALE;
    private static final String EMPTY_STRING = "";
    private static final String LANG_DIR_STRING = "root-en-es-pt-zh-ja-ko-de-fr-it-ar+he+fa+ru-nl-pl-th-tr-";
    private static final String LOCALE_ATTRIBUTE_KEY = "attribute";
    public static final ULocale PRC;
    public static final char PRIVATE_USE_EXTENSION = 'x';
    public static final ULocale ROOT;
    public static final ULocale TAIWAN;
    public static final ULocale UK;
    private static final String UNDEFINED_LANGUAGE = "und";
    private static final String UNDEFINED_REGION = "ZZ";
    private static final String UNDEFINED_SCRIPT = "Zzzz";
    private static final char UNDERSCORE = '_';
    public static final char UNICODE_LOCALE_EXTENSION = 'u';
    public static final ULocale US;
    public static Type VALID_LOCALE = null;
    private static volatile DefaultCategoryState defaultCategoryState = null;
    private static volatile ULocale defaultULocale = null;
    private static final long serialVersionUID = 3715177670352309217L;
    private volatile transient BaseLocale baseLocale;
    private volatile transient LocaleExtensions extensions;
    private volatile transient Locale locale;
    private String localeID;
    private static final CacheBase<String, String, Void> nameCache = new SoftCache<String, String, Void>() { // from class: com.ibm.icu.util.ULocale.1
        @Override // com.ibm.icu.impl.CacheBase
        public String createInstance(String str, Void r2) {
            return new LocaleIDParser(str).getName();
        }
    };
    public static final ULocale ENGLISH = new ULocale("en", Locale.ENGLISH);
    public static final ULocale FRENCH = new ULocale("fr", Locale.FRENCH);
    public static final ULocale GERMAN = new ULocale("de", Locale.GERMAN);
    public static final ULocale ITALIAN = new ULocale("it", Locale.ITALIAN);
    public static final ULocale JAPANESE = new ULocale("ja", Locale.JAPANESE);
    public static final ULocale KOREAN = new ULocale("ko", Locale.KOREAN);
    public static final ULocale CHINESE = new ULocale("zh", Locale.CHINESE);
    public static final ULocale SIMPLIFIED_CHINESE = new ULocale("zh_Hans");
    public static final ULocale TRADITIONAL_CHINESE = new ULocale("zh_Hant");
    public static final ULocale FRANCE = new ULocale("fr_FR", Locale.FRANCE);
    public static final ULocale GERMANY = new ULocale("de_DE", Locale.GERMANY);
    public static final ULocale ITALY = new ULocale("it_IT", Locale.ITALY);
    public static final ULocale JAPAN = new ULocale("ja_JP", Locale.JAPAN);
    public static final ULocale KOREA = new ULocale("ko_KR", Locale.KOREA);

    /* JADX INFO: renamed from: com.ibm.icu.util.ULocale$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$com$ibm$icu$util$ULocale$Category;

        static {
            int[] iArr = new int[Category.values().length];
            $SwitchMap$com$ibm$icu$util$ULocale$Category = iArr;
            try {
                iArr[Category.DISPLAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ibm$icu$util$ULocale$Category[Category.FORMAT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class AliasReplacer {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private String extensions;
        private String language;
        private String region;
        private String script;
        private List<String> variants;

        /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
        public static final class AliasDataHolder {
            static final Map<String, String> languageAliasMap;
            static final Map<String, String> scriptAliasMap;
            static final Map<String, String> subdivisionAliasMap;
            static final Map<String, List<String>> territoryAliasMap;
            static final Map<String, String> variantAliasMap;

            static {
                HashMap map = new HashMap();
                HashMap map2 = new HashMap();
                HashMap map3 = new HashMap();
                HashMap map4 = new HashMap();
                HashMap map5 = new HashMap();
                UResourceBundle uResourceBundle = UResourceBundle.getBundleInstance(ICUData.ICU_BASE_NAME, "metadata", ICUResourceBundle.ICU_DATA_CLASS_LOADER).get("alias");
                UResourceBundle uResourceBundle2 = uResourceBundle.get("language");
                UResourceBundle uResourceBundle3 = uResourceBundle.get("script");
                UResourceBundle uResourceBundle4 = uResourceBundle.get("territory");
                UResourceBundle uResourceBundle5 = uResourceBundle.get("variant");
                UResourceBundle uResourceBundle6 = uResourceBundle.get("subdivision");
                for (int i = 0; i < uResourceBundle2.getSize(); i++) {
                    UResourceBundle uResourceBundle7 = uResourceBundle2.get(i);
                    String key = uResourceBundle7.getKey();
                    String string = uResourceBundle7.get("replacement").getString();
                    Locale locale = new Locale(key);
                    if (!locale.getScript().isEmpty() || (key.startsWith(ULocale.UNDEFINED_LANGUAGE) && !locale.getCountry().isEmpty())) {
                        og.i(cq.v("key [", key, "] in alias:language contains unsupported fields combination."));
                        return;
                    }
                    map.put(key, string);
                }
                for (int i2 = 0; i2 < uResourceBundle3.getSize(); i2++) {
                    UResourceBundle uResourceBundle8 = uResourceBundle3.get(i2);
                    String key2 = uResourceBundle8.getKey();
                    String string2 = uResourceBundle8.get("replacement").getString();
                    if (key2.length() != 4) {
                        og.i(cq.v("Incorrect key [", key2, "] in alias:script."));
                        return;
                    }
                    map2.put(key2, string2);
                }
                int i3 = 0;
                while (i3 < uResourceBundle4.getSize()) {
                    UResourceBundle uResourceBundle9 = uResourceBundle4.get(i3);
                    String key3 = uResourceBundle9.getKey();
                    String string3 = uResourceBundle9.get("replacement").getString();
                    HashMap map6 = map;
                    if (key3.length() < 2 || key3.length() > 3) {
                        og.i(cq.v("Incorrect key [", key3, "] in alias:territory."));
                        return;
                    } else {
                        map3.put(key3, new ArrayList(Arrays.asList(string3.split(Padder.FALLBACK_PADDING_STRING))));
                        i3++;
                        map = map6;
                    }
                }
                HashMap map7 = map;
                for (int i4 = 0; i4 < uResourceBundle5.getSize(); i4++) {
                    UResourceBundle uResourceBundle10 = uResourceBundle5.get(i4);
                    String key4 = uResourceBundle10.getKey();
                    String string4 = uResourceBundle10.get("replacement").getString();
                    if (key4.length() < 4 || key4.length() > 8 || (key4.length() == 4 && (key4.charAt(0) < '0' || key4.charAt(0) > '9'))) {
                        og.i(cq.v("Incorrect key [", key4, "] in alias:variant."));
                        return;
                    }
                    if (string4.length() < 4 || string4.length() > 8 || (string4.length() == 4 && (string4.charAt(0) < '0' || string4.charAt(0) > '9'))) {
                        og.i(ky0.l("Incorrect variant [", string4, "] for the key [", key4, "] in alias:variant."));
                        return;
                    }
                    map4.put(key4, string4);
                }
                for (int i5 = 0; i5 < uResourceBundle6.getSize(); i5++) {
                    UResourceBundle uResourceBundle11 = uResourceBundle6.get(i5);
                    String key5 = uResourceBundle11.getKey();
                    String strConcat = uResourceBundle11.get("replacement").getString().split(Padder.FALLBACK_PADDING_STRING)[0];
                    if (key5.length() < 3 || key5.length() > 8) {
                        og.i(cq.v("Incorrect key [", key5, "] in alias:territory."));
                        return;
                    }
                    if (strConcat.length() == 2) {
                        strConcat = strConcat.concat(DateFormat.SPECIFIC_TZ);
                    } else if (strConcat.length() < 2 || strConcat.length() > 8) {
                        og.i(cq.v("Incorrect value [", strConcat, "] in alias:territory."));
                        return;
                    }
                    map5.put(key5, strConcat);
                }
                HashMap map8 = new HashMap(map7.size());
                for (Map.Entry entry : map7.entrySet()) {
                    Object key6 = entry.getKey();
                    Objects.requireNonNull(key6);
                    Object value = entry.getValue();
                    Objects.requireNonNull(value);
                    map8.put(key6, value);
                }
                languageAliasMap = Collections.unmodifiableMap(map8);
                HashMap map9 = new HashMap(map2.size());
                for (Map.Entry entry2 : map2.entrySet()) {
                    Object key7 = entry2.getKey();
                    Objects.requireNonNull(key7);
                    Object value2 = entry2.getValue();
                    Objects.requireNonNull(value2);
                    map9.put(key7, value2);
                }
                scriptAliasMap = Collections.unmodifiableMap(map9);
                HashMap map10 = new HashMap(map3.size());
                for (Map.Entry entry3 : map3.entrySet()) {
                    Object key8 = entry3.getKey();
                    Objects.requireNonNull(key8);
                    Object value3 = entry3.getValue();
                    Objects.requireNonNull(value3);
                    map10.put(key8, value3);
                }
                territoryAliasMap = Collections.unmodifiableMap(map10);
                HashMap map11 = new HashMap(map4.size());
                for (Map.Entry entry4 : map4.entrySet()) {
                    Object key9 = entry4.getKey();
                    Objects.requireNonNull(key9);
                    Object value4 = entry4.getValue();
                    Objects.requireNonNull(value4);
                    map11.put(key9, value4);
                }
                variantAliasMap = Collections.unmodifiableMap(map11);
                HashMap map12 = new HashMap(map5.size());
                for (Map.Entry entry5 : map5.entrySet()) {
                    Object key10 = entry5.getKey();
                    Objects.requireNonNull(key10);
                    Object value5 = entry5.getValue();
                    Objects.requireNonNull(value5);
                    map12.put(key10, value5);
                }
                subdivisionAliasMap = Collections.unmodifiableMap(map12);
            }

            private AliasDataHolder() {
            }
        }

        public AliasReplacer(String str, String str2, String str3, String str4, String str5) {
            this.language = str;
            this.script = str2;
            this.region = str3;
            if (!str4.isEmpty()) {
                this.variants = new ArrayList(Arrays.asList(str4.split(BaseLocale.SEP)));
            }
            this.extensions = str5;
        }

        private static String deleteOrReplace(String str, String str2, String str3) {
            if (str3 != null && !str3.isEmpty()) {
                return (str == null || str.isEmpty()) ? str3 : str;
            }
            if (str2 == null || str2.isEmpty()) {
                return str;
            }
            return null;
        }

        private static String generateKey(String str, String str2, String str3) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            if (str2 != null && !str2.isEmpty()) {
                sb.append(ULocale.UNDERSCORE);
                sb.append(str2);
            }
            if (str3 != null && !str3.isEmpty()) {
                sb.append(ULocale.UNDERSCORE);
                sb.append(str3);
            }
            return sb.toString();
        }

        private static Map<String, String> languageAliasMap() {
            return AliasDataHolder.languageAliasMap;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private boolean replaceLanguage(boolean z, boolean z2, boolean z3) {
            boolean z4;
            String str;
            String str2;
            String str3;
            String strSubstring;
            int i;
            String str4;
            char c = 0;
            if ((z2 && ((str4 = this.region) == null || str4.isEmpty())) || (z3 && this.variants == null)) {
                return false;
            }
            boolean z5 = true;
            int size = z3 ? this.variants.size() : 1;
            String str5 = z ? this.language : ULocale.UNDEFINED_LANGUAGE;
            String str6 = z2 ? this.region : null;
            int i2 = 0;
            String str7 = null;
            while (i2 < size) {
                if (z3) {
                    str7 = this.variants.get(i2);
                }
                int i3 = 4;
                if (str7 != null && str7.length() < 4) {
                    str7 = null;
                }
                String str8 = languageAliasMap().get(generateKey(str5, str6, str7));
                if (str8 == null) {
                    z4 = z5 ? 1 : 0;
                } else {
                    if (str8.indexOf(95) >= 0) {
                        String[] strArrSplit = str8.split(BaseLocale.SEP);
                        String str9 = strArrSplit[c];
                        if (str9.equals(ULocale.UNDEFINED_LANGUAGE)) {
                            str9 = this.language;
                        }
                        int length = strArrSplit[c].length() + (z5 ? 1 : 0);
                        int i4 = z5 ? 1 : 0;
                        String str10 = null;
                        String str11 = null;
                        String str12 = null;
                        while (true) {
                            if (strArrSplit.length <= i4) {
                                z4 = z5;
                                str8 = str9;
                                str = str10;
                                str2 = str11;
                                str3 = str12;
                                strSubstring = null;
                                break;
                            }
                            String str13 = strArrSplit[i4];
                            int length2 = str13.length();
                            if (z5 == length2) {
                                strSubstring = str8.substring(length);
                                z4 = z5;
                                str8 = str9;
                                str = str10;
                                str2 = str11;
                                str3 = str12;
                                break;
                            }
                            boolean z6 = z5;
                            if (length2 < 2 || length2 > 3) {
                                if (length2 >= 5 && length2 <= 8) {
                                    i = length2;
                                } else if (length2 == i3) {
                                    i = length2;
                                    if (str13.charAt(0) < '0' || str13.charAt(0) > '9') {
                                        str10 = str13;
                                    }
                                } else {
                                    i = length2;
                                }
                                str12 = str13;
                            } else {
                                i = length2;
                                str11 = str13;
                            }
                            i4++;
                            length += i + 1;
                            z5 = z6 ? 1 : 0;
                            i3 = 4;
                        }
                    } else {
                        if (str8.equals(ULocale.UNDEFINED_LANGUAGE)) {
                            str8 = this.language;
                        }
                        z4 = z5 ? 1 : 0;
                        strSubstring = null;
                        str2 = null;
                        str = null;
                        str3 = null;
                    }
                    String strDeleteOrReplace = deleteOrReplace(this.script, null, str);
                    String strDeleteOrReplace2 = deleteOrReplace(this.region, str6, str2);
                    String strDeleteOrReplace3 = deleteOrReplace(str7, str7, str3);
                    if (!this.language.equals(str8) || !this.script.equals(strDeleteOrReplace) || !this.region.equals(strDeleteOrReplace2) || !Objects.equals(str7, strDeleteOrReplace3) || strSubstring != null) {
                        this.language = str8;
                        this.script = strDeleteOrReplace;
                        this.region = strDeleteOrReplace2;
                        if (str7 != null && !str7.isEmpty()) {
                            if (strDeleteOrReplace3 == null || strDeleteOrReplace3.isEmpty()) {
                                this.variants.remove(i2);
                                if (this.variants.isEmpty()) {
                                    this.variants = null;
                                }
                            } else {
                                this.variants.set(i2, strDeleteOrReplace3);
                            }
                        }
                        return z4;
                    }
                }
                i2++;
                z5 = z4;
                c = 0;
            }
            return c;
        }

        private boolean replaceRegion() {
            List<String> list;
            String country;
            String str = this.region;
            if (str == null || str.isEmpty() || (list = territoryAliasMap().get(this.region)) == null) {
                return false;
            }
            if (list.size() > 1) {
                country = ULocale.addLikelySubtags(new ULocale(this.language, this.script, (String) null)).getCountry();
                if (!list.contains(country)) {
                    country = list.get(0);
                }
            } else {
                country = list.get(0);
            }
            this.region = country;
            return true;
        }

        private boolean replaceScript() {
            String str;
            String str2 = this.script;
            if (str2 == null || str2.isEmpty() || (str = scriptAliasMap().get(this.script)) == null) {
                return false;
            }
            this.script = str;
            return true;
        }

        private String replaceSubdivision(String str) {
            return subdivisionAliasMap().get(str);
        }

        private String replaceTransformedExtensions(String str) {
            StringBuilder sb = new StringBuilder();
            ArrayList arrayList = new ArrayList(Arrays.asList(str.split(LanguageTag.SEP)));
            ArrayList arrayList2 = new ArrayList();
            int size = arrayList.size();
            String strSubstring = ULocale.EMPTY_STRING;
            int i = 0;
            int length = 0;
            int i2 = 0;
            String str2 = ULocale.EMPTY_STRING;
            while (i2 < size) {
                Object obj = arrayList.get(i2);
                i2++;
                String str3 = (String) obj;
                if (LanguageTag.isTKey(str3)) {
                    if (i == 0) {
                        i = length - 1;
                    }
                    if (sb.length() > 0) {
                        arrayList2.add(sb.toString());
                        sb.setLength(0);
                    }
                    sb.append(str3);
                    str2 = str3;
                } else if (i != 0) {
                    sb.append(LanguageTag.SEP);
                    sb.append(ULocale.toUnicodeLocaleType(str2, str3));
                }
                length += str3.length() + 1;
            }
            if (sb.length() > 0) {
                arrayList2.add(sb.toString());
                sb.setLength(0);
            }
            if (i > 0) {
                strSubstring = str.substring(0, i);
            } else if (arrayList2.size() == 0) {
                strSubstring = str;
            }
            if (strSubstring.length() > 0) {
                sb.append(AsciiUtil.toLowerString(ULocale.createCanonical(ULocale.forLanguageTag(str)).toLanguageTag()));
            }
            if (arrayList2.size() > 0) {
                if (sb.length() > 0) {
                    sb.append(LanguageTag.SEP);
                }
                Collections.sort(arrayList2);
                sb.append(Utility.joinStrings(LanguageTag.SEP, arrayList2));
            }
            return sb.toString();
        }

        private boolean replaceVariant() {
            if (this.variants == null) {
                return false;
            }
            for (int i = 0; i < this.variants.size(); i++) {
                String str = this.variants.get(i);
                String str2 = variantAliasMap().get(str);
                if (str2 != null && !str.equals(str2)) {
                    this.variants.set(i, str2);
                    if (!str.equals("heploc")) {
                        return true;
                    }
                    this.variants.remove("hepburn");
                    if (!this.variants.isEmpty()) {
                        return true;
                    }
                    this.variants = null;
                    return true;
                }
            }
            return false;
        }

        private static Map<String, String> scriptAliasMap() {
            return AliasDataHolder.scriptAliasMap;
        }

        private static Map<String, String> subdivisionAliasMap() {
            return AliasDataHolder.subdivisionAliasMap;
        }

        private static Map<String, List<String>> territoryAliasMap() {
            return AliasDataHolder.territoryAliasMap;
        }

        private static Map<String, String> variantAliasMap() {
            return AliasDataHolder.variantAliasMap;
        }

        public String replace() {
            boolean z = false;
            int i = 0;
            boolean z2 = false;
            while (true) {
                int i2 = i + 1;
                String strJoinStrings = ULocale.EMPTY_STRING;
                if (i > 10) {
                    String str = this.language;
                    String str2 = this.script;
                    String str3 = this.region;
                    List<String> list = this.variants;
                    if (list != null) {
                        strJoinStrings = Utility.joinStrings(BaseLocale.SEP, list);
                    }
                    throw new IllegalArgumentException(cq.v("Have problem to resolve locale alias of ", ULocale.lscvToID(str, str2, str3, strJoinStrings), this.extensions));
                }
                if (!replaceLanguage(true, true, true) && !replaceLanguage(true, true, false) && !replaceLanguage(true, false, true) && !replaceLanguage(true, false, false) && !replaceLanguage(false, false, true) && !replaceRegion() && !replaceScript() && !replaceVariant()) {
                    if (this.extensions == null && !z2) {
                        return null;
                    }
                    String str4 = this.language;
                    String str5 = this.script;
                    String str6 = this.region;
                    List<String> list2 = this.variants;
                    if (list2 != null) {
                        strJoinStrings = Utility.joinStrings(BaseLocale.SEP, list2);
                    }
                    String strLscvToID = ULocale.lscvToID(str4, str5, str6, strJoinStrings);
                    if (this.extensions != null) {
                        ULocale uLocale = new ULocale(ky0.j(strLscvToID, this.extensions));
                        Iterator<String> keywords = uLocale.getKeywords();
                        while (keywords != null && keywords.hasNext()) {
                            String next = keywords.next();
                            if (next.equals("rg") || next.equals("sd") || next.equals("t")) {
                                String keywordValue = uLocale.getKeywordValue(next);
                                String strReplaceTransformedExtensions = next.equals("t") ? replaceTransformedExtensions(keywordValue) : replaceSubdivision(keywordValue);
                                if (strReplaceTransformedExtensions != null) {
                                    uLocale = uLocale.setKeywordValue(next, strReplaceTransformedExtensions);
                                    z = true;
                                }
                            }
                        }
                        if (z) {
                            this.extensions = uLocale.getName().substring(uLocale.getBaseName().length());
                            z2 = true;
                        }
                        strLscvToID = ky0.j(strLscvToID, this.extensions);
                    }
                    if (z2) {
                        return strLscvToID;
                    }
                    return null;
                }
                z2 = true;
                i = i2;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public enum AvailableType {
        DEFAULT,
        ONLY_LEGACY_ALIASES,
        WITH_LEGACY_ALIASES
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class Builder {
        private final InternalLocaleBuilder _locbld = new InternalLocaleBuilder();

        public Builder addUnicodeLocaleAttribute(String str) {
            try {
                this._locbld.addUnicodeLocaleAttribute(str);
                return this;
            } catch (LocaleSyntaxException e) {
                throw new IllformedLocaleException(e.getMessage(), e.getErrorIndex());
            }
        }

        public ULocale build() {
            return ULocale.getInstance(this._locbld.getBaseLocale(), this._locbld.getLocaleExtensions());
        }

        public Builder clear() {
            this._locbld.clear();
            return this;
        }

        public Builder clearExtensions() {
            this._locbld.clearExtensions();
            return this;
        }

        public Builder removeUnicodeLocaleAttribute(String str) {
            try {
                this._locbld.removeUnicodeLocaleAttribute(str);
                return this;
            } catch (LocaleSyntaxException e) {
                throw new IllformedLocaleException(e.getMessage(), e.getErrorIndex());
            }
        }

        public Builder setExtension(char c, String str) {
            try {
                this._locbld.setExtension(c, str);
                return this;
            } catch (LocaleSyntaxException e) {
                throw new IllformedLocaleException(e.getMessage(), e.getErrorIndex());
            }
        }

        public Builder setLanguage(String str) {
            try {
                this._locbld.setLanguage(str);
                return this;
            } catch (LocaleSyntaxException e) {
                throw new IllformedLocaleException(e.getMessage(), e.getErrorIndex());
            }
        }

        public Builder setLanguageTag(String str) {
            ParseStatus parseStatus = new ParseStatus();
            LanguageTag languageTag = LanguageTag.parse(str, parseStatus);
            if (parseStatus.isError()) {
                throw new IllformedLocaleException(parseStatus.getErrorMessage(), parseStatus.getErrorIndex());
            }
            this._locbld.setLanguageTag(languageTag);
            return this;
        }

        public Builder setLocale(ULocale uLocale) {
            try {
                this._locbld.setLocale(uLocale.base(), uLocale.extensions());
                return this;
            } catch (LocaleSyntaxException e) {
                throw new IllformedLocaleException(e.getMessage(), e.getErrorIndex());
            }
        }

        public Builder setRegion(String str) {
            try {
                this._locbld.setRegion(str);
                return this;
            } catch (LocaleSyntaxException e) {
                throw new IllformedLocaleException(e.getMessage(), e.getErrorIndex());
            }
        }

        public Builder setScript(String str) {
            try {
                this._locbld.setScript(str);
                return this;
            } catch (LocaleSyntaxException e) {
                throw new IllformedLocaleException(e.getMessage(), e.getErrorIndex());
            }
        }

        public Builder setUnicodeLocaleKeyword(String str, String str2) {
            try {
                this._locbld.setUnicodeLocaleKeyword(str, str2);
                return this;
            } catch (LocaleSyntaxException e) {
                throw new IllformedLocaleException(e.getMessage(), e.getErrorIndex());
            }
        }

        public Builder setVariant(String str) {
            try {
                this._locbld.setVariant(str);
                return this;
            } catch (LocaleSyntaxException e) {
                throw new IllformedLocaleException(e.getMessage(), e.getErrorIndex());
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public enum Category {
        DISPLAY,
        FORMAT
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class DefaultCategoryState {
        final Locale[] locales;
        final ULocale[] ulocales;

        public DefaultCategoryState(Locale[] localeArr, ULocale[] uLocaleArr) {
            this.locales = localeArr;
            this.ulocales = uLocaleArr;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class JDKLocaleHelper {
        private static Object eDISPLAY = null;
        private static Object eFORMAT = null;
        private static boolean hasLocaleCategories = false;
        private static Method mGetDefault;
        private static Method mSetDefault;

        static {
            Class<?> cls;
            try {
                Class<?>[] declaredClasses = Locale.class.getDeclaredClasses();
                int length = declaredClasses.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        cls = null;
                        break;
                    }
                    cls = declaredClasses[i];
                    if (cls.getName().equals("java.util.Locale$Category")) {
                        break;
                    } else {
                        i++;
                    }
                }
                if (cls == null) {
                    return;
                }
                mGetDefault = Locale.class.getDeclaredMethod("getDefault", cls);
                mSetDefault = Locale.class.getDeclaredMethod("setDefault", cls, Locale.class);
                Method method = cls.getMethod("name", null);
                for (Object obj : cls.getEnumConstants()) {
                    String str = (String) method.invoke(obj, null);
                    if (str.equals("DISPLAY")) {
                        eDISPLAY = obj;
                    } else if (str.equals("FORMAT")) {
                        eFORMAT = obj;
                    }
                }
                if (eDISPLAY != null && eFORMAT != null) {
                    hasLocaleCategories = true;
                }
            } catch (IllegalAccessException | IllegalArgumentException | NoSuchMethodException | SecurityException | InvocationTargetException unused) {
            }
        }

        private JDKLocaleHelper() {
        }

        public static Locale getDefault(Category category) {
            Object obj;
            if (hasLocaleCategories) {
                int i = AnonymousClass3.$SwitchMap$com$ibm$icu$util$ULocale$Category[category.ordinal()];
                if (i != 1) {
                    obj = i != 2 ? null : eFORMAT;
                } else {
                    obj = eDISPLAY;
                }
                if (obj != null) {
                    try {
                        return (Locale) mGetDefault.invoke(null, obj);
                    } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException unused) {
                    }
                }
            }
            return Locale.getDefault();
        }

        public static boolean hasLocaleCategories() {
            return hasLocaleCategories;
        }

        public static void setDefault(Category category, Locale locale) {
            Object obj;
            if (hasLocaleCategories) {
                int i = AnonymousClass3.$SwitchMap$com$ibm$icu$util$ULocale$Category[category.ordinal()];
                if (i != 1) {
                    obj = i != 2 ? null : eFORMAT;
                } else {
                    obj = eDISPLAY;
                }
                if (obj != null) {
                    try {
                        mSetDefault.invoke(null, obj, locale);
                    } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException unused) {
                    }
                }
            }
        }

        public static Locale toLocale(ULocale uLocale) {
            Locale localeForLanguageTag = (uLocale.getScript().length() > 0 || uLocale.getName().contains("@")) ? Locale.forLanguageTag(AsciiUtil.toUpperString(uLocale.toLanguageTag())) : null;
            return localeForLanguageTag == null ? new Locale(uLocale.getLanguage(), uLocale.getCountry(), uLocale.getVariant()) : localeForLanguageTag;
        }

        public static ULocale toULocale(Locale locale) {
            TreeMap treeMap;
            String language = locale.getLanguage();
            String country = locale.getCountry();
            String variant = locale.getVariant();
            String script = locale.getScript();
            Set<Character> extensionKeys = locale.getExtensionKeys();
            TreeSet<String> treeSet = null;
            TreeMap treeMap2 = null;
            if (extensionKeys.isEmpty()) {
                treeMap = null;
            } else {
                TreeSet treeSet2 = null;
                for (Character ch : extensionKeys) {
                    if (ch.charValue() == 'u') {
                        Set<String> unicodeLocaleAttributes = locale.getUnicodeLocaleAttributes();
                        if (!unicodeLocaleAttributes.isEmpty()) {
                            treeSet2 = new TreeSet();
                            Iterator<String> it = unicodeLocaleAttributes.iterator();
                            while (it.hasNext()) {
                                treeSet2.add(it.next());
                            }
                        }
                        for (String str : locale.getUnicodeLocaleKeys()) {
                            String unicodeLocaleType = locale.getUnicodeLocaleType(str);
                            if (unicodeLocaleType != null) {
                                if (str.equals("va")) {
                                    if (variant.length() != 0) {
                                        unicodeLocaleType = cq.k(unicodeLocaleType, BaseLocale.SEP, variant);
                                    }
                                    variant = unicodeLocaleType;
                                } else {
                                    if (treeMap2 == null) {
                                        treeMap2 = new TreeMap();
                                    }
                                    treeMap2.put(str, unicodeLocaleType);
                                }
                            }
                        }
                    } else {
                        String extension = locale.getExtension(ch.charValue());
                        if (extension != null) {
                            if (treeMap2 == null) {
                                treeMap2 = new TreeMap();
                            }
                            treeMap2.put(String.valueOf(ch), extension);
                        }
                    }
                }
                treeMap = treeMap2;
                treeSet = treeSet2;
            }
            if (language.equals("no") && country.equals("NO") && variant.equals("NY")) {
                language = "nn";
                variant = ULocale.EMPTY_STRING;
            }
            StringBuilder sb = new StringBuilder(language);
            if (script.length() > 0) {
                sb.append(ULocale.UNDERSCORE);
                sb.append(script);
            }
            if (country.length() > 0) {
                sb.append(ULocale.UNDERSCORE);
                sb.append(country);
            }
            if (variant.length() > 0) {
                if (country.length() == 0) {
                    sb.append(ULocale.UNDERSCORE);
                }
                sb.append(ULocale.UNDERSCORE);
                sb.append(variant);
            }
            if (treeSet != null) {
                StringBuilder sb2 = new StringBuilder();
                for (String str2 : treeSet) {
                    if (sb2.length() != 0) {
                        sb2.append('-');
                    }
                    sb2.append(str2);
                }
                if (treeMap == null) {
                    treeMap = new TreeMap();
                }
                treeMap.put(ULocale.LOCALE_ATTRIBUTE_KEY, sb2.toString());
            }
            int i = 0;
            if (treeMap != null) {
                sb.append('@');
                boolean z = false;
                for (Map.Entry entry : treeMap.entrySet()) {
                    String legacyKey = (String) entry.getKey();
                    String legacyType = (String) entry.getValue();
                    if (legacyKey.length() != 1) {
                        legacyKey = ULocale.toLegacyKey(legacyKey);
                        if (legacyType.length() == 0) {
                            legacyType = "yes";
                        }
                        legacyType = ULocale.toLegacyType(legacyKey, legacyType);
                    }
                    if (z) {
                        sb.append(';');
                    } else {
                        z = true;
                    }
                    sb.append(legacyKey);
                    sb.append('=');
                    sb.append(legacyType);
                    z = z;
                }
            }
            return new ULocale(ULocale.getName(sb.toString()), locale, i);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class KnownLocalesHolder {
        static final Set<String> KNOWN_LOCALES;

        static {
            String[] strArr = {"c", "en", "en_US", "af", "af_ZA", "am", "am_ET", "ar", "ar_001", "as", "as_IN", "az", "az_AZ", "be", "be_BY", "bg", "bg_BG", "bn", "bn_IN", "bs", "bs_BA", "ca", "ca_ES", "cs", "cs_CZ", "cy", "cy_GB", "da", "da_DK", "de", "de_DE", "el", "el_GR", "en_GB", "es", "es_419", "es_ES", "et", "et_EE", "eu", "eu_ES", "fa", "fa_IR", "fi", "fi_FI", "fil", "fil_PH", "fr", "fr_FR", "ga", "ga_IE", "gl", "gl_ES", "gu", "gu_IN", "he", "he_IL", "hi", "hi_IN", "hr", "hr_HR", "hu", "hu_HU", "hy", "hy_AM", "id", "id_ID", "is", "is_IS", "it", "it_IT", "ja", "ja_JP", DateFormat.HOUR_GENERIC_TZ, "jv_ID", "ka", "ka_GE", "kk", "kk_KZ", "km", "km_KH", "kn", "kn_IN", "ko", "ko_KR", "ky", "ky_KG", "lo", "lo_LA", "lt", "lt_LT", "lv", "lv_LV", "mk", "mk_MK", "ml", "ml_IN", "mn", "mn_MN", "mr", "mr_IN", DateFormat.MINUTE_SECOND, "ms_MY", "my", "my_MM", "nb", "nb_NO", "ne", "ne_NP", "nl", "nl_NL", "no", "or", "or_IN", "pa", "pa_IN", "pl", "pl_PL", "ps", "ps_AF", "pt", "pt_BR", "pt_PT", "ro", "ro_RO", "ru", "ru_RU", "sd", "sd_IN", "si", "si_LK", "sk", "sk_SK", "sl", "sl_SI", "so", "so_SO", "sq", "sq_AL", "sr", "sr_Cyrl_RS", "sr_Latn", "sr_RS", "sv", "sv_SE", "sw", "sw_TZ", "ta", "ta_IN", "te", "te_IN", "th", "th_TH", "tk", "tk_TM", "tr", "tr_TR", "uk", "uk_UA", "ur", "ur_PK", "uz", "uz_UZ", "vi", "vi_VN", "yue", "yue_Hant", "yue_Hant_HK", "yue_HK", "zh", "zh_CN", "zh_Hans", "zh_Hans_CN", "zh_Hant", "zh_Hant_TW", "zh_TW", "zu", "zu_ZA"};
            HashSet hashSet = new HashSet(178);
            for (int i = 0; i < 178; i++) {
                String str = strArr[i];
                Objects.requireNonNull(str);
                if (!hashSet.add(str)) {
                    dk0.y(str, "duplicate element: ");
                    return;
                }
            }
            KNOWN_LOCALES = Collections.unmodifiableSet(hashSet);
        }

        private KnownLocalesHolder() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    @Deprecated
    public enum Minimize {
        FAVOR_SCRIPT,
        FAVOR_REGION
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    @Deprecated
    public static class RegionValidateMap {

        @Deprecated
        protected int[] map;
        private static int[] gValidRegionMap = {-287352452, -555893265, 362037055, 234935680, -1341563904, 1440671, 2015102605, 54542351, -198501120, -45121215, 634912764, 16779339, 1401896000, 1073741825, -34516736, -1615103257, 68174234, 4228439, UProperty.CASE_FOLDING, 1048577, 4195336, 1};

        @Deprecated
        public static RegionValidateMap BUILTIN = new RegionValidateMap();

        @Deprecated
        public RegionValidateMap() {
            int[] iArr = gValidRegionMap;
            this.map = Arrays.copyOf(iArr, iArr.length);
        }

        @Deprecated
        public boolean equals(RegionValidateMap regionValidateMap) {
            return Arrays.equals(this.map, regionValidateMap.map);
        }

        @Deprecated
        public boolean isSet(String str) {
            int iValue = value(str);
            return iValue >= 0 && (this.map[iValue / 32] & (1 << (iValue % 32))) != 0;
        }

        @Deprecated
        public int value(String str) {
            if (!str.matches("[a-zA-Z][a-zA-Z]")) {
                return -1;
            }
            String lowerCase = str.toLowerCase();
            int iCodePointAt = "a".codePointAt(0);
            return (lowerCase.codePointAt(1) + ((lowerCase.codePointAt(0) - iCodePointAt) * 26)) - iCodePointAt;
        }
    }

    static {
        ULocale uLocale = new ULocale("zh_Hans_CN");
        CHINA = uLocale;
        PRC = uLocale;
        TAIWAN = new ULocale("zh_Hant_TW");
        UK = new ULocale("en_GB", Locale.UK);
        US = new ULocale("en_US", Locale.US);
        CANADA = new ULocale("en_CA", Locale.CANADA);
        CANADA_FRENCH = new ULocale("fr_CA", Locale.CANADA_FRENCH);
        Locale locale = new Locale(EMPTY_STRING, EMPTY_STRING);
        EMPTY_LOCALE = locale;
        ROOT = new ULocale(EMPTY_STRING, locale);
        CACHE = new SoftCache<Locale, ULocale, Void>() { // from class: com.ibm.icu.util.ULocale.2
            @Override // com.ibm.icu.impl.CacheBase
            public ULocale createInstance(Locale locale2, Void r2) {
                return JDKLocaleHelper.toULocale(locale2);
            }
        };
        CANONICALIZE_MAP = new String[][]{new String[]{"art__LOJBAN", "jbo"}, new String[]{"cel__GAULISH", "cel__GAULISH"}, new String[]{"de__1901", "de__1901"}, new String[]{"de__1906", "de__1906"}, new String[]{"en__BOONT", "en__BOONT"}, new String[]{"en__SCOUSE", "en__SCOUSE"}, new String[]{"hy__AREVELA", "hy", null, null}, new String[]{"hy__AREVMDA", "hyw", null, null}, new String[]{"sl__ROZAJ", "sl__ROZAJ"}, new String[]{"zh__GUOYU", "zh"}, new String[]{"zh__HAKKA", "hak"}, new String[]{"zh__XIANG", "hsn"}, new String[]{"zh_GAN", "gan"}, new String[]{"zh_MIN", "zh__MIN"}, new String[]{"zh_MIN_NAN", "nan"}, new String[]{"zh_WUU", "wuu"}, new String[]{"zh_YUE", "yue"}};
        Locale locale2 = Locale.getDefault();
        defaultULocale = forLocale(locale2);
        Locale[] localeArr = new Locale[Category.values().length];
        ULocale[] uLocaleArr = new ULocale[Category.values().length];
        int i = 0;
        if (JDKLocaleHelper.hasLocaleCategories()) {
            for (Category category : Category.values()) {
                int iOrdinal = category.ordinal();
                Locale locale3 = JDKLocaleHelper.getDefault(category);
                localeArr[iOrdinal] = locale3;
                uLocaleArr[iOrdinal] = forLocale(locale3);
            }
        } else {
            for (Category category2 : Category.values()) {
                int iOrdinal2 = category2.ordinal();
                localeArr[iOrdinal2] = locale2;
                uLocaleArr[iOrdinal2] = defaultULocale;
            }
        }
        defaultCategoryState = new DefaultCategoryState(localeArr, uLocaleArr);
        ACTUAL_LOCALE = new Type(i);
        VALID_LOCALE = new Type(i);
    }

    public ULocale(String str, String str2, String str3) {
        this.localeID = getName(lscvToID(str, str2, str3, EMPTY_STRING));
    }

    public static ULocale acceptLanguage(ULocale[] uLocaleArr, ULocale[] uLocaleArr2, boolean[] zArr) {
        if (zArr != null) {
            zArr[0] = true;
        }
        LocaleMatcher.Builder builder = LocaleMatcher.builder();
        for (ULocale uLocale : uLocaleArr2) {
            builder.addSupportedULocale(uLocale);
        }
        LocaleMatcher localeMatcherBuild = builder.build();
        LocaleMatcher.Result bestMatchResult = uLocaleArr.length == 1 ? localeMatcherBuild.getBestMatchResult(uLocaleArr[0]) : localeMatcherBuild.getBestMatchResult(Arrays.asList(uLocaleArr));
        if (bestMatchResult.getDesiredIndex() < 0) {
            return null;
        }
        if (zArr != null && bestMatchResult.getDesiredULocale().equals(bestMatchResult.getSupportedULocale())) {
            zArr[0] = false;
        }
        return bestMatchResult.getSupportedULocale();
    }

    public static ULocale addLikelySubtags(ULocale uLocale) {
        int tagString = parseTagString(uLocale.localeID, new String[3]);
        String strSubstring = tagString < uLocale.localeID.length() ? uLocale.localeID.substring(tagString) : null;
        LSR lsrMakeMaximizedLsrFrom = LikelySubtags.INSTANCE.makeMaximizedLsrFrom(new ULocale(uLocale.getLanguage(), uLocale.getScript(), uLocale.getCountry()), true);
        String strCreateTagString = createTagString(lsrMakeMaximizedLsrFrom.language, lsrMakeMaximizedLsrFrom.script, lsrMakeMaximizedLsrFrom.region, strSubstring);
        return strCreateTagString == null ? uLocale : new ULocale(strCreateTagString);
    }

    private static void appendTag(String str, StringBuilder sb) {
        if (sb.length() != 0) {
            sb.append(UNDERSCORE);
        }
        sb.append(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public BaseLocale base() {
        String language;
        String variant;
        String script;
        String country;
        if (this.baseLocale == null) {
            if (equals(ROOT)) {
                language = EMPTY_STRING;
                variant = EMPTY_STRING;
                script = variant;
                country = script;
            } else {
                LocaleIDParser localeIDParser = new LocaleIDParser(this.localeID);
                language = localeIDParser.getLanguage();
                script = localeIDParser.getScript();
                country = localeIDParser.getCountry();
                variant = localeIDParser.getVariant();
            }
            this.baseLocale = BaseLocale.getInstance(language, script, country, variant);
        }
        return this.baseLocale;
    }

    public static String canonicalize(String str) {
        String strReplace;
        LocaleIDParser localeIDParser = new LocaleIDParser(str, true);
        String baseName = localeIDParser.getBaseName();
        if (str.equals(EMPTY_STRING)) {
            return EMPTY_STRING;
        }
        int i = 0;
        while (true) {
            String[][] strArr = CANONICALIZE_MAP;
            if (i >= strArr.length) {
                if (!localeIDParser.getLanguage().equals("nb") || !localeIDParser.getVariant().equals("NY")) {
                    break;
                    break;
                }
                localeIDParser.setBaseName(lscvToID("nn", localeIDParser.getScript(), localeIDParser.getCountry(), null));
                break;
            }
            String[] strArr2 = strArr[i];
            if (strArr2[0].equals(baseName)) {
                localeIDParser.setBaseName(strArr2[1]);
                break;
            }
            i++;
        }
        if (!isKnownCanonicalizedLocale(localeIDParser.getName()) && (strReplace = new AliasReplacer(localeIDParser.getLanguage(), localeIDParser.getScript(), localeIDParser.getCountry(), AsciiUtil.toLowerString(localeIDParser.getVariant()), localeIDParser.getName().substring(localeIDParser.getBaseName().length())).replace()) != null) {
            localeIDParser = new LocaleIDParser(strReplace);
        }
        return localeIDParser.getName();
    }

    public static ULocale createCanonical(String str) {
        return new ULocale(canonicalize(str), (Locale) null);
    }

    private static String createTagString(String str, String str2, String str3, String str4) {
        StringBuilder sb = new StringBuilder();
        if (isEmptyString(str)) {
            appendTag(UNDEFINED_LANGUAGE, sb);
        } else {
            appendTag(str, sb);
        }
        if (!isEmptyString(str2)) {
            appendTag(str2, sb);
        }
        if (!isEmptyString(str3)) {
            appendTag(str3, sb);
        }
        if (str4 != null && str4.length() > 1) {
            char c = 0;
            if (str4.charAt(0) != '_') {
                c = 1;
            } else if (str4.charAt(1) == '_') {
                c = 2;
            }
            if (isEmptyString(str3)) {
                if (c == 1) {
                    sb.append(UNDERSCORE);
                }
                sb.append(str4);
            } else if (c == 2) {
                sb.append(str4.substring(1));
            } else {
                sb.append(str4);
            }
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public LocaleExtensions extensions() {
        if (this.extensions == null) {
            Iterator<String> keywords = getKeywords();
            if (keywords == null) {
                this.extensions = LocaleExtensions.EMPTY_EXTENSIONS;
            } else {
                InternalLocaleBuilder internalLocaleBuilder = new InternalLocaleBuilder();
                while (keywords.hasNext()) {
                    String next = keywords.next();
                    if (next.equals(LOCALE_ATTRIBUTE_KEY)) {
                        for (String str : getKeywordValue(next).split("[-_]")) {
                            try {
                                internalLocaleBuilder.addUnicodeLocaleAttribute(str);
                            } catch (LocaleSyntaxException unused) {
                            }
                        }
                    } else if (next.length() >= 2) {
                        String unicodeLocaleKey = toUnicodeLocaleKey(next);
                        String unicodeLocaleType = toUnicodeLocaleType(next, getKeywordValue(next));
                        if (unicodeLocaleKey != null && unicodeLocaleType != null) {
                            try {
                                internalLocaleBuilder.setUnicodeLocaleKeyword(unicodeLocaleKey, unicodeLocaleType);
                            } catch (LocaleSyntaxException unused2) {
                            }
                        }
                    } else if (next.length() == 1 && next.charAt(0) != 'u') {
                        internalLocaleBuilder.setExtension(next.charAt(0), getKeywordValue(next).replace(BaseLocale.SEP, LanguageTag.SEP));
                    }
                }
                this.extensions = internalLocaleBuilder.getLocaleExtensions();
            }
        }
        return this.extensions;
    }

    public static ULocale forLanguageTag(String str) {
        LanguageTag languageTag = LanguageTag.parse(str, null);
        InternalLocaleBuilder internalLocaleBuilder = new InternalLocaleBuilder();
        internalLocaleBuilder.setLanguageTag(languageTag);
        return getInstance(internalLocaleBuilder.getBaseLocale(), internalLocaleBuilder.getLocaleExtensions());
    }

    public static ULocale forLocale(Locale locale) {
        if (locale == null) {
            return null;
        }
        return CACHE.getInstance(locale, null);
    }

    public static ULocale[] getAvailableLocales() {
        return (ULocale[]) ICUResourceBundle.getAvailableULocales().clone();
    }

    public static Collection<ULocale> getAvailableLocalesByType(AvailableType availableType) {
        List listAsList;
        if (availableType == null) {
            dk0.v();
            return null;
        }
        if (availableType == AvailableType.WITH_LEGACY_ALIASES) {
            listAsList = new ArrayList();
            Collections.addAll(listAsList, ICUResourceBundle.getAvailableULocales(AvailableType.DEFAULT));
            Collections.addAll(listAsList, ICUResourceBundle.getAvailableULocales(AvailableType.ONLY_LEGACY_ALIASES));
        } else {
            listAsList = Arrays.asList(ICUResourceBundle.getAvailableULocales(availableType));
        }
        return Collections.unmodifiableList(listAsList);
    }

    public static String getBaseName(String str) {
        return str.indexOf(64) == -1 ? str : new LocaleIDParser(str).getBaseName();
    }

    public static String getCountry(String str) {
        return new LocaleIDParser(str).getCountry();
    }

    public static ULocale getDefault(Category category) {
        DefaultCategoryState defaultCategoryState2;
        DefaultCategoryState defaultCategoryState3;
        int iOrdinal = category.ordinal();
        DefaultCategoryState defaultCategoryState4 = defaultCategoryState;
        if (defaultCategoryState4 == null || defaultCategoryState4.ulocales[iOrdinal] == null) {
            return ROOT;
        }
        if (JDKLocaleHelper.hasLocaleCategories()) {
            Locale locale = JDKLocaleHelper.getDefault(category);
            if (!defaultCategoryState4.locales[iOrdinal].equals(locale)) {
                synchronized (ULocale.class) {
                    try {
                        defaultCategoryState3 = defaultCategoryState;
                        if (!defaultCategoryState3.locales[iOrdinal].equals(locale)) {
                            Locale[] localeArr = (Locale[]) defaultCategoryState3.locales.clone();
                            ULocale[] uLocaleArr = (ULocale[]) defaultCategoryState3.ulocales.clone();
                            localeArr[iOrdinal] = locale;
                            uLocaleArr[iOrdinal] = forLocale(locale);
                            DefaultCategoryState defaultCategoryState5 = new DefaultCategoryState(localeArr, uLocaleArr);
                            defaultCategoryState = defaultCategoryState5;
                            defaultCategoryState3 = defaultCategoryState5;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return defaultCategoryState3.ulocales[iOrdinal];
            }
        } else {
            Locale locale2 = Locale.getDefault();
            if (!defaultULocale.locale.equals(locale2)) {
                synchronized (ULocale.class) {
                    try {
                        defaultCategoryState2 = defaultCategoryState;
                        if (!defaultULocale.locale.equals(locale2)) {
                            defaultULocale = forLocale(locale2);
                            Locale[] localeArr2 = new Locale[Category.values().length];
                            ULocale[] uLocaleArr2 = new ULocale[Category.values().length];
                            for (Category category2 : Category.values()) {
                                int iOrdinal2 = category2.ordinal();
                                localeArr2[iOrdinal2] = locale2;
                                uLocaleArr2[iOrdinal2] = forLocale(locale2);
                            }
                            DefaultCategoryState defaultCategoryState6 = new DefaultCategoryState(localeArr2, uLocaleArr2);
                            defaultCategoryState = defaultCategoryState6;
                            defaultCategoryState2 = defaultCategoryState6;
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
                return defaultCategoryState2.ulocales[iOrdinal];
            }
        }
        return defaultCategoryState4.ulocales[iOrdinal];
    }

    public static String getDisplayCountry(String str, String str2) {
        return getDisplayCountryInternal(new ULocale(str), new ULocale(str2));
    }

    private static String getDisplayCountryInternal(ULocale uLocale, ULocale uLocale2) {
        return LocaleDisplayNames.getInstance(uLocale2).regionDisplayName(uLocale.getCountry());
    }

    public static String getDisplayKeyword(String str) {
        return getDisplayKeywordInternal(str, getDefault(Category.DISPLAY));
    }

    private static String getDisplayKeywordInternal(String str, ULocale uLocale) {
        return LocaleDisplayNames.getInstance(uLocale).keyDisplayName(str);
    }

    public static String getDisplayKeywordValue(String str, String str2, String str3) {
        return getDisplayKeywordValueInternal(new ULocale(str), str2, new ULocale(str3));
    }

    private static String getDisplayKeywordValueInternal(ULocale uLocale, String str, ULocale uLocale2) {
        String lowerString = AsciiUtil.toLowerString(str.trim());
        return LocaleDisplayNames.getInstance(uLocale2).keyValueDisplayName(lowerString, uLocale.getKeywordValue(lowerString));
    }

    public static String getDisplayLanguage(String str, String str2) {
        return getDisplayLanguageInternal(new ULocale(str), new ULocale(str2), false);
    }

    private static String getDisplayLanguageInternal(ULocale uLocale, ULocale uLocale2, boolean z) {
        return LocaleDisplayNames.getInstance(uLocale2).languageDisplayName(z ? uLocale.getBaseName() : uLocale.getLanguage());
    }

    public static String getDisplayLanguageWithDialect(String str, String str2) {
        return getDisplayLanguageInternal(new ULocale(str), new ULocale(str2), true);
    }

    public static String getDisplayName(String str, String str2) {
        return getDisplayNameInternal(new ULocale(str), new ULocale(str2));
    }

    private static String getDisplayNameInternal(ULocale uLocale, ULocale uLocale2) {
        return LocaleDisplayNames.getInstance(uLocale2).localeDisplayName(uLocale);
    }

    public static String getDisplayNameWithDialect(String str, String str2) {
        return getDisplayNameWithDialectInternal(new ULocale(str), new ULocale(str2));
    }

    private static String getDisplayNameWithDialectInternal(ULocale uLocale, ULocale uLocale2) {
        return LocaleDisplayNames.getInstance(uLocale2, LocaleDisplayNames.DialectHandling.DIALECT_NAMES).localeDisplayName(uLocale);
    }

    public static String getDisplayScript(String str, String str2) {
        return getDisplayScriptInternal(new ULocale(str), new ULocale(str2));
    }

    @Deprecated
    public static String getDisplayScriptInContext(String str, String str2) {
        return getDisplayScriptInContextInternal(new ULocale(str), new ULocale(str2));
    }

    private static String getDisplayScriptInContextInternal(ULocale uLocale, ULocale uLocale2) {
        return LocaleDisplayNames.getInstance(uLocale2).scriptDisplayNameInContext(uLocale.getScript());
    }

    private static String getDisplayScriptInternal(ULocale uLocale, ULocale uLocale2) {
        return LocaleDisplayNames.getInstance(uLocale2).scriptDisplayName(uLocale.getScript());
    }

    public static String getDisplayVariant(String str, String str2) {
        return getDisplayVariantInternal(new ULocale(str), new ULocale(str2));
    }

    private static String getDisplayVariantInternal(ULocale uLocale, ULocale uLocale2) {
        return LocaleDisplayNames.getInstance(uLocale2).variantDisplayName(uLocale.getVariant());
    }

    private static String getFallbackString(String str) {
        int iIndexOf = str.indexOf(64);
        if (iIndexOf == -1) {
            iIndexOf = str.length();
        }
        int iLastIndexOf = str.lastIndexOf(95, iIndexOf);
        if (iLastIndexOf == -1) {
            iLastIndexOf = 0;
        } else {
            while (iLastIndexOf > 0 && str.charAt(iLastIndexOf - 1) == '_') {
                iLastIndexOf--;
            }
        }
        return str.substring(0, iLastIndexOf).concat(str.substring(iIndexOf));
    }

    public static String getISO3Country(String str) {
        return LocaleIDs.getISO3Country(getCountry(str));
    }

    public static String getISO3Language(String str) {
        return LocaleIDs.getISO3Language(getLanguage(str));
    }

    public static String[] getISOCountries() {
        return LocaleIDs.getISOCountries();
    }

    public static String[] getISOLanguages() {
        return LocaleIDs.getISOLanguages();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ULocale getInstance(BaseLocale baseLocale, LocaleExtensions localeExtensions) {
        String strLscvToID = lscvToID(baseLocale.getLanguage(), baseLocale.getScript(), baseLocale.getRegion(), baseLocale.getVariant());
        Set<Character> keys = localeExtensions.getKeys();
        if (!keys.isEmpty()) {
            TreeMap treeMap = new TreeMap();
            for (Character ch : keys) {
                Extension extension = localeExtensions.getExtension(ch);
                if (extension instanceof UnicodeLocaleExtension) {
                    UnicodeLocaleExtension unicodeLocaleExtension = (UnicodeLocaleExtension) extension;
                    for (String str : unicodeLocaleExtension.getUnicodeLocaleKeys()) {
                        String unicodeLocaleType = unicodeLocaleExtension.getUnicodeLocaleType(str);
                        String legacyKey = toLegacyKey(str);
                        if (unicodeLocaleType.length() == 0) {
                            unicodeLocaleType = "yes";
                        }
                        String legacyType = toLegacyType(str, unicodeLocaleType);
                        if (legacyKey.equals("va") && legacyType.equals("posix") && baseLocale.getVariant().length() == 0) {
                            strLscvToID = ky0.j(strLscvToID, "_POSIX");
                        } else {
                            treeMap.put(legacyKey, legacyType);
                        }
                    }
                    Set<String> unicodeLocaleAttributes = unicodeLocaleExtension.getUnicodeLocaleAttributes();
                    if (unicodeLocaleAttributes.size() > 0) {
                        StringBuilder sb = new StringBuilder();
                        for (String str2 : unicodeLocaleAttributes) {
                            if (sb.length() > 0) {
                                sb.append('-');
                            }
                            sb.append(str2);
                        }
                        treeMap.put(LOCALE_ATTRIBUTE_KEY, sb.toString());
                    }
                } else {
                    treeMap.put(String.valueOf(ch), extension.getValue());
                }
            }
            if (!treeMap.isEmpty()) {
                StringBuilder sb2 = new StringBuilder(strLscvToID);
                sb2.append("@");
                boolean z = false;
                for (Map.Entry entry : treeMap.entrySet()) {
                    if (z) {
                        sb2.append(";");
                    } else {
                        z = true;
                    }
                    sb2.append((String) entry.getKey());
                    sb2.append("=");
                    sb2.append((String) entry.getValue());
                }
                strLscvToID = sb2.toString();
            }
        }
        return new ULocale(strLscvToID);
    }

    public static String getKeywordValue(String str, String str2) {
        return new LocaleIDParser(str).getKeywordValue(str2);
    }

    public static Iterator<String> getKeywords(String str) {
        return new LocaleIDParser(str).getKeywords();
    }

    public static String getLanguage(String str) {
        return new LocaleIDParser(str).getLanguage();
    }

    public static String getName(String str) {
        if (str == null || str.contains("@") || getShortestSubtagLength(str) != 1) {
            str = "root".equalsIgnoreCase(str) ? EMPTY_STRING : stripLeadingUnd(str);
        } else {
            String name = forLanguageTag((str.indexOf(95) < 0 || str.charAt(1) == '_' || str.charAt(1) == '-') ? str : str.replace(UNDERSCORE, '-')).getName();
            if (name.length() != 0) {
                str = name;
            }
        }
        return nameCache.getInstance(str, null);
    }

    @Deprecated
    public static String getRegionForSupplementalData(ULocale uLocale, boolean z) {
        String regionFromKey = getRegionFromKey(uLocale, "rg");
        if (regionFromKey != null) {
            return regionFromKey;
        }
        String country = uLocale.getCountry();
        if (country.length() != 0 || !z) {
            return country;
        }
        String regionFromKey2 = getRegionFromKey(uLocale, "sd");
        return regionFromKey2 != null ? regionFromKey2 : addLikelySubtags(uLocale).getCountry();
    }

    private static String getRegionFromKey(ULocale uLocale, String str) {
        String keywordValue = uLocale.getKeywordValue(str);
        if (keywordValue != null && keywordValue.length() >= 3 && keywordValue.length() <= 6) {
            String upperCase = keywordValue.substring(0, 2).toUpperCase();
            if (RegionValidateMap.BUILTIN.isSet(upperCase)) {
                return upperCase;
            }
        }
        return null;
    }

    public static String getScript(String str) {
        return new LocaleIDParser(str).getScript();
    }

    private static int getShortestSubtagLength(String str) {
        int length = str.length();
        int i = length;
        boolean z = true;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            if (str.charAt(i3) == '_' || str.charAt(i3) == '-') {
                if (i2 != 0 && i2 < i) {
                    i = i2;
                }
                z = true;
            } else {
                if (z) {
                    i2 = 0;
                    z = false;
                }
                i2++;
            }
        }
        return i;
    }

    public static String getVariant(String str) {
        return new LocaleIDParser(str).getVariant();
    }

    private static boolean isEmptyString(String str) {
        return str == null || str.length() == 0;
    }

    private static boolean isKnownCanonicalizedLocale(String str) {
        return KnownLocalesHolder.KNOWN_LOCALES.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String lscvToID(String str, String str2, String str3, String str4) {
        StringBuilder sb = new StringBuilder();
        if (str != null && str.length() > 0) {
            sb.append(str);
        }
        if (str2 != null && str2.length() > 0) {
            sb.append(UNDERSCORE);
            sb.append(str2);
        }
        if (str3 != null && str3.length() > 0) {
            sb.append(UNDERSCORE);
            sb.append(str3);
        }
        if (str4 != null && str4.length() > 0) {
            if (str3 == null || str3.length() == 0) {
                sb.append(UNDERSCORE);
            }
            sb.append(UNDERSCORE);
            sb.append(str4);
        }
        return sb.toString();
    }

    @Deprecated
    public static ULocale minimizeSubtags(ULocale uLocale, Minimize minimize) {
        int tagString = parseTagString(uLocale.localeID, new String[3]);
        String strSubstring = tagString < uLocale.localeID.length() ? uLocale.localeID.substring(tagString) : null;
        LSR lsrMinimizeSubtags = LikelySubtags.INSTANCE.minimizeSubtags(uLocale.getLanguage(), uLocale.getScript(), uLocale.getCountry(), minimize);
        String strCreateTagString = createTagString(lsrMinimizeSubtags.language, lsrMinimizeSubtags.script, lsrMinimizeSubtags.region, strSubstring);
        return strCreateTagString == null ? uLocale : new ULocale(strCreateTagString);
    }

    private static int parseTagString(String str, String[] strArr) {
        LocaleIDParser localeIDParser = new LocaleIDParser(str);
        String language = localeIDParser.getLanguage();
        String script = localeIDParser.getScript();
        String country = localeIDParser.getCountry();
        if (isEmptyString(language)) {
            strArr[0] = UNDEFINED_LANGUAGE;
        } else {
            strArr[0] = language;
        }
        if (script.equals(UNDEFINED_SCRIPT)) {
            strArr[1] = EMPTY_STRING;
        } else {
            strArr[1] = script;
        }
        if (country.equals(UNDEFINED_REGION)) {
            strArr[2] = EMPTY_STRING;
        } else {
            strArr[2] = country;
        }
        String variant = localeIDParser.getVariant();
        if (isEmptyString(variant)) {
            int iIndexOf = str.indexOf(64);
            return iIndexOf == -1 ? str.length() : iIndexOf;
        }
        int iIndexOf2 = str.indexOf(variant);
        return iIndexOf2 > 0 ? iIndexOf2 - 1 : iIndexOf2;
    }

    public static synchronized void setDefault(Category category, ULocale uLocale) {
        Locale locale = uLocale.toLocale();
        int iOrdinal = category.ordinal();
        DefaultCategoryState defaultCategoryState2 = defaultCategoryState;
        ULocale[] uLocaleArr = (ULocale[]) defaultCategoryState2.ulocales.clone();
        Locale[] localeArr = (Locale[]) defaultCategoryState2.locales.clone();
        uLocaleArr[iOrdinal] = uLocale;
        localeArr[iOrdinal] = locale;
        defaultCategoryState = new DefaultCategoryState(localeArr, uLocaleArr);
        JDKLocaleHelper.setDefault(category, locale);
    }

    private static String stripLeadingUnd(String str) {
        int length = str.length();
        if (length < 3) {
            return str;
        }
        if (!str.regionMatches(true, 0, UNDEFINED_LANGUAGE, 0, 3)) {
            return str;
        }
        if (length == 3) {
            return EMPTY_STRING;
        }
        char cCharAt = str.charAt(3);
        return (cCharAt == '-' || cCharAt == '_') ? str.substring(3) : str;
    }

    public static String toLegacyKey(String str) {
        String legacyKey = KeyTypeData.toLegacyKey(str);
        return (legacyKey == null && str.matches("[0-9a-zA-Z]+")) ? AsciiUtil.toLowerString(str) : legacyKey;
    }

    public static String toLegacyType(String str, String str2) {
        String legacyType = KeyTypeData.toLegacyType(str, str2, null, null);
        return (legacyType == null && str2.matches("[0-9a-zA-Z]+([_/\\-][0-9a-zA-Z]+)*")) ? AsciiUtil.toLowerString(str2) : legacyType;
    }

    public static String toUnicodeLocaleKey(String str) {
        String bcpKey = KeyTypeData.toBcpKey(str);
        return (bcpKey == null && UnicodeLocaleExtension.isKey(str)) ? AsciiUtil.toLowerString(str) : bcpKey;
    }

    public static String toUnicodeLocaleType(String str, String str2) {
        String bcpType = KeyTypeData.toBcpType(str, str2, null, null);
        return (bcpType == null && UnicodeLocaleExtension.isType(str2)) ? AsciiUtil.toLowerString(str2) : bcpType;
    }

    /* JADX WARN: Code duplicated, block: B:39:0x0095  */
    @Override // java.lang.Comparable
    public int compareTo(ULocale uLocale) {
        if (this == uLocale) {
            return 0;
        }
        int iCompareTo = getLanguage().compareTo(uLocale.getLanguage());
        if (iCompareTo == 0 && (iCompareTo = getScript().compareTo(uLocale.getScript())) == 0 && (iCompareTo = getCountry().compareTo(uLocale.getCountry())) == 0 && (iCompareTo = getVariant().compareTo(uLocale.getVariant())) == 0) {
            Iterator<String> keywords = getKeywords();
            Iterator<String> keywords2 = uLocale.getKeywords();
            if (keywords == null) {
                if (keywords2 == null) {
                    iCompareTo = 0;
                } else {
                    iCompareTo = -1;
                }
            } else if (keywords2 == null) {
                iCompareTo = 1;
            } else {
                while (iCompareTo == 0 && keywords.hasNext()) {
                    if (!keywords2.hasNext()) {
                        iCompareTo = 1;
                        break;
                    }
                    String next = keywords.next();
                    String next2 = keywords2.next();
                    int iCompareTo2 = next.compareTo(next2);
                    if (iCompareTo2 == 0) {
                        String keywordValue = getKeywordValue(next);
                        String keywordValue2 = uLocale.getKeywordValue(next2);
                        if (keywordValue == null) {
                            iCompareTo = keywordValue2 == null ? 0 : -1;
                        } else {
                            iCompareTo = keywordValue2 == null ? 1 : keywordValue.compareTo(keywordValue2);
                        }
                    } else {
                        iCompareTo = iCompareTo2;
                    }
                }
                if (iCompareTo == 0 && keywords2.hasNext()) {
                    iCompareTo = -1;
                }
            }
        }
        if (iCompareTo < 0) {
            return -1;
        }
        return iCompareTo > 0 ? 1 : 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ULocale) {
            return this.localeID.equals(((ULocale) obj).localeID);
        }
        return false;
    }

    public String getCharacterOrientation() {
        return ICUResourceTableAccess.getTableString(ICUData.ICU_BASE_NAME, this, "layout", "characters", "characters");
    }

    public String getExtension(char c) {
        if (LocaleExtensions.isValidKey(c)) {
            return extensions().getExtensionValue(Character.valueOf(c));
        }
        throw new IllegalArgumentException("Invalid extension key: " + c);
    }

    public Set<Character> getExtensionKeys() {
        return extensions().getKeys();
    }

    public ULocale getFallback() {
        if (this.localeID.length() == 0 || this.localeID.charAt(0) == '@') {
            return null;
        }
        return new ULocale(getFallbackString(this.localeID), (Locale) null);
    }

    public String getLineOrientation() {
        return ICUResourceTableAccess.getTableString(ICUData.ICU_BASE_NAME, this, "layout", "lines", "lines");
    }

    public Set<String> getUnicodeLocaleAttributes() {
        return extensions().getUnicodeLocaleAttributes();
    }

    public Set<String> getUnicodeLocaleKeys() {
        return extensions().getUnicodeLocaleKeys();
    }

    public String getUnicodeLocaleType(String str) {
        if (LocaleExtensions.isValidUnicodeLocaleKey(str)) {
            return extensions().getUnicodeLocaleType(str);
        }
        og.i(cq.j("Invalid Unicode locale key: ", str));
        return null;
    }

    public int hashCode() {
        return this.localeID.hashCode();
    }

    public boolean isRightToLeft() {
        int iIndexOf;
        String script = getScript();
        if (script.length() == 0) {
            String language = getLanguage();
            if (!language.isEmpty() && (iIndexOf = LANG_DIR_STRING.indexOf(language)) >= 0) {
                char cCharAt = LANG_DIR_STRING.charAt(language.length() + iIndexOf);
                if (cCharAt == '+') {
                    return true;
                }
                if (cCharAt == '-') {
                    return false;
                }
            }
            script = addLikelySubtags(this).getScript();
            if (script.length() == 0) {
                return false;
            }
        }
        return UScript.isRightToLeft(UScript.getCodeFromName(script));
    }

    public ULocale setKeywordValue(String str, String str2) {
        return new ULocale(setKeywordValue(this.localeID, str, str2), (Locale) null);
    }

    public String toLanguageTag() {
        BaseLocale baseLocaleBase = base();
        LocaleExtensions localeExtensionsExtensions = extensions();
        if (baseLocaleBase.getVariant().equalsIgnoreCase("POSIX")) {
            baseLocaleBase = BaseLocale.getInstance(baseLocaleBase.getLanguage(), baseLocaleBase.getScript(), baseLocaleBase.getRegion(), EMPTY_STRING);
            if (localeExtensionsExtensions.getUnicodeLocaleType("va") == null) {
                InternalLocaleBuilder internalLocaleBuilder = new InternalLocaleBuilder();
                try {
                    internalLocaleBuilder.setLocale(BaseLocale.ROOT, localeExtensionsExtensions);
                    internalLocaleBuilder.setUnicodeLocaleKeyword("va", "posix");
                    localeExtensionsExtensions = internalLocaleBuilder.getLocaleExtensions();
                } catch (LocaleSyntaxException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        LanguageTag locale = LanguageTag.parseLocale(baseLocaleBase, localeExtensionsExtensions);
        StringBuilder sb = new StringBuilder();
        String language = locale.getLanguage();
        if (language.length() > 0) {
            sb.append(LanguageTag.canonicalizeLanguage(language));
        }
        String script = locale.getScript();
        if (script.length() > 0) {
            sb.append(LanguageTag.SEP);
            sb.append(LanguageTag.canonicalizeScript(script));
        }
        String region = locale.getRegion();
        if (region.length() > 0) {
            sb.append(LanguageTag.SEP);
            sb.append(LanguageTag.canonicalizeRegion(region));
        }
        ArrayList arrayList = new ArrayList(locale.getVariants());
        Collections.sort(arrayList);
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            sb.append(LanguageTag.SEP);
            sb.append(LanguageTag.canonicalizeVariant((String) obj));
        }
        for (String str : locale.getExtensions()) {
            sb.append(LanguageTag.SEP);
            sb.append(LanguageTag.canonicalizeExtension(str));
        }
        String privateuse = locale.getPrivateuse();
        if (privateuse.length() > 0) {
            if (sb.length() == 0) {
                sb.append(UNDEFINED_LANGUAGE);
            }
            sb.append(LanguageTag.SEP);
            sb.append(LanguageTag.PRIVATEUSE);
            sb.append(LanguageTag.SEP);
            sb.append(LanguageTag.canonicalizePrivateuse(privateuse));
        }
        return sb.toString();
    }

    public Locale toLocale() {
        if (this.locale == null) {
            this.locale = JDKLocaleHelper.toLocale(this);
        }
        return this.locale;
    }

    public String toString() {
        return this.localeID;
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class Type {
        public /* synthetic */ Type(int i) {
            this();
        }

        public String toString() {
            if (this == ULocale.ACTUAL_LOCALE) {
                return "ACTUAL_LOCALE";
            }
            return this == ULocale.VALID_LOCALE ? "VALID_LOCALE" : cq.j("Unknown Type: ", Objects.toString(this));
        }

        private Type() {
        }
    }

    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public ULocale m27clone() {
        return this;
    }

    public String getISO3Country() {
        return getISO3Country(this.localeID);
    }

    public String getISO3Language() {
        return getISO3Language(this.localeID);
    }

    public String getCountry() {
        return base().getRegion();
    }

    public String getKeywordValue(String str) {
        return getKeywordValue(this.localeID, str);
    }

    public Iterator<String> getKeywords() {
        return getKeywords(this.localeID);
    }

    public String getLanguage() {
        return base().getLanguage();
    }

    public String getScript() {
        return base().getScript();
    }

    public String getVariant() {
        return base().getVariant();
    }

    public static ULocale createCanonical(ULocale uLocale) {
        return createCanonical(uLocale.getName());
    }

    public static String getDisplayKeyword(String str, String str2) {
        return getDisplayKeywordInternal(str, new ULocale(str2));
    }

    public static String getDisplayKeyword(String str, ULocale uLocale) {
        return getDisplayKeywordInternal(str, uLocale);
    }

    public static String setKeywordValue(String str, String str2, String str3) {
        LocaleIDParser localeIDParser = new LocaleIDParser(str);
        localeIDParser.setKeywordValue(str2, str3);
        return localeIDParser.getName();
    }

    public String getDisplayCountry(ULocale uLocale) {
        return getDisplayCountryInternal(this, uLocale);
    }

    public String getDisplayKeywordValue(String str, ULocale uLocale) {
        return getDisplayKeywordValueInternal(this, str, uLocale);
    }

    public String getDisplayName(ULocale uLocale) {
        return getDisplayNameInternal(this, uLocale);
    }

    public String getDisplayNameWithDialect(ULocale uLocale) {
        return getDisplayNameWithDialectInternal(this, uLocale);
    }

    public String getDisplayScript(ULocale uLocale) {
        return getDisplayScriptInternal(this, uLocale);
    }

    @Deprecated
    public String getDisplayScriptInContext(ULocale uLocale) {
        return getDisplayScriptInContextInternal(this, uLocale);
    }

    public String getDisplayVariant(ULocale uLocale) {
        return getDisplayVariantInternal(this, uLocale);
    }

    private ULocale(String str, Locale locale) {
        this.localeID = str;
        this.locale = locale;
    }

    public String getDisplayCountry() {
        return getDisplayCountryInternal(this, getDefault(Category.DISPLAY));
    }

    public String getDisplayKeywordValue(String str) {
        return getDisplayKeywordValueInternal(this, str, getDefault(Category.DISPLAY));
    }

    public String getDisplayLanguage(ULocale uLocale) {
        return getDisplayLanguageInternal(this, uLocale, false);
    }

    public String getDisplayLanguageWithDialect(ULocale uLocale) {
        return getDisplayLanguageInternal(this, uLocale, true);
    }

    public String getDisplayName() {
        return getDisplayNameInternal(this, getDefault(Category.DISPLAY));
    }

    public String getDisplayNameWithDialect() {
        return getDisplayNameWithDialectInternal(this, getDefault(Category.DISPLAY));
    }

    public String getDisplayScript() {
        return getDisplayScriptInternal(this, getDefault(Category.DISPLAY));
    }

    @Deprecated
    public String getDisplayScriptInContext() {
        return getDisplayScriptInContextInternal(this, getDefault(Category.DISPLAY));
    }

    public String getDisplayVariant() {
        return getDisplayVariantInternal(this, getDefault(Category.DISPLAY));
    }

    public static String getDisplayCountry(String str, ULocale uLocale) {
        return getDisplayCountryInternal(new ULocale(str), uLocale);
    }

    public static String getDisplayKeywordValue(String str, String str2, ULocale uLocale) {
        return getDisplayKeywordValueInternal(new ULocale(str), str2, uLocale);
    }

    public static String getDisplayName(String str, ULocale uLocale) {
        return getDisplayNameInternal(new ULocale(str), uLocale);
    }

    public static String getDisplayNameWithDialect(String str, ULocale uLocale) {
        return getDisplayNameWithDialectInternal(new ULocale(str), uLocale);
    }

    public static String getDisplayScript(String str, ULocale uLocale) {
        return getDisplayScriptInternal(new ULocale(str), uLocale);
    }

    @Deprecated
    public static String getDisplayScriptInContext(String str, ULocale uLocale) {
        return getDisplayScriptInContextInternal(new ULocale(str), uLocale);
    }

    public static String getDisplayVariant(String str, ULocale uLocale) {
        return getDisplayVariantInternal(new ULocale(str), uLocale);
    }

    public String getDisplayLanguage() {
        return getDisplayLanguageInternal(this, getDefault(Category.DISPLAY), false);
    }

    public String getDisplayLanguageWithDialect() {
        return getDisplayLanguageInternal(this, getDefault(Category.DISPLAY), true);
    }

    public static String getDisplayLanguage(String str, ULocale uLocale) {
        return getDisplayLanguageInternal(new ULocale(str), uLocale, false);
    }

    public static String getDisplayLanguageWithDialect(String str, ULocale uLocale) {
        return getDisplayLanguageInternal(new ULocale(str), uLocale, true);
    }

    public ULocale(String str) {
        this.localeID = getName(str);
    }

    public String getBaseName() {
        return getBaseName(this.localeID);
    }

    public ULocale(String str, String str2) {
        this(str, str2, (String) null);
    }

    public /* synthetic */ ULocale(String str, Locale locale, int i) {
        this(str, locale);
    }

    public static String getFallback(String str) {
        return getFallbackString(getName(str));
    }

    public static synchronized void setDefault(ULocale uLocale) {
        Locale.setDefault(uLocale.toLocale());
        defaultULocale = uLocale;
        for (Category category : Category.values()) {
            setDefault(category, uLocale);
        }
    }

    public static ULocale minimizeSubtags(ULocale uLocale) {
        return minimizeSubtags(uLocale, Minimize.FAVOR_REGION);
    }

    public static ULocale acceptLanguage(String str, ULocale[] uLocaleArr, boolean[] zArr) {
        if (zArr != null) {
            zArr[0] = true;
        }
        try {
            LocalePriorityList localePriorityListBuild = LocalePriorityList.add(str).build();
            LocaleMatcher.Builder builder = LocaleMatcher.builder();
            for (ULocale uLocale : uLocaleArr) {
                builder.addSupportedULocale(uLocale);
            }
            LocaleMatcher.Result bestMatchResult = builder.build().getBestMatchResult(localePriorityListBuild);
            if (bestMatchResult.getDesiredIndex() >= 0) {
                if (zArr != null && bestMatchResult.getDesiredULocale().equals(bestMatchResult.getSupportedULocale())) {
                    zArr[0] = false;
                }
                return bestMatchResult.getSupportedULocale();
            }
        } catch (IllegalArgumentException unused) {
        }
        return null;
    }

    public static ULocale acceptLanguage(String str, boolean[] zArr) {
        return acceptLanguage(str, getAvailableLocales(), zArr);
    }

    public static ULocale acceptLanguage(ULocale[] uLocaleArr, boolean[] zArr) {
        return acceptLanguage(uLocaleArr, getAvailableLocales(), zArr);
    }

    public String getName() {
        return this.localeID;
    }

    public static ULocale getDefault() {
        ULocale uLocale = defaultULocale;
        if (uLocale == null) {
            return ROOT;
        }
        if (uLocale.locale.equals(Locale.getDefault())) {
            return uLocale;
        }
        synchronized (ULocale.class) {
            try {
                Locale locale = Locale.getDefault();
                ULocale uLocale2 = defaultULocale;
                if (uLocale2.locale.equals(locale)) {
                    return uLocale2;
                }
                ULocale uLocaleForLocale = forLocale(locale);
                if (!JDKLocaleHelper.hasLocaleCategories()) {
                    Locale[] localeArr = new Locale[Category.values().length];
                    ULocale[] uLocaleArr = new ULocale[Category.values().length];
                    for (Category category : Category.values()) {
                        int iOrdinal = category.ordinal();
                        localeArr[iOrdinal] = locale;
                        uLocaleArr[iOrdinal] = uLocaleForLocale;
                    }
                    defaultCategoryState = new DefaultCategoryState(localeArr, uLocaleArr);
                }
                defaultULocale = uLocaleForLocale;
                return uLocaleForLocale;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
