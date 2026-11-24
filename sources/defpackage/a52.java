package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class a52 extends a54 {
    public final a54 b;
    public final int c;

    public a52(a54 a54Var, int i) {
        this.b = a54Var;
        this.c = i;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof a52)) {
            return false;
        }
        a52 a52Var = (a52) obj;
        return a52Var.b.equals(this.b) && a52Var.c == this.c;
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.c * 31);
    }
}
