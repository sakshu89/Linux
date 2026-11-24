package defpackage;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class uk2 {
    public final an1 a = new an1();
    public final q82 b = new q82(6);
    public final l90 c = new l90(1, new nc(2, null, 6));

    public uk2(String str) {
    }

    public final Integer a() {
        return new Integer(((AtomicInteger) this.b.a).get());
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x005d, code lost:
    
        if (r8 == r5) goto L25;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v4, types: [an1] */
    /* JADX WARN: Type inference failed for: r6v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(defpackage.hq0 r7, defpackage.y50 r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof defpackage.sk2
            if (r0 == 0) goto L13
            r0 = r8
            sk2 r0 = (defpackage.sk2) r0
            int r1 = r0.k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.k = r1
            goto L18
        L13:
            sk2 r0 = new sk2
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.i
            int r1 = r0.k
            r2 = 2
            r3 = 1
            r4 = 0
            t70 r5 = defpackage.t70.a
            if (r1 == 0) goto L41
            if (r1 == r3) goto L37
            if (r1 != r2) goto L31
            java.lang.Object r6 = r0.e
            an1 r6 = (defpackage.an1) r6
            defpackage.bz3.g(r8)     // Catch: java.lang.Throwable -> L2f
            goto L60
        L2f:
            r7 = move-exception
            goto L64
        L31:
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            defpackage.og.n(r6)
            return r4
        L37:
            an1 r6 = r0.f
            java.lang.Object r7 = r0.e
            hq0 r7 = (defpackage.hq0) r7
            defpackage.bz3.g(r8)
            goto L53
        L41:
            defpackage.bz3.g(r8)
            r0.e = r7
            an1 r6 = r6.a
            r0.f = r6
            r0.k = r3
            java.lang.Object r8 = r6.e(r0)
            if (r8 != r5) goto L53
            goto L5f
        L53:
            r0.e = r6     // Catch: java.lang.Throwable -> L2f
            r0.f = r4     // Catch: java.lang.Throwable -> L2f
            r0.k = r2     // Catch: java.lang.Throwable -> L2f
            java.lang.Object r8 = r7.j(r0)     // Catch: java.lang.Throwable -> L2f
            if (r8 != r5) goto L60
        L5f:
            return r5
        L60:
            r6.h(r4)
            return r8
        L64:
            r6.h(r4)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.uk2.b(hq0, y50):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0054  */
    /* JADX WARN: Code duplicated, block: B:30:0x005f  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object c(vq0 vq0Var, y50 y50Var) {
        tk2 tk2Var;
        an1 an1Var;
        boolean z;
        Throwable th;
        if (y50Var instanceof tk2) {
            tk2Var = (tk2) y50Var;
            int i = tk2Var.k;
            if ((i & Integer.MIN_VALUE) != 0) {
                tk2Var.k = i - Integer.MIN_VALUE;
            } else {
                tk2Var = new tk2(this, y50Var);
            }
        } else {
            tk2Var = new tk2(this, y50Var);
        }
        Object obj = tk2Var.i;
        int i2 = tk2Var.k;
        if (i2 != 0) {
            if (i2 != 1) {
                og.n("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            z = tk2Var.f;
            an1Var = tk2Var.e;
            try {
                bz3.g(obj);
                if (z) {
                    an1Var.h(null);
                }
                return obj;
            } catch (Throwable th2) {
                th = th2;
                if (z) {
                    an1Var.h(null);
                }
                throw th;
            }
        }
        bz3.g(obj);
        an1 an1Var2 = this.a;
        boolean zF = an1Var2.f();
        try {
            Object objValueOf = Boolean.valueOf(zF);
            tk2Var.e = an1Var2;
            tk2Var.f = zF;
            tk2Var.k = 1;
            Object objE = vq0Var.e(objValueOf, tk2Var);
            Object obj2 = t70.a;
            if (objE == obj2) {
                return obj2;
            }
            an1Var = an1Var2;
            z = zF;
            obj = objE;
            if (z) {
                an1Var.h(null);
            }
            return obj;
        } catch (Throwable th3) {
            an1Var = an1Var2;
            z = zF;
            th = th3;
            if (z) {
                an1Var.h(null);
            }
            throw th;
        }
    }
}
