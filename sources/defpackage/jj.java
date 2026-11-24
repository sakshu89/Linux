package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class jj {
    public final xt2 a;

    public jj(xt2 xt2Var) {
        this.a = xt2Var;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof jj) && this.a == ((jj) obj).a;
    }

    public final int hashCode() {
        return this.a.hashCode() ^ (-721379959);
    }

    public final String toString() {
        return "Event{eventCode=0, surfaceOutput=" + this.a + "}";
    }
}
