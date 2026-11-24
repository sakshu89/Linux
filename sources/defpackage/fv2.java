package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
final class fv2 extends ik1 {
    public final hq0 a;

    public fv2(hq0 hq0Var) {
        this.a = hq0Var;
    }

    @Override // defpackage.ik1
    public final dk1 e() {
        gv2 gv2Var = new gv2();
        zl0 zl0Var = ib4.a;
        gv2Var.x = zl0Var;
        gv2Var.H = zl0Var;
        gv2Var.X = zl0Var;
        gv2Var.Y = this.a;
        return gv2Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof fv2) {
            return this.a == ((fv2) obj).a;
        }
        return false;
    }

    @Override // defpackage.ik1
    public final void f(dk1 dk1Var) {
        gv2 gv2Var = (gv2) dk1Var;
        hq0 hq0Var = gv2Var.Y;
        hq0 hq0Var2 = this.a;
        if (hq0Var != hq0Var2) {
            gv2Var.Y = hq0Var2;
            tb3 tb3Var = gv2Var.Z;
            if (tb3Var != null) {
                na3 na3Var = (na3) hq0Var2.j(tb3Var);
                if (g31.a(na3Var, gv2Var.X)) {
                    return;
                }
                gv2Var.X = na3Var;
                gv2Var.I0();
            }
        }
    }

    public final int hashCode() {
        return this.a.hashCode();
    }
}
