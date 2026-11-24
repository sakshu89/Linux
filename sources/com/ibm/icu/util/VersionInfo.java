package com.ibm.icu.util;

import com.ibm.icu.impl.ICUData;
import com.ibm.icu.text.DateFormat;
import defpackage.cq;
import defpackage.ky0;
import defpackage.og;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class VersionInfo implements Comparable<VersionInfo> {

    @Deprecated
    public static final VersionInfo ICU_DATA_VERSION;

    @Deprecated
    public static final String ICU_DATA_VERSION_PATH = "79b";
    public static final VersionInfo ICU_VERSION;
    private static final String INVALID_VERSION_NUMBER_ = "Invalid version number: Version number may be negative or greater than 255";
    private static final int LAST_BYTE_MASK_ = 255;
    private static volatile String TZDATA_VERSION;
    public static final VersionInfo UCOL_BUILDER_VERSION;
    public static final VersionInfo UCOL_RUNTIME_VERSION;

    @Deprecated
    public static final VersionInfo UCOL_TAILORINGS_VERSION;
    public static final VersionInfo UNICODE_18_0;
    private static final VersionInfo UNICODE_VERSION;
    private int m_version_;
    private static final ConcurrentHashMap<Integer, VersionInfo> MAP_ = new ConcurrentHashMap<>();
    public static final VersionInfo UNICODE_1_0 = getInstance(1, 0, 0, 0);
    public static final VersionInfo UNICODE_1_0_1 = getInstance(1, 0, 1, 0);
    public static final VersionInfo UNICODE_1_1_0 = getInstance(1, 1, 0, 0);
    public static final VersionInfo UNICODE_1_1_5 = getInstance(1, 1, 5, 0);
    public static final VersionInfo UNICODE_2_0 = getInstance(2, 0, 0, 0);
    public static final VersionInfo UNICODE_2_1_2 = getInstance(2, 1, 2, 0);
    public static final VersionInfo UNICODE_2_1_5 = getInstance(2, 1, 5, 0);
    public static final VersionInfo UNICODE_2_1_8 = getInstance(2, 1, 8, 0);
    public static final VersionInfo UNICODE_2_1_9 = getInstance(2, 1, 9, 0);
    public static final VersionInfo UNICODE_3_0 = getInstance(3, 0, 0, 0);
    public static final VersionInfo UNICODE_3_0_1 = getInstance(3, 0, 1, 0);
    public static final VersionInfo UNICODE_3_1_0 = getInstance(3, 1, 0, 0);
    public static final VersionInfo UNICODE_3_1_1 = getInstance(3, 1, 1, 0);
    public static final VersionInfo UNICODE_3_2 = getInstance(3, 2, 0, 0);
    public static final VersionInfo UNICODE_4_0 = getInstance(4, 0, 0, 0);
    public static final VersionInfo UNICODE_4_0_1 = getInstance(4, 0, 1, 0);
    public static final VersionInfo UNICODE_4_1 = getInstance(4, 1, 0, 0);
    public static final VersionInfo UNICODE_5_0 = getInstance(5, 0, 0, 0);
    public static final VersionInfo UNICODE_5_1 = getInstance(5, 1, 0, 0);
    public static final VersionInfo UNICODE_5_2 = getInstance(5, 2, 0, 0);
    public static final VersionInfo UNICODE_6_0 = getInstance(6, 0, 0, 0);
    public static final VersionInfo UNICODE_6_1 = getInstance(6, 1, 0, 0);
    public static final VersionInfo UNICODE_6_2 = getInstance(6, 2, 0, 0);
    public static final VersionInfo UNICODE_6_3 = getInstance(6, 3, 0, 0);
    public static final VersionInfo UNICODE_7_0 = getInstance(7, 0, 0, 0);
    public static final VersionInfo UNICODE_8_0 = getInstance(8, 0, 0, 0);
    public static final VersionInfo UNICODE_9_0 = getInstance(9, 0, 0, 0);
    public static final VersionInfo UNICODE_10_0 = getInstance(10, 0, 0, 0);
    public static final VersionInfo UNICODE_11_0 = getInstance(11, 0, 0, 0);
    public static final VersionInfo UNICODE_12_0 = getInstance(12, 0, 0, 0);
    public static final VersionInfo UNICODE_12_1 = getInstance(12, 1, 0, 0);
    public static final VersionInfo UNICODE_13_0 = getInstance(13, 0, 0, 0);
    public static final VersionInfo UNICODE_14_0 = getInstance(14, 0, 0, 0);
    public static final VersionInfo UNICODE_15_0 = getInstance(15, 0, 0, 0);
    public static final VersionInfo UNICODE_15_1 = getInstance(15, 1, 0, 0);
    public static final VersionInfo UNICODE_16_0 = getInstance(16, 0, 0, 0);
    public static final VersionInfo UNICODE_17_0 = getInstance(17, 0, 0, 0);

    static {
        VersionInfo versionInfo = getInstance(18, 0, 0, 0);
        UNICODE_18_0 = versionInfo;
        VersionInfo versionInfo2 = getInstance(79, 1, 0, 0);
        ICU_VERSION = versionInfo2;
        ICU_DATA_VERSION = versionInfo2;
        UNICODE_VERSION = versionInfo;
        UCOL_RUNTIME_VERSION = getInstance(9);
        UCOL_BUILDER_VERSION = getInstance(9);
        UCOL_TAILORINGS_VERSION = getInstance(1);
        TZDATA_VERSION = null;
    }

    private VersionInfo(int i) {
        this.m_version_ = i;
    }

    public static VersionInfo getInstance(String str) {
        int length = str.length();
        int[] iArr = new int[4];
        iArr[0] = 0;
        iArr[1] = 0;
        iArr[2] = 0;
        iArr[3] = 0;
        int i = 0;
        int i2 = 0;
        while (i < 4 && i2 < length) {
            char cCharAt = str.charAt(i2);
            if (cCharAt == '.') {
                i++;
            } else {
                if (cCharAt < '0' || cCharAt > '9') {
                    og.i(INVALID_VERSION_NUMBER_);
                    return null;
                }
                int i3 = iArr[i] * 10;
                iArr[i] = i3;
                iArr[i] = i3 + ((char) (cCharAt - '0'));
            }
            i2++;
        }
        if (i2 != length) {
            og.i(cq.v("Invalid version number: String '", str, "' exceeds version format"));
            return null;
        }
        for (int i4 = 0; i4 < 4; i4++) {
            int i5 = iArr[i4];
            if (i5 < 0 || i5 > 255) {
                og.i(INVALID_VERSION_NUMBER_);
                return null;
            }
        }
        return getInstance(iArr[0], iArr[1], iArr[2], iArr[3]);
    }

    private static int getInt(int i, int i2, int i3, int i4) {
        return (i << 24) | (i2 << 16) | (i3 << 8) | i4;
    }

    public static String getTZDataVersion() {
        if (TZDATA_VERSION == null) {
            synchronized (VersionInfo.class) {
                try {
                    if (TZDATA_VERSION == null) {
                        TZDATA_VERSION = UResourceBundle.getBundleInstance(ICUData.ICU_BASE_NAME, "zoneinfo64").getString("TZVersion");
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return TZDATA_VERSION;
    }

    public static void main(String[] strArr) {
        String versionString;
        VersionInfo versionInfo = ICU_VERSION;
        if (versionInfo.getMajor() <= 4) {
            if (versionInfo.getMinor() % 2 != 0) {
                int major = versionInfo.getMajor();
                int minor = versionInfo.getMinor();
                int i = minor + 1;
                if (i >= 10) {
                    i = minor - 9;
                    major++;
                }
                versionString = major + "." + i + DateFormat.NUM_MONTH + versionInfo.getMilli();
            } else {
                versionString = versionInfo.getVersionString(2, 2);
            }
        } else if (versionInfo.getMinor() == 0) {
            versionString = versionInfo.getMajor() + DateFormat.NUM_MONTH + versionInfo.getMilli();
        } else {
            versionString = versionInfo.getVersionString(2, 2);
        }
        ky0.y("International Components for Unicode for Java ", versionString, System.out);
        System.out.println("");
        ky0.y("Implementation Version: ", versionInfo.getVersionString(2, 4), System.out);
        ky0.y("Unicode Data Version:   ", UNICODE_VERSION.getVersionString(2, 4), System.out);
        ky0.y("CLDR Data Version:      ", LocaleData.getCLDRVersion().getVersionString(2, 4), System.out);
        ky0.y("Time Zone Data Version: ", getTZDataVersion(), System.out);
    }

    @Override // java.lang.Comparable
    public int compareTo(VersionInfo versionInfo) {
        int i = this.m_version_;
        int i2 = versionInfo.m_version_;
        int i3 = (i >>> 1) - (i2 >>> 1);
        return i3 != 0 ? i3 : (i & 1) - (i2 & 1);
    }

    public boolean equals(Object obj) {
        return obj == this;
    }

    public int getMajor() {
        return (this.m_version_ >> 24) & 255;
    }

    public int getMicro() {
        return this.m_version_ & 255;
    }

    public int getMilli() {
        return (this.m_version_ >> 8) & 255;
    }

    public int getMinor() {
        return (this.m_version_ >> 16) & 255;
    }

    @Deprecated
    public String getVersionString(int i, int i2) {
        if (i < 1 || i2 < 1 || i > 4 || i2 > 4 || i > i2) {
            og.i("Invalid min/maxDigits range");
            return null;
        }
        int[] iArr = {getMajor(), getMinor(), getMilli(), getMicro()};
        while (i2 > i && iArr[i2 - 1] == 0) {
            i2--;
        }
        StringBuilder sb = new StringBuilder(7);
        sb.append(iArr[0]);
        for (int i3 = 1; i3 < i2; i3++) {
            sb.append(".");
            sb.append(iArr[i3]);
        }
        return sb.toString();
    }

    public int hashCode() {
        return this.m_version_;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(7);
        sb.append(getMajor());
        sb.append('.');
        sb.append(getMinor());
        sb.append('.');
        sb.append(getMilli());
        sb.append('.');
        sb.append(getMicro());
        return sb.toString();
    }

    public static VersionInfo getInstance(int i, int i2, int i3, int i4) {
        VersionInfo versionInfoPutIfAbsent;
        if (i >= 0 && i <= 255 && i2 >= 0 && i2 <= 255 && i3 >= 0 && i3 <= 255 && i4 >= 0 && i4 <= 255) {
            int i5 = getInt(i, i2, i3, i4);
            Integer numValueOf = Integer.valueOf(i5);
            ConcurrentHashMap<Integer, VersionInfo> concurrentHashMap = MAP_;
            VersionInfo versionInfo = concurrentHashMap.get(numValueOf);
            return (versionInfo != null || (versionInfoPutIfAbsent = concurrentHashMap.putIfAbsent(numValueOf, (versionInfo = new VersionInfo(i5)))) == null) ? versionInfo : versionInfoPutIfAbsent;
        }
        og.i(INVALID_VERSION_NUMBER_);
        return null;
    }

    public static VersionInfo getInstance(int i, int i2, int i3) {
        return getInstance(i, i2, i3, 0);
    }

    public static VersionInfo getInstance(int i, int i2) {
        return getInstance(i, i2, 0, 0);
    }

    public static VersionInfo getInstance(int i) {
        return getInstance(i, 0, 0, 0);
    }
}
