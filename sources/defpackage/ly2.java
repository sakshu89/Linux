package defpackage;

import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ly2 implements wx2 {
    public oz2 b;
    public final /* synthetic */ ny2 d;
    public boolean a = true;
    public lf2 c = xy.Y;

    public ly2(ny2 ny2Var) {
        this.d = ny2Var;
    }

    @Override // defpackage.wx2
    public final void a() {
        f();
    }

    @Override // defpackage.wx2
    public final void b(long j, lf2 lf2Var) throws IllegalAccessException, InvocationTargetException {
        long j2;
        hz2 hz2VarD;
        hz2 hz2VarD2;
        ny2 ny2Var = this.d;
        ku1 ku1Var = ny2Var.r;
        if (ny2Var.k() && ((pv0) ku1Var.getValue()) == null) {
            ku1Var.setValue(pv0.c);
            ny2Var.t = -1;
            this.a = true;
            this.c = lf2Var;
            ny2Var.o();
            ua1 ua1Var = ny2Var.d;
            if (ua1Var == null || (hz2VarD2 = ua1Var.d()) == null || !hz2VarD2.c(j)) {
                j2 = j;
                ua1 ua1Var2 = ny2Var.d;
                if (ua1Var2 != null && (hz2VarD = ua1Var2.d()) != null) {
                    int iK = ny2Var.b.k(hz2VarD.b(j2, true));
                    ty2 ty2VarE = ny2.e(ny2Var.n().a, hc4.a(iK, iK));
                    ny2Var.h(false);
                    bw0 bw0Var = ny2Var.k;
                    if (bw0Var != null) {
                        bw0Var.a();
                    }
                    ny2Var.c.j(ty2VarE);
                    ny2Var.w = new oz2(ty2VarE.b);
                }
                this.a = false;
            } else {
                if (ny2Var.n().a.b.length() == 0) {
                    return;
                }
                ny2Var.h(false);
                long jC = ny2.c(ny2Var, ty2.a(ny2Var.n(), null, oz2.b, 5), j, true, false, this.c, true);
                j2 = j;
                ny2Var.p = new oz2(jC);
                this.b = new oz2(jC);
            }
            ny2Var.q(rv0.a);
            ny2Var.o = j2;
            ny2Var.s.setValue(new jp1(j2));
            ny2Var.q = 0L;
        }
    }

    /* JADX WARN: Code duplicated, block: B:21:0x008e  */
    /* JADX WARN: Code duplicated, block: B:23:0x0092  */
    /* JADX WARN: Code duplicated, block: B:24:0x0099  */
    @Override // defpackage.wx2
    public final void e(long j) {
        hz2 hz2VarD;
        oz2 oz2Var;
        int iB;
        long jC;
        ny2 ny2Var = this.d;
        if (!ny2Var.k() || ny2Var.n().a.b.length() == 0) {
            return;
        }
        ny2Var.q = jp1.e(ny2Var.q, j);
        ua1 ua1Var = ny2Var.d;
        if (ua1Var != null && (hz2VarD = ua1Var.d()) != null) {
            ny2Var.s.setValue(new jp1(jp1.e(ny2Var.o, ny2Var.q)));
            if (ny2Var.p == null) {
                jp1 jp1VarI = ny2Var.i();
                jp1VarI.getClass();
                if (hz2VarD.c(jp1VarI.a)) {
                    oz2Var = ny2Var.p;
                    if (oz2Var != null) {
                        iB = (int) (oz2Var.a >> 32);
                    } else {
                        iB = hz2VarD.b(ny2Var.o, false);
                    }
                    jp1 jp1VarI2 = ny2Var.i();
                    jp1VarI2.getClass();
                    int iB2 = hz2VarD.b(jp1VarI2.a, false);
                    if (ny2Var.p != null && iB == iB2) {
                        return;
                    }
                    ty2 ty2VarN = ny2Var.n();
                    jp1 jp1VarI3 = ny2Var.i();
                    jp1VarI3.getClass();
                    jC = ny2.c(ny2Var, ty2VarN, jp1VarI3.a, false, false, this.c, true);
                } else {
                    int iK = ny2Var.b.k(hz2VarD.b(ny2Var.o, true));
                    mp1 mp1Var = ny2Var.b;
                    jp1 jp1VarI4 = ny2Var.i();
                    jp1VarI4.getClass();
                    dk0 dk0Var = iK == mp1Var.k(hz2VarD.b(jp1VarI4.a, true)) ? xy.Y : xy.Z;
                    ty2 ty2VarN2 = ny2Var.n();
                    jp1 jp1VarI5 = ny2Var.i();
                    jp1VarI5.getClass();
                    jC = ny2.c(ny2Var, ty2VarN2, jp1VarI5.a, false, false, dk0Var, true);
                }
            } else {
                oz2Var = ny2Var.p;
                if (oz2Var != null) {
                    iB = (int) (oz2Var.a >> 32);
                } else {
                    iB = hz2VarD.b(ny2Var.o, false);
                }
                jp1 jp1VarI6 = ny2Var.i();
                jp1VarI6.getClass();
                int iB3 = hz2VarD.b(jp1VarI6.a, false);
                if (ny2Var.p != null) {
                }
                ty2 ty2VarN3 = ny2Var.n();
                jp1 jp1VarI7 = ny2Var.i();
                jp1VarI7.getClass();
                jC = ny2.c(ny2Var, ty2VarN3, jp1VarI7.a, false, false, this.c, true);
            }
            this.b = new oz2(jC);
            if (!oz2.a(jC, ny2Var.p)) {
                this.a = false;
            }
        }
        ny2Var.t(false);
    }

    public final void f() {
        ny2 ny2Var = this.d;
        ny2Var.r.setValue(null);
        ny2Var.s.setValue(null);
        this.c = xy.Y;
        ny2Var.t(true);
        oz2 oz2Var = this.b;
        boolean zC = oz2.c(oz2Var != null ? oz2Var.a : ny2Var.n().b);
        ny2Var.q(zC ? rv0.c : rv0.b);
        ua1 ua1Var = ny2Var.d;
        if (ua1Var != null) {
            ua1Var.m.setValue(Boolean.valueOf(!zC && yb4.b(ny2Var, true)));
        }
        ua1 ua1Var2 = ny2Var.d;
        if (ua1Var2 != null) {
            ua1Var2.n.setValue(Boolean.valueOf(!zC && yb4.b(ny2Var, false)));
        }
        ua1 ua1Var3 = ny2Var.d;
        if (ua1Var3 != null) {
            ua1Var3.o.setValue(Boolean.valueOf(zC && yb4.b(ny2Var, true)));
        }
        if (this.a) {
            ny2.b(ny2Var, ny2Var.p);
        }
        ny2Var.p = null;
    }

    @Override // defpackage.wx2
    public final void onCancel() {
        f();
    }

    @Override // defpackage.wx2
    public final void c() {
    }

    @Override // defpackage.wx2
    public final void d() {
    }
}
