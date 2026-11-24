package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class f23 {
    public final g33 a;
    public final ku1 b = o44.g(null);
    public final /* synthetic */ j23 c;

    public f23(j23 j23Var, g33 g33Var, String str) {
        this.c = j23Var;
        this.a = g33Var;
    }

    public final e23 a(hq0 hq0Var, hq0 hq0Var2) {
        ku1 ku1Var = this.b;
        e23 e23Var = (e23) ku1Var.getValue();
        j23 j23Var = this.c;
        if (e23Var == null) {
            Object objJ = hq0Var2.j(j23Var.c());
            Object objJ2 = hq0Var2.j(j23Var.c());
            g33 g33Var = this.a;
            vd vdVar = (vd) g33Var.a.j(objJ2);
            vdVar.d();
            h23 h23Var = new h23(j23Var, objJ, vdVar, g33Var);
            e23Var = new e23(this, h23Var, hq0Var, hq0Var2);
            ku1Var.setValue(e23Var);
            j23Var.i.add(h23Var);
        }
        e23Var.c = hq0Var2;
        e23Var.b = hq0Var;
        e23Var.a(j23Var.f());
        return e23Var;
    }
}
