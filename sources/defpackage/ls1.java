package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ls1 implements vq0 {
    public final /* synthetic */ int a = 1;
    public final /* synthetic */ String b;
    public final /* synthetic */ long c;

    public /* synthetic */ ls1(int i, long j, String str) {
        this.b = str;
        this.c = j;
    }

    @Override // defpackage.vq0
    public final Object e(Object obj, Object obj2) {
        int i = this.a;
        q43 q43Var = q43.a;
        switch (i) {
            case 0:
                x20 x20Var = (x20) obj;
                int iIntValue = ((Integer) obj2).intValue();
                if (!x20Var.O(iIntValue & 1, (iIntValue & 3) != 2)) {
                    x20Var.R();
                } else {
                    yz2 yz2Var = ((v33) x20Var.j(w33.a)).o;
                    dz2.b(this.b, c34.d(bk1.a, 6.0f, 3.0f), this.c, 0L, np0.f, null, 0L, null, 0L, 0, false, 0, 0, yz2Var, x20Var, 1572912, 0, 131000);
                }
                break;
            default:
                ((Integer) obj2).getClass();
                k34.a(this.b, this.c, (x20) obj, ny3.c(49));
                break;
        }
        return q43Var;
    }

    public /* synthetic */ ls1(long j, String str) {
        this.b = str;
        this.c = j;
    }
}
