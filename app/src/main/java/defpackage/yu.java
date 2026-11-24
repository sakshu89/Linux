package defpackage;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import java.util.LinkedHashSet;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class yu {
    public static final ju a;

    static {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.add(new xa1(2));
        a = new ju(linkedHashSet);
    }

    public static void a(Context context, l11 l11Var, ju juVar) throws xu {
        Integer numB;
        int i = 0;
        IllegalArgumentException illegalArgumentException = null;
        if (Build.VERSION.SDK_INT >= 34 && v2.e(context) != 0) {
            LinkedHashSet linkedHashSetW = l11Var.w();
            if (linkedHashSetW.isEmpty()) {
                throw new xu("No cameras available", 0, null);
            }
            v2.e(context);
            linkedHashSetW.size();
            xq4.c(3, "CameraValidator");
            return;
        }
        if (juVar != null) {
            try {
                numB = juVar.b();
                if (numB == null) {
                    xq4.d("CameraValidator", "No lens facing info in the availableCamerasSelector, don't verify the camera lens facing.");
                    return;
                }
            } catch (IllegalStateException e) {
                xq4.b("CameraValidator", "Cannot get lens facing from the availableCamerasSelector don't verify the camera lens facing.", e);
                return;
            }
        } else {
            numB = null;
        }
        String str = Build.DEVICE;
        xq4.c(3, "CameraValidator");
        PackageManager packageManager = context.getPackageManager();
        try {
            if (packageManager.hasSystemFeature("android.hardware.camera") && (juVar == null || numB.intValue() == 1)) {
                ju.c.c(l11Var.w());
                i = 1;
            }
        } catch (IllegalArgumentException e2) {
            illegalArgumentException = e2;
            xq4.e("CameraValidator", "Camera LENS_FACING_BACK verification failed", illegalArgumentException);
        }
        try {
            if (packageManager.hasSystemFeature("android.hardware.camera.front") && (juVar == null || numB.intValue() == 0)) {
                ju.b.c(l11Var.w());
                i++;
            }
        } catch (IllegalArgumentException e3) {
            illegalArgumentException = e3;
            xq4.e("CameraValidator", "Camera LENS_FACING_FRONT verification failed", illegalArgumentException);
        }
        try {
            a.c(l11Var.w());
            xq4.c(3, "CameraValidator");
            i++;
        } catch (IllegalArgumentException unused) {
        }
        if (illegalArgumentException == null) {
            return;
        }
        xq4.a("CameraValidator", "Camera LensFacing verification failed, existing cameras: " + l11Var.w());
        throw new xu("Expected camera missing from device.", i, illegalArgumentException);
    }
}
