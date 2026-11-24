package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ji2 implements vq0 {
    public final /* synthetic */ int a;
    public final /* synthetic */ fq0 b;

    public /* synthetic */ ji2(fq0 fq0Var, int i) {
        this.a = 2;
        this.b = fq0Var;
    }

    @Override // defpackage.vq0
    public final Object e(Object obj, Object obj2) {
        int i = this.a;
        q43 q43Var = q43.a;
        fq0 fq0Var = this.b;
        x20 x20Var = (x20) obj;
        Integer num = (Integer) obj2;
        switch (i) {
            case 0:
                int iIntValue = num.intValue();
                if (!x20Var.O(iIntValue & 1, (iIntValue & 3) != 2)) {
                    x20Var.R();
                } else {
                    k34.g("VIEW HISTORY & LOGS", false, fq0Var, x20Var, 54);
                }
                break;
            case 1:
                int iIntValue2 = num.intValue();
                if (!x20Var.O(iIntValue2 & 1, (iIntValue2 & 3) != 2)) {
                    x20Var.R();
                } else {
                    k34.d(fq0Var, x20Var, 6);
                }
                break;
            default:
                num.getClass();
                k34.d(fq0Var, x20Var, ny3.c(7));
                break;
        }
        return q43Var;
    }

    public /* synthetic */ ji2(fq0 fq0Var, int i, byte b) {
        this.a = i;
        this.b = fq0Var;
    }
}
