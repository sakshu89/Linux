package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class wi0 extends k61 implements hq0 {
    public final /* synthetic */ boolean b;
    public final /* synthetic */ fq0 c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public wi0(boolean z, fq0 fq0Var) {
        super(1);
        this.b = z;
        this.c = fq0Var;
    }

    @Override // defpackage.hq0
    public final Object j(Object obj) {
        ((r72) obj).f(!this.b && ((Boolean) this.c.a()).booleanValue());
        return q43.a;
    }
}
