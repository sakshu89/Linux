package defpackage;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class mv2 implements xg2, zf0 {
    public final xg2 a;

    public mv2(xg2 xg2Var) {
        this.a = xg2Var;
    }

    @Override // defpackage.zf0
    public final xg2 a(int i) {
        return i >= 2 ? li0.a : new rs2(this.a, i, 2);
    }

    @Override // defpackage.xg2
    public final Iterator iterator() {
        return new xf0(this);
    }

    @Override // defpackage.zf0
    public final xg2 take() {
        return this;
    }
}
