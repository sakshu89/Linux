package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class vh1 implements zh1 {
    public final ro1 a;
    public final String b;

    public vh1(ro1 ro1Var, String str) {
        this.a = ro1Var;
        this.b = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof vh1)) {
            return false;
        }
        vh1 vh1Var = (vh1) obj;
        return this.a.equals(vh1Var.a) && this.b.equals(vh1Var.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.a.hashCode() * 31);
    }

    public final String toString() {
        return "Confirmed(nowPlaying=" + this.a + ", evidence=" + this.b + ")";
    }
}
