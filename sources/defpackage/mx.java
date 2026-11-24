package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class mx {
    public static final lx b = new lx();
    public final Object a;

    public static final Object a(Object obj) {
        if (obj instanceof lx) {
            return null;
        }
        return obj;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof mx) {
            return g31.a(this.a, ((mx) obj).a);
        }
        return false;
    }

    public final int hashCode() {
        Object obj = this.a;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public final String toString() {
        Object obj = this.a;
        if (obj instanceof kx) {
            return ((kx) obj).toString();
        }
        return "Value(" + obj + ')';
    }
}
