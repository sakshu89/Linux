package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class sd extends vd {
    public float a;
    public float b;

    public sd(float f, float f2) {
        this.a = f;
        this.b = f2;
    }

    @Override // defpackage.vd
    public final float a(int i) {
        if (i == 0) {
            return this.a;
        }
        if (i != 1) {
            return 0.0f;
        }
        return this.b;
    }

    @Override // defpackage.vd
    public final int b() {
        return 2;
    }

    @Override // defpackage.vd
    public final vd c() {
        return new sd(0.0f, 0.0f);
    }

    @Override // defpackage.vd
    public final void d() {
        this.a = 0.0f;
        this.b = 0.0f;
    }

    @Override // defpackage.vd
    public final void e(float f, int i) {
        if (i == 0) {
            this.a = f;
        } else {
            if (i != 1) {
                return;
            }
            this.b = f;
        }
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof sd)) {
            return false;
        }
        sd sdVar = (sd) obj;
        return sdVar.a == this.a && sdVar.b == this.b;
    }

    public final int hashCode() {
        return Float.hashCode(this.b) + (Float.hashCode(this.a) * 31);
    }

    public final String toString() {
        return "AnimationVector2D: v1 = " + this.a + ", v2 = " + this.b;
    }
}
