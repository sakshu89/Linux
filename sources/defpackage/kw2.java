package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class kw2 extends hw2 {
    public final Runnable c;

    public kw2(Runnable runnable, long j, boolean z) {
        super(j, z);
        this.c = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.c.run();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Task[");
        Runnable runnable = this.c;
        sb.append(runnable.getClass().getSimpleName());
        sb.append('@');
        sb.append(ba0.c(runnable));
        sb.append(", ");
        sb.append(this.a);
        sb.append(", ");
        return ky0.n(sb, this.b ? "Blocking" : "Non-blocking", ']');
    }
}
