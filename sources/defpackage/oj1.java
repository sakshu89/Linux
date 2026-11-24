package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class oj1 {
    public final an1 a = new an1();
    public Object b;

    /* JADX WARN: Code duplicated, block: B:31:0x0080 A[Catch: all -> 0x0083, TRY_LEAVE, TryCatch #0 {all -> 0x0083, blocks: (B:29:0x007c, B:31:0x0080, B:39:0x008e, B:41:0x0092, B:42:0x0094), top: B:46:0x0021 }] */
    /* JADX WARN: Code duplicated, block: B:41:0x0092 A[Catch: all -> 0x0083, TryCatch #0 {all -> 0x0083, blocks: (B:29:0x007c, B:31:0x0080, B:39:0x008e, B:41:0x0092, B:42:0x0094), top: B:46:0x0021 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v11 */
    /* JADX WARN: Type inference failed for: r10v5 */
    /* JADX WARN: Type inference failed for: r10v6, types: [hq0] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v4, types: [an1] */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference failed for: r9v0, types: [hq0] */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v11 */
    /* JADX WARN: Type inference failed for: r9v2, types: [an1] */
    /* JADX WARN: Type inference failed for: r9v3 */
    /* JADX WARN: Type inference failed for: r9v4, types: [an1] */
    public final Object a(Object obj, hq0 hq0Var, y50 y50Var) throws Throwable {
        nj1 nj1Var;
        ?? r9;
        int i;
        ?? r10;
        Object obj2;
        ?? r8;
        if (y50Var instanceof nj1) {
            nj1Var = (nj1) y50Var;
            int i2 = nj1Var.s;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                nj1Var.s = i2 - Integer.MIN_VALUE;
            } else {
                nj1Var = new nj1(this, y50Var);
            }
        } else {
            nj1Var = new nj1(this, y50Var);
        }
        Object objJ = nj1Var.k;
        int i3 = nj1Var.s;
        t70 t70Var = t70.a;
        try {
            try {
                try {
                    if (i3 == 0) {
                        bz3.g(objJ);
                        nj1Var.e = obj;
                        nj1Var.f = (nu2) hq0Var;
                        an1 an1Var = this.a;
                        nj1Var.i = an1Var;
                        i = 0;
                        nj1Var.j = 0;
                        nj1Var.s = 1;
                        if (an1Var.e(nj1Var) != t70Var) {
                            r10 = hq0Var;
                            r9 = an1Var;
                        }
                        return t70Var;
                    }
                    if (i3 != 1) {
                        if (i3 != 2) {
                            og.n("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        an1 an1Var2 = nj1Var.i;
                        obj2 = nj1Var.e;
                        try {
                            bz3.g(objJ);
                            r8 = an1Var2;
                            if (this.b == obj2) {
                                this.b = null;
                            }
                            r8.h(null);
                            return objJ;
                        } catch (Throwable th) {
                            th = th;
                            if (this.b == obj2) {
                                this.b = null;
                            }
                            throw th;
                        }
                    }
                    int i4 = nj1Var.j;
                    an1 an1Var3 = nj1Var.i;
                    hq0 hq0Var2 = (hq0) nj1Var.f;
                    Object obj3 = nj1Var.e;
                    bz3.g(objJ);
                    r10 = hq0Var2;
                    i = i4;
                    obj = obj3;
                    r9 = an1Var3;
                    nj1Var.e = obj;
                    nj1Var.f = null;
                    nj1Var.i = r9;
                    nj1Var.j = i;
                    nj1Var.s = 2;
                    objJ = r10.j(nj1Var);
                    if (objJ != t70Var) {
                        ?? r6 = r9;
                        obj2 = obj;
                        r8 = r6;
                        if (this.b == obj2) {
                            this.b = null;
                        }
                        r8.h(null);
                        return objJ;
                    }
                    return t70Var;
                } catch (Throwable th2) {
                    th = th2;
                    obj2 = obj;
                    if (this.b == obj2) {
                        this.b = null;
                    }
                    throw th;
                }
                this.b = obj;
            } catch (Throwable th3) {
                th = th3;
                r9.h(null);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            r9 = obj;
        }
    }
}
