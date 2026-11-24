package androidx.camera.camera2.internal.compat.quirk;

import android.os.Build;
import defpackage.h22;
import defpackage.hj;
import defpackage.kt2;
import defpackage.ky0;
import defpackage.lt2;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class ExtraSupportedSurfaceCombinationsQuirk implements h22 {
    public static final kt2 a;
    public static final kt2 b;
    public static final HashSet c;
    public static final HashSet d;

    static {
        kt2 kt2Var = new kt2();
        lt2 lt2Var = lt2.VGA;
        ky0.u(2, lt2Var, 0L, kt2Var);
        lt2 lt2Var2 = lt2.PREVIEW;
        ky0.u(1, lt2Var2, 0L, kt2Var);
        lt2 lt2Var3 = lt2.MAXIMUM;
        ky0.u(2, lt2Var3, 0L, kt2Var);
        a = kt2Var;
        kt2 kt2Var2 = new kt2();
        kt2Var2.a(new hj(1, lt2Var2, 0L));
        kt2Var2.a(new hj(1, lt2Var, 0L));
        ky0.u(2, lt2Var3, 0L, kt2Var2);
        b = kt2Var2;
        c = new HashSet(Arrays.asList("PIXEL 6", "PIXEL 6 PRO", "PIXEL 7", "PIXEL 7 PRO", "PIXEL 8", "PIXEL 8 PRO"));
        d = new HashSet(Arrays.asList("SM-S921", "SC-51E", "SCG25", "SM-S926", "SM-S928", "SC-52E", "SCG26"));
    }

    public static boolean b() {
        if (!"samsung".equalsIgnoreCase(Build.BRAND)) {
            return false;
        }
        String upperCase = Build.MODEL.toUpperCase(Locale.US);
        Iterator it = d.iterator();
        while (it.hasNext()) {
            if (upperCase.startsWith((String) it.next())) {
                return true;
            }
        }
        return false;
    }
}
