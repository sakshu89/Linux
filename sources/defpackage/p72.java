package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class p72 {
    public static final p72 d = new p72(false, 0, false);
    public static final p72 e = new p72(true, 500, false);
    public static final p72 f;
    public final long a;
    public final boolean b;
    public final boolean c;

    static {
        new p72(true, 100L, false);
        f = new p72(false, 0L, true);
    }

    public p72(boolean z, long j, boolean z2) {
        this.b = z;
        this.a = j;
        if (z2) {
            hh1.a("shouldRetry must be false when completeWithoutFailure is set to true", !z);
        }
        this.c = z2;
    }
}
