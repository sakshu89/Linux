package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class ob4 {
    public static final el0 a;
    public static final el0[] b;

    static {
        el0 el0Var = new el0(7L, "moduleinstall");
        a = el0Var;
        b = new el0[]{el0Var};
    }

    public static final long a(float f, long j) {
        return (Float.isNaN(f) || f >= 1.0f) ? j : sz.b(sz.d(j) * f, j);
    }
}
