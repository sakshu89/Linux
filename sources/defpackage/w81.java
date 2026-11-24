package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class w81 implements vq0 {
    public final /* synthetic */ int a = 0;
    public final /* synthetic */ t91 b;
    public final /* synthetic */ int c;
    public final /* synthetic */ Object e;

    public /* synthetic */ w81(int i, t91 t91Var, Object obj) {
        this.b = t91Var;
        this.c = i;
        this.e = obj;
    }

    @Override // defpackage.vq0
    public final Object e(Object obj, Object obj2) {
        int i = this.a;
        q43 q43Var = q43.a;
        Object obj3 = this.e;
        int i2 = this.c;
        t91 t91Var = this.b;
        x20 x20Var = (x20) obj;
        Integer num = (Integer) obj2;
        switch (i) {
            case 0:
                int iIntValue = num.intValue();
                if (!x20Var.O(iIntValue & 1, (iIntValue & 3) != 2)) {
                    x20Var.R();
                } else {
                    t91Var.a(i2, obj3, x20Var, 0);
                }
                break;
            default:
                num.getClass();
                t91Var.a(i2, obj3, x20Var, ny3.c(1));
                break;
        }
        return q43Var;
    }

    public /* synthetic */ w81(t91 t91Var, int i, Object obj, int i2) {
        this.b = t91Var;
        this.c = i;
        this.e = obj;
    }
}
