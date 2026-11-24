package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class od2 extends zb0 implements h30, ep1 {
    public be2 X;
    public js1 Y;
    public boolean Z;
    public ka0 c0;
    public ol1 d0;
    public boolean e0;
    public f9 f0;
    public ae2 g0;
    public xb0 h0;
    public g9 i0;
    public f9 j0;
    public boolean k0;

    @Override // defpackage.dk1
    public final void A0() {
        this.k0 = M0();
        L0();
        if (this.g0 == null) {
            be2 be2Var = this.X;
            ae2 ae2Var = new ae2(this.e0 ? this.j0 : this.f0, this.c0, this.d0, this.Y, be2Var, this.Z, this.k0);
            I0(ae2Var);
            this.g0 = ae2Var;
        }
    }

    @Override // defpackage.dk1
    public final void B0() {
        xb0 xb0Var = this.h0;
        if (xb0Var != null) {
            J0(xb0Var);
        }
    }

    @Override // defpackage.ep1
    public final void J() {
        g9 g9Var = (g9) ij4.a(this, gt1.a);
        if (g31.a(g9Var, this.i0)) {
            return;
        }
        this.i0 = g9Var;
        this.j0 = null;
        xb0 xb0Var = this.h0;
        if (xb0Var != null) {
            J0(xb0Var);
        }
        this.h0 = null;
        L0();
        ae2 ae2Var = this.g0;
        if (ae2Var != null) {
            be2 be2Var = this.X;
            js1 js1Var = this.Y;
            ae2Var.Z0(this.e0 ? this.j0 : this.f0, this.c0, this.d0, js1Var, be2Var, this.Z, this.k0);
        }
    }

    public final void L0() {
        xb0 xb0Var = this.h0;
        if (xb0Var != null) {
            if (((dk1) xb0Var).a.w) {
                return;
            }
            I0(xb0Var);
            return;
        }
        if (this.e0) {
            tr4.a(this, new kb(18, this));
        }
        f9 f9Var = this.e0 ? this.j0 : this.f0;
        if (f9Var != null) {
            zb0 zb0Var = f9Var.i;
            if (zb0Var.a.w) {
                return;
            }
            I0(zb0Var);
            this.h0 = zb0Var;
        }
    }

    public final boolean M0() {
        return (this.w ? cm4.g(this).i0 : z61.a) != z61.b || this.Y == js1.a;
    }

    public final void N0(f9 f9Var, ka0 ka0Var, ol1 ol1Var, js1 js1Var, be2 be2Var, boolean z, boolean z2) {
        boolean z3;
        this.X = be2Var;
        this.Y = js1Var;
        boolean z4 = true;
        if (this.e0 != z) {
            this.e0 = z;
            z3 = true;
        } else {
            z3 = false;
        }
        if (g31.a(this.f0, f9Var)) {
            z4 = false;
        } else {
            this.f0 = f9Var;
        }
        if (z3 || (z4 && !z)) {
            xb0 xb0Var = this.h0;
            if (xb0Var != null) {
                J0(xb0Var);
            }
            this.h0 = null;
            L0();
        }
        this.Z = z2;
        this.c0 = ka0Var;
        this.d0 = ol1Var;
        boolean zM0 = M0();
        this.k0 = zM0;
        ae2 ae2Var = this.g0;
        if (ae2Var != null) {
            ae2Var.Z0(this.e0 ? this.j0 : this.f0, ka0Var, ol1Var, js1Var, be2Var, z2, zM0);
        }
    }

    @Override // defpackage.xb0
    public final void t0() {
        boolean zM0 = M0();
        if (this.k0 != zM0) {
            this.k0 = zM0;
            be2 be2Var = this.X;
            js1 js1Var = this.Y;
            boolean z = this.e0;
            N0(z ? this.j0 : this.f0, this.c0, this.d0, js1Var, be2Var, z, this.Z);
        }
    }

    @Override // defpackage.dk1
    public final boolean x0() {
        return false;
    }
}
