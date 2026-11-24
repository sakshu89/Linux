package defpackage;

import android.graphics.Matrix;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class mi implements vy0 {
    public final iv2 a;
    public final long b;
    public final int c;
    public final Matrix d;

    public mi(iv2 iv2Var, long j, int i, Matrix matrix) {
        if (iv2Var == null) {
            dk0.n("Null tagBundle");
            throw null;
        }
        this.a = iv2Var;
        this.b = j;
        this.c = i;
        if (matrix != null) {
            this.d = matrix;
        } else {
            dk0.n("Null sensorToBufferTransformMatrix");
            throw null;
        }
    }

    @Override // defpackage.vy0
    public final void a(bk0 bk0Var) {
        bk0Var.d(this.c);
    }

    @Override // defpackage.vy0
    public final iv2 b() {
        return this.a;
    }

    @Override // defpackage.vy0
    public final long d() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof mi) {
            mi miVar = (mi) obj;
            if (this.a.equals(miVar.a) && this.b == miVar.b && this.c == miVar.c && this.d.equals(miVar.d)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = (this.a.hashCode() ^ 1000003) * 1000003;
        long j = this.b;
        return this.d.hashCode() ^ ((((iHashCode ^ ((int) ((j >>> 32) ^ j))) * 1000003) ^ this.c) * 1000003);
    }

    public final String toString() {
        return "ImmutableImageInfo{tagBundle=" + this.a + ", timestamp=" + this.b + ", rotationDegrees=" + this.c + ", sensorToBufferTransformMatrix=" + this.d + "}";
    }
}
