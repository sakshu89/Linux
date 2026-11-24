package defpackage;

import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class rs0 {
    public final long a;
    public final String b;
    public final Map c;

    public rs0(long j, String str, Map map) {
        str.getClass();
        this.a = j;
        this.b = str;
        this.c = map;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof rs0)) {
            return false;
        }
        rs0 rs0Var = (rs0) obj;
        return this.a == rs0Var.a && g31.a(this.b, rs0Var.b) && this.c.equals(rs0Var.c);
    }

    public final int hashCode() {
        return this.c.hashCode() + ky0.d(Long.hashCode(this.a) * 31, 31, this.b);
    }

    public final String toString() {
        return "ToolRequestKey(sequence=" + this.a + ", action=" + this.b + ", slots=" + this.c + ")";
    }
}
