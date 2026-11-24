package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
final class mk extends ik1 {
    public final long a;
    public final hn b;
    public final float c;
    public final yj2 d;

    public mk(long j, ec1 ec1Var, yj2 yj2Var, int i) {
        j = (i & 1) != 0 ? sz.g : j;
        ec1Var = (i & 2) != 0 ? null : ec1Var;
        this.a = j;
        this.b = ec1Var;
        this.c = 1.0f;
        this.d = yj2Var;
    }

    @Override // defpackage.ik1
    public final dk1 e() {
        nk nkVar = new nk();
        nkVar.x = this.a;
        nkVar.H = this.b;
        nkVar.X = this.c;
        nkVar.Y = this.d;
        nkVar.Z = 9205357640488583168L;
        return nkVar;
    }

    public final boolean equals(Object obj) {
        mk mkVar = obj instanceof mk ? (mk) obj : null;
        return mkVar != null && sz.c(this.a, mkVar.a) && g31.a(this.b, mkVar.b) && this.c == mkVar.c && g31.a(this.d, mkVar.d);
    }

    @Override // defpackage.ik1
    public final void f(dk1 dk1Var) {
        nk nkVar = (nk) dk1Var;
        nkVar.x = this.a;
        nkVar.H = this.b;
        nkVar.X = this.c;
        yj2 yj2Var = nkVar.Y;
        yj2 yj2Var2 = this.d;
        if (!g31.a(yj2Var, yj2Var2)) {
            nkVar.Y = yj2Var2;
            a34.a(nkVar);
        }
        vm4.a(nkVar);
    }

    public final int hashCode() {
        int i = sz.h;
        int iHashCode = Long.hashCode(this.a) * 31;
        hn hnVar = this.b;
        return this.d.hashCode() + cq.b((iHashCode + (hnVar != null ? hnVar.hashCode() : 0)) * 31, this.c, 31);
    }
}
