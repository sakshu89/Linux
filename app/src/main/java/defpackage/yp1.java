package defpackage;

import android.os.Build;
import android.window.BackEvent;
import android.window.OnBackAnimationCallback;
import java.util.ListIterator;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class yp1 implements OnBackAnimationCallback {
    public final /* synthetic */ wp1 a;
    public final /* synthetic */ wp1 b;
    public final /* synthetic */ xp1 c;
    public final /* synthetic */ xp1 d;

    public yp1(wp1 wp1Var, wp1 wp1Var2, xp1 xp1Var, xp1 xp1Var2) {
        this.a = wp1Var;
        this.b = wp1Var2;
        this.c = xp1Var;
        this.d = xp1Var2;
    }

    public final void onBackCancelled() {
        this.d.a();
    }

    public final void onBackInvoked() {
        this.c.a();
    }

    public final void onBackProgressed(BackEvent backEvent) {
        Object objPrevious;
        backEvent.getClass();
        v2.n(backEvent);
        v2.o(backEvent);
        v2.j(backEvent);
        v2.m(backEvent);
        if (Build.VERSION.SDK_INT >= 36) {
            g3.b(backEvent);
        }
        bq1 bq1Var = this.b.b;
        if (bq1Var.c == null) {
            hg hgVar = bq1Var.b;
            ListIterator listIterator = hgVar.listIterator(hgVar.size());
            while (listIterator.hasPrevious()) {
                objPrevious = listIterator.previous();
                if (((vp1) objPrevious).a) {
                }
            }
            objPrevious = null;
        }
    }

    public final void onBackStarted(BackEvent backEvent) {
        Object objPrevious;
        backEvent.getClass();
        v2.n(backEvent);
        v2.o(backEvent);
        v2.j(backEvent);
        v2.m(backEvent);
        if (Build.VERSION.SDK_INT >= 36) {
            g3.b(backEvent);
        }
        bq1 bq1Var = this.a.b;
        hg hgVar = bq1Var.b;
        ListIterator listIterator = hgVar.listIterator(hgVar.size());
        do {
            if (!listIterator.hasPrevious()) {
                objPrevious = null;
                break;
            }
            objPrevious = listIterator.previous();
        } while (!((vp1) objPrevious).a);
        vp1 vp1Var = (vp1) objPrevious;
        if (bq1Var.c != null) {
            bq1Var.a();
        }
        bq1Var.c = vp1Var;
    }
}
