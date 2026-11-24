package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ad extends nu2 implements hq0 {
    public final /* synthetic */ bd f;
    public final /* synthetic */ Object i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ad(bd bdVar, Object obj, x50 x50Var) {
        super(1, x50Var);
        this.f = bdVar;
        this.i = obj;
    }

    @Override // defpackage.hq0
    public final Object j(Object obj) {
        ad adVar = new ad(this.f, this.i, (x50) obj);
        q43 q43Var = q43.a;
        adVar.s(q43Var);
        return q43Var;
    }

    @Override // defpackage.pk
    public final Object s(Object obj) {
        bz3.g(obj);
        bd bdVar = this.f;
        bd.b(bdVar);
        Object objA = bd.a(bdVar, this.i);
        bdVar.c.b.setValue(objA);
        bdVar.e.setValue(objA);
        return q43.a;
    }
}
