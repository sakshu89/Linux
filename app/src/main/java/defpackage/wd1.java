package defpackage;

import android.media.AudioTrack;
import java.util.Iterator;
import java.util.LinkedHashMap;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class wd1 {
    public final q91 a;
    public final Object b;
    public final ts0 c;
    public final ts0 d;
    public final w9 e;
    public final x0 f;
    public final fq0 g;
    public final hg h;
    public boolean i;
    public boolean j;
    public long k;
    public long l;
    public final zd1 m;

    public wd1(q91 q91Var, Object obj, ts0 ts0Var, ts0 ts0Var2, w9 w9Var, x0 x0Var, g2 g2Var) {
        e4 e4Var = new e4(21);
        obj.getClass();
        this.a = q91Var;
        this.b = obj;
        this.c = ts0Var;
        this.d = ts0Var2;
        this.e = w9Var;
        this.f = x0Var;
        this.g = e4Var;
        this.h = new hg();
        this.m = new zd1(g2Var);
    }

    public static Object d(bx bxVar, long j, td1 td1Var) {
        j70 j70Var = td1Var.b;
        j70Var.getClass();
        gf2 gf2Var = new gf2(j70Var);
        gf2Var.g(bxVar.l(), new z(2, null, 3));
        sd1 sd1Var = new sd1(1, null);
        mq1 mq1Var = new mq1(j);
        lq1 lq1Var = lq1.k;
        h33.c(3, lq1Var);
        gf2Var.i(new ef2(gf2Var, mq1Var, lq1Var, n2.e, m44.e, sd1Var, null), false);
        return gf2Var.h() ? gf2Var.d(td1Var) : gf2Var.e(td1Var);
    }

    public final void a() {
        long j;
        long playbackHeadPosition;
        hg hgVar = this.h;
        if (!this.i) {
            return;
        }
        q91 q91Var = this.a;
        synchronized (q91Var) {
            kf kfVar = (kf) q91Var.c;
            j = 0;
            playbackHeadPosition = kfVar != null ? ((long) ((AudioTrack) kfVar.b).getPlaybackHeadPosition()) & 4294967295L : 0L;
        }
        if (playbackHeadPosition > this.k) {
            return;
        }
        this.l = playbackHeadPosition;
        zd1 zd1Var = this.m;
        LinkedHashMap linkedHashMap = zd1Var.a;
        hg hgVar2 = (hg) zd1Var.f;
        long j2 = playbackHeadPosition - zd1Var.d;
        if (j2 < 0) {
            j2 = 0;
        }
        zd1Var.d = playbackHeadPosition;
        while (j2 > j && !hgVar2.isEmpty()) {
            yd1 yd1Var = (yd1) hgVar2.first();
            long j3 = yd1Var.b;
            long j4 = yd1Var.a;
            long jMin = Math.min(j2, j3);
            long j5 = j;
            yd1Var.b -= jMin;
            j2 -= jMin;
            if (j4 != j5) {
                linkedHashMap.put(Long.valueOf(j4), Long.valueOf(((Number) linkedHashMap.getOrDefault(Long.valueOf(j4), Long.valueOf(j5))).longValue() - jMin));
                zd1Var.b(j4);
            }
            if (yd1Var.b == j5) {
                hgVar2.removeFirst();
            }
            j = j5;
            playbackHeadPosition = playbackHeadPosition;
        }
        long j6 = playbackHeadPosition;
        while (true) {
            rd1 rd1Var = (rd1) (hgVar.isEmpty() ? null : hgVar.b[hgVar.a]);
            if (rd1Var == null || rd1Var.b >= j6) {
                return;
            } else {
                this.f.j(Long.valueOf(((rd1) hgVar.removeFirst()).a));
            }
        }
    }

    public final void b(qd1 qd1Var) {
        synchronized (this.b) {
            if (h(qd1Var.a)) {
                long j = qd1Var.c;
                zd1 zd1Var = this.m;
                if (j == 0) {
                    zd1Var.getClass();
                } else {
                    zd1Var.b.add(Long.valueOf(j));
                    zd1Var.b(j);
                }
            }
        }
    }

    public final boolean c() {
        boolean z;
        synchronized (this.b) {
            z = this.i && this.l < this.k;
        }
        return z;
    }

    public final void e() {
        synchronized (this.b) {
            try {
                if (this.i) {
                    if (((Boolean) this.d.a()).booleanValue()) {
                        try {
                            this.a.C();
                            f();
                        } catch (Throwable th) {
                            f();
                            throw th;
                        }
                    } else {
                        a();
                        if (this.l >= this.k && this.j) {
                            this.j = false;
                            this.e.j(Boolean.FALSE);
                        }
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void f() {
        this.i = false;
        this.k = 0L;
        this.l = 0L;
        this.h.clear();
        zd1 zd1Var = this.m;
        zd1Var.getClass();
        hg hgVar = (hg) zd1Var.f;
        Iterator it = hgVar.iterator();
        while (it.hasNext()) {
            long j = ((yd1) it.next()).b;
        }
        hgVar.clear();
        zd1Var.a.clear();
        zd1Var.b.clear();
        zd1Var.c.clear();
        zd1Var.d = 0L;
        this.j = false;
        this.e.j(Boolean.FALSE);
    }

    /* JADX WARN: Code duplicated, block: B:101:0x01d1  */
    /* JADX WARN: Code duplicated, block: B:104:0x01dc  */
    /* JADX WARN: Code duplicated, block: B:107:0x01f2  */
    /* JADX WARN: Code duplicated, block: B:109:0x01f6  */
    /* JADX WARN: Code duplicated, block: B:111:0x01fa A[PHI: r1 r4 r16
      0x01fa: PHI (r1v42 bx) = (r1v5 bx), (r1v43 bx) binds: [B:103:0x01da, B:110:0x01f9] A[DONT_GENERATE, DONT_INLINE]
      0x01fa: PHI (r4v16 t42) = (r4v3 t42), (r4v18 t42) binds: [B:103:0x01da, B:110:0x01f9] A[DONT_GENERATE, DONT_INLINE]
      0x01fa: PHI (r16v7 int) = (r16v1 int), (r16v8 int) binds: [B:103:0x01da, B:110:0x01f9] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:126:0x0127 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:25:0x0091  */
    /* JADX WARN: Code duplicated, block: B:47:0x00f6 A[PHI: r1 r4 r5 r7 r10 r11
      0x00f6: PHI (r1v27 bx) = (r1v32 bx), (r1v39 bx) binds: [B:38:0x00cb, B:26:0x009a] A[DONT_GENERATE, DONT_INLINE]
      0x00f6: PHI (r4v10 t42) = (r4v13 t42), (r4v15 t42) binds: [B:38:0x00cb, B:26:0x009a] A[DONT_GENERATE, DONT_INLINE]
      0x00f6: PHI (r5v15 long) = (r5v18 long), (r5v20 long) binds: [B:38:0x00cb, B:26:0x009a] A[DONT_GENERATE, DONT_INLINE]
      0x00f6: PHI (r7v7 qd1) = (r7v11 qd1), (r7v16 qd1) binds: [B:38:0x00cb, B:26:0x009a] A[DONT_GENERATE, DONT_INLINE]
      0x00f6: PHI (r10v10 int) = (r10v12 int), (r10v14 int) binds: [B:38:0x00cb, B:26:0x009a] A[DONT_GENERATE, DONT_INLINE]
      0x00f6: PHI (r11v4 int) = (r11v6 int), (r11v8 int) binds: [B:38:0x00cb, B:26:0x009a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:49:0x0100 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:50:0x0102  */
    /* JADX WARN: Code duplicated, block: B:52:0x0105 A[DONT_GENERATE] */
    /* JADX WARN: Code duplicated, block: B:54:0x0108  */
    /* JADX WARN: Code duplicated, block: B:55:0x010a  */
    /* JADX WARN: Code duplicated, block: B:56:0x010f  */
    /* JADX WARN: Code duplicated, block: B:59:0x0116  */
    /* JADX WARN: Code duplicated, block: B:64:0x012c  */
    /* JADX WARN: Code duplicated, block: B:67:0x0143  */
    /* JADX WARN: Code duplicated, block: B:72:0x015a  */
    /* JADX WARN: Code duplicated, block: B:75:0x015f  */
    /* JADX WARN: Code duplicated, block: B:79:0x017b  */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:103:0x01da -> B:111:0x01fa). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:107:0x01f2 -> B:108:0x01f4). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x00d1 -> B:23:0x0086). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:0x0100 -> B:23:0x0086). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:52:0x0105 -> B:23:0x0086). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:55:0x010a -> B:23:0x0086). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:57:0x0112 -> B:23:0x0086). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object g(defpackage.bx r22, defpackage.y50 r23) {
        /*
            Method dump skipped, instruction units count: 567
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.wd1.g(bx, y50):java.lang.Object");
    }

    public final boolean h(long j) {
        return j == ((Number) this.c.a()).longValue() && !((Boolean) this.d.a()).booleanValue();
    }

    /* JADX WARN: Code duplicated, block: B:103:0x0072 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:104:0x0174 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:105:0x016c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:106:0x013c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:17:0x005e  */
    /* JADX WARN: Code duplicated, block: B:19:0x0069  */
    /* JADX WARN: Code duplicated, block: B:28:0x0079 A[Catch: all -> 0x0076, TRY_ENTER, TryCatch #0 {, blocks: (B:21:0x006c, B:23:0x0072, B:28:0x0079, B:29:0x0085, B:31:0x008e, B:33:0x0091, B:37:0x0099, B:39:0x00a3, B:41:0x00b0, B:43:0x00b6, B:46:0x00d6, B:48:0x00e2, B:50:0x00e9, B:52:0x00f5, B:54:0x00f9, B:59:0x0105, B:60:0x0107, B:62:0x0113, B:63:0x0114, B:67:0x011a, B:68:0x011b, B:70:0x011f, B:72:0x0127, B:75:0x012d, B:76:0x0136, B:85:0x016c, B:86:0x0173, B:87:0x0174, B:88:0x017b, B:91:0x017e, B:61:0x0108, B:30:0x0086), top: B:96:0x006c, inners: #1, #2 }] */
    /* JADX WARN: Code duplicated, block: B:33:0x0091 A[Catch: all -> 0x0076, TryCatch #0 {, blocks: (B:21:0x006c, B:23:0x0072, B:28:0x0079, B:29:0x0085, B:31:0x008e, B:33:0x0091, B:37:0x0099, B:39:0x00a3, B:41:0x00b0, B:43:0x00b6, B:46:0x00d6, B:48:0x00e2, B:50:0x00e9, B:52:0x00f5, B:54:0x00f9, B:59:0x0105, B:60:0x0107, B:62:0x0113, B:63:0x0114, B:67:0x011a, B:68:0x011b, B:70:0x011f, B:72:0x0127, B:75:0x012d, B:76:0x0136, B:85:0x016c, B:86:0x0173, B:87:0x0174, B:88:0x017b, B:91:0x017e, B:61:0x0108, B:30:0x0086), top: B:96:0x006c, inners: #1, #2 }] */
    /* JADX WARN: Code duplicated, block: B:35:0x0095  */
    /* JADX WARN: Code duplicated, block: B:36:0x0097  */
    /* JADX WARN: Code duplicated, block: B:37:0x0099 A[Catch: all -> 0x0076, TryCatch #0 {, blocks: (B:21:0x006c, B:23:0x0072, B:28:0x0079, B:29:0x0085, B:31:0x008e, B:33:0x0091, B:37:0x0099, B:39:0x00a3, B:41:0x00b0, B:43:0x00b6, B:46:0x00d6, B:48:0x00e2, B:50:0x00e9, B:52:0x00f5, B:54:0x00f9, B:59:0x0105, B:60:0x0107, B:62:0x0113, B:63:0x0114, B:67:0x011a, B:68:0x011b, B:70:0x011f, B:72:0x0127, B:75:0x012d, B:76:0x0136, B:85:0x016c, B:86:0x0173, B:87:0x0174, B:88:0x017b, B:91:0x017e, B:61:0x0108, B:30:0x0086), top: B:96:0x006c, inners: #1, #2 }] */
    /* JADX WARN: Code duplicated, block: B:39:0x00a3 A[Catch: all -> 0x0076, TryCatch #0 {, blocks: (B:21:0x006c, B:23:0x0072, B:28:0x0079, B:29:0x0085, B:31:0x008e, B:33:0x0091, B:37:0x0099, B:39:0x00a3, B:41:0x00b0, B:43:0x00b6, B:46:0x00d6, B:48:0x00e2, B:50:0x00e9, B:52:0x00f5, B:54:0x00f9, B:59:0x0105, B:60:0x0107, B:62:0x0113, B:63:0x0114, B:67:0x011a, B:68:0x011b, B:70:0x011f, B:72:0x0127, B:75:0x012d, B:76:0x0136, B:85:0x016c, B:86:0x0173, B:87:0x0174, B:88:0x017b, B:91:0x017e, B:61:0x0108, B:30:0x0086), top: B:96:0x006c, inners: #1, #2 }] */
    /* JADX WARN: Code duplicated, block: B:40:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:43:0x00b6 A[Catch: all -> 0x0076, TryCatch #0 {, blocks: (B:21:0x006c, B:23:0x0072, B:28:0x0079, B:29:0x0085, B:31:0x008e, B:33:0x0091, B:37:0x0099, B:39:0x00a3, B:41:0x00b0, B:43:0x00b6, B:46:0x00d6, B:48:0x00e2, B:50:0x00e9, B:52:0x00f5, B:54:0x00f9, B:59:0x0105, B:60:0x0107, B:62:0x0113, B:63:0x0114, B:67:0x011a, B:68:0x011b, B:70:0x011f, B:72:0x0127, B:75:0x012d, B:76:0x0136, B:85:0x016c, B:86:0x0173, B:87:0x0174, B:88:0x017b, B:91:0x017e, B:61:0x0108, B:30:0x0086), top: B:96:0x006c, inners: #1, #2 }] */
    /* JADX WARN: Code duplicated, block: B:44:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:45:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:48:0x00e2 A[Catch: all -> 0x0076, TryCatch #0 {, blocks: (B:21:0x006c, B:23:0x0072, B:28:0x0079, B:29:0x0085, B:31:0x008e, B:33:0x0091, B:37:0x0099, B:39:0x00a3, B:41:0x00b0, B:43:0x00b6, B:46:0x00d6, B:48:0x00e2, B:50:0x00e9, B:52:0x00f5, B:54:0x00f9, B:59:0x0105, B:60:0x0107, B:62:0x0113, B:63:0x0114, B:67:0x011a, B:68:0x011b, B:70:0x011f, B:72:0x0127, B:75:0x012d, B:76:0x0136, B:85:0x016c, B:86:0x0173, B:87:0x0174, B:88:0x017b, B:91:0x017e, B:61:0x0108, B:30:0x0086), top: B:96:0x006c, inners: #1, #2 }] */
    /* JADX WARN: Code duplicated, block: B:49:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:51:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:54:0x00f9 A[Catch: all -> 0x0076, TryCatch #0 {, blocks: (B:21:0x006c, B:23:0x0072, B:28:0x0079, B:29:0x0085, B:31:0x008e, B:33:0x0091, B:37:0x0099, B:39:0x00a3, B:41:0x00b0, B:43:0x00b6, B:46:0x00d6, B:48:0x00e2, B:50:0x00e9, B:52:0x00f5, B:54:0x00f9, B:59:0x0105, B:60:0x0107, B:62:0x0113, B:63:0x0114, B:67:0x011a, B:68:0x011b, B:70:0x011f, B:72:0x0127, B:75:0x012d, B:76:0x0136, B:85:0x016c, B:86:0x0173, B:87:0x0174, B:88:0x017b, B:91:0x017e, B:61:0x0108, B:30:0x0086), top: B:96:0x006c, inners: #1, #2 }] */
    /* JADX WARN: Code duplicated, block: B:56:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:70:0x011f A[Catch: all -> 0x0076, TryCatch #0 {, blocks: (B:21:0x006c, B:23:0x0072, B:28:0x0079, B:29:0x0085, B:31:0x008e, B:33:0x0091, B:37:0x0099, B:39:0x00a3, B:41:0x00b0, B:43:0x00b6, B:46:0x00d6, B:48:0x00e2, B:50:0x00e9, B:52:0x00f5, B:54:0x00f9, B:59:0x0105, B:60:0x0107, B:62:0x0113, B:63:0x0114, B:67:0x011a, B:68:0x011b, B:70:0x011f, B:72:0x0127, B:75:0x012d, B:76:0x0136, B:85:0x016c, B:86:0x0173, B:87:0x0174, B:88:0x017b, B:91:0x017e, B:61:0x0108, B:30:0x0086), top: B:96:0x006c, inners: #1, #2 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Code duplicated, block: B:81:0x0155 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:82:0x0156 A[EDGE_INSN: B:82:0x0156->B:83:0x0158 BREAK  A[LOOP:0: B:15:0x0059->B:84:0x015c]] */
    /* JADX WARN: Code duplicated, block: B:84:0x015c A[LOOP:0: B:15:0x0059->B:84:0x015c, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:96:0x006c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:97:0x0108 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:99:0x0086 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:82:0x0156 -> B:83:0x0158). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object i(long r19, byte[] r21, java.lang.Long r22, long r23, defpackage.y50 r25) {
        /*
            Method dump skipped, instruction units count: 394
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.wd1.i(long, byte[], java.lang.Long, long, y50):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:67:0x0118  */
    /* JADX WARN: Code duplicated, block: B:70:0x0145  */
    /* JADX WARN: Code duplicated, block: B:73:0x0151  */
    /* JADX WARN: Code duplicated, block: B:75:0x0154  */
    /* JADX WARN: Code duplicated, block: B:8:0x001a  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:70:0x0145 -> B:71:0x0149). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object j(java.util.List r18, int r19, defpackage.y50 r20) {
        /*
            Method dump skipped, instruction units count: 355
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.wd1.j(java.util.List, int, y50):java.lang.Object");
    }
}
