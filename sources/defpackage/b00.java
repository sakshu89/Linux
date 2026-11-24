package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class b00 {
    public final String a;
    public final long b;
    public final int c;

    public b00(int i, long j, String str) {
        this.a = str;
        this.b = j;
        this.c = i;
        if (str.length() == 0) {
            og.i("The name of a color space cannot be null and must contain at least 1 character");
            throw null;
        }
        if (i < -1 || i > 63) {
            og.i("The id must be between -1 and 63");
            throw null;
        }
    }

    public abstract float a(int i);

    public abstract float b(int i);

    public boolean c() {
        return false;
    }

    public abstract long d(float f, float f2, float f3);

    public abstract float e(float f, float f2, float f3);

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        b00 b00Var = (b00) obj;
        if (this.c == b00Var.c && this.a.equals(b00Var.a)) {
            return mi4.a(this.b, b00Var.b);
        }
        return false;
    }

    public abstract long f(float f, float f2, float f3, float f4, b00 b00Var);

    public int hashCode() {
        return cq.c(this.a.hashCode() * 31, 31, this.b) + this.c;
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(this.a);
        sb.append(" (id=");
        sb.append(this.c);
        sb.append(", model=");
        long j = this.b;
        if (mi4.a(j, 12884901888L)) {
            str = "Rgb";
        } else if (mi4.a(j, 12884901889L)) {
            str = "Xyz";
        } else if (mi4.a(j, 12884901890L)) {
            str = "Lab";
        } else {
            str = mi4.a(j, 17179869187L) ? "Cmyk" : "Unknown";
        }
        sb.append((Object) str);
        sb.append(')');
        return sb.toString();
    }
}
