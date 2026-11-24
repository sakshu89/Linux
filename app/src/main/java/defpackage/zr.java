package defpackage;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class zr extends q82 {
    public static final bi i = new bi("camera2.captureRequest.templateType", Integer.TYPE, null);
    public static final bi j = new bi("camera2.cameraCaptureSession.streamUseCase", Long.TYPE, null);
    public static final bi k = new bi("camera2.cameraDevice.stateCallback", CameraDevice.StateCallback.class, null);
    public static final bi n = new bi("camera2.cameraCaptureSession.stateCallback", CameraCaptureSession.StateCallback.class, null);
    public static final bi s = new bi("camera2.cameraCaptureSession.captureCallback", CameraCaptureSession.CaptureCallback.class, null);
    public static final bi t = new bi("camera2.cameraCaptureSession.physicalCameraId", String.class, null);

    public static bi M(CaptureRequest.Key key) {
        return new bi("camera2.captureRequest.option." + key.getName(), Object.class, key);
    }
}
