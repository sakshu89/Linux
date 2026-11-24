package com.ibm.icu.text;

import defpackage.og;
import java.text.ParsePosition;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
abstract class NFSubstitution {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final long MAX_INT64_IN_DOUBLE = 9007199254740991L;
    final DecimalFormat numberFormat;
    final int pos;
    final NFRuleSet ruleSet;

    /* JADX WARN: Code duplicated, block: B:29:0x0076  */
    /* JADX WARN: Code duplicated, block: B:7:0x0022 A[DONT_INVERT] */
    public NFSubstitution(int i, NFRuleSet nFRuleSet, String str) {
        this.pos = i;
        int length = str.length();
        if (length >= 2) {
            int i2 = length - 1;
            if (str.charAt(0) == str.charAt(i2)) {
                str = str.substring(1, i2);
            } else if (length != 0) {
                og.i("Illegal substitution syntax");
                throw null;
            }
        } else if (length != 0) {
            og.i("Illegal substitution syntax");
            throw null;
        }
        if (str.length() == 0) {
            this.ruleSet = nFRuleSet;
            this.numberFormat = null;
            return;
        }
        if (str.charAt(0) == '%') {
            this.ruleSet = nFRuleSet.owner.findRuleSet(str);
            this.numberFormat = null;
            return;
        }
        if (str.charAt(0) == '#' || str.charAt(0) == '0') {
            this.ruleSet = null;
            DecimalFormat decimalFormatClone = nFRuleSet.owner.getDecimalFormat().clone();
            this.numberFormat = decimalFormatClone;
            decimalFormatClone.applyPattern(str);
            return;
        }
        if (str.charAt(0) != '>') {
            og.i("Illegal substitution syntax");
            throw null;
        }
        this.ruleSet = nFRuleSet;
        this.numberFormat = null;
    }

    public static NFSubstitution makeSubstitution(int i, NFRule nFRule, NFRule nFRule2, NFRuleSet nFRuleSet, RuleBasedNumberFormat ruleBasedNumberFormat, String str) {
        if (str.length() == 0) {
            return null;
        }
        switch (str.charAt(0)) {
            case '<':
                if (nFRule.getBaseValue() == -1) {
                    og.i("<< not allowed in negative-number rule");
                    return null;
                }
                if (nFRule.getBaseValue() == -2 || nFRule.getBaseValue() == -3 || nFRule.getBaseValue() == -4) {
                    return new IntegralPartSubstitution(i, nFRuleSet, str);
                }
                return nFRuleSet.isFractionSet() ? new NumeratorSubstitution(i, nFRule.getBaseValue(), ruleBasedNumberFormat.getDefaultRuleSet(), str) : new MultiplierSubstitution(i, nFRule, nFRuleSet, str);
            case '=':
                return new SameValueSubstitution(i, nFRuleSet, str);
            case '>':
                if (nFRule.getBaseValue() == -1) {
                    return new AbsoluteValueSubstitution(i, nFRuleSet, str);
                }
                if (nFRule.getBaseValue() == -2 || nFRule.getBaseValue() == -3 || nFRule.getBaseValue() == -4) {
                    return new FractionalPartSubstitution(i, nFRuleSet, str);
                }
                if (!nFRuleSet.isFractionSet()) {
                    return new ModulusSubstitution(i, nFRule, nFRule2, nFRuleSet, str);
                }
                og.i(">> not allowed in fraction rule set");
                return null;
            default:
                og.i("Illegal substitution character");
                return null;
        }
    }

    public abstract double calcUpperBound(double d);

    public abstract double composeRuleValue(double d, double d2);

    public Number doParse(String str, ParsePosition parsePosition, double d, double d2, boolean z, int i, int i2) {
        Number number;
        double dCalcUpperBound = calcUpperBound(d2);
        NFRuleSet nFRuleSet = this.ruleSet;
        if (nFRuleSet != null) {
            number = nFRuleSet.parse(str, parsePosition, dCalcUpperBound, i, i2);
            if (z && !this.ruleSet.isFractionSet() && parsePosition.getIndex() == 0) {
                number = this.ruleSet.owner.getDecimalFormat().parse(str, parsePosition);
            }
        } else {
            number = this.numberFormat.parse(str, parsePosition);
        }
        if (parsePosition.getIndex() == 0) {
            return number;
        }
        double dComposeRuleValue = composeRuleValue(number.doubleValue(), d);
        long j = (long) dComposeRuleValue;
        return dComposeRuleValue == ((double) j) ? Long.valueOf(j) : Double.valueOf(dComposeRuleValue);
    }

    public void doSubstitution(double d, StringBuilder sb, int i, int i2) {
        NFRuleSet nFRuleSet;
        double dTransformNumber = transformNumber(d);
        if (Double.isInfinite(dTransformNumber)) {
            this.ruleSet.findRule(Double.POSITIVE_INFINITY).doFormat(dTransformNumber, sb, i + this.pos, i2);
            return;
        }
        if (dTransformNumber == Math.floor(dTransformNumber) && (nFRuleSet = this.ruleSet) != null) {
            nFRuleSet.format((long) dTransformNumber, sb, i + this.pos, i2);
            return;
        }
        NFRuleSet nFRuleSet2 = this.ruleSet;
        int i3 = this.pos;
        if (nFRuleSet2 != null) {
            nFRuleSet2.format(dTransformNumber, sb, i + i3, i2);
        } else {
            sb.insert(i + i3, this.numberFormat.format(dTransformNumber));
        }
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (getClass() == obj.getClass()) {
            NFSubstitution nFSubstitution = (NFSubstitution) obj;
            if (this.pos == nFSubstitution.pos && (this.ruleSet != null || nFSubstitution.ruleSet == null)) {
                DecimalFormat decimalFormat = this.numberFormat;
                DecimalFormat decimalFormat2 = nFSubstitution.numberFormat;
                if (decimalFormat != null ? decimalFormat.equals(decimalFormat2) : decimalFormat2 == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int getPos() {
        return this.pos;
    }

    public int hashCode() {
        return 42;
    }

    public boolean isModulusSubstitution() {
        return false;
    }

    public void setDecimalFormatSymbols(DecimalFormatSymbols decimalFormatSymbols) {
        DecimalFormat decimalFormat = this.numberFormat;
        if (decimalFormat != null) {
            decimalFormat.setDecimalFormatSymbols(decimalFormatSymbols);
        }
    }

    public String toString() {
        if (this.ruleSet != null) {
            return tokenChar() + this.ruleSet.getName() + tokenChar();
        }
        return tokenChar() + this.numberFormat.toPattern() + tokenChar();
    }

    public abstract char tokenChar();

    public abstract double transformNumber(double d);

    public abstract long transformNumber(long j);

    public void setDivisor(int i, short s) {
    }

    public void doSubstitution(long j, StringBuilder sb, int i, int i2) {
        if (this.ruleSet != null) {
            this.ruleSet.format(transformNumber(j), sb, i + this.pos, i2);
        } else if (j <= MAX_INT64_IN_DOUBLE) {
            sb.insert(i + this.pos, this.numberFormat.format(transformNumber(j)));
        } else {
            sb.insert(i + this.pos, this.numberFormat.format(transformNumber(j)));
        }
    }
}
