package com.ibm.icu.impl.number;

import com.ibm.icu.impl.locale.LanguageTag;
import com.ibm.icu.text.DateFormat;
import defpackage.og;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class DecimalQuantity_DualStorageBCD extends DecimalQuantity_AbstractBCD {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private byte[] bcdBytes;
    private long bcdLong = 0;
    private boolean usingBytes = false;

    public DecimalQuantity_DualStorageBCD(Number number) {
        if (number instanceof Long) {
            setToLong(number.longValue());
            return;
        }
        if (number instanceof Integer) {
            setToInt(number.intValue());
            return;
        }
        if (number instanceof Float) {
            setToDouble(number.doubleValue());
            return;
        }
        if (number instanceof Double) {
            setToDouble(number.doubleValue());
            return;
        }
        if (number instanceof BigInteger) {
            setToBigInteger((BigInteger) number);
            return;
        }
        if (number instanceof BigDecimal) {
            setToBigDecimal((BigDecimal) number);
        } else if (number instanceof com.ibm.icu.math.BigDecimal) {
            setToBigDecimal(((com.ibm.icu.math.BigDecimal) number).toBigDecimal());
        } else {
            og.i("Number is of an unsupported type: ".concat(number.getClass().getName()));
            throw null;
        }
    }

    private void ensureCapacity(int i) {
        if (i == 0) {
            return;
        }
        boolean z = this.usingBytes;
        int length = z ? this.bcdBytes.length : 0;
        if (!z) {
            this.bcdBytes = new byte[i];
        } else if (length < i) {
            byte[] bArr = new byte[i * 2];
            System.arraycopy(this.bcdBytes, 0, bArr, 0, length);
            this.bcdBytes = bArr;
        }
        this.usingBytes = true;
    }

    public static DecimalQuantity fromExponentString(String str) {
        if (!str.contains("e") && !str.contains("c") && !str.contains(DateFormat.ABBR_WEEKDAY) && !str.contains("C")) {
            int visibleFractionCount = getVisibleFractionCount(str);
            DecimalQuantity_DualStorageBCD decimalQuantity_DualStorageBCD = new DecimalQuantity_DualStorageBCD(new BigDecimal(str));
            decimalQuantity_DualStorageBCD.setMinFraction(visibleFractionCount);
            return decimalQuantity_DualStorageBCD;
        }
        int iLastIndexOf = str.lastIndexOf(101);
        if (iLastIndexOf < 0) {
            iLastIndexOf = str.lastIndexOf(99);
        }
        if (iLastIndexOf < 0) {
            iLastIndexOf = str.lastIndexOf(69);
        }
        if (iLastIndexOf < 0) {
            iLastIndexOf = str.lastIndexOf(67);
        }
        int i = Integer.parseInt(str.substring(iLastIndexOf + 1));
        String strSubstring = str.substring(0, iLastIndexOf);
        DecimalQuantity_DualStorageBCD decimalQuantity_DualStorageBCD2 = new DecimalQuantity_DualStorageBCD(new BigDecimal(strSubstring));
        decimalQuantity_DualStorageBCD2.setMinFraction(getVisibleFractionCount(strSubstring));
        decimalQuantity_DualStorageBCD2.adjustExponent(i);
        return decimalQuantity_DualStorageBCD2;
    }

    private static int getVisibleFractionCount(String str) {
        int iIndexOf = str.indexOf(46) + 1;
        if (iIndexOf == 0) {
            return 0;
        }
        return str.length() - iIndexOf;
    }

    private void switchStorage() {
        if (!this.usingBytes) {
            ensureCapacity();
            for (int i = 0; i < this.precision; i++) {
                byte[] bArr = this.bcdBytes;
                long j = this.bcdLong;
                bArr[i] = (byte) (15 & j);
                this.bcdLong = j >>> 4;
            }
            return;
        }
        this.bcdLong = 0L;
        for (int i2 = this.precision - 1; i2 >= 0; i2--) {
            long j2 = this.bcdLong << 4;
            this.bcdLong = j2;
            this.bcdLong = j2 | ((long) this.bcdBytes[i2]);
        }
        this.bcdBytes = null;
        this.usingBytes = false;
    }

    private String toNumberString() {
        StringBuilder sb = new StringBuilder();
        if (this.usingBytes) {
            if (this.precision == 0) {
                sb.append('0');
            }
            for (int i = this.precision - 1; i >= 0; i--) {
                sb.append((int) this.bcdBytes[i]);
            }
        } else {
            sb.append(Long.toHexString(this.bcdLong));
        }
        sb.append(DateFormat.ABBR_WEEKDAY);
        sb.append(this.scale);
        return sb.toString();
    }

    @Override // com.ibm.icu.impl.number.DecimalQuantity_AbstractBCD
    public BigDecimal bcdToBigDecimal() {
        if (this.usingBytes) {
            BigDecimal bigDecimal = new BigDecimal(toNumberString());
            return isNegative() ? bigDecimal.negate() : bigDecimal;
        }
        long digitPos = 0;
        for (int i = this.precision - 1; i >= 0; i--) {
            digitPos = (digitPos * 10) + ((long) getDigitPos(i));
        }
        BigDecimal bigDecimalValueOf = BigDecimal.valueOf(digitPos);
        int iScale = bigDecimalValueOf.scale();
        int i2 = this.scale;
        int i3 = this.exponent;
        BigDecimal bigDecimalScaleByPowerOfTen = ((long) ((iScale + i2) + i3)) <= -2147483648L ? BigDecimal.ZERO : bigDecimalValueOf.scaleByPowerOfTen(i2 + i3);
        return isNegative() ? bigDecimalScaleByPowerOfTen.negate() : bigDecimalScaleByPowerOfTen;
    }

    @Deprecated
    public String checkHealth() {
        int i = 0;
        if (!this.usingBytes) {
            if (this.bcdBytes != null) {
                int i2 = 0;
                while (true) {
                    byte[] bArr = this.bcdBytes;
                    if (i2 >= bArr.length) {
                        break;
                    }
                    if (bArr[i2] != 0) {
                        return "Nonzero digits in byte array but we are in long mode";
                    }
                    i2++;
                }
            }
            int i3 = this.precision;
            if (i3 == 0 && this.bcdLong != 0) {
                return "Value in bcdLong even though precision is zero";
            }
            if (i3 > 16) {
                return "Precision exceeds length of long";
            }
            if (i3 != 0 && getDigitPos(i3 - 1) == 0) {
                return "Most significant digit is zero in long mode";
            }
            if (this.precision != 0 && getDigitPos(0) == 0) {
                return "Least significant digit is zero in long mode";
            }
            while (true) {
                int i4 = this.precision;
                if (i >= i4) {
                    while (i4 < 16) {
                        if (getDigitPos(i4) != 0) {
                            return "Nonzero digits outside of range in long";
                        }
                        i4++;
                    }
                    return null;
                }
                if (getDigitPos(i) >= 10) {
                    return "Digit exceeding 10 in long";
                }
                if (getDigitPos(i) < 0) {
                    return "Digit below 0 in long (?!)";
                }
                i++;
            }
        } else {
            if (this.bcdLong != 0) {
                return "Value in bcdLong but we are in byte mode";
            }
            int i5 = this.precision;
            if (i5 == 0) {
                return "Zero precision but we are in byte mode";
            }
            if (i5 > this.bcdBytes.length) {
                return "Precision exceeds length of byte array";
            }
            if (getDigitPos(i5 - 1) == 0) {
                return "Most significant digit is zero in byte mode";
            }
            if (getDigitPos(0) == 0) {
                return "Least significant digit is zero in long mode";
            }
            while (true) {
                int i6 = this.precision;
                if (i >= i6) {
                    while (i6 < this.bcdBytes.length) {
                        if (getDigitPos(i6) != 0) {
                            return "Nonzero digits outside of range in byte array";
                        }
                        i6++;
                    }
                    return null;
                }
                if (getDigitPos(i) >= 10) {
                    return "Digit exceeding 10 in byte array";
                }
                if (getDigitPos(i) < 0) {
                    return "Digit below 0 in byte array";
                }
                i++;
            }
        }
    }

    @Override // com.ibm.icu.impl.number.DecimalQuantity_AbstractBCD
    public void compact() {
        int i;
        if (!this.usingBytes) {
            long j = this.bcdLong;
            if (j == 0) {
                setBcdToZero();
                return;
            }
            int iNumberOfTrailingZeros = Long.numberOfTrailingZeros(j) / 4;
            long j2 = this.bcdLong >>> (iNumberOfTrailingZeros * 4);
            this.bcdLong = j2;
            this.scale += iNumberOfTrailingZeros;
            this.precision = 16 - (Long.numberOfLeadingZeros(j2) / 4);
            return;
        }
        int i2 = 0;
        while (true) {
            i = this.precision;
            if (i2 >= i || this.bcdBytes[i2] != 0) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 == i) {
            setBcdToZero();
            return;
        }
        shiftRight(i2);
        int i3 = this.precision - 1;
        while (i3 >= 0 && this.bcdBytes[i3] == 0) {
            i3--;
        }
        int i4 = i3 + 1;
        this.precision = i4;
        if (i4 <= 16) {
            switchStorage();
        }
    }

    @Override // com.ibm.icu.impl.number.DecimalQuantity_AbstractBCD
    public void copyBcdFrom(DecimalQuantity decimalQuantity) {
        DecimalQuantity_DualStorageBCD decimalQuantity_DualStorageBCD = (DecimalQuantity_DualStorageBCD) decimalQuantity;
        setBcdToZero();
        if (!decimalQuantity_DualStorageBCD.usingBytes) {
            this.bcdLong = decimalQuantity_DualStorageBCD.bcdLong;
        } else {
            ensureCapacity(decimalQuantity_DualStorageBCD.precision);
            System.arraycopy(decimalQuantity_DualStorageBCD.bcdBytes, 0, this.bcdBytes, 0, decimalQuantity_DualStorageBCD.precision);
        }
    }

    @Override // com.ibm.icu.impl.number.DecimalQuantity
    public DecimalQuantity createCopy() {
        return new DecimalQuantity_DualStorageBCD(this);
    }

    @Override // com.ibm.icu.impl.number.DecimalQuantity_AbstractBCD
    public byte getDigitPos(int i) {
        if (this.usingBytes) {
            if (i < 0 || i >= this.precision) {
                return (byte) 0;
            }
            return this.bcdBytes[i];
        }
        if (i < 0 || i >= 16) {
            return (byte) 0;
        }
        return (byte) ((this.bcdLong >>> (i * 4)) & 15);
    }

    @Deprecated
    public boolean isUsingBytes() {
        return this.usingBytes;
    }

    @Override // com.ibm.icu.impl.number.DecimalQuantity
    public int maxRepresentableDigits() {
        return Integer.MAX_VALUE;
    }

    @Override // com.ibm.icu.impl.number.DecimalQuantity_AbstractBCD
    public void popFromLeft(int i) {
        if (this.usingBytes) {
            int i2 = this.precision;
            while (true) {
                i2--;
                if (i2 < this.precision - i) {
                    break;
                } else {
                    this.bcdBytes[i2] = 0;
                }
            }
        } else {
            this.bcdLong &= (1 << ((this.precision - i) * 4)) - 1;
        }
        this.precision -= i;
    }

    @Override // com.ibm.icu.impl.number.DecimalQuantity_AbstractBCD
    public void readBigIntegerToBcd(BigInteger bigInteger) {
        ensureCapacity();
        int i = 0;
        while (bigInteger.signum() != 0) {
            BigInteger[] bigIntegerArrDivideAndRemainder = bigInteger.divideAndRemainder(BigInteger.TEN);
            int i2 = i + 1;
            ensureCapacity(i2);
            this.bcdBytes[i] = bigIntegerArrDivideAndRemainder[1].byteValue();
            bigInteger = bigIntegerArrDivideAndRemainder[0];
            i = i2;
        }
        this.scale = 0;
        this.precision = i;
    }

    @Override // com.ibm.icu.impl.number.DecimalQuantity_AbstractBCD
    public void readIntToBcd(int i) {
        long j = 0;
        int i2 = 16;
        while (i != 0) {
            j = (j >>> 4) + ((((long) i) % 10) << 60);
            i /= 10;
            i2--;
        }
        this.bcdLong = j >>> (i2 * 4);
        this.scale = 0;
        this.precision = 16 - i2;
    }

    @Override // com.ibm.icu.impl.number.DecimalQuantity_AbstractBCD
    public void readLongToBcd(long j) {
        if (j >= 10000000000000000L) {
            ensureCapacity();
            int i = 0;
            while (j != 0) {
                this.bcdBytes[i] = (byte) (j % 10);
                j /= 10;
                i++;
            }
            this.scale = 0;
            this.precision = i;
            return;
        }
        int i2 = 16;
        long j2 = 0;
        while (j != 0) {
            j2 = (j2 >>> 4) + ((j % 10) << 60);
            j /= 10;
            i2--;
        }
        this.bcdLong = j2 >>> (i2 * 4);
        this.scale = 0;
        this.precision = 16 - i2;
    }

    @Override // com.ibm.icu.impl.number.DecimalQuantity_AbstractBCD
    public void setBcdToZero() {
        if (this.usingBytes) {
            this.bcdBytes = null;
            this.usingBytes = false;
        }
        this.bcdLong = 0L;
        this.scale = 0;
        this.precision = 0;
        this.isApproximate = false;
        this.origDouble = 0.0d;
        this.origDelta = 0;
        this.exponent = 0;
    }

    @Override // com.ibm.icu.impl.number.DecimalQuantity_AbstractBCD
    public void setDigitPos(int i, byte b) {
        if (this.usingBytes) {
            ensureCapacity(i + 1);
            this.bcdBytes[i] = b;
        } else if (i >= 16) {
            switchStorage();
            ensureCapacity(i + 1);
            this.bcdBytes[i] = b;
        } else {
            int i2 = i * 4;
            this.bcdLong = (((long) b) << i2) | (this.bcdLong & (~(15 << i2)));
        }
    }

    @Override // com.ibm.icu.impl.number.DecimalQuantity_AbstractBCD
    public void shiftLeft(int i) {
        if (!this.usingBytes && this.precision + i >= 16) {
            switchStorage();
        }
        if (this.usingBytes) {
            ensureCapacity(this.precision + i);
            byte[] bArr = this.bcdBytes;
            System.arraycopy(bArr, 0, bArr, i, this.precision);
            Arrays.fill(this.bcdBytes, 0, i, (byte) 0);
        } else {
            this.bcdLong <<= i * 4;
        }
        this.scale -= i;
        this.precision += i;
    }

    @Override // com.ibm.icu.impl.number.DecimalQuantity_AbstractBCD
    public void shiftRight(int i) {
        if (this.usingBytes) {
            int i2 = 0;
            while (i2 < this.precision - i) {
                byte[] bArr = this.bcdBytes;
                bArr[i2] = bArr[i2 + i];
                i2++;
            }
            while (i2 < this.precision) {
                this.bcdBytes[i2] = 0;
                i2++;
            }
        } else {
            this.bcdLong >>>= i * 4;
        }
        this.scale += i;
        this.precision -= i;
    }

    public String toString() {
        return String.format("<DecimalQuantity %d:%d %s %s%s>", Integer.valueOf(this.lReqPos), Integer.valueOf(this.rReqPos), this.usingBytes ? "bytes" : "long", isNegative() ? LanguageTag.SEP : "", toNumberString());
    }

    private void ensureCapacity() {
        ensureCapacity(40);
    }

    public DecimalQuantity_DualStorageBCD(long j) {
        setToLong(j);
    }

    public DecimalQuantity_DualStorageBCD(int i) {
        setToInt(i);
    }

    public DecimalQuantity_DualStorageBCD(double d) {
        setToDouble(d);
    }

    public DecimalQuantity_DualStorageBCD(BigInteger bigInteger) {
        setToBigInteger(bigInteger);
    }

    public DecimalQuantity_DualStorageBCD(BigDecimal bigDecimal) {
        setToBigDecimal(bigDecimal);
    }

    public DecimalQuantity_DualStorageBCD(DecimalQuantity_DualStorageBCD decimalQuantity_DualStorageBCD) {
        copyFrom(decimalQuantity_DualStorageBCD);
    }

    public DecimalQuantity_DualStorageBCD() {
        setBcdToZero();
        this.flags = (byte) 0;
    }
}
