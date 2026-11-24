package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class b82 extends g72 implements vq0 {
    public final /* synthetic */ int c;
    public int e;
    public /* synthetic */ Object f;
    public final /* synthetic */ Object i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b82(Object obj, x50 x50Var, int i) {
        super(x50Var);
        this.c = i;
        this.i = obj;
    }

    @Override // defpackage.vq0
    public final Object e(Object obj, Object obj2) {
        int i = this.c;
        q43 q43Var = q43.a;
        su2 su2Var = (su2) obj;
        x50 x50Var = (x50) obj2;
        switch (i) {
            case 0:
                return ((b82) q(x50Var, su2Var)).s(q43Var);
            case 1:
                ((b82) q(x50Var, su2Var)).s(q43Var);
                return t70.a;
            default:
                return ((b82) q(x50Var, su2Var)).s(q43Var);
        }
    }

    @Override // defpackage.pk
    public final x50 q(x50 x50Var, Object obj) {
        int i = this.c;
        Object obj2 = this.i;
        switch (i) {
            case 0:
                b82 b82Var = new b82((hq0) obj2, x50Var, 0);
                b82Var.f = obj;
                return b82Var;
            case 1:
                b82 b82Var2 = new b82((hq0) obj2, x50Var, 1);
                b82Var2.f = obj;
                return b82Var2;
            default:
                b82 b82Var3 = new b82((f9) obj2, x50Var, 2);
                b82Var3.f = obj;
                return b82Var3;
        }
    }

    /* JADX WARN: Code duplicated, block: B:74:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0058 -> B:18:0x005c). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:47:0x00e3 -> B:49:0x00e6). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:40:0x00be
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // defpackage.pk
    public final java.lang.Object s(java.lang.Object r15) {
        /*
            Method dump skipped, instruction units count: 338
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.b82.s(java.lang.Object):java.lang.Object");
    }
}
