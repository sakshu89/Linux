package androidx.camera.camera2.internal.compat.quirk;

import android.os.Build;
import defpackage.h22;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class ImageCaptureFailedWhenVideoCaptureIsBoundQuirk implements CaptureIntentPreviewQuirk, h22 {
    @Override // androidx.camera.camera2.internal.compat.quirk.CaptureIntentPreviewQuirk
    public final boolean a() {
        String str = Build.BRAND;
        if ("blu".equalsIgnoreCase(str) && "studio x10".equalsIgnoreCase(Build.MODEL)) {
            return true;
        }
        if ("itel".equalsIgnoreCase(str) && "itel w6004".equalsIgnoreCase(Build.MODEL)) {
            return true;
        }
        if ("vivo".equalsIgnoreCase(str) && "vivo 1805".equalsIgnoreCase(Build.MODEL)) {
            return true;
        }
        return "positivo".equalsIgnoreCase(str) && "twist 2 pro".equalsIgnoreCase(Build.MODEL);
    }
}
