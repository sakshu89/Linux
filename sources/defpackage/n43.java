package defpackage;

import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class n43 {
    public final String a;
    public final Map b;
    public final String c;

    public n43(Map map, String str, String str2) {
        this.a = str;
        this.b = map;
        this.c = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof n43)) {
            return false;
        }
        n43 n43Var = (n43) obj;
        return this.a.equals(n43Var.a) && this.b.equals(n43Var.b) && this.c.equals(n43Var.c);
    }

    public final int hashCode() {
        return this.c.hashCode() + ((this.b.hashCode() + (this.a.hashCode() * 31)) * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("UndoToken(skillId=");
        sb.append(this.a);
        sb.append(", payload=");
        sb.append(this.b);
        sb.append(", describe=");
        return cq.n(sb, this.c, ")");
    }
}
