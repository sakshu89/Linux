package defpackage;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class e52 implements h52 {
    public final List a;
    public final String b;

    public e52(List list, String str) {
        list.getClass();
        this.a = list;
        this.b = str;
    }

    @Override // defpackage.h52
    public final String a() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e52)) {
            return false;
        }
        e52 e52Var = (e52) obj;
        return g31.a(this.a, e52Var.a) && this.b.equals(e52Var.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.a.hashCode() * 31);
    }

    public final String toString() {
        return "GrantPermissions(permissions=" + this.a + ", label=" + this.b + ")";
    }
}
