package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ok extends dk1 implements f71, qf0, eg2, qy1, gk1, lu1, w61, du0, rn0, ho0, jt1, zn {
    public ck1 x;

    @Override // defpackage.dk1
    public final void A0() {
        I0(true);
    }

    @Override // defpackage.f71
    public final int B(mf1 mf1Var, jh1 jh1Var, int i) {
        ck1 ck1Var = this.x;
        ck1Var.getClass();
        return ((d71) ck1Var).d(new m31(mf1Var, mf1Var.getLayoutDirection()), new pa0(jh1Var, rh1.a, sh1.b, 1), r40.b(i, 0, 13)).a();
    }

    @Override // defpackage.dk1
    public final void B0() {
        if (!this.w) {
            z01.b("unInitializeModifier called on unattached node");
        }
        if ((this.c & 8) != 0) {
            ((r7) cm4.h(this)).w();
        }
    }

    @Override // defpackage.qy1
    public final void H(gy1 gy1Var, hy1 hy1Var, long j) {
        this.x.getClass();
        throw new ClassCastException();
    }

    public final void I0(boolean z) {
        if (!this.w) {
            z01.b("initializeModifier called on unattached node");
        }
        ck1 ck1Var = this.x;
        if ((this.c & 4) != 0 && !z) {
            cm4.e(this, 2).c1();
        }
        if ((this.c & 2) != 0) {
            jv2 jv2Var = cm4.g(this).o0.e;
            jv2Var.getClass();
            if (jv2Var.x) {
                co1 co1Var = this.k;
                co1Var.getClass();
                ((h71) co1Var).w1(this);
                ht1 ht1Var = co1Var.u0;
                if (ht1Var != null) {
                    ((yu0) ht1Var).c();
                }
            }
            if (!z) {
                cm4.e(this, 2).c1();
                cm4.g(this).E();
            }
        }
        if (ck1Var instanceof ca1) {
            ((ca1) ck1Var).a.k = cm4.g(this);
        }
        if ((this.c & 8) != 0) {
            ((r7) cm4.h(this)).w();
        }
    }

    @Override // defpackage.qf0
    public final void N(p71 p71Var) {
        ck1 ck1Var = this.x;
        ck1Var.getClass();
        p71Var.a();
    }

    @Override // defpackage.f71
    public final int S(mf1 mf1Var, jh1 jh1Var, int i) {
        ck1 ck1Var = this.x;
        ck1Var.getClass();
        return ((d71) ck1Var).d(new m31(mf1Var, mf1Var.getLayoutDirection()), new pa0(jh1Var, rh1.a, sh1.a, 1), r40.b(0, i, 7)).b();
    }

    @Override // defpackage.rn0
    public final void V(jo0 jo0Var) {
        ck1 ck1Var = this.x;
        z01.b("onFocusEvent called on wrong node");
        ck1Var.getClass();
        throw new ClassCastException();
    }

    @Override // defpackage.qy1
    public final boolean Y() {
        this.x.getClass();
        throw new ClassCastException();
    }

    @Override // defpackage.zn
    public final jc0 b() {
        return cm4.g(this).h0;
    }

    @Override // defpackage.zn
    public final long c() {
        return cp4.a(cm4.e(this, 128).c);
    }

    @Override // defpackage.f71
    public final ph1 d(qh1 qh1Var, jh1 jh1Var, long j) {
        ck1 ck1Var = this.x;
        ck1Var.getClass();
        return ((d71) ck1Var).d(qh1Var, jh1Var, j);
    }

    @Override // defpackage.f71
    public final int e(mf1 mf1Var, jh1 jh1Var, int i) {
        ck1 ck1Var = this.x;
        ck1Var.getClass();
        return ((d71) ck1Var).d(new m31(mf1Var, mf1Var.getLayoutDirection()), new pa0(jh1Var, rh1.b, sh1.a, 1), r40.b(0, i, 7)).b();
    }

    @Override // defpackage.eg2
    public final void e0(og2 og2Var) {
        ck1 ck1Var = this.x;
        ck1Var.getClass();
        uf ufVar = (uf) ck1Var;
        cg2 cg2Var = new cg2();
        cg2Var.c = ufVar.a;
        ufVar.b.j(cg2Var);
        og2Var.getClass();
        cg2 cg2Var2 = (cg2) og2Var;
        gm1 gm1Var = cg2Var2.a;
        if (cg2Var.c) {
            cg2Var2.c = true;
        }
        if (cg2Var.e) {
            cg2Var2.e = true;
        }
        gm1 gm1Var2 = cg2Var.a;
        Object[] objArr = gm1Var2.b;
        Object[] objArr2 = gm1Var2.c;
        long[] jArr = gm1Var2.a;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i = 0;
        while (true) {
            long j = jArr[i];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i2 = 8 - ((~(i - length)) >>> 31);
                for (int i3 = 0; i3 < i2; i3++) {
                    if ((255 & j) < 128) {
                        int i4 = (i << 3) + i3;
                        Object obj = objArr[i4];
                        Object obj2 = objArr2[i4];
                        ng2 ng2Var = (ng2) obj;
                        if (!gm1Var.b(ng2Var)) {
                            gm1Var.m(ng2Var, obj2);
                        } else if (obj2 instanceof b2) {
                            Object objG = gm1Var.g(ng2Var);
                            objG.getClass();
                            b2 b2Var = (b2) objG;
                            String str = b2Var.a;
                            if (str == null) {
                                str = ((b2) obj2).a;
                            }
                            rq0 rq0Var = b2Var.b;
                            if (rq0Var == null) {
                                rq0Var = ((b2) obj2).b;
                            }
                            gm1Var.m(ng2Var, new b2(str, rq0Var));
                        }
                    }
                    j >>= 8;
                }
                if (i2 != 8) {
                    return;
                }
            }
            if (i == length) {
                return;
            } else {
                i++;
            }
        }
    }

    @Override // defpackage.zn
    public final z61 getLayoutDirection() {
        return cm4.g(this).i0;
    }

    @Override // defpackage.qy1
    public final void h0() {
        this.x.getClass();
        throw new ClassCastException();
    }

    @Override // defpackage.gk1
    public final qs4 i() {
        return qs4.e;
    }

    @Override // defpackage.f71
    public final int n(mf1 mf1Var, jh1 jh1Var, int i) {
        ck1 ck1Var = this.x;
        ck1Var.getClass();
        return ((d71) ck1Var).d(new m31(mf1Var, mf1Var.getLayoutDirection()), new pa0(jh1Var, rh1.b, sh1.b, 1), r40.b(i, 0, 13)).a();
    }

    @Override // defpackage.lu1
    public final Object n0(Object obj) {
        this.x.getClass();
        throw new ClassCastException();
    }

    @Override // defpackage.qf0
    public final void o0() {
        vm4.a(this);
    }

    @Override // defpackage.qy1
    public final boolean q0() {
        this.x.getClass();
        throw new ClassCastException();
    }

    public final String toString() {
        return this.x.toString();
    }

    @Override // defpackage.du0
    public final void u(co1 co1Var) {
        this.x.getClass();
        throw new ClassCastException();
    }

    @Override // defpackage.jt1
    public final boolean y() {
        return this.w;
    }

    @Override // defpackage.xb0, defpackage.qy1
    public final void a() {
    }

    @Override // defpackage.w61
    public final void o(y61 y61Var) {
    }

    @Override // defpackage.w61
    public final void r(long j) {
    }
}
