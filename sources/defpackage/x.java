package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class x implements mm0 {
    public final /* synthetic */ int a;
    public final /* synthetic */ mm0 b;

    public /* synthetic */ x(mm0 mm0Var, int i) {
        this.a = i;
        this.b = mm0Var;
    }

    @Override // defpackage.mm0
    public final Object a(nm0 nm0Var, x50 x50Var) {
        int i = this.a;
        q43 q43Var = q43.a;
        t70 t70Var = t70.a;
        mm0 mm0Var = this.b;
        switch (i) {
            case 0:
                Object objA = mm0Var.a(new w(nm0Var, 0), x50Var);
                return objA == t70Var ? objA : q43Var;
            default:
                Object objA2 = mm0Var.a(new w(nm0Var, 1), x50Var);
                return objA2 == t70Var ? objA2 : q43Var;
        }
    }
}
