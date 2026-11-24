package defpackage;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureRequest;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public interface nh2 {
    Object a();

    int b();

    CameraCaptureSession.StateCallback c();

    List d();

    j11 e();

    Executor f();

    void g(CaptureRequest captureRequest);

    void h(j11 j11Var);
}
