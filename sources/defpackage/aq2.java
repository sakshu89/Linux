package defpackage;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class aq2 {
    public final zp2 a;
    public final ArrayList b;
    public final String c;
    public final String d;
    public final String e;

    public aq2(zp2 zp2Var, ArrayList arrayList, String str, String str2, String str3) {
        zp2Var.getClass();
        str.getClass();
        this.a = zp2Var;
        this.b = arrayList;
        this.c = str;
        this.d = str2;
        this.e = str3;
    }

    public final String a() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.c);
        String str = this.d;
        if (str != null && !cs2.A(str)) {
            sb.append(" by " + str);
        }
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof aq2)) {
            return false;
        }
        aq2 aq2Var = (aq2) obj;
        return g31.a(this.a, aq2Var.a) && this.b.equals(aq2Var.b) && g31.a(this.c, aq2Var.c) && g31.a(this.d, aq2Var.d) && this.e.equals(aq2Var.e);
    }

    public final int hashCode() {
        int iD = ky0.d((this.b.hashCode() + (this.a.hashCode() * 31)) * 31, 31, this.c);
        String str = this.d;
        return this.e.hashCode() + ((iD + (str == null ? 0 : str.hashCode())) * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Target(entry=");
        sb.append(this.a);
        sb.append(", evidence=");
        sb.append(this.b);
        sb.append(", title=");
        sb.append(this.c);
        sb.append(", artist=");
        sb.append(this.d);
        sb.append(", type=");
        return cq.n(sb, this.e, ")");
    }
}
