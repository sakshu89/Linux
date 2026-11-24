package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class z8 {
    public static final float a = (25.0f * 2.0f) / 2.4142137f;

    public static final void a(op1 op1Var, ek1 ek1Var, long j, x20 x20Var, int i) {
        int i2;
        x20Var.X(1776202187);
        int i3 = (x20Var.f(op1Var) ? 4 : 2) | i | (x20Var.f(ek1Var) ? 32 : 16) | 128;
        if (x20Var.O(i3 & 1, (i3 & 147) != 146)) {
            x20Var.T();
            if ((i & 1) == 0 || x20Var.y()) {
                i2 = i3 & (-897);
                j = 9205357640488583168L;
            } else {
                x20Var.R();
                i2 = i3 & (-897);
            }
            x20Var.q();
            int i4 = i2 & 14;
            boolean z = i4 == 4;
            Object objL = x20Var.L();
            if (z || objL == r20.a) {
                objL = new x0(4, op1Var);
                x20Var.g0(objL);
            }
            vd4.a(op1Var, xy.c, yi4.b(-1653527038, new t8(0, j, dg2.a(ek1Var, (hq0) objL)), x20Var), x20Var, i4 | 432);
        } else {
            x20Var.R();
        }
        long j2 = j;
        a42 a42VarR = x20Var.r();
        if (a42VarR != null) {
            a42VarR.d = new u8(op1Var, ek1Var, j2, i);
        }
    }

    public static final void b(ek1 ek1Var, x20 x20Var, int i, int i2) {
        int i3;
        x20Var.X(694251107);
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
        } else {
            i3 = (x20Var.f(ek1Var) ? 4 : 2) | i;
        }
        if (x20Var.O(i3 & 1, (i3 & 3) != 2)) {
            if (i4 != 0) {
                ek1Var = bk1.a;
            }
            k54.h(x20Var, gj4.a(w44.h(ek1Var, a, 25.0f), new w8(0)));
        } else {
            x20Var.R();
        }
        a42 a42VarR = x20Var.r();
        if (a42VarR != null) {
            a42VarR.d = new v8(ek1Var, i, i2);
        }
    }
}
