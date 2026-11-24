package defpackage;

import android.os.Handler;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class xh {
    public final Executor a;
    public final Handler b;

    public xh(Executor executor, Handler handler) {
        if (executor == null) {
            dk0.n("Null cameraExecutor");
            throw null;
        }
        this.a = executor;
        if (handler != null) {
            this.b = handler;
        } else {
            dk0.n("Null schedulerHandler");
            throw null;
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof xh) {
            xh xhVar = (xh) obj;
            if (this.a.equals(xhVar.a) && this.b.equals(xhVar.b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.b.hashCode() ^ ((this.a.hashCode() ^ 1000003) * 1000003);
    }

    public final String toString() {
        return "CameraThreadConfig{cameraExecutor=" + this.a + ", schedulerHandler=" + this.b + "}";
    }
}
