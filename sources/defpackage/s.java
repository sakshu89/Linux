package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class s implements mm0 {
    public final /* synthetic */ int a;
    public final /* synthetic */ mm0 b;
    public final /* synthetic */ f0 c;
    public final /* synthetic */ String e;

    public /* synthetic */ s(mm0 mm0Var, f0 f0Var, String str, int i) {
        this.a = i;
        this.b = mm0Var;
        this.c = f0Var;
        this.e = str;
    }

    @Override // defpackage.mm0
    public final Object a(nm0 nm0Var, x50 x50Var) {
        int i = this.a;
        q43 q43Var = q43.a;
        t70 t70Var = t70.a;
        String str = this.e;
        f0 f0Var = this.c;
        mm0 mm0Var = this.b;
        switch (i) {
            case 0:
                Object objA = mm0Var.a(new r(nm0Var, f0Var, str, 0), x50Var);
                return objA == t70Var ? objA : q43Var;
            case 1:
                Object objA2 = mm0Var.a(new r(nm0Var, f0Var, str, 1), x50Var);
                return objA2 == t70Var ? objA2 : q43Var;
            default:
                Object objA3 = mm0Var.a(new r(nm0Var, f0Var, str, 2), x50Var);
                return objA3 == t70Var ? objA3 : q43Var;
        }
    }
}
