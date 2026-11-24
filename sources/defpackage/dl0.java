package defpackage;

import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class dl0 extends v92 {
    public final HashMap f = new HashMap();

    @Override // defpackage.v92
    public final s92 a(Object obj) {
        return (s92) this.f.get(obj);
    }

    @Override // defpackage.v92
    public final Object b(Object obj) {
        Object objB = super.b(obj);
        this.f.remove(obj);
        return objB;
    }
}
