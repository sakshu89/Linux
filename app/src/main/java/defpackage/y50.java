package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class y50 extends pk {
    public final j70 b;
    public transient x50 c;

    public y50(x50 x50Var) {
        this(x50Var, x50Var != null ? x50Var.f() : null);
    }

    @Override // defpackage.x50
    public j70 f() {
        j70 j70Var = this.b;
        j70Var.getClass();
        return j70Var;
    }

    @Override // defpackage.pk
    public void t() {
        x50 x50Var = this.c;
        if (x50Var != null && x50Var != this) {
            h70 h70VarV = f().v(qs4.c);
            h70VarV.getClass();
            hd0 hd0Var = (hd0) x50Var;
            hd0Var.n();
            yv yvVarP = hd0Var.p();
            if (yvVarP != null) {
                yvVarP.q();
            }
        }
        this.c = z00.b;
    }

    public y50(x50 x50Var, j70 j70Var) {
        super(x50Var);
        this.b = j70Var;
    }
}
