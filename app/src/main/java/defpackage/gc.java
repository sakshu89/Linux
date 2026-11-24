package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class gc implements vq0 {
    public final /* synthetic */ int a;
    public final /* synthetic */ ek1 b;
    public final /* synthetic */ w10 c;
    public final /* synthetic */ int e;

    public /* synthetic */ gc(ek1 ek1Var, w10 w10Var, int i, int i2) {
        this.a = i2;
        this.b = ek1Var;
        this.c = w10Var;
        this.e = i;
    }

    @Override // defpackage.vq0
    public final Object e(Object obj, Object obj2) {
        int i = this.a;
        q43 q43Var = q43.a;
        int i2 = this.e;
        w10 w10Var = this.c;
        ek1 ek1Var = this.b;
        x20 x20Var = (x20) obj;
        ((Integer) obj2).getClass();
        switch (i) {
            case 0:
                ce4.a(ek1Var, w10Var, x20Var, ny3.c(i2 | 1));
                break;
            case 1:
                ce4.b(ek1Var, w10Var, x20Var, ny3.c(i2 | 1));
                break;
            case 2:
                jb0.d(ek1Var, w10Var, x20Var, ny3.c(i2 | 1));
                break;
            case 3:
                ba0.b(ek1Var, w10Var, x20Var, ny3.c(i2 | 1));
                break;
            default:
                ba0.a(ek1Var, w10Var, x20Var, ny3.c(i2 | 1));
                break;
        }
        return q43Var;
    }
}
