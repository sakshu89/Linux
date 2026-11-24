package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class gc2 extends nu2 implements vq0 {
    public final /* synthetic */ int f;
    public int i;
    public final /* synthetic */ vc2 j;
    public final /* synthetic */ f5 k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ gc2(vc2 vc2Var, f5 f5Var, x50 x50Var, int i) {
        super(2, x50Var);
        this.f = i;
        this.j = vc2Var;
        this.k = f5Var;
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
        return ((gc2) q(x50Var, s70Var)).s(q43Var);
    }

    @Override // defpackage.pk
    public final x50 q(x50 x50Var, Object obj) {
        int i = this.f;
        f5 f5Var = this.k;
        vc2 vc2Var = this.j;
        switch (i) {
            case 0:
                return new gc2(vc2Var, f5Var, x50Var, 0);
            default:
                return new gc2(vc2Var, f5Var, x50Var, 1);
        }
    }

    @Override // defpackage.pk
    public final Object s(Object obj) {
        int i = this.f;
        f5 f5Var = this.k;
        vc2 vc2Var = this.j;
        t70 t70Var = t70.a;
        switch (i) {
            case 0:
                int i2 = this.i;
                if (i2 == 0) {
                    bz3.g(obj);
                    this.i = 1;
                    Object objQ = vc2Var.q(f5Var, true, null, this);
                    return objQ == t70Var ? t70Var : objQ;
                }
                if (i2 == 1) {
                    bz3.g(obj);
                    return obj;
                }
                og.n("call to 'resume' before 'invoke' with coroutine");
                return null;
            default:
                int i3 = this.i;
                if (i3 == 0) {
                    bz3.g(obj);
                    this.i = 1;
                    Object objV = vc2Var.v(f5Var, true, false, this);
                    return objV == t70Var ? t70Var : objV;
                }
                if (i3 == 1) {
                    bz3.g(obj);
                    return obj;
                }
                og.n("call to 'resume' before 'invoke' with coroutine");
                return null;
        }
    }
}
