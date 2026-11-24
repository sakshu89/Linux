package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ti extends mn1 {
    public final ln1 a;
    public final kn1 b;

    public ti(ln1 ln1Var, kn1 kn1Var) {
        this.a = ln1Var;
        this.b = kn1Var;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof mn1) {
            mn1 mn1Var = (mn1) obj;
            ln1 ln1Var = this.a;
            if (ln1Var != null ? ln1Var.equals(((ti) mn1Var).a) : ((ti) mn1Var).a == null) {
                kn1 kn1Var = this.b;
                if (kn1Var != null ? kn1Var.equals(((ti) mn1Var).b) : ((ti) mn1Var).b == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        ln1 ln1Var = this.a;
        int iHashCode = ((ln1Var == null ? 0 : ln1Var.hashCode()) ^ 1000003) * 1000003;
        kn1 kn1Var = this.b;
        return iHashCode ^ (kn1Var != null ? kn1Var.hashCode() : 0);
    }

    public final String toString() {
        return "NetworkConnectionInfo{networkType=" + this.a + ", mobileSubtype=" + this.b + "}";
    }
}
