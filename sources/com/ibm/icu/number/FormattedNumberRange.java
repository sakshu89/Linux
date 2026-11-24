package com.ibm.icu.number;

import com.ibm.icu.impl.FormattedStringBuilder;
import com.ibm.icu.impl.FormattedValueStringBuilderImpl;
import com.ibm.icu.impl.number.DecimalQuantity;
import com.ibm.icu.text.ConstrainedFieldPosition;
import com.ibm.icu.text.FormattedValue;
import com.ibm.icu.text.PluralRules;
import defpackage.kf2;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.AttributedCharacterIterator;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class FormattedNumberRange implements FormattedValue {
    final NumberRangeFormatter.RangeIdentityResult identityResult;
    final DecimalQuantity quantity1;
    final DecimalQuantity quantity2;
    final FormattedStringBuilder string;

    public FormattedNumberRange(FormattedStringBuilder formattedStringBuilder, DecimalQuantity decimalQuantity, DecimalQuantity decimalQuantity2, NumberRangeFormatter.RangeIdentityResult rangeIdentityResult) {
        this.string = formattedStringBuilder;
        this.quantity1 = decimalQuantity;
        this.quantity2 = decimalQuantity2;
        this.identityResult = rangeIdentityResult;
    }

    @Override // com.ibm.icu.text.FormattedValue
    public <A extends Appendable> A appendTo(A a) {
        try {
            a.append(this.string);
            return a;
        } catch (IOException e) {
            kf2.h(e);
            return null;
        }
    }

    @Override // java.lang.CharSequence
    public char charAt(int i) {
        return this.string.charAt(i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof FormattedNumberRange)) {
            return false;
        }
        FormattedNumberRange formattedNumberRange = (FormattedNumberRange) obj;
        return this.string.contentEquals(formattedNumberRange.string) && this.quantity1.toBigDecimal().equals(formattedNumberRange.quantity1.toBigDecimal()) && this.quantity2.toBigDecimal().equals(formattedNumberRange.quantity2.toBigDecimal());
    }

    public BigDecimal getFirstBigDecimal() {
        return this.quantity1.toBigDecimal();
    }

    @Deprecated
    public PluralRules.IFixedDecimal getFirstFixedDecimal() {
        return this.quantity1;
    }

    public NumberRangeFormatter.RangeIdentityResult getIdentityResult() {
        return this.identityResult;
    }

    public BigDecimal getSecondBigDecimal() {
        return this.quantity2.toBigDecimal();
    }

    @Deprecated
    public PluralRules.IFixedDecimal getSecondFixedDecimal() {
        return this.quantity2;
    }

    public int hashCode() {
        return this.quantity2.toBigDecimal().hashCode() ^ ((Arrays.hashCode(this.string.toCharArray()) ^ Arrays.hashCode(this.string.toFieldArray())) ^ this.quantity1.toBigDecimal().hashCode());
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.string.length();
    }

    @Override // com.ibm.icu.text.FormattedValue
    public boolean nextPosition(ConstrainedFieldPosition constrainedFieldPosition) {
        return FormattedValueStringBuilderImpl.nextPosition(this.string, constrainedFieldPosition, null);
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int i, int i2) {
        return this.string.subString(i, i2);
    }

    @Override // com.ibm.icu.text.FormattedValue
    public AttributedCharacterIterator toCharacterIterator() {
        return FormattedValueStringBuilderImpl.toCharacterIterator(this.string, null);
    }

    @Override // com.ibm.icu.text.FormattedValue, java.lang.CharSequence
    public String toString() {
        return this.string.toString();
    }
}
