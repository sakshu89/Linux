package defpackage;

import android.hardware.camera2.CameraCharacteristics;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class vg4 {
    public static String a(zt ztVar, Integer num, List list) {
        if (num != null && list.contains("0") && list.contains("1")) {
            if (num.intValue() == 1) {
                if (((Integer) ztVar.b("0").a(CameraCharacteristics.LENS_FACING)).intValue() == 1) {
                    return "1";
                }
            } else if (num.intValue() == 0 && ((Integer) ztVar.b("1").a(CameraCharacteristics.LENS_FACING)).intValue() == 0) {
                return "0";
            }
        }
        return null;
    }

    public static int b(int i) {
        return (i >>> 1) ^ (-(i & 1));
    }

    public static long c(long j) {
        return (j >>> 1) ^ (-(1 & j));
    }
}
