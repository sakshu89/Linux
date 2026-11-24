package defpackage;

import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraManager;
import android.os.Handler;
import android.os.Looper;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class j13 {
    public final Context a;
    public final CameraManager b;
    public final jr2 c;
    public final jr2 d;
    public final g32 e;
    public volatile boolean f;
    public final cv2 g;

    public j13(Context context) {
        this.a = context;
        CameraManager cameraManager = (CameraManager) context.getSystemService(CameraManager.class);
        this.b = cameraManager;
        jr2 jr2VarA = o54.a(Boolean.FALSE);
        this.c = jr2VarA;
        this.d = o54.a(null);
        this.e = new g32(jr2VarA);
        this.f = true;
        this.g = new cv2(new kb(25, this));
        h13 h13Var = new h13(this);
        if (cameraManager != null) {
            try {
                cameraManager.registerTorchCallback(h13Var, new Handler(Looper.getMainLooper()));
            } catch (Throwable unused) {
            }
        }
    }

    public final boolean a(String str, boolean z) {
        CameraCharacteristics cameraCharacteristics;
        Integer num;
        try {
            CameraManager cameraManager = this.b;
            if (cameraManager != null && (cameraCharacteristics = cameraManager.getCameraCharacteristics(str)) != null && g31.a(cameraCharacteristics.get(CameraCharacteristics.FLASH_INFO_AVAILABLE), Boolean.TRUE)) {
                return !z || ((num = (Integer) cameraCharacteristics.get(CameraCharacteristics.LENS_FACING)) != null && num.intValue() == 1);
            }
            return false;
        } catch (CameraAccessException | IllegalArgumentException unused) {
            return false;
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object b(boolean z, y50 y50Var) {
        i13 i13Var;
        String str;
        if (y50Var instanceof i13) {
            i13Var = (i13) y50Var;
            int i = i13Var.j;
            if ((i & Integer.MIN_VALUE) != 0) {
                i13Var.j = i - Integer.MIN_VALUE;
            } else {
                i13Var = new i13(this, y50Var);
            }
        } else {
            i13Var = new i13(this, y50Var);
        }
        Object objC = i13Var.f;
        int i2 = i13Var.j;
        int i3 = 1;
        x50 x50Var = null;
        if (i2 == 0) {
            bz3.g(objC);
            m13 m13Var = m13.a;
            CameraManager cameraManager = this.b;
            if (cameraManager == null || (str = (String) this.g.getValue()) == null) {
                return m13Var;
            }
            try {
                cameraManager.setTorchMode(str, z);
                iy2 iy2Var = new iy2(this, z, x50Var, i3);
                i13Var.e = z;
                i13Var.j = 1;
                objC = xc4.c(1500L, iy2Var, i13Var);
                t70 t70Var = t70.a;
                if (objC == t70Var) {
                    return t70Var;
                }
            } catch (CameraAccessException e) {
                String message = e.getMessage();
                if (message == null) {
                    message = "another app is using the camera";
                }
                return new k13(message);
            } catch (IllegalArgumentException unused) {
                return m13Var;
            } catch (SecurityException unused2) {
                return n13.a;
            }
        } else {
            if (i2 != 1) {
                og.n("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            z = i13Var.e;
            bz3.g(objC);
        }
        return ((Boolean) objC) != null ? new l13(z) : new o13();
    }
}
