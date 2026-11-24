package defpackage;

import java.util.Collections;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class w14 {
    public static fl0 a(int i, l11 l11Var) {
        l14 l14Var = new l14(i);
        if (((HashMap) l11Var.c) == null) {
            l11Var.c = new HashMap();
        }
        ((HashMap) l11Var.c).put(t14.class, l14Var);
        return new fl0((String) l11Var.b, ((HashMap) l11Var.c) == null ? Collections.EMPTY_MAP : Collections.unmodifiableMap(new HashMap((HashMap) l11Var.c)));
    }

    public static HashMap b(Class cls, l14 l14Var) {
        HashMap map = new HashMap();
        map.put(cls, l14Var);
        return map;
    }

    public static l14 c(HashMap map, int i) {
        Collections.unmodifiableMap(new HashMap(map));
        return new l14(i);
    }
}
