package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class f72 extends pk {
    public f72(x50 x50Var) {
        super(x50Var);
        if (x50Var == null || x50Var.f() == gi0.a) {
            return;
        }
        og.i("Coroutines with restricted suspension must have EmptyCoroutineContext");
        throw null;
    }

    @Override // defpackage.x50
    public final j70 f() {
        return gi0.a;
    }
}
