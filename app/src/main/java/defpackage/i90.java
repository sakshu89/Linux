package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class i90 extends nu2 implements vq0 {
    public final /* synthetic */ int f;
    public int i;
    public final /* synthetic */ w90 j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ i90(w90 w90Var, x50 x50Var, int i) {
        super(2, x50Var);
        this.f = i;
        this.j = w90Var;
    }

    @Override // defpackage.vq0
    public final Object e(Object obj, Object obj2) {
        int i = this.f;
        q43 q43Var = q43.a;
        switch (i) {
            case 0:
                return ((i90) q((x50) obj2, (nm0) obj)).s(q43Var);
            case 1:
                return ((i90) q((x50) obj2, (s70) obj)).s(q43Var);
            default:
                return ((i90) q((x50) obj2, (s70) obj)).s(q43Var);
        }
    }

    @Override // defpackage.pk
    public final x50 q(x50 x50Var, Object obj) {
        int i = this.f;
        w90 w90Var = this.j;
        switch (i) {
            case 0:
                return new i90(w90Var, x50Var, 0);
            case 1:
                return new i90(w90Var, x50Var, 1);
            default:
                return new i90(w90Var, x50Var, 2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0049, code lost:
    
        if (r10 == r5) goto L22;
     */
    @Override // defpackage.pk
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object s(java.lang.Object r10) throws java.lang.Throwable {
        /*
            r9 = this;
            int r0 = r9.f
            q43 r1 = defpackage.q43.a
            r2 = -1
            r3 = 0
            java.lang.String r4 = "call to 'resume' before 'invoke' with coroutine"
            t70 r5 = defpackage.t70.a
            w90 r6 = r9.j
            r7 = 1
            r8 = 2
            switch(r0) {
                case 0: goto L9b;
                case 1: goto L57;
                default: goto L11;
            }
        L11:
            q82 r0 = r6.k
            int r1 = r9.i
            if (r1 == 0) goto L29
            if (r1 == r7) goto L23
            if (r1 != r8) goto L1f
            defpackage.bz3.g(r10)
            goto L4d
        L1f:
            defpackage.og.n(r4)
            goto L56
        L23:
            defpackage.bz3.g(r10)     // Catch: java.lang.Throwable -> L27
            goto L42
        L27:
            r9 = move-exception
            goto L51
        L29:
            defpackage.bz3.g(r10)
            fr2 r10 = r0.B()
            boolean r10 = r10 instanceof defpackage.wl0
            if (r10 == 0) goto L39
            fr2 r3 = r0.B()
            goto L56
        L39:
            r9.i = r7     // Catch: java.lang.Throwable -> L27
            java.lang.Object r10 = r6.i(r9)     // Catch: java.lang.Throwable -> L27
            if (r10 != r5) goto L42
            goto L4b
        L42:
            r9.i = r8
            r10 = 0
            java.lang.Object r10 = defpackage.w90.f(r6, r10, r9)
            if (r10 != r5) goto L4d
        L4b:
            r3 = r5
            goto L56
        L4d:
            r3 = r10
            fr2 r3 = (defpackage.fr2) r3
            goto L56
        L51:
            w22 r3 = new w22
            r3.<init>(r2, r9)
        L56:
            return r3
        L57:
            int r0 = r9.i
            if (r0 == 0) goto L6c
            if (r0 == r7) goto L68
            if (r0 != r8) goto L63
            defpackage.bz3.g(r10)
            goto L9a
        L63:
            defpackage.og.n(r4)
            r1 = r3
            goto L9a
        L68:
            defpackage.bz3.g(r10)
            goto L82
        L6c:
            defpackage.bz3.g(r10)
            p6 r10 = r6.n
            r9.i = r7
            java.lang.Object r10 = r10.b
            x00 r10 = (defpackage.x00) r10
            java.lang.Object r10 = r10.s0(r9)
            if (r10 != r5) goto L7e
            goto L7f
        L7e:
            r10 = r1
        L7f:
            if (r10 != r5) goto L82
            goto L99
        L82:
            uk2 r10 = r6.h()
            l90 r10 = r10.c
            mm0 r10 = defpackage.rn4.a(r10, r2)
            x9 r0 = new x9
            r0.<init>(r8, r6)
            r9.i = r8
            java.lang.Object r9 = r10.a(r0, r9)
            if (r9 != r5) goto L9a
        L99:
            r1 = r5
        L9a:
            return r1
        L9b:
            int r0 = r9.i
            if (r0 == 0) goto Laa
            if (r0 != r7) goto La5
            defpackage.bz3.g(r10)
            goto Lb6
        La5:
            defpackage.og.n(r4)
            r1 = r3
            goto Lb6
        Laa:
            defpackage.bz3.g(r10)
            r9.i = r7
            java.lang.Object r9 = defpackage.w90.e(r6, r9)
            if (r9 != r5) goto Lb6
            r1 = r5
        Lb6:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.i90.s(java.lang.Object):java.lang.Object");
    }
}
