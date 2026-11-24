package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ca0 implements md {
    public final p6 a;
    public final g33 b;
    public final Object c;
    public final vd d;
    public final vd e;
    public final vd f;
    public final Object g;
    public final long h;

    public ca0(da0 da0Var, g33 g33Var, Object obj, vd vdVar) {
        p6 p6Var = new p6(da0Var.a);
        this.a = p6Var;
        this.b = g33Var;
        this.c = obj;
        vd vdVar2 = (vd) g33Var.a.j(obj);
        this.d = vdVar2;
        this.e = v53.a(vdVar);
        hq0 hq0Var = g33Var.b;
        if (((vd) p6Var.e) == null) {
            p6Var.e = vdVar2.c();
        }
        vd vdVar3 = (vd) p6Var.e;
        if (vdVar3 == null) {
            g31.f("targetVector");
            throw null;
        }
        int iB = vdVar3.b();
        int i = 0;
        while (true) {
            vd vdVar4 = (vd) p6Var.e;
            if (i >= iB) {
                if (vdVar4 == null) {
                    g31.f("targetVector");
                    throw null;
                }
                this.g = hq0Var.j(vdVar4);
                p6 p6Var2 = this.a;
                vd vdVar5 = this.d;
                if (((vd) p6Var2.c) == null) {
                    p6Var2.c = vdVar5.c();
                }
                vd vdVar6 = (vd) p6Var2.c;
                if (vdVar6 == null) {
                    g31.f("velocityVector");
                    throw null;
                }
                int iB2 = vdVar6.b();
                long jMax = 0;
                for (int i2 = 0; i2 < iB2; i2++) {
                    py0 py0Var = (py0) p6Var2.a;
                    vdVar5.getClass();
                    jMax = Math.max(jMax, ((long) (Math.exp(((em0) py0Var.b).b(vdVar.a(i2)) / (((double) fm0.a) - 1.0d)) * 1000.0d)) * 1000000);
                }
                this.h = jMax;
                vd vdVarA = v53.a(this.a.m(jMax, this.d, vdVar));
                this.f = vdVarA;
                int iB3 = vdVarA.b();
                for (int i3 = 0; i3 < iB3; i3++) {
                    vd vdVar7 = this.f;
                    float fA = vdVar7.a(i3);
                    this.a.getClass();
                    this.a.getClass();
                    vdVar7.e(ky3.b(fA, -0.0f, 0.0f), i3);
                }
                return;
            }
            if (vdVar4 == null) {
                g31.f("targetVector");
                throw null;
            }
            py0 py0Var2 = (py0) p6Var.a;
            float fA2 = vdVar2.a(i);
            float fA3 = vdVar.a(i);
            em0 em0Var = (em0) py0Var2.b;
            double dB = em0Var.b(fA3);
            double d = fm0.a;
            int i4 = i;
            vdVar4.e((Math.signum(fA3) * ((float) (Math.exp((d / (d - 1.0d)) * dB) * ((double) (em0Var.a * em0Var.b))))) + fA2, i4);
            i = i4 + 1;
        }
    }

    @Override // defpackage.md
    public final Object a(long j) {
        if (f(j)) {
            return this.g;
        }
        hq0 hq0Var = this.b.b;
        p6 p6Var = this.a;
        vd vdVar = (vd) p6Var.b;
        vd vdVar2 = this.d;
        if (vdVar == null) {
            p6Var.b = vdVar2.c();
        }
        vd vdVar3 = (vd) p6Var.b;
        if (vdVar3 == null) {
            g31.f("valueVector");
            throw null;
        }
        int iB = vdVar3.b();
        int i = 0;
        while (true) {
            vd vdVar4 = (vd) p6Var.b;
            if (i >= iB) {
                if (vdVar4 != null) {
                    return hq0Var.j(vdVar4);
                }
                g31.f("valueVector");
                throw null;
            }
            if (vdVar4 == null) {
                g31.f("valueVector");
                throw null;
            }
            py0 py0Var = (py0) p6Var.a;
            float fA = vdVar2.a(i);
            long j2 = j / 1000000;
            dm0 dm0VarA = ((em0) py0Var.b).a(this.e.a(i));
            long j3 = dm0VarA.c;
            vdVar4.e((Math.signum(dm0VarA.a) * dm0VarA.b * k9.a(j3 > 0 ? j2 / j3 : 1.0f).a) + fA, i);
            i++;
        }
    }

    @Override // defpackage.md
    public final long b() {
        return this.h;
    }

    @Override // defpackage.md
    public final g33 c() {
        return this.b;
    }

    @Override // defpackage.md
    public final Object d() {
        return this.g;
    }

    @Override // defpackage.md
    public final vd e(long j) {
        if (f(j)) {
            return this.f;
        }
        return this.a.m(j, this.d, this.e);
    }

    @Override // defpackage.md
    public final boolean isInfinite() {
        return false;
    }
}
