package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ki2 implements vq0 {
    public final /* synthetic */ int a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ boolean e;

    public /* synthetic */ ki2(String str, String str2, boolean z, int i, int i2) {
        this.a = i2;
        this.b = str;
        this.c = str2;
        this.e = z;
    }

    @Override // defpackage.vq0
    public final Object e(Object obj, Object obj2) {
        int i = this.a;
        q43 q43Var = q43.a;
        boolean z = this.e;
        String str = this.c;
        String str2 = this.b;
        x20 x20Var = (x20) obj;
        ((Integer) obj2).getClass();
        switch (i) {
            case 0:
                k34.c(str2, str, z, x20Var, ny3.c(1));
                break;
            default:
                q44.c(str2, str, z, x20Var, ny3.c(1));
                break;
        }
        return q43Var;
    }
}
