package com.ibm.icu.impl;

import com.ibm.icu.impl.locale.AsciiUtil;
import com.ibm.icu.impl.locale.BaseLocale;
import com.ibm.icu.lang.UCharacter;
import com.ibm.icu.lang.UScript;
import com.ibm.icu.text.BreakIterator;
import com.ibm.icu.text.CaseMap;
import com.ibm.icu.text.DisplayContext;
import com.ibm.icu.text.LocaleDisplayNames;
import com.ibm.icu.util.ULocale;
import com.ibm.icu.util.UResourceBundle;
import defpackage.cq;
import defpackage.og;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class LocaleDisplayNamesImpl extends LocaleDisplayNames {
    private static final CaseMap.Title TO_TITLE_WHOLE_STRING_NO_LOWERCASE;
    private static final Cache cache = new Cache(0);
    private static final Map<String, CapitalizationContextUsage> contextUsageTypeMap;
    private final DisplayContext capitalization;
    private transient BreakIterator capitalizationBrkIter;
    private boolean[] capitalizationUsage;
    private final CurrencyData.CurrencyDisplayInfo currencyDisplayInfo;
    private final LocaleDisplayNames.DialectHandling dialectHandling;
    private final String format;
    private final char formatCloseParen;
    private final char formatOpenParen;
    private final char formatReplaceCloseParen;
    private final char formatReplaceOpenParen;
    private final String keyTypeFormat;
    private final DataTable langData;
    private final ULocale locale;
    private final DisplayContext nameLength;
    private final DataTable regionData;
    private final String separatorFormat;
    private final DisplayContext substituteHandling;

    /* JADX INFO: renamed from: com.ibm.icu.impl.LocaleDisplayNamesImpl$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ibm$icu$impl$LocaleDisplayNamesImpl$DataTableType;
        static final /* synthetic */ int[] $SwitchMap$com$ibm$icu$text$DisplayContext$Type;

        static {
            int[] iArr = new int[DataTableType.values().length];
            $SwitchMap$com$ibm$icu$impl$LocaleDisplayNamesImpl$DataTableType = iArr;
            try {
                iArr[DataTableType.LANG.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ibm$icu$impl$LocaleDisplayNamesImpl$DataTableType[DataTableType.REGION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[DisplayContext.Type.values().length];
            $SwitchMap$com$ibm$icu$text$DisplayContext$Type = iArr2;
            try {
                iArr2[DisplayContext.Type.DIALECT_HANDLING.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$ibm$icu$text$DisplayContext$Type[DisplayContext.Type.CAPITALIZATION.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$ibm$icu$text$DisplayContext$Type[DisplayContext.Type.DISPLAY_LENGTH.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$ibm$icu$text$DisplayContext$Type[DisplayContext.Type.SUBSTITUTE_HANDLING.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public enum CapitalizationContextUsage {
        LANGUAGE,
        SCRIPT,
        TERRITORY,
        VARIANT,
        KEY,
        KEYVALUE
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public enum DataTableType {
        LANG,
        REGION
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static abstract class DataTables {
        public static DataTables load(String str) {
            try {
                return (DataTables) Class.forName(str).newInstance();
            } catch (Throwable unused) {
                return new DataTables() { // from class: com.ibm.icu.impl.LocaleDisplayNamesImpl.DataTables.1
                    @Override // com.ibm.icu.impl.LocaleDisplayNamesImpl.DataTables
                    public DataTable get(ULocale uLocale, boolean z) {
                        return new DataTable(z);
                    }
                };
            }
        }

        public abstract DataTable get(ULocale uLocale, boolean z);
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class ICUDataTable extends DataTable {
        private final ICUResourceBundle bundle;

        public ICUDataTable(String str, ULocale uLocale, boolean z) {
            super(z);
            this.bundle = (ICUResourceBundle) UResourceBundle.getBundleInstance(str, uLocale.getBaseName());
        }

        @Override // com.ibm.icu.impl.LocaleDisplayNamesImpl.DataTable
        public String get(String str, String str2, String str3) {
            return ICUResourceTableAccess.getTableString(this.bundle, str, str2, str3, this.nullIfNotFound ? null : str3);
        }

        @Override // com.ibm.icu.impl.LocaleDisplayNamesImpl.DataTable
        public ULocale getLocale() {
            return this.bundle.getULocale();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static abstract class ICUDataTables extends DataTables {
        private final String path;

        public ICUDataTables(String str) {
            this.path = str;
        }

        @Override // com.ibm.icu.impl.LocaleDisplayNamesImpl.DataTables
        public DataTable get(ULocale uLocale, boolean z) {
            return new ICUDataTable(this.path, uLocale, z);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class LangDataTables {
        static final DataTables impl = DataTables.load("com.ibm.icu.impl.ICULangDataTables");
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class RegionDataTables {
        static final DataTables impl = DataTables.load("com.ibm.icu.impl.ICURegionDataTables");
    }

    static {
        HashMap map = new HashMap();
        contextUsageTypeMap = map;
        map.put("languages", CapitalizationContextUsage.LANGUAGE);
        map.put("script", CapitalizationContextUsage.SCRIPT);
        map.put("territory", CapitalizationContextUsage.TERRITORY);
        map.put("variant", CapitalizationContextUsage.VARIANT);
        map.put("key", CapitalizationContextUsage.KEY);
        map.put("keyValue", CapitalizationContextUsage.KEYVALUE);
        TO_TITLE_WHOLE_STRING_NO_LOWERCASE = CaseMap.toTitle().wholeString().noLowercase();
    }

    public LocaleDisplayNamesImpl(ULocale uLocale, DisplayContext... displayContextArr) {
        boolean z;
        this.capitalizationUsage = null;
        this.capitalizationBrkIter = null;
        LocaleDisplayNames.DialectHandling dialectHandling = LocaleDisplayNames.DialectHandling.STANDARD_NAMES;
        DisplayContext displayContext = DisplayContext.CAPITALIZATION_NONE;
        DisplayContext displayContext2 = DisplayContext.LENGTH_FULL;
        DisplayContext displayContext3 = DisplayContext.SUBSTITUTE;
        int length = displayContextArr.length;
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                break;
            }
            DisplayContext displayContext4 = displayContextArr[i2];
            int i3 = AnonymousClass1.$SwitchMap$com$ibm$icu$text$DisplayContext$Type[displayContext4.type().ordinal()];
            if (i3 == 1) {
                dialectHandling = displayContext4.value() == DisplayContext.STANDARD_NAMES.value() ? LocaleDisplayNames.DialectHandling.STANDARD_NAMES : LocaleDisplayNames.DialectHandling.DIALECT_NAMES;
            } else if (i3 == 2) {
                displayContext = displayContext4;
            } else if (i3 == 3) {
                displayContext2 = displayContext4;
            } else if (i3 == 4) {
                displayContext3 = displayContext4;
            }
            i2++;
        }
        this.dialectHandling = dialectHandling;
        this.capitalization = displayContext;
        this.nameLength = displayContext2;
        this.substituteHandling = displayContext3;
        DataTables dataTables = LangDataTables.impl;
        DisplayContext displayContext5 = DisplayContext.NO_SUBSTITUTE;
        DataTable dataTable = dataTables.get(uLocale, displayContext3 == displayContext5);
        this.langData = dataTable;
        DataTable dataTable2 = RegionDataTables.impl.get(uLocale, displayContext3 == displayContext5);
        this.regionData = dataTable2;
        this.locale = ULocale.ROOT.equals(dataTable.getLocale()) ? dataTable2.getLocale() : dataTable.getLocale();
        String str = dataTable.get("localeDisplayPattern", "separator");
        str = (str == null || "separator".equals(str)) ? "{0}, {1}" : str;
        StringBuilder sb = new StringBuilder();
        this.separatorFormat = SimpleFormatterImpl.compileToStringMinMaxArguments(str, sb, 2, 2);
        String str2 = dataTable.get("localeDisplayPattern", "pattern");
        str2 = (str2 == null || "pattern".equals(str2)) ? "{0} ({1})" : str2;
        this.format = SimpleFormatterImpl.compileToStringMinMaxArguments(str2, sb, 2, 2);
        if (str2.contains("（")) {
            this.formatOpenParen = (char) 65288;
            this.formatCloseParen = (char) 65289;
            this.formatReplaceOpenParen = (char) 65339;
            this.formatReplaceCloseParen = (char) 65341;
        } else {
            this.formatOpenParen = '(';
            this.formatCloseParen = ')';
            this.formatReplaceOpenParen = '[';
            this.formatReplaceCloseParen = ']';
        }
        String str3 = dataTable.get("localeDisplayPattern", "keyTypePattern");
        this.keyTypeFormat = SimpleFormatterImpl.compileToStringMinMaxArguments((str3 == null || "keyTypePattern".equals(str3)) ? "{0}={1}" : str3, sb, 2, 2);
        if (displayContext == DisplayContext.CAPITALIZATION_FOR_UI_LIST_OR_MENU || displayContext == DisplayContext.CAPITALIZATION_FOR_STANDALONE) {
            this.capitalizationUsage = new boolean[CapitalizationContextUsage.values().length];
            ICUResourceBundle iCUResourceBundle = (ICUResourceBundle) UResourceBundle.getBundleInstance(ICUData.ICU_BASE_NAME, uLocale);
            CapitalizationContextSink capitalizationContextSink = new CapitalizationContextSink(this, i);
            try {
                iCUResourceBundle.getAllItemsWithFallback("contextTransforms", capitalizationContextSink);
            } catch (MissingResourceException unused) {
            }
            z = capitalizationContextSink.hasCapitalizationUsage;
        } else {
            z = false;
        }
        if (z || displayContext == DisplayContext.CAPITALIZATION_FOR_BEGINNING_OF_SENTENCE) {
            this.capitalizationBrkIter = BreakIterator.getSentenceInstance(uLocale);
        }
        this.currencyDisplayInfo = CurrencyData.provider.getInstance(uLocale, false);
    }

    private String adjustForUsageAndContext(CapitalizationContextUsage capitalizationContextUsage, String str) {
        String titleCase;
        boolean[] zArr;
        if (str == null || str.length() <= 0 || !UCharacter.isLowerCase(str.codePointAt(0)) || (this.capitalization != DisplayContext.CAPITALIZATION_FOR_BEGINNING_OF_SENTENCE && ((zArr = this.capitalizationUsage) == null || !zArr[capitalizationContextUsage.ordinal()]))) {
            return str;
        }
        synchronized (this) {
            try {
                if (this.capitalizationBrkIter == null) {
                    this.capitalizationBrkIter = BreakIterator.getSentenceInstance(this.locale);
                }
                titleCase = UCharacter.toTitleCase(this.locale, str, this.capitalizationBrkIter, 768);
            } catch (Throwable th) {
                throw th;
            }
        }
        return titleCase;
    }

    private StringBuilder appendWithSep(String str, StringBuilder sb) {
        if (sb.length() == 0) {
            sb.append(str);
            return sb;
        }
        SimpleFormatterImpl.formatAndReplace(this.separatorFormat, sb, null, sb, str);
        return sb;
    }

    public static LocaleDisplayNames getInstance(ULocale uLocale, LocaleDisplayNames.DialectHandling dialectHandling) {
        return cache.get(uLocale, dialectHandling);
    }

    public static boolean haveData(DataTableType dataTableType) {
        int i = AnonymousClass1.$SwitchMap$com$ibm$icu$impl$LocaleDisplayNamesImpl$DataTableType[dataTableType.ordinal()];
        if (i == 1) {
            return LangDataTables.impl instanceof ICUDataTables;
        }
        if (i == 2) {
            return RegionDataTables.impl instanceof ICUDataTables;
        }
        og.i("unknown type: ".concat(String.valueOf(dataTableType)));
        return false;
    }

    private String keyDisplayName(String str, boolean z) {
        String str2 = this.langData.get("Keys", str);
        return z ? str2 : adjustForUsageAndContext(CapitalizationContextUsage.KEY, str2);
    }

    private String keyValueDisplayName(String str, String str2, boolean z) {
        String str3;
        if (str.equals("currency")) {
            String name = this.currencyDisplayInfo.getName(AsciiUtil.toUpperString(str2));
            if (name != null) {
                str2 = name;
            }
        } else {
            if (this.nameLength != DisplayContext.LENGTH_SHORT || (str3 = this.langData.get("Types%short", str, str2)) == null || str3.equals(str2)) {
                str3 = null;
            }
            str2 = str3 == null ? this.langData.get("Types", str, str2) : str3;
        }
        return z ? str2 : adjustForUsageAndContext(CapitalizationContextUsage.KEYVALUE, str2);
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0069  */
    /* JADX WARN: Code duplicated, block: B:33:0x007d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:34:0x007f  */
    /* JADX WARN: Code duplicated, block: B:39:0x0091  */
    private String localeDisplayNameInternal(ULocale uLocale) {
        String compiledPattern;
        String strK;
        String strK2;
        String language = uLocale.getLanguage();
        if (language.isEmpty()) {
            language = "und";
        }
        String script = uLocale.getScript();
        String country = uLocale.getCountry();
        String variant = uLocale.getVariant();
        boolean z = script.length() > 0;
        boolean z2 = country.length() > 0;
        boolean z3 = variant.length() > 0;
        if (this.dialectHandling != LocaleDisplayNames.DialectHandling.DIALECT_NAMES) {
            compiledPattern = null;
        } else if (z && z2) {
            String str = language + BaseLocale.SEP + script + BaseLocale.SEP + country;
            compiledPattern = localeIdName(str);
            if (compiledPattern != null && !compiledPattern.equals(str)) {
                z = false;
                z2 = false;
            } else if (!z) {
                if (z2) {
                    compiledPattern = null;
                } else {
                    compiledPattern = null;
                }
            } else if (z2) {
                compiledPattern = null;
            } else {
                compiledPattern = null;
            }
        } else if (!z && (compiledPattern = localeIdName((strK2 = cq.k(language, BaseLocale.SEP, script)))) != null && !compiledPattern.equals(strK2)) {
            z = false;
        } else if (z2 || (compiledPattern = localeIdName((strK = cq.k(language, BaseLocale.SEP, country)))) == null || compiledPattern.equals(strK)) {
            compiledPattern = null;
        } else {
            z2 = false;
        }
        if (compiledPattern == null) {
            String strLocaleIdName = localeIdName(language);
            if (strLocaleIdName == null) {
                return null;
            }
            compiledPattern = strLocaleIdName.replace(this.formatOpenParen, this.formatReplaceOpenParen).replace(this.formatCloseParen, this.formatReplaceCloseParen);
        }
        StringBuilder sb = new StringBuilder();
        if (z) {
            String strScriptDisplayNameInContext = scriptDisplayNameInContext(script, true);
            if (strScriptDisplayNameInContext == null) {
                return null;
            }
            sb.append(strScriptDisplayNameInContext.replace(this.formatOpenParen, this.formatReplaceOpenParen).replace(this.formatCloseParen, this.formatReplaceCloseParen));
        }
        if (z2) {
            String strRegionDisplayName = regionDisplayName(country, true);
            if (strRegionDisplayName == null) {
                return null;
            }
            appendWithSep(strRegionDisplayName.replace(this.formatOpenParen, this.formatReplaceOpenParen).replace(this.formatCloseParen, this.formatReplaceCloseParen), sb);
        }
        if (z3) {
            String strVariantDisplayName = variantDisplayName(variant, true);
            if (strVariantDisplayName == null) {
                return null;
            }
            appendWithSep(strVariantDisplayName.replace(this.formatOpenParen, this.formatReplaceOpenParen).replace(this.formatCloseParen, this.formatReplaceCloseParen), sb);
        }
        Iterator<String> keywords = uLocale.getKeywords();
        if (keywords != null) {
            while (keywords.hasNext()) {
                String next = keywords.next();
                String keywordValue = uLocale.getKeywordValue(next);
                String strKeyDisplayName = keyDisplayName(next, true);
                if (strKeyDisplayName == null) {
                    return null;
                }
                String strReplace = strKeyDisplayName.replace(this.formatOpenParen, this.formatReplaceOpenParen).replace(this.formatCloseParen, this.formatReplaceCloseParen);
                String strKeyValueDisplayName = keyValueDisplayName(next, keywordValue, true);
                if (strKeyValueDisplayName == null) {
                    return null;
                }
                String strReplace2 = strKeyValueDisplayName.replace(this.formatOpenParen, this.formatReplaceOpenParen).replace(this.formatCloseParen, this.formatReplaceCloseParen);
                if (!strReplace2.equals(keywordValue)) {
                    appendWithSep(strReplace2, sb);
                } else if (next.equals(strReplace)) {
                    StringBuilder sbAppendWithSep = appendWithSep(strReplace, sb);
                    sbAppendWithSep.append("=");
                    sbAppendWithSep.append(strReplace2);
                } else {
                    appendWithSep(SimpleFormatterImpl.formatCompiledPattern(this.keyTypeFormat, strReplace, strReplace2), sb);
                }
            }
        }
        String string = sb.length() > 0 ? sb.toString() : null;
        if (string != null) {
            compiledPattern = SimpleFormatterImpl.formatCompiledPattern(this.format, compiledPattern, string);
        }
        return adjustForUsageAndContext(CapitalizationContextUsage.LANGUAGE, compiledPattern);
    }

    private String localeIdName(String str) {
        String str2;
        String str3;
        DisplayContext displayContext = this.nameLength;
        DisplayContext displayContext2 = DisplayContext.LENGTH_SHORT;
        if (displayContext == displayContext2 && (str3 = this.langData.get("Languages%short", str)) != null && !str3.equals(str)) {
            return str3;
        }
        String str4 = this.langData.get("Languages", str);
        if ((str4 != null && !str4.equals(str)) || str.indexOf(95) >= 0) {
            return str4;
        }
        String name = ULocale.createCanonical(str).getName();
        return (this.nameLength != displayContext2 || (str2 = this.langData.get("Languages%short", name)) == null || str2.equals(name)) ? this.langData.get("Languages", name) : str2;
    }

    private LocaleDisplayNames.UiListItem newRow(ULocale uLocale, DisplayContext displayContext) {
        ULocale uLocaleMinimizeSubtags = ULocale.minimizeSubtags(uLocale, ULocale.Minimize.FAVOR_SCRIPT);
        String displayName = uLocale.getDisplayName(this.locale);
        DisplayContext displayContext2 = DisplayContext.CAPITALIZATION_FOR_UI_LIST_OR_MENU;
        if (displayContext == displayContext2) {
            displayName = toTitleWholeStringNoLowercase(this.locale, displayName);
        }
        String displayName2 = uLocale.getDisplayName(uLocale);
        if (displayContext == displayContext2) {
            displayName2 = toTitleWholeStringNoLowercase(uLocale, displayName2);
        }
        return new LocaleDisplayNames.UiListItem(uLocaleMinimizeSubtags, uLocale, displayName, displayName2);
    }

    private String regionDisplayName(String str, boolean z) {
        String str2;
        if (this.nameLength == DisplayContext.LENGTH_SHORT && (str2 = this.regionData.get("Countries%short", str)) != null && !str2.equals(str)) {
            return z ? str2 : adjustForUsageAndContext(CapitalizationContextUsage.TERRITORY, str2);
        }
        String str3 = this.regionData.get("Countries", str);
        return z ? str3 : adjustForUsageAndContext(CapitalizationContextUsage.TERRITORY, str3);
    }

    private String scriptDisplayNameInContext(String str, boolean z) {
        String str2;
        if (this.nameLength == DisplayContext.LENGTH_SHORT && (str2 = this.langData.get("Scripts%short", str)) != null && !str2.equals(str)) {
            return z ? str2 : adjustForUsageAndContext(CapitalizationContextUsage.SCRIPT, str2);
        }
        String str3 = this.langData.get("Scripts", str);
        return z ? str3 : adjustForUsageAndContext(CapitalizationContextUsage.SCRIPT, str3);
    }

    private static String toTitleWholeStringNoLowercase(ULocale uLocale, String str) {
        return TO_TITLE_WHOLE_STRING_NO_LOWERCASE.apply(uLocale.toLocale(), null, str);
    }

    private String variantDisplayName(String str, boolean z) {
        String str2 = this.langData.get("Variants", str);
        return z ? str2 : adjustForUsageAndContext(CapitalizationContextUsage.VARIANT, str2);
    }

    @Override // com.ibm.icu.text.LocaleDisplayNames
    public DisplayContext getContext(DisplayContext.Type type) {
        int i = AnonymousClass1.$SwitchMap$com$ibm$icu$text$DisplayContext$Type[type.ordinal()];
        if (i == 1) {
            return this.dialectHandling == LocaleDisplayNames.DialectHandling.STANDARD_NAMES ? DisplayContext.STANDARD_NAMES : DisplayContext.DIALECT_NAMES;
        }
        if (i == 2) {
            return this.capitalization;
        }
        if (i != 3) {
            return i != 4 ? DisplayContext.STANDARD_NAMES : this.substituteHandling;
        }
        return this.nameLength;
    }

    @Override // com.ibm.icu.text.LocaleDisplayNames
    public LocaleDisplayNames.DialectHandling getDialectHandling() {
        return this.dialectHandling;
    }

    @Override // com.ibm.icu.text.LocaleDisplayNames
    public ULocale getLocale() {
        return this.locale;
    }

    @Override // com.ibm.icu.text.LocaleDisplayNames
    public List<LocaleDisplayNames.UiListItem> getUiListCompareWholeItems(Set<ULocale> set, Comparator<LocaleDisplayNames.UiListItem> comparator) {
        DisplayContext context = getContext(DisplayContext.Type.CAPITALIZATION);
        ArrayList arrayList = new ArrayList();
        HashMap map = new HashMap();
        ULocale.Builder builder = new ULocale.Builder();
        for (ULocale uLocale : set) {
            builder.setLocale(uLocale);
            ULocale uLocaleAddLikelySubtags = ULocale.addLikelySubtags(uLocale);
            ULocale uLocale2 = new ULocale(uLocaleAddLikelySubtags.getLanguage());
            Set hashSet = (Set) map.get(uLocale2);
            if (hashSet == null) {
                hashSet = new HashSet();
                map.put(uLocale2, hashSet);
            }
            hashSet.add(uLocaleAddLikelySubtags);
        }
        for (Map.Entry entry : map.entrySet()) {
            ULocale uLocale3 = (ULocale) entry.getKey();
            Set<ULocale> set2 = (Set) entry.getValue();
            if (set2.size() == 1) {
                arrayList.add(newRow(ULocale.minimizeSubtags((ULocale) set2.iterator().next(), ULocale.Minimize.FAVOR_SCRIPT), context));
            } else {
                HashSet hashSet2 = new HashSet();
                HashSet hashSet3 = new HashSet();
                ULocale uLocaleAddLikelySubtags2 = ULocale.addLikelySubtags(uLocale3);
                hashSet2.add(uLocaleAddLikelySubtags2.getScript());
                hashSet3.add(uLocaleAddLikelySubtags2.getCountry());
                for (ULocale uLocale4 : set2) {
                    hashSet2.add(uLocale4.getScript());
                    hashSet3.add(uLocale4.getCountry());
                }
                boolean z = hashSet2.size() > 1;
                boolean z2 = hashSet3.size() > 1;
                Iterator it = set2.iterator();
                while (it.hasNext()) {
                    ULocale.Builder locale = builder.setLocale((ULocale) it.next());
                    if (!z) {
                        locale.setScript("");
                    }
                    if (!z2) {
                        locale.setRegion("");
                    }
                    arrayList.add(newRow(locale.build(), context));
                }
            }
        }
        Collections.sort(arrayList, comparator);
        return arrayList;
    }

    @Override // com.ibm.icu.text.LocaleDisplayNames
    public String languageDisplayName(String str) {
        String str2;
        String str3;
        if (str.equals("root") || str.indexOf(95) != -1) {
            if (this.substituteHandling == DisplayContext.SUBSTITUTE) {
                return str;
            }
            return null;
        }
        DisplayContext displayContext = this.nameLength;
        DisplayContext displayContext2 = DisplayContext.LENGTH_SHORT;
        if (displayContext == displayContext2 && (str3 = this.langData.get("Languages%short", str)) != null && !str3.equals(str)) {
            return adjustForUsageAndContext(CapitalizationContextUsage.LANGUAGE, str3);
        }
        String str4 = this.langData.get("Languages", str);
        if (str4 == null || str4.equals(str)) {
            String name = ULocale.createCanonical(str).getName();
            if (this.nameLength == displayContext2 && (str2 = this.langData.get("Languages%short", name)) != null && !str2.equals(name)) {
                return adjustForUsageAndContext(CapitalizationContextUsage.LANGUAGE, str2);
            }
            str4 = this.langData.get("Languages", name);
        }
        return adjustForUsageAndContext(CapitalizationContextUsage.LANGUAGE, str4);
    }

    @Override // com.ibm.icu.text.LocaleDisplayNames
    public String localeDisplayName(String str) {
        return localeDisplayNameInternal(new ULocale(str));
    }

    @Override // com.ibm.icu.text.LocaleDisplayNames
    public String scriptDisplayName(String str) {
        String str2;
        String str3 = this.langData.get("Scripts%stand-alone", str);
        if (str3 == null || str3.equals(str)) {
            if (this.nameLength == DisplayContext.LENGTH_SHORT && (str2 = this.langData.get("Scripts%short", str)) != null && !str2.equals(str)) {
                return adjustForUsageAndContext(CapitalizationContextUsage.SCRIPT, str2);
            }
            str3 = this.langData.get("Scripts", str);
        }
        return adjustForUsageAndContext(CapitalizationContextUsage.SCRIPT, str3);
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class Cache {
        private volatile CacheEntry entry;

        /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
        public static class CacheEntry {
            final DisplayContext capitalization;
            final LocaleDisplayNames.DialectHandling dialectHandling;
            final ULocale locale;
            final DisplayContext nameLength;
            final DisplayContext substituteHandling;
            final LocaleDisplayNames value;

            public CacheEntry(ULocale uLocale, LocaleDisplayNames.DialectHandling dialectHandling, DisplayContext displayContext, DisplayContext displayContext2, DisplayContext displayContext3, LocaleDisplayNames localeDisplayNames) {
                this.locale = uLocale;
                this.dialectHandling = dialectHandling;
                this.capitalization = displayContext;
                this.nameLength = displayContext2;
                this.substituteHandling = displayContext3;
                this.value = localeDisplayNames;
            }

            public boolean matches(ULocale uLocale, LocaleDisplayNames.DialectHandling dialectHandling, DisplayContext displayContext, DisplayContext displayContext2, DisplayContext displayContext3) {
                return dialectHandling == this.dialectHandling && displayContext == this.capitalization && displayContext2 == this.nameLength && displayContext3 == this.substituteHandling && uLocale.equals(this.locale);
            }
        }

        public /* synthetic */ Cache(int i) {
            this();
        }

        public LocaleDisplayNames get(ULocale uLocale, DisplayContext... displayContextArr) {
            LocaleDisplayNames.DialectHandling dialectHandling = LocaleDisplayNames.DialectHandling.STANDARD_NAMES;
            DisplayContext displayContext = DisplayContext.CAPITALIZATION_NONE;
            DisplayContext displayContext2 = DisplayContext.LENGTH_FULL;
            LocaleDisplayNames.DialectHandling dialectHandling2 = dialectHandling;
            DisplayContext displayContext3 = displayContext;
            DisplayContext displayContext4 = displayContext2;
            DisplayContext displayContext5 = DisplayContext.SUBSTITUTE;
            for (DisplayContext displayContext6 : displayContextArr) {
                int i = AnonymousClass1.$SwitchMap$com$ibm$icu$text$DisplayContext$Type[displayContext6.type().ordinal()];
                if (i == 1) {
                    dialectHandling2 = displayContext6.value() == DisplayContext.STANDARD_NAMES.value() ? LocaleDisplayNames.DialectHandling.STANDARD_NAMES : LocaleDisplayNames.DialectHandling.DIALECT_NAMES;
                } else if (i == 2) {
                    displayContext3 = displayContext6;
                } else if (i == 3) {
                    displayContext4 = displayContext6;
                } else if (i == 4) {
                    displayContext5 = displayContext6;
                }
            }
            CacheEntry cacheEntry = this.entry;
            if (cacheEntry != null && cacheEntry.matches(uLocale, dialectHandling2, displayContext3, displayContext4, displayContext5)) {
                return cacheEntry.value;
            }
            LocaleDisplayNamesImpl localeDisplayNamesImpl = new LocaleDisplayNamesImpl(uLocale, displayContextArr);
            this.entry = new CacheEntry(uLocale, dialectHandling2, displayContext3, displayContext4, displayContext5, localeDisplayNamesImpl);
            return localeDisplayNamesImpl;
        }

        private Cache() {
        }

        public LocaleDisplayNames get(ULocale uLocale, LocaleDisplayNames.DialectHandling dialectHandling) {
            ULocale uLocale2;
            LocaleDisplayNames.DialectHandling dialectHandling2;
            CacheEntry cacheEntry = this.entry;
            if (cacheEntry != null) {
                uLocale2 = uLocale;
                dialectHandling2 = dialectHandling;
                if (cacheEntry.matches(uLocale2, dialectHandling2, DisplayContext.CAPITALIZATION_NONE, DisplayContext.LENGTH_FULL, DisplayContext.SUBSTITUTE)) {
                    return cacheEntry.value;
                }
            } else {
                uLocale2 = uLocale;
                dialectHandling2 = dialectHandling;
            }
            LocaleDisplayNamesImpl localeDisplayNamesImpl = new LocaleDisplayNamesImpl(uLocale2, dialectHandling2);
            this.entry = new CacheEntry(uLocale2, dialectHandling2, DisplayContext.CAPITALIZATION_NONE, DisplayContext.LENGTH_FULL, DisplayContext.SUBSTITUTE, localeDisplayNamesImpl);
            return localeDisplayNamesImpl;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class DataTable {
        final boolean nullIfNotFound;

        public DataTable(boolean z) {
            this.nullIfNotFound = z;
        }

        public String get(String str, String str2, String str3) {
            if (this.nullIfNotFound) {
                return null;
            }
            return str3;
        }

        public ULocale getLocale() {
            return ULocale.ROOT;
        }

        public String get(String str, String str2) {
            return get(str, null, str2);
        }
    }

    public static LocaleDisplayNames getInstance(ULocale uLocale, DisplayContext... displayContextArr) {
        return cache.get(uLocale, displayContextArr);
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public final class CapitalizationContextSink extends UResource.Sink {
        boolean hasCapitalizationUsage;

        private CapitalizationContextSink() {
            this.hasCapitalizationUsage = false;
        }

        @Override // com.ibm.icu.impl.UResource.Sink
        public void put(UResource.Key key, UResource.Value value, boolean z) {
            UResource.Table table = value.getTable();
            for (int i = 0; table.getKeyAndValue(i, key, value); i++) {
                CapitalizationContextUsage capitalizationContextUsage = (CapitalizationContextUsage) LocaleDisplayNamesImpl.contextUsageTypeMap.get(key.toString());
                if (capitalizationContextUsage != null) {
                    int[] intVector = value.getIntVector();
                    if (intVector.length >= 2) {
                        if ((LocaleDisplayNamesImpl.this.capitalization == DisplayContext.CAPITALIZATION_FOR_UI_LIST_OR_MENU ? intVector[0] : intVector[1]) != 0) {
                            LocaleDisplayNamesImpl.this.capitalizationUsage[capitalizationContextUsage.ordinal()] = true;
                            this.hasCapitalizationUsage = true;
                        }
                    }
                }
            }
        }

        public /* synthetic */ CapitalizationContextSink(LocaleDisplayNamesImpl localeDisplayNamesImpl, int i) {
            this();
        }
    }

    @Override // com.ibm.icu.text.LocaleDisplayNames
    public String localeDisplayName(Locale locale) {
        return localeDisplayNameInternal(ULocale.forLocale(locale));
    }

    @Override // com.ibm.icu.text.LocaleDisplayNames
    public String localeDisplayName(ULocale uLocale) {
        return localeDisplayNameInternal(uLocale);
    }

    @Override // com.ibm.icu.text.LocaleDisplayNames
    public String keyDisplayName(String str) {
        return keyDisplayName(str, false);
    }

    @Override // com.ibm.icu.text.LocaleDisplayNames
    public String variantDisplayName(String str) {
        return variantDisplayName(str, false);
    }

    @Override // com.ibm.icu.text.LocaleDisplayNames
    public String regionDisplayName(String str) {
        return regionDisplayName(str, false);
    }

    @Override // com.ibm.icu.text.LocaleDisplayNames
    public String scriptDisplayNameInContext(String str) {
        return scriptDisplayNameInContext(str, false);
    }

    @Override // com.ibm.icu.text.LocaleDisplayNames
    public String scriptDisplayName(int i) {
        return scriptDisplayName(UScript.getShortName(i));
    }

    @Override // com.ibm.icu.text.LocaleDisplayNames
    public String keyValueDisplayName(String str, String str2) {
        return keyValueDisplayName(str, str2, false);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public LocaleDisplayNamesImpl(ULocale uLocale, LocaleDisplayNames.DialectHandling dialectHandling) {
        DisplayContext displayContext;
        if (dialectHandling == LocaleDisplayNames.DialectHandling.STANDARD_NAMES) {
            displayContext = DisplayContext.STANDARD_NAMES;
        } else {
            displayContext = DisplayContext.DIALECT_NAMES;
        }
        this(uLocale, displayContext, DisplayContext.CAPITALIZATION_NONE);
    }
}
