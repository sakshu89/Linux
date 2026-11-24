package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class z63 {
    public final boolean a;
    public final y63 b;
    public final int c;
    public final b90[] d;
    public int e;
    public final float[] f;
    public final float[] g;
    public final float[] h;

    public z63(boolean z, y63 y63Var) {
        int i;
        this.a = z;
        this.b = y63Var;
        if (z && y63Var.equals(y63.a)) {
            og.n("Lsq2 not (yet) supported for differential axes");
            throw null;
        }
        int iOrdinal = y63Var.ordinal();
        if (iOrdinal == 0) {
            i = 3;
        } else {
            if (iOrdinal != 1) {
                dk0.l();
                throw null;
            }
            i = 2;
        }
        this.c = i;
        this.d = new b90[20];
        this.f = new float[20];
        this.g = new float[20];
        this.h = new float[3];
    }

    public final void a(float f, long j) {
        int i = (this.e + 1) % 20;
        this.e = i;
        b90[] b90VarArr = this.d;
        b90 b90Var = b90VarArr[i];
        if (b90Var != null) {
            b90Var.a = j;
            b90Var.b = f;
        } else {
            b90 b90Var2 = new b90();
            b90Var2.a = j;
            b90Var2.b = f;
            b90VarArr[i] = b90Var2;
        }
    }

    public final float b(float f) {
        y63 y63Var;
        float[] fArr;
        float[] fArr2;
        float f2;
        boolean z;
        int i;
        float f3;
        float fSignum;
        float f4 = 0.0f;
        if (f <= 0.0f) {
            z01.b("maximumVelocity should be a positive value. You specified=" + f);
        }
        int i2 = this.e;
        b90[] b90VarArr = this.d;
        b90 b90Var = b90VarArr[i2];
        if (b90Var == null) {
            f3 = 0.0f;
            f2 = 0.0f;
        } else {
            int i3 = 0;
            b90 b90Var2 = b90Var;
            while (true) {
                b90 b90Var3 = b90VarArr[i2];
                boolean z2 = this.a;
                y63Var = this.b;
                fArr = this.f;
                fArr2 = this.g;
                if (b90Var3 == null) {
                    f2 = f4;
                    z = z2;
                    i = 1;
                    break;
                }
                long j = b90Var.a;
                f2 = f4;
                int i4 = i2;
                long j2 = b90Var3.a;
                float f5 = j - j2;
                z = z2;
                i = 1;
                float fAbs = Math.abs(j2 - b90Var2.a);
                b90Var2 = (y63Var == y63.a || z) ? b90Var3 : b90Var;
                if (f5 > 100.0f || fAbs > 40.0f) {
                    break;
                }
                fArr[i3] = b90Var3.b;
                fArr2[i3] = -f5;
                i2 = (i4 == 0 ? 20 : i4) - 1;
                i3++;
                if (i3 >= 20) {
                    break;
                }
                f4 = f2;
            }
            if (i3 >= this.c) {
                int iOrdinal = y63Var.ordinal();
                if (iOrdinal == 0) {
                    try {
                        float[] fArr3 = this.h;
                        ue4.d(fArr2, fArr, i3, fArr3);
                        fSignum = fArr3[1];
                    } catch (IllegalArgumentException unused) {
                        fSignum = f2;
                    }
                } else {
                    if (iOrdinal != i) {
                        dk0.l();
                        return f2;
                    }
                    int i5 = i3 - i;
                    float f6 = fArr2[i5];
                    int i6 = i5;
                    float fAbs2 = f2;
                    while (i6 > 0) {
                        int i7 = i6 - 1;
                        float f7 = fArr2[i7];
                        if (f6 != f7) {
                            float f8 = (z ? -fArr[i7] : fArr[i6] - fArr[i7]) / (f6 - f7);
                            fAbs2 += Math.abs(f8) * (f8 - (Math.signum(fAbs2) * ((float) Math.sqrt(Math.abs(fAbs2) * 2.0f))));
                            if (i6 == i5) {
                                fAbs2 *= 0.5f;
                            }
                        }
                        i6--;
                        f6 = f7;
                    }
                    fSignum = Math.signum(fAbs2) * ((float) Math.sqrt(Math.abs(fAbs2) * 2.0f));
                }
                f3 = fSignum * 1000.0f;
            } else {
                f3 = f2;
            }
        }
        if (f3 == f2 || Float.isNaN(f3)) {
            return f2;
        }
        if (f3 <= f2) {
            float f9 = -f;
            if (f3 < f9) {
                return f9;
            }
        } else if (f3 > f) {
            f3 = f;
        }
        return f3;
    }

    public /* synthetic */ z63() {
        this(false, y63.a);
    }

    public z63(int i) {
        this(true, y63.b);
    }
}
