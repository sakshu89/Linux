package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ae {
    public final Object a;
    public final int b;
    public final int c;
    public final String d;

    public ae(Object obj, int i, int i2, String str) {
        this.a = obj;
        this.b = i;
        this.c = i2;
        this.d = str;
        if (i <= i2) {
            return;
        }
        a11.a("Reversed range is not supported");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ae)) {
            return false;
        }
        ae aeVar = (ae) obj;
        return g31.a(this.a, aeVar.a) && this.b == aeVar.b && this.c == aeVar.c && g31.a(this.d, aeVar.d);
    }

    public final int hashCode() {
        Object obj = this.a;
        return this.d.hashCode() + ky0.a(this.c, ky0.a(this.b, (obj == null ? 0 : obj.hashCode()) * 31, 31), 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Range(item=");
        sb.append(this.a);
        sb.append(", start=");
        sb.append(this.b);
        sb.append(", end=");
        sb.append(this.c);
        sb.append(", tag=");
        return ky0.n(sb, this.d, ')');
    }

    public ae(Object obj, int i, int i2) {
        this(obj, i, i2, "");
    }
}
