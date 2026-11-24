package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class n91 extends nu2 implements vq0 {
    public int f;
    public final /* synthetic */ o91 i;
    public final /* synthetic */ int j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n91(o91 o91Var, int i, x50 x50Var) {
        super(2, x50Var);
        this.i = o91Var;
        this.j = i;
    }

    @Override // defpackage.vq0
    public final Object e(Object obj, Object obj2) {
        return ((n91) q((x50) obj2, (s70) obj)).s(q43.a);
    }

    @Override // defpackage.pk
    public final x50 q(x50 x50Var, Object obj) {
        return new n91(this.i, this.j, x50Var);
    }

    @Override // defpackage.pk
    public final Object s(Object obj) throws Throwable {
        int i = this.f;
        q43 q43Var = q43.a;
        if (i != 0) {
            if (i == 1) {
                bz3.g(obj);
                return q43Var;
            }
            og.n("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        bz3.g(obj);
        j91 j91Var = this.i.H;
        this.f = 1;
        ea1 ea1Var = j91Var.b;
        q91 q91Var = ea1.x;
        ea1Var.getClass();
        Object objD = ea1Var.d(rm1.a, new l2(ea1Var, this.j, (x50) null), this);
        t70 t70Var = t70.a;
        if (objD != t70Var) {
            objD = q43Var;
        }
        if (objD != t70Var) {
            objD = q43Var;
        }
        return objD == t70Var ? t70Var : q43Var;
    }
}
