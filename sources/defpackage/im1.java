package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class im1 extends g72 implements vq0 {
    public zt0 c;
    public jm1 e;
    public long[] f;
    public int i;
    public int j;
    public int k;
    public int n;
    public long s;
    public int t;
    public /* synthetic */ Object u;
    public final /* synthetic */ jm1 v;
    public final /* synthetic */ zt0 w;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public im1(jm1 jm1Var, zt0 zt0Var, x50 x50Var) {
        super(x50Var);
        this.v = jm1Var;
        this.w = zt0Var;
    }

    @Override // defpackage.vq0
    public final Object e(Object obj, Object obj2) {
        return ((im1) q((x50) obj2, (yg2) obj)).s(q43.a);
    }

    @Override // defpackage.pk
    public final x50 q(x50 x50Var, Object obj) {
        im1 im1Var = new im1(this.v, this.w, x50Var);
        im1Var.u = obj;
        return im1Var;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0051  */
    /* JADX WARN: Code duplicated, block: B:20:0x0097 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:21:0x0099  */
    /* JADX WARN: Code duplicated, block: B:23:0x00a1  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x004f -> B:22:0x009f). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x0051 -> B:14:0x0064). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x006d -> B:19:0x0094). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // defpackage.pk
    public final java.lang.Object s(java.lang.Object r21) {
        /*
            r20 = this;
            r0 = r20
            int r1 = r0.t
            r2 = 0
            r3 = 8
            r4 = 1
            if (r1 == 0) goto L2c
            if (r1 != r4) goto L25
            int r1 = r0.n
            int r5 = r0.k
            long r6 = r0.s
            int r8 = r0.j
            int r9 = r0.i
            long[] r10 = r0.f
            jm1 r11 = r0.e
            zt0 r12 = r0.c
            java.lang.Object r13 = r0.u
            yg2 r13 = (defpackage.yg2) r13
            defpackage.bz3.g(r21)
            goto L94
        L25:
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            defpackage.og.n(r0)
            r0 = 0
            return r0
        L2c:
            defpackage.bz3.g(r21)
            java.lang.Object r1 = r0.u
            yg2 r1 = (defpackage.yg2) r1
            jm1 r5 = r0.v
            hm1 r6 = r5.b
            long[] r6 = r6.a
            int r7 = r6.length
            int r7 = r7 + (-2)
            if (r7 < 0) goto La4
            zt0 r8 = r0.w
            r9 = r2
        L41:
            r10 = r6[r9]
            long r12 = ~r10
            r14 = 7
            long r12 = r12 << r14
            long r12 = r12 & r10
            r14 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r12 = r12 & r14
            int r12 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r12 == 0) goto L9f
            int r12 = r9 - r7
            int r12 = ~r12
            int r12 = r12 >>> 31
            int r12 = 8 - r12
            r13 = r1
            r1 = r2
            r18 = r10
            r11 = r5
            r10 = r6
            r5 = r12
            r12 = r8
            r8 = r9
            r9 = r7
            r6 = r18
        L64:
            if (r1 >= r5) goto L97
            r14 = 255(0xff, double:1.26E-321)
            long r14 = r14 & r6
            r16 = 128(0x80, double:6.3E-322)
            int r14 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
            if (r14 >= 0) goto L94
            int r2 = r8 << 3
            int r2 = r2 + r1
            r12.b = r2
            hm1 r3 = r11.b
            java.lang.Object[] r3 = r3.b
            r2 = r3[r2]
            r0.u = r13
            r0.c = r12
            r0.e = r11
            r0.f = r10
            r0.i = r9
            r0.j = r8
            r0.s = r6
            r0.k = r5
            r0.n = r1
            r0.t = r4
            r13.b(r0, r2)
            t70 r0 = defpackage.t70.a
            return r0
        L94:
            long r6 = r6 >> r3
            int r1 = r1 + r4
            goto L64
        L97:
            if (r5 != r3) goto La4
            r7 = r9
            r6 = r10
            r5 = r11
            r1 = r13
            r9 = r8
            r8 = r12
        L9f:
            if (r9 == r7) goto La4
            int r9 = r9 + 1
            goto L41
        La4:
            q43 r0 = defpackage.q43.a
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.im1.s(java.lang.Object):java.lang.Object");
    }
}
