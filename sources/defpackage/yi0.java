package defpackage;

import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class yi0 {
    public static final vq2 a = ie4.d(5, null);
    public static final vq2 b;
    public static final vq2 c;

    static {
        Map map = p83.a;
        b = ie4.d(1, new e21(4294967297L));
        c = ie4.d(1, new l21(4294967297L));
    }

    public static cj0 a(f33 f33Var, int i) {
        yl0 yl0VarD = f33Var;
        if ((i & 1) != 0) {
            yl0VarD = ie4.d(5, null);
        }
        return new cj0(new k23(new al0(yl0VarD), (zw) null, (LinkedHashMap) null, 126));
    }
}
