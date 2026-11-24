package com.ibm.icu.impl;

import com.ibm.icu.util.UResourceBundle;
import com.ibm.icu.util.VersionInfo;
import java.util.MissingResourceException;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ICUDataVersion {
    private static final String U_ICU_DATA_KEY = "DataVersion";
    private static final String U_ICU_VERSION_BUNDLE = "icuver";

    public static VersionInfo getDataVersion() {
        try {
            return VersionInfo.getInstance(UResourceBundle.getBundleInstance(ICUData.ICU_BASE_NAME, U_ICU_VERSION_BUNDLE, ICUResourceBundle.ICU_DATA_CLASS_LOADER).get(U_ICU_DATA_KEY).getString());
        } catch (MissingResourceException unused) {
            return null;
        }
    }
}
