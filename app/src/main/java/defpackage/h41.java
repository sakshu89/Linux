package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class h41 extends p41 {
    public final boolean f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h41(f41 f41Var) {
        super(true);
        boolean z = true;
        X(f41Var);
        sx sxVarT = T();
        tx txVar = sxVarT instanceof tx ? (tx) sxVarT : null;
        if (txVar == null) {
            z = false;
            break;
        }
        p41 p41VarP = txVar.p();
        while (!p41VarP.P()) {
            sx sxVarT2 = p41VarP.T();
            tx txVar2 = sxVarT2 instanceof tx ? (tx) sxVarT2 : null;
            if (txVar2 == null) {
                z = false;
                break;
            }
            p41VarP = txVar2.p();
        }
        this.f = z;
    }

    @Override // defpackage.p41
    public final boolean P() {
        return this.f;
    }

    @Override // defpackage.p41
    public final boolean R() {
        return true;
    }
}
