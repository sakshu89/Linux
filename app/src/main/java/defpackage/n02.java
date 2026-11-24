package defpackage;

import android.hardware.display.DisplayManager;
import android.view.Display;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class n02 implements DisplayManager.DisplayListener {
    public final /* synthetic */ r02 a;

    public n02(r02 r02Var) {
        this.a = r02Var;
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public final void onDisplayChanged(int i) {
        r02 r02Var = this.a;
        Display display = r02Var.getDisplay();
        if (display == null || display.getDisplayId() != i) {
            return;
        }
        r02Var.a();
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public final void onDisplayAdded(int i) {
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public final void onDisplayRemoved(int i) {
    }
}
