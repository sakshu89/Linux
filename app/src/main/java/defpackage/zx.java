package defpackage;

import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class zx {
    public final String a;
    public final String b;
    public final String c;
    public final Map d;

    public zx(String str, String str2, String str3, Map map) {
        str.getClass();
        str2.getClass();
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = map;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zx)) {
            return false;
        }
        zx zxVar = (zx) obj;
        return g31.a(this.a, zxVar.a) && g31.a(this.b, zxVar.b) && g31.a(this.c, zxVar.c) && g31.a(this.d, zxVar.d);
    }

    public final int hashCode() {
        int iD = ky0.d(this.a.hashCode() * 31, 31, this.b);
        String str = this.c;
        return this.d.hashCode() + ((iD + (str == null ? 0 : str.hashCode())) * 31);
    }

    public final String toString() {
        StringBuilder sbQ = cq.q("ClarificationOption(label=", this.a, ", value=", this.b, ", detail=");
        sbQ.append(this.c);
        sbQ.append(", resolvedSlots=");
        sbQ.append(this.d);
        sbQ.append(")");
        return sbQ.toString();
    }

    public /* synthetic */ zx(String str, String str2, String str3, int i) {
        this(str, str2, (i & 4) != 0 ? null : str3, ji0.a);
    }
}
