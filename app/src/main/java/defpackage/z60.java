package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class z60 extends nu2 implements vq0 {
    public final /* synthetic */ int f;
    public /* synthetic */ Object i;
    public final /* synthetic */ Object j;
    public final /* synthetic */ Object k;
    public final /* synthetic */ Object n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ z60(Object obj, Object obj2, Object obj3, x50 x50Var, int i) {
        super(2, x50Var);
        this.f = i;
        this.j = obj;
        this.k = obj2;
        this.n = obj3;
    }

    @Override // defpackage.vq0
    public final Object e(Object obj, Object obj2) {
        int i = this.f;
        q43 q43Var = q43.a;
        switch (i) {
            case 0:
                ((z60) q((x50) obj2, (s70) obj)).s(q43Var);
                break;
            default:
                ((z60) q((x50) obj2, (dm1) obj)).s(q43Var);
                break;
        }
        return q43Var;
    }

    @Override // defpackage.pk
    public final x50 q(x50 x50Var, Object obj) {
        int i = this.f;
        Object obj2 = this.n;
        Object obj3 = this.k;
        Object obj4 = this.j;
        switch (i) {
            case 0:
                z60 z60Var = new z60((ry1) obj4, (wx2) obj3, (ny2) obj2, x50Var, 0);
                z60Var.i = obj;
                return z60Var;
            default:
                z60 z60Var2 = new z60((h61) obj4, (String) obj3, (String) obj2, x50Var, 1);
                z60Var2.i = obj;
                return z60Var2;
        }
    }

    @Override // defpackage.pk
    public final Object s(Object obj) {
        int i = this.f;
        q43 q43Var = q43.a;
        Object obj2 = this.n;
        Object obj3 = this.k;
        Object obj4 = this.j;
        switch (i) {
            case 0:
                bz3.g(obj);
                s70 s70Var = (s70) this.i;
                ry1 ry1Var = (ry1) obj4;
                x50 x50Var = null;
                uf4.b(s70Var, null, new y60(ry1Var, (wx2) obj3, x50Var, 0), 1);
                uf4.b(s70Var, null, new p0(ry1Var, (ny2) obj2, x50Var, 12), 1);
                break;
            default:
                dm1 dm1Var = (dm1) this.i;
                bz3.g(obj);
                String str = (String) obj3;
                ((h61) obj4).getClass();
                str.getClass();
                dm1Var.getClass();
                dm1Var.f(new iz1(str), (String) obj2);
                break;
        }
        return q43Var;
    }
}
