package defpackage;

import android.util.Size;
import android.view.Surface;
import android.view.SurfaceHolder;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class hu2 implements SurfaceHolder.Callback {
    public Size a;
    public fu2 b;
    public fu2 c;
    public rw d;
    public Size e;
    public boolean f = false;
    public boolean g = false;
    public final /* synthetic */ iu2 h;

    public hu2(iu2 iu2Var) {
        this.h = iu2Var;
    }

    public final boolean a() {
        iu2 iu2Var = this.h;
        Surface surface = iu2Var.e.getHolder().getSurface();
        if (this.f || this.b == null || !Objects.equals(this.a, this.e)) {
            return false;
        }
        xq4.c(3, "SurfaceViewImpl");
        rw rwVar = this.d;
        fu2 fu2Var = this.b;
        Objects.requireNonNull(fu2Var);
        fu2Var.a(surface, al4.b(iu2Var.e.getContext()), new zt2(1, rwVar));
        this.f = true;
        iu2Var.d = true;
        iu2Var.f();
        return true;
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        xq4.c(3, "SurfaceViewImpl");
        this.e = new Size(i2, i3);
        a();
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceCreated(SurfaceHolder surfaceHolder) {
        fu2 fu2Var;
        xq4.c(3, "SurfaceViewImpl");
        if (!this.g || (fu2Var = this.c) == null) {
            return;
        }
        fu2Var.c();
        fu2Var.i.a(null);
        this.c = null;
        this.g = false;
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        xq4.c(3, "SurfaceViewImpl");
        boolean z = this.f;
        fu2 fu2Var = this.b;
        if (z) {
            if (fu2Var != null) {
                Objects.toString(fu2Var);
                xq4.c(3, "SurfaceViewImpl");
                this.b.k.a();
            }
        } else if (fu2Var != null) {
            Objects.toString(fu2Var);
            xq4.c(3, "SurfaceViewImpl");
            this.b.c();
        }
        this.g = true;
        fu2 fu2Var2 = this.b;
        if (fu2Var2 != null) {
            this.c = fu2Var2;
        }
        this.f = false;
        this.b = null;
        this.d = null;
        this.e = null;
        this.a = null;
    }
}
