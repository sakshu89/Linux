package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class iy3 {
    public static final w10 a = new w10(-1788872807, false, new w8(2));
    public static final w10 b = new w10(-1119076197, false, new w8(3));

    public static final void a(long j, yz2 yz2Var, w10 w10Var, x20 x20Var, int i) {
        x20Var.X(-684938728);
        int i2 = (x20Var.e(j) ? 4 : 2) | i | (x20Var.f(yz2Var) ? 32 : 16);
        if (x20Var.O(i2 & 1, (i2 & 147) != 146)) {
            m30 m30Var = dz2.a;
            kj4.b(new a22[]{g50.a.a(new sz(j)), m30Var.a(((yz2) x20Var.j(m30Var)).d(yz2Var))}, w10Var, x20Var, 56);
        } else {
            x20Var.R();
        }
        a42 a42VarR = x20Var.r();
        if (a42VarR != null) {
            a42VarR.d = new u8(j, yz2Var, w10Var, i, 4);
        }
    }
}
