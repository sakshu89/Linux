package androidx.camera.camera2.internal.compat.quirk;

import android.os.Build;
import defpackage.h22;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class ZslDisablerQuirk implements h22 {
    public static final List a = Arrays.asList("SM-F936", "SM-S901U", "SM-S908U", "SM-S908U1");
    public static final List b = Arrays.asList("MI 8");

    public static boolean b(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (Build.MODEL.toUpperCase(Locale.US).startsWith((String) it.next())) {
                return true;
            }
        }
        return false;
    }
}
