package defpackage;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class hi {
    public final String a;
    public final Integer b;
    public final ni0 c;
    public final long d;
    public final long e;
    public final Map f;

    public hi(String str, Integer num, ni0 ni0Var, long j, long j2, HashMap map) {
        this.a = str;
        this.b = num;
        this.c = ni0Var;
        this.d = j;
        this.e = j2;
        this.f = map;
    }

    public final String a(String str) {
        String str2 = (String) this.f.get(str);
        return str2 == null ? "" : str2;
    }

    public final int b(String str) {
        String str2 = (String) this.f.get(str);
        if (str2 == null) {
            return 0;
        }
        return Integer.valueOf(str2).intValue();
    }

    public final lj1 c() {
        lj1 lj1Var = new lj1(2);
        String str = this.a;
        if (str == null) {
            dk0.n("Null transportName");
            return null;
        }
        lj1Var.b = str;
        lj1Var.c = this.b;
        ni0 ni0Var = this.c;
        if (ni0Var == null) {
            dk0.n("Null encodedPayload");
            return null;
        }
        lj1Var.d = ni0Var;
        lj1Var.e = Long.valueOf(this.d);
        lj1Var.f = Long.valueOf(this.e);
        lj1Var.g = new HashMap(this.f);
        return lj1Var;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof hi) {
            hi hiVar = (hi) obj;
            if (this.a.equals(hiVar.a)) {
                Integer num = hiVar.b;
                Integer num2 = this.b;
                if (num2 != null ? num2.equals(num) : num == null) {
                    if (this.c.equals(hiVar.c) && this.d == hiVar.d && this.e == hiVar.e && this.f.equals(hiVar.f)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = (this.a.hashCode() ^ 1000003) * 1000003;
        Integer num = this.b;
        int iHashCode2 = (((iHashCode ^ (num == null ? 0 : num.hashCode())) * 1000003) ^ this.c.hashCode()) * 1000003;
        long j = this.d;
        int i = (iHashCode2 ^ ((int) (j ^ (j >>> 32)))) * 1000003;
        long j2 = this.e;
        return this.f.hashCode() ^ ((i ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003);
    }

    public final String toString() {
        return "EventInternal{transportName=" + this.a + ", code=" + this.b + ", encodedPayload=" + this.c + ", eventMillis=" + this.d + ", uptimeMillis=" + this.e + ", autoMetadata=" + this.f + "}";
    }
}
