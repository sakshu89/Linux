package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class ao4 {
    /* JADX WARN: Code duplicated, block: B:23:0x0068  */
    /* JADX WARN: Code duplicated, block: B:26:0x0073 A[LOOP:0: B:22:0x0066->B:26:0x0073, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:30:0x0079 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:31:0x004e A[EDGE_INSN: B:31:0x004e->B:18:0x004e BREAK  A[LOOP:0: B:22:0x0066->B:26:0x0073], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x005a -> B:21:0x005d). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public static final java.lang.Object a(defpackage.su2 r7, defpackage.hy1 r8, defpackage.pk r9) {
        /*
            boolean r0 = r9 instanceof defpackage.qp0
            if (r0 == 0) goto L13
            r0 = r9
            qp0 r0 = (defpackage.qp0) r0
            int r1 = r0.j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.j = r1
            goto L18
        L13:
            qp0 r0 = new qp0
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.i
            int r1 = r0.j
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L34
            if (r1 != r3) goto L2d
            hy1 r7 = r0.f
            su2 r8 = r0.e
            defpackage.bz3.g(r9)
            r6 = r8
            r8 = r7
            r7 = r6
            goto L5d
        L2d:
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            defpackage.og.n(r7)
            r7 = 0
            return r7
        L34:
            defpackage.bz3.g(r9)
            tu2 r9 = r7.i
            gy1 r9 = r9.Z
            java.util.List r9 = r9.a
            int r1 = r9.size()
            r4 = r2
        L42:
            if (r4 >= r1) goto L79
            java.lang.Object r5 = r9.get(r4)
            ny1 r5 = (defpackage.ny1) r5
            boolean r5 = r5.d
            if (r5 == 0) goto L76
        L4e:
            r0.e = r7
            r0.f = r8
            r0.j = r3
            java.lang.Object r9 = r7.a(r8, r0)
            t70 r1 = defpackage.t70.a
            if (r9 != r1) goto L5d
            return r1
        L5d:
            gy1 r9 = (defpackage.gy1) r9
            java.util.List r9 = r9.a
            int r1 = r9.size()
            r4 = r2
        L66:
            if (r4 >= r1) goto L79
            java.lang.Object r5 = r9.get(r4)
            ny1 r5 = (defpackage.ny1) r5
            boolean r5 = r5.d
            if (r5 == 0) goto L73
            goto L4e
        L73:
            int r4 = r4 + 1
            goto L66
        L76:
            int r4 = r4 + 1
            goto L42
        L79:
            q43 r7 = defpackage.q43.a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ao4.a(su2, hy1, pk):java.lang.Object");
    }

    public static final Object b(ry1 ry1Var, vq0 vq0Var, x50 x50Var) {
        Object objI0 = ((tu2) ry1Var).I0(new rp0(x50Var.f(), vq0Var, (x50) null), x50Var);
        return objI0 == t70.a ? objI0 : q43.a;
    }
}
