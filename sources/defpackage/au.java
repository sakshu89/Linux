package defpackage;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class au extends l11 {
    public static boolean J(RuntimeException runtimeException) {
        StackTraceElement[] stackTrace;
        if (Build.VERSION.SDK_INT == 28) {
            if ((!runtimeException.getClass().equals(RuntimeException.class) || (stackTrace = runtimeException.getStackTrace()) == null || stackTrace.length < 0) ? false : "_enableShutterSound".equals(stackTrace[0].getMethodName())) {
                return true;
            }
        }
        return false;
    }

    @Override // defpackage.l11
    public void D(String str, Executor executor, CameraDevice.StateCallback stateCallback) throws ds {
        try {
            try {
                ((CameraManager) this.b).openCamera(str, executor, stateCallback);
            } catch (SecurityException e) {
                throw e;
            }
        } catch (CameraAccessException e2) {
            throw new ds(e2);
        } catch (IllegalArgumentException | SecurityException e3) {
        } catch (RuntimeException e4) {
            if (!J(e4)) {
                throw e4;
            }
            throw new ds(e4);
        }
    }

    @Override // defpackage.l11
    public final void E(ch2 ch2Var, tq tqVar) {
        ((CameraManager) this.b).registerAvailabilityCallback(ch2Var, tqVar);
    }

    @Override // defpackage.l11
    public final void H(CameraManager.AvailabilityCallback availabilityCallback) {
        ((CameraManager) this.b).unregisterAvailabilityCallback(availabilityCallback);
    }

    @Override // defpackage.l11
    public CameraCharacteristics v(String str) throws ds {
        try {
            return super.v(str);
        } catch (RuntimeException e) {
            if (J(e)) {
                throw new ds(e);
            }
            throw e;
        }
    }
}
