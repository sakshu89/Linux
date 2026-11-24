package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class pv2 extends nu2 implements vq0 {
    public final /* synthetic */ int f;
    public int i;
    public final /* synthetic */ wq0 j;
    public final /* synthetic */ zz1 k;
    public final /* synthetic */ ny1 n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ pv2(wq0 wq0Var, zz1 zz1Var, ny1 ny1Var, x50 x50Var, int i) {
        super(2, x50Var);
        this.f = i;
        this.j = wq0Var;
        this.k = zz1Var;
        this.n = ny1Var;
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
        return ((pv2) q(x50Var, s70Var)).s(q43Var);
    }

    @Override // defpackage.pk
    public final x50 q(x50 x50Var, Object obj) {
        switch (this.f) {
            case 0:
                return new pv2(this.j, this.k, this.n, x50Var, 0);
            case 1:
                return new pv2(this.j, this.k, this.n, x50Var, 1);
            default:
                return new pv2(this.j, this.k, this.n, x50Var, 2);
        }
    }

    @Override // defpackage.pk
    public final Object s(Object obj) {
        int i = this.f;
        q43 q43Var = q43.a;
        ny1 ny1Var = this.n;
        zz1 zz1Var = this.k;
        wq0 wq0Var = this.j;
        t70 t70Var = t70.a;
        switch (i) {
            case 0:
                int i2 = this.i;
                if (i2 == 0) {
                    bz3.g(obj);
                    jp1 jp1Var = new jp1(ny1Var.c);
                    this.i = 1;
                    return wq0Var.c(zz1Var, jp1Var, this) == t70Var ? t70Var : q43Var;
                }
                if (i2 == 1) {
                    bz3.g(obj);
                    return q43Var;
                }
                og.n("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 1:
                int i3 = this.i;
                if (i3 == 0) {
                    bz3.g(obj);
                    jp1 jp1Var2 = new jp1(ny1Var.c);
                    this.i = 1;
                    return wq0Var.c(zz1Var, jp1Var2, this) == t70Var ? t70Var : q43Var;
                }
                if (i3 == 1) {
                    bz3.g(obj);
                    return q43Var;
                }
                og.n("call to 'resume' before 'invoke' with coroutine");
                return null;
            default:
                int i4 = this.i;
                if (i4 == 0) {
                    bz3.g(obj);
                    jp1 jp1Var3 = new jp1(ny1Var.c);
                    this.i = 1;
                    return wq0Var.c(zz1Var, jp1Var3, this) == t70Var ? t70Var : q43Var;
                }
                if (i4 == 1) {
                    bz3.g(obj);
                    return q43Var;
                }
                og.n("call to 'resume' before 'invoke' with coroutine");
                return null;
        }
    }
}
