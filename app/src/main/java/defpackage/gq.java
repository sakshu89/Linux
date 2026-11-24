package defpackage;

import android.content.Intent;
import android.content.IntentSender;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class gq implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ int c;
    public final /* synthetic */ Object e;

    public /* synthetic */ gq(int i, int i2, Object obj, Object obj2) {
        this.a = i2;
        this.b = obj;
        this.c = i;
        this.e = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.a;
        Object obj = this.e;
        int i2 = this.c;
        Object obj2 = this.b;
        switch (i) {
            case 0:
                ((es) obj2).c(i2, (el1) obj);
                break;
            case 1:
                ((es) obj2).b(i2, (ls) obj);
                break;
            case 2:
                ((CameraCaptureSession.CaptureCallback) ((iq) obj2).b).onCaptureSequenceAborted((CameraCaptureSession) obj, i2);
                break;
            case 3:
                ((CameraDevice.StateCallback) ((rq) obj2).b).onError((CameraDevice) obj, i2);
                break;
            case 4:
                m10 m10Var = (m10) obj2;
                Object obj3 = ((c4) obj).a;
                String str = (String) m10Var.a.get(Integer.valueOf(i2));
                if (str != null) {
                    f4 f4Var = (f4) m10Var.e.get(str);
                    if ((f4Var != null ? f4Var.a : null) != null) {
                        ag1 ag1Var = f4Var.a;
                        if (m10Var.d.remove(str)) {
                            ag1Var.a(obj3);
                        }
                    } else {
                        m10Var.g.remove(str);
                        m10Var.f.put(str, obj3);
                    }
                    break;
                }
                break;
            case 5:
                ((m10) obj2).a(i2, 0, new Intent().setAction("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST").putExtra("androidx.activity.result.contract.extra.SEND_INTENT_EXCEPTION", (IntentSender.SendIntentException) obj));
                break;
            default:
                ((l12) ((sc0) obj2).c).f(i2, obj);
                break;
        }
    }

    public /* synthetic */ gq(Object obj, AutoCloseable autoCloseable, int i, int i2) {
        this.a = i2;
        this.b = obj;
        this.e = autoCloseable;
        this.c = i;
    }
}
