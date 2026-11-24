package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class sz2 {
    public final long a;
    public final long b;

    public sz2(long j, long j2) {
        this.a = j;
        this.b = j2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof sz2)) {
            return false;
        }
        sz2 sz2Var = (sz2) obj;
        return sz.c(this.a, sz2Var.a) && sz.c(this.b, sz2Var.b);
    }

    public final int hashCode() {
        int i = sz.h;
        return Long.hashCode(this.b) + (Long.hashCode(this.a) * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("SelectionColors(selectionHandleColor=");
        ky0.v(this.a, sb, ", selectionBackgroundColor=");
        sb.append((Object) sz.i(this.b));
        sb.append(')');
        return sb.toString();
    }
}
