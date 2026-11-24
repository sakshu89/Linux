package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class qv2 extends nu2 implements vq0 {
    public final /* synthetic */ int f;
    public final /* synthetic */ zz1 i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ qv2(zz1 zz1Var, x50 x50Var, int i) {
        super(2, x50Var);
        this.f = i;
        this.i = zz1Var;
    }

    @Override // defpackage.vq0
    public final Object e(Object obj, Object obj2) {
        int i = this.f;
        q43 q43Var = q43.a;
        s70 s70Var = (s70) obj;
        x50 x50Var = (x50) obj2;
        switch (i) {
            case 0:
                ((qv2) q(x50Var, s70Var)).s(q43Var);
                break;
            case 1:
                ((qv2) q(x50Var, s70Var)).s(q43Var);
                break;
            case 2:
                ((qv2) q(x50Var, s70Var)).s(q43Var);
                break;
            case 3:
                ((qv2) q(x50Var, s70Var)).s(q43Var);
                break;
            case 4:
                ((qv2) q(x50Var, s70Var)).s(q43Var);
                break;
            case 5:
                ((qv2) q(x50Var, s70Var)).s(q43Var);
                break;
            case 6:
                ((qv2) q(x50Var, s70Var)).s(q43Var);
                break;
            default:
                ((qv2) q(x50Var, s70Var)).s(q43Var);
                break;
        }
        return q43Var;
    }

    @Override // defpackage.pk
    public final x50 q(x50 x50Var, Object obj) {
        int i = this.f;
        zz1 zz1Var = this.i;
        switch (i) {
            case 0:
                return new qv2(zz1Var, x50Var, 0);
            case 1:
                return new qv2(zz1Var, x50Var, 1);
            case 2:
                return new qv2(zz1Var, x50Var, 2);
            case 3:
                return new qv2(zz1Var, x50Var, 3);
            case 4:
                return new qv2(zz1Var, x50Var, 4);
            case 5:
                return new qv2(zz1Var, x50Var, 5);
            case 6:
                return new qv2(zz1Var, x50Var, 6);
            default:
                return new qv2(zz1Var, x50Var, 7);
        }
    }

    @Override // defpackage.pk
    public final Object s(Object obj) {
        int i = this.f;
        q43 q43Var = q43.a;
        zz1 zz1Var = this.i;
        switch (i) {
            case 0:
                bz3.g(obj);
                zz1Var.c = true;
                an1 an1Var = zz1Var.e;
                if (an1Var.d()) {
                    an1Var.h(null);
                }
                break;
            case 1:
                bz3.g(obj);
                zz1Var.a();
                break;
            case 2:
                bz3.g(obj);
                zz1Var.a();
                break;
            case 3:
                bz3.g(obj);
                zz1Var.c = true;
                an1 an1Var2 = zz1Var.e;
                if (an1Var2.d()) {
                    an1Var2.h(null);
                }
                break;
            case 4:
                bz3.g(obj);
                zz1Var.a();
                break;
            case 5:
                bz3.g(obj);
                zz1Var.a();
                break;
            case 6:
                bz3.g(obj);
                zz1Var.c = true;
                an1 an1Var3 = zz1Var.e;
                if (an1Var3.d()) {
                    an1Var3.h(null);
                }
                break;
            default:
                bz3.g(obj);
                zz1Var.a();
                break;
        }
        return q43Var;
    }
}
