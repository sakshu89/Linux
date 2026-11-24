package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class zc3 {
    public final int a;
    public final String b;

    public zc3(int i, String str) {
        this.a = i;
        this.b = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zc3)) {
            return false;
        }
        zc3 zc3Var = (zc3) obj;
        return this.a == zc3Var.a && this.b.equals(zc3Var.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (Integer.hashCode(this.a) * 31);
    }

    public final String toString() {
        return "HttpResponse(code=" + this.a + ", body=" + this.b + ")";
    }
}
