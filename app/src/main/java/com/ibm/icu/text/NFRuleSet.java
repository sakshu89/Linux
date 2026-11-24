package com.ibm.icu.text;

import com.ibm.icu.impl.PatternProps;
import defpackage.cq;
import defpackage.ky0;
import defpackage.og;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
final class NFRuleSet {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final int DEFAULT_RULE_INDEX = 3;
    static final int IMPROPER_FRACTION_RULE_INDEX = 1;
    static final int INFINITY_RULE_INDEX = 4;
    static final int NAN_RULE_INDEX = 5;
    static final int NEGATIVE_RULE_INDEX = 0;
    static final int PROPER_FRACTION_RULE_INDEX = 2;
    private static final int RECURSION_LIMIT = 64;
    LinkedList<NFRule> fractionRules;
    private final boolean isParseable;
    private final String name;
    final RuleBasedNumberFormat owner;
    private NFRule[] rules;
    final NFRule[] nonNumericalRules = new NFRule[6];
    private boolean isFractionRuleSet = false;

    public NFRuleSet(RuleBasedNumberFormat ruleBasedNumberFormat, String[] strArr, int i) {
        this.owner = ruleBasedNumberFormat;
        String strSubstring = strArr[i];
        if (strSubstring.isEmpty()) {
            og.i("Empty rule set description");
            throw null;
        }
        if (strSubstring.charAt(0) == '%') {
            int iIndexOf = strSubstring.indexOf(58);
            if (iIndexOf == -1) {
                og.i("Rule set name doesn't end in colon");
                throw null;
            }
            if (iIndexOf < 2) {
                og.i("Rule set name is '%'");
                throw null;
            }
            String strSubstring2 = strSubstring.substring(0, iIndexOf);
            boolean zEndsWith = strSubstring2.endsWith("@noparse");
            this.isParseable = !zEndsWith;
            this.name = zEndsWith ? strSubstring2.substring(0, strSubstring2.length() - 8) : strSubstring2;
            while (iIndexOf < strSubstring.length()) {
                iIndexOf++;
                if (!PatternProps.isWhiteSpace(strSubstring.charAt(iIndexOf))) {
                    break;
                }
            }
            strSubstring = strSubstring.substring(iIndexOf);
            strArr[i] = strSubstring;
        } else {
            this.name = "%default";
            this.isParseable = true;
        }
        if (strSubstring.isEmpty()) {
            og.i("Empty rule set description");
            throw null;
        }
    }

    private NFRule findFractionRuleSetRule(double d) {
        int i = 0;
        long baseValue = this.rules[0].getBaseValue();
        int i2 = 1;
        while (true) {
            NFRule[] nFRuleArr = this.rules;
            if (i2 >= nFRuleArr.length) {
                break;
            }
            baseValue = lcm(baseValue, nFRuleArr[i2].getBaseValue());
            i2++;
        }
        long jRound = Math.round(baseValue * d);
        long j = Long.MAX_VALUE;
        int i3 = 0;
        while (true) {
            NFRule[] nFRuleArr2 = this.rules;
            if (i >= nFRuleArr2.length) {
                i = i3;
                break;
            }
            long baseValue2 = (nFRuleArr2[i].getBaseValue() * jRound) % baseValue;
            long j2 = baseValue - baseValue2;
            if (j2 < baseValue2) {
                baseValue2 = j2;
            }
            if (baseValue2 < j) {
                if (baseValue2 == 0) {
                    break;
                }
                i3 = i;
                j = baseValue2;
            }
            i++;
        }
        int i4 = i + 1;
        NFRule[] nFRuleArr3 = this.rules;
        if (i4 < nFRuleArr3.length && nFRuleArr3[i4].getBaseValue() == this.rules[i].getBaseValue() && (Math.round(this.rules[i].getBaseValue() * d) < 1 || Math.round(d * this.rules[i].getBaseValue()) >= 2)) {
            i = i4;
        }
        return this.rules[i];
    }

    private NFRule findNormalRule(long j) {
        if (this.isFractionRuleSet) {
            return findFractionRuleSetRule(j);
        }
        int i = 0;
        if (j < 0) {
            NFRule nFRule = this.nonNumericalRules[0];
            if (nFRule != null) {
                return nFRule;
            }
            j = -j;
        }
        int length = this.rules.length;
        if (length <= 0) {
            return this.nonNumericalRules[3];
        }
        while (i < length) {
            int i2 = (i + length) >>> 1;
            long baseValue = this.rules[i2].getBaseValue();
            if (baseValue == j) {
                return this.rules[i2];
            }
            if (baseValue > j) {
                length = i2;
            } else {
                i = i2 + 1;
            }
        }
        if (length == 0) {
            throw new IllegalStateException("The rule set " + this.name + " cannot format the value " + j);
        }
        NFRule nFRule2 = this.rules[length - 1];
        if (!nFRule2.shouldRollBack(j)) {
            return nFRule2;
        }
        if (length != 1) {
            return this.rules[length - 2];
        }
        og.n(ky0.l("The rule set ", this.name, " cannot roll back from the rule '", String.valueOf(nFRule2), "'"));
        return null;
    }

    private static long lcm(long j, long j2) {
        long j3;
        long j4;
        int i = 0;
        long j5 = j;
        long j6 = j2;
        while (true) {
            j3 = j5 & 1;
            if (j3 != 0 || (j6 & 1) != 0) {
                break;
            }
            i++;
            j5 >>= 1;
            j6 >>= 1;
        }
        if (j3 == 1) {
            j5 = -j6;
            j4 = j6;
        } else {
            j4 = j6;
        }
        while (j5 != 0) {
            while ((j5 & 1) == 0) {
                j5 >>= 1;
            }
            if (j5 > 0) {
                j5 = j5;
            } else {
                j4 = -j5;
            }
            j5 -= j4;
        }
        return (j / (j5 << i)) * j2;
    }

    private void setBestFractionRule(int i, NFRule nFRule, boolean z) {
        if (z) {
            if (this.fractionRules == null) {
                this.fractionRules = new LinkedList<>();
            }
            this.fractionRules.add(nFRule);
        }
        NFRule[] nFRuleArr = this.nonNumericalRules;
        if (nFRuleArr[i] == null) {
            nFRuleArr[i] = nFRule;
        } else if (this.owner.getDecimalFormatSymbols().getDecimalSeparator() == nFRule.getDecimalPoint()) {
            this.nonNumericalRules[i] = nFRule;
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof NFRuleSet)) {
            return false;
        }
        NFRuleSet nFRuleSet = (NFRuleSet) obj;
        if (!this.name.equals(nFRuleSet.name) || this.rules.length != nFRuleSet.rules.length || this.isFractionRuleSet != nFRuleSet.isFractionRuleSet) {
            return false;
        }
        int i = 0;
        while (true) {
            NFRule[] nFRuleArr = this.nonNumericalRules;
            if (i >= nFRuleArr.length) {
                int i2 = 0;
                while (true) {
                    NFRule[] nFRuleArr2 = this.rules;
                    if (i2 >= nFRuleArr2.length) {
                        return true;
                    }
                    if (!nFRuleArr2[i2].equals(nFRuleSet.rules[i2])) {
                        return false;
                    }
                    i2++;
                }
            } else {
                if (!Objects.equals(nFRuleArr[i], nFRuleSet.nonNumericalRules[i])) {
                    return false;
                }
                i++;
            }
        }
    }

    public NFRule findRule(double d) {
        NFRule nFRule;
        if (this.isFractionRuleSet) {
            return findFractionRuleSetRule(d);
        }
        if (Double.isNaN(d)) {
            NFRule nFRule2 = this.nonNumericalRules[5];
            return nFRule2 == null ? this.owner.getDefaultNaNRule() : nFRule2;
        }
        if (d < 0.0d) {
            NFRule nFRule3 = this.nonNumericalRules[0];
            if (nFRule3 != null) {
                return nFRule3;
            }
            d = -d;
        }
        if (Double.isInfinite(d)) {
            NFRule nFRule4 = this.nonNumericalRules[4];
            return nFRule4 == null ? this.owner.getDefaultInfinityRule() : nFRule4;
        }
        if (d != Math.floor(d)) {
            if (d < 1.0d && (nFRule = this.nonNumericalRules[2]) != null) {
                return nFRule;
            }
            NFRule nFRule5 = this.nonNumericalRules[1];
            if (nFRule5 != null) {
                return nFRule5;
            }
        }
        NFRule nFRule6 = this.nonNumericalRules[3];
        return nFRule6 != null ? nFRule6 : findNormalRule(Math.round(d));
    }

    public void format(long j, StringBuilder sb, int i, int i2) {
        if (i2 < 64) {
            findNormalRule(j).doFormat(j, sb, i, i2 + 1);
        } else {
            og.n(cq.j("Recursion limit exceeded when applying ruleSet ", this.name));
        }
    }

    public String getName() {
        return this.name;
    }

    public int hashCode() {
        return 42;
    }

    public boolean isFractionSet() {
        return this.isFractionRuleSet;
    }

    public boolean isParseable() {
        return this.isParseable;
    }

    public boolean isPublic() {
        return !this.name.startsWith("%%");
    }

    public void makeIntoFractionRuleSet() {
        this.isFractionRuleSet = true;
    }

    public Number parse(String str, ParsePosition parsePosition, double d, int i, int i2) {
        ParsePosition parsePosition2 = new ParsePosition(0);
        Long l = NFRule.ZERO;
        if (i2 >= 64) {
            og.n(cq.j("Recursion limit exceeded when applying ruleSet ", this.name));
            return null;
        }
        if (str.length() == 0) {
            return l;
        }
        int i3 = i;
        Number number = l;
        int i4 = 0;
        while (true) {
            NFRule[] nFRuleArr = this.nonNumericalRules;
            if (i4 >= nFRuleArr.length) {
                break;
            }
            NFRule nFRule = nFRuleArr[i4];
            if (nFRule != null && ((i3 >> i4) & 1) == 0) {
                i3 |= 1 << i4;
                Number numberDoParse = nFRule.doParse(str, parsePosition, false, d, i3, i2 + 1);
                if (parsePosition.getIndex() > parsePosition2.getIndex()) {
                    parsePosition2.setIndex(parsePosition.getIndex());
                    number = numberDoParse;
                }
                if (parsePosition.getErrorIndex() > parsePosition2.getErrorIndex()) {
                    parsePosition2.setErrorIndex(parsePosition.getErrorIndex());
                }
                parsePosition.setIndex(0);
            }
            i4++;
        }
        Number number2 = number;
        for (int length = this.rules.length - 1; length >= 0 && parsePosition2.getIndex() < str.length(); length--) {
            if (this.isFractionRuleSet || this.rules[length].getBaseValue() < d) {
                Number numberDoParse2 = this.rules[length].doParse(str, parsePosition, this.isFractionRuleSet, d, i3, i2 + 1);
                if (parsePosition.getIndex() > parsePosition2.getIndex()) {
                    parsePosition2.setIndex(parsePosition.getIndex());
                    number2 = numberDoParse2;
                }
                if (parsePosition.getErrorIndex() > parsePosition2.getErrorIndex()) {
                    parsePosition2.setErrorIndex(parsePosition.getErrorIndex());
                }
                parsePosition.setIndex(0);
            }
        }
        parsePosition.setIndex(parsePosition2.getIndex());
        if (parsePosition.getIndex() == 0) {
            parsePosition.setErrorIndex(parsePosition2.getErrorIndex());
        }
        return number2;
    }

    public void parseRules(String str) {
        ArrayList arrayList = new ArrayList();
        int length = str.length();
        NFRule nFRule = null;
        int i = 0;
        int i2 = 0;
        do {
            int iIndexOf = str.indexOf(59, i2);
            if (iIndexOf < 0) {
                iIndexOf = length;
            }
            NFRule.makeRules(str.substring(i2, iIndexOf), this, nFRule, this.owner, arrayList);
            if (!arrayList.isEmpty()) {
                nFRule = (NFRule) arrayList.get(arrayList.size() - 1);
            }
            i2 = iIndexOf + 1;
        } while (i2 < length);
        int size = arrayList.size();
        long j = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            NFRule nFRule2 = (NFRule) obj;
            long baseValue = nFRule2.getBaseValue();
            if (baseValue == 0) {
                nFRule2.setBaseValue(j);
            } else {
                if (baseValue < j) {
                    throw new IllegalArgumentException("Rules are not in order, base: " + baseValue + " < " + j);
                }
                j = baseValue;
            }
            if (!this.isFractionRuleSet) {
                j++;
            }
        }
        NFRule[] nFRuleArr = new NFRule[arrayList.size()];
        this.rules = nFRuleArr;
        arrayList.toArray(nFRuleArr);
    }

    public void setDecimalFormatSymbols(DecimalFormatSymbols decimalFormatSymbols) {
        for (NFRule nFRule : this.rules) {
            nFRule.setDecimalFormatSymbols(decimalFormatSymbols);
        }
        if (this.fractionRules != null) {
            for (int i = 1; i <= 3; i++) {
                if (this.nonNumericalRules[i] != null) {
                    for (NFRule nFRule2 : this.fractionRules) {
                        if (this.nonNumericalRules[i].getBaseValue() == nFRule2.getBaseValue()) {
                            setBestFractionRule(i, nFRule2, false);
                        }
                    }
                }
            }
        }
        for (NFRule nFRule3 : this.nonNumericalRules) {
            if (nFRule3 != null) {
                nFRule3.setDecimalFormatSymbols(decimalFormatSymbols);
            }
        }
    }

    public void setNonNumericalRule(NFRule nFRule) {
        long baseValue = nFRule.getBaseValue();
        if (baseValue == -1) {
            this.nonNumericalRules[0] = nFRule;
            return;
        }
        if (baseValue == -2) {
            setBestFractionRule(1, nFRule, true);
            return;
        }
        if (baseValue == -3) {
            setBestFractionRule(2, nFRule, true);
            return;
        }
        if (baseValue == -4) {
            setBestFractionRule(3, nFRule, true);
        } else if (baseValue == -5) {
            this.nonNumericalRules[4] = nFRule;
        } else if (baseValue == -6) {
            this.nonNumericalRules[5] = nFRule;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name);
        sb.append(":\n");
        for (NFRule nFRule : this.rules) {
            sb.append(nFRule.toString());
            sb.append("\n");
        }
        for (NFRule nFRule2 : this.nonNumericalRules) {
            if (nFRule2 != null) {
                if (nFRule2.getBaseValue() == -2 || nFRule2.getBaseValue() == -3 || nFRule2.getBaseValue() == -4) {
                    for (NFRule nFRule3 : this.fractionRules) {
                        if (nFRule3.getBaseValue() == nFRule2.getBaseValue()) {
                            sb.append(nFRule3.toString());
                            sb.append("\n");
                        }
                    }
                } else {
                    sb.append(nFRule2.toString());
                    sb.append("\n");
                }
            }
        }
        return sb.toString();
    }

    public void format(double d, StringBuilder sb, int i, int i2) {
        if (i2 < 64) {
            findRule(d).doFormat(d, sb, i, i2 + 1);
        } else {
            og.n(cq.j("Recursion limit exceeded when applying ruleSet ", this.name));
        }
    }
}
