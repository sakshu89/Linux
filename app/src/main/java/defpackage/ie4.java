package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class ie4 {
    public static final void a(x20 x20Var, Integer num, vq0 vq0Var) {
        if (x20Var.S) {
            x20Var.b(vq0Var, num);
        }
    }

    public static final void b(x20 x20Var, hq0 hq0Var) {
        x20Var.b(new ha(19, hq0Var), q43.a);
    }

    public static final void c(x20 x20Var, vq0 vq0Var, Object obj) {
        if (x20Var.S || !g31.a(x20Var.L(), obj)) {
            x20Var.g0(obj);
            x20Var.b(vq0Var, obj);
        }
    }

    public static vq2 d(int i, Object obj) {
        float f = (i & 2) != 0 ? 1500.0f : 400.0f;
        if ((i & 4) != 0) {
            obj = null;
        }
        return new vq2(1.0f, f, obj);
    }

    public static f33 e(int i, tg0 tg0Var, int i2) {
        if ((i2 & 4) != 0) {
            tg0Var = ug0.a;
        }
        return new f33(i, tg0Var);
    }
}
