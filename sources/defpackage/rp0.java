package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class rp0 extends g72 implements vq0 {
    public final /* synthetic */ int c;
    public int e;
    public Object f;
    public Object i;
    public final /* synthetic */ Object j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public rp0(j70 j70Var, vq0 vq0Var, x50 x50Var) {
        super(x50Var);
        this.c = 0;
        this.i = j70Var;
        this.j = vq0Var;
    }

    @Override // defpackage.vq0
    public final Object e(Object obj, Object obj2) {
        int i = this.c;
        q43 q43Var = q43.a;
        switch (i) {
            case 0:
                return ((rp0) q((x50) obj2, (su2) obj)).s(q43Var);
            case 1:
                return ((rp0) q((x50) obj2, (su2) obj)).s(q43Var);
            default:
                return ((rp0) q((x50) obj2, (yg2) obj)).s(q43Var);
        }
    }

    @Override // defpackage.pk
    public final x50 q(x50 x50Var, Object obj) {
        int i = this.c;
        Object obj2 = this.j;
        switch (i) {
            case 0:
                rp0 rp0Var = new rp0((j70) this.i, (vq0) obj2, x50Var);
                rp0Var.f = obj;
                return rp0Var;
            case 1:
                rp0 rp0Var2 = new rp0((wx2) obj2, x50Var, 1);
                rp0Var2.f = obj;
                return rp0Var2;
            default:
                rp0 rp0Var3 = new rp0((kb) obj2, x50Var, 2);
                rp0Var3.i = obj;
                return rp0Var3;
        }
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0036  */
    /* JADX WARN: Code duplicated, block: B:13:0x0041  */
    /* JADX WARN: Code duplicated, block: B:61:0x0107  */
    /* JADX WARN: Code duplicated, block: B:76:0x00f9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:83:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:86:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v24 */
    /* JADX WARN: Type inference failed for: r15v5, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r15v7 */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.lang.Object, su2] */
    /* JADX WARN: Type inference failed for: r4v23 */
    /* JADX WARN: Type inference failed for: r4v24 */
    /* JADX WARN: Type inference failed for: r4v25 */
    /* JADX WARN: Type inference failed for: r4v26 */
    /* JADX WARN: Type inference failed for: r4v27 */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.lang.Object, su2] */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v8, types: [vq0] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x0041 -> B:14:0x0042). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x0090 -> B:30:0x0094). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:63:0x0110 -> B:49:0x00e0). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:70:0x0125 -> B:49:0x00e0). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // defpackage.pk
    public final java.lang.Object s(java.lang.Object r15) {
        /*
            Method dump skipped, instruction units count: 308
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.rp0.s(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ rp0(Object obj, x50 x50Var, int i) {
        super(x50Var);
        this.c = i;
        this.j = obj;
    }
}
