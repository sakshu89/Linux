package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class q50 {
    public final long a;
    public final long b;
    public final long c;
    public final long d;
    public final long e;

    public q50(long j, long j2, long j3, long j4, long j5) {
        this.a = j;
        this.b = j2;
        this.c = j3;
        this.d = j4;
        this.e = j5;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof q50)) {
            return false;
        }
        q50 q50Var = (q50) obj;
        return sz.c(this.a, q50Var.a) && sz.c(this.b, q50Var.b) && sz.c(this.c, q50Var.c) && sz.c(this.d, q50Var.d) && sz.c(this.e, q50Var.e);
    }

    public final int hashCode() {
        int i = sz.h;
        return Long.hashCode(this.e) + cq.c(cq.c(cq.c(Long.hashCode(this.a) * 31, 31, this.b), 31, this.c), 31, this.d);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("ContextMenuColors(backgroundColor=");
        ky0.v(this.a, sb, ", textColor=");
        ky0.v(this.b, sb, ", iconColor=");
        ky0.v(this.c, sb, ", disabledTextColor=");
        ky0.v(this.d, sb, ", disabledIconColor=");
        sb.append((Object) sz.i(this.e));
        sb.append(')');
        return sb.toString();
    }
}
