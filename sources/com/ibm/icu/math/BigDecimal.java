package com.ibm.icu.math;

import com.ibm.icu.lang.UCharacter;
import defpackage.cq;
import defpackage.ky0;
import defpackage.og;
import java.io.Serializable;
import java.math.BigInteger;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class BigDecimal extends Number implements Serializable, Comparable<BigDecimal> {
    private static final int MaxArg = 999999999;
    private static final int MaxExp = 999999999;
    private static final int MinArg = -999999999;
    private static final int MinExp = -999999999;
    public static final int ROUND_CEILING = 2;
    public static final int ROUND_DOWN = 1;
    public static final int ROUND_FLOOR = 3;
    public static final int ROUND_HALF_DOWN = 5;
    public static final int ROUND_HALF_EVEN = 6;
    public static final int ROUND_HALF_UP = 4;
    public static final int ROUND_UNNECESSARY = 7;
    public static final int ROUND_UP = 0;
    private static final byte isneg = -1;
    private static final byte ispos = 1;
    private static final byte iszero = 0;
    private static final long serialVersionUID = 8245355804974198832L;
    private int exp;
    private byte form;
    private byte ind;
    private byte[] mant;
    public static final BigDecimal ZERO = new BigDecimal(0L);
    public static final BigDecimal ONE = new BigDecimal(1L);
    public static final BigDecimal TEN = new BigDecimal(10);
    private static final MathContext plainMC = new MathContext(0, 0);
    private static byte[] bytecar = new byte[190];
    private static byte[] bytedig = diginit();

    /* JADX WARN: Code duplicated, block: B:100:0x012e  */
    /* JADX WARN: Code duplicated, block: B:101:0x0136  */
    /* JADX WARN: Code duplicated, block: B:103:0x013c  */
    /* JADX WARN: Code duplicated, block: B:106:0x014b  */
    /* JADX WARN: Code duplicated, block: B:108:0x014f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:109:0x0151  */
    /* JADX WARN: Code duplicated, block: B:113:0x0168  */
    /* JADX WARN: Code duplicated, block: B:115:0x0170  */
    /* JADX WARN: Code duplicated, block: B:117:0x0174  */
    /* JADX WARN: Code duplicated, block: B:119:0x017d  */
    /* JADX WARN: Code duplicated, block: B:121:0x0181  */
    /* JADX WARN: Code duplicated, block: B:123:0x018f  */
    /* JADX WARN: Code duplicated, block: B:124:0x0191  */
    /* JADX WARN: Code duplicated, block: B:128:0x0198  */
    /* JADX WARN: Code duplicated, block: B:131:0x019c  */
    /* JADX WARN: Code duplicated, block: B:133:0x00e1 A[EDGE_INSN: B:133:0x00e1->B:73:0x00e1 BREAK  A[LOOP:0: B:18:0x0038->B:36:0x0071], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:134:0x007a A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:141:0x00cd A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:155:0x0153 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:156:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:157:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:158:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:20:0x0046  */
    /* JADX WARN: Code duplicated, block: B:24:0x0050 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:25:0x0052 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:26:0x0054  */
    /* JADX WARN: Code duplicated, block: B:28:0x005b  */
    /* JADX WARN: Code duplicated, block: B:30:0x005f  */
    /* JADX WARN: Code duplicated, block: B:39:0x0080  */
    /* JADX WARN: Code duplicated, block: B:42:0x0089  */
    /* JADX WARN: Code duplicated, block: B:43:0x008e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:44:0x0090  */
    /* JADX WARN: Code duplicated, block: B:48:0x0099  */
    /* JADX WARN: Code duplicated, block: B:49:0x009c  */
    /* JADX WARN: Code duplicated, block: B:52:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:53:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:56:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:58:0x00af  */
    /* JADX WARN: Code duplicated, block: B:60:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:62:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:64:0x00be  */
    /* JADX WARN: Code duplicated, block: B:67:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:68:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:71:0x00da  */
    /* JADX WARN: Code duplicated, block: B:74:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:76:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:79:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:81:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:82:0x0100  */
    /* JADX WARN: Code duplicated, block: B:84:0x0104  */
    /* JADX WARN: Code duplicated, block: B:85:0x0109  */
    /* JADX WARN: Code duplicated, block: B:94:0x0122  */
    /* JADX WARN: Code duplicated, block: B:96:0x0126 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:97:0x0128  */
    public BigDecimal(char[] cArr, int i, int i2) {
        int i3;
        int i4;
        int i5;
        byte b;
        int i6;
        int i7;
        byte b2;
        byte b3;
        int i8;
        int i9;
        int i10;
        byte[] bArr;
        byte b4;
        int length;
        byte b5;
        int i11;
        char c;
        int iDigit;
        char c2;
        char c3;
        int i12;
        char c4;
        byte b6;
        int i13;
        byte b7;
        byte b8;
        char c5;
        int iDigit2;
        byte b9 = 0;
        this.form = (byte) 0;
        if (i2 <= 0) {
            bad(cArr);
        }
        byte b10 = 1;
        this.ind = (byte) 1;
        char c6 = cArr[i];
        int i14 = -1;
        if (c6 != '-') {
            if (c6 == '+') {
                i4 = i2 - 1;
                if (i4 == 0) {
                    bad(cArr);
                }
            } else {
                i3 = i;
                i4 = i2;
            }
            i5 = 0;
            b = 0;
            i6 = i4;
            int i15 = -1;
            i7 = i3;
            while (true) {
                b2 = b10;
                b3 = b9;
                if (i6 <= 0) {
                    break;
                }
                c3 = cArr[i7];
                if (c3 >= '0' && c3 <= '9') {
                    i5++;
                    i15 = i7;
                } else if (c3 == '.') {
                    if (i14 >= 0) {
                        bad(cArr);
                    }
                    i14 = i7 - i3;
                } else {
                    if (c3 != 'e' || c3 == 'E') {
                        if (i7 - i3 > i4 - 2) {
                            bad(cArr);
                        }
                        i12 = i7 + 1;
                        c4 = cArr[i12];
                        if (c4 == '-') {
                            i12 = i7 + 2;
                            b6 = b2;
                        } else {
                            i12 = c4 == '+' ? i7 + 2 : i12;
                            b6 = b3;
                        }
                        i13 = i4 - (i12 - i3);
                        if (i13 == 0) {
                            b7 = b2;
                        } else {
                            b7 = b3;
                        }
                        if (i13 > 9) {
                            b8 = b2;
                        } else {
                            b8 = b3;
                        }
                        if ((b7 | b8) != 0) {
                            bad(cArr);
                        }
                        while (i13 > 0) {
                            c5 = cArr[i12];
                            if (c5 < '0') {
                                bad(cArr);
                            }
                            if (c5 > '9') {
                                if (!UCharacter.isDigit(c5)) {
                                    bad(cArr);
                                }
                                iDigit2 = UCharacter.digit(c5, 10);
                                if (iDigit2 < 0) {
                                    bad(cArr);
                                }
                            } else {
                                iDigit2 = c5 - '0';
                            }
                            this.exp = (this.exp * 10) + iDigit2;
                            i13--;
                            i12++;
                        }
                        if (b6 != 0) {
                            this.exp = -this.exp;
                        }
                        b9 = b2;
                        break;
                    }
                    if (!UCharacter.isDigit(c3)) {
                        bad(cArr);
                    }
                    i5++;
                    i15 = i7;
                    b = b2;
                }
                i6--;
                i7++;
                b10 = b2;
                b9 = b3;
            }
            if (i5 == 0) {
                bad(cArr);
            }
            if (i14 >= 0) {
                this.exp = (this.exp + i14) - i5;
            }
            i8 = i15 - 1;
            i9 = i3;
            while (i3 <= i8) {
                c2 = cArr[i3];
                if (c2 != '0') {
                    if (c2 != '.') {
                        if (c2 > '9' || UCharacter.digit(c2, 10) != 0) {
                            break;
                        }
                        i9++;
                        i14--;
                        i5--;
                    } else {
                        i9++;
                        i14--;
                    }
                } else {
                    i9++;
                    i14--;
                    i5--;
                }
                i3++;
            }
            this.mant = new byte[i5];
            if (b != 0) {
                i11 = b3;
                while (i5 > 0) {
                    i9 = i11 == i14 ? i9 + 1 : i9;
                    c = cArr[i9];
                    if (c <= '9') {
                        this.mant[i11] = (byte) (c - '0');
                    } else {
                        iDigit = UCharacter.digit(c, 10);
                        if (iDigit < 0) {
                            bad(cArr);
                        }
                        this.mant[i11] = (byte) iDigit;
                    }
                    i9++;
                    i5--;
                    i11++;
                }
            } else {
                i10 = b3;
                while (i5 > 0) {
                    if (i10 == i14) {
                        i9++;
                    }
                    this.mant[i10] = (byte) (cArr[i9] - '0');
                    i9++;
                    i5--;
                    i10++;
                }
            }
            bArr = this.mant;
            if (bArr[b3] == 0) {
                this.ind = b3;
                if (this.exp > 0) {
                    this.exp = b3;
                }
                if (b9 != 0) {
                    this.mant = ZERO.mant;
                    this.exp = b3;
                    return;
                }
                return;
            }
            if (b9 != 0) {
                b4 = b2;
                this.form = b4;
                length = (this.exp + bArr.length) - b4;
                if (length < -999999999) {
                    b5 = b4;
                } else {
                    b5 = b3;
                }
                if (((length <= 999999999 ? b3 : b4) | b5) != 0) {
                    bad(cArr);
                    return;
                }
                return;
            }
            return;
        }
        i4 = i2 - 1;
        if (i4 == 0) {
            bad(cArr);
        }
        this.ind = (byte) -1;
        i3 = i + 1;
        i5 = 0;
        b = 0;
        i6 = i4;
        int i16 = -1;
        i7 = i3;
        while (true) {
            b2 = b10;
            b3 = b9;
            if (i6 <= 0) {
                break;
                break;
            }
            c3 = cArr[i7];
            if (c3 >= '0') {
                if (c3 == '.') {
                    if (c3 != 'e') {
                    }
                    if (i7 - i3 > i4 - 2) {
                        bad(cArr);
                    }
                    i12 = i7 + 1;
                    c4 = cArr[i12];
                    if (c4 == '-') {
                        i12 = i7 + 2;
                        b6 = b2;
                    } else {
                        if (c4 == '+') {
                        }
                        b6 = b3;
                    }
                    i13 = i4 - (i12 - i3);
                    if (i13 == 0) {
                        b7 = b2;
                    } else {
                        b7 = b3;
                    }
                    if (i13 > 9) {
                        b8 = b2;
                    } else {
                        b8 = b3;
                    }
                    if ((b7 | b8) != 0) {
                        bad(cArr);
                    }
                    while (i13 > 0) {
                        c5 = cArr[i12];
                        if (c5 < '0') {
                            bad(cArr);
                        }
                        if (c5 > '9') {
                            if (!UCharacter.isDigit(c5)) {
                                bad(cArr);
                            }
                            iDigit2 = UCharacter.digit(c5, 10);
                            if (iDigit2 < 0) {
                                bad(cArr);
                            }
                        } else {
                            iDigit2 = c5 - '0';
                        }
                        this.exp = (this.exp * 10) + iDigit2;
                        i13--;
                        i12++;
                    }
                    if (b6 != 0) {
                        this.exp = -this.exp;
                    }
                    b9 = b2;
                    break;
                }
                if (i14 >= 0) {
                    bad(cArr);
                }
                i14 = i7 - i3;
            } else {
                if (c3 == '.') {
                    if (c3 != 'e') {
                    }
                    if (i7 - i3 > i4 - 2) {
                        bad(cArr);
                    }
                    i12 = i7 + 1;
                    c4 = cArr[i12];
                    if (c4 == '-') {
                        i12 = i7 + 2;
                        b6 = b2;
                    } else {
                        if (c4 == '+') {
                        }
                        b6 = b3;
                    }
                    i13 = i4 - (i12 - i3);
                    if (i13 == 0) {
                        b7 = b2;
                    } else {
                        b7 = b3;
                    }
                    if (i13 > 9) {
                        b8 = b2;
                    } else {
                        b8 = b3;
                    }
                    if ((b7 | b8) != 0) {
                        bad(cArr);
                    }
                    while (i13 > 0) {
                        c5 = cArr[i12];
                        if (c5 < '0') {
                            bad(cArr);
                        }
                        if (c5 > '9') {
                            if (!UCharacter.isDigit(c5)) {
                                bad(cArr);
                            }
                            iDigit2 = UCharacter.digit(c5, 10);
                            if (iDigit2 < 0) {
                                bad(cArr);
                            }
                        } else {
                            iDigit2 = c5 - '0';
                        }
                        this.exp = (this.exp * 10) + iDigit2;
                        i13--;
                        i12++;
                    }
                    if (b6 != 0) {
                        this.exp = -this.exp;
                    }
                    b9 = b2;
                    break;
                }
                if (i14 >= 0) {
                    bad(cArr);
                }
                i14 = i7 - i3;
            }
            i6--;
            i7++;
            b10 = b2;
            b9 = b3;
            if (i5 == 0) {
                bad(cArr);
            }
            if (i14 >= 0) {
                this.exp = (this.exp + i14) - i5;
            }
            i8 = i16 - 1;
            i9 = i3;
            while (i3 <= i8) {
                c2 = cArr[i3];
                if (c2 != '0') {
                    i9++;
                    i14--;
                    i5--;
                } else if (c2 != '.') {
                    i9++;
                    i14--;
                } else {
                    if (c2 > '9') {
                        break;
                    }
                    i9++;
                    i14--;
                    i5--;
                }
                i3++;
            }
            this.mant = new byte[i5];
            if (b != 0) {
                i11 = b3;
                while (i5 > 0) {
                    if (i11 == i14) {
                    }
                    c = cArr[i9];
                    if (c <= '9') {
                        this.mant[i11] = (byte) (c - '0');
                    } else {
                        iDigit = UCharacter.digit(c, 10);
                        if (iDigit < 0) {
                            bad(cArr);
                        }
                        this.mant[i11] = (byte) iDigit;
                    }
                    i9++;
                    i5--;
                    i11++;
                }
            } else {
                i10 = b3;
                while (i5 > 0) {
                    if (i10 == i14) {
                        i9++;
                    }
                    this.mant[i10] = (byte) (cArr[i9] - '0');
                    i9++;
                    i5--;
                    i10++;
                }
            }
            bArr = this.mant;
            if (bArr[b3] == 0) {
                this.ind = b3;
                if (this.exp > 0) {
                    this.exp = b3;
                }
                if (b9 != 0) {
                    this.mant = ZERO.mant;
                    this.exp = b3;
                    return;
                }
                return;
            }
            if (b9 != 0) {
                b4 = b2;
                this.form = b4;
                length = (this.exp + bArr.length) - b4;
                if (length < -999999999) {
                    b5 = b4;
                } else {
                    b5 = b3;
                }
                if (((length <= 999999999 ? b3 : b4) | b5) != 0) {
                    bad(cArr);
                    return;
                }
                return;
            }
            return;
        }
    }

    private static final boolean allzero(byte[] bArr, int i) {
        if (i < 0) {
            i = 0;
        }
        int length = bArr.length - 1;
        while (i <= length) {
            if (bArr[i] != 0) {
                return false;
            }
            i++;
        }
        return true;
    }

    private void bad(char[] cArr) {
        throw new NumberFormatException(cq.j("Not a number: ", String.valueOf(cArr)));
    }

    private void badarg(String str, int i, String str2) {
        throw new IllegalArgumentException("Bad argument " + i + " to " + str + ": " + str2);
    }

    private static final byte[] byteaddsub(byte[] bArr, int i, byte[] bArr2, int i2, int i3, boolean z) {
        byte[] bArr3 = bArr;
        int length = bArr3.length;
        int length2 = bArr2.length;
        int i4 = i - 1;
        int i5 = i2 - 1;
        int i6 = i5 < i4 ? i4 : i5;
        byte[] bArr4 = (z && i6 + 1 == length) ? bArr3 : null;
        if (bArr4 == null) {
            bArr4 = new byte[i6 + 1];
        }
        int i7 = 0;
        boolean z2 = i3 == 1 || i3 == -1;
        int i8 = 0;
        for (int i9 = i6; i9 >= 0; i9--) {
            if (i4 >= 0) {
                if (i4 < length) {
                    i8 += bArr3[i4];
                }
                i4--;
            }
            if (i5 >= 0) {
                if (i5 < length2) {
                    i8 = z2 ? i3 > 0 ? i8 + bArr2[i5] : i8 - bArr2[i5] : (bArr2[i5] * i3) + i8;
                }
                i5--;
            }
            if (i8 >= 10 || i8 < 0) {
                int i10 = i8 + 90;
                bArr4[i9] = bytedig[i10];
                i8 = bytecar[i10];
            } else {
                bArr4[i9] = (byte) i8;
                i8 = 0;
            }
        }
        if (i8 == 0) {
            return bArr4;
        }
        if (!z || i6 + 2 != bArr3.length) {
            bArr3 = null;
        }
        if (bArr3 == null) {
            bArr3 = new byte[i6 + 2];
        }
        bArr3[0] = (byte) i8;
        if (i6 >= 10) {
            System.arraycopy(bArr4, 0, bArr3, 1, i6 + 1);
            return bArr3;
        }
        int i11 = i6 + 1;
        while (i11 > 0) {
            int i12 = i7 + 1;
            bArr3[i12] = bArr4[i7];
            i11--;
            i7 = i12;
        }
        return bArr3;
    }

    private void checkdigits(BigDecimal bigDecimal, int i) {
        if (i == 0) {
            return;
        }
        byte[] bArr = this.mant;
        if (bArr.length > i && !allzero(bArr, i)) {
            throw new ArithmeticException(cq.j("Too many digits: ", toString()));
        }
        if (bigDecimal == null) {
            return;
        }
        byte[] bArr2 = bigDecimal.mant;
        if (bArr2.length > i && !allzero(bArr2, i)) {
            throw new ArithmeticException(cq.j("Too many digits: ", bigDecimal.toString()));
        }
    }

    private static final BigDecimal clone(BigDecimal bigDecimal) {
        BigDecimal bigDecimal2 = new BigDecimal();
        bigDecimal2.ind = bigDecimal.ind;
        bigDecimal2.exp = bigDecimal.exp;
        bigDecimal2.form = bigDecimal.form;
        bigDecimal2.mant = bigDecimal.mant;
        return bigDecimal2;
    }

    private static final byte[] diginit() {
        byte[] bArr = new byte[190];
        for (int i = 0; i <= 189; i++) {
            int i2 = i - 90;
            if (i2 >= 0) {
                bArr[i] = (byte) (i2 % 10);
                bytecar[i] = (byte) (i2 / 10);
            } else {
                int i3 = i + 10;
                bArr[i] = (byte) (i3 % 10);
                bytecar[i] = (byte) ((i3 / 10) - 10);
            }
        }
        return bArr;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private BigDecimal dodivide(char c, BigDecimal bigDecimal, MathContext mathContext, int i) {
        int i2;
        byte[] bArrByteaddsub;
        boolean z;
        boolean z2;
        int i3;
        byte b;
        BigDecimal bigDecimalRound = this;
        BigDecimal bigDecimalRound2 = bigDecimal;
        int iScale = i;
        if (mathContext.lostDigits) {
            bigDecimalRound.checkdigits(bigDecimalRound2, mathContext.digits);
        }
        if (bigDecimalRound2.ind == 0) {
            throw new ArithmeticException("Divide by 0");
        }
        if (bigDecimalRound.ind == 0) {
            if (mathContext.form != 0) {
                return ZERO;
            }
            return iScale == -1 ? bigDecimalRound : bigDecimalRound.setScale(iScale);
        }
        int length = mathContext.digits;
        if (length > 0) {
            if (bigDecimalRound.mant.length > length) {
                bigDecimalRound = clone(bigDecimalRound).round(mathContext);
            }
            if (bigDecimalRound2.mant.length > length) {
                bigDecimalRound2 = clone(bigDecimalRound2).round(mathContext);
            }
        } else {
            if (iScale == -1) {
                iScale = bigDecimalRound.scale();
            }
            byte[] bArr = bigDecimalRound.mant;
            int length2 = bArr.length;
            int i4 = bigDecimalRound.exp;
            if (iScale != (-i4)) {
                length2 = length2 + iScale + i4;
            }
            byte[] bArr2 = bigDecimalRound2.mant;
            int length3 = (length2 - (bArr2.length - 1)) - bigDecimalRound2.exp;
            length = length3 < bArr.length ? bArr.length : length3;
            if (length < bArr2.length) {
                length = bArr2.length;
            }
        }
        int length4 = ((bigDecimalRound.exp - bigDecimalRound2.exp) + bigDecimalRound.mant.length) - bigDecimalRound2.mant.length;
        char c2 = 'D';
        if (length4 < 0 && c != 'D') {
            return c == 'I' ? ZERO : clone(bigDecimalRound).finish(mathContext, false);
        }
        BigDecimal bigDecimal2 = new BigDecimal();
        bigDecimal2.ind = (byte) (bigDecimalRound.ind * bigDecimalRound2.ind);
        bigDecimal2.exp = length4;
        int i5 = length + 1;
        bigDecimal2.mant = new byte[i5];
        int i6 = length + length + 1;
        byte[] bArrExtend = extend(bigDecimalRound.mant, i6);
        byte[] bArr3 = bigDecimalRound2.mant;
        int i7 = (bArr3[0] * 10) + 1;
        byte b2 = 0;
        if (bArr3.length > 1) {
            i7 += bArr3[1];
        }
        int i8 = i7;
        int i9 = 0;
        byte b3 = 1;
        int i10 = i6;
        int i11 = i10;
        loop0: while (true) {
            i2 = i11;
            bArrByteaddsub = bArrExtend;
            int i12 = b2;
            while (true) {
                if (i2 < i10) {
                    i10 = i10;
                    break;
                }
                if (i2 == i10) {
                    int i13 = b2;
                    int i14 = i2;
                    while (true) {
                        if (i14 <= 0) {
                            bigDecimal2.mant[i9] = (byte) (i12 + 1);
                            i9++;
                            bArrByteaddsub[b2] = b2;
                            break loop0;
                        }
                        i10 = i10;
                        byte b4 = i13 < bArr3.length ? bArr3[i13] : b2;
                        int i15 = i13;
                        byte b5 = bArrByteaddsub[i15];
                        if (b5 < b4) {
                            break;
                        }
                        c2 = 'D';
                        if (b5 > b4) {
                            i3 = bArrByteaddsub[b2];
                            b3 = b3;
                            break;
                        }
                        i14--;
                        i13 = i15 + 1;
                        i10 = i10;
                    }
                } else {
                    i10 = i10;
                    c2 = c2;
                    b3 = b3;
                    i3 = bArrByteaddsub[b2] * 10;
                    if (i2 > b3) {
                        i3 += bArrByteaddsub[b3];
                    }
                }
                int i16 = (i3 * 10) / i8;
                if (i16 == 0) {
                    i16 = b3;
                }
                i12 += i16;
                bArr3 = bArr3;
                byte[] bArr4 = bArrByteaddsub;
                int i17 = i2;
                bArrByteaddsub = byteaddsub(bArr4, i17, bArr3, i10, -i16, true);
                if (bArrByteaddsub[0] != 0) {
                    i2 = i17;
                    b2 = 0;
                } else {
                    int i18 = i17 - 2;
                    int i19 = 0;
                    while (i19 <= i18 && bArrByteaddsub[i19] == 0) {
                        i17--;
                        i19++;
                    }
                    if (i19 == 0) {
                        b = 0;
                    } else {
                        b = 0;
                        System.arraycopy(bArrByteaddsub, i19, bArrByteaddsub, 0, i17);
                    }
                    i2 = i17;
                    b2 = b;
                }
            }
            if (((i9 != 0 ? b3 : b2) | (i12 != 0 ? b3 : b2)) != 0) {
                bigDecimal2.mant[i9] = (byte) i12;
                int i20 = i9 + 1;
                if (i20 == i5 || bArrByteaddsub[b2] == 0) {
                    i9 = i20;
                    break;
                }
                i9 = i20;
                if ((iScale < 0 && (-bigDecimal2.exp) > iScale) || (c != 'D' && bigDecimal2.exp <= 0)) {
                    break;
                }
                bigDecimal2.exp--;
                c2 = 'D';
                i10--;
                bArrExtend = bArrByteaddsub;
                i11 = i2;
            } else if (iScale < 0) {
                bigDecimal2.exp--;
                c2 = 'D';
                i10--;
                bArrExtend = bArrByteaddsub;
                i11 = i2;
            } else {
                bigDecimal2.exp--;
                c2 = 'D';
                i10--;
                bArrExtend = bArrByteaddsub;
                i11 = i2;
            }
        }
        int i21 = i9 == 0 ? b3 : i9;
        if (((c == 'I' ? b3 : b2) | (c == 'R' ? b3 : b2)) != 0) {
            int i22 = bigDecimal2.exp;
            if (i21 + i22 > length) {
                throw new ArithmeticException("Integer overflow");
            }
            if (c == 'R') {
                if (bigDecimal2.mant[b2] == 0) {
                    return clone(bigDecimalRound).finish(mathContext, b2);
                }
                if (bArrByteaddsub[b2] == 0) {
                    return ZERO;
                }
                bigDecimal2.ind = bigDecimalRound.ind;
                bigDecimal2.exp = (i22 - (i6 - bigDecimalRound.mant.length)) + bigDecimalRound.exp;
                int i23 = i2 - 1;
                for (byte b6 = b3; i23 >= b6; b6 = 1) {
                    int i24 = bigDecimal2.exp;
                    if ((!(i24 < bigDecimalRound.exp) || !(i24 < bigDecimalRound2.exp)) || bArrByteaddsub[i23] != 0) {
                        break;
                    }
                    i2--;
                    bigDecimal2.exp = i24 + 1;
                    i23--;
                }
                if (i2 < bArrByteaddsub.length) {
                    byte[] bArr5 = new byte[i2];
                    z2 = false;
                    System.arraycopy(bArrByteaddsub, 0, bArr5, 0, i2);
                    bArrByteaddsub = bArr5;
                } else {
                    z2 = false;
                }
                bigDecimal2.mant = bArrByteaddsub;
                return bigDecimal2.finish(mathContext, z2);
            }
        } else if (bArrByteaddsub[b2] != 0) {
            byte[] bArr6 = bigDecimal2.mant;
            int i25 = i21 - 1;
            byte b7 = bArr6[i25];
            if (b7 % 5 == 0) {
                bArr6[i25] = (byte) (b7 + 1);
            }
        }
        byte[] bArr7 = bigDecimal2.mant;
        if (iScale < 0) {
            if (i21 == bArr7.length) {
                bigDecimal2.round(mathContext);
            } else {
                if (bArr7[0] == 0) {
                    return ZERO;
                }
                byte[] bArr8 = new byte[i21];
                System.arraycopy(bArr7, 0, bArr8, 0, i21);
                bigDecimal2.mant = bArr8;
            }
            return bigDecimal2.finish(mathContext, true);
        }
        if (i21 != bArr7.length) {
            bigDecimal2.exp -= bArr7.length - i21;
        }
        bigDecimal2.round(bArr7.length - ((-bigDecimal2.exp) - iScale), mathContext.roundingMode);
        if (bigDecimal2.exp != (-iScale)) {
            byte[] bArr9 = bigDecimal2.mant;
            z = true;
            bigDecimal2.mant = extend(bArr9, bArr9.length + 1);
            bigDecimal2.exp--;
        } else {
            z = true;
        }
        return bigDecimal2.finish(mathContext, z);
    }

    private static final byte[] extend(byte[] bArr, int i) {
        if (bArr.length == i) {
            return bArr;
        }
        byte[] bArr2 = new byte[i];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:55:0x0097, code lost:
    
        if (r9 <= 999999999) goto L59;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private com.ibm.icu.math.BigDecimal finish(com.ibm.icu.math.MathContext r8, boolean r9) {
        /*
            Method dump skipped, instruction units count: 205
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ibm.icu.math.BigDecimal.finish(com.ibm.icu.math.MathContext, boolean):com.ibm.icu.math.BigDecimal");
    }

    private int intcheck(int i, int i2) {
        int iIntValueExact = intValueExact();
        if (!(iIntValueExact < i) && !(iIntValueExact > i2)) {
            return iIntValueExact;
        }
        throw new ArithmeticException(ky0.h(iIntValueExact, "Conversion overflow: "));
    }

    private char[] layout() {
        byte[] bArr = this.mant;
        int length = bArr.length;
        char[] cArr = new char[length];
        int length2 = bArr.length;
        int i = 0;
        while (length2 > 0) {
            cArr[i] = (char) (this.mant[i] + 48);
            length2--;
            i++;
        }
        char c = '-';
        if (this.form != 0) {
            StringBuilder sb = new StringBuilder(length + 15);
            if (this.ind == -1) {
                sb.append('-');
            }
            int i2 = (this.exp + length) - 1;
            if (this.form == 1) {
                sb.append(cArr[0]);
                if (length > 1) {
                    sb.append('.');
                    sb.append(cArr, 1, length - 1);
                }
            } else {
                int i3 = i2 % 3;
                if (i3 < 0) {
                    i3 += 3;
                }
                i2 -= i3;
                int i4 = i3 + 1;
                if (i4 >= length) {
                    sb.append(cArr, 0, length);
                    for (int i5 = i4 - length; i5 > 0; i5--) {
                        sb.append('0');
                    }
                } else {
                    sb.append(cArr, 0, i4);
                    sb.append('.');
                    sb.append(cArr, i4, length - i4);
                }
            }
            if (i2 != 0) {
                if (i2 < 0) {
                    i2 = -i2;
                } else {
                    c = '+';
                }
                sb.append('E');
                sb.append(c);
                sb.append(i2);
            }
            char[] cArr2 = new char[sb.length()];
            int length3 = sb.length();
            if (length3 != 0) {
                sb.getChars(0, length3, cArr2, 0);
            }
            return cArr2;
        }
        int i6 = this.exp;
        byte b = this.ind;
        if (i6 == 0) {
            if (b >= 0) {
                return cArr;
            }
            char[] cArr3 = new char[length + 1];
            cArr3[0] = '-';
            System.arraycopy(cArr, 0, cArr3, 1, length);
            return cArr3;
        }
        int i7 = b == -1 ? 1 : 0;
        int i8 = i6 + length;
        if (i8 < 1) {
            int i9 = i7 + 2;
            char[] cArr4 = new char[i9 - i6];
            if (i7 != 0) {
                cArr4[0] = '-';
            }
            cArr4[i7] = '0';
            cArr4[i7 + 1] = '.';
            int i10 = -i8;
            int i11 = i9;
            while (i10 > 0) {
                cArr4[i11] = '0';
                i10--;
                i11++;
            }
            System.arraycopy(cArr, 0, cArr4, i9 - i8, length);
            return cArr4;
        }
        if (i8 <= length) {
            char[] cArr5 = new char[i7 + 1 + length];
            if (i7 != 0) {
                cArr5[0] = '-';
            }
            System.arraycopy(cArr, 0, cArr5, i7, i8);
            int i12 = i7 + i8;
            cArr5[i12] = '.';
            System.arraycopy(cArr, i8, cArr5, i12 + 1, length - i8);
            return cArr5;
        }
        char[] cArr6 = new char[i7 + i8];
        if (i7 != 0) {
            cArr6[0] = '-';
        }
        System.arraycopy(cArr, 0, cArr6, i7, length);
        int i13 = i8 - length;
        int i14 = i7 + length;
        while (i13 > 0) {
            cArr6[i14] = '0';
            i13--;
            i14++;
        }
        return cArr6;
    }

    private BigDecimal round(int i, int i2) {
        byte b;
        boolean z;
        byte[] bArr = this.mant;
        int length = bArr.length - i;
        if (length > 0) {
            this.exp += length;
            int i3 = this.ind;
            if (i > 0) {
                byte[] bArr2 = new byte[i];
                this.mant = bArr2;
                System.arraycopy(bArr, 0, bArr2, 0, i);
                b = bArr[i];
                z = true;
            } else {
                this.mant = ZERO.mant;
                this.ind = (byte) 0;
                if (i == 0) {
                    b = bArr[0];
                    z = false;
                } else {
                    b = 0;
                    z = false;
                }
            }
            if (i2 != 4) {
                if (i2 == 7) {
                    if (!allzero(bArr, i)) {
                        throw new ArithmeticException("Rounding necessary");
                    }
                } else if (i2 == 5) {
                    if (b <= 5 && (b != 5 || allzero(bArr, i + 1))) {
                    }
                } else if (i2 == 6) {
                    if (b <= 5) {
                        if (b == 5) {
                            if (allzero(bArr, i + 1)) {
                                byte[] bArr3 = this.mant;
                                if (bArr3[bArr3.length - 1] % 2 == 0) {
                                }
                            }
                        }
                    }
                } else if (i2 != 1) {
                    if (i2 == 0) {
                        if (allzero(bArr, i)) {
                        }
                    } else if (i2 == 2) {
                        if (i3 <= 0 || allzero(bArr, i)) {
                        }
                    } else {
                        if (i2 != 3) {
                            og.i(ky0.h(i2, "Bad round value: "));
                            return null;
                        }
                        if (i3 >= 0 || allzero(bArr, i)) {
                        }
                    }
                }
                i3 = 0;
            } else if (b < 5) {
                i3 = 0;
            }
            if (i3 != 0) {
                byte b2 = this.ind;
                if (b2 == 0) {
                    this.mant = ONE.mant;
                    this.ind = (byte) i3;
                } else {
                    if (b2 == -1) {
                        i3 = -i3;
                    }
                    byte[] bArr4 = this.mant;
                    byte[] bArrByteaddsub = byteaddsub(bArr4, bArr4.length, ONE.mant, 1, i3, z);
                    int length2 = bArrByteaddsub.length;
                    byte[] bArr5 = this.mant;
                    if (length2 > bArr5.length) {
                        this.exp++;
                        System.arraycopy(bArrByteaddsub, 0, bArr5, 0, bArr5.length);
                    } else {
                        this.mant = bArrByteaddsub;
                    }
                }
            }
            int i4 = this.exp;
            if (i4 > 999999999) {
                throw new ArithmeticException(ky0.h(i4, "Exponent Overflow: "));
            }
        }
        return this;
    }

    public static BigDecimal valueOf(long j, int i) {
        BigDecimal bigDecimal;
        if (j == 0) {
            bigDecimal = ZERO;
        } else if (j == 1) {
            bigDecimal = ONE;
        } else {
            bigDecimal = j == 10 ? TEN : new BigDecimal(j);
        }
        if (i == 0) {
            return bigDecimal;
        }
        if (i < 0) {
            throw new NumberFormatException(ky0.h(i, "Negative scale: "));
        }
        BigDecimal bigDecimalClone = clone(bigDecimal);
        bigDecimalClone.exp = -i;
        return bigDecimalClone;
    }

    public BigDecimal abs(MathContext mathContext) {
        return this.ind == -1 ? negate(mathContext) : plus(mathContext);
    }

    public BigDecimal add(BigDecimal bigDecimal, MathContext mathContext) {
        int i;
        byte[] bArr;
        int i2;
        byte[] bArr2;
        int i3;
        byte b;
        BigDecimal bigDecimalRound = this;
        BigDecimal bigDecimalRound2 = bigDecimal;
        if (mathContext.lostDigits) {
            bigDecimalRound.checkdigits(bigDecimalRound2, mathContext.digits);
        }
        if (bigDecimalRound.ind == 0 && mathContext.form != 0) {
            return bigDecimal.plus(mathContext);
        }
        if (bigDecimalRound2.ind == 0 && mathContext.form != 0) {
            return bigDecimalRound.plus(mathContext);
        }
        int i4 = mathContext.digits;
        if (i4 > 0) {
            if (bigDecimalRound.mant.length > i4) {
                bigDecimalRound = clone(bigDecimalRound).round(mathContext);
            }
            if (bigDecimalRound2.mant.length > i4) {
                bigDecimalRound2 = clone(bigDecimalRound2).round(mathContext);
            }
        }
        BigDecimal bigDecimal2 = new BigDecimal();
        byte[] bArr3 = bigDecimalRound.mant;
        int length = bArr3.length;
        byte[] bArr4 = bigDecimalRound2.mant;
        int length2 = bArr4.length;
        int i5 = bigDecimalRound.exp;
        int i6 = bigDecimalRound2.exp;
        if (i5 == i6) {
            bigDecimal2.exp = i5;
        } else if (i5 > i6) {
            int i7 = (length + i5) - i6;
            if (i7 >= length2 + i4 + 1 && i4 > 0) {
                bigDecimal2.mant = bArr3;
                bigDecimal2.exp = i5;
                bigDecimal2.ind = bigDecimalRound.ind;
                if (length < i4) {
                    bigDecimal2.mant = extend(bigDecimalRound.mant, i4);
                    bigDecimal2.exp -= i4 - length;
                }
                return bigDecimal2.finish(mathContext, false);
            }
            bigDecimal2.exp = i6;
            int i8 = i4 + 1;
            if (i7 > i8 && i4 > 0) {
                int i9 = (i7 - i4) - 1;
                length2 -= i9;
                bigDecimal2.exp = i6 + i9;
                i7 = i8;
            }
            if (i7 > length) {
                length = i7;
            }
        } else {
            int i10 = (length2 + i6) - i5;
            if (i10 >= length + i4 + 1 && i4 > 0) {
                bigDecimal2.mant = bArr4;
                bigDecimal2.exp = i6;
                bigDecimal2.ind = bigDecimalRound2.ind;
                if (length2 < i4) {
                    bigDecimal2.mant = extend(bigDecimalRound2.mant, i4);
                    bigDecimal2.exp -= i4 - length2;
                }
                return bigDecimal2.finish(mathContext, false);
            }
            bigDecimal2.exp = i5;
            int i11 = i4 + 1;
            if (i10 > i11 && i4 > 0) {
                int i12 = (i10 - i4) - 1;
                length -= i12;
                bigDecimal2.exp = i5 + i12;
                i10 = i11;
            }
            if (i10 > length2) {
                length2 = i10;
            }
        }
        byte b2 = bigDecimalRound.ind;
        if (b2 == 0) {
            bigDecimal2.ind = (byte) 1;
        } else {
            bigDecimal2.ind = b2;
        }
        byte b3 = bigDecimalRound.ind;
        boolean z = b3 == -1;
        byte b4 = bigDecimalRound2.ind;
        if (z == (b4 == -1)) {
            i2 = length;
            bArr2 = bArr4;
            i3 = length2;
            i = 1;
            bArr = bArr3;
        } else if (b4 != 0) {
            if ((b3 == 0) || (length < length2)) {
                bigDecimal2.ind = (byte) (-bigDecimal2.ind);
            } else {
                if (length <= length2) {
                    int length3 = bArr3.length - 1;
                    int length4 = bArr4.length - 1;
                    int i13 = 0;
                    int i14 = 0;
                    while (true) {
                        if (i13 <= length3) {
                            b = bArr3[i13];
                        } else if (i14 <= length4) {
                            b = 0;
                        } else if (mathContext.form != 0) {
                            return ZERO;
                        }
                        byte b5 = i14 <= length4 ? bArr4[i14] : (byte) 0;
                        if (b == b5) {
                            i13++;
                            i14++;
                        } else if (b < b5) {
                            bigDecimal2.ind = (byte) (-bigDecimal2.ind);
                        }
                    }
                }
                i = -1;
                bArr = bArr3;
                i2 = length;
                bArr2 = bArr4;
                i3 = length2;
            }
            i = -1;
            bArr2 = bArr3;
            i3 = length;
            bArr = bArr4;
            i2 = length2;
        } else {
            i = -1;
            bArr = bArr3;
            i2 = length;
            bArr2 = bArr4;
            i3 = length2;
        }
        bigDecimal2.mant = byteaddsub(bArr, i2, bArr2, i3, i, false);
        return bigDecimal2.finish(mathContext, false);
    }

    public byte byteValueExact() {
        int iIntValueExact = intValueExact();
        if (!(iIntValueExact > 127) && !(iIntValueExact < -128)) {
            return (byte) iIntValueExact;
        }
        throw new ArithmeticException(cq.j("Conversion overflow: ", toString()));
    }

    public int compareTo(BigDecimal bigDecimal, MathContext mathContext) {
        if (mathContext.lostDigits) {
            checkdigits(bigDecimal, mathContext.digits);
        }
        byte b = this.ind;
        byte b2 = bigDecimal.ind;
        if ((b == b2) && (this.exp == bigDecimal.exp)) {
            int length = this.mant.length;
            byte[] bArr = bigDecimal.mant;
            if (length < bArr.length) {
                return (byte) (-b);
            }
            if (length > bArr.length) {
                return b;
            }
            int i = mathContext.digits;
            if ((length <= i) | (i == 0)) {
                int i2 = 0;
                while (length > 0) {
                    byte b3 = this.mant[i2];
                    byte b4 = bigDecimal.mant[i2];
                    if (b3 < b4) {
                        return (byte) (-this.ind);
                    }
                    if (b3 > b4) {
                        return this.ind;
                    }
                    length--;
                    i2++;
                }
                return 0;
            }
        } else {
            if (b < b2) {
                return -1;
            }
            if (b > b2) {
                return 1;
            }
        }
        BigDecimal bigDecimalClone = clone(bigDecimal);
        bigDecimalClone.ind = (byte) (-bigDecimalClone.ind);
        return add(bigDecimalClone, mathContext).ind;
    }

    public BigDecimal divide(BigDecimal bigDecimal, int i, int i2) {
        if (i >= 0) {
            return dodivide('D', bigDecimal, new MathContext(0, 0, false, i2), i);
        }
        throw new ArithmeticException(ky0.h(i, "Negative scale: "));
    }

    public BigDecimal divideInteger(BigDecimal bigDecimal) {
        return dodivide('I', bigDecimal, plainMC, 0);
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return Double.valueOf(toString()).doubleValue();
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof BigDecimal)) {
            return false;
        }
        BigDecimal bigDecimal = (BigDecimal) obj;
        if (this.ind != bigDecimal.ind) {
            return false;
        }
        byte[] bArr = this.mant;
        if (((bArr.length == bigDecimal.mant.length) & (this.exp == bigDecimal.exp)) && (this.form == bigDecimal.form)) {
            int length = bArr.length;
            int i = 0;
            while (length > 0) {
                if (this.mant[i] != bigDecimal.mant[i]) {
                    return false;
                }
                length--;
                i++;
            }
        } else {
            char[] cArrLayout = layout();
            char[] cArrLayout2 = bigDecimal.layout();
            if (cArrLayout.length != cArrLayout2.length) {
                return false;
            }
            int length2 = cArrLayout.length;
            int i2 = 0;
            while (length2 > 0) {
                if (cArrLayout[i2] != cArrLayout2[i2]) {
                    return false;
                }
                length2--;
                i2++;
            }
        }
        return true;
    }

    @Override // java.lang.Number
    public float floatValue() {
        return Float.valueOf(toString()).floatValue();
    }

    public String format(int i, int i2, int i3, int i4, int i5, int i6) {
        char[] cArr;
        int length;
        if ((i < -1) | (i == 0)) {
            badarg("format", 1, String.valueOf(i));
        }
        if (i2 < -1) {
            badarg("format", 2, String.valueOf(i2));
        }
        if ((i3 < -1) | (i3 == 0)) {
            badarg("format", 3, String.valueOf(i3));
        }
        if (i4 < -1) {
            badarg("format", 4, String.valueOf(i3));
        }
        if (i5 != 1 && i5 != 2) {
            if (i5 == -1) {
                i5 = 1;
            } else {
                badarg("format", 5, String.valueOf(i5));
            }
        }
        if (i6 != 4) {
            if (i6 == -1) {
                i6 = 4;
            } else {
                try {
                    new MathContext(9, 1, false, i6);
                } catch (IllegalArgumentException unused) {
                    badarg("format", 6, String.valueOf(i6));
                }
            }
        }
        BigDecimal bigDecimalClone = clone(this);
        if (i4 == -1 || bigDecimalClone.ind == 0) {
            bigDecimalClone.form = (byte) 0;
        } else {
            int length2 = bigDecimalClone.exp + bigDecimalClone.mant.length;
            if (length2 <= i4 && length2 >= -5) {
                bigDecimalClone.form = (byte) 0;
            } else {
                bigDecimalClone.form = (byte) i5;
            }
        }
        if (i2 >= 0) {
            while (true) {
                byte b = bigDecimalClone.form;
                if (b == 0) {
                    length = -bigDecimalClone.exp;
                } else if (b == 1) {
                    length = bigDecimalClone.mant.length - 1;
                } else {
                    int i7 = bigDecimalClone.exp;
                    byte[] bArr = bigDecimalClone.mant;
                    int length3 = ((i7 + bArr.length) - 1) % 3;
                    if (length3 < 0) {
                        length3 += 3;
                    }
                    int i8 = length3 + 1;
                    length = i8 >= bArr.length ? 0 : bArr.length - i8;
                }
                if (length == i2) {
                    break;
                }
                byte[] bArr2 = bigDecimalClone.mant;
                if (length < i2) {
                    bigDecimalClone.mant = extend(bArr2, (bArr2.length + i2) - length);
                    int i9 = bigDecimalClone.exp - (i2 - length);
                    bigDecimalClone.exp = i9;
                    if (i9 >= -999999999) {
                        break;
                    }
                    throw new ArithmeticException(ky0.h(i9, "Exponent Overflow: "));
                }
                int i10 = length - i2;
                if (i10 > bArr2.length) {
                    bigDecimalClone.mant = ZERO.mant;
                    bigDecimalClone.ind = (byte) 0;
                    bigDecimalClone.exp = 0;
                } else {
                    int length4 = bArr2.length - i10;
                    int i11 = bigDecimalClone.exp;
                    bigDecimalClone.round(length4, i6);
                    if (bigDecimalClone.exp - i11 == i10) {
                        break;
                    }
                }
            }
        }
        char[] cArrLayout = bigDecimalClone.layout();
        if (i > 0) {
            int length5 = cArrLayout.length;
            int i12 = 0;
            while (length5 > 0) {
                char c = cArrLayout[i12];
                if (c == '.' || c == 'E') {
                    break;
                }
                length5--;
                i12++;
            }
            if (i12 > i) {
                badarg("format", 1, String.valueOf(i));
            }
            if (i12 < i) {
                char[] cArr2 = new char[(cArrLayout.length + i) - i12];
                int i13 = i - i12;
                int i14 = 0;
                while (i13 > 0) {
                    cArr2[i14] = ' ';
                    i13--;
                    i14++;
                }
                System.arraycopy(cArrLayout, 0, cArr2, i14, cArrLayout.length);
                cArrLayout = cArr2;
            }
        }
        if (i3 > 0) {
            int length6 = cArrLayout.length - 1;
            int length7 = cArrLayout.length - 1;
            while (length6 > 0 && cArrLayout[length7] != 'E') {
                length6--;
                length7--;
            }
            if (length7 == 0) {
                cArr = new char[cArrLayout.length + i3 + 2];
                System.arraycopy(cArrLayout, 0, cArr, 0, cArrLayout.length);
                int i15 = i3 + 2;
                int length8 = cArrLayout.length;
                while (i15 > 0) {
                    cArr[length8] = ' ';
                    i15--;
                    length8++;
                }
            } else {
                int length9 = (cArrLayout.length - length7) - 2;
                if (length9 > i3) {
                    badarg("format", 3, String.valueOf(i3));
                }
                if (length9 < i3) {
                    cArr = new char[(cArrLayout.length + i3) - length9];
                    int i16 = length7 + 2;
                    System.arraycopy(cArrLayout, 0, cArr, 0, i16);
                    int i17 = i3 - length9;
                    int i18 = i16;
                    while (i17 > 0) {
                        cArr[i18] = '0';
                        i17--;
                        i18++;
                    }
                    System.arraycopy(cArrLayout, i16, cArr, i18, length9);
                }
            }
            cArrLayout = cArr;
        }
        return new String(cArrLayout);
    }

    public int hashCode() {
        return toString().hashCode();
    }

    @Override // java.lang.Number
    public int intValue() {
        return toBigInteger().intValue();
    }

    /* JADX WARN: Code duplicated, block: B:34:0x006e  */
    /* JADX WARN: Code duplicated, block: B:37:0x0073  */
    public int intValueExact() {
        if (this.ind == 0) {
            return 0;
        }
        byte[] bArr = this.mant;
        int length = bArr.length - 1;
        int i = this.exp;
        if (i < 0) {
            length += i;
            if (!allzero(bArr, length + 1)) {
                throw new ArithmeticException(cq.j("Decimal part non-zero: ", toString()));
            }
            if (length < 0) {
                return 0;
            }
            i = 0;
        } else if (i + length > 9) {
            throw new ArithmeticException(cq.j("Conversion overflow: ", toString()));
        }
        int i2 = i + length;
        int i3 = 0;
        for (int i4 = 0; i4 <= i2; i4++) {
            i3 *= 10;
            if (i4 <= length) {
                i3 += this.mant[i4];
            }
        }
        if (i2 == 9) {
            int i5 = i3 / 1000000000;
            byte b = this.mant[0];
            if (i5 != b) {
                if (i3 != Integer.MIN_VALUE || this.ind != -1 || b != 2) {
                    throw new ArithmeticException(cq.j("Conversion overflow: ", toString()));
                }
            } else if (this.ind != 1) {
                return -i3;
            }
        } else if (this.ind != 1) {
            return -i3;
        }
        return i3;
    }

    @Override // java.lang.Number
    public long longValue() {
        return toBigInteger().longValue();
    }

    /* JADX WARN: Code duplicated, block: B:38:0x007d  */
    /* JADX WARN: Code duplicated, block: B:41:0x0082  */
    public long longValueExact() {
        long j = 0;
        if (this.ind == 0) {
            return 0L;
        }
        byte[] bArr = this.mant;
        int length = bArr.length - 1;
        int i = this.exp;
        if (i < 0) {
            length += i;
            if (!allzero(bArr, length < 0 ? 0 : length + 1)) {
                throw new ArithmeticException(cq.j("Decimal part non-zero: ", toString()));
            }
            if (length < 0) {
                return 0L;
            }
            i = 0;
        } else if (bArr.length + i > 18) {
            throw new ArithmeticException(cq.j("Conversion overflow: ", toString()));
        }
        int i2 = i + length;
        for (int i3 = 0; i3 <= i2; i3++) {
            j *= 10;
            if (i3 <= length) {
                j += (long) this.mant[i3];
            }
        }
        if (i2 == 18) {
            long j2 = j / 1000000000000000000L;
            byte b = this.mant[0];
            if (j2 != b) {
                if (j != Long.MIN_VALUE || this.ind != -1 || b != 9) {
                    throw new ArithmeticException(cq.j("Conversion overflow: ", toString()));
                }
            } else if (this.ind != 1) {
                return -j;
            }
        } else if (this.ind != 1) {
            return -j;
        }
        return j;
    }

    public BigDecimal max(BigDecimal bigDecimal, MathContext mathContext) {
        return compareTo(bigDecimal, mathContext) >= 0 ? plus(mathContext) : bigDecimal.plus(mathContext);
    }

    public BigDecimal min(BigDecimal bigDecimal, MathContext mathContext) {
        return compareTo(bigDecimal, mathContext) <= 0 ? plus(mathContext) : bigDecimal.plus(mathContext);
    }

    public BigDecimal movePointLeft(int i) {
        BigDecimal bigDecimalClone = clone(this);
        bigDecimalClone.exp -= i;
        return bigDecimalClone.finish(plainMC, false);
    }

    public BigDecimal movePointRight(int i) {
        BigDecimal bigDecimalClone = clone(this);
        bigDecimalClone.exp += i;
        return bigDecimalClone.finish(plainMC, false);
    }

    public BigDecimal multiply(BigDecimal bigDecimal, MathContext mathContext) {
        int i;
        byte[] bArr;
        if (mathContext.lostDigits) {
            checkdigits(bigDecimal, mathContext.digits);
        }
        int i2 = mathContext.digits;
        if (i2 > 0) {
            if (this.mant.length > i2) {
                this = clone(this).round(mathContext);
            }
            if (bigDecimal.mant.length > i2) {
                bigDecimal = clone(bigDecimal).round(mathContext);
            }
            i = 0;
        } else {
            i = this.exp;
            if (i <= 0) {
                i = 0;
            }
            int i3 = bigDecimal.exp;
            if (i3 > 0) {
                i += i3;
            }
        }
        byte[] bArr2 = this.mant;
        int length = bArr2.length;
        byte[] bArr3 = bigDecimal.mant;
        if (length < bArr3.length) {
            bArr = bArr3;
        } else {
            bArr = bArr2;
            bArr2 = bArr3;
        }
        int length2 = bArr2.length + bArr.length;
        int i4 = length2 - 1;
        if (bArr2[0] * bArr[0] <= 9) {
            length2 = i4;
        }
        BigDecimal bigDecimal2 = new BigDecimal();
        byte[] bArrByteaddsub = new byte[length2];
        int i5 = 0;
        int length3 = bArr2.length;
        int i6 = i4;
        while (length3 > 0) {
            byte b = bArr2[i5];
            if (b != 0) {
                bArrByteaddsub = byteaddsub(bArrByteaddsub, bArrByteaddsub.length, bArr, i6, b, true);
            }
            i6--;
            length3--;
            i5++;
        }
        bigDecimal2.ind = (byte) (this.ind * bigDecimal.ind);
        bigDecimal2.exp = (this.exp + bigDecimal.exp) - i;
        if (i == 0) {
            bigDecimal2.mant = bArrByteaddsub;
        } else {
            bigDecimal2.mant = extend(bArrByteaddsub, bArrByteaddsub.length + i);
        }
        return bigDecimal2.finish(mathContext, false);
    }

    public BigDecimal negate(MathContext mathContext) {
        if (mathContext.lostDigits) {
            checkdigits(null, mathContext.digits);
        }
        BigDecimal bigDecimalClone = clone(this);
        bigDecimalClone.ind = (byte) (-bigDecimalClone.ind);
        return bigDecimalClone.finish(mathContext, false);
    }

    public BigDecimal plus(MathContext mathContext) {
        if (mathContext.lostDigits) {
            checkdigits(null, mathContext.digits);
        }
        if (mathContext.form == 0 && this.form == 0) {
            int length = this.mant.length;
            int i = mathContext.digits;
            if (length <= i || i == 0) {
                return this;
            }
        }
        return clone(this).finish(mathContext, false);
    }

    public BigDecimal pow(BigDecimal bigDecimal, MathContext mathContext) {
        int length;
        if (mathContext.lostDigits) {
            checkdigits(bigDecimal, mathContext.digits);
        }
        int iIntcheck = bigDecimal.intcheck(-999999999, 999999999);
        int i = mathContext.digits;
        boolean z = false;
        if (i == 0) {
            if (bigDecimal.ind == -1) {
                throw new ArithmeticException(cq.j("Negative power: ", bigDecimal.toString()));
            }
            length = 0;
        } else {
            if (bigDecimal.mant.length + bigDecimal.exp > i) {
                throw new ArithmeticException(cq.j("Too many digits: ", bigDecimal.toString()));
            }
            if (this.mant.length > i) {
                this = clone(this).round(mathContext);
            }
            length = bigDecimal.mant.length + bigDecimal.exp + i + 1;
        }
        MathContext mathContext2 = new MathContext(length, mathContext.form, false, mathContext.roundingMode);
        BigDecimal bigDecimalDivide = ONE;
        if (iIntcheck == 0) {
            return bigDecimalDivide;
        }
        if (iIntcheck < 0) {
            iIntcheck = -iIntcheck;
        }
        int i2 = 1;
        while (true) {
            iIntcheck += iIntcheck;
            if (iIntcheck < 0) {
                bigDecimalDivide = bigDecimalDivide.multiply(this, mathContext2);
                z = true;
            }
            if (i2 == 31) {
                break;
            }
            if (z) {
                bigDecimalDivide = bigDecimalDivide.multiply(bigDecimalDivide, mathContext2);
            }
            i2++;
        }
        if (bigDecimal.ind < 0) {
            bigDecimalDivide = ONE.divide(bigDecimalDivide, mathContext2);
        }
        return bigDecimalDivide.finish(mathContext, true);
    }

    public BigDecimal remainder(BigDecimal bigDecimal) {
        return dodivide('R', bigDecimal, plainMC, -1);
    }

    public int scale() {
        int i = this.exp;
        if (i >= 0) {
            return 0;
        }
        return -i;
    }

    public BigDecimal setScale(int i, int i2) {
        int iScale = scale();
        if (iScale == i && this.form == 0) {
            return this;
        }
        BigDecimal bigDecimalClone = clone(this);
        if (iScale <= i) {
            int i3 = iScale == 0 ? bigDecimalClone.exp + i : i - iScale;
            byte[] bArr = bigDecimalClone.mant;
            bigDecimalClone.mant = extend(bArr, bArr.length + i3);
            bigDecimalClone.exp = -i;
        } else {
            if (i < 0) {
                throw new ArithmeticException(ky0.h(i, "Negative scale: "));
            }
            bigDecimalClone = bigDecimalClone.round(bigDecimalClone.mant.length - (iScale - i), i2);
            if (bigDecimalClone.exp != (-i)) {
                byte[] bArr2 = bigDecimalClone.mant;
                bigDecimalClone.mant = extend(bArr2, bArr2.length + 1);
                bigDecimalClone.exp--;
            }
        }
        bigDecimalClone.form = (byte) 0;
        return bigDecimalClone;
    }

    public short shortValueExact() {
        int iIntValueExact = intValueExact();
        if (!(iIntValueExact > 32767) && !(iIntValueExact < -32768)) {
            return (short) iIntValueExact;
        }
        throw new ArithmeticException(cq.j("Conversion overflow: ", toString()));
    }

    public int signum() {
        return this.ind;
    }

    public BigDecimal subtract(BigDecimal bigDecimal, MathContext mathContext) {
        if (mathContext.lostDigits) {
            checkdigits(bigDecimal, mathContext.digits);
        }
        BigDecimal bigDecimalClone = clone(bigDecimal);
        bigDecimalClone.ind = (byte) (-bigDecimalClone.ind);
        return add(bigDecimalClone, mathContext);
    }

    public java.math.BigDecimal toBigDecimal() {
        return new java.math.BigDecimal(unscaledValue(), scale());
    }

    public BigInteger toBigInteger() {
        int i = this.exp;
        if (!((this.form == 0) & (i >= 0))) {
            if (i >= 0) {
                this = clone(this);
                this.form = (byte) 0;
            } else if ((-i) >= this.mant.length) {
                this = ZERO;
            } else {
                this = clone(this);
                byte[] bArr = this.mant;
                int length = bArr.length + this.exp;
                byte[] bArr2 = new byte[length];
                System.arraycopy(bArr, 0, bArr2, 0, length);
                this.mant = bArr2;
                this.form = (byte) 0;
                this.exp = 0;
            }
        }
        return new BigInteger(new String(this.layout()));
    }

    public BigInteger toBigIntegerExact() {
        int i = this.exp;
        if (i < 0) {
            byte[] bArr = this.mant;
            if (!allzero(bArr, bArr.length + i)) {
                throw new ArithmeticException(cq.j("Decimal part non-zero: ", toString()));
            }
        }
        return toBigInteger();
    }

    public char[] toCharArray() {
        return layout();
    }

    public String toString() {
        return new String(layout());
    }

    public BigInteger unscaledValue() {
        if (this.exp < 0) {
            this = clone(this);
            this.exp = 0;
        }
        return this.toBigInteger();
    }

    public BigDecimal divideInteger(BigDecimal bigDecimal, MathContext mathContext) {
        return dodivide('I', bigDecimal, mathContext, 0);
    }

    public BigDecimal remainder(BigDecimal bigDecimal, MathContext mathContext) {
        return dodivide('R', bigDecimal, mathContext, -1);
    }

    public BigDecimal abs() {
        return abs(plainMC);
    }

    public BigDecimal max(BigDecimal bigDecimal) {
        return max(bigDecimal, plainMC);
    }

    public BigDecimal min(BigDecimal bigDecimal) {
        return min(bigDecimal, plainMC);
    }

    public BigDecimal subtract(BigDecimal bigDecimal) {
        return subtract(bigDecimal, plainMC);
    }

    public BigDecimal negate() {
        return negate(plainMC);
    }

    public BigDecimal divide(BigDecimal bigDecimal, int i) {
        return dodivide('D', bigDecimal, new MathContext(0, 0, false, i), -1);
    }

    public BigDecimal divide(BigDecimal bigDecimal) {
        return dodivide('D', bigDecimal, plainMC, -1);
    }

    public BigDecimal divide(BigDecimal bigDecimal, MathContext mathContext) {
        return dodivide('D', bigDecimal, mathContext, -1);
    }

    public BigDecimal plus() {
        return plus(plainMC);
    }

    public static BigDecimal valueOf(long j) {
        return valueOf(j, 0);
    }

    public static BigDecimal valueOf(double d) {
        return new BigDecimal(Double.toString(d));
    }

    public BigDecimal setScale(int i) {
        return setScale(i, 7);
    }

    @Override // java.lang.Comparable
    public int compareTo(BigDecimal bigDecimal) {
        return compareTo(bigDecimal, plainMC);
    }

    public BigDecimal multiply(BigDecimal bigDecimal) {
        return multiply(bigDecimal, plainMC);
    }

    public BigDecimal pow(BigDecimal bigDecimal) {
        return pow(bigDecimal, plainMC);
    }

    private BigDecimal round(MathContext mathContext) {
        return round(mathContext.digits, mathContext.roundingMode);
    }

    public BigDecimal add(BigDecimal bigDecimal) {
        return add(bigDecimal, plainMC);
    }

    public String format(int i, int i2) {
        return format(i, i2, -1, -1, 1, 4);
    }

    public BigDecimal(BigInteger bigInteger) {
        this(bigInteger.toString(10));
    }

    public BigDecimal(BigInteger bigInteger, int i) {
        this(bigInteger.toString(10));
        if (i >= 0) {
            this.exp = -i;
            return;
        }
        throw new NumberFormatException(ky0.h(i, "Negative scale: "));
    }

    public BigDecimal(char[] cArr) {
        this(cArr, 0, cArr.length);
    }

    public BigDecimal(java.math.BigDecimal bigDecimal) {
        this(bigDecimal.toString());
    }

    public BigDecimal(double d) {
        this(new java.math.BigDecimal(d).toString());
    }

    public BigDecimal(int i) {
        this.form = (byte) 0;
        if (i <= 9 && i >= -9) {
            if (i == 0) {
                this.mant = ZERO.mant;
                this.ind = (byte) 0;
                return;
            }
            if (i == 1) {
                this.mant = ONE.mant;
                this.ind = (byte) 1;
                return;
            }
            if (i == -1) {
                this.mant = ONE.mant;
                this.ind = (byte) -1;
                return;
            }
            byte[] bArr = new byte[1];
            this.mant = bArr;
            if (i > 0) {
                bArr[0] = (byte) i;
                this.ind = (byte) 1;
                return;
            } else {
                bArr[0] = (byte) (-i);
                this.ind = (byte) -1;
                return;
            }
        }
        if (i > 0) {
            this.ind = (byte) 1;
            i = -i;
        } else {
            this.ind = (byte) -1;
        }
        int i2 = i;
        int i3 = 9;
        while (true) {
            i2 /= 10;
            if (i2 == 0) {
                break;
            } else {
                i3--;
            }
        }
        this.mant = new byte[10 - i3];
        int i4 = 9 - i3;
        while (true) {
            this.mant[i4] = (byte) (-((byte) (i % 10)));
            i /= 10;
            if (i == 0) {
                return;
            } else {
                i4--;
            }
        }
    }

    public BigDecimal(long j) {
        this.form = (byte) 0;
        if (j > 0) {
            this.ind = (byte) 1;
            j = -j;
        } else if (j == 0) {
            this.ind = (byte) 0;
        } else {
            this.ind = (byte) -1;
        }
        long j2 = j;
        int i = 18;
        while (true) {
            j2 /= 10;
            if (j2 == 0) {
                break;
            } else {
                i--;
            }
        }
        this.mant = new byte[19 - i];
        int i2 = 18 - i;
        while (true) {
            this.mant[i2] = (byte) (-((byte) (j % 10)));
            j /= 10;
            if (j == 0) {
                return;
            } else {
                i2--;
            }
        }
    }

    public BigDecimal(String str) {
        this(str.toCharArray(), 0, str.length());
    }

    private BigDecimal() {
        this.form = (byte) 0;
    }
}
