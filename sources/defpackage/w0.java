package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class w0 extends nu2 implements vq0 {
    public final /* synthetic */ int f;
    public final /* synthetic */ ky i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ w0(ky kyVar, x50 x50Var, int i) {
        super(2, x50Var);
        this.f = i;
        this.i = kyVar;
    }

    @Override // defpackage.vq0
    public final Object e(Object obj, Object obj2) {
        int i = this.f;
        q43 q43Var = q43.a;
        s70 s70Var = (s70) obj;
        x50 x50Var = (x50) obj2;
        switch (i) {
            case 0:
                ((w0) q(x50Var, s70Var)).s(q43Var);
                break;
            default:
                ((w0) q(x50Var, s70Var)).s(q43Var);
                break;
        }
        return q43Var;
    }

    @Override // defpackage.pk
    public final x50 q(x50 x50Var, Object obj) {
        int i = this.f;
        ky kyVar = this.i;
        switch (i) {
            case 0:
                return new w0(kyVar, x50Var, 0);
            default:
                return new w0(kyVar, x50Var, 1);
        }
    }

    @Override // defpackage.pk
    public final Object s(Object obj) {
        int i = this.f;
        q43 q43Var = q43.a;
        x50 x50Var = null;
        ky kyVar = this.i;
        switch (i) {
            case 0:
                bz3.g(obj);
                if (kyVar.k0 == null) {
                    xw0 xw0Var = new xw0();
                    ol1 ol1Var = kyVar.X;
                    if (ol1Var != null) {
                        uf4.b(kyVar.w0(), null, new p0(ol1Var, xw0Var, x50Var, 0), 3);
                    }
                    kyVar.k0 = xw0Var;
                }
                break;
            default:
                bz3.g(obj);
                xw0 xw0Var2 = kyVar.k0;
                if (xw0Var2 != null) {
                    yw0 yw0Var = new yw0(xw0Var2);
                    ol1 ol1Var2 = kyVar.X;
                    if (ol1Var2 != null) {
                        uf4.b(kyVar.w0(), null, new p0(ol1Var2, yw0Var, x50Var, 1), 3);
                    }
                    kyVar.k0 = null;
                }
                break;
        }
        return q43Var;
    }
}
