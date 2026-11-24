package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ym0 extends nu2 implements wq0 {
    public final /* synthetic */ int f;
    public int i;
    public /* synthetic */ nm0 j;
    public /* synthetic */ Object k;
    public final /* synthetic */ nu2 n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ym0(nu2 nu2Var, x50 x50Var, int i) {
        super(3, x50Var);
        this.f = i;
        this.n = nu2Var;
    }

    @Override // defpackage.wq0
    public final Object c(Object obj, Object obj2, Object obj3) {
        int i = this.f;
        q43 q43Var = q43.a;
        nu2 nu2Var = this.n;
        nm0 nm0Var = (nm0) obj;
        switch (i) {
            case 0:
                ym0 ym0Var = new ym0((aa) nu2Var, (x50) obj3, 0);
                ym0Var.j = nm0Var;
                ym0Var.k = obj2;
                return ym0Var.s(q43Var);
            default:
                ym0 ym0Var2 = new ym0((hj2) nu2Var, (x50) obj3, 1);
                ym0Var2.j = nm0Var;
                ym0Var2.k = (Object[]) obj2;
                return ym0Var2.s(q43Var);
        }
    }

    @Override // defpackage.pk
    public final Object s(Object obj) throws Throwable {
        nm0 nm0Var;
        nm0 nm0Var2;
        int i = this.f;
        q43 q43Var = q43.a;
        nu2 nu2Var = this.n;
        t70 t70Var = t70.a;
        switch (i) {
            case 0:
                int i2 = this.i;
                if (i2 == 0) {
                    bz3.g(obj);
                    nm0Var = this.j;
                    Object obj2 = this.k;
                    this.j = nm0Var;
                    this.i = 1;
                    obj = ((aa) nu2Var).e(obj2, this);
                    if (obj != t70Var) {
                    }
                    return t70Var;
                }
                if (i2 != 1) {
                    if (i2 == 2) {
                        bz3.g(obj);
                        return q43Var;
                    }
                    og.n("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                nm0Var = this.j;
                bz3.g(obj);
                this.j = null;
                this.i = 2;
                if (nm0Var.n(obj, this) != t70Var) {
                    return q43Var;
                }
                return t70Var;
            default:
                int i3 = this.i;
                if (i3 == 0) {
                    bz3.g(obj);
                    nm0Var2 = this.j;
                    Object[] objArr = (Object[]) this.k;
                    Object obj3 = objArr[0];
                    Object obj4 = objArr[1];
                    this.j = nm0Var2;
                    this.i = 1;
                    obj = ((hj2) nu2Var).c(obj3, obj4, this);
                    if (obj != t70Var) {
                    }
                    return t70Var;
                }
                if (i3 != 1) {
                    if (i3 == 2) {
                        bz3.g(obj);
                        return q43Var;
                    }
                    og.n("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                nm0Var2 = this.j;
                bz3.g(obj);
                this.j = null;
                this.i = 2;
                if (nm0Var2.n(obj, this) != t70Var) {
                    return q43Var;
                }
                return t70Var;
        }
    }
}
