package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class nj2 extends nu2 implements vq0 {
    public final /* synthetic */ int f;
    public int i;
    public final /* synthetic */ oj2 j;
    public final /* synthetic */ boolean k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public nj2(boolean z, oj2 oj2Var, x50 x50Var) {
        super(2, x50Var);
        this.f = 0;
        this.k = z;
        this.j = oj2Var;
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
            case 2:
                break;
        }
        return ((nj2) q(x50Var, s70Var)).s(q43Var);
    }

    @Override // defpackage.pk
    public final x50 q(x50 x50Var, Object obj) {
        switch (this.f) {
            case 0:
                return new nj2(this.k, this.j, x50Var);
            case 1:
                return new nj2(this.j, this.k, x50Var, 1);
            case 2:
                return new nj2(this.j, this.k, x50Var, 2);
            default:
                return new nj2(this.j, this.k, x50Var, 3);
        }
    }

    /* JADX WARN: Code duplicated, block: B:69:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:73:0x013e  */
    /* JADX WARN: Code duplicated, block: B:74:0x0141  */
    @Override // defpackage.pk
    public final Object s(Object obj) {
        String str;
        jr2 jr2Var;
        Object value;
        int i = this.f;
        t70 t70Var = t70.a;
        oj2 oj2Var = this.j;
        boolean z = this.k;
        q43 q43Var = q43.a;
        switch (i) {
            case 0:
                int i2 = this.i;
                if (i2 != 0) {
                    if (i2 == 1) {
                        bz3.g(obj);
                    } else {
                        if (i2 != 2) {
                            og.n("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        bz3.g(obj);
                    }
                    if (!z) {
                        jr2Var = oj2Var.j;
                        do {
                            value = jr2Var.getValue();
                        } while (!jr2Var.h(value, gj2.a((gj2) value, false, null, null, false, null, r51.a, false, null, false, null, null, null, null, false, false, null, false, null, null, false, null, null, 2097119)));
                    }
                    if (z) {
                        str = "Cloud AI enabled. Save your Gemini API key to connect.";
                    } else {
                        str = "Cloud AI off. Live streaming stopped.";
                    }
                    oj2Var.i(str);
                    return q43Var;
                }
                bz3.g(obj);
                if (!z) {
                    this.i = 1;
                    if (oj2.f(oj2Var, this) == t70Var) {
                        return t70Var;
                    }
                }
                f0 f0Var = oj2Var.b;
                this.i = 2;
                if (f0Var.l(z, this) == t70Var) {
                    return t70Var;
                }
                if (!z) {
                    jr2Var = oj2Var.j;
                    do {
                        value = jr2Var.getValue();
                    } while (!jr2Var.h(value, gj2.a((gj2) value, false, null, null, false, null, r51.a, false, null, false, null, null, null, null, false, false, null, false, null, null, false, null, null, 2097119)));
                }
                if (z) {
                    str = "Cloud AI enabled. Save your Gemini API key to connect.";
                } else {
                    str = "Cloud AI off. Live streaming stopped.";
                }
                oj2Var.i(str);
                return q43Var;
            case 1:
                int i3 = this.i;
                if (i3 == 0) {
                    bz3.g(obj);
                    j5 j5Var = oj2Var.c;
                    this.i = 1;
                    Object objA = rq1.a(k5.a(j5Var.a), new d0(z, (x50) null, 2), this);
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
                oj2Var.i(z ? "Send WhatsApp messages without confirmation." : "Ask before sending WhatsApp messages.");
                return q43Var;
            case 2:
                int i4 = this.i;
                if (i4 == 0) {
                    bz3.g(obj);
                    j5 j5Var2 = oj2Var.c;
                    this.i = 1;
                    Object objA2 = rq1.a(k5.a(j5Var2.a), new d0(z, (x50) null, 3), this);
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
                jr2 jr2Var2 = oj2Var.e.g;
                Boolean boolValueOf = Boolean.valueOf(z);
                jr2Var2.getClass();
                jr2Var2.j(null, boolValueOf);
                oj2Var.i(z ? "SONIC will say Boss on completed actions." : "SONIC will speak plainly.");
                return q43Var;
            default:
                int i5 = this.i;
                if (i5 == 0) {
                    bz3.g(obj);
                    j5 j5Var3 = oj2Var.c;
                    this.i = 1;
                    Object objA3 = rq1.a(k5.a(j5Var3.a), new d0(z, (x50) null, 4), this);
                    if (objA3 != t70Var) {
                        objA3 = q43Var;
                    }
                    if (objA3 == t70Var) {
                        return t70Var;
                    }
                } else {
                    if (i5 != 1) {
                        og.n("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    bz3.g(obj);
                }
                oj2Var.i(z ? "Screen reading enabled." : "Screen reading disabled.");
                oj2Var.j();
                return q43Var;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ nj2(oj2 oj2Var, boolean z, x50 x50Var, int i) {
        super(2, x50Var);
        this.f = i;
        this.j = oj2Var;
        this.k = z;
    }
}
