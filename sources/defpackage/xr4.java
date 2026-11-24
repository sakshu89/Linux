package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class xr4 {
    public static final void a(rl2 rl2Var, xf xfVar, int i) {
        while (true) {
            int i2 = rl2Var.v;
            if (i > i2 && i < rl2Var.u) {
                return;
            }
            if (i2 == 0 && i == 0) {
                return;
            }
            rl2Var.M();
            if (rl2Var.y(rl2Var.v)) {
                xfVar.j();
            }
            rl2Var.j();
        }
    }
}
