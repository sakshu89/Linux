package defpackage;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureFailure;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.view.Surface;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class cr extends CameraCaptureSession.CaptureCallback {
    public final /* synthetic */ int a;
    public final Object b;

    public cr(List list) {
        this.a = 0;
        this.b = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            CameraCaptureSession.CaptureCallback captureCallback = (CameraCaptureSession.CaptureCallback) it.next();
            if (!(captureCallback instanceof dr)) {
                ((ArrayList) this.b).add(captureCallback);
            }
        }
    }

    public static int a(CaptureRequest captureRequest) {
        Integer num;
        if ((captureRequest.getTag() instanceof iv2) && (num = (Integer) ((iv2) captureRequest.getTag()).a.get("CAPTURE_CONFIG_ID_KEY")) != null) {
            return num.intValue();
        }
        return -1;
    }

    @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
    public void onCaptureBufferLost(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, Surface surface, long j) {
        switch (this.a) {
            case 0:
                ArrayList arrayList = (ArrayList) this.b;
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    ((CameraCaptureSession.CaptureCallback) arrayList.get(i)).onCaptureBufferLost(cameraCaptureSession, captureRequest, surface, j);
                }
                break;
            default:
                super.onCaptureBufferLost(cameraCaptureSession, captureRequest, surface, j);
                break;
        }
    }

    @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
    public final void onCaptureCompleted(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, TotalCaptureResult totalCaptureResult) {
        iv2 iv2Var;
        switch (this.a) {
            case 0:
                ArrayList arrayList = (ArrayList) this.b;
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    Object obj = arrayList.get(i);
                    i++;
                    ((CameraCaptureSession.CaptureCallback) obj).onCaptureCompleted(cameraCaptureSession, captureRequest, totalCaptureResult);
                }
                return;
            case 1:
                super.onCaptureCompleted(cameraCaptureSession, captureRequest, totalCaptureResult);
                Object tag = captureRequest.getTag();
                if (tag != null) {
                    hh1.a("The tagBundle object from the CaptureResult is not a TagBundle object.", tag instanceof iv2);
                    iv2Var = (iv2) tag;
                } else {
                    iv2Var = iv2.b;
                }
                ((es) this.b).b(a(captureRequest), new l11(8, iv2Var, totalCaptureResult));
                return;
            default:
                synchronized (((tw) this.b).a) {
                    try {
                        kh2 kh2Var = ((tw) this.b).f;
                        if (kh2Var == null) {
                            return;
                        }
                        lw lwVar = kh2Var.g;
                        xq4.c(3, "CaptureSession");
                        tw twVar = (tw) this.b;
                        twVar.n.getClass();
                        twVar.i(Collections.singletonList(rh2.a(lwVar)));
                        return;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
        }
    }

    @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
    public void onCaptureFailed(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, CaptureFailure captureFailure) {
        int i = this.a;
        Object obj = this.b;
        switch (i) {
            case 0:
                ArrayList arrayList = (ArrayList) obj;
                int size = arrayList.size();
                int i2 = 0;
                while (i2 < size) {
                    Object obj2 = arrayList.get(i2);
                    i2++;
                    ((CameraCaptureSession.CaptureCallback) obj2).onCaptureFailed(cameraCaptureSession, captureRequest, captureFailure);
                }
                break;
            case 1:
                super.onCaptureFailed(cameraCaptureSession, captureRequest, captureFailure);
                ((es) obj).c(a(captureRequest), new el1(10));
                break;
            default:
                super.onCaptureFailed(cameraCaptureSession, captureRequest, captureFailure);
                break;
        }
    }

    @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
    public void onCaptureProgressed(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, CaptureResult captureResult) {
        switch (this.a) {
            case 0:
                ArrayList arrayList = (ArrayList) this.b;
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    Object obj = arrayList.get(i);
                    i++;
                    ((CameraCaptureSession.CaptureCallback) obj).onCaptureProgressed(cameraCaptureSession, captureRequest, captureResult);
                }
                break;
            default:
                super.onCaptureProgressed(cameraCaptureSession, captureRequest, captureResult);
                break;
        }
    }

    @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
    public void onCaptureSequenceAborted(CameraCaptureSession cameraCaptureSession, int i) {
        switch (this.a) {
            case 0:
                ArrayList arrayList = (ArrayList) this.b;
                int size = arrayList.size();
                int i2 = 0;
                while (i2 < size) {
                    Object obj = arrayList.get(i2);
                    i2++;
                    ((CameraCaptureSession.CaptureCallback) obj).onCaptureSequenceAborted(cameraCaptureSession, i);
                }
                break;
            default:
                super.onCaptureSequenceAborted(cameraCaptureSession, i);
                break;
        }
    }

    @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
    public void onCaptureSequenceCompleted(CameraCaptureSession cameraCaptureSession, int i, long j) {
        switch (this.a) {
            case 0:
                ArrayList arrayList = (ArrayList) this.b;
                int size = arrayList.size();
                int i2 = 0;
                while (i2 < size) {
                    Object obj = arrayList.get(i2);
                    i2++;
                    ((CameraCaptureSession.CaptureCallback) obj).onCaptureSequenceCompleted(cameraCaptureSession, i, j);
                }
                break;
            default:
                super.onCaptureSequenceCompleted(cameraCaptureSession, i, j);
                break;
        }
    }

    @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
    public void onCaptureStarted(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, long j, long j2) {
        int i = this.a;
        Object obj = this.b;
        switch (i) {
            case 0:
                ArrayList arrayList = (ArrayList) obj;
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ((CameraCaptureSession.CaptureCallback) arrayList.get(i2)).onCaptureStarted(cameraCaptureSession, captureRequest, j, j2);
                }
                break;
            case 1:
                super.onCaptureStarted(cameraCaptureSession, captureRequest, j, j2);
                ((es) obj).d(a(captureRequest));
                break;
            default:
                super.onCaptureStarted(cameraCaptureSession, captureRequest, j, j2);
                break;
        }
    }

    public cr(es esVar) {
        this.a = 1;
        if (esVar != null) {
            this.b = esVar;
        } else {
            dk0.n("cameraCaptureCallback is null");
            throw null;
        }
    }

    public cr(tw twVar) {
        this.a = 2;
        this.b = twVar;
    }
}
