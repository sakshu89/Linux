package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class vi0 extends k61 implements hq0 {
    public final /* synthetic */ int b;
    public final /* synthetic */ cj0 c;
    public final /* synthetic */ mk0 e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ vi0(cj0 cj0Var, mk0 mk0Var, int i) {
        super(1);
        this.b = i;
        this.c = cj0Var;
        this.e = mk0Var;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0021  */
    @Override // defpackage.hq0
    public final Object j(Object obj) {
        yl0 yl0Var;
        yl0 yl0Var2;
        int i = this.b;
        cj0 cj0Var = this.c;
        mk0 mk0Var = this.e;
        switch (i) {
            case 0:
                g23 g23Var = (g23) obj;
                si0 si0Var = si0.a;
                si0 si0Var2 = si0.b;
                if (g23Var.a(si0Var, si0Var2)) {
                    al0 al0Var = cj0Var.a.a;
                    return (al0Var == null || (yl0Var2 = al0Var.a) == null) ? yi0.a : yl0Var2;
                }
                if (!g23Var.a(si0Var2, si0.c)) {
                    return yi0.a;
                }
                al0 al0Var2 = mk0Var.a.a;
                return (al0Var2 == null || (yl0Var = al0Var2.a) == null) ? yi0.a : yl0Var;
            default:
                int iOrdinal = ((si0) obj).ordinal();
                float f = 0.0f;
                if (iOrdinal != 0) {
                    if (iOrdinal == 1) {
                        f = 1.0f;
                    } else {
                        if (iOrdinal != 2) {
                            dk0.l();
                            return null;
                        }
                        if (mk0Var.a.a == null) {
                            f = 1.0f;
                        }
                    }
                } else if (cj0Var.a.a == null) {
                    f = 1.0f;
                }
                return Float.valueOf(f);
        }
    }
}
