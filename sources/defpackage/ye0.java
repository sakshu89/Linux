package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ye0 extends g72 implements vq0 {
    public gy1 c;
    public int e;
    public int f;
    public /* synthetic */ Object i;
    public final /* synthetic */ o42 j;
    public final /* synthetic */ t42 k;
    public final /* synthetic */ t42 n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ye0(o42 o42Var, t42 t42Var, t42 t42Var2, x50 x50Var) {
        super(x50Var);
        this.j = o42Var;
        this.k = t42Var;
        this.n = t42Var2;
    }

    @Override // defpackage.vq0
    public final Object e(Object obj, Object obj2) {
        return ((ye0) q((x50) obj2, (su2) obj)).s(q43.a);
    }

    @Override // defpackage.pk
    public final x50 q(x50 x50Var, Object obj) {
        ye0 ye0Var = new ye0(this.j, this.k, this.n, x50Var);
        ye0Var.i = obj;
        return ye0Var;
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0058  */
    /* JADX WARN: Code duplicated, block: B:20:0x0065 A[LOOP:2: B:16:0x0056->B:20:0x0065, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:73:0x0068 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:74:0x0069 A[EDGE_INSN: B:74:0x0069->B:22:0x0069 BREAK  A[LOOP:2: B:16:0x0056->B:20:0x0065], SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x00af -> B:39:0x00b2). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // defpackage.pk
    public final java.lang.Object s(java.lang.Object r17) {
        /*
            Method dump skipped, instruction units count: 308
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ye0.s(java.lang.Object):java.lang.Object");
    }
}
