package com.ibm.icu.impl;

import com.ibm.icu.impl.locale.BaseLocale;
import com.ibm.icu.util.ULocale;
import com.ibm.icu.util.UResourceBundle;
import com.ibm.icu.util.UResourceBundleIterator;
import com.ibm.icu.util.UResourceTypeMismatchException;
import defpackage.cq;
import defpackage.ky0;
import defpackage.og;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.URL;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class ICUResourceBundle extends UResourceBundle {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int ALIAS = 3;
    public static final int ARRAY16 = 9;
    private static final String DEFAULT_TAG = "default";
    private static final String FULL_LOCALE_NAMES_LIST = "fullLocaleNames.lst";
    private static final char HYPHEN = '-';
    private static final String ICUDATA = "ICUDATA";
    private static final String ICU_RESOURCE_INDEX = "res_index";
    protected static final String INSTALLED_LOCALES = "InstalledLocales";
    private static final String LOCALE = "LOCALE";
    public static final String NO_INHERITANCE_MARKER = "∅∅∅";
    public static final int RES_BOGUS = -1;
    private static final char RES_PATH_SEP_CHAR = '/';
    private static final String RES_PATH_SEP_STR = "/";
    public static final int STRING_V2 = 6;
    public static final int TABLE16 = 5;
    public static final int TABLE32 = 4;
    private ICUResourceBundle container;
    protected String key;
    WholeBundle wholeBundle;
    public static final ClassLoader ICU_DATA_CLASS_LOADER = ClassLoaderUtil.getClassLoader(ICUData.class);
    private static CacheBase<String, ICUResourceBundle, Loader> BUNDLE_CACHE = new SoftCache<String, ICUResourceBundle, Loader>() { // from class: com.ibm.icu.impl.ICUResourceBundle.1
        @Override // com.ibm.icu.impl.CacheBase
        public ICUResourceBundle createInstance(String str, Loader loader) {
            return loader.load();
        }
    };
    private static final boolean DEBUG = ICUDebug.enabled("localedata");
    private static CacheBase<String, AvailEntry, ClassLoader> GET_AVAILABLE_CACHE = new SoftCache<String, AvailEntry, ClassLoader>() { // from class: com.ibm.icu.impl.ICUResourceBundle.3
        @Override // com.ibm.icu.impl.CacheBase
        public AvailEntry createInstance(String str, ClassLoader classLoader) {
            return new AvailEntry(str, classLoader);
        }
    };
    private static final Comparator<String[]> COMPARE_FIRST_ELEMENT = new Comparator<String[]>() { // from class: com.ibm.icu.impl.ICUResourceBundle.4
        @Override // java.util.Comparator
        public int compare(String[] strArr, String[] strArr2) {
            return strArr[0].compareTo(strArr2[0]);
        }
    };

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class AvailEntry {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private volatile Set<String> fullNameSet;
        private ClassLoader loader;
        private volatile Locale[] locales;
        private volatile Set<String> nameSet;
        private String prefix;
        private volatile EnumMap<ULocale.AvailableType, ULocale[]> ulocales;

        public AvailEntry(String str, ClassLoader classLoader) {
            this.prefix = str;
            this.loader = classLoader;
        }

        public Set<String> getFullLocaleNameSet() {
            if (this.fullNameSet == null) {
                synchronized (this) {
                    try {
                        if (this.fullNameSet == null) {
                            this.fullNameSet = ICUResourceBundle.createFullLocaleNameSet(this.prefix, this.loader);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            return this.fullNameSet;
        }

        public Locale[] getLocaleList(ULocale.AvailableType availableType) {
            if (this.locales == null) {
                getULocaleList(availableType);
                synchronized (this) {
                    try {
                        if (this.locales == null) {
                            this.locales = ICUResourceBundle.getLocaleList(this.ulocales.get(availableType));
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            return this.locales;
        }

        public Set<String> getLocaleNameSet() {
            if (this.nameSet == null) {
                synchronized (this) {
                    try {
                        if (this.nameSet == null) {
                            this.nameSet = ICUResourceBundle.createLocaleNameSet(this.prefix, this.loader);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            return this.nameSet;
        }

        public ULocale[] getULocaleList(ULocale.AvailableType availableType) {
            if (this.ulocales == null) {
                synchronized (this) {
                    try {
                        if (this.ulocales == null) {
                            this.ulocales = ICUResourceBundle.createULocaleList(this.prefix, this.loader);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            return this.ulocales.get(availableType);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class AvailableLocalesSink extends UResource.Sink {
        EnumMap<ULocale.AvailableType, ULocale[]> output;

        public AvailableLocalesSink(EnumMap<ULocale.AvailableType, ULocale[]> enumMap) {
            this.output = enumMap;
        }

        @Override // com.ibm.icu.impl.UResource.Sink
        public void put(UResource.Key key, UResource.Value value, boolean z) {
            ULocale.AvailableType availableType;
            UResource.Table table = value.getTable();
            for (int i = 0; table.getKeyAndValue(i, key, value); i++) {
                if (key.contentEquals(ICUResourceBundle.INSTALLED_LOCALES)) {
                    availableType = ULocale.AvailableType.DEFAULT;
                } else {
                    if (key.contentEquals("AliasLocales")) {
                        availableType = ULocale.AvailableType.ONLY_LEGACY_ALIASES;
                    }
                }
                UResource.Table table2 = value.getTable();
                ULocale[] uLocaleArr = new ULocale[table2.getSize()];
                for (int i2 = 0; table2.getKeyAndValue(i2, key, value); i2++) {
                    uLocaleArr[i2] = new ULocale(key.toString());
                }
                this.output.put(availableType, uLocaleArr);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public enum OpenType {
        LOCALE_DEFAULT_ROOT,
        LOCALE_ROOT,
        LOCALE_ONLY,
        DIRECT
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class WholeBundle {
        String baseName;
        ClassLoader loader;
        String localeID;
        ICUResourceBundleReader reader;
        Set<String> topLevelKeys;
        ULocale ulocale;

        public WholeBundle(String str, String str2, ClassLoader classLoader, ICUResourceBundleReader iCUResourceBundleReader) {
            this.baseName = str;
            this.localeID = str2;
            this.ulocale = new ULocale(str2);
            this.loader = classLoader;
            this.reader = iCUResourceBundleReader;
        }
    }

    public ICUResourceBundle(ICUResourceBundle iCUResourceBundle, String str) {
        this.key = str;
        this.wholeBundle = iCUResourceBundle.wholeBundle;
        this.container = iCUResourceBundle;
        ((ResourceBundle) this).parent = ((ResourceBundle) iCUResourceBundle).parent;
    }

    private static final void addBundleBaseNamesFromClassLoader(final String str, final ClassLoader classLoader, final Set<String> set) {
        AccessController.doPrivileged(new PrivilegedAction<Void>() { // from class: com.ibm.icu.impl.ICUResourceBundle.2
            @Override // java.security.PrivilegedAction
            public Void run() {
                try {
                    Enumeration<URL> resources = classLoader.getResources(str);
                    if (resources == null) {
                        return null;
                    }
                    URLHandler.URLVisitor uRLVisitor = new URLHandler.URLVisitor() { // from class: com.ibm.icu.impl.ICUResourceBundle.2.1
                        @Override // com.ibm.icu.impl.URLHandler.URLVisitor
                        public void visit(String str2) {
                            if (str2.endsWith(".res")) {
                                set.add(str2.substring(0, str2.length() - 4));
                            }
                        }
                    };
                    while (resources.hasMoreElements()) {
                        URL urlNextElement = resources.nextElement();
                        URLHandler uRLHandler = URLHandler.get(urlNextElement);
                        if (uRLHandler != null) {
                            uRLHandler.guide(uRLVisitor, false);
                        } else if (ICUResourceBundle.DEBUG) {
                            System.out.println("handler for " + String.valueOf(urlNextElement) + " is null");
                        }
                    }
                } catch (IOException e) {
                    if (ICUResourceBundle.DEBUG) {
                        ky0.y("ouch: ", e.getMessage(), System.out);
                    }
                }
                return null;
            }
        });
    }

    private static final void addLocaleIDsFromIndexBundle(String str, ClassLoader classLoader, Set<String> set) {
        try {
            UResourceBundleIterator iterator = ((ICUResourceBundle) ((ICUResourceBundle) UResourceBundle.instantiateBundle(str, ICU_RESOURCE_INDEX, classLoader, true)).get(INSTALLED_LOCALES)).getIterator();
            iterator.reset();
            while (iterator.hasNext()) {
                set.add(iterator.next().getKey());
            }
        } catch (MissingResourceException unused) {
            if (DEBUG) {
                System.out.println("couldn't find " + str + "/res_index.res");
                Thread.dumpStack();
            }
        }
    }

    private static void addLocaleIDsFromListFile(String str, ClassLoader classLoader, Set<String> set) {
        try {
            InputStream resourceAsStream = classLoader.getResourceAsStream(str + FULL_LOCALE_NAMES_LIST);
            if (resourceAsStream == null) {
                return;
            }
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(resourceAsStream, "ASCII"));
            while (true) {
                try {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        bufferedReader.close();
                        return;
                    } else if (line.length() != 0 && !line.startsWith("#")) {
                        set.add(line);
                    }
                } catch (Throwable th) {
                    bufferedReader.close();
                    throw th;
                }
            }
        } catch (IOException unused) {
        }
    }

    private static int countPathKeys(String str) {
        if (str.isEmpty()) {
            return 0;
        }
        int i = 1;
        for (int i2 = 0; i2 < str.length(); i2++) {
            if (str.charAt(i2) == '/') {
                i++;
            }
        }
        return i;
    }

    public static ICUResourceBundle createBundle(String str, String str2, ClassLoader classLoader) {
        ICUResourceBundleReader reader = ICUResourceBundleReader.getReader(str, str2, classLoader);
        if (reader == null) {
            return null;
        }
        return getBundle(reader, str, str2, classLoader);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Set<String> createFullLocaleNameSet(String str, ClassLoader classLoader) {
        String strSubstring;
        String strConcat = str.endsWith(RES_PATH_SEP_STR) ? str : str.concat(RES_PATH_SEP_STR);
        HashSet hashSet = new HashSet();
        if (!ICUConfig.get("com.ibm.icu.impl.ICUResourceBundle.skipRuntimeLocaleResourceScan", "false").equalsIgnoreCase("true")) {
            addBundleBaseNamesFromClassLoader(strConcat, classLoader, hashSet);
            if (str.startsWith(ICUData.ICU_BASE_NAME)) {
                if (str.length() == 29) {
                    strSubstring = "";
                } else {
                    strSubstring = str.charAt(29) == '/' ? str.substring(30) : null;
                }
                if (strSubstring != null) {
                    ICUBinary.addBaseNamesInFileFolder(strSubstring, ".res", hashSet);
                }
            }
            hashSet.remove(ICU_RESOURCE_INDEX);
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                String str2 = (String) it.next();
                if (str2.length() == 1 || str2.length() > 3) {
                    if (str2.indexOf(95) < 0) {
                        it.remove();
                    }
                }
            }
        }
        if (hashSet.isEmpty()) {
            if (DEBUG) {
                System.out.println("unable to enumerate data files in ".concat(str));
            }
            addLocaleIDsFromListFile(strConcat, classLoader, hashSet);
        }
        if (hashSet.isEmpty()) {
            addLocaleIDsFromIndexBundle(str, classLoader, hashSet);
        }
        hashSet.remove("root");
        hashSet.add(ULocale.ROOT.toString());
        return Collections.unmodifiableSet(hashSet);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Set<String> createLocaleNameSet(String str, ClassLoader classLoader) {
        HashSet hashSet = new HashSet();
        addLocaleIDsFromIndexBundle(str, classLoader, hashSet);
        return Collections.unmodifiableSet(hashSet);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EnumMap<ULocale.AvailableType, ULocale[]> createULocaleList(String str, ClassLoader classLoader) {
        ICUResourceBundle iCUResourceBundle = (ICUResourceBundle) UResourceBundle.instantiateBundle(str, ICU_RESOURCE_INDEX, classLoader, true);
        EnumMap<ULocale.AvailableType, ULocale[]> enumMap = new EnumMap<>(ULocale.AvailableType.class);
        iCUResourceBundle.getAllItemsWithFallback("", new AvailableLocalesSink(enumMap));
        return enumMap;
    }

    private static final ICUResourceBundle findResourceWithFallback(String[] strArr, int i, ICUResourceBundle iCUResourceBundle, UResourceBundle uResourceBundle) {
        if (uResourceBundle == null) {
            uResourceBundle = iCUResourceBundle;
        }
        while (true) {
            int i2 = i + 1;
            ICUResourceBundle iCUResourceBundle2 = (ICUResourceBundle) iCUResourceBundle.handleGet(strArr[i], (HashMap<String, String>) null, uResourceBundle);
            if (iCUResourceBundle2 == null) {
                ICUResourceBundle parent = iCUResourceBundle.getParent();
                if (parent == null) {
                    return null;
                }
                int resDepth = iCUResourceBundle.getResDepth();
                if (i != resDepth) {
                    String[] strArr2 = new String[(strArr.length - i) + resDepth];
                    System.arraycopy(strArr, i, strArr2, resDepth, strArr.length - i);
                    strArr = strArr2;
                }
                iCUResourceBundle.getResPathKeys(strArr, resDepth);
                i = 0;
                iCUResourceBundle = parent;
            } else {
                if (i2 == strArr.length) {
                    return iCUResourceBundle2;
                }
                i = i2;
                iCUResourceBundle = iCUResourceBundle2;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:28:0x0065  */
    /* JADX WARN: Code duplicated, block: B:30:0x006c  */
    /* JADX WARN: Code duplicated, block: B:31:0x0076  */
    /* JADX WARN: Code duplicated, block: B:35:0x007c  */
    /* JADX WARN: Code duplicated, block: B:37:0x0081  */
    /* JADX WARN: Code duplicated, block: B:39:0x0087 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:40:0x0088  */
    /* JADX WARN: Code duplicated, block: B:42:0x0090 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:46:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:54:0x007a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:58:0x00b3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:59:0x009c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:62:0x0062 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:63:0x0092 A[SYNTHETIC] */
    private static final String findStringWithFallback(String str, UResourceBundle uResourceBundle, UResourceBundle uResourceBundle2) {
        ICUResourceBundleReader.Container array;
        String str2;
        int resource;
        ICUResourceBundle aliasedResource;
        String string;
        ICUResourceBundleReader iCUResourceBundleReader;
        int resDepth;
        if (str.length() == 0 || !(uResourceBundle instanceof ICUResourceBundleImpl.ResourceContainer)) {
            return null;
        }
        UResourceBundle uResourceBundle3 = uResourceBundle2 == null ? uResourceBundle : uResourceBundle2;
        ICUResourceBundle iCUResourceBundle = (ICUResourceBundle) uResourceBundle;
        ICUResourceBundleReader iCUResourceBundleReader2 = iCUResourceBundle.wholeBundle.reader;
        int resDepth2 = iCUResourceBundle.getResDepth();
        int iCountPathKeys = countPathKeys(str);
        String[] strArr = new String[resDepth2 + iCountPathKeys];
        getResPathKeys(str, iCountPathKeys, strArr, resDepth2);
        int i = -1;
        ICUResourceBundle iCUResourceBundle2 = iCUResourceBundle;
        while (true) {
            int i2 = resDepth2;
            while (true) {
                if (i != -1) {
                    int iRES_GET_TYPE = ICUResourceBundleReader.RES_GET_TYPE(i);
                    if (ICUResourceBundleReader.URES_IS_TABLE(iRES_GET_TYPE)) {
                        array = iCUResourceBundleReader2.getTable(i);
                    } else if (ICUResourceBundleReader.URES_IS_ARRAY(iRES_GET_TYPE)) {
                        array = iCUResourceBundleReader2.getArray(i);
                    } else {
                        i = -1;
                    }
                    ICUResourceBundleReader.Container container = array;
                    resDepth2++;
                    str2 = strArr[resDepth2];
                    resource = container.getResource(iCUResourceBundleReader2, str2);
                    if (resource == -1) {
                        i = resource;
                    } else {
                        if (ICUResourceBundleReader.RES_GET_TYPE(resource) == 3) {
                            iCUResourceBundle2.getResPathKeys(strArr, i2);
                            aliasedResource = getAliasedResource(iCUResourceBundle2, strArr, resDepth2, str2, resource, null, uResourceBundle3);
                        } else {
                            aliasedResource = null;
                        }
                        if (resDepth2 == strArr.length) {
                            if (aliasedResource != null) {
                                return aliasedResource.getString();
                            }
                            string = iCUResourceBundleReader2.getString(resource);
                            if (string != null) {
                                return string;
                            }
                            throw new UResourceTypeMismatchException("");
                        }
                        if (aliasedResource != null) {
                            iCUResourceBundleReader = aliasedResource.wholeBundle.reader;
                            resDepth = aliasedResource.getResDepth();
                            if (resDepth2 != resDepth) {
                                String[] strArr2 = new String[(strArr.length - resDepth2) + resDepth];
                                System.arraycopy(strArr, resDepth2, strArr2, resDepth, strArr.length - resDepth2);
                                i = -1;
                                strArr = strArr2;
                                iCUResourceBundle2 = aliasedResource;
                                resDepth2 = resDepth;
                            } else {
                                iCUResourceBundleReader2 = iCUResourceBundleReader;
                                i2 = resDepth;
                                iCUResourceBundle2 = aliasedResource;
                                i = -1;
                            }
                        } else {
                            i = resource;
                        }
                    }
                    iCUResourceBundleReader2 = iCUResourceBundleReader;
                } else {
                    int type = iCUResourceBundle2.getType();
                    if (type == 2 || type == 8) {
                        array = ((ICUResourceBundleImpl.ResourceContainer) iCUResourceBundle2).value;
                        ICUResourceBundleReader.Container container2 = array;
                        resDepth2++;
                        str2 = strArr[resDepth2];
                        resource = container2.getResource(iCUResourceBundleReader2, str2);
                        if (resource == -1) {
                            i = resource;
                        } else {
                            if (ICUResourceBundleReader.RES_GET_TYPE(resource) == 3) {
                                iCUResourceBundle2.getResPathKeys(strArr, i2);
                                aliasedResource = getAliasedResource(iCUResourceBundle2, strArr, resDepth2, str2, resource, null, uResourceBundle3);
                            } else {
                                aliasedResource = null;
                            }
                            if (resDepth2 == strArr.length) {
                                if (aliasedResource != null) {
                                    return aliasedResource.getString();
                                }
                                string = iCUResourceBundleReader2.getString(resource);
                                if (string != null) {
                                    return string;
                                }
                                throw new UResourceTypeMismatchException("");
                            }
                            if (aliasedResource != null) {
                                iCUResourceBundleReader = aliasedResource.wholeBundle.reader;
                                resDepth = aliasedResource.getResDepth();
                                if (resDepth2 != resDepth) {
                                    String[] strArr3 = new String[(strArr.length - resDepth2) + resDepth];
                                    System.arraycopy(strArr, resDepth2, strArr3, resDepth, strArr.length - resDepth2);
                                    i = -1;
                                    strArr = strArr3;
                                    iCUResourceBundle2 = aliasedResource;
                                    resDepth2 = resDepth;
                                } else {
                                    iCUResourceBundleReader2 = iCUResourceBundleReader;
                                    i2 = resDepth;
                                    iCUResourceBundle2 = aliasedResource;
                                    i = -1;
                                }
                            } else {
                                i = resource;
                            }
                        }
                        iCUResourceBundleReader2 = iCUResourceBundleReader;
                    }
                }
                ICUResourceBundle parent = iCUResourceBundle2.getParent();
                if (parent == null) {
                    return null;
                }
                iCUResourceBundle2.getResPathKeys(strArr, i2);
                iCUResourceBundleReader = parent.wholeBundle.reader;
                resDepth2 = 0;
                iCUResourceBundle2 = parent;
                iCUResourceBundleReader2 = iCUResourceBundleReader;
            }
        }
    }

    public static ICUResourceBundle getAliasedResource(String str, ClassLoader classLoader, String str2, String[] strArr, int i, String[] strArr2, HashMap<String, String> map, UResourceBundle uResourceBundle) {
        String strSubstring;
        String strSubstring2;
        String strSubstring3;
        int length;
        String[] strArr3;
        int iIndexOf;
        HashMap<String, String> map2 = map == null ? new HashMap<>() : map;
        ICUResourceBundle iCUResourceBundleFindResourceWithFallback = null;
        if (map2.get(str) != null) {
            og.i("Circular references in the resource bundles");
            return null;
        }
        map2.put(str, "");
        if (str.indexOf(47) == 0) {
            int iIndexOf2 = str.indexOf(47, 1);
            int i2 = iIndexOf2 + 1;
            int iIndexOf3 = str.indexOf(47, i2);
            strSubstring3 = str.substring(1, iIndexOf2);
            if (iIndexOf3 < 0) {
                strSubstring = str.substring(i2);
                strSubstring2 = null;
            } else {
                String strSubstring4 = str.substring(i2, iIndexOf3);
                strSubstring2 = str.substring(iIndexOf3 + 1, str.length());
                strSubstring = strSubstring4;
            }
            if (strSubstring3.equals(ICUDATA)) {
                classLoader = ICU_DATA_CLASS_LOADER;
                strSubstring3 = ICUData.ICU_BASE_NAME;
            } else if (strSubstring3.indexOf(ICUDATA) > -1 && (iIndexOf = strSubstring3.indexOf(45)) > -1) {
                strSubstring3 = "com/ibm/icu/impl/data/icudata/".concat(strSubstring3.substring(iIndexOf + 1, strSubstring3.length()));
                classLoader = ICU_DATA_CLASS_LOADER;
            }
        } else {
            int iIndexOf4 = str.indexOf(47);
            if (iIndexOf4 != -1) {
                String strSubstring5 = str.substring(0, iIndexOf4);
                strSubstring2 = str.substring(iIndexOf4 + 1);
                strSubstring = strSubstring5;
            } else {
                strSubstring = str;
                strSubstring2 = null;
            }
            strSubstring3 = str2;
        }
        if (strSubstring3.equals(LOCALE)) {
            String strSubstring6 = str.substring(8, str.length());
            ICUResourceBundle iCUResourceBundle = (ICUResourceBundle) uResourceBundle;
            while (true) {
                ICUResourceBundle iCUResourceBundle2 = iCUResourceBundle.container;
                if (iCUResourceBundle2 == null) {
                    break;
                }
                iCUResourceBundle = iCUResourceBundle2;
            }
            iCUResourceBundleFindResourceWithFallback = findResourceWithFallback(strSubstring6, iCUResourceBundle, null);
        } else {
            ICUResourceBundle bundleInstance = getBundleInstance(strSubstring3, strSubstring, classLoader, false);
            if (strSubstring2 != null) {
                length = countPathKeys(strSubstring2);
                if (length > 0) {
                    strArr3 = new String[length];
                    getResPathKeys(strSubstring2, length, strArr3, 0);
                } else {
                    strArr3 = strArr;
                }
            } else if (strArr != null) {
                strArr3 = strArr;
                length = i;
            } else {
                length = strArr2.length;
                strArr3 = strArr2;
            }
            if (length > 0) {
                iCUResourceBundleFindResourceWithFallback = bundleInstance;
                for (int i3 = 0; iCUResourceBundleFindResourceWithFallback != null && i3 < length; i3++) {
                    iCUResourceBundleFindResourceWithFallback = iCUResourceBundleFindResourceWithFallback.get(strArr3[i3], map2, uResourceBundle);
                }
            }
        }
        if (iCUResourceBundleFindResourceWithFallback != null) {
            return iCUResourceBundleFindResourceWithFallback;
        }
        throw new MissingResourceException(strSubstring, str2, strArr2[strArr2.length - 1]);
    }

    private static AvailEntry getAvailEntry(String str, ClassLoader classLoader) {
        return GET_AVAILABLE_CACHE.getInstance(str, classLoader);
    }

    public static Set<String> getAvailableLocaleNameSet(String str, ClassLoader classLoader) {
        return getAvailEntry(str, classLoader).getLocaleNameSet();
    }

    public static final Locale[] getAvailableLocales() {
        return getAvailableLocales(ICUData.ICU_BASE_NAME, ICU_DATA_CLASS_LOADER, ULocale.AvailableType.DEFAULT);
    }

    public static final ULocale[] getAvailableULocales() {
        return getAvailableULocales(ICUData.ICU_BASE_NAME, ICU_DATA_CLASS_LOADER, ULocale.AvailableType.DEFAULT);
    }

    private static ICUResourceBundle getBundle(ICUResourceBundleReader iCUResourceBundleReader, String str, String str2, ClassLoader classLoader) {
        int rootResource = iCUResourceBundleReader.getRootResource();
        if (!ICUResourceBundleReader.URES_IS_TABLE(ICUResourceBundleReader.RES_GET_TYPE(rootResource))) {
            og.n("Invalid format error");
            return null;
        }
        ICUResourceBundleImpl.ResourceTable resourceTable = new ICUResourceBundleImpl.ResourceTable(new WholeBundle(str, str2, classLoader, iCUResourceBundleReader), rootResource);
        String strFindString = resourceTable.findString("%%ALIAS");
        return strFindString != null ? (ICUResourceBundle) UResourceBundle.getBundleInstance(str, strFindString) : resourceTable;
    }

    public static ICUResourceBundle getBundleInstance(String str, String str2, ClassLoader classLoader, OpenType openType) {
        if (str == null) {
            str = ICUData.ICU_BASE_NAME;
        }
        String str3 = str;
        String baseName = ULocale.getBaseName(str2);
        ICUResourceBundle iCUResourceBundleInstantiateBundle = openType == OpenType.LOCALE_DEFAULT_ROOT ? instantiateBundle(str3, baseName, null, ULocale.getDefault().getBaseName(), classLoader, openType) : instantiateBundle(str3, baseName, null, null, classLoader, openType);
        if (iCUResourceBundleInstantiateBundle != null) {
            return iCUResourceBundleInstantiateBundle;
        }
        throw new MissingResourceException(ky0.l("Could not find the bundle ", str3, RES_PATH_SEP_STR, baseName, ".res"), "", "");
    }

    private static String getDefaultScript(String str, String str2) {
        String strK = cq.k(str, BaseLocale.SEP, str2);
        Map<String, String> map = LocaleFallbackData.DEFAULT_SCRIPT_TABLE;
        String str3 = map.get(strK);
        if (str3 == null) {
            str3 = map.get(str);
        }
        return str3 == null ? "Latn" : str3;
    }

    private static String getExplicitParent(String str) {
        return LocaleFallbackData.PARENT_LOCALE_TABLE.get(str);
    }

    public static Set<String> getFullLocaleNameSet() {
        return getFullLocaleNameSet(ICUData.ICU_BASE_NAME, ICU_DATA_CLASS_LOADER);
    }

    public static final ULocale getFunctionalEquivalent(String str, ClassLoader classLoader, String str2, String str3, ULocale uLocale, boolean[] zArr, boolean z) {
        boolean z2;
        String keywordValue = uLocale.getKeywordValue(str3);
        String baseName = uLocale.getBaseName();
        ULocale uLocale2 = new ULocale(baseName);
        int i = 0;
        if (keywordValue == null || keywordValue.length() == 0 || keywordValue.equals("default")) {
            keywordValue = "";
            z2 = true;
        } else {
            z2 = false;
        }
        ICUResourceBundle parent = (ICUResourceBundle) UResourceBundle.getBundleInstance(str, uLocale2);
        if (zArr != null) {
            zArr[0] = false;
            for (ULocale uLocale3 : getAvailEntry(str, classLoader).getULocaleList(ULocale.AvailableType.DEFAULT)) {
                if (uLocale2.equals(uLocale3)) {
                    zArr[0] = true;
                    break;
                }
            }
        }
        ULocale uLocale4 = null;
        String string = null;
        int i2 = 0;
        do {
            try {
                string = ((ICUResourceBundle) parent.get(str2)).getString("default");
                if (z2) {
                    z2 = false;
                    keywordValue = string;
                }
                uLocale4 = parent.getULocale();
            } catch (MissingResourceException unused) {
            }
            if (uLocale4 == null) {
                parent = parent.getParent();
                i2++;
            }
            if (parent == null) {
                break;
            }
        } while (uLocale4 == null);
        ICUResourceBundle parent2 = (ICUResourceBundle) UResourceBundle.getBundleInstance(str, new ULocale(baseName));
        ULocale uLocale5 = null;
        int i3 = 0;
        do {
            try {
                ICUResourceBundle iCUResourceBundle = (ICUResourceBundle) parent2.get(str2);
                iCUResourceBundle.get(keywordValue);
                uLocale5 = iCUResourceBundle.getULocale();
                if (uLocale5 != null && i3 > i2) {
                    string = iCUResourceBundle.getString("default");
                    parent2.getULocale();
                    i2 = i3;
                }
            } catch (MissingResourceException unused2) {
            }
            if (uLocale5 == null) {
                parent2 = parent2.getParent();
                i3++;
            }
            if (parent2 == null) {
                break;
            }
        } while (uLocale5 == null);
        if (uLocale5 == null && string != null && !string.equals(keywordValue)) {
            ICUResourceBundle parent3 = (ICUResourceBundle) UResourceBundle.getBundleInstance(str, new ULocale(baseName));
            String string2 = string;
            do {
                try {
                    ICUResourceBundle iCUResourceBundle2 = (ICUResourceBundle) parent3.get(str2);
                    ICUResourceBundle iCUResourceBundle3 = (ICUResourceBundle) iCUResourceBundle2.get(string);
                    uLocale5 = parent3.getULocale();
                    if (!uLocale5.getBaseName().equals(iCUResourceBundle3.getULocale().getBaseName())) {
                        uLocale5 = null;
                    }
                    if (uLocale5 != null && i > i2) {
                        string2 = iCUResourceBundle2.getString("default");
                        parent3.getULocale();
                        i2 = i;
                    }
                } catch (MissingResourceException unused3) {
                }
                if (uLocale5 == null) {
                    parent3 = parent3.getParent();
                    i++;
                }
                if (parent3 == null) {
                    break;
                }
            } while (uLocale5 == null);
            i3 = i;
            keywordValue = string;
            string = string2;
        }
        if (uLocale5 == null) {
            throw new MissingResourceException("Could not find locale containing requested or default keyword.", str, cq.k(str3, "=", keywordValue));
        }
        if (z && string.equals(keywordValue) && i3 <= i2) {
            return uLocale5;
        }
        return new ULocale(uLocale5.getBaseName() + "@" + str3 + "=" + keywordValue);
    }

    public static final String[] getKeywordValues(String str, String str2) {
        HashSet hashSet = new HashSet();
        for (ULocale uLocale : getAvailEntry(str, ICU_DATA_CLASS_LOADER).getULocaleList(ULocale.AvailableType.DEFAULT)) {
            try {
                Enumeration<String> keys = ((ICUResourceBundle) UResourceBundle.getBundleInstance(str, uLocale).getObject(str2)).getKeys();
                while (keys.hasMoreElements()) {
                    String strNextElement = keys.nextElement();
                    if (!"default".equals(strNextElement) && !strNextElement.startsWith("private-")) {
                        hashSet.add(strNextElement);
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return (String[]) hashSet.toArray(new String[0]);
    }

    public static final Locale[] getLocaleList(ULocale[] uLocaleArr) {
        ArrayList arrayList = new ArrayList(uLocaleArr.length);
        HashSet hashSet = new HashSet();
        for (ULocale uLocale : uLocaleArr) {
            Locale locale = uLocale.toLocale();
            if (!hashSet.contains(locale)) {
                arrayList.add(locale);
                hashSet.add(locale);
            }
        }
        return (Locale[]) arrayList.toArray(new Locale[arrayList.size()]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean getNoFallback() {
        return this.wholeBundle.reader.getNoFallback();
    }

    public static String getParentLocaleID(String str, String str2, OpenType openType) {
        String explicitParent;
        if (str.endsWith(BaseLocale.SEP) || !ULocale.getVariant(str).isEmpty()) {
            int iLastIndexOf = str.lastIndexOf(95);
            if (iLastIndexOf >= 0) {
                return str.substring(0, iLastIndexOf);
            }
            return null;
        }
        ULocale uLocale = new ULocale(str);
        String language = uLocale.getLanguage();
        String script = uLocale.getScript();
        String country = uLocale.getCountry();
        OpenType openType2 = OpenType.LOCALE_DEFAULT_ROOT;
        if (openType == openType2 && (explicitParent = getExplicitParent(str)) != null) {
            if (explicitParent.equals("root")) {
                return null;
            }
            return explicitParent;
        }
        if (!script.isEmpty() && !country.isEmpty()) {
            return getDefaultScript(language, country).equals(script) ? cq.k(language, BaseLocale.SEP, country) : cq.k(language, BaseLocale.SEP, script);
        }
        if (!country.isEmpty()) {
            String script2 = ULocale.getScript(str2);
            return !script2.isEmpty() ? cq.k(language, BaseLocale.SEP, script2) : cq.k(language, BaseLocale.SEP, getDefaultScript(language, country));
        }
        if (script.isEmpty()) {
            return null;
        }
        if (openType != openType2 || getDefaultScript(language, null).equals(script)) {
            return language;
        }
        return null;
    }

    private int getResDepth() {
        ICUResourceBundle iCUResourceBundle = this.container;
        if (iCUResourceBundle == null) {
            return 0;
        }
        return iCUResourceBundle.getResDepth() + 1;
    }

    private static void getResPathKeys(String str, int i, String[] strArr, int i2) {
        if (i == 0) {
            return;
        }
        if (i == 1) {
            strArr[i2] = str;
            return;
        }
        int i3 = 0;
        while (true) {
            int iIndexOf = str.indexOf(47, i3);
            int i4 = i2 + 1;
            strArr[i2] = str.substring(i3, iIndexOf);
            if (i == 2) {
                strArr[i4] = str.substring(iIndexOf + 1);
                return;
            } else {
                i3 = iIndexOf + 1;
                i--;
                i2 = i4;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ICUResourceBundle instantiateBundle(final String str, final String str2, final String str3, final String str4, final ClassLoader classLoader, final OpenType openType) {
        String str5;
        final String fullName = ICUResourceBundleReader.getFullName(str, str2);
        char cOrdinal = (char) (openType.ordinal() + 48);
        if (openType != OpenType.LOCALE_DEFAULT_ROOT) {
            str5 = fullName + "#" + cOrdinal;
        } else {
            str5 = fullName + "#" + cOrdinal + "#" + str4;
        }
        return BUNDLE_CACHE.getInstance(str5, new Loader() { // from class: com.ibm.icu.impl.ICUResourceBundle.5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // com.ibm.icu.impl.ICUResourceBundle.Loader
            public ICUResourceBundle load() {
                ICUResourceBundle iCUResourceBundleInstantiateBundle;
                if (ICUResourceBundle.DEBUG) {
                    ky0.y("Creating ", fullName, System.out);
                }
                String str6 = str.indexOf(46) == -1 ? "root" : "";
                String str7 = str2.isEmpty() ? str6 : str2;
                ICUResourceBundle iCUResourceBundleCreateBundle = ICUResourceBundle.createBundle(str, str7, classLoader);
                if (ICUResourceBundle.DEBUG) {
                    PrintStream printStream = System.out;
                    String strValueOf = String.valueOf(iCUResourceBundleCreateBundle);
                    String strValueOf2 = String.valueOf(openType);
                    boolean z = iCUResourceBundleCreateBundle != null && iCUResourceBundleCreateBundle.getNoFallback();
                    StringBuilder sbQ = cq.q("The bundle created is: ", strValueOf, " and openType=", strValueOf2, " and bundle.getNoFallback=");
                    sbQ.append(z);
                    printStream.println(sbQ.toString());
                }
                if (openType != OpenType.DIRECT && (iCUResourceBundleCreateBundle == null || !iCUResourceBundleCreateBundle.getNoFallback())) {
                    if (iCUResourceBundleCreateBundle == null) {
                        OpenType openType2 = openType;
                        OpenType openType3 = OpenType.LOCALE_DEFAULT_ROOT;
                        if (openType2 == openType3 && str7.equals(str4)) {
                            openType2 = OpenType.LOCALE_ROOT;
                        }
                        OpenType openType4 = openType2;
                        String str8 = str3;
                        String str9 = str8 != null ? str8 : str7;
                        String parentLocaleID = ICUResourceBundle.getParentLocaleID(str7, str9, openType);
                        if (parentLocaleID != null) {
                            return ICUResourceBundle.instantiateBundle(str, parentLocaleID, str9, str4, classLoader, openType4);
                        }
                        if (openType4 == openType3 && !ICUResourceBundle.localeIDStartsWithLangSubtag(str4, str7)) {
                            String str10 = str;
                            String str11 = str4;
                            return ICUResourceBundle.instantiateBundle(str10, str11, null, str11, classLoader, openType4);
                        }
                        if (openType4 != OpenType.LOCALE_ONLY && !str6.isEmpty()) {
                            return ICUResourceBundle.createBundle(str, str6, classLoader);
                        }
                    } else {
                        String localeID = iCUResourceBundleCreateBundle.getLocaleID();
                        int iLastIndexOf = localeID.lastIndexOf(95);
                        String strFindString = ((ICUResourceBundleImpl.ResourceTable) iCUResourceBundleCreateBundle).findString("%%Parent");
                        if (strFindString != null) {
                            iCUResourceBundleInstantiateBundle = ICUResourceBundle.instantiateBundle(str, strFindString, null, str4, classLoader, openType);
                        } else if (iLastIndexOf != -1) {
                            iCUResourceBundleInstantiateBundle = ICUResourceBundle.instantiateBundle(str, localeID.substring(0, iLastIndexOf), null, str4, classLoader, openType);
                        } else {
                            iCUResourceBundleInstantiateBundle = !localeID.equals(str6) ? ICUResourceBundle.instantiateBundle(str, str6, null, str4, classLoader, openType) : null;
                        }
                        if (!iCUResourceBundleCreateBundle.equals(iCUResourceBundleInstantiateBundle)) {
                            iCUResourceBundleCreateBundle.setParent(iCUResourceBundleInstantiateBundle);
                        }
                    }
                }
                return iCUResourceBundleCreateBundle;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean localeIDStartsWithLangSubtag(String str, String str2) {
        if (str.startsWith(str2)) {
            return str.length() == str2.length() || str.charAt(str2.length()) == '_';
        }
        return false;
    }

    public ICUResourceBundle at(String str) {
        if (this instanceof ICUResourceBundleImpl.ResourceTable) {
            return (ICUResourceBundle) handleGet(str, (HashMap<String, String>) null, this);
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ICUResourceBundle)) {
            return false;
        }
        ICUResourceBundle iCUResourceBundle = (ICUResourceBundle) obj;
        return getBaseName().equals(iCUResourceBundle.getBaseName()) && getLocaleID().equals(iCUResourceBundle.getLocaleID());
    }

    @Override // com.ibm.icu.util.UResourceBundle
    public ICUResourceBundle findTopLevel(int i) {
        return (ICUResourceBundle) super.findTopLevel(i);
    }

    public ICUResourceBundle findWithFallback(String str) {
        return findResourceWithFallback(str, this, null);
    }

    public ICUResourceBundle get(String str, HashMap<String, String> map, UResourceBundle uResourceBundle) {
        ICUResourceBundle iCUResourceBundle = (ICUResourceBundle) handleGet(str, map, uResourceBundle);
        if (iCUResourceBundle != null) {
            return iCUResourceBundle;
        }
        ICUResourceBundle parent = getParent();
        if (parent != null) {
            parent = parent.get(str, map, uResourceBundle);
        }
        if (parent != null) {
            return parent;
        }
        throw new MissingResourceException(cq.l("Can't find resource for bundle ", ICUResourceBundleReader.getFullName(getBaseName(), getLocaleID()), ", key ", str), getClass().getName(), str);
    }

    public void getAllChildrenWithFallback(String str, final UResource.Sink sink) {
        getAllItemsWithFallback(str, new UResource.Sink() { // from class: com.ibm.icu.impl.ICUResourceBundle.1AllChildrenSink
            @Override // com.ibm.icu.impl.UResource.Sink
            public void put(UResource.Key key, UResource.Value value, boolean z) {
                UResource.Table table = value.getTable();
                for (int i = 0; table.getKeyAndValue(i, key, value); i++) {
                    if (value.getType() == 3) {
                        String aliasString = value.getAliasString();
                        ICUResourceBundle iCUResourceBundle = ICUResourceBundle.this;
                        ICUResourceBundle aliasedResource = ICUResourceBundle.getAliasedResource(aliasString, iCUResourceBundle.wholeBundle.loader, "", null, 0, null, null, iCUResourceBundle);
                        ICUResourceBundleImpl iCUResourceBundleImpl = (ICUResourceBundleImpl) aliasedResource;
                        ICUResourceBundleReader.ReaderValue readerValue = new ICUResourceBundleReader.ReaderValue();
                        readerValue.reader = iCUResourceBundleImpl.wholeBundle.reader;
                        readerValue.res = iCUResourceBundleImpl.getResource();
                        if (readerValue.getType() != 2) {
                            sink.put(key, readerValue, z);
                        } else {
                            String strSubstring = aliasString.substring(8);
                            sink.put(key.m6clone(), readerValue, z);
                            int type = 2;
                            while (type == 2 && aliasedResource.getParent() != null) {
                                ICUResourceBundle iCUResourceBundleFindWithFallback = aliasedResource.getParent().findWithFallback(strSubstring);
                                if (iCUResourceBundleFindWithFallback.key.equals(aliasedResource.key)) {
                                    aliasedResource = iCUResourceBundleFindWithFallback;
                                } else {
                                    String strK = cq.k(strSubstring.substring(0, strSubstring.lastIndexOf(47)), ICUResourceBundle.RES_PATH_SEP_STR, iCUResourceBundleFindWithFallback.key);
                                    strSubstring = strK;
                                    aliasedResource = ICUResourceBundle.this.findWithFallback(strK);
                                }
                                ICUResourceBundleImpl iCUResourceBundleImpl2 = (ICUResourceBundleImpl) aliasedResource;
                                ICUResourceBundleReader.ReaderValue readerValue2 = new ICUResourceBundleReader.ReaderValue();
                                readerValue2.reader = iCUResourceBundleImpl2.wholeBundle.reader;
                                readerValue2.res = iCUResourceBundleImpl2.getResource();
                                type = readerValue2.getType();
                                sink.put(key.m6clone(), readerValue2, z);
                            }
                        }
                    } else {
                        sink.put(key, value, z);
                    }
                }
            }
        });
    }

    public void getAllItemsWithFallback(String str, UResource.Sink sink) {
        ICUResourceBundle iCUResourceBundleFindResourceWithFallback;
        int iCountPathKeys = countPathKeys(str);
        if (iCountPathKeys == 0) {
            iCUResourceBundleFindResourceWithFallback = this;
        } else {
            int resDepth = getResDepth();
            String[] strArr = new String[resDepth + iCountPathKeys];
            getResPathKeys(str, iCountPathKeys, strArr, resDepth);
            iCUResourceBundleFindResourceWithFallback = findResourceWithFallback(strArr, resDepth, this, null);
            if (iCUResourceBundleFindResourceWithFallback == null) {
                throw new MissingResourceException("Can't find resource for bundle " + getClass().getName() + ", key " + getType(), str, getKey());
            }
        }
        iCUResourceBundleFindResourceWithFallback.getAllItemsWithFallback(new UResource.Key(), new ICUResourceBundleReader.ReaderValue(), sink, this);
    }

    public void getAllItemsWithFallbackNoFail(String str, UResource.Sink sink) {
        try {
            getAllItemsWithFallback(str, sink);
        } catch (MissingResourceException unused) {
        }
    }

    @Override // com.ibm.icu.util.UResourceBundle
    public String getBaseName() {
        return this.wholeBundle.baseName;
    }

    @Override // com.ibm.icu.util.UResourceBundle
    public String getKey() {
        return this.key;
    }

    @Override // com.ibm.icu.util.UResourceBundle, java.util.ResourceBundle
    public Locale getLocale() {
        return getULocale().toLocale();
    }

    @Override // com.ibm.icu.util.UResourceBundle
    public String getLocaleID() {
        return this.wholeBundle.localeID;
    }

    public String getStringWithFallback(String str) {
        String strFindStringWithFallback = findStringWithFallback(str, this, null);
        if (strFindStringWithFallback != null) {
            if (strFindStringWithFallback.equals(NO_INHERITANCE_MARKER)) {
                throw new MissingResourceException("Encountered NO_INHERITANCE_MARKER", str, getKey());
            }
            return strFindStringWithFallback;
        }
        throw new MissingResourceException("Can't find resource for bundle " + getClass().getName() + ", key " + getType(), str, getKey());
    }

    @Deprecated
    public final Set<String> getTopLevelKeySet() {
        return this.wholeBundle.topLevelKeys;
    }

    @Override // com.ibm.icu.util.UResourceBundle
    public ULocale getULocale() {
        return this.wholeBundle.ulocale;
    }

    public UResource.Value getValueWithFallback(String str) {
        if (!str.isEmpty()) {
            ICUResourceBundle iCUResourceBundleFindResourceWithFallback = findResourceWithFallback(str, this, null);
            if (iCUResourceBundleFindResourceWithFallback == null) {
                throw new MissingResourceException("Can't find resource for bundle " + getClass().getName() + ", key " + getType(), str, getKey());
            }
            this = iCUResourceBundleFindResourceWithFallback;
        }
        ICUResourceBundleReader.ReaderValue readerValue = new ICUResourceBundleReader.ReaderValue();
        ICUResourceBundleImpl iCUResourceBundleImpl = (ICUResourceBundleImpl) this;
        readerValue.reader = iCUResourceBundleImpl.wholeBundle.reader;
        readerValue.res = iCUResourceBundleImpl.getResource();
        return readerValue;
    }

    public ICUResourceBundle getWithFallback(String str) {
        ICUResourceBundle iCUResourceBundleFindResourceWithFallback = findResourceWithFallback(str, this, null);
        if (iCUResourceBundleFindResourceWithFallback != null) {
            if (iCUResourceBundleFindResourceWithFallback.getType() == 0 && iCUResourceBundleFindResourceWithFallback.getString().equals(NO_INHERITANCE_MARKER)) {
                throw new MissingResourceException("Encountered NO_INHERITANCE_MARKER", str, getKey());
            }
            return iCUResourceBundleFindResourceWithFallback;
        }
        throw new MissingResourceException("Can't find resource for bundle " + getClass().getName() + ", key " + getType(), str, getKey());
    }

    @Override // com.ibm.icu.util.UResourceBundle
    public Enumeration<String> handleGetKeys() {
        return Collections.enumeration(handleKeySet());
    }

    public int hashCode() {
        return 42;
    }

    public boolean isRoot() {
        return this.wholeBundle.localeID.isEmpty() || this.wholeBundle.localeID.equals("root");
    }

    @Override // com.ibm.icu.util.UResourceBundle
    public boolean isTopLevelResource() {
        return this.container == null;
    }

    @Override // java.util.ResourceBundle
    public void setParent(ResourceBundle resourceBundle) {
        ((ResourceBundle) this).parent = resourceBundle;
    }

    @Deprecated
    public final void setTopLevelKeySet(Set<String> set) {
        this.wholeBundle.topLevelKeys = set;
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static abstract class Loader {
        public /* synthetic */ Loader(int i) {
            this();
        }

        public abstract ICUResourceBundle load();

        private Loader() {
        }
    }

    @Override // com.ibm.icu.util.UResourceBundle
    public ICUResourceBundle getParent() {
        return (ICUResourceBundle) ((ResourceBundle) this).parent;
    }

    public static Set<String> getAvailableLocaleNameSet() {
        return getAvailableLocaleNameSet(ICUData.ICU_BASE_NAME, ICU_DATA_CLASS_LOADER);
    }

    public static Set<String> getFullLocaleNameSet(String str, ClassLoader classLoader) {
        return getAvailEntry(str, classLoader).getFullLocaleNameSet();
    }

    @Override // com.ibm.icu.util.UResourceBundle
    public ICUResourceBundle findTopLevel(String str) {
        return (ICUResourceBundle) super.findTopLevel(str);
    }

    public static final Locale[] getAvailableLocales(String str, ClassLoader classLoader, ULocale.AvailableType availableType) {
        return getAvailEntry(str, classLoader).getLocaleList(availableType);
    }

    public static final ULocale[] getAvailableULocales(String str, ClassLoader classLoader, ULocale.AvailableType availableType) {
        return getAvailEntry(str, classLoader).getULocaleList(availableType);
    }

    public static final Locale[] getAvailableLocales(ULocale.AvailableType availableType) {
        return getAvailableLocales(ICUData.ICU_BASE_NAME, ICU_DATA_CLASS_LOADER, availableType);
    }

    public static final ULocale[] getAvailableULocales(ULocale.AvailableType availableType) {
        return getAvailableULocales(ICUData.ICU_BASE_NAME, ICU_DATA_CLASS_LOADER, availableType);
    }

    public static final Locale[] getAvailableLocales(String str, ClassLoader classLoader) {
        return getAvailableLocales(str, classLoader, ULocale.AvailableType.DEFAULT);
    }

    public static final ULocale[] getAvailableULocales(String str, ClassLoader classLoader) {
        return getAvailableULocales(str, classLoader, ULocale.AvailableType.DEFAULT);
    }

    public ICUResourceBundle at(int i) {
        return (ICUResourceBundle) handleGet(i, (HashMap<String, String>) null, this);
    }

    public ICUResourceBundle(WholeBundle wholeBundle) {
        this.wholeBundle = wholeBundle;
    }

    private void getResPathKeys(String[] strArr, int i) {
        while (i > 0) {
            i--;
            strArr[i] = this.key;
            this = this.container;
        }
    }

    private static final ICUResourceBundle findResourceWithFallback(String str, UResourceBundle uResourceBundle, UResourceBundle uResourceBundle2) {
        if (str.length() == 0) {
            return null;
        }
        ICUResourceBundle iCUResourceBundle = (ICUResourceBundle) uResourceBundle;
        int resDepth = iCUResourceBundle.getResDepth();
        int iCountPathKeys = countPathKeys(str);
        String[] strArr = new String[resDepth + iCountPathKeys];
        getResPathKeys(str, iCountPathKeys, strArr, resDepth);
        return findResourceWithFallback(strArr, resDepth, iCUResourceBundle, uResourceBundle2);
    }

    public static ICUResourceBundle getBundleInstance(String str, ULocale uLocale, OpenType openType) {
        if (uLocale == null) {
            uLocale = ULocale.getDefault();
        }
        return getBundleInstance(str, uLocale.getBaseName(), ICU_DATA_CLASS_LOADER, openType);
    }

    public static ICUResourceBundle getBundleInstance(String str, String str2, ClassLoader classLoader, boolean z) {
        return getBundleInstance(str, str2, classLoader, z ? OpenType.DIRECT : OpenType.LOCALE_DEFAULT_ROOT);
    }

    private void getAllItemsWithFallback(UResource.Key key, ICUResourceBundleReader.ReaderValue readerValue, UResource.Sink sink, UResourceBundle uResourceBundle) {
        ICUResourceBundleImpl iCUResourceBundleImpl = (ICUResourceBundleImpl) this;
        readerValue.reader = iCUResourceBundleImpl.wholeBundle.reader;
        readerValue.res = iCUResourceBundleImpl.getResource();
        String str = this.key;
        if (str == null) {
            str = "";
        }
        key.setString(str);
        sink.put(key, readerValue, ((ResourceBundle) this).parent == null);
        ResourceBundle resourceBundle = ((ResourceBundle) this).parent;
        if (resourceBundle != null) {
            ICUResourceBundle iCUResourceBundleFindResourceWithFallback = (ICUResourceBundle) resourceBundle;
            int resDepth = getResDepth();
            if (resDepth != 0) {
                String[] strArr = new String[resDepth];
                getResPathKeys(strArr, resDepth);
                iCUResourceBundleFindResourceWithFallback = findResourceWithFallback(strArr, 0, iCUResourceBundleFindResourceWithFallback, uResourceBundle);
            }
            if (iCUResourceBundleFindResourceWithFallback != null) {
                iCUResourceBundleFindResourceWithFallback.getAllItemsWithFallback(key, readerValue, sink, uResourceBundle);
            }
        }
    }

    public String findStringWithFallback(String str) {
        return findStringWithFallback(str, this, null);
    }

    public static ICUResourceBundle getAliasedResource(ICUResourceBundle iCUResourceBundle, String[] strArr, int i, String str, int i2, HashMap<String, String> map, UResourceBundle uResourceBundle) {
        WholeBundle wholeBundle = iCUResourceBundle.wholeBundle;
        ClassLoader classLoader = wholeBundle.loader;
        String alias = wholeBundle.reader.getAlias(i2);
        String str2 = wholeBundle.baseName;
        int resDepth = iCUResourceBundle.getResDepth();
        String[] strArr2 = new String[resDepth + 1];
        iCUResourceBundle.getResPathKeys(strArr2, resDepth);
        strArr2[resDepth] = str;
        return getAliasedResource(alias, classLoader, str2, strArr, i, strArr2, map, uResourceBundle);
    }
}
