package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class al0 {
    public final yl0 a;

    public al0(yl0 yl0Var) {
        this.a = yl0Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof al0) {
            return Float.compare(0.0f, 0.0f) == 0 && g31.a(this.a, ((al0) obj).a);
        }
        return false;
    }

    public final int hashCode() {
        return this.a.hashCode() + (Float.hashCode(0.0f) * 31);
    }

    public final String toString() {
        return "Fade(alpha=0.0, animationSpec=" + this.a + ')';
    }
}
