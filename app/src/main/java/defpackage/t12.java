package defpackage;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class t12 {
    public static final f80 a = uk1.b;

    public static final void a(ek1 ek1Var, final long j, final float f, long j2, int i, float f2, x20 x20Var, final int i2) {
        ek1 ek1Var2;
        final long j3;
        final int i3;
        final float f3;
        float f4;
        final long j4;
        int i4;
        x20Var.X(333154241);
        int i5 = i2 | 222208;
        if (x20Var.O(i5 & 1, (74899 & i5) != 74898)) {
            x20Var.T();
            if ((i2 & 1) == 0 || x20Var.y()) {
                f4 = 4.0f;
                j4 = sz.f;
                i4 = 1;
            } else {
                x20Var.R();
                j4 = j2;
                i4 = i;
                f4 = f2;
            }
            x20Var.q();
            final int i6 = i4;
            final ks2 ks2Var = new ks2(((jc0) x20Var.j(l30.h)).x(f), 0.0f, i6, 0, 26);
            Object objL = x20Var.L();
            Object obj = r20.a;
            if (objL == obj) {
                objL = new s01();
                x20Var.g0(objL);
            }
            s01 s01Var = (s01) objL;
            s01Var.a(x20Var, 0);
            final q01 q01VarA = xo4.a(s01Var, 0.0f, 1080.0f, new p01(ie4.e(6000, ug0.b, 2)), x20Var);
            va1 va1Var = new va1(8);
            x51 x51Var = new x51();
            va1Var.j(x51Var);
            final q01 q01VarA2 = xo4.a(s01Var, 0.0f, 360.0f, new p01(new y51(x51Var)), x20Var);
            x51 x51Var2 = new x51();
            x51Var2.a = 6000;
            x51Var2.a(Float.valueOf(0.87f), 3000).b = a;
            x51Var2.a(Float.valueOf(0.1f), 6000);
            final q01 q01VarA3 = xo4.a(s01Var, 0.1f, 0.87f, new p01(new y51(x51Var2)), x20Var);
            va1 va1Var2 = new va1(9);
            AtomicInteger atomicInteger = dg2.a;
            uf ufVar = new uf(va1Var2, true);
            ek1Var2 = ek1Var;
            ek1 ek1VarG = w44.g(ek1Var2.c(ufVar), 40.0f);
            boolean zF = x20Var.f(q01VarA3) | x20Var.f(q01VarA) | x20Var.f(q01VarA2) | x20Var.e(j4) | x20Var.h(ks2Var);
            Object objL2 = x20Var.L();
            if (zF || objL2 == obj) {
                final float f5 = f4;
                Object obj2 = new hq0() { // from class: r12
                    @Override // defpackage.hq0
                    public final Object j(Object obj3) {
                        long j5 = j4;
                        ks2 ks2Var2 = ks2Var;
                        long j6 = j;
                        rf0 rf0Var = (rf0) obj3;
                        float fFloatValue = ((Number) q01VarA3.getValue()).floatValue() * 360.0f;
                        int i7 = i6;
                        float f6 = f5;
                        if (i7 != 0 && Float.intBitsToFloat((int) (rf0Var.c() & 4294967295L)) <= Float.intBitsToFloat((int) (rf0Var.c() >> 32))) {
                            f6 += f;
                        }
                        float fU0 = (f6 / ((float) (((double) rf0Var.u0(Float.intBitsToFloat((int) (rf0Var.c() >> 32)))) * 3.141592653589793d))) * 360.0f;
                        float fFloatValue2 = ((Number) q01VarA2.getValue()).floatValue() + ((Number) q01VarA.getValue()).floatValue();
                        long jX = rf0Var.X();
                        kf kfVarC = rf0Var.C();
                        long jR = kfVarC.r();
                        kfVarC.m().m();
                        try {
                            ((q82) kfVarC.b).G(fFloatValue2, jX);
                            t12.b(rf0Var, Math.min(fFloatValue, fU0) + fFloatValue, (360.0f - fFloatValue) - (Math.min(fFloatValue, fU0) * 2.0f), j5, ks2Var2);
                            t12.b(rf0Var, 0.0f, fFloatValue, j6, ks2Var2);
                            return q43.a;
                        } finally {
                            cq.t(kfVarC, jR);
                        }
                    }
                };
                i6 = i6;
                x20Var.g0(obj2);
                objL2 = obj2;
            }
            dh4.a(ek1VarG, (hq0) objL2, x20Var, 0);
            f3 = f4;
            i3 = i6;
            j3 = j4;
        } else {
            ek1Var2 = ek1Var;
            x20Var.R();
            j3 = j2;
            i3 = i;
            f3 = f2;
        }
        a42 a42VarR = x20Var.r();
        if (a42VarR != null) {
            final ek1 ek1Var3 = ek1Var2;
            a42VarR.d = new vq0(j, f, j3, i3, f3, i2) { // from class: s12
                public final /* synthetic */ long b;
                public final /* synthetic */ float c;
                public final /* synthetic */ long e;
                public final /* synthetic */ int f;
                public final /* synthetic */ float i;

                @Override // defpackage.vq0
                public final Object e(Object obj3, Object obj4) {
                    ((Integer) obj4).getClass();
                    int iC = ny3.c(439);
                    t12.a(this.a, this.b, this.c, this.e, this.f, this.i, (x20) obj3, iC);
                    return q43.a;
                }
            };
        }
    }

    public static final void b(rf0 rf0Var, float f, float f2, long j, ks2 ks2Var) {
        float f3 = ks2Var.a / 2.0f;
        float fIntBitsToFloat = Float.intBitsToFloat((int) (rf0Var.c() >> 32)) - (2.0f * f3);
        rf0Var.j(j, f, f2, (((long) Float.floatToRawIntBits(f3)) << 32) | (((long) Float.floatToRawIntBits(f3)) & 4294967295L), (((long) Float.floatToRawIntBits(fIntBitsToFloat)) << 32) | (((long) Float.floatToRawIntBits(fIntBitsToFloat)) & 4294967295L), ks2Var);
    }
}
