package defpackage;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class vc4 {
    public static final lc0 a(Context context) {
        float f = context.getResources().getConfiguration().fontScale;
        float f2 = context.getResources().getDisplayMetrics().density;
        ip0 ip0VarA = jp0.a(f);
        if (ip0VarA == null) {
            ip0VarA = new dc1(f);
        }
        return new lc0(f2, f, ip0VarA);
    }

    public static void b() {
        hh1.e("Not in application's main thread", c());
    }

    public static boolean c() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    public static void d(Runnable runnable) {
        if (c()) {
            runnable.run();
        } else {
            hh1.e("Unable to post to main thread", new Handler(Looper.getMainLooper()).post(runnable));
        }
    }
}
