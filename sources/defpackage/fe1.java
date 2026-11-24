package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class fe1 extends nu2 implements vq0 {
    public long f;
    public gd1 i;
    public int j;
    public final /* synthetic */ hd1 k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fe1(hd1 hd1Var, x50 x50Var) {
        super(2, x50Var);
        this.k = hd1Var;
    }

    @Override // defpackage.vq0
    public final Object e(Object obj, Object obj2) {
        return ((fe1) q((x50) obj2, (s70) obj)).s(q43.a);
    }

    @Override // defpackage.pk
    public final x50 q(x50 x50Var, Object obj) {
        return new fe1(this.k, x50Var);
    }

    /* JADX WARN: Code duplicated, block: B:20:0x002c  */
    /* JADX WARN: Code duplicated, block: B:25:0x0039 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:33:0x004b  */
    /* JADX WARN: Code duplicated, block: B:36:0x0052  */
    /* JADX WARN: Code duplicated, block: B:38:0x005c A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:39:0x005d  */
    /* JADX WARN: Code duplicated, block: B:42:0x006c A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:51:0x0024 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x006a -> B:6:0x0013). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // defpackage.pk
    public final java.lang.Object s(java.lang.Object r12) {
        /*
            r11 = this;
            hd1 r0 = r11.k
            t70 r1 = defpackage.t70.a
            int r2 = r11.j
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L1b
            if (r2 != r3) goto L15
            long r5 = r11.f
            gd1 r2 = r11.i
            defpackage.bz3.g(r12)
        L13:
            r12 = r2
            goto L23
        L15:
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            defpackage.og.n(r11)
            return r4
        L1b:
            defpackage.bz3.g(r12)
            monitor-enter(r0)
            long r5 = r0.h     // Catch: java.lang.Throwable -> L70
            monitor-exit(r0)
            r12 = r4
        L23:
            monitor-enter(r0)
            long r7 = r0.h     // Catch: java.lang.Throwable -> L6d
            monitor-exit(r0)
            int r2 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r2 == 0) goto L2c
            goto L51
        L2c:
            boolean r2 = r0.f()
            if (r2 != 0) goto L33
            goto L51
        L33:
            gd1 r2 = r0.k()
            if (r12 == 0) goto L3c
            if (r2 != 0) goto L3c
            goto L51
        L3c:
            if (r12 == 0) goto L49
            if (r2 == 0) goto L49
            long r7 = r12.a
            long r9 = r2.a
            int r7 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r7 == 0) goto L49
            goto L51
        L49:
            if (r2 == 0) goto L5d
            boolean r12 = r0.b(r2)
            if (r12 != 0) goto L52
        L51:
            return r4
        L52:
            gd1 r12 = r0.c()
            boolean r12 = defpackage.g31.a(r12, r2)
            if (r12 == 0) goto L5e
            return r2
        L5d:
            r2 = r12
        L5e:
            r11.i = r2
            r11.f = r5
            r11.j = r3
            r7 = 20
            java.lang.Object r12 = defpackage.bm4.b(r7, r11)
            if (r12 != r1) goto L13
            return r1
        L6d:
            r11 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L6d
            throw r11
        L70:
            r11 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L70
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.fe1.s(java.lang.Object):java.lang.Object");
    }
}
