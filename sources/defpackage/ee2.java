package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ee2 extends nu2 implements vq0 {
    public he2 f;
    public s42 i;
    public long j;
    public int k;
    public /* synthetic */ Object n;
    public final /* synthetic */ he2 s;
    public final /* synthetic */ s42 t;
    public final /* synthetic */ long u;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ee2(he2 he2Var, s42 s42Var, long j, x50 x50Var) {
        super(2, x50Var);
        this.s = he2Var;
        this.t = s42Var;
        this.u = j;
    }

    @Override // defpackage.vq0
    public final Object e(Object obj, Object obj2) {
        return ((ee2) q((x50) obj2, (fe2) obj)).s(q43.a);
    }

    @Override // defpackage.pk
    public final x50 q(x50 x50Var, Object obj) {
        ee2 ee2Var = new ee2(this.s, this.t, this.u, x50Var);
        ee2Var.n = obj;
        return ee2Var;
    }

    @Override // defpackage.pk
    public final Object s(Object obj) throws Throwable {
        he2 he2Var;
        s42 s42Var;
        he2 he2Var2;
        long j;
        int i = this.k;
        js1 js1Var = js1.b;
        int i2 = 1;
        if (i == 0) {
            bz3.g(obj);
            fe2 fe2Var = (fe2) this.n;
            he2Var = this.s;
            z91 z91Var = new z91(i2, he2Var, fe2Var);
            ka0 ka0Var = he2Var.c;
            s42Var = this.t;
            long j2 = s42Var.a;
            js1 js1Var2 = he2Var.d;
            long j3 = this.u;
            float fD = he2Var.d(js1Var2 == js1Var ? x63.b(j3) : x63.c(j3));
            this.n = he2Var;
            this.f = he2Var;
            this.i = s42Var;
            this.j = j2;
            this.k = 1;
            ka0Var.getClass();
            obj = uf4.d(ka0Var.b, new ja0(fD, ka0Var, z91Var, null), this);
            t70 t70Var = t70.a;
            if (obj == t70Var) {
                return t70Var;
            }
            he2Var2 = he2Var;
            j = j2;
        } else {
            if (i != 1) {
                og.n("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            j = this.j;
            s42Var = this.i;
            he2Var = this.f;
            he2Var2 = (he2) this.n;
            bz3.g(obj);
        }
        float fD2 = he2Var2.d(((Number) obj).floatValue());
        s42Var.a = he2Var.d == js1Var ? x63.a(j, fD2, 0.0f, 2) : x63.a(j, 0.0f, fD2, 1);
        return q43.a;
    }
}
