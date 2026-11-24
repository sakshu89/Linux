package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class xd2 extends nu2 implements vq0 {
    public final /* synthetic */ int f = 0;
    public final /* synthetic */ long i;
    public /* synthetic */ Object j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xd2(mm1 mm1Var, long j, x50 x50Var) {
        super(2, x50Var);
        this.j = mm1Var;
        this.i = j;
    }

    @Override // defpackage.vq0
    public final Object e(Object obj, Object obj2) {
        int i = this.f;
        q43 q43Var = q43.a;
        switch (i) {
            case 0:
                ((xd2) q((x50) obj2, (fe2) obj)).s(q43Var);
                break;
            default:
                ((xd2) q((x50) obj2, (s70) obj)).s(q43Var);
                break;
        }
        return q43Var;
    }

    @Override // defpackage.pk
    public final x50 q(x50 x50Var, Object obj) {
        switch (this.f) {
            case 0:
                xd2 xd2Var = new xd2(this.i, x50Var);
                xd2Var.j = obj;
                return xd2Var;
            default:
                return new xd2((mm1) this.j, this.i, x50Var);
        }
    }

    @Override // defpackage.pk
    public final Object s(Object obj) {
        int i = this.f;
        q43 q43Var = q43.a;
        long j = this.i;
        switch (i) {
            case 0:
                bz3.g(obj);
                he2 he2Var = ((fe2) this.j).a;
                he2Var.c(he2Var.k, j, 1);
                break;
            default:
                mm1 mm1Var = (mm1) this.j;
                bz3.g(obj);
                if (((b02) mm1Var.getValue()) != null) {
                    mm1Var.setValue(null);
                }
                mm1Var.setValue(new b02(j));
                break;
        }
        return q43Var;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xd2(long j, x50 x50Var) {
        super(2, x50Var);
        this.i = j;
    }
}
