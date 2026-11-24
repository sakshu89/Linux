package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class xi0 extends k61 implements hq0 {
    public final /* synthetic */ int b;
    public final /* synthetic */ hq0 c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ xi0(hq0 hq0Var, int i) {
        super(1);
        this.b = i;
        this.c = hq0Var;
    }

    @Override // defpackage.hq0
    public final Object j(Object obj) {
        int i = this.b;
        hq0 hq0Var = this.c;
        switch (i) {
            case 0:
                long j = ((l21) obj).a;
                int i2 = (int) (j >> 32);
                return new l21((((long) ((Number) hq0Var.j(Integer.valueOf((int) (j & 4294967295L)))).intValue()) & 4294967295L) | (((long) i2) << 32));
            default:
                long j2 = ((l21) obj).a;
                int i3 = (int) (j2 >> 32);
                return new l21((((long) ((Number) hq0Var.j(Integer.valueOf((int) (j2 & 4294967295L)))).intValue()) & 4294967295L) | (((long) i3) << 32));
        }
    }
}
