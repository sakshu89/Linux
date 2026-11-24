package defpackage;

import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class mf1 extends zw1 implements sk1, qh1 {
    public jf1 i;
    public hq0 j;
    public bx1 k;
    public boolean n;
    public boolean s;
    public boolean t;
    public final nf1 u = new nf1(0, this);
    public we v;
    public gm1 w;

    public static void H0(co1 co1Var) {
        o71 o71Var;
        co1 co1Var2 = co1Var.H;
        n71 n71Var = co1Var.x;
        if (!g31.a(co1Var2 != null ? co1Var2.x : null, n71Var)) {
            n71Var.p0.p.f0.f();
            return;
        }
        i6 i6VarQ = n71Var.p0.p.q();
        if (i6VarQ == null || (o71Var = ((nh1) i6VarQ).f0) == null) {
            return;
        }
        o71Var.f();
    }

    public abstract y61 A0();

    public abstract boolean B0();

    public abstract n71 C0();

    public abstract ph1 D0();

    public abstract mf1 E0();

    public abstract long F0();

    public final jf1 G0() {
        jf1 jf1Var = this.i;
        if (jf1Var != null) {
            return jf1Var;
        }
        jf1 jf1Var2 = new jf1(this);
        this.i = jf1Var2;
        return jf1Var2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void I0(hm1 hm1Var) {
        n71 n71Var;
        Object[] objArr = hm1Var.b;
        long[] jArr = hm1Var.a;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i = 0;
        while (true) {
            long j = jArr[i];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i2 = 8 - ((~(i - length)) >>> 31);
                for (int i3 = 0; i3 < i2; i3++) {
                    if ((255 & j) < 128 && (n71Var = (n71) ((m93) objArr[(i << 3) + i3]).get()) != null) {
                        if (s()) {
                            n71Var.S(false);
                        } else {
                            n71Var.U(false);
                        }
                    }
                    j >>= 8;
                }
                if (i2 != 8) {
                    return;
                }
            }
            if (i == length) {
                return;
            } else {
                i++;
            }
        }
    }

    public abstract void J0();

    @Override // defpackage.qh1
    public final ph1 O(int i, int i2, Map map, hq0 hq0Var, hq0 hq0Var2) {
        if ((i & (-16777216)) != 0 || ((-16777216) & i2) != 0) {
            z01.b("Size(" + i + " x " + i2 + ") is out of range. Each dimension must be between 0 and 16777215.");
        }
        return new lf1(i, i2, map, hq0Var, hq0Var2, this);
    }

    @Override // defpackage.sk1
    public final void o(boolean z) {
        mf1 mf1VarE0 = E0();
        n71 n71VarC0 = mf1VarE0 != null ? mf1VarE0.C0() : null;
        if (g31.a(n71VarC0, C0())) {
            this.n = z;
            return;
        }
        if ((n71VarC0 != null ? n71VarC0.p0.d : null) != j71.c) {
            if ((n71VarC0 != null ? n71VarC0.p0.d : null) != j71.e) {
                return;
            }
        }
        this.n = z;
    }

    @Override // defpackage.z21
    public boolean s() {
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:47:0x0108  */
    /* JADX WARN: Multi-variable type inference failed */
    public final void s0(n71 n71Var, tw0 tw0Var) {
        char c;
        long j;
        long j2;
        long j3;
        long[] jArr;
        long[] jArr2;
        long j4;
        int i;
        char c2;
        long j5;
        long j6;
        int i2;
        int i3;
        int i4;
        gm1 gm1Var = this.w;
        char c3 = 7;
        long j7 = -9187201950435737472L;
        int i5 = 8;
        if (gm1Var != null) {
            Object[] objArr = gm1Var.c;
            long[] jArr3 = gm1Var.a;
            int length = jArr3.length - 2;
            if (length >= 0) {
                int i6 = 0;
                long j8 = 128;
                while (true) {
                    long j9 = jArr3[i6];
                    j2 = 255;
                    if ((((~j9) << c3) & j9 & j7) != j7) {
                        int i7 = 8 - ((~(i6 - length)) >>> 31);
                        int i8 = 0;
                        while (i8 < i7) {
                            if ((j9 & 255) < j8) {
                                c2 = c3;
                                hm1 hm1Var = (hm1) objArr[(i6 << 3) + i8];
                                j5 = j7;
                                Object[] objArr2 = hm1Var.b;
                                long[] jArr4 = hm1Var.a;
                                int length2 = jArr4.length - 2;
                                if (length2 >= 0) {
                                    j6 = j8;
                                    int i9 = 0;
                                    int i10 = i5;
                                    while (true) {
                                        int i11 = length2;
                                        long j10 = jArr4[i9];
                                        jArr2 = jArr3;
                                        j4 = j9;
                                        if ((((~j10) << c2) & j10 & j5) != j5) {
                                            int i12 = 8 - ((~(i9 - i11)) >>> 31);
                                            int i13 = 0;
                                            while (i13 < i12) {
                                                if ((j10 & 255) < j6) {
                                                    int i14 = (i9 << 3) + i13;
                                                    n71 n71Var2 = (n71) ((m93) objArr2[i14]).get();
                                                    i3 = i13;
                                                    if (n71Var2 != null) {
                                                        boolean zH = n71Var2.H();
                                                        i4 = i8;
                                                        if (zH) {
                                                        }
                                                    } else {
                                                        i4 = i8;
                                                    }
                                                    hm1Var.m(i14);
                                                } else {
                                                    i3 = i13;
                                                    i4 = i8;
                                                }
                                                j10 >>= i10;
                                                i13 = i3 + 1;
                                                i8 = i4;
                                            }
                                            i = i8;
                                            if (i12 != i10) {
                                                break;
                                            }
                                        } else {
                                            i = i8;
                                        }
                                        length2 = i11;
                                        if (i9 == length2) {
                                            break;
                                        }
                                        i9++;
                                        jArr3 = jArr2;
                                        j9 = j4;
                                        i8 = i;
                                        i10 = 8;
                                    }
                                } else {
                                    jArr2 = jArr3;
                                    j4 = j9;
                                    i = i8;
                                    j6 = j8;
                                }
                                i2 = 8;
                            } else {
                                jArr2 = jArr3;
                                j4 = j9;
                                i = i8;
                                c2 = c3;
                                j5 = j7;
                                j6 = j8;
                                i2 = i5;
                            }
                            i5 = i2;
                            j9 = j4 >> i2;
                            c3 = c2;
                            j7 = j5;
                            j8 = j6;
                            i8 = i + 1;
                            jArr3 = jArr2;
                        }
                        jArr = jArr3;
                        c = c3;
                        j = j7;
                        j3 = j8;
                        if (i7 != i5) {
                            break;
                        }
                    } else {
                        jArr = jArr3;
                        c = c3;
                        j = j7;
                        j3 = j8;
                    }
                    if (i6 == length) {
                        break;
                    }
                    i6++;
                    c3 = c;
                    j7 = j;
                    j8 = j3;
                    jArr3 = jArr;
                    i5 = 8;
                }
            } else {
                c = 7;
                j = -9187201950435737472L;
                j2 = 255;
                j3 = 128;
            }
        } else {
            c = 7;
            j = -9187201950435737472L;
            j2 = 255;
            j3 = 128;
        }
        gm1 gm1Var2 = this.w;
        if (gm1Var2 != null) {
            long[] jArr5 = gm1Var2.a;
            int length3 = jArr5.length - 2;
            if (length3 >= 0) {
                int i15 = 0;
                while (true) {
                    long j11 = jArr5[i15];
                    if ((((~j11) << c) & j11 & j) != j) {
                        int i16 = 8 - ((~(i15 - length3)) >>> 31);
                        for (int i17 = 0; i17 < i16; i17++) {
                            if ((j11 & j2) < j3) {
                                int i18 = (i15 << 3) + i17;
                                if (((hm1) gm1Var2.c[i18]).g()) {
                                    gm1Var2.l(i18);
                                }
                            }
                            j11 >>= 8;
                        }
                        if (i16 != 8) {
                            break;
                        }
                    }
                    if (i15 == length3) {
                        break;
                    } else {
                        i15++;
                    }
                }
            }
        }
        gm1 gm1Var3 = this.w;
        if (gm1Var3 == null) {
            gm1Var3 = new gm1();
            this.w = gm1Var3;
        }
        Object objG = gm1Var3.g(tw0Var);
        if (objG == null) {
            objG = new hm1();
            gm1Var3.m(tw0Var, objG);
        }
        ((hm1) objG).k(new m93(n71Var));
    }

    public abstract int t0(d6 d6Var);

    /* JADX WARN: Multi-variable type inference failed */
    public final void w0(bx1 bx1Var, long j, long j2) {
        char c;
        long j3;
        long j4;
        long j5;
        n71 n71Var;
        int i;
        char c2;
        long j6;
        mf1 mf1VarE0;
        lt1 snapshotObserver;
        gm1 gm1Var = this.w;
        we weVar = this.v;
        if (weVar == null) {
            weVar = new we();
            this.v = weVar;
        }
        we weVar2 = weVar;
        it1 it1Var = C0().x;
        if (it1Var != null && (snapshotObserver = ((r7) it1Var).getSnapshotObserver()) != null) {
            snapshotObserver.a.c(bx1Var, j7.j0, new kf1(this, j, j2, bx1Var));
        }
        boolean zS = s();
        hm1 hm1Var = (hm1) weVar2.e;
        hm1 hm1Var2 = (hm1) weVar2.f;
        int i2 = weVar2.a;
        for (int i3 = 0; i3 < i2; i3++) {
            byte b = ((byte[]) weVar2.d)[i3];
            if (b == 3) {
                tw0 tw0Var = ((tw0[]) weVar2.b)[i3];
                tw0Var.getClass();
                hm1Var2.k(tw0Var);
            } else if (b != 0 && gm1Var != null) {
                tw0 tw0Var2 = ((tw0[]) weVar2.b)[i3];
                tw0Var2.getClass();
                hm1 hm1Var3 = (hm1) gm1Var.k(tw0Var2);
                if (hm1Var3 != null) {
                    hm1Var.j(hm1Var3);
                }
            }
        }
        int i4 = weVar2.a;
        int i5 = 0;
        for (int i6 = 0; i6 < i4; i6++) {
            byte[] bArr = (byte[]) weVar2.d;
            if (bArr[i6] == 2) {
                i5++;
            } else if (i5 > 0) {
                tw0[] tw0VarArr = (tw0[]) weVar2.b;
                tw0VarArr[i6 - i5] = tw0VarArr[i6];
            }
            bArr[i6] = 2;
        }
        int i7 = weVar2.a;
        for (int i8 = i7 - i5; i8 < i7; i8++) {
            ((tw0[]) weVar2.b)[i8] = null;
        }
        weVar2.a -= i5;
        mf1 mf1VarE1 = E0();
        Object[] objArr = hm1Var2.b;
        long[] jArr = hm1Var2.a;
        int length = jArr.length - 2;
        char c3 = 7;
        long j7 = -9187201950435737472L;
        int i9 = 8;
        if (length >= 0) {
            j4 = 128;
            int i10 = 0;
            while (true) {
                long j8 = jArr[i10];
                j5 = 255;
                if ((((~j8) << c3) & j8 & j7) != j7) {
                    int i11 = 8 - ((~(i10 - length)) >>> 31);
                    int i12 = 0;
                    while (i12 < i11) {
                        if ((j8 & 255) < 128) {
                            c2 = c3;
                            tw0 tw0Var3 = (tw0) objArr[(i10 << 3) + i12];
                            j6 = j7;
                            mf1 mf1Var = mf1VarE1 == null ? this : mf1VarE1;
                            i = i9;
                            mf1 mf1Var2 = mf1Var;
                            while (true) {
                                we weVar3 = mf1Var2.v;
                                if ((weVar3 != null && qg.q((tw0[]) weVar3.b, tw0Var3) >= 0) || (mf1VarE0 = mf1Var2.E0()) == null) {
                                    break;
                                } else {
                                    mf1Var2 = mf1VarE0;
                                }
                            }
                            gm1 gm1Var2 = mf1Var2.w;
                            hm1 hm1Var4 = gm1Var2 != null ? (hm1) gm1Var2.k(tw0Var3) : null;
                            if (hm1Var4 != null) {
                                mf1Var.I0(hm1Var4);
                            }
                        } else {
                            i = i9;
                            c2 = c3;
                            j6 = j7;
                        }
                        j8 >>= i;
                        i12++;
                        c3 = c2;
                        j7 = j6;
                        i9 = i;
                    }
                    c = c3;
                    j3 = j7;
                    if (i11 != i9) {
                        break;
                    }
                } else {
                    c = c3;
                    j3 = j7;
                }
                if (i10 == length) {
                    break;
                }
                i10++;
                c3 = c;
                j7 = j3;
                i9 = 8;
            }
        } else {
            c = 7;
            j3 = -9187201950435737472L;
            j4 = 128;
            j5 = 255;
        }
        hm1Var2.b();
        Object[] objArr2 = hm1Var.b;
        long[] jArr2 = hm1Var.a;
        int length2 = jArr2.length - 2;
        if (length2 >= 0) {
            int i13 = 0;
            while (true) {
                long j9 = jArr2[i13];
                if ((((~j9) << c) & j9 & j3) != j3) {
                    int i14 = 8 - ((~(i13 - length2)) >>> 31);
                    for (int i15 = 0; i15 < i14; i15++) {
                        if ((j9 & j5) < j4 && (n71Var = (n71) ((m93) objArr2[(i13 << 3) + i15]).get()) != null) {
                            if (zS) {
                                n71Var.S(false);
                            } else {
                                n71Var.U(false);
                            }
                        }
                        j9 >>= 8;
                    }
                    if (i14 != 8) {
                        break;
                    }
                }
                if (i13 == length2) {
                    break;
                } else {
                    i13++;
                }
            }
        }
        hm1Var.b();
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0050 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:21:0x0052 A[LOOP:0: B:11:0x001b->B:21:0x0052, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:48:0x0055 A[EDGE_INSN: B:48:0x0055->B:22:0x0055 BREAK  A[LOOP:0: B:11:0x001b->B:21:0x0052], SYNTHETIC] */
    public final void x0(ph1 ph1Var) {
        long j;
        long j2;
        gm1 gm1Var = this.w;
        if (this.t) {
            return;
        }
        hq0 hq0VarE = ph1Var.e();
        if (hq0VarE != null) {
            boolean z = this.j != hq0VarE;
            if (z || !G0().a) {
                j = 0;
                j2 = 9223372034707292159L;
            } else {
                y61 y61VarA0 = A0();
                long jB = ap4.b(y61VarA0.a(0L));
                long jS = y61VarA0.S();
                j2 = jB;
                j = jS;
                z = (e21.a(jB, G0().b) && l21.a(jS, G0().c)) ? false : true;
            }
            if (z) {
                bx1 bx1Var = this.k;
                if (bx1Var != null) {
                    bx1Var.a = ph1Var;
                } else {
                    bx1Var = new bx1(ph1Var, this);
                    this.k = bx1Var;
                }
                w0(bx1Var, j2, j);
                this.j = ph1Var.e();
                return;
            }
            return;
        }
        if (gm1Var != null) {
            Object[] objArr = gm1Var.c;
            long[] jArr = gm1Var.a;
            int length = jArr.length - 2;
            if (length >= 0) {
                int i = 0;
                while (true) {
                    long j3 = jArr[i];
                    if ((((~j3) << 7) & j3 & (-9187201950435737472L)) == -9187201950435737472L) {
                        if (i != length) {
                            break;
                            break;
                        }
                        i++;
                    } else {
                        int i2 = 8 - ((~(i - length)) >>> 31);
                        for (int i3 = 0; i3 < i2; i3++) {
                            if ((255 & j3) < 128) {
                                I0((hm1) objArr[(i << 3) + i3]);
                            }
                            j3 >>= 8;
                        }
                        if (i2 != 8) {
                            break;
                        } else if (i != length) {
                            break;
                        } else {
                            i++;
                        }
                    }
                }
            }
            gm1Var.a();
        }
    }

    public final int y0(d6 d6Var) {
        int iT0;
        if (!B0() || (iT0 = t0(d6Var)) == Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        boolean z = d6Var instanceof j73;
        long j = this.f;
        return iT0 + ((int) (z ? j >> 32 : 4294967295L & j));
    }

    public abstract mf1 z0();
}
