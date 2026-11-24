package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class zi {
    public final g12 a;
    public final zy0 b;

    public zi(g12 g12Var, zy0 zy0Var) {
        if (g12Var == null) {
            dk0.n("Null processingRequest");
            throw null;
        }
        this.a = g12Var;
        this.b = zy0Var;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zi)) {
            return false;
        }
        zi ziVar = (zi) obj;
        return this.a.equals(ziVar.a) && this.b.equals(ziVar.b);
    }

    public final int hashCode() {
        return this.b.hashCode() ^ ((this.a.hashCode() ^ 1000003) * 1000003);
    }

    public final String toString() {
        return "InputPacket{processingRequest=" + this.a + ", imageProxy=" + this.b + "}";
    }
}
