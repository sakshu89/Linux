package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class sq implements ir0 {
    public final /* synthetic */ int a;
    public final /* synthetic */ tw b;
    public final /* synthetic */ yq c;

    public /* synthetic */ sq(yq yqVar, tw twVar, int i) {
        this.a = i;
        this.c = yqVar;
        this.b = twVar;
    }

    @Override // defpackage.ir0
    public final void c(Object obj) {
        switch (this.a) {
            case 0:
                this.c.v.remove(this.b);
                int iX = cq.x(this.c.q0);
                if (iX != 1 && iX != 4) {
                    if (iX == 5 || (iX == 6 && this.c.t != 0)) {
                        this.c.t("Camera reopen required. Checking if the current camera can be closed safely.");
                    }
                }
                if (this.c.v.isEmpty()) {
                    yq yqVar = this.c;
                    if (yqVar.s != null) {
                        yqVar.t("closing camera");
                        this.c.s.close();
                        this.c.s = null;
                    }
                }
                break;
            default:
                yq yqVar2 = this.c;
                if (yqVar2.H.c == 2 && yqVar2.q0 == 9) {
                    this.c.E(10);
                    break;
                }
                break;
        }
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0033  */
    /* JADX WARN: Code duplicated, block: B:16:0x003d  */
    /*  JADX ERROR: JadxRuntimeException in pass: IfRegionVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r1v9 kh2, still in use, count: 2, list:
          (r1v9 kh2) from 0x0025: INVOKE (r1v9 kh2) VIRTUAL call: kh2.b():java.util.List A[MD:():java.util.List (m), WRAPPED] (LINE:38)
          (r1v9 kh2) from 0x0031: PHI (r1 I:??) = (r1v6 kh2), (r1v9 kh2) binds: [B:12:0x0030, B:28:0x0031] A[DONT_GENERATE, DONT_INLINE]
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
        	at jadx.core.utils.InsnRemover.unbindInsn(InsnRemover.java:93)
        	at jadx.core.dex.visitors.regions.TernaryMod.makeTernaryInsn(TernaryMod.java:132)
        	at jadx.core.dex.visitors.regions.TernaryMod.processRegion(TernaryMod.java:67)
        	at jadx.core.dex.visitors.regions.TernaryMod.enterRegion(TernaryMod.java:50)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:96)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:27)
        	at jadx.core.dex.visitors.regions.TernaryMod.process(TernaryMod.java:36)
        	at jadx.core.dex.visitors.regions.IfRegionVisitor.process(IfRegionVisitor.java:44)
        	at jadx.core.dex.visitors.regions.IfRegionVisitor.visit(IfRegionVisitor.java:30)
        */
    @Override // defpackage.ir0
    public final void i(java.lang.Throwable r5) {
        /*
            r4 = this;
            int r0 = r4.a
            switch(r0) {
                case 0: goto L8e;
                default: goto L5;
            }
        L5:
            boolean r0 = r5 instanceof defpackage.nb0
            yq r1 = r4.c
            if (r0 == 0) goto L52
            nb0 r5 = (defpackage.nb0) r5
            ob0 r5 = r5.a
            sg1 r0 = r1.a
            java.util.Collection r0 = r0.b()
            java.util.Iterator r0 = r0.iterator()
        L19:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L30
            java.lang.Object r1 = r0.next()
            kh2 r1 = (defpackage.kh2) r1
            java.util.List r2 = r1.b()
            boolean r2 = r2.contains(r5)
            if (r2 == 0) goto L19
            goto L31
        L30:
            r1 = 0
        L31:
            if (r1 == 0) goto L8e
            yq r4 = r4.c
            xv0 r5 = defpackage.xg4.c()
            ih2 r0 = r1.f
            if (r0 == 0) goto L8e
            java.lang.Throwable r2 = new java.lang.Throwable
            r2.<init>()
            java.lang.String r2 = "Posting surface closed"
            r4.t(r2)
            o8 r4 = new o8
            r2 = 8
            r4.<init>(r2, r0, r1)
            r5.execute(r4)
            goto L8e
        L52:
            boolean r0 = r5 instanceof java.util.concurrent.CancellationException
            if (r0 == 0) goto L5c
            java.lang.String r4 = "Unable to configure camera cancelled"
            r1.t(r4)
            goto L8e
        L5c:
            int r0 = r1.q0
            r1 = 9
            if (r0 != r1) goto L6e
            yq r0 = r4.c
            wh r2 = new wh
            r3 = 4
            r2.<init>(r3, r5)
            r3 = 1
            r0.F(r1, r2, r3)
        L6e:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Unable to configure camera "
            r0.<init>(r1)
            yq r1 = r4.c
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "Camera2CameraImpl"
            defpackage.xq4.b(r1, r0, r5)
            yq r5 = r4.c
            tw r0 = r5.u
            tw r4 = r4.b
            if (r0 != r4) goto L8e
            r5.D()
        L8e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.sq.i(java.lang.Throwable):void");
    }

    private final void a(Throwable th) {
    }
}
