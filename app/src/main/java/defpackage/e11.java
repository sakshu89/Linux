package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class e11 extends of1 {
    @Override // defpackage.of1
    public final void L0() {
        sf1 sf1Var = this.x.x.p0.q;
        sf1Var.getClass();
        sf1Var.z0();
    }

    @Override // defpackage.jh1
    public final int V(int i) {
        l11 l11VarT = this.x.x.t();
        oh1 oh1VarZ = l11VarT.z();
        n71 n71Var = (n71) l11VarT.b;
        return oh1VarZ.i(n71Var.o0.d, n71Var.l(), i);
    }

    @Override // defpackage.jh1
    public final int c0(int i) {
        l11 l11VarT = this.x.x.t();
        oh1 oh1VarZ = l11VarT.z();
        n71 n71Var = (n71) l11VarT.b;
        return oh1VarZ.c(n71Var.o0.d, n71Var.l(), i);
    }

    @Override // defpackage.jh1
    public final zw1 e(long j) {
        q0(j);
        co1 co1Var = this.x;
        pm1 pm1VarZ = co1Var.x.z();
        Object[] objArr = pm1VarZ.a;
        int i = pm1VarZ.c;
        for (int i2 = 0; i2 < i; i2++) {
            sf1 sf1Var = ((n71) objArr[i2]).p0.q;
            sf1Var.getClass();
            sf1Var.s = l71.c;
        }
        n71 n71Var = co1Var.x;
        of1.K0(this, n71Var.f0.f(this, n71Var.l(), j));
        return this;
    }

    @Override // defpackage.jh1
    public final int e0(int i) {
        l11 l11VarT = this.x.x.t();
        oh1 oh1VarZ = l11VarT.z();
        n71 n71Var = (n71) l11VarT.b;
        return oh1VarZ.g(n71Var.o0.d, n71Var.l(), i);
    }

    @Override // defpackage.jh1
    public final int f(int i) {
        l11 l11VarT = this.x.x.t();
        oh1 oh1VarZ = l11VarT.z();
        n71 n71Var = (n71) l11VarT.b;
        return oh1VarZ.a(n71Var.o0.d, n71Var.l(), i);
    }

    @Override // defpackage.mf1
    public final int t0(d6 d6Var) {
        sf1 sf1Var = this.x.x.p0.q;
        sf1Var.getClass();
        r71 r71Var = sf1Var.i;
        j71 j71Var = r71Var.d;
        o71 o71Var = sf1Var.X;
        if (j71Var == j71.b) {
            o71Var.d = true;
            if (o71Var.b) {
                r71Var.f = true;
                r71Var.g = true;
            }
        } else {
            o71Var.e = true;
        }
        e11 e11Var = sf1Var.p().B0;
        if (e11Var != null) {
            e11Var.t = true;
        }
        sf1Var.r();
        e11 e11Var2 = sf1Var.p().B0;
        if (e11Var2 != null) {
            e11Var2.t = false;
        }
        Integer num = (Integer) o71Var.g.get(d6Var);
        int iIntValue = num != null ? num.intValue() : Integer.MIN_VALUE;
        this.c0.g(iIntValue, d6Var);
        return iIntValue;
    }
}
