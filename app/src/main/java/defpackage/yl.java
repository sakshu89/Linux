package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class yl {
    public final float a;
    public final cn2 b;

    public yl(float f, cn2 cn2Var) {
        this.a = f;
        this.b = cn2Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof yl)) {
            return false;
        }
        yl ylVar = (yl) obj;
        return de0.b(this.a, ylVar.a) && this.b.equals(ylVar.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (Float.hashCode(this.a) * 31);
    }

    public final String toString() {
        return "BorderStroke(width=" + ((Object) de0.c(this.a)) + ", brush=" + this.b + ')';
    }
}
