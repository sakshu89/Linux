package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ii2 implements vq0 {
    public final /* synthetic */ int a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ int c;

    public /* synthetic */ ii2(int i, int i2, boolean z) {
        this.a = i2;
        this.b = z;
        this.c = i;
    }

    @Override // defpackage.vq0
    public final Object e(Object obj, Object obj2) {
        int i = this.a;
        q43 q43Var = q43.a;
        int i2 = this.c;
        boolean z = this.b;
        x20 x20Var = (x20) obj;
        ((Integer) obj2).intValue();
        switch (i) {
            case 0:
                k34.j(z, x20Var, ny3.c(i2 | 1));
                break;
            default:
                q44.i(z, x20Var, ny3.c(i2 | 1));
                break;
        }
        return q43Var;
    }
}
