package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class l90 implements mm0 {
    public final /* synthetic */ int a;
    public final Object b;

    public /* synthetic */ l90(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    /* JADX WARN: Code duplicated, block: B:9:0x001e  */
    @Override // defpackage.mm0
    public final Object a(nm0 nm0Var, x50 x50Var) throws Throwable {
        d1 d1Var;
        n92 n92Var;
        Throwable th;
        int i = this.a;
        Object obj = this.b;
        t70 t70Var = t70.a;
        q43 q43Var = q43.a;
        switch (i) {
            case 0:
                Object objA = ((i5) obj).a(new w(nm0Var, 3), x50Var);
                return objA == t70Var ? objA : q43Var;
            default:
                if (x50Var instanceof d1) {
                    d1Var = (d1) x50Var;
                    int i2 = d1Var.j;
                    if ((i2 & Integer.MIN_VALUE) != 0) {
                        d1Var.j = i2 - Integer.MIN_VALUE;
                    } else {
                        d1Var = new d1(this, x50Var);
                    }
                } else {
                    d1Var = new d1(this, x50Var);
                }
                Object obj2 = d1Var.f;
                int i3 = d1Var.j;
                if (i3 != 0) {
                    if (i3 != 1) {
                        og.n("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    n92Var = d1Var.e;
                    try {
                        bz3.g(obj2);
                        n92Var.t();
                        return q43Var;
                    } catch (Throwable th2) {
                        th = th2;
                        n92Var.t();
                        throw th;
                    }
                }
                bz3.g(obj2);
                j70 j70Var = d1Var.b;
                j70Var.getClass();
                n92 n92Var2 = new n92(nm0Var, j70Var);
                try {
                    d1Var.e = n92Var2;
                    d1Var.j = 1;
                    Object objE = ((vq0) obj).e(n92Var2, d1Var);
                    if (objE != t70Var) {
                        objE = q43Var;
                    }
                    if (objE == t70Var) {
                        return t70Var;
                    }
                    n92Var = n92Var2;
                    n92Var.t();
                    return q43Var;
                } catch (Throwable th3) {
                    n92Var = n92Var2;
                    th = th3;
                    n92Var.t();
                    throw th;
                }
        }
    }
}
