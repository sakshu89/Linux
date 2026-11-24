package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class kf1 extends k61 implements fq0 {
    public final /* synthetic */ mf1 b;
    public final /* synthetic */ long c;
    public final /* synthetic */ long e;
    public final /* synthetic */ bx1 f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public kf1(mf1 mf1Var, long j, long j2, bx1 bx1Var) {
        super(0);
        this.b = mf1Var;
        this.c = j;
        this.e = j2;
        this.f = bx1Var;
    }

    @Override // defpackage.fq0
    public final Object a() {
        mf1 mf1Var = this.b;
        mf1Var.G0().a = false;
        mf1Var.G0().b = this.c;
        mf1Var.G0().c = this.e;
        hq0 hq0VarE = this.f.a.e();
        if (hq0VarE != null) {
            hq0VarE.j(mf1Var.G0());
        }
        return q43.a;
    }
}
