package com.ibm.icu.impl;

import java.security.AccessController;
import java.security.PrivilegedAction;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class ClassLoaderUtil {
    private static volatile ClassLoader BOOTSTRAP_CLASSLOADER;

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class BootstrapClassLoader extends ClassLoader {
        public BootstrapClassLoader() {
            super(Object.class.getClassLoader());
        }
    }

    private static ClassLoader getBootstrapClassLoader() {
        if (BOOTSTRAP_CLASSLOADER == null) {
            synchronized (ClassLoaderUtil.class) {
                try {
                    if (BOOTSTRAP_CLASSLOADER == null) {
                        BOOTSTRAP_CLASSLOADER = System.getSecurityManager() != null ? (ClassLoader) AccessController.doPrivileged(new PrivilegedAction<ClassLoader>() { // from class: com.ibm.icu.impl.ClassLoaderUtil.1
                            @Override // java.security.PrivilegedAction
                            /* JADX INFO: renamed from: run, reason: merged with bridge method [inline-methods] */
                            public ClassLoader run2() {
                                return new BootstrapClassLoader();
                            }
                        }) : new BootstrapClassLoader();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return BOOTSTRAP_CLASSLOADER;
    }

    public static ClassLoader getClassLoader() {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        if (contextClassLoader != null) {
            return contextClassLoader;
        }
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        return systemClassLoader == null ? getBootstrapClassLoader() : systemClassLoader;
    }

    public static ClassLoader getClassLoader(Class<?> cls) {
        ClassLoader classLoader = cls.getClassLoader();
        return classLoader == null ? getClassLoader() : classLoader;
    }
}
