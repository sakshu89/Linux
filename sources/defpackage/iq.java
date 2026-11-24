package defpackage;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureFailure;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.view.Surface;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class iq extends CameraCaptureSession.CaptureCallback {
    public final /* synthetic */ int a;
    public final Object b;
    public Object c;

    public iq(int i) {
        this.a = i;
        switch (i) {
            case 3:
                this.b = hg4.a(new zq(7, this));
                break;
            default:
                this.c = null;
                this.b = new HashMap();
                break;
        }
    }

    public void a(CaptureRequest captureRequest, List list) {
        HashMap map = (HashMap) this.b;
        List list2 = (List) map.get(captureRequest);
        if (list2 == null) {
            map.put(captureRequest, list);
            return;
        }
        ArrayList arrayList = new ArrayList(list2.size() + list.size());
        arrayList.addAll(list);
        arrayList.addAll(list2);
        map.put(captureRequest, arrayList);
    }

    public void b() {
        tp tpVar = (tp) this.c;
        if (tpVar != null) {
            tpVar.a(null);
            this.c = null;
        }
    }

    public List c(CaptureRequest captureRequest) {
        List list = (List) ((HashMap) this.b).get(captureRequest);
        return list != null ? list : Collections.EMPTY_LIST;
    }

    @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
    public void onCaptureBufferLost(final CameraCaptureSession cameraCaptureSession, final CaptureRequest captureRequest, final Surface surface, final long j) {
        switch (this.a) {
            case 1:
                Iterator it = c(captureRequest).iterator();
                while (it.hasNext()) {
                    ((CameraCaptureSession.CaptureCallback) it.next()).onCaptureBufferLost(cameraCaptureSession, captureRequest, surface, j);
                }
                break;
            case 2:
                ((ch2) this.c).execute(new Runnable() { // from class: qs
                    @Override // java.lang.Runnable
                    public final void run() {
                        ((CameraCaptureSession.CaptureCallback) this.a.b).onCaptureBufferLost(cameraCaptureSession, captureRequest, surface, j);
                    }
                });
                break;
            default:
                super.onCaptureBufferLost(cameraCaptureSession, captureRequest, surface, j);
                break;
        }
    }

    @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
    public final void onCaptureCompleted(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, TotalCaptureResult totalCaptureResult) {
        switch (this.a) {
            case 0:
                ((ch2) this.c).execute(new o8(4, this, totalCaptureResult));
                break;
            case 1:
                Iterator it = c(captureRequest).iterator();
                while (it.hasNext()) {
                    ((CameraCaptureSession.CaptureCallback) it.next()).onCaptureCompleted(cameraCaptureSession, captureRequest, totalCaptureResult);
                }
                break;
            case 2:
                ((ch2) this.c).execute(new os(this, cameraCaptureSession, captureRequest, totalCaptureResult, 0));
                break;
            default:
                b();
                break;
        }
    }

    @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
    public void onCaptureFailed(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, CaptureFailure captureFailure) {
        switch (this.a) {
            case 1:
                Iterator it = c(captureRequest).iterator();
                while (it.hasNext()) {
                    ((CameraCaptureSession.CaptureCallback) it.next()).onCaptureFailed(cameraCaptureSession, captureRequest, captureFailure);
                }
                break;
            case 2:
                ((ch2) this.c).execute(new os(this, cameraCaptureSession, captureRequest, captureFailure, 2));
                break;
            case 3:
                b();
                break;
            default:
                super.onCaptureFailed(cameraCaptureSession, captureRequest, captureFailure);
                break;
        }
    }

    @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
    public void onCaptureProgressed(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, CaptureResult captureResult) {
        switch (this.a) {
            case 1:
                Iterator it = c(captureRequest).iterator();
                while (it.hasNext()) {
                    ((CameraCaptureSession.CaptureCallback) it.next()).onCaptureProgressed(cameraCaptureSession, captureRequest, captureResult);
                }
                break;
            case 2:
                ((ch2) this.c).execute(new os(this, cameraCaptureSession, captureRequest, captureResult, 1));
                break;
            default:
                super.onCaptureProgressed(cameraCaptureSession, captureRequest, captureResult);
                break;
        }
    }

    @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
    public void onCaptureSequenceAborted(CameraCaptureSession cameraCaptureSession, int i) {
        switch (this.a) {
            case 1:
                Iterator it = ((HashMap) this.b).values().iterator();
                while (it.hasNext()) {
                    Iterator it2 = ((List) it.next()).iterator();
                    while (it2.hasNext()) {
                        ((CameraCaptureSession.CaptureCallback) it2.next()).onCaptureSequenceAborted(cameraCaptureSession, i);
                    }
                }
                qw qwVar = (qw) this.c;
                if (qwVar != null) {
                    qwVar.a();
                }
                break;
            case 2:
                ((ch2) this.c).execute(new gq(this, cameraCaptureSession, i, 2));
                break;
            case 3:
                b();
                break;
            default:
                super.onCaptureSequenceAborted(cameraCaptureSession, i);
                break;
        }
    }

    @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
    public void onCaptureSequenceCompleted(final CameraCaptureSession cameraCaptureSession, final int i, final long j) {
        switch (this.a) {
            case 1:
                Iterator it = ((HashMap) this.b).values().iterator();
                while (it.hasNext()) {
                    Iterator it2 = ((List) it.next()).iterator();
                    while (it2.hasNext()) {
                        ((CameraCaptureSession.CaptureCallback) it2.next()).onCaptureSequenceCompleted(cameraCaptureSession, i, j);
                    }
                }
                qw qwVar = (qw) this.c;
                if (qwVar != null) {
                    qwVar.a();
                }
                break;
            case 2:
                ((ch2) this.c).execute(new Runnable() { // from class: ps
                    @Override // java.lang.Runnable
                    public final void run() {
                        ((CameraCaptureSession.CaptureCallback) this.a.b).onCaptureSequenceCompleted(cameraCaptureSession, i, j);
                    }
                });
                break;
            case 3:
                b();
                break;
            default:
                super.onCaptureSequenceCompleted(cameraCaptureSession, i, j);
                break;
        }
    }

    @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
    public void onCaptureStarted(final CameraCaptureSession cameraCaptureSession, final CaptureRequest captureRequest, final long j, final long j2) {
        switch (this.a) {
            case 1:
                Iterator it = c(captureRequest).iterator();
                while (it.hasNext()) {
                    ((CameraCaptureSession.CaptureCallback) it.next()).onCaptureStarted(cameraCaptureSession, captureRequest, j, j2);
                }
                break;
            case 2:
                ((ch2) this.c).execute(new Runnable() { // from class: ns
                    @Override // java.lang.Runnable
                    public final void run() {
                        ((CameraCaptureSession.CaptureCallback) this.a.b).onCaptureStarted(cameraCaptureSession, captureRequest, j, j2);
                    }
                });
                break;
            case 3:
                b();
                break;
            default:
                super.onCaptureStarted(cameraCaptureSession, captureRequest, j, j2);
                break;
        }
    }

    public iq(ch2 ch2Var, CameraCaptureSession.CaptureCallback captureCallback) {
        this.a = 2;
        this.c = ch2Var;
        this.b = captureCallback;
    }

    public iq(ch2 ch2Var) {
        this.a = 0;
        this.b = new HashSet();
        this.c = ch2Var;
    }
}
