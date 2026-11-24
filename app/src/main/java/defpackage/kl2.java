package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class kl2 {
    public final String a;
    public final String b;
    public final String c;

    public kl2(String str, String str2, String str3) {
        str.getClass();
        str2.getClass();
        str3.getClass();
        this.a = str;
        this.b = str2;
        this.c = str3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof kl2)) {
            return false;
        }
        kl2 kl2Var = (kl2) obj;
        return g31.a(this.a, kl2Var.a) && g31.a(this.b, kl2Var.b) && g31.a(this.c, kl2Var.c);
    }

    public final int hashCode() {
        return this.c.hashCode() + ky0.d(this.a.hashCode() * 31, 31, this.b);
    }

    public final String toString() {
        return cq.n(cq.q("Conflict(action=", this.a, ", winner=", this.b, ", loser="), this.c, ")");
    }
}
