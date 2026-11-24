package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class dw {
    public jc0 a;
    public z61 b;
    public cw c;
    public long d;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof dw)) {
            return false;
        }
        dw dwVar = (dw) obj;
        return g31.a(this.a, dwVar.a) && this.b == dwVar.b && g31.a(this.c, dwVar.c) && xk2.a(this.d, dwVar.d);
    }

    public final int hashCode() {
        return Long.hashCode(this.d) + ((this.c.hashCode() + ((this.b.hashCode() + (this.a.hashCode() * 31)) * 31)) * 31);
    }

    public final String toString() {
        return "DrawParams(density=" + this.a + ", layoutDirection=" + this.b + ", canvas=" + this.c + ", size=" + ((Object) xk2.d(this.d)) + ')';
    }
}
