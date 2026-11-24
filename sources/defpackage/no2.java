package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class no2 extends nu2 implements vq0 {
    public int f;
    public final /* synthetic */ so2 i;
    public final /* synthetic */ boolean j;
    public final /* synthetic */ long k;
    public final /* synthetic */ fq0 n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public no2(so2 so2Var, boolean z, long j, fq0 fq0Var, x50 x50Var) {
        super(2, x50Var);
        this.i = so2Var;
        this.j = z;
        this.k = j;
        this.n = fq0Var;
    }

    @Override // defpackage.vq0
    public final Object e(Object obj, Object obj2) {
        return ((no2) q((x50) obj2, (s70) obj)).s(q43.a);
    }

    @Override // defpackage.pk
    public final x50 q(x50 x50Var, Object obj) {
        return new no2(this.i, this.j, this.k, this.n, x50Var);
    }

    @Override // defpackage.pk
    public final Object s(Object obj) {
        int i = this.f;
        so2 so2Var = this.i;
        if (i == 0) {
            bz3.g(obj);
            j5 j5Var = so2Var.h;
            this.f = 1;
            Object objB = j5Var.b(this.j, this);
            t70 t70Var = t70.a;
            if (objB == t70Var) {
                return t70Var;
            }
        } else {
            if (i != 1) {
                og.n("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            bz3.g(obj);
        }
        if (this.k == so2Var.u) {
            so2Var.s = null;
            this.n.a();
        }
        return q43.a;
    }
}
