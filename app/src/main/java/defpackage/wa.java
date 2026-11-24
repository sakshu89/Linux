package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class wa extends k61 implements hq0 {
    public final /* synthetic */ yy1 b;
    public final /* synthetic */ fq0 c;
    public final /* synthetic */ bz1 e;
    public final /* synthetic */ String f;
    public final /* synthetic */ z61 i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public wa(yy1 yy1Var, fq0 fq0Var, bz1 bz1Var, String str, z61 z61Var) {
        super(1);
        this.b = yy1Var;
        this.c = fq0Var;
        this.e = bz1Var;
        this.f = str;
        this.i = z61Var;
    }

    @Override // defpackage.hq0
    public final Object j(Object obj) {
        yy1 yy1Var = this.b;
        yy1Var.x.addView(yy1Var, yy1Var.H);
        yy1Var.i(this.c, this.e, this.f, this.i);
        return new g8(1, yy1Var);
    }
}
