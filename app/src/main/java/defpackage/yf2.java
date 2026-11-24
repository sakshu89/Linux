package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class yf2 extends nu2 implements vq0 {
    public final /* synthetic */ int f = 1;
    public int i;
    public final /* synthetic */ long j;
    public final /* synthetic */ Object k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public yf2(long j, su2 su2Var, x50 x50Var) {
        super(2, x50Var);
        this.j = j;
        this.k = su2Var;
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
        }
        return ((yf2) q(x50Var, s70Var)).s(q43Var);
    }

    @Override // defpackage.pk
    public final x50 q(x50 x50Var, Object obj) {
        int i = this.f;
        Object obj2 = this.k;
        long j = this.j;
        switch (i) {
            case 0:
                return new yf2((bd) obj2, j, x50Var);
            default:
                return new yf2(j, (su2) obj2, x50Var);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x003d, code lost:
    
        if (defpackage.bm4.b(8, r13) == r7) goto L16;
     */
    @Override // defpackage.pk
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object s(java.lang.Object r14) {
        /*
            r13 = this;
            int r0 = r13.f
            q43 r6 = defpackage.q43.a
            java.lang.Object r1 = r13.k
            r2 = 0
            java.lang.String r3 = "call to 'resume' before 'invoke' with coroutine"
            t70 r7 = defpackage.t70.a
            r5 = 1
            long r8 = r13.j
            switch(r0) {
                case 0: goto L55;
                default: goto L11;
            }
        L11:
            int r0 = r13.i
            r10 = 8
            r12 = 2
            if (r0 == 0) goto L29
            if (r0 == r5) goto L25
            if (r0 != r12) goto L20
            defpackage.bz3.g(r14)
            goto L41
        L20:
            defpackage.og.n(r3)
            r6 = r2
            goto L54
        L25:
            defpackage.bz3.g(r14)
            goto L37
        L29:
            defpackage.bz3.g(r14)
            long r2 = r8 - r10
            r13.i = r5
            java.lang.Object r0 = defpackage.bm4.b(r2, r13)
            if (r0 != r7) goto L37
            goto L3f
        L37:
            r13.i = r12
            java.lang.Object r0 = defpackage.bm4.b(r10, r13)
            if (r0 != r7) goto L41
        L3f:
            r6 = r7
            goto L54
        L41:
            su2 r1 = (defpackage.su2) r1
            yv r0 = r1.c
            if (r0 == 0) goto L54
            iy1 r1 = new iy1
            r1.<init>(r8)
            h72 r2 = new h72
            r2.<init>(r1)
            r0.h(r2)
        L54:
            return r6
        L55:
            int r0 = r13.i
            if (r0 == 0) goto L64
            if (r0 != r5) goto L5f
            defpackage.bz3.g(r14)
            goto L7e
        L5f:
            defpackage.og.n(r3)
            r6 = r2
            goto L7e
        L64:
            defpackage.bz3.g(r14)
            r0 = r1
            bd r0 = (defpackage.bd) r0
            jp1 r1 = new jp1
            r1.<init>(r8)
            vq2 r2 = defpackage.zf2.d
            r13.i = r5
            r3 = 0
            r5 = 12
            r4 = r13
            java.lang.Object r0 = defpackage.bd.c(r0, r1, r2, r3, r4, r5)
            if (r0 != r7) goto L7e
            r6 = r7
        L7e:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.yf2.s(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public yf2(bd bdVar, long j, x50 x50Var) {
        super(2, x50Var);
        this.k = bdVar;
        this.j = j;
    }
}
