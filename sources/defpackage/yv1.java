package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class yv1 implements g70 {
    public final float a;

    public yv1(float f) {
        this.a = f;
        if (f < 0.0f || f > 100.0f) {
            c11.a("The percent should be in the range of [0, 100]");
        }
    }

    @Override // defpackage.g70
    public final float a(long j, jc0 jc0Var) {
        return (this.a / 100.0f) * xk2.b(j);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof yv1) && Float.compare(this.a, ((yv1) obj).a) == 0;
    }

    public final int hashCode() {
        return Float.hashCode(this.a);
    }

    public final String toString() {
        return "CornerSize(size = " + this.a + "%)";
    }
}
