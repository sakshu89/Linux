package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class gn2 extends nu2 implements vq0 {
    public final /* synthetic */ int f = 1;
    public int i;
    public /* synthetic */ Object j;
    public final /* synthetic */ f5 k;
    public final /* synthetic */ in2 n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gn2(f5 f5Var, in2 in2Var, x50 x50Var) {
        super(2, x50Var);
        this.k = f5Var;
        this.n = in2Var;
    }

    @Override // defpackage.vq0
    public final Object e(Object obj, Object obj2) {
        int i = this.f;
        q43 q43Var = q43.a;
        nm0 nm0Var = (nm0) obj;
        x50 x50Var = (x50) obj2;
        switch (i) {
            case 0:
                break;
        }
        return ((gn2) q(x50Var, nm0Var)).s(q43Var);
    }

    @Override // defpackage.pk
    public final x50 q(x50 x50Var, Object obj) {
        int i = this.f;
        in2 in2Var = this.n;
        f5 f5Var = this.k;
        switch (i) {
            case 0:
                gn2 gn2Var = new gn2(in2Var, f5Var, x50Var);
                gn2Var.j = obj;
                return gn2Var;
            default:
                gn2 gn2Var2 = new gn2(f5Var, in2Var, x50Var);
                gn2Var2.j = obj;
                return gn2Var2;
        }
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0089  */
    /* JADX WARN: Code duplicated, block: B:27:0x008c  */
    /* JADX WARN: Code duplicated, block: B:29:0x008f  */
    /* JADX WARN: Code duplicated, block: B:30:0x0092  */
    /* JADX WARN: Code duplicated, block: B:60:? A[RETURN, SYNTHETIC] */
    @Override // defpackage.pk
    public final Object s(Object obj) {
        a92 a92VarB;
        y82 y82Var;
        f5 f5Var;
        int i = this.f;
        t70 t70Var = t70.a;
        f5 f5Var2 = this.k;
        in2 in2Var = this.n;
        q43 q43Var = q43.a;
        switch (i) {
            case 0:
                nm0 nm0Var = (nm0) this.j;
                int i2 = this.i;
                if (i2 == 0) {
                    bz3.g(obj);
                    this.j = null;
                    this.i = 1;
                    if (in2Var.i(nm0Var, f5Var2, false, this) == t70Var) {
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
            default:
                String str = f5Var2.e;
                nm0 nm0Var2 = (nm0) this.j;
                int i3 = this.i;
                if (i3 != 0) {
                    if (i3 != 1) {
                        if (i3 == 2) {
                            bz3.g(obj);
                            a92VarB = he1.b(in2Var.a, str, (i60) in2Var.g.c.getValue(), 8);
                            if (a92VarB instanceof y82) {
                                y82Var = (y82) a92VarB;
                            } else {
                                y82Var = null;
                            }
                            if (y82Var != null) {
                                f5Var = y82Var.a;
                            } else {
                                f5Var = null;
                            }
                            if (f5Var != null && (in2.a(in2Var, f5Var) || in2.a(in2Var, f5Var) || !in2.a(in2Var, f5Var2))) {
                                f5Var2 = f5Var;
                            }
                            this.j = null;
                            this.i = 3;
                            if (in2Var.i(nm0Var2, f5Var2, false, this) == t70Var) {
                                return t70Var;
                            }
                        } else if (i3 != 3) {
                            og.n("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                    }
                    bz3.g(obj);
                } else {
                    bz3.g(obj);
                    if (f5Var2.d != q21.c) {
                        og.i("Failed requirement.");
                        return null;
                    }
                    if (in2Var.g.a() != null) {
                        l90 l90VarL = in2Var.l(str, c63.b, ii0.a);
                        w wVar = new w(nm0Var2, 4);
                        this.j = null;
                        this.i = 1;
                        if (l90VarL.a(wVar, this) == t70Var) {
                            return t70Var;
                        }
                    } else {
                        in2Var.g.b();
                        a5 a5Var = new a5(str);
                        this.j = nm0Var2;
                        this.i = 2;
                        if (nm0Var2.n(a5Var, this) == t70Var) {
                            return t70Var;
                        }
                        a92VarB = he1.b(in2Var.a, str, (i60) in2Var.g.c.getValue(), 8);
                        if (a92VarB instanceof y82) {
                            y82Var = (y82) a92VarB;
                        } else {
                            y82Var = null;
                        }
                        if (y82Var != null) {
                            f5Var = y82Var.a;
                        } else {
                            f5Var = null;
                        }
                        if (f5Var != null) {
                            f5Var2 = f5Var;
                        }
                        this.j = null;
                        this.i = 3;
                        if (in2Var.i(nm0Var2, f5Var2, false, this) == t70Var) {
                            return t70Var;
                        }
                    }
                }
                return q43Var;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gn2(in2 in2Var, f5 f5Var, x50 x50Var) {
        super(2, x50Var);
        this.n = in2Var;
        this.k = f5Var;
    }
}
