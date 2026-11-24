package defpackage;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class yf0 implements xg2, zf0 {
    public final xg2 a;
    public final int b;

    public yf0(xg2 xg2Var, int i) {
        xg2Var.getClass();
        this.a = xg2Var;
        this.b = i;
        if (i >= 0) {
            return;
        }
        throw new IllegalArgumentException(("count must be non-negative, but was " + i + '.').toString());
    }

    @Override // defpackage.zf0
    public final xg2 a(int i) {
        int i2 = this.b + i;
        return i2 < 0 ? new yf0(this, i) : new yf0(this.a, i2);
    }

    @Override // defpackage.xg2
    public final Iterator iterator() {
        return new xf0(this);
    }

    @Override // defpackage.zf0
    public final xg2 take() {
        int i = this.b;
        int i2 = i + 2;
        return i2 < 0 ? new mv2(this) : new rs2(this.a, i, i2);
    }
}
