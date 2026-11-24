package defpackage;

import android.content.Context;
import android.os.Build;
import android.widget.EdgeEffect;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class f9 {
    public final jc0 a;
    public long b = 9205357640488583168L;
    public final xg0 c;
    public final ku1 d;
    public final boolean e;
    public boolean f;
    public long g;
    public long h;
    public final zb0 i;

    public f9(Context context, jc0 jc0Var, long j, qt1 qt1Var) {
        this.a = jc0Var;
        xg0 xg0Var = new xg0(context, ki4.g(j));
        this.c = xg0Var;
        this.d = new ku1(q43.a, el1.f);
        this.e = true;
        this.g = 0L;
        this.h = -1L;
        e9 e9Var = new e9(0, this);
        gy1 gy1Var = pu2.a;
        tu2 tu2Var = new tu2(null, null, e9Var);
        this.i = Build.VERSION.SDK_INT >= 31 ? new ku0(tu2Var, this, xg0Var) : new ku0(tu2Var, this, xg0Var, qt1Var);
    }

    public final void a() {
        boolean z;
        xg0 xg0Var = this.c;
        EdgeEffect edgeEffect = xg0Var.d;
        boolean z2 = true;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            z = !edgeEffect.isFinished();
        } else {
            z = false;
        }
        EdgeEffect edgeEffect2 = xg0Var.e;
        if (edgeEffect2 != null) {
            edgeEffect2.onRelease();
            z = !edgeEffect2.isFinished() || z;
        }
        EdgeEffect edgeEffect3 = xg0Var.f;
        if (edgeEffect3 != null) {
            edgeEffect3.onRelease();
            z = !edgeEffect3.isFinished() || z;
        }
        EdgeEffect edgeEffect4 = xg0Var.g;
        if (edgeEffect4 != null) {
            edgeEffect4.onRelease();
            if (edgeEffect4.isFinished() && !z) {
                z2 = false;
            }
            z = z2;
        }
        if (z) {
            d();
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x001b  */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0137, code lost:
    
        if (r4 == r6) goto L51;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(long r19, defpackage.ge2 r21, defpackage.y50 r22) {
        /*
            Method dump skipped, instruction units count: 483
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.f9.b(long, ge2, y50):java.lang.Object");
    }

    public final long c() {
        long jA = this.b;
        if ((9223372034707292159L & jA) == 9205357640488583168L) {
            jA = a44.a(this.g);
        }
        float fIntBitsToFloat = Float.intBitsToFloat((int) (jA >> 32)) / Float.intBitsToFloat((int) (this.g >> 32));
        return (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (jA & 4294967295L)) / Float.intBitsToFloat((int) (this.g & 4294967295L)))) & 4294967295L) | (Float.floatToRawIntBits(fIntBitsToFloat) << 32);
    }

    public final void d() {
        if (this.e) {
            this.d.setValue(q43.a);
        }
    }

    public final float e(long j) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (c() >> 32));
        int i = (int) (j & 4294967295L);
        float fIntBitsToFloat2 = Float.intBitsToFloat(i) / Float.intBitsToFloat((int) (this.g & 4294967295L));
        EdgeEffect edgeEffectB = this.c.b();
        float fD = -fIntBitsToFloat2;
        float f = 1.0f - fIntBitsToFloat;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 31) {
            fD = le.d(edgeEffectB, fD, f);
        } else {
            edgeEffectB.onPull(fD, f);
        }
        return (i2 >= 31 ? le.c(edgeEffectB) : 0.0f) == 0.0f ? Float.intBitsToFloat((int) (4294967295L & this.g)) * (-fD) : Float.intBitsToFloat(i);
    }

    public final float f(long j) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (c() & 4294967295L));
        int i = (int) (j >> 32);
        float fIntBitsToFloat2 = Float.intBitsToFloat(i) / Float.intBitsToFloat((int) (this.g >> 32));
        EdgeEffect edgeEffectC = this.c.c();
        float f = 1.0f - fIntBitsToFloat;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 31) {
            fIntBitsToFloat2 = le.d(edgeEffectC, fIntBitsToFloat2, f);
        } else {
            edgeEffectC.onPull(fIntBitsToFloat2, f);
        }
        return (i2 >= 31 ? le.c(edgeEffectC) : 0.0f) == 0.0f ? Float.intBitsToFloat((int) (this.g >> 32)) * fIntBitsToFloat2 : Float.intBitsToFloat(i);
    }

    public final float g(long j) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (c() & 4294967295L));
        int i = (int) (j >> 32);
        float fIntBitsToFloat2 = Float.intBitsToFloat(i) / Float.intBitsToFloat((int) (this.g >> 32));
        EdgeEffect edgeEffectD = this.c.d();
        float fD = -fIntBitsToFloat2;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 31) {
            fD = le.d(edgeEffectD, fD, fIntBitsToFloat);
        } else {
            edgeEffectD.onPull(fD, fIntBitsToFloat);
        }
        return (i2 >= 31 ? le.c(edgeEffectD) : 0.0f) == 0.0f ? Float.intBitsToFloat((int) (this.g >> 32)) * (-fD) : Float.intBitsToFloat(i);
    }

    public final float h(long j) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (c() >> 32));
        int i = (int) (j & 4294967295L);
        float fIntBitsToFloat2 = Float.intBitsToFloat(i) / Float.intBitsToFloat((int) (this.g & 4294967295L));
        EdgeEffect edgeEffectE = this.c.e();
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 31) {
            fIntBitsToFloat2 = le.d(edgeEffectE, fIntBitsToFloat2, fIntBitsToFloat);
        } else {
            edgeEffectE.onPull(fIntBitsToFloat2, fIntBitsToFloat);
        }
        return (i2 >= 31 ? le.c(edgeEffectE) : 0.0f) == 0.0f ? Float.intBitsToFloat((int) (this.g & 4294967295L)) * fIntBitsToFloat2 : Float.intBitsToFloat(i);
    }

    public final void i(long j) {
        boolean zA = xk2.a(this.g, 0L);
        boolean zA2 = xk2.a(j, this.g);
        this.g = j;
        if (!zA2) {
            int iF = hh1.f(Float.intBitsToFloat((int) (j >> 32)));
            long jF = (((long) hh1.f(Float.intBitsToFloat((int) (j & 4294967295L)))) & 4294967295L) | (((long) iF) << 32);
            xg0 xg0Var = this.c;
            xg0Var.c = jF;
            EdgeEffect edgeEffect = xg0Var.d;
            if (edgeEffect != null) {
                edgeEffect.setSize((int) (jF >> 32), (int) (jF & 4294967295L));
            }
            EdgeEffect edgeEffect2 = xg0Var.e;
            if (edgeEffect2 != null) {
                edgeEffect2.setSize((int) (jF >> 32), (int) (jF & 4294967295L));
            }
            EdgeEffect edgeEffect3 = xg0Var.f;
            if (edgeEffect3 != null) {
                edgeEffect3.setSize((int) (jF & 4294967295L), (int) (jF >> 32));
            }
            EdgeEffect edgeEffect4 = xg0Var.g;
            if (edgeEffect4 != null) {
                edgeEffect4.setSize((int) (jF & 4294967295L), (int) (jF >> 32));
            }
            EdgeEffect edgeEffect5 = xg0Var.h;
            if (edgeEffect5 != null) {
                edgeEffect5.setSize((int) (jF >> 32), (int) (jF & 4294967295L));
            }
            EdgeEffect edgeEffect6 = xg0Var.i;
            if (edgeEffect6 != null) {
                edgeEffect6.setSize((int) (jF >> 32), (int) (jF & 4294967295L));
            }
            EdgeEffect edgeEffect7 = xg0Var.j;
            if (edgeEffect7 != null) {
                edgeEffect7.setSize((int) (jF & 4294967295L), (int) (jF >> 32));
            }
            EdgeEffect edgeEffect8 = xg0Var.k;
            if (edgeEffect8 != null) {
                edgeEffect8.setSize((int) (4294967295L & jF), (int) (jF >> 32));
            }
        }
        if (zA || zA2) {
            return;
        }
        a();
    }
}
