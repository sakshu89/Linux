package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class wl extends zb0 implements eg2 {
    public sl X;
    public float Y;
    public cn2 Z;
    public yj2 c0;
    public final ro d0;

    public wl(float f, cn2 cn2Var, yj2 yj2Var) {
        this.Y = f;
        this.Z = cn2Var;
        this.c0 = yj2Var;
        ro roVar = new ro(new so(), new x0(6, this));
        I0(roVar);
        this.d0 = roVar;
    }

    @Override // defpackage.eg2
    public final void e0(og2 og2Var) {
        mg2.d(og2Var, this.c0);
    }

    @Override // defpackage.eg2
    public final boolean h() {
        return false;
    }

    @Override // defpackage.dk1
    public final boolean x0() {
        return false;
    }
}
