package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class by2 extends nu2 implements wq0 {
    public int f;
    public /* synthetic */ zz1 i;
    public /* synthetic */ long j;
    public final /* synthetic */ s70 k;
    public final /* synthetic */ mm1 n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public by2(s70 s70Var, mm1 mm1Var, x50 x50Var) {
        super(3, x50Var);
        this.k = s70Var;
        this.n = mm1Var;
    }

    @Override // defpackage.wq0
    public final Object c(Object obj, Object obj2, Object obj3) {
        long j = ((jp1) obj2).a;
        by2 by2Var = new by2(this.k, this.n, (x50) obj3);
        by2Var.i = (zz1) obj;
        by2Var.j = j;
        return by2Var.s(q43.a);
    }

    @Override // defpackage.pk
    public final Object s(Object obj) {
        int i = this.f;
        mm1 mm1Var = this.n;
        s70 s70Var = this.k;
        if (i == 0) {
            bz3.g(obj);
            zz1 zz1Var = this.i;
            uf4.b(s70Var, null, new xd2(mm1Var, this.j, null), 3);
            this.f = 1;
            obj = zz1Var.e(this);
            t70 t70Var = t70.a;
            if (obj == t70Var) {
                return t70Var;
            }
        } else {
            if (i != 1) {
                og.n("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            bz3.g(obj);
        }
        uf4.b(s70Var, null, new d0(mm1Var, ((Boolean) obj).booleanValue(), (x50) null), 3);
        return q43.a;
    }
}
