package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class w implements nm0 {
    public final /* synthetic */ int a;
    public final /* synthetic */ nm0 b;

    public w(nm0 nm0Var, j5 j5Var) {
        this.a = 2;
        this.b = nm0Var;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:13:0x0032  */
    /* JADX WARN: Code duplicated, block: B:147:0x0250  */
    /* JADX WARN: Code duplicated, block: B:148:0x0253  */
    /* JADX WARN: Code duplicated, block: B:171:0x02b7  */
    /* JADX WARN: Code duplicated, block: B:195:0x0317  */
    /* JADX WARN: Code duplicated, block: B:42:0x008f  */
    /* JADX WARN: Code duplicated, block: B:70:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:84:0x0135  */
    /* JADX WARN: Code duplicated, block: B:98:0x0168  */
    /*  JADX ERROR: JadxRuntimeException in pass: IfRegionVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r6v19 java.lang.Object, still in use, count: 2, list:
          (r6v19 java.lang.Object) from 0x012e: PHI (r6 I:??) = (r6v16 java.lang.Object), (r6v19 java.lang.Object) binds: [B:79:0x012d, B:211:0x012e] A[DONT_GENERATE, DONT_INLINE]
          (r6v19 java.lang.Object) from 0x0120: CHECK_CAST (l82) (r6v19 java.lang.Object)
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
    @Override // defpackage.nm0
    public final java.lang.Object n(java.lang.Object r24, defpackage.x50 r25) {
        /*
            Method dump skipped, instruction units count: 910
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.w.n(java.lang.Object, x50):java.lang.Object");
    }

    public /* synthetic */ w(nm0 nm0Var, int i) {
        this.a = i;
        this.b = nm0Var;
    }
}
