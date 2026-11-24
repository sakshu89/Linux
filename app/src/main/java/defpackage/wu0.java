package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
final class wu0 extends ik1 {
    public final float a;
    public final float b;
    public final long c;
    public final yj2 d;
    public final boolean e;
    public final long f;
    public final long g;

    public wu0(float f, float f2, long j, yj2 yj2Var, boolean z, long j2, long j3) {
        this.a = f;
        this.b = f2;
        this.c = j;
        this.d = yj2Var;
        this.e = z;
        this.f = j2;
        this.g = j3;
    }

    @Override // defpackage.ik1
    public final dk1 e() {
        qk2 qk2Var = new qk2();
        qk2Var.x = 1.0f;
        qk2Var.H = 1.0f;
        qk2Var.X = this.a;
        qk2Var.Y = this.b;
        qk2Var.Z = 8.0f;
        qk2Var.c0 = this.c;
        qk2Var.d0 = this.d;
        qk2Var.e0 = this.e;
        qk2Var.f0 = this.f;
        qk2Var.g0 = this.g;
        qk2Var.h0 = 3;
        qk2Var.i0 = new h6(23, qk2Var);
        return qk2Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof wu0) {
            wu0 wu0Var = (wu0) obj;
            if (Float.compare(1.0f, 1.0f) == 0 && Float.compare(1.0f, 1.0f) == 0 && Float.compare(this.a, wu0Var.a) == 0 && Float.compare(0.0f, 0.0f) == 0 && Float.compare(0.0f, 0.0f) == 0 && Float.compare(this.b, wu0Var.b) == 0 && Float.compare(0.0f, 0.0f) == 0 && Float.compare(0.0f, 0.0f) == 0 && Float.compare(0.0f, 0.0f) == 0 && Float.compare(8.0f, 8.0f) == 0) {
                long j = wu0Var.c;
                int i = y13.b;
                if (this.c == j && g31.a(this.d, wu0Var.d) && this.e == wu0Var.e && sz.c(this.f, wu0Var.f) && sz.c(this.g, wu0Var.g)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // defpackage.ik1
    public final void f(dk1 dk1Var) {
        co1 co1Var;
        qk2 qk2Var = (qk2) dk1Var;
        qk2Var.x = 1.0f;
        qk2Var.H = 1.0f;
        qk2Var.X = this.a;
        qk2Var.Y = this.b;
        qk2Var.Z = 8.0f;
        qk2Var.c0 = this.c;
        qk2Var.d0 = this.d;
        qk2Var.e0 = this.e;
        qk2Var.f0 = this.f;
        qk2Var.g0 = this.g;
        qk2Var.h0 = 3;
        h6 h6Var = qk2Var.i0;
        if (qk2Var.a.w && (co1Var = cm4.e(qk2Var, 2).H) != null) {
            co1Var.t1(h6Var, true);
        }
    }

    public final int hashCode() {
        int iB = cq.b(cq.b(cq.b(cq.b(cq.b(cq.b(cq.b(cq.b(cq.b(Float.hashCode(1.0f) * 31, 1.0f, 31), this.a, 31), 0.0f, 31), 0.0f, 31), this.b, 31), 0.0f, 31), 0.0f, 31), 0.0f, 31), 8.0f, 31);
        int i = y13.b;
        int iE = ky0.e((this.d.hashCode() + cq.c(iB, 31, this.c)) * 31, 961, this.e);
        int i2 = sz.h;
        return ky0.a(3, ky0.a(0, cq.c(cq.c(iE, 31, this.f), 31, this.g), 31), 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("GraphicsLayerElement(scaleX=1.0, scaleY=1.0, alpha=");
        sb.append(this.a);
        sb.append(", translationX=0.0, translationY=0.0, shadowElevation=");
        sb.append(this.b);
        sb.append(", rotationX=0.0, rotationY=0.0, rotationZ=0.0, cameraDistance=8.0, transformOrigin=");
        sb.append((Object) y13.a(this.c));
        sb.append(", shape=");
        sb.append(this.d);
        sb.append(", clip=");
        sb.append(this.e);
        sb.append(", renderEffect=null, ambientShadowColor=");
        ky0.v(this.f, sb, ", spotShadowColor=");
        sb.append((Object) sz.i(this.g));
        sb.append(", compositingStrategy=CompositingStrategy(value=0), blendMode=");
        sb.append((Object) mf4.c(3));
        sb.append(", colorFilter=null)");
        return sb.toString();
    }
}
