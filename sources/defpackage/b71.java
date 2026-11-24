package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class b71 {
    public final int a;
    public final int b;
    public final boolean c;

    public b71(int i, int i2, boolean z) {
        this.a = i;
        this.b = i2;
        this.c = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b71)) {
            return false;
        }
        b71 b71Var = (b71) obj;
        return this.a == b71Var.a && this.b == b71Var.b && this.c == b71Var.c;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.c) + ky0.a(this.b, Integer.hashCode(this.a) * 31, 31);
    }

    public final String toString() {
        return "BidiRun(start=" + this.a + ", end=" + this.b + ", isRtl=" + this.c + ')';
    }
}
