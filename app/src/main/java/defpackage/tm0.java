package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class tm0 implements mm0 {
    public final /* synthetic */ l90 a;
    public final /* synthetic */ j90 b;

    public tm0(l90 l90Var, j90 j90Var) {
        this.a = l90Var;
        this.b = j90Var;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // defpackage.mm0
    public final Object a(nm0 nm0Var, x50 x50Var) throws Throwable {
        sm0 sm0Var;
        n92 n92Var;
        n92 n92Var2;
        if (x50Var instanceof sm0) {
            sm0Var = (sm0) x50Var;
            int i = sm0Var.f;
            if ((i & Integer.MIN_VALUE) != 0) {
                sm0Var.f = i - Integer.MIN_VALUE;
            } else {
                sm0Var = new sm0(this, x50Var);
            }
        } else {
            sm0Var = new sm0(this, x50Var);
        }
        Object obj = sm0Var.e;
        int i2 = sm0Var.f;
        t70 t70Var = t70.a;
        try {
            try {
                if (i2 == 0) {
                    bz3.g(obj);
                    l90 l90Var = this.a;
                    sm0Var.j = this;
                    sm0Var.k = nm0Var;
                    sm0Var.f = 1;
                    if (l90Var.a(nm0Var, sm0Var) != t70Var) {
                    }
                    return t70Var;
                }
                if (i2 != 1) {
                    if (i2 == 2) {
                        Throwable th = (Throwable) sm0Var.j;
                        bz3.g(obj);
                        throw th;
                    }
                    if (i2 != 3) {
                        og.n("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    n92Var2 = (n92) sm0Var.j;
                    try {
                        bz3.g(obj);
                        n92Var2.t();
                        return q43.a;
                    } catch (Throwable th2) {
                        th = th2;
                        n92Var2.t();
                        throw th;
                    }
                }
                nm0Var = sm0Var.k;
                this = (tm0) sm0Var.j;
                bz3.g(obj);
                j90 j90Var = this.b;
                sm0Var.j = n92Var;
                sm0Var.k = null;
                sm0Var.f = 3;
                if (j90Var.c(n92Var, null, sm0Var) != t70Var) {
                    n92Var2 = n92Var;
                    n92Var2.t();
                    return q43.a;
                }
            } catch (Throwable th3) {
                th = th3;
                n92Var2 = n92Var;
                n92Var2.t();
                throw th;
            }
            j70 j70Var = sm0Var.b;
            j70Var.getClass();
            n92Var = new n92(nm0Var, j70Var);
        } catch (Throwable th4) {
            tm0 tm0Var = this;
            p03 p03Var = new p03(th4);
            j90 j90Var2 = tm0Var.b;
            sm0Var.j = th4;
            sm0Var.k = null;
            sm0Var.f = 2;
            if (tn4.a(p03Var, j90Var2, th4, sm0Var) != t70Var) {
                throw th4;
            }
        }
        return t70Var;
    }
}
