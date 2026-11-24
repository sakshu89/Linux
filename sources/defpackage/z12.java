package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class z12 {
    public final ma1 a;

    public z12(fq0 fq0Var) {
        this.a = new ma1(fq0Var);
    }

    public abstract a22 a(Object obj);

    public h63 b() {
        return this.a;
    }

    public final h63 c(a22 a22Var, h63 h63Var) {
        h63 h63Var2 = null;
        h63Var2 = null;
        h63Var2 = null;
        h63Var2 = null;
        h63Var2 = null;
        h63Var2 = null;
        if (h63Var instanceof ng0) {
            if (a22Var.b) {
                ng0 ng0Var = (ng0) h63Var;
                ng0Var.a.setValue(a22Var.b());
                h63Var2 = ng0Var;
            }
        } else if (h63Var instanceof tr2) {
            if ((a22Var.a || a22Var.f != null) && !a22Var.b) {
                tr2 tr2Var = (tr2) h63Var;
                if (g31.a(a22Var.b(), tr2Var.a)) {
                    h63Var2 = tr2Var;
                }
            }
        } else if (h63Var instanceof n30) {
            a22Var.getClass();
        }
        if (h63Var2 != null) {
            return h63Var2;
        }
        if (!a22Var.b) {
            return new tr2(a22Var.b());
        }
        Object obj = a22Var.f;
        om2 om2Var = (om2) a22Var.e;
        if (om2Var == null) {
            om2Var = su0.k;
        }
        return new ng0(new ku1(obj, om2Var));
    }
}
