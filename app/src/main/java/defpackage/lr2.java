package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class lr2 extends nu2 implements vq0 {
    public final /* synthetic */ int f = 1;
    public float i;
    public int j;
    public /* synthetic */ Object k;
    public final /* synthetic */ Object n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public lr2(ux uxVar, float f, pd pdVar, x50 x50Var) {
        super(2, x50Var);
        this.k = uxVar;
        this.i = f;
        this.n = pdVar;
    }

    @Override // defpackage.vq0
    public final Object e(Object obj, Object obj2) {
        int i = this.f;
        q43 q43Var = q43.a;
        s70 s70Var = (s70) obj;
        x50 x50Var = (x50) obj2;
        switch (i) {
            case 0:
                break;
        }
        return ((lr2) q(x50Var, s70Var)).s(q43Var);
    }

    @Override // defpackage.pk
    public final x50 q(x50 x50Var, Object obj) {
        int i = this.f;
        Object obj2 = this.n;
        switch (i) {
            case 0:
                return new lr2((ux) this.k, this.i, (pd) obj2, x50Var);
            default:
                lr2 lr2Var = new lr2((j23) obj2, x50Var);
                lr2Var.k = obj;
                return lr2Var;
        }
    }

    @Override // defpackage.pk
    public final Object s(Object obj) {
        final float fE;
        s70 s70Var;
        int i = this.f;
        q43 q43Var = q43.a;
        Object obj2 = this.n;
        t70 t70Var = t70.a;
        switch (i) {
            case 0:
                int i2 = this.j;
                if (i2 == 0) {
                    bz3.g(obj);
                    this.j = 1;
                    return bd.c((bd) ((ux) this.k).c, new Float(this.i), (pd) obj2, null, this, 12) == t70Var ? t70Var : q43Var;
                }
                if (i2 == 1) {
                    bz3.g(obj);
                    return q43Var;
                }
                og.n("call to 'resume' before 'invoke' with coroutine");
                return null;
            default:
                int i3 = this.j;
                if (i3 == 0) {
                    bz3.g(obj);
                    s70 s70Var2 = (s70) this.k;
                    fE = ya4.e(s70Var2.o());
                    s70Var = s70Var2;
                } else {
                    if (i3 != 1) {
                        og.n("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    fE = this.i;
                    s70Var = (s70) this.k;
                    bz3.g(obj);
                }
                while (tl4.d(s70Var)) {
                    final j23 j23Var = (j23) obj2;
                    hq0 hq0Var = new hq0() { // from class: i23
                        @Override // defpackage.hq0
                        public final Object j(Object obj3) {
                            long jLongValue = ((Long) obj3).longValue();
                            j23 j23Var2 = j23Var;
                            boolean zG = j23Var2.g();
                            iu1 iu1Var = j23Var2.g;
                            if (!zG) {
                                if (iu1Var.g() == Long.MIN_VALUE) {
                                    iu1Var.h(jLongValue);
                                    ((ku1) j23Var2.a.b).setValue(Boolean.TRUE);
                                }
                                long jG = jLongValue - iu1Var.g();
                                float f = fE;
                                if (f != 0.0f) {
                                    double d = jG / ((double) f);
                                    if (Double.isNaN(d)) {
                                        og.i("Cannot round NaN value.");
                                        return null;
                                    }
                                    jG = Math.round(d);
                                }
                                if (j23Var2.b == null) {
                                    j23Var2.f.h(jG);
                                }
                                j23Var2.h(jG, f == 0.0f);
                            }
                            return q43.a;
                        }
                    };
                    this.k = s70Var;
                    this.i = fE;
                    this.j = 1;
                    j70 j70Var = this.b;
                    j70Var.getClass();
                    if (or4.a(j70Var).a(hq0Var, this) == t70Var) {
                        return t70Var;
                    }
                }
                return q43Var;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public lr2(j23 j23Var, x50 x50Var) {
        super(2, x50Var);
        this.n = j23Var;
    }
}
