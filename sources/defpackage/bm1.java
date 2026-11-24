package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class bm1 extends g72 implements vq0 {
    public zt0 c;
    public cm1 e;
    public long[] f;
    public int i;
    public int j;
    public /* synthetic */ Object k;
    public final /* synthetic */ cm1 n;
    public final /* synthetic */ zt0 s;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bm1(cm1 cm1Var, zt0 zt0Var, x50 x50Var) {
        super(x50Var);
        this.n = cm1Var;
        this.s = zt0Var;
    }

    @Override // defpackage.vq0
    public final Object e(Object obj, Object obj2) {
        return ((bm1) q((x50) obj2, (yg2) obj)).s(q43.a);
    }

    @Override // defpackage.pk
    public final x50 q(x50 x50Var, Object obj) {
        bm1 bm1Var = new bm1(this.n, this.s, x50Var);
        bm1Var.k = obj;
        return bm1Var;
    }

    @Override // defpackage.pk
    public final Object s(Object obj) {
        yg2 yg2Var;
        cm1 cm1Var;
        long[] jArr;
        int i;
        zt0 zt0Var;
        int i2 = this.j;
        if (i2 == 0) {
            bz3.g(obj);
            yg2Var = (yg2) this.k;
            cm1Var = this.n;
            am1 am1Var = cm1Var.b;
            jArr = am1Var.c;
            i = am1Var.e;
            zt0Var = this.s;
        } else {
            if (i2 != 1) {
                og.n("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            i = this.i;
            jArr = this.f;
            cm1Var = this.e;
            zt0Var = this.c;
            yg2Var = (yg2) this.k;
            bz3.g(obj);
        }
        if (i == Integer.MAX_VALUE) {
            return q43.a;
        }
        int i3 = (int) ((jArr[i] >> 31) & 2147483647L);
        zt0Var.b = i;
        Object obj2 = cm1Var.b.b[i];
        this.k = yg2Var;
        this.c = zt0Var;
        this.e = cm1Var;
        this.f = jArr;
        this.i = i3;
        this.j = 1;
        yg2Var.b(this, obj2);
        return t70.a;
    }
}
