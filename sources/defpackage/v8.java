package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class v8 implements vq0 {
    public final /* synthetic */ int a;
    public final /* synthetic */ ek1 b;
    public final /* synthetic */ int c;

    public /* synthetic */ v8(ek1 ek1Var, int i, int i2) {
        this.a = 0;
        this.b = ek1Var;
        this.c = i2;
    }

    @Override // defpackage.vq0
    public final Object e(Object obj, Object obj2) {
        int i = this.a;
        q43 q43Var = q43.a;
        int i2 = this.c;
        ek1 ek1Var = this.b;
        x20 x20Var = (x20) obj;
        ((Integer) obj2).getClass();
        switch (i) {
            case 0:
                z8.b(ek1Var, x20Var, ny3.c(1), i2);
                break;
            case 1:
                gm.a(ek1Var, x20Var, ny3.c(i2 | 1));
                break;
            default:
                cb4.c(ek1Var, x20Var, ny3.c(i2 | 1));
                break;
        }
        return q43Var;
    }

    public /* synthetic */ v8(ek1 ek1Var, int i, int i2, byte b) {
        this.a = i2;
        this.b = ek1Var;
        this.c = i;
    }
}
