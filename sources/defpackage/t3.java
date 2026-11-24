package defpackage;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class t3 implements v3 {
    public final String a;
    public final List b;

    public t3(String str, List list) {
        str.getClass();
        this.a = str;
        this.b = list;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof t3)) {
            return false;
        }
        t3 t3Var = (t3) obj;
        return g31.a(this.a, t3Var.a) && this.b.equals(t3Var.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.a.hashCode() * 31);
    }

    public final String toString() {
        return "NotFound(target=" + this.a + ", nearest=" + this.b + ")";
    }
}
