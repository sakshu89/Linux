package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class yd2 extends nu2 implements vq0 {
    public final /* synthetic */ int f;
    public int i;
    public final /* synthetic */ ae2 j;
    public /* synthetic */ long k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ yd2(ae2 ae2Var, long j, x50 x50Var, int i) {
        super(2, x50Var);
        this.f = i;
        this.j = ae2Var;
        this.k = j;
    }

    @Override // defpackage.vq0
    public final Object e(Object obj, Object obj2) {
        int i = this.f;
        q43 q43Var = q43.a;
        switch (i) {
            case 0:
                return ((yd2) q((x50) obj2, (s70) obj)).s(q43Var);
            case 1:
                return ((yd2) q((x50) obj2, (s70) obj)).s(q43Var);
            default:
                long j = ((jp1) obj).a;
                yd2 yd2Var = new yd2(this.j, (x50) obj2);
                yd2Var.k = j;
                return yd2Var.s(q43Var);
        }
    }

    @Override // defpackage.pk
    public final x50 q(x50 x50Var, Object obj) {
        switch (this.f) {
            case 0:
                return new yd2(this.j, this.k, x50Var, 0);
            case 1:
                return new yd2(this.j, this.k, x50Var, 1);
            default:
                yd2 yd2Var = new yd2(this.j, x50Var);
                yd2Var.k = ((jp1) obj).a;
                return yd2Var;
        }
    }

    @Override // defpackage.pk
    public final Object s(Object obj) {
        int i = this.f;
        q43 q43Var = q43.a;
        ae2 ae2Var = this.j;
        t70 t70Var = t70.a;
        switch (i) {
            case 0:
                int i2 = this.i;
                if (i2 != 0) {
                    if (i2 == 1) {
                        bz3.g(obj);
                        return q43Var;
                    }
                    og.n("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                bz3.g(obj);
                he2 he2Var = ae2Var.w0;
                xd2 xd2Var = new xd2(this.k, null);
                this.i = 1;
                return he2Var.f(rm1.b, xd2Var, this) == t70Var ? t70Var : q43Var;
            case 1:
                int i3 = this.i;
                if (i3 != 0) {
                    if (i3 == 1) {
                        bz3.g(obj);
                        return q43Var;
                    }
                    og.n("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                bz3.g(obj);
                he2 he2Var2 = ae2Var.w0;
                long j = this.k;
                this.i = 1;
                return he2Var2.b(j, true, this) == t70Var ? t70Var : q43Var;
            default:
                int i4 = this.i;
                if (i4 != 0) {
                    if (i4 == 1) {
                        bz3.g(obj);
                        return obj;
                    }
                    og.n("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                bz3.g(obj);
                long j2 = this.k;
                he2 he2Var3 = ae2Var.w0;
                this.i = 1;
                Object objA = ud2.a(he2Var3, j2, this);
                return objA == t70Var ? t70Var : objA;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public yd2(ae2 ae2Var, x50 x50Var) {
        super(2, x50Var);
        this.f = 2;
        this.j = ae2Var;
    }
}
