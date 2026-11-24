package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class d92 {
    public static final e92 a = new e92(jg1.b, xy.t);

    public static final e92 a(dg dgVar, kl klVar, x20 x20Var, int i) {
        if (dgVar.equals(jg1.b) && g31.a(klVar, xy.t)) {
            x20Var.W(-1073830487);
            x20Var.p(false);
            return a;
        }
        x20Var.W(-1073779616);
        boolean z = true;
        boolean z2 = (((i & 14) ^ 6) > 4 && x20Var.f(dgVar)) || (i & 6) == 4;
        if ((((i & 112) ^ 48) <= 32 || !x20Var.f(klVar)) && (i & 48) != 32) {
            z = false;
        }
        boolean z3 = z2 | z;
        Object objL = x20Var.L();
        if (z3 || objL == r20.a) {
            objL = new e92(dgVar, klVar);
            x20Var.g0(objL);
        }
        e92 e92Var = (e92) objL;
        x20Var.p(false);
        return e92Var;
    }
}
