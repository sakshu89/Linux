package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class rd extends vd {
    public float a;

    public rd(float f) {
        this.a = f;
    }

    @Override // defpackage.vd
    public final float a(int i) {
        if (i == 0) {
            return this.a;
        }
        return 0.0f;
    }

    @Override // defpackage.vd
    public final int b() {
        return 1;
    }

    @Override // defpackage.vd
    public final vd c() {
        return new rd(0.0f);
    }

    @Override // defpackage.vd
    public final void d() {
        this.a = 0.0f;
    }

    @Override // defpackage.vd
    public final void e(float f, int i) {
        if (i == 0) {
            this.a = f;
        }
    }

    public final boolean equals(Object obj) {
        return (obj instanceof rd) && ((rd) obj).a == this.a;
    }

    public final int hashCode() {
        return Float.hashCode(this.a);
    }

    public final String toString() {
        return "AnimationVector1D: value = " + this.a;
    }
}
