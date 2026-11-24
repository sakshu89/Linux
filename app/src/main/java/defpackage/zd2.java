package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class zd2 extends nu2 implements vq0 {
    public int f;
    public final /* synthetic */ ae2 i;
    public final /* synthetic */ float j;
    public final /* synthetic */ float k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zd2(ae2 ae2Var, float f, float f2, x50 x50Var) {
        super(2, x50Var);
        this.i = ae2Var;
        this.j = f;
        this.k = f2;
    }

    @Override // defpackage.vq0
    public final Object e(Object obj, Object obj2) {
        return ((zd2) q((x50) obj2, (s70) obj)).s(q43.a);
    }

    @Override // defpackage.pk
    public final x50 q(x50 x50Var, Object obj) {
        return new zd2(this.i, this.j, this.k, x50Var);
    }

    @Override // defpackage.pk
    public final Object s(Object obj) {
        int i = this.f;
        if (i == 0) {
            bz3.g(obj);
            he2 he2Var = this.i.w0;
            long jFloatToRawIntBits = (((long) Float.floatToRawIntBits(this.j)) << 32) | (((long) Float.floatToRawIntBits(this.k)) & 4294967295L);
            this.f = 1;
            Object objA = ud2.a(he2Var, jFloatToRawIntBits, this);
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
