package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class b73 implements e73 {
    public final String a;
    public final String b;
    public final String c;

    public b73(String str, String str2, String str3) {
        this.a = str;
        this.b = str2;
        this.c = str3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b73)) {
            return false;
        }
        b73 b73Var = (b73) obj;
        return this.a.equals(b73Var.a) && this.b.equals(b73Var.b) && this.c.equals(b73Var.c);
    }

    public final int hashCode() {
        return this.c.hashCode() + ky0.d(this.a.hashCode() * 31, 31, this.b);
    }

    public final String toString() {
        return cq.n(cq.q("Contradicted(check=", this.a, ", expected=", this.b, ", observed="), this.c, ")");
    }
}
