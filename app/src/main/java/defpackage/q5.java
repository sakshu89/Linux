package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class q5 {
    public final int a;
    public final int b;
    public final long c;
    public final long d;

    public q5(int i, int i2, long j, long j2) {
        this.a = i;
        this.b = i2;
        this.c = j;
        this.d = j2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof q5)) {
            return false;
        }
        q5 q5Var = (q5) obj;
        return this.a == q5Var.a && this.b == q5Var.b && this.c == q5Var.c && this.d == q5Var.d;
    }

    public final int hashCode() {
        return Long.hashCode(this.d) + cq.c(ky0.a(this.b, Integer.hashCode(this.a) * 31, 31), 31, this.c);
    }

    public final String toString() {
        StringBuilder sbP = cq.p("RequestedAlarm(hour=", this.a, ", minute=", this.b, ", expected=");
        sbP.append(this.c);
        sbP.append(", requestedAt=");
        sbP.append(this.d);
        sbP.append(")");
        return sbP.toString();
    }
}
