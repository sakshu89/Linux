package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ey2 implements be2 {
    public final /* synthetic */ be2 a;
    public final qc0 b;
    public final qc0 c;

    public ey2(be2 be2Var, final fy2 fy2Var) {
        this.a = be2Var;
        final int i = 0;
        this.b = o44.b(new fq0() { // from class: dy2
            @Override // defpackage.fq0
            public final Object a() {
                int i2 = i;
                fy2 fy2Var2 = fy2Var;
                switch (i2) {
                    case 0:
                        return Boolean.valueOf(fy2Var2.a.g() < fy2Var2.b.g());
                    default:
                        return Boolean.valueOf(fy2Var2.a.g() > 0.0f);
                }
            }
        });
        final int i2 = 1;
        this.c = o44.b(new fq0() { // from class: dy2
            @Override // defpackage.fq0
            public final Object a() {
                int i3 = i2;
                fy2 fy2Var2 = fy2Var;
                switch (i3) {
                    case 0:
                        return Boolean.valueOf(fy2Var2.a.g() < fy2Var2.b.g());
                    default:
                        return Boolean.valueOf(fy2Var2.a.g() > 0.0f);
                }
            }
        });
    }

    @Override // defpackage.be2
    public final boolean a() {
        return ((Boolean) this.c.getValue()).booleanValue();
    }

    @Override // defpackage.be2
    public final boolean b() {
        return this.a.b();
    }

    @Override // defpackage.be2
    public final boolean c() {
        return ((Boolean) this.b.getValue()).booleanValue();
    }

    @Override // defpackage.be2
    public final Object d(rm1 rm1Var, vq0 vq0Var, y50 y50Var) {
        return this.a.d(rm1Var, vq0Var, y50Var);
    }

    @Override // defpackage.be2
    public final float e(float f) {
        return this.a.e(f);
    }
}
