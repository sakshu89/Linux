package defpackage;

import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ae1 {
    public final long a;
    public final String b;
    public final String c;
    public final JSONObject d;

    public ae1(long j, String str, String str2, JSONObject jSONObject) {
        str2.getClass();
        this.a = j;
        this.b = str;
        this.c = str2;
        this.d = jSONObject;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ae1)) {
            return false;
        }
        ae1 ae1Var = (ae1) obj;
        return this.a == ae1Var.a && this.b.equals(ae1Var.b) && g31.a(this.c, ae1Var.c) && this.d.equals(ae1Var.d);
    }

    public final int hashCode() {
        return this.d.hashCode() + ky0.d(ky0.d(Long.hashCode(this.a) * 31, 31, this.b), 31, this.c);
    }

    public final String toString() {
        return "Reply(id=" + this.a + ", key=" + this.b + ", userRequest=" + this.c + ", result=" + this.d + ")";
    }
}
