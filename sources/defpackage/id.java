package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class id extends k61 implements wq0 {
    public final /* synthetic */ hq0 b;
    public final /* synthetic */ j23 c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public id(hq0 hq0Var, j23 j23Var) {
        super(3);
        this.b = hq0Var;
        this.c = j23Var;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0032  */
    @Override // defpackage.wq0
    public final Object c(Object obj, Object obj2, Object obj3) {
        long j;
        qh1 qh1Var = (qh1) obj;
        zw1 zw1VarE = ((jh1) obj2).e(((q40) obj3).a);
        if (qh1Var.s()) {
            if (((Boolean) this.b.j(this.c.d.getValue())).booleanValue()) {
                j = (((long) zw1VarE.a) << 32) | (((long) zw1VarE.b) & 4294967295L);
            } else {
                j = 0;
            }
        } else {
            j = (((long) zw1VarE.a) << 32) | (((long) zw1VarE.b) & 4294967295L);
        }
        return qh1Var.j0((int) (j >> 32), (int) (4294967295L & j), ji0.a, new d7(zw1VarE, 2));
    }
}
