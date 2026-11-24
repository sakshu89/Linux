package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class zi0 extends k61 implements hq0 {
    public final /* synthetic */ zw1 b;
    public final /* synthetic */ long c;
    public final /* synthetic */ long e;
    public final /* synthetic */ ke0 f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zi0(zw1 zw1Var, long j, long j2, ke0 ke0Var) {
        super(1);
        this.b = zw1Var;
        this.c = j;
        this.e = j2;
        this.f = ke0Var;
    }

    @Override // defpackage.hq0
    public final Object j(Object obj) {
        yw1 yw1Var = (yw1) obj;
        long j = this.c;
        long j2 = this.e;
        yw1Var.getClass();
        zw1 zw1Var = this.b;
        yw1.a(yw1Var, zw1Var);
        zw1Var.n0(e21.c((((long) (((int) (j >> 32)) + ((int) (j2 >> 32)))) << 32) | (((long) (((int) (j & 4294967295L)) + ((int) (j2 & 4294967295L)))) & 4294967295L), zw1Var.f), 0.0f, this.f);
        return q43.a;
    }
}
