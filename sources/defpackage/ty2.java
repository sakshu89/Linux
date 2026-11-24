package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ty2 {
    public final be a;
    public final long b;
    public final oz2 c;

    public ty2(be beVar, long j, oz2 oz2Var) {
        oz2 oz2Var2;
        this.a = beVar;
        this.b = hc4.c(beVar.b.length(), j);
        if (oz2Var != null) {
            oz2Var2 = new oz2(hc4.c(beVar.b.length(), oz2Var.a));
        } else {
            oz2Var2 = null;
        }
        this.c = oz2Var2;
    }

    public static ty2 a(ty2 ty2Var, be beVar, long j, int i) {
        if ((i & 1) != 0) {
            beVar = ty2Var.a;
        }
        if ((i & 2) != 0) {
            j = ty2Var.b;
        }
        oz2 oz2Var = (i & 4) != 0 ? ty2Var.c : null;
        ty2Var.getClass();
        return new ty2(beVar, j, oz2Var);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ty2)) {
            return false;
        }
        ty2 ty2Var = (ty2) obj;
        return oz2.b(this.b, ty2Var.b) && g31.a(this.c, ty2Var.c) && g31.a(this.a, ty2Var.a);
    }

    public final int hashCode() {
        int iHashCode = this.a.hashCode() * 31;
        int i = oz2.c;
        int iC = cq.c(iHashCode, 31, this.b);
        oz2 oz2Var = this.c;
        return iC + (oz2Var != null ? Long.hashCode(oz2Var.a) : 0);
    }

    public final String toString() {
        return "TextFieldValue(text='" + ((Object) this.a) + "', selection=" + ((Object) oz2.h(this.b)) + ", composition=" + this.c + ')';
    }

    public ty2(int i, long j, String str) {
        this(new be((i & 1) != 0 ? "" : str), (i & 2) != 0 ? oz2.b : j, (oz2) null);
    }
}
