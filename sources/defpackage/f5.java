package defpackage;

import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class f5 {
    public final String a;
    public final Map b;
    public final float c;
    public final q21 d;
    public final String e;

    public f5(String str, Map map, float f, q21 q21Var, String str2) {
        str.getClass();
        str2.getClass();
        this.a = str;
        this.b = map;
        this.c = f;
        this.d = q21Var;
        this.e = str2;
        if (0.0f > f || f > 1.0f) {
            throw new IllegalArgumentException(("confidence must be in 0..1, was " + f).toString());
        }
    }

    public static f5 a(f5 f5Var, String str, Map map, int i) {
        if ((i & 1) != 0) {
            str = f5Var.a;
        }
        String str2 = str;
        if ((i & 2) != 0) {
            map = f5Var.b;
        }
        Map map2 = map;
        float f = f5Var.c;
        q21 q21Var = (i & 8) != 0 ? f5Var.d : q21.c;
        String str3 = f5Var.e;
        f5Var.getClass();
        str2.getClass();
        map2.getClass();
        str3.getClass();
        return new f5(str2, map2, f, q21Var, str3);
    }

    public final Integer b(String str) {
        String strC = c(str);
        if (strC != null) {
            return js2.l(10, strC);
        }
        return null;
    }

    public final String c(String str) {
        String str2 = (String) this.b.get(str);
        if (str2 == null || cs2.A(str2)) {
            return null;
        }
        return str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f5)) {
            return false;
        }
        f5 f5Var = (f5) obj;
        return g31.a(this.a, f5Var.a) && this.b.equals(f5Var.b) && Float.compare(this.c, f5Var.c) == 0 && this.d == f5Var.d && g31.a(this.e, f5Var.e);
    }

    public final int hashCode() {
        return this.e.hashCode() + ((this.d.hashCode() + cq.b((this.b.hashCode() + (this.a.hashCode() * 31)) * 31, this.c, 31)) * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("AgentIntent(action=");
        sb.append(this.a);
        sb.append(", slots=");
        sb.append(this.b);
        sb.append(", confidence=");
        sb.append(this.c);
        sb.append(", source=");
        sb.append(this.d);
        sb.append(", utterance=");
        return cq.n(sb, this.e, ")");
    }
}
