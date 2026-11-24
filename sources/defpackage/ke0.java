package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ke0 extends k61 implements hq0 {
    public final /* synthetic */ int b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ Object e;
    public final /* synthetic */ Object f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ke0(Object obj, Object obj2, Object obj3, int i) {
        super(1);
        this.b = i;
        this.c = obj;
        this.e = obj2;
        this.f = obj3;
    }

    @Override // defpackage.hq0
    public final Object j(Object obj) {
        long j;
        boolean zBooleanValue;
        int i = this.b;
        Object obj2 = this.f;
        Object obj3 = this.e;
        Object obj4 = this.c;
        switch (i) {
            case 0:
                t23 t23Var = (t23) obj;
                le0 le0Var = (le0) t23Var;
                if (!((c9) ((r7) cm4.h((le0) obj3)).m35getDragAndDropManager()).b.contains(le0Var) || !km4.a(le0Var, lm4.a((q82) obj2))) {
                    return s23.a;
                }
                ((t42) obj4).a = t23Var;
                return s23.c;
            case 1:
                r72 r72Var = (r72) obj;
                gr2 gr2Var = (gr2) obj3;
                gr2 gr2Var2 = (gr2) obj4;
                r72Var.d(gr2Var2 != null ? ((Number) gr2Var2.getValue()).floatValue() : 1.0f);
                r72Var.h(gr2Var != null ? ((Number) gr2Var.getValue()).floatValue() : 1.0f);
                r72Var.i(gr2Var != null ? ((Number) gr2Var.getValue()).floatValue() : 1.0f);
                gr2 gr2Var3 = (gr2) obj2;
                if (gr2Var3 != null) {
                    ((y13) gr2Var3.getValue()).getClass();
                    j = 0;
                } else {
                    j = y13.a;
                }
                r72Var.o(j);
                return q43.a;
            default:
                ko0 ko0Var = (ko0) obj;
                if (g31.a(ko0Var, (ko0) obj4)) {
                    zBooleanValue = false;
                } else {
                    if (g31.a(ko0Var, ((do0) obj3).c)) {
                        og.n("Focus search landed at the root.");
                        return null;
                    }
                    zBooleanValue = ((Boolean) ((hq0) obj2).j(ko0Var)).booleanValue();
                }
                return Boolean.valueOf(zBooleanValue);
        }
    }
}
