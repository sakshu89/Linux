package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class qf4 {
    public static final void a(ek1 ek1Var, c6 c6Var, w10 w10Var, x20 x20Var, int i) {
        Object obj;
        x20Var.X(380139498);
        int i2 = i | 432;
        int i3 = 0;
        if (x20Var.O(i2 & 1, (i2 & 1171) != 1170)) {
            ll llVar = xy.b;
            oh1 oh1VarD = gm.d(llVar, false);
            boolean zF = x20Var.f(oh1VarD);
            Object objL = x20Var.L();
            if (zF || objL == r20.a) {
                objL = new km(i3, oh1VarD, w10Var);
                x20Var.g0(objL);
            }
            na4.a(ek1Var, (vq0) objL, x20Var, 6);
            obj = llVar;
        } else {
            x20Var.R();
            obj = c6Var;
        }
        Object obj2 = obj;
        a42 a42VarR = x20Var.r();
        if (a42VarR != null) {
            a42VarR.d = new ic(ek1Var, obj2, w10Var, i, 1);
        }
    }

    public static int b(int i) {
        if (i == 1) {
            return 0;
        }
        if (i == 2) {
            return 1;
        }
        if (i == 4) {
            return 2;
        }
        if (i == 8) {
            return 3;
        }
        if (i == 16) {
            return 4;
        }
        if (i == 32) {
            return 5;
        }
        if (i == 64) {
            return 6;
        }
        if (i == 128) {
            return 7;
        }
        if (i == 256) {
            return 8;
        }
        if (i == 512) {
            return 9;
        }
        og.i(ky0.h(i, "type needs to be >= FIRST and <= LAST, type="));
        return 0;
    }
}
