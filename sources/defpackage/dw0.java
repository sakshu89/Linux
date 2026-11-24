package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class dw0 {
    public static final oo d;
    public static final oo e;
    public static final oo f;
    public static final oo g;
    public static final oo h;
    public static final oo i;
    public final oo a;
    public final oo b;
    public final int c;

    static {
        oo ooVar = oo.e;
        d = nr4.m(":");
        e = nr4.m(":status");
        f = nr4.m(":method");
        g = nr4.m(":path");
        h = nr4.m(":scheme");
        i = nr4.m(":authority");
    }

    public dw0(oo ooVar, oo ooVar2) {
        ooVar.getClass();
        ooVar2.getClass();
        this.a = ooVar;
        this.b = ooVar2;
        this.c = ooVar2.c() + ooVar.c() + 32;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof dw0)) {
            return false;
        }
        dw0 dw0Var = (dw0) obj;
        return g31.a(this.a, dw0Var.a) && g31.a(this.b, dw0Var.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.a.hashCode() * 31);
    }

    public final String toString() {
        return this.a.j() + ": " + this.b.j();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public dw0(String str, String str2) {
        this(nr4.m(str), nr4.m(str2));
        str.getClass();
        str2.getClass();
        oo ooVar = oo.e;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public dw0(oo ooVar, String str) {
        this(ooVar, nr4.m(str));
        ooVar.getClass();
        str.getClass();
        oo ooVar2 = oo.e;
    }
}
