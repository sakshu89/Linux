package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class xp1 implements fq0 {
    public final /* synthetic */ int a;
    public final /* synthetic */ bq1 b;

    public /* synthetic */ xp1(bq1 bq1Var, int i) {
        this.a = i;
        this.b = bq1Var;
    }

    @Override // defpackage.fq0
    public final Object a() {
        int i = this.a;
        q43 q43Var = q43.a;
        bq1 bq1Var = this.b;
        switch (i) {
            case 0:
                bq1Var.b();
                break;
            case 1:
                bq1Var.a();
                break;
            default:
                bq1Var.b();
                break;
        }
        return q43Var;
    }
}
