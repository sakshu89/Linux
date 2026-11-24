package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ko2 extends nu2 implements vq0 {
    public final /* synthetic */ int f;
    public int i;
    public final /* synthetic */ so2 j;
    public final /* synthetic */ String k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ko2(so2 so2Var, String str, x50 x50Var, int i) {
        super(2, x50Var);
        this.f = i;
        this.j = so2Var;
        this.k = str;
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
        return ((ko2) q(x50Var, s70Var)).s(q43Var);
    }

    @Override // defpackage.pk
    public final x50 q(x50 x50Var, Object obj) {
        int i = this.f;
        String str = this.k;
        so2 so2Var = this.j;
        switch (i) {
            case 0:
                return new ko2(so2Var, str, x50Var, 0);
            default:
                return new ko2(so2Var, str, x50Var, 1);
        }
    }

    @Override // defpackage.pk
    public final Object s(Object obj) {
        int i = this.f;
        String str = this.k;
        so2 so2Var = this.j;
        t70 t70Var = t70.a;
        q43 q43Var = q43.a;
        x50 x50Var = null;
        switch (i) {
            case 0:
                int i2 = this.i;
                if (i2 == 0) {
                    bz3.g(obj);
                    if (so2Var.o()) {
                        so2Var.F = null;
                        so2Var.j();
                        mt0 mt0Var = so2Var.k;
                        zb zbVar = new zb(19, so2Var, str);
                        q0 q0Var = new q0(1, this.j, so2.class, "render", "render(Lcom/project/sonic/core/agent/AgentEvent;)V", 0, 0, 14);
                        this.i = 1;
                        if (mt0Var.l(zbVar, q0Var, this) == t70Var) {
                            return t70Var;
                        }
                    } else {
                        in2 in2Var = so2Var.b;
                        in2Var.getClass();
                        str.getClass();
                        l90 l90Var = new l90(1, new aa(in2Var, str, x50Var, 14));
                        this.i = 2;
                        if (so2Var.u(l90Var, this) == t70Var) {
                            return t70Var;
                        }
                    }
                } else {
                    if (i2 != 1 && i2 != 2) {
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
                    this.i = 1;
                    so2Var.q();
                    Object objU = so2Var.u(so2Var.b.l(str, c63.a, ii0.a), this);
                    if (objU != t70Var) {
                        objU = q43Var;
                    }
                    if (objU == t70Var) {
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
