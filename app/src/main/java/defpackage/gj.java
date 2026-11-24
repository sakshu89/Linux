package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class gj {
    public final int a;
    public final int b;
    public final boolean c;
    public final boolean d;

    public gj(int i, int i2, boolean z, boolean z2) {
        this.a = i;
        this.b = i2;
        this.c = z;
        this.d = z2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof gj) {
            gj gjVar = (gj) obj;
            if (this.a == gjVar.a && this.b == gjVar.b && this.c == gjVar.c && this.d == gjVar.d) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((((this.a ^ 1000003) * 1000003) ^ this.b) * 1000003) ^ (this.c ? 1231 : 1237)) * 1000003) ^ (this.d ? 1231 : 1237);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("FeatureSettings{cameraMode=");
        sb.append(this.a);
        sb.append(", requiredMaxBitDepth=");
        sb.append(this.b);
        sb.append(", previewStabilizationOn=");
        sb.append(this.c);
        sb.append(", ultraHdrOn=");
        return ky0.o(sb, this.d, "}");
    }
}
