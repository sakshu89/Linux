package defpackage;

import android.hardware.camera2.CameraManager;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class yt extends CameraManager.AvailabilityCallback {
    public final ch2 a;
    public final tq b;
    public final Object c = new Object();
    public boolean d = false;

    public yt(ch2 ch2Var, tq tqVar) {
        this.a = ch2Var;
        this.b = tqVar;
    }

    @Override // android.hardware.camera2.CameraManager.AvailabilityCallback
    public final void onCameraAccessPrioritiesChanged() {
        synchronized (this.c) {
            try {
                if (!this.d) {
                    this.a.execute(new s7(9, this));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.hardware.camera2.CameraManager.AvailabilityCallback
    public final void onCameraAvailable(String str) {
        synchronized (this.c) {
            try {
                if (!this.d) {
                    this.a.execute(new xt(this, str, 0));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.hardware.camera2.CameraManager.AvailabilityCallback
    public final void onCameraUnavailable(String str) {
        synchronized (this.c) {
            try {
                if (!this.d) {
                    this.a.execute(new xt(this, str, 1));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
