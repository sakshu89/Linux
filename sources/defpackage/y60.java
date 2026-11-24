package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class y60 extends nu2 implements vq0 {
    public final /* synthetic */ int f;
    public int i;
    public final /* synthetic */ ry1 j;
    public final /* synthetic */ wx2 k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ y60(ry1 ry1Var, wx2 wx2Var, x50 x50Var, int i) {
        super(2, x50Var);
        this.f = i;
        this.j = ry1Var;
        this.k = wx2Var;
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
        return ((y60) q(x50Var, s70Var)).s(q43Var);
    }

    @Override // defpackage.pk
    public final x50 q(x50 x50Var, Object obj) {
        switch (this.f) {
            case 0:
                return new y60(this.j, this.k, x50Var, 0);
            case 1:
                return new y60(this.j, this.k, x50Var, 1);
            default:
                return new y60(this.j, this.k, x50Var, 2);
        }
    }

    @Override // defpackage.pk
    public final Object s(Object obj) {
        int i = this.f;
        wx2 wx2Var = this.k;
        ry1 ry1Var = this.j;
        t70 t70Var = t70.a;
        q43 q43Var = q43.a;
        x50 x50Var = null;
        int i2 = 1;
        switch (i) {
            case 0:
                int i3 = this.i;
                if (i3 == 0) {
                    bz3.g(obj);
                    this.i = 1;
                    Object objC = tl4.c(new f61(ry1Var, wx2Var, x50Var, i2), this);
                    if (objC != t70Var) {
                        objC = q43Var;
                    }
                    if (objC == t70Var) {
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
            case 1:
                int i4 = this.i;
                if (i4 == 0) {
                    bz3.g(obj);
                    this.i = 1;
                    Object objB = ao4.b(ry1Var, new rp0(wx2Var, x50Var, i2), this);
                    if (objB != t70Var) {
                        objB = q43Var;
                    }
                    if (objB == t70Var) {
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
            default:
                int i5 = this.i;
                if (i5 == 0) {
                    bz3.g(obj);
                    this.i = 1;
                    ef1 ef1Var = new ef1(wx2Var, 0);
                    ff1 ff1Var = new ff1(wx2Var, 0);
                    ff1 ff1Var2 = new ff1(wx2Var, 1);
                    ha haVar = new ha(6, wx2Var);
                    xv xvVar = new xv(2, ef1Var);
                    x0 x0Var = new x0(9, ff1Var);
                    e4 e4Var = new e4(10);
                    float f = cf0.a;
                    Object objB2 = ao4.b(ry1Var, new af0(e4Var, new s42(), null, xvVar, haVar, ff1Var2, x0Var, null), this);
                    if (objB2 != t70Var) {
                        objB2 = q43Var;
                    }
                    if (objB2 != t70Var) {
                        objB2 = q43Var;
                    }
                    if (objB2 != t70Var) {
                        objB2 = q43Var;
                    }
                    if (objB2 == t70Var) {
                        return t70Var;
                    }
                } else {
                    if (i5 != 1) {
                        og.n("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    bz3.g(obj);
                }
                return q43Var;
        }
    }
}
