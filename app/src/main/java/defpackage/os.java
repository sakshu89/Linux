package defpackage;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureFailure;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.view.Surface;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class os implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ Object e;
    public final /* synthetic */ Object f;

    public /* synthetic */ os(Object obj, Object obj2, Object obj3, Object obj4, int i) {
        this.a = i;
        this.b = obj;
        this.c = obj2;
        this.e = obj3;
        this.f = obj4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.a;
        Object obj = this.f;
        Object obj2 = this.e;
        Object obj3 = this.c;
        Object obj4 = this.b;
        switch (i) {
            case 0:
                ((CameraCaptureSession.CaptureCallback) ((iq) obj4).b).onCaptureCompleted((CameraCaptureSession) obj3, (CaptureRequest) obj2, (TotalCaptureResult) obj);
                break;
            case 1:
                ((CameraCaptureSession.CaptureCallback) ((iq) obj4).b).onCaptureProgressed((CameraCaptureSession) obj3, (CaptureRequest) obj2, (CaptureResult) obj);
                break;
            case 2:
                ((CameraCaptureSession.CaptureCallback) ((iq) obj4).b).onCaptureFailed((CameraCaptureSession) obj3, (CaptureRequest) obj2, (CaptureFailure) obj);
                break;
            case 3:
                ((ry0) obj4).E((kf) obj3, (Executor) obj2, (uf1) obj);
                break;
            default:
                f03 f03Var = (f03) obj4;
                Surface surface = (Surface) obj3;
                wp wpVar = (wp) obj2;
                fu2 fu2Var = (fu2) obj;
                xq4.c(3, "TextureViewImpl");
                rw rwVar = f03Var.l;
                if (rwVar != null) {
                    rwVar.a();
                    f03Var.l = null;
                }
                surface.release();
                if (f03Var.g == wpVar) {
                    f03Var.g = null;
                }
                if (f03Var.h == fu2Var) {
                    f03Var.h = null;
                }
                break;
        }
    }
}
