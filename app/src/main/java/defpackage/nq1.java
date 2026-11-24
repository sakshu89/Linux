package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class nq1 extends k61 implements hq0 {
    public final /* synthetic */ int b;
    public final /* synthetic */ ko0 c;
    public final /* synthetic */ ko0 e;
    public final /* synthetic */ int f;
    public final /* synthetic */ ke0 i;
    public final /* synthetic */ Object j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ nq1(ko0 ko0Var, ko0 ko0Var2, Object obj, int i, ke0 ke0Var, int i2) {
        super(1);
        this.b = i2;
        this.c = ko0Var;
        this.e = ko0Var2;
        this.j = obj;
        this.f = i;
        this.i = ke0Var;
    }

    @Override // defpackage.hq0
    public final Object j(Object obj) {
        int i = this.b;
        ke0 ke0Var = this.i;
        int i2 = this.f;
        Object obj2 = this.j;
        ko0 ko0Var = this.e;
        ko0 ko0Var2 = this.c;
        switch (i) {
            case 0:
                hl hlVar = (hl) obj;
                if (ko0Var2 != ((do0) ((r7) cm4.h(ko0Var)).getFocusOwner()).f()) {
                    return Boolean.TRUE;
                }
                boolean zF = wr4.f(ko0Var, (ko0) obj2, i2, ke0Var);
                Boolean boolValueOf = Boolean.valueOf(zF);
                if (zF || !hlVar.a()) {
                    return boolValueOf;
                }
                return null;
            default:
                hl hlVar2 = (hl) obj;
                if (ko0Var2 != ((do0) ((r7) cm4.h(ko0Var)).getFocusOwner()).f()) {
                    return Boolean.TRUE;
                }
                boolean zK = nd4.k(i2, ke0Var, ko0Var, (l42) obj2);
                Boolean boolValueOf2 = Boolean.valueOf(zK);
                if (zK || !hlVar2.a()) {
                    return boolValueOf2;
                }
                return null;
        }
    }
}
