package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class yd {
    public final Object a;
    public final int b;
    public final int c;
    public final String d;

    public yd(Object obj, int i, int i2, String str) {
        this.a = obj;
        this.b = i;
        this.c = i2;
        this.d = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof yd)) {
            return false;
        }
        yd ydVar = (yd) obj;
        return g31.a(this.a, ydVar.a) && this.b == ydVar.b && this.c == ydVar.c && g31.a(this.d, ydVar.d);
    }

    public final int hashCode() {
        Object obj = this.a;
        return this.d.hashCode() + ky0.a(this.c, ky0.a(this.b, (obj == null ? 0 : obj.hashCode()) * 31, 31), 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("MutableRange(item=");
        sb.append(this.a);
        sb.append(", start=");
        sb.append(this.b);
        sb.append(", end=");
        sb.append(this.c);
        sb.append(", tag=");
        return ky0.n(sb, this.d, ')');
    }
}
