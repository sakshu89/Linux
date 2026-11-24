package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class t10 implements vq0 {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ int c;
    public final /* synthetic */ Object e;
    public final /* synthetic */ Object f;
    public final /* synthetic */ Object i;

    public /* synthetic */ t10(yz yzVar, ck2 ck2Var, v33 v33Var, w10 w10Var, int i) {
        this.a = 1;
        this.e = yzVar;
        this.f = ck2Var;
        this.i = v33Var;
        this.b = w10Var;
        this.c = i;
    }

    @Override // defpackage.vq0
    public final Object e(Object obj, Object obj2) {
        int i = this.a;
        Object obj3 = this.i;
        Object obj4 = this.f;
        q43 q43Var = q43.a;
        int i2 = this.c;
        Object obj5 = this.e;
        Object obj6 = this.b;
        switch (i) {
            case 0:
                ((Integer) obj2).getClass();
                int iC = ny3.c(i2) | 1;
                ((w10) obj6).d((vk) obj5, this.f, this.i, (x20) obj, iC);
                break;
            case 1:
                ((Integer) obj2).getClass();
                gh1.b((yz) obj5, (ck2) obj4, (v33) obj3, (w10) obj6, (x20) obj, ny3.c(i2 | 1));
                break;
            default:
                ((Integer) obj2).getClass();
                k54.j((eo2) obj6, (zt1) obj5, (hq0) obj4, (hq0) obj3, (x20) obj, ny3.c(i2 | 1));
                break;
        }
        return q43Var;
    }

    public /* synthetic */ t10(Object obj, Object obj2, Object obj3, Object obj4, int i, int i2) {
        this.a = i2;
        this.b = obj;
        this.e = obj2;
        this.f = obj3;
        this.i = obj4;
        this.c = i;
    }
}
