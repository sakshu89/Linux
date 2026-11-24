package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class w63 {
    public final vd a;
    public final tg0 b;

    public w63(vd vdVar, tg0 tg0Var) {
        this.a = vdVar;
        this.b = tg0Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof w63)) {
            return false;
        }
        w63 w63Var = (w63) obj;
        return g31.a(this.a, w63Var.a) && g31.a(this.b, w63Var.b);
    }

    public final int hashCode() {
        return Integer.hashCode(0) + ((this.b.hashCode() + (this.a.hashCode() * 31)) * 31);
    }

    public final String toString() {
        return "VectorizedKeyframeSpecElementInfo(vectorValue=" + this.a + ", easing=" + this.b + ", arcMode=ArcMode(value=0))";
    }
}
