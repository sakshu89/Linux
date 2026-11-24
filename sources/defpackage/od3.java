package defpackage;

import android.hardware.camera2.CameraCharacteristics;
import android.media.ImageWriter;
import androidx.camera.camera2.internal.compat.quirk.ZslDisablerQuirk;
import java.util.ArrayDeque;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class od3 {
    public final ys a;
    public final b13 b;
    public boolean c = false;
    public boolean d = false;
    public final boolean e;
    public final boolean f;
    public m92 g;
    public ow h;
    public nz0 i;
    public ImageWriter j;

    public od3(ys ysVar) {
        boolean z;
        this.e = false;
        this.f = false;
        this.a = ysVar;
        int[] iArr = (int[]) ysVar.a(CameraCharacteristics.REQUEST_AVAILABLE_CAPABILITIES);
        if (iArr == null) {
            z = false;
            break;
        }
        int length = iArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                z = false;
                break;
            } else {
                if (iArr[i] == 4) {
                    z = true;
                    break;
                }
                i++;
            }
        }
        this.e = z;
        this.f = wc0.a.d(ZslDisablerQuirk.class) != null;
        kf2 kf2Var = new kf2(13);
        b13 b13Var = new b13();
        b13Var.b = new Object();
        b13Var.a = new ArrayDeque(3);
        b13Var.c = kf2Var;
        this.b = b13Var;
    }
}
