package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class lj0 extends mj0 {
    public final Runnable c;

    public lj0(long j, Runnable runnable) {
        super(j);
        this.c = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.c.run();
    }

    @Override // defpackage.mj0
    public final String toString() {
        return super.toString() + this.c;
    }
}
