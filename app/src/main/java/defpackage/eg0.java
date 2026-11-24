package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class eg0 implements Comparable {
    public static final xy a = new xy(12);
    public static final long b = ym4.b(4611686018427387903L);
    public static final long c = ym4.b(-4611686018427387903L);

    public static final long a(long j, long j2) {
        long j3 = j2 / 1000000;
        long jA = ym4.a(j, j3);
        if (-4611686018426L > jA || jA >= 4611686018427L) {
            return ym4.b(jA);
        }
        long j4 = ((jA * 1000000) + (j2 - (j3 * 1000000))) << 1;
        int i = gg0.a;
        return j4;
    }
}
