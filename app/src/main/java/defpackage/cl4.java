package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class cl4 {
    public static final void a(ny2 ny2Var, w10 w10Var, x20 x20Var, int i) {
        int i2;
        x20Var.X(2080741862);
        if ((i & 6) == 0) {
            i2 = (x20Var.h(ny2Var) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= x20Var.h(w10Var) ? 32 : 16;
        }
        if (x20Var.O(i2 & 1, (i2 & 19) != 18)) {
            qi4.a(ny2Var, w10Var, x20Var, i2 & 126);
        } else {
            x20Var.R();
        }
        a42 a42VarR = x20Var.r();
        if (a42VarR != null) {
            a42VarR.d = new s00(ny2Var, w10Var, i, 1);
        }
    }
}
