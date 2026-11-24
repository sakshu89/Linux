package defpackage;

import android.util.Log;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class xq4 {
    public static int a = 3;

    public static void a(String str, String str2) {
        if (c(6, str)) {
            Log.e(str, str2);
        }
    }

    public static void b(String str, String str2, Throwable th) {
        if (c(6, str)) {
            Log.e(str, str2, th);
        }
    }

    public static boolean c(int i, String str) {
        return a <= i || Log.isLoggable(str, i);
    }

    public static void d(String str, String str2) {
        if (c(5, str)) {
            Log.w(str, str2);
        }
    }

    public static void e(String str, String str2, Throwable th) {
        if (c(5, str)) {
            Log.w(str, str2, th);
        }
    }
}
