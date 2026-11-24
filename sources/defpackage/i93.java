package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class i93 {
    public final int a;
    public final int b;
    public final boolean c;

    public i93(int i, int i2, boolean z) {
        this.a = i;
        this.b = i2;
        this.c = z;
    }

    public final String a() {
        int iB = b();
        String str = this.c ? ", muted" : "";
        StringBuilder sb = new StringBuilder();
        sb.append(this.a);
        sb.append(" of ");
        sb.append(this.b);
        sb.append(" (");
        sb.append(iB);
        return cq.n(sb, "%)", str);
    }

    public final int b() {
        int i = this.b;
        if (i <= 0) {
            return 0;
        }
        return hh1.f((this.a * 100.0f) / i);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i93)) {
            return false;
        }
        i93 i93Var = (i93) obj;
        return this.a == i93Var.a && this.b == i93Var.b && this.c == i93Var.c;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.c) + ky0.a(this.b, Integer.hashCode(this.a) * 31, 31);
    }

    public final String toString() {
        return ky0.o(cq.p("VolumeState(step=", this.a, ", maxStep=", this.b, ", isMuted="), this.c, ")");
    }
}
