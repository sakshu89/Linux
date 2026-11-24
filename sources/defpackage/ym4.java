package defpackage;

import com.ibm.icu.impl.CalendarAstronomer;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class ym4 {
    public static final long a(long j, long j2) {
        if (j != 4611686018427387903L && j != -4611686018427387903L) {
            return (j2 == 4611686018427387903L || j2 == -4611686018427387903L) ? j2 : ky3.d(j + j2, -4611686018427387903L, 4611686018427387903L);
        }
        if ((-4611686018427387903L >= j2 || j2 >= 4611686018427387903L) && (j2 ^ j) < 0) {
            return 9223372036854759646L;
        }
        return j;
    }

    public static final long b(long j) {
        long j2 = (j << 1) + 1;
        eg0.a.getClass();
        int i = gg0.a;
        return j2;
    }

    /* JADX WARN: Code duplicated, block: B:32:0x006d A[PHI: r4
      0x006d: PHI (r4v5 long) = (r4v3 long), (r4v4 long), (r4v4 long), (r4v4 long), (r4v4 long) binds: [B:31:0x006b, B:47:0x0099, B:50:0x009f, B:42:0x0085, B:36:0x007a] A[DONT_GENERATE, DONT_INLINE]] */
    public static final long c(long j, hg0 hg0Var) {
        long j2;
        TimeUnit timeUnit = hg0Var.a;
        TimeUnit timeUnit2 = TimeUnit.NANOSECONDS;
        long jConvert = timeUnit.convert(4611686018426999999L, timeUnit2);
        if ((-jConvert) <= j && j <= jConvert) {
            long jConvert2 = timeUnit2.convert(j, timeUnit);
            xy xyVar = eg0.a;
            long j3 = jConvert2 << 1;
            int i = gg0.a;
            return j3;
        }
        if (hg0Var.compareTo(hg0.MILLISECONDS) < 0) {
            return b(ky3.d(TimeUnit.MILLISECONDS.convert(j, timeUnit), -4611686018427387903L, 4611686018427387903L));
        }
        long jSignum = Long.signum(j);
        if (j < -9223372036854775807L) {
            j = -9223372036854775807L;
        }
        long jAbs = Math.abs(j);
        int iOrdinal = hg0Var.ordinal();
        long j4 = 0;
        if (iOrdinal == 2) {
            j2 = 1;
        } else if (iOrdinal == 3) {
            j2 = 1000;
        } else if (iOrdinal == 4) {
            j2 = 60000;
        } else if (iOrdinal == 5) {
            j2 = 3600000;
        } else {
            if (iOrdinal != 6) {
                og.h(hg0Var, "Wrong unit for millisMultiplier: ");
                return 0L;
            }
            j2 = CalendarAstronomer.DAY_MS;
        }
        if (jAbs == 0) {
            jAbs = j4;
        } else {
            j4 = 4611686018427387903L;
            if (jAbs == 1) {
                if (j2 > 4611686018427387903L) {
                    jAbs = j4;
                } else {
                    jAbs = j2;
                }
            } else if (j2 != 1) {
                int iNumberOfLeadingZeros = (128 - Long.numberOfLeadingZeros(jAbs)) - Long.numberOfLeadingZeros(j2);
                if (iNumberOfLeadingZeros < 63) {
                    jAbs *= j2;
                } else if (iNumberOfLeadingZeros > 63) {
                    jAbs = j4;
                } else {
                    jAbs *= j2;
                    if (jAbs > 4611686018427387903L) {
                        jAbs = j4;
                    }
                }
            } else if (jAbs > 4611686018427387903L) {
                jAbs = j4;
            }
        }
        return b(jSignum * jAbs);
    }
}
