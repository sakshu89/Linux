package com.ibm.icu.text;

import com.ibm.icu.impl.number.DecimalQuantity_DualStorageBCD;
import defpackage.og;
import java.text.ParsePosition;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
class FractionalPartSubstitution extends NFSubstitution {
    private final boolean byDigits;
    private final boolean useSpaces;

    public FractionalPartSubstitution(int i, NFRuleSet nFRuleSet, String str) {
        NFRuleSet nFRuleSet2;
        super(i, nFRuleSet, str);
        if (str.equals(">>") || str.equals(">>>") || nFRuleSet == (nFRuleSet2 = this.ruleSet)) {
            this.byDigits = true;
            this.useSpaces = !str.equals(">>>");
            return;
        }
        this.byDigits = false;
        this.useSpaces = true;
        if (nFRuleSet2 != null) {
            nFRuleSet2.makeIntoFractionRuleSet();
        } else {
            og.i("rule set is missing");
            throw null;
        }
    }

    @Override // com.ibm.icu.text.NFSubstitution
    public double calcUpperBound(double d) {
        return 0.0d;
    }

    @Override // com.ibm.icu.text.NFSubstitution
    public double composeRuleValue(double d, double d2) {
        return d + d2;
    }

    @Override // com.ibm.icu.text.NFSubstitution
    public Number doParse(String str, ParsePosition parsePosition, double d, double d2, boolean z, int i, int i2) {
        Number number;
        if (!this.byDigits) {
            return super.doParse(str, parsePosition, d, 0.0d, z, i, i2);
        }
        ParsePosition parsePosition2 = new ParsePosition(1);
        DecimalQuantity_DualStorageBCD decimalQuantity_DualStorageBCD = new DecimalQuantity_DualStorageBCD();
        String strSubstring = str;
        int i3 = 0;
        while (strSubstring.length() > 0 && parsePosition2.getIndex() != 0) {
            parsePosition2.setIndex(0);
            int iIntValue = this.ruleSet.parse(strSubstring, parsePosition2, 10.0d, i, i2).intValue();
            if (z && parsePosition2.getIndex() == 0 && (number = this.ruleSet.owner.getDecimalFormat().parse(strSubstring, parsePosition2)) != null) {
                iIntValue = number.intValue();
            }
            if (parsePosition2.getIndex() != 0) {
                decimalQuantity_DualStorageBCD.appendDigit((byte) iIntValue, 0, true);
                i3++;
                parsePosition.setIndex(parsePosition2.getIndex() + parsePosition.getIndex());
                strSubstring = strSubstring.substring(parsePosition2.getIndex());
                while (strSubstring.length() > 0 && strSubstring.charAt(0) == ' ') {
                    strSubstring = strSubstring.substring(1);
                    parsePosition.setIndex(parsePosition.getIndex() + 1);
                }
            }
        }
        decimalQuantity_DualStorageBCD.adjustMagnitude(-i3);
        return Double.valueOf(composeRuleValue(decimalQuantity_DualStorageBCD.toDouble(), d));
    }

    @Override // com.ibm.icu.text.NFSubstitution
    public void doSubstitution(double d, StringBuilder sb, int i, int i2) {
        if (!this.byDigits) {
            super.doSubstitution(d, sb, i, i2);
            return;
        }
        DecimalQuantity_DualStorageBCD decimalQuantity_DualStorageBCD = new DecimalQuantity_DualStorageBCD(d);
        decimalQuantity_DualStorageBCD.roundToInfinity();
        boolean z = false;
        for (int lowerDisplayMagnitude = decimalQuantity_DualStorageBCD.getLowerDisplayMagnitude(); lowerDisplayMagnitude < 0; lowerDisplayMagnitude++) {
            if (z && this.useSpaces) {
                sb.insert(this.pos + i, ' ');
            } else {
                z = true;
            }
            this.ruleSet.format(decimalQuantity_DualStorageBCD.getDigit(lowerDisplayMagnitude), sb, i + this.pos, i2);
        }
    }

    @Override // com.ibm.icu.text.NFSubstitution
    public char tokenChar() {
        return '>';
    }

    @Override // com.ibm.icu.text.NFSubstitution
    public double transformNumber(double d) {
        return d - Math.floor(d);
    }

    @Override // com.ibm.icu.text.NFSubstitution
    public long transformNumber(long j) {
        return 0L;
    }
}
