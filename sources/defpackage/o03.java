package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class o03 {
    public final ml1 a;
    public n03 b;
    public long c;
    public long d;
    public long e;
    public long f;
    public float[] g;

    public o03() {
        ml1 ml1Var = d21.a;
        this.a = new ml1();
        this.c = -1L;
        this.d = 0L;
        this.e = 0L;
    }

    public final void a(n03 n03Var, long j, long j2, float[] fArr, long j3) {
        long j4 = n03Var.g;
        if (j3 - j4 > 0 || j4 == Long.MIN_VALUE) {
            n03Var.g = j3;
            n03Var.a(n03Var.e, n03Var.f, j, j2, fArr);
        }
    }
}
