package com.ibm.icu.impl.units;

import com.ibm.icu.impl.locale.LanguageTag;
import com.ibm.icu.util.BytesTrie;
import com.ibm.icu.util.CharsTrie;
import com.ibm.icu.util.CharsTrieBuilder;
import com.ibm.icu.util.ICUCloneNotSupportedException;
import com.ibm.icu.util.MeasureUnit;
import com.ibm.icu.util.StringTrieBuilder;
import defpackage.cq;
import defpackage.dk0;
import defpackage.ky0;
import defpackage.og;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class MeasureUnitImpl {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private MeasureUnit.Complexity complexity;
    private long constantDenominator;
    private String identifier;
    private final ArrayList<SingleUnitImpl> singleUnits;

    /* JADX INFO: renamed from: com.ibm.icu.impl.units.MeasureUnitImpl$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ibm$icu$impl$units$MeasureUnitImpl$CompoundPart;
        static final /* synthetic */ int[] $SwitchMap$com$ibm$icu$impl$units$MeasureUnitImpl$UnitsParser$Token$Type;

        static {
            int[] iArr = new int[UnitsParser.Token.Type.values().length];
            $SwitchMap$com$ibm$icu$impl$units$MeasureUnitImpl$UnitsParser$Token$Type = iArr;
            try {
                iArr[UnitsParser.Token.Type.TYPE_POWER_PART.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ibm$icu$impl$units$MeasureUnitImpl$UnitsParser$Token$Type[UnitsParser.Token.Type.TYPE_PREFIX.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$ibm$icu$impl$units$MeasureUnitImpl$UnitsParser$Token$Type[UnitsParser.Token.Type.TYPE_SIMPLE_UNIT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$ibm$icu$impl$units$MeasureUnitImpl$UnitsParser$Token$Type[UnitsParser.Token.Type.TYPE_ALIAS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[CompoundPart.values().length];
            $SwitchMap$com$ibm$icu$impl$units$MeasureUnitImpl$CompoundPart = iArr2;
            try {
                iArr2[CompoundPart.PER.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$ibm$icu$impl$units$MeasureUnitImpl$CompoundPart[CompoundPart.TIMES.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$ibm$icu$impl$units$MeasureUnitImpl$CompoundPart[CompoundPart.AND.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public enum CompoundPart {
        PER(0),
        TIMES(1),
        AND(2);

        private final int index;

        CompoundPart(int i) {
            this.index = i;
        }

        public static CompoundPart getCompoundPartFromTrieIndex(int i) {
            int i2 = i - 128;
            if (i2 == 0) {
                return PER;
            }
            if (i2 == 1) {
                return TIMES;
            }
            if (i2 == 2) {
                return AND;
            }
            og.m("CompoundPart index must be 0, 1 or 2");
            return null;
        }

        public int getTrieIndex() {
            return this.index + 128;
        }

        public int getValue() {
            return this.index;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public enum InitialCompoundPart {
        INITIAL_COMPOUND_PART_PER(0);

        private final int index;

        InitialCompoundPart(int i) {
            this.index = i;
        }

        public static InitialCompoundPart getInitialCompoundPartFromTrieIndex(int i) {
            if (i - 192 == 0) {
                return INITIAL_COMPOUND_PART_PER;
            }
            og.i("Incorrect trieIndex");
            return null;
        }

        public int getTrieIndex() {
            return this.index + 192;
        }

        public int getValue() {
            return this.index;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class MeasureUnitImplComparator implements Comparator<MeasureUnitImpl> {
        private final ConversionRates conversionRates;

        public MeasureUnitImplComparator(ConversionRates conversionRates) {
            this.conversionRates = conversionRates;
        }

        @Override // java.util.Comparator
        public int compare(MeasureUnitImpl measureUnitImpl, MeasureUnitImpl measureUnitImpl2) {
            String specialMappingName = this.conversionRates.getSpecialMappingName(measureUnitImpl);
            String specialMappingName2 = this.conversionRates.getSpecialMappingName(measureUnitImpl2);
            if (specialMappingName == null && specialMappingName2 == null) {
                return this.conversionRates.getFactorToBase(measureUnitImpl).getConversionRate().compareTo(this.conversionRates.getFactorToBase(measureUnitImpl2).getConversionRate());
            }
            if (specialMappingName == null) {
                return -1;
            }
            if (specialMappingName2 == null) {
                return 1;
            }
            return specialMappingName.compareTo(specialMappingName2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class MeasureUnitImplWithIndex {
        int index;
        MeasureUnitImpl unitImpl;

        public MeasureUnitImplWithIndex(int i, MeasureUnitImpl measureUnitImpl) {
            this.index = i;
            this.unitImpl = measureUnitImpl;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class MeasureUnitImplWithIndexComparator implements Comparator<MeasureUnitImplWithIndex> {
        private MeasureUnitImplComparator measureUnitImplComparator;

        public MeasureUnitImplWithIndexComparator(ConversionRates conversionRates) {
            this.measureUnitImplComparator = new MeasureUnitImplComparator(conversionRates);
        }

        @Override // java.util.Comparator
        public int compare(MeasureUnitImplWithIndex measureUnitImplWithIndex, MeasureUnitImplWithIndex measureUnitImplWithIndex2) {
            return this.measureUnitImplComparator.compare(measureUnitImplWithIndex.unitImpl, measureUnitImplWithIndex2.unitImpl);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public enum PowerPart {
        P2(2),
        P3(3),
        P4(4),
        P5(5),
        P6(6),
        P7(7),
        P8(8),
        P9(9),
        P10(10),
        P11(11),
        P12(12),
        P13(13),
        P14(14),
        P15(15);

        private final int power;

        PowerPart(int i) {
            this.power = i;
        }

        public static int getPowerFromTrieIndex(int i) {
            return i - 256;
        }

        public int getTrieIndex() {
            return this.power + 256;
        }

        public int getValue() {
            return this.power;
        }
    }

    public MeasureUnitImpl() {
        this.identifier = null;
        this.complexity = MeasureUnit.Complexity.SINGLE;
        this.constantDenominator = 0L;
        this.singleUnits = new ArrayList<>();
    }

    private int countCharacter(String str, char c) {
        int i = 0;
        for (int i2 = 0; i2 < str.length(); i2++) {
            if (str.charAt(i2) == c) {
                i++;
            }
        }
        return i;
    }

    public static MeasureUnitImpl forCurrencyCode(String str) {
        MeasureUnitImpl measureUnitImpl = new MeasureUnitImpl();
        measureUnitImpl.identifier = str;
        return measureUnitImpl;
    }

    public static MeasureUnitImpl forIdentifier(String str) {
        return UnitsParser.parseForIdentifier(str);
    }

    private String getConstantsString(long j) {
        int iCountCharacter;
        StringBuilder sb = new StringBuilder();
        sb.append(j);
        String string = sb.toString();
        return (j > 1000 && (iCountCharacter = countCharacter(string, '0')) == string.length() + (-1) && string.charAt(0) == '1') ? ky0.h(iCountCharacter, "1e") : string;
    }

    public boolean appendSingleUnit(SingleUnitImpl singleUnitImpl) {
        SingleUnitImpl singleUnitImpl2 = null;
        this.identifier = null;
        if (singleUnitImpl == null) {
            return false;
        }
        ArrayList<SingleUnitImpl> arrayList = this.singleUnits;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            SingleUnitImpl singleUnitImpl3 = arrayList.get(i);
            i++;
            SingleUnitImpl singleUnitImpl4 = singleUnitImpl3;
            if (singleUnitImpl4.isCompatibleWith(singleUnitImpl)) {
                singleUnitImpl2 = singleUnitImpl4;
                break;
            }
        }
        if (singleUnitImpl2 != null) {
            singleUnitImpl2.setDimensionality(singleUnitImpl.getDimensionality() + singleUnitImpl2.getDimensionality());
            return false;
        }
        this.singleUnits.add(singleUnitImpl.copy());
        if (this.singleUnits.size() > 1 && this.complexity == MeasureUnit.Complexity.SINGLE) {
            setComplexity(MeasureUnit.Complexity.COMPOUND);
        }
        return true;
    }

    public void applyDimensionality(int i) {
        ArrayList<SingleUnitImpl> arrayList = this.singleUnits;
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            SingleUnitImpl singleUnitImpl = arrayList.get(i2);
            i2++;
            SingleUnitImpl singleUnitImpl2 = singleUnitImpl;
            singleUnitImpl2.setDimensionality(singleUnitImpl2.getDimensionality() * i);
        }
    }

    public MeasureUnit build() {
        return MeasureUnit.fromMeasureUnitImpl(this);
    }

    public MeasureUnitImpl copy() {
        MeasureUnitImpl measureUnitImpl = new MeasureUnitImpl();
        measureUnitImpl.complexity = this.complexity;
        measureUnitImpl.identifier = this.identifier;
        measureUnitImpl.constantDenominator = this.constantDenominator;
        ArrayList<SingleUnitImpl> arrayList = this.singleUnits;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            SingleUnitImpl singleUnitImpl = arrayList.get(i);
            i++;
            measureUnitImpl.singleUnits.add(singleUnitImpl.copy());
        }
        return measureUnitImpl;
    }

    public MeasureUnitImpl copyAndSimplify() {
        MeasureUnitImpl measureUnitImpl = new MeasureUnitImpl();
        ArrayList<SingleUnitImpl> singleUnits = getSingleUnits();
        int size = singleUnits.size();
        int i = 0;
        while (i < size) {
            SingleUnitImpl singleUnitImpl = singleUnits.get(i);
            i++;
            SingleUnitImpl singleUnitImpl2 = singleUnitImpl;
            ArrayList<SingleUnitImpl> singleUnits2 = measureUnitImpl.getSingleUnits();
            int size2 = singleUnits2.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size2) {
                    measureUnitImpl.appendSingleUnit(singleUnitImpl2);
                    break;
                }
                SingleUnitImpl singleUnitImpl3 = singleUnits2.get(i2);
                i2++;
                SingleUnitImpl singleUnitImpl4 = singleUnitImpl3;
                if (singleUnitImpl4.getSimpleUnitID().compareTo(singleUnitImpl2.getSimpleUnitID()) == 0 && singleUnitImpl4.getPrefix().getIdentifier().compareTo(singleUnitImpl2.getPrefix().getIdentifier()) == 0) {
                    singleUnitImpl4.setDimensionality(singleUnitImpl2.getDimensionality() + singleUnitImpl4.getDimensionality());
                    break;
                }
            }
        }
        return measureUnitImpl;
    }

    public ArrayList<MeasureUnitImplWithIndex> extractIndividualUnitsWithIndices() {
        ArrayList<MeasureUnitImplWithIndex> arrayList = new ArrayList<>();
        int i = 0;
        if (getComplexity() != MeasureUnit.Complexity.MIXED) {
            arrayList.add(new MeasureUnitImplWithIndex(0, copy()));
            return arrayList;
        }
        ArrayList<SingleUnitImpl> singleUnits = getSingleUnits();
        int size = singleUnits.size();
        int i2 = 0;
        while (i2 < size) {
            SingleUnitImpl singleUnitImpl = singleUnits.get(i2);
            i2++;
            arrayList.add(new MeasureUnitImplWithIndex(i, new MeasureUnitImpl(singleUnitImpl)));
            i++;
        }
        return arrayList;
    }

    public MeasureUnit.Complexity getComplexity() {
        return this.complexity;
    }

    public long getConstantDenominator() {
        return this.constantDenominator;
    }

    public String getIdentifier() {
        return this.identifier;
    }

    public SingleUnitImpl getSingleUnitImpl() {
        if (this.singleUnits.size() == 0) {
            return new SingleUnitImpl();
        }
        if (this.singleUnits.size() == 1) {
            return this.singleUnits.get(0).copy();
        }
        dk0.p();
        return null;
    }

    public ArrayList<SingleUnitImpl> getSingleUnits() {
        return this.singleUnits;
    }

    public void serialize() {
        if (getSingleUnits().size() == 0 && this.constantDenominator == 0) {
            return;
        }
        if (this.complexity == MeasureUnit.Complexity.COMPOUND) {
            Collections.sort(getSingleUnits(), new SingleUnitComparator());
        }
        StringBuilder sb = new StringBuilder();
        ArrayList<SingleUnitImpl> singleUnits = getSingleUnits();
        int size = singleUnits.size();
        boolean z = true;
        boolean z2 = false;
        boolean z3 = false;
        int i = 0;
        while (i < size) {
            SingleUnitImpl singleUnitImpl = singleUnits.get(i);
            i++;
            SingleUnitImpl singleUnitImpl2 = singleUnitImpl;
            if (z && singleUnitImpl2.getDimensionality() < 0) {
                z3 = true;
                z = false;
            } else if (singleUnitImpl2.getDimensionality() < 0) {
                z3 = false;
            }
            if (z3 && this.constantDenominator > 0) {
                sb.append("-per-");
                sb.append(getConstantsString(this.constantDenominator));
                z2 = true;
                z3 = false;
            }
            if (getComplexity() == MeasureUnit.Complexity.MIXED) {
                if (sb.length() != 0) {
                    sb.append("-and-");
                }
            } else if (z3) {
                if (sb.length() == 0) {
                    sb.append("per-");
                } else {
                    sb.append("-per-");
                }
            } else if (sb.length() != 0) {
                sb.append(LanguageTag.SEP);
            }
            sb.append(singleUnitImpl2.getNeutralIdentifier());
        }
        if (this.constantDenominator > 0 && !z2) {
            sb.append("-per-");
            sb.append(getConstantsString(this.constantDenominator));
        }
        this.identifier = sb.toString();
    }

    public void setComplexity(MeasureUnit.Complexity complexity) {
        this.complexity = complexity;
    }

    public void setConstantDenominator(long j) {
        this.constantDenominator = j;
    }

    public void takeReciprocal() {
        this.identifier = null;
        ArrayList<SingleUnitImpl> arrayList = this.singleUnits;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            SingleUnitImpl singleUnitImpl = arrayList.get(i);
            i++;
            SingleUnitImpl singleUnitImpl2 = singleUnitImpl;
            singleUnitImpl2.setDimensionality(singleUnitImpl2.getDimensionality() * (-1));
        }
    }

    public String toString() {
        return cq.v("MeasureUnitImpl [", build().getIdentifier(), "]");
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class SingleUnitComparator implements Comparator<SingleUnitImpl> {
        @Override // java.util.Comparator
        public int compare(SingleUnitImpl singleUnitImpl, SingleUnitImpl singleUnitImpl2) {
            return singleUnitImpl.compareTo(singleUnitImpl2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class UnitsParser {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private static MeasureUnit.MeasurePrefix[] measurePrefixValues = MeasureUnit.MeasurePrefix.values();
        private static volatile CharsTrie savedTrie;
        private String fSource;
        private final CharsTrie trie;
        private int fIndex = 0;
        private boolean fAfterPer = false;
        private boolean fJustAfterPer = false;
        private boolean fSawAnd = false;

        /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
        public static class SingleUnitOrConstant {
            Long constant;
            SingleUnitImpl singleUnit;

            public SingleUnitOrConstant(SingleUnitImpl singleUnitImpl, Long l) {
                if (singleUnitImpl != null && l != null) {
                    og.i("It is a SingleUnit Or a Constant, not both");
                    throw null;
                }
                this.singleUnit = singleUnitImpl;
                this.constant = l;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
        public enum TokenState {
            NO_TOKENS_SEEN,
            POWER_TOKEN_SEEN,
            PREFIX_TOKEN_SEEN
        }

        static {
            CharsTrieBuilder charsTrieBuilder = new CharsTrieBuilder();
            for (MeasureUnit.MeasurePrefix measurePrefix : measurePrefixValues) {
                charsTrieBuilder.add(measurePrefix.getIdentifier(), getTrieIndexForPrefix(measurePrefix));
            }
            charsTrieBuilder.add("-per-", CompoundPart.PER.getTrieIndex());
            charsTrieBuilder.add(LanguageTag.SEP, CompoundPart.TIMES.getTrieIndex());
            charsTrieBuilder.add("-and-", CompoundPart.AND.getTrieIndex());
            charsTrieBuilder.add("per-", InitialCompoundPart.INITIAL_COMPOUND_PART_PER.getTrieIndex());
            PowerPart powerPart = PowerPart.P2;
            charsTrieBuilder.add("square-", powerPart.getTrieIndex());
            PowerPart powerPart2 = PowerPart.P3;
            charsTrieBuilder.add("cubic-", powerPart2.getTrieIndex());
            charsTrieBuilder.add("pow2-", powerPart.getTrieIndex());
            charsTrieBuilder.add("pow3-", powerPart2.getTrieIndex());
            charsTrieBuilder.add("pow4-", PowerPart.P4.getTrieIndex());
            charsTrieBuilder.add("pow5-", PowerPart.P5.getTrieIndex());
            charsTrieBuilder.add("pow6-", PowerPart.P6.getTrieIndex());
            charsTrieBuilder.add("pow7-", PowerPart.P7.getTrieIndex());
            charsTrieBuilder.add("pow8-", PowerPart.P8.getTrieIndex());
            charsTrieBuilder.add("pow9-", PowerPart.P9.getTrieIndex());
            charsTrieBuilder.add("pow10-", PowerPart.P10.getTrieIndex());
            charsTrieBuilder.add("pow11-", PowerPart.P11.getTrieIndex());
            charsTrieBuilder.add("pow12-", PowerPart.P12.getTrieIndex());
            charsTrieBuilder.add("pow13-", PowerPart.P13.getTrieIndex());
            charsTrieBuilder.add("pow14-", PowerPart.P14.getTrieIndex());
            charsTrieBuilder.add("pow15-", PowerPart.P15.getTrieIndex());
            String[] simpleUnits = UnitsData.getSimpleUnits();
            for (int i = 0; i < simpleUnits.length; i++) {
                charsTrieBuilder.add(simpleUnits[i], i + 512);
            }
            List<UnitAliases.Alias> aliases = UnitsData.getAliases();
            for (int i2 = 0; i2 < aliases.size(); i2++) {
                charsTrieBuilder.add(aliases.get(i2).alias, UnitsData.Constants.kAliasOffset + i2);
            }
            savedTrie = charsTrieBuilder.build(StringTrieBuilder.Option.FAST);
        }

        private UnitsParser(String str) {
            this.fSource = str;
            try {
                this.trie = savedTrie.m23clone();
            } catch (CloneNotSupportedException unused) {
                throw new ICUCloneNotSupportedException();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static MeasureUnit.MeasurePrefix getPrefixFromTrieIndex(int i) {
            return measurePrefixValues[i - 64];
        }

        private static int getTrieIndexForPrefix(MeasureUnit.MeasurePrefix measurePrefix) {
            return measurePrefix.ordinal() + 64;
        }

        private boolean hasNext() {
            return this.fIndex < this.fSource.length();
        }

        private SingleUnitOrConstant nextSingleUnit() {
            SingleUnitImpl singleUnitImpl = new SingleUnitImpl();
            TokenState tokenState = TokenState.NO_TOKENS_SEEN;
            boolean z = this.fIndex == 0;
            Token tokenNextToken = nextToken();
            this.fJustAfterPer = false;
            if (tokenNextToken.getType() == Token.Type.TYPE_ALIAS) {
                processAlias(tokenNextToken);
                tokenNextToken = nextToken();
            }
            if (z) {
                if (tokenNextToken.getType() == Token.Type.TYPE_UNIT_CONSTANT) {
                    og.i("Unit constant cannot be the first token");
                    return null;
                }
                if (tokenNextToken.getType() == Token.Type.TYPE_INITIAL_COMPOUND_PART) {
                    this.fAfterPer = true;
                    this.fJustAfterPer = true;
                    singleUnitImpl.setDimensionality(-1);
                    tokenNextToken = nextToken();
                }
            } else {
                if (tokenNextToken.getType() != Token.Type.TYPE_COMPOUND_PART) {
                    og.i("token type must be TYPE_COMPOUND_PART");
                    return null;
                }
                int i = AnonymousClass1.$SwitchMap$com$ibm$icu$impl$units$MeasureUnitImpl$CompoundPart[CompoundPart.getCompoundPartFromTrieIndex(tokenNextToken.getMatch()).ordinal()];
                if (i != 1) {
                    if (i != 2) {
                        if (i == 3) {
                            if (this.fAfterPer) {
                                og.i("Can't start with \"-and-\", and mixed compound units");
                                return null;
                            }
                            this.fSawAnd = true;
                        }
                    } else if (this.fAfterPer) {
                        singleUnitImpl.setDimensionality(-1);
                    }
                } else {
                    if (this.fSawAnd) {
                        og.i("Mixed compound units not yet supported");
                        return null;
                    }
                    this.fAfterPer = true;
                    this.fJustAfterPer = true;
                    singleUnitImpl.setDimensionality(-1);
                }
                tokenNextToken = nextToken();
            }
            if (tokenNextToken.getType() == Token.Type.TYPE_UNIT_CONSTANT) {
                if (this.fJustAfterPer) {
                    return new SingleUnitOrConstant(null, Long.valueOf(tokenNextToken.getConstantDenominator()));
                }
                og.i("Unit constant cannot be the first token");
                return null;
            }
            while (true) {
                int i2 = AnonymousClass1.$SwitchMap$com$ibm$icu$impl$units$MeasureUnitImpl$UnitsParser$Token$Type[tokenNextToken.getType().ordinal()];
                if (i2 != 1) {
                    if (i2 == 2) {
                        TokenState tokenState2 = TokenState.PREFIX_TOKEN_SEEN;
                        if (tokenState == tokenState2) {
                            dk0.v();
                            return null;
                        }
                        singleUnitImpl.setPrefix(tokenNextToken.getPrefix());
                        tokenState = tokenState2;
                    } else {
                        if (i2 == 3) {
                            singleUnitImpl.setSimpleUnit(tokenNextToken.getSimpleUnitIndex(), UnitsData.getSimpleUnits());
                            return new SingleUnitOrConstant(singleUnitImpl, null);
                        }
                        if (i2 != 4) {
                            dk0.v();
                            return null;
                        }
                        processAlias(tokenNextToken);
                    }
                } else {
                    if (tokenState != TokenState.NO_TOKENS_SEEN) {
                        dk0.v();
                        return null;
                    }
                    singleUnitImpl.setDimensionality(singleUnitImpl.getDimensionality() * tokenNextToken.getPower());
                    tokenState = TokenState.POWER_TOKEN_SEEN;
                }
                if (!hasNext()) {
                    og.i("We ran out of tokens before finding a complete single unit.");
                    return null;
                }
                tokenNextToken = nextToken();
            }
        }

        private Token nextToken() {
            this.trie.reset();
            int i = this.fIndex;
            int value = -1;
            int i2 = -1;
            while (this.fIndex < this.fSource.length()) {
                CharsTrie charsTrie = this.trie;
                String str = this.fSource;
                int i3 = this.fIndex;
                this.fIndex = i3 + 1;
                BytesTrie.Result next = charsTrie.next(str.charAt(i3));
                if (next == BytesTrie.Result.NO_MATCH) {
                    break;
                }
                if (next != BytesTrie.Result.NO_VALUE) {
                    value = this.trie.getValue();
                    i2 = this.fIndex;
                    if (next == BytesTrie.Result.FINAL_VALUE) {
                        break;
                    }
                    if (next != BytesTrie.Result.INTERMEDIATE_VALUE) {
                        og.i("Result must have an intermediate value");
                        return null;
                    }
                }
            }
            if (value >= 0) {
                this.fIndex = i2;
                return new Token(value);
            }
            if (!this.fJustAfterPer) {
                og.i(ky0.h(i2, "Encountered unknown token starting at index "));
                return null;
            }
            int iIndexOf = this.fSource.indexOf(45, i);
            String str2 = this.fSource;
            String strSubstring = iIndexOf == -1 ? str2.substring(i) : str2.substring(i, iIndexOf);
            if (iIndexOf == -1) {
                iIndexOf = this.fSource.length();
            }
            this.fIndex = iIndexOf;
            return Token.tokenWithConstant(strSubstring);
        }

        private MeasureUnitImpl parse() {
            MeasureUnitImpl measureUnitImpl = new MeasureUnitImpl();
            if (this.fSource.isEmpty()) {
                return null;
            }
            while (hasNext()) {
                this.fSawAnd = false;
                SingleUnitOrConstant singleUnitOrConstantNextSingleUnit = nextSingleUnit();
                SingleUnitImpl singleUnitImpl = singleUnitOrConstantNextSingleUnit.singleUnit;
                if (singleUnitImpl != null) {
                    boolean zAppendSingleUnit = measureUnitImpl.appendSingleUnit(singleUnitImpl);
                    if (this.fSawAnd && !zAppendSingleUnit) {
                        og.i("Two similar units are not allowed in a mixed unit.");
                        return null;
                    }
                    if (measureUnitImpl.singleUnits.size() < 2) {
                        continue;
                    } else {
                        MeasureUnit.Complexity complexity = this.fSawAnd ? MeasureUnit.Complexity.MIXED : MeasureUnit.Complexity.COMPOUND;
                        if (measureUnitImpl.getSingleUnits().size() == 2) {
                            measureUnitImpl.setComplexity(complexity);
                        } else if (measureUnitImpl.getComplexity() != complexity) {
                            og.i("Can't have mixed compound units");
                            return null;
                        }
                    }
                } else {
                    if (measureUnitImpl.getConstantDenominator() != 0) {
                        og.i("Can't have multiple unit constants");
                        return null;
                    }
                    measureUnitImpl.setConstantDenominator(singleUnitOrConstantNextSingleUnit.constant.longValue());
                    measureUnitImpl.setComplexity(MeasureUnit.Complexity.COMPOUND);
                }
            }
            if (measureUnitImpl.getSingleUnits().size() != 0) {
                return measureUnitImpl;
            }
            og.i("Error in parsing a unit identifier.");
            return null;
        }

        public static MeasureUnitImpl parseForIdentifier(String str) {
            if (str == null || str.isEmpty()) {
                return null;
            }
            return new UnitsParser(str).parse();
        }

        private void processAlias(Token token) {
            this.fSource = ky0.j(UnitsData.getReplacementFromAliasIndex(token.getAliasIndex()), this.fSource.substring(this.fIndex));
            this.fIndex = 0;
        }

        /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
        public static class Token {
            static final /* synthetic */ boolean $assertionsDisabled = false;
            private final long fMatch;
            private final Type type;

            /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
            public enum Type {
                TYPE_UNDEFINED,
                TYPE_PREFIX,
                TYPE_COMPOUND_PART,
                TYPE_INITIAL_COMPOUND_PART,
                TYPE_POWER_PART,
                TYPE_SIMPLE_UNIT,
                TYPE_UNIT_CONSTANT,
                TYPE_ALIAS
            }

            public Token(long j) {
                this.fMatch = j;
                this.type = calculateType(j);
            }

            private Type calculateType(long j) {
                if (j <= 0) {
                    og.m("fMatch must have a positive value");
                    return null;
                }
                if (j < 128) {
                    return Type.TYPE_PREFIX;
                }
                if (j < 192) {
                    return Type.TYPE_COMPOUND_PART;
                }
                if (j < 256) {
                    return Type.TYPE_INITIAL_COMPOUND_PART;
                }
                if (j < 512) {
                    return Type.TYPE_POWER_PART;
                }
                return j < 51200 ? Type.TYPE_SIMPLE_UNIT : Type.TYPE_ALIAS;
            }

            public static Token tokenWithConstant(String str) {
                BigDecimal bigDecimal = new BigDecimal(str);
                if (bigDecimal.scale() <= 0 && bigDecimal.compareTo(BigDecimal.ZERO) >= 0 && bigDecimal.compareTo(BigDecimal.valueOf(Long.MAX_VALUE)) <= 0) {
                    return new Token(bigDecimal.longValueExact(), Type.TYPE_UNIT_CONSTANT);
                }
                og.i("The unit constant value is not a valid non-negative long integer.");
                return null;
            }

            public int getAliasIndex() {
                return ((int) this.fMatch) - UnitsData.Constants.kAliasOffset;
            }

            public long getConstantDenominator() {
                return this.fMatch;
            }

            public InitialCompoundPart getInitialCompoundPart() {
                return InitialCompoundPart.getInitialCompoundPartFromTrieIndex((int) this.fMatch);
            }

            public int getMatch() {
                return (int) this.fMatch;
            }

            public int getPower() {
                return PowerPart.getPowerFromTrieIndex((int) this.fMatch);
            }

            public MeasureUnit.MeasurePrefix getPrefix() {
                return UnitsParser.getPrefixFromTrieIndex((int) this.fMatch);
            }

            public int getSimpleUnitIndex() {
                return ((int) this.fMatch) - 512;
            }

            public Type getType() {
                return this.type;
            }

            private Token(long j, Type type) {
                this.fMatch = j;
                this.type = type;
            }
        }
    }

    public MeasureUnitImpl(SingleUnitImpl singleUnitImpl) {
        this();
        appendSingleUnit(singleUnitImpl);
    }
}
