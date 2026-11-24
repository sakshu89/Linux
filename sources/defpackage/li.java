package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class li {
    public final wi a;
    public final int b;

    public li(wi wiVar, int i) {
        if (wiVar == null) {
            dk0.n("Null packet");
            throw null;
        }
        this.a = wiVar;
        this.b = i;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof li) {
            li liVar = (li) obj;
            if (this.a.equals(liVar.a) && this.b == liVar.b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.b ^ ((this.a.hashCode() ^ 1000003) * 1000003);
    }

    public final String toString() {
        return "In{packet=" + this.a + ", jpegQuality=" + this.b + "}";
    }
}
