package defpackage;

import android.opengl.EGLSurface;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class vi {
    public final EGLSurface a;
    public final int b;
    public final int c;

    public vi(EGLSurface eGLSurface, int i, int i2) {
        if (eGLSurface == null) {
            dk0.n("Null eglSurface");
            throw null;
        }
        this.a = eGLSurface;
        this.b = i;
        this.c = i2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof vi) {
            vi viVar = (vi) obj;
            if (this.a.equals(viVar.a) && this.b == viVar.b && this.c == viVar.c) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.c ^ ((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b) * 1000003);
    }

    public final String toString() {
        return "OutputSurface{eglSurface=" + this.a + ", width=" + this.b + ", height=" + this.c + "}";
    }
}
