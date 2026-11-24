package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class wj2 extends ik1 {
    public final yj2 a;
    public final boolean b;
    public final long c;
    public final long d;

    public wj2(yj2 yj2Var, boolean z, long j, long j2) {
        this.a = yj2Var;
        this.b = z;
        this.c = j;
        this.d = j2;
    }

    @Override // defpackage.ik1
    public final dk1 e() {
        return new pl(new h6(22, this));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof wj2)) {
            return false;
        }
        wj2 wj2Var = (wj2) obj;
        return de0.b(3.0f, 3.0f) && g31.a(this.a, wj2Var.a) && this.b == wj2Var.b && sz.c(this.c, wj2Var.c) && sz.c(this.d, wj2Var.d);
    }

    @Override // defpackage.ik1
    public final void f(dk1 dk1Var) {
        co1 co1Var;
        pl plVar = (pl) dk1Var;
        h6 h6Var = new h6(22, this);
        plVar.x = h6Var;
        if (plVar.a.w && (co1Var = cm4.e(plVar, 2).H) != null) {
            co1Var.t1(h6Var, true);
        }
    }

    public final int hashCode() {
        int iE = ky0.e((this.a.hashCode() + (Float.hashCode(3.0f) * 31)) * 31, 31, this.b);
        int i = sz.h;
        return Long.hashCode(this.d) + cq.c(iE, 31, this.c);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("ShadowGraphicsLayerElement(elevation=");
        sb.append((Object) de0.c(3.0f));
        sb.append(", shape=");
        sb.append(this.a);
        sb.append(", clip=");
        sb.append(this.b);
        sb.append(", ambientColor=");
        ky0.v(this.c, sb, ", spotColor=");
        sb.append((Object) sz.i(this.d));
        sb.append(')');
        return sb.toString();
    }
}
