package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class v90 extends nu2 implements vq0 {
    public r42 f;
    public int i;
    public /* synthetic */ Object j;
    public final /* synthetic */ r42 k;
    public final /* synthetic */ w90 n;
    public final /* synthetic */ Object s;
    public final /* synthetic */ boolean t;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v90(r42 r42Var, w90 w90Var, Object obj, boolean z, x50 x50Var) {
        super(2, x50Var);
        this.k = r42Var;
        this.n = w90Var;
        this.s = obj;
        this.t = z;
    }

    @Override // defpackage.vq0
    public final Object e(Object obj, Object obj2) {
        return ((v90) q((x50) obj2, (pl0) obj)).s(q43.a);
    }

    @Override // defpackage.pk
    public final x50 q(x50 x50Var, Object obj) {
        v90 v90Var = new v90(this.k, this.n, this.s, this.t, x50Var);
        v90Var.j = obj;
        return v90Var;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0060, code lost:
    
        if (r6.b(r2, r8) == r7) goto L16;
     */
    @Override // defpackage.pk
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object s(java.lang.Object r9) {
        /*
            r8 = this;
            int r0 = r8.i
            r1 = 0
            java.lang.Object r2 = r8.s
            w90 r3 = r8.n
            r42 r4 = r8.k
            r5 = 2
            r6 = 1
            t70 r7 = defpackage.t70.a
            if (r0 == 0) goto L27
            if (r0 == r6) goto L1d
            if (r0 != r5) goto L17
            defpackage.bz3.g(r9)
            goto L63
        L17:
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            defpackage.og.n(r8)
            return r1
        L1d:
            r42 r0 = r8.f
            java.lang.Object r6 = r8.j
            pl0 r6 = (defpackage.pl0) r6
            defpackage.bz3.g(r9)
            goto L4e
        L27:
            defpackage.bz3.g(r9)
            java.lang.Object r9 = r8.j
            pl0 r9 = (defpackage.pl0) r9
            uk2 r0 = r3.h()
            r8.j = r9
            r8.f = r4
            r8.i = r6
            q82 r0 = r0.b
            java.lang.Object r0 = r0.a
            java.util.concurrent.atomic.AtomicInteger r0 = (java.util.concurrent.atomic.AtomicInteger) r0
            int r0 = r0.incrementAndGet()
            java.lang.Integer r6 = new java.lang.Integer
            r6.<init>(r0)
            if (r6 != r7) goto L4a
            goto L62
        L4a:
            r0 = r6
            r6 = r9
            r9 = r0
            r0 = r4
        L4e:
            java.lang.Number r9 = (java.lang.Number) r9
            int r9 = r9.intValue()
            r0.a = r9
            r8.j = r1
            r8.f = r1
            r8.i = r5
            java.lang.Object r9 = r6.b(r2, r8)
            if (r9 != r7) goto L63
        L62:
            return r7
        L63:
            boolean r8 = r8.t
            if (r8 == 0) goto L7b
            q82 r8 = r3.k
            y80 r9 = new y80
            if (r2 == 0) goto L72
            int r0 = r2.hashCode()
            goto L73
        L72:
            r0 = 0
        L73:
            int r1 = r4.a
            r9.<init>(r2, r0, r1)
            r8.K(r9)
        L7b:
            q43 r8 = defpackage.q43.a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.v90.s(java.lang.Object):java.lang.Object");
    }
}
