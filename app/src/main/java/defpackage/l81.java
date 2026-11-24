package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class l81 {
    public final int a;
    public final int b;

    public l81(int i, int i2) {
        this.a = i;
        this.b = i2;
        if (!(i >= 0)) {
            c11.a("negative start index");
        }
        if (i2 >= i) {
            return;
        }
        c11.a("end index greater than start");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof l81)) {
            return false;
        }
        l81 l81Var = (l81) obj;
        return this.a == l81Var.a && this.b == l81Var.b;
    }

    public final int hashCode() {
        return Integer.hashCode(this.b) + (Integer.hashCode(this.a) * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Interval(start=");
        sb.append(this.a);
        sb.append(", end=");
        return ky0.m(sb, this.b, ')');
    }
}
