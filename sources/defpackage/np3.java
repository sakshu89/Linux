package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class np3 extends pp3 {
    public static final np3 a = new np3();

    @Override // defpackage.pp3
    public final Object a() {
        throw new IllegalStateException("Optional.get() cannot be called on an absent value");
    }

    @Override // defpackage.pp3
    public final Object b() {
        return "";
    }

    @Override // defpackage.pp3
    public final boolean c() {
        return false;
    }

    @Override // defpackage.pp3
    public final boolean equals(Object obj) {
        return obj == this;
    }

    @Override // defpackage.pp3
    public final int hashCode() {
        return 2040732332;
    }

    public final String toString() {
        return "Optional.absent()";
    }
}
