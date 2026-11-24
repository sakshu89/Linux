package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class v10 extends p4 implements vq0 {
    public final /* synthetic */ int k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ v10(int i, Object obj, Class cls, String str, String str2, int i2, int i3) {
        super(i, i2, cls, obj, str, str2);
        this.k = i3;
    }

    @Override // defpackage.vq0
    public final Object e(Object obj, Object obj2) {
        int i = this.k;
        q43 q43Var = q43.a;
        Object obj3 = this.a;
        switch (i) {
            case 0:
                ((w10) obj3).f((x20) obj, ((Number) obj2).intValue());
                return q43Var;
            default:
                long j = ((x63) obj).a;
                ae2 ae2Var = (ae2) obj3;
                s70 s70Var = (s70) ((fq0) ae2Var.t0.c).a();
                if (s70Var == null) {
                    og.n("in order to access nested coroutine scope you need to attach dispatcher to the `Modifier.nestedScroll` first.");
                    return null;
                }
                uf4.b(s70Var, null, new yd2(ae2Var, j, null, 1), 3);
                return q43Var;
        }
    }
}
