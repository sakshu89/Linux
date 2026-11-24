package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ge2 extends nu2 implements vq0 {
    public long f;
    public int i;
    public /* synthetic */ long j;
    public final /* synthetic */ he2 k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ge2(he2 he2Var, x50 x50Var) {
        super(2, x50Var);
        this.k = he2Var;
    }

    @Override // defpackage.vq0
    public final Object e(Object obj, Object obj2) {
        long j = ((x63) obj).a;
        ge2 ge2Var = new ge2(this.k, (x50) obj2);
        ge2Var.j = j;
        return ge2Var.s(q43.a);
    }

    @Override // defpackage.pk
    public final x50 q(x50 x50Var, Object obj) {
        ge2 ge2Var = new ge2(this.k, x50Var);
        ge2Var.j = ((x63) obj).a;
        return ge2Var;
    }

    /* JADX WARN: Code duplicated, block: B:22:0x006e  */
    @Override // defpackage.pk
    public final Object s(Object obj) {
        long j;
        long j2;
        long j3;
        long j4;
        long j5;
        int i = this.i;
        he2 he2Var = this.k;
        t70 t70Var = t70.a;
        if (i == 0) {
            bz3.g(obj);
            j = this.j;
            p6 p6Var = he2Var.f;
            this.j = j;
            this.i = 1;
            obj = p6Var.c(j, this);
            if (obj != t70Var) {
            }
            return t70Var;
        }
        if (i == 1) {
            j = this.j;
            bz3.g(obj);
        } else {
            if (i == 2) {
                j2 = this.f;
                j = this.j;
                bz3.g(obj);
                j3 = ((x63) obj).a;
                p6 p6Var2 = he2Var.f;
                long jD = x63.d(j2, j3);
                this.j = j;
                this.f = j3;
                this.i = 3;
                obj = p6Var2.b(jD, j3, this);
                if (obj != t70Var) {
                    j4 = j;
                    j5 = j3;
                }
                return t70Var;
            }
            if (i != 3) {
                og.n("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            j5 = this.f;
            j4 = this.j;
            bz3.g(obj);
        }
        return new x63(x63.d(j4, x63.d(j5, ((x63) obj).a)));
        long jD2 = x63.d(j, ((x63) obj).a);
        this.j = j;
        this.f = jD2;
        this.i = 2;
        obj = he2Var.a(jD2, this);
        if (obj != t70Var) {
            j2 = jD2;
            j3 = ((x63) obj).a;
            p6 p6Var3 = he2Var.f;
            long jD3 = x63.d(j2, j3);
            this.j = j;
            this.f = j3;
            this.i = 3;
            obj = p6Var3.b(jD3, j3, this);
            if (obj != t70Var) {
                j4 = j;
                j5 = j3;
                return new x63(x63.d(j4, x63.d(j5, ((x63) obj).a)));
            }
        }
        return t70Var;
    }
}
