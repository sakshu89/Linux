package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class am2 {
    public final String a;
    public final int b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final int g;

    public am2(String str, int i, String str2, String str3, String str4, String str5, int i2) {
        this.a = str;
        this.b = i;
        this.c = str2;
        this.d = str3;
        this.e = str4;
        this.f = str5;
        this.g = i2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof am2)) {
            return false;
        }
        am2 am2Var = (am2) obj;
        return this.a.equals(am2Var.a) && this.b == am2Var.b && this.c.equals(am2Var.c) && this.d.equals(am2Var.d) && this.e.equals(am2Var.e) && this.f.equals(am2Var.f) && this.g == am2Var.g;
    }

    public final int hashCode() {
        return Integer.hashCode(this.g) + ky0.d(ky0.d(ky0.d(ky0.d(ky0.a(this.b, this.a.hashCode() * 31, 31), 31, this.c), 31, this.d), 31, this.e), 31, this.f);
    }

    public final String toString() {
        return "SmsDraftSnapshot(packageName=" + this.a + ", windowId=" + this.b + ", recipientNumber=" + this.c + ", body=" + this.d + ", composerId=" + this.e + ", sendId=" + this.f + ", matchingMessages=" + this.g + ")";
    }
}
