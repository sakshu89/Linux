package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class pl extends dk1 implements f71, eg2 {
    public hq0 x;

    public pl(hq0 hq0Var) {
        this.x = hq0Var;
    }

    @Override // defpackage.f71
    public final ph1 d(qh1 qh1Var, jh1 jh1Var, long j) {
        zw1 zw1VarE = jh1Var.e(j);
        return qh1Var.j0(zw1VarE.a, zw1VarE.b, ji0.a, new k8(7, zw1VarE, this));
    }

    @Override // defpackage.eg2
    public final void e0(og2 og2Var) {
        yj2 yj2Var;
        boolean z;
        co1 co1VarE = cm4.e(this, 2);
        if (co1VarE.o0) {
            yj2Var = co1VarE.m0;
            z = co1VarE.n0;
        } else {
            r72 r72Var = pz3.a;
            if (r72Var == null) {
                pz3.a = new r72();
            } else {
                r72Var.a();
            }
            r72 r72Var2 = pz3.a;
            r72Var2.getClass();
            r72Var2.v = co1VarE.x.h0;
            r72Var2.u = cp4.a(co1VarE.c);
            bm2 bm2VarA = i44.a();
            hq0 hq0VarE = bm2VarA != null ? bm2VarA.e() : null;
            bm2 bm2VarB = i44.b(bm2VarA);
            try {
                this.x.j(r72Var2);
                i44.e(bm2VarA, bm2VarB, hq0VarE);
                yj2Var = r72Var2.s;
                z = r72Var2.t;
            } catch (Throwable th) {
                i44.e(bm2VarA, bm2VarB, hq0VarE);
                throw th;
            }
        }
        if (z) {
            mg2.d(og2Var, yj2Var);
        }
    }

    @Override // defpackage.eg2
    public final boolean h() {
        return false;
    }

    public final String toString() {
        return "BlockGraphicsLayerModifier(block=" + this.x + ')';
    }

    @Override // defpackage.dk1
    public final boolean x0() {
        return false;
    }
}
