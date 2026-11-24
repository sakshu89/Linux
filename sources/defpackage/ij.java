package defpackage;

import android.graphics.Rect;
import android.util.Size;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ij {
    public final Size a;
    public final Rect b;
    public final wt c;
    public final int d;
    public final boolean e;

    public ij(Size size, Rect rect, wt wtVar, int i, boolean z) {
        if (size == null) {
            dk0.n("Null inputSize");
            throw null;
        }
        this.a = size;
        if (rect == null) {
            dk0.n("Null inputCropRect");
            throw null;
        }
        this.b = rect;
        this.c = wtVar;
        this.d = i;
        this.e = z;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ij) {
            ij ijVar = (ij) obj;
            if (this.a.equals(ijVar.a) && this.b.equals(ijVar.b)) {
                wt wtVar = ijVar.c;
                wt wtVar2 = this.c;
                if (wtVar2 != null ? wtVar2.equals(wtVar) : wtVar == null) {
                    if (this.d == ijVar.d && this.e == ijVar.e) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = (((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003;
        wt wtVar = this.c;
        return (this.e ? 1231 : 1237) ^ ((((iHashCode ^ (wtVar == null ? 0 : wtVar.hashCode())) * 1000003) ^ this.d) * 1000003);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("CameraInputInfo{inputSize=");
        sb.append(this.a);
        sb.append(", inputCropRect=");
        sb.append(this.b);
        sb.append(", cameraInternal=");
        sb.append(this.c);
        sb.append(", rotationDegrees=");
        sb.append(this.d);
        sb.append(", mirroring=");
        return ky0.o(sb, this.e, "}");
    }
}
