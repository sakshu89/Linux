package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class yi {
    public final vg0 a;
    public final vg0 b;
    public final int c;
    public final int d;

    public yi(vg0 vg0Var, vg0 vg0Var2, int i, int i2) {
        this.a = vg0Var;
        this.b = vg0Var2;
        this.c = i;
        this.d = i2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof yi) {
            yi yiVar = (yi) obj;
            if (this.a == yiVar.a && this.b == yiVar.b && this.c == yiVar.c && this.d == yiVar.d) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.d ^ ((((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003) ^ this.c) * 1000003);
    }

    public final String toString() {
        return "In{edge=" + this.a + ", postviewEdge=" + this.b + ", inputFormat=" + this.c + ", outputFormat=" + this.d + "}";
    }
}
