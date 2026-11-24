package defpackage;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class p4 implements fr0, Serializable {
    public final Object a;
    public final Class b;
    public final String c;
    public final String e;
    public final boolean f = false;
    public final int i;
    public final int j;

    public p4(int i, int i2, Class cls, Object obj, String str, String str2) {
        this.a = obj;
        this.b = cls;
        this.c = str;
        this.e = str2;
        this.i = i;
        this.j = i2 >> 1;
    }

    @Override // defpackage.fr0
    public final int b() {
        return this.i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof p4)) {
            return false;
        }
        p4 p4Var = (p4) obj;
        return this.f == p4Var.f && this.i == p4Var.i && this.j == p4Var.j && g31.a(this.a, p4Var.a) && this.b.equals(p4Var.b) && this.c.equals(p4Var.c) && this.e.equals(p4Var.e);
    }

    public final int hashCode() {
        Object obj = this.a;
        return ((((ky0.d(ky0.d((this.b.hashCode() + ((obj != null ? obj.hashCode() : 0) * 31)) * 31, 31, this.c), 31, this.e) + (this.f ? 1231 : 1237)) * 31) + this.i) * 31) + this.j;
    }

    public final String toString() {
        u42.a.getClass();
        return v42.a(this);
    }
}
