package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class p71 implements rf0 {
    public final ew a = new ew();
    public qf0 b;

    @Override // defpackage.rf0
    public final kf C() {
        return this.a.b;
    }

    @Override // defpackage.rf0
    public final void G(hn hnVar, float f, long j, float f2) {
        this.a.G(hnVar, f, j, f2);
    }

    @Override // defpackage.jc0
    public final float I(long j) {
        return this.a.I(j);
    }

    @Override // defpackage.rf0
    public final void L(long j, float f, long j2, float f2) {
        this.a.L(j, f, j2, f2);
    }

    @Override // defpackage.rf0
    public final void M(long j, long j2, long j3, wm4 wm4Var, int i) {
        this.a.M(j, j2, j3, wm4Var, i);
    }

    @Override // defpackage.rf0
    public final void Q(p9 p9Var, long j, long j2, long j3, float f, nl nlVar, int i) {
        this.a.Q(p9Var, j, j2, j3, f, nlVar, i);
    }

    @Override // defpackage.jc0
    public final int R(float f) {
        return this.a.R(f);
    }

    @Override // defpackage.rf0
    public final long X() {
        return this.a.X();
    }

    public final void a() {
        ew ewVar = this.a;
        cw cwVarM = ewVar.b.m();
        xb0 xb0Var = this.b;
        if (xb0Var == null) {
            throw cq.e("Attempting to drawContent for a `null` node. This usually means that a call to ContentDrawScope#drawContent() has been captured inside a lambda, and is being invoked outside of the draw pass. Capturing the scope this way is unsupported - if you are trying to record drawContent with graphicsLayer.record(), make sure you are using the GraphicsLayer#record function within DrawScope, instead of the member function on GraphicsLayer.");
        }
        dk1 dk1Var = (dk1) xb0Var;
        dk1 dk1VarB = dk1Var.a.i;
        if (dk1VarB != null && (dk1VarB.e & 4) != 0) {
            while (true) {
                if (dk1VarB != null) {
                    int i = dk1VarB.c;
                    if ((i & 2) == 0) {
                        if ((i & 4) != 0) {
                            break;
                        } else {
                            dk1VarB = dk1VarB.i;
                        }
                    }
                }
                dk1VarB = null;
                break;
            }
        } else {
            dk1VarB = null;
            break;
        }
        if (dk1VarB == null) {
            co1 co1VarE = cm4.e(xb0Var, 4);
            if (co1VarE.V0() == dk1Var.a) {
                co1VarE = co1VarE.H;
                co1VarE.getClass();
            }
            co1VarE.k1(cwVarM, (vu0) ewVar.b.c);
            return;
        }
        pm1 pm1Var = null;
        while (dk1VarB != null) {
            if (dk1VarB instanceof qf0) {
                qf0 qf0Var = (qf0) dk1VarB;
                vu0 vu0Var = (vu0) ewVar.b.c;
                co1 co1VarE2 = cm4.e(qf0Var, 4);
                long jA = cp4.a(co1VarE2.c);
                n71 n71Var = co1VarE2.x;
                n71Var.getClass();
                ((r7) q71.a(n71Var)).getSharedDrawScope().d(cwVarM, jA, co1VarE2, qf0Var, vu0Var);
            } else if ((dk1VarB.c & 4) != 0 && (dk1VarB instanceof zb0)) {
                int i2 = 0;
                for (dk1 dk1Var2 = ((zb0) dk1VarB).H; dk1Var2 != null; dk1Var2 = dk1Var2.i) {
                    if ((dk1Var2.c & 4) != 0) {
                        i2++;
                        if (i2 == 1) {
                            dk1VarB = dk1Var2;
                        } else {
                            if (pm1Var == null) {
                                pm1Var = new pm1(new dk1[16]);
                            }
                            if (dk1VarB != null) {
                                pm1Var.b(dk1VarB);
                                dk1VarB = null;
                            }
                            pm1Var.b(dk1Var2);
                        }
                    }
                }
                if (i2 == 1) {
                }
            }
            dk1VarB = cm4.b(pm1Var);
        }
    }

    @Override // defpackage.jc0
    public final long a0(long j) {
        return this.a.a0(j);
    }

    @Override // defpackage.jc0
    public final float b() {
        return this.a.b();
    }

    @Override // defpackage.rf0
    public final long c() {
        return this.a.c();
    }

    public final void d(cw cwVar, long j, co1 co1Var, qf0 qf0Var, vu0 vu0Var) {
        qf0 qf0Var2 = this.b;
        this.b = qf0Var;
        z61 z61Var = co1Var.x.i0;
        ew ewVar = this.a;
        kf kfVar = ewVar.b;
        dw dwVar = ((ew) kfVar.e).a;
        jc0 jc0Var = dwVar.a;
        z61 z61Var2 = dwVar.b;
        cw cwVarM = kfVar.m();
        kf kfVar2 = ewVar.b;
        long jR = kfVar2.r();
        vu0 vu0Var2 = (vu0) kfVar2.c;
        kfVar2.E(co1Var);
        kfVar2.F(z61Var);
        kfVar2.D(cwVar);
        kfVar2.G(j);
        kfVar2.c = vu0Var;
        cwVar.m();
        try {
            qf0Var.N(this);
            cwVar.j();
            kfVar2.E(jc0Var);
            kfVar2.F(z61Var2);
            kfVar2.D(cwVarM);
            kfVar2.G(jR);
            kfVar2.c = vu0Var2;
            this.b = qf0Var2;
        } catch (Throwable th) {
            cwVar.j();
            kfVar2.E(jc0Var);
            kfVar2.F(z61Var2);
            kfVar2.D(cwVarM);
            kfVar2.G(jR);
            kfVar2.c = vu0Var2;
            throw th;
        }
    }

    @Override // defpackage.jc0
    public final float d0(long j) {
        return this.a.d0(j);
    }

    public final void e(hn hnVar, long j, long j2, long j3, float f, wm4 wm4Var) {
        ew ewVar = this.a;
        int i = (int) (j >> 32);
        int i2 = (int) (j & 4294967295L);
        ewVar.a.c.k(Float.intBitsToFloat(i), Float.intBitsToFloat(i2), Float.intBitsToFloat((int) (j2 >> 32)) + Float.intBitsToFloat(i), Float.intBitsToFloat((int) (j2 & 4294967295L)) + Float.intBitsToFloat(i2), Float.intBitsToFloat((int) (j3 >> 32)), Float.intBitsToFloat((int) (j3 & 4294967295L)), ewVar.d(hnVar, wm4Var, f, null, 3, 1));
    }

    @Override // defpackage.rf0
    public final void f0(long j, long j2, long j3, float f) {
        this.a.f0(j, j2, j3, f);
    }

    @Override // defpackage.rf0
    public final void g(na naVar, hn hnVar, float f, wm4 wm4Var, int i) {
        this.a.g(naVar, hnVar, f, wm4Var, i);
    }

    @Override // defpackage.rf0
    public final z61 getLayoutDirection() {
        return this.a.a.b;
    }

    @Override // defpackage.rf0
    public final void j(long j, float f, float f2, long j2, long j3, ks2 ks2Var) {
        this.a.j(j, f, f2, j2, j3, ks2Var);
    }

    @Override // defpackage.jc0
    public final float l() {
        return this.a.l();
    }

    @Override // defpackage.jc0
    public final long l0(float f) {
        return this.a.l0(f);
    }

    @Override // defpackage.rf0
    public final void m0(na naVar, long j, float f, wm4 wm4Var) {
        this.a.m0(naVar, j, f, wm4Var);
    }

    @Override // defpackage.rf0
    public final void p0(long j, long j2, long j3, float f, wm4 wm4Var) {
        this.a.p0(j, j2, j3, f, wm4Var);
    }

    @Override // defpackage.jc0
    public final float r0(int i) {
        return this.a.r0(i);
    }

    @Override // defpackage.jc0
    public final float u0(float f) {
        return f / this.a.b();
    }

    @Override // defpackage.jc0
    public final long v(float f) {
        return this.a.v(f);
    }

    @Override // defpackage.jc0
    public final long w(long j) {
        return this.a.w(j);
    }

    @Override // defpackage.jc0
    public final float x(float f) {
        return this.a.b() * f;
    }

    @Override // defpackage.rf0
    public final void z(hn hnVar, long j, long j2, float f, wm4 wm4Var) {
        this.a.z(hnVar, j, j2, f, wm4Var);
    }
}
