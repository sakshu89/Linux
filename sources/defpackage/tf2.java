package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class tf2 extends g72 implements vq0 {
    public int c;
    public /* synthetic */ Object e;
    public final /* synthetic */ long f;
    public final /* synthetic */ s42 i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public tf2(long j, s42 s42Var, x50 x50Var) {
        super(x50Var);
        this.f = j;
        this.i = s42Var;
    }

    @Override // defpackage.vq0
    public final Object e(Object obj, Object obj2) {
        return ((tf2) q((x50) obj2, (su2) obj)).s(q43.a);
    }

    @Override // defpackage.pk
    public final x50 q(x50 x50Var, Object obj) {
        tf2 tf2Var = new tf2(this.f, this.i, x50Var);
        tf2Var.e = obj;
        return tf2Var;
    }

    @Override // defpackage.pk
    public final Object s(Object obj) {
        su2 su2Var;
        int i = this.c;
        s42 s42Var = this.i;
        if (i == 0) {
            bz3.g(obj);
            su2 su2Var2 = (su2) this.e;
            ha haVar = new ha(11, s42Var);
            this.e = su2Var2;
            this.c = 1;
            Object objC = cf0.c(su2Var2, this.f, haVar, this);
            t70 t70Var = t70.a;
            if (objC == t70Var) {
                return t70Var;
            }
            obj = objC;
            su2Var = su2Var2;
        } else {
            if (i != 1) {
                og.n("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            su2Var = (su2) this.e;
            bz3.g(obj);
        }
        if (((ny1) obj) != null && (s42Var.a & 9223372034707292159L) != 9205357640488583168L) {
            return be0.b;
        }
        ny1 ny1Var = (ny1) mz.x(su2Var.i.Z.a);
        if (!y11.d(ny1Var)) {
            return be0.e;
        }
        ny1Var.a();
        return be0.a;
    }
}
