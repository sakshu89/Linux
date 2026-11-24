package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class dz3 {
    public static final py0 a;
    public static final py0 b;

    static {
        int i = 16;
        a = new py0(i, "REMOVED_TASK");
        b = new py0(i, "CLOSED_EMPTY");
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0052  */
    /* JADX WARN: Code duplicated, block: B:25:0x005f A[LOOP:0: B:21:0x0050->B:25:0x005f, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:29:0x0031 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x003d -> B:18:0x0040). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public static final java.lang.Object a(defpackage.su2 r6, defpackage.pk r7) {
        /*
            boolean r0 = r7 instanceof defpackage.a82
            if (r0 == 0) goto L13
            r0 = r7
            a82 r0 = (defpackage.a82) r0
            int r1 = r0.i
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.i = r1
            goto L18
        L13:
            a82 r0 = new a82
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.f
            int r1 = r0.i
            r2 = 1
            if (r1 == 0) goto L2e
            if (r1 != r2) goto L27
            su2 r6 = r0.e
            defpackage.bz3.g(r7)
            goto L40
        L27:
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            defpackage.og.n(r6)
            r6 = 0
            return r6
        L2e:
            defpackage.bz3.g(r7)
        L31:
            r0.e = r6
            r0.i = r2
            hy1 r7 = defpackage.hy1.b
            java.lang.Object r7 = r6.a(r7, r0)
            t70 r1 = defpackage.t70.a
            if (r7 != r1) goto L40
            return r1
        L40:
            gy1 r7 = (defpackage.gy1) r7
            int r1 = r7.d
            java.util.List r7 = r7.a
            r1 = r1 & 66
            if (r1 == 0) goto L31
            int r1 = r7.size()
            r3 = 0
            r4 = r3
        L50:
            if (r4 >= r1) goto L62
            java.lang.Object r5 = r7.get(r4)
            ny1 r5 = (defpackage.ny1) r5
            boolean r5 = defpackage.y11.a(r5)
            if (r5 != 0) goto L5f
            goto L31
        L5f:
            int r4 = r4 + 1
            goto L50
        L62:
            java.lang.Object r6 = r7.get(r3)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.dz3.a(su2, pk):java.lang.Object");
    }
}
