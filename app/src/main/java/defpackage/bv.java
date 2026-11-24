package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class bv {
    public final String a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;

    public bv(int i, int i2, int i3, String str, int i4, int i5) {
        this.a = str;
        this.b = i;
        this.c = i2;
        this.d = i3;
        this.e = i4;
        this.f = i5;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof bv)) {
            return false;
        }
        bv bvVar = (bv) obj;
        return this.a.equals(bvVar.a) && this.b == bvVar.b && this.c == bvVar.c && this.d == bvVar.d && this.e == bvVar.e && this.f == bvVar.f;
    }

    public final int hashCode() {
        return Integer.hashCode(this.f) + ky0.a(this.e, ky0.a(this.d, ky0.a(this.c, ky0.a(this.b, this.a.hashCode() * 31, 31), 31), 31), 31);
    }

    public final String toString() {
        return "Frame(packageName=" + this.a + ", windowId=" + this.b + ", left=" + this.c + ", top=" + this.d + ", right=" + this.e + ", bottom=" + this.f + ")";
    }
}
