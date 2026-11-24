package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class y93 {
    public final String a;
    public final String b;
    public final String c;

    public y93(String str, String str2, String str3) {
        this.a = str;
        this.b = str2;
        this.c = str3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof y93)) {
            return false;
        }
        y93 y93Var = (y93) obj;
        return this.a.equals(y93Var.a) && this.b.equals(y93Var.b) && this.c.equals(y93Var.c);
    }

    public final int hashCode() {
        return this.c.hashCode() + ky0.d(this.a.hashCode() * 31, 31, this.b);
    }

    public final String toString() {
        return cq.n(cq.q("WhatsAppDraftSnapshot(title=", this.a, ", body=", this.b, ", packageName="), this.c, ")");
    }
}
