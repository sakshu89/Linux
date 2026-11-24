package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ni {
    public final float a;
    public final float b;
    public final float c;
    public final float d;

    public ni(float f, float f2, float f3, float f4) {
        this.a = f;
        this.b = f2;
        this.c = f3;
        this.d = f4;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ni) {
            ni niVar = (ni) obj;
            if (Float.floatToIntBits(this.a) == Float.floatToIntBits(niVar.a) && Float.floatToIntBits(this.b) == Float.floatToIntBits(niVar.b) && Float.floatToIntBits(this.c) == Float.floatToIntBits(niVar.c) && Float.floatToIntBits(this.d) == Float.floatToIntBits(niVar.d)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Float.floatToIntBits(this.d) ^ ((((((Float.floatToIntBits(this.a) ^ 1000003) * 1000003) ^ Float.floatToIntBits(this.b)) * 1000003) ^ Float.floatToIntBits(this.c)) * 1000003);
    }

    public final String toString() {
        return "ImmutableZoomState{zoomRatio=" + this.a + ", maxZoomRatio=" + this.b + ", minZoomRatio=" + this.c + ", linearZoom=" + this.d + "}";
    }
}
