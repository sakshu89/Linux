package defpackage;

import android.graphics.Canvas;
import android.os.Build;
import android.view.ViewParent;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class co1 extends mf1 implements jh1, y61, jt1 {
    public static final r72 v0 = new r72();
    public static final v61 w0 = new v61();
    public static final float[] x0 = ih1.a();
    public static final nr4 y0;
    public static final qs4 z0;
    public co1 H;
    public co1 X;
    public boolean Y;
    public boolean Z;
    public hq0 c0;
    public jc0 d0;
    public z61 e0;
    public ph1 g0;
    public ul1 h0;
    public float j0;
    public fm1 k0;
    public v61 l0;
    public boolean n0;
    public boolean o0;
    public vu0 p0;
    public cw q0;
    public i8 r0;
    public boolean t0;
    public ht1 u0;
    public final n71 x;
    public float f0 = 0.8f;
    public long i0 = 0;
    public yj2 m0 = y34.a;
    public final bo1 s0 = new bo1(this, 1);

    static {
        int i = 15;
        y0 = new nr4(i);
        z0 = new qs4(i);
    }

    public co1(n71 n71Var) {
        this.x = n71Var;
        this.d0 = n71Var.h0;
        this.e0 = n71Var.i0;
    }

    public static co1 p1(y61 y61Var) {
        co1 co1Var;
        pf1 pf1Var = y61Var instanceof pf1 ? (pf1) y61Var : null;
        if (pf1Var != null && (co1Var = pf1Var.a.x) != null) {
            return co1Var;
        }
        y61Var.getClass();
        return (co1) y61Var;
    }

    @Override // defpackage.y61
    public final long A(long j) {
        if (!V0().w) {
            z01.b("LayoutCoordinate operations are only valid when isAttached is true");
        }
        return H(pp4.c(this), ((r7) q71.a(this.x)).B(j));
    }

    @Override // defpackage.y61
    public final boolean B() {
        return V0().w;
    }

    @Override // defpackage.mf1
    public final boolean B0() {
        return this.g0 != null;
    }

    @Override // defpackage.mf1
    public final n71 C0() {
        return this.x;
    }

    @Override // defpackage.y61
    public final void D(float[] fArr) {
        it1 it1VarA = q71.a(this.x);
        co1 co1VarP1 = p1(pp4.c(this));
        s1(co1VarP1, fArr);
        if (it1VarA instanceof r7) {
            ((r7) it1VarA).o(fArr);
            return;
        }
        long jA = co1VarP1.a(0L);
        if ((9223372034707292159L & jA) != 9205357640488583168L) {
            ih1.f(fArr, Float.intBitsToFloat((int) (jA >> 32)), Float.intBitsToFloat((int) (jA & 4294967295L)));
        }
    }

    @Override // defpackage.mf1
    public final ph1 D0() {
        ph1 ph1Var = this.g0;
        if (ph1Var != null) {
            return ph1Var;
        }
        og.n("Asking for measurement result of unmeasured layout modifier");
        return null;
    }

    @Override // defpackage.mf1
    public final mf1 E0() {
        return this.X;
    }

    @Override // defpackage.mf1
    public final long F0() {
        return this.i0;
    }

    @Override // defpackage.y61
    public final long H(y61 y61Var, long j) {
        if (y61Var instanceof pf1) {
            pf1 pf1Var = (pf1) y61Var;
            pf1Var.a.x.e1();
            return pf1Var.H(this, j ^ (-9223372034707292160L)) ^ (-9223372034707292160L);
        }
        co1 co1VarP1 = p1(y61Var);
        co1VarP1.e1();
        co1 co1VarR0 = R0(co1VarP1);
        while (co1VarP1 != co1VarR0) {
            ht1 ht1Var = co1VarP1.u0;
            if (ht1Var != null) {
                yu0 yu0Var = (yu0) ht1Var;
                float[] fArrB = yu0Var.b();
                if (!yu0Var.Z) {
                    j = ih1.b(j, fArrB);
                }
            }
            j = ap4.a(j, co1VarP1.i0);
            co1VarP1 = co1VarP1.X;
            co1VarP1.getClass();
        }
        return L0(co1VarR0, j);
    }

    @Override // defpackage.y61
    public final void J(y61 y61Var, float[] fArr) {
        co1 co1VarP1 = p1(y61Var);
        co1VarP1.e1();
        co1 co1VarR0 = R0(co1VarP1);
        ih1.d(fArr);
        co1VarP1.s1(co1VarR0, fArr);
        r1(co1VarR0, fArr);
    }

    @Override // defpackage.mf1
    public final void J0() {
        n0(this.i0, this.j0, this.c0);
    }

    public final void K0(co1 co1Var, fm1 fm1Var, boolean z) {
        if (co1Var == this) {
            return;
        }
        co1 co1Var2 = this.X;
        if (co1Var2 != null) {
            co1Var2.K0(co1Var, fm1Var, z);
        }
        long j = this.i0;
        float f = (int) (j >> 32);
        fm1Var.b -= f;
        fm1Var.d -= f;
        float f2 = (int) (j & 4294967295L);
        fm1Var.c -= f2;
        fm1Var.e -= f2;
        ht1 ht1Var = this.u0;
        if (ht1Var != null) {
            yu0 yu0Var = (yu0) ht1Var;
            float[] fArrA = yu0Var.a();
            if (!yu0Var.Z) {
                if (fArrA == null) {
                    fm1Var.b = 0.0f;
                    fm1Var.c = 0.0f;
                    fm1Var.d = 0.0f;
                    fm1Var.e = 0.0f;
                } else {
                    ih1.c(fArrA, fm1Var);
                }
            }
            if (this.Z && z) {
                long j2 = this.c;
                fm1Var.e(0.0f, 0.0f, (int) (j2 >> 32), (int) (j2 & 4294967295L));
            }
        }
    }

    public final long L0(co1 co1Var, long j) {
        if (co1Var == this) {
            return j;
        }
        co1 co1Var2 = this.X;
        return (co1Var2 == null || g31.a(co1Var, co1Var2)) ? S0(j) : S0(co1Var2.L0(co1Var, j));
    }

    public final long M0(long j) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j >> 32)) - i0();
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j & 4294967295L)) - h0();
        return (((long) Float.floatToRawIntBits(Math.max(0.0f, fIntBitsToFloat / 2.0f))) << 32) | (((long) Float.floatToRawIntBits(Math.max(0.0f, fIntBitsToFloat2 / 2.0f))) & 4294967295L);
    }

    @Override // defpackage.y61
    public final l42 N(y61 y61Var, boolean z) {
        if (!V0().w) {
            z01.b("LayoutCoordinate operations are only valid when isAttached is true");
        }
        if (!y61Var.B()) {
            z01.b("LayoutCoordinates " + y61Var + " is not attached!");
        }
        co1 co1VarP1 = p1(y61Var);
        co1VarP1.e1();
        co1 co1VarR0 = R0(co1VarP1);
        fm1 fm1Var = this.k0;
        if (fm1Var == null) {
            fm1Var = new fm1();
            this.k0 = fm1Var;
        }
        fm1Var.b = 0.0f;
        fm1Var.c = 0.0f;
        fm1Var.d = (int) (y61Var.S() >> 32);
        fm1Var.e = (int) (y61Var.S() & 4294967295L);
        while (co1VarP1 != co1VarR0) {
            co1VarP1.m1(fm1Var, z, false);
            if (fm1Var.f()) {
                return l42.e;
            }
            co1VarP1 = co1VarP1.X;
            co1VarP1.getClass();
        }
        K0(co1VarR0, fm1Var, z);
        return new l42(fm1Var.b, fm1Var.c, fm1Var.d, fm1Var.e);
    }

    public final float N0(long j, long j2) {
        if (i0() >= Float.intBitsToFloat((int) (j2 >> 32)) && h0() >= Float.intBitsToFloat((int) (j2 & 4294967295L))) {
            return Float.POSITIVE_INFINITY;
        }
        long jM0 = M0(j2);
        float fIntBitsToFloat = Float.intBitsToFloat((int) (jM0 >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (jM0 & 4294967295L));
        float fIntBitsToFloat3 = Float.intBitsToFloat((int) (j >> 32));
        float fMax = Math.max(0.0f, fIntBitsToFloat3 < 0.0f ? -fIntBitsToFloat3 : fIntBitsToFloat3 - i0());
        float fIntBitsToFloat4 = Float.intBitsToFloat((int) (j & 4294967295L));
        long jFloatToRawIntBits = (((long) Float.floatToRawIntBits(fMax)) << 32) | (((long) Float.floatToRawIntBits(Math.max(0.0f, fIntBitsToFloat4 < 0.0f ? -fIntBitsToFloat4 : fIntBitsToFloat4 - h0()))) & 4294967295L);
        if (fIntBitsToFloat > 0.0f || fIntBitsToFloat2 > 0.0f) {
            int i = (int) (jFloatToRawIntBits >> 32);
            if (Float.intBitsToFloat(i) <= fIntBitsToFloat) {
                int i2 = (int) (jFloatToRawIntBits & 4294967295L);
                if (Float.intBitsToFloat(i2) <= fIntBitsToFloat2) {
                    float fIntBitsToFloat5 = Float.intBitsToFloat(i);
                    float fIntBitsToFloat6 = Float.intBitsToFloat(i2);
                    return (fIntBitsToFloat6 * fIntBitsToFloat6) + (fIntBitsToFloat5 * fIntBitsToFloat5);
                }
            }
        }
        return Float.POSITIVE_INFINITY;
    }

    public final void O0(cw cwVar, vu0 vu0Var) {
        float f;
        ht1 ht1Var = this.u0;
        if (ht1Var == null) {
            long j = this.i0;
            float f2 = (int) (j >> 32);
            float f3 = (int) (j & 4294967295L);
            cwVar.g(f2, f3);
            P0(cwVar, vu0Var);
            cwVar.g(-f2, -f3);
            return;
        }
        yu0 yu0Var = (yu0) ht1Var;
        ew ewVar = yu0Var.v;
        yu0Var.g();
        boolean z = false;
        yu0Var.c0 = yu0Var.a.a.G() > 0.0f;
        kf kfVar = ewVar.b;
        kfVar.D(cwVar);
        kfVar.c = vu0Var;
        vu0 vu0Var2 = yu0Var.a;
        cw cwVarM = ewVar.C().m();
        vu0 vu0Var3 = (vu0) ewVar.C().c;
        xu0 xu0Var = vu0Var2.a;
        if (vu0Var2.s) {
            return;
        }
        vu0Var2.a();
        if (!xu0Var.H()) {
            try {
                vu0Var2.a.w(vu0Var2.b, vu0Var2.c, vu0Var2, vu0Var2.e);
            } catch (Throwable unused) {
            }
        }
        boolean z2 = xu0Var.G() > 0.0f;
        if (z2) {
            cwVarM.s();
        }
        Canvas canvasA = v6.a(cwVarM);
        boolean zIsHardwareAccelerated = canvasA.isHardwareAccelerated();
        if (!zIsHardwareAccelerated) {
            long j2 = vu0Var2.t;
            float f4 = (int) (j2 >> 32);
            float f5 = (int) (j2 & 4294967295L);
            long j3 = vu0Var2.u;
            float f6 = ((int) (j3 >> 32)) + f4;
            float f7 = f5 + ((int) (j3 & 4294967295L));
            float fA = xu0Var.a();
            nl nlVarX = xu0Var.x();
            int iK = xu0Var.K();
            if (fA < 1.0f || iK != 3 || nlVarX != null || xu0Var.u() == 1) {
                fa faVarA = vu0Var2.p;
                if (faVarA == null) {
                    faVarA = ld4.a();
                    vu0Var2.p = faVarA;
                }
                faVarA.c(fA);
                faVarA.d(iK);
                faVarA.f(nlVarX);
                f = f4;
                canvasA.saveLayer(f, f5, f6, f7, faVarA.a);
            } else {
                canvasA.save();
                f = f4;
            }
            canvasA.translate(f, f5);
            canvasA.concat(xu0Var.C());
        }
        boolean z3 = !zIsHardwareAccelerated && vu0Var2.w;
        if (z3) {
            cwVarM.m();
            es4 es4VarD = vu0Var2.d();
            if (es4VarD instanceof us1) {
                cw.l(cwVarM, ((us1) es4VarD).a);
            } else if (es4VarD instanceof vs1) {
                na naVarA = vu0Var2.m;
                if (naVarA != null) {
                    naVarA.a.rewind();
                } else {
                    naVarA = pa.a();
                    vu0Var2.m = naVarA;
                }
                na.b(naVarA, ((vs1) es4VarD).a);
                cwVarM.t(naVarA);
            } else {
                if (!(es4VarD instanceof ts1)) {
                    dk0.l();
                    return;
                }
                cwVarM.t(((ts1) es4VarD).a);
            }
        }
        if (vu0Var3 != null) {
            ux uxVar = vu0Var3.r;
            if (!uxVar.a) {
                y01.a("Only add dependencies during a tracking");
            }
            hm1 hm1Var = (hm1) uxVar.d;
            if (hm1Var != null) {
                hm1Var.a(vu0Var2);
            } else if (((vu0) uxVar.b) != null) {
                hm1 hm1Var2 = za2.a;
                hm1 hm1Var3 = new hm1();
                vu0 vu0Var4 = (vu0) uxVar.b;
                vu0Var4.getClass();
                hm1Var3.a(vu0Var4);
                hm1Var3.a(vu0Var2);
                uxVar.d = hm1Var3;
                uxVar.b = null;
            } else {
                uxVar.b = vu0Var2;
            }
            hm1 hm1Var4 = (hm1) uxVar.e;
            if (hm1Var4 != null) {
                z = !hm1Var4.l(vu0Var2);
            } else if (((vu0) uxVar.c) != vu0Var2) {
                z = true;
            } else {
                uxVar.c = null;
            }
            if (z) {
                vu0Var2.q++;
            }
        }
        if (((u6) cwVarM).a.isHardwareAccelerated()) {
            xu0Var.s(cwVarM);
        } else {
            ew ewVar2 = vu0Var2.o;
            if (ewVar2 == null) {
                ewVar2 = new ew();
                vu0Var2.o = ewVar2;
            }
            kf kfVar2 = ewVar2.b;
            jc0 jc0Var = vu0Var2.b;
            z61 z61Var = vu0Var2.c;
            long jA = cp4.a(vu0Var2.u);
            dw dwVar = ((ew) kfVar2.e).a;
            jc0 jc0Var2 = dwVar.a;
            z61 z61Var2 = dwVar.b;
            cw cwVarM2 = kfVar2.m();
            long jR = kfVar2.r();
            vu0 vu0Var5 = (vu0) kfVar2.c;
            kfVar2.E(jc0Var);
            kfVar2.F(z61Var);
            kfVar2.D(cwVarM);
            kfVar2.G(jA);
            kfVar2.c = vu0Var2;
            cwVarM.m();
            try {
                vu0Var2.c(ewVar2);
                cwVarM.j();
                kfVar2.E(jc0Var2);
                kfVar2.F(z61Var2);
                kfVar2.D(cwVarM2);
                kfVar2.G(jR);
                kfVar2.c = vu0Var5;
            } catch (Throwable th) {
                cwVarM.j();
                kfVar2.E(jc0Var2);
                kfVar2.F(z61Var2);
                kfVar2.D(cwVarM2);
                kfVar2.G(jR);
                kfVar2.c = vu0Var5;
                throw th;
            }
        }
        if (z3) {
            cwVarM.j();
        }
        if (z2) {
            cwVarM.o();
        }
        if (zIsHardwareAccelerated) {
            return;
        }
        canvasA.restore();
    }

    public final void P0(cw cwVar, vu0 vu0Var) {
        co1 co1Var;
        cw cwVar2;
        vu0 vu0Var2;
        dk1 dk1VarW0 = W0(4);
        if (dk1VarW0 == null) {
            k1(cwVar, vu0Var);
            return;
        }
        n71 n71Var = this.x;
        n71Var.getClass();
        p71 sharedDrawScope = ((r7) q71.a(n71Var)).getSharedDrawScope();
        long jA = cp4.a(this.c);
        sharedDrawScope.getClass();
        pm1 pm1Var = null;
        while (dk1VarW0 != null) {
            if (dk1VarW0 instanceof qf0) {
                co1Var = this;
                cwVar2 = cwVar;
                vu0Var2 = vu0Var;
                sharedDrawScope.d(cwVar2, jA, co1Var, (qf0) dk1VarW0, vu0Var2);
            } else {
                co1Var = this;
                cwVar2 = cwVar;
                vu0Var2 = vu0Var;
                if ((dk1VarW0.c & 4) != 0 && (dk1VarW0 instanceof zb0)) {
                    int i = 0;
                    for (dk1 dk1Var = ((zb0) dk1VarW0).H; dk1Var != null; dk1Var = dk1Var.i) {
                        if ((dk1Var.c & 4) != 0) {
                            i++;
                            if (i == 1) {
                                dk1VarW0 = dk1Var;
                            } else {
                                if (pm1Var == null) {
                                    pm1Var = new pm1(new dk1[16]);
                                }
                                if (dk1VarW0 != null) {
                                    pm1Var.b(dk1VarW0);
                                    dk1VarW0 = null;
                                }
                                pm1Var.b(dk1Var);
                            }
                        }
                    }
                    if (i == 1) {
                    }
                }
                cwVar = cwVar2;
                this = co1Var;
                vu0Var = vu0Var2;
            }
            dk1VarW0 = cm4.b(pm1Var);
            cwVar = cwVar2;
            this = co1Var;
            vu0Var = vu0Var2;
        }
    }

    public abstract void Q0();

    public final co1 R0(co1 co1Var) {
        n71 n71VarU = co1Var.x;
        n71 n71Var = this.x;
        if (n71VarU == n71Var) {
            dk1 dk1VarV0 = co1Var.V0();
            dk1 dk1VarV1 = V0();
            if (!dk1VarV1.a.w) {
                z01.b("visitLocalAncestors called on an unattached node");
            }
            for (dk1 dk1Var = dk1VarV1.a.f; dk1Var != null; dk1Var = dk1Var.f) {
                if ((dk1Var.c & 2) != 0 && dk1Var == dk1VarV0) {
                    return co1Var;
                }
            }
            return this;
        }
        while (n71VarU.H > n71Var.H) {
            n71VarU = n71VarU.u();
            n71VarU.getClass();
        }
        n71 n71VarU2 = n71Var;
        while (n71VarU2.H > n71VarU.H) {
            n71VarU2 = n71VarU2.u();
            n71VarU2.getClass();
        }
        while (n71VarU != n71VarU2) {
            n71VarU = n71VarU.u();
            n71VarU2 = n71VarU2.u();
            if (n71VarU == null || n71VarU2 == null) {
                og.i("layouts are not part of the same hierarchy");
                return null;
            }
        }
        if (n71VarU2 != n71Var) {
            if (n71VarU != co1Var.x) {
                return n71VarU.o0.c;
            }
            return co1Var;
        }
        return this;
    }

    @Override // defpackage.y61
    public final long S() {
        return this.c;
    }

    public final long S0(long j) {
        long j2 = this.i0;
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j >> 32)) - ((int) (j2 >> 32));
        long jFloatToRawIntBits = (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (j & 4294967295L)) - ((int) (j2 & 4294967295L)))) & 4294967295L) | (Float.floatToRawIntBits(fIntBitsToFloat) << 32);
        ht1 ht1Var = this.u0;
        if (ht1Var != null) {
            yu0 yu0Var = (yu0) ht1Var;
            float[] fArrA = yu0Var.a();
            if (fArrA == null) {
                return 9187343241974906880L;
            }
            if (!yu0Var.Z) {
                return ih1.b(jFloatToRawIntBits, fArrA);
            }
        }
        return jFloatToRawIntBits;
    }

    public abstract of1 T0();

    @Override // defpackage.y61
    public final long U(long j) {
        if (!V0().w) {
            z01.b("LayoutCoordinate operations are only valid when isAttached is true");
        }
        e1();
        while (this != null) {
            n71 n71Var = this.x;
            if (this == n71Var.o0.d && !n71Var.c) {
                long jB = ((r7) q71.a(n71Var)).getRectManager().b(n71Var);
                if (!e21.a(jB, 9223372034707292159L)) {
                    return ap4.a(j, jB);
                }
            }
            ht1 ht1Var = this.u0;
            if (ht1Var != null) {
                yu0 yu0Var = (yu0) ht1Var;
                float[] fArrB = yu0Var.b();
                if (!yu0Var.Z) {
                    j = ih1.b(j, fArrB);
                }
            }
            j = ap4.a(j, this.i0);
            this = this.X;
        }
        return j;
    }

    public final long U0() {
        return this.d0.a0(this.x.j0.g());
    }

    public abstract dk1 V0();

    public final dk1 W0(int i) {
        boolean zG = do1.g(i);
        dk1 dk1VarV0 = V0();
        if (!zG && (dk1VarV0 = dk1VarV0.f) == null) {
            return null;
        }
        for (dk1 dk1VarX0 = X0(zG); dk1VarX0 != null && (dk1VarX0.e & i) != 0; dk1VarX0 = dk1VarX0.i) {
            if ((dk1VarX0.c & i) != 0) {
                return dk1VarX0;
            }
            if (dk1VarX0 == dk1VarV0) {
                return null;
            }
        }
        return null;
    }

    public final dk1 X0(boolean z) {
        dk1 dk1VarV0;
        zn1 zn1Var = this.x.o0;
        if (zn1Var.d == this) {
            return zn1Var.f;
        }
        co1 co1Var = this.X;
        if (!z) {
            if (co1Var != null) {
                return co1Var.V0();
            }
            return null;
        }
        if (co1Var == null || (dk1VarV0 = co1Var.V0()) == null) {
            return null;
        }
        return dk1VarV0.i;
    }

    public final void Y0(dk1 dk1Var, ao1 ao1Var, long j, pw0 pw0Var, int i, boolean z) {
        if (dk1Var == null) {
            b1(ao1Var, j, pw0Var, i, z);
            return;
        }
        int i2 = pw0Var.c;
        yl1 yl1Var = pw0Var.a;
        pw0Var.b(i2 + 1, yl1Var.b);
        pw0Var.c++;
        yl1Var.a(dk1Var);
        pw0Var.b.a(mo4.a(-1.0f, z, false));
        Y0(rr4.a(dk1Var, ao1Var.d()), ao1Var, j, pw0Var, i, z);
        pw0Var.c = i2;
    }

    public final void Z0(dk1 dk1Var, ao1 ao1Var, long j, pw0 pw0Var, int i, boolean z, float f) {
        if (dk1Var == null) {
            b1(ao1Var, j, pw0Var, i, z);
            return;
        }
        int i2 = pw0Var.c;
        yl1 yl1Var = pw0Var.a;
        pw0Var.b(i2 + 1, yl1Var.b);
        pw0Var.c++;
        yl1Var.a(dk1Var);
        pw0Var.b.a(mo4.a(f, z, false));
        j1(rr4.a(dk1Var, ao1Var.d()), ao1Var, j, pw0Var, i, z, f, true);
        pw0Var.c = i2;
    }

    @Override // defpackage.y61
    public final long a(long j) {
        if (!V0().w) {
            z01.b("LayoutCoordinate operations are only valid when isAttached is true");
        }
        return ((r7) q71.a(this.x)).p(U(j));
    }

    public final void a1(ao1 ao1Var, long j, pw0 pw0Var, int i, boolean z) {
        boolean z2;
        boolean z3;
        dk1 dk1VarW0 = W0(ao1Var.d());
        if (!v1(j)) {
            if (i == 1) {
                float fN0 = N0(j, U0());
                if ((Float.floatToRawIntBits(fN0) & Integer.MAX_VALUE) < 2139095040) {
                    if (pw0Var.c != pw0Var.a.b - 1) {
                        if (hm4.a(pw0Var.a(), mo4.a(fN0, false, false)) <= 0) {
                            return;
                        }
                    }
                    Z0(dk1VarW0, ao1Var, j, pw0Var, i, false, fN0);
                    return;
                }
                return;
            }
            return;
        }
        if (dk1VarW0 == null) {
            b1(ao1Var, j, pw0Var, i, z);
            return;
        }
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j & 4294967295L));
        if (fIntBitsToFloat >= 0.0f && fIntBitsToFloat2 >= 0.0f && fIntBitsToFloat < i0() && fIntBitsToFloat2 < h0()) {
            Y0(dk1VarW0, ao1Var, j, pw0Var, i, z);
            return;
        }
        float fN1 = i == 1 ? N0(j, U0()) : Float.POSITIVE_INFINITY;
        if ((Float.floatToRawIntBits(fN1) & Integer.MAX_VALUE) < 2139095040) {
            if (pw0Var.c != pw0Var.a.b - 1) {
                z2 = z;
                if (hm4.a(pw0Var.a(), mo4.a(fN1, z2, false)) > 0) {
                }
                j1(dk1VarW0, ao1Var, j, pw0Var, i, z2, fN1, z3);
            }
            z2 = z;
            z3 = true;
            j1(dk1VarW0, ao1Var, j, pw0Var, i, z2, fN1, z3);
        }
        z2 = z;
        z3 = false;
        j1(dk1VarW0, ao1Var, j, pw0Var, i, z2, fN1, z3);
    }

    @Override // defpackage.jc0
    public final float b() {
        return this.x.h0.b();
    }

    public void b1(ao1 ao1Var, long j, pw0 pw0Var, int i, boolean z) {
        co1 co1Var = this.H;
        if (co1Var != null) {
            co1Var.a1(ao1Var, co1Var.S0(j), pw0Var, i, z);
        }
    }

    public final void c1() {
        ht1 ht1Var = this.u0;
        if (ht1Var != null) {
            ((yu0) ht1Var).c();
            return;
        }
        co1 co1Var = this.X;
        if (co1Var != null) {
            co1Var.c1();
        }
    }

    public final boolean d1() {
        if (this.u0 != null && this.f0 <= 0.0f) {
            return true;
        }
        co1 co1Var = this.X;
        if (co1Var != null) {
            return co1Var.d1();
        }
        return false;
    }

    public final void e1() {
        this.x.p0.b();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v13 */
    /* JADX WARN: Type inference failed for: r7v14 */
    /* JADX WARN: Type inference failed for: r7v15 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5, types: [dk1] */
    /* JADX WARN: Type inference failed for: r7v7, types: [dk1] */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Type inference failed for: r7v9, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v2, types: [pm1] */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v6, types: [pm1] */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference failed for: r8v9 */
    /* JADX WARN: Type inference failed for: r9v5 */
    public final void f1() {
        dk1 dk1VarV0;
        boolean zG = do1.g(128);
        dk1 dk1VarX0 = X0(zG);
        if (dk1VarX0 == null || (dk1VarX0.a.e & 128) == 0) {
            return;
        }
        bm2 bm2VarA = i44.a();
        hq0 hq0VarE = bm2VarA != null ? bm2VarA.e() : null;
        bm2 bm2VarB = i44.b(bm2VarA);
        try {
            if (!zG) {
                dk1VarV0 = V0().f;
                if (dk1VarV0 == null) {
                }
                i44.e(bm2VarA, bm2VarB, hq0VarE);
            }
            dk1VarV0 = V0();
            for (dk1 dk1VarX1 = X0(zG); dk1VarX1 != null && (dk1VarX1.e & 128) != 0; dk1VarX1 = dk1VarX1.i) {
                if ((dk1VarX1.c & 128) != 0) {
                    ?? B = dk1VarX1;
                    ?? pm1Var = 0;
                    while (B != 0) {
                        if (B instanceof w61) {
                            ((w61) B).r(this.c);
                        } else if ((B.c & 128) != 0 && (B instanceof zb0)) {
                            dk1 dk1Var = ((zb0) B).H;
                            int i = 0;
                            B = B;
                            pm1Var = pm1Var;
                            while (dk1Var != null) {
                                if ((dk1Var.c & 128) != 0) {
                                    i++;
                                    pm1Var = pm1Var;
                                    if (i == 1) {
                                        B = dk1Var;
                                    } else {
                                        if (pm1Var == 0) {
                                            pm1Var = new pm1(new dk1[16]);
                                        }
                                        if (B != 0) {
                                            pm1Var.b(B);
                                            B = 0;
                                        }
                                        pm1Var.b(dk1Var);
                                    }
                                }
                                dk1Var = dk1Var.i;
                                B = B;
                                pm1Var = pm1Var;
                            }
                            if (i == 1) {
                            }
                        }
                        B = cm4.b(pm1Var);
                    }
                }
                if (dk1VarX1 == dk1VarV0) {
                    break;
                }
            }
            i44.e(bm2VarA, bm2VarB, hq0VarE);
        } catch (Throwable th) {
            i44.e(bm2VarA, bm2VarB, hq0VarE);
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1, types: [dk1] */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4, types: [dk1] */
    /* JADX WARN: Type inference failed for: r4v5, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3, types: [pm1] */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6, types: [pm1] */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9 */
    /* JADX WARN: Type inference failed for: r6v4 */
    public final void g1() {
        boolean zG = do1.g(4194304);
        dk1 dk1VarV0 = V0();
        if (!zG && (dk1VarV0 = dk1VarV0.f) == null) {
            return;
        }
        for (dk1 dk1VarX0 = X0(zG); dk1VarX0 != null && (dk1VarX0.e & 4194304) != 0; dk1VarX0 = dk1VarX0.i) {
            if ((dk1VarX0.c & 4194304) != 0) {
                ?? B = dk1VarX0;
                ?? pm1Var = 0;
                while (B != 0) {
                    if (B instanceof w61) {
                        ((w61) B).o(this);
                    } else if ((B.c & 4194304) != 0 && (B instanceof zb0)) {
                        dk1 dk1Var = ((zb0) B).H;
                        int i = 0;
                        B = B;
                        pm1Var = pm1Var;
                        while (dk1Var != null) {
                            if ((dk1Var.c & 4194304) != 0) {
                                i++;
                                pm1Var = pm1Var;
                                if (i == 1) {
                                    B = dk1Var;
                                } else {
                                    if (pm1Var == 0) {
                                        pm1Var = new pm1(new dk1[16]);
                                    }
                                    if (B != 0) {
                                        pm1Var.b(B);
                                        B = 0;
                                    }
                                    pm1Var.b(dk1Var);
                                }
                            }
                            dk1Var = dk1Var.i;
                            B = B;
                            pm1Var = pm1Var;
                        }
                        if (i == 1) {
                        }
                    }
                    B = cm4.b(pm1Var);
                }
            }
            if (dk1VarX0 == dk1VarV0) {
                return;
            }
        }
    }

    @Override // defpackage.z21
    public final z61 getLayoutDirection() {
        return this.x.i0;
    }

    @Override // defpackage.y61
    public final long h(long j) {
        if (!V0().w) {
            z01.b("LayoutCoordinate operations are only valid when isAttached is true");
        }
        y61 y61VarC = pp4.c(this);
        r7 r7Var = (r7) q71.a(this.x);
        r7Var.x();
        return H(y61VarC, jp1.d(ih1.b(j, r7Var.K0), y61VarC.U(0L)));
    }

    public final void h1() {
        this.Y = true;
        this.s0.a();
        n1();
        if (e21.a(this.i0, 0L)) {
            return;
        }
        this.x.N();
    }

    @Override // defpackage.y61
    public final long i(long j) {
        long jU = U(j);
        r7 r7Var = (r7) q71.a(this.x);
        r7Var.x();
        return ih1.b(jU, r7Var.J0);
    }

    public final void i1() {
        boolean zG = do1.g(1048576);
        dk1 dk1VarX0 = X0(zG);
        if (dk1VarX0 == null || (dk1VarX0.a.e & 1048576) == 0) {
            return;
        }
        dk1 dk1VarV0 = V0();
        if (!zG && (dk1VarV0 = dk1VarV0.f) == null) {
            return;
        }
        for (dk1 dk1VarX1 = X0(zG); dk1VarX1 != null && (dk1VarX1.e & 1048576) != 0; dk1VarX1 = dk1VarX1.i) {
            if ((dk1VarX1.c & 1048576) != 0) {
                dk1 dk1VarB = dk1VarX1;
                pm1 pm1Var = null;
                while (dk1VarB != null) {
                    if ((dk1VarB.c & 1048576) != 0 && (dk1VarB instanceof zb0)) {
                        int i = 0;
                        for (dk1 dk1Var = ((zb0) dk1VarB).H; dk1Var != null; dk1Var = dk1Var.i) {
                            if ((dk1Var.c & 1048576) != 0) {
                                i++;
                                if (i == 1) {
                                    dk1VarB = dk1Var;
                                } else {
                                    if (pm1Var == null) {
                                        pm1Var = new pm1(new dk1[16]);
                                    }
                                    if (dk1VarB != null) {
                                        pm1Var.b(dk1VarB);
                                        dk1VarB = null;
                                    }
                                    pm1Var.b(dk1Var);
                                }
                            }
                        }
                        if (i == 1) {
                        }
                    }
                    dk1VarB = cm4.b(pm1Var);
                }
            }
            if (dk1VarX1 == dk1VarV0) {
                return;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:69:0x01af A[PHI: r8
      0x01af: PHI (r8v14 ??) = (r8v1 ??), (r8v1 ??), (r8v16 ??) binds: [B:51:0x017a, B:53:0x017e, B:67:0x01a8] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1, types: [dk1] */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v21 */
    /* JADX WARN: Type inference failed for: r4v22 */
    /* JADX WARN: Type inference failed for: r4v23 */
    /* JADX WARN: Type inference failed for: r4v7, types: [dk1] */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v9 */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v14, types: [pm1] */
    /* JADX WARN: Type inference failed for: r8v15 */
    /* JADX WARN: Type inference failed for: r8v16 */
    /* JADX WARN: Type inference failed for: r8v17 */
    /* JADX WARN: Type inference failed for: r8v18, types: [pm1] */
    /* JADX WARN: Type inference failed for: r8v23 */
    /* JADX WARN: Type inference failed for: r8v24 */
    /* JADX WARN: Type inference failed for: r8v25 */
    /* JADX WARN: Type inference failed for: r8v26 */
    /* JADX WARN: Type inference failed for: r8v27 */
    public final void j1(dk1 dk1Var, ao1 ao1Var, long j, pw0 pw0Var, int i, boolean z, float f, boolean z2) {
        ?? B;
        int i2;
        if (dk1Var == null) {
            b1(ao1Var, j, pw0Var, i, z);
            return;
        }
        int i3 = i;
        char c = 3;
        if (i3 == 3 || i3 == 4) {
            ?? r4 = dk1Var;
            ?? pm1Var = 0;
            while (r4 != 0) {
                if (r4 instanceof qy1) {
                    long jQ = ((qy1) r4).q();
                    int i4 = (int) (j >> 32);
                    float fIntBitsToFloat = Float.intBitsToFloat(i4);
                    n71 n71Var = this.x;
                    z61 z61Var = n71Var.i0;
                    int i5 = q13.b;
                    long j2 = Long.MIN_VALUE & jQ;
                    z61 z61Var2 = z61.a;
                    if (fIntBitsToFloat < (-((j2 == 0 || z61Var == z61Var2) ? xy.m(0, jQ) : xy.m(2, jQ)))) {
                        break;
                    }
                    if (Float.intBitsToFloat(i4) >= i0() + ((j2 == 0 || n71Var.i0 == z61Var2) ? xy.m(2, jQ) : xy.m(0, jQ))) {
                        break;
                    }
                    int i6 = (int) (j & 4294967295L);
                    float fIntBitsToFloat2 = Float.intBitsToFloat(i6);
                    int i7 = q13.b;
                    if (fIntBitsToFloat2 < (-xy.m(1, jQ))) {
                        break;
                    }
                    if (Float.intBitsToFloat(i6) >= xy.m(3, jQ) + h0()) {
                        break;
                    }
                    ql1 ql1Var = pw0Var.b;
                    yl1 yl1Var = pw0Var.a;
                    int i8 = pw0Var.c;
                    int i9 = yl1Var.b;
                    if (i8 == i9 - 1) {
                        pw0Var.b(i8 + 1, i9);
                        pw0Var.c++;
                        yl1Var.a(dk1Var);
                        ql1Var.a(mo4.a(0.0f, z, true));
                        j1(rr4.a(dk1Var, ao1Var.d()), ao1Var, j, pw0Var, i3, z, f, z2);
                        pw0Var.c = i8;
                        return;
                    }
                    long jA = pw0Var.a();
                    int i10 = pw0Var.c;
                    if (!hm4.c(jA)) {
                        if (hm4.b(jA) > 0.0f) {
                            int i11 = pw0Var.c;
                            pw0Var.b(i11 + 1, yl1Var.b);
                            pw0Var.c++;
                            yl1Var.a(dk1Var);
                            ql1Var.a(mo4.a(0.0f, z, true));
                            j1(rr4.a(dk1Var, ao1Var.d()), ao1Var, j, pw0Var, i, z, f, z2);
                            pw0Var.c = i11;
                            return;
                        }
                        return;
                    }
                    int i12 = yl1Var.b;
                    int i13 = i12 - 1;
                    pw0Var.c = i13;
                    pw0Var.b(i12, yl1Var.b);
                    pw0Var.c++;
                    yl1Var.a(dk1Var);
                    ql1Var.a(mo4.a(0.0f, z, true));
                    j1(rr4.a(dk1Var, ao1Var.d()), ao1Var, j, pw0Var, i, z, f, z2);
                    pw0Var.c = i13;
                    if (hm4.b(pw0Var.a()) < 0.0f) {
                        pw0Var.b(i10 + 1, pw0Var.c + 1);
                    }
                    pw0Var.c = i10;
                    return;
                }
                char c2 = c;
                if ((r4.c & 16) == 0 || !(r4 instanceof zb0)) {
                    B = cm4.b(pm1Var);
                } else {
                    dk1 dk1Var2 = ((zb0) r4).H;
                    int i14 = 0;
                    B = r4;
                    pm1Var = pm1Var;
                    while (dk1Var2 != null) {
                        if ((dk1Var2.c & 16) != 0) {
                            i14++;
                            pm1Var = pm1Var;
                            if (i14 == 1) {
                                B = dk1Var2;
                            } else {
                                if (pm1Var == 0) {
                                    pm1Var = new pm1(new dk1[16]);
                                }
                                if (B != 0) {
                                    pm1Var.b(B);
                                    B = 0;
                                }
                                pm1Var.b(dk1Var2);
                            }
                        }
                        dk1Var2 = dk1Var2.i;
                        B = B;
                        pm1Var = pm1Var;
                    }
                    if (i14 != 1) {
                        B = cm4.b(pm1Var);
                    }
                }
                i3 = i;
                c = c2;
                r4 = B;
                pm1Var = pm1Var;
            }
        }
        if (z2) {
            Z0(dk1Var, ao1Var, j, pw0Var, i, z, f);
            return;
        }
        if (!ao1Var.a(dk1Var)) {
            j1(rr4.a(dk1Var, ao1Var.d()), ao1Var, j, pw0Var, i, z, f, false);
            return;
        }
        ql1 ql1Var2 = pw0Var.b;
        yl1 yl1Var2 = pw0Var.a;
        int i15 = pw0Var.c;
        int i16 = yl1Var2.b;
        if (i15 != i16 - 1) {
            long jA2 = pw0Var.a();
            int i17 = pw0Var.c;
            int i18 = yl1Var2.b;
            int i19 = i18 - 1;
            pw0Var.c = i19;
            pw0Var.b(i18, yl1Var2.b);
            pw0Var.c++;
            yl1Var2.a(dk1Var);
            ql1Var2.a(mo4.a(f, z, false));
            j1(rr4.a(dk1Var, ao1Var.d()), ao1Var, j, pw0Var, i, z, f, false);
            pw0Var.c = i19;
            long jA3 = pw0Var.a();
            if (pw0Var.c + 1 >= yl1Var2.b - 1 || hm4.a(jA2, jA3) <= 0) {
                pw0Var.b(pw0Var.c + 1, yl1Var2.b);
            } else {
                int i20 = i17 + 1;
                boolean zC = hm4.c(jA3);
                int i21 = pw0Var.c;
                pw0Var.b(i20, zC ? i21 + 2 : i21 + 1);
            }
            pw0Var.c = i17;
            return;
        }
        int i22 = i15 + 1;
        pw0Var.b(i22, i16);
        pw0Var.c++;
        yl1Var2.a(dk1Var);
        ql1Var2.a(mo4.a(f, z, false));
        j1(rr4.a(dk1Var, ao1Var.d()), ao1Var, j, pw0Var, i, z, f, false);
        pw0Var.c = i15;
        if (i22 == yl1Var2.b - 1 || hm4.c(pw0Var.a())) {
            int i23 = pw0Var.c;
            int i24 = i23 + 1;
            yl1Var2.k(i24);
            if (i24 < 0 || i24 >= (i2 = ql1Var2.b)) {
                og.o("Index must be between 0 and size");
                return;
            }
            long[] jArr = ql1Var2.a;
            long j3 = jArr[i24];
            if (i24 != i2 - 1) {
                qg.f(jArr, jArr, i24, i23 + 2, i2);
            }
            ql1Var2.b--;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5, types: [dk1] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8, types: [dk1] */
    /* JADX WARN: Type inference failed for: r1v9, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3, types: [pm1] */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6, types: [pm1] */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /* JADX WARN: Type inference failed for: r5v4 */
    @Override // defpackage.zw1, defpackage.jh1
    public final Object k() {
        n71 n71Var = this.x;
        if (!n71Var.o0.d(64)) {
            return null;
        }
        V0();
        Object objN0 = null;
        for (dk1 dk1Var = n71Var.o0.e; dk1Var != null; dk1Var = dk1Var.f) {
            if ((dk1Var.c & 64) != 0) {
                ?? B = dk1Var;
                ?? pm1Var = 0;
                while (B != 0) {
                    if (B instanceof lu1) {
                        objN0 = ((lu1) B).n0(objN0);
                    } else if ((B.c & 64) != 0 && (B instanceof zb0)) {
                        dk1 dk1Var2 = ((zb0) B).H;
                        int i = 0;
                        B = B;
                        pm1Var = pm1Var;
                        while (dk1Var2 != null) {
                            if ((dk1Var2.c & 64) != 0) {
                                i++;
                                pm1Var = pm1Var;
                                if (i == 1) {
                                    B = dk1Var2;
                                } else {
                                    if (pm1Var == 0) {
                                        pm1Var = new pm1(new dk1[16]);
                                    }
                                    if (B != 0) {
                                        pm1Var.b(B);
                                        B = 0;
                                    }
                                    pm1Var.b(dk1Var2);
                                }
                            }
                            dk1Var2 = dk1Var2.i;
                            B = B;
                            pm1Var = pm1Var;
                        }
                        if (i == 1) {
                        }
                    }
                    B = cm4.b(pm1Var);
                }
            }
        }
        return objN0;
    }

    public abstract void k1(cw cwVar, vu0 vu0Var);

    @Override // defpackage.jc0
    public final float l() {
        return this.x.h0.l();
    }

    public final void l1(long j, float f, hq0 hq0Var) {
        t1(hq0Var, false);
        boolean zA = e21.a(this.i0, j);
        n71 n71Var = this.x;
        if (!zA) {
            ((r7) q71.a(n71Var)).H(-4.0f);
            this.i0 = j;
            n71Var.p0.p.x0();
            ht1 ht1Var = this.u0;
            if (ht1Var != null) {
                ((yu0) ht1Var).d(j);
            } else {
                co1 co1Var = this.X;
                if (co1Var != null) {
                    co1Var.c1();
                }
            }
            n71Var.N();
            mf1.H0(this);
            it1 it1Var = n71Var.x;
            if (it1Var != null) {
                ((r7) it1Var).t(n71Var);
            }
        }
        this.j0 = f;
        if (this == n71Var.o0.d) {
            ((r7) q71.a(n71Var)).getRectManager().f(n71Var, false);
        }
        if (this.t) {
            return;
        }
        x0(D0());
    }

    @Override // defpackage.y61
    public final y61 m() {
        boolean z = V0().w;
        n71 n71Var = this.x;
        if (!z) {
            StringBuilder sb = new StringBuilder("LayoutCoordinate operations are only valid when isAttached is true");
            for (n71 n71VarU = n71Var; n71VarU != null; n71VarU = n71VarU.u()) {
                sb.append("\n|");
                sb.append(n71VarU);
                sb.append(" isAttached=");
                sb.append(n71VarU.H());
                sb.append(" modifier=");
                sb.append(n71VarU.t0);
                sb.append(" tail=");
                sb.append(V0());
            }
            z01.b(sb.toString());
        }
        e1();
        return n71Var.o0.d.X;
    }

    public final void m1(fm1 fm1Var, boolean z, boolean z2) {
        ht1 ht1Var = this.u0;
        if (ht1Var != null) {
            if (this.Z) {
                if (z2) {
                    long jU0 = U0();
                    float fIntBitsToFloat = Float.intBitsToFloat((int) (jU0 >> 32)) / 2.0f;
                    float fIntBitsToFloat2 = Float.intBitsToFloat((int) (jU0 & 4294967295L)) / 2.0f;
                    long j = this.c;
                    fm1Var.e(-fIntBitsToFloat, -fIntBitsToFloat2, ((int) (j >> 32)) + fIntBitsToFloat, ((int) (j & 4294967295L)) + fIntBitsToFloat2);
                } else if (z) {
                    long j2 = this.c;
                    fm1Var.e(0.0f, 0.0f, (int) (j2 >> 32), (int) (j2 & 4294967295L));
                }
                if (fm1Var.f()) {
                    return;
                }
            }
            yu0 yu0Var = (yu0) ht1Var;
            float[] fArrB = yu0Var.b();
            if (!yu0Var.Z) {
                if (fArrB == null) {
                    fm1Var.b = 0.0f;
                    fm1Var.c = 0.0f;
                    fm1Var.d = 0.0f;
                    fm1Var.e = 0.0f;
                } else {
                    ih1.c(fArrB, fm1Var);
                }
            }
        }
        long j3 = this.i0;
        float f = (int) (j3 >> 32);
        fm1Var.b += f;
        fm1Var.d += f;
        float f2 = (int) (j3 & 4294967295L);
        fm1Var.c += f2;
        fm1Var.e += f2;
    }

    public final void n1() {
        if (this.u0 != null) {
            t1(null, false);
            this.x.U(false);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v5 */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1, types: [dk1] */
    /* JADX WARN: Type inference failed for: r8v12 */
    /* JADX WARN: Type inference failed for: r8v13 */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v4, types: [dk1] */
    /* JADX WARN: Type inference failed for: r8v5, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v6 */
    /* JADX WARN: Type inference failed for: r8v7 */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference failed for: r8v9 */
    /* JADX WARN: Type inference failed for: r9v13 */
    /* JADX WARN: Type inference failed for: r9v14 */
    /* JADX WARN: Type inference failed for: r9v15 */
    /* JADX WARN: Type inference failed for: r9v16 */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v3 */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r9v5, types: [pm1] */
    /* JADX WARN: Type inference failed for: r9v6 */
    /* JADX WARN: Type inference failed for: r9v7 */
    /* JADX WARN: Type inference failed for: r9v8, types: [pm1] */
    public final void o1(ph1 ph1Var) {
        co1 co1Var;
        ph1 ph1Var2 = this.g0;
        if (ph1Var != ph1Var2) {
            this.g0 = ph1Var;
            n71 n71Var = this.x;
            int i = 0;
            if (ph1Var2 == null || ph1Var.b() != ph1Var2.b() || ph1Var.a() != ph1Var2.a()) {
                int iB = ph1Var.b();
                int iA = ph1Var.a();
                ht1 ht1Var = this.u0;
                if (ht1Var != null) {
                    ((yu0) ht1Var).e((((long) iB) << 32) | (((long) iA) & 4294967295L));
                } else if (n71Var.I() && (co1Var = this.X) != null) {
                    co1Var.c1();
                }
                o0((((long) iA) & 4294967295L) | (((long) iB) << 32));
                if (this.c0 != null) {
                    u1(false);
                }
                boolean zG = do1.g(4);
                dk1 dk1VarV0 = V0();
                if (zG || (dk1VarV0 = dk1VarV0.f) != null) {
                    for (dk1 dk1VarX0 = X0(zG); dk1VarX0 != null && (dk1VarX0.e & 4) != 0; dk1VarX0 = dk1VarX0.i) {
                        if ((dk1VarX0.c & 4) != 0) {
                            ?? B = dk1VarX0;
                            ?? pm1Var = 0;
                            while (B != 0) {
                                if (B instanceof qf0) {
                                    ((qf0) B).o0();
                                } else if ((B.c & 4) != 0 && (B instanceof zb0)) {
                                    dk1 dk1Var = ((zb0) B).H;
                                    int i2 = 0;
                                    B = B;
                                    pm1Var = pm1Var;
                                    while (dk1Var != null) {
                                        if ((dk1Var.c & 4) != 0) {
                                            i2++;
                                            pm1Var = pm1Var;
                                            if (i2 == 1) {
                                                B = dk1Var;
                                            } else {
                                                if (pm1Var == 0) {
                                                    pm1Var = new pm1(new dk1[16]);
                                                }
                                                if (B != 0) {
                                                    pm1Var.b(B);
                                                    B = 0;
                                                }
                                                pm1Var.b(dk1Var);
                                            }
                                        }
                                        dk1Var = dk1Var.i;
                                        B = B;
                                        pm1Var = pm1Var;
                                    }
                                    if (i2 == 1) {
                                    }
                                }
                                B = cm4.b(pm1Var);
                            }
                        }
                        if (dk1VarX0 == dk1VarV0) {
                            break;
                        }
                    }
                }
                it1 it1Var = n71Var.x;
                if (it1Var != null) {
                    ((r7) it1Var).t(n71Var);
                }
            }
            ul1 ul1Var = this.h0;
            if ((ul1Var == null || ul1Var.e == 0) && ph1Var.d().isEmpty()) {
                return;
            }
            ul1 ul1Var2 = this.h0;
            Map mapD = ph1Var.d();
            if (ul1Var2 != null && ul1Var2.e == mapD.size()) {
                Object[] objArr = ul1Var2.b;
                int[] iArr = ul1Var2.c;
                long[] jArr = ul1Var2.a;
                int length = jArr.length - 2;
                if (length < 0) {
                    return;
                }
                int i3 = 0;
                loop0: while (true) {
                    long j = jArr[i3];
                    if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                        int i4 = 8 - ((~(i3 - length)) >>> 31);
                        for (int i5 = i; i5 < i4; i5++) {
                            if ((255 & j) < 128) {
                                int i6 = (i3 << 3) + i5;
                                Object obj = objArr[i6];
                                int i7 = iArr[i6];
                                Integer num = (Integer) mapD.get((d6) obj);
                                if (num == null || num.intValue() != i7) {
                                    break loop0;
                                }
                            }
                            j >>= 8;
                        }
                        if (i4 != 8) {
                            return;
                        }
                    }
                    if (i3 == length) {
                        return;
                    }
                    i3++;
                    i = 0;
                }
            }
            n71Var.p0.p.f0.f();
            ul1 ul1Var3 = this.h0;
            if (ul1Var3 == null) {
                ul1 ul1Var4 = xo1.a;
                ul1Var3 = new ul1();
                this.h0 = ul1Var3;
            }
            ul1Var3.a();
            for (Map.Entry entry : ph1Var.d().entrySet()) {
                ul1Var3.g(((Number) entry.getValue()).intValue(), entry.getKey());
            }
        }
    }

    public final l42 q1() {
        if (V0().w) {
            y61 y61VarC = pp4.c(this);
            fm1 fm1Var = this.k0;
            if (fm1Var == null) {
                fm1Var = new fm1();
                this.k0 = fm1Var;
            }
            long jM0 = M0(U0());
            int i = (int) (jM0 >> 32);
            fm1Var.b = -Float.intBitsToFloat(i);
            int i2 = (int) (jM0 & 4294967295L);
            fm1Var.c = -Float.intBitsToFloat(i2);
            fm1Var.d = Float.intBitsToFloat(i) + i0();
            fm1Var.e = Float.intBitsToFloat(i2) + h0();
            while (this != y61VarC) {
                this.m1(fm1Var, false, true);
                if (!fm1Var.f()) {
                    this = this.X;
                    this.getClass();
                }
            }
            return new l42(fm1Var.b, fm1Var.c, fm1Var.d, fm1Var.e);
        }
        return l42.e;
    }

    public final void r1(co1 co1Var, float[] fArr) {
        float[] fArrA;
        if (g31.a(co1Var, this)) {
            return;
        }
        co1 co1Var2 = this.X;
        co1Var2.getClass();
        co1Var2.r1(co1Var, fArr);
        if (!e21.a(this.i0, 0L)) {
            float[] fArr2 = x0;
            ih1.d(fArr2);
            long j = this.i0;
            ih1.f(fArr2, -((int) (j >> 32)), -((int) (j & 4294967295L)));
            ih1.e(fArr, fArr2);
        }
        ht1 ht1Var = this.u0;
        if (ht1Var == null || (fArrA = ((yu0) ht1Var).a()) == null) {
            return;
        }
        ih1.e(fArr, fArrA);
    }

    public final void s1(co1 co1Var, float[] fArr) {
        while (!this.equals(co1Var)) {
            ht1 ht1Var = this.u0;
            if (ht1Var != null) {
                ih1.e(fArr, ((yu0) ht1Var).b());
            }
            long j = this.i0;
            if (!e21.a(j, 0L)) {
                float[] fArr2 = x0;
                ih1.d(fArr2);
                ih1.f(fArr2, (int) (j >> 32), (int) (j & 4294967295L));
                ih1.e(fArr, fArr2);
            }
            this = this.X;
            this.getClass();
        }
    }

    public final void t1(hq0 hq0Var, boolean z) {
        it1 it1Var;
        pm1 pm1Var;
        Reference referencePoll;
        i8 i8Var;
        pm1 pm1Var2;
        Reference referencePoll2;
        Object obj;
        int i = 0;
        n71 n71Var = this.x;
        boolean z2 = (!z && this.c0 == hq0Var && g31.a(this.d0, n71Var.h0) && this.e0 == n71Var.i0) ? false : true;
        this.d0 = n71Var.h0;
        this.e0 = n71Var.i0;
        boolean zH = n71Var.H();
        bo1 bo1Var = this.s0;
        if (!zH || hq0Var == null) {
            this.c0 = null;
            ht1 ht1Var = this.u0;
            if (ht1Var != null) {
                yu0 yu0Var = (yu0) ht1Var;
                if (!dr4.a(yu0Var.b())) {
                    n71Var.N();
                }
                yu0Var.e = null;
                yu0Var.f = null;
                yu0Var.j = true;
                yu0Var.f(false);
                uu0 uu0Var = yu0Var.b;
                if (uu0Var != null) {
                    uu0Var.a(yu0Var.a);
                    r7 r7Var = yu0Var.c;
                    cu2 cu2Var = r7Var.e1;
                    do {
                        ReferenceQueue referenceQueue = (ReferenceQueue) cu2Var.c;
                        pm1Var = (pm1) cu2Var.b;
                        referencePoll = referenceQueue.poll();
                        if (referencePoll != null) {
                            pm1Var.k(referencePoll);
                        }
                    } while (referencePoll != null);
                    pm1Var.b(new WeakReference(yu0Var, (ReferenceQueue) cu2Var.c));
                    r7Var.p0.j(yu0Var);
                }
                n71Var.s0 = true;
                bo1Var.a();
                if (V0().w && n71Var.I() && (it1Var = n71Var.x) != null) {
                    ((r7) it1Var).t(n71Var);
                }
            }
            this.u0 = null;
            this.t0 = false;
            return;
        }
        this.c0 = hq0Var;
        if (this.u0 != null) {
            if (z2) {
                u1(true);
                return;
            }
            return;
        }
        it1 it1VarA = q71.a(n71Var);
        i8 i8Var2 = this.r0;
        if (i8Var2 == null) {
            i8 i8Var3 = new i8(3, this, new bo1(this, i));
            this.r0 = i8Var3;
            i8Var = i8Var3;
        } else {
            i8Var = i8Var2;
        }
        r7 r7Var2 = (r7) it1VarA;
        cu2 cu2Var2 = r7Var2.e1;
        do {
            ReferenceQueue referenceQueue2 = (ReferenceQueue) cu2Var2.c;
            pm1Var2 = (pm1) cu2Var2.b;
            referencePoll2 = referenceQueue2.poll();
            if (referencePoll2 != null) {
                pm1Var2.k(referencePoll2);
            }
        } while (referencePoll2 != null);
        do {
            int i2 = pm1Var2.c;
            if (i2 == 0) {
                obj = null;
                break;
            }
            obj = ((Reference) pm1Var2.l(i2 - 1)).get();
        } while (obj == null);
        ht1 yu0Var2 = (ht1) obj;
        if (yu0Var2 != null) {
            yu0 yu0Var3 = (yu0) yu0Var2;
            uu0 uu0Var2 = yu0Var3.b;
            if (uu0Var2 == null) {
                throw cq.e("currently reuse is only supported when we manage the layer lifecycle");
            }
            if (!yu0Var3.a.s) {
                z01.a("layer should have been released before reuse");
            }
            yu0Var3.a = uu0Var2.b();
            yu0Var3.j = false;
            yu0Var3.e = i8Var;
            yu0Var3.f = bo1Var;
            yu0Var3.X = false;
            yu0Var3.Y = false;
            yu0Var3.Z = true;
            ih1.d(yu0Var3.k);
            float[] fArr = yu0Var3.n;
            if (fArr != null) {
                ih1.d(fArr);
            }
            yu0Var3.x = y13.a;
            yu0Var3.c0 = false;
            yu0Var3.i = 9223372034707292159L;
            yu0Var3.H = null;
            yu0Var3.w = 0;
        } else {
            yu0Var2 = new yu0(r7Var2.getGraphicsContext().b(), r7Var2.getGraphicsContext(), r7Var2, i8Var, bo1Var);
        }
        yu0 yu0Var4 = (yu0) yu0Var2;
        yu0Var4.e(this.c);
        yu0Var4.d(this.i0);
        this.u0 = yu0Var2;
        u1(true);
        n71Var.s0 = true;
        bo1Var.a();
    }

    @Override // defpackage.y61
    public final long u(y61 y61Var, long j) {
        return H(y61Var, j);
    }

    public final void u1(boolean z) {
        r7 r7Var;
        boolean z2;
        r7 r7Var2;
        it1 it1Var;
        fq0 fq0Var;
        fq0 fq0Var2;
        ht1 ht1Var = this.u0;
        hq0 hq0Var = this.c0;
        if (ht1Var == null) {
            if (hq0Var == null) {
                return;
            }
            z01.b("null layer with a non-null layerBlock");
            return;
        }
        if (hq0Var == null) {
            throw cq.e("updateLayerParameters requires a non-null layerBlock");
        }
        r72 r72Var = v0;
        r72Var.a();
        n71 n71Var = this.x;
        r72Var.v = n71Var.h0;
        r72Var.w = n71Var.i0;
        r72Var.u = cp4.a(this.c);
        ((r7) q71.a(n71Var)).getSnapshotObserver().a.c(this, j7.m0, new h7(7, hq0Var, this));
        v61 v61Var = this.l0;
        if (v61Var == null) {
            v61Var = new v61();
            this.l0 = v61Var;
        }
        v61 v61Var2 = w0;
        v61Var2.getClass();
        v61Var2.a = v61Var.a;
        v61Var2.b = v61Var.b;
        v61Var2.c = v61Var.c;
        v61Var2.d = v61Var.d;
        float f = r72Var.b;
        v61Var.a = f;
        v61Var.b = r72Var.c;
        v61Var.c = r72Var.k;
        long j = r72Var.n;
        v61Var.d = j;
        yu0 yu0Var = (yu0) ht1Var;
        r7 r7Var3 = yu0Var.c;
        int i = r72Var.a | yu0Var.w;
        yu0Var.u = r72Var.w;
        yu0Var.t = r72Var.v;
        int i2 = i & 4096;
        if (i2 != 0) {
            yu0Var.x = j;
        }
        if ((i & 1) != 0) {
            xu0 xu0Var = yu0Var.a.a;
            if (xu0Var.d() != f) {
                xu0Var.m(f);
            }
        }
        if ((i & 2) != 0) {
            vu0 vu0Var = yu0Var.a;
            float f2 = r72Var.c;
            xu0 xu0Var2 = vu0Var.a;
            if (xu0Var2.I() != f2) {
                xu0Var2.B(f2);
            }
        }
        if ((i & 4) != 0) {
            vu0 vu0Var2 = yu0Var.a;
            float f3 = r72Var.e;
            xu0 xu0Var3 = vu0Var2.a;
            if (xu0Var3.a() != f3) {
                xu0Var3.c(f3);
            }
        }
        if ((i & 8) != 0) {
            xu0 xu0Var4 = yu0Var.a.a;
            if (xu0Var4.q() != 0.0f) {
                xu0Var4.r();
            }
        }
        if ((i & 16) != 0) {
            xu0 xu0Var5 = yu0Var.a.a;
            if (xu0Var5.f() != 0.0f) {
                xu0Var5.g();
            }
        }
        if ((i & 32) != 0) {
            vu0 vu0Var3 = yu0Var.a;
            float f4 = r72Var.f;
            xu0 xu0Var6 = vu0Var3.a;
            if (xu0Var6.G() != f4) {
                xu0Var6.e(f4);
                vu0Var3.g = true;
                vu0Var3.a();
            }
            if (r72Var.f > 0.0f && !yu0Var.c0 && (fq0Var2 = yu0Var.f) != null) {
                fq0Var2.a();
            }
        }
        if ((i & 64) != 0) {
            vu0 vu0Var4 = yu0Var.a;
            long j2 = r72Var.i;
            xu0 xu0Var7 = vu0Var4.a;
            if (!sz.c(j2, xu0Var7.M())) {
                xu0Var7.j(j2);
            }
        }
        if ((i & 128) != 0) {
            vu0 vu0Var5 = yu0Var.a;
            long j3 = r72Var.j;
            xu0 xu0Var8 = vu0Var5.a;
            if (!sz.c(j3, xu0Var8.i())) {
                xu0Var8.A(j3);
            }
        }
        if ((i & 1024) != 0) {
            xu0 xu0Var9 = yu0Var.a.a;
            if (xu0Var9.J() != 0.0f) {
                xu0Var9.z();
            }
        }
        if ((i & 256) != 0) {
            xu0 xu0Var10 = yu0Var.a.a;
            if (xu0Var10.v() != 0.0f) {
                xu0Var10.b();
            }
        }
        if ((i & 512) != 0) {
            xu0 xu0Var11 = yu0Var.a.a;
            if (xu0Var11.E() != 0.0f) {
                xu0Var11.h();
            }
        }
        if ((i & 2048) != 0) {
            vu0 vu0Var6 = yu0Var.a;
            float f5 = r72Var.k;
            xu0 xu0Var12 = vu0Var6.a;
            if (xu0Var12.o() != f5) {
                xu0Var12.F(f5);
            }
        }
        if (i2 != 0) {
            long j4 = yu0Var.x;
            boolean z3 = j4 == y13.a;
            vu0 vu0Var7 = yu0Var.a;
            if (!z3) {
                long jFloatToRawIntBits = (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (yu0Var.x & 4294967295L)) * ((int) (yu0Var.i & 4294967295L)))) & 4294967295L) | (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (j4 >> 32)) * ((int) (yu0Var.i >> 32)))) << 32);
                if (!jp1.b(vu0Var7.v, jFloatToRawIntBits)) {
                    vu0Var7.v = jFloatToRawIntBits;
                    vu0Var7.a.L(jFloatToRawIntBits);
                }
            } else if (!jp1.b(vu0Var7.v, 9205357640488583168L)) {
                vu0Var7.v = 9205357640488583168L;
                vu0Var7.a.L(9205357640488583168L);
            }
        }
        if ((i & 16384) != 0) {
            vu0 vu0Var8 = yu0Var.a;
            boolean z4 = r72Var.t;
            if (vu0Var8.w != z4) {
                vu0Var8.w = z4;
                vu0Var8.g = true;
                vu0Var8.a();
            }
        }
        if ((131072 & i) != 0) {
            xu0 xu0Var13 = yu0Var.a.a;
        }
        if ((262144 & i) != 0) {
            xu0 xu0Var14 = yu0Var.a.a;
            if (!g31.a(xu0Var14.x(), null)) {
                xu0Var14.l();
            }
        }
        if ((524288 & i) != 0) {
            vu0 vu0Var9 = yu0Var.a;
            int i3 = r72Var.x;
            xu0 xu0Var15 = vu0Var9.a;
            if (xu0Var15.K() != i3) {
                xu0Var15.n(i3);
            }
        }
        if ((32768 & i) != 0) {
            xu0 xu0Var16 = yu0Var.a.a;
            if (xu0Var16.u() != 0) {
                xu0Var16.y(0);
            }
        }
        if ((i & 7963) != 0) {
            yu0Var.X = true;
            yu0Var.Y = true;
        }
        if (g31.a(yu0Var.H, r72Var.H)) {
            r7Var = r7Var3;
            z2 = false;
        } else {
            es4 es4Var = r72Var.H;
            yu0Var.H = es4Var;
            if (es4Var == null) {
                r7Var = r7Var3;
            } else {
                vu0 vu0Var10 = yu0Var.a;
                if (es4Var instanceof us1) {
                    l42 l42Var = ((us1) es4Var).a;
                    float f6 = l42Var.a;
                    float f7 = l42Var.b;
                    r7Var = r7Var3;
                    vu0Var10.f((((long) Float.floatToRawIntBits(f6)) << 32) | (((long) Float.floatToRawIntBits(f7)) & 4294967295L), (((long) Float.floatToRawIntBits(l42Var.c - f6)) << 32) | (((long) Float.floatToRawIntBits(l42Var.d - f7)) & 4294967295L), 0.0f);
                } else {
                    r7Var = r7Var3;
                    if (es4Var instanceof ts1) {
                        na naVar = ((ts1) es4Var).a;
                        vu0Var10.k = null;
                        vu0Var10.i = 9205357640488583168L;
                        vu0Var10.h = 0L;
                        vu0Var10.j = 0.0f;
                        vu0Var10.g = true;
                        vu0Var10.n = false;
                        vu0Var10.l = naVar;
                        vu0Var10.a();
                    } else {
                        if (!(es4Var instanceof vs1)) {
                            dk0.l();
                            return;
                        }
                        vs1 vs1Var = (vs1) es4Var;
                        na naVar2 = vs1Var.b;
                        if (naVar2 != null) {
                            vu0Var10.k = null;
                            vu0Var10.i = 9205357640488583168L;
                            vu0Var10.h = 0L;
                            vu0Var10.j = 0.0f;
                            vu0Var10.g = true;
                            vu0Var10.n = false;
                            vu0Var10.l = naVar2;
                            vu0Var10.a();
                        } else {
                            s82 s82Var = vs1Var.a;
                            float f8 = s82Var.b;
                            float f9 = s82Var.a;
                            vu0Var10.f((((long) Float.floatToRawIntBits(f9)) << 32) | (((long) Float.floatToRawIntBits(f8)) & 4294967295L), (((long) Float.floatToRawIntBits(s82Var.c - f9)) << 32) | (((long) Float.floatToRawIntBits(s82Var.d - f8)) & 4294967295L), Float.intBitsToFloat((int) (s82Var.h >> 32)));
                        }
                    }
                }
                if ((es4Var instanceof ts1) && Build.VERSION.SDK_INT < 33 && (fq0Var = yu0Var.f) != null) {
                    fq0Var.a();
                }
            }
            z2 = true;
        }
        yu0Var.w = r72Var.a;
        if (i != 0 || z2) {
            ViewParent parent = r7Var.getParent();
            if (parent != null) {
                r7Var2 = r7Var;
                parent.onDescendantInvalidated(r7Var2, r7Var2);
            } else {
                r7Var2 = r7Var;
            }
            if (r7Var2.u) {
                r7Var2.H(0.0f);
            }
        }
        boolean z5 = this.Z;
        boolean z6 = r72Var.t;
        this.Z = z6;
        this.f0 = r72Var.e;
        boolean z7 = v61Var2.a == v61Var.a && v61Var2.b == v61Var.b && v61Var2.c == v61Var.c && v61Var2.d == v61Var.d;
        if (z && ((!z7 || z5 != z6) && (it1Var = n71Var.x) != null)) {
            ((r7) it1Var).t(n71Var);
        }
        if (z7) {
            return;
        }
        r71 r71Var = n71Var.p0;
        if (r71Var.l > 0) {
            if (r71Var.k || r71Var.j) {
                n71Var.U(false);
            }
            r71Var.p.x0();
        }
        n71Var.N();
        r7 r7Var4 = (r7) q71.a(n71Var);
        n42 rectManager = r7Var4.getRectManager();
        if (this == n71Var.o0.d) {
            rectManager.f(n71Var, false);
        } else {
            rectManager.getClass();
            if (n71Var.I()) {
                long jG = n42.g(n71Var);
                if (e21.a(jG, 9223372034707292159L)) {
                    rectManager.d(n71Var);
                } else {
                    n71Var.i = jG;
                    n71Var.j = false;
                    pm1 pm1VarZ = n71Var.z();
                    Object[] objArr = pm1VarZ.a;
                    int i4 = pm1VarZ.c;
                    for (int i5 = 0; i5 < i4; i5++) {
                        rectManager.f((n71) objArr[i5], false);
                    }
                    rectManager.e(n71Var);
                }
            }
        }
        if (n71Var.w0 > 0) {
            q91 q91Var = r7Var4.F0.e;
            q91Var.getClass();
            if (n71Var.w0 > 0) {
                ((pm1) q91Var.b).b(n71Var);
                n71Var.v0 = true;
            }
            r7Var4.A(null);
        }
    }

    /* JADX WARN: Code duplicated, block: B:62:0x017d  */
    public final boolean v1(long j) {
        boolean z;
        boolean z2;
        boolean zB;
        if ((((9187343241974906880L ^ (j & 9187343241974906880L)) - 4294967297L) & (-9223372034707292160L)) != 0) {
            return false;
        }
        ht1 ht1Var = this.u0;
        if (ht1Var == null || !this.Z) {
            return true;
        }
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j & 4294967295L));
        vu0 vu0Var = ((yu0) ht1Var).a;
        if (vu0Var.w) {
            es4 es4VarD = vu0Var.d();
            if (es4VarD instanceof us1) {
                l42 l42Var = ((us1) es4VarD).a;
                if (l42Var.a > fIntBitsToFloat || fIntBitsToFloat >= l42Var.c || l42Var.b > fIntBitsToFloat2 || fIntBitsToFloat2 >= l42Var.d) {
                    z = false;
                    z2 = true;
                }
                z = false;
                z2 = true;
            } else if (es4VarD instanceof vs1) {
                s82 s82Var = ((vs1) es4VarD).a;
                float f = s82Var.c;
                float f2 = s82Var.b;
                float f3 = s82Var.d;
                float f4 = s82Var.a;
                long j2 = s82Var.f;
                long j3 = s82Var.h;
                z = false;
                z2 = true;
                long j4 = s82Var.g;
                long j5 = s82Var.e;
                if (fIntBitsToFloat >= f4 && fIntBitsToFloat < f && fIntBitsToFloat2 >= f2 && fIntBitsToFloat2 < f3) {
                    int i = (int) (j5 >> 32);
                    float fIntBitsToFloat3 = Float.intBitsToFloat(i);
                    int i2 = (int) (j2 >> 32);
                    if (Float.intBitsToFloat(i2) + fIntBitsToFloat3 <= f - f4) {
                        int i3 = (int) (j3 >> 32);
                        float fIntBitsToFloat4 = Float.intBitsToFloat(i3);
                        int i4 = (int) (j4 >> 32);
                        if (Float.intBitsToFloat(i4) + fIntBitsToFloat4 <= f - f4) {
                            int i5 = (int) (j5 & 4294967295L);
                            int i6 = (int) (j3 & 4294967295L);
                            if (Float.intBitsToFloat(i6) + Float.intBitsToFloat(i5) <= f3 - f2) {
                                int i7 = (int) (j2 & 4294967295L);
                                int i8 = (int) (j4 & 4294967295L);
                                if (Float.intBitsToFloat(i8) + Float.intBitsToFloat(i7) <= f3 - f2) {
                                    float fIntBitsToFloat5 = Float.intBitsToFloat(i) + f4;
                                    float fIntBitsToFloat6 = Float.intBitsToFloat(i5) + f2;
                                    float fIntBitsToFloat7 = f - Float.intBitsToFloat(i2);
                                    float fIntBitsToFloat8 = Float.intBitsToFloat(i7) + f2;
                                    float fIntBitsToFloat9 = f - Float.intBitsToFloat(i4);
                                    float fIntBitsToFloat10 = f3 - Float.intBitsToFloat(i8);
                                    float fIntBitsToFloat11 = f3 - Float.intBitsToFloat(i6);
                                    float fIntBitsToFloat12 = Float.intBitsToFloat(i3) + f4;
                                    if (fIntBitsToFloat < fIntBitsToFloat5 && fIntBitsToFloat2 < fIntBitsToFloat6) {
                                        zB = u34.b(fIntBitsToFloat, fIntBitsToFloat2, fIntBitsToFloat5, fIntBitsToFloat6, s82Var.e);
                                    } else if (fIntBitsToFloat < fIntBitsToFloat12 && fIntBitsToFloat2 > fIntBitsToFloat11) {
                                        zB = u34.b(fIntBitsToFloat, fIntBitsToFloat2, fIntBitsToFloat12, fIntBitsToFloat11, s82Var.h);
                                    } else if (fIntBitsToFloat <= fIntBitsToFloat7 || fIntBitsToFloat2 >= fIntBitsToFloat8) {
                                        zB = (fIntBitsToFloat <= fIntBitsToFloat9 || fIntBitsToFloat2 <= fIntBitsToFloat10) ? z2 : u34.b(fIntBitsToFloat, fIntBitsToFloat2, fIntBitsToFloat9, fIntBitsToFloat10, s82Var.g);
                                    } else {
                                        zB = u34.b(fIntBitsToFloat, fIntBitsToFloat2, fIntBitsToFloat7, fIntBitsToFloat8, s82Var.f);
                                    }
                                } else {
                                    na naVarA = pa.a();
                                    na.b(naVarA, s82Var);
                                    zB = u34.a(fIntBitsToFloat, fIntBitsToFloat2, naVarA);
                                }
                            } else {
                                na naVarA2 = pa.a();
                                na.b(naVarA2, s82Var);
                                zB = u34.a(fIntBitsToFloat, fIntBitsToFloat2, naVarA2);
                            }
                        } else {
                            na naVarA3 = pa.a();
                            na.b(naVarA3, s82Var);
                            zB = u34.a(fIntBitsToFloat, fIntBitsToFloat2, naVarA3);
                        }
                    } else {
                        na naVarA4 = pa.a();
                        na.b(naVarA4, s82Var);
                        zB = u34.a(fIntBitsToFloat, fIntBitsToFloat2, naVarA4);
                    }
                }
            } else {
                z = false;
                z2 = true;
                if (!(es4VarD instanceof ts1)) {
                    dk0.l();
                    return false;
                }
                zB = u34.a(fIntBitsToFloat, fIntBitsToFloat2, ((ts1) es4VarD).a);
            }
            zB = z;
        } else {
            z = false;
            z2 = true;
        }
        return zB ? z2 : z;
    }

    @Override // defpackage.jt1
    public final boolean y() {
        return (this.u0 == null || this.Y || !this.x.H()) ? false : true;
    }

    @Override // defpackage.mf1
    public final mf1 z0() {
        return this.H;
    }

    @Override // defpackage.mf1
    public final y61 A0() {
        return this;
    }
}
