package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class rj2 extends nu2 implements vq0 {
    public final /* synthetic */ int f;
    public int i;
    public final /* synthetic */ sj2 j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ rj2(sj2 sj2Var, x50 x50Var, int i) {
        super(2, x50Var);
        this.f = i;
        this.j = sj2Var;
    }

    @Override // defpackage.vq0
    public final Object e(Object obj, Object obj2) {
        int i = this.f;
        q43 q43Var = q43.a;
        s70 s70Var = (s70) obj;
        x50 x50Var = (x50) obj2;
        switch (i) {
            case 0:
                break;
            case 1:
                break;
        }
        return ((rj2) q(x50Var, s70Var)).s(q43Var);
    }

    @Override // defpackage.pk
    public final x50 q(x50 x50Var, Object obj) {
        int i = this.f;
        sj2 sj2Var = this.j;
        switch (i) {
            case 0:
                return new rj2(sj2Var, x50Var, 0);
            case 1:
                return new rj2(sj2Var, x50Var, 1);
            default:
                return new rj2(sj2Var, x50Var, 2);
        }
    }

    @Override // defpackage.pk
    public final Object s(Object obj) {
        int i = this.f;
        sj2 sj2Var = this.j;
        t70 t70Var = t70.a;
        q43 q43Var = q43.a;
        switch (i) {
            case 0:
                int i2 = this.i;
                if (i2 == 0) {
                    bz3.g(obj);
                    i5 i5Var = sj2Var.d.b;
                    x9 x9Var = new x9(5, sj2Var);
                    this.i = 1;
                    if (i5Var.a(x9Var, this) == t70Var) {
                        return t70Var;
                    }
                } else {
                    if (i2 != 1) {
                        og.n("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    bz3.g(obj);
                }
                return q43Var;
            case 1:
                int i3 = this.i;
                if (i3 == 0) {
                    bz3.g(obj);
                    j5 j5Var = sj2Var.d;
                    this.i = 1;
                    Object objA = rq1.a(k5.a(j5Var.a), new d0(true, (x50) null, 5), this);
                    if (objA != t70Var) {
                        objA = q43Var;
                    }
                    if (objA == t70Var) {
                        return t70Var;
                    }
                } else {
                    if (i3 != 1) {
                        og.n("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    bz3.g(obj);
                }
                return q43Var;
            default:
                int i4 = this.i;
                if (i4 == 0) {
                    bz3.g(obj);
                    j5 j5Var2 = sj2Var.d;
                    this.i = 1;
                    Object objA2 = rq1.a(k5.a(j5Var2.a), new d0(false, (x50) null, 5), this);
                    if (objA2 != t70Var) {
                        objA2 = q43Var;
                    }
                    if (objA2 == t70Var) {
                        return t70Var;
                    }
                } else {
                    if (i4 != 1) {
                        og.n("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    bz3.g(obj);
                }
                return q43Var;
        }
    }
}
