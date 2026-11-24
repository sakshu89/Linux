package defpackage;

import android.graphics.Bitmap;
import android.graphics.RectF;
import android.util.Size;
import android.view.Display;
import android.view.TextureView;
import android.view.View;
import android.widget.FrameLayout;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class s02 {
    public Size a;
    public final FrameLayout b;
    public final l02 c;
    public boolean d = false;

    public s02(FrameLayout frameLayout, l02 l02Var) {
        this.b = frameLayout;
        this.c = l02Var;
    }

    public abstract View a();

    public abstract Bitmap b();

    public abstract void c();

    public abstract void d();

    public abstract void e(fu2 fu2Var, rw rwVar);

    public final void f() {
        View viewA = a();
        if (viewA == null || !this.d) {
            return;
        }
        FrameLayout frameLayout = this.b;
        Size size = new Size(frameLayout.getWidth(), frameLayout.getHeight());
        int layoutDirection = frameLayout.getLayoutDirection();
        l02 l02Var = this.c;
        l02Var.getClass();
        if (size.getHeight() == 0 || size.getWidth() == 0) {
            xq4.d("PreviewTransform", "Transform not applied due to PreviewView size: " + size);
            return;
        }
        if (l02Var.f()) {
            if (viewA instanceof TextureView) {
                ((TextureView) viewA).setTransform(l02Var.d());
            } else {
                Display display = viewA.getDisplay();
                boolean z = false;
                boolean z2 = (!l02Var.g || display == null || display.getRotation() == l02Var.e) ? false : true;
                boolean z3 = l02Var.g;
                if (!z3) {
                    if ((!z3 ? l02Var.c : -pg4.b(l02Var.e)) != 0) {
                        z = true;
                    }
                }
                if (z2 || z) {
                    xq4.a("PreviewTransform", "Custom rotation not supported with SurfaceView/PERFORMANCE mode.");
                }
            }
            RectF rectFE = l02Var.e(size, layoutDirection);
            viewA.setPivotX(0.0f);
            viewA.setPivotY(0.0f);
            viewA.setScaleX(rectFE.width() / l02Var.a.getWidth());
            viewA.setScaleY(rectFE.height() / l02Var.a.getHeight());
            viewA.setTranslationX(rectFE.left - viewA.getLeft());
            viewA.setTranslationY(rectFE.top - viewA.getTop());
        }
    }

    public abstract wc1 g();
}
