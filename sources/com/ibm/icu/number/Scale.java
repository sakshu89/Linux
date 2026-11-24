package com.ibm.icu.number;

import com.ibm.icu.impl.number.DecimalQuantity;
import com.ibm.icu.impl.number.RoundingUtils;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class Scale {
    final BigDecimal arbitrary;
    final int magnitude;
    final MathContext mc;
    final BigDecimal reciprocal;
    private static final Scale DEFAULT = new Scale(0, null);
    private static final Scale HUNDRED = new Scale(2, null);
    private static final Scale THOUSAND = new Scale(3, null);
    private static final BigDecimal BIG_DECIMAL_100 = BigDecimal.valueOf(100L);
    private static final BigDecimal BIG_DECIMAL_1000 = BigDecimal.valueOf(1000L);

    private Scale(int i, BigDecimal bigDecimal, MathContext mathContext) {
        if (bigDecimal != null) {
            BigDecimal bigDecimal2 = BigDecimal.ZERO;
            bigDecimal = bigDecimal.compareTo(bigDecimal2) == 0 ? bigDecimal2 : bigDecimal.signum() == 0 ? new BigDecimal(BigInteger.ZERO, 0) : bigDecimal.stripTrailingZeros();
            if (bigDecimal.precision() == 1 && bigDecimal.unscaledValue().equals(BigInteger.ONE)) {
                i -= bigDecimal.scale();
                bigDecimal = null;
            }
        }
        this.magnitude = i;
        this.arbitrary = bigDecimal;
        this.mc = mathContext;
        if (bigDecimal == null || BigDecimal.ZERO.compareTo(bigDecimal) == 0) {
            this.reciprocal = null;
        } else {
            this.reciprocal = BigDecimal.ONE.divide(bigDecimal, mathContext);
        }
    }

    public static Scale byBigDecimal(BigDecimal bigDecimal) {
        if (bigDecimal.compareTo(BigDecimal.ONE) == 0) {
            return DEFAULT;
        }
        if (bigDecimal.compareTo(BIG_DECIMAL_100) == 0) {
            return HUNDRED;
        }
        return bigDecimal.compareTo(BIG_DECIMAL_1000) == 0 ? THOUSAND : new Scale(0, bigDecimal);
    }

    public static Scale byDouble(double d) {
        if (d == 1.0d) {
            return DEFAULT;
        }
        if (d == 100.0d) {
            return HUNDRED;
        }
        return d == 1000.0d ? THOUSAND : new Scale(0, BigDecimal.valueOf(d));
    }

    public static Scale byDoubleAndPowerOfTen(double d, int i) {
        return new Scale(i, BigDecimal.valueOf(d));
    }

    public static Scale none() {
        return DEFAULT;
    }

    public static Scale powerOfTen(int i) {
        if (i == 0) {
            return DEFAULT;
        }
        if (i == 2) {
            return HUNDRED;
        }
        return i == 3 ? THOUSAND : new Scale(i, null);
    }

    @Deprecated
    public void applyReciprocalTo(DecimalQuantity decimalQuantity) {
        decimalQuantity.adjustMagnitude(-this.magnitude);
        BigDecimal bigDecimal = this.reciprocal;
        if (bigDecimal != null) {
            decimalQuantity.multiplyBy(bigDecimal);
            decimalQuantity.roundToMagnitude(decimalQuantity.getMagnitude() - this.mc.getPrecision(), this.mc);
        }
    }

    @Deprecated
    public void applyTo(DecimalQuantity decimalQuantity) {
        decimalQuantity.adjustMagnitude(this.magnitude);
        BigDecimal bigDecimal = this.arbitrary;
        if (bigDecimal != null) {
            decimalQuantity.multiplyBy(bigDecimal);
        }
    }

    public boolean isValid() {
        return (this.magnitude == 0 && this.arbitrary == null) ? false : true;
    }

    @Deprecated
    public Scale withMathContext(MathContext mathContext) {
        return this.mc.equals(mathContext) ? this : new Scale(this.magnitude, this.arbitrary, mathContext);
    }

    private Scale(int i, BigDecimal bigDecimal) {
        this(i, bigDecimal, RoundingUtils.DEFAULT_MATH_CONTEXT_34_DIGITS);
    }
}
