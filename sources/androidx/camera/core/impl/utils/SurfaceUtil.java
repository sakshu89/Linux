package androidx.camera.core.impl.utils;

import android.view.Surface;
import defpackage.xy;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class SurfaceUtil {
    static {
        System.loadLibrary("surface_util_jni");
    }

    public static xy a(Surface surface) {
        int[] iArrNativeGetSurfaceInfo = nativeGetSurfaceInfo(surface);
        xy xyVar = new xy(19);
        int i = iArrNativeGetSurfaceInfo[0];
        int i2 = iArrNativeGetSurfaceInfo[1];
        int i3 = iArrNativeGetSurfaceInfo[2];
        return xyVar;
    }

    private static native int[] nativeGetSurfaceInfo(Surface surface);
}
