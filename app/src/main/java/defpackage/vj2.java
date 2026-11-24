package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class vj2 {
    public static final vj2 d = new vj2(7, 0);
    public final long a;
    public final long b;
    public final float c;

    public /* synthetic */ vj2(int i, long j) {
        this((i & 1) != 0 ? ki4.c(4278190080L) : j, 0L, (i & 4) != 0 ? 0.0f : 10.0f);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof vj2)) {
            return false;
        }
        vj2 vj2Var = (vj2) obj;
        return sz.c(this.a, vj2Var.a) && jp1.b(this.b, vj2Var.b) && this.c == vj2Var.c;
    }

    public final int hashCode() {
        int i = sz.h;
        return Float.hashCode(this.c) + cq.c(Long.hashCode(this.a) * 31, 31, this.b);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Shadow(color=");
        ky0.v(this.a, sb, ", offset=");
        sb.append((Object) jp1.g(this.b));
        sb.append(", blurRadius=");
        return cq.m(sb, this.c, ')');
    }

    public vj2(long j, long j2, float f) {
        this.a = j;
        this.b = j2;
        this.c = f;
    }
}
