package defpackage;

import android.hardware.camera2.CameraCaptureSession;
import android.media.ImageWriter;
import android.view.Surface;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class vs extends CameraCaptureSession.StateCallback {
    public final /* synthetic */ int a;
    public final Object b;

    public vs(List list) {
        this.a = 0;
        this.b = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            CameraCaptureSession.StateCallback stateCallback = (CameraCaptureSession.StateCallback) it.next();
            if (!(stateCallback instanceof ws)) {
                ((ArrayList) this.b).add(stateCallback);
            }
        }
    }

    @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
    public void onActive(CameraCaptureSession cameraCaptureSession) {
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
                    ((CameraCaptureSession.StateCallback) obj2).onActive(cameraCaptureSession);
                }
                break;
            case 1:
                bv2 bv2Var = (bv2) obj;
                bv2Var.k(cameraCaptureSession);
                bv2Var.a(bv2Var);
                break;
            default:
                super.onActive(cameraCaptureSession);
                break;
        }
    }

    @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
    public void onCaptureQueueEmpty(CameraCaptureSession cameraCaptureSession) {
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
                    ((CameraCaptureSession.StateCallback) obj2).onCaptureQueueEmpty(cameraCaptureSession);
                }
                break;
            case 1:
                bv2 bv2Var = (bv2) obj;
                bv2Var.k(cameraCaptureSession);
                bv2Var.b(bv2Var);
                break;
            default:
                super.onCaptureQueueEmpty(cameraCaptureSession);
                break;
        }
    }

    @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
    public void onClosed(CameraCaptureSession cameraCaptureSession) {
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
                    ((CameraCaptureSession.StateCallback) obj2).onClosed(cameraCaptureSession);
                }
                break;
            case 1:
                bv2 bv2Var = (bv2) obj;
                bv2Var.k(cameraCaptureSession);
                bv2Var.c(bv2Var);
                break;
            default:
                super.onClosed(cameraCaptureSession);
                break;
        }
    }

    @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
    public final void onConfigureFailed(CameraCaptureSession cameraCaptureSession) {
        tp tpVar;
        switch (this.a) {
            case 0:
                ArrayList arrayList = (ArrayList) this.b;
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    Object obj = arrayList.get(i);
                    i++;
                    ((CameraCaptureSession.StateCallback) obj).onConfigureFailed(cameraCaptureSession);
                }
                return;
            case 1:
                try {
                    ((bv2) this.b).k(cameraCaptureSession);
                    bv2 bv2Var = (bv2) this.b;
                    bv2Var.d(bv2Var);
                    synchronized (((bv2) this.b).a) {
                        hh1.d(((bv2) this.b).i, "OpenCaptureSession completer should not null");
                        bv2 bv2Var2 = (bv2) this.b;
                        tpVar = bv2Var2.i;
                        bv2Var2.i = null;
                        break;
                    }
                    return;
                } finally {
                    synchronized (((bv2) this.b).a) {
                        hh1.d(((bv2) this.b).i, "OpenCaptureSession completer should not null");
                        bv2 bv2Var3 = (bv2) this.b;
                        tpVar = bv2Var3.i;
                        bv2Var3.i = null;
                        tpVar.b(new IllegalStateException("onConfigureFailed"));
                    }
                }
            default:
                return;
        }
    }

    @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
    public final void onConfigured(CameraCaptureSession cameraCaptureSession) {
        tp tpVar;
        switch (this.a) {
            case 0:
                ArrayList arrayList = (ArrayList) this.b;
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    Object obj = arrayList.get(i);
                    i++;
                    ((CameraCaptureSession.StateCallback) obj).onConfigured(cameraCaptureSession);
                }
                return;
            case 1:
                try {
                    ((bv2) this.b).k(cameraCaptureSession);
                    bv2 bv2Var = (bv2) this.b;
                    bv2Var.e(bv2Var);
                    synchronized (((bv2) this.b).a) {
                        hh1.d(((bv2) this.b).i, "OpenCaptureSession completer should not null");
                        bv2 bv2Var2 = (bv2) this.b;
                        tpVar = bv2Var2.i;
                        bv2Var2.i = null;
                        break;
                    }
                    return;
                } finally {
                    synchronized (((bv2) this.b).a) {
                        hh1.d(((bv2) this.b).i, "OpenCaptureSession completer should not null");
                        bv2 bv2Var3 = (bv2) this.b;
                        tpVar = bv2Var3.i;
                        bv2Var3.i = null;
                        tpVar.a(null);
                    }
                }
            default:
                Surface inputSurface = cameraCaptureSession.getInputSurface();
                if (inputSurface != null) {
                    ((od3) this.b).j = ImageWriter.newInstance(inputSurface, 1);
                    return;
                }
                return;
        }
    }

    @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
    public void onReady(CameraCaptureSession cameraCaptureSession) {
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
                    ((CameraCaptureSession.StateCallback) obj2).onReady(cameraCaptureSession);
                }
                break;
            case 1:
                bv2 bv2Var = (bv2) obj;
                bv2Var.k(cameraCaptureSession);
                bv2Var.f(bv2Var);
                break;
            default:
                super.onReady(cameraCaptureSession);
                break;
        }
    }

    @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
    public void onSurfacePrepared(CameraCaptureSession cameraCaptureSession, Surface surface) {
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
                    ((CameraCaptureSession.StateCallback) obj2).onSurfacePrepared(cameraCaptureSession, surface);
                }
                break;
            case 1:
                bv2 bv2Var = (bv2) obj;
                bv2Var.k(cameraCaptureSession);
                bv2Var.h(bv2Var, surface);
                break;
            default:
                super.onSurfacePrepared(cameraCaptureSession, surface);
                break;
        }
    }

    private final void a(CameraCaptureSession cameraCaptureSession) {
    }

    public /* synthetic */ vs(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }
}
