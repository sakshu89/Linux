package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class d60 extends nu2 implements vq0 {
    public final /* synthetic */ int f;
    public int i;
    public final /* synthetic */ x00 j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ d60(x00 x00Var, x50 x50Var, int i) {
        super(2, x50Var);
        this.f = i;
        this.j = x00Var;
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
            case 3:
                break;
        }
        return ((d60) q(x50Var, s70Var)).s(q43Var);
    }

    @Override // defpackage.pk
    public final x50 q(x50 x50Var, Object obj) {
        int i = this.f;
        x00 x00Var = this.j;
        switch (i) {
            case 0:
                return new d60(x00Var, x50Var, 0);
            case 1:
                return new d60(x00Var, x50Var, 1);
            case 2:
                return new d60(x00Var, x50Var, 2);
            case 3:
                return new d60(x00Var, x50Var, 3);
            default:
                return new d60(x00Var, x50Var, 4);
        }
    }

    @Override // defpackage.pk
    public final Object s(Object obj) throws Throwable {
        int i = this.f;
        x00 x00Var = this.j;
        t70 t70Var = t70.a;
        switch (i) {
            case 0:
                int i2 = this.i;
                if (i2 == 0) {
                    bz3.g(obj);
                    this.i = 1;
                    Object objS0 = x00Var.s0(this);
                    return objS0 == t70Var ? t70Var : objS0;
                }
                if (i2 == 1) {
                    bz3.g(obj);
                    return obj;
                }
                og.n("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 1:
                int i3 = this.i;
                if (i3 == 0) {
                    bz3.g(obj);
                    this.i = 1;
                    if (x00Var.s0(this) == t70Var) {
                        return t70Var;
                    }
                } else {
                    if (i3 != 1) {
                        og.n("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    bz3.g(obj);
                }
                return q43.a;
            case 2:
                int i4 = this.i;
                if (i4 == 0) {
                    bz3.g(obj);
                    this.i = 1;
                    Object objS1 = x00Var.s0(this);
                    return objS1 == t70Var ? t70Var : objS1;
                }
                if (i4 == 1) {
                    bz3.g(obj);
                    return obj;
                }
                og.n("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 3:
                int i5 = this.i;
                if (i5 == 0) {
                    bz3.g(obj);
                    this.i = 1;
                    Object objS2 = x00Var.s0(this);
                    return objS2 == t70Var ? t70Var : objS2;
                }
                if (i5 == 1) {
                    bz3.g(obj);
                    return obj;
                }
                og.n("call to 'resume' before 'invoke' with coroutine");
                return null;
            default:
                int i6 = this.i;
                if (i6 == 0) {
                    bz3.g(obj);
                    this.i = 1;
                    Object objS3 = x00Var.s0(this);
                    return objS3 == t70Var ? t70Var : objS3;
                }
                if (i6 == 1) {
                    bz3.g(obj);
                    return obj;
                }
                og.n("call to 'resume' before 'invoke' with coroutine");
                return null;
        }
    }
}
