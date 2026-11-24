package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class f82 {
    public final long a = sz.g;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof f82) {
            return sz.c(this.a, ((f82) obj).a);
        }
        return false;
    }

    public final int hashCode() {
        int i = sz.h;
        return Long.hashCode(this.a) * 31;
    }

    public final String toString() {
        return "RippleConfiguration(color=" + ((Object) sz.i(this.a)) + ", rippleAlpha=null)";
    }
}
