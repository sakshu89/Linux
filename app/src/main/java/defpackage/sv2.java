package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class sv2 extends g72 implements vq0 {
    public yq2 c;
    public int e;
    public /* synthetic */ Object f;
    public final /* synthetic */ s70 i;
    public final /* synthetic */ wq0 j;
    public final /* synthetic */ hq0 k;
    public final /* synthetic */ zz1 n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public sv2(s70 s70Var, wq0 wq0Var, hq0 hq0Var, zz1 zz1Var, x50 x50Var) {
        super(x50Var);
        this.i = s70Var;
        this.j = wq0Var;
        this.k = hq0Var;
        this.n = zz1Var;
    }

    @Override // defpackage.vq0
    public final Object e(Object obj, Object obj2) {
        return ((sv2) q((x50) obj2, (su2) obj)).s(q43.a);
    }

    @Override // defpackage.pk
    public final x50 q(x50 x50Var, Object obj) {
        sv2 sv2Var = new sv2(this.i, this.j, this.k, this.n, x50Var);
        sv2Var.f = obj;
        return sv2Var;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0072, code lost:
    
        if (r14 == r11) goto L20;
     */
    @Override // defpackage.pk
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object s(java.lang.Object r14) {
        /*
            r13 = this;
            int r0 = r13.e
            r1 = 0
            s70 r2 = r13.i
            r3 = 2
            r4 = 1
            zz1 r7 = r13.n
            r9 = 0
            t70 r11 = defpackage.t70.a
            if (r0 == 0) goto L2c
            if (r0 == r4) goto L21
            if (r0 != r3) goto L1a
            java.lang.Object r0 = r13.f
            f41 r0 = (defpackage.f41) r0
            defpackage.bz3.g(r14)
            goto L75
        L1a:
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            defpackage.og.n(r13)
            r13 = 0
            return r13
        L21:
            yq2 r0 = r13.c
            java.lang.Object r5 = r13.f
            su2 r5 = (defpackage.su2) r5
            defpackage.bz3.g(r14)
        L2a:
            r12 = r5
            goto L51
        L2c:
            defpackage.bz3.g(r14)
            java.lang.Object r14 = r13.f
            r5 = r14
            su2 r5 = (defpackage.su2) r5
            nv2 r14 = defpackage.vv2.a
            rv2 r14 = new rv2
            r14.<init>(r7, r9, r1)
            yq2 r14 = defpackage.uf4.b(r2, r9, r14, r4)
            r13.f = r5
            r13.c = r14
            r13.e = r4
            r0 = 3
            java.lang.Object r0 = defpackage.vv2.b(r5, r13, r0)
            if (r0 != r11) goto L4d
            goto L74
        L4d:
            r12 = r0
            r0 = r14
            r14 = r12
            goto L2a
        L51:
            r8 = r14
            ny1 r8 = (defpackage.ny1) r8
            r8.a()
            nv2 r14 = defpackage.vv2.a
            wq0 r6 = r13.j
            if (r6 == r14) goto L66
            pv2 r5 = new pv2
            r10 = 0
            r5.<init>(r6, r7, r8, r9, r10)
            defpackage.vv2.d(r2, r0, r5)
        L66:
            r13.f = r0
            r13.c = r9
            r13.e = r3
            hy1 r14 = defpackage.hy1.b
            java.lang.Object r14 = defpackage.vv2.e(r12, r14, r13)
            if (r14 != r11) goto L75
        L74:
            return r11
        L75:
            ny1 r14 = (defpackage.ny1) r14
            if (r14 != 0) goto L82
            qv2 r13 = new qv2
            r13.<init>(r7, r9, r1)
            defpackage.vv2.d(r2, r0, r13)
            goto L99
        L82:
            r14.a()
            qv2 r1 = new qv2
            r1.<init>(r7, r9, r4)
            defpackage.vv2.d(r2, r0, r1)
            long r0 = r14.c
            jp1 r14 = new jp1
            r14.<init>(r0)
            hq0 r13 = r13.k
            r13.j(r14)
        L99:
            q43 r13 = defpackage.q43.a
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.sv2.s(java.lang.Object):java.lang.Object");
    }
}
