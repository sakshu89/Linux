package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class i92 {
    public final String a;
    public final String b;
    public final String c;
    public final boolean d;

    public i92(String str, String str2, String str3, boolean z) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i92)) {
            return false;
        }
        i92 i92Var = (i92) obj;
        return this.a.equals(i92Var.a) && this.b.equals(i92Var.b) && this.c.equals(i92Var.c) && this.d == i92Var.d;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.d) + ky0.d(ky0.d(this.a.hashCode() * 31, 31, this.b), 31, this.c);
    }

    public final String toString() {
        StringBuilder sbQ = cq.q("RuntimeGrant(permission=", this.a, ", title=", this.b, ", why=");
        sbQ.append(this.c);
        sbQ.append(", granted=");
        sbQ.append(this.d);
        sbQ.append(")");
        return sbQ.toString();
    }
}
