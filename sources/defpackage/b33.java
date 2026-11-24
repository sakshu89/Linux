package defpackage;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class b33 implements Serializable {
    public final Object a;
    public final Object b;
    public final Object c;

    public b33(Object obj, Object obj2, Object obj3) {
        this.a = obj;
        this.b = obj2;
        this.c = obj3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b33)) {
            return false;
        }
        b33 b33Var = (b33) obj;
        return g31.a(this.a, b33Var.a) && g31.a(this.b, b33Var.b) && this.c.equals(b33Var.c);
    }

    public final int hashCode() {
        Object obj = this.a;
        int iHashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        Object obj2 = this.b;
        return this.c.hashCode() + ((iHashCode + (obj2 != null ? obj2.hashCode() : 0)) * 31);
    }

    public final String toString() {
        return "(" + this.a + ", " + this.b + ", " + this.c + ')';
    }
}
