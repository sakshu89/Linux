package defpackage;

import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class yx {
    public final String a;
    public final String b;
    public final List c;
    public final String d;
    public final Map e;

    public yx(String str, String str2, List list, String str3, Map map) {
        str.getClass();
        str2.getClass();
        str3.getClass();
        map.getClass();
        this.a = str;
        this.b = str2;
        this.c = list;
        this.d = str3;
        this.e = map;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof yx)) {
            return false;
        }
        yx yxVar = (yx) obj;
        return g31.a(this.a, yxVar.a) && g31.a(this.b, yxVar.b) && this.c.equals(yxVar.c) && g31.a(this.d, yxVar.d) && g31.a(this.e, yxVar.e);
    }

    public final int hashCode() {
        return this.e.hashCode() + ky0.d((this.c.hashCode() + ky0.d(this.a.hashCode() * 31, 31, this.b)) * 31, 31, this.d);
    }

    public final String toString() {
        StringBuilder sbQ = cq.q("Clarification(question=", this.a, ", slotKey=", this.b, ", options=");
        sbQ.append(this.c);
        sbQ.append(", pendingAction=");
        sbQ.append(this.d);
        sbQ.append(", resolvedSlots=");
        sbQ.append(this.e);
        sbQ.append(")");
        return sbQ.toString();
    }
}
