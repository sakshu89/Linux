package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class wm1 extends nu2 implements vq0 {
    public an1 f;
    public Object i;
    public ab0 j;
    public xm1 k;
    public int n;
    public /* synthetic */ Object s;
    public final /* synthetic */ rm1 t;
    public final /* synthetic */ xm1 u;
    public final /* synthetic */ r0 v;
    public final /* synthetic */ ab0 w;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public wm1(rm1 rm1Var, xm1 xm1Var, r0 r0Var, ab0 ab0Var, x50 x50Var) {
        super(2, x50Var);
        this.t = rm1Var;
        this.u = xm1Var;
        this.v = r0Var;
        this.w = ab0Var;
    }

    @Override // defpackage.vq0
    public final Object e(Object obj, Object obj2) {
        return ((wm1) q((x50) obj2, (s70) obj)).s(q43.a);
    }

    @Override // defpackage.pk
    public final x50 q(x50 x50Var, Object obj) {
        wm1 wm1Var = new wm1(this.t, this.u, this.v, this.w, x50Var);
        wm1Var.s = obj;
        return wm1Var;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ConstInlineVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Unexpected instance arg in invoke
        	at jadx.core.dex.visitors.ConstInlineVisitor.addExplicitCast(ConstInlineVisitor.java:285)
        	at jadx.core.dex.visitors.ConstInlineVisitor.replaceArg(ConstInlineVisitor.java:267)
        	at jadx.core.dex.visitors.ConstInlineVisitor.replaceConst(ConstInlineVisitor.java:177)
        	at jadx.core.dex.visitors.ConstInlineVisitor.checkInsn(ConstInlineVisitor.java:110)
        	at jadx.core.dex.visitors.ConstInlineVisitor.process(ConstInlineVisitor.java:55)
        	at jadx.core.dex.visitors.ConstInlineVisitor.visit(ConstInlineVisitor.java:47)
        */
    @Override // defpackage.pk
    public final java.lang.Object s(java.lang.Object r9) {
        /*
            r8 = this;
            int r0 = r8.n
            r1 = 2
            r2 = 1
            r3 = 0
            t70 r4 = defpackage.t70.a
            if (r0 == 0) goto L3c
            if (r0 == r2) goto L25
            if (r0 != r1) goto L1f
            java.lang.Object r0 = r8.i
            xm1 r0 = (defpackage.xm1) r0
            an1 r1 = r8.f
            java.lang.Object r8 = r8.s
            um1 r8 = (defpackage.um1) r8
            defpackage.bz3.g(r9)     // Catch: java.lang.Throwable -> L1c
            goto L90
        L1c:
            r9 = move-exception
            goto Lab
        L1f:
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            defpackage.og.n(r8)
            return r3
        L25:
            xm1 r0 = r8.k
            ab0 r2 = r8.j
            java.lang.Object r5 = r8.i
            vq0 r5 = (defpackage.vq0) r5
            an1 r6 = r8.f
            java.lang.Object r7 = r8.s
            um1 r7 = (defpackage.um1) r7
            defpackage.bz3.g(r9)
            r9 = r6
            r6 = r5
            r5 = r9
            r9 = r0
            r0 = r7
            goto L78
        L3c:
            defpackage.bz3.g(r9)
            java.lang.Object r9 = r8.s
            s70 r9 = (defpackage.s70) r9
            um1 r0 = new um1
            j70 r9 = r9.o()
            nr4 r5 = defpackage.nr4.k
            h70 r9 = r9.v(r5)
            r9.getClass()
            f41 r9 = (defpackage.f41) r9
            rm1 r5 = r8.t
            r0.<init>(r5, r9)
            xm1 r9 = r8.u
            defpackage.xm1.a(r9, r0)
            an1 r5 = r9.b
            r8.s = r0
            r8.f = r5
            r0 r6 = r8.v
            r8.i = r6
            ab0 r7 = r8.w
            r8.j = r7
            r8.k = r9
            r8.n = r2
            java.lang.Object r2 = r5.e(r8)
            if (r2 != r4) goto L77
            goto L8a
        L77:
            r2 = r7
        L78:
            r8.s = r0     // Catch: java.lang.Throwable -> La5
            r8.f = r5     // Catch: java.lang.Throwable -> La5
            r8.i = r9     // Catch: java.lang.Throwable -> La5
            r8.j = r3     // Catch: java.lang.Throwable -> La5
            r8.k = r3     // Catch: java.lang.Throwable -> La5
            r8.n = r1     // Catch: java.lang.Throwable -> La5
            java.lang.Object r8 = r6.e(r2, r8)     // Catch: java.lang.Throwable -> La5
            if (r8 != r4) goto L8b
        L8a:
            return r4
        L8b:
            r1 = r9
            r9 = r8
            r8 = r0
            r0 = r1
            r1 = r5
        L90:
            java.util.concurrent.atomic.AtomicReference r0 = r0.a     // Catch: java.lang.Throwable -> La3
        L92:
            boolean r2 = r0.compareAndSet(r8, r3)     // Catch: java.lang.Throwable -> La3
            if (r2 == 0) goto L99
            goto L9f
        L99:
            java.lang.Object r2 = r0.get()     // Catch: java.lang.Throwable -> La3
            if (r2 == r8) goto L92
        L9f:
            r1.h(r3)
            return r9
        La3:
            r8 = move-exception
            goto Lbb
        La5:
            r8 = move-exception
            r1 = r9
            r9 = r8
            r8 = r0
            r0 = r1
            r1 = r5
        Lab:
            java.util.concurrent.atomic.AtomicReference r0 = r0.a     // Catch: java.lang.Throwable -> La3
        Lad:
            boolean r2 = r0.compareAndSet(r8, r3)     // Catch: java.lang.Throwable -> La3
            if (r2 != 0) goto Lba
            java.lang.Object r2 = r0.get()     // Catch: java.lang.Throwable -> La3
            if (r2 != r8) goto Lba
            goto Lad
        Lba:
            throw r9     // Catch: java.lang.Throwable -> La3
        Lbb:
            r1.h(r3)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.wm1.s(java.lang.Object):java.lang.Object");
    }
}
