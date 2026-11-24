package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class fz0 {
    public static int k;
    public static final su0 l = new su0(14);
    public final String a;
    public final float b;
    public final float c;
    public final float d;
    public final float e;
    public final n63 f;
    public final long g;
    public final int h;
    public final boolean i;
    public final int j;

    public fz0(String str, float f, float f2, float f3, float f4, n63 n63Var, long j, int i, boolean z) {
        int i2;
        synchronized (l) {
            i2 = k;
            k = i2 + 1;
        }
        this.a = str;
        this.b = f;
        this.c = f2;
        this.d = f3;
        this.e = f4;
        this.f = n63Var;
        this.g = j;
        this.h = i;
        this.i = z;
        this.j = i2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof fz0)) {
            return false;
        }
        fz0 fz0Var = (fz0) obj;
        return g31.a(this.a, fz0Var.a) && de0.b(this.b, fz0Var.b) && de0.b(this.c, fz0Var.c) && this.d == fz0Var.d && this.e == fz0Var.e && this.f.equals(fz0Var.f) && sz.c(this.g, fz0Var.g) && this.h == fz0Var.h && this.i == fz0Var.i;
    }

    public final int hashCode() {
        int iHashCode = (this.f.hashCode() + cq.b(cq.b(cq.b(cq.b(this.a.hashCode() * 31, this.b, 31), this.c, 31), this.d, 31), this.e, 31)) * 31;
        int i = sz.h;
        return Boolean.hashCode(this.i) + ky0.a(this.h, cq.c(iHashCode, 31, this.g), 31);
    }
}
