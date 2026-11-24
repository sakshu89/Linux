package androidx.camera.camera2.internal.compat.quirk;

import android.os.Build;
import android.util.Range;
import android.util.Size;
import com.ibm.icu.impl.coll.Collation;
import defpackage.cq;
import defpackage.h22;
import java.util.HashMap;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class ExtraCroppingQuirk implements h22 {
    public static final HashMap a;

    static {
        HashMap map = new HashMap();
        a = map;
        map.put("SM-T580", null);
        map.put("SM-J710MN", new Range(21, 26));
        map.put("SM-A320FL", null);
        map.put("SM-G570M", null);
        map.put("SM-G610F", null);
        map.put("SM-G610M", new Range(21, 26));
    }

    public static Size b(int i) {
        if (!c()) {
            return null;
        }
        int iX = cq.x(i);
        if (iX == 0) {
            return new Size(1920, 1080);
        }
        if (iX == 1) {
            return new Size(Collation.COMMON_WEIGHT16, 720);
        }
        if (iX != 2) {
            return null;
        }
        return new Size(3264, 1836);
    }

    public static boolean c() {
        if (!"samsung".equalsIgnoreCase(Build.BRAND)) {
            return false;
        }
        String str = Build.MODEL;
        Locale locale = Locale.US;
        String upperCase = str.toUpperCase(locale);
        HashMap map = a;
        if (!map.containsKey(upperCase)) {
            return false;
        }
        Range range = (Range) map.get(str.toUpperCase(locale));
        if (range == null) {
            return true;
        }
        return range.contains(Integer.valueOf(Build.VERSION.SDK_INT));
    }
}
