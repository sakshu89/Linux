package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class qm2 extends nu2 implements vq0 {
    public final /* synthetic */ int f;
    public int i;
    public /* synthetic */ Object j;
    public final /* synthetic */ vq0 k;
    public final /* synthetic */ mm1 n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ qm2(vq0 vq0Var, mm1 mm1Var, x50 x50Var, int i) {
        super(2, x50Var);
        this.f = i;
        this.k = vq0Var;
        this.n = mm1Var;
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
        return ((qm2) q(x50Var, s70Var)).s(q43Var);
    }

    @Override // defpackage.pk
    public final x50 q(x50 x50Var, Object obj) {
        switch (this.f) {
            case 0:
                qm2 qm2Var = new qm2(this.k, this.n, x50Var, 0);
                qm2Var.j = obj;
                return qm2Var;
            default:
                qm2 qm2Var2 = new qm2(this.k, this.n, x50Var, 1);
                qm2Var2.j = obj;
                return qm2Var2;
        }
    }

    @Override // defpackage.pk
    public final Object s(Object obj) {
        int i = this.f;
        q43 q43Var = q43.a;
        mm1 mm1Var = this.n;
        vq0 vq0Var = this.k;
        t70 t70Var = t70.a;
        switch (i) {
            case 0:
                int i2 = this.i;
                if (i2 == 0) {
                    bz3.g(obj);
                    i12 i12Var = new i12(mm1Var, ((s70) this.j).o());
                    this.i = 1;
                    return vq0Var.e(i12Var, this) == t70Var ? t70Var : q43Var;
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
                    i12 i12Var2 = new i12(mm1Var, ((s70) this.j).o());
                    this.i = 1;
                    return vq0Var.e(i12Var2, this) == t70Var ? t70Var : q43Var;
                }
                if (i3 == 1) {
                    bz3.g(obj);
                    return q43Var;
                }
                og.n("call to 'resume' before 'invoke' with coroutine");
                return null;
        }
    }
}
