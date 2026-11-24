package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class qk2 extends dk1 implements f71, eg2 {
    public float H;
    public float X;
    public float Y;
    public float Z;
    public long c0;
    public yj2 d0;
    public boolean e0;
    public long f0;
    public long g0;
    public int h0;
    public h6 i0;
    public float x;

    @Override // defpackage.f71
    public final ph1 d(qh1 qh1Var, jh1 jh1Var, long j) {
        zw1 zw1VarE = jh1Var.e(j);
        return qh1Var.j0(zw1VarE.a, zw1VarE.b, ji0.a, new k8(9, zw1VarE, this));
    }

    @Override // defpackage.eg2
    public final void e0(og2 og2Var) {
        if (this.e0) {
            mg2.d(og2Var, this.d0);
        }
    }

    @Override // defpackage.eg2
    public final boolean h() {
        return false;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("SimpleGraphicsLayerModifier(scaleX=");
        sb.append(this.x);
        sb.append(", scaleY=");
        sb.append(this.H);
        sb.append(", alpha = ");
        sb.append(this.X);
        sb.append(", translationX=0.0, translationY=0.0, shadowElevation=");
        sb.append(this.Y);
        sb.append(", rotationX=0.0, rotationY=0.0, rotationZ=0.0, cameraDistance=");
        sb.append(this.Z);
        sb.append(", transformOrigin=");
        sb.append((Object) y13.a(this.c0));
        sb.append(", shape=");
        sb.append(this.d0);
        sb.append(", clip=");
        sb.append(this.e0);
        sb.append(", renderEffect=null, ambientShadowColor=");
        ky0.v(this.f0, sb, ", spotShadowColor=");
        ky0.v(this.g0, sb, ", compositingStrategy=CompositingStrategy(value=0), blendMode=");
        sb.append((Object) mf4.c(this.h0));
        sb.append(", colorFilter=null)");
        return sb.toString();
    }

    @Override // defpackage.dk1
    public final boolean x0() {
        return false;
    }
}
