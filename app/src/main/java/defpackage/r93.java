package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class r93 extends nu2 implements vq0 {
    public final /* synthetic */ int f;
    public final /* synthetic */ u93 i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ r93(u93 u93Var, x50 x50Var, int i) {
        super(2, x50Var);
        this.f = i;
        this.i = u93Var;
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
        return ((r93) q(x50Var, s70Var)).s(q43Var);
    }

    @Override // defpackage.pk
    public final x50 q(x50 x50Var, Object obj) {
        int i = this.f;
        u93 u93Var = this.i;
        switch (i) {
            case 0:
                return new r93(u93Var, x50Var, 0);
            case 1:
                return new r93(u93Var, x50Var, 1);
            case 2:
                return new r93(u93Var, x50Var, 2);
            default:
                return new r93(u93Var, x50Var, 3);
        }
    }

    @Override // defpackage.pk
    public final Object s(Object obj) {
        int i = this.f;
        u93 u93Var = this.i;
        switch (i) {
            case 0:
                bz3.g(obj);
                return u93Var.c.e("com.google.android.youtube");
            case 1:
                bz3.g(obj);
                return Boolean.valueOf(u93Var.c.b.a());
            case 2:
                bz3.g(obj);
                return Boolean.valueOf(u93Var.c.b.a());
            default:
                bz3.g(obj);
                return u93Var.c.e("com.google.android.youtube");
        }
    }
}
