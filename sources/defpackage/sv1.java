package defpackage;

import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class sv1 {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final long e;
    public final Integer f;
    public final String g;
    public final Map h;
    public final String i;

    public sv1(String str, String str2, String str3, String str4, long j, Integer num, String str5, Map map, String str6) {
        str4.getClass();
        map.getClass();
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = j;
        this.f = num;
        this.g = str5;
        this.h = map;
        this.i = str6;
    }

    public final String a() {
        return this.b;
    }

    public final Map b() {
        return this.h;
    }

    public final String c() {
        return this.a;
    }

    public final Integer d() {
        return this.f;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof sv1)) {
            return false;
        }
        sv1 sv1Var = (sv1) obj;
        return this.a.equals(sv1Var.a) && this.b.equals(sv1Var.b) && this.c.equals(sv1Var.c) && g31.a(this.d, sv1Var.d) && this.e == sv1Var.e && g31.a(this.f, sv1Var.f) && g31.a(this.g, sv1Var.g) && g31.a(this.h, sv1Var.h) && g31.a(this.i, sv1Var.i);
    }

    public final int hashCode() {
        int iC = cq.c(ky0.d(ky0.d(ky0.d(this.a.hashCode() * 31, 31, this.b), 31, this.c), 31, this.d), 31, this.e);
        Integer num = this.f;
        int iHashCode = (iC + (num == null ? 0 : num.hashCode())) * 31;
        String str = this.g;
        int iHashCode2 = (this.h.hashCode() + ((iHashCode + (str == null ? 0 : str.hashCode())) * 31)) * 31;
        String str2 = this.i;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sbQ = cq.q("PendingScreenAction(target=", this.a, ", packageName=", this.b, ", windowFingerprint=");
        sbQ.append(this.c);
        sbQ.append(", actionType=");
        sbQ.append(this.d);
        sbQ.append(", timestampMs=");
        sbQ.append(this.e);
        sbQ.append(", windowId=");
        sbQ.append(this.f);
        sbQ.append(", searchQuery=");
        sbQ.append(this.g);
        sbQ.append(", resolvedSlots=");
        sbQ.append(this.h);
        sbQ.append(", controlSignature=");
        sbQ.append(this.i);
        sbQ.append(")");
        return sbQ.toString();
    }
}
