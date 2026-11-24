package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class q01 implements gr2 {
    public Float a;
    public Float b;
    public final ku1 c;
    public wv2 e;
    public boolean f;
    public boolean i;
    public long j;
    public final /* synthetic */ s01 k;

    public q01(s01 s01Var, Float f, Float f2, p01 p01Var) {
        this.k = s01Var;
        this.a = f;
        this.b = f2;
        this.c = o44.g(f);
        this.e = new wv2(p01Var, eb4.a, this.a, this.b, null);
    }

    @Override // defpackage.gr2
    public final Object getValue() {
        return this.c.getValue();
    }
}
