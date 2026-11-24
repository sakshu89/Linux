package com.ibm.icu.text;

import com.ibm.icu.impl.ICUData;
import com.ibm.icu.impl.ICUResourceBundle;
import com.ibm.icu.impl.LocaleUtility;
import com.ibm.icu.impl.Utility;
import com.ibm.icu.lang.UScript;
import com.ibm.icu.util.CaseInsensitiveString;
import com.ibm.icu.util.UResourceBundle;
import defpackage.cq;
import defpackage.ky0;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.BiFunction;
import java.util.function.Supplier;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
class TransliteratorRegistry {
    private static final String ANY = "Any";
    private static final boolean DEBUG = false;
    private static final char LOCALE_SEP = '_';
    private static final String NO_VARIANT = "";
    private final Map<CaseInsensitiveString, Object[]> registry = new ConcurrentHashMap();
    private final Map<CaseInsensitiveString, Map<CaseInsensitiveString, List<CaseInsensitiveString>>> specDAG = new ConcurrentHashMap();
    private final Set<CaseInsensitiveString> availableIDs = new LinkedHashSet();
    private final Map<String, WeakReference<CaseInsensitiveString>> stvStringPool = Collections.synchronizedMap(new WeakHashMap());

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class AliasEntry {
        public String alias;

        public AliasEntry(String str) {
            this.alias = str;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class CompoundRBTEntry {
        private String ID;
        private UnicodeSet compoundFilter;
        private List<RuleBasedTransliterator.Data> dataVector;
        private List<String> idBlockVector;

        public CompoundRBTEntry(String str, List<String> list, List<RuleBasedTransliterator.Data> list2, UnicodeSet unicodeSet) {
            this.ID = str;
            this.idBlockVector = list;
            this.dataVector = list2;
            this.compoundFilter = unicodeSet;
        }

        public Transliterator getInstance() {
            ArrayList arrayList = new ArrayList();
            int iMax = Math.max(this.idBlockVector.size(), this.dataVector.size());
            int i = 1;
            for (int i2 = 0; i2 < iMax; i2++) {
                if (i2 < this.idBlockVector.size()) {
                    String str = this.idBlockVector.get(i2);
                    if (str.length() > 0) {
                        arrayList.add(Transliterator.getInstance(str));
                    }
                }
                if (i2 < this.dataVector.size()) {
                    arrayList.add(new RuleBasedTransliterator(ky0.h(i, "%Pass"), this.dataVector.get(i2), null));
                    i++;
                }
            }
            CompoundTransliterator compoundTransliterator = new CompoundTransliterator(arrayList, i - 1);
            compoundTransliterator.setID(this.ID);
            UnicodeSet unicodeSet = this.compoundFilter;
            if (unicodeSet != null) {
                compoundTransliterator.setFilter(unicodeSet);
            }
            return compoundTransliterator;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class IDEnumeration implements Enumeration<String> {
        Enumeration<CaseInsensitiveString> en;

        public IDEnumeration(Enumeration<CaseInsensitiveString> enumeration) {
            this.en = enumeration;
        }

        @Override // java.util.Enumeration
        public boolean hasMoreElements() {
            Enumeration<CaseInsensitiveString> enumeration = this.en;
            return enumeration != null && enumeration.hasMoreElements();
        }

        @Override // java.util.Enumeration
        public String nextElement() {
            return this.en.nextElement().getString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class LocaleEntry {
        public int direction;
        public String rule;

        public LocaleEntry(String str, int i) {
            this.rule = str;
            this.direction = i;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class Spec {
        private boolean isNextLocale;
        private boolean isSpecLocale;
        private String nextSpec;
        private ICUResourceBundle res;
        private String scriptName;
        private String spec = null;
        private String top;

        public Spec(String str) {
            this.top = str;
            this.scriptName = null;
            try {
                int codeFromName = UScript.getCodeFromName(str);
                int[] code = UScript.getCode(this.top);
                if (code != null) {
                    String name = UScript.getName(code[0]);
                    this.scriptName = name;
                    if (name.equalsIgnoreCase(this.top)) {
                        this.scriptName = null;
                    }
                }
                this.isSpecLocale = false;
                this.res = null;
                if (codeFromName == -1) {
                    ICUResourceBundle iCUResourceBundle = (ICUResourceBundle) UResourceBundle.getBundleInstance(ICUData.ICU_TRANSLIT_BASE_NAME, LocaleUtility.getLocaleFromName(this.top));
                    this.res = iCUResourceBundle;
                    if (iCUResourceBundle != null && LocaleUtility.isFallbackOf(iCUResourceBundle.getULocale().toString(), this.top)) {
                        this.isSpecLocale = true;
                    }
                }
            } catch (MissingResourceException unused) {
                this.scriptName = null;
            }
            reset();
        }

        private void setupNext() {
            this.isNextLocale = false;
            if (!this.isSpecLocale) {
                if (Utility.sameObjects(this.nextSpec, this.scriptName)) {
                    this.nextSpec = null;
                    return;
                } else {
                    this.nextSpec = this.scriptName;
                    return;
                }
            }
            String str = this.spec;
            this.nextSpec = str;
            int iLastIndexOf = str.lastIndexOf(95);
            if (iLastIndexOf <= 0) {
                this.nextSpec = this.scriptName;
            } else {
                this.nextSpec = this.spec.substring(0, iLastIndexOf);
                this.isNextLocale = true;
            }
        }

        public String get() {
            return this.spec;
        }

        public ResourceBundle getBundle() {
            ICUResourceBundle iCUResourceBundle = this.res;
            if (iCUResourceBundle == null || !iCUResourceBundle.getULocale().toString().equals(this.spec)) {
                return null;
            }
            return this.res;
        }

        public String getTop() {
            return this.top;
        }

        public boolean hasFallback() {
            return this.nextSpec != null;
        }

        public boolean isLocale() {
            return this.isSpecLocale;
        }

        public String next() {
            this.spec = this.nextSpec;
            this.isSpecLocale = this.isNextLocale;
            setupNext();
            return this.spec;
        }

        public void reset() {
            if (Utility.sameObjects(this.spec, this.top)) {
                return;
            }
            this.spec = this.top;
            this.isSpecLocale = this.res != null;
            setupNext();
        }
    }

    private Object[] find(String str, String str2, String str3) {
        Spec spec = new Spec(str);
        Spec spec2 = new Spec(str2);
        if (str3.length() != 0) {
            Object[] objArrFindInDynamicStore = findInDynamicStore(spec, spec2, str3);
            if (objArrFindInDynamicStore != null) {
                return objArrFindInDynamicStore;
            }
            Object[] objArrFindInStaticStore = findInStaticStore(spec, spec2, str3);
            if (objArrFindInStaticStore != null) {
                return objArrFindInStaticStore;
            }
        }
        while (true) {
            spec.reset();
            while (true) {
                Object[] objArrFindInDynamicStore2 = findInDynamicStore(spec, spec2, NO_VARIANT);
                if (objArrFindInDynamicStore2 != null) {
                    return objArrFindInDynamicStore2;
                }
                Object[] objArrFindInStaticStore2 = findInStaticStore(spec, spec2, NO_VARIANT);
                if (objArrFindInStaticStore2 != null) {
                    return objArrFindInStaticStore2;
                }
                if (!spec.hasFallback()) {
                    break;
                }
                spec.next();
            }
            if (!spec2.hasFallback()) {
                return null;
            }
            spec2.next();
        }
    }

    private Object[] findInBundle(Spec spec, Spec spec2, String str, int i) {
        int i2;
        ResourceBundle bundle = spec.getBundle();
        if (bundle == null) {
            return null;
        }
        int i3 = 0;
        while (i3 < 2) {
            StringBuilder sb = new StringBuilder();
            if (i3 == 0) {
                sb.append(i == 0 ? "TransliterateTo" : "TransliterateFrom");
            } else {
                sb.append("Transliterate");
            }
            sb.append(spec2.get().toUpperCase(Locale.ENGLISH));
            try {
                String[] stringArray = bundle.getStringArray(sb.toString());
                if (str.length() != 0) {
                    i2 = 0;
                    while (i2 < stringArray.length && !stringArray[i2].equalsIgnoreCase(str)) {
                        i2 += 2;
                    }
                } else {
                    i2 = 0;
                }
                if (i2 < stringArray.length) {
                    return new Object[]{new LocaleEntry(stringArray[i2 + 1], i3 == 0 ? 0 : i)};
                }
                continue;
            } catch (MissingResourceException unused) {
            }
            i3++;
        }
        return null;
    }

    private Object[] findInDynamicStore(Spec spec, Spec spec2, String str) {
        return this.registry.get(new CaseInsensitiveString(TransliteratorIDParser.STVtoID(spec.get(), spec2.get(), str)));
    }

    private Object[] findInStaticStore(Spec spec, Spec spec2, String str) {
        Object[] objArrFindInBundle;
        if (spec.isLocale()) {
            objArrFindInBundle = findInBundle(spec, spec2, str, 0);
        } else {
            objArrFindInBundle = spec2.isLocale() ? findInBundle(spec2, spec, str, 1) : null;
        }
        Object[] objArr = objArrFindInBundle;
        if (objArr != null) {
            registerEntry(spec.getTop(), spec2.getTop(), str, objArr, false);
        }
        return objArr;
    }

    private Transliterator instantiateEntry(String str, Object[] objArr, StringBuilder sb) {
        while (true) {
            Object obj = objArr[0];
            if (obj instanceof RuleBasedTransliterator.Data) {
                return new RuleBasedTransliterator(str, (RuleBasedTransliterator.Data) obj, null);
            }
            if (obj instanceof Class) {
                try {
                    return (Transliterator) ((Class) obj).newInstance();
                } catch (IllegalAccessException | InstantiationException unused) {
                    return null;
                }
            }
            if (obj instanceof AliasEntry) {
                sb.append(((AliasEntry) obj).alias);
                return null;
            }
            if (obj instanceof Transliterator.Factory) {
                return ((Transliterator.Factory) obj).getInstance(str);
            }
            if (obj instanceof CompoundRBTEntry) {
                return ((CompoundRBTEntry) obj).getInstance();
            }
            if (obj instanceof AnyTransliterator) {
                return ((AnyTransliterator) obj).safeClone();
            }
            if (obj instanceof RuleBasedTransliterator) {
                return ((RuleBasedTransliterator) obj).safeClone();
            }
            if (obj instanceof CompoundTransliterator) {
                return ((CompoundTransliterator) obj).safeClone();
            }
            if (obj instanceof Transliterator) {
                return (Transliterator) obj;
            }
            TransliteratorParser transliteratorParser = new TransliteratorParser();
            try {
                ResourceEntry resourceEntry = (ResourceEntry) obj;
                transliteratorParser.parse(resourceEntry.getResource(), resourceEntry.direction);
            } catch (ClassCastException unused2) {
                LocaleEntry localeEntry = (LocaleEntry) obj;
                transliteratorParser.parse(localeEntry.rule, localeEntry.direction);
            }
            if (transliteratorParser.idBlockVector.size() == 0 && transliteratorParser.dataVector.size() == 0) {
                objArr[0] = new AliasEntry("Any-Null");
            } else if (transliteratorParser.idBlockVector.size() == 0 && transliteratorParser.dataVector.size() == 1) {
                objArr[0] = transliteratorParser.dataVector.get(0);
            } else if (transliteratorParser.idBlockVector.size() == 1 && transliteratorParser.dataVector.size() == 0) {
                UnicodeSet unicodeSet = transliteratorParser.compoundFilter;
                if (unicodeSet != null) {
                    objArr[0] = new AliasEntry(cq.k(unicodeSet.toPattern(false), ";", transliteratorParser.idBlockVector.get(0)));
                } else {
                    objArr[0] = new AliasEntry(transliteratorParser.idBlockVector.get(0));
                }
            } else {
                objArr[0] = new CompoundRBTEntry(str, transliteratorParser.idBlockVector, transliteratorParser.dataVector, transliteratorParser.compoundFilter);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Map lambda$registerSTV$0(CaseInsensitiveString caseInsensitiveString) {
        return new ConcurrentHashMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List lambda$registerSTV$1(CaseInsensitiveString caseInsensitiveString) {
        return new ArrayList(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ WeakReference lambda$toInternedSTVString$2(AtomicReference atomicReference, String str, WeakReference weakReference) {
        CaseInsensitiveString caseInsensitiveString;
        if (weakReference == null || (caseInsensitiveString = (CaseInsensitiveString) weakReference.get()) == null) {
            caseInsensitiveString = new CaseInsensitiveString(str);
            weakReference = new WeakReference(caseInsensitiveString);
        }
        atomicReference.set(caseInsensitiveString);
        return weakReference;
    }

    private void registerEntry(String str, String str2, String str3, String str4, Object obj, boolean z) {
        CaseInsensitiveString caseInsensitiveString = new CaseInsensitiveString(str);
        this.registry.put(caseInsensitiveString, obj instanceof Object[] ? (Object[]) obj : new Object[]{obj});
        if (z) {
            registerSTV(str2, str3, str4);
            this.availableIDs.add(caseInsensitiveString);
        } else {
            removeSTV(str2, str3, str4);
            this.availableIDs.remove(caseInsensitiveString);
        }
    }

    private void registerSTV(String str, String str2, String str3) {
        CaseInsensitiveString internedSTVString = toInternedSTVString(str);
        CaseInsensitiveString internedSTVString2 = toInternedSTVString(str2);
        CaseInsensitiveString internedSTVString3 = toInternedSTVString(str3);
        List<CaseInsensitiveString> listComputeIfAbsent = this.specDAG.computeIfAbsent(internedSTVString, new d(2)).computeIfAbsent(internedSTVString2, new d(3));
        if (listComputeIfAbsent.contains(internedSTVString3)) {
            return;
        }
        if (str3.length() > 0) {
            listComputeIfAbsent.add(internedSTVString3);
        } else {
            listComputeIfAbsent.add(0, internedSTVString3);
        }
    }

    private void removeSTV(String str, String str2, String str3) {
        List<CaseInsensitiveString> list;
        CaseInsensitiveString caseInsensitiveString = new CaseInsensitiveString(str);
        CaseInsensitiveString caseInsensitiveString2 = new CaseInsensitiveString(str2);
        CaseInsensitiveString caseInsensitiveString3 = new CaseInsensitiveString(str3);
        Map<CaseInsensitiveString, List<CaseInsensitiveString>> map = this.specDAG.get(caseInsensitiveString);
        if (map == null || (list = map.get(caseInsensitiveString2)) == null) {
            return;
        }
        list.remove(caseInsensitiveString3);
        if (list.size() == 0) {
            map.remove(caseInsensitiveString2);
            if (map.size() == 0) {
                this.specDAG.remove(caseInsensitiveString);
            }
        }
    }

    private CaseInsensitiveString toInternedSTVString(String str) {
        final AtomicReference atomicReference = new AtomicReference();
        this.stvStringPool.compute(str, new BiFunction() { // from class: com.ibm.icu.text.e
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return TransliteratorRegistry.lambda$toInternedSTVString$2(atomicReference, (String) obj, (WeakReference) obj2);
            }
        });
        return (CaseInsensitiveString) atomicReference.get();
    }

    public Transliterator get(String str, StringBuilder sb) {
        Object[] objArrFind = find(str);
        if (objArrFind == null) {
            return null;
        }
        return instantiateEntry(str, objArrFind, sb);
    }

    public Enumeration<String> getAvailableIDs() {
        return new IDEnumeration(Collections.enumeration(this.availableIDs));
    }

    public Enumeration<String> getAvailableSources() {
        return new IDEnumeration(Collections.enumeration(this.specDAG.keySet()));
    }

    public Enumeration<String> getAvailableTargets(String str) {
        Map<CaseInsensitiveString, List<CaseInsensitiveString>> map = this.specDAG.get(new CaseInsensitiveString(str));
        return map == null ? new IDEnumeration(null) : new IDEnumeration(Collections.enumeration(map.keySet()));
    }

    public Enumeration<String> getAvailableVariants(String str, String str2) {
        CaseInsensitiveString caseInsensitiveString = new CaseInsensitiveString(str);
        CaseInsensitiveString caseInsensitiveString2 = new CaseInsensitiveString(str2);
        Map<CaseInsensitiveString, List<CaseInsensitiveString>> map = this.specDAG.get(caseInsensitiveString);
        if (map == null) {
            return new IDEnumeration(null);
        }
        List<CaseInsensitiveString> list = map.get(caseInsensitiveString2);
        return list == null ? new IDEnumeration(null) : new IDEnumeration(Collections.enumeration(list));
    }

    public void put(String str, String str2, int i, boolean z) {
        registerEntry(str, new ResourceEntry(str2, i), z);
    }

    public void remove(String str) {
        String[] strArrIDtoSTV = TransliteratorIDParser.IDtoSTV(str);
        String strSTVtoID = TransliteratorIDParser.STVtoID(strArrIDtoSTV[0], strArrIDtoSTV[1], strArrIDtoSTV[2]);
        this.registry.remove(new CaseInsensitiveString(strSTVtoID));
        removeSTV(strArrIDtoSTV[0], strArrIDtoSTV[1], strArrIDtoSTV[2]);
        this.availableIDs.remove(new CaseInsensitiveString(strSTVtoID));
    }

    public void put(String str, Transliterator.Factory factory, boolean z) {
        registerEntry(str, factory, z);
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class ResourceEntry {
        public final int direction;
        private String resource;
        private final Supplier<String> resourceSupplier;

        public ResourceEntry(String str, int i) {
            this.resource = str;
            this.direction = i;
            this.resourceSupplier = null;
        }

        public String getResource() {
            if (this.resourceSupplier == null) {
                return this.resource;
            }
            synchronized (this) {
                try {
                    String str = this.resource;
                    if (str != null) {
                        return str;
                    }
                    String str2 = this.resourceSupplier.get();
                    this.resource = str2;
                    return str2;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public ResourceEntry(Supplier<String> supplier, int i) {
            this.resourceSupplier = supplier;
            this.direction = i;
        }
    }

    public void put(String str, Class<? extends Transliterator> cls, boolean z) {
        registerEntry(str, cls, z);
    }

    public void put(String str, Supplier<String> supplier, int i, boolean z) {
        registerEntry(str, new ResourceEntry(supplier, i), z);
    }

    public void put(String str, String str2, boolean z) {
        registerEntry(str, new AliasEntry(str2), z);
    }

    public void put(String str, Transliterator transliterator, boolean z) {
        registerEntry(str, transliterator, z);
    }

    private void registerEntry(String str, Object obj, boolean z) {
        String[] strArrIDtoSTV = TransliteratorIDParser.IDtoSTV(str);
        String strSTVtoID = TransliteratorIDParser.STVtoID(strArrIDtoSTV[0], strArrIDtoSTV[1], strArrIDtoSTV[2]);
        registerEntry(str.equals(strSTVtoID) ? str : strSTVtoID, strArrIDtoSTV[0], strArrIDtoSTV[1], strArrIDtoSTV[2], obj, z);
    }

    private void registerEntry(String str, String str2, String str3, Object obj, boolean z) {
        registerEntry(TransliteratorIDParser.STVtoID(str, str2, str3), str.length() == 0 ? ANY : str, str2, str3, obj, z);
    }

    private Object[] find(String str) {
        String[] strArrIDtoSTV = TransliteratorIDParser.IDtoSTV(str);
        return find(strArrIDtoSTV[0], strArrIDtoSTV[1], strArrIDtoSTV[2]);
    }
}
