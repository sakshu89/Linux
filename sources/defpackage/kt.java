package defpackage;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.params.SessionConfiguration;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class kt extends l11 {
    @Override // defpackage.l11
    public final void t(oh2 oh2Var) throws ds {
        SessionConfiguration sessionConfiguration = (SessionConfiguration) oh2Var.a.a();
        sessionConfiguration.getClass();
        try {
            ((CameraDevice) this.b).createCaptureSession(sessionConfiguration);
        } catch (CameraAccessException e) {
            throw new ds(e);
        }
    }
}
