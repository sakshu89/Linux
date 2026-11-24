package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class s91 implements vq0 {
    public final /* synthetic */ int a;
    public final /* synthetic */ int b;
    public final /* synthetic */ Object c;

    public /* synthetic */ s91(Object obj, int i, int i2) {
        this.a = i2;
        this.c = obj;
        this.b = i;
    }

    @Override // defpackage.vq0
    public final Object e(Object obj, Object obj2) {
        int i = this.a;
        q43 q43Var = q43.a;
        int i2 = this.b;
        Object obj3 = this.c;
        switch (i) {
            case 0:
                t91 t91Var = (t91) obj3;
                x20 x20Var = (x20) obj;
                int iIntValue = ((Integer) obj2).intValue();
                if (!x20Var.O(iIntValue & 1, (iIntValue & 3) != 2)) {
                    x20Var.R();
                } else {
                    y21 y21VarA = t91Var.b.a.a(i2);
                    ((w10) y21VarA.c.c).o(t91Var.c, Integer.valueOf(i2 - y21VarA.a), x20Var, 0);
                }
                break;
            default:
                ((Integer) obj2).getClass();
                k34.b((String) obj3, (x20) obj, ny3.c(i2 | 1));
                break;
        }
        return q43Var;
    }
}
