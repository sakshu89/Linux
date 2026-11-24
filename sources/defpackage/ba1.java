package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ba1 extends nu2 implements vq0 {
    public int f;
    public /* synthetic */ Object i;
    public final /* synthetic */ ea1 j;
    public final /* synthetic */ int k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ba1(ea1 ea1Var, int i, x50 x50Var) {
        super(2, x50Var);
        this.j = ea1Var;
        this.k = i;
    }

    @Override // defpackage.vq0
    public final Object e(Object obj, Object obj2) {
        return ((ba1) q((x50) obj2, (kd2) obj)).s(q43.a);
    }

    @Override // defpackage.pk
    public final x50 q(x50 x50Var, Object obj) {
        ba1 ba1Var = new ba1(this.j, this.k, x50Var);
        ba1Var.i = obj;
        return ba1Var;
    }

    @Override // defpackage.pk
    public final Object s(Object obj) {
        int i = this.f;
        if (i == 0) {
            bz3.g(obj);
            kd2 kd2Var = (kd2) this.i;
            ea1 ea1Var = this.j;
            z91 z91Var = new z91(0, kd2Var, ea1Var);
            jc0 jc0Var = ((x91) ea1Var.f.getValue()).i;
            this.f = 1;
            Object objA = dq4.a(z91Var, this.k, 100, jc0Var, this);
            t70 t70Var = t70.a;
            if (objA == t70Var) {
                return t70Var;
            }
        } else {
            if (i != 1) {
                og.n("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            bz3.g(obj);
        }
        return q43.a;
    }
}
