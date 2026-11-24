package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class hl2 implements jl2 {
    public final String a;
    public final String b;
    public final e73 c;
    public final h52 d;
    public final boolean e;

    public /* synthetic */ hl2(String str, String str2, e73 e73Var, d52 d52Var, boolean z, int i) {
        this(str, str2, e73Var, (i & 8) != 0 ? null : d52Var, (i & 16) != 0 ? false : z);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof hl2)) {
            return false;
        }
        hl2 hl2Var = (hl2) obj;
        return g31.a(this.a, hl2Var.a) && g31.a(this.b, hl2Var.b) && g31.a(this.c, hl2Var.c) && g31.a(this.d, hl2Var.d) && this.e == hl2Var.e;
    }

    public final int hashCode() {
        int iHashCode = (this.c.hashCode() + ky0.d(this.a.hashCode() * 31, 31, this.b)) * 31;
        h52 h52Var = this.d;
        return Boolean.hashCode(this.e) + ((iHashCode + (h52Var == null ? 0 : h52Var.hashCode())) * 31);
    }

    public final String toString() {
        StringBuilder sbQ = cq.q("Partial(spoken=", this.a, ", limitation=", this.b, ", verification=");
        sbQ.append(this.c);
        sbQ.append(", remedy=");
        sbQ.append(this.d);
        sbQ.append(", awaitingConfirmation=");
        return ky0.o(sbQ, this.e, ")");
    }

    public hl2(String str, String str2, e73 e73Var, h52 h52Var, boolean z) {
        str.getClass();
        this.a = str;
        this.b = str2;
        this.c = e73Var;
        this.d = h52Var;
        this.e = z;
    }
}
