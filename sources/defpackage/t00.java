package defpackage;

import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class t00 {
    public static final l11 a = new l11("CommonUtils", 24);

    public static String a(Context context) {
        try {
            return String.valueOf(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode);
        } catch (PackageManager.NameNotFoundException e) {
            String strConcat = "Exception thrown when trying to get app version ".concat(e.toString());
            l11 l11Var = a;
            if (!Log.isLoggable((String) l11Var.b, 6)) {
                return "";
            }
            String str = (String) l11Var.c;
            if (str != null) {
                strConcat = str.concat(strConcat);
            }
            Log.e("CommonUtils", strConcat);
            return "";
        }
    }
}
