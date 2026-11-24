package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class r50 {
    public final um2 a = new um2();

    public static void b(r50 r50Var, vq0 vq0Var, w10 w10Var, fq0 fq0Var, int i) {
        if ((i & 8) != 0) {
            w10Var = null;
        }
        r50Var.a.add(new w10(-1789283891, true, new x81(vq0Var, r50Var, w10Var, fq0Var)));
    }

    public final void a(q50 q50Var, x20 x20Var, int i) {
        x20Var.X(-798501095);
        int i2 = (x20Var.f(q50Var) ? 4 : 2) | i | (x20Var.f(this) ? 32 : 16);
        if (x20Var.O(i2 & 1, (i2 & 19) != 18)) {
            um2 um2Var = this.a;
            int size = um2Var.size();
            for (int i3 = 0; i3 < size; i3++) {
                ((wq0) um2Var.get(i3)).c(q50Var, x20Var, Integer.valueOf(i2 & 14));
            }
        } else {
            x20Var.R();
        }
        a42 a42VarR = x20Var.r();
        if (a42VarR != null) {
            a42VarR.d = new km(i, 3, this, q50Var);
        }
    }
}
