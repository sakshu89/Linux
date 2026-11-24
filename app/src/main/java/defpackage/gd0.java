package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class gd0 extends Exception {
    public final Throwable a;

    public gd0(Throwable th, l70 l70Var, j70 j70Var) {
        super("Coroutine dispatcher " + l70Var + " threw an exception, context = " + j70Var, th);
        this.a = th;
    }

    @Override // java.lang.Throwable
    public final Throwable getCause() {
        return this.a;
    }
}
