package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public interface jc0 {
    default float I(long j) {
        if (!c03.a(b03.b(j), 4294967296L)) {
            b11.b("Only Sp can convert to Px");
        }
        float[] fArr = jp0.a;
        if (l() < 1.03f) {
            return l() * b03.c(j);
        }
        ip0 ip0VarA = jp0.a(l());
        if (ip0VarA != null) {
            return ip0VarA.b(b03.c(j));
        }
        return l() * b03.c(j);
    }

    default int R(float f) {
        float fX = x(f);
        if (Float.isInfinite(fX)) {
            return Integer.MAX_VALUE;
        }
        return Math.round(fX);
    }

    default long a0(long j) {
        if (j == 9205357640488583168L) {
            return 9205357640488583168L;
        }
        float fX = x(Float.intBitsToFloat((int) (j >> 32)));
        float fX2 = x(Float.intBitsToFloat((int) (j & 4294967295L)));
        return (((long) Float.floatToRawIntBits(fX)) << 32) | (((long) Float.floatToRawIntBits(fX2)) & 4294967295L);
    }

    float b();

    default float d0(long j) {
        if (!c03.a(b03.b(j), 4294967296L)) {
            b11.b("Only Sp can convert to Px");
        }
        return x(I(j));
    }

    float l();

    default long l0(float f) {
        return v(u0(f));
    }

    default float r0(int i) {
        return i / b();
    }

    default float u0(float f) {
        return f / b();
    }

    default long v(float f) {
        float[] fArr = jp0.a;
        if (l() < 1.03f) {
            return nc4.d(f / l(), 4294967296L);
        }
        ip0 ip0VarA = jp0.a(l());
        return nc4.d(ip0VarA != null ? ip0VarA.a(f) : f / l(), 4294967296L);
    }

    default long w(long j) {
        if (j != 9205357640488583168L) {
            return im4.a(u0(Float.intBitsToFloat((int) (j >> 32))), u0(Float.intBitsToFloat((int) (j & 4294967295L))));
        }
        return 9205357640488583168L;
    }

    default float x(float f) {
        return b() * f;
    }
}
