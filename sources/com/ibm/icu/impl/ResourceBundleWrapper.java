package com.ibm.icu.impl;

import com.ibm.icu.impl.locale.BaseLocale;
import com.ibm.icu.util.ULocale;
import com.ibm.icu.util.UResourceBundle;
import defpackage.cq;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.MissingResourceException;
import java.util.Objects;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ResourceBundleWrapper extends UResourceBundle {
    private static CacheBase<BundleCacheKey, ResourceBundleWrapper, Loader> BUNDLE_CACHE = new SoftCache<BundleCacheKey, ResourceBundleWrapper, Loader>() { // from class: com.ibm.icu.impl.ResourceBundleWrapper.1
        @Override // com.ibm.icu.impl.CacheBase
        public ResourceBundleWrapper createInstance(BundleCacheKey bundleCacheKey, Loader loader) {
            return loader.load();
        }
    };
    private static final boolean DEBUG = ICUDebug.enabled("resourceBundleWrapper");
    private String baseName;
    private ResourceBundle bundle;
    private volatile List<String> keys;
    private String localeID;

    private ResourceBundleWrapper(ResourceBundle resourceBundle) {
        this.bundle = null;
        this.localeID = null;
        this.baseName = null;
        this.keys = null;
        this.bundle = resourceBundle;
    }

    public static ResourceBundleWrapper getBundleInstance(String str, String str2, ClassLoader classLoader, boolean z) {
        if (classLoader == null) {
            classLoader = ClassLoaderUtil.getClassLoader();
        }
        ResourceBundleWrapper resourceBundleWrapperInstantiateBundle = z ? instantiateBundle(str, str2, null, classLoader, z) : instantiateBundle(str, str2, ULocale.getDefault().getBaseName(), classLoader, z);
        if (resourceBundleWrapperInstantiateBundle == null) {
            throw new MissingResourceException(cq.l("Could not find the bundle ", str, str.indexOf(47) >= 0 ? "/" : BaseLocale.SEP, str2), "", "");
        }
        return resourceBundleWrapperInstantiateBundle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initKeysVector() {
        if (this.keys != null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (ResourceBundleWrapper resourceBundleWrapper = this; resourceBundleWrapper != null; resourceBundleWrapper = (ResourceBundleWrapper) resourceBundleWrapper.getParent()) {
            Enumeration<String> keys = resourceBundleWrapper.bundle.getKeys();
            while (keys.hasMoreElements()) {
                String strNextElement = keys.nextElement();
                if (!arrayList.contains(strNextElement)) {
                    arrayList.add(strNextElement);
                }
            }
        }
        this.keys = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ResourceBundleWrapper instantiateBundle(final String str, final String str2, final String str3, final ClassLoader classLoader, final boolean z) {
        final String strK = str2.isEmpty() ? str : cq.k(str, BaseLocale.SEP, str2);
        return BUNDLE_CACHE.getInstance(new BundleCacheKey(z ? strK : cq.k(strK, "#", str3), classLoader, 0), new Loader() { // from class: com.ibm.icu.impl.ResourceBundleWrapper.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Code duplicated, block: B:30:0x00b0 A[Catch: Exception -> 0x00de, TRY_LEAVE, TryCatch #2 {Exception -> 0x00de, blocks: (B:28:0x0088, B:30:0x00b0, B:42:0x00dd, B:47:0x00e5, B:49:0x00e9, B:51:0x00f1, B:53:0x00f9, B:55:0x0103, B:58:0x0114), top: B:80:0x0088 }] */
            /* JADX WARN: Code duplicated, block: B:47:0x00e5 A[Catch: Exception -> 0x00de, TRY_ENTER, TryCatch #2 {Exception -> 0x00de, blocks: (B:28:0x0088, B:30:0x00b0, B:42:0x00dd, B:47:0x00e5, B:49:0x00e9, B:51:0x00f1, B:53:0x00f9, B:55:0x0103, B:58:0x0114), top: B:80:0x0088 }] */
            /* JADX WARN: Code duplicated, block: B:57:0x0112 A[ADDED_TO_REGION] */
            /* JADX WARN: Code duplicated, block: B:61:0x0119  */
            /* JADX WARN: Code duplicated, block: B:70:0x0134  */
            /* JADX WARN: Code duplicated, block: B:71:0x0138  */
            /* JADX WARN: Code duplicated, block: B:73:0x013e  */
            /* JADX WARN: Code duplicated, block: B:80:0x0088 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Code duplicated, block: B:89:0x0057 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Code duplicated, block: B:93:0x00c1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Instruction removed from duplicated block: B:73:0x013e, please report this as an issue */
            @Override // com.ibm.icu.impl.ResourceBundleWrapper.Loader
            public ResourceBundleWrapper load() throws Throwable {
                ResourceBundleWrapper resourceBundleWrapperInstantiateBundle;
                boolean z2;
                ResourceBundleWrapper resourceBundleWrapperInstantiateBundle2;
                InputStream inputStream;
                BufferedInputStream bufferedInputStream;
                ResourceBundleWrapper resourceBundleWrapper;
                int iLastIndexOf = str2.lastIndexOf(95);
                String str4 = str2;
                boolean z3 = true;
                ResourceBundleWrapper resourceBundleWrapper2 = null;
                int i = 0;
                try {
                    if (iLastIndexOf == -1) {
                        if (str4.isEmpty()) {
                            resourceBundleWrapperInstantiateBundle = null;
                        } else {
                            resourceBundleWrapperInstantiateBundle = ResourceBundleWrapper.instantiateBundle(str, "", str3, classLoader, z);
                            z2 = true;
                        }
                        resourceBundleWrapperInstantiateBundle2 = new ResourceBundleWrapper((ResourceBundle) classLoader.loadClass(strK).asSubclass(ResourceBundle.class).newInstance(), i);
                        if (resourceBundleWrapperInstantiateBundle != null) {
                            try {
                                resourceBundleWrapperInstantiateBundle2.setParent(resourceBundleWrapperInstantiateBundle);
                            } catch (ClassNotFoundException | NoClassDefFoundError unused) {
                                resourceBundleWrapper2 = resourceBundleWrapperInstantiateBundle2;
                                resourceBundleWrapperInstantiateBundle2 = resourceBundleWrapper2;
                                if (z3) {
                                    try {
                                        final String str5 = strK.replace('.', '/') + ".properties";
                                        inputStream = (InputStream) AccessController.doPrivileged(new PrivilegedAction<InputStream>() { // from class: com.ibm.icu.impl.ResourceBundleWrapper.2.1
                                            /* JADX WARN: Can't rename method to resolve collision */
                                            @Override // java.security.PrivilegedAction
                                            public InputStream run() {
                                                return classLoader.getResourceAsStream(str5);
                                            }
                                        });
                                        if (inputStream != null) {
                                            bufferedInputStream = new BufferedInputStream(inputStream);
                                            try {
                                                resourceBundleWrapper = new ResourceBundleWrapper(new PropertyResourceBundle(bufferedInputStream), i);
                                                if (resourceBundleWrapperInstantiateBundle != null) {
                                                    try {
                                                        resourceBundleWrapper.setParent(resourceBundleWrapperInstantiateBundle);
                                                    } catch (Exception unused2) {
                                                        resourceBundleWrapperInstantiateBundle2 = resourceBundleWrapper;
                                                        try {
                                                            bufferedInputStream.close();
                                                        } catch (Exception unused3) {
                                                        }
                                                    } catch (Throwable th) {
                                                        th = th;
                                                        try {
                                                            bufferedInputStream.close();
                                                        } catch (Exception unused4) {
                                                        }
                                                        throw th;
                                                    }
                                                }
                                                resourceBundleWrapper.baseName = str;
                                                resourceBundleWrapper.localeID = str2;
                                                try {
                                                    bufferedInputStream.close();
                                                } catch (Exception unused5) {
                                                }
                                                resourceBundleWrapperInstantiateBundle2 = resourceBundleWrapper;
                                            } catch (Exception unused6) {
                                            } catch (Throwable th2) {
                                                th = th2;
                                            }
                                        }
                                        if (resourceBundleWrapperInstantiateBundle2 == null) {
                                            String str6 = str;
                                            String str7 = str3;
                                            resourceBundleWrapperInstantiateBundle2 = ResourceBundleWrapper.instantiateBundle(str6, str7, str7, classLoader, z);
                                        }
                                        if (resourceBundleWrapperInstantiateBundle2 == null) {
                                            resourceBundleWrapperInstantiateBundle = resourceBundleWrapperInstantiateBundle2;
                                        } else {
                                            resourceBundleWrapperInstantiateBundle = resourceBundleWrapperInstantiateBundle2;
                                        }
                                        resourceBundleWrapperInstantiateBundle2 = resourceBundleWrapperInstantiateBundle;
                                    } catch (Exception e) {
                                        if (ResourceBundleWrapper.DEBUG) {
                                            System.out.println("failure");
                                        }
                                        if (ResourceBundleWrapper.DEBUG) {
                                            System.out.println(e);
                                        }
                                    }
                                }
                                if (resourceBundleWrapperInstantiateBundle2 != null) {
                                    resourceBundleWrapperInstantiateBundle2.initKeysVector();
                                } else if (ResourceBundleWrapper.DEBUG) {
                                    System.out.println("Returning null for " + str + BaseLocale.SEP + str2);
                                }
                                return resourceBundleWrapperInstantiateBundle2;
                            } catch (Exception e2) {
                                e = e2;
                                resourceBundleWrapper2 = resourceBundleWrapperInstantiateBundle2;
                                if (ResourceBundleWrapper.DEBUG) {
                                    System.out.println("failure");
                                }
                                if (ResourceBundleWrapper.DEBUG) {
                                    System.out.println(e);
                                }
                                resourceBundleWrapperInstantiateBundle2 = resourceBundleWrapper2;
                            }
                        }
                        resourceBundleWrapperInstantiateBundle2.baseName = str;
                        resourceBundleWrapperInstantiateBundle2.localeID = str2;
                        z3 = false;
                        if (z3) {
                            final String str8 = strK.replace('.', '/') + ".properties";
                            inputStream = (InputStream) AccessController.doPrivileged(new PrivilegedAction<InputStream>() { // from class: com.ibm.icu.impl.ResourceBundleWrapper.2.1
                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // java.security.PrivilegedAction
                                public InputStream run() {
                                    return classLoader.getResourceAsStream(str8);
                                }
                            });
                            if (inputStream != null) {
                                bufferedInputStream = new BufferedInputStream(inputStream);
                                resourceBundleWrapper = new ResourceBundleWrapper(new PropertyResourceBundle(bufferedInputStream), i);
                                if (resourceBundleWrapperInstantiateBundle != null) {
                                    resourceBundleWrapper.setParent(resourceBundleWrapperInstantiateBundle);
                                }
                                resourceBundleWrapper.baseName = str;
                                resourceBundleWrapper.localeID = str2;
                                bufferedInputStream.close();
                                resourceBundleWrapperInstantiateBundle2 = resourceBundleWrapper;
                            }
                            if (resourceBundleWrapperInstantiateBundle2 == null && !z && !str2.isEmpty() && str2.indexOf(95) < 0 && !ResourceBundleWrapper.localeIDStartsWithLangSubtag(str3, str2)) {
                                String str9 = str;
                                String str10 = str3;
                                resourceBundleWrapperInstantiateBundle2 = ResourceBundleWrapper.instantiateBundle(str9, str10, str10, classLoader, z);
                            }
                            if (resourceBundleWrapperInstantiateBundle2 == null || (z2 && z)) {
                                resourceBundleWrapperInstantiateBundle = resourceBundleWrapperInstantiateBundle2;
                            }
                            resourceBundleWrapperInstantiateBundle2 = resourceBundleWrapperInstantiateBundle;
                        }
                        if (resourceBundleWrapperInstantiateBundle2 != null) {
                            resourceBundleWrapperInstantiateBundle2.initKeysVector();
                        } else if (ResourceBundleWrapper.DEBUG) {
                            System.out.println("Returning null for " + str + BaseLocale.SEP + str2);
                        }
                        return resourceBundleWrapperInstantiateBundle2;
                    }
                    resourceBundleWrapperInstantiateBundle = ResourceBundleWrapper.instantiateBundle(str, str4.substring(0, iLastIndexOf), str3, classLoader, z);
                    resourceBundleWrapperInstantiateBundle2 = new ResourceBundleWrapper((ResourceBundle) classLoader.loadClass(strK).asSubclass(ResourceBundle.class).newInstance(), i);
                    if (resourceBundleWrapperInstantiateBundle != null) {
                        resourceBundleWrapperInstantiateBundle2.setParent(resourceBundleWrapperInstantiateBundle);
                    }
                    resourceBundleWrapperInstantiateBundle2.baseName = str;
                    resourceBundleWrapperInstantiateBundle2.localeID = str2;
                } catch (ClassNotFoundException | NoClassDefFoundError unused7) {
                } catch (Exception e3) {
                    e = e3;
                }
                z2 = false;
                z3 = false;
                if (z3) {
                    final String str11 = strK.replace('.', '/') + ".properties";
                    inputStream = (InputStream) AccessController.doPrivileged(new PrivilegedAction<InputStream>() { // from class: com.ibm.icu.impl.ResourceBundleWrapper.2.1
                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // java.security.PrivilegedAction
                        public InputStream run() {
                            return classLoader.getResourceAsStream(str11);
                        }
                    });
                    if (inputStream != null) {
                        bufferedInputStream = new BufferedInputStream(inputStream);
                        resourceBundleWrapper = new ResourceBundleWrapper(new PropertyResourceBundle(bufferedInputStream), i);
                        if (resourceBundleWrapperInstantiateBundle != null) {
                            resourceBundleWrapper.setParent(resourceBundleWrapperInstantiateBundle);
                        }
                        resourceBundleWrapper.baseName = str;
                        resourceBundleWrapper.localeID = str2;
                        bufferedInputStream.close();
                        resourceBundleWrapperInstantiateBundle2 = resourceBundleWrapper;
                    }
                    if (resourceBundleWrapperInstantiateBundle2 == null) {
                        String str12 = str;
                        String str13 = str3;
                        resourceBundleWrapperInstantiateBundle2 = ResourceBundleWrapper.instantiateBundle(str12, str13, str13, classLoader, z);
                    }
                    if (resourceBundleWrapperInstantiateBundle2 == null) {
                        resourceBundleWrapperInstantiateBundle = resourceBundleWrapperInstantiateBundle2;
                    } else {
                        resourceBundleWrapperInstantiateBundle = resourceBundleWrapperInstantiateBundle2;
                    }
                    resourceBundleWrapperInstantiateBundle2 = resourceBundleWrapperInstantiateBundle;
                }
                if (resourceBundleWrapperInstantiateBundle2 != null) {
                    resourceBundleWrapperInstantiateBundle2.initKeysVector();
                } else if (ResourceBundleWrapper.DEBUG) {
                    System.out.println("Returning null for " + str + BaseLocale.SEP + str2);
                }
                return resourceBundleWrapperInstantiateBundle2;
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

    @Override // com.ibm.icu.util.UResourceBundle
    public String getBaseName() {
        return this.bundle.getClass().getName().replace('.', '/');
    }

    @Override // com.ibm.icu.util.UResourceBundle, java.util.ResourceBundle
    public Enumeration<String> getKeys() {
        return Collections.enumeration(this.keys);
    }

    @Override // com.ibm.icu.util.UResourceBundle
    public String getLocaleID() {
        return this.localeID;
    }

    @Override // com.ibm.icu.util.UResourceBundle
    public UResourceBundle getParent() {
        return (UResourceBundle) ((ResourceBundle) this).parent;
    }

    @Override // com.ibm.icu.util.UResourceBundle
    public ULocale getULocale() {
        return new ULocale(this.localeID);
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0015  */
    /* JADX WARN: Code duplicated, block: B:9:0x0014 A[RETURN] */
    @Override // com.ibm.icu.util.UResourceBundle, java.util.ResourceBundle
    public Object handleGetObject(String str) {
        Object object;
        for (ResourceBundleWrapper resourceBundleWrapper = this; resourceBundleWrapper != null; resourceBundleWrapper = (ResourceBundleWrapper) resourceBundleWrapper.getParent()) {
            try {
                object = resourceBundleWrapper.bundle.getObject(str);
                if (object != null) {
                    return object;
                }
                throw new MissingResourceException(cq.l("Can't find resource for bundle ", this.baseName, ", key ", str), ResourceBundleWrapper.class.getName(), str);
            } catch (MissingResourceException unused) {
            }
        }
        object = null;
        if (object != null) {
            return object;
        }
        throw new MissingResourceException(cq.l("Can't find resource for bundle ", this.baseName, ", key ", str), ResourceBundleWrapper.class.getName(), str);
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static abstract class Loader {
        public /* synthetic */ Loader(int i) {
            this();
        }

        public abstract ResourceBundleWrapper load();

        private Loader() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class BundleCacheKey {
        public final String baseName;
        public final ClassLoader classLoader;

        private BundleCacheKey(String str, ClassLoader classLoader) {
            this.baseName = str;
            this.classLoader = classLoader;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && getClass() == obj.getClass()) {
                BundleCacheKey bundleCacheKey = (BundleCacheKey) obj;
                if (Objects.equals(this.baseName, bundleCacheKey.baseName) && Objects.equals(this.classLoader, bundleCacheKey.classLoader)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return Objects.hash(this.baseName, this.classLoader);
        }

        public /* synthetic */ BundleCacheKey(String str, ClassLoader classLoader, int i) {
            this(str, classLoader);
        }
    }

    public /* synthetic */ ResourceBundleWrapper(ResourceBundle resourceBundle, int i) {
        this(resourceBundle);
    }
}
