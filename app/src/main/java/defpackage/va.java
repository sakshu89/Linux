package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class va implements ly1 {
    public final int b;

    public va(int i) {
        this.b = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!va.class.equals(obj != null ? obj.getClass() : null)) {
            return false;
        }
        obj.getClass();
        return this.b == ((va) obj).b;
    }

    public final int hashCode() {
        return this.b;
    }

    public final String toString() {
        return ky0.m(new StringBuilder("AndroidPointerIcon(type="), this.b, ')');
    }
}
