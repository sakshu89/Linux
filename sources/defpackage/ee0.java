package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ee0 implements g70 {
    public final float a;

    public ee0(float f) {
        this.a = f;
    }

    @Override // defpackage.g70
    public final float a(long j, jc0 jc0Var) {
        return jc0Var.x(this.a);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ee0) && de0.b(this.a, ((ee0) obj).a);
    }

    public final int hashCode() {
        return Float.hashCode(this.a);
    }

    public final String toString() {
        return "CornerSize(size = " + this.a + ".dp)";
    }
}
