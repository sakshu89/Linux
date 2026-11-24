package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class nk extends dk1 implements qf0, ep1, eg2 {
    public hn H;
    public float X;
    public yj2 Y;
    public long Z;
    public z61 c0;
    public es4 d0;
    public yj2 e0;
    public es4 f0;
    public long x;

    @Override // defpackage.ep1
    public final void J() {
        this.Z = 9205357640488583168L;
        this.c0 = null;
        this.d0 = null;
        this.e0 = null;
        vm4.a(this);
    }

    @Override // defpackage.qf0
    public final void N(p71 p71Var) {
        es4 es4Var;
        char c;
        long j;
        hn hnVar;
        na naVar;
        ew ewVar = p71Var.a;
        if (this.Y == y34.a) {
            if (!sz.c(this.x, sz.g)) {
                rf0.E(p71Var, this.x, 0L, 126);
            }
            hn hnVar2 = this.H;
            if (hnVar2 != null) {
                rf0.W(p71Var, hnVar2, 0L, 0L, this.X, null, 118);
            }
        } else {
            if (xk2.a(ewVar.c(), this.Z) && p71Var.getLayoutDirection() == this.c0 && g31.a(this.e0, this.Y)) {
                es4Var = this.d0;
                es4Var.getClass();
            } else {
                tr4.a(this, new zb(2, this, p71Var));
                es4Var = this.f0;
                this.f0 = null;
            }
            es4 es4Var2 = es4Var;
            this.d0 = es4Var2;
            this.Z = ewVar.c();
            this.c0 = p71Var.getLayoutDirection();
            this.e0 = this.Y;
            es4Var2.getClass();
            boolean zC = sz.c(this.x, sz.g);
            ql0 ql0Var = ql0.a;
            if (zC) {
                c = ' ';
                j = 4294967295L;
            } else {
                long j2 = this.x;
                if (es4Var2 instanceof us1) {
                    l42 l42Var = ((us1) es4Var2).a;
                    float f = l42Var.a;
                    p71Var.M(j2, (((long) Float.floatToRawIntBits(l42Var.b)) & 4294967295L) | (Float.floatToRawIntBits(f) << 32), fs4.a(l42Var), ql0Var, 3);
                    ql0Var = ql0Var;
                } else if (es4Var2 instanceof vs1) {
                    vs1 vs1Var = (vs1) es4Var2;
                    na naVar2 = vs1Var.b;
                    if (naVar2 != null) {
                        p71Var.m0(naVar2, j2, 1.0f, ql0Var);
                        ql0Var = ql0Var;
                    } else {
                        ql0Var = ql0Var;
                        s82 s82Var = vs1Var.a;
                        float f2 = s82Var.b;
                        float f3 = s82Var.a;
                        float fIntBitsToFloat = Float.intBitsToFloat((int) (s82Var.h >> 32));
                        c = ' ';
                        j = 4294967295L;
                        long jFloatToRawIntBits = (((long) Float.floatToRawIntBits(f2)) & 4294967295L) | (Float.floatToRawIntBits(f3) << 32);
                        long jFloatToRawIntBits2 = (((long) Float.floatToRawIntBits(s82Var.c - f3)) << 32) | (((long) Float.floatToRawIntBits(s82Var.d - f2)) & 4294967295L);
                        long jFloatToRawIntBits3 = (((long) Float.floatToRawIntBits(fIntBitsToFloat)) & 4294967295L) | (Float.floatToRawIntBits(fIntBitsToFloat) << 32);
                        int i = (int) (jFloatToRawIntBits >> 32);
                        int i2 = (int) (jFloatToRawIntBits & 4294967295L);
                        ewVar.a.c.k(Float.intBitsToFloat(i), Float.intBitsToFloat(i2), Float.intBitsToFloat((int) (jFloatToRawIntBits2 >> 32)) + Float.intBitsToFloat(i), Float.intBitsToFloat((int) (jFloatToRawIntBits2 & 4294967295L)) + Float.intBitsToFloat(i2), Float.intBitsToFloat((int) (jFloatToRawIntBits3 >> 32)), Float.intBitsToFloat((int) (jFloatToRawIntBits3 & 4294967295L)), ew.a(ewVar, j2, ql0Var, 1.0f, 3));
                    }
                } else {
                    c = ' ';
                    j = 4294967295L;
                    if (!(es4Var2 instanceof ts1)) {
                        dk0.l();
                        return;
                    } else {
                        p71Var.m0(((ts1) es4Var2).a, j2, 1.0f, ql0Var);
                        ql0Var = ql0Var;
                    }
                }
                c = ' ';
                j = 4294967295L;
            }
            hn hnVar3 = this.H;
            if (hnVar3 != null) {
                float f4 = this.X;
                if (es4Var2 instanceof us1) {
                    l42 l42Var2 = ((us1) es4Var2).a;
                    p71Var.z(hnVar3, (((long) Float.floatToRawIntBits(l42Var2.a)) << c) | (((long) Float.floatToRawIntBits(l42Var2.b)) & j), fs4.a(l42Var2), f4, ql0Var);
                } else {
                    if (es4Var2 instanceof vs1) {
                        vs1 vs1Var2 = (vs1) es4Var2;
                        hnVar = hnVar3;
                        naVar = vs1Var2.b;
                        if (naVar == null) {
                            s82 s82Var2 = vs1Var2.a;
                            float f5 = s82Var2.b;
                            float f6 = s82Var2.a;
                            float fIntBitsToFloat2 = Float.intBitsToFloat((int) (s82Var2.h >> c));
                            p71Var.e(hnVar, (((long) Float.floatToRawIntBits(f6)) << c) | (((long) Float.floatToRawIntBits(f5)) & j), (((long) Float.floatToRawIntBits(s82Var2.c - f6)) << c) | (((long) Float.floatToRawIntBits(s82Var2.d - f5)) & j), (((long) Float.floatToRawIntBits(fIntBitsToFloat2)) & j) | (Float.floatToRawIntBits(fIntBitsToFloat2) << c), f4, ql0Var);
                        }
                    } else if (!(es4Var2 instanceof ts1)) {
                        dk0.l();
                        return;
                    } else {
                        hnVar = hnVar3;
                        naVar = ((ts1) es4Var2).a;
                    }
                    p71Var.g(naVar, hnVar, f4, ql0Var, 3);
                }
            }
        }
        p71Var.a();
    }

    @Override // defpackage.eg2
    public final void e0(og2 og2Var) {
        mg2.d(og2Var, this.Y);
    }

    @Override // defpackage.eg2
    public final boolean h() {
        return false;
    }
}
