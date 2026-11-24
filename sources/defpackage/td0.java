package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class td0 extends k61 implements fq0 {
    public final /* synthetic */ boolean b;
    public final /* synthetic */ q91 c;
    public final /* synthetic */ String e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public td0(boolean z, q91 q91Var, String str) {
        super(0);
        this.b = z;
        this.c = q91Var;
        this.e = str;
    }

    @Override // defpackage.fq0
    public final Object a() {
        if (this.b) {
            q91 q91Var = this.c;
            String str = this.e;
            ma2 ma2Var = (ma2) q91Var.b;
            synchronized (ma2Var.c) {
            }
        }
        return q43.a;
    }
}
