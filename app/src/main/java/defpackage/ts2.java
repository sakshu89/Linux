package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ts2 extends k61 implements vq0 {
    public final /* synthetic */ ws2 b;
    public final /* synthetic */ ek1 c;
    public final /* synthetic */ vq0 e;
    public final /* synthetic */ int f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ts2(ws2 ws2Var, ek1 ek1Var, vq0 vq0Var, int i) {
        super(2);
        this.b = ws2Var;
        this.c = ek1Var;
        this.e = vq0Var;
        this.f = i;
    }

    @Override // defpackage.vq0
    public final Object e(Object obj, Object obj2) {
        ((Number) obj2).intValue();
        int iC = ny3.c(this.f | 1);
        na4.b(this.b, this.c, this.e, (x20) obj, iC);
        return q43.a;
    }
}
