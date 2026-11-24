package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class bo1 extends k61 implements fq0 {
    public final /* synthetic */ int b;
    public final /* synthetic */ co1 c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ bo1(co1 co1Var, int i) {
        super(0);
        this.b = i;
        this.c = co1Var;
    }

    @Override // defpackage.fq0
    public final Object a() {
        int i = this.b;
        q43 q43Var = q43.a;
        co1 co1Var = this.c;
        switch (i) {
            case 0:
                cw cwVar = co1Var.q0;
                cwVar.getClass();
                co1Var.P0(cwVar, co1Var.p0);
                break;
            default:
                co1 co1Var2 = co1Var.X;
                if (co1Var2 != null) {
                    co1Var2.c1();
                }
                break;
        }
        return q43Var;
    }
}
