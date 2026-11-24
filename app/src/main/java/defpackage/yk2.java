package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
final class yk2 extends ik1 {
    public final float a;
    public final float b;
    public final float c;
    public final float d;
    public final boolean e;

    public /* synthetic */ yk2(float f, float f2, int i) {
        this((i & 1) != 0 ? Float.NaN : 1.0f, (i & 2) != 0 ? Float.NaN : f, (i & 4) != 0 ? Float.NaN : 1.0f, (i & 8) != 0 ? Float.NaN : f2, true);
    }

    @Override // defpackage.ik1
    public final dk1 e() {
        zk2 zk2Var = new zk2();
        zk2Var.x = this.a;
        zk2Var.H = this.b;
        zk2Var.X = this.c;
        zk2Var.Y = this.d;
        zk2Var.Z = this.e;
        return zk2Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof yk2)) {
            return false;
        }
        yk2 yk2Var = (yk2) obj;
        return de0.b(this.a, yk2Var.a) && de0.b(this.b, yk2Var.b) && de0.b(this.c, yk2Var.c) && de0.b(this.d, yk2Var.d) && this.e == yk2Var.e;
    }

    @Override // defpackage.ik1
    public final void f(dk1 dk1Var) {
        zk2 zk2Var = (zk2) dk1Var;
        zk2Var.x = this.a;
        zk2Var.H = this.b;
        zk2Var.X = this.c;
        zk2Var.Y = this.d;
        zk2Var.Z = this.e;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.e) + cq.b(cq.b(cq.b(Float.hashCode(this.a) * 31, this.b, 31), this.c, 31), this.d, 31);
    }

    public yk2(float f, float f2, float f3, float f4, boolean z) {
        this.a = f;
        this.b = f2;
        this.c = f3;
        this.d = f4;
        this.e = z;
    }
}
