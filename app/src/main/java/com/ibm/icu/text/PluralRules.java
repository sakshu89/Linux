package com.ibm.icu.text;

import com.ibm.icu.impl.PluralRulesLoader;
import com.ibm.icu.impl.StandardPlural;
import com.ibm.icu.impl.number.DecimalQuantity;
import com.ibm.icu.impl.number.DecimalQuantity_DualStorageBCD;
import com.ibm.icu.impl.number.Padder;
import com.ibm.icu.impl.number.range.StandardPluralRanges;
import com.ibm.icu.number.FormattedNumber;
import com.ibm.icu.number.FormattedNumberRange;
import com.ibm.icu.util.Output;
import com.ibm.icu.util.ULocale;
import defpackage.cq;
import defpackage.dk0;
import defpackage.ky0;
import defpackage.og;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class PluralRules implements Serializable {
    static final Pattern AND_SEPARATED;
    static final Pattern AT_SEPARATED;
    private static final String CATEGORY_SEPARATOR = ";  ";
    static final Pattern COMMA_SEPARATED;
    public static final PluralRules DEFAULT;
    private static final Rule DEFAULT_RULE;
    static final Pattern DOTDOT_SEPARATED;
    public static final String KEYWORD_FEW = "few";
    public static final String KEYWORD_MANY = "many";
    public static final String KEYWORD_ONE = "one";
    public static final String KEYWORD_OTHER = "other";
    public static final String KEYWORD_TWO = "two";
    public static final String KEYWORD_ZERO = "zero";
    private static final Constraint NO_CONSTRAINT;
    public static final double NO_UNIQUE_VALUE = -0.00123456777d;
    static final Pattern OR_SEPARATED;
    static final Pattern SEMI_SEPARATED;
    static final Pattern TILDE_SEPARATED;
    private static final long serialVersionUID = 1;
    private final transient Set<String> keywords;
    private final RuleList rules;
    private final transient StandardPluralRanges standardPluralRanges;
    static final UnicodeSet ALLOWED_ID = new UnicodeSet("[a-z]").freeze();

    @Deprecated
    public static final DecimalQuantity NO_UNIQUE_VALUE_DECIMAL_QUANTITY = new DecimalQuantity_DualStorageBCD(-0.00123456777d);

    /* JADX INFO: renamed from: com.ibm.icu.text.PluralRules$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$ibm$icu$text$PluralRules$Operand;
        static final /* synthetic */ int[] $SwitchMap$com$ibm$icu$text$PluralRules$SampleType;

        static {
            int[] iArr = new int[SampleType.values().length];
            $SwitchMap$com$ibm$icu$text$PluralRules$SampleType = iArr;
            try {
                iArr[SampleType.INTEGER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ibm$icu$text$PluralRules$SampleType[SampleType.DECIMAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[Operand.values().length];
            $SwitchMap$com$ibm$icu$text$PluralRules$Operand = iArr2;
            try {
                iArr2[Operand.n.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$ibm$icu$text$PluralRules$Operand[Operand.i.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$ibm$icu$text$PluralRules$Operand[Operand.f.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$ibm$icu$text$PluralRules$Operand[Operand.t.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$ibm$icu$text$PluralRules$Operand[Operand.v.ordinal()] = 5;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$ibm$icu$text$PluralRules$Operand[Operand.w.ordinal()] = 6;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$ibm$icu$text$PluralRules$Operand[Operand.e.ordinal()] = 7;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$ibm$icu$text$PluralRules$Operand[Operand.c.ordinal()] = 8;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class AndConstraint extends BinaryConstraint {
        private static final long serialVersionUID = 7766999779862263523L;

        public AndConstraint(Constraint constraint, Constraint constraint2) {
            super(constraint, constraint2);
        }

        @Override // com.ibm.icu.text.PluralRules.Constraint
        public boolean isFulfilled(IFixedDecimal iFixedDecimal) {
            return this.a.isFulfilled(iFixedDecimal) && this.b.isFulfilled(iFixedDecimal);
        }

        @Override // com.ibm.icu.text.PluralRules.Constraint
        public boolean isLimited(SampleType sampleType) {
            return this.a.isLimited(sampleType) || this.b.isLimited(sampleType);
        }

        public String toString() {
            return cq.k(this.a.toString(), " and ", this.b.toString());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static abstract class BinaryConstraint implements Constraint, Serializable {
        private static final long serialVersionUID = 1;
        protected final Constraint a;
        protected final Constraint b;

        public BinaryConstraint(Constraint constraint, Constraint constraint2) {
            this.a = constraint;
            this.b = constraint2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public interface Constraint extends Serializable {
        boolean isFulfilled(IFixedDecimal iFixedDecimal);

        boolean isLimited(SampleType sampleType);
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    @Deprecated
    public static class DecimalQuantitySamplesRange {

        @Deprecated
        public final DecimalQuantity end;

        @Deprecated
        public final DecimalQuantity start;

        @Deprecated
        public DecimalQuantitySamplesRange(DecimalQuantity decimalQuantity, DecimalQuantity decimalQuantity2) {
            Operand operand = Operand.v;
            if (decimalQuantity.getPluralOperand(operand) != decimalQuantity2.getPluralOperand(operand)) {
                og.i(cq.l("Ranges must have the same number of visible decimals: ", String.valueOf(decimalQuantity), "~", String.valueOf(decimalQuantity2)));
                throw null;
            }
            this.start = decimalQuantity;
            this.end = decimalQuantity2;
        }

        @Deprecated
        public String toString() {
            String exponentString = this.start.toExponentString();
            DecimalQuantity decimalQuantity = this.end;
            return ky0.j(exponentString, decimalQuantity == this.start ? "" : cq.j("~", decimalQuantity.toExponentString()));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    @Deprecated
    public static abstract class Factory {
        @Deprecated
        public Factory() {
        }

        @Deprecated
        public static PluralRulesLoader getDefaultFactory() {
            return PluralRulesLoader.loader;
        }

        @Deprecated
        public final PluralRules forLocale(ULocale uLocale) {
            return forLocale(uLocale, PluralType.CARDINAL);
        }

        @Deprecated
        public abstract PluralRules forLocale(ULocale uLocale, PluralType pluralType);

        @Deprecated
        public abstract ULocale[] getAvailableULocales();

        @Deprecated
        public abstract ULocale getFunctionalEquivalent(ULocale uLocale, boolean[] zArr);

        @Deprecated
        public abstract boolean hasOverride(ULocale uLocale);
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    @Deprecated
    public interface IFixedDecimal {
        @Deprecated
        double getPluralOperand(Operand operand);

        @Deprecated
        boolean isHasIntegerValue();

        @Deprecated
        boolean isInfinite();

        @Deprecated
        boolean isNaN();
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public enum KeywordStatus {
        INVALID,
        SUPPRESSED,
        UNIQUE,
        BOUNDED,
        UNBOUNDED
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    @Deprecated
    public enum Operand {
        n,
        i,
        f,
        t,
        v,
        w,
        e,
        c,
        j
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class OrConstraint extends BinaryConstraint {
        private static final long serialVersionUID = 1405488568664762222L;

        public OrConstraint(Constraint constraint, Constraint constraint2) {
            super(constraint, constraint2);
        }

        @Override // com.ibm.icu.text.PluralRules.Constraint
        public boolean isFulfilled(IFixedDecimal iFixedDecimal) {
            return this.a.isFulfilled(iFixedDecimal) || this.b.isFulfilled(iFixedDecimal);
        }

        @Override // com.ibm.icu.text.PluralRules.Constraint
        public boolean isLimited(SampleType sampleType) {
            return this.a.isLimited(sampleType) && this.b.isLimited(sampleType);
        }

        public String toString() {
            return cq.k(this.a.toString(), " or ", this.b.toString());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public enum PluralType {
        CARDINAL,
        ORDINAL
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class RangeConstraint implements Constraint, Serializable {
        private static final long serialVersionUID = 1;
        private final boolean inRange;
        private final boolean integersOnly;
        private final double lowerBound;
        private final int mod;
        private final Operand operand;
        private final long[] range_list;
        private final double upperBound;

        public RangeConstraint(int i, boolean z, Operand operand, boolean z2, double d, double d2, long[] jArr) {
            this.mod = i;
            this.inRange = z;
            this.integersOnly = z2;
            this.lowerBound = d;
            this.upperBound = d2;
            this.range_list = jArr;
            this.operand = operand;
        }

        @Override // com.ibm.icu.text.PluralRules.Constraint
        public boolean isFulfilled(IFixedDecimal iFixedDecimal) {
            double pluralOperand = iFixedDecimal.getPluralOperand(this.operand);
            if ((this.integersOnly && pluralOperand - ((long) pluralOperand) != 0.0d) || (this.operand == Operand.j && iFixedDecimal.getPluralOperand(Operand.v) != 0.0d)) {
                return !this.inRange;
            }
            int i = this.mod;
            if (i != 0) {
                pluralOperand %= (double) i;
            }
            boolean z = pluralOperand >= this.lowerBound && pluralOperand <= this.upperBound;
            if (z && this.range_list != null) {
                z = false;
                int i2 = 0;
                while (!z) {
                    long[] jArr = this.range_list;
                    if (i2 >= jArr.length) {
                        break;
                    }
                    z = pluralOperand >= ((double) jArr[i2]) && pluralOperand <= ((double) jArr[i2 + 1]);
                    i2 += 2;
                }
            }
            return this.inRange == z;
        }

        @Override // com.ibm.icu.text.PluralRules.Constraint
        public boolean isLimited(SampleType sampleType) {
            Operand operand;
            Operand operand2;
            double d = this.lowerBound;
            boolean z = d == this.upperBound && d == 0.0d;
            Operand operand3 = this.operand;
            boolean z2 = (operand3 == Operand.v || operand3 == Operand.w || operand3 == Operand.f || operand3 == Operand.t) && this.inRange != z;
            int i = AnonymousClass2.$SwitchMap$com$ibm$icu$text$PluralRules$SampleType[sampleType.ordinal()];
            if (i == 1) {
                return z2 || (((operand = this.operand) == Operand.n || operand == Operand.i || operand == Operand.j) && this.mod == 0 && this.inRange);
            }
            if (i != 2) {
                return false;
            }
            return (!z2 || (operand2 = this.operand) == Operand.n || operand2 == Operand.j) && (this.integersOnly || this.lowerBound == this.upperBound) && this.mod == 0 && this.inRange;
        }

        /* JADX WARN: Code duplicated, block: B:10:0x002c  */
        public String toString() {
            double d;
            boolean z;
            StringBuilder sb = new StringBuilder();
            sb.append(this.operand);
            if (this.mod != 0) {
                sb.append(" % ");
                sb.append(this.mod);
            }
            String str = " != ";
            if (this.lowerBound != this.upperBound) {
                boolean z2 = this.integersOnly;
                boolean z3 = this.inRange;
                if (!z2) {
                    str = z3 ? " within " : " not within ";
                } else if (z3) {
                    str = " = ";
                }
            } else if (this.inRange) {
                str = " = ";
            }
            sb.append(str);
            if (this.range_list != null) {
                int i = 0;
                while (true) {
                    long[] jArr = this.range_list;
                    if (i >= jArr.length) {
                        break;
                    }
                    double d2 = jArr[i];
                    double d3 = jArr[i + 1];
                    if (i != 0) {
                        z = true;
                        d = d3;
                    } else {
                        d = d3;
                        z = false;
                    }
                    PluralRules.addRange(sb, d2, d, z);
                    i += 2;
                }
            } else {
                PluralRules.addRange(sb, this.lowerBound, this.upperBound, false);
            }
            return sb.toString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class Rule implements Serializable {
        private static final long serialVersionUID = 1;
        private final Constraint constraint;
        private final DecimalQuantitySamples decimalSamples;
        private final DecimalQuantitySamples integerSamples;
        private final String keyword;

        public Rule(String str, Constraint constraint, DecimalQuantitySamples decimalQuantitySamples, DecimalQuantitySamples decimalQuantitySamples2) {
            this.keyword = str;
            this.constraint = constraint;
            this.integerSamples = decimalQuantitySamples;
            this.decimalSamples = decimalQuantitySamples2;
        }

        public Rule and(Constraint constraint) {
            return new Rule(this.keyword, new AndConstraint(this.constraint, constraint), this.integerSamples, this.decimalSamples);
        }

        public boolean appliesTo(IFixedDecimal iFixedDecimal) {
            return this.constraint.isFulfilled(iFixedDecimal);
        }

        public String getConstraint() {
            return this.constraint.toString();
        }

        public String getKeyword() {
            return this.keyword;
        }

        public int hashCode() {
            return this.constraint.hashCode() ^ this.keyword.hashCode();
        }

        public boolean isLimited(SampleType sampleType) {
            return this.constraint.isLimited(sampleType);
        }

        public Rule or(Constraint constraint) {
            return new Rule(this.keyword, new OrConstraint(this.constraint, constraint), this.integerSamples, this.decimalSamples);
        }

        public String toString() {
            String str = this.keyword;
            String string = this.constraint.toString();
            DecimalQuantitySamples decimalQuantitySamples = this.integerSamples;
            String strJ = decimalQuantitySamples == null ? "" : cq.j(Padder.FALLBACK_PADDING_STRING, decimalQuantitySamples.toString());
            DecimalQuantitySamples decimalQuantitySamples2 = this.decimalSamples;
            return str + ": " + string + strJ + (decimalQuantitySamples2 != null ? cq.j(Padder.FALLBACK_PADDING_STRING, decimalQuantitySamples2.toString()) : "");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    @Deprecated
    public enum SampleType {
        INTEGER,
        DECIMAL
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class SimpleTokenizer {
        static final UnicodeSet BREAK_AND_IGNORE = new UnicodeSet(9, 10, 12, 13, 32, 32).freeze();
        static final UnicodeSet BREAK_AND_KEEP = new UnicodeSet(33, 33, 37, 37, 44, 44, 46, 46, 61, 61).freeze();

        public static String[] split(String str) {
            ArrayList arrayList = new ArrayList();
            int i = -1;
            for (int i2 = 0; i2 < str.length(); i2++) {
                char cCharAt = str.charAt(i2);
                if (BREAK_AND_IGNORE.contains(cCharAt)) {
                    if (i >= 0) {
                        arrayList.add(str.substring(i, i2));
                        i = -1;
                    }
                } else if (BREAK_AND_KEEP.contains(cCharAt)) {
                    if (i >= 0) {
                        arrayList.add(str.substring(i, i2));
                    }
                    arrayList.add(str.substring(i2, i2 + 1));
                    i = -1;
                } else if (i < 0) {
                    i = i2;
                }
            }
            if (i >= 0) {
                arrayList.add(str.substring(i));
            }
            return (String[]) arrayList.toArray(new String[arrayList.size()]);
        }
    }

    static {
        Constraint constraint = new Constraint() { // from class: com.ibm.icu.text.PluralRules.1
            private static final long serialVersionUID = 9163464945387899416L;

            @Override // com.ibm.icu.text.PluralRules.Constraint
            public boolean isFulfilled(IFixedDecimal iFixedDecimal) {
                return true;
            }

            @Override // com.ibm.icu.text.PluralRules.Constraint
            public boolean isLimited(SampleType sampleType) {
                return false;
            }

            public String toString() {
                return "";
            }
        };
        NO_CONSTRAINT = constraint;
        Rule rule = new Rule(KEYWORD_OTHER, constraint, null, null);
        DEFAULT_RULE = rule;
        DEFAULT = new PluralRules(new RuleList(0).addRule(rule), StandardPluralRanges.DEFAULT);
        AT_SEPARATED = Pattern.compile("\\s*\\Q\\E@\\s*");
        OR_SEPARATED = Pattern.compile("\\s*or\\s*");
        AND_SEPARATED = Pattern.compile("\\s*and\\s*");
        COMMA_SEPARATED = Pattern.compile("\\s*,\\s*");
        DOTDOT_SEPARATED = Pattern.compile("\\s*\\Q..\\E\\s*");
        TILDE_SEPARATED = Pattern.compile("\\s*~\\s*");
        SEMI_SEPARATED = Pattern.compile("\\s*;\\s*");
    }

    private PluralRules(RuleList ruleList, StandardPluralRanges standardPluralRanges) {
        this.rules = ruleList;
        this.keywords = Collections.unmodifiableSet(ruleList.getKeywords());
        this.standardPluralRanges = standardPluralRanges;
    }

    private boolean addConditional(Set<IFixedDecimal> set, Set<IFixedDecimal> set2, double d) {
        FixedDecimal fixedDecimal = new FixedDecimal(d);
        if (set.contains(fixedDecimal) || set2.contains(fixedDecimal)) {
            return false;
        }
        set2.add(fixedDecimal);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void addRange(StringBuilder sb, double d, double d2, boolean z) {
        if (z) {
            sb.append(",");
        }
        if (d == d2) {
            sb.append(format(d));
            return;
        }
        sb.append(format(d) + ".." + format(d2));
    }

    private boolean addSample(String str, DecimalQuantity decimalQuantity, int i, Set<DecimalQuantity> set) {
        if (!select(decimalQuantity).equals(str)) {
            return true;
        }
        set.add(decimalQuantity);
        return i + (-1) >= 0;
    }

    public static /* bridge */ /* synthetic */ Rule b() {
        return parseRule("other:");
    }

    public static PluralRules createRules(String str) {
        try {
            return parseDescription(str);
        } catch (Exception unused) {
            return null;
        }
    }

    public static PluralRules forLocale(ULocale uLocale) {
        return Factory.getDefaultFactory().forLocale(uLocale, PluralType.CARDINAL);
    }

    private static String format(double d) {
        long j = (long) d;
        return d == ((double) j) ? String.valueOf(j) : String.valueOf(d);
    }

    public static ULocale[] getAvailableULocales() {
        return Factory.getDefaultFactory().getAvailableULocales();
    }

    public static ULocale getFunctionalEquivalent(ULocale uLocale, boolean[] zArr) {
        return Factory.getDefaultFactory().getFunctionalEquivalent(uLocale, zArr);
    }

    private static boolean isValidKeyword(String str) {
        return ALLOWED_ID.containsAll(str);
    }

    @Deprecated
    public static PluralRules newInternal(String str, StandardPluralRanges standardPluralRanges) {
        String strTrim = str.trim();
        return strTrim.length() == 0 ? DEFAULT : new PluralRules(parseRuleChain(strTrim), standardPluralRanges);
    }

    private static String nextToken(String[] strArr, int i, String str) throws ParseException {
        if (i < strArr.length) {
            return strArr[i];
        }
        throw new ParseException(cq.v("missing token at end of '", str, "'"), -1);
    }

    /* JADX WARN: Code duplicated, block: B:101:0x01c8  */
    /* JADX WARN: Code duplicated, block: B:102:0x01cb  */
    /* JADX WARN: Code duplicated, block: B:104:0x01d4 A[LOOP:3: B:103:0x01d2->B:104:0x01d4, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:108:0x01e9 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:116:0x020a A[LOOP:2: B:63:0x0109->B:116:0x020a, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:141:0x0157 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:142:0x0152 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:143:0x0168 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:144:0x0225 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:146:0x0205 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:153:0x01b7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:47:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:49:0x00cc A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:56:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:65:0x0116  */
    /* JADX WARN: Code duplicated, block: B:67:0x0126  */
    /* JADX WARN: Code duplicated, block: B:69:0x0132  */
    /* JADX WARN: Code duplicated, block: B:71:0x013f  */
    /* JADX WARN: Code duplicated, block: B:73:0x014b  */
    /* JADX WARN: Code duplicated, block: B:79:0x015c  */
    /* JADX WARN: Code duplicated, block: B:81:0x0162  */
    /* JADX WARN: Code duplicated, block: B:85:0x016d  */
    /* JADX WARN: Code duplicated, block: B:88:0x0177  */
    /* JADX WARN: Code duplicated, block: B:90:0x017d  */
    /* JADX WARN: Code duplicated, block: B:99:0x01c1  */
    private static Constraint parseConstraint(String str) throws ParseException {
        int i;
        Constraint constraint;
        int i2;
        int i3;
        boolean z;
        int i4;
        String strNextToken;
        boolean zEquals;
        int i5;
        String strNextToken2;
        boolean z2;
        boolean z3;
        ArrayList arrayList;
        double d;
        double d2;
        Operand operand;
        long j;
        boolean z4;
        String str2;
        long j2;
        String str3;
        double dMin;
        double dMax;
        int size;
        long[] jArr;
        int i6;
        long[] jArr2;
        int i7;
        int i8;
        int i9;
        String strNextToken3;
        int i10;
        int i11 = 0;
        String[] strArrSplit = OR_SEPARATED.split(str, 0);
        int i12 = 0;
        Constraint orConstraint = null;
        while (i12 < strArrSplit.length) {
            String[] strArrSplit2 = AND_SEPARATED.split(strArrSplit[i12], i11);
            int i13 = i11;
            Constraint andConstraint = null;
            while (i13 < strArrSplit2.length) {
                Constraint rangeConstraint = NO_CONSTRAINT;
                String strTrim = strArrSplit2[i13].trim();
                String[] strArrSplit3 = SimpleTokenizer.split(strTrim);
                String str4 = strArrSplit3[i11];
                try {
                    Operand operand2 = FixedDecimal.getOperand(str4);
                    if (1 < strArrSplit3.length) {
                        String strNextToken4 = strArrSplit3[1];
                        if ("mod".equals(strNextToken4) || "%".equals(strNextToken4)) {
                            i2 = 4;
                            i3 = Integer.parseInt(strArrSplit3[2]);
                            strNextToken4 = nextToken(strArrSplit3, 3, strTrim);
                        } else {
                            i3 = i11;
                            i2 = 2;
                        }
                        if ("not".equals(strNextToken4)) {
                            i4 = i2 + 1;
                            String strNextToken5 = nextToken(strArrSplit3, i2, strTrim);
                            if ("=".equals(strNextToken5)) {
                                throw unexpected(strNextToken5, strTrim);
                            }
                            strNextToken = strNextToken5;
                        } else {
                            if ("!".equals(strNextToken4)) {
                                i4 = i2 + 1;
                                strNextToken = nextToken(strArrSplit3, i2, strTrim);
                                if (!"=".equals(strNextToken)) {
                                    throw unexpected(strNextToken, strTrim);
                                }
                            } else {
                                z = true;
                            }
                            if (!"is".equals(strNextToken4) || "in".equals(strNextToken4) || "=".equals(strNextToken4)) {
                                zEquals = "is".equals(strNextToken4);
                                if (!zEquals && !z) {
                                    throw unexpected(strNextToken4, strTrim);
                                }
                                i5 = i2 + 1;
                                strNextToken2 = nextToken(strArrSplit3, i2, strTrim);
                                z2 = true;
                            } else {
                                if (!"within".equals(strNextToken4)) {
                                    throw unexpected(strNextToken4, strTrim);
                                }
                                strNextToken2 = nextToken(strArrSplit3, i2, strTrim);
                                z2 = false;
                                i5 = i2 + 1;
                                zEquals = false;
                            }
                            if ("not".equals(strNextToken2)) {
                                if (zEquals && !z) {
                                    throw unexpected(strNextToken2, strTrim);
                                }
                                z = !z;
                                strNextToken2 = nextToken(strArrSplit3, i5, strTrim);
                                i5++;
                            }
                            z3 = z;
                            arrayList = new ArrayList();
                            d = 9.223372036854776E18d;
                            d2 = -9.223372036854776E18d;
                            operand = operand2;
                            while (true) {
                                j = Long.parseLong(strNextToken2);
                                z4 = zEquals;
                                i = i12;
                                str2 = ",";
                                if (i5 < strArrSplit3.length) {
                                    i7 = i5 + 1;
                                    strNextToken2 = nextToken(strArrSplit3, i5, strTrim);
                                    i8 = i5;
                                    if (strNextToken2.equals(".")) {
                                        i9 = i8 + 2;
                                        strNextToken3 = nextToken(strArrSplit3, i7, strTrim);
                                        if (strNextToken3.equals(".")) {
                                            throw unexpected(strNextToken3, strTrim);
                                        }
                                        i5 = i8 + 3;
                                        strNextToken2 = nextToken(strArrSplit3, i9, strTrim);
                                        long j3 = Long.parseLong(strNextToken2);
                                        if (i5 < strArrSplit3.length) {
                                            i10 = i8 + 4;
                                            strNextToken2 = nextToken(strArrSplit3, i5, strTrim);
                                            if (strNextToken2.equals(",")) {
                                                throw unexpected(strNextToken2, strTrim);
                                            }
                                            i5 = i10;
                                        }
                                        str2 = ",";
                                        orConstraint = orConstraint;
                                        j2 = j3;
                                    } else {
                                        if (strNextToken2.equals(",")) {
                                            throw unexpected(strNextToken2, strTrim);
                                        }
                                        i5 = i7;
                                    }
                                    if (j <= j2) {
                                        throw unexpected(j + "~" + j2, strTrim);
                                    }
                                    constraint = andConstraint;
                                    str3 = strNextToken2;
                                    if (i3 == 0 && j2 >= i3) {
                                        throw unexpected(j2 + ">mod=" + i3, strTrim);
                                    }
                                    arrayList.add(Long.valueOf(j));
                                    arrayList.add(Long.valueOf(j2));
                                    dMin = Math.min(d, j);
                                    dMax = Math.max(d2, j2);
                                    if (i5 >= strArrSplit3.length) {
                                        if (!str3.equals(str2)) {
                                            throw unexpected(str3, strTrim);
                                        }
                                        if (arrayList.size() == 2) {
                                            jArr2 = null;
                                        } else {
                                            size = arrayList.size();
                                            jArr = new long[size];
                                            for (i6 = 0; i6 < size; i6++) {
                                                jArr[i6] = ((Long) arrayList.get(i6)).longValue();
                                            }
                                            jArr2 = jArr;
                                        }
                                        if (dMin != dMax || !z4 || z3) {
                                            rangeConstraint = new RangeConstraint(i3, z3, operand, z2, dMin, dMax, jArr2);
                                            break;
                                        }
                                        throw unexpected("is not <range>", strTrim);
                                    }
                                    strNextToken2 = nextToken(strArrSplit3, i5, strTrim);
                                    i5++;
                                    d = dMin;
                                    andConstraint = constraint;
                                    operand = operand;
                                    d2 = dMax;
                                    i12 = i;
                                    orConstraint = orConstraint;
                                    zEquals = z4;
                                }
                                j2 = j;
                                if (j <= j2) {
                                    throw unexpected(j + "~" + j2, strTrim);
                                }
                                constraint = andConstraint;
                                str3 = strNextToken2;
                                if (i3 == 0) {
                                }
                                arrayList.add(Long.valueOf(j));
                                arrayList.add(Long.valueOf(j2));
                                dMin = Math.min(d, j);
                                dMax = Math.max(d2, j2);
                                if (i5 >= strArrSplit3.length) {
                                    if (!str3.equals(str2)) {
                                        throw unexpected(str3, strTrim);
                                    }
                                    if (arrayList.size() == 2) {
                                        jArr2 = null;
                                    } else {
                                        size = arrayList.size();
                                        jArr = new long[size];
                                        while (i6 < size) {
                                            jArr[i6] = ((Long) arrayList.get(i6)).longValue();
                                        }
                                        jArr2 = jArr;
                                    }
                                    if (dMin != dMax) {
                                    }
                                    rangeConstraint = new RangeConstraint(i3, z3, operand, z2, dMin, dMax, jArr2);
                                    break;
                                }
                                strNextToken2 = nextToken(strArrSplit3, i5, strTrim);
                                i5++;
                                d = dMin;
                                andConstraint = constraint;
                                operand = operand;
                                d2 = dMax;
                                i12 = i;
                                orConstraint = orConstraint;
                                zEquals = z4;
                            }
                        }
                        i2 = i4;
                        strNextToken4 = strNextToken;
                        z = false;
                        if ("is".equals(strNextToken4)) {
                            zEquals = "is".equals(strNextToken4);
                            if (!zEquals) {
                            }
                            i5 = i2 + 1;
                            strNextToken2 = nextToken(strArrSplit3, i2, strTrim);
                            z2 = true;
                        } else {
                            zEquals = "is".equals(strNextToken4);
                            if (!zEquals) {
                            }
                            i5 = i2 + 1;
                            strNextToken2 = nextToken(strArrSplit3, i2, strTrim);
                            z2 = true;
                        }
                        if ("not".equals(strNextToken2)) {
                            if (zEquals) {
                            }
                            z = !z;
                            strNextToken2 = nextToken(strArrSplit3, i5, strTrim);
                            i5++;
                        }
                        z3 = z;
                        arrayList = new ArrayList();
                        d = 9.223372036854776E18d;
                        d2 = -9.223372036854776E18d;
                        operand = operand2;
                        while (true) {
                            j = Long.parseLong(strNextToken2);
                            z4 = zEquals;
                            i = i12;
                            str2 = ",";
                            if (i5 < strArrSplit3.length) {
                                i7 = i5 + 1;
                                strNextToken2 = nextToken(strArrSplit3, i5, strTrim);
                                i8 = i5;
                                if (strNextToken2.equals(".")) {
                                    i9 = i8 + 2;
                                    strNextToken3 = nextToken(strArrSplit3, i7, strTrim);
                                    if (strNextToken3.equals(".")) {
                                        throw unexpected(strNextToken3, strTrim);
                                    }
                                    i5 = i8 + 3;
                                    strNextToken2 = nextToken(strArrSplit3, i9, strTrim);
                                    long j4 = Long.parseLong(strNextToken2);
                                    if (i5 < strArrSplit3.length) {
                                        i10 = i8 + 4;
                                        strNextToken2 = nextToken(strArrSplit3, i5, strTrim);
                                        if (strNextToken2.equals(",")) {
                                            throw unexpected(strNextToken2, strTrim);
                                        }
                                        i5 = i10;
                                    }
                                    str2 = ",";
                                    orConstraint = orConstraint;
                                    j2 = j4;
                                } else {
                                    if (strNextToken2.equals(",")) {
                                        throw unexpected(strNextToken2, strTrim);
                                    }
                                    i5 = i7;
                                }
                                if (j <= j2) {
                                    throw unexpected(j + "~" + j2, strTrim);
                                }
                                constraint = andConstraint;
                                str3 = strNextToken2;
                                if (i3 == 0) {
                                }
                                arrayList.add(Long.valueOf(j));
                                arrayList.add(Long.valueOf(j2));
                                dMin = Math.min(d, j);
                                dMax = Math.max(d2, j2);
                                if (i5 >= strArrSplit3.length) {
                                    if (!str3.equals(str2)) {
                                        throw unexpected(str3, strTrim);
                                    }
                                    if (arrayList.size() == 2) {
                                        jArr2 = null;
                                    } else {
                                        size = arrayList.size();
                                        jArr = new long[size];
                                        while (i6 < size) {
                                            jArr[i6] = ((Long) arrayList.get(i6)).longValue();
                                        }
                                        jArr2 = jArr;
                                    }
                                    if (dMin != dMax) {
                                    }
                                    rangeConstraint = new RangeConstraint(i3, z3, operand, z2, dMin, dMax, jArr2);
                                    break;
                                }
                                strNextToken2 = nextToken(strArrSplit3, i5, strTrim);
                                i5++;
                                d = dMin;
                                andConstraint = constraint;
                                operand = operand;
                                d2 = dMax;
                                i12 = i;
                                orConstraint = orConstraint;
                                zEquals = z4;
                            }
                            j2 = j;
                            if (j <= j2) {
                                throw unexpected(j + "~" + j2, strTrim);
                            }
                            constraint = andConstraint;
                            str3 = strNextToken2;
                            if (i3 == 0) {
                            }
                            arrayList.add(Long.valueOf(j));
                            arrayList.add(Long.valueOf(j2));
                            dMin = Math.min(d, j);
                            dMax = Math.max(d2, j2);
                            if (i5 >= strArrSplit3.length) {
                                if (!str3.equals(str2)) {
                                    throw unexpected(str3, strTrim);
                                }
                                if (arrayList.size() == 2) {
                                    jArr2 = null;
                                } else {
                                    size = arrayList.size();
                                    jArr = new long[size];
                                    while (i6 < size) {
                                        jArr[i6] = ((Long) arrayList.get(i6)).longValue();
                                    }
                                    jArr2 = jArr;
                                }
                                if (dMin != dMax) {
                                }
                                rangeConstraint = new RangeConstraint(i3, z3, operand, z2, dMin, dMax, jArr2);
                                break;
                            }
                            strNextToken2 = nextToken(strArrSplit3, i5, strTrim);
                            i5++;
                            d = dMin;
                            andConstraint = constraint;
                            operand = operand;
                            d2 = dMax;
                            i12 = i;
                            orConstraint = orConstraint;
                            zEquals = z4;
                        }
                    } else {
                        i = i12;
                        orConstraint = orConstraint;
                        constraint = andConstraint;
                    }
                    andConstraint = constraint == null ? rangeConstraint : new AndConstraint(constraint, rangeConstraint);
                    i13++;
                    orConstraint = orConstraint;
                    strArrSplit = strArrSplit;
                    strArrSplit2 = strArrSplit2;
                    i12 = i;
                    i11 = 0;
                } catch (Exception unused) {
                    throw unexpected(str4, strTrim);
                }
            }
            String[] strArr = strArrSplit;
            int i14 = i12;
            Constraint constraint2 = orConstraint;
            Constraint constraint3 = andConstraint;
            orConstraint = constraint2 == null ? constraint3 : new OrConstraint(constraint2, constraint3);
            i12 = i14 + 1;
            strArrSplit = strArr;
            i11 = 0;
        }
        return orConstraint;
    }

    public static PluralRules parseDescription(String str) {
        return newInternal(str, null);
    }

    private static Rule parseRule(String str) throws ParseException {
        DecimalQuantitySamples decimalQuantitySamples;
        DecimalQuantitySamples decimalQuantitySamples2;
        if (str.length() == 0) {
            return DEFAULT_RULE;
        }
        String lowerCase = str.toLowerCase(Locale.ENGLISH);
        int iIndexOf = lowerCase.indexOf(58);
        if (iIndexOf == -1) {
            throw new ParseException(cq.v("missing ':' in rule description '", lowerCase, "'"), 0);
        }
        String strTrim = lowerCase.substring(0, iIndexOf).trim();
        if (!isValidKeyword(strTrim)) {
            throw new ParseException(cq.v("keyword '", strTrim, " is not valid"), 0);
        }
        String strTrim2 = lowerCase.substring(iIndexOf + 1).trim();
        String[] strArrSplit = AT_SEPARATED.split(strTrim2, 0);
        int length = strArrSplit.length;
        if (length == 1) {
            decimalQuantitySamples = null;
            decimalQuantitySamples2 = null;
        } else if (length == 2) {
            decimalQuantitySamples = DecimalQuantitySamples.parse(strArrSplit[1]);
            if (decimalQuantitySamples.sampleType == SampleType.DECIMAL) {
                decimalQuantitySamples2 = decimalQuantitySamples;
                decimalQuantitySamples = null;
            } else {
                decimalQuantitySamples2 = null;
            }
        } else {
            if (length != 3) {
                og.i(cq.j("Too many samples in ", strTrim2));
                return null;
            }
            decimalQuantitySamples = DecimalQuantitySamples.parse(strArrSplit[1]);
            decimalQuantitySamples2 = DecimalQuantitySamples.parse(strArrSplit[2]);
            if (decimalQuantitySamples.sampleType != SampleType.INTEGER || decimalQuantitySamples2.sampleType != SampleType.DECIMAL) {
                og.i(cq.j("Must have @integer then @decimal in ", strTrim2));
                return null;
            }
        }
        boolean zEquals = strTrim.equals(KEYWORD_OTHER);
        if (zEquals == (strArrSplit[0].length() == 0)) {
            return new Rule(strTrim, zEquals ? NO_CONSTRAINT : parseConstraint(strArrSplit[0]), decimalQuantitySamples, decimalQuantitySamples2);
        }
        og.i("The keyword 'other' must have no constraints, just samples.");
        return null;
    }

    private static RuleList parseRuleChain(String str) throws ParseException {
        RuleList ruleList = new RuleList(0);
        if (str.endsWith(";")) {
            str = str.substring(0, str.length() - 1);
        }
        for (String str2 : SEMI_SEPARATED.split(str, 0)) {
            Rule rule = parseRule(str2.trim());
            ruleList.hasExplicitBoundingInfo |= (rule.integerSamples == null && rule.decimalSamples == null) ? false : true;
            ruleList.addRule(rule);
        }
        return ruleList.finish();
    }

    private void readObject(ObjectInputStream objectInputStream) throws NotSerializableException {
        throw new NotSerializableException();
    }

    private static ParseException unexpected(String str, String str2) {
        return new ParseException(ky0.l("unexpected token '", str, "' in '", str2, "'"), -1);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws NotSerializableException {
        throw new NotSerializableException();
    }

    private Object writeReplace() {
        return new PluralRulesSerialProxy(toString());
    }

    @Deprecated
    public int compareTo(PluralRules pluralRules) {
        return toString().compareTo(pluralRules.toString());
    }

    @Deprecated
    public boolean computeLimited(String str, SampleType sampleType) {
        return this.rules.computeLimited(str, sampleType);
    }

    public boolean equals(PluralRules pluralRules) {
        return pluralRules != null && toString().equals(pluralRules.toString());
    }

    @Deprecated
    public Collection<DecimalQuantity> getAllKeywordDecimalQuantityValues(String str) {
        return getAllKeywordValues(str, SampleType.INTEGER);
    }

    public Collection<Double> getAllKeywordValues(String str) {
        Collection<DecimalQuantity> allKeywordDecimalQuantityValues = getAllKeywordDecimalQuantityValues(str);
        if (allKeywordDecimalQuantityValues == null) {
            return null;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator<DecimalQuantity> it = allKeywordDecimalQuantityValues.iterator();
        while (it.hasNext()) {
            linkedHashSet.add(Double.valueOf(it.next().toDouble()));
        }
        return linkedHashSet;
    }

    @Deprecated
    public Collection<DecimalQuantity> getDecimalQuantitySamples(String str, SampleType sampleType) {
        if (!this.keywords.contains(str)) {
            return null;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (this.rules.hasExplicitBoundingInfo) {
            DecimalQuantitySamples decimalSamples = this.rules.getDecimalSamples(str, sampleType);
            return decimalSamples == null ? Collections.unmodifiableSet(linkedHashSet) : Collections.unmodifiableCollection(decimalSamples.addDecimalQuantitySamples(linkedHashSet));
        }
        int i = isLimited(str, sampleType) ? Integer.MAX_VALUE : 20;
        int i2 = AnonymousClass2.$SwitchMap$com$ibm$icu$text$PluralRules$SampleType[sampleType.ordinal()];
        int i3 = 0;
        if (i2 == 1) {
            while (i3 < 200 && addSample(str, new DecimalQuantity_DualStorageBCD(i3), i, linkedHashSet)) {
                i3++;
            }
            addSample(str, new DecimalQuantity_DualStorageBCD(1000000), i, linkedHashSet);
        } else if (i2 == 2) {
            while (i3 < 2000) {
                DecimalQuantity_DualStorageBCD decimalQuantity_DualStorageBCD = new DecimalQuantity_DualStorageBCD(i3);
                decimalQuantity_DualStorageBCD.adjustMagnitude(-1);
                if (!addSample(str, decimalQuantity_DualStorageBCD, i, linkedHashSet)) {
                    break;
                }
                i3++;
            }
            addSample(str, DecimalQuantity_DualStorageBCD.fromExponentString("1000000.0"), i, linkedHashSet);
        }
        if (linkedHashSet.size() == 0) {
            return null;
        }
        return Collections.unmodifiableSet(linkedHashSet);
    }

    @Deprecated
    public DecimalQuantitySamples getDecimalSamples(String str, SampleType sampleType) {
        return this.rules.getDecimalSamples(str, sampleType);
    }

    /* JADX WARN: Type inference failed for: r2v13, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v8, types: [T, java.lang.Object] */
    @Deprecated
    public KeywordStatus getKeywordStatus(String str, int i, Set<DecimalQuantity> set, Output<DecimalQuantity> output, SampleType sampleType) {
        if (output != null) {
            output.value = null;
        }
        if (!this.keywords.contains(str)) {
            return KeywordStatus.INVALID;
        }
        if (!isLimited(str, sampleType)) {
            return KeywordStatus.UNBOUNDED;
        }
        Collection<DecimalQuantity> decimalQuantitySamples = getDecimalQuantitySamples(str, sampleType);
        int size = decimalQuantitySamples.size();
        if (set == null) {
            set = Collections.EMPTY_SET;
        }
        if (size > set.size()) {
            if (size != 1) {
                return KeywordStatus.BOUNDED;
            }
            if (output != null) {
                output.value = decimalQuantitySamples.iterator().next();
            }
            return KeywordStatus.UNIQUE;
        }
        ArrayList arrayList = new ArrayList(decimalQuantitySamples);
        Iterator<DecimalQuantity> it = set.iterator();
        while (it.hasNext()) {
            arrayList.remove(new DecimalQuantity_DualStorageBCD(it.next().toBigDecimal().subtract(new BigDecimal(i))));
        }
        if (arrayList.size() == 0) {
            return KeywordStatus.SUPPRESSED;
        }
        if (output != null && arrayList.size() == 1) {
            output.value = arrayList.iterator().next();
        }
        return size == 1 ? KeywordStatus.UNIQUE : KeywordStatus.BOUNDED;
    }

    public Set<String> getKeywords() {
        return this.keywords;
    }

    @Deprecated
    public String getRules(String str) {
        return this.rules.getRules(str);
    }

    @Deprecated
    public Collection<Double> getSamples(String str, SampleType sampleType) {
        Collection<DecimalQuantity> decimalQuantitySamples = getDecimalQuantitySamples(str, sampleType);
        if (decimalQuantitySamples == null) {
            return null;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator<DecimalQuantity> it = decimalQuantitySamples.iterator();
        while (it.hasNext()) {
            linkedHashSet.add(Double.valueOf(it.next().toDouble()));
        }
        return linkedHashSet;
    }

    @Deprecated
    public DecimalQuantity getUniqueKeywordDecimalQuantityValue(String str) {
        Collection<DecimalQuantity> allKeywordDecimalQuantityValues = getAllKeywordDecimalQuantityValues(str);
        return (allKeywordDecimalQuantityValues == null || allKeywordDecimalQuantityValues.size() != 1) ? NO_UNIQUE_VALUE_DECIMAL_QUANTITY : allKeywordDecimalQuantityValues.iterator().next();
    }

    public double getUniqueKeywordValue(String str) {
        DecimalQuantity uniqueKeywordDecimalQuantityValue = getUniqueKeywordDecimalQuantityValue(str);
        if (uniqueKeywordDecimalQuantityValue.equals(NO_UNIQUE_VALUE_DECIMAL_QUANTITY)) {
            return -0.00123456777d;
        }
        return uniqueKeywordDecimalQuantityValue.toDouble();
    }

    public int hashCode() {
        return this.rules.hashCode();
    }

    public Boolean isLimited(String str) {
        return Boolean.valueOf(this.rules.isLimited(str, SampleType.INTEGER));
    }

    @Deprecated
    public boolean matches(FixedDecimal fixedDecimal, String str) {
        return this.rules.select(fixedDecimal, str);
    }

    public String select(FormattedNumberRange formattedNumberRange) {
        if (this.standardPluralRanges == null) {
            dk0.r("Plural ranges are unavailable on this instance");
            return null;
        }
        return this.standardPluralRanges.resolve(StandardPlural.fromString(select(formattedNumberRange.getFirstFixedDecimal())), StandardPlural.fromString(select(formattedNumberRange.getSecondFixedDecimal()))).getKeyword();
    }

    public String toString() {
        return this.rules.toString();
    }

    public static PluralRules forLocale(Locale locale) {
        return forLocale(ULocale.forLocale(locale));
    }

    public static PluralRules forLocale(ULocale uLocale, PluralType pluralType) {
        return Factory.getDefaultFactory().forLocale(uLocale, pluralType);
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class RuleList implements Serializable {
        private static final long serialVersionUID = 1;
        private boolean hasExplicitBoundingInfo;
        private final List<Rule> rules;

        private RuleList() {
            this.hasExplicitBoundingInfo = false;
            this.rules = new ArrayList();
        }

        private Rule selectRule(IFixedDecimal iFixedDecimal) {
            for (Rule rule : this.rules) {
                if (rule.appliesTo(iFixedDecimal)) {
                    return rule;
                }
            }
            return null;
        }

        public RuleList addRule(Rule rule) {
            String keyword = rule.getKeyword();
            Iterator<Rule> it = this.rules.iterator();
            while (it.hasNext()) {
                if (keyword.equals(it.next().getKeyword())) {
                    og.i("Duplicate keyword: ".concat(keyword));
                    return null;
                }
            }
            this.rules.add(rule);
            return this;
        }

        public boolean computeLimited(String str, SampleType sampleType) {
            boolean z = false;
            for (Rule rule : this.rules) {
                if (str.equals(rule.getKeyword())) {
                    if (!rule.isLimited(sampleType)) {
                        return false;
                    }
                    z = true;
                }
            }
            return z;
        }

        public RuleList finish() {
            Iterator<Rule> it = this.rules.iterator();
            Rule ruleB = null;
            while (it.hasNext()) {
                Rule next = it.next();
                if (PluralRules.KEYWORD_OTHER.equals(next.getKeyword())) {
                    it.remove();
                    ruleB = next;
                }
            }
            if (ruleB == null) {
                ruleB = PluralRules.b();
            }
            this.rules.add(ruleB);
            return this;
        }

        public DecimalQuantitySamples getDecimalSamples(String str, SampleType sampleType) {
            for (Rule rule : this.rules) {
                if (rule.getKeyword().equals(str)) {
                    return sampleType == SampleType.INTEGER ? rule.integerSamples : rule.decimalSamples;
                }
            }
            return null;
        }

        public Set<String> getKeywords() {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            Iterator<Rule> it = this.rules.iterator();
            while (it.hasNext()) {
                linkedHashSet.add(it.next().getKeyword());
            }
            return linkedHashSet;
        }

        public String getRules(String str) {
            for (Rule rule : this.rules) {
                if (rule.getKeyword().equals(str)) {
                    return rule.getConstraint();
                }
            }
            return null;
        }

        public boolean isLimited(String str, SampleType sampleType) {
            if (!this.hasExplicitBoundingInfo) {
                return computeLimited(str, sampleType);
            }
            DecimalQuantitySamples decimalSamples = getDecimalSamples(str, sampleType);
            if (decimalSamples == null) {
                return true;
            }
            return decimalSamples.bounded;
        }

        public boolean select(IFixedDecimal iFixedDecimal, String str) {
            for (Rule rule : this.rules) {
                if (rule.getKeyword().equals(str) && rule.appliesTo(iFixedDecimal)) {
                    return true;
                }
            }
            return false;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (Rule rule : this.rules) {
                if (sb.length() != 0) {
                    sb.append(PluralRules.CATEGORY_SEPARATOR);
                }
                sb.append(rule);
            }
            return sb.toString();
        }

        public /* synthetic */ RuleList(int i) {
            this();
        }

        public String select(IFixedDecimal iFixedDecimal) {
            if (!iFixedDecimal.isInfinite() && !iFixedDecimal.isNaN()) {
                return selectRule(iFixedDecimal).getKeyword();
            }
            return PluralRules.KEYWORD_OTHER;
        }
    }

    public static PluralRules forLocale(Locale locale, PluralType pluralType) {
        return forLocale(ULocale.forLocale(locale), pluralType);
    }

    @Deprecated
    public boolean isLimited(String str, SampleType sampleType) {
        return this.rules.isLimited(str, sampleType);
    }

    public boolean equals(Object obj) {
        return (obj instanceof PluralRules) && equals((PluralRules) obj);
    }

    @Deprecated
    public Collection<DecimalQuantity> getAllKeywordValues(String str, SampleType sampleType) {
        if (isLimited(str, sampleType)) {
            return getDecimalQuantitySamples(str, sampleType);
        }
        return null;
    }

    public Collection<Double> getSamples(String str) {
        return getSamples(str, SampleType.INTEGER);
    }

    public String select(FormattedNumber formattedNumber) {
        return this.rules.select(formattedNumber.getFixedDecimal());
    }

    public String select(double d) {
        return this.rules.select(new FixedDecimal(d));
    }

    @Deprecated
    public String select(double d, int i, long j) {
        return this.rules.select(new FixedDecimal(d, i, j));
    }

    @Deprecated
    public String select(IFixedDecimal iFixedDecimal) {
        return this.rules.select(iFixedDecimal);
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    @Deprecated
    public static class FixedDecimal extends Number implements Comparable<FixedDecimal>, IFixedDecimal {
        static final long MAX = 1000000000000000000L;
        private static final long MAX_INTEGER_PART = 1000000000;
        private static final long serialVersionUID = -4756200506571685661L;
        private final int baseFactor;
        final long decimalDigits;
        final long decimalDigitsWithoutTrailingZeros;
        final int exponent;
        final boolean hasIntegerValue;
        final long integerValue;
        final boolean isNegative;
        final double source;
        final int visibleDecimalDigitCount;
        final int visibleDecimalDigitCountWithoutTrailingZeros;

        @Deprecated
        public FixedDecimal(double d, int i, long j, int i2, int i3) {
            boolean z = d < 0.0d;
            this.isNegative = z;
            double d2 = z ? -d : d;
            this.source = d2;
            this.visibleDecimalDigitCount = i;
            this.decimalDigits = j;
            long j2 = d > 1.0E18d ? MAX : (long) d2;
            this.integerValue = j2;
            this.exponent = i2 == 0 ? i3 : i2;
            this.hasIntegerValue = d2 == ((double) j2);
            if (j == 0) {
                this.decimalDigitsWithoutTrailingZeros = 0L;
                this.visibleDecimalDigitCountWithoutTrailingZeros = 0;
            } else {
                int i4 = i;
                while (j % 10 == 0) {
                    j /= 10;
                    i4--;
                }
                this.decimalDigitsWithoutTrailingZeros = j;
                this.visibleDecimalDigitCountWithoutTrailingZeros = i4;
            }
            this.baseFactor = (int) Math.pow(10.0d, i);
        }

        @Deprecated
        public static FixedDecimal createWithExponent(double d, int i, int i2) {
            return new FixedDecimal(d, i, getFractionalDigits(d, i), i2);
        }

        @Deprecated
        public static int decimals(double d) {
            if (Double.isInfinite(d) || Double.isNaN(d)) {
                return 0;
            }
            if (d < 0.0d) {
                d = -d;
            }
            if (d == Math.floor(d)) {
                return 0;
            }
            if (d < 1.0E9d) {
                long j = ((long) (d * 1000000.0d)) % 1000000;
                int i = 10;
                for (int i2 = 6; i2 > 0; i2--) {
                    if (j % ((long) i) != 0) {
                        return i2;
                    }
                    i *= 10;
                }
                return 0;
            }
            String str = String.format(Locale.ENGLISH, "%1.15e", Double.valueOf(d));
            int iLastIndexOf = str.lastIndexOf(101);
            int i3 = iLastIndexOf + 1;
            if (str.charAt(i3) == '+') {
                i3 = iLastIndexOf + 2;
            }
            int i4 = (iLastIndexOf - 2) - Integer.parseInt(str.substring(i3));
            if (i4 < 0) {
                return 0;
            }
            for (int i5 = iLastIndexOf - 1; i4 > 0 && str.charAt(i5) == '0'; i5--) {
                i4--;
            }
            return i4;
        }

        private static int getFractionalDigits(double d, int i) {
            if (i == 0) {
                return 0;
            }
            if (d < 0.0d) {
                d = -d;
            }
            int iPow = (int) Math.pow(10.0d, i);
            return (int) (Math.round(d * ((double) iPow)) % ((long) iPow));
        }

        @Deprecated
        public static Operand getOperand(String str) {
            return Operand.valueOf(str);
        }

        private void readObject(ObjectInputStream objectInputStream) throws NotSerializableException {
            throw new NotSerializableException();
        }

        private void writeObject(ObjectOutputStream objectOutputStream) throws NotSerializableException {
            throw new NotSerializableException();
        }

        @Override // java.lang.Comparable
        @Deprecated
        public int compareTo(FixedDecimal fixedDecimal) {
            if (this.exponent != fixedDecimal.exponent) {
                return doubleValue() < fixedDecimal.doubleValue() ? -1 : 1;
            }
            long j = this.integerValue;
            long j2 = fixedDecimal.integerValue;
            if (j != j2) {
                return j < j2 ? -1 : 1;
            }
            double d = this.source;
            double d2 = fixedDecimal.source;
            if (d != d2) {
                return d < d2 ? -1 : 1;
            }
            int i = this.visibleDecimalDigitCount;
            int i2 = fixedDecimal.visibleDecimalDigitCount;
            if (i != i2) {
                return i < i2 ? -1 : 1;
            }
            long j3 = this.decimalDigits - fixedDecimal.decimalDigits;
            if (j3 != 0) {
                return j3 < 0 ? -1 : 1;
            }
            return 0;
        }

        @Override // java.lang.Number
        @Deprecated
        public double doubleValue() {
            boolean z = this.isNegative;
            double d = this.source;
            if (z) {
                d = -d;
            }
            return Math.pow(10.0d, this.exponent) * d;
        }

        @Deprecated
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof FixedDecimal)) {
                return false;
            }
            FixedDecimal fixedDecimal = (FixedDecimal) obj;
            return this.source == fixedDecimal.source && this.visibleDecimalDigitCount == fixedDecimal.visibleDecimalDigitCount && this.decimalDigits == fixedDecimal.decimalDigits && this.exponent == fixedDecimal.exponent;
        }

        @Override // java.lang.Number
        @Deprecated
        public float floatValue() {
            return (float) (Math.pow(10.0d, this.exponent) * this.source);
        }

        @Deprecated
        public int getBaseFactor() {
            return this.baseFactor;
        }

        @Deprecated
        public long getDecimalDigits() {
            return this.decimalDigits;
        }

        @Deprecated
        public long getDecimalDigitsWithoutTrailingZeros() {
            return this.decimalDigitsWithoutTrailingZeros;
        }

        @Deprecated
        public long getIntegerValue() {
            return this.integerValue;
        }

        @Override // com.ibm.icu.text.PluralRules.IFixedDecimal
        @Deprecated
        public double getPluralOperand(Operand operand) {
            switch (AnonymousClass2.$SwitchMap$com$ibm$icu$text$PluralRules$Operand[operand.ordinal()]) {
                case 1:
                    int i = this.exponent;
                    double d = this.source;
                    return i == 0 ? d : Math.pow(10.0d, i) * d;
                case 2:
                    return intValue();
                case 3:
                    return this.decimalDigits;
                case 4:
                    return this.decimalDigitsWithoutTrailingZeros;
                case 5:
                    return this.visibleDecimalDigitCount;
                case 6:
                    return this.visibleDecimalDigitCountWithoutTrailingZeros;
                case 7:
                    return this.exponent;
                case 8:
                    return this.exponent;
                default:
                    return doubleValue();
            }
        }

        @Deprecated
        public double getSource() {
            return this.source;
        }

        @Deprecated
        public int getVisibleDecimalDigitCount() {
            return this.visibleDecimalDigitCount;
        }

        @Deprecated
        public int getVisibleDecimalDigitCountWithoutTrailingZeros() {
            return this.visibleDecimalDigitCountWithoutTrailingZeros;
        }

        @Deprecated
        public boolean hasIntegerValue() {
            return this.hasIntegerValue;
        }

        @Deprecated
        public int hashCode() {
            return (int) (this.decimalDigits + ((long) ((this.visibleDecimalDigitCount + ((int) (this.source * 37.0d))) * 37)));
        }

        @Override // java.lang.Number
        @Deprecated
        public int intValue() {
            return (int) longValue();
        }

        @Override // com.ibm.icu.text.PluralRules.IFixedDecimal
        @Deprecated
        public boolean isHasIntegerValue() {
            return this.hasIntegerValue;
        }

        @Override // com.ibm.icu.text.PluralRules.IFixedDecimal
        @Deprecated
        public boolean isInfinite() {
            return Double.isInfinite(this.source);
        }

        @Override // com.ibm.icu.text.PluralRules.IFixedDecimal
        @Deprecated
        public boolean isNaN() {
            return Double.isNaN(this.source);
        }

        @Deprecated
        public boolean isNegative() {
            return this.isNegative;
        }

        @Override // java.lang.Number
        @Deprecated
        public long longValue() {
            int i = this.exponent;
            return i == 0 ? this.integerValue : (long) (Math.pow(10.0d, i) * this.integerValue);
        }

        @Deprecated
        public String toString() {
            String str = String.format(Locale.ROOT, cq.h("%.", this.visibleDecimalDigitCount, "f"), Double.valueOf(this.source));
            int i = this.exponent;
            if (i == 0) {
                return str;
            }
            return str + "e" + i;
        }

        @Deprecated
        public FixedDecimal(double d, int i, long j, int i2) {
            this(d, i, j, i2, i2);
        }

        @Deprecated
        public FixedDecimal(double d, int i, long j) {
            this(d, i, j, 0);
        }

        @Deprecated
        public FixedDecimal(double d, int i) {
            this(d, i, getFractionalDigits(d, i));
        }

        @Deprecated
        public FixedDecimal(double d) {
            this(d, decimals(d));
        }

        @Deprecated
        public FixedDecimal(long j) {
            this(j, 0);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    @Deprecated
    public static class DecimalQuantitySamples {

        @Deprecated
        public final boolean bounded;

        @Deprecated
        public final SampleType sampleType;

        @Deprecated
        public final Set<DecimalQuantitySamplesRange> samples;

        private DecimalQuantitySamples(SampleType sampleType, Set<DecimalQuantitySamplesRange> set, boolean z) {
            this.sampleType = sampleType;
            this.samples = set;
            this.bounded = z;
        }

        private static void checkDecimal(SampleType sampleType, DecimalQuantity decimalQuantity) {
            if ((sampleType != SampleType.INTEGER || decimalQuantity.getPluralOperand(Operand.v) == 0.0d) && !(sampleType == SampleType.DECIMAL && decimalQuantity.getPluralOperand(Operand.v) == 0.0d && decimalQuantity.getPluralOperand(Operand.e) == 0.0d)) {
                return;
            }
            og.i("Ill-formed number range: ".concat(String.valueOf(decimalQuantity)));
        }

        public static DecimalQuantitySamples parse(String str) {
            SampleType sampleType;
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            if (str.startsWith("integer")) {
                sampleType = SampleType.INTEGER;
            } else {
                if (!str.startsWith("decimal")) {
                    og.i("Samples must start with 'integer' or 'decimal'");
                    return null;
                }
                sampleType = SampleType.DECIMAL;
            }
            boolean z = false;
            boolean z2 = true;
            for (String str2 : PluralRules.COMMA_SEPARATED.split(str.substring(7).trim(), 0)) {
                if (str2.equals("…") || str2.equals("...")) {
                    z2 = false;
                    z = true;
                } else {
                    if (z) {
                        og.i("Can only have … at the end of samples: ".concat(str2));
                        return null;
                    }
                    String[] strArrSplit = PluralRules.TILDE_SEPARATED.split(str2, 0);
                    int length = strArrSplit.length;
                    if (length == 1) {
                        DecimalQuantity decimalQuantityFromExponentString = DecimalQuantity_DualStorageBCD.fromExponentString(strArrSplit[0]);
                        checkDecimal(sampleType, decimalQuantityFromExponentString);
                        linkedHashSet.add(new DecimalQuantitySamplesRange(decimalQuantityFromExponentString, decimalQuantityFromExponentString));
                    } else {
                        if (length != 2) {
                            og.i("Ill-formed number range: ".concat(str2));
                            return null;
                        }
                        DecimalQuantity decimalQuantityFromExponentString2 = DecimalQuantity_DualStorageBCD.fromExponentString(strArrSplit[0]);
                        DecimalQuantity decimalQuantityFromExponentString3 = DecimalQuantity_DualStorageBCD.fromExponentString(strArrSplit[1]);
                        checkDecimal(sampleType, decimalQuantityFromExponentString2);
                        checkDecimal(sampleType, decimalQuantityFromExponentString3);
                        linkedHashSet.add(new DecimalQuantitySamplesRange(decimalQuantityFromExponentString2, decimalQuantityFromExponentString3));
                    }
                }
            }
            return new DecimalQuantitySamples(sampleType, Collections.unmodifiableSet(linkedHashSet), z2);
        }

        @Deprecated
        public Collection<DecimalQuantity> addDecimalQuantitySamples(Collection<DecimalQuantity> collection) {
            addSamples(null, collection);
            return collection;
        }

        @Deprecated
        public void addSamples(Collection<Double> collection, Collection<DecimalQuantity> collection2) {
            if (collection == null && collection2 == null) {
                return;
            }
            if (collection == null || collection2 == null) {
                boolean z = collection != null;
                for (DecimalQuantitySamplesRange decimalQuantitySamplesRange : this.samples) {
                    DecimalQuantity decimalQuantity = decimalQuantitySamplesRange.start;
                    DecimalQuantity decimalQuantity2 = decimalQuantitySamplesRange.end;
                    int lowerDisplayMagnitude = decimalQuantity.getLowerDisplayMagnitude();
                    int exponent = decimalQuantity.getExponent();
                    BigDecimal bigDecimalMovePointRight = BigDecimal.ONE.movePointRight(lowerDisplayMagnitude + exponent);
                    DecimalQuantity decimalQuantityCreateCopy = decimalQuantity.createCopy();
                    while (decimalQuantityCreateCopy.toDouble() <= decimalQuantity2.toDouble()) {
                        if (z) {
                            double d = decimalQuantityCreateCopy.toDouble();
                            if (d != Math.floor(d) && decimalQuantityCreateCopy.getPluralOperand(Operand.v) > 0.0d) {
                                collection.add(Double.valueOf(d));
                            }
                        } else {
                            collection2.add(decimalQuantityCreateCopy);
                        }
                        DecimalQuantity_DualStorageBCD decimalQuantity_DualStorageBCD = new DecimalQuantity_DualStorageBCD(decimalQuantityCreateCopy.toBigDecimal().add(bigDecimalMovePointRight));
                        decimalQuantity_DualStorageBCD.setMinFraction(-lowerDisplayMagnitude);
                        decimalQuantity_DualStorageBCD.adjustMagnitude(-exponent);
                        decimalQuantity_DualStorageBCD.adjustExponent(exponent);
                        decimalQuantityCreateCopy = decimalQuantity_DualStorageBCD;
                    }
                }
            }
        }

        @Deprecated
        public Set<DecimalQuantitySamplesRange> getSamples() {
            return this.samples;
        }

        @Deprecated
        public void getStartEndSamples(Set<DecimalQuantity> set) {
            for (DecimalQuantitySamplesRange decimalQuantitySamplesRange : this.samples) {
                set.add(decimalQuantitySamplesRange.start);
                set.add(decimalQuantitySamplesRange.end);
            }
        }

        @Deprecated
        public String toString() {
            StringBuilder sb = new StringBuilder("@");
            sb.append(this.sampleType.toString().toLowerCase(Locale.ENGLISH));
            boolean z = true;
            for (DecimalQuantitySamplesRange decimalQuantitySamplesRange : this.samples) {
                if (z) {
                    z = false;
                } else {
                    sb.append(",");
                }
                sb.append(' ');
                sb.append(decimalQuantitySamplesRange);
            }
            if (!this.bounded) {
                sb.append(", …");
            }
            return sb.toString();
        }

        @Deprecated
        public Collection<Double> addSamples(Collection<Double> collection) {
            addSamples(collection, null);
            return collection;
        }
    }

    public KeywordStatus getKeywordStatus(String str, int i, Set<DecimalQuantity> set, Output<DecimalQuantity> output) {
        return getKeywordStatus(str, i, set, output, SampleType.INTEGER);
    }

    @Deprecated
    public Collection<DecimalQuantity> getDecimalQuantitySamples(String str) {
        return getDecimalQuantitySamples(str, SampleType.INTEGER);
    }
}
