package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class vt1 extends dk1 implements f71, qf0 {
    public boolean H;
    public ll X;
    public el1 Y;
    public float Z;
    public nl c0;
    public tt1 x;

    public static boolean J0(long j) {
        return !xk2.a(j, 9205357640488583168L) && (Float.floatToRawIntBits(Float.intBitsToFloat((int) (j & 4294967295L))) & Integer.MAX_VALUE) < 2139095040;
    }

    public static boolean K0(long j) {
        return !xk2.a(j, 9205357640488583168L) && (Float.floatToRawIntBits(Float.intBitsToFloat((int) (j >> 32))) & Integer.MAX_VALUE) < 2139095040;
    }

    @Override // defpackage.f71
    public final int B(mf1 mf1Var, jh1 jh1Var, int i) {
        if (!I0()) {
            return jh1Var.e0(i);
        }
        long jL0 = L0(r40.b(i, 0, 13));
        return Math.max(q40.i(jL0), jh1Var.e0(i));
    }

    public final boolean I0() {
        return this.H && this.x.d() != 9205357640488583168L;
    }

    public final long L0(long j) {
        boolean z = false;
        boolean z2 = q40.d(j) && q40.c(j);
        if (q40.f(j) && q40.e(j)) {
            z = true;
        }
        if ((!I0() && z2) || z) {
            return q40.a(j, q40.h(j), 0, q40.g(j), 0, 10);
        }
        long jD = this.x.d();
        int iRound = K0(jD) ? Math.round(Float.intBitsToFloat((int) (jD >> 32))) : q40.j(j);
        int iRound2 = J0(jD) ? Math.round(Float.intBitsToFloat((int) (jD & 4294967295L))) : q40.i(j);
        long jFloatToRawIntBits = (((long) Float.floatToRawIntBits(r40.f(iRound2, j))) & 4294967295L) | (((long) Float.floatToRawIntBits(r40.g(iRound, j))) << 32);
        if (I0()) {
            long jFloatToRawIntBits2 = (((long) Float.floatToRawIntBits(!K0(this.x.d()) ? Float.intBitsToFloat((int) (jFloatToRawIntBits >> 32)) : Float.intBitsToFloat((int) (this.x.d() >> 32)))) << 32) | (((long) Float.floatToRawIntBits(!J0(this.x.d()) ? Float.intBitsToFloat((int) (jFloatToRawIntBits & 4294967295L)) : Float.intBitsToFloat((int) (this.x.d() & 4294967295L)))) & 4294967295L);
            jFloatToRawIntBits = (Float.intBitsToFloat((int) (jFloatToRawIntBits >> 32)) == 0.0f || Float.intBitsToFloat((int) (jFloatToRawIntBits & 4294967295L)) == 0.0f) ? 0L : qz3.a(jFloatToRawIntBits2, this.Y.l(jFloatToRawIntBits2, jFloatToRawIntBits));
        }
        return q40.a(j, r40.g(Math.round(Float.intBitsToFloat((int) (jFloatToRawIntBits >> 32))), j), 0, r40.f(Math.round(Float.intBitsToFloat((int) (jFloatToRawIntBits & 4294967295L))), j), 0, 10);
    }

    @Override // defpackage.qf0
    public final void N(p71 p71Var) {
        ew ewVar = p71Var.a;
        long jD = this.x.d();
        long jFloatToRawIntBits = (((long) Float.floatToRawIntBits(K0(jD) ? Float.intBitsToFloat((int) (jD >> 32)) : Float.intBitsToFloat((int) (ewVar.c() >> 32)))) << 32) | (((long) Float.floatToRawIntBits(J0(jD) ? Float.intBitsToFloat((int) (jD & 4294967295L)) : Float.intBitsToFloat((int) (ewVar.c() & 4294967295L)))) & 4294967295L);
        long jA = (Float.intBitsToFloat((int) (ewVar.c() >> 32)) == 0.0f || Float.intBitsToFloat((int) (ewVar.c() & 4294967295L)) == 0.0f) ? 0L : qz3.a(jFloatToRawIntBits, this.Y.l(jFloatToRawIntBits, ewVar.c()));
        long jA2 = this.X.a((((long) Math.round(Float.intBitsToFloat((int) (jA >> 32)))) << 32) | (((long) Math.round(Float.intBitsToFloat((int) (jA & 4294967295L)))) & 4294967295L), (((long) Math.round(Float.intBitsToFloat((int) (ewVar.c() >> 32)))) << 32) | (((long) Math.round(Float.intBitsToFloat((int) (ewVar.c() & 4294967295L)))) & 4294967295L), p71Var.getLayoutDirection());
        float f = (int) (jA2 >> 32);
        float f2 = (int) (jA2 & 4294967295L);
        ((q82) ewVar.b.b).J(f, f2);
        try {
            this.x.c(p71Var, jA, this.Z, this.c0);
            ((q82) ewVar.b.b).J(-f, -f2);
            p71Var.a();
        } catch (Throwable th) {
            ((q82) ewVar.b.b).J(-f, -f2);
            throw th;
        }
    }

    @Override // defpackage.f71
    public final int S(mf1 mf1Var, jh1 jh1Var, int i) {
        if (!I0()) {
            return jh1Var.V(i);
        }
        long jL0 = L0(r40.b(0, i, 7));
        return Math.max(q40.j(jL0), jh1Var.V(i));
    }

    @Override // defpackage.f71
    public final ph1 d(qh1 qh1Var, jh1 jh1Var, long j) {
        zw1 zw1VarE = jh1Var.e(L0(j));
        return qh1Var.j0(zw1VarE.a, zw1VarE.b, ji0.a, new d7(zw1VarE, 5));
    }

    @Override // defpackage.f71
    public final int e(mf1 mf1Var, jh1 jh1Var, int i) {
        if (!I0()) {
            return jh1Var.c0(i);
        }
        long jL0 = L0(r40.b(0, i, 7));
        return Math.max(q40.j(jL0), jh1Var.c0(i));
    }

    @Override // defpackage.f71
    public final int n(mf1 mf1Var, jh1 jh1Var, int i) {
        if (!I0()) {
            return jh1Var.f(i);
        }
        long jL0 = L0(r40.b(i, 0, 13));
        return Math.max(q40.i(jL0), jh1Var.f(i));
    }

    public final String toString() {
        return "PainterModifier(painter=" + this.x + ", sizeToIntrinsics=" + this.H + ", alignment=" + this.X + ", alpha=" + this.Z + ", colorFilter=" + this.c0 + ')';
    }

    @Override // defpackage.dk1
    public final boolean x0() {
        return false;
    }
}
