package defpackage;

import android.view.View;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class xf1 extends dk1 implements du0, qf0, eg2, ep1 {
    public qy2 H;
    public ix1 X;
    public View Y;
    public jc0 Z;
    public hx1 c0;
    public qc0 e0;
    public l21 g0;
    public un h0;
    public rm2 x;
    public final ku1 d0 = new ku1(null, el1.f);
    public long f0 = 9205357640488583168L;

    public xf1(rm2 rm2Var, qy2 qy2Var, ix1 ix1Var) {
        this.x = rm2Var;
        this.H = qy2Var;
        this.X = ix1Var;
    }

    @Override // defpackage.dk1
    public final void A0() {
        J();
        this.h0 = nh4.a(0, 7, null);
        uf4.b(w0(), null, new l2(this, (x50) null, 11), 1);
    }

    @Override // defpackage.dk1
    public final void B0() {
        hx1 hx1Var = this.c0;
        if (hx1Var != null) {
            ((jx1) hx1Var).b();
        }
        this.c0 = null;
    }

    public final long I0() {
        if (this.e0 == null) {
            this.e0 = o44.b(new wf1(this, 2));
        }
        qc0 qc0Var = this.e0;
        if (qc0Var != null) {
            return ((jp1) qc0Var.getValue()).a;
        }
        return 9205357640488583168L;
    }

    @Override // defpackage.ep1
    public final void J() {
        tr4.a(this, new wf1(this, 0));
    }

    public final void J0() {
        hx1 hx1Var = this.c0;
        if (hx1Var != null) {
            ((jx1) hx1Var).b();
        }
        View viewA = this.Y;
        if (viewA == null) {
            viewA = dm4.a(this);
        }
        this.Y = viewA;
        jc0 jc0Var = this.Z;
        if (jc0Var == null) {
            jc0Var = cm4.g(this).h0;
        }
        this.Z = jc0Var;
        this.c0 = this.X.b(viewA, jc0Var);
        L0();
    }

    public final void K0() {
        jc0 jc0Var = this.Z;
        if (jc0Var == null) {
            jc0Var = cm4.g(this).h0;
            this.Z = jc0Var;
        }
        long j = ((jp1) this.x.j(jc0Var)).a;
        if ((j & 9223372034707292159L) == 9205357640488583168L || (9223372034707292159L & I0()) == 9205357640488583168L) {
            this.f0 = 9205357640488583168L;
            hx1 hx1Var = this.c0;
            if (hx1Var != null) {
                ((jx1) hx1Var).b();
                return;
            }
            return;
        }
        this.f0 = jp1.e(I0(), j);
        if (this.c0 == null) {
            J0();
        }
        hx1 hx1Var2 = this.c0;
        if (hx1Var2 != null) {
            hx1Var2.a(this.f0, 9205357640488583168L);
        }
        L0();
    }

    public final void L0() {
        jc0 jc0Var;
        hx1 hx1Var = this.c0;
        if (hx1Var == null || (jc0Var = this.Z) == null) {
            return;
        }
        jx1 jx1Var = (jx1) hx1Var;
        long jC = jx1Var.c();
        l21 l21Var = this.g0;
        if (l21Var != null && jC == l21Var.a) {
            return;
        }
        this.H.j(new ge0(jc0Var.w(cp4.a(jx1Var.c()))));
        this.g0 = new l21(jx1Var.c());
    }

    @Override // defpackage.qf0
    public final void N(p71 p71Var) {
        p71Var.a();
        un unVar = this.h0;
        if (unVar != null) {
            unVar.s(q43.a);
        }
    }

    @Override // defpackage.eg2
    public final void e0(og2 og2Var) {
        og2Var.a(yf1.a, new wf1(this, 1));
    }

    @Override // defpackage.du0
    public final void u(co1 co1Var) {
        this.d0.setValue(co1Var);
    }
}
