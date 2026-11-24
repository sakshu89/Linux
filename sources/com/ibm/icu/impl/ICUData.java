package com.ibm.icu.impl;

import defpackage.cq;
import java.io.InputStream;
import java.net.URL;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.MissingResourceException;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ICUData {
    public static final String ICU_BASE_NAME = "com/ibm/icu/impl/data/icudata";
    public static final String ICU_BRKITR_BASE_NAME = "com/ibm/icu/impl/data/icudata/brkitr";
    public static final String ICU_BRKITR_NAME = "brkitr";
    public static final String ICU_BUNDLE = "data/icudata";
    public static final String ICU_COLLATION_BASE_NAME = "com/ibm/icu/impl/data/icudata/coll";
    public static final String ICU_CURR_BASE_NAME = "com/ibm/icu/impl/data/icudata/curr";
    static final String ICU_DATA_PATH = "com/ibm/icu/impl/";
    public static final String ICU_LANG_BASE_NAME = "com/ibm/icu/impl/data/icudata/lang";
    public static final String ICU_RBNF_BASE_NAME = "com/ibm/icu/impl/data/icudata/rbnf";
    public static final String ICU_REGION_BASE_NAME = "com/ibm/icu/impl/data/icudata/region";
    public static final String ICU_TRANSLIT_BASE_NAME = "com/ibm/icu/impl/data/icudata/translit";
    public static final String ICU_UNIT_BASE_NAME = "com/ibm/icu/impl/data/icudata/unit";
    public static final String ICU_ZONE_BASE_NAME = "com/ibm/icu/impl/data/icudata/zone";
    static final String PACKAGE_NAME = "icudt79b";
    private static final boolean logBinaryDataFromInputStream = false;
    private static final Logger logger = null;
    private static final Logger tracingLogger;

    static {
        tracingLogger = ICUDebug.enabled("dataTracing") ? Logger.getLogger(ICUData.class.getName().concat(".tracing")) : null;
    }

    public static boolean exists(final String str) {
        return (System.getSecurityManager() != null ? (URL) AccessController.doPrivileged(new PrivilegedAction<URL>() { // from class: com.ibm.icu.impl.ICUData.1
            @Override // java.security.PrivilegedAction
            public URL run() {
                return ICUData.class.getResource(str);
            }
        }) : ICUData.class.getResource(str)) != null;
    }

    public static InputStream getRequiredStream(String str) {
        return getStream((Class<?>) ICUData.class, str, true);
    }

    public static InputStream getStream(final ClassLoader classLoader, final String str, boolean z) {
        Logger logger2 = tracingLogger;
        if (logger2 != null) {
            logger2.info("Using resource file " + str + (z ? " (required)" : " (optional)"));
        }
        InputStream resourceAsStream = System.getSecurityManager() != null ? (InputStream) AccessController.doPrivileged(new PrivilegedAction<InputStream>() { // from class: com.ibm.icu.impl.ICUData.3
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.security.PrivilegedAction
            public InputStream run() {
                return classLoader.getResourceAsStream(str);
            }
        }) : classLoader.getResourceAsStream(str);
        if (resourceAsStream == null && z) {
            throw new MissingResourceException("could not locate data", classLoader.toString(), str);
        }
        checkStreamForBinaryData(resourceAsStream, str);
        return resourceAsStream;
    }

    public static InputStream getRequiredStream(ClassLoader classLoader, String str) {
        return getStream(classLoader, str, true);
    }

    public static InputStream getRequiredStream(Class<?> cls, String str) {
        return getStream(cls, str, true);
    }

    private static void checkStreamForBinaryData(InputStream inputStream, String str) {
    }

    private static InputStream getStream(final Class<?> cls, final String str, boolean z) {
        InputStream resourceAsStream;
        if (System.getSecurityManager() != null) {
            resourceAsStream = (InputStream) AccessController.doPrivileged(new PrivilegedAction<InputStream>() { // from class: com.ibm.icu.impl.ICUData.2
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.security.PrivilegedAction
                public InputStream run() {
                    return cls.getResourceAsStream(str);
                }
            });
        } else {
            resourceAsStream = cls.getResourceAsStream(str);
        }
        if (resourceAsStream == null && z) {
            throw new MissingResourceException(cq.j("could not locate data ", str), cls.getPackage().getName(), str);
        }
        checkStreamForBinaryData(resourceAsStream, str);
        return resourceAsStream;
    }

    public static InputStream getStream(ClassLoader classLoader, String str) {
        return getStream(classLoader, str, false);
    }

    public static InputStream getStream(String str) {
        return getStream((Class<?>) ICUData.class, str, false);
    }

    public static InputStream getStream(Class<?> cls, String str) {
        return getStream(cls, str, false);
    }
}
