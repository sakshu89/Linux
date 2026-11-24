package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class if2 {
    public final p62 a;
    public final int b;
    public final long c;

    public if2(p62 p62Var, int i, long j) {
        this.a = p62Var;
        this.b = i;
        this.c = j;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof if2)) {
            return false;
        }
        if2 if2Var = (if2) obj;
        return this.a == if2Var.a && this.b == if2Var.b && this.c == if2Var.c;
    }

    public final int hashCode() {
        return Long.hashCode(this.c) + ky0.a(this.b, this.a.hashCode() * 31, 31);
    }

    public final String toString() {
        return "AnchorInfo(direction=" + this.a + ", offset=" + this.b + ", selectableId=" + this.c + ')';
    }
}
