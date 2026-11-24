package defpackage;

import java.util.Date;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class u41 implements pi0 {
    public static final t41 f = new t41();
    public final HashMap a;
    public final HashMap b;
    public final r41 c;
    public boolean e;

    public u41() {
        HashMap map = new HashMap();
        this.a = map;
        HashMap map2 = new HashMap();
        this.b = map2;
        this.c = r41.b;
        this.e = false;
        map2.put(String.class, s41.b);
        map.remove(String.class);
        map2.put(Boolean.class, s41.c);
        map.remove(Boolean.class);
        map2.put(Date.class, f);
        map.remove(Date.class);
    }

    @Override // defpackage.pi0
    public final pi0 a(Class cls, vo1 vo1Var) {
        this.a.put(cls, vo1Var);
        this.b.remove(cls);
        return this;
    }
}
