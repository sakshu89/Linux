package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class jj2 extends nu2 implements vq0 {
    public final /* synthetic */ int f;
    public int i;
    public final /* synthetic */ oj2 j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ jj2(oj2 oj2Var, x50 x50Var, int i) {
        super(2, x50Var);
        this.f = i;
        this.j = oj2Var;
    }

    @Override // defpackage.vq0
    public final Object e(Object obj, Object obj2) {
        int i = this.f;
        q43 q43Var = q43.a;
        s70 s70Var = (s70) obj;
        x50 x50Var = (x50) obj2;
        switch (i) {
            case 0:
                break;
            case 1:
                break;
            case 2:
                break;
        }
        return ((jj2) q(x50Var, s70Var)).s(q43Var);
    }

    @Override // defpackage.pk
    public final x50 q(x50 x50Var, Object obj) {
        int i = this.f;
        oj2 oj2Var = this.j;
        switch (i) {
            case 0:
                return new jj2(oj2Var, x50Var, 0);
            case 1:
                return new jj2(oj2Var, x50Var, 1);
            case 2:
                return new jj2(oj2Var, x50Var, 2);
            default:
                return new jj2(oj2Var, x50Var, 3);
        }
    }

    /* JADX WARN: Code duplicated, block: B:33:0x0077  */
    /* JADX WARN: Code duplicated, block: B:61:0x0113  */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x007f, code lost:
    
        if (r1.j(r32) == r9) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0119, code lost:
    
        if (r1.j(r32) == r9) goto L63;
     */
    @Override // defpackage.pk
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object s(java.lang.Object r33) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 446
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.jj2.s(java.lang.Object):java.lang.Object");
    }
}
