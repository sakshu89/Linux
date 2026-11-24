package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class dh4 {
    public static final void a(ek1 ek1Var, hq0 hq0Var, x20 x20Var, int i) {
        int i2;
        x20Var.X(-932836462);
        if ((i & 6) == 0) {
            i2 = (x20Var.f(ek1Var) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= x20Var.h(hq0Var) ? 32 : 16;
        }
        int i3 = 0;
        if (x20Var.O(i2 & 1, (i2 & 19) != 18)) {
            k54.h(x20Var, az3.a(ek1Var, hq0Var));
        } else {
            x20Var.R();
        }
        a42 a42VarR = x20Var.r();
        if (a42VarR != null) {
            a42VarR.d = new gw(i, i3, ek1Var, hq0Var);
        }
    }

    public static void b(int i, Object[] objArr) {
        for (int i2 = 0; i2 < i; i2++) {
            if (objArr[i2] == null) {
                dk0.n(ky0.h(i2, "at index "));
                return;
            }
        }
    }
}
