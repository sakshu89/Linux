package com.ibm.icu.text;

import com.ibm.icu.impl.ICUData;
import com.ibm.icu.impl.ICUResourceBundle;
import com.ibm.icu.impl.Utility;
import com.ibm.icu.impl.locale.LanguageTag;
import com.ibm.icu.text.Transliterator;
import com.ibm.icu.util.CaseInsensitiveString;
import com.ibm.icu.util.ULocale;
import com.ibm.icu.util.UResourceBundle;
import defpackage.cq;
import defpackage.ky0;
import defpackage.og;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Supplier;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class Transliterator implements StringTransform {
    static final boolean DEBUG = false;
    public static final int FORWARD = 0;
    static final char ID_DELIM = ';';
    static final char ID_SEP = '-';
    private static final String RB_DISPLAY_NAME_PATTERN = "TransliteratorNamePattern";
    private static final String RB_DISPLAY_NAME_PREFIX = "%Translit%%";
    private static final String RB_RULE_BASED_IDS = "RuleBasedTransliteratorIDs";
    private static final String RB_SCRIPT_DISPLAY_NAME_PREFIX = "%Translit%";
    public static final int REVERSE = 1;
    private static final String ROOT = "root";
    static final char VARIANT_SEP = '/';
    private String ID;
    private UnicodeSet filter;
    private int maximumContextLength = 0;
    private static TransliteratorRegistry registry = new TransliteratorRegistry();
    private static Map<CaseInsensitiveString, String> displayNameCache = new ConcurrentHashMap();

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public interface Factory {
        Transliterator getInstance(String str);
    }

    static {
        int i;
        UResourceBundle uResourceBundle = UResourceBundle.getBundleInstance(ICUData.ICU_TRANSLIT_BASE_NAME, ROOT).get(RB_RULE_BASED_IDS);
        int size = uResourceBundle.getSize();
        for (final int i2 = 0; i2 < size; i2++) {
            UResourceBundle uResourceBundle2 = uResourceBundle.get(i2);
            String key = uResourceBundle2.getKey();
            if (key.indexOf("-t-") < 0) {
                UResourceBundle uResourceBundle3 = uResourceBundle2.get(0);
                String key2 = uResourceBundle3.getKey();
                if (key2.equals("file") || key2.equals("internal")) {
                    Supplier<String> supplier = new Supplier() { // from class: m23
                        @Override // java.util.function.Supplier
                        public final Object get() {
                            return Transliterator.lambda$static$0(i2);
                        }
                    };
                    String string = uResourceBundle3.getString("direction");
                    char cCharAt = string.charAt(0);
                    if (cCharAt == 'F') {
                        i = 0;
                    } else {
                        if (cCharAt != 'R') {
                            og.p("Can't parse direction: ".concat(string));
                            return;
                        }
                        i = 1;
                    }
                    registry.put(key, supplier, i, !key2.equals("internal"));
                } else {
                    if (!key2.equals("alias")) {
                        og.p("Unknown type: ".concat(key2));
                        return;
                    }
                    registry.put(key, uResourceBundle3.getString(), true);
                }
            }
        }
        registerSpecialInverse("Null", "Null", false);
        registerClass("Any-Null", NullTransliterator.class, null);
        RemoveTransliterator.register();
        EscapeTransliterator.register();
        UnescapeTransliterator.register();
        LowercaseTransliterator.register();
        UppercaseTransliterator.register();
        TitlecaseTransliterator.register();
        CaseFoldTransliterator.register();
        UnicodeNameTransliterator.register();
        NameUnicodeTransliterator.register();
        NormalizationTransliterator.register();
        BreakTransliterator.register();
        AnyTransliterator.register();
    }

    public Transliterator(String str, UnicodeFilter unicodeFilter) {
        str.getClass();
        this.ID = str;
        setFilter(unicodeFilter);
    }

    public static final Transliterator createFromRules(String str, String str2, int i) {
        TransliteratorParser transliteratorParser = new TransliteratorParser();
        transliteratorParser.parse(str2, i);
        if (transliteratorParser.idBlockVector.size() == 0 && transliteratorParser.dataVector.size() == 0) {
            return new NullTransliterator();
        }
        if (transliteratorParser.idBlockVector.size() == 0 && transliteratorParser.dataVector.size() == 1) {
            return new RuleBasedTransliterator(str, transliteratorParser.dataVector.get(0), transliteratorParser.compoundFilter);
        }
        if (transliteratorParser.idBlockVector.size() == 1 && transliteratorParser.dataVector.size() == 0) {
            UnicodeSet unicodeSet = transliteratorParser.compoundFilter;
            Transliterator transliterator = unicodeSet != null ? getInstance(unicodeSet.toPattern(false) + ";" + transliteratorParser.idBlockVector.get(0)) : getInstance(transliteratorParser.idBlockVector.get(0));
            if (transliterator != null) {
                transliterator.setID(str);
            }
            return transliterator;
        }
        ArrayList arrayList = new ArrayList();
        int iMax = Math.max(transliteratorParser.idBlockVector.size(), transliteratorParser.dataVector.size());
        int i2 = 1;
        for (int i3 = 0; i3 < iMax; i3++) {
            if (i3 < transliteratorParser.idBlockVector.size()) {
                String str3 = transliteratorParser.idBlockVector.get(i3);
                if (str3.length() > 0 && !(getInstance(str3) instanceof NullTransliterator)) {
                    arrayList.add(getInstance(str3));
                }
            }
            if (i3 < transliteratorParser.dataVector.size()) {
                arrayList.add(new RuleBasedTransliterator(ky0.h(i2, "%Pass"), transliteratorParser.dataVector.get(i3), null));
                i2++;
            }
        }
        CompoundTransliterator compoundTransliterator = new CompoundTransliterator(arrayList, i2 - 1);
        compoundTransliterator.setID(str);
        UnicodeSet unicodeSet2 = transliteratorParser.compoundFilter;
        if (unicodeSet2 != null) {
            compoundTransliterator.setFilter(unicodeSet2);
        }
        return compoundTransliterator;
    }

    private void filteredTransliterate(Replaceable replaceable, Position position, boolean z, boolean z2) {
        boolean z3;
        if (this.filter == null && !z2) {
            handleTransliterate(replaceable, position, z);
            return;
        }
        int i = position.limit;
        do {
            if (this.filter != null) {
                while (true) {
                    int i2 = position.start;
                    if (i2 >= i) {
                        break;
                    }
                    UnicodeSet unicodeSet = this.filter;
                    int iChar32At = replaceable.char32At(i2);
                    if (unicodeSet.contains(iChar32At)) {
                        break;
                    } else {
                        position.start = UTF16.getCharCount(iChar32At) + position.start;
                    }
                }
                position.limit = position.start;
                while (true) {
                    int i3 = position.limit;
                    if (i3 >= i) {
                        break;
                    }
                    UnicodeSet unicodeSet2 = this.filter;
                    int iChar32At2 = replaceable.char32At(i3);
                    if (!unicodeSet2.contains(iChar32At2)) {
                        break;
                    } else {
                        position.limit = UTF16.getCharCount(iChar32At2) + position.limit;
                    }
                }
            }
            int i4 = position.start;
            int i5 = position.limit;
            if (i4 == i5) {
                break;
            }
            z3 = i5 < i ? false : z;
            if (z2 && z3) {
                int i6 = i5 - i4;
                int length = replaceable.length();
                replaceable.copy(i4, i5, length);
                int i7 = position.start;
                int i8 = length;
                int i9 = 0;
                int i10 = 0;
                while (true) {
                    int charCount = UTF16.getCharCount(replaceable.char32At(i7));
                    i7 += charCount;
                    if (i7 > i5) {
                        break;
                    }
                    i9 += charCount;
                    position.limit = i7;
                    handleTransliterate(replaceable, position, true);
                    int i11 = position.limit;
                    int i12 = i11 - i7;
                    int i13 = position.start;
                    if (i13 != i11) {
                        int i14 = (i8 + i12) - (i11 - i4);
                        replaceable.replace(i4, i11, "");
                        replaceable.copy(i14, i14 + i9, i4);
                        position.start = i4;
                        position.limit = i7;
                        position.contextLimit -= i12;
                    } else {
                        i8 += i12 + i9;
                        i5 += i12;
                        i10 += i12;
                        i4 = i13;
                        i7 = i4;
                        i9 = 0;
                    }
                }
                int i15 = length + i10;
                i += i10;
                replaceable.replace(i15, i6 + i15, "");
                position.start = i4;
            } else {
                handleTransliterate(replaceable, position, z3);
                int i16 = position.limit;
                int i17 = i16 - i5;
                if (!z3 && position.start != i16) {
                    og.p(cq.j("ERROR: Incomplete non-incremental transliteration by ", getID()));
                    return;
                }
                i += i17;
            }
            if (this.filter == null) {
                break;
            }
        } while (!z3);
        position.limit = i;
    }

    public static final Enumeration<String> getAvailableIDs() {
        return registry.getAvailableIDs();
    }

    public static final Enumeration<String> getAvailableSources() {
        return registry.getAvailableSources();
    }

    public static final Enumeration<String> getAvailableTargets(String str) {
        return registry.getAvailableTargets(str);
    }

    public static final Enumeration<String> getAvailableVariants(String str, String str2) {
        return registry.getAvailableVariants(str, str2);
    }

    public static Transliterator getBasicInstance(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        Transliterator transliterator = registry.get(str, sb);
        if (sb.length() != 0) {
            transliterator = getInstance(sb.toString(), 0);
        }
        if (transliterator != null && str2 != null) {
            transliterator.setID(str2);
        }
        return transliterator;
    }

    public static String getDisplayName(String str, ULocale uLocale) {
        ICUResourceBundle iCUResourceBundle = (ICUResourceBundle) UResourceBundle.getBundleInstance(ICUData.ICU_TRANSLIT_BASE_NAME, uLocale);
        String[] strArrIDtoSTV = TransliteratorIDParser.IDtoSTV(str);
        if (strArrIDtoSTV == null) {
            return "";
        }
        String strK = cq.k(strArrIDtoSTV[0], LanguageTag.SEP, strArrIDtoSTV[1]);
        String str2 = strArrIDtoSTV[2];
        if (str2 != null && str2.length() > 0) {
            strK = cq.k(strK, "/", strArrIDtoSTV[2]);
        }
        String str3 = displayNameCache.get(new CaseInsensitiveString(strK));
        if (str3 != null) {
            return str3;
        }
        try {
            try {
                return iCUResourceBundle.getString(RB_DISPLAY_NAME_PREFIX.concat(strK));
            } catch (MissingResourceException unused) {
                java.text.MessageFormat messageFormat = new java.text.MessageFormat(iCUResourceBundle.getString(RB_DISPLAY_NAME_PATTERN));
                Object[] objArr = new Object[3];
                objArr[0] = 2;
                objArr[1] = strArrIDtoSTV[0];
                objArr[2] = strArrIDtoSTV[1];
                for (int i = 1; i <= 2; i++) {
                    try {
                        objArr[i] = iCUResourceBundle.getString(RB_SCRIPT_DISPLAY_NAME_PREFIX + ((String) objArr[i]));
                    } catch (MissingResourceException unused2) {
                    }
                }
                if (strArrIDtoSTV[2].length() <= 0) {
                    return messageFormat.format(objArr);
                }
                return messageFormat.format(objArr) + "/" + strArrIDtoSTV[2];
            }
        } catch (MissingResourceException unused3) {
            throw new RuntimeException();
        }
    }

    public static Transliterator getInstance(String str, int i) {
        StringBuilder sb = new StringBuilder();
        ArrayList arrayList = new ArrayList();
        UnicodeSet[] unicodeSetArr = new UnicodeSet[1];
        if (!TransliteratorIDParser.parseCompoundID(str, i, sb, arrayList, unicodeSetArr)) {
            og.i(cq.j("Invalid ID ", str));
            return null;
        }
        List<Transliterator> listInstantiateList = TransliteratorIDParser.instantiateList(arrayList);
        Transliterator compoundTransliterator = (arrayList.size() > 1 || sb.indexOf(";") >= 0) ? new CompoundTransliterator(listInstantiateList) : listInstantiateList.get(0);
        compoundTransliterator.setID(sb.toString());
        UnicodeSet unicodeSet = unicodeSetArr[0];
        if (unicodeSet != null) {
            compoundTransliterator.setFilter(unicodeSet);
        }
        return compoundTransliterator;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$static$0(int i) {
        return UResourceBundle.getBundleInstance(ICUData.ICU_TRANSLIT_BASE_NAME, ROOT).get(RB_RULE_BASED_IDS).get(i).get(0).getString("resource");
    }

    public static void registerAlias(String str, String str2) {
        registry.put(str, str2, true);
    }

    @Deprecated
    public static void registerAny() {
        AnyTransliterator.register();
    }

    public static void registerClass(String str, Class<? extends Transliterator> cls, String str2) {
        registry.put(str, cls, true);
        if (str2 != null) {
            displayNameCache.put(new CaseInsensitiveString(str), str2);
        }
    }

    public static void registerFactory(String str, Factory factory) {
        registry.put(str, factory, true);
    }

    public static void registerInstance(Transliterator transliterator) {
        registry.put(transliterator.getID(), transliterator, true);
    }

    public static void registerSpecialInverse(String str, String str2, boolean z) {
        TransliteratorIDParser.registerSpecialInverse(str, str2, z);
    }

    public static void unregister(String str) {
        displayNameCache.remove(new CaseInsensitiveString(str));
        registry.remove(str);
    }

    @Deprecated
    public void addSourceTargetSet(UnicodeSet unicodeSet, UnicodeSet unicodeSet2, UnicodeSet unicodeSet3) {
        UnicodeSet unicodeSetRetainAll = new UnicodeSet(handleGetSourceSet()).retainAll(getFilterAsUnicodeSet(unicodeSet));
        unicodeSet2.addAll(unicodeSetRetainAll);
        for (String str : unicodeSetRetainAll) {
            String strTransliterate = transliterate(str);
            if (!str.equals(strTransliterate)) {
                unicodeSet3.addAll(strTransliterate);
            }
        }
    }

    public final String baseToRules(boolean z) {
        if (!z) {
            return cq.v("::", getID(), ";");
        }
        StringBuilder sb = new StringBuilder();
        String id = getID();
        int charCount = 0;
        while (charCount < id.length()) {
            int iCharAt = UTF16.charAt(id, charCount);
            if (!Utility.escapeUnprintable(sb, iCharAt)) {
                sb.appendCodePoint(iCharAt);
            }
            charCount += UTF16.getCharCount(iCharAt);
        }
        sb.insert(0, "::");
        sb.append(ID_DELIM);
        return sb.toString();
    }

    public final void finishTransliteration(Replaceable replaceable, Position position) {
        position.validate(replaceable.length());
        filteredTransliterate(replaceable, position, false, true);
    }

    public Transliterator[] getElements() {
        if (!(this instanceof CompoundTransliterator)) {
            return new Transliterator[]{this};
        }
        CompoundTransliterator compoundTransliterator = (CompoundTransliterator) this;
        int count = compoundTransliterator.getCount();
        Transliterator[] transliteratorArr = new Transliterator[count];
        for (int i = 0; i < count; i++) {
            transliteratorArr[i] = compoundTransliterator.getTransliterator(i);
        }
        return transliteratorArr;
    }

    public final UnicodeFilter getFilter() {
        return this.filter;
    }

    @Deprecated
    public UnicodeSet getFilterAsUnicodeSet(UnicodeSet unicodeSet) {
        UnicodeSet unicodeSet2;
        if (this.filter == null) {
            return unicodeSet;
        }
        UnicodeSet unicodeSet3 = new UnicodeSet(unicodeSet);
        try {
            unicodeSet2 = this.filter;
        } catch (ClassCastException unused) {
            UnicodeSet unicodeSet4 = this.filter;
            UnicodeSet unicodeSet5 = new UnicodeSet();
            unicodeSet4.addMatchSetTo(unicodeSet5);
            unicodeSet2 = unicodeSet5;
        }
        return unicodeSet3.retainAll(unicodeSet2).freeze();
    }

    public final String getID() {
        return this.ID;
    }

    public final Transliterator getInverse() {
        return getInstance(this.ID, 1);
    }

    public final int getMaximumContextLength() {
        return this.maximumContextLength;
    }

    public final UnicodeSet getSourceSet() {
        UnicodeSet unicodeSet = new UnicodeSet();
        addSourceTargetSet(getFilterAsUnicodeSet(UnicodeSet.ALL_CODE_POINTS), unicodeSet, new UnicodeSet());
        return unicodeSet;
    }

    public UnicodeSet getTargetSet() {
        UnicodeSet unicodeSet = new UnicodeSet();
        addSourceTargetSet(getFilterAsUnicodeSet(UnicodeSet.ALL_CODE_POINTS), new UnicodeSet(), unicodeSet);
        return unicodeSet;
    }

    public UnicodeSet handleGetSourceSet() {
        return new UnicodeSet();
    }

    public abstract void handleTransliterate(Replaceable replaceable, Position position, boolean z);

    public void setFilter(UnicodeFilter unicodeFilter) {
        if (unicodeFilter == null) {
            this.filter = null;
            return;
        }
        try {
            this.filter = new UnicodeSet((UnicodeSet) unicodeFilter).freeze();
        } catch (Exception unused) {
            UnicodeSet unicodeSet = new UnicodeSet();
            this.filter = unicodeSet;
            unicodeFilter.addMatchSetTo(unicodeSet);
            this.filter.freeze();
        }
    }

    public final void setID(String str) {
        this.ID = str;
    }

    public void setMaximumContextLength(int i) {
        if (i >= 0) {
            this.maximumContextLength = i;
        } else {
            og.i(ky0.h(i, "Invalid context length "));
        }
    }

    public String toRules(boolean z) {
        return baseToRules(z);
    }

    public final void transliterate(Replaceable replaceable, Position position, String str) {
        position.validate(replaceable.length());
        if (str != null) {
            int i = position.limit;
            replaceable.replace(i, i, str);
            position.limit = str.length() + position.limit;
            position.contextLimit = str.length() + position.contextLimit;
        }
        int i2 = position.limit;
        if (i2 <= 0 || !UTF16.isLeadSurrogate(replaceable.charAt(i2 - 1))) {
            filteredTransliterate(replaceable, position, true, true);
        }
    }

    @Override // com.ibm.icu.text.StringTransform, com.ibm.icu.text.Transform
    public String transform(String str) {
        return transliterate(str);
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class Position {
        public int contextLimit;
        public int contextStart;
        public int limit;
        public int start;

        public Position(int i, int i2, int i3, int i4) {
            this.contextStart = i;
            this.contextLimit = i2;
            this.start = i3;
            this.limit = i4;
        }

        public boolean equals(Object obj) {
            if (obj instanceof Position) {
                Position position = (Position) obj;
                if (this.contextStart == position.contextStart && this.contextLimit == position.contextLimit && this.start == position.start && this.limit == position.limit) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return Objects.hash(Integer.valueOf(this.contextStart), Integer.valueOf(this.contextLimit), Integer.valueOf(this.start), Integer.valueOf(this.limit));
        }

        public void set(Position position) {
            this.contextStart = position.contextStart;
            this.contextLimit = position.contextLimit;
            this.start = position.start;
            this.limit = position.limit;
        }

        public String toString() {
            int i = this.contextStart;
            int i2 = this.start;
            int i3 = this.limit;
            int i4 = this.contextLimit;
            StringBuilder sbP = cq.p("[cs=", i, ", s=", i2, ", l=");
            sbP.append(i3);
            sbP.append(", cl=");
            sbP.append(i4);
            sbP.append("]");
            return sbP.toString();
        }

        public final void validate(int i) {
            int i2;
            int i3;
            int i4;
            int i5 = this.contextStart;
            if (i5 < 0 || (i2 = this.start) < i5 || (i3 = this.limit) < i2 || (i4 = this.contextLimit) < i3 || i < i4) {
                int i6 = this.start;
                int i7 = this.limit;
                int i8 = this.contextLimit;
                StringBuilder sbP = cq.p("Invalid Position {cs=", i5, ", s=", i6, ", l=");
                sbP.append(i7);
                sbP.append(", cl=");
                sbP.append(i8);
                sbP.append("}, len=");
                sbP.append(i);
                throw new IllegalArgumentException(sbP.toString());
            }
        }

        public Position(int i, int i2, int i3) {
            this(i, i2, i3, i2);
        }

        public Position() {
            this(0, 0, 0, 0);
        }

        public Position(Position position) {
            set(position);
        }
    }

    public static void registerInstance(Transliterator transliterator, boolean z) {
        registry.put(transliterator.getID(), transliterator, z);
    }

    public final void transliterate(Replaceable replaceable) {
        transliterate(replaceable, 0, replaceable.length());
    }

    public final String transliterate(String str) {
        ReplaceableString replaceableString = new ReplaceableString(str);
        transliterate(replaceableString);
        return replaceableString.toString();
    }

    public final int transliterate(Replaceable replaceable, int i, int i2) {
        if (i < 0 || i2 < i || replaceable.length() < i2) {
            return -1;
        }
        Position position = new Position(i, i2, i);
        filteredTransliterate(replaceable, position, false, true);
        return position.limit;
    }

    public final void transliterate(Replaceable replaceable, Position position, int i) {
        transliterate(replaceable, position, UTF16.valueOf(i));
    }

    public final void transliterate(Replaceable replaceable, Position position) {
        transliterate(replaceable, position, (String) null);
    }

    public static final Transliterator getInstance(String str) {
        return getInstance(str, 0);
    }

    public static String getDisplayName(String str, Locale locale) {
        return getDisplayName(str, ULocale.forLocale(locale));
    }

    public static final String getDisplayName(String str) {
        return getDisplayName(str, ULocale.getDefault(ULocale.Category.DISPLAY));
    }

    public void filteredTransliterate(Replaceable replaceable, Position position, boolean z) {
        filteredTransliterate(replaceable, position, z, false);
    }
}
