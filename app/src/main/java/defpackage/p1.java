package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class p1 {
    public static final p1 b;
    public static final p1 c;
    public final Throwable a;

    static {
        if (w1.e) {
            c = null;
            b = null;
        } else {
            c = new p1(null, false);
            b = new p1(null, true);
        }
    }

    public p1(Throwable th, boolean z) {
        this.a = th;
    }
}
