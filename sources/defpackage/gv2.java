package defpackage;

import android.view.View;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class gv2 extends dk1 implements f71, t23 {
    public na3 H;
    public na3 X;
    public hq0 Y;
    public tb3 Z;
    public na3 x;

    @Override // defpackage.dk1
    public final void A0() {
        tb3 tb3Var;
        View viewA = dm4.a(this);
        WeakHashMap weakHashMap = tb3.v;
        synchronized (weakHashMap) {
            try {
                Object tb3Var2 = weakHashMap.get(viewA);
                if (tb3Var2 == null) {
                    tb3Var2 = new tb3(viewA);
                    weakHashMap.put(viewA, tb3Var2);
                }
                tb3Var = (tb3) tb3Var2;
            } catch (Throwable th) {
                throw th;
            }
        }
        t11 t11Var = tb3Var.u;
        if (tb3Var.t == 0) {
            int i = u73.a;
            o73.f(viewA, t11Var);
            if (viewA.isAttachedToWindow()) {
                viewA.requestApplyInsets();
            }
            viewA.addOnAttachStateChangeListener(t11Var);
            u73.c(viewA, t11Var);
        }
        tb3Var.t++;
        na3 na3Var = (na3) this.Y.j(tb3Var);
        if (!g31.a(na3Var, this.X)) {
            this.X = na3Var;
            I0();
        }
        this.Z = tb3Var;
        jd4.b(this, "androidx.compose.foundation.layout.ConsumedInsetsProvider", new r11(this, 1));
        I0();
    }

    @Override // defpackage.dk1
    public final void B0() {
        View viewA = dm4.a(this);
        tb3 tb3Var = this.Z;
        if (tb3Var != null) {
            int i = tb3Var.t - 1;
            tb3Var.t = i;
            if (i == 0) {
                int i2 = u73.a;
                o73.f(viewA, null);
                u73.c(viewA, null);
                viewA.removeOnAttachStateChangeListener(tb3Var.u);
            }
        }
        this.H = this.x;
        jd4.d(this, "androidx.compose.foundation.layout.ConsumedInsetsProvider", new r11(this, 0));
    }

    @Override // defpackage.dk1
    public final void C0() {
        this.x = ib4.a;
    }

    public final void I0() {
        this.H = new p43(this.x, this.X);
        jd4.d(this, "androidx.compose.foundation.layout.ConsumedInsetsProvider", new r11(this, 0));
        up4.a(this);
    }

    @Override // defpackage.f71
    public final ph1 d(qh1 qh1Var, jh1 jh1Var, long j) {
        int iA = this.H.a(qh1Var, qh1Var.getLayoutDirection()) - this.x.a(qh1Var, qh1Var.getLayoutDirection());
        int iB = this.H.b(qh1Var) - this.x.b(qh1Var);
        int iC = (this.H.c(qh1Var, qh1Var.getLayoutDirection()) - this.x.c(qh1Var, qh1Var.getLayoutDirection())) + iA;
        int iD = (this.H.d(qh1Var) - this.x.d(qh1Var)) + iB;
        zw1 zw1VarE = jh1Var.e(r40.i(-iC, -iD, j));
        return qh1Var.j0(r40.g(zw1VarE.a + iC, j), r40.f(zw1VarE.b + iD, j), ji0.a, new u11(zw1VarE, iA, iB, 0));
    }

    @Override // defpackage.t23
    public final Object p() {
        return "androidx.compose.foundation.layout.ConsumedInsetsProvider";
    }
}
