package com.ibm.icu.impl.number;

import com.ibm.icu.impl.StandardPlural;
import com.ibm.icu.number.Precision;
import com.ibm.icu.number.Scale;
import com.ibm.icu.text.PluralRules;
import defpackage.cq;
import java.math.MathContext;
import java.math.RoundingMode;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class RoundingUtils {
    public static final MathContext DEFAULT_MATH_CONTEXT_34_DIGITS;
    public static final MathContext DEFAULT_MATH_CONTEXT_UNLIMITED;
    public static final int MAX_INT_FRAC_SIG = 999;
    public static final int SECTION_LOWER = 1;
    public static final int SECTION_MIDPOINT = 2;
    public static final int SECTION_UPPER = 3;
    public static final RoundingMode DEFAULT_ROUNDING_MODE = RoundingMode.HALF_EVEN;
    private static final MathContext[] MATH_CONTEXT_BY_ROUNDING_MODE_UNLIMITED = new MathContext[RoundingMode.values().length];
    private static final MathContext[] MATH_CONTEXT_BY_ROUNDING_MODE_34_DIGITS = new MathContext[RoundingMode.values().length];

    static {
        int i = 0;
        while (true) {
            MathContext[] mathContextArr = MATH_CONTEXT_BY_ROUNDING_MODE_34_DIGITS;
            if (i >= mathContextArr.length) {
                MathContext[] mathContextArr2 = MATH_CONTEXT_BY_ROUNDING_MODE_UNLIMITED;
                RoundingMode roundingMode = DEFAULT_ROUNDING_MODE;
                DEFAULT_MATH_CONTEXT_UNLIMITED = mathContextArr2[roundingMode.ordinal()];
                DEFAULT_MATH_CONTEXT_34_DIGITS = mathContextArr[roundingMode.ordinal()];
                return;
            }
            MATH_CONTEXT_BY_ROUNDING_MODE_UNLIMITED[i] = new MathContext(0, RoundingMode.valueOf(i));
            mathContextArr[i] = new MathContext(34);
            i++;
        }
    }

    public static MathContext getMathContextOr34Digits(DecimalFormatProperties decimalFormatProperties) {
        MathContext mathContext = decimalFormatProperties.getMathContext();
        if (mathContext != null) {
            return mathContext;
        }
        RoundingMode roundingMode = decimalFormatProperties.getRoundingMode();
        if (roundingMode == null) {
            roundingMode = RoundingMode.HALF_EVEN;
        }
        return MATH_CONTEXT_BY_ROUNDING_MODE_34_DIGITS[roundingMode.ordinal()];
    }

    public static MathContext getMathContextOrUnlimited(DecimalFormatProperties decimalFormatProperties) {
        MathContext mathContext = decimalFormatProperties.getMathContext();
        if (mathContext != null) {
            return mathContext;
        }
        RoundingMode roundingMode = decimalFormatProperties.getRoundingMode();
        if (roundingMode == null) {
            roundingMode = RoundingMode.HALF_EVEN;
        }
        return MATH_CONTEXT_BY_ROUNDING_MODE_UNLIMITED[roundingMode.ordinal()];
    }

    public static StandardPlural getPluralSafe(Precision precision, PluralRules pluralRules, DecimalQuantity decimalQuantity) {
        if (precision == null) {
            return decimalQuantity.getStandardPlural(pluralRules);
        }
        DecimalQuantity decimalQuantityCreateCopy = decimalQuantity.createCopy();
        precision.apply(decimalQuantityCreateCopy);
        return decimalQuantityCreateCopy.getStandardPlural(pluralRules);
    }

    public static boolean getRoundingDirection(boolean z, boolean z2, int i, int i2, Object obj) {
        switch (i2) {
            case 0:
                return false;
            case 1:
                return true;
            case 2:
                return z2;
            case 3:
                return !z2;
            case 4:
                if (i == 1) {
                    return true;
                }
                if (i == 2 || i == 3) {
                    return false;
                }
                break;
            case 5:
                if (i == 1 || i == 2) {
                    return true;
                }
                if (i == 3) {
                    return false;
                }
                break;
            case 6:
                if (i == 1) {
                    return true;
                }
                if (i == 2) {
                    return z;
                }
                if (i == 3) {
                    return false;
                }
                break;
        }
        throw new ArithmeticException(cq.j("Rounding is required on ", obj.toString()));
    }

    public static MathContext mathContextUnlimited(RoundingMode roundingMode) {
        return MATH_CONTEXT_BY_ROUNDING_MODE_UNLIMITED[roundingMode.ordinal()];
    }

    public static boolean roundsAtMidpoint(int i) {
        return (i == 0 || i == 1 || i == 2 || i == 3) ? false : true;
    }

    public static Scale scaleFromProperties(DecimalFormatProperties decimalFormatProperties) {
        MathContext mathContextOr34Digits = getMathContextOr34Digits(decimalFormatProperties);
        if (decimalFormatProperties.getMagnitudeMultiplier() != 0) {
            return Scale.powerOfTen(decimalFormatProperties.getMagnitudeMultiplier()).withMathContext(mathContextOr34Digits);
        }
        if (decimalFormatProperties.getMultiplier() != null) {
            return Scale.byBigDecimal(decimalFormatProperties.getMultiplier()).withMathContext(mathContextOr34Digits);
        }
        return null;
    }
}
