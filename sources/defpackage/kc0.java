package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class kc0 implements jc0 {
    public final float a;
    public final float b;

    public kc0(float f, float f2) {
        this.a = f;
        this.b = f2;
    }

    @Override // defpackage.jc0
    public final float b() {
        return this.a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof kc0)) {
            return false;
        }
        kc0 kc0Var = (kc0) obj;
        return Float.compare(this.a, kc0Var.a) == 0 && Float.compare(this.b, kc0Var.b) == 0;
    }

    public final int hashCode() {
        return Float.hashCode(this.b) + (Float.hashCode(this.a) * 31);
    }

    @Override // defpackage.jc0
    public final float l() {
        return this.b;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("DensityImpl(density=");
        sb.append(this.a);
        sb.append(", fontScale=");
        return cq.m(sb, this.b, ')');
    }
}
