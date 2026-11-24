package defpackage;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class x23 {
    public static final x23 e = new x23(0, 0, new Object[0], null);
    public int a;
    public int b;
    public final y74 c;
    public Object[] d;

    public x23(int i, int i2, Object[] objArr, y74 y74Var) {
        this.a = i;
        this.b = i2;
        this.c = y74Var;
        this.d = objArr;
    }

    public static x23 j(int i, Object obj, Object obj2, int i2, Object obj3, Object obj4, int i3, y74 y74Var) {
        if (i3 > 30) {
            return new x23(0, 0, new Object[]{obj, obj2, obj3, obj4}, y74Var);
        }
        int iE = ld4.e(i, i3);
        int iE2 = ld4.e(i2, i3);
        if (iE != iE2) {
            return new x23((1 << iE) | (1 << iE2), 0, iE < iE2 ? new Object[]{obj, obj2, obj3, obj4} : new Object[]{obj3, obj4, obj, obj2}, y74Var);
        }
        return new x23(0, 1 << iE, new Object[]{j(i, obj, obj2, i2, obj3, obj4, i3 + 5, y74Var)}, y74Var);
    }

    public final Object[] a(int i, int i2, int i3, Object obj, Object obj2, int i4, y74 y74Var) {
        Object obj3 = this.d[i];
        x23 x23VarJ = j(obj3 != null ? obj3.hashCode() : 0, obj3, x(i), i3, obj, obj2, i4 + 5, y74Var);
        int iT = t(i2);
        int i5 = iT + 1;
        Object[] objArr = this.d;
        Object[] objArr2 = new Object[objArr.length - 1];
        qg.i(objArr, 0, objArr2, i, 6);
        qg.g(objArr, i, objArr2, i + 2, i5);
        objArr2[iT - 1] = x23VarJ;
        qg.g(objArr, iT, objArr2, i5, objArr.length);
        return objArr2;
    }

    public final int b() {
        if (this.b == 0) {
            return this.d.length / 2;
        }
        int iBitCount = Integer.bitCount(this.a);
        int length = this.d.length;
        for (int i = iBitCount * 2; i < length; i++) {
            iBitCount += s(i).b();
        }
        return iBitCount;
    }

    public final boolean c(Object obj) {
        f21 f21VarE = ky3.e(ky3.f(0, this.d.length), 2);
        int i = f21VarE.a;
        int i2 = f21VarE.b;
        int i3 = f21VarE.c;
        if ((i3 > 0 && i <= i2) || (i3 < 0 && i2 <= i)) {
            while (!g31.a(obj, this.d[i])) {
                if (i != i2) {
                    i += i3;
                }
            }
            return true;
        }
        return false;
    }

    public final boolean d(int i, int i2, Object obj) {
        int iE = 1 << ld4.e(i, i2);
        if (h(iE)) {
            return g31.a(obj, this.d[f(iE)]);
        }
        if (!i(iE)) {
            return false;
        }
        x23 x23VarS = s(t(iE));
        return i2 == 30 ? x23VarS.c(obj) : x23VarS.d(i, i2 + 5, obj);
    }

    public final boolean e(x23 x23Var) {
        if (this == x23Var) {
            return true;
        }
        if (this.b == x23Var.b && this.a == x23Var.a) {
            int length = this.d.length;
            for (int i = 0; i < length; i++) {
                if (this.d[i] == x23Var.d[i]) {
                }
            }
            return true;
        }
        return false;
    }

    public final int f(int i) {
        return Integer.bitCount(this.a & (i - 1)) * 2;
    }

    public final Object g(int i, int i2, Object obj) {
        int iE = 1 << ld4.e(i, i2);
        if (h(iE)) {
            int iF = f(iE);
            if (g31.a(obj, this.d[iF])) {
                return x(iF);
            }
            return null;
        }
        if (!i(iE)) {
            return null;
        }
        x23 x23VarS = s(t(iE));
        if (i2 != 30) {
            return x23VarS.g(i, i2 + 5, obj);
        }
        f21 f21VarE = ky3.e(ky3.f(0, x23VarS.d.length), 2);
        int i3 = f21VarE.a;
        int i4 = f21VarE.b;
        int i5 = f21VarE.c;
        if ((i5 <= 0 || i3 > i4) && (i5 >= 0 || i4 > i3)) {
            return null;
        }
        while (!g31.a(obj, x23VarS.d[i3])) {
            if (i3 == i4) {
                return null;
            }
            i3 += i5;
        }
        return x23VarS.x(i3);
    }

    public final boolean h(int i) {
        return (this.a & i) != 0;
    }

    public final boolean i(int i) {
        return (this.b & i) != 0;
    }

    public final x23 k(int i, fw1 fw1Var) {
        fw1Var.e(fw1Var.f - 1);
        fw1Var.c = x(i);
        Object[] objArr = this.d;
        if (objArr.length == 2) {
            return null;
        }
        if (this.c != fw1Var.a) {
            return new x23(0, 0, ld4.c(i, objArr), fw1Var.a);
        }
        this.d = ld4.c(i, objArr);
        return this;
    }

    public final x23 l(int i, Object obj, Object obj2, int i2, fw1 fw1Var) {
        fw1 fw1Var2;
        x23 x23VarL;
        int iE = 1 << ld4.e(i, i2);
        boolean zH = h(iE);
        y74 y74Var = this.c;
        if (zH) {
            int iF = f(iE);
            if (!g31.a(obj, this.d[iF])) {
                fw1Var.e(fw1Var.f + 1);
                y74 y74Var2 = fw1Var.a;
                if (y74Var != y74Var2) {
                    return new x23(this.a ^ iE, this.b | iE, a(iF, iE, i, obj, obj2, i2, y74Var2), y74Var2);
                }
                this.d = a(iF, iE, i, obj, obj2, i2, y74Var2);
                this.a ^= iE;
                this.b |= iE;
                return this;
            }
            fw1Var.c = x(iF);
            if (x(iF) == obj2) {
                return this;
            }
            if (y74Var == fw1Var.a) {
                this.d[iF + 1] = obj2;
                return this;
            }
            fw1Var.e++;
            Object[] objArr = this.d;
            Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
            objArrCopyOf[iF + 1] = obj2;
            return new x23(this.a, this.b, objArrCopyOf, fw1Var.a);
        }
        if (!i(iE)) {
            fw1Var.e(fw1Var.f + 1);
            y74 y74Var3 = fw1Var.a;
            int iF2 = f(iE);
            Object[] objArr2 = this.d;
            if (y74Var != y74Var3) {
                return new x23(this.a | iE, this.b, ld4.b(objArr2, iF2, obj, obj2), y74Var3);
            }
            this.d = ld4.b(objArr2, iF2, obj, obj2);
            this.a |= iE;
            return this;
        }
        int iT = t(iE);
        x23 x23VarS = s(iT);
        if (i2 == 30) {
            f21 f21VarE = ky3.e(ky3.f(0, x23VarS.d.length), 2);
            int i3 = f21VarE.a;
            int i4 = f21VarE.b;
            int i5 = f21VarE.c;
            if ((i5 > 0 && i3 <= i4) || (i5 < 0 && i4 <= i3)) {
                while (true) {
                    if (!g31.a(obj, x23VarS.d[i3])) {
                        if (i3 == i4) {
                            fw1Var.e(fw1Var.f + 1);
                            x23VarL = new x23(0, 0, ld4.b(x23VarS.d, 0, obj, obj2), fw1Var.a);
                            break;
                        }
                        i3 += i5;
                    } else {
                        fw1Var.c = x23VarS.x(i3);
                        if (x23VarS.c != fw1Var.a) {
                            fw1Var.e++;
                            Object[] objArr3 = x23VarS.d;
                            Object[] objArrCopyOf2 = Arrays.copyOf(objArr3, objArr3.length);
                            objArrCopyOf2[i3 + 1] = obj2;
                            x23VarL = new x23(0, 0, objArrCopyOf2, fw1Var.a);
                            break;
                        }
                        x23VarS.d[i3 + 1] = obj2;
                        x23VarL = x23VarS;
                        break;
                    }
                }
            } else {
                fw1Var.e(fw1Var.f + 1);
                x23VarL = new x23(0, 0, ld4.b(x23VarS.d, 0, obj, obj2), fw1Var.a);
                break;
            }
            fw1Var2 = fw1Var;
        } else {
            fw1Var2 = fw1Var;
            x23VarL = x23VarS.l(i, obj, obj2, i2 + 5, fw1Var2);
        }
        return x23VarS == x23VarL ? this : r(iT, x23VarL, fw1Var2.a);
    }

    public final x23 m(x23 x23Var, int i, ic0 ic0Var, fw1 fw1Var) {
        x23 x23Var2;
        Object[] objArr;
        x23 x23VarJ;
        if (this == x23Var) {
            ic0Var.a += b();
            return this;
        }
        int i2 = 0;
        if (i > 30) {
            y74 y74Var = fw1Var.a;
            int i3 = x23Var.b;
            Object[] objArr2 = this.d;
            Object[] objArrCopyOf = Arrays.copyOf(objArr2, objArr2.length + x23Var.d.length);
            int length = this.d.length;
            f21 f21VarE = ky3.e(ky3.f(0, x23Var.d.length), 2);
            int i4 = f21VarE.a;
            int i5 = f21VarE.b;
            int i6 = f21VarE.c;
            if ((i6 > 0 && i4 <= i5) || (i6 < 0 && i5 <= i4)) {
                while (true) {
                    if (c(x23Var.d[i4])) {
                        ic0Var.a++;
                    } else {
                        Object[] objArr3 = x23Var.d;
                        objArrCopyOf[length] = objArr3[i4];
                        objArrCopyOf[length + 1] = objArr3[i4 + 1];
                        length += 2;
                    }
                    if (i4 == i5) {
                        break;
                    }
                    i4 += i6;
                }
            }
            if (length != this.d.length) {
                if (length == x23Var.d.length) {
                    return x23Var;
                }
                return length == objArrCopyOf.length ? new x23(0, 0, objArrCopyOf, y74Var) : new x23(0, 0, Arrays.copyOf(objArrCopyOf, length), y74Var);
            }
        } else {
            int i7 = this.b | x23Var.b;
            int i8 = this.a;
            int i9 = x23Var.a;
            int i10 = (i8 ^ i9) & (~i7);
            int i11 = i8 & i9;
            int i12 = i10;
            while (i11 != 0) {
                int iLowestOneBit = Integer.lowestOneBit(i11);
                if (g31.a(this.d[f(iLowestOneBit)], x23Var.d[x23Var.f(iLowestOneBit)])) {
                    i12 |= iLowestOneBit;
                } else {
                    i7 |= iLowestOneBit;
                }
                i11 ^= iLowestOneBit;
            }
            if ((i7 & i12) != 0) {
                dz1.b("Check failed.");
            }
            if (g31.a(this.c, fw1Var.a) && this.a == i12 && this.b == i7) {
                x23Var2 = this;
            } else {
                x23Var2 = new x23(i12, i7, new Object[Integer.bitCount(i7) + (Integer.bitCount(i12) * 2)], null);
            }
            int i13 = i7;
            int i14 = 0;
            while (i13 != 0) {
                int iLowestOneBit2 = Integer.lowestOneBit(i13);
                Object[] objArr4 = x23Var2.d;
                int length2 = (objArr4.length - 1) - i14;
                if (i(iLowestOneBit2)) {
                    x23VarJ = s(t(iLowestOneBit2));
                    if (x23Var.i(iLowestOneBit2)) {
                        x23VarJ = x23VarJ.m(x23Var.s(x23Var.t(iLowestOneBit2)), i + 5, ic0Var, fw1Var);
                        objArr = objArr4;
                    } else if (x23Var.h(iLowestOneBit2)) {
                        int iF = x23Var.f(iLowestOneBit2);
                        Object obj = x23Var.d[iF];
                        Object objX = x23Var.x(iF);
                        int i15 = fw1Var.f;
                        objArr = objArr4;
                        x23VarJ = x23VarJ.l(obj != null ? obj.hashCode() : i2, obj, objX, i + 5, fw1Var);
                        if (fw1Var.f == i15) {
                            ic0Var.a++;
                        }
                    } else {
                        objArr = objArr4;
                    }
                } else {
                    objArr = objArr4;
                    if (x23Var.i(iLowestOneBit2)) {
                        x23 x23VarS = x23Var.s(x23Var.t(iLowestOneBit2));
                        if (h(iLowestOneBit2)) {
                            int iF2 = f(iLowestOneBit2);
                            Object obj2 = this.d[iF2];
                            int i16 = i + 5;
                            if (x23VarS.d(obj2 != null ? obj2.hashCode() : 0, i16, obj2)) {
                                ic0Var.a++;
                                x23VarJ = x23VarS;
                            } else {
                                x23VarJ = x23VarS.l(obj2 != null ? obj2.hashCode() : 0, obj2, x(iF2), i16, fw1Var);
                            }
                        } else {
                            x23VarJ = x23VarS;
                        }
                    } else {
                        int iF3 = f(iLowestOneBit2);
                        Object obj3 = this.d[iF3];
                        Object objX2 = x(iF3);
                        int iF4 = x23Var.f(iLowestOneBit2);
                        Object obj4 = x23Var.d[iF4];
                        x23VarJ = j(obj3 != null ? obj3.hashCode() : 0, obj3, objX2, obj4 != null ? obj4.hashCode() : 0, obj4, x23Var.x(iF4), i + 5, fw1Var.a);
                    }
                }
                objArr[length2] = x23VarJ;
                i14++;
                i13 ^= iLowestOneBit2;
                i2 = 0;
            }
            int i17 = 0;
            while (i12 != 0) {
                int iLowestOneBit3 = Integer.lowestOneBit(i12);
                int i18 = i17 * 2;
                if (x23Var.h(iLowestOneBit3)) {
                    int iF5 = x23Var.f(iLowestOneBit3);
                    Object[] objArr5 = x23Var2.d;
                    objArr5[i18] = x23Var.d[iF5];
                    objArr5[i18 + 1] = x23Var.x(iF5);
                    if (h(iLowestOneBit3)) {
                        ic0Var.a++;
                    }
                } else {
                    int iF6 = f(iLowestOneBit3);
                    Object[] objArr6 = x23Var2.d;
                    objArr6[i18] = this.d[iF6];
                    objArr6[i18 + 1] = x(iF6);
                }
                i17++;
                i12 ^= iLowestOneBit3;
            }
            if (!e(x23Var2)) {
                return x23Var.e(x23Var2) ? x23Var : x23Var2;
            }
        }
        return this;
    }

    public final x23 n(int i, Object obj, int i2, fw1 fw1Var) {
        x23 x23VarN;
        int iE = 1 << ld4.e(i, i2);
        if (h(iE)) {
            int iF = f(iE);
            if (g31.a(obj, this.d[iF])) {
                return p(iF, iE, fw1Var);
            }
        } else if (i(iE)) {
            int iT = t(iE);
            x23 x23VarS = s(iT);
            if (i2 == 30) {
                f21 f21VarE = ky3.e(ky3.f(0, x23VarS.d.length), 2);
                int i3 = f21VarE.a;
                int i4 = f21VarE.b;
                int i5 = f21VarE.c;
                if ((i5 > 0 && i3 <= i4) || (i5 < 0 && i4 <= i3)) {
                    while (true) {
                        if (!g31.a(obj, x23VarS.d[i3])) {
                            if (i3 == i4) {
                                x23VarN = x23VarS;
                                break;
                            }
                            i3 += i5;
                        } else {
                            x23VarN = x23VarS.k(i3, fw1Var);
                            break;
                        }
                    }
                } else {
                    x23VarN = x23VarS;
                    break;
                }
            } else {
                x23VarN = x23VarS.n(i, obj, i2 + 5, fw1Var);
            }
            return q(x23VarS, x23VarN, iT, iE, fw1Var.a);
        }
        return this;
    }

    public final x23 o(int i, Object obj, Object obj2, int i2, fw1 fw1Var) {
        fw1 fw1Var2;
        x23 x23VarO;
        int iE = 1 << ld4.e(i, i2);
        if (h(iE)) {
            int iF = f(iE);
            return (g31.a(obj, this.d[iF]) && g31.a(obj2, x(iF))) ? p(iF, iE, fw1Var) : this;
        }
        if (!i(iE)) {
            return this;
        }
        int iT = t(iE);
        x23 x23VarS = s(iT);
        if (i2 == 30) {
            f21 f21VarE = ky3.e(ky3.f(0, x23VarS.d.length), 2);
            int i3 = f21VarE.a;
            int i4 = f21VarE.b;
            int i5 = f21VarE.c;
            if ((i5 > 0 && i3 <= i4) || (i5 < 0 && i4 <= i3)) {
                while (true) {
                    if (!g31.a(obj, x23VarS.d[i3]) || !g31.a(obj2, x23VarS.x(i3))) {
                        if (i3 == i4) {
                            x23VarO = x23VarS;
                            break;
                        }
                        i3 += i5;
                    } else {
                        x23VarO = x23VarS.k(i3, fw1Var);
                        break;
                    }
                }
            } else {
                x23VarO = x23VarS;
                break;
            }
            fw1Var2 = fw1Var;
        } else {
            fw1Var2 = fw1Var;
            x23VarO = x23VarS.o(i, obj, obj2, i2 + 5, fw1Var2);
        }
        return q(x23VarS, x23VarO, iT, iE, fw1Var2.a);
    }

    public final x23 p(int i, int i2, fw1 fw1Var) {
        fw1Var.e(fw1Var.f - 1);
        fw1Var.c = x(i);
        Object[] objArr = this.d;
        if (objArr.length == 2) {
            return null;
        }
        if (this.c != fw1Var.a) {
            return new x23(i2 ^ this.a, this.b, ld4.c(i, objArr), fw1Var.a);
        }
        this.d = ld4.c(i, objArr);
        this.a ^= i2;
        return this;
    }

    public final x23 q(x23 x23Var, x23 x23Var2, int i, int i2, y74 y74Var) {
        y74 y74Var2 = this.c;
        if (x23Var2 != null) {
            return (y74Var2 == y74Var || x23Var != x23Var2) ? r(i, x23Var2, y74Var) : this;
        }
        Object[] objArr = this.d;
        if (objArr.length == 1) {
            return null;
        }
        if (y74Var2 != y74Var) {
            return new x23(this.a, this.b ^ i2, ld4.d(i, objArr), y74Var);
        }
        this.d = ld4.d(i, objArr);
        this.b ^= i2;
        return this;
    }

    public final x23 r(int i, x23 x23Var, y74 y74Var) {
        Object[] objArr = this.d;
        if (objArr.length == 1 && x23Var.d.length == 2 && x23Var.b == 0) {
            x23Var.a = this.b;
            return x23Var;
        }
        if (this.c == y74Var) {
            objArr[i] = x23Var;
            return this;
        }
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
        objArrCopyOf[i] = x23Var;
        return new x23(this.a, this.b, objArrCopyOf, y74Var);
    }

    public final x23 s(int i) {
        Object obj = this.d[i];
        obj.getClass();
        return (x23) obj;
    }

    public final int t(int i) {
        return (this.d.length - 1) - Integer.bitCount(this.b & (i - 1));
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x00c6, code lost:
    
        if (r13 == null) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00cf, code lost:
    
        if (r13 == null) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00d2, code lost:
    
        r13.b = w(r11, r4, (defpackage.x23) r13.b);
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00dc, code lost:
    
        return r13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final defpackage.c10 u(int r12, int r13, java.lang.Object r14, java.lang.Object r15) {
        /*
            Method dump skipped, instruction units count: 247
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.x23.u(int, int, java.lang.Object, java.lang.Object):c10");
    }

    public final x23 v(int i, int i2, Object obj) {
        x23 x23VarV;
        int iE = 1 << ld4.e(i, i2);
        if (h(iE)) {
            int iF = f(iE);
            if (!g31.a(obj, this.d[iF])) {
                return this;
            }
            Object[] objArr = this.d;
            if (objArr.length != 2) {
                return new x23(this.a ^ iE, this.b, ld4.c(iF, objArr), null);
            }
        } else {
            if (!i(iE)) {
                return this;
            }
            int iT = t(iE);
            x23 x23VarS = s(iT);
            if (i2 == 30) {
                f21 f21VarE = ky3.e(ky3.f(0, x23VarS.d.length), 2);
                int i3 = f21VarE.a;
                int i4 = f21VarE.b;
                int i5 = f21VarE.c;
                if ((i5 > 0 && i3 <= i4) || (i5 < 0 && i4 <= i3)) {
                    while (true) {
                        if (!g31.a(obj, x23VarS.d[i3])) {
                            if (i3 == i4) {
                                x23VarV = x23VarS;
                                break;
                            }
                            i3 += i5;
                        } else {
                            Object[] objArr2 = x23VarS.d;
                            if (objArr2.length != 2) {
                                x23VarV = new x23(0, 0, ld4.c(i3, objArr2), null);
                                break;
                            }
                            x23VarV = null;
                            break;
                        }
                    }
                } else {
                    x23VarV = x23VarS;
                    break;
                }
            } else {
                x23VarV = x23VarS.v(i, i2 + 5, obj);
            }
            if (x23VarV != null) {
                return x23VarS != x23VarV ? w(iT, iE, x23VarV) : this;
            }
            Object[] objArr3 = this.d;
            if (objArr3.length != 1) {
                return new x23(this.a, this.b ^ iE, ld4.d(iT, objArr3), null);
            }
        }
        return null;
    }

    public final x23 w(int i, int i2, x23 x23Var) {
        Object[] objArr = x23Var.d;
        if (objArr.length != 2 || x23Var.b != 0) {
            Object[] objArr2 = this.d;
            Object[] objArrCopyOf = Arrays.copyOf(objArr2, objArr2.length);
            objArrCopyOf[i] = x23Var;
            return new x23(this.a, this.b, objArrCopyOf, null);
        }
        if (this.d.length == 1) {
            x23Var.a = this.b;
            return x23Var;
        }
        int iF = f(i2);
        Object[] objArr3 = this.d;
        Object obj = objArr[0];
        Object obj2 = objArr[1];
        Object[] objArrCopyOf2 = Arrays.copyOf(objArr3, objArr3.length + 1);
        qg.g(objArrCopyOf2, i + 2, objArrCopyOf2, i + 1, objArr3.length);
        qg.g(objArrCopyOf2, iF + 2, objArrCopyOf2, iF, i);
        objArrCopyOf2[iF] = obj;
        objArrCopyOf2[iF + 1] = obj2;
        return new x23(this.a ^ i2, this.b ^ i2, objArrCopyOf2, null);
    }

    public final Object x(int i) {
        return this.d[i + 1];
    }
}
