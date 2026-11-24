package com.ibm.icu.impl.number;

import com.ibm.icu.impl.StandardPlural;
import com.ibm.icu.text.PluralRules;
import java.math.BigDecimal;
import java.math.MathContext;
import java.text.FieldPosition;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public interface DecimalQuantity extends PluralRules.IFixedDecimal {
    void adjustExponent(int i);

    void adjustMagnitude(int i);

    void applyMaxInteger(int i);

    void copyFrom(DecimalQuantity decimalQuantity);

    DecimalQuantity createCopy();

    byte getDigit(int i);

    int getExponent();

    int getLowerDisplayMagnitude();

    int getMagnitude();

    long getPositionFingerprint();

    StandardPlural getStandardPlural(PluralRules pluralRules);

    int getUpperDisplayMagnitude();

    @Override // com.ibm.icu.text.PluralRules.IFixedDecimal
    boolean isInfinite();

    @Override // com.ibm.icu.text.PluralRules.IFixedDecimal
    boolean isNaN();

    boolean isNegative();

    boolean isZeroish();

    int maxRepresentableDigits();

    void multiplyBy(BigDecimal bigDecimal);

    void negate();

    void populateUFieldPosition(FieldPosition fieldPosition);

    void resetExponent();

    void roundToIncrement(BigDecimal bigDecimal, MathContext mathContext);

    void roundToInfinity();

    void roundToMagnitude(int i, MathContext mathContext);

    void roundToNickel(int i, MathContext mathContext);

    void setMinFraction(int i);

    void setMinInteger(int i);

    void setToBigDecimal(BigDecimal bigDecimal);

    Modifier.Signum signum();

    BigDecimal toBigDecimal();

    double toDouble();

    String toExponentString();

    long toLong(boolean z);

    String toPlainString();
}
