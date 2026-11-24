package defpackage;

import android.view.View;
import android.view.Window;
import android.view.WindowManager;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class rb2 extends View {
    public Window a;
    public pb2 b;

    /* JADX INFO: Access modifiers changed from: private */
    public float getBrightness() {
        Window window = this.a;
        if (window != null) {
            return window.getAttributes().screenBrightness;
        }
        xq4.a("ScreenFlashView", "setBrightness: mScreenFlashWindow is null!");
        return Float.NaN;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBrightness(float f) {
        if (this.a == null) {
            xq4.a("ScreenFlashView", "setBrightness: mScreenFlashWindow is null!");
            return;
        }
        if (Float.isNaN(f)) {
            xq4.a("ScreenFlashView", "setBrightness: value is NaN!");
            return;
        }
        WindowManager.LayoutParams attributes = this.a.getAttributes();
        attributes.screenBrightness = f;
        this.a.setAttributes(attributes);
        xq4.c(3, "ScreenFlashView");
    }

    private void setScreenFlashUiInfo(qy0 qy0Var) {
        xq4.c(3, "ScreenFlashView");
    }

    public qy0 getScreenFlash() {
        return this.b;
    }

    public long getVisibilityRampUpAnimationDurationMillis() {
        return 1000L;
    }

    public void setController(ht htVar) {
        vc4.b();
    }

    public void setScreenFlashWindow(Window window) {
        vc4.b();
        if (this.a != window) {
            this.b = window == null ? null : new pb2(this);
        }
        this.a = window;
        setScreenFlashUiInfo(getScreenFlash());
    }
}
