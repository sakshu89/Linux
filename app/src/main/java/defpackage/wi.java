package defpackage;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.util.Size;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class wi {
    public final Object a;
    public final xj0 b;
    public final int c;
    public final Size d;
    public final Rect e;
    public final int f;
    public final Matrix g;
    public final ls h;

    public wi(Object obj, xj0 xj0Var, int i, Size size, Rect rect, int i2, Matrix matrix, ls lsVar) {
        if (obj == null) {
            dk0.n("Null data");
            throw null;
        }
        this.a = obj;
        this.b = xj0Var;
        this.c = i;
        this.d = size;
        if (rect == null) {
            dk0.n("Null cropRect");
            throw null;
        }
        this.e = rect;
        this.f = i2;
        if (matrix == null) {
            dk0.n("Null sensorToBufferTransform");
            throw null;
        }
        this.g = matrix;
        if (lsVar != null) {
            this.h = lsVar;
        } else {
            dk0.n("Null cameraCaptureResult");
            throw null;
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof wi) {
            wi wiVar = (wi) obj;
            if (this.a.equals(wiVar.a)) {
                xj0 xj0Var = wiVar.b;
                xj0 xj0Var2 = this.b;
                if (xj0Var2 == null) {
                    if (xj0Var == null) {
                    }
                } else if (xj0Var2 != xj0Var) {
                    return false;
                }
                if (this.c == wiVar.c && this.d.equals(wiVar.d) && this.e.equals(wiVar.e) && this.f == wiVar.f && this.g.equals(wiVar.g) && this.h.equals(wiVar.h)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = (this.a.hashCode() ^ 1000003) * 1000003;
        xj0 xj0Var = this.b;
        return this.h.hashCode() ^ ((((((((((((iHashCode ^ (xj0Var == null ? 0 : xj0Var.hashCode())) * 1000003) ^ this.c) * 1000003) ^ this.d.hashCode()) * 1000003) ^ this.e.hashCode()) * 1000003) ^ this.f) * 1000003) ^ this.g.hashCode()) * 1000003);
    }

    public final String toString() {
        return "Packet{data=" + this.a + ", exif=" + this.b + ", format=" + this.c + ", size=" + this.d + ", cropRect=" + this.e + ", rotationDegrees=" + this.f + ", sensorToBufferTransform=" + this.g + ", cameraCaptureResult=" + this.h + "}";
    }
}
