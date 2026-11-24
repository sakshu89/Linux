package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class bb0 implements be2 {
    public final hq0 a;
    public final ab0 b = new ab0(this);
    public final xm1 c = new xm1();
    public final ku1 d;
    public final ku1 e;
    public final ku1 f;

    public bb0(hq0 hq0Var) {
        this.a = hq0Var;
        Boolean bool = Boolean.FALSE;
        this.d = o44.g(bool);
        this.e = o44.g(bool);
        this.f = o44.g(bool);
    }

    @Override // defpackage.be2
    public final boolean b() {
        return ((Boolean) this.d.getValue()).booleanValue();
    }

    @Override // defpackage.be2
    public final Object d(rm1 rm1Var, vq0 vq0Var, y50 y50Var) {
        Object objC = tl4.c(new r0(this, rm1Var, vq0Var, null, 7), y50Var);
        return objC == t70.a ? objC : q43.a;
    }

    @Override // defpackage.be2
    public final float e(float f) {
        return ((Number) this.a.j(Float.valueOf(f))).floatValue();
    }
}
