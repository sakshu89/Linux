package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public interface e83 {
    default b83 a(Class cls) {
        throw new UnsupportedOperationException("`Factory.create(String, CreationExtras)` is not implemented. You may need to override the method and provide a custom implementation. Note that using `Factory.create(String)` is not supported and considered an error.");
    }

    default b83 b(Class cls, jl1 jl1Var) {
        return a(cls);
    }

    default b83 c(dy dyVar, jl1 jl1Var) {
        return b(jp4.a(dyVar), jl1Var);
    }
}
