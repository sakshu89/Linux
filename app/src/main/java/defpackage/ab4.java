package defpackage;

import com.ibm.icu.impl.PatternTokenizer;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class ab4 {
    public static final py0 a = new py0(16, "NO_THREAD_ELEMENTS");
    public static final ra2 b = new ra2(20);
    public static final ra2 c = new ra2(21);
    public static final ra2 d = new ra2(22);

    public static final void a(j70 j70Var, Object obj) {
        if (obj == a) {
            return;
        }
        if (!(obj instanceof l03)) {
            j70Var.y(c, null).getClass();
            dk0.t();
            return;
        }
        k60[] k60VarArr = ((l03) obj).b;
        int length = k60VarArr.length - 1;
        if (length < 0) {
            return;
        }
        k60 k60Var = k60VarArr[length];
        throw null;
    }

    /* JADX WARN: Code duplicated, block: B:36:0x0076 A[PHI: r16
      0x0076: PHI (r16v3 long) = (r16v2 long), (r16v5 long) binds: [B:30:0x0069, B:34:0x0073] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:39:0x0082 A[LOOP:0: B:25:0x0058->B:39:0x0082, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:58:0x0096 A[EDGE_INSN: B:58:0x0096->B:43:0x0096 BREAK  A[LOOP:0: B:25:0x0058->B:39:0x0082], SYNTHETIC] */
    public static final long b(String str, long j, long j2, long j3) {
        String property;
        boolean z;
        long j4;
        int i;
        long j5;
        int i2 = hv2.a;
        Long lValueOf = null;
        try {
            property = System.getProperty(str);
        } catch (SecurityException unused) {
            property = null;
        }
        if (property == null) {
            return j;
        }
        int i3 = 10;
        ph4.a(10);
        int length = property.length();
        if (length != 0) {
            int i4 = 0;
            char cCharAt = property.charAt(0);
            long j6 = -9223372036854775807L;
            if (g31.b(cCharAt, 48) < 0) {
                z = true;
                if (length != 1) {
                    if (cCharAt == '+') {
                        z = false;
                        i4 = 1;
                    } else if (cCharAt == '-') {
                        j6 = Long.MIN_VALUE;
                        i4 = 1;
                    }
                }
            } else {
                z = false;
            }
            long j7 = 0;
            long j8 = -256204778801521550L;
            while (true) {
                if (i4 >= length) {
                    if (!z) {
                        lValueOf = Long.valueOf(-j7);
                        break;
                    }
                    lValueOf = Long.valueOf(j7);
                    break;
                }
                int iDigit = Character.digit((int) property.charAt(i4), i3);
                if (iDigit < 0) {
                    break;
                }
                if (j7 < j8) {
                    if (j8 != -256204778801521550L) {
                        break;
                    }
                    j8 = j6 / 10;
                    if (j7 < j8) {
                        break;
                    }
                    j4 = j7 * 10;
                    i = length;
                    j5 = iDigit;
                    if (j4 < j6 + j5) {
                        break;
                        break;
                    }
                    j7 = j4 - j5;
                    i4++;
                    length = i;
                    i3 = 10;
                } else {
                    j4 = j7 * 10;
                    i = length;
                    j5 = iDigit;
                    if (j4 < j6 + j5) {
                        break;
                    }
                    j7 = j4 - j5;
                    i4++;
                    length = i;
                    i3 = 10;
                }
            }
        }
        if (lValueOf == null) {
            throw new IllegalStateException(("System property '" + str + "' has unrecognized value '" + property + PatternTokenizer.SINGLE_QUOTE).toString());
        }
        long jLongValue = lValueOf.longValue();
        if (j2 <= jLongValue && jLongValue <= j3) {
            return jLongValue;
        }
        throw new IllegalStateException(("System property '" + str + "' should be in range " + j2 + ".." + j3 + ", but is '" + jLongValue + PatternTokenizer.SINGLE_QUOTE).toString());
    }

    public static int c(int i, int i2, String str) {
        return (int) b(str, i, 1L, (i2 & 8) != 0 ? Integer.MAX_VALUE : 2097150);
    }

    public static final Object d(j70 j70Var) {
        Object objY = j70Var.y(b, 0);
        objY.getClass();
        return objY;
    }

    public static final Object e(j70 j70Var, Object obj) {
        if (obj == null) {
            obj = d(j70Var);
        }
        if (obj == 0) {
            return a;
        }
        if (obj instanceof Integer) {
            return j70Var.y(d, new l03(((Number) obj).intValue(), j70Var));
        }
        dk0.t();
        return null;
    }
}
