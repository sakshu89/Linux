package defpackage;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class dq2 {
    public final jq2 a;
    public final List b;
    public final String c;

    public dq2(jq2 jq2Var, List list, String str) {
        this.a = jq2Var;
        this.b = list;
        this.c = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof dq2)) {
            return false;
        }
        dq2 dq2Var = (dq2) obj;
        return this.a.equals(dq2Var.a) && this.b.equals(dq2Var.b) && this.c.equals(dq2Var.c);
    }

    public final int hashCode() {
        return this.c.hashCode() + ((this.b.hashCode() + (this.a.hashCode() * 31)) * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("ClickRequest(frame=");
        sb.append(this.a);
        sb.append(", key=");
        sb.append(this.b);
        sb.append(", control=");
        return cq.n(sb, this.c, ")");
    }
}
