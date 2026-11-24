package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class nc3 extends nu2 implements vq0 {
    public final /* synthetic */ int f;
    public int i;
    public final /* synthetic */ pc3 j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ nc3(pc3 pc3Var, x50 x50Var, int i) {
        super(2, x50Var);
        this.f = i;
        this.j = pc3Var;
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
        }
        return ((nc3) q(x50Var, s70Var)).s(q43Var);
    }

    @Override // defpackage.pk
    public final x50 q(x50 x50Var, Object obj) {
        int i = this.f;
        pc3 pc3Var = this.j;
        switch (i) {
            case 0:
                return new nc3(pc3Var, x50Var, 0);
            default:
                return new nc3(pc3Var, x50Var, 1);
        }
    }

    @Override // defpackage.pk
    public final Object s(Object obj) throws Throwable {
        int i = this.f;
        pc3 pc3Var = this.j;
        t70 t70Var = t70.a;
        q43 q43Var = q43.a;
        switch (i) {
            case 0:
                int i2 = this.i;
                if (i2 == 0) {
                    bz3.g(obj);
                    r7 r7Var = pc3Var.a;
                    this.i = 1;
                    Object objD = r7Var.k0.d(this);
                    if (objD != t70Var) {
                        objD = q43Var;
                    }
                    if (objD == t70Var) {
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
                int i3 = this.i;
                if (i3 == 0) {
                    bz3.g(obj);
                    r7 r7Var2 = pc3Var.a;
                    this.i = 1;
                    Object objA = r7Var2.l0.a(this);
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
        }
    }
}
