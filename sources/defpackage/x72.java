package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class x72 extends k61 implements hq0 {
    public final /* synthetic */ int b;
    public final /* synthetic */ y72 c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ x72(y72 y72Var, int i) {
        super(1);
        this.b = i;
        this.c = y72Var;
    }

    @Override // defpackage.hq0
    public final Object j(Object obj) {
        int i = this.b;
        y72 y72Var = this.c;
        switch (i) {
            case 0:
                return Double.valueOf(y72Var.n.c(ky3.a(((Number) obj).doubleValue(), y72Var.e, y72Var.f)));
            default:
                return Double.valueOf(ky3.a(y72Var.k.c(((Number) obj).doubleValue()), y72Var.e, y72Var.f));
        }
    }
}
