package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class jw0 implements e83 {
    public static final y74 d = new y74(13);
    public final h81 a;
    public final e83 b;
    public final h4 c;

    public jw0(h81 h81Var, e83 e83Var, q82 q82Var) {
        this.a = h81Var;
        this.b = e83Var;
        this.c = new h4(1, q82Var);
    }

    @Override // defpackage.e83
    public final b83 a(Class cls) {
        if (!this.a.containsKey(cls)) {
            return this.b.a(cls);
        }
        dk0.r("`Factory.create(String, CreationExtras)` is not implemented. You may need to override the method and provide a custom implementation. Note that using `Factory.create(String)` is not supported and considered an error.");
        return null;
    }

    @Override // defpackage.e83
    public final b83 b(Class cls, jl1 jl1Var) {
        return this.a.containsKey(cls) ? this.c.b(cls, jl1Var) : this.b.b(cls, jl1Var);
    }
}
