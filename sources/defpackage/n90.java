package defpackage;

import com.project.sonic.background.SonicVoiceService;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class n90 extends nu2 implements hq0 {
    public final /* synthetic */ int f;
    public int i;
    public final /* synthetic */ Object j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ n90(Object obj, x50 x50Var, int i) {
        super(1, x50Var);
        this.f = i;
        this.j = obj;
    }

    @Override // defpackage.hq0
    public final Object j(Object obj) {
        int i = this.f;
        q43 q43Var = q43.a;
        Object obj2 = this.j;
        x50 x50Var = (x50) obj;
        switch (i) {
            case 0:
                return new n90((t90) obj2, x50Var, 0).s(q43Var);
            case 1:
                return new n90((SonicVoiceService) obj2, x50Var, 1).s(q43Var);
            default:
                return new n90((ny2) obj2, x50Var, 2).s(q43Var);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x006e, code lost:
    
        if (r14 == r5) goto L29;
     */
    @Override // defpackage.pk
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object s(java.lang.Object r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 254
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.n90.s(java.lang.Object):java.lang.Object");
    }
}
