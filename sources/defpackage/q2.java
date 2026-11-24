package defpackage;

import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.AccessibilityService$TakeScreenshotCallback;
import android.graphics.Bitmap;
import android.hardware.HardwareBuffer;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class q2 implements AccessibilityService$TakeScreenshotCallback {
    public final /* synthetic */ AtomicBoolean a;
    public final /* synthetic */ hq0 b;

    public q2(AtomicBoolean atomicBoolean, hq0 hq0Var) {
        this.a = atomicBoolean;
        this.b = hq0Var;
    }

    public final void onFailure(int i) {
        r2.a(this.a, this.b, new yc2(Integer.valueOf(i)));
    }

    /* JADX WARN: Code duplicated, block: B:15:0x002e  */
    /* JADX WARN: Code duplicated, block: B:49:0x006e  */
    /* JADX WARN: Code duplicated, block: B:52:0x0073  */
    /* JADX WARN: Code duplicated, block: B:53:0x0079  */
    public final void onSuccess(AccessibilityService.ScreenshotResult screenshotResult) {
        Object h72Var;
        boolean z;
        Object obj;
        Bitmap bitmap;
        ad2 yc2Var;
        Bitmap bitmapWrapHardwareBuffer;
        Bitmap bitmap2;
        screenshotResult.getClass();
        try {
            HardwareBuffer hardwareBuffer = screenshotResult.getHardwareBuffer();
            hardwareBuffer.getClass();
            try {
                bitmapWrapHardwareBuffer = Bitmap.wrapHardwareBuffer(hardwareBuffer, screenshotResult.getColorSpace());
                if (bitmapWrapHardwareBuffer != null) {
                    try {
                        Bitmap bitmapCopy = bitmapWrapHardwareBuffer.copy(Bitmap.Config.ARGB_8888, false);
                        if (bitmapCopy == null) {
                            bitmap2 = null;
                        } else {
                            if (bitmapCopy != bitmapWrapHardwareBuffer) {
                                Bitmap.Config config = bitmapCopy.getConfig();
                                bitmap2 = bitmapCopy;
                                if (config == Bitmap.Config.HARDWARE) {
                                }
                                h72Var = new h72(th);
                                z = h72Var instanceof h72;
                                obj = h72Var;
                                if (z) {
                                    obj = null;
                                }
                                bitmap = (Bitmap) obj;
                                if (bitmap != null) {
                                    yc2Var = new zc2(bitmap);
                                } else {
                                    yc2Var = new yc2(null);
                                }
                                r2.a(this.a, this.b, yc2Var);
                            }
                            bitmapCopy.recycle();
                            bitmap2 = null;
                        }
                    } catch (Throwable th) {
                        th = th;
                        if (bitmapWrapHardwareBuffer != null) {
                            try {
                                if (bitmapWrapHardwareBuffer.isRecycled()) {
                                    bitmapWrapHardwareBuffer = null;
                                }
                                if (bitmapWrapHardwareBuffer != null) {
                                    bitmapWrapHardwareBuffer.recycle();
                                }
                            } finally {
                                hardwareBuffer.close();
                            }
                        }
                        throw th;
                    }
                } else {
                    bitmap2 = null;
                }
                if (bitmapWrapHardwareBuffer != null) {
                    try {
                        if (bitmapWrapHardwareBuffer.isRecycled()) {
                            bitmapWrapHardwareBuffer = null;
                        }
                        if (bitmapWrapHardwareBuffer != null) {
                            bitmapWrapHardwareBuffer.recycle();
                        }
                    } catch (Throwable th2) {
                        hardwareBuffer.close();
                        throw th2;
                    }
                }
                hardwareBuffer.close();
                h72Var = bitmap2;
                z = h72Var instanceof h72;
                obj = h72Var;
                if (z) {
                    obj = null;
                }
                bitmap = (Bitmap) obj;
                if (bitmap != null) {
                    yc2Var = new zc2(bitmap);
                } else {
                    yc2Var = new yc2(null);
                }
                r2.a(this.a, this.b, yc2Var);
            } catch (Throwable th3) {
                th = th3;
                bitmapWrapHardwareBuffer = null;
            }
        } catch (Throwable th4) {
            h72Var = new h72(th4);
        }
    }
}
