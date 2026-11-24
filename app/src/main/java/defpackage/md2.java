package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class md2 implements be2 {
    public static final q91 j = new q91(26, new ra2(18), new sa2(21));
    public final hu1 a;
    public float f;
    public final qc0 h;
    public final qc0 i;
    public final hu1 b = new hu1(0);
    public final hu1 c = new hu1(0);
    public final ol1 d = new ol1();
    public final hu1 e = new hu1(Integer.MAX_VALUE);
    public final bb0 g = new bb0(new x0(25, this));

    public md2(int i) {
        this.a = new hu1(i);
        final int i2 = 0;
        this.h = o44.b(new fq0(this) { // from class: ld2
            public final /* synthetic */ md2 b;

            {
                this.b = this;
            }

            @Override // defpackage.fq0
            public final Object a() {
                int i3 = i2;
                md2 md2Var = this.b;
                switch (i3) {
                    case 0:
                        return Boolean.valueOf(md2Var.a.g() < md2Var.e.g());
                    default:
                        return Boolean.valueOf(md2Var.a.g() > 0);
                }
            }
        });
        final int i3 = 1;
        this.i = o44.b(new fq0(this) { // from class: ld2
            public final /* synthetic */ md2 b;

            {
                this.b = this;
            }

            @Override // defpackage.fq0
            public final Object a() {
                int i4 = i3;
                md2 md2Var = this.b;
                switch (i4) {
                    case 0:
                        return Boolean.valueOf(md2Var.a.g() < md2Var.e.g());
                    default:
                        return Boolean.valueOf(md2Var.a.g() > 0);
                }
            }
        });
    }

    @Override // defpackage.be2
    public final boolean a() {
        return ((Boolean) this.i.getValue()).booleanValue();
    }

    @Override // defpackage.be2
    public final boolean b() {
        return this.g.b();
    }

    @Override // defpackage.be2
    public final boolean c() {
        return ((Boolean) this.h.getValue()).booleanValue();
    }

    @Override // defpackage.be2
    public final Object d(rm1 rm1Var, vq0 vq0Var, y50 y50Var) {
        Object objD = this.g.d(rm1Var, vq0Var, y50Var);
        return objD == t70.a ? objD : q43.a;
    }

    @Override // defpackage.be2
    public final float e(float f) {
        return this.g.e(f);
    }
}
