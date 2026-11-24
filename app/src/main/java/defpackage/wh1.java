package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class wh1 implements zh1 {
    public final String a;
    public final ro1 b;

    public wh1(ro1 ro1Var, String str) {
        this.a = str;
        this.b = ro1Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof wh1)) {
            return false;
        }
        wh1 wh1Var = (wh1) obj;
        return this.a.equals(wh1Var.a) && this.b.equals(wh1Var.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.a.hashCode() * 31);
    }

    public final String toString() {
        return "Dispatched(reason=" + this.a + ", nowPlaying=" + this.b + ")";
    }
}
