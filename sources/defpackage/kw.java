package defpackage;

import android.hardware.camera2.CameraCaptureSession;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class kw extends es {
    public final CameraCaptureSession.CaptureCallback a;

    public kw(CameraCaptureSession.CaptureCallback captureCallback) {
        if (captureCallback != null) {
            this.a = captureCallback;
        } else {
            dk0.n("captureCallback is null");
            throw null;
        }
    }
}
