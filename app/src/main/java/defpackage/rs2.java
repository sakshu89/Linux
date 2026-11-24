package defpackage;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class rs2 implements xg2, zf0 {
    public final xg2 a;
    public final int b;
    public final int c;

    public rs2(xg2 xg2Var, int i, int i2) {
        xg2Var.getClass();
        this.a = xg2Var;
        this.b = i;
        this.c = i2;
        if (i < 0) {
            og.g(ky0.h(i, "startIndex should be non-negative, but is "));
            throw null;
        }
        if (i2 < 0) {
            og.g(ky0.h(i2, "endIndex should be non-negative, but is "));
            throw null;
        }
        if (i2 >= i) {
            return;
        }
        og.g(ky0.i("endIndex should be not less than startIndex, but was ", i2, i, " < "));
        throw null;
    }

    @Override // defpackage.zf0
    public final xg2 a(int i) {
        int i2 = this.c;
        int i3 = this.b;
        return i >= i2 - i3 ? li0.a : new rs2(this.a, i3 + i, i2);
    }

    @Override // defpackage.xg2
    public final Iterator iterator() {
        return new zt0(this);
    }

    @Override // defpackage.zf0
    public final xg2 take() {
        int i = this.c;
        int i2 = this.b;
        if (2 >= i - i2) {
            return this;
        }
        return new rs2(this.a, i2, i2 + 2);
    }
}
