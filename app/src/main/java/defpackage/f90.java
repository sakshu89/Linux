package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class f90 {
    public final /* synthetic */ an1 a;
    public final /* synthetic */ o42 b;
    public final /* synthetic */ t42 c;
    public final /* synthetic */ w90 d;

    public f90(an1 an1Var, o42 o42Var, t42 t42Var, w90 w90Var) {
        this.a = an1Var;
        this.b = o42Var;
        this.c = t42Var;
        this.d = w90Var;
    }

    /* JADX WARN: Code duplicated, block: B:37:0x00b0 A[Catch: all -> 0x0052, TRY_LEAVE, TryCatch #0 {all -> 0x0052, blocks: (B:21:0x004e, B:35:0x00a8, B:37:0x00b0), top: B:52:0x004e }] */
    /* JADX WARN: Code duplicated, block: B:40:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:42:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object a(z9 z9Var, y50 y50Var) throws Throwable {
        e90 e90Var;
        an1 an1Var;
        o42 o42Var;
        t42 t42Var;
        w90 w90Var;
        vq0 vq0Var;
        an1 an1Var2;
        an1 an1Var3;
        t42 t42Var2;
        Object obj;
        if (y50Var instanceof e90) {
            e90Var = (e90) y50Var;
            int i = e90Var.t;
            if ((i & Integer.MIN_VALUE) != 0) {
                e90Var.t = i - Integer.MIN_VALUE;
            } else {
                e90Var = new e90(this, y50Var);
            }
        } else {
            e90Var = new e90(this, y50Var);
        }
        Object obj2 = e90Var.n;
        int i2 = e90Var.t;
        t70 t70Var = t70.a;
        try {
            if (i2 == 0) {
                bz3.g(obj2);
                e90Var.e = z9Var;
                an1Var = this.a;
                e90Var.f = an1Var;
                o42Var = this.b;
                e90Var.i = o42Var;
                t42Var = this.c;
                e90Var.j = t42Var;
                w90Var = this.d;
                e90Var.k = w90Var;
                e90Var.t = 1;
                vq0Var = z9Var;
                if (an1Var.e(e90Var) != t70Var) {
                }
                return t70Var;
            }
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        og.n("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    obj = e90Var.i;
                    t42Var2 = (t42) e90Var.f;
                    an1Var2 = (an1) e90Var.e;
                    try {
                        bz3.g(obj2);
                        t42Var2.a = obj;
                        Object obj3 = t42Var2.a;
                        an1Var2.h(null);
                        return obj3;
                    } catch (Throwable th) {
                        th = th;
                        an1Var2.h(null);
                        throw th;
                    }
                }
                w90Var = (w90) e90Var.i;
                t42Var2 = (t42) e90Var.f;
                an1Var3 = (an1) e90Var.e;
                try {
                    bz3.g(obj2);
                    if (!g31.a(obj2, t42Var2.a)) {
                        e90Var.e = an1Var3;
                        e90Var.f = t42Var2;
                        e90Var.i = obj2;
                        e90Var.t = 3;
                        if (w90Var.k(obj2, false, e90Var) != t70Var) {
                            obj = obj2;
                            an1Var2 = an1Var3;
                            t42Var2.a = obj;
                        }
                        return t70Var;
                    }
                    an1Var2 = an1Var3;
                    Object obj4 = t42Var2.a;
                    an1Var2.h(null);
                    return obj4;
                } catch (Throwable th2) {
                    th = th2;
                    an1Var2 = an1Var3;
                    an1Var2.h(null);
                    throw th;
                }
            }
            w90Var = e90Var.k;
            t42 t42Var3 = e90Var.j;
            o42Var = (o42) e90Var.i;
            an1 an1Var4 = (an1) e90Var.f;
            vq0 vq0Var2 = (vq0) e90Var.e;
            bz3.g(obj2);
            t42Var = t42Var3;
            vq0Var = vq0Var2;
            an1Var = an1Var4;
            if (o42Var.a) {
                throw new IllegalStateException("InitializerApi.updateData should not be called after initialization is complete.");
            }
            Object obj5 = t42Var.a;
            e90Var.e = an1Var;
            e90Var.f = t42Var;
            e90Var.i = w90Var;
            e90Var.j = null;
            e90Var.k = null;
            e90Var.t = 2;
            Object objE = vq0Var.e(obj5, e90Var);
            if (objE != t70Var) {
                an1Var3 = an1Var;
                obj2 = objE;
                t42Var2 = t42Var;
                if (!g31.a(obj2, t42Var2.a)) {
                    e90Var.e = an1Var3;
                    e90Var.f = t42Var2;
                    e90Var.i = obj2;
                    e90Var.t = 3;
                    if (w90Var.k(obj2, false, e90Var) != t70Var) {
                        obj = obj2;
                        an1Var2 = an1Var3;
                        t42Var2.a = obj;
                    }
                } else {
                    an1Var2 = an1Var3;
                }
                Object obj6 = t42Var2.a;
                an1Var2.h(null);
                return obj6;
            }
            return t70Var;
        } catch (Throwable th3) {
            th = th3;
            an1Var2 = an1Var;
            an1Var2.h(null);
            throw th;
        }
    }
}
