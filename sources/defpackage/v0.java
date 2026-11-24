package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class v0 extends nu2 implements vq0 {
    public final /* synthetic */ int f;
    public int i;
    public final /* synthetic */ ky j;
    public final /* synthetic */ b02 k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ v0(ky kyVar, b02 b02Var, x50 x50Var, int i) {
        super(2, x50Var);
        this.f = i;
        this.j = kyVar;
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
            case 1:
                break;
            case 2:
                break;
        }
        return ((v0) q(x50Var, s70Var)).s(q43Var);
    }

    @Override // defpackage.pk
    public final x50 q(x50 x50Var, Object obj) {
        int i = this.f;
        b02 b02Var = this.k;
        ky kyVar = this.j;
        switch (i) {
            case 0:
                return new v0(kyVar, b02Var, x50Var, 0);
            case 1:
                return new v0(kyVar, b02Var, x50Var, 1);
            case 2:
                return new v0(kyVar, b02Var, x50Var, 2);
            default:
                return new v0(kyVar, b02Var, x50Var, 3);
        }
    }

    @Override // defpackage.pk
    public final Object s(Object obj) {
        int i = this.f;
        q43 q43Var = q43.a;
        b02 b02Var = this.k;
        ky kyVar = this.j;
        t70 t70Var = t70.a;
        switch (i) {
            case 0:
                int i2 = this.i;
                if (i2 != 0) {
                    if (i2 == 1) {
                        bz3.g(obj);
                        return q43Var;
                    }
                    og.n("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                bz3.g(obj);
                ol1 ol1Var = kyVar.X;
                if (ol1Var == null) {
                    return q43Var;
                }
                a02 a02Var = new a02(b02Var);
                this.i = 1;
                return ol1Var.a(a02Var, this) == t70Var ? t70Var : q43Var;
            case 1:
                int i3 = this.i;
                if (i3 != 0) {
                    if (i3 == 1) {
                        bz3.g(obj);
                        return q43Var;
                    }
                    og.n("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                bz3.g(obj);
                ol1 ol1Var2 = kyVar.X;
                if (ol1Var2 == null) {
                    return q43Var;
                }
                a02 a02Var2 = new a02(b02Var);
                this.i = 1;
                return ol1Var2.a(a02Var2, this) == t70Var ? t70Var : q43Var;
            case 2:
                int i4 = this.i;
                if (i4 != 0) {
                    if (i4 == 1) {
                        bz3.g(obj);
                        return q43Var;
                    }
                    og.n("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                bz3.g(obj);
                ol1 ol1Var3 = kyVar.X;
                if (ol1Var3 == null) {
                    return q43Var;
                }
                this.i = 1;
                return ol1Var3.a(b02Var, this) == t70Var ? t70Var : q43Var;
            default:
                int i5 = this.i;
                if (i5 != 0) {
                    if (i5 == 1) {
                        bz3.g(obj);
                        return q43Var;
                    }
                    og.n("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                bz3.g(obj);
                ol1 ol1Var4 = kyVar.X;
                if (ol1Var4 == null) {
                    return q43Var;
                }
                c02 c02Var = new c02(b02Var);
                this.i = 1;
                return ol1Var4.a(c02Var, this) == t70Var ? t70Var : q43Var;
        }
    }
}
