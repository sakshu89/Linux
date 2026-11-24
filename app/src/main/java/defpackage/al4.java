package defpackage;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Process;
import android.text.TextUtils;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class al4 {
    public static int a(Context context, String str) {
        if (str == null) {
            dk0.n("permission must be non-null");
            return 0;
        }
        if (Build.VERSION.SDK_INT >= 33 || !TextUtils.equals("android.permission.POST_NOTIFICATIONS", str)) {
            return context.checkPermission(str, Process.myPid(), Process.myUid());
        }
        return new qo1(context).a.areNotificationsEnabled() ? 0 : -1;
    }

    public static Executor b(Context context) {
        return Build.VERSION.SDK_INT >= 28 ? p50.d(context) : new uj0(new Handler(context.getMainLooper()), 0);
    }
}
