package defpackage;

import android.hardware.camera2.CameraDevice;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class jt implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ rq b;
    public final /* synthetic */ CameraDevice c;

    public /* synthetic */ jt(rq rqVar, CameraDevice cameraDevice, int i) {
        this.a = i;
        this.b = rqVar;
        this.c = cameraDevice;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.a;
        CameraDevice cameraDevice = this.c;
        rq rqVar = this.b;
        switch (i) {
            case 0:
                ((CameraDevice.StateCallback) rqVar.b).onClosed(cameraDevice);
                break;
            case 1:
                ((CameraDevice.StateCallback) rqVar.b).onDisconnected(cameraDevice);
                break;
            default:
                ((CameraDevice.StateCallback) rqVar.b).onOpened(cameraDevice);
                break;
        }
    }
}
