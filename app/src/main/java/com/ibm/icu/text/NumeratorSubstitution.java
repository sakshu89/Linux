package com.ibm.icu.text;

import java.text.ParsePosition;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
class NumeratorSubstitution extends NFSubstitution {
    private final double denominator;
    private final boolean withZeros;

    public NumeratorSubstitution(int i, double d, NFRuleSet nFRuleSet, String str) {
        super(i, nFRuleSet, fixdesc(str));
        this.denominator = d;
        this.withZeros = str.endsWith("<<");
    }

    public static String fixdesc(String str) {
        return str.endsWith("<<") ? str.substring(0, str.length() - 1) : str;
    }

    @Override // com.ibm.icu.text.NFSubstitution
    public double calcUpperBound(double d) {
        return this.denominator;
    }

    @Override // com.ibm.icu.text.NFSubstitution
    public double composeRuleValue(double d, double d2) {
        return d / d2;
    }

    @Override // com.ibm.icu.text.NFSubstitution
    public Number doParse(String str, ParsePosition parsePosition, double d, double d2, boolean z, int i, int i2) {
        String strSubstring;
        int i3;
        if (!this.withZeros || this.ruleSet == null) {
            strSubstring = str;
            i3 = 0;
        } else {
            ParsePosition parsePosition2 = new ParsePosition(1);
            String strSubstring2 = str;
            i3 = 0;
            while (strSubstring2.length() > 0 && parsePosition2.getIndex() != 0) {
                parsePosition2.setIndex(0);
                this.ruleSet.parse(strSubstring2, parsePosition2, 1.0d, i, i2).intValue();
                if (parsePosition2.getIndex() == 0) {
                    break;
                }
                i3++;
                parsePosition.setIndex(parsePosition2.getIndex() + parsePosition.getIndex());
                strSubstring2 = strSubstring2.substring(parsePosition2.getIndex());
                while (strSubstring2.length() > 0 && strSubstring2.charAt(0) == ' ') {
                    strSubstring2 = strSubstring2.substring(1);
                    parsePosition.setIndex(parsePosition.getIndex() + 1);
                }
            }
            strSubstring = str.substring(parsePosition.getIndex());
            parsePosition.setIndex(0);
        }
        Number numberDoParse = super.doParse(strSubstring, parsePosition, this.withZeros ? 1.0d : d, d2, false, i, i2);
        if (!this.withZeros || numberDoParse == null) {
            return numberDoParse;
        }
        long jLongValue = numberDoParse.longValue();
        long j = 1;
        while (j <= jLongValue) {
            if (j > 922337203685477580L) {
                parsePosition.setIndex(0);
                return 0;
            }
            j *= 10;
        }
        while (i3 > 0) {
            if (j > 922337203685477580L) {
                parsePosition.setIndex(0);
                return 0;
            }
            j *= 10;
            i3--;
        }
        return Double.valueOf(jLongValue / j);
    }

    @Override // com.ibm.icu.text.NFSubstitution
    public void doSubstitution(double d, StringBuilder sb, int i, int i2) {
        int length;
        NFRuleSet nFRuleSet;
        double dTransformNumber = transformNumber(d);
        if (!this.withZeros || this.ruleSet == null) {
            length = i;
        } else {
            long j = (long) dTransformNumber;
            int length2 = sb.length();
            while (true) {
                long j2 = j * 10;
                if (j2 >= this.denominator) {
                    break;
                }
                sb.insert(i + this.pos, ' ');
                this.ruleSet.format(0L, sb, i + this.pos, i2);
                j = j2;
            }
            length = (sb.length() - length2) + i;
        }
        if (dTransformNumber == Math.floor(dTransformNumber) && (nFRuleSet = this.ruleSet) != null) {
            nFRuleSet.format((long) dTransformNumber, sb, this.pos + length, i2);
            return;
        }
        int i3 = length;
        NFRuleSet nFRuleSet2 = this.ruleSet;
        int i4 = this.pos;
        if (nFRuleSet2 != null) {
            nFRuleSet2.format(dTransformNumber, sb, i3 + i4, i2);
        } else {
            sb.insert(i3 + i4, this.numberFormat.format(dTransformNumber));
        }
    }

    @Override // com.ibm.icu.text.NFSubstitution
    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            NumeratorSubstitution numeratorSubstitution = (NumeratorSubstitution) obj;
            if (this.denominator == numeratorSubstitution.denominator && this.withZeros == numeratorSubstitution.withZeros) {
                return true;
            }
        }
        return false;
    }

    @Override // com.ibm.icu.text.NFSubstitution
    public char tokenChar() {
        return '<';
    }

    @Override // com.ibm.icu.text.NFSubstitution
    public long transformNumber(long j) {
        return Math.round(j * this.denominator);
    }

    @Override // com.ibm.icu.text.NFSubstitution
    public double transformNumber(double d) {
        return Math.round(d * this.denominator);
    }
}
