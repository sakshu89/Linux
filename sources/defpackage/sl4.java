package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class sl4 {
    public static final void a(j70 j70Var, Throwable th) {
        if (th instanceof gd0) {
            th = ((gd0) th).a;
        }
        try {
            m70 m70Var = (m70) j70Var.v(ak1.c);
            if (m70Var != null) {
                m70Var.w(j70Var, th);
            } else {
                rl4.a(j70Var, th);
            }
        } catch (Throwable th2) {
            if (th != th2) {
                RuntimeException runtimeException = new RuntimeException("Exception while trying to handle coroutine exception", th2);
                gn4.a(runtimeException, th);
                th = runtimeException;
            }
            rl4.a(j70Var, th);
        }
    }
}
