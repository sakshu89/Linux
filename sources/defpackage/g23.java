package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class g23 {
    public final Object a;
    public final Object b;

    public g23(Object obj, Object obj2) {
        this.a = obj;
        this.b = obj2;
    }

    public final boolean a(si0 si0Var, si0 si0Var2) {
        return si0Var.equals(this.a) && si0Var2.equals(this.b);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof g23)) {
            return false;
        }
        g23 g23Var = (g23) obj;
        return g31.a(this.a, g23Var.a) && g31.a(this.b, g23Var.b);
    }

    public final int hashCode() {
        Object obj = this.a;
        int iHashCode = (obj != null ? obj.hashCode() : 0) * 31;
        Object obj2 = this.b;
        return iHashCode + (obj2 != null ? obj2.hashCode() : 0);
    }
}
