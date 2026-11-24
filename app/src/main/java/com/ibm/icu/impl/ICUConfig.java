package com.ibm.icu.impl;

import java.io.IOException;
import java.io.InputStream;
import java.security.AccessControlException;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.MissingResourceException;
import java.util.Properties;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class ICUConfig {
    private static final Properties CONFIG_PROPS;
    public static final String CONFIG_PROPS_FILE = "/com/ibm/icu/ICUConfig.properties";

    static {
        Properties properties = new Properties();
        CONFIG_PROPS = properties;
        try {
            InputStream stream = ICUData.getStream(CONFIG_PROPS_FILE);
            if (stream != null) {
                try {
                    properties.load(stream);
                } finally {
                    stream.close();
                }
            }
        } catch (IOException | MissingResourceException unused) {
        }
    }

    public static String get(final String str, String str2) {
        String property;
        if (System.getSecurityManager() != null) {
            try {
                property = (String) AccessController.doPrivileged(new PrivilegedAction<String>() { // from class: com.ibm.icu.impl.ICUConfig.1
                    @Override // java.security.PrivilegedAction
                    public String run() {
                        return System.getProperty(str);
                    }
                });
            } catch (AccessControlException unused) {
                property = null;
            }
        } else {
            property = System.getProperty(str);
        }
        return (property == null || property.equals("")) ? CONFIG_PROPS.getProperty(str, str2) : property;
    }

    public static String get(String str) {
        return get(str, null);
    }
}
