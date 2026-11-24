package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class vt2 implements vq0 {
    public final /* synthetic */ ek1 a;
    public final /* synthetic */ yj2 b;
    public final /* synthetic */ long c;
    public final /* synthetic */ float e;
    public final /* synthetic */ yl f;
    public final /* synthetic */ ol1 i;
    public final /* synthetic */ boolean j;
    public final /* synthetic */ fq0 k;
    public final /* synthetic */ float n;
    public final /* synthetic */ w10 s;

    public vt2(ek1 ek1Var, yj2 yj2Var, long j, float f, yl ylVar, ol1 ol1Var, boolean z, fq0 fq0Var, float f2, w10 w10Var) {
        this.a = ek1Var;
        this.b = yj2Var;
        this.c = j;
        this.e = f;
        this.f = ylVar;
        this.i = ol1Var;
        this.j = z;
        this.k = fq0Var;
        this.n = f2;
        this.s = w10Var;
    }

    @Override // defpackage.vq0
    public final Object e(Object obj, Object obj2) {
        x20 x20Var = (x20) obj;
        int iIntValue = ((Number) obj2).intValue();
        if (x20Var.O(iIntValue & 1, (iIntValue & 3) != 2)) {
            qw0 qw0Var = u21.a;
            ek1 ek1VarC = pd3.b(wt2.a(this.a.c(rj1.a), this.b, wt2.b(this.c, this.e, x20Var), this.f, ((jc0) x20Var.j(l30.h)).x(this.n)), this.i, i82.a(), this.j, null, this.k, 24).c(new wx(new j(13)));
            oh1 oh1VarD = gm.d(xy.b, true);
            int iHashCode = Long.hashCode(x20Var.T);
            gw1 gw1VarL = x20Var.l();
            ek1 ek1VarC2 = gj4.c(x20Var, ek1VarC);
            o20.p.getClass();
            k30 k30Var = n20.b;
            x20Var.Z();
            if (x20Var.S) {
                x20Var.k(k30Var);
            } else {
                x20Var.j0();
            }
            ie4.c(x20Var, n20.f, oh1VarD);
            ie4.c(x20Var, n20.e, gw1VarL);
            jd jdVar = n20.g;
            if (x20Var.S || !g31.a(x20Var.L(), Integer.valueOf(iHashCode))) {
                x20Var.g0(Integer.valueOf(iHashCode));
                x20Var.b(jdVar, Integer.valueOf(iHashCode));
            }
            ie4.c(x20Var, n20.d, ek1VarC2);
            this.s.e(x20Var, 0);
            x20Var.p(true);
        } else {
            x20Var.R();
        }
        return q43.a;
    }
}
