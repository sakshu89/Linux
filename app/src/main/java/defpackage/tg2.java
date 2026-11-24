package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class tg2 {
    public static final py0 b;
    public static final py0 c;
    public static final py0 d;
    public static final py0 e;
    public static final int a = ab4.c(100, 12, "kotlinx.coroutines.semaphore.maxSpinCycles");
    public static final int f = ab4.c(16, 12, "kotlinx.coroutines.semaphore.segmentSize");

    static {
        int i = 16;
        b = new py0(i, "PERMIT");
        c = new py0(i, "TAKEN");
        d = new py0(i, "BROKEN");
        e = new py0(i, "CANCELLED");
    }
}
