package com.ibm.icu.text;

import defpackage.cq;
import defpackage.og;
import java.text.ParsePosition;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
class ModulusSubstitution extends NFSubstitution {
    long divisor;
    private final NFRule ruleToUse;

    public ModulusSubstitution(int i, NFRule nFRule, NFRule nFRule2, NFRuleSet nFRuleSet, String str) {
        super(i, nFRuleSet, str);
        long divisor = nFRule.getDivisor();
        this.divisor = divisor;
        if (divisor != 0) {
            if (str.equals(">>>")) {
                this.ruleToUse = nFRule2;
                return;
            } else {
                this.ruleToUse = null;
                return;
            }
        }
        String strSubstring = str.substring(0, i);
        String strSubstring2 = str.substring(i);
        StringBuilder sb = new StringBuilder("Substitution with bad divisor (");
        sb.append(divisor);
        sb.append(") ");
        sb.append(strSubstring);
        og.n(cq.n(sb, " | ", strSubstring2));
        throw null;
    }

    @Override // com.ibm.icu.text.NFSubstitution
    public double calcUpperBound(double d) {
        return this.divisor;
    }

    @Override // com.ibm.icu.text.NFSubstitution
    public double composeRuleValue(double d, double d2) {
        return (d2 - (d2 % this.divisor)) + d;
    }

    @Override // com.ibm.icu.text.NFSubstitution
    public Number doParse(String str, ParsePosition parsePosition, double d, double d2, boolean z, int i, int i2) {
        NFRule nFRule = this.ruleToUse;
        if (nFRule == null) {
            return super.doParse(str, parsePosition, d, d2, z, i, i2);
        }
        Number numberDoParse = nFRule.doParse(str, parsePosition, false, d2, i, i2 + 1);
        if (parsePosition.getIndex() == 0) {
            return numberDoParse;
        }
        double dComposeRuleValue = composeRuleValue(numberDoParse.doubleValue(), d);
        long j = (long) dComposeRuleValue;
        return dComposeRuleValue == ((double) j) ? Long.valueOf(j) : Double.valueOf(dComposeRuleValue);
    }

    @Override // com.ibm.icu.text.NFSubstitution
    public void doSubstitution(long j, StringBuilder sb, int i, int i2) {
        if (this.ruleToUse == null) {
            super.doSubstitution(j, sb, i, i2);
        } else {
            this.ruleToUse.doFormat(transformNumber(j), sb, i + this.pos, i2);
        }
    }

    @Override // com.ibm.icu.text.NFSubstitution
    public boolean equals(Object obj) {
        return super.equals(obj) && this.divisor == ((ModulusSubstitution) obj).divisor;
    }

    @Override // com.ibm.icu.text.NFSubstitution
    public boolean isModulusSubstitution() {
        return true;
    }

    @Override // com.ibm.icu.text.NFSubstitution
    public void setDivisor(int i, short s) {
        long jPower = NFRule.power(i, s);
        this.divisor = jPower;
        if (jPower != 0) {
            return;
        }
        og.n("Substitution with bad divisor");
    }

    @Override // com.ibm.icu.text.NFSubstitution
    public char tokenChar() {
        return '>';
    }

    @Override // com.ibm.icu.text.NFSubstitution
    public double transformNumber(double d) {
        return d % this.divisor;
    }

    @Override // com.ibm.icu.text.NFSubstitution
    public long transformNumber(long j) {
        return j % this.divisor;
    }

    @Override // com.ibm.icu.text.NFSubstitution
    public void doSubstitution(double d, StringBuilder sb, int i, int i2) {
        if (this.ruleToUse == null) {
            super.doSubstitution(d, sb, i, i2);
        } else {
            this.ruleToUse.doFormat(transformNumber(d), sb, i + this.pos, i2);
        }
    }
}
