package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class d73 implements e73 {
    public final String a;
    public final String b;

    public d73(String str, String str2) {
        str2.getClass();
        this.a = str;
        this.b = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d73)) {
            return false;
        }
        d73 d73Var = (d73) obj;
        return this.a.equals(d73Var.a) && g31.a(this.b, d73Var.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.a.hashCode() * 31);
    }

    public final String toString() {
        return ky0.l("Verified(check=", this.a, ", observed=", this.b, ")");
    }
}
