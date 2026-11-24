package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class t0 extends nu2 implements vq0 {
    public final /* synthetic */ int f = 0;
    public int i;
    public final /* synthetic */ ol1 j;
    public final /* synthetic */ b02 k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t0(ol1 ol1Var, b02 b02Var, x50 x50Var) {
        super(2, x50Var);
        this.j = ol1Var;
        this.k = b02Var;
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
        return ((t0) q(x50Var, s70Var)).s(q43Var);
    }

    @Override // defpackage.pk
    public final x50 q(x50 x50Var, Object obj) {
        int i = this.f;
        b02 b02Var = this.k;
        ol1 ol1Var = this.j;
        switch (i) {
            case 0:
                return new t0(b02Var, ol1Var, x50Var);
            default:
                return new t0(ol1Var, b02Var, x50Var);
        }
    }

    @Override // defpackage.pk
    public final Object s(Object obj) {
        int i = this.f;
        q43 q43Var = q43.a;
        b02 b02Var = this.k;
        ol1 ol1Var = this.j;
        t70 t70Var = t70.a;
        switch (i) {
            case 0:
                int i2 = this.i;
                if (i2 == 0) {
                    bz3.g(obj);
                    c02 c02Var = new c02(b02Var);
                    this.i = 1;
                    return ol1Var.a(c02Var, this) == t70Var ? t70Var : q43Var;
                }
                if (i2 == 1) {
                    bz3.g(obj);
                    return q43Var;
                }
                og.n("call to 'resume' before 'invoke' with coroutine");
                return null;
            default:
                int i3 = this.i;
                if (i3 == 0) {
                    bz3.g(obj);
                    this.i = 1;
                    return ol1Var.a(b02Var, this) == t70Var ? t70Var : q43Var;
                }
                if (i3 == 1) {
                    bz3.g(obj);
                    return q43Var;
                }
                og.n("call to 'resume' before 'invoke' with coroutine");
                return null;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t0(b02 b02Var, ol1 ol1Var, x50 x50Var) {
        super(2, x50Var);
        this.k = b02Var;
        this.j = ol1Var;
    }
}
