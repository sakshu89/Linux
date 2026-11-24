package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class zw {
    public final c6 a;
    public final hq0 b;
    public final yl0 c;

    public zw(c6 c6Var, hq0 hq0Var, yl0 yl0Var) {
        this.a = c6Var;
        this.b = hq0Var;
        this.c = yl0Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zw)) {
            return false;
        }
        zw zwVar = (zw) obj;
        return g31.a(this.a, zwVar.a) && g31.a(this.b, zwVar.b) && this.c.equals(zwVar.c);
    }

    public final int hashCode() {
        return Boolean.hashCode(true) + ((this.c.hashCode() + ((this.b.hashCode() + (this.a.hashCode() * 31)) * 31)) * 31);
    }

    public final String toString() {
        return "ChangeSize(alignment=" + this.a + ", size=" + this.b + ", animationSpec=" + this.c + ", clip=true)";
    }
}
