package defpackage;

import android.graphics.Paint;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ew implements rf0 {
    public final dw a;
    public final kf b;
    public fa c;
    public fa e;

    public ew() {
        dw dwVar = new dw();
        dwVar.a = yy3.c;
        dwVar.b = z61.a;
        dwVar.c = fi0.a;
        dwVar.d = 0L;
        this.a = dwVar;
        this.b = new kf(this);
    }

    public static fa a(ew ewVar, long j, wm4 wm4Var, float f, int i) {
        fa faVarF = ewVar.f(wm4Var);
        Paint paint = faVarF.a;
        if (f != 1.0f) {
            j = sz.b(sz.d(j) * f, j);
        }
        if (!sz.c(ki4.b(paint.getColor()), j)) {
            faVarF.e(j);
        }
        if (faVarF.c != null) {
            faVarF.h(null);
        }
        if (!g31.a(faVarF.d, null)) {
            faVarF.f(null);
        }
        if (faVarF.b != i) {
            faVarF.d(i);
        }
        if (paint.isFilterBitmap()) {
            return faVarF;
        }
        faVarF.g(1);
        return faVarF;
    }

    @Override // defpackage.rf0
    public final kf C() {
        return this.b;
    }

    @Override // defpackage.rf0
    public final void G(hn hnVar, float f, long j, float f2) {
        this.a.c.d(f, j, d(hnVar, ql0.a, f2, null, 3, 1));
    }

    @Override // defpackage.rf0
    public final void L(long j, float f, long j2, float f2) {
        this.a.c.d(f, j2, a(this, j, ql0.a, f2, 3));
    }

    @Override // defpackage.rf0
    public final void M(long j, long j2, long j3, wm4 wm4Var, int i) {
        int i2 = (int) (j2 >> 32);
        int i3 = (int) (j2 & 4294967295L);
        this.a.c.q(Float.intBitsToFloat(i2), Float.intBitsToFloat(i3), Float.intBitsToFloat((int) (j3 >> 32)) + Float.intBitsToFloat(i2), Float.intBitsToFloat((int) (4294967295L & j3)) + Float.intBitsToFloat(i3), a(this, j, wm4Var, 1.0f, i));
    }

    @Override // defpackage.rf0
    public final void Q(p9 p9Var, long j, long j2, long j3, float f, nl nlVar, int i) {
        this.a.c.e(p9Var, j, j2, j3, d(null, ql0.a, f, nlVar, 3, i));
    }

    @Override // defpackage.jc0
    public final float b() {
        return this.a.a.b();
    }

    public final fa d(hn hnVar, wm4 wm4Var, float f, nl nlVar, int i, int i2) {
        fa faVarF = f(wm4Var);
        Paint paint = faVarF.a;
        if (hnVar != null) {
            hnVar.a(f, c(), faVarF);
        } else {
            if (faVarF.c != null) {
                faVarF.h(null);
            }
            long jB = ki4.b(paint.getColor());
            long j = sz.b;
            if (!sz.c(jB, j)) {
                faVarF.e(j);
            }
            if (paint.getAlpha() / 255.0f != f) {
                faVarF.c(f);
            }
        }
        if (!g31.a(faVarF.d, nlVar)) {
            faVarF.f(nlVar);
        }
        if (faVarF.b != i) {
            faVarF.d(i);
        }
        if (paint.isFilterBitmap() == i2) {
            return faVarF;
        }
        faVarF.g(i2);
        return faVarF;
    }

    public final void e(p9 p9Var, nl nlVar) {
        this.a.c.a(p9Var, d(null, ql0.a, 1.0f, nlVar, 3, 1));
    }

    public final fa f(wm4 wm4Var) {
        if (g31.a(wm4Var, ql0.a)) {
            fa faVar = this.c;
            if (faVar != null) {
                return faVar;
            }
            fa faVarA = ld4.a();
            faVarA.l(0);
            this.c = faVarA;
            return faVarA;
        }
        if (!(wm4Var instanceof ks2)) {
            dk0.l();
            return null;
        }
        fa faVarA2 = this.e;
        if (faVarA2 == null) {
            faVarA2 = ld4.a();
            faVarA2.l(1);
            this.e = faVarA2;
        }
        Paint paint = faVarA2.a;
        float strokeWidth = paint.getStrokeWidth();
        ks2 ks2Var = (ks2) wm4Var;
        float f = ks2Var.a;
        if (strokeWidth != f) {
            faVarA2.k(f);
        }
        int iA = faVarA2.a();
        int i = ks2Var.c;
        if (iA != i) {
            faVarA2.i(i);
        }
        float strokeMiter = paint.getStrokeMiter();
        float f2 = ks2Var.b;
        if (strokeMiter != f2) {
            paint.setStrokeMiter(f2);
        }
        int iB = faVarA2.b();
        int i2 = ks2Var.d;
        if (iB == i2) {
            return faVarA2;
        }
        faVarA2.j(i2);
        return faVarA2;
    }

    @Override // defpackage.rf0
    public final void f0(long j, long j2, long j3, float f) {
        cw cwVar = this.a.c;
        fa faVarA = this.e;
        if (faVarA == null) {
            faVarA = ld4.a();
            faVarA.l(1);
            this.e = faVarA;
        }
        Paint paint = faVarA.a;
        if (!sz.c(ki4.b(paint.getColor()), j)) {
            faVarA.e(j);
        }
        if (faVarA.c != null) {
            faVarA.h(null);
        }
        if (!g31.a(faVarA.d, null)) {
            faVarA.f(null);
        }
        if (faVarA.b != 3) {
            faVarA.d(3);
        }
        if (paint.getStrokeWidth() != f) {
            faVarA.k(f);
        }
        if (paint.getStrokeMiter() != 4.0f) {
            paint.setStrokeMiter(4.0f);
        }
        if (faVarA.a() != 1) {
            faVarA.i(1);
        }
        if (faVarA.b() != 0) {
            faVarA.j(0);
        }
        if (!paint.isFilterBitmap()) {
            faVarA.g(1);
        }
        cwVar.n(j2, j3, faVarA);
    }

    @Override // defpackage.rf0
    public final void g(na naVar, hn hnVar, float f, wm4 wm4Var, int i) {
        this.a.c.h(naVar, d(hnVar, wm4Var, f, null, i, 1));
    }

    @Override // defpackage.rf0
    public final z61 getLayoutDirection() {
        return this.a.b;
    }

    @Override // defpackage.rf0
    public final void j(long j, float f, float f2, long j2, long j3, ks2 ks2Var) {
        int i = (int) (j2 >> 32);
        int i2 = (int) (j2 & 4294967295L);
        this.a.c.u(Float.intBitsToFloat(i), Float.intBitsToFloat(i2), Float.intBitsToFloat((int) (j3 >> 32)) + Float.intBitsToFloat(i), Float.intBitsToFloat((int) (j3 & 4294967295L)) + Float.intBitsToFloat(i2), f, f2, a(this, j, ks2Var, 1.0f, 3));
    }

    @Override // defpackage.jc0
    public final float l() {
        return this.a.a.l();
    }

    @Override // defpackage.rf0
    public final void m0(na naVar, long j, float f, wm4 wm4Var) {
        this.a.c.h(naVar, a(this, j, wm4Var, f, 3));
    }

    @Override // defpackage.rf0
    public final void p0(long j, long j2, long j3, float f, wm4 wm4Var) {
        int i = (int) (j2 >> 32);
        int i2 = (int) (j2 & 4294967295L);
        this.a.c.i(Float.intBitsToFloat(i), Float.intBitsToFloat(i2), Float.intBitsToFloat((int) (j3 >> 32)) + Float.intBitsToFloat(i), Float.intBitsToFloat((int) (4294967295L & j3)) + Float.intBitsToFloat(i2), a(this, j, wm4Var, f, 3));
    }

    @Override // defpackage.rf0
    public final void z(hn hnVar, long j, long j2, float f, wm4 wm4Var) {
        int i = (int) (j >> 32);
        int i2 = (int) (j & 4294967295L);
        this.a.c.q(Float.intBitsToFloat(i), Float.intBitsToFloat(i2), Float.intBitsToFloat((int) (j2 >> 32)) + Float.intBitsToFloat(i), Float.intBitsToFloat((int) (4294967295L & j2)) + Float.intBitsToFloat(i2), d(hnVar, wm4Var, f, null, 3, 1));
    }
}
