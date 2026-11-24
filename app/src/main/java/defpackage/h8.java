package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class h8 extends k61 implements vq0 {
    public final /* synthetic */ int b = 1;
    public final /* synthetic */ tc c;
    public final /* synthetic */ vq0 e;
    public final /* synthetic */ it1 f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h8(r7 r7Var, tc tcVar, vq0 vq0Var) {
        super(2);
        this.f = r7Var;
        this.c = tcVar;
        this.e = vq0Var;
    }

    @Override // defpackage.vq0
    public final Object e(Object obj, Object obj2) {
        int i = this.b;
        q43 q43Var = q43.a;
        vq0 vq0Var = this.e;
        tc tcVar = this.c;
        it1 it1Var = this.f;
        switch (i) {
            case 0:
                x20 x20Var = (x20) obj;
                int iIntValue = ((Number) obj2).intValue();
                if (!x20Var.O(iIntValue & 1, (iIntValue & 3) != 2)) {
                    x20Var.R();
                } else {
                    l30.a((r7) it1Var, tcVar, vq0Var, x20Var, 0);
                }
                break;
            default:
                ((Number) obj2).intValue();
                l30.a(it1Var, tcVar, vq0Var, (x20) obj, ny3.c(1));
                break;
        }
        return q43Var;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h8(it1 it1Var, tc tcVar, vq0 vq0Var, int i) {
        super(2);
        this.f = it1Var;
        this.c = tcVar;
        this.e = vq0Var;
    }
}
