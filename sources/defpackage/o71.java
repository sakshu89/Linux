package defpackage;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class o71 {
    public final i6 a;
    public boolean c;
    public boolean d;
    public boolean e;
    public i6 f;
    public final /* synthetic */ int h;
    public boolean b = true;
    public final HashMap g = new HashMap();

    public o71(i6 i6Var, int i) {
        this.h = i;
        this.a = i6Var;
    }

    public static final void a(o71 o71Var, d6 d6Var, int i, co1 co1Var) {
        HashMap map = o71Var.g;
        float f = i;
        long jFloatToRawIntBits = ((long) Float.floatToRawIntBits(f)) << 32;
        long jFloatToRawIntBits2 = ((long) Float.floatToRawIntBits(f)) & 4294967295L;
        while (true) {
            long jA = jFloatToRawIntBits | jFloatToRawIntBits2;
            do {
                switch (o71Var.h) {
                    case 0:
                        ht1 ht1Var = co1Var.u0;
                        if (ht1Var != null) {
                            yu0 yu0Var = (yu0) ht1Var;
                            float[] fArrB = yu0Var.b();
                            if (!yu0Var.Z) {
                                jA = ih1.b(jA, fArrB);
                            }
                        }
                        jA = ap4.a(jA, co1Var.i0);
                        break;
                    default:
                        of1 of1VarT0 = co1Var.T0();
                        of1VarT0.getClass();
                        long j = of1VarT0.H;
                        jA = jp1.e((((long) Float.floatToRawIntBits((int) (j & 4294967295L))) & 4294967295L) | (((long) Float.floatToRawIntBits((int) (j >> 32))) << 32), jA);
                        break;
                }
                co1Var = co1Var.X;
                co1Var.getClass();
                if (co1Var.equals(o71Var.a.p())) {
                    int iRound = Math.round(d6Var instanceof qw0 ? Float.intBitsToFloat((int) (jA & 4294967295L)) : Float.intBitsToFloat((int) (jA >> 32)));
                    if (map.containsKey(d6Var)) {
                        int iIntValue = ((Number) bh1.a(d6Var, map)).intValue();
                        qw0 qw0Var = g6.a;
                        iRound = ((Number) d6Var.a.e(Integer.valueOf(iIntValue), Integer.valueOf(iRound))).intValue();
                    }
                    map.put(d6Var, Integer.valueOf(iRound));
                    return;
                }
            } while (!o71Var.b(co1Var).containsKey(d6Var));
            float fC = o71Var.c(co1Var, d6Var);
            long jFloatToRawIntBits3 = Float.floatToRawIntBits(fC);
            long jFloatToRawIntBits4 = Float.floatToRawIntBits(fC);
            jFloatToRawIntBits = jFloatToRawIntBits3 << 32;
            jFloatToRawIntBits2 = jFloatToRawIntBits4 & 4294967295L;
        }
    }

    public final Map b(co1 co1Var) {
        switch (this.h) {
            case 0:
                return co1Var.D0().d();
            default:
                of1 of1VarT0 = co1Var.T0();
                of1VarT0.getClass();
                return of1VarT0.D0().d();
        }
    }

    public final int c(co1 co1Var, d6 d6Var) {
        switch (this.h) {
            case 0:
                return co1Var.y0(d6Var);
            default:
                of1 of1VarT0 = co1Var.T0();
                of1VarT0.getClass();
                return of1VarT0.y0(d6Var);
        }
    }

    public final boolean d() {
        return this.c || this.d || this.e;
    }

    public final boolean e() {
        h();
        return this.f != null;
    }

    public final void f() {
        this.b = true;
        i6 i6Var = this.a;
        i6 i6VarQ = i6Var.q();
        if (i6VarQ == null) {
            return;
        }
        if (this.c) {
            i6VarQ.requestLayout();
        }
        if (this.d) {
            i6Var.b0();
        }
        if (this.e) {
            i6Var.requestLayout();
        }
        i6VarQ.d().f();
    }

    public final void g() {
        HashMap map = this.g;
        map.clear();
        h6 h6Var = new h6(0, this);
        i6 i6Var = this.a;
        i6Var.n(h6Var);
        map.putAll(b(i6Var.p()));
        this.b = false;
    }

    public final void h() {
        o71 o71VarD;
        o71 o71VarD2;
        boolean zD = d();
        i6 i6Var = this.a;
        if (!zD) {
            i6 i6VarQ = i6Var.q();
            if (i6VarQ == null) {
                return;
            }
            i6Var = i6VarQ.d().f;
            if (i6Var == null || !i6Var.d().d()) {
                i6 i6Var2 = this.f;
                if (i6Var2 == null || i6Var2.d().d()) {
                    return;
                }
                i6 i6VarQ2 = i6Var2.q();
                if (i6VarQ2 != null && (o71VarD2 = i6VarQ2.d()) != null) {
                    o71VarD2.h();
                }
                i6 i6VarQ3 = i6Var2.q();
                i6Var = (i6VarQ3 == null || (o71VarD = i6VarQ3.d()) == null) ? null : o71VarD.f;
            }
        }
        this.f = i6Var;
    }
}
