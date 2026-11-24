package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class k50 extends dk1 implements h30, w61 {
    public final he2 H;
    public boolean X;
    public final wd2 Y;
    public boolean c0;
    public boolean e0;
    public js1 x;
    public final tm Z = new tm(0);
    public long d0 = 0;

    public k50(js1 js1Var, he2 he2Var, boolean z, wd2 wd2Var) {
        this.x = js1Var;
        this.H = he2Var;
        this.X = z;
        this.Y = wd2Var;
    }

    public static final float I0(k50 k50Var, cn cnVar, long j) {
        float f;
        l42 l42Var;
        int iCompare;
        if (l21.a(k50Var.d0, 0L)) {
            return 0.0f;
        }
        pm1 pm1Var = k50Var.Z.a;
        int i = pm1Var.c - 1;
        Object[] objArr = pm1Var.a;
        if (i < objArr.length) {
            l42Var = null;
            while (true) {
                if (i < 0) {
                    f = 0.0f;
                    break;
                }
                l42 l42Var2 = (l42) ((h50) objArr[i]).a.a();
                if (l42Var2 != null) {
                    long jC = l42Var2.c();
                    long jA = cp4.a(k50Var.d0);
                    f = 0.0f;
                    int iOrdinal = k50Var.x.ordinal();
                    if (iOrdinal == 0) {
                        iCompare = Float.compare(Float.intBitsToFloat((int) (jC & 4294967295L)), Float.intBitsToFloat((int) (jA & 4294967295L)));
                    } else {
                        if (iOrdinal != 1) {
                            dk0.l();
                            return 0.0f;
                        }
                        iCompare = Float.compare(Float.intBitsToFloat((int) (jC >> 32)), Float.intBitsToFloat((int) (jA >> 32)));
                    }
                    if (iCompare > 0) {
                        if (l42Var != null) {
                            break;
                        }
                        l42Var = l42Var2;
                        break;
                    }
                    l42Var = l42Var2;
                }
                i--;
            }
        } else {
            f = 0.0f;
            l42Var = null;
        }
        if (l42Var == null) {
            l42 l42Var3 = k50Var.c0 ? (l42) k50Var.Y.a() : null;
            if (l42Var3 == null) {
                return f;
            }
            l42Var = l42Var3;
        }
        long jA2 = cp4.a(k50Var.d0);
        int iOrdinal2 = k50Var.x.ordinal();
        if (iOrdinal2 == 0) {
            float f2 = l42Var.b;
            return cnVar.a(f2 - ((int) (j & 4294967295L)), l42Var.d - f2, Float.intBitsToFloat((int) (jA2 & 4294967295L)));
        }
        if (iOrdinal2 == 1) {
            float f3 = l42Var.a;
            return cnVar.a(f3 - ((int) (j >> 32)), l42Var.c - f3, Float.intBitsToFloat((int) (jA2 >> 32)));
        }
        dk0.l();
        return f;
    }

    public static boolean J0(k50 k50Var, l42 l42Var, long j, long j2, int i) {
        if ((i & 1) != 0) {
            j = k50Var.d0;
        }
        long j3 = j;
        if ((i & 2) != 0) {
            j2 = 0;
        }
        long jL0 = k50Var.L0(l42Var, j3, j2);
        return Math.abs(Float.intBitsToFloat((int) (jL0 >> 32))) <= 0.5f && Math.abs(Float.intBitsToFloat((int) (jL0 & 4294967295L))) <= 0.5f;
    }

    public final void K0(long j) {
        m30 m30Var = en.a;
        cn cnVar = (cn) ij4.a(this, m30Var);
        if (this.e0) {
            c11.c("launchAnimation called when previous animation was running");
        }
        ((cn) ij4.a(this, m30Var)).getClass();
        cn.a.getClass();
        uf4.b(w0(), null, new j50(this, new i53(bn.b), cnVar, j, null), 1);
    }

    public final long L0(l42 l42Var, long j, long j2) {
        long jA = cp4.a(j);
        int iOrdinal = this.x.ordinal();
        if (iOrdinal == 0) {
            cn cnVar = (cn) ij4.a(this, en.a);
            float f = l42Var.b;
            return (((long) Float.floatToRawIntBits(0.0f)) << 32) | (((long) Float.floatToRawIntBits(cnVar.a(f - ((int) (j2 & 4294967295L)), l42Var.d - f, Float.intBitsToFloat((int) (jA & 4294967295L))))) & 4294967295L);
        }
        if (iOrdinal != 1) {
            dk0.l();
            return 0L;
        }
        cn cnVar2 = (cn) ij4.a(this, en.a);
        float f2 = l42Var.a;
        return (((long) Float.floatToRawIntBits(cnVar2.a(f2 - ((int) (j2 >> 32)), l42Var.c - f2, Float.intBitsToFloat((int) (jA >> 32))))) << 32) | (((long) Float.floatToRawIntBits(0.0f)) & 4294967295L);
    }

    @Override // defpackage.w61
    public final void r(long j) {
        int iB;
        long j2;
        long j3 = this.d0;
        this.d0 = j;
        int iOrdinal = this.x.ordinal();
        if (iOrdinal == 0) {
            iB = g31.b((int) (j & 4294967295L), (int) (j3 & 4294967295L));
        } else {
            if (iOrdinal != 1) {
                dk0.l();
                return;
            }
            iB = g31.b((int) (j >> 32), (int) (j3 >> 32));
        }
        if (iB >= 0) {
            return;
        }
        if (this.X) {
            j2 = 0;
        } else {
            j2 = this.x == js1.a ? ((long) (((int) (j3 & 4294967295L)) - ((int) (j & 4294967295L)))) & 4294967295L : ((long) (((int) (j3 >> 32)) - ((int) (j >> 32)))) << 32;
        }
        long j4 = j2;
        l42 l42Var = (l42) this.Y.a();
        if (l42Var == null || this.e0 || this.c0 || !J0(this, l42Var, j3, 0L, 2) || J0(this, l42Var, 0L, j4, 1)) {
            return;
        }
        this.c0 = true;
        K0(j4);
    }

    @Override // defpackage.dk1
    public final boolean x0() {
        return false;
    }
}
