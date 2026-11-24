package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class et1 {
    public final long a;
    public final qt1 b;

    public et1() {
        long jC = ki4.c(4284900966L);
        qt1 qt1VarA = c34.a(3);
        this.a = jC;
        this.b = qt1VarA;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!et1.class.equals(obj != null ? obj.getClass() : null)) {
            return false;
        }
        obj.getClass();
        et1 et1Var = (et1) obj;
        return sz.c(this.a, et1Var.a) && g31.a(this.b, et1Var.b);
    }

    public final int hashCode() {
        int i = sz.h;
        return this.b.hashCode() + (Long.hashCode(this.a) * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("OverscrollConfiguration(glowColor=");
        ky0.v(this.a, sb, ", drawPadding=");
        sb.append(this.b);
        sb.append(')');
        return sb.toString();
    }
}
