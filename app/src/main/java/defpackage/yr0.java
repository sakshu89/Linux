package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class yr0 {
    public final int a;
    public final String b;

    public yr0(int i, String str) {
        this.a = i;
        this.b = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof yr0)) {
            return false;
        }
        yr0 yr0Var = (yr0) obj;
        return this.a == yr0Var.a && this.b.equals(yr0Var.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (Integer.hashCode(this.a) * 31);
    }

    public final String toString() {
        return "HttpResponse(code=" + this.a + ", payload=" + this.b + ")";
    }
}
