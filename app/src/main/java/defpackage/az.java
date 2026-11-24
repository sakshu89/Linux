package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class az implements AutoCloseable, s70 {
    public final j70 a;

    public az(j70 j70Var) {
        j70Var.getClass();
        this.a = j70Var;
    }

    @Override // java.lang.AutoCloseable
    public final void close() {
        f41 f41Var = (f41) this.a.v(nr4.k);
        if (f41Var != null) {
            f41Var.e(null);
        }
    }

    @Override // defpackage.s70
    public final j70 o() {
        return this.a;
    }
}
