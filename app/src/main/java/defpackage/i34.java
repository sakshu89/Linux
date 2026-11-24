package defpackage;

import android.content.Intent;
import android.os.Build;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class i34 {
    public static final StackTraceElement[] a = new StackTraceElement[0];

    public static ni2 a(String str, String str2, String str3, String str4) {
        return Build.VERSION.SDK_INT >= 29 ? new ni2(new Intent(str), str2, true) : b(str3, str4);
    }

    public static ni2 b(String str, String str2) {
        return new ni2(new Intent(str), str2, false);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static ni2 c(String str, String str2) {
        switch (str.hashCode()) {
            case -1884274053:
                if (str.equals("storage")) {
                    return b("android.settings.INTERNAL_STORAGE_SETTINGS", "storage settings");
                }
                break;
            case -1314247385:
                if (str.equals("mobile_data")) {
                    return a("android.settings.panel.action.INTERNET_CONNECTIVITY", "the internet panel", "android.settings.DATA_ROAMING_SETTINGS", "mobile network settings");
                }
                break;
            case -677011630:
                if (str.equals("airplane")) {
                    return b("android.settings.AIRPLANE_MODE_SETTINGS", "airplane mode settings");
                }
                break;
            case -331239923:
                if (str.equals("battery")) {
                    return b("android.settings.BATTERY_SAVER_SETTINGS", "battery saver settings");
                }
                break;
            case -248858434:
                if (str.equals("date_time")) {
                    return b("android.settings.DATE_SETTINGS", "date and time settings");
                }
                break;
            case -213139122:
                if (str.equals("accessibility")) {
                    return b("android.settings.ACCESSIBILITY_SETTINGS", "accessibility settings");
                }
                break;
            case -80681014:
                if (str.equals("developer")) {
                    return b("android.settings.APPLICATION_DEVELOPMENT_SETTINGS", "developer options");
                }
                break;
            case 108971:
                if (str.equals("nfc")) {
                    return a("android.settings.panel.action.NFC", "the NFC panel", "android.settings.NFC_SETTINGS", "NFC settings");
                }
                break;
            case 3000946:
                if (str.equals("apps")) {
                    return b("android.settings.MANAGE_APPLICATIONS_SETTINGS", "the app list");
                }
                break;
            case 3649301:
                if (str.equals("wifi")) {
                    return a("android.settings.panel.action.WIFI", "the Wi-Fi panel", "android.settings.WIFI_SETTINGS", "Wi-Fi settings");
                }
                break;
            case 109627663:
                if (str.equals("sound")) {
                    return a("android.settings.panel.action.VOLUME", "the volume panel", "android.settings.SOUND_SETTINGS", "sound settings");
                }
                break;
            case 949122880:
                if (str.equals("security")) {
                    return b("android.settings.SECURITY_SETTINGS", "security settings");
                }
                break;
            case 1099603663:
                if (str.equals("hotspot")) {
                    return b("android.settings.WIRELESS_SETTINGS", "network settings, where the hotspot switch lives");
                }
                break;
            case 1272354024:
                if (str.equals("notifications")) {
                    if (Build.VERSION.SDK_INT >= 34) {
                        return b("android.settings.ALL_APPS_NOTIFICATION_SETTINGS", "notification settings");
                    }
                    Intent intentPutExtra = new Intent("android.settings.APP_NOTIFICATION_SETTINGS").putExtra("android.provider.extra.APP_PACKAGE", str2);
                    intentPutExtra.getClass();
                    return new ni2(intentPutExtra, "SONIC's own notification settings", false);
                }
                break;
            case 1671764162:
                if (str.equals("display")) {
                    return b("android.settings.DISPLAY_SETTINGS", "display settings");
                }
                break;
            case 1901043637:
                if (str.equals("location")) {
                    return b("android.settings.LOCATION_SOURCE_SETTINGS", "location settings");
                }
                break;
            case 1968882350:
                if (str.equals("bluetooth")) {
                    return b("android.settings.BLUETOOTH_SETTINGS", "Bluetooth settings");
                }
                break;
        }
        return b("android.settings.SETTINGS", "settings");
    }
}
