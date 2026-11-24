package com.ibm.icu.impl.number;

import com.ibm.icu.impl.StandardPlural;
import com.ibm.icu.impl.Utility;
import com.ibm.icu.text.PluralRules;
import com.ibm.icu.text.UFieldPosition;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.text.FieldPosition;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class DecimalQuantity_AbstractBCD implements DecimalQuantity {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    protected static final int INFINITY_FLAG = 2;
    protected static final int NAN_FLAG = 4;
    protected static final int NEGATIVE_FLAG = 1;
    private static final int SECTION_LOWER_EDGE = -1;
    private static final int SECTION_UPPER_EDGE = -2;
    protected byte flags;
    protected boolean isApproximate;
    protected int origDelta;
    protected double origDouble;
    protected int precision;
    protected int scale;
    private static final double[] DOUBLE_MULTIPLIERS = {1.0d, 10.0d, 100.0d, 1000.0d, 10000.0d, 100000.0d, 1000000.0d, 1.0E7d, 1.0E8d, 1.0E9d, 1.0E10d, 1.0E11d, 1.0E12d, 1.0E13d, 1.0E14d, 1.0E15d, 1.0E16d, 1.0E17d, 1.0E18d, 1.0E19d, 1.0E20d, 1.0E21d};
    static final byte[] INT64_BCD = {9, 2, 2, 3, 3, 7, 2, 0, 3, 6, 8, 5, 4, 7, 7, 5, 8, 0, 8};
    protected int lReqPos = 0;
    protected int rReqPos = 0;
    protected int exponent = 0;

    @Deprecated
    public boolean explicitExactDouble = false;

    /* JADX INFO: renamed from: com.ibm.icu.impl.number.DecimalQuantity_AbstractBCD$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ibm$icu$text$PluralRules$Operand;

        static {
            int[] iArr = new int[PluralRules.Operand.values().length];
            $SwitchMap$com$ibm$icu$text$PluralRules$Operand = iArr;
            try {
                iArr[PluralRules.Operand.i.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ibm$icu$text$PluralRules$Operand[PluralRules.Operand.f.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$ibm$icu$text$PluralRules$Operand[PluralRules.Operand.t.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$ibm$icu$text$PluralRules$Operand[PluralRules.Operand.v.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$ibm$icu$text$PluralRules$Operand[PluralRules.Operand.w.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$ibm$icu$text$PluralRules$Operand[PluralRules.Operand.e.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$ibm$icu$text$PluralRules$Operand[PluralRules.Operand.c.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    private void _setToBigDecimal(BigDecimal bigDecimal) {
        int iScale = bigDecimal.scale();
        _setToBigInteger(bigDecimal.scaleByPowerOfTen(iScale).toBigInteger());
        this.scale -= iScale;
    }

    private void _setToBigInteger(BigInteger bigInteger) {
        if (bigInteger.bitLength() < 32) {
            readIntToBcd(bigInteger.intValue());
        } else if (bigInteger.bitLength() < 64) {
            readLongToBcd(bigInteger.longValue());
        } else {
            readBigIntegerToBcd(bigInteger);
        }
    }

    private void _setToDoubleFast(double d) {
        double d2;
        this.isApproximate = true;
        this.origDouble = d;
        this.origDelta = 0;
        int iDoubleToLongBits = ((int) ((Double.doubleToLongBits(d) & 9218868437227405312L) >> 52)) - 1023;
        if (iDoubleToLongBits <= 52) {
            long j = (long) d;
            if (j == d) {
                _setToLong(j);
                return;
            }
        }
        if (iDoubleToLongBits == -1023 || iDoubleToLongBits == 1024) {
            convertToAccurateDouble();
            return;
        }
        int i = (int) (((double) (52 - iDoubleToLongBits)) / 3.321928094887362d);
        if (i >= 0) {
            int i2 = i;
            while (i2 >= 22) {
                d *= 1.0E22d;
                i2 -= 22;
            }
            d2 = d * DOUBLE_MULTIPLIERS[i2];
        } else {
            int i3 = i;
            while (i3 <= -22) {
                d /= 1.0E22d;
                i3 += 22;
            }
            d2 = d / DOUBLE_MULTIPLIERS[-i3];
        }
        long jRound = Math.round(d2);
        if (jRound != 0) {
            _setToLong(jRound);
            this.scale -= i;
        }
    }

    private void _setToInt(int i) {
        if (i == Integer.MIN_VALUE) {
            readLongToBcd(-i);
        } else {
            readIntToBcd(i);
        }
    }

    private void _setToLong(long j) {
        if (j == Long.MIN_VALUE) {
            readBigIntegerToBcd(BigInteger.valueOf(j).negate());
        } else if (j <= 2147483647L) {
            readIntToBcd((int) j);
        } else {
            readLongToBcd(j);
        }
    }

    private void convertToAccurateDouble() {
        double d = this.origDouble;
        int i = this.origDelta;
        setBcdToZero();
        String string = Double.toString(d);
        if (string.indexOf(69) != -1) {
            int iIndexOf = string.indexOf(69);
            _setToLong(Long.parseLong(string.charAt(0) + string.substring(2, iIndexOf)));
            this.scale = (Integer.parseInt(string.substring(iIndexOf + 1)) - (iIndexOf - 1)) + 1 + this.scale;
        } else if (string.charAt(0) == '0') {
            _setToLong(Long.parseLong(string.substring(2)));
            this.scale = (2 - string.length()) + this.scale;
        } else if (string.charAt(string.length() - 1) == '0') {
            _setToLong(Long.parseLong(string.substring(0, string.length() - 2)));
        } else {
            int iIndexOf2 = string.indexOf(46);
            _setToLong(Long.parseLong(string.substring(0, iIndexOf2).concat(string.substring(iIndexOf2 + 1))));
            this.scale = (iIndexOf2 - string.length()) + 1 + this.scale;
        }
        this.scale += i;
        compact();
        this.explicitExactDouble = true;
    }

    private int fractionCount() {
        return Math.max(0, (-getLowerDisplayMagnitude()) - this.exponent);
    }

    private int fractionCountWithoutTrailingZeros() {
        return Math.max((-this.scale) - this.exponent, 0);
    }

    /* JADX WARN: Code duplicated, block: B:24:0x004b  */
    /* JADX WARN: Code duplicated, block: B:26:0x0050 A[EDGE_INSN: B:26:0x0050->B:109:0x0123 BREAK  A[LOOP:1: B:34:0x0060->B:38:0x0069]] */
    private void roundToMagnitude(int i, MathContext mathContext, boolean z) {
        int i2;
        int iSafeSubtract = safeSubtract(i, this.scale);
        int precision = mathContext.getPrecision();
        if (precision > 0) {
            int i3 = this.precision;
            if (i3 - precision > iSafeSubtract) {
                iSafeSubtract = i3 - precision;
            }
        }
        byte digitPos = getDigitPos(iSafeSubtract);
        if ((iSafeSubtract > 0 || this.isApproximate || !(!z || digitPos == 0 || digitPos == 5)) && this.precision != 0) {
            byte digitPos2 = getDigitPos(safeSubtract(iSafeSubtract, 1));
            if (this.isApproximate) {
                int iSafeSubtract2 = safeSubtract(iSafeSubtract, 2);
                int iMax = Math.max(0, this.precision - 14);
                if (digitPos2 == 0 && (!z || digitPos == 0 || digitPos == 5)) {
                    while (true) {
                        if (iSafeSubtract2 < iMax) {
                            i2 = -1;
                            break;
                        } else {
                            if (getDigitPos(iSafeSubtract2) != 0) {
                                i2 = 1;
                                break;
                            }
                            iSafeSubtract2--;
                        }
                    }
                } else if (digitPos2 != 4 || (z && digitPos != 2 && digitPos != 7)) {
                    if (digitPos2 != 5 || (z && digitPos != 2 && digitPos != 7)) {
                        if (digitPos2 != 9 || (z && digitPos != 4 && digitPos != 9)) {
                            if (!z || digitPos == 2 || digitPos == 7 ? digitPos2 < 5 : !(digitPos >= 2 && (digitPos < 5 || digitPos >= 7))) {
                                i2 = 1;
                                break;
                            }
                        } else {
                            while (true) {
                                if (iSafeSubtract2 < iMax) {
                                    i2 = -2;
                                    break;
                                } else if (getDigitPos(iSafeSubtract2) == 9) {
                                    iSafeSubtract2--;
                                }
                            }
                        }
                    } else {
                        while (true) {
                            if (iSafeSubtract2 < iMax) {
                                i2 = 2;
                            } else if (getDigitPos(iSafeSubtract2) == 0) {
                                iSafeSubtract2--;
                            }
                        }
                    }
                    i2 = 3;
                    break;
                } else {
                    while (true) {
                        if (iSafeSubtract2 < iMax) {
                            i2 = 2;
                        } else {
                            if (getDigitPos(iSafeSubtract2) != 9) {
                                i2 = 1;
                                break;
                            }
                            iSafeSubtract2--;
                        }
                    }
                }
                boolean zRoundsAtMidpoint = RoundingUtils.roundsAtMidpoint(mathContext.getRoundingMode().ordinal());
                if (safeSubtract(iSafeSubtract, 1) < this.precision - 14 || ((zRoundsAtMidpoint && i2 == 2) || (!zRoundsAtMidpoint && i2 < 0))) {
                    convertToAccurateDouble();
                    roundToMagnitude(i, mathContext, z);
                    return;
                }
                this.isApproximate = false;
                this.origDouble = 0.0d;
                this.origDelta = 0;
                if (iSafeSubtract <= 0 && (!z || digitPos == 0 || digitPos == 5)) {
                    return;
                }
                if (i2 == -1) {
                    i2 = 1;
                }
                if (i2 == -2) {
                    i2 = 3;
                    break;
                }
            } else if (!z || digitPos == 2 || digitPos == 7) {
                if (digitPos2 >= 5) {
                    if (digitPos2 <= 5) {
                        int iSafeSubtract3 = safeSubtract(iSafeSubtract, 2);
                        while (true) {
                            if (iSafeSubtract3 < 0) {
                                i2 = 2;
                                break;
                            } else {
                                if (getDigitPos(iSafeSubtract3) != 0) {
                                    i2 = 3;
                                    break;
                                }
                                iSafeSubtract3--;
                            }
                        }
                    } else {
                        i2 = 3;
                        break;
                    }
                } else {
                    i2 = 1;
                }
            } else {
                if (digitPos >= 2 && (digitPos < 5 || digitPos >= 7)) {
                    i2 = 3;
                    break;
                }
                i2 = 1;
            }
            boolean roundingDirection = RoundingUtils.getRoundingDirection(!z ? digitPos % 2 != 0 : digitPos >= 2 && digitPos <= 7 && ((digitPos != 2 || i2 == 3) && !(digitPos == 7 && i2 == 3)), isNegative(), i2, mathContext.getRoundingMode().ordinal(), this);
            if (iSafeSubtract >= this.precision) {
                setBcdToZero();
                this.scale = i;
            } else {
                shiftRight(iSafeSubtract);
            }
            if (z) {
                if (digitPos < 5 && roundingDirection) {
                    setDigitPos(0, (byte) 0);
                    compact();
                    return;
                } else {
                    if (digitPos < 5 || roundingDirection) {
                        setDigitPos(0, (byte) 5);
                        if (this.precision == 0) {
                            this.precision = 1;
                            return;
                        }
                        return;
                    }
                    setDigitPos(0, (byte) 9);
                    digitPos = 9;
                }
            }
            if (!roundingDirection) {
                if (digitPos == 9) {
                    int i4 = 0;
                    while (getDigitPos(i4) == 9) {
                        i4++;
                    }
                    shiftRight(i4);
                }
                setDigitPos(0, (byte) (getDigitPos(0) + 1));
                this.precision++;
            }
            compact();
        }
    }

    private static int safeSubtract(int i, int i2) {
        int i3 = i - i2;
        if (i2 < 0 && i3 < i) {
            return Integer.MAX_VALUE;
        }
        if (i2 <= 0 || i3 <= i) {
            return i3;
        }
        return Integer.MIN_VALUE;
    }

    private void toExponentString(StringBuilder sb) {
        if (isNegative()) {
            sb.append('-');
        }
        int i = this.scale;
        int i2 = (this.precision + i) - 1;
        int i3 = this.lReqPos;
        if (i2 < i3 - 1) {
            i2 = i3 - 1;
        }
        int i4 = this.rReqPos;
        if (i > i4) {
            i = i4;
        }
        if (i2 < 0) {
            sb.append('0');
        }
        while (i2 >= 0) {
            sb.append((char) (getDigitPos(i2 - this.scale) + 48));
            i2--;
        }
        if (i < 0) {
            sb.append('.');
        }
        while (i2 >= i) {
            sb.append((char) (getDigitPos(i2 - this.scale) + 48));
            i2--;
        }
        if (this.exponent != 0) {
            sb.append('c');
            sb.append(this.exponent);
        }
    }

    @Override // com.ibm.icu.impl.number.DecimalQuantity
    public void adjustExponent(int i) {
        this.exponent += i;
    }

    @Override // com.ibm.icu.impl.number.DecimalQuantity
    public void adjustMagnitude(int i) {
        if (this.precision != 0) {
            this.scale = Utility.addExact(this.scale, i);
            this.origDelta = Utility.addExact(this.origDelta, i);
            Utility.addExact(this.scale, this.precision);
        }
    }

    @Deprecated
    public void appendDigit(byte b, int i, boolean z) {
        if (b == 0) {
            if (!z || this.precision == 0) {
                return;
            }
            this.scale = i + 1 + this.scale;
            return;
        }
        int i2 = this.scale;
        if (i2 > 0) {
            i += i2;
            if (z) {
                this.scale = 0;
            }
        }
        int i3 = i + 1;
        shiftLeft(i3);
        setDigitPos(0, b);
        if (z) {
            this.scale += i3;
        }
    }

    @Override // com.ibm.icu.impl.number.DecimalQuantity
    public void applyMaxInteger(int i) {
        if (this.precision == 0) {
            return;
        }
        if (i <= this.scale) {
            setBcdToZero();
            return;
        }
        int magnitude = getMagnitude();
        if (i <= magnitude) {
            popFromLeft((magnitude - i) + 1);
            compact();
        }
    }

    public abstract BigDecimal bcdToBigDecimal();

    public DecimalQuantity_AbstractBCD clear() {
        this.lReqPos = 0;
        this.rReqPos = 0;
        this.flags = (byte) 0;
        setBcdToZero();
        return this;
    }

    public abstract void compact();

    public abstract void copyBcdFrom(DecimalQuantity decimalQuantity);

    @Override // com.ibm.icu.impl.number.DecimalQuantity
    public void copyFrom(DecimalQuantity decimalQuantity) {
        copyBcdFrom(decimalQuantity);
        DecimalQuantity_AbstractBCD decimalQuantity_AbstractBCD = (DecimalQuantity_AbstractBCD) decimalQuantity;
        this.lReqPos = decimalQuantity_AbstractBCD.lReqPos;
        this.rReqPos = decimalQuantity_AbstractBCD.rReqPos;
        this.scale = decimalQuantity_AbstractBCD.scale;
        this.precision = decimalQuantity_AbstractBCD.precision;
        this.flags = decimalQuantity_AbstractBCD.flags;
        this.origDouble = decimalQuantity_AbstractBCD.origDouble;
        this.origDelta = decimalQuantity_AbstractBCD.origDelta;
        this.isApproximate = decimalQuantity_AbstractBCD.isApproximate;
        this.exponent = decimalQuantity_AbstractBCD.exponent;
    }

    public boolean equals(Object obj) {
        int i;
        boolean z;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DecimalQuantity_AbstractBCD)) {
            return false;
        }
        DecimalQuantity_AbstractBCD decimalQuantity_AbstractBCD = (DecimalQuantity_AbstractBCD) obj;
        if (this.scale != decimalQuantity_AbstractBCD.scale || (i = this.precision) != decimalQuantity_AbstractBCD.precision || this.flags != decimalQuantity_AbstractBCD.flags || this.lReqPos != decimalQuantity_AbstractBCD.lReqPos || this.rReqPos != decimalQuantity_AbstractBCD.rReqPos || (z = this.isApproximate) != decimalQuantity_AbstractBCD.isApproximate) {
            return false;
        }
        if (i == 0) {
            return true;
        }
        if (z) {
            return this.origDouble == decimalQuantity_AbstractBCD.origDouble && this.origDelta == decimalQuantity_AbstractBCD.origDelta;
        }
        for (int upperDisplayMagnitude = getUpperDisplayMagnitude(); upperDisplayMagnitude >= getLowerDisplayMagnitude(); upperDisplayMagnitude--) {
            if (getDigit(upperDisplayMagnitude) != decimalQuantity_AbstractBCD.getDigit(upperDisplayMagnitude)) {
                return false;
            }
        }
        return true;
    }

    public boolean fitsInLong() {
        if (isInfinite() || isNaN()) {
            return false;
        }
        if (isZeroish()) {
            return true;
        }
        if (this.exponent + this.scale < 0) {
            return false;
        }
        int magnitude = getMagnitude();
        if (magnitude < 18) {
            return true;
        }
        if (magnitude > 18) {
            return false;
        }
        for (int i = 0; i < this.precision; i++) {
            byte digit = getDigit(18 - i);
            byte b = INT64_BCD[i];
            if (digit < b) {
                return true;
            }
            if (digit > b) {
                return false;
            }
        }
        return isNegative();
    }

    @Override // com.ibm.icu.impl.number.DecimalQuantity
    public byte getDigit(int i) {
        return getDigitPos(i - this.scale);
    }

    public abstract byte getDigitPos(int i);

    @Override // com.ibm.icu.impl.number.DecimalQuantity
    public int getExponent() {
        return this.exponent;
    }

    @Override // com.ibm.icu.impl.number.DecimalQuantity
    public int getLowerDisplayMagnitude() {
        int i = this.scale;
        int i2 = this.rReqPos;
        return i2 < i ? i2 : i;
    }

    @Override // com.ibm.icu.impl.number.DecimalQuantity
    public int getMagnitude() {
        int i = this.precision;
        if (i != 0) {
            return (this.scale + i) - 1;
        }
        throw new ArithmeticException("Magnitude is not well-defined for zero");
    }

    @Override // com.ibm.icu.text.PluralRules.IFixedDecimal
    public double getPluralOperand(PluralRules.Operand operand) {
        switch (AnonymousClass1.$SwitchMap$com$ibm$icu$text$PluralRules$Operand[operand.ordinal()]) {
            case 1:
                return isNegative() ? -toLong(true) : toLong(true);
            case 2:
                return toFractionLong(true);
            case 3:
                return toFractionLong(false);
            case 4:
                return fractionCount();
            case 5:
                return fractionCountWithoutTrailingZeros();
            case 6:
                return getExponent();
            case 7:
                return getExponent();
            default:
                return Math.abs(toDouble());
        }
    }

    @Override // com.ibm.icu.impl.number.DecimalQuantity
    public long getPositionFingerprint() {
        return ((long) (this.lReqPos << 16)) ^ (((long) this.rReqPos) << 32);
    }

    @Override // com.ibm.icu.impl.number.DecimalQuantity
    public StandardPlural getStandardPlural(PluralRules pluralRules) {
        return pluralRules == null ? StandardPlural.OTHER : StandardPlural.orOtherFromString(pluralRules.select(this));
    }

    @Override // com.ibm.icu.impl.number.DecimalQuantity
    public int getUpperDisplayMagnitude() {
        int i = this.scale + this.precision;
        int i2 = this.lReqPos;
        if (i2 > i) {
            i = i2;
        }
        return i - 1;
    }

    public int hashCode() {
        int iHash = Objects.hash(Integer.valueOf(this.scale), Integer.valueOf(this.precision), Byte.valueOf(this.flags), Integer.valueOf(this.lReqPos), Integer.valueOf(this.rReqPos), Boolean.valueOf(this.isApproximate));
        if (this.precision != 0) {
            if (this.isApproximate) {
                return Objects.hash(Integer.valueOf(iHash), Double.valueOf(this.origDouble), Integer.valueOf(this.origDelta));
            }
            int upperDisplayMagnitude = getUpperDisplayMagnitude();
            if (upperDisplayMagnitude >= getLowerDisplayMagnitude()) {
                return Objects.hash(Integer.valueOf(iHash), Byte.valueOf(getDigit(upperDisplayMagnitude)));
            }
        }
        return iHash;
    }

    @Override // com.ibm.icu.text.PluralRules.IFixedDecimal
    public boolean isHasIntegerValue() {
        return this.scale >= 0;
    }

    @Override // com.ibm.icu.impl.number.DecimalQuantity, com.ibm.icu.text.PluralRules.IFixedDecimal
    public boolean isInfinite() {
        return (this.flags & 2) != 0;
    }

    @Override // com.ibm.icu.impl.number.DecimalQuantity, com.ibm.icu.text.PluralRules.IFixedDecimal
    public boolean isNaN() {
        return (this.flags & 4) != 0;
    }

    @Override // com.ibm.icu.impl.number.DecimalQuantity
    public boolean isNegative() {
        return (this.flags & 1) != 0;
    }

    @Override // com.ibm.icu.impl.number.DecimalQuantity
    public boolean isZeroish() {
        return this.precision == 0;
    }

    @Override // com.ibm.icu.impl.number.DecimalQuantity
    public void multiplyBy(BigDecimal bigDecimal) {
        if (isZeroish()) {
            return;
        }
        setToBigDecimal(toBigDecimal().multiply(bigDecimal));
    }

    @Override // com.ibm.icu.impl.number.DecimalQuantity
    public void negate() {
        this.flags = (byte) (this.flags ^ 1);
    }

    public abstract void popFromLeft(int i);

    @Override // com.ibm.icu.impl.number.DecimalQuantity
    public void populateUFieldPosition(FieldPosition fieldPosition) {
        if (fieldPosition instanceof UFieldPosition) {
            ((UFieldPosition) fieldPosition).setFractionDigits((int) getPluralOperand(PluralRules.Operand.v), (long) getPluralOperand(PluralRules.Operand.f));
        }
    }

    public abstract void readBigIntegerToBcd(BigInteger bigInteger);

    public abstract void readIntToBcd(int i);

    public abstract void readLongToBcd(long j);

    @Override // com.ibm.icu.impl.number.DecimalQuantity
    public void resetExponent() {
        adjustMagnitude(this.exponent);
        this.exponent = 0;
    }

    @Override // com.ibm.icu.impl.number.DecimalQuantity
    public void roundToIncrement(BigDecimal bigDecimal, MathContext mathContext) {
        BigDecimal bigDecimalRound = toBigDecimal().divide(bigDecimal, 0, mathContext.getRoundingMode()).multiply(bigDecimal).round(mathContext);
        if (bigDecimalRound.signum() == 0) {
            setBcdToZero();
        } else {
            setToBigDecimal(bigDecimalRound);
        }
    }

    @Override // com.ibm.icu.impl.number.DecimalQuantity
    public void roundToInfinity() {
        if (this.isApproximate) {
            convertToAccurateDouble();
        }
    }

    @Override // com.ibm.icu.impl.number.DecimalQuantity
    public void roundToNickel(int i, MathContext mathContext) {
        roundToMagnitude(i, mathContext, true);
    }

    public abstract void setBcdToZero();

    public abstract void setDigitPos(int i, byte b);

    @Override // com.ibm.icu.impl.number.DecimalQuantity
    public void setMinFraction(int i) {
        this.rReqPos = -i;
    }

    @Override // com.ibm.icu.impl.number.DecimalQuantity
    public void setMinInteger(int i) {
        int i2 = this.lReqPos;
        if (i < i2) {
            i = i2;
        }
        this.lReqPos = i;
    }

    @Override // com.ibm.icu.impl.number.DecimalQuantity
    public void setToBigDecimal(BigDecimal bigDecimal) {
        setBcdToZero();
        this.flags = (byte) 0;
        if (bigDecimal.signum() == -1) {
            this.flags = (byte) (this.flags | 1);
            bigDecimal = bigDecimal.negate();
        }
        if (bigDecimal.signum() != 0) {
            _setToBigDecimal(bigDecimal);
            compact();
        }
    }

    public void setToBigInteger(BigInteger bigInteger) {
        setBcdToZero();
        this.flags = (byte) 0;
        if (bigInteger.signum() == -1) {
            this.flags = (byte) (this.flags | 1);
            bigInteger = bigInteger.negate();
        }
        if (bigInteger.signum() != 0) {
            _setToBigInteger(bigInteger);
            compact();
        }
    }

    public void setToDouble(double d) {
        setBcdToZero();
        this.flags = (byte) 0;
        if (Double.doubleToRawLongBits(d) < 0) {
            this.flags = (byte) (this.flags | 1);
            d = -d;
        }
        if (Double.isNaN(d)) {
            this.flags = (byte) (this.flags | 4);
            return;
        }
        if (Double.isInfinite(d)) {
            this.flags = (byte) (this.flags | 2);
        } else if (d != 0.0d) {
            _setToDoubleFast(d);
            compact();
        }
    }

    public void setToInt(int i) {
        setBcdToZero();
        this.flags = (byte) 0;
        if (i < 0) {
            this.flags = (byte) 1;
            i = -i;
        }
        if (i != 0) {
            _setToInt(i);
            compact();
        }
    }

    public void setToLong(long j) {
        setBcdToZero();
        this.flags = (byte) 0;
        if (j < 0) {
            this.flags = (byte) 1;
            j = -j;
        }
        if (j != 0) {
            _setToLong(j);
            compact();
        }
    }

    public abstract void shiftLeft(int i);

    public abstract void shiftRight(int i);

    @Override // com.ibm.icu.impl.number.DecimalQuantity
    public Modifier.Signum signum() {
        boolean z = isZeroish() && !isInfinite();
        boolean zIsNegative = isNegative();
        if (z && zIsNegative) {
            return Modifier.Signum.NEG_ZERO;
        }
        if (z) {
            return Modifier.Signum.POS_ZERO;
        }
        return zIsNegative ? Modifier.Signum.NEG : Modifier.Signum.POS;
    }

    @Override // com.ibm.icu.impl.number.DecimalQuantity
    public BigDecimal toBigDecimal() {
        if (this.isApproximate) {
            convertToAccurateDouble();
        }
        return bcdToBigDecimal();
    }

    @Override // com.ibm.icu.impl.number.DecimalQuantity
    public double toDouble() {
        if (isNaN()) {
            return Double.NaN;
        }
        if (isInfinite()) {
            return isNegative() ? Double.NEGATIVE_INFINITY : Double.POSITIVE_INFINITY;
        }
        StringBuilder sb = new StringBuilder();
        toScientificString(sb);
        return Double.parseDouble(sb.toString());
    }

    public long toFractionLong(boolean z) {
        int iMin = this.scale;
        if (z) {
            iMin = Math.min(iMin, this.rReqPos);
        }
        long digitPos = 0;
        for (int i = (-1) - this.exponent; i >= iMin && digitPos <= 1.0E17d; i--) {
            digitPos = (digitPos * 10) + ((long) getDigitPos(i - this.scale));
        }
        if (!z) {
            while (digitPos > 0 && digitPos % 10 == 0) {
                digitPos /= 10;
            }
        }
        return digitPos;
    }

    @Override // com.ibm.icu.impl.number.DecimalQuantity
    public long toLong(boolean z) {
        int iMin = ((this.exponent + this.scale) + this.precision) - 1;
        if (z) {
            iMin = Math.min(iMin, 17);
        }
        long digitPos = 0;
        while (iMin >= 0) {
            digitPos = (digitPos * 10) + ((long) getDigitPos((iMin - this.scale) - this.exponent));
            iMin--;
        }
        return isNegative() ? -digitPos : digitPos;
    }

    public void toPlainString(StringBuilder sb) {
        if (isNegative()) {
            sb.append('-');
        }
        int i = this.precision;
        if (i == 0) {
            sb.append('0');
            return;
        }
        int i2 = this.scale;
        int i3 = this.exponent;
        int i4 = ((i + i2) + i3) - 1;
        int i5 = i2 + i3;
        int i6 = this.lReqPos;
        if (i4 < i6 - 1) {
            i4 = i6 - 1;
        }
        int i7 = this.rReqPos;
        if (i5 > i7) {
            i5 = i7;
        }
        if (i4 < 0) {
            sb.append('0');
        }
        while (i4 >= 0) {
            sb.append((char) (getDigitPos((i4 - this.scale) - this.exponent) + 48));
            i4--;
        }
        if (i5 < 0) {
            sb.append('.');
        }
        while (i4 >= i5) {
            sb.append((char) (getDigitPos((i4 - this.scale) - this.exponent) + 48));
            i4--;
        }
    }

    public void toScientificString(StringBuilder sb) {
        if (isNegative()) {
            sb.append('-');
        }
        int i = this.precision;
        if (i == 0) {
            sb.append("0E+0");
            return;
        }
        int i2 = i - 1;
        sb.append((char) (getDigitPos(i2) + 48));
        int i3 = i - 2;
        if (i3 >= 0) {
            sb.append('.');
            while (i3 >= 0) {
                sb.append((char) (getDigitPos(i3) + 48));
                i3--;
            }
        }
        sb.append('E');
        int i4 = i2 + this.scale + this.exponent;
        if (i4 == Integer.MIN_VALUE) {
            sb.append("-2147483648");
            return;
        }
        if (i4 < 0) {
            i4 *= -1;
            sb.append('-');
        } else {
            sb.append('+');
        }
        if (i4 == 0) {
            sb.append('0');
        }
        int length = sb.length();
        while (i4 > 0) {
            sb.insert(length, (char) ((i4 % 10) + 48));
            i4 /= 10;
        }
    }

    public void truncate() {
        int i = this.scale;
        if (i < 0) {
            shiftRight(-i);
            this.scale = 0;
            compact();
        }
    }

    @Override // com.ibm.icu.impl.number.DecimalQuantity
    public String toExponentString() {
        StringBuilder sb = new StringBuilder();
        toExponentString(sb);
        return sb.toString();
    }

    @Override // com.ibm.icu.impl.number.DecimalQuantity
    public String toPlainString() {
        StringBuilder sb = new StringBuilder();
        toPlainString(sb);
        return sb.toString();
    }

    public String toScientificString() {
        StringBuilder sb = new StringBuilder();
        toScientificString(sb);
        return sb.toString();
    }

    @Override // com.ibm.icu.impl.number.DecimalQuantity
    public void roundToMagnitude(int i, MathContext mathContext) {
        roundToMagnitude(i, mathContext, false);
    }
}
