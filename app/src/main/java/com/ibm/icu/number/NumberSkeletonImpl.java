package com.ibm.icu.number;

import com.ibm.icu.impl.CacheBase;
import com.ibm.icu.impl.PatternProps;
import com.ibm.icu.impl.SoftCache;
import com.ibm.icu.impl.StringSegment;
import com.ibm.icu.impl.number.MacroProps;
import com.ibm.icu.impl.number.Padder;
import com.ibm.icu.impl.number.RoundingUtils;
import com.ibm.icu.text.NumberingSystem;
import com.ibm.icu.util.BytesTrie;
import com.ibm.icu.util.CharsTrie;
import com.ibm.icu.util.CharsTrieBuilder;
import com.ibm.icu.util.Currency;
import com.ibm.icu.util.MeasureUnit;
import com.ibm.icu.util.NoUnit;
import com.ibm.icu.util.StringTrieBuilder;
import defpackage.dk0;
import defpackage.ky0;
import java.math.BigDecimal;
import java.math.RoundingMode;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
class NumberSkeletonImpl {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final char ALT_WILDCARD_CHAR = '+';
    static final char WILDCARD_CHAR = '*';
    static final StemEnum[] STEM_ENUM_VALUES = StemEnum.values();
    static final String SERIALIZED_STEM_TRIE = buildStemTrie();
    private static final CacheBase<String, UnlocalizedNumberFormatter, Void> cache = new SoftCache<String, UnlocalizedNumberFormatter, Void>() { // from class: com.ibm.icu.number.NumberSkeletonImpl.1
        @Override // com.ibm.icu.impl.CacheBase
        public UnlocalizedNumberFormatter createInstance(String str, Void r2) {
            return NumberSkeletonImpl.create(str);
        }
    };

    /* JADX INFO: renamed from: com.ibm.icu.number.NumberSkeletonImpl$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$ibm$icu$number$NumberFormatter$DecimalSeparatorDisplay;
        static final /* synthetic */ int[] $SwitchMap$com$ibm$icu$number$NumberFormatter$GroupingStrategy;
        static final /* synthetic */ int[] $SwitchMap$com$ibm$icu$number$NumberFormatter$SignDisplay;
        static final /* synthetic */ int[] $SwitchMap$com$ibm$icu$number$NumberFormatter$UnitWidth;
        static final /* synthetic */ int[] $SwitchMap$com$ibm$icu$number$NumberSkeletonImpl$ParseState;
        static final /* synthetic */ int[] $SwitchMap$com$ibm$icu$number$NumberSkeletonImpl$StemEnum;
        static final /* synthetic */ int[] $SwitchMap$java$math$RoundingMode;

        static {
            int[] iArr = new int[ParseState.values().length];
            $SwitchMap$com$ibm$icu$number$NumberSkeletonImpl$ParseState = iArr;
            try {
                iArr[ParseState.STATE_INCREMENT_PRECISION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ibm$icu$number$NumberSkeletonImpl$ParseState[ParseState.STATE_MEASURE_UNIT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$ibm$icu$number$NumberSkeletonImpl$ParseState[ParseState.STATE_PER_MEASURE_UNIT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$ibm$icu$number$NumberSkeletonImpl$ParseState[ParseState.STATE_IDENTIFIER_UNIT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$ibm$icu$number$NumberSkeletonImpl$ParseState[ParseState.STATE_UNIT_USAGE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$ibm$icu$number$NumberSkeletonImpl$ParseState[ParseState.STATE_CURRENCY_UNIT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$ibm$icu$number$NumberSkeletonImpl$ParseState[ParseState.STATE_INTEGER_WIDTH.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$ibm$icu$number$NumberSkeletonImpl$ParseState[ParseState.STATE_NUMBERING_SYSTEM.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$ibm$icu$number$NumberSkeletonImpl$ParseState[ParseState.STATE_SCALE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$ibm$icu$number$NumberSkeletonImpl$ParseState[ParseState.STATE_SCIENTIFIC.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$ibm$icu$number$NumberSkeletonImpl$ParseState[ParseState.STATE_FRACTION_PRECISION.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$ibm$icu$number$NumberSkeletonImpl$ParseState[ParseState.STATE_PRECISION.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            int[] iArr2 = new int[NumberFormatter.DecimalSeparatorDisplay.values().length];
            $SwitchMap$com$ibm$icu$number$NumberFormatter$DecimalSeparatorDisplay = iArr2;
            try {
                iArr2[NumberFormatter.DecimalSeparatorDisplay.AUTO.ordinal()] = 1;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$ibm$icu$number$NumberFormatter$DecimalSeparatorDisplay[NumberFormatter.DecimalSeparatorDisplay.ALWAYS.ordinal()] = 2;
            } catch (NoSuchFieldError unused14) {
            }
            int[] iArr3 = new int[NumberFormatter.SignDisplay.values().length];
            $SwitchMap$com$ibm$icu$number$NumberFormatter$SignDisplay = iArr3;
            try {
                iArr3[NumberFormatter.SignDisplay.AUTO.ordinal()] = 1;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$com$ibm$icu$number$NumberFormatter$SignDisplay[NumberFormatter.SignDisplay.ALWAYS.ordinal()] = 2;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$com$ibm$icu$number$NumberFormatter$SignDisplay[NumberFormatter.SignDisplay.NEVER.ordinal()] = 3;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                $SwitchMap$com$ibm$icu$number$NumberFormatter$SignDisplay[NumberFormatter.SignDisplay.ACCOUNTING.ordinal()] = 4;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                $SwitchMap$com$ibm$icu$number$NumberFormatter$SignDisplay[NumberFormatter.SignDisplay.ACCOUNTING_ALWAYS.ordinal()] = 5;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                $SwitchMap$com$ibm$icu$number$NumberFormatter$SignDisplay[NumberFormatter.SignDisplay.EXCEPT_ZERO.ordinal()] = 6;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                $SwitchMap$com$ibm$icu$number$NumberFormatter$SignDisplay[NumberFormatter.SignDisplay.ACCOUNTING_EXCEPT_ZERO.ordinal()] = 7;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                $SwitchMap$com$ibm$icu$number$NumberFormatter$SignDisplay[NumberFormatter.SignDisplay.NEGATIVE.ordinal()] = 8;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                $SwitchMap$com$ibm$icu$number$NumberFormatter$SignDisplay[NumberFormatter.SignDisplay.ACCOUNTING_NEGATIVE.ordinal()] = 9;
            } catch (NoSuchFieldError unused23) {
            }
            int[] iArr4 = new int[NumberFormatter.UnitWidth.values().length];
            $SwitchMap$com$ibm$icu$number$NumberFormatter$UnitWidth = iArr4;
            try {
                iArr4[NumberFormatter.UnitWidth.NARROW.ordinal()] = 1;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                $SwitchMap$com$ibm$icu$number$NumberFormatter$UnitWidth[NumberFormatter.UnitWidth.SHORT.ordinal()] = 2;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                $SwitchMap$com$ibm$icu$number$NumberFormatter$UnitWidth[NumberFormatter.UnitWidth.FULL_NAME.ordinal()] = 3;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                $SwitchMap$com$ibm$icu$number$NumberFormatter$UnitWidth[NumberFormatter.UnitWidth.ISO_CODE.ordinal()] = 4;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                $SwitchMap$com$ibm$icu$number$NumberFormatter$UnitWidth[NumberFormatter.UnitWidth.FORMAL.ordinal()] = 5;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                $SwitchMap$com$ibm$icu$number$NumberFormatter$UnitWidth[NumberFormatter.UnitWidth.VARIANT.ordinal()] = 6;
            } catch (NoSuchFieldError unused29) {
            }
            try {
                $SwitchMap$com$ibm$icu$number$NumberFormatter$UnitWidth[NumberFormatter.UnitWidth.HIDDEN.ordinal()] = 7;
            } catch (NoSuchFieldError unused30) {
            }
            int[] iArr5 = new int[NumberFormatter.GroupingStrategy.values().length];
            $SwitchMap$com$ibm$icu$number$NumberFormatter$GroupingStrategy = iArr5;
            try {
                iArr5[NumberFormatter.GroupingStrategy.OFF.ordinal()] = 1;
            } catch (NoSuchFieldError unused31) {
            }
            try {
                $SwitchMap$com$ibm$icu$number$NumberFormatter$GroupingStrategy[NumberFormatter.GroupingStrategy.MIN2.ordinal()] = 2;
            } catch (NoSuchFieldError unused32) {
            }
            try {
                $SwitchMap$com$ibm$icu$number$NumberFormatter$GroupingStrategy[NumberFormatter.GroupingStrategy.AUTO.ordinal()] = 3;
            } catch (NoSuchFieldError unused33) {
            }
            try {
                $SwitchMap$com$ibm$icu$number$NumberFormatter$GroupingStrategy[NumberFormatter.GroupingStrategy.ON_ALIGNED.ordinal()] = 4;
            } catch (NoSuchFieldError unused34) {
            }
            try {
                $SwitchMap$com$ibm$icu$number$NumberFormatter$GroupingStrategy[NumberFormatter.GroupingStrategy.THOUSANDS.ordinal()] = 5;
            } catch (NoSuchFieldError unused35) {
            }
            int[] iArr6 = new int[RoundingMode.values().length];
            $SwitchMap$java$math$RoundingMode = iArr6;
            try {
                iArr6[RoundingMode.CEILING.ordinal()] = 1;
            } catch (NoSuchFieldError unused36) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.FLOOR.ordinal()] = 2;
            } catch (NoSuchFieldError unused37) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.DOWN.ordinal()] = 3;
            } catch (NoSuchFieldError unused38) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.UP.ordinal()] = 4;
            } catch (NoSuchFieldError unused39) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.HALF_EVEN.ordinal()] = 5;
            } catch (NoSuchFieldError unused40) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.HALF_DOWN.ordinal()] = 6;
            } catch (NoSuchFieldError unused41) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.HALF_UP.ordinal()] = 7;
            } catch (NoSuchFieldError unused42) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.UNNECESSARY.ordinal()] = 8;
            } catch (NoSuchFieldError unused43) {
            }
            int[] iArr7 = new int[StemEnum.values().length];
            $SwitchMap$com$ibm$icu$number$NumberSkeletonImpl$StemEnum = iArr7;
            try {
                iArr7[StemEnum.STEM_COMPACT_SHORT.ordinal()] = 1;
            } catch (NoSuchFieldError unused44) {
            }
            try {
                $SwitchMap$com$ibm$icu$number$NumberSkeletonImpl$StemEnum[StemEnum.STEM_COMPACT_LONG.ordinal()] = 2;
            } catch (NoSuchFieldError unused45) {
            }
            try {
                $SwitchMap$com$ibm$icu$number$NumberSkeletonImpl$StemEnum[StemEnum.STEM_SCIENTIFIC.ordinal()] = 3;
            } catch (NoSuchFieldError unused46) {
            }
            try {
                $SwitchMap$com$ibm$icu$number$NumberSkeletonImpl$StemEnum[StemEnum.STEM_ENGINEERING.ordinal()] = 4;
            } catch (NoSuchFieldError unused47) {
            }
            try {
                $SwitchMap$com$ibm$icu$number$NumberSkeletonImpl$StemEnum[StemEnum.STEM_NOTATION_SIMPLE.ordinal()] = 5;
            } catch (NoSuchFieldError unused48) {
            }
            try {
                $SwitchMap$com$ibm$icu$number$NumberSkeletonImpl$StemEnum[StemEnum.STEM_BASE_UNIT.ordinal()] = 6;
            } catch (NoSuchFieldError unused49) {
            }
            try {
                $SwitchMap$com$ibm$icu$number$NumberSkeletonImpl$StemEnum[StemEnum.STEM_PERCENT.ordinal()] = 7;
            } catch (NoSuchFieldError unused50) {
            }
            try {
                $SwitchMap$com$ibm$icu$number$NumberSkeletonImpl$StemEnum[StemEnum.STEM_PERMILLE.ordinal()] = 8;
            } catch (NoSuchFieldError unused51) {
            }
            try {
                $SwitchMap$com$ibm$icu$number$NumberSkeletonImpl$StemEnum[StemEnum.STEM_PRECISION_INTEGER.ordinal()] = 9;
            } catch (NoSuchFieldError unused52) {
            }
            try {
                $SwitchMap$com$ibm$icu$number$NumberSkeletonImpl$StemEnum[StemEnum.STEM_PRECISION_UNLIMITED.ordinal()] = 10;
            } catch (NoSuchFieldError unused53) {
            }
            try {
                $SwitchMap$com$ibm$icu$number$NumberSkeletonImpl$StemEnum[StemEnum.STEM_PRECISION_CURRENCY_STANDARD.ordinal()] = 11;
            } catch (NoSuchFieldError unused54) {
            }
            try {
                $SwitchMap$com$ibm$icu$number$NumberSkeletonImpl$StemEnum[StemEnum.STEM_PRECISION_CURRENCY_CASH.ordinal()] = 12;
            } catch (NoSuchFieldError unused55) {
            }
            try {
                $SwitchMap$com$ibm$icu$number$NumberSkeletonImpl$StemEnum[StemEnum.STEM_ROUNDING_MODE_CEILING.ordinal()] = 13;
            } catch (NoSuchFieldError unused56) {
            }
            try {
                $SwitchMap$com$ibm$icu$number$NumberSkeletonImpl$StemEnum[StemEnum.STEM_ROUNDING_MODE_FLOOR.ordinal()] = 14;
            } catch (NoSuchFieldError unused57) {
            }
            try {
                $SwitchMap$com$ibm$icu$number$NumberSkeletonImpl$StemEnum[StemEnum.STEM_ROUNDING_MODE_DOWN.ordinal()] = 15;
            } catch (NoSuchFieldError unused58) {
            }
            try {
                $SwitchMap$com$ibm$icu$number$NumberSkeletonImpl$StemEnum[StemEnum.STEM_ROUNDING_MODE_UP.ordinal()] = 16;
            } catch (NoSuchFieldError unused59) {
            }
            try {
                $SwitchMap$com$ibm$icu$number$NumberSkeletonImpl$StemEnum[StemEnum.STEM_ROUNDING_MODE_HALF_EVEN.ordinal()] = 17;
            } catch (NoSuchFieldError unused60) {
            }
            try {
                $SwitchMap$com$ibm$icu$number$NumberSkeletonImpl$StemEnum[StemEnum.STEM_ROUNDING_MODE_HALF_DOWN.ordinal()] = 18;
            } catch (NoSuchFieldError unused61) {
            }
            try {
                $SwitchMap$com$ibm$icu$number$NumberSkeletonImpl$StemEnum[StemEnum.STEM_ROUNDING_MODE_HALF_UP.ordinal()] = 19;
            } catch (NoSuchFieldError unused62) {
            }
            try {
                $SwitchMap$com$ibm$icu$number$NumberSkeletonImpl$StemEnum[StemEnum.STEM_ROUNDING_MODE_UNNECESSARY.ordinal()] = 20;
            } catch (NoSuchFieldError unused63) {
            }
            try {
                $SwitchMap$com$ibm$icu$number$NumberSkeletonImpl$StemEnum[StemEnum.STEM_GROUP_OFF.ordinal()] = 21;
            } catch (NoSuchFieldError unused64) {
            }
            try {
                $SwitchMap$com$ibm$icu$number$NumberSkeletonImpl$StemEnum[StemEnum.STEM_GROUP_MIN2.ordinal()] = 22;
            } catch (NoSuchFieldError unused65) {
            }
            try {
                $SwitchMap$com$ibm$icu$number$NumberSkeletonImpl$StemEnum[StemEnum.STEM_GROUP_AUTO.ordinal()] = 23;
            } catch (NoSuchFieldError unused66) {
            }
            try {
                $SwitchMap$com$ibm$icu$number$NumberSkeletonImpl$StemEnum[StemEnum.STEM_GROUP_ON_ALIGNED.ordinal()] = 24;
            } catch (NoSuchFieldError unused67) {
            }
            try {
                $SwitchMap$com$ibm$icu$number$NumberSkeletonImpl$StemEnum[StemEnum.STEM_GROUP_THOUSANDS.ordinal()] = 25;
            } catch (NoSuchFieldError unused68) {
            }
            try {
                $SwitchMap$com$ibm$icu$number$NumberSkeletonImpl$StemEnum[StemEnum.STEM_UNIT_WIDTH_NARROW.ordinal()] = 26;
            } catch (NoSuchFieldError unused69) {
            }
            try {
                $SwitchMap$com$ibm$icu$number$NumberSkeletonImpl$StemEnum[StemEnum.STEM_UNIT_WIDTH_SHORT.ordinal()] = 27;
            } catch (NoSuchFieldError unused70) {
            }
            try {
                $SwitchMap$com$ibm$icu$number$NumberSkeletonImpl$StemEnum[StemEnum.STEM_UNIT_WIDTH_FULL_NAME.ordinal()] = 28;
            } catch (NoSuchFieldError unused71) {
            }
            try {
                $SwitchMap$com$ibm$icu$number$NumberSkeletonImpl$StemEnum[StemEnum.STEM_UNIT_WIDTH_ISO_CODE.ordinal()] = 29;
            } catch (NoSuchFieldError unused72) {
            }
            try {
                $SwitchMap$com$ibm$icu$number$NumberSkeletonImpl$StemEnum[StemEnum.STEM_UNIT_WIDTH_FORMAL.ordinal()] = 30;
            } catch (NoSuchFieldError unused73) {
            }
            try {
                $SwitchMap$com$ibm$icu$number$NumberSkeletonImpl$StemEnum[StemEnum.STEM_UNIT_WIDTH_VARIANT.ordinal()] = 31;
            } catch (NoSuchFieldError unused74) {
            }
            try {
                $SwitchMap$com$ibm$icu$number$NumberSkeletonImpl$StemEnum[StemEnum.STEM_UNIT_WIDTH_HIDDEN.ordinal()] = 32;
            } catch (NoSuchFieldError unused75) {
            }
            try {
                $SwitchMap$com$ibm$icu$number$NumberSkeletonImpl$StemEnum[StemEnum.STEM_SIGN_AUTO.ordinal()] = 33;
            } catch (NoSuchFieldError unused76) {
            }
            try {
                $SwitchMap$com$ibm$icu$number$NumberSkeletonImpl$StemEnum[StemEnum.STEM_SIGN_ALWAYS.ordinal()] = 34;
            } catch (NoSuchFieldError unused77) {
            }
            try {
                $SwitchMap$com$ibm$icu$number$NumberSkeletonImpl$StemEnum[StemEnum.STEM_SIGN_NEVER.ordinal()] = 35;
            } catch (NoSuchFieldError unused78) {
            }
            try {
                $SwitchMap$com$ibm$icu$number$NumberSkeletonImpl$StemEnum[StemEnum.STEM_SIGN_ACCOUNTING.ordinal()] = 36;
            } catch (NoSuchFieldError unused79) {
            }
            try {
                $SwitchMap$com$ibm$icu$number$NumberSkeletonImpl$StemEnum[StemEnum.STEM_SIGN_ACCOUNTING_ALWAYS.ordinal()] = 37;
            } catch (NoSuchFieldError unused80) {
            }
            try {
                $SwitchMap$com$ibm$icu$number$NumberSkeletonImpl$StemEnum[StemEnum.STEM_SIGN_EXCEPT_ZERO.ordinal()] = 38;
            } catch (NoSuchFieldError unused81) {
            }
            try {
                $SwitchMap$com$ibm$icu$number$NumberSkeletonImpl$StemEnum[StemEnum.STEM_SIGN_ACCOUNTING_EXCEPT_ZERO.ordinal()] = 39;
            } catch (NoSuchFieldError unused82) {
            }
            try {
                $SwitchMap$com$ibm$icu$number$NumberSkeletonImpl$StemEnum[StemEnum.STEM_SIGN_NEGATIVE.ordinal()] = 40;
            } catch (NoSuchFieldError unused83) {
            }
            try {
                $SwitchMap$com$ibm$icu$number$NumberSkeletonImpl$StemEnum[StemEnum.STEM_SIGN_ACCOUNTING_NEGATIVE.ordinal()] = 41;
            } catch (NoSuchFieldError unused84) {
            }
            try {
                $SwitchMap$com$ibm$icu$number$NumberSkeletonImpl$StemEnum[StemEnum.STEM_DECIMAL_AUTO.ordinal()] = 42;
            } catch (NoSuchFieldError unused85) {
            }
            try {
                $SwitchMap$com$ibm$icu$number$NumberSkeletonImpl$StemEnum[StemEnum.STEM_DECIMAL_ALWAYS.ordinal()] = 43;
            } catch (NoSuchFieldError unused86) {
            }
            try {
                $SwitchMap$com$ibm$icu$number$NumberSkeletonImpl$StemEnum[StemEnum.STEM_PERCENT_100.ordinal()] = 44;
            } catch (NoSuchFieldError unused87) {
            }
            try {
                $SwitchMap$com$ibm$icu$number$NumberSkeletonImpl$StemEnum[StemEnum.STEM_INTEGER_WIDTH_TRUNC.ordinal()] = 45;
            } catch (NoSuchFieldError unused88) {
            }
            try {
                $SwitchMap$com$ibm$icu$number$NumberSkeletonImpl$StemEnum[StemEnum.STEM_LATIN.ordinal()] = 46;
            } catch (NoSuchFieldError unused89) {
            }
            try {
                $SwitchMap$com$ibm$icu$number$NumberSkeletonImpl$StemEnum[StemEnum.STEM_PRECISION_INCREMENT.ordinal()] = 47;
            } catch (NoSuchFieldError unused90) {
            }
            try {
                $SwitchMap$com$ibm$icu$number$NumberSkeletonImpl$StemEnum[StemEnum.STEM_MEASURE_UNIT.ordinal()] = 48;
            } catch (NoSuchFieldError unused91) {
            }
            try {
                $SwitchMap$com$ibm$icu$number$NumberSkeletonImpl$StemEnum[StemEnum.STEM_PER_MEASURE_UNIT.ordinal()] = 49;
            } catch (NoSuchFieldError unused92) {
            }
            try {
                $SwitchMap$com$ibm$icu$number$NumberSkeletonImpl$StemEnum[StemEnum.STEM_UNIT.ordinal()] = 50;
            } catch (NoSuchFieldError unused93) {
            }
            try {
                $SwitchMap$com$ibm$icu$number$NumberSkeletonImpl$StemEnum[StemEnum.STEM_UNIT_USAGE.ordinal()] = 51;
            } catch (NoSuchFieldError unused94) {
            }
            try {
                $SwitchMap$com$ibm$icu$number$NumberSkeletonImpl$StemEnum[StemEnum.STEM_CURRENCY.ordinal()] = 52;
            } catch (NoSuchFieldError unused95) {
            }
            try {
                $SwitchMap$com$ibm$icu$number$NumberSkeletonImpl$StemEnum[StemEnum.STEM_INTEGER_WIDTH.ordinal()] = 53;
            } catch (NoSuchFieldError unused96) {
            }
            try {
                $SwitchMap$com$ibm$icu$number$NumberSkeletonImpl$StemEnum[StemEnum.STEM_NUMBERING_SYSTEM.ordinal()] = 54;
            } catch (NoSuchFieldError unused97) {
            }
            try {
                $SwitchMap$com$ibm$icu$number$NumberSkeletonImpl$StemEnum[StemEnum.STEM_SCALE.ordinal()] = 55;
            } catch (NoSuchFieldError unused98) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class BlueprintHelpers {
        static final /* synthetic */ boolean $assertionsDisabled = false;

        /* JADX INFO: Access modifiers changed from: private */
        public static void generateCurrencyOption(Currency currency, StringBuilder sb) {
            sb.append(currency.getCurrencyCode());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void generateDigitsStem(int i, int i2, StringBuilder sb) {
            NumberSkeletonImpl.appendMultiple(sb, 64, i);
            if (i2 == -1) {
                sb.append(NumberSkeletonImpl.WILDCARD_CHAR);
            } else {
                NumberSkeletonImpl.appendMultiple(sb, 35, i2 - i);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void generateExponentWidthOption(int i, StringBuilder sb) {
            sb.append(NumberSkeletonImpl.WILDCARD_CHAR);
            NumberSkeletonImpl.appendMultiple(sb, 101, i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void generateFractionStem(int i, int i2, StringBuilder sb) {
            if (i == 0 && i2 == 0) {
                sb.append("precision-integer");
                return;
            }
            sb.append('.');
            NumberSkeletonImpl.appendMultiple(sb, 48, i);
            if (i2 == -1) {
                sb.append(NumberSkeletonImpl.WILDCARD_CHAR);
            } else {
                NumberSkeletonImpl.appendMultiple(sb, 35, i2 - i);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void generateIncrementOption(BigDecimal bigDecimal, StringBuilder sb) {
            sb.append(bigDecimal.toPlainString());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void generateIntegerWidthOption(int i, int i2, StringBuilder sb) {
            if (i2 == -1) {
                sb.append(NumberSkeletonImpl.WILDCARD_CHAR);
            } else {
                NumberSkeletonImpl.appendMultiple(sb, 35, i2 - i);
            }
            NumberSkeletonImpl.appendMultiple(sb, 48, i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void generateNumberingSystemOption(NumberingSystem numberingSystem, StringBuilder sb) {
            sb.append(numberingSystem.getName());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void generateScaleOption(Scale scale, StringBuilder sb) {
            BigDecimal bigDecimal = scale.arbitrary;
            if (bigDecimal == null) {
                bigDecimal = BigDecimal.ONE;
            }
            sb.append(bigDecimal.scaleByPowerOfTen(scale.magnitude).toPlainString());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void parseCurrencyOption(StringSegment stringSegment, MacroProps macroProps) {
            try {
                macroProps.unit = Currency.getInstance(stringSegment.subSequence(0, stringSegment.length()).toString());
            } catch (IllegalArgumentException e) {
                throw new SkeletonSyntaxException("Invalid currency", stringSegment, e);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void parseDigitsStem(StringSegment stringSegment, MacroProps macroProps) {
            int i;
            int i2 = 0;
            int i3 = 0;
            while (i2 < stringSegment.length() && stringSegment.charAt(i2) == '@') {
                i3++;
                i2++;
            }
            if (i2 >= stringSegment.length()) {
                i = i3;
            } else if (NumberSkeletonImpl.isWildcardChar(stringSegment.charAt(i2))) {
                i2++;
                i = -1;
            } else {
                i = i3;
                while (i2 < stringSegment.length() && stringSegment.charAt(i2) == '#') {
                    i++;
                    i2++;
                }
            }
            if (i2 < stringSegment.length()) {
                throw new SkeletonSyntaxException("Invalid significant digits stem", stringSegment);
            }
            if (i == -1) {
                macroProps.precision = Precision.minSignificantDigits(i3);
            } else {
                macroProps.precision = Precision.minMaxSignificantDigits(i3, i);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean parseExponentSignOption(StringSegment stringSegment, MacroProps macroProps) {
            NumberFormatter.SignDisplay signDisplay;
            CharsTrie charsTrie = new CharsTrie(NumberSkeletonImpl.SERIALIZED_STEM_TRIE, 0);
            BytesTrie.Result next = charsTrie.next(stringSegment, 0, stringSegment.length());
            if ((next != BytesTrie.Result.INTERMEDIATE_VALUE && next != BytesTrie.Result.FINAL_VALUE) || (signDisplay = StemToObject.signDisplay(NumberSkeletonImpl.STEM_ENUM_VALUES[charsTrie.getValue()])) == null) {
                return false;
            }
            macroProps.notation = ((ScientificNotation) macroProps.notation).withExponentSignDisplay(signDisplay);
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean parseExponentWidthOption(StringSegment stringSegment, MacroProps macroProps) {
            if (!NumberSkeletonImpl.isWildcardChar(stringSegment.charAt(0))) {
                return false;
            }
            int i = 0;
            int i2 = 1;
            while (i2 < stringSegment.length() && stringSegment.charAt(i2) == 'e') {
                i++;
                i2++;
            }
            if (i2 < stringSegment.length()) {
                return false;
            }
            macroProps.notation = ((ScientificNotation) macroProps.notation).withMinExponentDigits(i);
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Code duplicated, block: B:36:0x0073  */
        /* JADX WARN: Code duplicated, block: B:37:0x007a  */
        public static boolean parseFracSigOption(StringSegment stringSegment, MacroProps macroProps) {
            int i;
            NumberFormatter.RoundingPriority roundingPriority;
            int i2 = 0;
            if (stringSegment.charAt(0) != '@') {
                return false;
            }
            int i3 = 0;
            while (i2 < stringSegment.length() && stringSegment.charAt(i2) == '@') {
                i3++;
                i2++;
            }
            if (i2 >= stringSegment.length()) {
                i = i3;
            } else if (NumberSkeletonImpl.isWildcardChar(stringSegment.charAt(i2))) {
                i2++;
                i = -1;
            } else {
                i = i3;
                while (i2 < stringSegment.length() && stringSegment.charAt(i2) == '#') {
                    i++;
                    i2++;
                }
            }
            FractionPrecision fractionPrecision = (FractionPrecision) macroProps.precision;
            if (i2 < stringSegment.length()) {
                if (i == -1) {
                    throw new SkeletonSyntaxException("Invalid digits option: Wildcard character not allowed with the priority annotation", stringSegment);
                }
                if (stringSegment.codePointAt(i2) == 114) {
                    roundingPriority = NumberFormatter.RoundingPriority.RELAXED;
                } else {
                    if (stringSegment.codePointAt(i2) == 115) {
                        roundingPriority = NumberFormatter.RoundingPriority.STRICT;
                    } else {
                        roundingPriority = NumberFormatter.RoundingPriority.RELAXED;
                    }
                    if (i2 >= stringSegment.length()) {
                        throw new SkeletonSyntaxException("Invalid digits option for fraction rounder", stringSegment);
                    }
                    macroProps.precision = fractionPrecision.withSignificantDigits(i3, i, roundingPriority);
                }
                i2++;
                if (i2 >= stringSegment.length()) {
                    throw new SkeletonSyntaxException("Invalid digits option for fraction rounder", stringSegment);
                }
                macroProps.precision = fractionPrecision.withSignificantDigits(i3, i, roundingPriority);
            } else if (i == -1) {
                macroProps.precision = fractionPrecision.withMinDigits(i3);
            } else {
                if (i3 != 1) {
                    throw new SkeletonSyntaxException("Invalid digits option: Priority annotation required", stringSegment);
                }
                macroProps.precision = fractionPrecision.withMaxDigits(i);
            }
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void parseFractionStem(StringSegment stringSegment, MacroProps macroProps) {
            int i;
            int i2 = 1;
            int i3 = 0;
            while (i2 < stringSegment.length() && stringSegment.charAt(i2) == '0') {
                i3++;
                i2++;
            }
            if (i2 >= stringSegment.length()) {
                i = i3;
            } else if (NumberSkeletonImpl.isWildcardChar(stringSegment.charAt(i2))) {
                i2++;
                i = -1;
            } else {
                i = i3;
                while (i2 < stringSegment.length() && stringSegment.charAt(i2) == '#') {
                    i++;
                    i2++;
                }
            }
            if (i2 < stringSegment.length()) {
                throw new SkeletonSyntaxException("Invalid fraction stem", stringSegment);
            }
            if (i != -1) {
                macroProps.precision = Precision.minMaxFraction(i3, i);
            } else if (i3 == 0) {
                macroProps.precision = Precision.unlimited();
            } else {
                macroProps.precision = Precision.minFraction(i3);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void parseIdentifierUnitOption(StringSegment stringSegment, MacroProps macroProps) {
            try {
                macroProps.unit = MeasureUnit.forIdentifier(stringSegment.asString());
            } catch (IllegalArgumentException unused) {
                throw new SkeletonSyntaxException("Invalid unit stem", stringSegment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void parseIncrementOption(StringSegment stringSegment, MacroProps macroProps) {
            try {
                macroProps.precision = Precision.increment(new BigDecimal(stringSegment.subSequence(0, stringSegment.length()).toString()));
            } catch (NumberFormatException e) {
                throw new SkeletonSyntaxException("Invalid rounding increment", stringSegment, e);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void parseIntegerStem(StringSegment stringSegment, MacroProps macroProps) {
            int i = 1;
            while (i < stringSegment.length()) {
                if (stringSegment.charAt(i) != '0') {
                    i--;
                    break;
                }
                i++;
            }
            if (i < stringSegment.length()) {
                throw new SkeletonSyntaxException("Invalid integer stem", stringSegment);
            }
            macroProps.integerWidth = IntegerWidth.zeroFillTo(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void parseIntegerWidthOption(StringSegment stringSegment, MacroProps macroProps) {
            int i;
            int i2;
            int i3 = 0;
            if (NumberSkeletonImpl.isWildcardChar(stringSegment.charAt(0))) {
                i = 1;
                i2 = -1;
            } else {
                i = 0;
                i2 = 0;
            }
            while (i < stringSegment.length() && i2 != -1 && stringSegment.charAt(i) == '#') {
                i2++;
                i++;
            }
            if (i < stringSegment.length()) {
                while (i < stringSegment.length() && stringSegment.charAt(i) == '0') {
                    i3++;
                    i++;
                }
            }
            if (i2 != -1) {
                i2 += i3;
            }
            if (i < stringSegment.length()) {
                throw new SkeletonSyntaxException("Invalid integer width stem", stringSegment);
            }
            if (i2 == -1) {
                macroProps.integerWidth = IntegerWidth.zeroFillTo(i3);
            } else {
                macroProps.integerWidth = IntegerWidth.zeroFillTo(i3).truncateAt(i2);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void parseMeasurePerUnitOption(StringSegment stringSegment, MacroProps macroProps) {
            MeasureUnit measureUnit = macroProps.unit;
            parseMeasureUnitOption(stringSegment, macroProps);
            macroProps.perUnit = macroProps.unit;
            macroProps.unit = measureUnit;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void parseMeasureUnitOption(StringSegment stringSegment, MacroProps macroProps) {
            int i = 0;
            while (i < stringSegment.length() && stringSegment.charAt(i) != '-') {
                i++;
            }
            if (i == stringSegment.length()) {
                throw new SkeletonSyntaxException("Invalid measure unit option", stringSegment);
            }
            MeasureUnit measureUnitValidateAndGet = MeasureUnit.validateAndGet(stringSegment.subSequence(0, i).toString(), stringSegment.subSequence(i + 1, stringSegment.length()).toString());
            if (measureUnitValidateAndGet == null) {
                throw new SkeletonSyntaxException("Unknown measure unit", stringSegment);
            }
            macroProps.unit = measureUnitValidateAndGet;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void parseNumberingSystemOption(StringSegment stringSegment, MacroProps macroProps) {
            NumberingSystem instanceByName = NumberingSystem.getInstanceByName(stringSegment.subSequence(0, stringSegment.length()).toString());
            if (instanceByName == null) {
                throw new SkeletonSyntaxException("Unknown numbering system", stringSegment);
            }
            macroProps.symbols = instanceByName;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void parseScaleOption(StringSegment stringSegment, MacroProps macroProps) {
            try {
                macroProps.scale = Scale.byBigDecimal(new BigDecimal(stringSegment.subSequence(0, stringSegment.length()).toString()));
            } catch (NumberFormatException e) {
                throw new SkeletonSyntaxException("Invalid scale", stringSegment, e);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Code duplicated, block: B:24:0x0050  */
        /* JADX WARN: Code duplicated, block: B:26:0x0058 A[LOOP:0: B:22:0x004a->B:26:0x0058, LOOP_END] */
        /* JADX WARN: Code duplicated, block: B:28:0x005f  */
        /* JADX WARN: Code duplicated, block: B:29:0x0064  */
        /* JADX WARN: Code duplicated, block: B:35:0x0073 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:36:? A[PHI: r1 r2
          PHI (r1v2 int) = (r1v1 int), (r1v5 int) binds: [B:11:0x0023, B:21:0x0048] A[DONT_GENERATE, DONT_INLINE]
          PHI (r2v2 com.ibm.icu.number.NumberFormatter$SignDisplay) = (r2v1 com.ibm.icu.number.NumberFormatter$SignDisplay), (r2v6 com.ibm.icu.number.NumberFormatter$SignDisplay) binds: [B:11:0x0023, B:21:0x0048] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
        public static void parseScientificStem(StringSegment stringSegment, MacroProps macroProps) {
            boolean z;
            ScientificNotation scientificNotationScientific;
            int i = 1;
            if (stringSegment.length() != 1) {
                int i2 = 0;
                if (stringSegment.charAt(1) != 'E') {
                    z = false;
                } else if (stringSegment.length() != 2) {
                    z = true;
                    i = 2;
                }
                NumberFormatter.SignDisplay signDisplay = NumberFormatter.SignDisplay.AUTO;
                if (stringSegment.charAt(i) != '+') {
                    while (i < stringSegment.length()) {
                        if (stringSegment.charAt(i) == '0') {
                            i2++;
                            i++;
                        }
                    }
                    if (z) {
                        scientificNotationScientific = Notation.engineering();
                    } else {
                        scientificNotationScientific = Notation.scientific();
                    }
                    macroProps.notation = scientificNotationScientific.withExponentSignDisplay(signDisplay).withMinExponentDigits(i2);
                    return;
                }
                int i3 = i + 1;
                if (stringSegment.length() != i3) {
                    if (stringSegment.charAt(i3) == '!') {
                        signDisplay = NumberFormatter.SignDisplay.ALWAYS;
                    } else if (stringSegment.charAt(i3) == '?') {
                        signDisplay = NumberFormatter.SignDisplay.EXCEPT_ZERO;
                    }
                    i += 2;
                    if (stringSegment.length() != i) {
                        while (i < stringSegment.length()) {
                            if (stringSegment.charAt(i) == '0') {
                                i2++;
                                i++;
                            }
                        }
                        if (z) {
                            scientificNotationScientific = Notation.engineering();
                        } else {
                            scientificNotationScientific = Notation.scientific();
                        }
                        macroProps.notation = scientificNotationScientific.withExponentSignDisplay(signDisplay).withMinExponentDigits(i2);
                        return;
                    }
                }
            }
            throw new SkeletonSyntaxException("Invalid scientific stem", stringSegment);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean parseTrailingZeroOption(StringSegment stringSegment, MacroProps macroProps) {
            if (!stringSegment.contentEquals("w")) {
                return false;
            }
            macroProps.precision = macroProps.precision.trailingZeroDisplay(NumberFormatter.TrailingZeroDisplay.HIDE_IF_WHOLE);
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void parseUnitUsageOption(StringSegment stringSegment, MacroProps macroProps) {
            macroProps.usage = stringSegment.asString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class EnumToStemString {
        /* JADX INFO: Access modifiers changed from: private */
        public static void decimalSeparatorDisplay(NumberFormatter.DecimalSeparatorDisplay decimalSeparatorDisplay, StringBuilder sb) {
            int i = AnonymousClass2.$SwitchMap$com$ibm$icu$number$NumberFormatter$DecimalSeparatorDisplay[decimalSeparatorDisplay.ordinal()];
            if (i == 1) {
                sb.append("decimal-auto");
            } else {
                if (i != 2) {
                    throw new AssertionError();
                }
                sb.append("decimal-always");
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void groupingStrategy(NumberFormatter.GroupingStrategy groupingStrategy, StringBuilder sb) {
            int i = AnonymousClass2.$SwitchMap$com$ibm$icu$number$NumberFormatter$GroupingStrategy[groupingStrategy.ordinal()];
            if (i == 1) {
                sb.append("group-off");
                return;
            }
            if (i == 2) {
                sb.append("group-min2");
                return;
            }
            if (i == 3) {
                sb.append("group-auto");
            } else if (i == 4) {
                sb.append("group-on-aligned");
            } else {
                if (i != 5) {
                    throw new AssertionError();
                }
                sb.append("group-thousands");
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void roundingMode(RoundingMode roundingMode, StringBuilder sb) {
            switch (AnonymousClass2.$SwitchMap$java$math$RoundingMode[roundingMode.ordinal()]) {
                case 1:
                    sb.append("rounding-mode-ceiling");
                    return;
                case 2:
                    sb.append("rounding-mode-floor");
                    return;
                case 3:
                    sb.append("rounding-mode-down");
                    return;
                case 4:
                    sb.append("rounding-mode-up");
                    return;
                case 5:
                    sb.append("rounding-mode-half-even");
                    return;
                case 6:
                    sb.append("rounding-mode-half-down");
                    return;
                case 7:
                    sb.append("rounding-mode-half-up");
                    return;
                case 8:
                    sb.append("rounding-mode-unnecessary");
                    return;
                default:
                    throw new AssertionError();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void signDisplay(NumberFormatter.SignDisplay signDisplay, StringBuilder sb) {
            switch (AnonymousClass2.$SwitchMap$com$ibm$icu$number$NumberFormatter$SignDisplay[signDisplay.ordinal()]) {
                case 1:
                    sb.append("sign-auto");
                    return;
                case 2:
                    sb.append("sign-always");
                    return;
                case 3:
                    sb.append("sign-never");
                    return;
                case 4:
                    sb.append("sign-accounting");
                    return;
                case 5:
                    sb.append("sign-accounting-always");
                    return;
                case 6:
                    sb.append("sign-except-zero");
                    return;
                case 7:
                    sb.append("sign-accounting-except-zero");
                    return;
                case 8:
                    sb.append("sign-negative");
                    return;
                case 9:
                    sb.append("sign-accounting-negative");
                    return;
                default:
                    throw new AssertionError();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void unitWidth(NumberFormatter.UnitWidth unitWidth, StringBuilder sb) {
            switch (AnonymousClass2.$SwitchMap$com$ibm$icu$number$NumberFormatter$UnitWidth[unitWidth.ordinal()]) {
                case 1:
                    sb.append("unit-width-narrow");
                    return;
                case 2:
                    sb.append("unit-width-short");
                    return;
                case 3:
                    sb.append("unit-width-full-name");
                    return;
                case 4:
                    sb.append("unit-width-iso-code");
                    return;
                case 5:
                    sb.append("unit-width-formal");
                    return;
                case 6:
                    sb.append("unit-width-variant");
                    return;
                case 7:
                    sb.append("unit-width-hidden");
                    return;
                default:
                    throw new AssertionError();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class GeneratorHelpers {
        static final /* synthetic */ boolean $assertionsDisabled = false;

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean decimal(MacroProps macroProps, StringBuilder sb) {
            NumberFormatter.DecimalSeparatorDisplay decimalSeparatorDisplay = macroProps.decimal;
            if (decimalSeparatorDisplay == NumberFormatter.DecimalSeparatorDisplay.AUTO) {
                return false;
            }
            EnumToStemString.decimalSeparatorDisplay(decimalSeparatorDisplay, sb);
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean grouping(MacroProps macroProps, StringBuilder sb) {
            Object obj = macroProps.grouping;
            if (!(obj instanceof NumberFormatter.GroupingStrategy)) {
                dk0.r("Cannot generate number skeleton with custom Grouper");
                return false;
            }
            if (obj == NumberFormatter.GroupingStrategy.AUTO) {
                return false;
            }
            EnumToStemString.groupingStrategy((NumberFormatter.GroupingStrategy) obj, sb);
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean integerWidth(MacroProps macroProps, StringBuilder sb) {
            if (macroProps.integerWidth.equals(IntegerWidth.DEFAULT)) {
                return false;
            }
            IntegerWidth integerWidth = macroProps.integerWidth;
            if (integerWidth.minInt == 0 && integerWidth.maxInt == 0) {
                sb.append("integer-width-trunc");
                return true;
            }
            sb.append("integer-width/");
            IntegerWidth integerWidth2 = macroProps.integerWidth;
            BlueprintHelpers.generateIntegerWidthOption(integerWidth2.minInt, integerWidth2.maxInt, sb);
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean notation(MacroProps macroProps, StringBuilder sb) {
            Notation notation = macroProps.notation;
            if (notation instanceof CompactNotation) {
                if (notation == Notation.compactLong()) {
                    sb.append("compact-long");
                    return true;
                }
                if (macroProps.notation == Notation.compactShort()) {
                    sb.append("compact-short");
                    return true;
                }
                dk0.r("Cannot generate number skeleton with custom compact data");
                return false;
            }
            if (!(notation instanceof ScientificNotation)) {
                return false;
            }
            ScientificNotation scientificNotation = (ScientificNotation) notation;
            if (scientificNotation.engineeringInterval == 3) {
                sb.append("engineering");
            } else {
                sb.append("scientific");
            }
            if (scientificNotation.minExponentDigits > 1) {
                sb.append('/');
                BlueprintHelpers.generateExponentWidthOption(scientificNotation.minExponentDigits, sb);
            }
            if (scientificNotation.exponentSignDisplay != NumberFormatter.SignDisplay.AUTO) {
                sb.append('/');
                EnumToStemString.signDisplay(scientificNotation.exponentSignDisplay, sb);
            }
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean precision(MacroProps macroProps, StringBuilder sb) {
            Precision precision = macroProps.precision;
            if (precision instanceof Precision.InfiniteRounderImpl) {
                sb.append("precision-unlimited");
            } else if (precision instanceof Precision.FractionRounderImpl) {
                Precision.FractionRounderImpl fractionRounderImpl = (Precision.FractionRounderImpl) precision;
                BlueprintHelpers.generateFractionStem(fractionRounderImpl.minFrac, fractionRounderImpl.maxFrac, sb);
            } else if (precision instanceof Precision.SignificantRounderImpl) {
                Precision.SignificantRounderImpl significantRounderImpl = (Precision.SignificantRounderImpl) precision;
                BlueprintHelpers.generateDigitsStem(significantRounderImpl.minSig, significantRounderImpl.maxSig, sb);
            } else if (precision instanceof Precision.FracSigRounderImpl) {
                Precision.FracSigRounderImpl fracSigRounderImpl = (Precision.FracSigRounderImpl) precision;
                BlueprintHelpers.generateFractionStem(fracSigRounderImpl.minFrac, fracSigRounderImpl.maxFrac, sb);
                sb.append('/');
                if (fracSigRounderImpl.retain) {
                    NumberFormatter.RoundingPriority roundingPriority = fracSigRounderImpl.priority;
                    NumberFormatter.RoundingPriority roundingPriority2 = NumberFormatter.RoundingPriority.RELAXED;
                    int i = fracSigRounderImpl.maxSig;
                    if (roundingPriority == roundingPriority2) {
                        BlueprintHelpers.generateDigitsStem(i, -1, sb);
                    } else {
                        BlueprintHelpers.generateDigitsStem(1, i, sb);
                    }
                } else {
                    BlueprintHelpers.generateDigitsStem(fracSigRounderImpl.minSig, fracSigRounderImpl.maxSig, sb);
                    if (fracSigRounderImpl.priority == NumberFormatter.RoundingPriority.RELAXED) {
                        sb.append('r');
                    } else {
                        sb.append('s');
                    }
                }
            } else if (precision instanceof Precision.IncrementRounderImpl) {
                sb.append("precision-increment/");
                BlueprintHelpers.generateIncrementOption(((Precision.IncrementRounderImpl) precision).increment, sb);
            } else if (((Precision.CurrencyRounderImpl) precision).usage == Currency.CurrencyUsage.STANDARD) {
                sb.append("precision-currency-standard");
            } else {
                sb.append("precision-currency-cash");
            }
            if (macroProps.precision.trailingZeroDisplay == NumberFormatter.TrailingZeroDisplay.HIDE_IF_WHOLE) {
                sb.append("/w");
            }
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean roundingMode(MacroProps macroProps, StringBuilder sb) {
            RoundingMode roundingMode = macroProps.roundingMode;
            if (roundingMode == RoundingUtils.DEFAULT_ROUNDING_MODE) {
                return false;
            }
            EnumToStemString.roundingMode(roundingMode, sb);
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean scale(MacroProps macroProps, StringBuilder sb) {
            if (!macroProps.scale.isValid()) {
                return false;
            }
            sb.append("scale/");
            BlueprintHelpers.generateScaleOption(macroProps.scale, sb);
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean sign(MacroProps macroProps, StringBuilder sb) {
            NumberFormatter.SignDisplay signDisplay = macroProps.sign;
            if (signDisplay == NumberFormatter.SignDisplay.AUTO) {
                return false;
            }
            EnumToStemString.signDisplay(signDisplay, sb);
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean symbols(MacroProps macroProps, StringBuilder sb) {
            Object obj = macroProps.symbols;
            if (!(obj instanceof NumberingSystem)) {
                dk0.r("Cannot generate number skeleton with custom DecimalFormatSymbols");
                return false;
            }
            NumberingSystem numberingSystem = (NumberingSystem) obj;
            if (numberingSystem.getName().equals("latn")) {
                sb.append("latin");
                return true;
            }
            sb.append("numbering-system/");
            BlueprintHelpers.generateNumberingSystemOption(numberingSystem, sb);
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean unit(MacroProps macroProps, StringBuilder sb) {
            MeasureUnit measureUnitProduct = macroProps.unit;
            MeasureUnit measureUnit = macroProps.perUnit;
            if (measureUnit != null) {
                if ((measureUnitProduct instanceof Currency) || (measureUnit instanceof Currency)) {
                    dk0.r("Cannot generate number skeleton with currency unit and per-unit");
                    return false;
                }
                measureUnitProduct = measureUnitProduct.product(measureUnit.reciprocal());
            }
            if (measureUnitProduct instanceof Currency) {
                sb.append("currency/");
                BlueprintHelpers.generateCurrencyOption((Currency) measureUnitProduct, sb);
                return true;
            }
            if (measureUnitProduct.equals(MeasureUnit.PERCENT)) {
                sb.append("percent");
                return true;
            }
            if (measureUnitProduct.equals(MeasureUnit.PERMILLE)) {
                sb.append("permille");
                return true;
            }
            sb.append("unit/");
            sb.append(measureUnitProduct.getIdentifier());
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean unitWidth(MacroProps macroProps, StringBuilder sb) {
            NumberFormatter.UnitWidth unitWidth = macroProps.unitWidth;
            if (unitWidth == NumberFormatter.UnitWidth.SHORT) {
                return false;
            }
            EnumToStemString.unitWidth(unitWidth, sb);
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean usage(MacroProps macroProps, StringBuilder sb) {
            String str = macroProps.usage;
            if (str == null || str.length() <= 0) {
                return false;
            }
            sb.append("usage/");
            sb.append(macroProps.usage);
            return true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public enum ParseState {
        STATE_NULL,
        STATE_SCIENTIFIC,
        STATE_FRACTION_PRECISION,
        STATE_PRECISION,
        STATE_INCREMENT_PRECISION,
        STATE_MEASURE_UNIT,
        STATE_PER_MEASURE_UNIT,
        STATE_IDENTIFIER_UNIT,
        STATE_UNIT_USAGE,
        STATE_CURRENCY_UNIT,
        STATE_INTEGER_WIDTH,
        STATE_NUMBERING_SYSTEM,
        STATE_SCALE
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public enum StemEnum {
        STEM_COMPACT_SHORT,
        STEM_COMPACT_LONG,
        STEM_SCIENTIFIC,
        STEM_ENGINEERING,
        STEM_NOTATION_SIMPLE,
        STEM_BASE_UNIT,
        STEM_PERCENT,
        STEM_PERMILLE,
        STEM_PERCENT_100,
        STEM_PRECISION_INTEGER,
        STEM_PRECISION_UNLIMITED,
        STEM_PRECISION_CURRENCY_STANDARD,
        STEM_PRECISION_CURRENCY_CASH,
        STEM_ROUNDING_MODE_CEILING,
        STEM_ROUNDING_MODE_FLOOR,
        STEM_ROUNDING_MODE_DOWN,
        STEM_ROUNDING_MODE_UP,
        STEM_ROUNDING_MODE_HALF_EVEN,
        STEM_ROUNDING_MODE_HALF_DOWN,
        STEM_ROUNDING_MODE_HALF_UP,
        STEM_ROUNDING_MODE_UNNECESSARY,
        STEM_INTEGER_WIDTH_TRUNC,
        STEM_GROUP_OFF,
        STEM_GROUP_MIN2,
        STEM_GROUP_AUTO,
        STEM_GROUP_ON_ALIGNED,
        STEM_GROUP_THOUSANDS,
        STEM_LATIN,
        STEM_UNIT_WIDTH_NARROW,
        STEM_UNIT_WIDTH_SHORT,
        STEM_UNIT_WIDTH_FULL_NAME,
        STEM_UNIT_WIDTH_ISO_CODE,
        STEM_UNIT_WIDTH_FORMAL,
        STEM_UNIT_WIDTH_VARIANT,
        STEM_UNIT_WIDTH_HIDDEN,
        STEM_SIGN_AUTO,
        STEM_SIGN_ALWAYS,
        STEM_SIGN_NEVER,
        STEM_SIGN_ACCOUNTING,
        STEM_SIGN_ACCOUNTING_ALWAYS,
        STEM_SIGN_EXCEPT_ZERO,
        STEM_SIGN_ACCOUNTING_EXCEPT_ZERO,
        STEM_SIGN_NEGATIVE,
        STEM_SIGN_ACCOUNTING_NEGATIVE,
        STEM_DECIMAL_AUTO,
        STEM_DECIMAL_ALWAYS,
        STEM_PRECISION_INCREMENT,
        STEM_MEASURE_UNIT,
        STEM_PER_MEASURE_UNIT,
        STEM_UNIT,
        STEM_UNIT_USAGE,
        STEM_CURRENCY,
        STEM_INTEGER_WIDTH,
        STEM_NUMBERING_SYSTEM,
        STEM_SCALE
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class StemToObject {
        /* JADX INFO: Access modifiers changed from: private */
        public static NumberFormatter.DecimalSeparatorDisplay decimalSeparatorDisplay(StemEnum stemEnum) {
            int i = AnonymousClass2.$SwitchMap$com$ibm$icu$number$NumberSkeletonImpl$StemEnum[stemEnum.ordinal()];
            if (i == 42) {
                return NumberFormatter.DecimalSeparatorDisplay.AUTO;
            }
            if (i != 43) {
                return null;
            }
            return NumberFormatter.DecimalSeparatorDisplay.ALWAYS;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static NumberFormatter.GroupingStrategy groupingStrategy(StemEnum stemEnum) {
            switch (AnonymousClass2.$SwitchMap$com$ibm$icu$number$NumberSkeletonImpl$StemEnum[stemEnum.ordinal()]) {
                case 21:
                    return NumberFormatter.GroupingStrategy.OFF;
                case 22:
                    return NumberFormatter.GroupingStrategy.MIN2;
                case 23:
                    return NumberFormatter.GroupingStrategy.AUTO;
                case 24:
                    return NumberFormatter.GroupingStrategy.ON_ALIGNED;
                case 25:
                    return NumberFormatter.GroupingStrategy.THOUSANDS;
                default:
                    return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static Notation notation(StemEnum stemEnum) {
            int i = AnonymousClass2.$SwitchMap$com$ibm$icu$number$NumberSkeletonImpl$StemEnum[stemEnum.ordinal()];
            if (i == 1) {
                return Notation.compactShort();
            }
            if (i == 2) {
                return Notation.compactLong();
            }
            if (i == 3) {
                return Notation.scientific();
            }
            if (i == 4) {
                return Notation.engineering();
            }
            if (i == 5) {
                return Notation.simple();
            }
            throw new AssertionError();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static Precision precision(StemEnum stemEnum) {
            switch (AnonymousClass2.$SwitchMap$com$ibm$icu$number$NumberSkeletonImpl$StemEnum[stemEnum.ordinal()]) {
                case 9:
                    return Precision.integer();
                case 10:
                    return Precision.unlimited();
                case 11:
                    return Precision.currency(Currency.CurrencyUsage.STANDARD);
                case 12:
                    return Precision.currency(Currency.CurrencyUsage.CASH);
                default:
                    throw new AssertionError();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static RoundingMode roundingMode(StemEnum stemEnum) {
            switch (AnonymousClass2.$SwitchMap$com$ibm$icu$number$NumberSkeletonImpl$StemEnum[stemEnum.ordinal()]) {
                case 13:
                    return RoundingMode.CEILING;
                case 14:
                    return RoundingMode.FLOOR;
                case 15:
                    return RoundingMode.DOWN;
                case 16:
                    return RoundingMode.UP;
                case 17:
                    return RoundingMode.HALF_EVEN;
                case 18:
                    return RoundingMode.HALF_DOWN;
                case 19:
                    return RoundingMode.HALF_UP;
                case 20:
                    return RoundingMode.UNNECESSARY;
                default:
                    throw new AssertionError();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static NumberFormatter.SignDisplay signDisplay(StemEnum stemEnum) {
            switch (AnonymousClass2.$SwitchMap$com$ibm$icu$number$NumberSkeletonImpl$StemEnum[stemEnum.ordinal()]) {
                case 33:
                    return NumberFormatter.SignDisplay.AUTO;
                case 34:
                    return NumberFormatter.SignDisplay.ALWAYS;
                case 35:
                    return NumberFormatter.SignDisplay.NEVER;
                case 36:
                    return NumberFormatter.SignDisplay.ACCOUNTING;
                case 37:
                    return NumberFormatter.SignDisplay.ACCOUNTING_ALWAYS;
                case 38:
                    return NumberFormatter.SignDisplay.EXCEPT_ZERO;
                case 39:
                    return NumberFormatter.SignDisplay.ACCOUNTING_EXCEPT_ZERO;
                case 40:
                    return NumberFormatter.SignDisplay.NEGATIVE;
                case 41:
                    return NumberFormatter.SignDisplay.ACCOUNTING_NEGATIVE;
                default:
                    return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static MeasureUnit unit(StemEnum stemEnum) {
            int i = AnonymousClass2.$SwitchMap$com$ibm$icu$number$NumberSkeletonImpl$StemEnum[stemEnum.ordinal()];
            if (i == 6) {
                return NoUnit.BASE;
            }
            if (i == 7) {
                return NoUnit.PERCENT;
            }
            if (i == 8) {
                return NoUnit.PERMILLE;
            }
            throw new AssertionError();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static NumberFormatter.UnitWidth unitWidth(StemEnum stemEnum) {
            switch (AnonymousClass2.$SwitchMap$com$ibm$icu$number$NumberSkeletonImpl$StemEnum[stemEnum.ordinal()]) {
                case 26:
                    return NumberFormatter.UnitWidth.NARROW;
                case 27:
                    return NumberFormatter.UnitWidth.SHORT;
                case 28:
                    return NumberFormatter.UnitWidth.FULL_NAME;
                case 29:
                    return NumberFormatter.UnitWidth.ISO_CODE;
                case 30:
                    return NumberFormatter.UnitWidth.FORMAL;
                case 31:
                    return NumberFormatter.UnitWidth.VARIANT;
                case 32:
                    return NumberFormatter.UnitWidth.HIDDEN;
                default:
                    return null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void appendMultiple(StringBuilder sb, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            sb.appendCodePoint(i);
        }
    }

    public static String buildStemTrie() {
        CharsTrieBuilder charsTrieBuilder = new CharsTrieBuilder();
        StemEnum stemEnum = StemEnum.STEM_COMPACT_SHORT;
        charsTrieBuilder.add("compact-short", stemEnum.ordinal());
        StemEnum stemEnum2 = StemEnum.STEM_COMPACT_LONG;
        charsTrieBuilder.add("compact-long", stemEnum2.ordinal());
        charsTrieBuilder.add("scientific", StemEnum.STEM_SCIENTIFIC.ordinal());
        charsTrieBuilder.add("engineering", StemEnum.STEM_ENGINEERING.ordinal());
        charsTrieBuilder.add("notation-simple", StemEnum.STEM_NOTATION_SIMPLE.ordinal());
        charsTrieBuilder.add("base-unit", StemEnum.STEM_BASE_UNIT.ordinal());
        StemEnum stemEnum3 = StemEnum.STEM_PERCENT;
        charsTrieBuilder.add("percent", stemEnum3.ordinal());
        charsTrieBuilder.add("permille", StemEnum.STEM_PERMILLE.ordinal());
        charsTrieBuilder.add("precision-integer", StemEnum.STEM_PRECISION_INTEGER.ordinal());
        charsTrieBuilder.add("precision-unlimited", StemEnum.STEM_PRECISION_UNLIMITED.ordinal());
        charsTrieBuilder.add("precision-currency-standard", StemEnum.STEM_PRECISION_CURRENCY_STANDARD.ordinal());
        charsTrieBuilder.add("precision-currency-cash", StemEnum.STEM_PRECISION_CURRENCY_CASH.ordinal());
        charsTrieBuilder.add("rounding-mode-ceiling", StemEnum.STEM_ROUNDING_MODE_CEILING.ordinal());
        charsTrieBuilder.add("rounding-mode-floor", StemEnum.STEM_ROUNDING_MODE_FLOOR.ordinal());
        charsTrieBuilder.add("rounding-mode-down", StemEnum.STEM_ROUNDING_MODE_DOWN.ordinal());
        charsTrieBuilder.add("rounding-mode-up", StemEnum.STEM_ROUNDING_MODE_UP.ordinal());
        charsTrieBuilder.add("rounding-mode-half-even", StemEnum.STEM_ROUNDING_MODE_HALF_EVEN.ordinal());
        charsTrieBuilder.add("rounding-mode-half-down", StemEnum.STEM_ROUNDING_MODE_HALF_DOWN.ordinal());
        charsTrieBuilder.add("rounding-mode-half-up", StemEnum.STEM_ROUNDING_MODE_HALF_UP.ordinal());
        charsTrieBuilder.add("rounding-mode-unnecessary", StemEnum.STEM_ROUNDING_MODE_UNNECESSARY.ordinal());
        charsTrieBuilder.add("integer-width-trunc", StemEnum.STEM_INTEGER_WIDTH_TRUNC.ordinal());
        StemEnum stemEnum4 = StemEnum.STEM_GROUP_OFF;
        charsTrieBuilder.add("group-off", stemEnum4.ordinal());
        StemEnum stemEnum5 = StemEnum.STEM_GROUP_MIN2;
        charsTrieBuilder.add("group-min2", stemEnum5.ordinal());
        charsTrieBuilder.add("group-auto", StemEnum.STEM_GROUP_AUTO.ordinal());
        StemEnum stemEnum6 = StemEnum.STEM_GROUP_ON_ALIGNED;
        charsTrieBuilder.add("group-on-aligned", stemEnum6.ordinal());
        charsTrieBuilder.add("group-thousands", StemEnum.STEM_GROUP_THOUSANDS.ordinal());
        charsTrieBuilder.add("latin", StemEnum.STEM_LATIN.ordinal());
        charsTrieBuilder.add("unit-width-narrow", StemEnum.STEM_UNIT_WIDTH_NARROW.ordinal());
        charsTrieBuilder.add("unit-width-short", StemEnum.STEM_UNIT_WIDTH_SHORT.ordinal());
        charsTrieBuilder.add("unit-width-full-name", StemEnum.STEM_UNIT_WIDTH_FULL_NAME.ordinal());
        charsTrieBuilder.add("unit-width-iso-code", StemEnum.STEM_UNIT_WIDTH_ISO_CODE.ordinal());
        charsTrieBuilder.add("unit-width-formal", StemEnum.STEM_UNIT_WIDTH_FORMAL.ordinal());
        charsTrieBuilder.add("unit-width-variant", StemEnum.STEM_UNIT_WIDTH_VARIANT.ordinal());
        charsTrieBuilder.add("unit-width-hidden", StemEnum.STEM_UNIT_WIDTH_HIDDEN.ordinal());
        charsTrieBuilder.add("sign-auto", StemEnum.STEM_SIGN_AUTO.ordinal());
        StemEnum stemEnum7 = StemEnum.STEM_SIGN_ALWAYS;
        charsTrieBuilder.add("sign-always", stemEnum7.ordinal());
        StemEnum stemEnum8 = StemEnum.STEM_SIGN_NEVER;
        charsTrieBuilder.add("sign-never", stemEnum8.ordinal());
        StemEnum stemEnum9 = StemEnum.STEM_SIGN_ACCOUNTING;
        charsTrieBuilder.add("sign-accounting", stemEnum9.ordinal());
        StemEnum stemEnum10 = StemEnum.STEM_SIGN_ACCOUNTING_ALWAYS;
        charsTrieBuilder.add("sign-accounting-always", stemEnum10.ordinal());
        StemEnum stemEnum11 = StemEnum.STEM_SIGN_EXCEPT_ZERO;
        charsTrieBuilder.add("sign-except-zero", stemEnum11.ordinal());
        StemEnum stemEnum12 = StemEnum.STEM_SIGN_ACCOUNTING_EXCEPT_ZERO;
        charsTrieBuilder.add("sign-accounting-except-zero", stemEnum12.ordinal());
        StemEnum stemEnum13 = StemEnum.STEM_SIGN_NEGATIVE;
        charsTrieBuilder.add("sign-negative", stemEnum13.ordinal());
        StemEnum stemEnum14 = StemEnum.STEM_SIGN_ACCOUNTING_NEGATIVE;
        charsTrieBuilder.add("sign-accounting-negative", stemEnum14.ordinal());
        charsTrieBuilder.add("decimal-auto", StemEnum.STEM_DECIMAL_AUTO.ordinal());
        charsTrieBuilder.add("decimal-always", StemEnum.STEM_DECIMAL_ALWAYS.ordinal());
        charsTrieBuilder.add("precision-increment", StemEnum.STEM_PRECISION_INCREMENT.ordinal());
        charsTrieBuilder.add("measure-unit", StemEnum.STEM_MEASURE_UNIT.ordinal());
        charsTrieBuilder.add("per-measure-unit", StemEnum.STEM_PER_MEASURE_UNIT.ordinal());
        charsTrieBuilder.add("unit", StemEnum.STEM_UNIT.ordinal());
        charsTrieBuilder.add("usage", StemEnum.STEM_UNIT_USAGE.ordinal());
        charsTrieBuilder.add("currency", StemEnum.STEM_CURRENCY.ordinal());
        charsTrieBuilder.add("integer-width", StemEnum.STEM_INTEGER_WIDTH.ordinal());
        charsTrieBuilder.add("numbering-system", StemEnum.STEM_NUMBERING_SYSTEM.ordinal());
        charsTrieBuilder.add("scale", StemEnum.STEM_SCALE.ordinal());
        charsTrieBuilder.add("K", stemEnum.ordinal());
        charsTrieBuilder.add("KK", stemEnum2.ordinal());
        charsTrieBuilder.add("%", stemEnum3.ordinal());
        charsTrieBuilder.add("%x100", StemEnum.STEM_PERCENT_100.ordinal());
        charsTrieBuilder.add(",_", stemEnum4.ordinal());
        charsTrieBuilder.add(",?", stemEnum5.ordinal());
        charsTrieBuilder.add(",!", stemEnum6.ordinal());
        charsTrieBuilder.add("+!", stemEnum7.ordinal());
        charsTrieBuilder.add("+_", stemEnum8.ordinal());
        charsTrieBuilder.add("()", stemEnum9.ordinal());
        charsTrieBuilder.add("()!", stemEnum10.ordinal());
        charsTrieBuilder.add("+?", stemEnum11.ordinal());
        charsTrieBuilder.add("()?", stemEnum12.ordinal());
        charsTrieBuilder.add("+-", stemEnum13.ordinal());
        charsTrieBuilder.add("()-", stemEnum14.ordinal());
        return charsTrieBuilder.buildCharSequence(StringTrieBuilder.Option.FAST).toString();
    }

    private static void checkNull(Object obj, CharSequence charSequence) {
        if (obj != null) {
            throw new SkeletonSyntaxException("Duplicated setting", charSequence);
        }
    }

    public static UnlocalizedNumberFormatter create(String str) {
        return NumberFormatter.with().macros(parseSkeleton(str));
    }

    public static String generate(MacroProps macroProps) {
        StringBuilder sb = new StringBuilder();
        generateSkeleton(macroProps, sb);
        return sb.toString();
    }

    private static void generateSkeleton(MacroProps macroProps, StringBuilder sb) {
        if (macroProps.notation != null && GeneratorHelpers.notation(macroProps, sb)) {
            sb.append(' ');
        }
        if (macroProps.unit != null && GeneratorHelpers.unit(macroProps, sb)) {
            sb.append(' ');
        }
        if (macroProps.usage != null && GeneratorHelpers.usage(macroProps, sb)) {
            sb.append(' ');
        }
        if (macroProps.precision != null && GeneratorHelpers.precision(macroProps, sb)) {
            sb.append(' ');
        }
        if (macroProps.roundingMode != null && GeneratorHelpers.roundingMode(macroProps, sb)) {
            sb.append(' ');
        }
        if (macroProps.grouping != null && GeneratorHelpers.grouping(macroProps, sb)) {
            sb.append(' ');
        }
        if (macroProps.integerWidth != null && GeneratorHelpers.integerWidth(macroProps, sb)) {
            sb.append(' ');
        }
        if (macroProps.symbols != null && GeneratorHelpers.symbols(macroProps, sb)) {
            sb.append(' ');
        }
        if (macroProps.unitWidth != null && GeneratorHelpers.unitWidth(macroProps, sb)) {
            sb.append(' ');
        }
        if (macroProps.sign != null && GeneratorHelpers.sign(macroProps, sb)) {
            sb.append(' ');
        }
        if (macroProps.decimal != null && GeneratorHelpers.decimal(macroProps, sb)) {
            sb.append(' ');
        }
        if (macroProps.scale != null && GeneratorHelpers.scale(macroProps, sb)) {
            sb.append(' ');
        }
        if (macroProps.padder != null) {
            dk0.r("Cannot generate number skeleton with custom padder");
            return;
        }
        String str = macroProps.unitDisplayCase;
        if (str != null && !str.isEmpty()) {
            dk0.r("Cannot generate number skeleton with custom unit display case");
            return;
        }
        if (macroProps.affixProvider != null) {
            dk0.r("Cannot generate number skeleton with custom affix provider");
        } else if (macroProps.rules != null) {
            dk0.r("Cannot generate number skeleton with custom plural rules");
        } else if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
        }
    }

    public static UnlocalizedNumberFormatter getOrCreate(String str) {
        return cache.getInstance(str, null);
    }

    public static boolean isWildcardChar(char c) {
        return c == '*' || c == '+';
    }

    private static ParseState parseOption(ParseState parseState, StringSegment stringSegment, MacroProps macroProps) {
        int[] iArr = AnonymousClass2.$SwitchMap$com$ibm$icu$number$NumberSkeletonImpl$ParseState;
        switch (iArr[parseState.ordinal()]) {
            case 1:
                BlueprintHelpers.parseIncrementOption(stringSegment, macroProps);
                return ParseState.STATE_PRECISION;
            case 2:
                BlueprintHelpers.parseMeasureUnitOption(stringSegment, macroProps);
                return ParseState.STATE_NULL;
            case 3:
                BlueprintHelpers.parseMeasurePerUnitOption(stringSegment, macroProps);
                return ParseState.STATE_NULL;
            case 4:
                BlueprintHelpers.parseIdentifierUnitOption(stringSegment, macroProps);
                return ParseState.STATE_NULL;
            case 5:
                BlueprintHelpers.parseUnitUsageOption(stringSegment, macroProps);
                return ParseState.STATE_NULL;
            case 6:
                BlueprintHelpers.parseCurrencyOption(stringSegment, macroProps);
                return ParseState.STATE_NULL;
            case 7:
                BlueprintHelpers.parseIntegerWidthOption(stringSegment, macroProps);
                return ParseState.STATE_NULL;
            case 8:
                BlueprintHelpers.parseNumberingSystemOption(stringSegment, macroProps);
                return ParseState.STATE_NULL;
            case 9:
                BlueprintHelpers.parseScaleOption(stringSegment, macroProps);
                return ParseState.STATE_NULL;
            default:
                if (iArr[parseState.ordinal()] == 10) {
                    if (BlueprintHelpers.parseExponentWidthOption(stringSegment, macroProps)) {
                        return ParseState.STATE_SCIENTIFIC;
                    }
                    if (BlueprintHelpers.parseExponentSignOption(stringSegment, macroProps)) {
                        return ParseState.STATE_SCIENTIFIC;
                    }
                }
                if (iArr[parseState.ordinal()] == 11) {
                    if (BlueprintHelpers.parseFracSigOption(stringSegment, macroProps)) {
                        return ParseState.STATE_PRECISION;
                    }
                    parseState = ParseState.STATE_PRECISION;
                }
                if (iArr[parseState.ordinal()] == 12 && BlueprintHelpers.parseTrailingZeroOption(stringSegment, macroProps)) {
                    return ParseState.STATE_NULL;
                }
                throw new SkeletonSyntaxException("Invalid option", stringSegment);
        }
    }

    private static MacroProps parseSkeleton(String str) {
        ParseState parseState;
        String strJ = ky0.j(str, Padder.FALLBACK_PADDING_STRING);
        MacroProps macroProps = new MacroProps();
        StringSegment stringSegment = new StringSegment(strJ, false);
        CharsTrie charsTrie = new CharsTrie(SERIALIZED_STEM_TRIE, 0);
        ParseState option = ParseState.STATE_NULL;
        int iCharCount = 0;
        while (iCharCount < stringSegment.length()) {
            int iCodePointAt = stringSegment.codePointAt(iCharCount);
            boolean zIsWhiteSpace = PatternProps.isWhiteSpace(iCodePointAt);
            boolean z = iCodePointAt == 47;
            if (zIsWhiteSpace || z) {
                if (iCharCount != 0) {
                    stringSegment.setLength(iCharCount);
                    if (option == ParseState.STATE_NULL) {
                        option = parseStem(stringSegment, charsTrie, macroProps);
                        charsTrie.reset();
                    } else {
                        option = parseOption(option, stringSegment, macroProps);
                    }
                    stringSegment.resetLength();
                    stringSegment.adjustOffset(iCharCount);
                    iCharCount = 0;
                } else if (option != ParseState.STATE_NULL) {
                    stringSegment.setLength(Character.charCount(iCodePointAt));
                    throw new SkeletonSyntaxException("Unexpected separator character", stringSegment);
                }
                if (z && option == ParseState.STATE_NULL) {
                    stringSegment.setLength(Character.charCount(iCodePointAt));
                    throw new SkeletonSyntaxException("Unexpected option separator", stringSegment);
                }
                if (zIsWhiteSpace && option != (parseState = ParseState.STATE_NULL)) {
                    switch (AnonymousClass2.$SwitchMap$com$ibm$icu$number$NumberSkeletonImpl$ParseState[option.ordinal()]) {
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                        case 7:
                        case 8:
                        case 9:
                            stringSegment.setLength(Character.charCount(iCodePointAt));
                            throw new SkeletonSyntaxException("Stem requires an option", stringSegment);
                        default:
                            option = parseState;
                            break;
                    }
                }
                stringSegment.adjustOffset(Character.charCount(iCodePointAt));
            } else {
                iCharCount += Character.charCount(iCodePointAt);
                if (option == ParseState.STATE_NULL) {
                    charsTrie.nextForCodePoint(iCodePointAt);
                }
            }
        }
        return macroProps;
    }

    private static ParseState parseStem(StringSegment stringSegment, CharsTrie charsTrie, MacroProps macroProps) {
        char cCharAt = stringSegment.charAt(0);
        if (cCharAt == '.') {
            checkNull(macroProps.precision, stringSegment);
            BlueprintHelpers.parseFractionStem(stringSegment, macroProps);
            return ParseState.STATE_FRACTION_PRECISION;
        }
        if (cCharAt == '0') {
            checkNull(macroProps.integerWidth, stringSegment);
            BlueprintHelpers.parseIntegerStem(stringSegment, macroProps);
            return ParseState.STATE_NULL;
        }
        if (cCharAt == '@') {
            checkNull(macroProps.precision, stringSegment);
            BlueprintHelpers.parseDigitsStem(stringSegment, macroProps);
            return ParseState.STATE_PRECISION;
        }
        if (cCharAt == 'E') {
            checkNull(macroProps.notation, stringSegment);
            BlueprintHelpers.parseScientificStem(stringSegment, macroProps);
            return ParseState.STATE_NULL;
        }
        BytesTrie.Result resultCurrent = charsTrie.current();
        if (resultCurrent != BytesTrie.Result.INTERMEDIATE_VALUE && resultCurrent != BytesTrie.Result.FINAL_VALUE) {
            throw new SkeletonSyntaxException("Unknown stem", stringSegment);
        }
        StemEnum stemEnum = STEM_ENUM_VALUES[charsTrie.getValue()];
        int[] iArr = AnonymousClass2.$SwitchMap$com$ibm$icu$number$NumberSkeletonImpl$StemEnum;
        switch (iArr[stemEnum.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                checkNull(macroProps.notation, stringSegment);
                macroProps.notation = StemToObject.notation(stemEnum);
                int i = iArr[stemEnum.ordinal()];
                return (i == 3 || i == 4) ? ParseState.STATE_SCIENTIFIC : ParseState.STATE_NULL;
            case 6:
            case 7:
            case 8:
                checkNull(macroProps.unit, stringSegment);
                macroProps.unit = StemToObject.unit(stemEnum);
                return ParseState.STATE_NULL;
            case 9:
            case 10:
            case 11:
            case 12:
                checkNull(macroProps.precision, stringSegment);
                macroProps.precision = StemToObject.precision(stemEnum);
                return iArr[stemEnum.ordinal()] != 9 ? ParseState.STATE_PRECISION : ParseState.STATE_FRACTION_PRECISION;
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
                checkNull(macroProps.roundingMode, stringSegment);
                macroProps.roundingMode = StemToObject.roundingMode(stemEnum);
                return ParseState.STATE_NULL;
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
                checkNull(macroProps.grouping, stringSegment);
                macroProps.grouping = StemToObject.groupingStrategy(stemEnum);
                return ParseState.STATE_NULL;
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
                checkNull(macroProps.unitWidth, stringSegment);
                macroProps.unitWidth = StemToObject.unitWidth(stemEnum);
                return ParseState.STATE_NULL;
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
                checkNull(macroProps.sign, stringSegment);
                macroProps.sign = StemToObject.signDisplay(stemEnum);
                return ParseState.STATE_NULL;
            case 42:
            case 43:
                checkNull(macroProps.decimal, stringSegment);
                macroProps.decimal = StemToObject.decimalSeparatorDisplay(stemEnum);
                return ParseState.STATE_NULL;
            case 44:
                checkNull(macroProps.scale, stringSegment);
                checkNull(macroProps.unit, stringSegment);
                macroProps.scale = Scale.powerOfTen(2);
                macroProps.unit = NoUnit.PERCENT;
                return ParseState.STATE_NULL;
            case 45:
                checkNull(macroProps.integerWidth, stringSegment);
                macroProps.integerWidth = IntegerWidth.zeroFillTo(0).truncateAt(0);
                return ParseState.STATE_NULL;
            case 46:
                checkNull(macroProps.symbols, stringSegment);
                macroProps.symbols = NumberingSystem.LATIN;
                return ParseState.STATE_NULL;
            case 47:
                checkNull(macroProps.precision, stringSegment);
                return ParseState.STATE_INCREMENT_PRECISION;
            case 48:
                checkNull(macroProps.unit, stringSegment);
                return ParseState.STATE_MEASURE_UNIT;
            case 49:
                if (macroProps.unit instanceof Currency) {
                    throw new SkeletonSyntaxException("Duplicated setting", stringSegment);
                }
                checkNull(macroProps.perUnit, stringSegment);
                return ParseState.STATE_PER_MEASURE_UNIT;
            case 50:
                checkNull(macroProps.unit, stringSegment);
                checkNull(macroProps.perUnit, stringSegment);
                return ParseState.STATE_IDENTIFIER_UNIT;
            case 51:
                checkNull(macroProps.usage, stringSegment);
                return ParseState.STATE_UNIT_USAGE;
            case 52:
                checkNull(macroProps.unit, stringSegment);
                checkNull(macroProps.perUnit, stringSegment);
                return ParseState.STATE_CURRENCY_UNIT;
            case 53:
                checkNull(macroProps.integerWidth, stringSegment);
                return ParseState.STATE_INTEGER_WIDTH;
            case 54:
                checkNull(macroProps.symbols, stringSegment);
                return ParseState.STATE_NUMBERING_SYSTEM;
            case 55:
                checkNull(macroProps.scale, stringSegment);
                return ParseState.STATE_SCALE;
            default:
                throw new AssertionError();
        }
    }
}
