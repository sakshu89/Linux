package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class xy1 extends k61 implements fq0 {
    public final /* synthetic */ s42 b;
    public final /* synthetic */ yy1 c;
    public final /* synthetic */ i21 e;
    public final /* synthetic */ long f;
    public final /* synthetic */ long i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xy1(s42 s42Var, yy1 yy1Var, i21 i21Var, long j, long j2) {
        super(0);
        this.b = s42Var;
        this.c = yy1Var;
        this.e = i21Var;
        this.f = j;
        this.i = j2;
    }

    @Override // defpackage.fq0
    public final Object a() {
        yy1 yy1Var = this.c;
        this.b.a = yy1Var.getPositionProvider().m(this.e, this.f, yy1Var.getParentLayoutDirection(), this.i);
        return q43.a;
    }
}
