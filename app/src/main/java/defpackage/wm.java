package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class wm {
    public final pm1 a = new pm1(new xm[16]);

    /* JADX WARN: Code duplicated, block: B:16:0x0045  */
    /* JADX WARN: Code duplicated, block: B:18:0x0061 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x005f -> B:19:0x0062). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object a(defpackage.l42 r8, defpackage.y50 r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof defpackage.vm
            if (r0 == 0) goto L13
            r0 = r9
            vm r0 = (defpackage.vm) r0
            int r1 = r0.s
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.s = r1
            goto L18
        L13:
            vm r0 = new vm
            r0.<init>(r7, r9)
        L18:
            java.lang.Object r9 = r0.k
            int r1 = r0.s
            r2 = 1
            if (r1 == 0) goto L35
            if (r1 != r2) goto L2e
            int r7 = r0.j
            int r8 = r0.i
            java.lang.Object[] r1 = r0.f
            l42 r3 = r0.e
            defpackage.bz3.g(r9)
            r9 = r3
            goto L62
        L2e:
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            defpackage.og.n(r7)
            r7 = 0
            return r7
        L35:
            defpackage.bz3.g(r9)
            pm1 r7 = r7.a
            java.lang.Object[] r9 = r7.a
            int r7 = r7.c
            r1 = 0
            r6 = r9
            r9 = r8
            r8 = r1
            r1 = r6
        L43:
            if (r8 >= r7) goto L64
            r3 = r1[r8]
            xm r3 = (defpackage.xm) r3
            kb r4 = new kb
            r5 = 2
            r4.<init>(r5, r9)
            r0.e = r9
            r0.f = r1
            r0.i = r8
            r0.j = r7
            r0.s = r2
            java.lang.Object r3 = defpackage.sf4.a(r3, r4, r0)
            t70 r4 = defpackage.t70.a
            if (r3 != r4) goto L62
            return r4
        L62:
            int r8 = r8 + r2
            goto L43
        L64:
            q43 r7 = defpackage.q43.a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.wm.a(l42, y50):java.lang.Object");
    }
}
