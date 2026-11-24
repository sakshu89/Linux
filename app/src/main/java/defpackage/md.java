package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public interface md {
    Object a(long j);

    long b();

    g33 c();

    Object d();

    vd e(long j);

    default boolean f(long j) {
        return j >= b();
    }

    boolean isInfinite();
}
