package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class s00 implements vq0 {
    public final /* synthetic */ int a;
    public final /* synthetic */ ny2 b;
    public final /* synthetic */ w10 c;
    public final /* synthetic */ int e;

    public /* synthetic */ s00(ny2 ny2Var, w10 w10Var, int i, int i2) {
        this.a = i2;
        this.b = ny2Var;
        this.c = w10Var;
        this.e = i;
    }

    @Override // defpackage.vq0
    public final Object e(Object obj, Object obj2) {
        int i = this.a;
        q43 q43Var = q43.a;
        int i2 = this.e;
        w10 w10Var = this.c;
        ny2 ny2Var = this.b;
        x20 x20Var = (x20) obj;
        ((Integer) obj2).getClass();
        switch (i) {
            case 0:
                qi4.a(ny2Var, w10Var, x20Var, ny3.c(i2 | 1));
                break;
            default:
                cl4.a(ny2Var, w10Var, x20Var, ny3.c(i2 | 1));
                break;
        }
        return q43Var;
    }
}
