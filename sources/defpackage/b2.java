package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class b2 {
    public final String a;
    public final rq0 b;

    public b2(String str, rq0 rq0Var) {
        this.a = str;
        this.b = rq0Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b2)) {
            return false;
        }
        b2 b2Var = (b2) obj;
        return g31.a(this.a, b2Var.a) && g31.a(this.b, b2Var.b);
    }

    public final int hashCode() {
        String str = this.a;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        rq0 rq0Var = this.b;
        return iHashCode + (rq0Var != null ? rq0Var.hashCode() : 0);
    }

    public final String toString() {
        return "AccessibilityAction(label=" + this.a + ", action=" + this.b + ')';
    }
}
