package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class hk implements fq0 {
    public final /* synthetic */ int a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ Object c;

    public /* synthetic */ hk(Object obj, boolean z, int i) {
        this.a = i;
        this.c = obj;
        this.b = z;
    }

    @Override // defpackage.fq0
    public final Object a() {
        km1 km1VarI;
        int i = this.a;
        q43 q43Var = q43.a;
        boolean z = this.b;
        Object obj = this.c;
        switch (i) {
            case 0:
                jk jkVar = (jk) obj;
                jkVar.a = z;
                fq0 fq0Var = jkVar.c;
                if (fq0Var != null) {
                    fq0Var.a();
                }
                break;
            case 1:
                fq0 fq0Var2 = (fq0) obj;
                if (z) {
                    fq0Var2.a();
                }
                break;
            case 2:
                ba baVar = (ba) obj;
                if (z && (km1VarI = baVar.i()) != null) {
                    ((hk2) km1VarI).q(q43Var);
                }
                break;
            case 3:
                ((hq0) obj).j(Boolean.valueOf(!z));
                break;
            default:
                so2 so2Var = (so2) obj;
                if (so2Var.o()) {
                    so2Var.p.s(new c43(z, z));
                } else if (z && so2Var.w) {
                    so2Var.q.s(new ho2(true));
                }
                break;
        }
        return q43Var;
    }

    public /* synthetic */ hk(boolean z, Object obj, int i) {
        this.a = i;
        this.b = z;
        this.c = obj;
    }
}
