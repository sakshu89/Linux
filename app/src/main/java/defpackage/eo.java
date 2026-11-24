package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class eo {
    public final float a;

    public eo(float f) {
        this.a = f;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof eo)) {
            return false;
        }
        return de0.b(0.0f, 0.0f) && de0.b(0.0f, 0.0f) && de0.b(0.0f, 0.0f) && de0.b(this.a, ((eo) obj).a) && de0.b(0.0f, 0.0f);
    }

    public final int hashCode() {
        return Float.hashCode(0.0f) + cq.b(cq.b(cq.b(Float.hashCode(0.0f) * 31, 0.0f, 31), 0.0f, 31), this.a, 31);
    }
}
