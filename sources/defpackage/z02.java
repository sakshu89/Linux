package defpackage;

import android.app.Activity;
import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class z02 extends ei0 {
    final /* synthetic */ a12 this$0;

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class a extends ei0 {
        final /* synthetic */ a12 this$0;

        public a(a12 a12Var) {
            this.this$0 = a12Var;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostResumed(Activity activity) {
            activity.getClass();
            this.this$0.a();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostStarted(Activity activity) {
            activity.getClass();
            a12 a12Var = this.this$0;
            int i = a12Var.a + 1;
            a12Var.a = i;
            if (i == 1 && a12Var.e) {
                a12Var.i.d(db1.ON_START);
                a12Var.e = false;
            }
        }
    }

    public z02(a12 a12Var) {
        this.this$0 = a12Var;
    }

    @Override // defpackage.ei0, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        activity.getClass();
        if (Build.VERSION.SDK_INT < 29) {
            int i = g62.b;
            Fragment fragmentFindFragmentByTag = activity.getFragmentManager().findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag");
            fragmentFindFragmentByTag.getClass();
            ((g62) fragmentFindFragmentByTag).a = this.this$0.k;
        }
    }

    @Override // defpackage.ei0, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        activity.getClass();
        a12 a12Var = this.this$0;
        int i = a12Var.b - 1;
        a12Var.b = i;
        if (i == 0) {
            Handler handler = a12Var.f;
            handler.getClass();
            handler.postDelayed(a12Var.j, 700L);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPreCreated(Activity activity, Bundle bundle) {
        activity.getClass();
        f50.i(activity, new a(this.this$0));
    }

    @Override // defpackage.ei0, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        activity.getClass();
        a12 a12Var = this.this$0;
        int i = a12Var.a - 1;
        a12Var.a = i;
        if (i == 0 && a12Var.c) {
            a12Var.i.d(db1.ON_STOP);
            a12Var.e = true;
        }
    }
}
