package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class bb extends k61 implements vq0 {
    public final /* synthetic */ az1 b;
    public final /* synthetic */ fq0 c;
    public final /* synthetic */ bz1 e;
    public final /* synthetic */ w10 f;
    public final /* synthetic */ int i;
    public final /* synthetic */ int j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bb(az1 az1Var, fq0 fq0Var, bz1 bz1Var, w10 w10Var, int i, int i2) {
        super(2);
        this.b = az1Var;
        this.c = fq0Var;
        this.e = bz1Var;
        this.f = w10Var;
        this.i = i;
        this.j = i2;
    }

    @Override // defpackage.vq0
    public final Object e(Object obj, Object obj2) {
        ((Number) obj2).intValue();
        fb.a(this.b, this.c, this.e, this.f, (x20) obj, ny3.c(this.i | 1), this.j);
        return q43.a;
    }
}
