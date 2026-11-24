package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class dr2 extends nu2 implements wq0 {
    public int f;
    public /* synthetic */ nm0 i;
    public /* synthetic */ int j;
    public final /* synthetic */ er2 k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dr2(er2 er2Var, x50 x50Var) {
        super(3, x50Var);
        this.k = er2Var;
    }

    @Override // defpackage.wq0
    public final Object c(Object obj, Object obj2, Object obj3) {
        int iIntValue = ((Number) obj2).intValue();
        dr2 dr2Var = new dr2(this.k, (x50) obj3);
        dr2Var.i = (nm0) obj;
        dr2Var.j = iIntValue;
        return dr2Var.s(q43.a);
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0061 A[PHI: r0
      0x0061: PHI (r0v3 nm0) = (r0v2 nm0), (r0v6 nm0) binds: [B:25:0x005e, B:13:0x0023] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0044, code lost:
    
        if (r0.n(defpackage.kk2.a, r8) == r7) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x007b, code lost:
    
        if (r0.n(defpackage.kk2.c, r8) == r7) goto L32;
     */
    @Override // defpackage.pk
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object s(java.lang.Object r9) {
        /*
            r8 = this;
            int r0 = r8.f
            r1 = 0
            r2 = 5
            r3 = 4
            r4 = 3
            r5 = 2
            r6 = 1
            t70 r7 = defpackage.t70.a
            if (r0 == 0) goto L33
            if (r0 == r6) goto L2f
            if (r0 == r5) goto L29
            if (r0 == r4) goto L23
            if (r0 == r3) goto L1d
            if (r0 != r2) goto L17
            goto L2f
        L17:
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            defpackage.og.n(r8)
            return r1
        L1d:
            nm0 r0 = r8.i
            defpackage.bz3.g(r9)
            goto L71
        L23:
            nm0 r0 = r8.i
            defpackage.bz3.g(r9)
            goto L61
        L29:
            nm0 r0 = r8.i
            defpackage.bz3.g(r9)
            goto L54
        L2f:
            defpackage.bz3.g(r9)
            goto L7e
        L33:
            defpackage.bz3.g(r9)
            nm0 r0 = r8.i
            int r9 = r8.j
            if (r9 <= 0) goto L47
            r8.f = r6
            kk2 r9 = defpackage.kk2.a
            java.lang.Object r8 = r0.n(r9, r8)
            if (r8 != r7) goto L7e
            goto L7d
        L47:
            r8.i = r0
            r8.f = r5
            r5 = 0
            java.lang.Object r9 = defpackage.bm4.b(r5, r8)
            if (r9 != r7) goto L54
            goto L7d
        L54:
            r8.i = r0
            r8.f = r4
            kk2 r9 = defpackage.kk2.b
            java.lang.Object r9 = r0.n(r9, r8)
            if (r9 != r7) goto L61
            goto L7d
        L61:
            r8.i = r0
            r8.f = r3
            r3 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            java.lang.Object r9 = defpackage.bm4.b(r3, r8)
            if (r9 != r7) goto L71
            goto L7d
        L71:
            r8.i = r1
            r8.f = r2
            kk2 r9 = defpackage.kk2.c
            java.lang.Object r8 = r0.n(r9, r8)
            if (r8 != r7) goto L7e
        L7d:
            return r7
        L7e:
            q43 r8 = defpackage.q43.a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.dr2.s(java.lang.Object):java.lang.Object");
    }
}
