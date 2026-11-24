package defpackage;

import android.os.Handler;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class n42 {
    public final t9 a;
    public final o03 b;
    public final yl1 c;
    public boolean d;
    public boolean e;
    public boolean f;
    public m4 g;
    public long h;
    public final ta i;
    public final fm1 j;

    public n42() {
        t9 t9Var = new t9(4, false);
        t9Var.c = new long[192];
        t9Var.e = new long[192];
        this.a = t9Var;
        this.b = new o03();
        this.c = new yl1();
        this.h = -1L;
        this.i = new ta(15, this);
        this.j = new fm1();
    }

    public static boolean c(co1 co1Var) {
        ht1 ht1Var = co1Var.u0;
        return (ht1Var == null || dr4.a(((yu0) ht1Var).b())) ? false : true;
    }

    public static long g(n71 n71Var) {
        zn1 zn1Var = n71Var.o0;
        co1 co1Var = zn1Var.d;
        long jC = 0;
        for (co1 co1Var2 = zn1Var.c; co1Var2 != null && co1Var2 != co1Var; co1Var2 = co1Var2.X) {
            if (c(co1Var2)) {
                return 9223372034707292159L;
            }
            jC = e21.c(jC, co1Var2.i0);
        }
        return jC;
    }

    public static void i(n71 n71Var) {
        if (!n71Var.c || c(n71Var.o0.d)) {
            return;
        }
        n71Var.c = false;
        if (n71Var.j) {
            n71Var.i = g(n71Var);
            n71Var.j = false;
        }
        if (e21.a(n71Var.i, 9223372034707292159L)) {
            return;
        }
        pm1 pm1VarZ = n71Var.z();
        Object[] objArr = pm1VarZ.a;
        int i = pm1VarZ.c;
        for (int i2 = 0; i2 < i; i2++) {
            i((n71) objArr[i2]);
        }
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0248  */
    /* JADX WARN: Code duplicated, block: B:103:0x0251 A[LOOP:11: B:102:0x024f->B:103:0x0251, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:106:0x025a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:107:0x025c A[LOOP:9: B:95:0x022b->B:107:0x025c, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:110:0x0263 A[ADDED_TO_REGION, LOOP:12: B:110:0x0263->B:111:0x0265, LOOP_START, PHI: r1
      0x0263: PHI (r1v10 n03) = (r1v9 n03), (r1v11 n03) binds: [B:109:0x0261, B:111:0x0265] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:111:0x0265 A[LOOP:12: B:110:0x0263->B:111:0x0265, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:115:0x0272  */
    /* JADX WARN: Code duplicated, block: B:135:0x020d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:136:0x025f A[EDGE_INSN: B:136:0x025f->B:108:0x025f BREAK  A[LOOP:9: B:95:0x022b->B:107:0x025c], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:137:0x025f A[EDGE_INSN: B:137:0x025f->B:108:0x025f BREAK  A[LOOP:9: B:95:0x022b->B:107:0x025c], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:139:0x0254 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:142:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:71:0x0181  */
    /* JADX WARN: Code duplicated, block: B:73:0x018b A[ADDED_TO_REGION, LOOP:7: B:73:0x018b->B:74:0x018d, LOOP_START, PHI: r3
      0x018b: PHI (r3v7 n03) = (r3v6 n03), (r3v8 n03) binds: [B:72:0x0189, B:74:0x018d] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:74:0x018d A[LOOP:7: B:73:0x018b->B:74:0x018d, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:77:0x01d2  */
    /* JADX WARN: Code duplicated, block: B:85:0x01f9  */
    /* JADX WARN: Code duplicated, block: B:88:0x0217  */
    /* JADX WARN: Code duplicated, block: B:92:0x021f  */
    /* JADX WARN: Code duplicated, block: B:94:0x022a  */
    /* JADX WARN: Code duplicated, block: B:97:0x0237  */
    /* JADX WARN: Code duplicated, block: B:99:0x0242  */
    public final void a() {
        boolean z;
        long j;
        int i;
        long j2;
        long j3;
        int i2;
        Object[] objArr;
        long[] jArr;
        int length;
        n03 n03Var;
        int i3;
        long j4;
        int i4;
        long j5;
        int i5;
        n03 n03Var2;
        long[] jArr2;
        long[] jArr3;
        int i6;
        int i7;
        int i8;
        long j6;
        long j7;
        float[] fArr;
        n03 n03Var3;
        long[] jArr4;
        long j8;
        long j9;
        m4 m4Var = this.g;
        if (m4Var != null) {
            n4.a.removeCallbacks(m4Var);
            this.g = null;
        }
        Handler handler = n4.a;
        long jCurrentTimeMillis = System.currentTimeMillis();
        boolean z2 = this.d;
        boolean z3 = z2 || this.e;
        t9 t9Var = this.a;
        boolean z4 = true;
        o03 o03Var = this.b;
        if (z2) {
            this.d = false;
            yl1 yl1Var = this.c;
            Object[] objArr2 = yl1Var.a;
            int i9 = yl1Var.b;
            for (int i10 = 0; i10 < i9; i10++) {
                ((fq0) objArr2[i10]).a();
            }
            long[] jArr5 = (long[]) t9Var.c;
            int i11 = t9Var.b;
            int i12 = 0;
            while (i12 < jArr5.length - 2 && i12 < i11) {
                long j10 = jArr5[i12 + 2];
                boolean z5 = z4;
                int i13 = i11;
                if ((((int) (j10 >> 60)) & 1) != 0) {
                    long j11 = jArr5[i12];
                    long j12 = jArr5[i12 + 1];
                    n03 n03Var4 = (n03) o03Var.a.b(((int) j10) & 33554431);
                    while (n03Var4 != null) {
                        n03 n03Var5 = n03Var4.d;
                        boolean z6 = z3;
                        long j13 = n03Var4.g;
                        boolean z7 = (jCurrentTimeMillis - j13 >= 0 || j13 == Long.MIN_VALUE) ? z5 : false;
                        n03Var4.e = j11;
                        n03Var4.f = j12;
                        if (z7) {
                            n03Var4.g = jCurrentTimeMillis;
                            j8 = j11;
                            j9 = j12;
                            n03Var4.a(j8, j9, o03Var.d, o03Var.e, o03Var.g);
                        } else {
                            j8 = j11;
                            j9 = j12;
                        }
                        n03Var4 = n03Var5;
                        j11 = j8;
                        j12 = j9;
                        z3 = z6;
                    }
                }
                i12 += 3;
                z4 = z5;
                i11 = i13;
                z3 = z3;
            }
            z = z3;
            j = 0;
            long[] jArr6 = (long[]) t9Var.c;
            int i14 = t9Var.b;
            for (int i15 = 0; i15 < jArr6.length - 2 && i15 < i14; i15 += 3) {
                int i16 = i15 + 2;
                jArr6[i16] = jArr6[i16] & (-1152921504606846977L);
            }
        } else {
            z = z3;
            j = 0;
        }
        if (this.e) {
            this.e = false;
            long j14 = o03Var.d;
            long j15 = o03Var.e;
            float[] fArr2 = o03Var.g;
            ml1 ml1Var = o03Var.a;
            j2 = 128;
            Object[] objArr3 = ml1Var.c;
            long[] jArr7 = ml1Var.a;
            int length2 = jArr7.length - 2;
            if (length2 >= 0) {
                int i17 = 0;
                int i18 = 8;
                j3 = 255;
                while (true) {
                    long j16 = j14;
                    long j17 = jArr7[i17];
                    int i19 = i18;
                    t9Var = t9Var;
                    if ((((~j17) << 7) & j17 & (-9187201950435737472L)) != -9187201950435737472L) {
                        int i20 = 8 - ((~(i17 - length2)) >>> 31);
                        long j18 = j17;
                        int i21 = 0;
                        while (i21 < i20) {
                            if ((j18 & 255) < 128) {
                                n03 n03Var6 = (n03) objArr3[(i17 << 3) + i21];
                                while (n03Var6 != null) {
                                    o03Var.a(n03Var6, j16, j15, fArr2, jCurrentTimeMillis);
                                    n03Var6 = n03Var6.d;
                                    i19 = i19;
                                    jArr7 = jArr7;
                                }
                            }
                            long[] jArr8 = jArr7;
                            int i22 = i19;
                            j18 >>= i22;
                            i21++;
                            j16 = j16;
                            i19 = i22;
                            jArr7 = jArr8;
                        }
                        jArr4 = jArr7;
                        i = i19;
                        j14 = j16;
                        if (i20 != i) {
                            break;
                        }
                    } else {
                        jArr4 = jArr7;
                        i = i19;
                        j14 = j16;
                    }
                    if (i17 == length2) {
                        break;
                    }
                    i17++;
                    i18 = i;
                    t9Var = t9Var;
                    jArr7 = jArr4;
                }
            } else {
                i = 8;
            }
            if (z) {
                j6 = o03Var.d;
                j7 = o03Var.e;
                fArr = o03Var.g;
                n03Var3 = o03Var.b;
                if (n03Var3 != null) {
                    while (n03Var3 != null) {
                        n71 n71VarG = cm4.g(n03Var3.b);
                        long jB = ((r7) q71.a(n71VarG)).getRectManager().b(n71VarG);
                        long j19 = n71VarG.f;
                        n03Var3.e = jB;
                        n03Var3.f = (((long) (((int) (jB & 4294967295L)) + ((int) (j19 & 4294967295L)))) & 4294967295L) | (((long) (((int) (jB >> 32)) + ((int) (j19 >> 32)))) << 32);
                        o03Var.a(n03Var3, j6, j7, fArr, jCurrentTimeMillis);
                        n03Var3 = n03Var3.d;
                    }
                }
            }
            if (this.f) {
                i2 = 0;
                this.f = false;
                t9 t9Var2 = t9Var;
                jArr2 = (long[]) t9Var2.c;
                int i23 = t9Var2.b;
                jArr3 = (long[]) t9Var2.e;
                i7 = 0;
                for (i6 = 0; i6 < jArr2.length - 2 && i7 < jArr3.length - 2 && i6 < i23; i6 += 3) {
                    i8 = i6 + 2;
                    if (jArr2[i8] != m42.a) {
                        jArr3[i7] = jArr2[i6];
                        jArr3[i7 + 1] = jArr2[i6 + 1];
                        jArr3[i7 + 2] = jArr2[i8];
                        i7 += 3;
                    }
                }
                t9Var2.b = i7;
                t9Var2.c = jArr3;
                t9Var2.e = jArr2;
            } else {
                i2 = 0;
            }
            if (o03Var.c <= jCurrentTimeMillis) {
                ml1 ml1Var2 = o03Var.a;
                objArr = ml1Var2.c;
                jArr = ml1Var2.a;
                length = jArr.length - 2;
                if (length >= 0) {
                    i3 = i2;
                    while (true) {
                        j4 = jArr[i3];
                        if ((((~j4) << 7) & j4 & (-9187201950435737472L)) != -9187201950435737472L) {
                            if (i3 != length) {
                                break;
                                break;
                            }
                            i3++;
                        } else {
                            i4 = 8 - ((~(i3 - length)) >>> 31);
                            j5 = j4;
                            for (i5 = i2; i5 < i4; i5++) {
                                if ((j5 & j3) < j2) {
                                    for (n03Var2 = (n03) objArr[(i3 << 3) + i5]; n03Var2 != null; n03Var2 = n03Var2.d) {
                                    }
                                }
                                j5 >>= i;
                            }
                            if (i4 == i) {
                                break;
                            } else if (i3 != length) {
                                break;
                            } else {
                                i3++;
                            }
                        }
                    }
                }
                n03Var = o03Var.b;
                if (n03Var != null) {
                    while (n03Var != null) {
                        n03Var = n03Var.d;
                    }
                }
                o03Var.c = -1L;
            }
            if (o03Var.c > j) {
                j();
            }
        }
        i = 8;
        j2 = 128;
        j3 = 255;
        if (z) {
            j6 = o03Var.d;
            j7 = o03Var.e;
            fArr = o03Var.g;
            n03Var3 = o03Var.b;
            if (n03Var3 != null) {
                while (n03Var3 != null) {
                    n71 n71VarG2 = cm4.g(n03Var3.b);
                    long jB2 = ((r7) q71.a(n71VarG2)).getRectManager().b(n71VarG2);
                    long j110 = n71VarG2.f;
                    n03Var3.e = jB2;
                    n03Var3.f = (((long) (((int) (jB2 & 4294967295L)) + ((int) (j110 & 4294967295L)))) & 4294967295L) | (((long) (((int) (jB2 >> 32)) + ((int) (j110 >> 32)))) << 32);
                    o03Var.a(n03Var3, j6, j7, fArr, jCurrentTimeMillis);
                    n03Var3 = n03Var3.d;
                }
            }
        }
        if (this.f) {
            i2 = 0;
            this.f = false;
            t9 t9Var3 = t9Var;
            jArr2 = (long[]) t9Var3.c;
            int i24 = t9Var3.b;
            jArr3 = (long[]) t9Var3.e;
            i7 = 0;
            while (i6 < jArr2.length - 2) {
                i8 = i6 + 2;
                if (jArr2[i8] != m42.a) {
                    jArr3[i7] = jArr2[i6];
                    jArr3[i7 + 1] = jArr2[i6 + 1];
                    jArr3[i7 + 2] = jArr2[i8];
                    i7 += 3;
                }
            }
            t9Var3.b = i7;
            t9Var3.c = jArr3;
            t9Var3.e = jArr2;
        } else {
            i2 = 0;
        }
        if (o03Var.c <= jCurrentTimeMillis) {
            ml1 ml1Var3 = o03Var.a;
            objArr = ml1Var3.c;
            jArr = ml1Var3.a;
            length = jArr.length - 2;
            if (length >= 0) {
                i3 = i2;
                while (true) {
                    j4 = jArr[i3];
                    if ((((~j4) << 7) & j4 & (-9187201950435737472L)) != -9187201950435737472L) {
                        if (i3 != length) {
                            break;
                            break;
                        }
                        i3++;
                    } else {
                        i4 = 8 - ((~(i3 - length)) >>> 31);
                        j5 = j4;
                        while (i5 < i4) {
                            if ((j5 & j3) < j2) {
                                while (n03Var2 != null) {
                                }
                            }
                            j5 >>= i;
                        }
                        if (i4 == i) {
                            break;
                            break;
                        } else {
                            if (i3 != length) {
                                break;
                                break;
                            }
                            i3++;
                        }
                    }
                }
            }
            n03Var = o03Var.b;
            if (n03Var != null) {
                while (n03Var != null) {
                    n03Var = n03Var.d;
                }
            }
            o03Var.c = -1L;
        }
        if (o03Var.c > j) {
            j();
        }
    }

    public final long b(n71 n71Var) {
        long j;
        int i = n71Var.b & 33554431;
        t9 t9Var = this.a;
        long[] jArr = (long[]) t9Var.c;
        int i2 = t9Var.b;
        int i3 = 0;
        while (true) {
            if (i3 >= jArr.length - 2 || i3 >= i2) {
                j = Long.MAX_VALUE;
                break;
            }
            if ((((int) jArr[i3 + 2]) & 33554431) == i) {
                j = jArr[i3];
                break;
            }
            i3 += 3;
        }
        if (j == Long.MAX_VALUE) {
            return 9223372034707292159L;
        }
        return (((long) ((int) j)) & 4294967295L) | (((long) ((int) (j >> 32))) << 32);
    }

    /* JADX WARN: Code duplicated, block: B:31:0x0105  */
    /* JADX WARN: Code duplicated, block: B:33:0x010a  */
    public final void d(n71 n71Var) {
        char c;
        boolean z;
        n71 n71VarU;
        int i;
        boolean z2 = true;
        n71Var.c = true;
        n71Var.e = 9223372034707292159L;
        zn1 zn1Var = n71Var.o0;
        co1 co1Var = zn1Var.d;
        nh1 nh1Var = n71Var.p0.p;
        int iI0 = nh1Var.i0();
        float fH0 = nh1Var.h0();
        fm1 fm1Var = this.j;
        fm1Var.b = 0.0f;
        fm1Var.c = 0.0f;
        fm1Var.d = iI0;
        fm1Var.e = fH0;
        while (true) {
            c = ' ';
            if (co1Var == null) {
                break;
            }
            n71 n71Var2 = co1Var.x;
            if (co1Var == n71Var2.o0.d && !n71Var2.c) {
                long jB = b(n71Var2);
                if (!e21.a(jB, 9223372034707292159L)) {
                    fm1Var.h((((long) Float.floatToRawIntBits((int) (jB & 4294967295L))) & 4294967295L) | (Float.floatToRawIntBits((int) (jB >> 32)) << 32));
                    break;
                }
            }
            ht1 ht1Var = co1Var.u0;
            if (ht1Var != null) {
                float[] fArrB = ((yu0) ht1Var).b();
                if (!dr4.a(fArrB)) {
                    ih1.c(fArrB, fm1Var);
                }
            }
            long j = co1Var.i0;
            fm1Var.h((4294967295L & ((long) Float.floatToRawIntBits((int) (j & 4294967295L)))) | (Float.floatToRawIntBits((int) (j >> 32)) << 32));
            co1Var = co1Var.X;
        }
        int i2 = (int) fm1Var.b;
        int i3 = (int) fm1Var.c;
        int i4 = (int) fm1Var.d;
        int i5 = (int) fm1Var.e;
        int i6 = n71Var.b;
        boolean z3 = n71Var.k;
        n71Var.k = true;
        t9 t9Var = this.a;
        if (z3) {
            int i7 = i6 & 33554431;
            long[] jArr = (long[]) t9Var.c;
            int i8 = t9Var.b;
            int i9 = 0;
            while (true) {
                if (i9 >= jArr.length - 2 || i9 >= i8) {
                    z = z2;
                    t9 t9Var2 = t9Var;
                    n71VarU = n71Var.u();
                    if (n71VarU != null) {
                        i = n71VarU.b;
                    } else {
                        i = -1;
                    }
                    t9Var2.d(i6, i2, i3, i4, i5, (512 & 32) != 0 ? -1 : i, zn1Var.d(1024), zn1Var.d(16), this.b.a.a(i6), -1);
                } else {
                    int i10 = i9 + 2;
                    char c2 = c;
                    t9 t9Var3 = t9Var;
                    long j2 = jArr[i10];
                    z = z2;
                    if ((((int) j2) & 33554431) == i7) {
                        jArr[i9] = (((long) i2) << c2) | (((long) i3) & 4294967295L);
                        jArr[i9 + 1] = (((long) i5) & 4294967295L) | (((long) i4) << c2);
                        jArr[i10] = (((j2 >> 63) & 1) << 60) | j2;
                    } else {
                        i9 += 3;
                        c = c2;
                        t9Var = t9Var3;
                        z2 = z;
                    }
                }
            }
        } else {
            z = z2;
            t9 t9Var4 = t9Var;
            n71VarU = n71Var.u();
            if (n71VarU != null) {
                i = n71VarU.b;
            } else {
                i = -1;
            }
            t9Var4.d(i6, i2, i3, i4, i5, (512 & 32) != 0 ? -1 : i, zn1Var.d(1024), zn1Var.d(16), this.b.a.a(i6), -1);
        }
        this.d = z;
        pm1 pm1VarZ = n71Var.z();
        Object[] objArr = pm1VarZ.a;
        int i11 = pm1VarZ.c;
        for (int i12 = 0; i12 < i11; i12++) {
            n71 n71Var3 = (n71) objArr[i12];
            if (n71Var3.I()) {
                d(n71Var3);
            }
        }
    }

    public final void e(n71 n71Var) {
        if (n71Var.k) {
            this.d = true;
            int i = n71Var.b & 33554431;
            t9 t9Var = this.a;
            long[] jArr = (long[]) t9Var.c;
            int i2 = t9Var.b;
            for (int i3 = 0; i3 < jArr.length - 2 && i3 < i2; i3 += 3) {
                int i4 = i3 + 2;
                long j = jArr[i4];
                if ((((int) j) & 33554431) == i) {
                    jArr[i4] = (((j >> 63) & 1) << 60) | j;
                    break;
                }
            }
        }
        j();
    }

    public final void f(n71 n71Var, boolean z) {
        long j;
        long j2;
        int i;
        long[] jArr;
        int i2;
        boolean zI = n71Var.I();
        zn1 zn1Var = n71Var.o0;
        if (zI) {
            n71 n71VarU = n71Var.u();
            if (n71VarU == null || n71VarU.c) {
                j = n71VarU == null ? 0L : 9223372034707292159L;
            } else {
                if (n71VarU.j) {
                    n71VarU.j = false;
                    n71VarU.i = g(n71VarU);
                }
                j = n71VarU.i;
            }
            co1 co1Var = zn1Var.d;
            if (e21.a(j, 9223372034707292159L) || c(co1Var)) {
                d(n71Var);
                return;
            }
            if (n71Var.c) {
                d(n71Var);
                i(n71Var);
                return;
            }
            long jC = e21.c(j, co1Var.i0);
            nh1 nh1Var = n71Var.p0.p;
            int iI0 = nh1Var.i0();
            int iH0 = nh1Var.h0();
            long j3 = (((long) iI0) << 32) | (((long) iH0) & 4294967295L);
            int i3 = n71Var.b;
            boolean z2 = n71Var.k;
            t9 t9Var = this.a;
            if (!z2) {
                j2 = jC;
                n71Var.k = true;
                boolean zD = zn1Var.d(1024);
                boolean zD2 = zn1Var.d(16);
                boolean zA = this.b.a.a(i3);
                if (n71VarU != null) {
                    int i4 = n71VarU.b;
                    int i5 = (int) (j2 >> 32);
                    int i6 = (int) (j2 & 4294967295L);
                    int i7 = i3 & 33554431;
                    long[] jArr2 = (long[]) t9Var.c;
                    int i8 = t9Var.b;
                    for (int i9 = 0; i9 < jArr2.length - 2 && i9 < i8; i9 += 3) {
                        if ((((int) jArr2[i9 + 2]) & 33554431) == i4) {
                            long j4 = jArr2[i9];
                            int i10 = ((int) (j4 >> 32)) + i5;
                            int i11 = ((int) j4) + i6;
                            t9Var.d(i7, i10, i11, i10 + iI0, i11 + iH0, i4, zD, zD2, zA, i9);
                            break;
                        }
                    }
                } else {
                    int i12 = (int) (j2 >> 32);
                    int i13 = (int) (j2 & 4294967295L);
                    t9Var.d(i3, i12, i13, i12 + iI0, i13 + iH0, (512 & 32) != 0 ? -1 : 0, zD, zD2, zA, -1);
                }
                this.d = true;
            } else if (!z && e21.a(jC, n71Var.e) && l21.a(j3, n71Var.f)) {
                j2 = jC;
            } else {
                if (n71VarU != null) {
                    int i14 = n71VarU.b;
                    int i15 = (int) (jC >> 32);
                    j2 = jC;
                    int i16 = (int) (j2 & 4294967295L);
                    int i17 = i3 & 33554431;
                    long[] jArr3 = (long[]) t9Var.c;
                    int i18 = t9Var.b;
                    int i19 = 0;
                    loop0: while (i19 < jArr3.length - 2 && i19 < i18) {
                        int i20 = i18;
                        if ((((int) jArr3[i19 + 2]) & 33554431) == i14) {
                            long j5 = jArr3[i19];
                            i = i16;
                            int i21 = ((int) (j5 >> 32)) + i15;
                            int i22 = ((int) j5) + i;
                            int i23 = i21 + iI0;
                            int i24 = i22 + iH0;
                            i19 += 3;
                            while (true) {
                                if (i19 >= jArr3.length - 2) {
                                    i2 = i20;
                                    break;
                                }
                                int i25 = i20;
                                if (i19 >= i25) {
                                    i2 = i25;
                                    break;
                                }
                                int i26 = i19 + 2;
                                int i27 = iI0;
                                long j6 = jArr3[i26];
                                long[] jArr4 = jArr3;
                                if ((((int) j6) & 33554431) == i17) {
                                    long j7 = jArr4[i19];
                                    int i28 = i21 - ((int) (j7 >> 32));
                                    int i29 = i22 - ((int) j7);
                                    jArr4[i19] = (((long) i22) & 4294967295L) | (((long) i21) << 32);
                                    jArr4[i19 + 1] = (((long) i23) << 32) | (((long) i24) & 4294967295L);
                                    jArr4[i26] = j6 | (((j6 >> 63) & 1) << 60);
                                    if (i28 != 0 || i29 != 0) {
                                        int i30 = m42.b;
                                        t9Var.g(i28, i29, (j6 & (-1125899873288193L)) | (((long) ((i19 + 3) & 33554431)) << 25));
                                        break loop0;
                                    }
                                    break loop0;
                                }
                                i19 += 3;
                                iI0 = i27;
                                i20 = i25;
                                jArr3 = jArr4;
                            }
                            jArr = jArr3;
                        } else {
                            i = i16;
                            jArr = jArr3;
                            i2 = i20;
                        }
                        i19 += 3;
                        i14 = i14;
                        iI0 = iI0;
                        i16 = i;
                        iH0 = iH0;
                        i18 = i2;
                        jArr3 = jArr;
                    }
                } else {
                    j2 = jC;
                    int i31 = (int) (j2 >> 32);
                    int i32 = (int) (j2 & 4294967295L);
                    int i33 = i31 + iI0;
                    int i34 = i32 + iH0;
                    int i35 = i3 & 33554431;
                    long[] jArr5 = (long[]) t9Var.c;
                    int i36 = t9Var.b;
                    int i37 = 0;
                    while (i37 < jArr5.length - 2 && i37 < i36) {
                        int i38 = i37 + 2;
                        long j8 = jArr5[i38];
                        long[] jArr6 = jArr5;
                        if ((((int) j8) & 33554431) == i35) {
                            long j9 = jArr6[i37];
                            int i39 = i37;
                            jArr6[i39] = (((long) i31) << 32) | (((long) i32) & 4294967295L);
                            jArr6[i39 + 1] = (((long) i33) << 32) | (((long) i34) & 4294967295L);
                            jArr6[i38] = (((j8 >> 63) & 1) << 60) | j8;
                            int i40 = i31 - ((int) (j9 >> 32));
                            int i41 = i32 - ((int) j9);
                            if (!(i40 != 0) && !(i41 != 0)) {
                                break;
                            }
                            int i42 = m42.b;
                            t9Var.g(i40, i41, (j8 & (-1125899873288193L)) | (((long) ((i39 + 3) & 33554431)) << 25));
                            break;
                        }
                        i37 += 3;
                        jArr5 = jArr6;
                    }
                }
                this.d = true;
            }
            n71Var.f = j3;
            n71Var.e = j2;
        }
    }

    public final void h(n71 n71Var) {
        if (n71Var.k) {
            int i = n71Var.b & 33554431;
            t9 t9Var = this.a;
            long[] jArr = (long[]) t9Var.c;
            int i2 = t9Var.b;
            for (int i3 = 0; i3 < jArr.length - 2 && i3 < i2; i3 += 3) {
                int i4 = i3 + 2;
                if ((((int) jArr[i4]) & 33554431) == i) {
                    jArr[i3] = -1;
                    jArr[i3 + 1] = -1;
                    jArr[i4] = m42.a;
                    break;
                }
            }
            n71Var.k = false;
            this.d = true;
            this.f = true;
        }
    }

    public final void j() {
        m4 m4Var = this.g;
        boolean z = m4Var != null;
        long j = this.b.c;
        if (j >= 0 || !z) {
            if (this.h == j && z) {
                return;
            }
            if (m4Var != null) {
                Handler handler = n4.a;
                n4.a.removeCallbacks(m4Var);
            }
            Handler handler2 = n4.a;
            long jCurrentTimeMillis = System.currentTimeMillis();
            long jMax = Math.max(j, 16 + jCurrentTimeMillis);
            this.h = jMax;
            m4 m4Var2 = new m4(this.i, 0);
            n4.a.postDelayed(m4Var2, jMax - jCurrentTimeMillis);
            this.g = m4Var2;
        }
    }
}
