package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class i21 {
    public static final i21 e = new i21(0, 0, 0, 0);
    public final int a;
    public final int b;
    public final int c;
    public final int d;

    public i21(int i, int i2, int i3, int i4) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i21)) {
            return false;
        }
        i21 i21Var = (i21) obj;
        return this.a == i21Var.a && this.b == i21Var.b && this.c == i21Var.c && this.d == i21Var.d;
    }

    public final int hashCode() {
        return Integer.hashCode(this.d) + ky0.a(this.c, ky0.a(this.b, Integer.hashCode(this.a) * 31, 31), 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("IntRect.fromLTRB(");
        sb.append(this.a);
        sb.append(", ");
        sb.append(this.b);
        sb.append(", ");
        sb.append(this.c);
        sb.append(", ");
        return ky0.m(sb, this.d, ')');
    }
}
