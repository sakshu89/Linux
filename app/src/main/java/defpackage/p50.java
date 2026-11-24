package defpackage;

import android.app.Notification;
import android.content.Context;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.view.DisplayCutout;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class p50 {
    public static Handler a(Looper looper) {
        return Handler.createAsync(looper);
    }

    public static Handler b(Looper looper) {
        return Handler.createAsync(looper);
    }

    public static List c(DisplayCutout displayCutout) {
        return displayCutout.getBoundingRects();
    }

    public static Executor d(Context context) {
        return context.getMainExecutor();
    }

    public static int e(Object obj) {
        return ((Icon) obj).getResId();
    }

    public static String f(Object obj) {
        return ((Icon) obj).getResPackage();
    }

    public static int g(DisplayCutout displayCutout) {
        return displayCutout.getSafeInsetBottom();
    }

    public static int h(DisplayCutout displayCutout) {
        return displayCutout.getSafeInsetLeft();
    }

    public static int i(DisplayCutout displayCutout) {
        return displayCutout.getSafeInsetRight();
    }

    public static int j(DisplayCutout displayCutout) {
        return displayCutout.getSafeInsetTop();
    }

    public static int k(Object obj) {
        return ((Icon) obj).getType();
    }

    public static Uri l(Object obj) {
        return ((Icon) obj).getUri();
    }

    public static boolean m(Handler handler, nv nvVar, long j) {
        return handler.postDelayed(nvVar, "retry_token", j);
    }

    public static void n(ve veVar, int i) {
        veVar.setFirstBaselineToTopHeight(i);
    }

    public static void o(Notification.Action.Builder builder) {
        builder.setSemanticAction(0);
    }
}
