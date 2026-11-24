package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class fl2 implements jl2 {
    public final String a;
    public final String b;
    public final h52 c;
    public final boolean d;

    public fl2(String str, String str2, h52 h52Var, boolean z) {
        str2.getClass();
        this.a = str;
        this.b = str2;
        this.c = h52Var;
        this.d = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof fl2)) {
            return false;
        }
        fl2 fl2Var = (fl2) obj;
        return g31.a(this.a, fl2Var.a) && g31.a(this.b, fl2Var.b) && g31.a(this.c, fl2Var.c) && this.d == fl2Var.d;
    }

    public final int hashCode() {
        int iD = ky0.d(this.a.hashCode() * 31, 31, this.b);
        h52 h52Var = this.c;
        return Boolean.hashCode(this.d) + ((iD + (h52Var == null ? 0 : h52Var.hashCode())) * 31);
    }

    public final String toString() {
        StringBuilder sbQ = cq.q("Failed(spoken=", this.a, ", reason=", this.b, ", remedy=");
        sbQ.append(this.c);
        sbQ.append(", recoverable=");
        sbQ.append(this.d);
        sbQ.append(")");
        return sbQ.toString();
    }

    public /* synthetic */ fl2(String str, String str2, g52 g52Var, boolean z, int i) {
        this(str, str2, (i & 4) != 0 ? null : g52Var, (i & 8) != 0 ? true : z);
    }
}
