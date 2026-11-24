package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class a81 {
    public final /* synthetic */ int a;
    public final /* synthetic */ b81 b;
    public final /* synthetic */ Object c;

    public /* synthetic */ a81(b81 b81Var, Object obj, int i) {
        this.a = i;
        this.b = b81Var;
        this.c = obj;
    }

    public t71 b() {
        b81 b81Var = this.b;
        n71 n71Var = (n71) b81Var.s.g(this.c);
        if (n71Var != null) {
            return (t71) b81Var.i.g(n71Var);
        }
        return null;
    }

    public final boolean c() {
        kv1 kv1Var;
        switch (this.a) {
            case 0:
                return true;
            default:
                t71 t71VarB = b();
                if (t71VarB == null || (kv1Var = t71VarB.f) == null) {
                    return true;
                }
                return kv1Var.c();
        }
    }

    private final void a() {
    }
}
