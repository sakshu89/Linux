package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class i20 extends nu2 implements vq0 {
    public int f;
    public /* synthetic */ float i;
    public final /* synthetic */ j20 j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i20(j20 j20Var, x50 x50Var) {
        super(2, x50Var);
        this.j = j20Var;
    }

    @Override // defpackage.vq0
    public final Object e(Object obj, Object obj2) {
        return ((i20) q((x50) obj2, Float.valueOf(((Number) obj).floatValue()))).s(q43.a);
    }

    @Override // defpackage.pk
    public final x50 q(x50 x50Var, Object obj) {
        i20 i20Var = new i20(this.j, x50Var);
        i20Var.i = ((Number) obj).floatValue();
        return i20Var;
    }

    @Override // defpackage.pk
    public final Object s(Object obj) {
        int i = this.f;
        if (i == 0) {
            bz3.g(obj);
            float f = this.i;
            j20 j20Var = this.j;
            Object objG = j20Var.a.d.a.g(bg2.e);
            vq0 vq0Var = (vq0) (objG != null ? objG : null);
            if (vq0Var == null) {
                throw cq.e("Required value was null.");
            }
            jp1 jp1Var = new jp1((((long) Float.floatToRawIntBits(0.0f)) << 32) | (((long) Float.floatToRawIntBits(f)) & 4294967295L));
            this.f = 1;
            obj = vq0Var.e(jp1Var, this);
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
        return new Float(Float.intBitsToFloat((int) (((jp1) obj).a & 4294967295L)));
    }
}
