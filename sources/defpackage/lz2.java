package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class lz2 {
    public static final lz2 c = new lz2(2, false);
    public static final lz2 d = new lz2(1, true);
    public final int a;
    public final boolean b;

    public lz2(int i, boolean z) {
        this.a = i;
        this.b = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof lz2)) {
            return false;
        }
        lz2 lz2Var = (lz2) obj;
        return this.a == lz2Var.a && this.b == lz2Var.b;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.b) + (Integer.hashCode(this.a) * 31);
    }

    public final String toString() {
        if (equals(c)) {
            return "TextMotion.Static";
        }
        return equals(d) ? "TextMotion.Animated" : "Invalid";
    }
}
