package defpackage;

import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class mv3 extends ov3 {
    @Override // defpackage.ov3
    public final double f(long j, Object obj) {
        return Double.longBitsToDouble(((Unsafe) this.a).getLong(obj, j));
    }

    @Override // defpackage.ov3
    public final float g(long j, Object obj) {
        return Float.intBitsToFloat(((Unsafe) this.a).getInt(obj, j));
    }

    @Override // defpackage.ov3
    public final void h(Object obj, long j, boolean z) {
        if (pv3.g) {
            pv3.c(obj, j, z ? (byte) 1 : (byte) 0);
        } else {
            pv3.d(obj, j, z ? (byte) 1 : (byte) 0);
        }
    }

    @Override // defpackage.ov3
    public final void i(Object obj, long j, byte b) {
        if (pv3.g) {
            pv3.c(obj, j, b);
        } else {
            pv3.d(obj, j, b);
        }
    }

    @Override // defpackage.ov3
    public final void j(Object obj, long j, double d) {
        ((Unsafe) this.a).putLong(obj, j, Double.doubleToLongBits(d));
    }

    @Override // defpackage.ov3
    public final void k(Object obj, long j, float f) {
        ((Unsafe) this.a).putInt(obj, j, Float.floatToIntBits(f));
    }

    @Override // defpackage.ov3
    public final boolean l(long j, Object obj) {
        return pv3.g ? pv3.m(j, obj) : pv3.n(j, obj);
    }
}
