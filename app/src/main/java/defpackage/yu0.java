package defpackage;

import android.view.ViewParent;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class yu0 implements ht1 {
    public es4 H;
    public boolean X;
    public boolean Y;
    public vu0 a;
    public final uu0 b;
    public final r7 c;
    public boolean c0;
    public vq0 e;
    public fq0 f;
    public boolean j;
    public float[] n;
    public boolean s;
    public int w;
    public long i = 9223372034707292159L;
    public final float[] k = ih1.a();
    public jc0 t = em4.a();
    public z61 u = z61.a;
    public final ew v = new ew();
    public long x = y13.a;
    public boolean Z = true;
    public final h6 d0 = new h6(14, this);

    public yu0(vu0 vu0Var, uu0 uu0Var, r7 r7Var, vq0 vq0Var, fq0 fq0Var) {
        this.a = vu0Var;
        this.b = uu0Var;
        this.c = r7Var;
        this.e = vq0Var;
        this.f = fq0Var;
    }

    public final float[] a() {
        float[] fArrA = this.n;
        if (fArrA == null) {
            fArrA = ih1.a();
            this.n = fArrA;
        }
        if (this.Y) {
            this.Y = false;
            float[] fArrB = b();
            if (this.Z) {
                return fArrB;
            }
            if (!gp4.a(fArrB, fArrA)) {
                fArrA[0] = Float.NaN;
                return null;
            }
        } else if (Float.isNaN(fArrA[0])) {
            return null;
        }
        return fArrA;
    }

    public final float[] b() {
        boolean z = this.X;
        float[] fArr = this.k;
        if (z) {
            vu0 vu0Var = this.a;
            long jA = vu0Var.v;
            xu0 xu0Var = vu0Var.a;
            if ((9223372034707292159L & jA) == 9205357640488583168L) {
                jA = a44.a(cp4.a(this.i));
            }
            float fIntBitsToFloat = Float.intBitsToFloat((int) (jA >> 32));
            float fIntBitsToFloat2 = Float.intBitsToFloat((int) (jA & 4294967295L));
            float fQ = xu0Var.q();
            float f = xu0Var.f();
            float fV = xu0Var.v();
            float fE = xu0Var.E();
            float fJ = xu0Var.J();
            float fD = xu0Var.d();
            float fI = xu0Var.I();
            double d = ((double) fV) * 0.017453292519943295d;
            float fSin = (float) Math.sin(d);
            float fCos = (float) Math.cos(d);
            float f2 = -fSin;
            float f3 = (f * fCos) - (0.0f * fSin);
            float f4 = (0.0f * fCos) + (f * fSin);
            double d2 = ((double) fE) * 0.017453292519943295d;
            float fSin2 = (float) Math.sin(d2);
            float fCos2 = (float) Math.cos(d2);
            float f5 = -fSin2;
            float f6 = fSin * fSin2;
            float f7 = fSin * fCos2;
            float f8 = fCos * fSin2;
            float f9 = fCos * fCos2;
            float f10 = (f4 * fSin2) + (fQ * fCos2);
            float f11 = (f4 * fCos2) + ((-fQ) * fSin2);
            double d3 = ((double) fJ) * 0.017453292519943295d;
            float fSin3 = (float) Math.sin(d3);
            float fCos3 = (float) Math.cos(d3);
            float f12 = -fSin3;
            float f13 = (fCos3 * f6) + (f12 * fCos2);
            float f14 = (f6 * fSin3) + (fCos2 * fCos3);
            float f15 = fSin3 * fCos;
            float f16 = f14 * fD;
            float f17 = f15 * fD;
            float f18 = ((fSin3 * f7) + (fCos3 * f5)) * fD;
            float f19 = f13 * fI;
            float f20 = fCos * fCos3 * fI;
            float f21 = ((fCos3 * f7) + (f12 * f5)) * fI;
            float f22 = f8 * 1.0f;
            float f23 = f2 * 1.0f;
            float f24 = f9 * 1.0f;
            if (fArr.length >= 16) {
                fArr[0] = f16;
                fArr[1] = f17;
                fArr[2] = f18;
                fArr[3] = 0.0f;
                fArr[4] = f19;
                fArr[5] = f20;
                fArr[6] = f21;
                fArr[7] = 0.0f;
                fArr[8] = f22;
                fArr[9] = f23;
                fArr[10] = f24;
                fArr[11] = 0.0f;
                float f25 = -fIntBitsToFloat;
                fArr[12] = ((f16 * f25) - (fIntBitsToFloat2 * f19)) + f10 + fIntBitsToFloat;
                fArr[13] = ((f17 * f25) - (fIntBitsToFloat2 * f20)) + f3 + fIntBitsToFloat2;
                fArr[14] = ((f25 * f18) - (fIntBitsToFloat2 * f21)) + f11;
                fArr[15] = 1.0f;
            }
            this.X = false;
            this.Z = dr4.a(fArr);
        }
        return fArr;
    }

    public final void c() {
        if (this.s || this.j) {
            return;
        }
        this.c.invalidate();
        f(true);
    }

    public final void d(long j) {
        r7 r7Var = this.c;
        if (r7Var.u) {
            r7Var.H(-4.0f);
        }
        vu0 vu0Var = this.a;
        if (!e21.a(vu0Var.t, j)) {
            vu0Var.t = j;
            vu0Var.a.D((int) (j >> 32), (int) (j & 4294967295L), vu0Var.u);
        }
        ViewParent parent = r7Var.getParent();
        if (parent != null) {
            parent.onDescendantInvalidated(r7Var, r7Var);
        }
    }

    public final void e(long j) {
        if (l21.a(j, this.i)) {
            return;
        }
        r7 r7Var = this.c;
        if (r7Var.u) {
            r7Var.H(-4.0f);
        }
        this.i = j;
        c();
    }

    public final void f(boolean z) {
        if (z != this.s) {
            this.s = z;
            r7 r7Var = this.c;
            yl1 yl1Var = r7Var.p0;
            boolean z2 = r7Var.r0;
            if (!z) {
                if (z2) {
                    return;
                }
                yl1Var.j(this);
                yl1 yl1Var2 = r7Var.q0;
                if (yl1Var2 != null) {
                    yl1Var2.j(this);
                    return;
                }
                return;
            }
            if (!z2) {
                yl1Var.a(this);
                return;
            }
            yl1 yl1Var3 = r7Var.q0;
            if (yl1Var3 == null) {
                yl1Var3 = new yl1();
                r7Var.q0 = yl1Var3;
            }
            yl1Var3.a(this);
        }
    }

    public final void g() {
        if (this.s) {
            if (this.x != y13.a && !l21.a(this.a.u, this.i)) {
                vu0 vu0Var = this.a;
                float fIntBitsToFloat = Float.intBitsToFloat((int) (this.x >> 32)) * ((int) (this.i >> 32));
                long jFloatToRawIntBits = (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (this.x & 4294967295L)) * ((int) (this.i & 4294967295L)))) & 4294967295L) | (Float.floatToRawIntBits(fIntBitsToFloat) << 32);
                if (!jp1.b(vu0Var.v, jFloatToRawIntBits)) {
                    vu0Var.v = jFloatToRawIntBits;
                    vu0Var.a.L(jFloatToRawIntBits);
                }
            }
            vu0 vu0Var2 = this.a;
            jc0 jc0Var = this.t;
            z61 z61Var = this.u;
            long j = this.i;
            long j2 = vu0Var2.u;
            xu0 xu0Var = vu0Var2.a;
            if (!l21.a(j2, j)) {
                vu0Var2.u = j;
                long j3 = vu0Var2.t;
                xu0Var.D((int) (j3 >> 32), (int) (4294967295L & j3), j);
                if (vu0Var2.i == 9205357640488583168L) {
                    vu0Var2.g = true;
                    vu0Var2.a();
                }
            }
            vu0Var2.b = jc0Var;
            vu0Var2.c = z61Var;
            vu0Var2.d = this.d0;
            xu0Var.w(jc0Var, z61Var, vu0Var2, vu0Var2.e);
            f(false);
        }
    }
}
