package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class iz1 {
    public final String a;

    public iz1(String str) {
        str.getClass();
        this.a = str;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof iz1)) {
            return false;
        }
        return g31.a(this.a, ((iz1) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return this.a;
    }
}
