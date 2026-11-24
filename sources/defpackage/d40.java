package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class d40 {
    public final String a;
    public final Boolean b;
    public final long c;

    public d40(String str, Boolean bool, long j) {
        this.a = str;
        this.b = bool;
        this.c = j;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d40)) {
            return false;
        }
        d40 d40Var = (d40) obj;
        return this.a.equals(d40Var.a) && g31.a(this.b, d40Var.b) && this.c == d40Var.c;
    }

    public final int hashCode() {
        int iHashCode = this.a.hashCode() * 31;
        Boolean bool = this.b;
        return Long.hashCode(this.c) + ((iHashCode + (bool == null ? 0 : bool.hashCode())) * 31);
    }

    public final String toString() {
        return "ConnectivityContext(lastRadio=" + this.a + ", lastTargetState=" + this.b + ", timestampMs=" + this.c + ")";
    }
}
