package defpackage;

import android.hardware.camera2.CameraDevice;
import android.os.SystemClock;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class xq extends CameraDevice.StateCallback {
    public final ch2 a;
    public final xv0 b;
    public wq c;
    public ScheduledFuture d;
    public final vq e;
    public final /* synthetic */ yq f;

    public xq(yq yqVar, ch2 ch2Var, xv0 xv0Var, long j) {
        this.f = yqVar;
        this.a = ch2Var;
        this.b = xv0Var;
        this.e = new vq(this, j);
    }

    public final boolean a() {
        if (this.d == null) {
            return false;
        }
        this.f.t("Cancelling scheduled re-open: " + this.c);
        this.c.b = true;
        this.c = null;
        this.d.cancel(false);
        this.d = null;
        return true;
    }

    public final void b() {
        hh1.e(null, this.c == null);
        hh1.e(null, this.d == null);
        vq vqVar = this.e;
        vqVar.getClass();
        long jUptimeMillis = SystemClock.uptimeMillis();
        if (vqVar.b == -1) {
            vqVar.b = jUptimeMillis;
        }
        long j = jUptimeMillis - vqVar.b;
        long jC = vqVar.c();
        yq yqVar = this.f;
        if (j >= jC) {
            vqVar.b = -1L;
            xq4.a("Camera2CameraImpl", "Camera reopening attempted for " + vqVar.c() + "ms without success.");
            yqVar.F(4, null, false);
            return;
        }
        this.c = new wq(this, this.a);
        yqVar.t("Attempting camera re-open in " + vqVar.b() + "ms: " + this.c + " activeResuming = " + yqVar.l0);
        this.d = this.b.schedule(this.c, (long) vqVar.b(), TimeUnit.MILLISECONDS);
    }

    public final boolean c() {
        yq yqVar = this.f;
        if (!yqVar.l0) {
            return false;
        }
        int i = yqVar.t;
        return i == 1 || i == 2;
    }

    @Override // android.hardware.camera2.CameraDevice.StateCallback
    public final void onClosed(CameraDevice cameraDevice) {
        this.f.t("CameraDevice.onClosed()");
        hh1.e("Unexpected onClose callback on camera device: " + cameraDevice, this.f.s == null);
        int iX = cq.x(this.f.q0);
        if (iX == 1 || iX == 4) {
            hh1.e(null, this.f.v.isEmpty());
            this.f.r();
            return;
        }
        if (iX != 5 && iX != 6) {
            og.n("Camera closed while in state: ".concat(cq.y(this.f.q0)));
            return;
        }
        yq yqVar = this.f;
        int i = yqVar.t;
        if (i == 0) {
            yqVar.J(false);
        } else {
            yqVar.t("Camera closed due to error: ".concat(yq.v(i)));
            b();
        }
    }

    @Override // android.hardware.camera2.CameraDevice.StateCallback
    public final void onDisconnected(CameraDevice cameraDevice) {
        this.f.t("CameraDevice.onDisconnected()");
        onError(cameraDevice, 1);
    }

    @Override // android.hardware.camera2.CameraDevice.StateCallback
    public final void onError(CameraDevice cameraDevice, int i) {
        yq yqVar = this.f;
        yqVar.s = cameraDevice;
        yqVar.t = i;
        l11 l11Var = yqVar.p0;
        ((yq) l11Var.c).t("Camera receive onErrorCallback");
        l11Var.q();
        int iX = cq.x(this.f.q0);
        if (iX != 1) {
            switch (iX) {
                case 4:
                    break;
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                    cameraDevice.getId();
                    cq.w(this.f.q0);
                    int i2 = 3;
                    xq4.c(3, "Camera2CameraImpl");
                    hh1.e("Attempt to handle open error from non open state: ".concat(cq.y(this.f.q0)), this.f.q0 == 8 || this.f.q0 == 9 || this.f.q0 == 10 || this.f.q0 == 7 || this.f.q0 == 6);
                    if (i == 1 || i == 2 || i == 4) {
                        cameraDevice.getId();
                        xq4.c(3, "Camera2CameraImpl");
                        yq yqVar2 = this.f;
                        hh1.e("Can only reopen camera device after error if the camera device is actually in an error state.", yqVar2.t != 0);
                        if (i == 1) {
                            i2 = 2;
                        } else if (i == 2) {
                            i2 = 1;
                        }
                        yqVar2.F(7, new wh(i2, null), true);
                        yqVar2.q();
                    } else {
                        xq4.a("Camera2CameraImpl", "Error observed on open (or opening) camera device " + cameraDevice.getId() + ": " + yq.v(i) + " closing camera.");
                        this.f.F(5, new wh(i == 3 ? 5 : 6, null), true);
                        this.f.q();
                    }
                    break;
                default:
                    og.n("onError() should not be possible from state: ".concat(cq.y(this.f.q0)));
                    break;
            }
            return;
        }
        String id = cameraDevice.getId();
        String strV = yq.v(i);
        String strW = cq.w(this.f.q0);
        StringBuilder sbQ = cq.q("CameraDevice.onError(): ", id, " failed with ", strV, " while in ");
        sbQ.append(strW);
        sbQ.append(" state. Will finish closing camera.");
        xq4.a("Camera2CameraImpl", sbQ.toString());
        this.f.q();
    }

    @Override // android.hardware.camera2.CameraDevice.StateCallback
    public final void onOpened(CameraDevice cameraDevice) {
        this.f.t("CameraDevice.onOpened()");
        yq yqVar = this.f;
        yqVar.s = cameraDevice;
        yqVar.t = 0;
        this.e.b = -1L;
        int iX = cq.x(yqVar.q0);
        if (iX == 1 || iX == 4) {
            hh1.e(null, this.f.v.isEmpty());
            this.f.s.close();
            this.f.s = null;
        } else {
            if (iX != 5 && iX != 6 && iX != 7) {
                og.n("onOpened() should not be possible from state: ".concat(cq.y(this.f.q0)));
                return;
            }
            this.f.E(9);
            ru ruVar = this.f.X;
            String id = cameraDevice.getId();
            yq yqVar2 = this.f;
            if (ruVar.e(id, yqVar2.H.m(yqVar2.s.getId()))) {
                this.f.B();
            }
        }
    }
}
