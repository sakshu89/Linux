package defpackage;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class vl0 implements xg2 {
    public final xg2 a;
    public final boolean b;
    public final hq0 c;

    public vl0(xg2 xg2Var, boolean z, hq0 hq0Var) {
        this.a = xg2Var;
        this.b = z;
        this.c = hq0Var;
    }

    @Override // defpackage.xg2
    public final Iterator iterator() {
        return new ul0(this);
    }
}
