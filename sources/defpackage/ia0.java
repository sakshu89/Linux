package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class ia0 {
    public static final vb0 a;

    static {
        String property;
        vb0 vb0Var;
        int i = hv2.a;
        try {
            property = System.getProperty("kotlinx.coroutines.main.delay");
        } catch (SecurityException unused) {
            property = null;
        }
        if (property != null ? Boolean.parseBoolean(property) : false) {
            xa0 xa0Var = ld0.a;
            tv0 tv0Var = ig1.a;
            tv0 tv0Var2 = tv0Var.i;
            vb0Var = tv0Var;
            if (tv0Var == null) {
                vb0Var = ha0.u;
            }
        } else {
            vb0Var = ha0.u;
        }
        a = vb0Var;
    }
}
