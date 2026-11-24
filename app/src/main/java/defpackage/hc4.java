package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class hc4 {
    public static final long a(int i, int i2) {
        if (i < 0 || i2 < 0) {
            a11.a("start and end cannot be negative. [start: " + i + ", end: " + i2 + ']');
        }
        long j = (((long) i2) & 4294967295L) | (((long) i) << 32);
        int i3 = oz2.c;
        return j;
    }

    public static final String b(d32 d32Var) {
        if (d32Var.equals(a32.a)) {
            return "ready";
        }
        if (d32Var instanceof z22) {
            return "missing permissions: ".concat(mz.C(((z22) d32Var).a, null, null, null, null, 63));
        }
        if (d32Var instanceof c32) {
            return "unavailable: ".concat(((c32) d32Var).a);
        }
        if (d32Var instanceof b32) {
            return cq.v("requires ", ((b32) d32Var).a.name(), " tier");
        }
        dk0.l();
        return null;
    }

    public static final long c(int i, long j) {
        int i2 = oz2.c;
        int i3 = (int) (j >> 32);
        int i4 = i3 < 0 ? 0 : i3;
        if (i4 > i) {
            i4 = i;
        }
        int i5 = (int) (4294967295L & j);
        int i6 = i5 >= 0 ? i5 : 0;
        if (i6 <= i) {
            i = i6;
        }
        return (i4 == i3 && i == i5) ? j : a(i4, i);
    }
}
