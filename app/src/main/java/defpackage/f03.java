package defpackage;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.util.Size;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.widget.FrameLayout;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class f03 extends s02 {
    public TextureView e;
    public SurfaceTexture f;
    public wp g;
    public fu2 h;
    public boolean i;
    public SurfaceTexture j;
    public AtomicReference k;
    public rw l;

    @Override // defpackage.s02
    public final View a() {
        return this.e;
    }

    @Override // defpackage.s02
    public final Bitmap b() {
        TextureView textureView = this.e;
        if (textureView == null || !textureView.isAvailable()) {
            return null;
        }
        return this.e.getBitmap();
    }

    @Override // defpackage.s02
    public final void c() {
        if (!this.i || this.j == null) {
            return;
        }
        SurfaceTexture surfaceTexture = this.e.getSurfaceTexture();
        SurfaceTexture surfaceTexture2 = this.j;
        if (surfaceTexture != surfaceTexture2) {
            this.e.setSurfaceTexture(surfaceTexture2);
            this.j = null;
            this.i = false;
        }
    }

    @Override // defpackage.s02
    public final void d() {
        this.i = true;
    }

    @Override // defpackage.s02
    public final void e(fu2 fu2Var, rw rwVar) {
        Size size = fu2Var.b;
        this.a = size;
        this.l = rwVar;
        size.getClass();
        FrameLayout frameLayout = this.b;
        TextureView textureView = new TextureView(frameLayout.getContext());
        this.e = textureView;
        textureView.setLayoutParams(new FrameLayout.LayoutParams(this.a.getWidth(), this.a.getHeight()));
        this.e.setSurfaceTextureListener(new e03(this));
        frameLayout.removeAllViews();
        frameLayout.addView(this.e);
        fu2 fu2Var2 = this.h;
        if (fu2Var2 != null) {
            fu2Var2.c();
        }
        this.h = fu2Var;
        Executor executorB = al4.b(this.e.getContext());
        v62 v62Var = new v62(7, this, fu2Var);
        o62 o62Var = fu2Var.j.c;
        if (o62Var != null) {
            o62Var.a(v62Var, executorB);
        }
        h();
    }

    @Override // defpackage.s02
    public final wc1 g() {
        tp tpVar = new tp();
        tpVar.c = new o62();
        wp wpVar = new wp(tpVar);
        tpVar.b = wpVar;
        tpVar.a = cq.class;
        try {
            this.k.set(tpVar);
            tpVar.a = "textureViewImpl_waitForNextFrame";
            return wpVar;
        } catch (Exception e) {
            wpVar.b(e);
            return wpVar;
        }
    }

    public final void h() {
        SurfaceTexture surfaceTexture;
        Size size = this.a;
        if (size == null || (surfaceTexture = this.f) == null || this.h == null) {
            return;
        }
        surfaceTexture.setDefaultBufferSize(size.getWidth(), this.a.getHeight());
        Surface surface = new Surface(this.f);
        fu2 fu2Var = this.h;
        wp wpVarA = hg4.a(new qq(9, this, surface));
        this.g = wpVarA;
        wpVarA.b.a(new os(this, surface, wpVarA, fu2Var, 4), al4.b(this.e.getContext()));
        this.d = true;
        f();
    }
}
