package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class gn0 implements vq0 {
    public final /* synthetic */ int a;
    public final /* synthetic */ w10 b;

    public /* synthetic */ gn0(w10 w10Var) {
        this.a = 0;
        this.b = w10Var;
    }

    @Override // defpackage.vq0
    public final Object e(Object obj, Object obj2) {
        int i = this.a;
        q43 q43Var = q43.a;
        w10 w10Var = this.b;
        x20 x20Var = (x20) obj;
        Integer num = (Integer) obj2;
        switch (i) {
            case 0:
                int iIntValue = num.intValue();
                if (!x20Var.O(iIntValue & 1, (iIntValue & 3) != 2)) {
                    x20Var.R();
                } else {
                    w10Var.c(nn0.a, x20Var, 6);
                }
                break;
            case 1:
                num.getClass();
                gq4.a(w10Var, x20Var, ny3.c(7));
                break;
            case 2:
                num.getClass();
                q44.b(w10Var, x20Var, ny3.c(7));
                break;
            default:
                num.getClass();
                g03.a(w10Var, x20Var, ny3.c(7));
                break;
        }
        return q43Var;
    }

    public /* synthetic */ gn0(w10 w10Var, int i, int i2) {
        this.a = i2;
        this.b = w10Var;
    }
}
