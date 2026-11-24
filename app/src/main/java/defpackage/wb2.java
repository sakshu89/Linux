package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class wb2 extends nu2 implements vq0 {
    public long f;
    public wc2 i;
    public int j;
    public int k;
    public final /* synthetic */ xb2 n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public wb2(xb2 xb2Var, x50 x50Var) {
        super(2, x50Var);
        this.n = xb2Var;
    }

    @Override // defpackage.vq0
    public final Object e(Object obj, Object obj2) {
        return ((wb2) q((x50) obj2, (s70) obj)).s(q43.a);
    }

    @Override // defpackage.pk
    public final x50 q(x50 x50Var, Object obj) {
        return new wb2(this.n, x50Var);
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0030  */
    /* JADX WARN: Code duplicated, block: B:20:0x003e  */
    /* JADX WARN: Code duplicated, block: B:22:0x0050 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:30:0x0025 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x003c -> B:23:0x0051). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x004e -> B:23:0x0051). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:15:0x0030
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // defpackage.pk
    public final java.lang.Object s(java.lang.Object r9) {
        /*
            r8 = this;
            int r0 = r8.k
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L18
            if (r0 != r1) goto L12
            int r0 = r8.j
            long r3 = r8.f
            wc2 r5 = r8.i
            defpackage.bz3.g(r9)
            goto L51
        L12:
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            defpackage.og.n(r8)
            return r2
        L18:
            defpackage.bz3.g(r9)
            long r3 = java.lang.System.currentTimeMillis()
            r9 = 0
            r0 = r9
            r9 = r2
        L22:
            r5 = 6
            if (r0 >= r5) goto L54
            xb2 r9 = r8.n     // Catch: java.lang.Throwable -> L2d
            wc2 r9 = defpackage.xb2.a(r9)     // Catch: java.lang.Throwable -> L2d
            r5 = r9
            goto L2e
        L2d:
            r5 = r2
        L2e:
            if (r5 == 0) goto L3b
            java.util.List r9 = r5.c
            boolean r9 = r9.isEmpty()
            r9 = r9 ^ r1
            if (r9 != r1) goto L3b
            r9 = r5
            goto L54
        L3b:
            r9 = 5
            if (r0 >= r9) goto L51
            r8.i = r5
            r8.f = r3
            r8.j = r0
            r8.k = r1
            r6 = 120(0x78, double:5.93E-322)
            java.lang.Object r9 = defpackage.bm4.b(r6, r8)
            t70 r6 = defpackage.t70.a
            if (r9 != r6) goto L51
            return r6
        L51:
            r9 = r5
            int r0 = r0 + r1
            goto L22
        L54:
            if (r9 == 0) goto L5f
            java.util.List r8 = r9.c
            boolean r8 = r8.isEmpty()
            if (r8 != 0) goto L5f
            r2 = r9
        L5f:
            java.lang.System.currentTimeMillis()
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.wb2.s(java.lang.Object):java.lang.Object");
    }
}
