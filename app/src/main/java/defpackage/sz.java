package defpackage;

import com.ibm.icu.impl.coll.Collation;
import com.ibm.icu.impl.coll.CollationRootElements;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class sz {
    public static final long b = ki4.c(4278190080L);
    public static final long c;
    public static final long d;
    public static final long e;
    public static final long f;
    public static final long g;
    public static final /* synthetic */ int h = 0;
    public final long a;

    static {
        ki4.c(4282664004L);
        ki4.c(4287137928L);
        ki4.c(4291611852L);
        c = ki4.c(4294967295L);
        d = ki4.c(Collation.MAX_PRIMARY);
        ki4.c(4278255360L);
        e = ki4.c(4278190335L);
        ki4.c(CollationRootElements.PRIMARY_SENTINEL);
        ki4.c(4278255615L);
        ki4.c(4294902015L);
        f = ki4.b(0);
        g = ki4.a(0.0f, 0.0f, 0.0f, 0.0f, d00.u);
    }

    public /* synthetic */ sz(long j) {
        this.a = j;
    }

    public static final long a(long j, b00 b00Var) {
        i40 i40VarD;
        b00 b00VarF = f(j);
        int i = b00VarF.c;
        int i2 = b00Var.c;
        if ((i | i2) < 0) {
            i40VarD = oi4.d(b00VarF, b00Var);
        } else {
            ml1 ml1Var = j40.a;
            int i3 = i | (i2 << 6);
            Object objB = ml1Var.b(i3);
            if (objB == null) {
                objB = oi4.d(b00VarF, b00Var);
                ml1Var.h(i3, objB);
            }
            i40VarD = (i40) objB;
        }
        return i40VarD.a(j);
    }

    public static long b(float f2, long j) {
        return ki4.a(h(j), g(j), e(j), f2, f(j));
    }

    public static final boolean c(long j, long j2) {
        return j == j2;
    }

    public static final float d(long j) {
        float fB;
        float f2;
        if ((63 & j) == 0) {
            fB = (float) ge4.b((j >>> 56) & 255);
            f2 = 255.0f;
        } else {
            fB = (float) ge4.b((j >>> 6) & 1023);
            f2 = 1023.0f;
        }
        return fB / f2;
    }

    public static final float e(long j) {
        int i;
        int i2;
        int i3;
        if ((63 & j) == 0) {
            return ((float) ge4.b((j >>> 32) & 255)) / 255.0f;
        }
        short s = (short) ((j >>> 16) & 65535);
        int i4 = Short.MIN_VALUE & s;
        int i5 = ((65535 & s) >>> 10) & 31;
        int i6 = s & 1023;
        if (i5 != 0) {
            int i7 = i6 << 13;
            if (i5 == 31) {
                i = 255;
                if (i7 != 0) {
                    i7 |= 4194304;
                }
            } else {
                i = i5 + 112;
            }
            int i8 = i;
            i2 = i7;
            i3 = i8;
        } else {
            if (i6 != 0) {
                float fIntBitsToFloat = Float.intBitsToFloat(i6 + 1056964608) - hm0.a;
                return i4 == 0 ? fIntBitsToFloat : -fIntBitsToFloat;
            }
            i3 = 0;
            i2 = 0;
        }
        return Float.intBitsToFloat((i3 << 23) | (i4 << 16) | i2);
    }

    public static final b00 f(long j) {
        float[] fArr = d00.a;
        return d00.y[(int) (j & 63)];
    }

    public static final float g(long j) {
        int i;
        int i2;
        int i3;
        if ((63 & j) == 0) {
            return ((float) ge4.b((j >>> 40) & 255)) / 255.0f;
        }
        short s = (short) ((j >>> 32) & 65535);
        int i4 = Short.MIN_VALUE & s;
        int i5 = ((65535 & s) >>> 10) & 31;
        int i6 = s & 1023;
        if (i5 != 0) {
            int i7 = i6 << 13;
            if (i5 == 31) {
                i = 255;
                if (i7 != 0) {
                    i7 |= 4194304;
                }
            } else {
                i = i5 + 112;
            }
            int i8 = i;
            i2 = i7;
            i3 = i8;
        } else {
            if (i6 != 0) {
                float fIntBitsToFloat = Float.intBitsToFloat(i6 + 1056964608) - hm0.a;
                return i4 == 0 ? fIntBitsToFloat : -fIntBitsToFloat;
            }
            i3 = 0;
            i2 = 0;
        }
        return Float.intBitsToFloat((i3 << 23) | (i4 << 16) | i2);
    }

    public static final float h(long j) {
        int i;
        int i2;
        int i3;
        if ((63 & j) == 0) {
            return ((float) ge4.b((j >>> 48) & 255)) / 255.0f;
        }
        short s = (short) ((j >>> 48) & 65535);
        int i4 = Short.MIN_VALUE & s;
        int i5 = ((65535 & s) >>> 10) & 31;
        int i6 = s & 1023;
        if (i5 != 0) {
            int i7 = i6 << 13;
            if (i5 == 31) {
                i = 255;
                if (i7 != 0) {
                    i7 |= 4194304;
                }
            } else {
                i = i5 + 112;
            }
            int i8 = i;
            i2 = i7;
            i3 = i8;
        } else {
            if (i6 != 0) {
                float fIntBitsToFloat = Float.intBitsToFloat(i6 + 1056964608) - hm0.a;
                return i4 == 0 ? fIntBitsToFloat : -fIntBitsToFloat;
            }
            i3 = 0;
            i2 = 0;
        }
        return Float.intBitsToFloat((i3 << 23) | (i4 << 16) | i2);
    }

    public static String i(long j) {
        StringBuilder sb = new StringBuilder("Color(");
        sb.append(h(j));
        sb.append(", ");
        sb.append(g(j));
        sb.append(", ");
        sb.append(e(j));
        sb.append(", ");
        sb.append(d(j));
        sb.append(", ");
        return ky0.n(sb, f(j).a, ')');
    }

    public final boolean equals(Object obj) {
        if (obj instanceof sz) {
            return this.a == ((sz) obj).a;
        }
        return false;
    }

    public final int hashCode() {
        return Long.hashCode(this.a);
    }

    public final String toString() {
        return i(this.a);
    }
}
