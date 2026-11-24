package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class qv0 implements az1 {
    public final c6 a;
    public final op1 b;
    public long c = 0;

    public qv0(c6 c6Var, op1 op1Var) {
        this.a = c6Var;
        this.b = op1Var;
    }

    @Override // defpackage.az1
    public final long m(i21 i21Var, long j, z61 z61Var, long j2) {
        long jA = this.b.a();
        if ((9223372034707292159L & jA) == 9205357640488583168L) {
            jA = this.c;
        }
        this.c = jA;
        return e21.c(e21.c((((long) i21Var.b) & 4294967295L) | (((long) i21Var.a) << 32), ap4.b(jA)), this.a.a(j2, 0L, z61Var));
    }
}
