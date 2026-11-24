package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class jl {
    public final float a;

    public jl(float f) {
        this.a = f;
    }

    public final int a(int i, int i2, z61 z61Var) {
        float f = (i2 - i) / 2.0f;
        z61 z61Var2 = z61.a;
        float f2 = this.a;
        if (z61Var != z61Var2) {
            f2 *= -1.0f;
        }
        return Math.round((1.0f + f2) * f);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof jl) && Float.compare(this.a, ((jl) obj).a) == 0;
    }

    public final int hashCode() {
        return Float.hashCode(this.a);
    }

    public final String toString() {
        return cq.m(new StringBuilder("Horizontal(bias="), this.a, ')');
    }
}
