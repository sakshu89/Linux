package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class xd1 {
    public final long a;
    public final String b;

    public xd1(long j, String str) {
        str.getClass();
        this.a = j;
        this.b = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof xd1)) {
            return false;
        }
        xd1 xd1Var = (xd1) obj;
        return this.a == xd1Var.a && g31.a(this.b, xd1Var.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (Long.hashCode(this.a) * 31);
    }

    public final String toString() {
        return "LivePlayedActionReply(id=" + this.a + ", userRequest=" + this.b + ")";
    }
}
