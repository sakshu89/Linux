package defpackage;

import android.hardware.camera2.CameraCaptureSession;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class rs implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ ss b;
    public final /* synthetic */ CameraCaptureSession c;

    public /* synthetic */ rs(ss ssVar, CameraCaptureSession cameraCaptureSession, int i) {
        this.a = i;
        this.b = ssVar;
        this.c = cameraCaptureSession;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.a;
        CameraCaptureSession cameraCaptureSession = this.c;
        ss ssVar = this.b;
        switch (i) {
            case 0:
                ssVar.a.onActive(cameraCaptureSession);
                break;
            case 1:
                ssVar.a.onClosed(cameraCaptureSession);
                break;
            case 2:
                ssVar.a.onCaptureQueueEmpty(cameraCaptureSession);
                break;
            case 3:
                ssVar.a.onConfigured(cameraCaptureSession);
                break;
            case 4:
                ssVar.a.onReady(cameraCaptureSession);
                break;
            default:
                ssVar.a.onConfigureFailed(cameraCaptureSession);
                break;
        }
    }
}
