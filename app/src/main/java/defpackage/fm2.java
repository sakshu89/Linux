package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class fm2 extends g72 implements vq0 {
    public long[] c;
    public int e;
    public int f;
    public int i;
    public /* synthetic */ Object j;
    public final /* synthetic */ gm2 k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fm2(gm2 gm2Var, x50 x50Var) {
        super(x50Var);
        this.k = gm2Var;
    }

    @Override // defpackage.vq0
    public final Object e(Object obj, Object obj2) {
        return ((fm2) q((x50) obj2, (yg2) obj)).s(q43.a);
    }

    @Override // defpackage.pk
    public final x50 q(x50 x50Var, Object obj) {
        fm2 fm2Var = new fm2(this.k, x50Var);
        fm2Var.j = obj;
        return fm2Var;
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0078  */
    /* JADX WARN: Code duplicated, block: B:24:0x0080  */
    /* JADX WARN: Code duplicated, block: B:27:0x0095  */
    /* JADX WARN: Code duplicated, block: B:30:0x009a  */
    /* JADX WARN: Code duplicated, block: B:32:0x009e  */
    /* JADX WARN: Code duplicated, block: B:34:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:36:0x00bc  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x007e -> B:26:0x0093). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x00bc -> B:37:0x00be). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:27:0x0095
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // defpackage.pk
    public final java.lang.Object s(java.lang.Object r23) {
        /*
            r22 = this;
            r0 = r22
            gm2 r1 = r0.k
            long r2 = r1.a
            long r4 = r1.c
            long r6 = r1.b
            int r8 = r0.i
            r9 = 0
            r12 = 64
            r13 = 3
            r14 = 2
            r16 = 0
            r18 = 1
            r10 = 1
            t70 r11 = defpackage.t70.a
            if (r8 == 0) goto L4b
            if (r8 == r10) goto L3c
            if (r8 == r14) goto L32
            if (r8 != r13) goto L2c
            int r1 = r0.e
            java.lang.Object r6 = r0.j
            yg2 r6 = (defpackage.yg2) r6
            defpackage.bz3.g(r23)
            r7 = r13
            goto Lbe
        L2c:
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            defpackage.og.n(r0)
            return r9
        L32:
            int r1 = r0.e
            java.lang.Object r8 = r0.j
            yg2 r8 = (defpackage.yg2) r8
            defpackage.bz3.g(r23)
            goto L93
        L3c:
            int r1 = r0.f
            int r8 = r0.e
            long[] r15 = r0.c
            java.lang.Object r13 = r0.j
            yg2 r13 = (defpackage.yg2) r13
            defpackage.bz3.g(r23)
            int r8 = r8 + r10
            goto L59
        L4b:
            defpackage.bz3.g(r23)
            java.lang.Object r8 = r0.j
            r13 = r8
            yg2 r13 = (defpackage.yg2) r13
            long[] r15 = r1.e
            if (r15 == 0) goto L70
            int r1 = r15.length
            r8 = 0
        L59:
            if (r8 >= r1) goto L70
            r2 = r15[r8]
            java.lang.Long r4 = new java.lang.Long
            r4.<init>(r2)
            r0.j = r13
            r0.c = r15
            r0.e = r8
            r0.f = r1
            r0.i = r10
            r13.b(r0, r4)
            return r11
        L70:
            int r1 = (r6 > r16 ? 1 : (r6 == r16 ? 0 : -1))
            if (r1 == 0) goto L96
            r8 = r13
            r1 = 0
        L76:
            if (r1 >= r12) goto L95
            long r20 = r18 << r1
            long r20 = r6 & r20
            int r13 = (r20 > r16 ? 1 : (r20 == r16 ? 0 : -1))
            if (r13 == 0) goto L93
            long r2 = (long) r1
            long r4 = r4 + r2
            java.lang.Long r2 = new java.lang.Long
            r2.<init>(r4)
            r0.j = r8
            r0.c = r9
            r0.e = r1
            r0.i = r14
            r8.b(r0, r2)
            return r11
        L93:
            int r1 = r1 + r10
            goto L76
        L95:
            r13 = r8
        L96:
            int r1 = (r2 > r16 ? 1 : (r2 == r16 ? 0 : -1))
            if (r1 == 0) goto Lc1
            r6 = r13
            r15 = 0
        L9c:
            if (r15 >= r12) goto Lc1
            long r7 = r18 << r15
            long r7 = r7 & r2
            int r1 = (r7 > r16 ? 1 : (r7 == r16 ? 0 : -1))
            if (r1 == 0) goto Lbc
            long r1 = (long) r15
            long r4 = r4 + r1
            r1 = 64
            long r4 = r4 + r1
            java.lang.Long r1 = new java.lang.Long
            r1.<init>(r4)
            r0.j = r6
            r0.c = r9
            r0.e = r15
            r7 = 3
            r0.i = r7
            r6.b(r0, r1)
            return r11
        Lbc:
            r7 = 3
            r1 = r15
        Lbe:
            int r15 = r1 + 1
            goto L9c
        Lc1:
            q43 r0 = defpackage.q43.a
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.fm2.s(java.lang.Object):java.lang.Object");
    }
}
