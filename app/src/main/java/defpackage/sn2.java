package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class sn2 implements vq0 {
    public final /* synthetic */ int a;
    public final /* synthetic */ eo2 b;
    public final /* synthetic */ g32 c;
    public final /* synthetic */ fq0 e;
    public final /* synthetic */ fq0 f;
    public final /* synthetic */ fq0 i;
    public final /* synthetic */ hq0 j;
    public final /* synthetic */ hq0 k;
    public final /* synthetic */ int n;

    public /* synthetic */ sn2(eo2 eo2Var, g32 g32Var, fq0 fq0Var, fq0 fq0Var2, fq0 fq0Var3, hq0 hq0Var, hq0 hq0Var2, int i, int i2) {
        this.a = i2;
        this.b = eo2Var;
        this.c = g32Var;
        this.e = fq0Var;
        this.f = fq0Var2;
        this.i = fq0Var3;
        this.j = hq0Var;
        this.k = hq0Var2;
        this.n = i;
    }

    @Override // defpackage.vq0
    public final Object e(Object obj, Object obj2) {
        int i = this.a;
        q43 q43Var = q43.a;
        int i2 = this.n;
        switch (i) {
            case 0:
                ((Integer) obj2).getClass();
                int iC = ny3.c(i2 | 1);
                k54.e(this.b, this.c, this.e, this.f, this.i, this.j, this.k, (x20) obj, iC);
                break;
            default:
                ((Integer) obj2).getClass();
                int iC2 = ny3.c(i2 | 1);
                k54.b(this.b, this.c, this.e, this.f, this.i, this.j, this.k, (x20) obj, iC2);
                break;
        }
        return q43Var;
    }
}
