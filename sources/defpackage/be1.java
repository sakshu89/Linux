package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class be1 {
    public final dd1 a;
    public final long b;
    public final boolean c;
    public final boolean d;
    public final boolean e;

    public /* synthetic */ be1(dd1 dd1Var, int i) {
        this((i & 1) != 0 ? dd1.a : dd1Var, 0L, (i & 4) == 0, false, false);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof be1)) {
            return false;
        }
        be1 be1Var = (be1) obj;
        return this.a == be1Var.a && this.b == be1Var.b && this.c == be1Var.c && this.d == be1Var.d && this.e == be1Var.e;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.e) + ky0.e(ky0.e(cq.c(this.a.hashCode() * 31, 31, this.b), 31, this.c), 31, this.d);
    }

    public final String toString() {
        return "LiveRunResult(issue=" + this.a + ", activeForMs=" + this.b + ", stopped=" + this.c + ", connected=" + this.d + ", modelUnavailable=" + this.e + ")";
    }

    public be1(dd1 dd1Var, long j, boolean z, boolean z2, boolean z3) {
        dd1Var.getClass();
        this.a = dd1Var;
        this.b = j;
        this.c = z;
        this.d = z2;
        this.e = z3;
    }
}
