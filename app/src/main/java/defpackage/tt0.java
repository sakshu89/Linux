package defpackage;

import java.io.Serializable;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class tt0 {
    public static final x42 e;
    public static final x42 f;
    public static final List g;
    public final c22 a;
    public final f0 b;
    public final an1 c;
    public volatile ot0 d;

    static {
        y42 y42Var = y42.IGNORE_CASE;
        e = new x42("^gemini-(\\d+)(?:\\.(\\d+))?(?:-|$)", y42Var);
        f = new x42("^gemini-[a-z0-9][a-z0-9._-]{0,120}$", y42Var);
        g = nz.i("embedding", "audio", "live", "transcrib", "translat", "tts", "image", "robotics", "computer-use", "research");
    }

    public tt0(yb0 yb0Var, f0 f0Var) {
        yb0Var.getClass();
        f0Var.getClass();
        this.a = yb0Var;
        this.b = f0Var;
        this.c = new an1();
        this.d = new ot0(-1L, ii0.a);
    }

    /* JADX WARN: Code duplicated, block: B:121:0x033d  */
    /* JADX WARN: Code duplicated, block: B:123:0x0344  */
    /* JADX WARN: Code duplicated, block: B:125:0x034a  */
    /* JADX WARN: Code duplicated, block: B:127:0x0351  */
    /* JADX WARN: Code duplicated, block: B:128:0x0357  */
    /* JADX WARN: Code duplicated, block: B:131:0x0372  */
    /* JADX WARN: Code duplicated, block: B:134:0x0392 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:136:0x0398  */
    /* JADX WARN: Code duplicated, block: B:140:0x03c3  */
    /* JADX WARN: Code duplicated, block: B:141:0x03c6  */
    /* JADX WARN: Code duplicated, block: B:168:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:169:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:174:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:63:0x019a  */
    /* JADX WARN: Code duplicated, block: B:66:0x01bb  */
    /* JADX WARN: Code duplicated, block: B:69:0x01c7  */
    /* JADX WARN: Code duplicated, block: B:70:0x01cd A[Catch: Exception -> 0x00a6, CancellationException -> 0x03cc, TRY_ENTER, TRY_LEAVE, TryCatch #0 {CancellationException -> 0x03cc, blocks: (B:70:0x01cd, B:72:0x01e6, B:75:0x01ee, B:77:0x01f2, B:19:0x00a0), top: B:149:0x00a0 }] */
    /* JADX WARN: Code duplicated, block: B:74:0x01ec  */
    /* JADX WARN: Code duplicated, block: B:77:0x01f2 A[Catch: Exception -> 0x0222, CancellationException -> 0x03cc, TRY_LEAVE, TryCatch #0 {CancellationException -> 0x03cc, blocks: (B:70:0x01cd, B:72:0x01e6, B:75:0x01ee, B:77:0x01f2, B:19:0x00a0), top: B:149:0x00a0 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x001f  */
    /* JADX WARN: Code duplicated, block: B:89:0x0255  */
    /* JADX WARN: Code duplicated, block: B:93:0x026a  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0 */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v10 */
    /* JADX WARN: Type inference failed for: r12v11, types: [java.lang.Object, java.lang.Throwable, java.util.List, x50] */
    /* JADX WARN: Type inference failed for: r12v12, types: [java.lang.Object, java.lang.Throwable, java.util.List, xr0] */
    /* JADX WARN: Type inference failed for: r12v13 */
    /* JADX WARN: Type inference failed for: r12v14 */
    /* JADX WARN: Type inference failed for: r12v15 */
    /* JADX WARN: Type inference failed for: r12v16 */
    /* JADX WARN: Type inference failed for: r12v17 */
    /* JADX WARN: Type inference failed for: r12v18 */
    /* JADX WARN: Type inference failed for: r12v19 */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v20 */
    /* JADX WARN: Type inference failed for: r12v21 */
    /* JADX WARN: Type inference failed for: r12v22 */
    /* JADX WARN: Type inference failed for: r12v23 */
    /* JADX WARN: Type inference failed for: r12v24 */
    /* JADX WARN: Type inference failed for: r12v25 */
    /* JADX WARN: Type inference failed for: r12v26 */
    /* JADX WARN: Type inference failed for: r12v27 */
    /* JADX WARN: Type inference failed for: r12v3, types: [java.lang.Object, java.lang.String, java.lang.Throwable, java.util.List] */
    /* JADX WARN: Type inference failed for: r12v4, types: [java.lang.Object, java.lang.String, java.lang.Throwable, java.util.List] */
    /* JADX WARN: Type inference failed for: r12v5, types: [java.lang.Object, java.lang.String, java.lang.Throwable, java.util.List, x50] */
    /* JADX WARN: Type inference failed for: r12v6, types: [java.lang.Object, java.lang.String, java.lang.Throwable, java.util.List, xr0] */
    /* JADX WARN: Type inference failed for: r12v9, types: [java.lang.Object, java.lang.Throwable, java.util.List] */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public static final java.io.Serializable a(defpackage.tt0 r22, defpackage.y50 r23) {
        /*
            Method dump skipped, instruction units count: 1020
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.tt0.a(tt0, y50):java.io.Serializable");
    }

    public static h72 d() {
        return new h72(new IllegalStateException("Gemini key changed during model discovery"));
    }

    public static int g(String str) {
        if (cs2.n(str, "-exp", true)) {
            return 1;
        }
        if (cs2.n(str, "-preview", true)) {
            return 2;
        }
        return cs2.n(str, "-latest", true) ? 3 : 4;
    }

    public static wt1 h(String str) {
        fh1 fh1VarB = x42.b(e, str);
        if (fh1VarB == null) {
            return new wt1(0, 0);
        }
        Integer numM = js2.m((String) ((dh1) fh1VarB.a()).get(1));
        Integer numValueOf = Integer.valueOf(numM != null ? numM.intValue() : 0);
        Integer numM2 = js2.m((String) ((dh1) fh1VarB.a()).get(2));
        return new wt1(numValueOf, Integer.valueOf(numM2 != null ? numM2.intValue() : 0));
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0075 A[PHI: r5 r13
      0x0075: PHI (r5v1 long) = (r5v0 long), (r5v3 long) binds: [B:25:0x0098, B:18:0x0070] A[DONT_GENERATE, DONT_INLINE]
      0x0075: PHI (r13v8 java.lang.Object) = (r13v7 java.lang.Object), (r13v1 java.lang.Object) binds: [B:25:0x0098, B:18:0x0070] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:30:0x00b4 A[PHI: r1 r5 r7 r13
      0x00b4: PHI (r1v3 java.lang.String) = (r1v2 java.lang.String), (r1v4 java.lang.String) binds: [B:28:0x00b0, B:17:0x0066] A[DONT_GENERATE, DONT_INLINE]
      0x00b4: PHI (r5v4 long) = (r5v2 long), (r5v6 long) binds: [B:28:0x00b0, B:17:0x0066] A[DONT_GENERATE, DONT_INLINE]
      0x00b4: PHI (r7v1 long) = (r7v0 long), (r7v2 long) binds: [B:28:0x00b0, B:17:0x0066] A[DONT_GENERATE, DONT_INLINE]
      0x00b4: PHI (r13v11 java.lang.Object) = (r13v10 java.lang.Object), (r13v1 java.lang.Object) binds: [B:28:0x00b0, B:17:0x0066] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:33:0x00cc A[PHI: r1 r5 r7 r13
      0x00cc: PHI (r1v5 java.lang.String) = (r1v3 java.lang.String), (r1v6 java.lang.String) binds: [B:31:0x00c8, B:16:0x005c] A[DONT_GENERATE, DONT_INLINE]
      0x00cc: PHI (r5v7 long) = (r5v5 long), (r5v8 long) binds: [B:31:0x00c8, B:16:0x005c] A[DONT_GENERATE, DONT_INLINE]
      0x00cc: PHI (r7v3 long) = (r7v1 long), (r7v4 long) binds: [B:31:0x00c8, B:16:0x005c] A[DONT_GENERATE, DONT_INLINE]
      0x00cc: PHI (r13v15 java.lang.Object) = (r13v14 java.lang.Object), (r13v1 java.lang.Object) binds: [B:31:0x00c8, B:16:0x005c] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:35:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:37:0x00db  */
    /* JADX WARN: Code duplicated, block: B:38:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:51:0x010b A[PHI: r1 r5 r7
      0x010b: PHI (r1v7 java.lang.String) = 
      (r1v5 java.lang.String)
      (r1v5 java.lang.String)
      (r1v5 java.lang.String)
      (r1v5 java.lang.String)
      (r1v8 java.lang.String)
     binds: [B:37:0x00db, B:39:0x00e1, B:42:0x00e8, B:44:0x00ef, B:49:0x0108] A[DONT_GENERATE, DONT_INLINE]
      0x010b: PHI (r5v9 long) = (r5v7 long), (r5v7 long), (r5v7 long), (r5v7 long), (r5v10 long) binds: [B:37:0x00db, B:39:0x00e1, B:42:0x00e8, B:44:0x00ef, B:49:0x0108] A[DONT_GENERATE, DONT_INLINE]
      0x010b: PHI (r7v5 long) = (r7v3 long), (r7v3 long), (r7v3 long), (r7v3 long), (r7v6 long) binds: [B:37:0x00db, B:39:0x00e1, B:42:0x00e8, B:44:0x00ef, B:49:0x0108] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:54:0x011b  */
    /* JADX WARN: Code duplicated, block: B:58:0x012e  */
    /* JADX WARN: Code duplicated, block: B:61:0x013c  */
    /* JADX WARN: Code duplicated, block: B:63:0x0141  */
    /* JADX WARN: Code duplicated, block: B:65:0x015f A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:73:0x017d  */
    /* JADX WARN: Code duplicated, block: B:76:0x0186 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00fe, code lost:
    
        if (r13 == r4) goto L72;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(defpackage.y50 r13) {
        /*
            Method dump skipped, instruction units count: 414
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.tt0.b(y50):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:40:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:41:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:44:0x00e7 A[Catch: all -> 0x003e, TryCatch #2 {all -> 0x003e, blocks: (B:13:0x0039, B:72:0x0194, B:75:0x019f, B:76:0x01ac, B:78:0x01b2, B:80:0x01bf, B:82:0x01c5, B:68:0x0173, B:60:0x0139, B:63:0x0145, B:64:0x0155, B:50:0x0113, B:53:0x0118, B:56:0x011e, B:31:0x0096, B:42:0x00d9, B:44:0x00e7, B:46:0x00f1, B:38:0x00c0), top: B:90:0x0026 }] */
    /* JADX WARN: Code duplicated, block: B:48:0x010c  */
    /* JADX WARN: Code duplicated, block: B:49:0x010e  */
    /* JADX WARN: Code duplicated, block: B:52:0x0117  */
    /* JADX WARN: Code duplicated, block: B:55:0x011c  */
    /* JADX WARN: Code duplicated, block: B:56:0x011e A[Catch: all -> 0x003e, TryCatch #2 {all -> 0x003e, blocks: (B:13:0x0039, B:72:0x0194, B:75:0x019f, B:76:0x01ac, B:78:0x01b2, B:80:0x01bf, B:82:0x01c5, B:68:0x0173, B:60:0x0139, B:63:0x0145, B:64:0x0155, B:50:0x0113, B:53:0x0118, B:56:0x011e, B:31:0x0096, B:42:0x00d9, B:44:0x00e7, B:46:0x00f1, B:38:0x00c0), top: B:90:0x0026 }] */
    /* JADX WARN: Code duplicated, block: B:58:0x0135  */
    /* JADX WARN: Code duplicated, block: B:59:0x0136  */
    /* JADX WARN: Code duplicated, block: B:62:0x0143  */
    /* JADX WARN: Code duplicated, block: B:63:0x0145 A[Catch: all -> 0x003e, TryCatch #2 {all -> 0x003e, blocks: (B:13:0x0039, B:72:0x0194, B:75:0x019f, B:76:0x01ac, B:78:0x01b2, B:80:0x01bf, B:82:0x01c5, B:68:0x0173, B:60:0x0139, B:63:0x0145, B:64:0x0155, B:50:0x0113, B:53:0x0118, B:56:0x011e, B:31:0x0096, B:42:0x00d9, B:44:0x00e7, B:46:0x00f1, B:38:0x00c0), top: B:90:0x0026 }] */
    /* JADX WARN: Code duplicated, block: B:66:0x016e  */
    /* JADX WARN: Code duplicated, block: B:67:0x016f  */
    /* JADX WARN: Code duplicated, block: B:71:0x0190  */
    /* JADX WARN: Code duplicated, block: B:74:0x019e  */
    /* JADX WARN: Code duplicated, block: B:75:0x019f A[Catch: all -> 0x003e, TryCatch #2 {all -> 0x003e, blocks: (B:13:0x0039, B:72:0x0194, B:75:0x019f, B:76:0x01ac, B:78:0x01b2, B:80:0x01bf, B:82:0x01c5, B:68:0x0173, B:60:0x0139, B:63:0x0145, B:64:0x0155, B:50:0x0113, B:53:0x0118, B:56:0x011e, B:31:0x0096, B:42:0x00d9, B:44:0x00e7, B:46:0x00f1, B:38:0x00c0), top: B:90:0x0026 }] */
    /* JADX WARN: Code duplicated, block: B:78:0x01b2 A[Catch: all -> 0x003e, TryCatch #2 {all -> 0x003e, blocks: (B:13:0x0039, B:72:0x0194, B:75:0x019f, B:76:0x01ac, B:78:0x01b2, B:80:0x01bf, B:82:0x01c5, B:68:0x0173, B:60:0x0139, B:63:0x0145, B:64:0x0155, B:50:0x0113, B:53:0x0118, B:56:0x011e, B:31:0x0096, B:42:0x00d9, B:44:0x00e7, B:46:0x00f1, B:38:0x00c0), top: B:90:0x0026 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    /* JADX WARN: Code duplicated, block: B:93:0x01bf A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:96:0x01ac A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 10, insn: 0x0057: MOVE (r8 I:??[OBJECT, ARRAY]) = (r10 I:??[OBJECT, ARRAY]) (LINE:88), block:B:21:0x0057 */
    /* JADX WARN: Type inference failed for: r2v0, types: [ii0] */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.io.Serializable] */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.util.ArrayList] */
    public final Serializable c(String str, y50 y50Var) throws Throwable {
        qt0 qt0Var;
        an1 an1Var;
        an1 an1Var2;
        String str2;
        int i;
        Object objI;
        int i2;
        String str3;
        long jLongValue;
        Object objM;
        String str4;
        int i3;
        int i4;
        long j;
        List list;
        Object objI2;
        List list2;
        int i5;
        int i6;
        long j2;
        Set set;
        Object objI3;
        long j3;
        Set set2;
        String str5;
        String str6;
        var arrayList = ii0.a;
        if (y50Var instanceof qt0) {
            qt0Var = (qt0) y50Var;
            int i7 = qt0Var.u;
            if ((i7 & Integer.MIN_VALUE) != 0) {
                qt0Var.u = i7 - Integer.MIN_VALUE;
            } else {
                qt0Var = new qt0(this, y50Var);
            }
        } else {
            qt0Var = new qt0(this, y50Var);
        }
        Object objF = qt0Var.s;
        t70 t70Var = t70.a;
        int i8 = 0;
        try {
            try {
                switch (qt0Var.u) {
                    case 0:
                        bz3.g(objF);
                        an1 an1Var3 = this.c;
                        str2 = str;
                        qt0Var.e = str2;
                        qt0Var.f = an1Var3;
                        qt0Var.j = 0;
                        qt0Var.u = 1;
                        if (an1Var3.e(qt0Var) != t70Var) {
                            an1Var2 = an1Var3;
                            i = 0;
                            f0 f0Var = this.b;
                            qt0Var.e = str2;
                            qt0Var.f = an1Var2;
                            qt0Var.j = i;
                            qt0Var.k = 0;
                            qt0Var.u = 2;
                            objI = f0Var.i(qt0Var);
                            if (objI == t70Var) {
                                String str7 = str2;
                                i2 = i;
                                objF = objI;
                                str3 = str7;
                                jLongValue = ((Number) objF).longValue();
                                if (this.d.a == jLongValue || this.d.b.isEmpty()) {
                                    ms0 ms0Var = (ms0) this.a.get();
                                    qt0Var.e = str3;
                                    qt0Var.f = an1Var2;
                                    qt0Var.j = i2;
                                    qt0Var.k = i8;
                                    qt0Var.n = jLongValue;
                                    qt0Var.u = 3;
                                    objM = ms0Var.m(qt0Var);
                                    if (objM != t70Var) {
                                        str4 = str3;
                                        i3 = i8;
                                        i4 = i2;
                                        j = jLongValue;
                                        if (objM instanceof h72) {
                                            objM = null;
                                        }
                                        list = (List) objM;
                                        if (list == null) {
                                            f0 f0Var2 = this.b;
                                            qt0Var.e = str4;
                                            qt0Var.f = an1Var2;
                                            qt0Var.i = list;
                                            qt0Var.j = i4;
                                            qt0Var.k = i3;
                                            qt0Var.n = j;
                                            qt0Var.u = 4;
                                            objI2 = f0Var2.i(qt0Var);
                                            if (objI2 == t70Var) {
                                                list2 = list;
                                                objF = objI2;
                                                if (((Number) objF).longValue() == j) {
                                                    this.d = new ot0(j, e(list2));
                                                    long j4 = j;
                                                    i2 = i4;
                                                    jLongValue = j4;
                                                    i8 = i3;
                                                    str3 = str4;
                                                    f0 f0Var3 = this.b;
                                                    qt0Var.e = str3;
                                                    qt0Var.f = an1Var2;
                                                    qt0Var.i = null;
                                                    qt0Var.j = i2;
                                                    qt0Var.k = i8;
                                                    qt0Var.n = jLongValue;
                                                    qt0Var.u = 5;
                                                    objF = f0Var3.f("gemini", qt0Var);
                                                    if (objF == t70Var) {
                                                        long j5 = jLongValue;
                                                        i5 = i2;
                                                        i6 = i8;
                                                        j2 = j5;
                                                        set = (Set) objF;
                                                        f0 f0Var4 = this.b;
                                                        qt0Var.e = str3;
                                                        qt0Var.f = an1Var2;
                                                        qt0Var.i = set;
                                                        qt0Var.j = i5;
                                                        qt0Var.k = i6;
                                                        qt0Var.n = j2;
                                                        qt0Var.u = 6;
                                                        objI3 = f0Var4.i(qt0Var);
                                                        if (objI3 != t70Var) {
                                                            j3 = j2;
                                                            set2 = set;
                                                            objF = objI3;
                                                            str5 = str3;
                                                            if (((Number) objF).longValue() != j3) {
                                                                List list3 = this.d.b;
                                                                arrayList = new ArrayList();
                                                                for (Object obj : list3) {
                                                                    str6 = (String) obj;
                                                                    if (g31.a(str6, str5) && !set2.contains(str6)) {
                                                                        arrayList.add(obj);
                                                                    }
                                                                    break;
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                        an1Var2.h(null);
                                        return arrayList;
                                    }
                                } else {
                                    f0 f0Var5 = this.b;
                                    qt0Var.e = str3;
                                    qt0Var.f = an1Var2;
                                    qt0Var.i = null;
                                    qt0Var.j = i2;
                                    qt0Var.k = i8;
                                    qt0Var.n = jLongValue;
                                    qt0Var.u = 5;
                                    objF = f0Var5.f("gemini", qt0Var);
                                    if (objF == t70Var) {
                                        long j6 = jLongValue;
                                        i5 = i2;
                                        i6 = i8;
                                        j2 = j6;
                                        set = (Set) objF;
                                        f0 f0Var6 = this.b;
                                        qt0Var.e = str3;
                                        qt0Var.f = an1Var2;
                                        qt0Var.i = set;
                                        qt0Var.j = i5;
                                        qt0Var.k = i6;
                                        qt0Var.n = j2;
                                        qt0Var.u = 6;
                                        objI3 = f0Var6.i(qt0Var);
                                        if (objI3 != t70Var) {
                                            j3 = j2;
                                            set2 = set;
                                            objF = objI3;
                                            str5 = str3;
                                            if (((Number) objF).longValue() != j3) {
                                                List list4 = this.d.b;
                                                arrayList = new ArrayList();
                                                while (r0.hasNext()) {
                                                    str6 = (String) obj;
                                                    if (g31.a(str6, str5)) {
                                                    }
                                                    break;
                                                }
                                            }
                                            an1Var2.h(null);
                                            return arrayList;
                                        }
                                    }
                                }
                            }
                        }
                        return t70Var;
                    case 1:
                        int i9 = qt0Var.j;
                        an1Var2 = qt0Var.f;
                        String str8 = qt0Var.e;
                        bz3.g(objF);
                        i = i9;
                        str2 = str8;
                        f0 f0Var7 = this.b;
                        qt0Var.e = str2;
                        qt0Var.f = an1Var2;
                        qt0Var.j = i;
                        qt0Var.k = 0;
                        qt0Var.u = 2;
                        objI = f0Var7.i(qt0Var);
                        if (objI == t70Var) {
                            String str9 = str2;
                            i2 = i;
                            objF = objI;
                            str3 = str9;
                            jLongValue = ((Number) objF).longValue();
                            if (this.d.a == jLongValue) {
                            }
                            ms0 ms0Var2 = (ms0) this.a.get();
                            qt0Var.e = str3;
                            qt0Var.f = an1Var2;
                            qt0Var.j = i2;
                            qt0Var.k = i8;
                            qt0Var.n = jLongValue;
                            qt0Var.u = 3;
                            objM = ms0Var2.m(qt0Var);
                            if (objM != t70Var) {
                                str4 = str3;
                                i3 = i8;
                                i4 = i2;
                                j = jLongValue;
                                if (objM instanceof h72) {
                                    objM = null;
                                }
                                list = (List) objM;
                                if (list == null) {
                                    f0 f0Var8 = this.b;
                                    qt0Var.e = str4;
                                    qt0Var.f = an1Var2;
                                    qt0Var.i = list;
                                    qt0Var.j = i4;
                                    qt0Var.k = i3;
                                    qt0Var.n = j;
                                    qt0Var.u = 4;
                                    objI2 = f0Var8.i(qt0Var);
                                    if (objI2 == t70Var) {
                                        list2 = list;
                                        objF = objI2;
                                        if (((Number) objF).longValue() == j) {
                                            this.d = new ot0(j, e(list2));
                                            long j7 = j;
                                            i2 = i4;
                                            jLongValue = j7;
                                            i8 = i3;
                                            str3 = str4;
                                            f0 f0Var9 = this.b;
                                            qt0Var.e = str3;
                                            qt0Var.f = an1Var2;
                                            qt0Var.i = null;
                                            qt0Var.j = i2;
                                            qt0Var.k = i8;
                                            qt0Var.n = jLongValue;
                                            qt0Var.u = 5;
                                            objF = f0Var9.f("gemini", qt0Var);
                                            if (objF == t70Var) {
                                                long j8 = jLongValue;
                                                i5 = i2;
                                                i6 = i8;
                                                j2 = j8;
                                                set = (Set) objF;
                                                f0 f0Var10 = this.b;
                                                qt0Var.e = str3;
                                                qt0Var.f = an1Var2;
                                                qt0Var.i = set;
                                                qt0Var.j = i5;
                                                qt0Var.k = i6;
                                                qt0Var.n = j2;
                                                qt0Var.u = 6;
                                                objI3 = f0Var10.i(qt0Var);
                                                if (objI3 != t70Var) {
                                                    j3 = j2;
                                                    set2 = set;
                                                    objF = objI3;
                                                    str5 = str3;
                                                    if (((Number) objF).longValue() != j3) {
                                                        List list5 = this.d.b;
                                                        arrayList = new ArrayList();
                                                        while (r0.hasNext()) {
                                                            str6 = (String) obj;
                                                            if (g31.a(str6, str5)) {
                                                            }
                                                            break;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                                an1Var2.h(null);
                                return arrayList;
                            }
                            break;
                        }
                        return t70Var;
                    case 2:
                        i8 = qt0Var.k;
                        i2 = qt0Var.j;
                        an1Var2 = qt0Var.f;
                        str3 = qt0Var.e;
                        bz3.g(objF);
                        jLongValue = ((Number) objF).longValue();
                        if (this.d.a == jLongValue) {
                            break;
                        }
                        ms0 ms0Var3 = (ms0) this.a.get();
                        qt0Var.e = str3;
                        qt0Var.f = an1Var2;
                        qt0Var.j = i2;
                        qt0Var.k = i8;
                        qt0Var.n = jLongValue;
                        qt0Var.u = 3;
                        objM = ms0Var3.m(qt0Var);
                        if (objM != t70Var) {
                            str4 = str3;
                            i3 = i8;
                            i4 = i2;
                            j = jLongValue;
                            if (objM instanceof h72) {
                                objM = null;
                            }
                            list = (List) objM;
                            if (list == null) {
                                f0 f0Var11 = this.b;
                                qt0Var.e = str4;
                                qt0Var.f = an1Var2;
                                qt0Var.i = list;
                                qt0Var.j = i4;
                                qt0Var.k = i3;
                                qt0Var.n = j;
                                qt0Var.u = 4;
                                objI2 = f0Var11.i(qt0Var);
                                if (objI2 == t70Var) {
                                    list2 = list;
                                    objF = objI2;
                                    if (((Number) objF).longValue() == j) {
                                        this.d = new ot0(j, e(list2));
                                        long j9 = j;
                                        i2 = i4;
                                        jLongValue = j9;
                                        i8 = i3;
                                        str3 = str4;
                                        f0 f0Var12 = this.b;
                                        qt0Var.e = str3;
                                        qt0Var.f = an1Var2;
                                        qt0Var.i = null;
                                        qt0Var.j = i2;
                                        qt0Var.k = i8;
                                        qt0Var.n = jLongValue;
                                        qt0Var.u = 5;
                                        objF = f0Var12.f("gemini", qt0Var);
                                        if (objF == t70Var) {
                                            long j10 = jLongValue;
                                            i5 = i2;
                                            i6 = i8;
                                            j2 = j10;
                                            set = (Set) objF;
                                            f0 f0Var13 = this.b;
                                            qt0Var.e = str3;
                                            qt0Var.f = an1Var2;
                                            qt0Var.i = set;
                                            qt0Var.j = i5;
                                            qt0Var.k = i6;
                                            qt0Var.n = j2;
                                            qt0Var.u = 6;
                                            objI3 = f0Var13.i(qt0Var);
                                            if (objI3 != t70Var) {
                                                j3 = j2;
                                                set2 = set;
                                                objF = objI3;
                                                str5 = str3;
                                                if (((Number) objF).longValue() != j3) {
                                                    List list6 = this.d.b;
                                                    arrayList = new ArrayList();
                                                    while (r0.hasNext()) {
                                                        str6 = (String) obj;
                                                        if (g31.a(str6, str5)) {
                                                        }
                                                        break;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            an1Var2.h(null);
                            return arrayList;
                        }
                        return t70Var;
                    case 3:
                        j = qt0Var.n;
                        int i10 = qt0Var.k;
                        int i11 = qt0Var.j;
                        an1 an1Var4 = qt0Var.f;
                        String str10 = qt0Var.e;
                        bz3.g(objF);
                        objM = ((i72) objF).a;
                        i3 = i10;
                        an1Var2 = an1Var4;
                        i4 = i11;
                        str4 = str10;
                        if (objM instanceof h72) {
                            objM = null;
                        }
                        list = (List) objM;
                        if (list == null) {
                            f0 f0Var14 = this.b;
                            qt0Var.e = str4;
                            qt0Var.f = an1Var2;
                            qt0Var.i = list;
                            qt0Var.j = i4;
                            qt0Var.k = i3;
                            qt0Var.n = j;
                            qt0Var.u = 4;
                            objI2 = f0Var14.i(qt0Var);
                            if (objI2 == t70Var) {
                                list2 = list;
                                objF = objI2;
                                if (((Number) objF).longValue() == j) {
                                    this.d = new ot0(j, e(list2));
                                    long j11 = j;
                                    i2 = i4;
                                    jLongValue = j11;
                                    i8 = i3;
                                    str3 = str4;
                                    f0 f0Var15 = this.b;
                                    qt0Var.e = str3;
                                    qt0Var.f = an1Var2;
                                    qt0Var.i = null;
                                    qt0Var.j = i2;
                                    qt0Var.k = i8;
                                    qt0Var.n = jLongValue;
                                    qt0Var.u = 5;
                                    objF = f0Var15.f("gemini", qt0Var);
                                    if (objF == t70Var) {
                                        long j12 = jLongValue;
                                        i5 = i2;
                                        i6 = i8;
                                        j2 = j12;
                                        set = (Set) objF;
                                        f0 f0Var16 = this.b;
                                        qt0Var.e = str3;
                                        qt0Var.f = an1Var2;
                                        qt0Var.i = set;
                                        qt0Var.j = i5;
                                        qt0Var.k = i6;
                                        qt0Var.n = j2;
                                        qt0Var.u = 6;
                                        objI3 = f0Var16.i(qt0Var);
                                        if (objI3 != t70Var) {
                                            j3 = j2;
                                            set2 = set;
                                            objF = objI3;
                                            str5 = str3;
                                            if (((Number) objF).longValue() != j3) {
                                                List list7 = this.d.b;
                                                arrayList = new ArrayList();
                                                while (r0.hasNext()) {
                                                    str6 = (String) obj;
                                                    if (g31.a(str6, str5)) {
                                                    }
                                                    break;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            return t70Var;
                        }
                        an1Var2.h(null);
                        return arrayList;
                    case 4:
                        j = qt0Var.n;
                        int i12 = qt0Var.k;
                        int i13 = qt0Var.j;
                        List list8 = (List) qt0Var.i;
                        an1 an1Var5 = qt0Var.f;
                        str4 = qt0Var.e;
                        try {
                            bz3.g(objF);
                            i3 = i12;
                            an1Var2 = an1Var5;
                            list2 = list8;
                            i4 = i13;
                            if (((Number) objF).longValue() == j) {
                                this.d = new ot0(j, e(list2));
                                long j13 = j;
                                i2 = i4;
                                jLongValue = j13;
                                i8 = i3;
                                str3 = str4;
                                f0 f0Var17 = this.b;
                                qt0Var.e = str3;
                                qt0Var.f = an1Var2;
                                qt0Var.i = null;
                                qt0Var.j = i2;
                                qt0Var.k = i8;
                                qt0Var.n = jLongValue;
                                qt0Var.u = 5;
                                objF = f0Var17.f("gemini", qt0Var);
                                if (objF == t70Var) {
                                    long j14 = jLongValue;
                                    i5 = i2;
                                    i6 = i8;
                                    j2 = j14;
                                    set = (Set) objF;
                                    f0 f0Var18 = this.b;
                                    qt0Var.e = str3;
                                    qt0Var.f = an1Var2;
                                    qt0Var.i = set;
                                    qt0Var.j = i5;
                                    qt0Var.k = i6;
                                    qt0Var.n = j2;
                                    qt0Var.u = 6;
                                    objI3 = f0Var18.i(qt0Var);
                                    if (objI3 != t70Var) {
                                        j3 = j2;
                                        set2 = set;
                                        objF = objI3;
                                        str5 = str3;
                                        if (((Number) objF).longValue() != j3) {
                                            List list9 = this.d.b;
                                            arrayList = new ArrayList();
                                            while (r0.hasNext()) {
                                                str6 = (String) obj;
                                                if (g31.a(str6, str5)) {
                                                }
                                                break;
                                            }
                                        }
                                    }
                                }
                                return t70Var;
                            }
                            an1Var2.h(null);
                            return arrayList;
                        } catch (Throwable th) {
                            th = th;
                            an1Var2 = an1Var5;
                            an1Var2.h(null);
                            throw th;
                        }
                    case 5:
                        j2 = qt0Var.n;
                        int i14 = qt0Var.k;
                        int i15 = qt0Var.j;
                        an1 an1Var6 = qt0Var.f;
                        String str11 = qt0Var.e;
                        bz3.g(objF);
                        i6 = i14;
                        an1Var2 = an1Var6;
                        i5 = i15;
                        str3 = str11;
                        set = (Set) objF;
                        f0 f0Var19 = this.b;
                        qt0Var.e = str3;
                        qt0Var.f = an1Var2;
                        qt0Var.i = set;
                        qt0Var.j = i5;
                        qt0Var.k = i6;
                        qt0Var.n = j2;
                        qt0Var.u = 6;
                        objI3 = f0Var19.i(qt0Var);
                        if (objI3 != t70Var) {
                            j3 = j2;
                            set2 = set;
                            objF = objI3;
                            str5 = str3;
                            if (((Number) objF).longValue() != j3) {
                                List list10 = this.d.b;
                                arrayList = new ArrayList();
                                while (r0.hasNext()) {
                                    str6 = (String) obj;
                                    if (g31.a(str6, str5)) {
                                    }
                                    break;
                                }
                            }
                            an1Var2.h(null);
                            return arrayList;
                        }
                        return t70Var;
                    case 6:
                        j3 = qt0Var.n;
                        set2 = (Set) qt0Var.i;
                        an1Var2 = qt0Var.f;
                        str5 = qt0Var.e;
                        bz3.g(objF);
                        if (((Number) objF).longValue() != j3) {
                            List list11 = this.d.b;
                            arrayList = new ArrayList();
                            while (r0.hasNext()) {
                                str6 = (String) obj;
                                if (g31.a(str6, str5)) {
                                }
                                break;
                            }
                        }
                        an1Var2.h(null);
                        return arrayList;
                    default:
                        og.n("call to 'resume' before 'invoke' with coroutine");
                        return null;
                }
            } catch (Throwable th2) {
                th = th2;
                an1Var2 = an1Var;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public final List e(List list) {
        list.getClass();
        List listT = mz.t(list);
        ArrayList arrayList = new ArrayList();
        for (Object obj : listT) {
            if (f.e((String) obj)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        int i = 0;
        while (true) {
            int i2 = 1;
            if (i >= size) {
                return mz.K(arrayList2, new w00(i2, new ag(this)));
            }
            Object obj2 = arrayList.get(i);
            i++;
            String str = (String) obj2;
            List list2 = g;
            if (list2 == null || !list2.isEmpty()) {
                Iterator it = list2.iterator();
                do {
                    if (it.hasNext()) {
                    }
                } while (!cs2.n(str, (String) it.next(), true));
            }
            arrayList2.add(obj2);
        }
    }

    /* JADX WARN: Code duplicated, block: B:29:0x006e A[Catch: all -> 0x002d, TryCatch #1 {all -> 0x002d, blocks: (B:13:0x0029, B:27:0x006a, B:29:0x006e, B:30:0x0071), top: B:40:0x0029 }] */
    /* JADX WARN: Code duplicated, block: B:30:0x0071 A[Catch: all -> 0x002d, TRY_LEAVE, TryCatch #1 {all -> 0x002d, blocks: (B:13:0x0029, B:27:0x006a, B:29:0x006e, B:30:0x0071), top: B:40:0x0029 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object f(y50 y50Var) {
        st0 st0Var;
        an1 an1Var;
        int i;
        Throwable th;
        an1 an1Var2;
        i72 i72Var;
        Object h72Var;
        if (y50Var instanceof st0) {
            st0Var = (st0) y50Var;
            int i2 = st0Var.k;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                st0Var.k = i2 - Integer.MIN_VALUE;
            } else {
                st0Var = new st0(this, y50Var);
            }
        } else {
            st0Var = new st0(this, y50Var);
        }
        Object obj = st0Var.i;
        int i3 = st0Var.k;
        x50 x50Var = null;
        t70 t70Var = t70.a;
        try {
            if (i3 == 0) {
                bz3.g(obj);
                an1Var = this.c;
                st0Var.e = an1Var;
                i = 0;
                st0Var.f = 0;
                st0Var.k = 1;
                if (an1Var.e(st0Var) != t70Var) {
                }
                return t70Var;
            }
            if (i3 != 1) {
                if (i3 != 2) {
                    og.n("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                an1Var2 = st0Var.e;
                try {
                    bz3.g(obj);
                    i72Var = (i72) obj;
                    if (i72Var != null) {
                        h72Var = i72Var.a;
                    } else {
                        h72Var = new h72(new SocketTimeoutException("Gemini model discovery timed out after 35 seconds"));
                    }
                    an1Var2.h(null);
                    return h72Var;
                } catch (Throwable th2) {
                    th = th2;
                    an1Var2.h(null);
                    throw th;
                }
            }
            i = st0Var.f;
            an1 an1Var3 = st0Var.e;
            bz3.g(obj);
            an1Var = an1Var3;
            l2 l2Var = new l2(this, x50Var, 6);
            st0Var.e = an1Var;
            st0Var.f = i;
            st0Var.k = 2;
            Object objC = xc4.c(35000L, l2Var, st0Var);
            if (objC != t70Var) {
                an1 an1Var4 = an1Var;
                obj = objC;
                an1Var2 = an1Var4;
                i72Var = (i72) obj;
                if (i72Var != null) {
                    h72Var = i72Var.a;
                } else {
                    h72Var = new h72(new SocketTimeoutException("Gemini model discovery timed out after 35 seconds"));
                }
                an1Var2.h(null);
                return h72Var;
            }
            return t70Var;
        } catch (Throwable th3) {
            an1 an1Var5 = an1Var;
            th = th3;
            an1Var2 = an1Var5;
            an1Var2.h(null);
            throw th;
        }
    }
}
