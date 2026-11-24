package defpackage;

import android.content.Context;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class co2 {
    public static final Locale k;
    public final xx1 a;
    public final sn1 b;
    public final jr2 c;
    public final jr2 d;
    public final jr2 e;
    public final jr2 f;
    public final jr2 g;
    public final AtomicLong h;
    public final AtomicReference i;
    public final hg j;

    static {
        Locale localeForLanguageTag = Locale.forLanguageTag("hi-IN");
        localeForLanguageTag.getClass();
        k = localeForLanguageTag;
    }

    public co2(Context context, xx1 xx1Var, sn1 sn1Var) {
        xx1Var.getClass();
        sn1Var.getClass();
        this.a = xx1Var;
        this.b = sn1Var;
        this.c = o54.a("Preview the voice to check the installed engine.");
        Boolean bool = Boolean.FALSE;
        this.d = o54.a(bool);
        Boolean bool2 = Boolean.TRUE;
        this.e = o54.a(bool2);
        this.f = o54.a(bool);
        this.g = o54.a(bool2);
        this.h = new AtomicLong();
        this.i = new AtomicReference(null);
        this.j = new hg(0);
    }

    public final void a(String str) {
        AtomicReference atomicReference;
        do {
            atomicReference = this.i;
            if (atomicReference.compareAndSet(str, null)) {
                Boolean bool = Boolean.FALSE;
                jr2 jr2Var = this.d;
                jr2Var.getClass();
                jr2Var.j(null, bool);
                return;
            }
        } while (atomicReference.get() == str);
    }

    /* JADX WARN: Code duplicated, block: B:143:0x0360 A[Catch: all -> 0x004d, TryCatch #2 {all -> 0x004d, blocks: (B:16:0x0046, B:172:0x042c, B:150:0x03ad, B:152:0x03b5, B:155:0x03c4, B:157:0x03ce, B:160:0x03dc, B:162:0x03ea, B:165:0x03f7, B:169:0x0401, B:188:0x0470, B:28:0x0081, B:146:0x038a, B:137:0x0340, B:139:0x0350, B:143:0x0360, B:147:0x0392, B:191:0x0476), top: B:202:0x0037 }] */
    /* JADX WARN: Code duplicated, block: B:145:0x0388  */
    /* JADX WARN: Code duplicated, block: B:147:0x0392 A[Catch: all -> 0x004d, TryCatch #2 {all -> 0x004d, blocks: (B:16:0x0046, B:172:0x042c, B:150:0x03ad, B:152:0x03b5, B:155:0x03c4, B:157:0x03ce, B:160:0x03dc, B:162:0x03ea, B:165:0x03f7, B:169:0x0401, B:188:0x0470, B:28:0x0081, B:146:0x038a, B:137:0x0340, B:139:0x0350, B:143:0x0360, B:147:0x0392, B:191:0x0476), top: B:202:0x0037 }] */
    /* JADX WARN: Code duplicated, block: B:149:0x03ab  */
    /* JADX WARN: Code duplicated, block: B:150:0x03ad A[Catch: all -> 0x004d, PHI: r0 r2 r4 r6 r8 r9 r10 r13 r14 r15 r20 r21
      0x03ad: PHI (r0v13 java.lang.String) = (r0v8 java.lang.String), (r0v23 java.lang.String) binds: [B:24:0x0069, B:148:0x03a9] A[DONT_GENERATE, DONT_INLINE]
      0x03ad: PHI (r2v6 boolean) = (r2v2 boolean), (r2v14 boolean) binds: [B:24:0x0069, B:148:0x03a9] A[DONT_GENERATE, DONT_INLINE]
      0x03ad: PHI (r4v10 java.lang.String) = (r4v7 java.lang.String), (r4v13 java.lang.String) binds: [B:24:0x0069, B:148:0x03a9] A[DONT_GENERATE, DONT_INLINE]
      0x03ad: PHI (r6v3 java.util.Locale) = (r6v2 java.util.Locale), (r6v5 java.util.Locale) binds: [B:24:0x0069, B:148:0x03a9] A[DONT_GENERATE, DONT_INLINE]
      0x03ad: PHI (r8v3 xx1) = (r8v2 xx1), (r8v5 xx1) binds: [B:24:0x0069, B:148:0x03a9] A[DONT_GENERATE, DONT_INLINE]
      0x03ad: PHI (r9v3 int) = (r9v2 int), (r9v4 int) binds: [B:24:0x0069, B:148:0x03a9] A[DONT_GENERATE, DONT_INLINE]
      0x03ad: PHI (r10v5 float) = (r10v4 float), (r10v7 float) binds: [B:24:0x0069, B:148:0x03a9] A[DONT_GENERATE, DONT_INLINE]
      0x03ad: PHI (r13v3 boolean) = (r13v2 boolean), (r13v7 boolean) binds: [B:24:0x0069, B:148:0x03a9] A[DONT_GENERATE, DONT_INLINE]
      0x03ad: PHI (r14v4 boolean) = (r14v3 boolean), (r14v5 boolean) binds: [B:24:0x0069, B:148:0x03a9] A[DONT_GENERATE, DONT_INLINE]
      0x03ad: PHI (r15v4 java.lang.Object) = (r15v3 java.lang.Object), (r15v25 java.lang.Object) binds: [B:24:0x0069, B:148:0x03a9] A[DONT_GENERATE, DONT_INLINE]
      0x03ad: PHI (r20v2 jr2) = (r20v1 jr2), (r20v3 jr2) binds: [B:24:0x0069, B:148:0x03a9] A[DONT_GENERATE, DONT_INLINE]
      0x03ad: PHI (r21v5 hg) = (r21v2 hg), (r6v0 hg) binds: [B:24:0x0069, B:148:0x03a9] A[DONT_GENERATE, DONT_INLINE], TryCatch #2 {all -> 0x004d, blocks: (B:16:0x0046, B:172:0x042c, B:150:0x03ad, B:152:0x03b5, B:155:0x03c4, B:157:0x03ce, B:160:0x03dc, B:162:0x03ea, B:165:0x03f7, B:169:0x0401, B:188:0x0470, B:28:0x0081, B:146:0x038a, B:137:0x0340, B:139:0x0350, B:143:0x0360, B:147:0x0392, B:191:0x0476), top: B:202:0x0037 }] */
    /* JADX WARN: Code duplicated, block: B:152:0x03b5 A[Catch: all -> 0x004d, TRY_LEAVE, TryCatch #2 {all -> 0x004d, blocks: (B:16:0x0046, B:172:0x042c, B:150:0x03ad, B:152:0x03b5, B:155:0x03c4, B:157:0x03ce, B:160:0x03dc, B:162:0x03ea, B:165:0x03f7, B:169:0x0401, B:188:0x0470, B:28:0x0081, B:146:0x038a, B:137:0x0340, B:139:0x0350, B:143:0x0360, B:147:0x0392, B:191:0x0476), top: B:202:0x0037 }] */
    /* JADX WARN: Code duplicated, block: B:155:0x03c4 A[Catch: all -> 0x004d, TRY_ENTER, TryCatch #2 {all -> 0x004d, blocks: (B:16:0x0046, B:172:0x042c, B:150:0x03ad, B:152:0x03b5, B:155:0x03c4, B:157:0x03ce, B:160:0x03dc, B:162:0x03ea, B:165:0x03f7, B:169:0x0401, B:188:0x0470, B:28:0x0081, B:146:0x038a, B:137:0x0340, B:139:0x0350, B:143:0x0360, B:147:0x0392, B:191:0x0476), top: B:202:0x0037 }] */
    /* JADX WARN: Code duplicated, block: B:157:0x03ce A[Catch: all -> 0x004d, TryCatch #2 {all -> 0x004d, blocks: (B:16:0x0046, B:172:0x042c, B:150:0x03ad, B:152:0x03b5, B:155:0x03c4, B:157:0x03ce, B:160:0x03dc, B:162:0x03ea, B:165:0x03f7, B:169:0x0401, B:188:0x0470, B:28:0x0081, B:146:0x038a, B:137:0x0340, B:139:0x0350, B:143:0x0360, B:147:0x0392, B:191:0x0476), top: B:202:0x0037 }] */
    /* JADX WARN: Code duplicated, block: B:162:0x03ea A[Catch: all -> 0x004d, TryCatch #2 {all -> 0x004d, blocks: (B:16:0x0046, B:172:0x042c, B:150:0x03ad, B:152:0x03b5, B:155:0x03c4, B:157:0x03ce, B:160:0x03dc, B:162:0x03ea, B:165:0x03f7, B:169:0x0401, B:188:0x0470, B:28:0x0081, B:146:0x038a, B:137:0x0340, B:139:0x0350, B:143:0x0360, B:147:0x0392, B:191:0x0476), top: B:202:0x0037 }] */
    /* JADX WARN: Code duplicated, block: B:168:0x0400  */
    /* JADX WARN: Code duplicated, block: B:47:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    /* JADX WARN: Code restructure failed: missing block: B:170:0x0429, code lost:
    
        if (r2 == r7) goto L171;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [int] */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v32 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(java.lang.String r26, java.util.Locale r27, boolean r28, defpackage.y50 r29) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 1164
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.co2.b(java.lang.String, java.util.Locale, boolean, y50):java.lang.Object");
    }

    public final void c() {
        this.i.set(null);
        Boolean bool = Boolean.FALSE;
        jr2 jr2Var = this.d;
        jr2Var.getClass();
        jr2Var.j(null, bool);
        this.b.c();
        xx1 xx1Var = this.a;
        ConcurrentHashMap concurrentHashMap = xx1Var.b;
        x00 x00Var = xx1Var.a;
        if (x00Var.Z() && ((Boolean) x00Var.N()).booleanValue()) {
            xx1Var.e.stop();
        }
        Collection collectionValues = concurrentHashMap.values();
        collectionValues.getClass();
        Iterator it = collectionValues.iterator();
        while (it.hasNext()) {
            ((x00) it.next()).b0(Boolean.FALSE);
        }
        concurrentHashMap.clear();
    }
}
