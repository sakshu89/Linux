package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class fg1 extends p4 implements hq0 {
    public final /* synthetic */ int k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ fg1(int i, Object obj, Class cls, String str, String str2, int i2, int i3) {
        super(i, i2, cls, obj, str, str2);
        this.k = i3;
    }

    @Override // defpackage.hq0
    public final Object j(Object obj) {
        int i = this.k;
        q43 q43Var = q43.a;
        Object obj2 = this.a;
        switch (i) {
            case 0:
                String str = (String) obj;
                str.getClass();
                so2 so2Var = (so2) obj2;
                so2Var.getClass();
                uf4.b(gb4.c(so2Var), null, new ko2(so2Var, str, null, 0), 3);
                break;
            default:
                ((pm1) obj2).b((fd2) obj);
                break;
        }
        return q43Var;
    }
}
