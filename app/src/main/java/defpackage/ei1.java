package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ei1 extends nu2 implements vq0 {
    public int f;
    public final /* synthetic */ xv2 i;
    public final /* synthetic */ gi1 j;
    public final /* synthetic */ wv1 k;
    public final /* synthetic */ Integer n;
    public final /* synthetic */ boolean s;
    public final /* synthetic */ String t;
    public final /* synthetic */ String u;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ei1(xv2 xv2Var, gi1 gi1Var, wv1 wv1Var, Integer num, boolean z, String str, String str2, x50 x50Var) {
        super(2, x50Var);
        this.i = xv2Var;
        this.j = gi1Var;
        this.k = wv1Var;
        this.n = num;
        this.s = z;
        this.t = str;
        this.u = str2;
    }

    @Override // defpackage.vq0
    public final Object e(Object obj, Object obj2) {
        return ((ei1) q((x50) obj2, (s70) obj)).s(q43.a);
    }

    @Override // defpackage.pk
    public final x50 q(x50 x50Var, Object obj) {
        return new ei1(this.i, this.j, this.k, this.n, this.s, this.t, this.u, x50Var);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x004a, code lost:
    
        if (r14 == r4) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x006a, code lost:
    
        if (r14 == r4) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x007c, code lost:
    
        if (r14 == r4) goto L28;
     */
    @Override // defpackage.pk
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object s(java.lang.Object r14) throws java.lang.Throwable {
        /*
            r13 = this;
            int r0 = r13.f
            r1 = 3
            r2 = 2
            r3 = 1
            if (r0 == 0) goto L21
            if (r0 == r3) goto L1d
            if (r0 == r2) goto L19
            if (r0 != r1) goto L12
            defpackage.bz3.g(r14)
            goto L7f
        L12:
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            defpackage.og.n(r13)
            r13 = 0
            return r13
        L19:
            defpackage.bz3.g(r14)
            goto L6d
        L1d:
            defpackage.bz3.g(r14)
            goto L4d
        L21:
            defpackage.bz3.g(r14)
            java.lang.Integer r14 = r13.n
            gi1 r0 = r13.j
            t70 r4 = defpackage.t70.a
            xv2 r5 = r13.i
            if (r5 == 0) goto L50
            up2 r6 = r0.e
            java.lang.String r7 = r5.a
            java.lang.String r8 = r5.b
            wv1 r0 = r13.k
            r0.getClass()
            java.util.List r11 = r0.c
            r14.getClass()
            int r9 = r14.intValue()
            r13.f = r3
            r10 = 1
            r12 = r13
            java.lang.Object r14 = r6.a(r7, r8, r9, r10, r11, r12)
            if (r14 != r4) goto L4d
            goto L7e
        L4d:
            v3 r14 = (defpackage.v3) r14
            return r14
        L50:
            r11 = r13
            up2 r5 = r0.e
            ii0 r10 = defpackage.ii0.a
            boolean r13 = r11.s
            if (r13 == 0) goto L70
            r14.getClass()
            int r8 = r14.intValue()
            r11.f = r2
            r7 = 0
            r9 = 0
            java.lang.String r6 = ""
            java.lang.Object r14 = r5.a(r6, r7, r8, r9, r10, r11)
            if (r14 != r4) goto L6d
            goto L7e
        L6d:
            v3 r14 = (defpackage.v3) r14
            return r14
        L70:
            r11.f = r1
            r9 = 0
            java.lang.String r6 = r11.t
            java.lang.String r7 = r11.u
            r8 = 0
            java.lang.Object r14 = r5.a(r6, r7, r8, r9, r10, r11)
            if (r14 != r4) goto L7f
        L7e:
            return r4
        L7f:
            v3 r14 = (defpackage.v3) r14
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ei1.s(java.lang.Object):java.lang.Object");
    }
}
