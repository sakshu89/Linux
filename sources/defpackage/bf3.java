package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class bf3 {
    public final ok3 a;
    public final mr3 b;
    public final wp3 c;
    public final boolean d;

    public bf3(ok3 ok3Var, mr3 mr3Var, wp3 wp3Var, boolean z) {
        this.a = ok3Var;
        this.b = mr3Var;
        if (wp3Var == null) {
            dk0.n("Null lineBoxParcels");
            throw null;
        }
        this.c = wp3Var;
        this.d = z;
    }

    public static bf3 a(ok3 ok3Var) {
        up3 up3Var = wp3.f;
        aq3 aq3Var = aq3.k;
        return new bf3(ok3Var, new mr3("", aq3Var), aq3Var, false);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof bf3) {
            bf3 bf3Var = (bf3) obj;
            if (this.a.equals(bf3Var.a) && this.b == bf3Var.b && this.c.equals(bf3Var.c) && this.d == bf3Var.d) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (true != this.d ? 1237 : 1231) ^ ((((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003) ^ this.c.hashCode()) * 1000003);
    }

    public final String toString() {
        String string = this.a.toString();
        String string2 = this.b.toString();
        String string3 = this.c.toString();
        StringBuilder sbQ = cq.q("VkpResults{status=", string, ", textParcel=", string2, ", lineBoxParcels=");
        sbQ.append(string3);
        sbQ.append(", fromColdCall=");
        return ky0.o(sbQ, this.d, "}");
    }
}
