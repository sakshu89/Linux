package defpackage;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Build;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class e62 {
    /* JADX WARN: Multi-variable type inference failed */
    public static void a(Activity activity, db1 db1Var) {
        qb1 qb1VarF;
        db1Var.getClass();
        if (!(activity instanceof ob1) || (qb1VarF = ((ob1) activity).f()) == null) {
            return;
        }
        qb1VarF.d(db1Var);
    }

    public static void b(Activity activity) {
        if (Build.VERSION.SDK_INT >= 29) {
            g62.a.Companion.getClass();
            activity.registerActivityLifecycleCallbacks(new g62.a());
        }
        FragmentManager fragmentManager = activity.getFragmentManager();
        if (fragmentManager.findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag") == null) {
            fragmentManager.beginTransaction().add(new g62(), "androidx.lifecycle.LifecycleDispatcher.report_fragment_tag").commit();
            fragmentManager.executePendingTransactions();
        }
    }
}
