package defpackage;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class wc2 {
    public final String a;
    public final String b;
    public final List c;
    public final long d;

    public wc2(String str, String str2, List list, long j) {
        str.getClass();
        str2.getClass();
        this.a = str;
        this.b = str2;
        this.c = list;
        this.d = j;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof wc2)) {
            return false;
        }
        wc2 wc2Var = (wc2) obj;
        return g31.a(this.a, wc2Var.a) && g31.a(this.b, wc2Var.b) && this.c.equals(wc2Var.c) && this.d == wc2Var.d;
    }

    public final int hashCode() {
        return Long.hashCode(this.d) + ((this.c.hashCode() + ky0.d(this.a.hashCode() * 31, 31, this.b)) * 31);
    }

    public final String toString() {
        StringBuilder sbQ = cq.q("ScreenSnapshot(packageName=", this.a, ", appLabel=", this.b, ", elements=");
        sbQ.append(this.c);
        sbQ.append(", capturedAtMs=");
        sbQ.append(this.d);
        sbQ.append(")");
        return sbQ.toString();
    }
}
