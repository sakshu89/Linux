package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class sl {
    public p9 a = null;
    public u6 b = null;
    public ew c = null;
    public na d = null;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof sl)) {
            return false;
        }
        sl slVar = (sl) obj;
        return g31.a(this.a, slVar.a) && g31.a(this.b, slVar.b) && g31.a(this.c, slVar.c) && g31.a(this.d, slVar.d);
    }

    public final int hashCode() {
        p9 p9Var = this.a;
        int iHashCode = (p9Var == null ? 0 : p9Var.hashCode()) * 31;
        u6 u6Var = this.b;
        int iHashCode2 = (iHashCode + (u6Var == null ? 0 : u6Var.hashCode())) * 31;
        ew ewVar = this.c;
        int iHashCode3 = (iHashCode2 + (ewVar == null ? 0 : ewVar.hashCode())) * 31;
        na naVar = this.d;
        return iHashCode3 + (naVar != null ? naVar.hashCode() : 0);
    }

    public final String toString() {
        return "BorderCache(imageBitmap=" + this.a + ", canvas=" + this.b + ", canvasDrawScope=" + this.c + ", borderPath=" + this.d + ')';
    }
}
