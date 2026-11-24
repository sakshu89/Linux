package defpackage;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class es0 extends nu2 implements vq0 {
    public Iterator f;
    public String i;
    public Object j;
    public int k;
    public final /* synthetic */ ms0 n;
    public final /* synthetic */ String s;
    public final /* synthetic */ long t;
    public final /* synthetic */ String u;
    public final /* synthetic */ d v;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public es0(ms0 ms0Var, String str, long j, String str2, d dVar, x50 x50Var) {
        super(2, x50Var);
        this.n = ms0Var;
        this.s = str;
        this.t = j;
        this.u = str2;
        this.v = dVar;
    }

    @Override // defpackage.vq0
    public final Object e(Object obj, Object obj2) {
        return ((es0) q((x50) obj2, (s70) obj)).s(q43.a);
    }

    @Override // defpackage.pk
    public final x50 q(x50 x50Var, Object obj) {
        return new es0(this.n, this.s, this.t, this.u, this.v, x50Var);
    }

    /* JADX WARN: Code duplicated, block: B:34:0x00a3 A[Catch: Exception -> 0x002e, CancellationException -> 0x01b3, TryCatch #2 {CancellationException -> 0x01b3, Exception -> 0x002e, blocks: (B:7:0x0027, B:74:0x0188, B:76:0x0190, B:12:0x003d, B:70:0x0177, B:15:0x004a, B:32:0x009d, B:34:0x00a3, B:38:0x00be, B:40:0x00c6, B:42:0x00ce, B:45:0x00e3, B:49:0x00fb, B:51:0x0103, B:53:0x010b, B:55:0x010f, B:57:0x0124, B:61:0x013e, B:63:0x0146, B:66:0x0171, B:79:0x019a, B:81:0x019f, B:18:0x0056, B:21:0x0064, B:24:0x006f, B:25:0x0075, B:31:0x0093, B:28:0x007e), top: B:91:0x0012 }] */
    /* JADX WARN: Code duplicated, block: B:36:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:37:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:40:0x00c6 A[Catch: Exception -> 0x002e, CancellationException -> 0x01b3, TryCatch #2 {CancellationException -> 0x01b3, Exception -> 0x002e, blocks: (B:7:0x0027, B:74:0x0188, B:76:0x0190, B:12:0x003d, B:70:0x0177, B:15:0x004a, B:32:0x009d, B:34:0x00a3, B:38:0x00be, B:40:0x00c6, B:42:0x00ce, B:45:0x00e3, B:49:0x00fb, B:51:0x0103, B:53:0x010b, B:55:0x010f, B:57:0x0124, B:61:0x013e, B:63:0x0146, B:66:0x0171, B:79:0x019a, B:81:0x019f, B:18:0x0056, B:21:0x0064, B:24:0x006f, B:25:0x0075, B:31:0x0093, B:28:0x007e), top: B:91:0x0012 }] */
    /* JADX WARN: Code duplicated, block: B:42:0x00ce A[Catch: Exception -> 0x002e, CancellationException -> 0x01b3, TryCatch #2 {CancellationException -> 0x01b3, Exception -> 0x002e, blocks: (B:7:0x0027, B:74:0x0188, B:76:0x0190, B:12:0x003d, B:70:0x0177, B:15:0x004a, B:32:0x009d, B:34:0x00a3, B:38:0x00be, B:40:0x00c6, B:42:0x00ce, B:45:0x00e3, B:49:0x00fb, B:51:0x0103, B:53:0x010b, B:55:0x010f, B:57:0x0124, B:61:0x013e, B:63:0x0146, B:66:0x0171, B:79:0x019a, B:81:0x019f, B:18:0x0056, B:21:0x0064, B:24:0x006f, B:25:0x0075, B:31:0x0093, B:28:0x007e), top: B:91:0x0012 }] */
    /* JADX WARN: Code duplicated, block: B:44:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:45:0x00e3 A[Catch: Exception -> 0x002e, CancellationException -> 0x01b3, PHI: r2 r5 r6 r13
      0x00e3: PHI (r2v33 java.lang.String) = (r2v11 java.lang.String), (r2v35 java.lang.String) binds: [B:22:0x0067, B:43:0x00df] A[DONT_GENERATE, DONT_INLINE]
      0x00e3: PHI (r5v7 java.util.Iterator) = (r5v2 java.util.Iterator), (r5v8 java.util.Iterator) binds: [B:22:0x0067, B:43:0x00df] A[DONT_GENERATE, DONT_INLINE]
      0x00e3: PHI (r6v8 java.lang.Object) = (r6v2 java.lang.Object), (r6v16 java.lang.Object) binds: [B:22:0x0067, B:43:0x00df] A[DONT_GENERATE, DONT_INLINE]
      0x00e3: PHI (r13v5 ??) = (r13v9 ?? I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), (r13v13 ??) binds: [B:22:0x0067, B:43:0x00df] A[DONT_GENERATE, DONT_INLINE], TryCatch #2 {CancellationException -> 0x01b3, Exception -> 0x002e, blocks: (B:7:0x0027, B:74:0x0188, B:76:0x0190, B:12:0x003d, B:70:0x0177, B:15:0x004a, B:32:0x009d, B:34:0x00a3, B:38:0x00be, B:40:0x00c6, B:42:0x00ce, B:45:0x00e3, B:49:0x00fb, B:51:0x0103, B:53:0x010b, B:55:0x010f, B:57:0x0124, B:61:0x013e, B:63:0x0146, B:66:0x0171, B:79:0x019a, B:81:0x019f, B:18:0x0056, B:21:0x0064, B:24:0x006f, B:25:0x0075, B:31:0x0093, B:28:0x007e), top: B:91:0x0012 }] */
    /* JADX WARN: Code duplicated, block: B:47:0x00f4  */
    /* JADX WARN: Code duplicated, block: B:48:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:53:0x010b A[Catch: Exception -> 0x002e, CancellationException -> 0x01b3, TryCatch #2 {CancellationException -> 0x01b3, Exception -> 0x002e, blocks: (B:7:0x0027, B:74:0x0188, B:76:0x0190, B:12:0x003d, B:70:0x0177, B:15:0x004a, B:32:0x009d, B:34:0x00a3, B:38:0x00be, B:40:0x00c6, B:42:0x00ce, B:45:0x00e3, B:49:0x00fb, B:51:0x0103, B:53:0x010b, B:55:0x010f, B:57:0x0124, B:61:0x013e, B:63:0x0146, B:66:0x0171, B:79:0x019a, B:81:0x019f, B:18:0x0056, B:21:0x0064, B:24:0x006f, B:25:0x0075, B:31:0x0093, B:28:0x007e), top: B:91:0x0012 }] */
    /* JADX WARN: Code duplicated, block: B:55:0x010f A[Catch: Exception -> 0x002e, CancellationException -> 0x01b3, TryCatch #2 {CancellationException -> 0x01b3, Exception -> 0x002e, blocks: (B:7:0x0027, B:74:0x0188, B:76:0x0190, B:12:0x003d, B:70:0x0177, B:15:0x004a, B:32:0x009d, B:34:0x00a3, B:38:0x00be, B:40:0x00c6, B:42:0x00ce, B:45:0x00e3, B:49:0x00fb, B:51:0x0103, B:53:0x010b, B:55:0x010f, B:57:0x0124, B:61:0x013e, B:63:0x0146, B:66:0x0171, B:79:0x019a, B:81:0x019f, B:18:0x0056, B:21:0x0064, B:24:0x006f, B:25:0x0075, B:31:0x0093, B:28:0x007e), top: B:91:0x0012 }] */
    /* JADX WARN: Code duplicated, block: B:57:0x0124 A[Catch: Exception -> 0x002e, CancellationException -> 0x01b3, TryCatch #2 {CancellationException -> 0x01b3, Exception -> 0x002e, blocks: (B:7:0x0027, B:74:0x0188, B:76:0x0190, B:12:0x003d, B:70:0x0177, B:15:0x004a, B:32:0x009d, B:34:0x00a3, B:38:0x00be, B:40:0x00c6, B:42:0x00ce, B:45:0x00e3, B:49:0x00fb, B:51:0x0103, B:53:0x010b, B:55:0x010f, B:57:0x0124, B:61:0x013e, B:63:0x0146, B:66:0x0171, B:79:0x019a, B:81:0x019f, B:18:0x0056, B:21:0x0064, B:24:0x006f, B:25:0x0075, B:31:0x0093, B:28:0x007e), top: B:91:0x0012 }] */
    /* JADX WARN: Code duplicated, block: B:59:0x013a  */
    /* JADX WARN: Code duplicated, block: B:60:0x013b  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v0 */
    /* JADX WARN: Type inference failed for: r13v1, types: [h52, java.lang.Object, java.lang.String, java.util.Iterator] */
    /* JADX WARN: Type inference failed for: r13v10 */
    /* JADX WARN: Type inference failed for: r13v11 */
    /* JADX WARN: Type inference failed for: r13v12 */
    /* JADX WARN: Type inference failed for: r13v13 */
    /* JADX WARN: Type inference failed for: r13v14 */
    /* JADX WARN: Type inference failed for: r13v2 */
    /* JADX WARN: Type inference failed for: r13v3 */
    /* JADX WARN: Type inference failed for: r13v5 */
    /* JADX WARN: Type inference failed for: r13v6, types: [h52] */
    /* JADX WARN: Type inference failed for: r13v7, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r13v8 */
    /* JADX WARN: Type inference failed for: r13v9 */
    /* JADX WARN: Type inference failed for: r17v0, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v29 */
    /* JADX WARN: Type inference failed for: r2v41, types: [java.lang.String, java.util.Iterator] */
    /* JADX WARN: Type inference failed for: r2v45 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:60:0x013b -> B:32:0x009d). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // defpackage.pk
    public final java.lang.Object s(java.lang.Object r20) {
        /*
            Method dump skipped, instruction units count: 458
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.es0.s(java.lang.Object):java.lang.Object");
    }
}
