package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ix implements nm0 {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ Object e;
    public final /* synthetic */ Object f;

    public /* synthetic */ ix(Object obj, Object obj2, Object obj3, Object obj4, int i) {
        this.a = i;
        this.b = obj;
        this.c = obj2;
        this.e = obj3;
        this.f = obj4;
    }

    /* JADX WARN: Code duplicated, block: B:62:0x00cc  */
    @Override // defpackage.nm0
    public final Object n(Object obj, x50 x50Var) {
        hx hxVar;
        int i = this.a;
        Object obj2 = this.f;
        boolean z = true;
        Object obj3 = this.c;
        Object obj4 = this.e;
        q43 q43Var = q43.a;
        Object obj5 = this.b;
        switch (i) {
            case 0:
                if (x50Var instanceof hx) {
                    hxVar = (hx) x50Var;
                    int i2 = hxVar.k;
                    if ((i2 & Integer.MIN_VALUE) != 0) {
                        hxVar.k = i2 - Integer.MIN_VALUE;
                    } else {
                        hxVar = new hx(this, x50Var);
                    }
                } else {
                    hxVar = new hx(this, x50Var);
                }
                Object obj6 = hxVar.i;
                int i3 = hxVar.k;
                if (i3 == 0) {
                    bz3.g(obj6);
                    f41 f41Var = (f41) ((t42) obj5).a;
                    if (f41Var != null) {
                        f41Var.e(new qx("Child of the scoped flow was cancelled"));
                        hxVar.e = this;
                        hxVar.f = obj;
                        hxVar.k = 1;
                        Object objH = f41Var.H(hxVar);
                        t70 t70Var = t70.a;
                        if (objH == t70Var) {
                            return t70Var;
                        }
                    }
                } else {
                    if (i3 != 1) {
                        og.n("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    obj = hxVar.f;
                    this = hxVar.e;
                    bz3.g(obj6);
                }
                ((t42) this.b).a = uf4.b((s70) this.c, null, new gx((jx) this.e, (nm0) this.f, obj, null), 1);
                return q43Var;
            case 1:
                ny2 ny2Var = (ny2) obj4;
                ua1 ua1Var = (ua1) obj5;
                if (((Boolean) obj).booleanValue() && ua1Var.b()) {
                    hl4.g((xy2) obj3, ua1Var, ny2Var.n(), (kz0) obj2, ny2Var.b);
                } else {
                    hl4.e(ua1Var);
                }
                return q43Var;
            default:
                r21 r21Var = (r21) obj;
                r42 r42Var = (r42) obj4;
                r42 r42Var2 = (r42) obj3;
                r42 r42Var3 = (r42) obj5;
                if (r21Var instanceof b02) {
                    r42Var3.a++;
                } else if ((r21Var instanceof c02) || (r21Var instanceof a02)) {
                    r42Var3.a--;
                } else if (r21Var instanceof xw0) {
                    r42Var2.a++;
                } else if (r21Var instanceof yw0) {
                    r42Var2.a--;
                } else if (r21Var instanceof sn0) {
                    r42Var.a++;
                } else if (r21Var instanceof tn0) {
                    r42Var.a--;
                }
                boolean z2 = false;
                boolean z3 = r42Var3.a > 0;
                boolean z4 = r42Var2.a > 0;
                boolean z5 = r42Var.a > 0;
                ea0 ea0Var = (ea0) obj2;
                if (ea0Var.H != z3) {
                    ea0Var.H = z3;
                    z2 = true;
                }
                if (ea0Var.X != z4) {
                    ea0Var.X = z4;
                    z2 = true;
                }
                if (ea0Var.Y != z5) {
                    ea0Var.Y = z5;
                } else {
                    z = z2;
                }
                if (z) {
                    vm4.a(ea0Var);
                }
                return q43Var;
        }
    }
}
