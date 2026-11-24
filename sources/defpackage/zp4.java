package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class zp4 {
    public static final void a(t91 t91Var, Object obj, int i, Object obj2, x20 x20Var, int i2) {
        x20Var.X(1439843069);
        int i3 = (x20Var.f(t91Var) ? 4 : 2) | i2 | (x20Var.f(obj) ? 32 : 16) | (x20Var.d(i) ? 256 : 128) | (x20Var.f(obj2) ? 2048 : 1024);
        if (x20Var.O(i3 & 1, (i3 & 1171) != 1170)) {
            ((y92) obj).b(obj2, yi4.b(980966366, new w81(i, t91Var, obj2), x20Var), x20Var, 48);
        } else {
            x20Var.R();
        }
        a42 a42VarR = x20Var.r();
        if (a42VarR != null) {
            a42VarR.d = new mb(t91Var, obj, i, obj2, i2);
        }
    }
}
