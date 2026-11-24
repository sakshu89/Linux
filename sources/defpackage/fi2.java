package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class fi2 implements vq0 {
    public final /* synthetic */ int a;
    public final /* synthetic */ String b;
    public final /* synthetic */ boolean c;
    public final /* synthetic */ rq0 e;

    public /* synthetic */ fi2(String str, boolean z, rq0 rq0Var, int i, int i2) {
        this.a = i2;
        this.b = str;
        this.c = z;
        this.e = rq0Var;
    }

    @Override // defpackage.vq0
    public final Object e(Object obj, Object obj2) {
        int i = this.a;
        q43 q43Var = q43.a;
        rq0 rq0Var = this.e;
        boolean z = this.c;
        String str = this.b;
        switch (i) {
            case 0:
                ((Integer) obj2).getClass();
                k34.k(str, z, (hq0) rq0Var, (x20) obj, ny3.c(7));
                break;
            default:
                ((Integer) obj2).getClass();
                k54.a(str, z, (fq0) rq0Var, (x20) obj, ny3.c(7));
                break;
        }
        return q43Var;
    }
}
