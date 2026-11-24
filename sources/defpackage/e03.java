package defpackage;

import android.graphics.SurfaceTexture;
import android.view.TextureView;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class e03 implements TextureView.SurfaceTextureListener {
    public final /* synthetic */ f03 a;

    public e03(f03 f03Var) {
        this.a = f03Var;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        xq4.c(3, "TextureViewImpl");
        f03 f03Var = this.a;
        f03Var.f = surfaceTexture;
        if (f03Var.g == null) {
            f03Var.h();
            return;
        }
        f03Var.h.getClass();
        Objects.toString(f03Var.h);
        xq4.c(3, "TextureViewImpl");
        f03Var.h.k.a();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        f03 f03Var = this.a;
        f03Var.f = null;
        wp wpVar = f03Var.g;
        if (wpVar == null) {
            xq4.c(3, "TextureViewImpl");
            return true;
        }
        cu2 cu2Var = new cu2(2, this, surfaceTexture, false);
        wpVar.a(new or0(0, wpVar, cu2Var), al4.b(f03Var.e.getContext()));
        f03Var.j = surfaceTexture;
        return false;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        xq4.c(3, "TextureViewImpl");
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        tp tpVar = (tp) this.a.k.getAndSet(null);
        if (tpVar != null) {
            tpVar.a(null);
        }
    }
}
