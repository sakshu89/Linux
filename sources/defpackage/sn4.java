package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class sn4 {
    /* JADX WARN: Code duplicated, block: B:27:0x0064  */
    /* JADX WARN: Code duplicated, block: B:28:0x0065  */
    /* JADX WARN: Code duplicated, block: B:31:0x0071 A[Catch: all -> 0x0035, TRY_LEAVE, TryCatch #0 {all -> 0x0035, blocks: (B:13:0x002f, B:25:0x0054, B:29:0x0069, B:31:0x0071, B:20:0x0045, B:24:0x0050), top: B:50:0x0021 }] */
    /* JADX WARN: Code duplicated, block: B:34:0x0086 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:35:0x0088  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0083, code lost:
    
        if (r1.n(r10, r0) == r5) goto L33;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x0083 -> B:14:0x0032). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object a(defpackage.nm0 r7, defpackage.bx r8, boolean r9, defpackage.x50 r10) throws java.lang.Throwable {
        /*
            boolean r0 = r10 instanceof defpackage.qm0
            if (r0 == 0) goto L13
            r0 = r10
            qm0 r0 = (defpackage.qm0) r0
            int r1 = r0.n
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.n = r1
            goto L18
        L13:
            qm0 r0 = new qm0
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.k
            int r1 = r0.n
            r2 = 0
            r3 = 2
            r4 = 1
            t70 r5 = defpackage.t70.a
            if (r1 == 0) goto L49
            if (r1 == r4) goto L3d
            if (r1 != r3) goto L37
            boolean r9 = r0.j
            pn r7 = r0.i
            bx r8 = r0.f
            nm0 r1 = r0.e
            defpackage.bz3.g(r10)     // Catch: java.lang.Throwable -> L35
        L32:
            r10 = r7
            r7 = r1
            goto L54
        L35:
            r7 = move-exception
            goto L8e
        L37:
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            defpackage.og.n(r7)
            return r2
        L3d:
            boolean r9 = r0.j
            pn r7 = r0.i
            bx r8 = r0.f
            nm0 r1 = r0.e
            defpackage.bz3.g(r10)     // Catch: java.lang.Throwable -> L35
            goto L69
        L49:
            defpackage.bz3.g(r10)
            boolean r10 = r7 instanceof defpackage.p03
            if (r10 != 0) goto La9
            pn r10 = r8.iterator()     // Catch: java.lang.Throwable -> L35
        L54:
            r0.e = r7     // Catch: java.lang.Throwable -> L35
            r0.f = r8     // Catch: java.lang.Throwable -> L35
            r0.i = r10     // Catch: java.lang.Throwable -> L35
            r0.j = r9     // Catch: java.lang.Throwable -> L35
            r0.n = r4     // Catch: java.lang.Throwable -> L35
            java.lang.Object r1 = r10.b(r0)     // Catch: java.lang.Throwable -> L35
            if (r1 != r5) goto L65
            goto L85
        L65:
            r6 = r1
            r1 = r7
            r7 = r10
            r10 = r6
        L69:
            java.lang.Boolean r10 = (java.lang.Boolean) r10     // Catch: java.lang.Throwable -> L35
            boolean r10 = r10.booleanValue()     // Catch: java.lang.Throwable -> L35
            if (r10 == 0) goto L86
            java.lang.Object r10 = r7.c()     // Catch: java.lang.Throwable -> L35
            r0.e = r1     // Catch: java.lang.Throwable -> L35
            r0.f = r8     // Catch: java.lang.Throwable -> L35
            r0.i = r7     // Catch: java.lang.Throwable -> L35
            r0.j = r9     // Catch: java.lang.Throwable -> L35
            r0.n = r3     // Catch: java.lang.Throwable -> L35
            java.lang.Object r10 = r1.n(r10, r0)     // Catch: java.lang.Throwable -> L35
            if (r10 != r5) goto L32
        L85:
            return r5
        L86:
            if (r9 == 0) goto L8b
            r8.e(r2)
        L8b:
            q43 r7 = defpackage.q43.a
            return r7
        L8e:
            throw r7     // Catch: java.lang.Throwable -> L8f
        L8f:
            r10 = move-exception
            if (r9 == 0) goto La8
            boolean r9 = r7 instanceof java.util.concurrent.CancellationException
            if (r9 == 0) goto L99
            r2 = r7
            java.util.concurrent.CancellationException r2 = (java.util.concurrent.CancellationException) r2
        L99:
            if (r2 != 0) goto La5
            java.util.concurrent.CancellationException r2 = new java.util.concurrent.CancellationException
            java.lang.String r9 = "Channel was consumed, consumer had failed"
            r2.<init>(r9)
            r2.initCause(r7)
        La5:
            r8.e(r2)
        La8:
            throw r10
        La9:
            p03 r7 = (defpackage.p03) r7
            java.lang.Throwable r7 = r7.a
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.sn4.a(nm0, bx, boolean, x50):java.lang.Object");
    }
}
