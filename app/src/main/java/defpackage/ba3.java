package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ba3 {
    public final String a;
    public final String b;

    public ba3(String str, String str2) {
        str.getClass();
        this.a = str;
        this.b = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ba3)) {
            return false;
        }
        ba3 ba3Var = (ba3) obj;
        return g31.a(this.a, ba3Var.a) && this.b.equals(ba3Var.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.a.hashCode() * 31);
    }

    public final String toString() {
        return ky0.l("Target(name=", this.a, ", number=", this.b, ")");
    }
}
