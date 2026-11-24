package defpackage;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class py1 {
    public final long a;
    public final long b;
    public final long c;
    public final long d;
    public final boolean e;
    public final float f;
    public final int g;
    public final boolean h;
    public final ArrayList i;
    public final long j;
    public final long k;

    public py1(long j, long j2, long j3, long j4, boolean z, float f, int i, boolean z2, ArrayList arrayList, long j5, long j6) {
        this.a = j;
        this.b = j2;
        this.c = j3;
        this.d = j4;
        this.e = z;
        this.f = f;
        this.g = i;
        this.h = z2;
        this.i = arrayList;
        this.j = j5;
        this.k = j6;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof py1)) {
            return false;
        }
        py1 py1Var = (py1) obj;
        return f31.d(this.a, py1Var.a) && this.b == py1Var.b && jp1.b(this.c, py1Var.c) && jp1.b(this.d, py1Var.d) && this.e == py1Var.e && Float.compare(this.f, py1Var.f) == 0 && this.g == py1Var.g && this.h == py1Var.h && this.i.equals(py1Var.i) && jp1.b(this.j, py1Var.j) && jp1.b(this.k, py1Var.k);
    }

    public final int hashCode() {
        return Long.hashCode(this.k) + cq.c((this.i.hashCode() + ky0.e(ky0.a(this.g, cq.b(ky0.e(cq.c(cq.c(cq.c(Long.hashCode(this.a) * 31, 31, this.b), 31, this.c), 31, this.d), 31, this.e), this.f, 31), 31), 31, this.h)) * 31, 31, this.j);
    }

    public final String toString() {
        return "PointerInputEventData(id=" + ((Object) f31.f(this.a)) + ", uptime=" + this.b + ", positionOnScreen=" + ((Object) jp1.g(this.c)) + ", position=" + ((Object) jp1.g(this.d)) + ", down=" + this.e + ", pressure=" + this.f + ", type=" + ((Object) ty1.a(this.g)) + ", activeHover=" + this.h + ", historical=" + this.i + ", scrollDelta=" + ((Object) jp1.g(this.j)) + ", originalEventPosition=" + ((Object) jp1.g(this.k)) + ')';
    }
}
