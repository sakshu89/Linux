package defpackage;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class p40 implements xg2 {
    public final AtomicReference a;

    public p40(xg2 xg2Var) {
        this.a = new AtomicReference(xg2Var);
    }

    @Override // defpackage.xg2
    public final Iterator iterator() {
        xg2 xg2Var = (xg2) this.a.getAndSet(null);
        if (xg2Var != null) {
            return xg2Var.iterator();
        }
        og.n("This sequence can be consumed only once.");
        return null;
    }
}
