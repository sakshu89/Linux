package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class o00 extends nu2 implements vq0 {
    public bx f;
    public byte[] i;
    public int j;
    public int k;
    public int n;
    public /* synthetic */ Object s;
    public final /* synthetic */ mm0[] t;
    public final /* synthetic */ ym0 u;
    public final /* synthetic */ nm0 v;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o00(mm0[] mm0VarArr, ym0 ym0Var, nm0 nm0Var, x50 x50Var) {
        super(2, x50Var);
        this.t = mm0VarArr;
        this.u = ym0Var;
        this.v = nm0Var;
    }

    @Override // defpackage.vq0
    public final Object e(Object obj, Object obj2) {
        return ((o00) q((x50) obj2, (s70) obj)).s(q43.a);
    }

    @Override // defpackage.pk
    public final x50 q(x50 x50Var, Object obj) {
        o00 o00Var = new o00(this.t, this.u, this.v, x50Var);
        o00Var.s = obj;
        return o00Var;
    }

    /* JADX WARN: Code duplicated, block: B:27:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:30:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:32:0x00b9 A[DONT_INVERT, EDGE_INSN: B:32:0x00b9->B:18:0x007a BREAK  A[LOOP:0: B:25:0x009a->B:38:?]] */
    /* JADX WARN: Code duplicated, block: B:33:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:37:0x00b9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:38:? A[LOOP:0: B:25:0x009a->B:38:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x00cf -> B:18:0x007a). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // defpackage.pk
    public final java.lang.Object s(java.lang.Object r18) {
        /*
            Method dump skipped, instruction units count: 210
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.o00.s(java.lang.Object):java.lang.Object");
    }
}
