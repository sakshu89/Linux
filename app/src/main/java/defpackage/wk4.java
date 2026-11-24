package defpackage;

import com.ibm.icu.impl.Normalizer2Impl;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class wk4 {
    public static long a(int i, int i2, int i3, int i4) {
        int i5 = 262142;
        int iMin = Math.min(i3, 262142);
        int iMin2 = i4 == Integer.MAX_VALUE ? Integer.MAX_VALUE : Math.min(i4, 262142);
        int i6 = iMin2 == Integer.MAX_VALUE ? iMin : iMin2;
        if (i6 >= 8191) {
            if (i6 < 32767) {
                i5 = 65534;
            } else if (i6 < 65535) {
                i5 = Normalizer2Impl.COMP_1_TRAIL_MASK;
            } else {
                if (i6 >= 262143) {
                    r40.k(i6);
                    og.k();
                    return 0L;
                }
                i5 = 8190;
            }
        }
        return r40.a(Math.min(i5, i), i2 != Integer.MAX_VALUE ? Math.min(i5, i2) : Integer.MAX_VALUE, iMin, iMin2);
    }

    public static long b(int i, int i2, int i3, int i4) {
        int i5 = 262142;
        int iMin = Math.min(i, 262142);
        int iMin2 = i2 == Integer.MAX_VALUE ? Integer.MAX_VALUE : Math.min(i2, 262142);
        int i6 = iMin2 == Integer.MAX_VALUE ? iMin : iMin2;
        if (i6 >= 8191) {
            if (i6 < 32767) {
                i5 = 65534;
            } else if (i6 < 65535) {
                i5 = Normalizer2Impl.COMP_1_TRAIL_MASK;
            } else {
                if (i6 >= 262143) {
                    r40.k(i6);
                    og.k();
                    return 0L;
                }
                i5 = 8190;
            }
        }
        return r40.a(iMin, iMin2, Math.min(i5, i3), i4 != Integer.MAX_VALUE ? Math.min(i5, i4) : Integer.MAX_VALUE);
    }
}
