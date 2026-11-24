package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ch1 {
    public final String a;
    public final h21 b;

    public ch1(String str, h21 h21Var) {
        this.a = str;
        this.b = h21Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ch1)) {
            return false;
        }
        ch1 ch1Var = (ch1) obj;
        return this.a.equals(ch1Var.a) && this.b.equals(ch1Var.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.a.hashCode() * 31);
    }

    public final String toString() {
        return "MatchGroup(value=" + this.a + ", range=" + this.b + ')';
    }
}
