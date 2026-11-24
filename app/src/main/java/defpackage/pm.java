package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class pm {
    public final int a;
    public final int b;
    public final int c;

    public pm(int i, int i2, int i3) {
        this.a = i;
        this.b = i2;
        this.c = i3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof pm)) {
            return false;
        }
        pm pmVar = (pm) obj;
        return this.a == pmVar.a && this.b == pmVar.b && this.c == pmVar.c;
    }

    public final int hashCode() {
        return Integer.hashCode(this.c) + ky0.a(this.b, Integer.hashCode(this.a) * 31, 31);
    }

    public final String toString() {
        StringBuilder sbP = cq.p("Confirmed(percent=", this.a, ", rawValue=", this.b, ", scaleMax=");
        sbP.append(this.c);
        sbP.append(")");
        return sbP.toString();
    }
}
