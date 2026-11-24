package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class qi4 {
    public static final void a(ny2 ny2Var, w10 w10Var, x20 x20Var, int i) {
        int i2;
        x20Var.X(1533506138);
        if ((i & 6) == 0) {
            i2 = (x20Var.h(ny2Var) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= x20Var.h(w10Var) ? 32 : 16;
        }
        if (x20Var.O(i2 & 1, (i2 & 19) != 18)) {
            x20Var.W(-885604480);
            ba0.b(!ny2Var.k() ? bk1.a : new fx2(new gy2(ny2Var, null, 0)).c(new qx2(ny2Var.y, new n90(ny2Var, null, 2), new hy2(ny2Var, null, 0), new v60(ny2Var, 2))), w10Var, x20Var, i2 & 112);
            x20Var.p(false);
        } else {
            x20Var.R();
        }
        a42 a42VarR = x20Var.r();
        if (a42VarR != null) {
            a42VarR.d = new s00(ny2Var, w10Var, i, 0);
        }
    }
}
