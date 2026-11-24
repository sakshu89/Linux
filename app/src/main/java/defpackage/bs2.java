package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class bs2 implements xd {
    public final String a;

    public final boolean equals(Object obj) {
        if (obj instanceof bs2) {
            return this.a.equals(((bs2) obj).a);
        }
        return false;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "StringAnnotation(value=" + this.a + ')';
    }
}
