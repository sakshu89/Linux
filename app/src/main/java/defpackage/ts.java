package defpackage;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureRequest;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ts extends l11 {
    @Override // defpackage.l11
    public final int G(CaptureRequest captureRequest, ch2 ch2Var, CameraCaptureSession.CaptureCallback captureCallback) {
        return ((CameraCaptureSession) this.b).setSingleRepeatingRequest(captureRequest, ch2Var, captureCallback);
    }

    @Override // defpackage.l11
    public final int r(ArrayList arrayList, ch2 ch2Var, CameraCaptureSession.CaptureCallback captureCallback) {
        return ((CameraCaptureSession) this.b).captureBurstRequests(arrayList, ch2Var, captureCallback);
    }
}
