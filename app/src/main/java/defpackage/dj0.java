package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class dj0 extends g72 implements vq0 {
    public final /* synthetic */ int c;
    public long[] e;
    public int f;
    public int i;
    public int j;
    public int k;
    public long n;
    public int s;
    public /* synthetic */ Object t;
    public Object u;
    public final /* synthetic */ Object v;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ dj0(Object obj, x50 x50Var, int i) {
        super(x50Var);
        this.c = i;
        this.v = obj;
    }

    @Override // defpackage.vq0
    public final Object e(Object obj, Object obj2) {
        int i = this.c;
        q43 q43Var = q43.a;
        yg2 yg2Var = (yg2) obj;
        x50 x50Var = (x50) obj2;
        switch (i) {
            case 0:
                break;
            case 1:
                break;
            case 2:
                break;
        }
        return ((dj0) q(x50Var, yg2Var)).s(q43Var);
    }

    @Override // defpackage.pk
    public final x50 q(x50 x50Var, Object obj) {
        int i = this.c;
        Object obj2 = this.v;
        switch (i) {
            case 0:
                dj0 dj0Var = new dj0((ej0) obj2, x50Var, 0);
                dj0Var.t = obj;
                return dj0Var;
            case 1:
                dj0 dj0Var2 = new dj0((ej0) obj2, x50Var, 1);
                dj0Var2.t = obj;
                return dj0Var2;
            case 2:
                dj0 dj0Var3 = new dj0((ab2) obj2, x50Var, 2);
                dj0Var3.t = obj;
                return dj0Var3;
            default:
                dj0 dj0Var4 = new dj0((ys2) obj2, x50Var, 3);
                dj0Var4.t = obj;
                return dj0Var4;
        }
    }

    /* JADX WARN: Code duplicated, block: B:77:0x0223  */
    /* JADX WARN: Code duplicated, block: B:85:0x0270 A[DONT_INVERT, PHI: r1 r4 r5 r6 r8
      0x0270: PHI (r1v6 yg2) = (r1v4 yg2), (r1v8 yg2) binds: [B:76:0x0221, B:84:0x026b] A[DONT_GENERATE, DONT_INLINE]
      0x0270: PHI (r4v4 long[]) = (r4v2 long[]), (r4v6 long[]) binds: [B:76:0x0221, B:84:0x026b] A[DONT_GENERATE, DONT_INLINE]
      0x0270: PHI (r5v4 int) = (r5v2 int), (r5v6 int) binds: [B:76:0x0221, B:84:0x026b] A[DONT_GENERATE, DONT_INLINE]
      0x0270: PHI (r6v2 int) = (r6v1 int), (r6v4 int) binds: [B:76:0x0221, B:84:0x026b] A[DONT_GENERATE, DONT_INLINE]
      0x0270: PHI (r8v4 ej0) = (r8v2 ej0), (r8v6 ej0) binds: [B:76:0x0221, B:84:0x026b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:86:0x0272  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x006d -> B:22:0x00ac). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x006f -> B:15:0x007e). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0084 -> B:19:0x00a2). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x00fe -> B:43:0x013e). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x0100 -> B:36:0x0111). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x0117 -> B:40:0x0135). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:55:0x0190 -> B:64:0x01d0). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:56:0x0192 -> B:57:0x01a3). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:59:0x01a9 -> B:61:0x01c7). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:76:0x0221 -> B:85:0x0270). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:77:0x0223 -> B:78:0x0235). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:80:0x023b -> B:82:0x0266). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // defpackage.pk
    public final java.lang.Object s(java.lang.Object r26) {
        /*
            Method dump skipped, instruction units count: 640
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.dj0.s(java.lang.Object):java.lang.Object");
    }
}
