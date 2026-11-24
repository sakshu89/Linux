package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class dc1 implements ip0 {
    public final float a;

    public dc1(float f) {
        this.a = f;
    }

    @Override // defpackage.ip0
    public final float a(float f) {
        return f / this.a;
    }

    @Override // defpackage.ip0
    public final float b(float f) {
        return f * this.a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof dc1) && Float.compare(this.a, ((dc1) obj).a) == 0;
    }

    public final int hashCode() {
        return Float.hashCode(this.a);
    }

    public final String toString() {
        return cq.m(new StringBuilder("LinearFontScaleConverter(fontScale="), this.a, ')');
    }
}
