package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class iq2 {
    public final tq2 a;
    public final dq2 b;

    public iq2(tq2 tq2Var, dq2 dq2Var, int i) {
        tq2Var = (i & 1) != 0 ? null : tq2Var;
        dq2Var = (i & 2) != 0 ? null : dq2Var;
        this.a = tq2Var;
        this.b = dq2Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof iq2)) {
            return false;
        }
        iq2 iq2Var = (iq2) obj;
        return g31.a(this.a, iq2Var.a) && g31.a(this.b, iq2Var.b);
    }

    public final int hashCode() {
        tq2 tq2Var = this.a;
        int iHashCode = (tq2Var == null ? 0 : tq2Var.hashCode()) * 31;
        dq2 dq2Var = this.b;
        return iHashCode + (dq2Var != null ? dq2Var.hashCode() : 0);
    }

    public final String toString() {
        return "Decision(result=" + this.a + ", request=" + this.b + ")";
    }
}
