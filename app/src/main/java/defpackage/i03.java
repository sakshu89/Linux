package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class i03 {
    public static final ThreadLocal a = new ThreadLocal();

    public static jj0 a() {
        ThreadLocal threadLocal = a;
        jj0 jj0Var = (jj0) threadLocal.get();
        if (jj0Var != null) {
            return jj0Var;
        }
        rl rlVar = new rl(Thread.currentThread());
        threadLocal.set(rlVar);
        return rlVar;
    }
}
