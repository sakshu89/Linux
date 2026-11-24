package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class xa0 extends vj0 {
    public static final xa0 e;
    public r70 c;

    static {
        int i = nw2.c;
        int i2 = nw2.d;
        long j = nw2.e;
        String str = nw2.a;
        xa0 xa0Var = new xa0();
        xa0Var.c = new r70(i, i2, j, str);
        e = xa0Var;
    }

    @Override // defpackage.l70
    public final void L(j70 j70Var, Runnable runnable) {
        r70.j(this.c, runnable, 6);
    }

    @Override // defpackage.l70
    public final void M(j70 j70Var, Runnable runnable) {
        r70.j(this.c, runnable, 2);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        throw new UnsupportedOperationException("Dispatchers.Default cannot be closed");
    }

    @Override // defpackage.l70
    public final String toString() {
        return "Dispatchers.Default";
    }
}
