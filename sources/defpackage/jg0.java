package defpackage;

import android.hardware.camera2.params.DynamicRangeProfiles;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class jg0 {
    public static final HashMap a;
    public static final HashMap b;

    static {
        ig0 ig0Var;
        HashMap map = new HashMap();
        a = map;
        HashMap map2 = new HashMap();
        b = map2;
        ig0 ig0Var2 = ig0.d;
        map.put(1L, ig0Var2);
        map2.put(ig0Var2, Collections.singletonList(1L));
        map.put(2L, ig0.e);
        map2.put((ig0) map.get(2L), Collections.singletonList(2L));
        ig0 ig0Var3 = ig0.f;
        map.put(4L, ig0Var3);
        map2.put(ig0Var3, Collections.singletonList(4L));
        ig0 ig0Var4 = ig0.g;
        map.put(8L, ig0Var4);
        map2.put(ig0Var4, Collections.singletonList(8L));
        List listAsList = Arrays.asList(64L, 128L, 16L, 32L);
        Iterator it = listAsList.iterator();
        while (true) {
            boolean zHasNext = it.hasNext();
            ig0Var = ig0.h;
            if (!zHasNext) {
                break;
            }
            a.put((Long) it.next(), ig0Var);
        }
        b.put(ig0Var, listAsList);
        List listAsList2 = Arrays.asList(1024L, 2048L, 256L, 512L);
        Iterator it2 = listAsList2.iterator();
        while (true) {
            boolean zHasNext2 = it2.hasNext();
            ig0 ig0Var5 = ig0.i;
            if (!zHasNext2) {
                b.put(ig0Var5, listAsList2);
                return;
            } else {
                a.put((Long) it2.next(), ig0Var5);
            }
        }
    }

    public static Long a(ig0 ig0Var, DynamicRangeProfiles dynamicRangeProfiles) {
        List<Long> list = (List) b.get(ig0Var);
        if (list == null) {
            return null;
        }
        Set supportedProfiles = dynamicRangeProfiles.getSupportedProfiles();
        for (Long l : list) {
            if (supportedProfiles.contains(l)) {
                return l;
            }
        }
        return null;
    }
}
