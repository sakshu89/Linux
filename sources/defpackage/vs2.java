package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class vs2 extends k61 implements vq0 {
    public final /* synthetic */ int b;
    public final /* synthetic */ ws2 c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ vs2(ws2 ws2Var, int i) {
        super(2);
        this.b = i;
        this.c = ws2Var;
    }

    @Override // defpackage.vq0
    public final Object e(Object obj, Object obj2) {
        int i = this.b;
        q43 q43Var = q43.a;
        ws2 ws2Var = this.c;
        switch (i) {
            case 0:
                ws2Var.a().b = (a30) obj2;
                break;
            case 1:
                b81 b81VarA = ws2Var.a();
                ((n71) obj).c0(new x71(b81VarA, (vq0) obj2, b81VarA.H));
                break;
            default:
                n71 n71Var = (n71) obj;
                zs2 zs2Var = ws2Var.a;
                b81 b81Var = n71Var.q0;
                if (b81Var == null) {
                    b81Var = new b81(n71Var, zs2Var);
                    n71Var.q0 = b81Var;
                }
                ws2Var.b = b81Var;
                ws2Var.a().h();
                b81 b81VarA2 = ws2Var.a();
                if (b81VarA2.c != zs2Var) {
                    b81VarA2.c = zs2Var;
                    b81VarA2.i(false);
                    n71.V(b81VarA2.a, false, 7);
                }
                break;
        }
        return q43Var;
    }
}
