package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class gw implements vq0 {
    public final /* synthetic */ int a;
    public final /* synthetic */ int b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ Object e;

    public /* synthetic */ gw(int i, int i2, Object obj, Object obj2) {
        this.a = i2;
        this.c = obj;
        this.e = obj2;
        this.b = i;
    }

    @Override // defpackage.vq0
    public final Object e(Object obj, Object obj2) {
        int i = this.a;
        q43 q43Var = q43.a;
        int i2 = this.b;
        Object obj3 = this.e;
        Object obj4 = this.c;
        switch (i) {
            case 0:
                ((Integer) obj2).intValue();
                dh4.a((ek1) obj4, (hq0) obj3, (x20) obj, ny3.c(i2 | 1));
                break;
            case 1:
                ((Integer) obj2).getClass();
                ((w10) obj4).h(obj3, (x20) obj, ny3.c(i2) | 1);
                break;
            case 2:
                ((Integer) obj2).getClass();
                kj4.a((a22) obj4, (w10) obj3, (x20) obj, ny3.c(i2 | 1));
                break;
            case 3:
                ((Integer) obj2).getClass();
                kj4.b((a22[]) obj4, (vq0) obj3, (x20) obj, ny3.c(i2 | 1));
                break;
            case 4:
                ((Integer) obj2).getClass();
                q44.e((String) obj4, (fq0) obj3, (x20) obj, ny3.c(i2 | 1));
                break;
            default:
                ((Integer) obj2).getClass();
                ((j23) obj4).a((Boolean) obj3, (x20) obj, ny3.c(i2 | 1));
                break;
        }
        return q43Var;
    }
}
