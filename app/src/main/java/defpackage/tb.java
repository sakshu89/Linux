package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class tb implements vq0 {
    public final /* synthetic */ int a = 0;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ int e;
    public final /* synthetic */ Object f;

    public /* synthetic */ tb(ek1 ek1Var, fq0 fq0Var, boolean z, int i) {
        this.f = ek1Var;
        this.c = fq0Var;
        this.b = z;
        this.e = i;
    }

    @Override // defpackage.vq0
    public final Object e(Object obj, Object obj2) {
        int i = this.a;
        q43 q43Var = q43.a;
        int i2 = this.e;
        Object obj3 = this.c;
        Object obj4 = this.f;
        boolean z = this.b;
        switch (i) {
            case 0:
                ((Integer) obj2).getClass();
                vd4.c((ek1) obj4, (fq0) obj3, z, (x20) obj, ny3.c(i2 | 1));
                break;
            case 1:
                ((Integer) obj2).getClass();
                k34.g((String) obj4, z, (fq0) obj3, (x20) obj, ny3.c(i2 | 1));
                break;
            default:
                ((Integer) obj2).getClass();
                wb4.a(z, (p62) obj4, (ny2) obj3, (x20) obj, ny3.c(i2 | 1));
                break;
        }
        return q43Var;
    }

    public /* synthetic */ tb(String str, boolean z, fq0 fq0Var, int i) {
        this.f = str;
        this.b = z;
        this.c = fq0Var;
        this.e = i;
    }

    public /* synthetic */ tb(boolean z, p62 p62Var, ny2 ny2Var, int i) {
        this.b = z;
        this.f = p62Var;
        this.c = ny2Var;
        this.e = i;
    }
}
