package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class b12 {
    public final int a;

    public b12(int i) {
        this.a = i;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof b12) {
            return this.a == ((b12) obj).a;
        }
        return false;
    }

    public final int hashCode() {
        return this.a;
    }
}
