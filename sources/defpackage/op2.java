package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class op2 {
    public final np2 a;
    public final String b;
    public final String c;
    public final boolean d;
    public final boolean e;

    public op2(np2 np2Var, String str, String str2, boolean z, boolean z2) {
        np2Var.getClass();
        str.getClass();
        str2.getClass();
        this.a = np2Var;
        this.b = str;
        this.c = str2;
        this.d = z;
        this.e = z2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof op2)) {
            return false;
        }
        op2 op2Var = (op2) obj;
        return this.a == op2Var.a && g31.a(this.b, op2Var.b) && g31.a(this.c, op2Var.c) && this.d == op2Var.d && this.e == op2Var.e;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.e) + ky0.e(ky0.d(ky0.d(this.a.hashCode() * 31, 31, this.b), 31, this.c), 31, this.d);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("SpecialGrant(access=");
        sb.append(this.a);
        sb.append(", title=");
        sb.append(this.b);
        sb.append(", why=");
        sb.append(this.c);
        sb.append(", granted=");
        sb.append(this.d);
        sb.append(", optional=");
        return ky0.o(sb, this.e, ")");
    }
}
