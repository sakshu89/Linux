package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class du1 {
    public String a;
    public yz2 b;
    public qo0 c;
    public int d;
    public boolean e;
    public int f;
    public int g;
    public jc0 i;
    public ia j;
    public boolean k;
    public pj1 m;
    public cu1 n;
    public z61 o;
    public long s;
    public long h = d11.a;
    public long l = 0;
    public long p = r40.h(0, 0, 0, 0);
    public int q = -1;
    public int r = -1;

    public du1(String str, yz2 yz2Var, qo0 qo0Var, int i, boolean z, int i2, int i3) {
        this.a = str;
        this.b = yz2Var;
        this.c = qo0Var;
        this.d = i;
        this.e = z;
        this.f = i2;
        this.g = i3;
    }

    public static long f(du1 du1Var, long j, z61 z61Var) {
        int i;
        yz2 yz2Var = du1Var.b;
        pj1 pj1Var = du1Var.m;
        jc0 jc0Var = du1Var.i;
        jc0Var.getClass();
        qo0 qo0Var = du1Var.c;
        if ((pj1Var == null || z61Var != pj1Var.a || !lc4.b(yz2Var, z61Var).equals(pj1Var.b) || jc0Var.b() != pj1Var.c.a || qo0Var != pj1Var.d) && ((pj1Var = pj1.h) == null || z61Var != pj1Var.a || !lc4.b(yz2Var, z61Var).equals(pj1Var.b) || jc0Var.b() != pj1Var.c.a || qo0Var != pj1Var.d)) {
            pj1Var = new pj1(z61Var, lc4.b(yz2Var, z61Var), new kc0(jc0Var.b(), jc0Var.l()), qo0Var);
            pj1.h = pj1Var;
        }
        du1Var.m = pj1Var;
        int i2 = du1Var.g;
        kc0 kc0Var = pj1Var.c;
        float f = pj1Var.g;
        float f2 = pj1Var.f;
        if (Float.isNaN(f) || Float.isNaN(f2)) {
            float fB = e8.a(qj1.a, pj1Var.e, r40.b(0, 0, 15), kc0Var, pj1Var.d, 1, 96).b();
            float fB2 = e8.a(qj1.b, pj1Var.e, r40.b(0, 0, 15), kc0Var, pj1Var.d, 2, 96).b() - fB;
            pj1Var.g = fB;
            pj1Var.f = fB2;
            f2 = fB2;
            f = fB;
        }
        if (i2 != 1) {
            int iRound = Math.round((f2 * (i2 - 1)) + f);
            i = iRound >= 0 ? iRound : 0;
            int iG = q40.g(j);
            if (i > iG) {
                i = iG;
            }
        } else {
            i = q40.i(j);
        }
        return r40.a(q40.j(j), q40.h(j), i, q40.g(j));
    }

    public final int a(int i, z61 z61Var) {
        int i2 = this.q;
        int i3 = this.r;
        if (i == i2 && i2 != -1) {
            return i3;
        }
        long jA = r40.a(0, i, 0, Integer.MAX_VALUE);
        if (this.g > 1) {
            jA = f(this, jA, z61Var);
        }
        cu1 cu1VarE = e(z61Var);
        long jA2 = wp4.a(jA, this.e, this.d, cu1VarE.c());
        boolean z = this.e;
        int i4 = this.d;
        int i5 = this.f;
        int iA = mb4.a(new ia((ma) cu1VarE, ((z || !(i4 == 2 || i4 == 4 || i4 == 5)) && i5 >= 1) ? i5 : 1, i4, jA2).b());
        int i6 = q40.i(jA);
        if (iA < i6) {
            iA = i6;
        }
        this.q = i;
        this.r = iA;
        return iA;
    }

    public final boolean b(long j, z61 z61Var) {
        cu1 cu1Var;
        this.s = (this.s << 2) | 3;
        boolean z = true;
        long jF = this.g > 1 ? f(this, j, z61Var) : j;
        ia iaVar = this.j;
        boolean z2 = false;
        if (iaVar != null && (cu1Var = this.n) != null && !cu1Var.b() && z61Var == this.o && (q40.b(jF, this.p) || (q40.h(jF) == q40.h(this.p) && q40.j(jF) == q40.j(this.p) && q40.g(jF) >= iaVar.b() && !iaVar.d.d))) {
            if (!q40.b(jF, this.p)) {
                ia iaVar2 = this.j;
                iaVar2.getClass();
                long jD = r40.d(jF, (((long) mb4.a(Math.min(iaVar2.a.n.c(), iaVar2.d()))) << 32) | (((long) mb4.a(iaVar2.b())) & 4294967295L));
                this.l = jD;
                if (this.d == 3 || (((int) (jD >> 32)) >= iaVar2.d() && ((int) (4294967295L & jD)) >= iaVar2.b())) {
                    z = false;
                }
                this.k = z;
                this.p = jF;
            }
            return false;
        }
        cu1 cu1VarE = e(z61Var);
        long jA = wp4.a(jF, this.e, this.d, cu1VarE.c());
        boolean z3 = this.e;
        int i = this.d;
        int i2 = this.f;
        ia iaVar3 = new ia((ma) cu1VarE, ((z3 || !(i == 2 || i == 4 || i == 5)) && i2 >= 1) ? i2 : 1, i, jA);
        this.p = jF;
        long jD2 = r40.d(jF, (((long) mb4.a(iaVar3.b())) & 4294967295L) | (((long) mb4.a(iaVar3.d())) << 32));
        this.l = jD2;
        if (this.d != 3 && (((int) (jD2 >> 32)) < iaVar3.d() || ((int) (jD2 & 4294967295L)) < iaVar3.b())) {
            z2 = true;
        }
        this.k = z2;
        this.j = iaVar3;
        return true;
    }

    public final void c() {
        this.j = null;
        this.n = null;
        this.o = null;
        this.q = -1;
        this.r = -1;
        this.p = r40.h(0, 0, 0, 0);
        this.l = 0L;
        this.k = false;
    }

    public final void d(jc0 jc0Var) {
        long jA;
        jc0 jc0Var2 = this.i;
        if (jc0Var != null) {
            int i = d11.b;
            jA = d11.a(jc0Var.b(), jc0Var.l());
        } else {
            jA = d11.a;
        }
        if (jc0Var2 == null) {
            this.i = jc0Var;
            this.h = jA;
        } else if (jc0Var == null || this.h != jA) {
            this.i = jc0Var;
            this.h = jA;
            this.s = (this.s << 2) | 1;
            c();
        }
    }

    public final cu1 e(z61 z61Var) {
        cu1 maVar = this.n;
        if (maVar == null || z61Var != this.o || maVar.b()) {
            this.o = z61Var;
            String str = this.a;
            yz2 yz2VarB = lc4.b(this.b, z61Var);
            jc0 jc0Var = this.i;
            jc0Var.getClass();
            qo0 qo0Var = this.c;
            ii0 ii0Var = ii0.a;
            maVar = new ma(str, yz2VarB, ii0Var, ii0Var, qo0Var, jc0Var);
        }
        this.n = maVar;
        return maVar;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("ParagraphLayoutCache(paragraph=");
        sb.append(this.j != null ? "<paragraph>" : "null");
        sb.append(", lastDensity=");
        sb.append((Object) d11.b(this.h));
        sb.append(", history=");
        sb.append(this.s);
        sb.append(", constraints=$)");
        return sb.toString();
    }
}
