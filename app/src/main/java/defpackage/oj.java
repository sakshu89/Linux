package defpackage;

import android.graphics.Matrix;
import android.graphics.Rect;
import androidx.camera.core.internal.compat.quirk.CaptureFailedRetryQuirk;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class oj {
    public int a;
    public final Executor b;
    public final uf1 c;
    public final kf d;
    public final Rect e;
    public final Matrix f;
    public final int g;
    public final int h;
    public final int i;
    public final List j;

    public oj(Executor executor, uf1 uf1Var, kf kfVar, Rect rect, Matrix matrix, int i, int i2, int i3, List list) {
        this.a = ((CaptureFailedRetryQuirk) uc0.a.d(CaptureFailedRetryQuirk.class)) == null ? 0 : 1;
        if (executor == null) {
            dk0.n("Null appExecutor");
            throw null;
        }
        this.b = executor;
        this.c = uf1Var;
        this.d = kfVar;
        this.e = rect;
        if (matrix == null) {
            dk0.n("Null sensorToBufferTransform");
            throw null;
        }
        this.f = matrix;
        this.g = i;
        this.h = i2;
        this.i = i3;
        if (list != null) {
            this.j = list;
        } else {
            dk0.n("Null sessionConfigCameraCaptureCallbacks");
            throw null;
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof oj) {
            oj ojVar = (oj) obj;
            if (this.b.equals(ojVar.b)) {
                uf1 uf1Var = ojVar.c;
                uf1 uf1Var2 = this.c;
                if (uf1Var2 != null ? uf1Var2.equals(uf1Var) : uf1Var == null) {
                    kf kfVar = ojVar.d;
                    kf kfVar2 = this.d;
                    if (kfVar2 != null ? kfVar2.equals(kfVar) : kfVar == null) {
                        if (this.e.equals(ojVar.e) && this.f.equals(ojVar.f) && this.g == ojVar.g && this.h == ojVar.h && this.i == ojVar.i && this.j.equals(ojVar.j)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = (this.b.hashCode() ^ 1000003) * (-721379959);
        uf1 uf1Var = this.c;
        int iHashCode2 = (iHashCode ^ (uf1Var == null ? 0 : uf1Var.hashCode())) * 1000003;
        kf kfVar = this.d;
        return this.j.hashCode() ^ ((((((((((((iHashCode2 ^ (kfVar != null ? kfVar.hashCode() : 0)) * 1000003) ^ this.e.hashCode()) * 1000003) ^ this.f.hashCode()) * 1000003) ^ this.g) * 1000003) ^ this.h) * 1000003) ^ this.i) * 1000003);
    }

    public final String toString() {
        return "TakePictureRequest{appExecutor=" + this.b + ", inMemoryCallback=null, onDiskCallback=" + this.c + ", outputFileOptions=" + this.d + ", cropRect=" + this.e + ", sensorToBufferTransform=" + this.f + ", rotationDegrees=" + this.g + ", jpegQuality=" + this.h + ", captureMode=" + this.i + ", sessionConfigCameraCaptureCallbacks=" + this.j + "}";
    }
}
