package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class pf2 extends g72 implements vq0 {
    public final /* synthetic */ int c = 1;
    public int e;
    public /* synthetic */ Object f;
    public Object i;
    public Object j;
    public final /* synthetic */ Object k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public pf2(t9 t9Var, s9 s9Var, wx2 wx2Var, x50 x50Var) {
        super(x50Var);
        this.i = t9Var;
        this.j = s9Var;
        this.k = wx2Var;
    }

    @Override // defpackage.vq0
    public final Object e(Object obj, Object obj2) {
        int i = this.c;
        q43 q43Var = q43.a;
        su2 su2Var = (su2) obj;
        x50 x50Var = (x50) obj2;
        switch (i) {
            case 0:
                break;
        }
        return ((pf2) q(x50Var, su2Var)).s(q43Var);
    }

    @Override // defpackage.pk
    public final x50 q(x50 x50Var, Object obj) {
        int i = this.c;
        Object obj2 = this.k;
        switch (i) {
            case 0:
                pf2 pf2Var = new pf2((t9) this.i, (s9) this.j, (wx2) obj2, x50Var);
                pf2Var.f = obj;
                return pf2Var;
            default:
                pf2 pf2Var2 = new pf2((ms2) obj2, x50Var);
                pf2Var2.f = obj;
                return pf2Var2;
        }
    }

    /* JADX WARN: Code duplicated, block: B:155:0x027c  */
    /* JADX WARN: Code duplicated, block: B:180:0x0302  */
    /* JADX WARN: Code duplicated, block: B:195:0x033e  */
    /* JADX WARN: Code duplicated, block: B:197:0x0345  */
    /* JADX WARN: Code duplicated, block: B:200:0x0352  */
    /* JADX WARN: Code duplicated, block: B:210:0x010d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:213:0x0106 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:251:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:256:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:257:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:42:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:44:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:46:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:49:0x0102  */
    /* JADX WARN: Code duplicated, block: B:55:0x0118  */
    /* JADX WARN: Code duplicated, block: B:60:0x012e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:138:0x0243 -> B:140:0x0246). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x00d2 -> B:40:0x00d6). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // defpackage.pk
    public final java.lang.Object s(java.lang.Object r24) {
        /*
            Method dump skipped, instruction units count: 870
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.pf2.s(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public pf2(ms2 ms2Var, x50 x50Var) {
        super(x50Var);
        this.k = ms2Var;
    }
}
