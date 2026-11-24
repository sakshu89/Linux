package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class hs1 implements vq0 {
    public final /* synthetic */ int a;
    public final /* synthetic */ rn2 b;
    public final /* synthetic */ float c;
    public final /* synthetic */ boolean e;
    public final /* synthetic */ ek1 f;
    public final /* synthetic */ int i;

    public /* synthetic */ hs1(rn2 rn2Var, float f, boolean z, ek1 ek1Var, int i, int i2) {
        this.a = i2;
        this.b = rn2Var;
        this.c = f;
        this.e = z;
        this.f = ek1Var;
        this.i = i;
    }

    @Override // defpackage.vq0
    public final Object e(Object obj, Object obj2) {
        int i = this.a;
        q43 q43Var = q43.a;
        int i2 = this.i;
        switch (i) {
            case 0:
                ((Integer) obj2).getClass();
                int iC = ny3.c(i2 | 1);
                bs4.a(this.b, this.c, this.e, this.f, (x20) obj, iC);
                break;
            case 1:
                ((Integer) obj2).getClass();
                int iC2 = ny3.c(i2 | 1);
                s44.b(this.b, this.c, this.e, this.f, (x20) obj, iC2);
                break;
            default:
                ((Integer) obj2).getClass();
                int iC3 = ny3.c(i2 | 1);
                gf4.a(this.b, this.c, this.e, this.f, (x20) obj, iC3);
                break;
        }
        return q43Var;
    }
}
