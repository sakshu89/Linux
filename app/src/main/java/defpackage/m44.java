package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class m44 {
    public static final py0 a;
    public static final py0 b;
    public static final py0 c;
    public static final py0 d;
    public static final py0 e;

    static {
        int i = 16;
        a = new py0(i, "STATE_REG");
        b = new py0(i, "STATE_COMPLETED");
        c = new py0(i, "STATE_CANCELLED");
        d = new py0(i, "NO_RESULT");
        e = new py0(i, "PARAM_CLAUSE_0");
    }

    public static final int a(long[] jArr, long j) {
        int length = jArr.length - 1;
        int i = 0;
        while (i <= length) {
            int i2 = (i + length) >>> 1;
            long j2 = jArr[i2];
            if (j > j2) {
                i = i2 + 1;
            } else {
                if (j >= j2) {
                    return i2;
                }
                length = i2 - 1;
            }
        }
        return -(i + 1);
    }
}
