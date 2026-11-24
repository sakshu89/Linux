package defpackage;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageInstaller;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesIncorrectManifestValueException;
import com.google.android.gms.common.GooglePlayServicesMissingManifestValueException;
import com.ibm.icu.impl.locale.LanguageTag;
import com.ibm.icu.text.ArabicShaping;
import com.project.sonic.R;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class nu0 {
    public static final int a;
    public static final nu0 b;

    static {
        int i = ru0.c;
        a = 12451000;
        b = new nu0();
    }

    public Intent a(int i, Context context, String str) {
        if (i != 1 && i != 2) {
            if (i != 3) {
                return null;
            }
            Uri uriFromParts = Uri.fromParts("package", "com.google.android.gms", null);
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(uriFromParts);
            return intent;
        }
        if (context != null && fm4.a(context)) {
            Intent intent2 = new Intent("com.google.android.clockwork.home.UPDATE_ANDROID_WEAR_ACTION");
            intent2.setPackage("com.google.android.wearable.app");
            return intent2;
        }
        StringBuilder sb = new StringBuilder("gcore_");
        sb.append(a);
        sb.append(LanguageTag.SEP);
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
        }
        sb.append(LanguageTag.SEP);
        if (context != null) {
            sb.append(context.getPackageName());
        }
        sb.append(LanguageTag.SEP);
        if (context != null) {
            try {
                wf wfVarA = sc3.a(context);
                sb.append(wfVarA.a.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode);
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        String string = sb.toString();
        Intent intent3 = new Intent("android.intent.action.VIEW");
        Uri.Builder builderAppendQueryParameter = Uri.parse("market://details").buildUpon().appendQueryParameter("id", "com.google.android.gms");
        if (!TextUtils.isEmpty(string)) {
            builderAppendQueryParameter.appendQueryParameter("pcampaignid", string);
        }
        intent3.setData(builderAppendQueryParameter.build());
        intent3.setPackage("com.android.vending");
        intent3.addFlags(ArabicShaping.TASHKEEL_RESIZE);
        return intent3;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0186  */
    /* JADX WARN: Code duplicated, block: B:103:0x018b  */
    /* JADX WARN: Code duplicated, block: B:105:0x018f  */
    /* JADX WARN: Code duplicated, block: B:106:0x01b4  */
    /* JADX WARN: Code duplicated, block: B:115:0x01d5  */
    /* JADX WARN: Code duplicated, block: B:116:0x01d7  */
    /* JADX WARN: Code duplicated, block: B:144:0x01b8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:54:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:92:0x015c  */
    /* JADX WARN: Code duplicated, block: B:97:0x017f  */
    /* JADX WARN: Code duplicated, block: B:99:0x0184  */
    /* JADX WARN: Instruction removed from duplicated block: B:105:0x018f, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:97:0x017f, please report this as an issue */
    public int b(Context context, int i) {
        boolean z;
        PackageInfo packageInfo;
        int i2;
        int i3;
        ApplicationInfo applicationInfo;
        int i4 = ru0.c;
        try {
            context.getResources().getString(R.string.common_google_play_services_unknown_issue);
        } catch (Throwable unused) {
            Log.e("GooglePlayServicesUtil", "The Google Play services resources were not found. Check your project configuration to ensure that the resources are included.");
        }
        boolean z2 = true;
        if (!"com.google.android.gms".equals(context.getPackageName()) && !ru0.b.get()) {
            synchronized (qb4.a) {
                try {
                    if (!qb4.b) {
                        qb4.b = true;
                        try {
                            Bundle bundle = sc3.a(context).a.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
                            if (bundle != null) {
                                bundle.getString("com.google.app.id");
                                qb4.c = bundle.getInt("com.google.android.gms.version");
                            }
                        } catch (PackageManager.NameNotFoundException e) {
                            Log.wtf("MetadataValueReader", "This should never happen.", e);
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            int i5 = qb4.c;
            if (i5 == 0) {
                throw new GooglePlayServicesMissingManifestValueException("A required meta-data tag in your app's AndroidManifest.xml does not exist.  You must have the following declaration within the <application> element:     <meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />");
            }
            if (i5 != 12451000) {
                throw new GooglePlayServicesIncorrectManifestValueException(cq.i("The meta-data tag in your app's AndroidManifest.xml does not have the right value.  Expected ", a, " but found ", i5, ".  You must have the following declaration within the <application> element:     <meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />"));
            }
        }
        int i6 = 0;
        if (fm4.a(context)) {
            z = false;
        } else {
            if (fm4.c == null) {
                fm4.c = Boolean.valueOf(context.getPackageManager().hasSystemFeature("android.hardware.type.iot") || context.getPackageManager().hasSystemFeature("android.hardware.type.embedded"));
            }
            if (fm4.c.booleanValue()) {
                z = false;
            } else {
                z = true;
            }
        }
        if (i < 0) {
            dk0.v();
            return 0;
        }
        String packageName = context.getPackageName();
        PackageManager packageManager = context.getPackageManager();
        int i7 = 9;
        if (z) {
            try {
                packageInfo = packageManager.getPackageInfo("com.android.vending", 8256);
            } catch (PackageManager.NameNotFoundException unused2) {
                Log.w("GooglePlayServicesUtil", String.valueOf(packageName).concat(" requires the Google Play Store, but it is missing."));
            }
        } else {
            packageInfo = null;
        }
        try {
            PackageInfo packageInfo2 = packageManager.getPackageInfo("com.google.android.gms", 64);
            synchronized (su0.class) {
                if (su0.b == null) {
                    w54 w54Var = ol4.a;
                    synchronized (ol4.class) {
                        if (ol4.c == null) {
                            ol4.c = context.getApplicationContext();
                        } else {
                            Log.w("GoogleCertificates", "GoogleCertificates has been initialized already");
                        }
                    }
                    su0 su0Var = new su0(i6);
                    context.getApplicationContext();
                    su0.b = su0Var;
                }
            }
            if (!su0.r(packageInfo2)) {
                Log.w("GooglePlayServicesUtil", String.valueOf(packageName).concat(" requires Google Play services, but their signature is invalid."));
            } else if (z) {
                jg1.d(packageInfo);
                if (!su0.r(packageInfo)) {
                    Log.w("GooglePlayServicesUtil", String.valueOf(packageName).concat(" requires Google Play Store, but its signature is invalid."));
                } else if (z || packageInfo == null || packageInfo.signatures[0].equals(packageInfo2.signatures[0])) {
                    i2 = packageInfo2.versionCode;
                    if (i2 == -1) {
                        i3 = -1;
                    } else {
                        i3 = i2 / 1000;
                    }
                    if (i3 < (i != -1 ? i / 1000 : -1)) {
                        Log.w("GooglePlayServicesUtil", "Google Play services out of date for " + packageName + ".  Requires " + i + " but found " + i2);
                        i7 = 2;
                    } else {
                        applicationInfo = packageInfo2.applicationInfo;
                        if (applicationInfo == null) {
                            try {
                                applicationInfo = packageManager.getApplicationInfo("com.google.android.gms", 0);
                            } catch (PackageManager.NameNotFoundException e2) {
                                Log.wtf("GooglePlayServicesUtil", String.valueOf(packageName).concat(" requires Google Play services, but they're missing when getting application info."), e2);
                                i7 = 1;
                            }
                        }
                        if (applicationInfo.enabled) {
                            i7 = 0;
                        } else {
                            i7 = 3;
                        }
                    }
                } else {
                    Log.w("GooglePlayServicesUtil", String.valueOf(packageName).concat(" requires Google Play Store, but its signature doesn't match that of Google Play services."));
                }
            } else if (z) {
                i2 = packageInfo2.versionCode;
                if (i2 == -1) {
                    i3 = -1;
                } else {
                    i3 = i2 / 1000;
                }
                if (i3 < (i != -1 ? i / 1000 : -1)) {
                    Log.w("GooglePlayServicesUtil", "Google Play services out of date for " + packageName + ".  Requires " + i + " but found " + i2);
                    i7 = 2;
                } else {
                    applicationInfo = packageInfo2.applicationInfo;
                    if (applicationInfo == null) {
                        applicationInfo = packageManager.getApplicationInfo("com.google.android.gms", 0);
                    }
                    if (applicationInfo.enabled) {
                        i7 = 3;
                    } else {
                        i7 = 0;
                    }
                }
            } else {
                i2 = packageInfo2.versionCode;
                if (i2 == -1) {
                    i3 = -1;
                } else {
                    i3 = i2 / 1000;
                }
                if (i3 < (i != -1 ? i / 1000 : -1)) {
                    Log.w("GooglePlayServicesUtil", "Google Play services out of date for " + packageName + ".  Requires " + i + " but found " + i2);
                    i7 = 2;
                } else {
                    applicationInfo = packageInfo2.applicationInfo;
                    if (applicationInfo == null) {
                        applicationInfo = packageManager.getApplicationInfo("com.google.android.gms", 0);
                    }
                    if (applicationInfo.enabled) {
                        i7 = 3;
                    } else {
                        i7 = 0;
                    }
                }
            }
        } catch (PackageManager.NameNotFoundException unused3) {
            Log.w("GooglePlayServicesUtil", String.valueOf(packageName).concat(" requires Google Play services, but they are missing."));
        }
        if (i7 != 18) {
            if (i7 == 1) {
                try {
                    Iterator<PackageInstaller.SessionInfo> it = context.getPackageManager().getPackageInstaller().getAllSessions().iterator();
                    while (it.hasNext()) {
                        if ("com.google.android.gms".equals(it.next().getAppPackageName())) {
                        }
                    }
                    z2 = context.getPackageManager().getApplicationInfo("com.google.android.gms", 8192).enabled;
                } catch (PackageManager.NameNotFoundException | Exception unused4) {
                    z2 = false;
                }
            } else {
                z2 = false;
            }
        }
        if (z2) {
            return 18;
        }
        return i7;
    }
}
