package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ez {
    public final String a;
    public final int b;
    public final int c;

    public ez(String str, int i, int i2) {
        this.a = str;
        this.b = i;
        this.c = i2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ez)) {
            return false;
        }
        ez ezVar = (ez) obj;
        return this.a.equals(ezVar.a) && this.b == ezVar.b && this.c == ezVar.c;
    }

    public final int hashCode() {
        return Integer.hashCode(this.c) + ky0.a(this.b, this.a.hashCode() * 31, 31);
    }

    public final String toString() {
        return "CloudUsage(day=" + this.a + ", calls=" + this.b + ", limit=" + this.c + ")";
    }
}
