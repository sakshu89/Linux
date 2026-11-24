package com.ibm.icu.util;

import com.ibm.icu.impl.ICUData;
import com.ibm.icu.impl.ICUResourceBundle;
import com.ibm.icu.impl.ICUResourceBundleReader;
import com.ibm.icu.impl.ResourceBundleWrapper;
import defpackage.cq;
import defpackage.ky0;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class UResourceBundle extends ResourceBundle {
    public static final int ARRAY = 8;
    public static final int BINARY = 1;
    public static final int INT = 7;
    public static final int INT_VECTOR = 14;
    public static final int NONE = -1;
    private static Map<String, RootType> ROOT_CACHE = new ConcurrentHashMap();
    public static final int STRING = 0;
    public static final int TABLE = 2;

    /* JADX INFO: renamed from: com.ibm.icu.util.UResourceBundle$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ibm$icu$util$UResourceBundle$RootType;

        static {
            int[] iArr = new int[RootType.values().length];
            $SwitchMap$com$ibm$icu$util$UResourceBundle$RootType = iArr;
            try {
                iArr[RootType.ICU.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ibm$icu$util$UResourceBundle$RootType[RootType.JAVA.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$ibm$icu$util$UResourceBundle$RootType[RootType.MISSING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public enum RootType {
        MISSING,
        ICU,
        JAVA
    }

    public static UResourceBundle getBundleInstance(String str, Locale locale) {
        if (str == null) {
            str = ICUData.ICU_BASE_NAME;
        }
        return getBundleInstance(str, (locale == null ? ULocale.getDefault() : ULocale.forLocale(locale)).getBaseName(), ICUResourceBundle.ICU_DATA_CLASS_LOADER, false);
    }

    private static RootType getRootType(String str, ClassLoader classLoader) {
        RootType rootType;
        RootType rootType2 = ROOT_CACHE.get(str);
        if (rootType2 != null) {
            return rootType2;
        }
        String str2 = str.indexOf(46) == -1 ? "root" : "";
        try {
            try {
                ICUResourceBundle.getBundleInstance(str, str2, classLoader, true);
                rootType = RootType.ICU;
            } catch (MissingResourceException unused) {
                ResourceBundleWrapper.getBundleInstance(str, str2, classLoader, true);
                rootType = RootType.JAVA;
            }
        } catch (MissingResourceException unused2) {
            rootType = RootType.MISSING;
        }
        ROOT_CACHE.put(str, rootType);
        return rootType;
    }

    private Object handleGetObjectImpl(String str, UResourceBundle uResourceBundle) {
        Object objResolveObject = resolveObject(str, uResourceBundle);
        if (objResolveObject != null) {
            return objResolveObject;
        }
        UResourceBundle parent = getParent();
        if (parent != null) {
            objResolveObject = parent.handleGetObjectImpl(str, uResourceBundle);
        }
        if (objResolveObject != null) {
            return objResolveObject;
        }
        throw new MissingResourceException(cq.l("Can't find resource for bundle ", getClass().getName(), ", key ", str), getClass().getName(), str);
    }

    public static UResourceBundle instantiateBundle(String str, String str2, ClassLoader classLoader, boolean z) {
        int i = AnonymousClass1.$SwitchMap$com$ibm$icu$util$UResourceBundle$RootType[getRootType(str, classLoader).ordinal()];
        if (i == 1) {
            return ICUResourceBundle.getBundleInstance(str, str2, classLoader, z);
        }
        if (i == 2) {
            return ResourceBundleWrapper.getBundleInstance(str, str2, classLoader, z);
        }
        try {
            ICUResourceBundle bundleInstance = ICUResourceBundle.getBundleInstance(str, str2, classLoader, z);
            setRootType(str, RootType.ICU);
            return bundleInstance;
        } catch (MissingResourceException unused) {
            ResourceBundleWrapper bundleInstance2 = ResourceBundleWrapper.getBundleInstance(str, str2, classLoader, z);
            setRootType(str, RootType.JAVA);
            return bundleInstance2;
        }
    }

    private Object resolveObject(String str, UResourceBundle uResourceBundle) {
        if (getType() == 0) {
            return getString();
        }
        UResourceBundle uResourceBundleHandleGet = handleGet(str, (HashMap<String, String>) null, uResourceBundle);
        if (uResourceBundleHandleGet == null) {
            return uResourceBundleHandleGet;
        }
        if (uResourceBundleHandleGet.getType() == 0) {
            return uResourceBundleHandleGet.getString();
        }
        try {
            return uResourceBundleHandleGet.getType() == 8 ? uResourceBundleHandleGet.handleGetStringArray() : uResourceBundleHandleGet;
        } catch (UResourceTypeMismatchException unused) {
            return uResourceBundleHandleGet;
        }
    }

    private static void setRootType(String str, RootType rootType) {
        ROOT_CACHE.put(str, rootType);
    }

    @Deprecated
    public UResourceBundle findTopLevel(String str) {
        for (UResourceBundle parent = this; parent != null; parent = parent.getParent()) {
            UResourceBundle uResourceBundleHandleGet = parent.handleGet(str, (HashMap<String, String>) null, this);
            if (uResourceBundleHandleGet != null) {
                return uResourceBundleHandleGet;
            }
        }
        return null;
    }

    public UResourceBundle get(int i) {
        UResourceBundle uResourceBundleHandleGet = handleGet(i, (HashMap<String, String>) null, this);
        if (uResourceBundleHandleGet != null) {
            return uResourceBundleHandleGet;
        }
        UResourceBundle parent = getParent();
        if (parent != null) {
            parent = parent.get(i);
        }
        if (parent != null) {
            return parent;
        }
        throw new MissingResourceException(cq.l("Can't find resource for bundle ", getClass().getName(), ", key ", getKey()), getClass().getName(), getKey());
    }

    public abstract String getBaseName();

    public ByteBuffer getBinary() {
        throw new UResourceTypeMismatchException("");
    }

    public int getInt() {
        throw new UResourceTypeMismatchException("");
    }

    public int[] getIntVector() {
        throw new UResourceTypeMismatchException("");
    }

    public UResourceBundleIterator getIterator() {
        return new UResourceBundleIterator(this);
    }

    public String getKey() {
        return null;
    }

    @Override // java.util.ResourceBundle
    public Enumeration<String> getKeys() {
        return Collections.enumeration(keySet());
    }

    @Override // java.util.ResourceBundle
    public Locale getLocale() {
        return getULocale().toLocale();
    }

    public abstract String getLocaleID();

    public abstract UResourceBundle getParent();

    public int getSize() {
        return 1;
    }

    public String getString(int i) {
        ICUResourceBundle iCUResourceBundle = (ICUResourceBundle) get(i);
        if (iCUResourceBundle.getType() == 0) {
            return iCUResourceBundle.getString();
        }
        throw new UResourceTypeMismatchException("");
    }

    public String[] getStringArray() {
        throw new UResourceTypeMismatchException("");
    }

    public int getType() {
        return -1;
    }

    public int getUInt() {
        throw new UResourceTypeMismatchException("");
    }

    public abstract ULocale getULocale();

    public VersionInfo getVersion() {
        return null;
    }

    public UResourceBundle handleGet(int i, HashMap<String, String> map, UResourceBundle uResourceBundle) {
        return null;
    }

    public Enumeration<String> handleGetKeys() {
        return null;
    }

    @Override // java.util.ResourceBundle
    public Object handleGetObject(String str) {
        return handleGetObjectImpl(str, this);
    }

    public String[] handleGetStringArray() {
        return null;
    }

    @Override // java.util.ResourceBundle
    @Deprecated
    public Set<String> handleKeySet() {
        return Collections.EMPTY_SET;
    }

    @Deprecated
    public boolean isTopLevelResource() {
        return true;
    }

    @Override // java.util.ResourceBundle
    @Deprecated
    public Set<String> keySet() {
        ICUResourceBundle iCUResourceBundle;
        Set<String> topLevelKeySet;
        TreeSet treeSet;
        if (isTopLevelResource() && (this instanceof ICUResourceBundle)) {
            iCUResourceBundle = (ICUResourceBundle) this;
            topLevelKeySet = iCUResourceBundle.getTopLevelKeySet();
        } else {
            iCUResourceBundle = null;
            topLevelKeySet = null;
        }
        if (topLevelKeySet != null) {
            return topLevelKeySet;
        }
        if (!isTopLevelResource()) {
            return handleKeySet();
        }
        ResourceBundle resourceBundle = ((ResourceBundle) this).parent;
        if (resourceBundle == null) {
            treeSet = new TreeSet();
        } else if (resourceBundle instanceof UResourceBundle) {
            treeSet = new TreeSet(((UResourceBundle) ((ResourceBundle) this).parent).keySet());
        } else {
            treeSet = new TreeSet();
            Enumeration<String> keys = ((ResourceBundle) this).parent.getKeys();
            while (keys.hasMoreElements()) {
                treeSet.add(keys.nextElement());
            }
        }
        treeSet.addAll(handleKeySet());
        Set<String> setUnmodifiableSet = Collections.unmodifiableSet(treeSet);
        if (iCUResourceBundle != null) {
            iCUResourceBundle.setTopLevelKeySet(setUnmodifiableSet);
        }
        return setUnmodifiableSet;
    }

    public String toString() {
        return ky0.l("UResourceBundle{name=", getBaseBundleName(), ", locale=", String.valueOf(getLocale()), "}");
    }

    public UResourceBundle handleGet(String str, HashMap<String, String> map, UResourceBundle uResourceBundle) {
        return null;
    }

    public byte[] getBinary(byte[] bArr) {
        throw new UResourceTypeMismatchException("");
    }

    @Deprecated
    public UResourceBundle findTopLevel(int i) {
        for (UResourceBundle parent = this; parent != null; parent = parent.getParent()) {
            UResourceBundle uResourceBundleHandleGet = parent.handleGet(i, (HashMap<String, String>) null, this);
            if (uResourceBundleHandleGet != null) {
                return uResourceBundleHandleGet;
            }
        }
        return null;
    }

    public String getString() {
        throw new UResourceTypeMismatchException("");
    }

    public static UResourceBundle getBundleInstance(String str, String str2, ClassLoader classLoader) {
        return getBundleInstance(str, str2, classLoader, false);
    }

    public static UResourceBundle getBundleInstance(String str, String str2, ClassLoader classLoader, boolean z) {
        return instantiateBundle(str, str2, classLoader, z);
    }

    public static UResourceBundle getBundleInstance(ULocale uLocale) {
        if (uLocale == null) {
            uLocale = ULocale.getDefault();
        }
        return getBundleInstance(ICUData.ICU_BASE_NAME, uLocale.getBaseName(), ICUResourceBundle.ICU_DATA_CLASS_LOADER, false);
    }

    public static UResourceBundle getBundleInstance(String str) {
        if (str == null) {
            str = ICUData.ICU_BASE_NAME;
        }
        return getBundleInstance(str, ULocale.getDefault().getBaseName(), ICUResourceBundle.ICU_DATA_CLASS_LOADER, false);
    }

    public static UResourceBundle getBundleInstance(String str, String str2) {
        return getBundleInstance(str, str2, ICUResourceBundle.ICU_DATA_CLASS_LOADER, false);
    }

    public static UResourceBundle getBundleInstance(String str, ULocale uLocale) {
        if (str == null) {
            str = ICUData.ICU_BASE_NAME;
        }
        if (uLocale == null) {
            uLocale = ULocale.getDefault();
        }
        return getBundleInstance(str, uLocale.getBaseName(), ICUResourceBundle.ICU_DATA_CLASS_LOADER, false);
    }

    public static UResourceBundle getBundleInstance(String str, Locale locale, ClassLoader classLoader) {
        if (str == null) {
            str = ICUData.ICU_BASE_NAME;
        }
        return getBundleInstance(str, (locale == null ? ULocale.getDefault() : ULocale.forLocale(locale)).getBaseName(), classLoader, false);
    }

    public static UResourceBundle getBundleInstance(String str, ULocale uLocale, ClassLoader classLoader) {
        if (str == null) {
            str = ICUData.ICU_BASE_NAME;
        }
        if (uLocale == null) {
            uLocale = ULocale.getDefault();
        }
        return getBundleInstance(str, uLocale.getBaseName(), classLoader, false);
    }

    public UResourceBundle get(String str) {
        UResourceBundle uResourceBundleFindTopLevel = findTopLevel(str);
        if (uResourceBundleFindTopLevel != null) {
            return uResourceBundleFindTopLevel;
        }
        throw new MissingResourceException(cq.l("Can't find resource for bundle ", ICUResourceBundleReader.getFullName(getBaseName(), getLocaleID()), ", key ", str), getClass().getName(), str);
    }
}
