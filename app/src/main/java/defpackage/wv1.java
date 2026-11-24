package defpackage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class wv1 {
    public final String a;
    public final String b;
    public final List c;
    public final int d;
    public final long e;
    public final String f;
    public final String g;
    public final String h;

    public wv1(String str, String str2, List list, long j, String str3) {
        ArrayList arrayList = new ArrayList(nz.d(list));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            xv2 xv2Var = (xv2) it.next();
            arrayList.add(xv2Var.a + "|" + xv2Var.b);
        }
        int iHashCode = arrayList.hashCode();
        String string = UUID.randomUUID().toString();
        string.getClass();
        str.getClass();
        list.getClass();
        this.a = str;
        this.b = str2;
        this.c = list;
        this.d = iHashCode;
        this.e = j;
        this.f = "com.spotify.music";
        this.g = string;
        this.h = str3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof wv1)) {
            return false;
        }
        wv1 wv1Var = (wv1) obj;
        return g31.a(this.a, wv1Var.a) && g31.a(this.b, wv1Var.b) && g31.a(this.c, wv1Var.c) && this.d == wv1Var.d && this.e == wv1Var.e && g31.a(this.f, wv1Var.f) && g31.a(this.g, wv1Var.g) && g31.a(this.h, wv1Var.h);
    }

    public final int hashCode() {
        int iHashCode = this.a.hashCode() * 31;
        String str = this.b;
        int iD = ky0.d(ky0.d(cq.c(ky0.a(this.d, (this.c.hashCode() + ((iHashCode + (str == null ? 0 : str.hashCode())) * 31)) * 31, 31), 31, this.e), 31, this.f), 31, this.g);
        String str2 = this.h;
        return iD + (str2 != null ? str2.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sbQ = cq.q("PendingSpotifySearch(query=", this.a, ", artist=", this.b, ", candidates=");
        sbQ.append(this.c);
        sbQ.append(", fingerprint=");
        sbQ.append(this.d);
        sbQ.append(", timestamp=");
        sbQ.append(this.e);
        sbQ.append(", packageName=");
        sbQ.append(this.f);
        sbQ.append(", searchId=");
        sbQ.append(this.g);
        sbQ.append(", mediaKind=");
        sbQ.append(this.h);
        sbQ.append(")");
        return sbQ.toString();
    }
}
