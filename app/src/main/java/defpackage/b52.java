package defpackage;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class b52 {
    public final long a;
    public final long b;
    public final long c;
    public final long d;
    public final long e;
    public final float[] f;
    public final ck g;

    public b52(long j, long j2, long j3, long j4, long j5, float[] fArr, ck ckVar) {
        this.a = j;
        this.b = j2;
        this.c = j3;
        this.d = j4;
        this.e = j5;
        this.f = fArr;
        this.g = ckVar;
    }

    /* JADX WARN: Code duplicated, block: B:29:0x004d  */
    public final boolean equals(Object obj) {
        boolean zEquals;
        if (this == obj) {
            return true;
        }
        if (obj != null && b52.class == obj.getClass()) {
            b52 b52Var = (b52) obj;
            if (this.a == b52Var.a && this.b == b52Var.b && this.e == b52Var.e && e21.a(this.c, b52Var.c) && e21.a(this.d, b52Var.d)) {
                float[] fArr = b52Var.f;
                float[] fArr2 = this.f;
                if (fArr2 == null) {
                    if (fArr == null) {
                        zEquals = true;
                    } else {
                        zEquals = false;
                    }
                } else if (fArr == null) {
                    zEquals = false;
                } else {
                    zEquals = fArr2.equals(fArr);
                }
                return zEquals && this.g == b52Var.g;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iC = cq.c(cq.c(cq.c(cq.c(Long.hashCode(this.a) * 31, 31, this.b), 31, this.e), 31, this.c), 31, this.d);
        float[] fArr = this.f;
        return this.g.hashCode() + ((iC + (fArr != null ? Arrays.hashCode(fArr) : 0)) * 31);
    }
}
