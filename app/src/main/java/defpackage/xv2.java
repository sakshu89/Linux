package defpackage;

import android.graphics.Rect;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class xv2 {
    public final String a;
    public final String b;
    public final Rect c;

    public xv2(String str, String str2, Rect rect) {
        str.getClass();
        this.a = str;
        this.b = str2;
        this.c = rect;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof xv2)) {
            return false;
        }
        xv2 xv2Var = (xv2) obj;
        return g31.a(this.a, xv2Var.a) && g31.a(this.b, xv2Var.b) && g31.a(this.c, xv2Var.c);
    }

    public final int hashCode() {
        int iHashCode = this.a.hashCode() * 31;
        String str = this.b;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        Rect rect = this.c;
        return iHashCode2 + (rect != null ? rect.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sbQ = cq.q("TargetCandidate(title=", this.a, ", artist=", this.b, ", bounds=");
        sbQ.append(this.c);
        sbQ.append(")");
        return sbQ.toString();
    }
}
