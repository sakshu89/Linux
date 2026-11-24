package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class wd2 implements fq0 {
    public final /* synthetic */ int a;
    public final /* synthetic */ ae2 b;

    public /* synthetic */ wd2(ae2 ae2Var, int i) {
        this.a = i;
        this.b = ae2Var;
    }

    @Override // defpackage.fq0
    public final Object a() {
        int i = this.a;
        ae2 ae2Var = this.b;
        switch (i) {
            case 0:
                return Boolean.valueOf(ae2Var.w);
            default:
                ko0 ko0Var = ae2Var.y0;
                if (!ko0Var.a.w) {
                    return null;
                }
                jo0 jo0VarN0 = ko0Var.N0();
                int iOrdinal = jo0VarN0.ordinal();
                if (iOrdinal != 0 && iOrdinal != 1 && iOrdinal != 2) {
                    if (iOrdinal == 3) {
                        return null;
                    }
                    dk0.l();
                    return null;
                }
                if (jo0VarN0.a()) {
                    return ko0Var.L0(null);
                }
                ko0 ko0VarF = ((do0) ((r7) cm4.h(ko0Var)).getFocusOwner()).f();
                if (ko0VarF != null) {
                    return ko0VarF.L0(cm4.f(ko0Var));
                }
                return null;
        }
    }
}
