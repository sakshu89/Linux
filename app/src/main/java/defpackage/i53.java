package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class i53 {
    public static final rd f = new rd(0.0f);
    public final s63 a;
    public long b = Long.MIN_VALUE;
    public rd c = f;
    public boolean d;
    public float e;

    public i53(pd pdVar) {
        this.a = pdVar.a(eb4.a);
    }

    /* JADX WARN: Code duplicated, block: B:30:0x007e A[Catch: all -> 0x003a, PHI: r0 r2 r3 r13
      0x007e: PHI (r0v16 hq0) = (r0v9 hq0), (r0v17 hq0) binds: [B:29:0x0076, B:37:0x00ae] A[DONT_GENERATE, DONT_INLINE]
      0x007e: PHI (r2v5 fq0) = (r2v3 fq0), (r2v6 fq0) binds: [B:29:0x0076, B:37:0x00ae] A[DONT_GENERATE, DONT_INLINE]
      0x007e: PHI (r3v4 h53) = (r3v2 h53), (r3v5 h53) binds: [B:29:0x0076, B:37:0x00ae] A[DONT_GENERATE, DONT_INLINE]
      0x007e: PHI (r13v1 float) = (r13v0 float), (r13v2 float) binds: [B:29:0x0076, B:37:0x00ae] A[DONT_GENERATE, DONT_INLINE], TRY_ENTER, TryCatch #0 {all -> 0x003a, blocks: (B:13:0x0035, B:44:0x00d8, B:20:0x004b, B:36:0x00a9, B:30:0x007e, B:33:0x008c, B:38:0x00b0, B:41:0x00bb), top: B:49:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:32:0x008b  */
    /* JADX WARN: Code duplicated, block: B:33:0x008c A[Catch: all -> 0x003a, TryCatch #0 {all -> 0x003a, blocks: (B:13:0x0035, B:44:0x00d8, B:20:0x004b, B:36:0x00a9, B:30:0x007e, B:33:0x008c, B:38:0x00b0, B:41:0x00bb), top: B:49:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:35:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:36:0x00a9 A[Catch: all -> 0x003a, PHI: r0 r2 r3 r13
      0x00a9: PHI (r0v17 hq0) = (r0v16 hq0), (r0v20 hq0) binds: [B:34:0x00a6, B:21:0x004e] A[DONT_GENERATE, DONT_INLINE]
      0x00a9: PHI (r2v6 fq0) = (r2v5 fq0), (r2v8 fq0) binds: [B:34:0x00a6, B:21:0x004e] A[DONT_GENERATE, DONT_INLINE]
      0x00a9: PHI (r3v5 h53) = (r3v4 h53), (r3v7 h53) binds: [B:34:0x00a6, B:21:0x004e] A[DONT_GENERATE, DONT_INLINE]
      0x00a9: PHI (r13v2 float) = (r13v1 float), (r13v4 float) binds: [B:34:0x00a6, B:21:0x004e] A[DONT_GENERATE, DONT_INLINE], TryCatch #0 {all -> 0x003a, blocks: (B:13:0x0035, B:44:0x00d8, B:20:0x004b, B:36:0x00a9, B:30:0x007e, B:33:0x008c, B:38:0x00b0, B:41:0x00bb), top: B:49:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:38:0x00b0 A[Catch: all -> 0x003a, PHI: r0 r2 r3
      0x00b0: PHI (r0v12 hq0) = (r0v16 hq0), (r0v17 hq0) binds: [B:32:0x008b, B:37:0x00ae] A[DONT_GENERATE, DONT_INLINE]
      0x00b0: PHI (r2v4 fq0) = (r2v5 fq0), (r2v6 fq0) binds: [B:32:0x008b, B:37:0x00ae] A[DONT_GENERATE, DONT_INLINE]
      0x00b0: PHI (r3v3 h53) = (r3v4 h53), (r3v5 h53) binds: [B:32:0x008b, B:37:0x00ae] A[DONT_GENERATE, DONT_INLINE], TryCatch #0 {all -> 0x003a, blocks: (B:13:0x0035, B:44:0x00d8, B:20:0x004b, B:36:0x00a9, B:30:0x007e, B:33:0x008c, B:38:0x00b0, B:41:0x00bb), top: B:49:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:40:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:41:0x00bb A[Catch: all -> 0x003a, TryCatch #0 {all -> 0x003a, blocks: (B:13:0x0035, B:44:0x00d8, B:20:0x004b, B:36:0x00a9, B:30:0x007e, B:33:0x008c, B:38:0x00b0, B:41:0x00bb), top: B:49:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x00a6 -> B:36:0x00a9). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object a(defpackage.e2 r17, defpackage.ek r18, defpackage.y50 r19) {
        /*
            Method dump skipped, instruction units count: 235
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.i53.a(e2, ek, y50):java.lang.Object");
    }
}
