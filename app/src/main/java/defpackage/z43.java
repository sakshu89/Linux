package defpackage;

import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class z43 extends b53 {
    public final /* synthetic */ int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ z43(Unsafe unsafe, int i) {
        super(unsafe);
        this.b = i;
    }

    @Override // defpackage.b53
    public final boolean c(long j, Object obj) {
        switch (this.b) {
            case 0:
                return c53.g ? c53.b(j, obj) : c53.c(j, obj);
            default:
                return c53.g ? c53.b(j, obj) : c53.c(j, obj);
        }
    }

    @Override // defpackage.b53
    public final double d(long j, Object obj) {
        switch (this.b) {
            case 0:
                break;
        }
        return Double.longBitsToDouble(g(j, obj));
    }

    @Override // defpackage.b53
    public final float e(long j, Object obj) {
        switch (this.b) {
            case 0:
                break;
        }
        return Float.intBitsToFloat(f(j, obj));
    }

    @Override // defpackage.b53
    public final void j(Object obj, long j, boolean z) {
        switch (this.b) {
            case 0:
                if (!c53.g) {
                    c53.l(obj, j, z ? (byte) 1 : (byte) 0);
                } else {
                    c53.k(obj, j, z ? (byte) 1 : (byte) 0);
                }
                break;
            default:
                if (!c53.g) {
                    c53.l(obj, j, z ? (byte) 1 : (byte) 0);
                } else {
                    c53.k(obj, j, z ? (byte) 1 : (byte) 0);
                }
                break;
        }
    }

    @Override // defpackage.b53
    public final void k(Object obj, long j, byte b) {
        switch (this.b) {
            case 0:
                if (!c53.g) {
                    c53.l(obj, j, b);
                } else {
                    c53.k(obj, j, b);
                }
                break;
            default:
                if (!c53.g) {
                    c53.l(obj, j, b);
                } else {
                    c53.k(obj, j, b);
                }
                break;
        }
    }

    @Override // defpackage.b53
    public final void l(Object obj, long j, double d) {
        switch (this.b) {
            case 0:
                o(obj, j, Double.doubleToLongBits(d));
                break;
            default:
                o(obj, j, Double.doubleToLongBits(d));
                break;
        }
    }

    @Override // defpackage.b53
    public final void m(Object obj, long j, float f) {
        switch (this.b) {
            case 0:
                n(Float.floatToIntBits(f), j, obj);
                break;
            default:
                n(Float.floatToIntBits(f), j, obj);
                break;
        }
    }

    @Override // defpackage.b53
    public final boolean r() {
        switch (this.b) {
        }
        return false;
    }
}
