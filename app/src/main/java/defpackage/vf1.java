package defpackage;

import android.view.View;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class vf1 extends ik1 {
    public final rm2 a;
    public final qy2 b;
    public final ix1 c;

    public vf1(rm2 rm2Var, qy2 qy2Var, ix1 ix1Var) {
        this.a = rm2Var;
        this.b = qy2Var;
        this.c = ix1Var;
    }

    @Override // defpackage.ik1
    public final dk1 e() {
        return new xf1(this.a, this.b, this.c);
    }

    public final boolean equals(Object obj) {
        return this == obj;
    }

    @Override // defpackage.ik1
    public final void f(dk1 dk1Var) {
        xf1 xf1Var = (xf1) dk1Var;
        xf1Var.getClass();
        ix1 ix1Var = xf1Var.X;
        View view = xf1Var.Y;
        jc0 jc0Var = xf1Var.Z;
        xf1Var.x = this.a;
        xf1Var.H = this.b;
        ix1 ix1Var2 = this.c;
        xf1Var.X = ix1Var2;
        View viewA = dm4.a(xf1Var);
        jc0 jc0Var2 = cm4.g(xf1Var).h0;
        if (xf1Var.c0 != null) {
            ng2 ng2Var = yf1.a;
            if (((!Float.isNaN(Float.NaN) || !Float.isNaN(Float.NaN)) && !ix1Var2.a()) || !de0.b(Float.NaN, Float.NaN) || !de0.b(Float.NaN, Float.NaN) || !ix1Var2.equals(ix1Var) || !viewA.equals(view) || !g31.a(jc0Var2, jc0Var)) {
                xf1Var.J0();
            }
        }
        xf1Var.K0();
    }

    public final int hashCode() {
        return this.c.hashCode() + ((this.b.hashCode() + ky0.e(cq.b(cq.b(cq.c(ky0.e(cq.b(this.a.hashCode() * 961, Float.NaN, 31), 31, true), 31, 9205357640488583168L), Float.NaN, 31), Float.NaN, 31), 31, true)) * 31);
    }
}
