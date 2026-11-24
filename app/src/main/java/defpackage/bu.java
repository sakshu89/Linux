package defpackage;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class bu extends au {
    @Override // defpackage.au, defpackage.l11
    public final void D(String str, Executor executor, CameraDevice.StateCallback stateCallback) throws ds {
        try {
            ((CameraManager) this.b).openCamera(str, executor, stateCallback);
        } catch (CameraAccessException e) {
            throw new ds(e);
        }
    }

    @Override // defpackage.au, defpackage.l11
    public final CameraCharacteristics v(String str) throws ds {
        try {
            return ((CameraManager) this.b).getCameraCharacteristics(str);
        } catch (CameraAccessException e) {
            throw new ds(e);
        }
    }
}
