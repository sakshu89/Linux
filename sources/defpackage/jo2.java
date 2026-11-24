package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class jo2 extends nu2 implements vq0 {
    public int f;
    public final /* synthetic */ so2 i;
    public final /* synthetic */ long j;
    public final /* synthetic */ boolean k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jo2(so2 so2Var, long j, boolean z, x50 x50Var) {
        super(2, x50Var);
        this.i = so2Var;
        this.j = j;
        this.k = z;
    }

    @Override // defpackage.vq0
    public final Object e(Object obj, Object obj2) {
        return ((jo2) q((x50) obj2, (s70) obj)).s(q43.a);
    }

    @Override // defpackage.pk
    public final x50 q(x50 x50Var, Object obj) {
        return new jo2(this.i, this.j, this.k, x50Var);
    }

    @Override // defpackage.pk
    public final Object s(Object obj) {
        Object objC;
        Object value;
        eo2 eo2Var;
        boolean z = this.k;
        q43 q43Var = q43.a;
        so2 so2Var = this.i;
        t70 t70Var = t70.a;
        int i = this.f;
        if (i == 0) {
            bz3.g(obj);
            j5 j5Var = so2Var.h;
            this.f = 1;
            objC = rn4.c(j5Var.b, this);
            if (objC == t70Var) {
                return t70Var;
            }
        } else {
            if (i != 1) {
                og.n("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            bz3.g(obj);
            objC = obj;
        }
        g5 g5Var = (g5) objC;
        if (this.j == so2Var.u) {
            l11 l11Var = vg.a;
            boolean z2 = g5Var.c;
            b60 b60Var = g5Var.d;
            Boolean bool = so2Var.s;
            if (!z || (z2 && !g31.a(bool, Boolean.FALSE))) {
                if (z && b60Var == b60.LIVE) {
                    mt0 mt0Var = so2Var.k;
                    if (mt0Var.v && ((ee1) mt0Var.l.a.getValue()).a) {
                        return q43Var;
                    }
                }
                so2Var.v = b60Var;
                so2Var.B = g5Var.h;
                jr2 jr2Var = so2Var.n;
                do {
                    value = jr2Var.getValue();
                    eo2Var = (eo2) value;
                } while (!jr2Var.h(value, eo2.a(eo2Var, null, null, null, null, null, null, null, null, false, false, false, false, false, null, eo2Var.o + 1, 16383)));
            }
        }
        return q43Var;
    }
}
