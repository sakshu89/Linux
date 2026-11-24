package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class pf1 implements y61 {
    public final of1 a;

    public pf1(of1 of1Var) {
        this.a = of1Var;
    }

    @Override // defpackage.y61
    public final long A(long j) {
        return jp1.e(this.a.x.A(j), b());
    }

    @Override // defpackage.y61
    public final boolean B() {
        return this.a.x.V0().w;
    }

    @Override // defpackage.y61
    public final void D(float[] fArr) {
        this.a.x.D(fArr);
    }

    @Override // defpackage.y61
    public final long H(y61 y61Var, long j) {
        boolean z = y61Var instanceof pf1;
        of1 of1Var = this.a;
        if (!z) {
            of1 of1VarA = ar4.a(of1Var);
            co1 co1Var = of1VarA.x;
            long jH = H(of1VarA.Y, j);
            long j2 = of1VarA.H;
            long jD = jp1.d(jH, (4294967295L & ((long) Float.floatToRawIntBits((int) (j2 & 4294967295L)))) | (Float.floatToRawIntBits((int) (j2 >> 32)) << 32));
            if (!co1Var.V0().w) {
                z01.b("LayoutCoordinate operations are only valid when isAttached is true");
            }
            co1Var.e1();
            co1 co1Var2 = co1Var.X;
            if (co1Var2 != null) {
                co1Var = co1Var2;
            }
            return jp1.e(jD, co1Var.H(y61Var, 0L));
        }
        of1 of1Var2 = ((pf1) y61Var).a;
        co1 co1Var3 = of1Var2.x;
        co1Var3.e1();
        of1 of1VarT0 = of1Var.x.R0(co1Var3).T0();
        if (of1VarT0 != null) {
            long jB = e21.b(e21.c(of1Var2.N0(of1VarT0, false), ap4.b(j)), of1Var.N0(of1VarT0, false));
            return (((long) Float.floatToRawIntBits((int) (jB >> 32))) << 32) | (((long) Float.floatToRawIntBits((int) (jB & 4294967295L))) & 4294967295L);
        }
        of1 of1VarA2 = ar4.a(of1Var2);
        long jC = e21.c(e21.c(of1Var2.N0(of1VarA2, false), of1VarA2.H), ap4.b(j));
        of1 of1VarA3 = ar4.a(of1Var);
        long jB2 = e21.b(jC, e21.c(of1Var.N0(of1VarA3, false), of1VarA3.H));
        long jFloatToRawIntBits = Float.floatToRawIntBits((int) (jB2 >> 32));
        long jFloatToRawIntBits2 = ((long) Float.floatToRawIntBits((int) (jB2 & 4294967295L))) & 4294967295L;
        co1 co1Var4 = of1VarA3.x.X;
        co1Var4.getClass();
        co1 co1Var5 = of1VarA2.x.X;
        co1Var5.getClass();
        return co1Var4.H(co1Var5, jFloatToRawIntBits2 | (jFloatToRawIntBits << 32));
    }

    @Override // defpackage.y61
    public final void J(y61 y61Var, float[] fArr) {
        this.a.x.J(y61Var, fArr);
    }

    @Override // defpackage.y61
    public final l42 N(y61 y61Var, boolean z) {
        return this.a.x.N(y61Var, z);
    }

    @Override // defpackage.y61
    public final long S() {
        of1 of1Var = this.a;
        return (((long) of1Var.a) << 32) | (((long) of1Var.b) & 4294967295L);
    }

    @Override // defpackage.y61
    public final long U(long j) {
        return this.a.x.U(jp1.e(j, b()));
    }

    @Override // defpackage.y61
    public final long a(long j) {
        return this.a.x.a(jp1.e(0L, b()));
    }

    public final long b() {
        of1 of1Var = this.a;
        of1 of1VarA = ar4.a(of1Var);
        return jp1.d(H(of1VarA.Y, 0L), of1Var.x.H(of1VarA.x, 0L));
    }

    @Override // defpackage.y61
    public final long h(long j) {
        return jp1.e(this.a.x.h(j), b());
    }

    @Override // defpackage.y61
    public final long i(long j) {
        return this.a.x.i(jp1.e(j, b()));
    }

    @Override // defpackage.y61
    public final y61 m() {
        of1 of1VarT0;
        if (!B()) {
            z01.b("LayoutCoordinate operations are only valid when isAttached is true");
        }
        co1 co1Var = this.a.x.x.o0.d.X;
        if (co1Var == null || (of1VarT0 = co1Var.T0()) == null) {
            return null;
        }
        return of1VarT0.Y;
    }

    @Override // defpackage.y61
    public final long u(y61 y61Var, long j) {
        return H(y61Var, j);
    }
}
