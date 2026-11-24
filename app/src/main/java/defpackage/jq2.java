package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class jq2 {
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;

    public jq2(int i, int i2, int i3, int i4, int i5) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
        this.e = i5;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof jq2)) {
            return false;
        }
        jq2 jq2Var = (jq2) obj;
        return this.a == jq2Var.a && this.b == jq2Var.b && this.c == jq2Var.c && this.d == jq2Var.d && this.e == jq2Var.e;
    }

    public final int hashCode() {
        return Integer.hashCode(this.e) + ky0.a(this.d, ky0.a(this.c, ky0.a(this.b, Integer.hashCode(this.a) * 31, 31), 31), 31);
    }

    public final String toString() {
        StringBuilder sbP = cq.p("Frame(windowId=", this.a, ", left=", this.b, ", top=");
        sbP.append(this.c);
        sbP.append(", right=");
        sbP.append(this.d);
        sbP.append(", bottom=");
        sbP.append(this.e);
        sbP.append(")");
        return sbP.toString();
    }
}
