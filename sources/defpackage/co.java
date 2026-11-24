package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class co extends nu2 implements vq0 {
    public int f;
    public final /* synthetic */ bd i;
    public final /* synthetic */ float j;
    public final /* synthetic */ boolean k;
    public final /* synthetic */ eo n;
    public final /* synthetic */ r21 s;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public co(bd bdVar, float f, boolean z, eo eoVar, r21 r21Var, x50 x50Var) {
        super(2, x50Var);
        this.i = bdVar;
        this.j = f;
        this.k = z;
        this.n = eoVar;
        this.s = r21Var;
    }

    @Override // defpackage.vq0
    public final Object e(Object obj, Object obj2) {
        return ((co) q((x50) obj2, (s70) obj)).s(q43.a);
    }

    @Override // defpackage.pk
    public final x50 q(x50 x50Var, Object obj) {
        return new co(this.i, this.j, this.k, this.n, this.s, x50Var);
    }

    /* JADX WARN: Code duplicated, block: B:47:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:66:0x00db A[RETURN] */
    @Override // defpackage.pk
    public final Object s(Object obj) {
        r21 sn0Var;
        Object objE;
        int i = this.f;
        q43 q43Var = q43.a;
        f33 f33Var = null;
        if (i != 0) {
            if (i == 1) {
                bz3.g(obj);
                return q43Var;
            }
            if (i == 2) {
                bz3.g(obj);
                return q43Var;
            }
            og.n("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        bz3.g(obj);
        bd bdVar = this.i;
        float f = ((de0) bdVar.e.getValue()).a;
        float f2 = this.j;
        if (!de0.b(f, f2)) {
            boolean z = this.k;
            t70 t70Var = t70.a;
            if (z) {
                float f3 = ((de0) bdVar.e.getValue()).a;
                if (de0.b(f3, 0.0f)) {
                    sn0Var = new b02(0L);
                } else if (de0.b(f3, this.n.a)) {
                    sn0Var = new xw0();
                } else {
                    sn0Var = de0.b(f3, 0.0f) ? new sn0() : null;
                }
                this.f = 2;
                f33 f33Var2 = ih0.b;
                f33 f33Var3 = ih0.a;
                r21 r21Var = this.s;
                if (r21Var != null) {
                    if ((r21Var instanceof b02) || (r21Var instanceof jf0) || (r21Var instanceof xw0) || (r21Var instanceof sn0)) {
                        f33Var = f33Var3;
                    }
                } else if (sn0Var != null) {
                    if ((sn0Var instanceof b02) || (sn0Var instanceof jf0)) {
                        f33Var = f33Var2;
                    } else if (sn0Var instanceof xw0) {
                        f33Var = ih0.c;
                    } else if (sn0Var instanceof sn0) {
                        f33Var = f33Var2;
                    }
                }
                f33 f33Var4 = f33Var;
                bd bdVar2 = this.i;
                if (f33Var4 == null ? (objE = bdVar2.e(this, new de0(f2))) != t70Var : (objE = bd.c(bdVar2, new de0(f2), f33Var4, null, this, 12)) != t70Var) {
                    objE = q43Var;
                }
                if (objE == t70Var) {
                    return t70Var;
                }
            } else {
                de0 de0Var = new de0(f2);
                this.f = 1;
                if (bdVar.e(this, de0Var) == t70Var) {
                    return t70Var;
                }
            }
        }
        return q43Var;
    }
}
