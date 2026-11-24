package defpackage;

import java.util.Collections;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class wk0 {
    public static volatile wk0 a;
    public static final wk0 b;

    static {
        wk0 wk0Var = new wk0();
        Map map = Collections.EMPTY_MAP;
        b = wk0Var;
    }

    public static wk0 a() {
        wk0 wk0Var;
        w12 w12Var = w12.c;
        wk0 wk0Var2 = a;
        if (wk0Var2 != null) {
            return wk0Var2;
        }
        synchronized (wk0.class) {
            try {
                wk0Var = a;
                if (wk0Var == null) {
                    Class cls = vk0.a;
                    wk0 wk0Var3 = null;
                    if (cls != null) {
                        try {
                            wk0Var3 = (wk0) cls.getDeclaredMethod("getEmptyRegistry", null).invoke(null, null);
                        } catch (Exception unused) {
                        }
                    }
                    wk0Var = wk0Var3 != null ? wk0Var3 : b;
                    a = wk0Var;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return wk0Var;
    }
}
