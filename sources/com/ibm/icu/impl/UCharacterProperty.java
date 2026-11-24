package com.ibm.icu.impl;

import com.ibm.icu.lang.UCharacter;
import com.ibm.icu.lang.UProperty;
import com.ibm.icu.lang.UScript;
import com.ibm.icu.text.ArabicShaping;
import com.ibm.icu.text.Normalizer;
import com.ibm.icu.text.Normalizer2;
import com.ibm.icu.text.UTF16;
import com.ibm.icu.text.UnicodeSet;
import com.ibm.icu.util.CodePointMap;
import com.ibm.icu.util.CodePointTrie;
import com.ibm.icu.util.ICUUncheckedIOException;
import com.ibm.icu.util.VersionInfo;
import defpackage.dk0;
import defpackage.kf2;
import defpackage.ky0;
import defpackage.og;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.EnumSet;
import java.util.MissingResourceException;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class UCharacterProperty {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int AGE_SHIFT_ = 24;
    private static final int ALPHABETIC_PROPERTY_ = 8;
    private static final int ASCII_HEX_DIGIT_PROPERTY_ = 7;
    private static final int CGJ = 847;
    private static final int CR = 13;
    private static final int DASH_PROPERTY_ = 1;
    private static final String DATA_FILE_NAME_ = "uprops.icu";
    private static final int DATA_FORMAT = 1431335535;
    private static final int DECOMPOSITION_TYPE_MASK_ = 31;
    private static final int DEFAULT_IGNORABLE_CODE_POINT_PROPERTY_ = 19;
    private static final int DEL = 127;
    private static final int DEPRECATED_PROPERTY_ = 20;
    private static final int DIACRITIC_PROPERTY_ = 10;
    private static final int EAST_ASIAN_MASK_ = 28672;
    private static final int EAST_ASIAN_SHIFT_ = 12;
    private static final int EXTENDER_PROPERTY_ = 11;
    private static final int FIGURESP = 8199;
    private static final int GCB_MASK = 992;
    private static final int GCB_SHIFT = 5;
    private static final int GC_ZL_MASK;
    private static final int GC_ZP_MASK;
    private static final int GC_ZS_MASK;
    private static final int GC_Z_MASK;
    private static final int GRAPHEME_BASE_PROPERTY_ = 26;
    private static final int GRAPHEME_EXTEND_PROPERTY_ = 13;
    private static final int GRAPHEME_LINK_PROPERTY_ = 14;
    private static final int HAIRSP = 8202;
    private static final int HEX_DIGIT_PROPERTY_ = 6;
    private static final int HYPHEN_PROPERTY_ = 2;
    private static final int IDEOGRAPHIC_PROPERTY_ = 9;
    private static final int IDS_BINARY_OPERATOR_PROPERTY_ = 15;
    private static final int IDS_TRINARY_OPERATOR_PROPERTY_ = 16;
    private static final int[] ID_COMPAT_MATH_CONTINUE;
    private static final int[] ID_COMPAT_MATH_START;
    private static final int ID_CONTINUE_PROPERTY_ = 25;
    private static final int ID_START_PROPERTY_ = 24;
    private static final int ID_TYPE_ALLOWED_MIN = 60;
    private static final int ID_TYPE_BIT = 128;
    private static final int ID_TYPE_DEFAULT_IGNORABLE = 49;
    private static final int ID_TYPE_DEPRECATED = 48;
    private static final int ID_TYPE_EXCLUSION = 32;
    private static final int ID_TYPE_FORBIDDEN = 48;
    private static final int ID_TYPE_INCLUSION = 62;
    private static final int ID_TYPE_LIMITED_USE = 16;
    private static final int ID_TYPE_NOT_CHARACTER = 0;
    private static final int ID_TYPE_NOT_NFKC = 50;
    private static final int ID_TYPE_NOT_XID = 1;
    private static final int ID_TYPE_OBSOLETE = 2;
    private static final int ID_TYPE_RECOMMENDED = 63;
    private static final int ID_TYPE_SHIFT = 26;
    private static final int ID_TYPE_TECHNICAL = 4;
    private static final int ID_TYPE_UNCOMMON_USE = 8;
    private static final int INCB_MASK = 98304;
    private static final int INCB_SHIFT = 15;
    private static final int INHSWAP = 8298;
    public static final UCharacterProperty INSTANCE;
    public static final char LATIN_CAPITAL_LETTER_I_WITH_DOT_ABOVE_ = 304;
    public static final char LATIN_SMALL_LETTER_DOTLESS_I_ = 305;
    public static final char LATIN_SMALL_LETTER_I_ = 'i';
    private static final int LB_MASK = 66060288;
    private static final int LB_SHIFT = 20;
    private static final int LOGICAL_ORDER_EXCEPTION_PROPERTY_ = 21;
    private static final int MATH_PROPERTY_ = 5;
    private static final int MAX_BLOCK = 1023;
    public static final int MAX_SCRIPT = 1023;
    private static final int[] MODIFIER_COMBINING_MARK;
    static final int MY_MASK = 30;
    private static final int NBSP = 160;
    private static final int NL = 133;
    private static final int NNBSP = 8239;
    private static final int NOMDIG = 8303;
    private static final int NONCHARACTER_CODE_POINT_PROPERTY_ = 12;
    private static final int NTV_BASE60_START_ = 768;
    private static final int NTV_DECIMAL_START_ = 1;
    private static final int NTV_DIGIT_START_ = 11;
    private static final int NTV_FRACTION20_START_ = 804;
    private static final int NTV_FRACTION32_START_ = 828;
    private static final int NTV_FRACTION_START_ = 176;
    private static final int NTV_LARGE_START_ = 480;
    private static final int NTV_NONE_ = 0;
    private static final int NTV_NUMERIC_START_ = 21;
    private static final int NTV_RESERVED_START_ = 844;
    private static final int NUMERIC_TYPE_VALUE_SHIFT_ = 6;
    private static final int PATTERN_SYNTAX = 29;
    private static final int PATTERN_WHITE_SPACE = 30;
    private static final int PREPENDED_CONCATENATION_MARK = 31;
    private static final int QUOTATION_MARK_PROPERTY_ = 3;
    private static final int RADICAL_PROPERTY_ = 17;
    private static final int RLM = 8207;
    private static final int SB_MASK = 1015808;
    private static final int SB_SHIFT = 15;
    public static final int SCRIPT_X_MASK = 4095;
    public static final int SCRIPT_X_WITH_COMMON = 1024;
    public static final int SCRIPT_X_WITH_INHERITED = 2048;
    public static final int SCRIPT_X_WITH_OTHER = 3072;
    public static final int SRC_BIDI = 5;
    public static final int SRC_BLOCK = 18;
    public static final int SRC_CASE = 4;
    public static final int SRC_CASE_AND_NORM = 7;
    public static final int SRC_CHAR = 1;
    public static final int SRC_CHAR_AND_PROPSVEC = 6;
    public static final int SRC_COUNT = 20;
    public static final int SRC_EMOJI = 15;
    public static final int SRC_IDSU = 16;
    public static final int SRC_ID_COMPAT_MATH = 17;
    public static final int SRC_INPC = 12;
    public static final int SRC_INSC = 13;
    public static final int SRC_MCM = 19;
    public static final int SRC_NAMES = 3;
    public static final int SRC_NFC = 8;
    public static final int SRC_NFC_CANON_ITER = 11;
    public static final int SRC_NFKC = 9;
    public static final int SRC_NFKC_CF = 10;
    public static final int SRC_NONE = 0;
    public static final int SRC_PROPSVEC = 2;
    public static final int SRC_VO = 14;
    private static final int S_TERM_PROPERTY_ = 27;
    private static final int TAB = 9;
    private static final int TERMINAL_PUNCTUATION_PROPERTY_ = 4;
    public static final int TYPE_MASK = 31;
    private static final int UNIFIED_IDEOGRAPH_PROPERTY_ = 18;
    private static final int U_A = 65;
    private static final int U_F = 70;
    private static final int U_FW_A = 65313;
    private static final int U_FW_F = 65318;
    private static final int U_FW_Z = 65338;
    private static final int U_FW_a = 65345;
    private static final int U_FW_f = 65350;
    private static final int U_FW_z = 65370;
    private static final int U_Z = 90;
    private static final int U_a = 97;
    private static final int U_f = 102;
    private static final int U_z = 122;
    private static final int VARIATION_SELECTOR_PROPERTY_ = 28;
    private static final int WB_MASK = 31744;
    private static final int WB_SHIFT = 10;
    private static final int WHITE_SPACE_PROPERTY_ = 0;
    private static final int WJ = 8288;
    private static final int XID_CONTINUE_PROPERTY_ = 23;
    private static final int XID_START_PROPERTY_ = 22;
    private static final int ZWNBSP = 65279;
    private static final int[] gcbToHst;
    private static final int[] idTypeToEncoded;
    BinaryProperty[] binProps;
    IntProperty[] intProps;
    int m_additionalColumnsCount_;
    Trie2_16 m_additionalTrie_;
    int[] m_additionalVectors_;
    CodePointTrie m_blockTrie_;
    int m_maxBlockScriptValue_;
    int m_maxJTGValue_;
    int m_maxValuesOther_;
    public char[] m_scriptExtensions_;
    public Trie2_16 m_trie_;
    public VersionInfo m_unicodeVersion_;
    private static final int GC_CN_MASK = getMask(0);
    private static final int GC_CC_MASK = getMask(15);
    private static final int GC_CS_MASK = getMask(18);

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public class BiDiIntProperty extends IntProperty {
        public BiDiIntProperty() {
            super(5);
        }

        @Override // com.ibm.icu.impl.UCharacterProperty.IntProperty
        public int getMaxValue(int i) {
            return UBiDiProps.INSTANCE.getMaxValue(i);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public class CaseBinaryProperty extends BinaryProperty {
        int which;

        public CaseBinaryProperty(int i) {
            super(4);
            this.which = i;
        }

        @Override // com.ibm.icu.impl.UCharacterProperty.BinaryProperty
        public boolean contains(int i) {
            return UCaseProps.INSTANCE.hasBinaryProperty(i, this.which);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public class CombiningClassIntProperty extends IntProperty {
        public CombiningClassIntProperty(int i) {
            super(i);
        }

        @Override // com.ibm.icu.impl.UCharacterProperty.IntProperty
        public int getMaxValue(int i) {
            return 255;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public class EmojiBinaryProperty extends BinaryProperty {
        int which;

        public EmojiBinaryProperty(int i) {
            super(15);
            this.which = i;
        }

        @Override // com.ibm.icu.impl.UCharacterProperty.BinaryProperty
        public boolean contains(int i) {
            return EmojiProps.INSTANCE.hasBinaryProperty(i, this.which);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public class MCMBinaryProperty extends BinaryProperty {
        public MCMBinaryProperty() {
            super(19);
        }

        @Override // com.ibm.icu.impl.UCharacterProperty.BinaryProperty
        public boolean contains(int i) {
            for (int i2 = 0; i2 < UCharacterProperty.MODIFIER_COMBINING_MARK.length && i >= UCharacterProperty.MODIFIER_COMBINING_MARK[i2]; i2 += 2) {
                if (i < UCharacterProperty.MODIFIER_COMBINING_MARK[i2 + 1]) {
                    return true;
                }
            }
            return false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public class MathCompatBinaryProperty extends BinaryProperty {
        int which;

        public MathCompatBinaryProperty(int i) {
            super(17);
            this.which = i;
        }

        @Override // com.ibm.icu.impl.UCharacterProperty.BinaryProperty
        public boolean contains(int i) {
            if (this.which == 74) {
                for (int i2 = 0; i2 < UCharacterProperty.ID_COMPAT_MATH_CONTINUE.length; i2 += 2) {
                    if (i < UCharacterProperty.ID_COMPAT_MATH_CONTINUE[i2]) {
                        return false;
                    }
                    if (i < UCharacterProperty.ID_COMPAT_MATH_CONTINUE[i2 + 1]) {
                        return true;
                    }
                }
            }
            if (i < UCharacterProperty.ID_COMPAT_MATH_START[0]) {
                return false;
            }
            for (int i3 : UCharacterProperty.ID_COMPAT_MATH_START) {
                if (i == i3) {
                    return true;
                }
            }
            return false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public class NormInertBinaryProperty extends BinaryProperty {
        int which;

        public NormInertBinaryProperty(int i, int i2) {
            super(i);
            this.which = i2;
        }

        @Override // com.ibm.icu.impl.UCharacterProperty.BinaryProperty
        public boolean contains(int i) {
            return Norm2AllModes.getN2WithImpl(this.which - 37).isInert(i);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public class NormQuickCheckIntProperty extends IntProperty {
        int max;
        int which;

        public NormQuickCheckIntProperty(int i, int i2, int i3) {
            super(i);
            this.which = i2;
            this.max = i3;
        }

        @Override // com.ibm.icu.impl.UCharacterProperty.IntProperty
        public int getMaxValue(int i) {
            return this.max;
        }

        @Override // com.ibm.icu.impl.UCharacterProperty.IntProperty
        public int getValue(int i) {
            return Norm2AllModes.getN2WithImpl(this.which - 4108).getQuickCheck(i);
        }
    }

    static {
        int mask = getMask(12);
        GC_ZS_MASK = mask;
        int mask2 = getMask(13);
        GC_ZL_MASK = mask2;
        int mask3 = getMask(14);
        GC_ZP_MASK = mask3;
        GC_Z_MASK = mask | mask2 | mask3;
        ID_COMPAT_MATH_CONTINUE = new int[]{178, 180, 185, 186, 8304, 8305, 8308, 8319, 8320, 8335};
        ID_COMPAT_MATH_START = new int[]{8706, 8711, 8734, 120513, 120539, 120571, 120597, 120629, 120655, 120687, 120713, 120745, 120771};
        MODIFIER_COMBINING_MARK = new int[]{1620, 1622, 1624, 1625, 1756, 1757, 1763, 1764, 1767, 1769, 2250, 2252, 2253, 2256, 2259, 2260, 2291, 2292, 69364, 69365, 69366, 69367, 69369, 69370};
        gcbToHst = new int[]{0, 0, 0, 0, 1, 0, 4, 5, 3, 2};
        idTypeToEncoded = new int[]{0, 48, 49, 50, 129, 160, 130, 132, 136, 144, 62, 63};
        try {
            INSTANCE = new UCharacterProperty();
        } catch (IOException e) {
            throw new MissingResourceException(e.getMessage(), "", "");
        }
    }

    private UCharacterProperty() throws IOException {
        int i;
        int i2 = 5;
        int i3 = 1;
        this.binProps = new BinaryProperty[]{new BinaryProperty(1, 256), new BinaryProperty(1, 128), new BinaryProperty(i2) { // from class: com.ibm.icu.impl.UCharacterProperty.1
            @Override // com.ibm.icu.impl.UCharacterProperty.BinaryProperty
            public boolean contains(int i4) {
                return UBiDiProps.INSTANCE.isBidiControl(i4);
            }
        }, new BinaryProperty(i2) { // from class: com.ibm.icu.impl.UCharacterProperty.2
            @Override // com.ibm.icu.impl.UCharacterProperty.BinaryProperty
            public boolean contains(int i4) {
                return UBiDiProps.INSTANCE.isMirrored(i4);
            }
        }, new BinaryProperty(1, 2), new BinaryProperty(1, ArabicShaping.TASHKEEL_RESIZE), new BinaryProperty(1, 1048576), new BinaryProperty(1, 1024), new BinaryProperty(1, 2048), new BinaryProperty(8) { // from class: com.ibm.icu.impl.UCharacterProperty.3
            @Override // com.ibm.icu.impl.UCharacterProperty.BinaryProperty
            public boolean contains(int i4) {
                Normalizer2Impl normalizer2Impl = Norm2AllModes.getNFCInstance().impl;
                return normalizer2Impl.isCompNo(normalizer2Impl.getNorm16(i4));
            }
        }, new BinaryProperty(1, 67108864), new BinaryProperty(1, 8192), new BinaryProperty(1, 16384), new BinaryProperty(1, 64), new BinaryProperty(1, 4), new BinaryProperty(1, 33554432), new BinaryProperty(1, 16777216), new BinaryProperty(1, 512), new BinaryProperty(1, 32768), new BinaryProperty(1, 65536), new BinaryProperty(5) { // from class: com.ibm.icu.impl.UCharacterProperty.4
            @Override // com.ibm.icu.impl.UCharacterProperty.BinaryProperty
            public boolean contains(int i4) {
                return UBiDiProps.INSTANCE.isJoinControl(i4);
            }
        }, new BinaryProperty(1, ArabicShaping.SEEN_TWOCELL_NEAR), new CaseBinaryProperty(22), new BinaryProperty(1, 32), new BinaryProperty(1, 4096), new BinaryProperty(1, 8), new BinaryProperty(1, Normalizer.INPUT_IS_FCD), new CaseBinaryProperty(27), new BinaryProperty(1, 16), new BinaryProperty(1, ArabicShaping.TASHKEEL_BEGIN), new CaseBinaryProperty(30), new BinaryProperty(1, 1), new BinaryProperty(1, 8388608), new BinaryProperty(1, 4194304), new CaseBinaryProperty(34), new BinaryProperty(1, 134217728), new BinaryProperty(1, 268435456), new NormInertBinaryProperty(8, 37), new NormInertBinaryProperty(9, 38), new NormInertBinaryProperty(8, 39), new NormInertBinaryProperty(9, 40), new BinaryProperty(11) { // from class: com.ibm.icu.impl.UCharacterProperty.5
            @Override // com.ibm.icu.impl.UCharacterProperty.BinaryProperty
            public boolean contains(int i4) {
                return Norm2AllModes.getNFCInstance().impl.ensureCanonIterData().isCanonSegmentStarter(i4);
            }
        }, new BinaryProperty(1, 536870912), new BinaryProperty(1, 1073741824), new BinaryProperty(6) { // from class: com.ibm.icu.impl.UCharacterProperty.6
            @Override // com.ibm.icu.impl.UCharacterProperty.BinaryProperty
            public boolean contains(int i4) {
                return UCharacter.isUAlphabetic(i4) || UCharacter.isDigit(i4);
            }
        }, new BinaryProperty(i3) { // from class: com.ibm.icu.impl.UCharacterProperty.7
            @Override // com.ibm.icu.impl.UCharacterProperty.BinaryProperty
            public boolean contains(int i4) {
                if (i4 <= 159) {
                    return i4 == 9 || i4 == 32;
                }
                return UCharacter.getType(i4) == 12;
            }
        }, new BinaryProperty(i3) { // from class: com.ibm.icu.impl.UCharacterProperty.8
            @Override // com.ibm.icu.impl.UCharacterProperty.BinaryProperty
            public boolean contains(int i4) {
                return UCharacterProperty.isgraphPOSIX(i4);
            }
        }, new BinaryProperty(i3) { // from class: com.ibm.icu.impl.UCharacterProperty.9
            @Override // com.ibm.icu.impl.UCharacterProperty.BinaryProperty
            public boolean contains(int i4) {
                return UCharacter.getType(i4) == 12 || UCharacterProperty.isgraphPOSIX(i4);
            }
        }, new BinaryProperty(i3) { // from class: com.ibm.icu.impl.UCharacterProperty.10
            @Override // com.ibm.icu.impl.UCharacterProperty.BinaryProperty
            public boolean contains(int i4) {
                return (i4 <= 102 && i4 >= 65 && (i4 <= 70 || i4 >= 97)) || (i4 >= UCharacterProperty.U_FW_A && i4 <= UCharacterProperty.U_FW_f && (i4 <= UCharacterProperty.U_FW_F || i4 >= UCharacterProperty.U_FW_a)) || UCharacter.getType(i4) == 9;
            }
        }, new CaseBinaryProperty(49), new CaseBinaryProperty(50), new CaseBinaryProperty(51), new CaseBinaryProperty(52), new CaseBinaryProperty(53), new BinaryProperty(7) { // from class: com.ibm.icu.impl.UCharacterProperty.11
            /* JADX WARN: Type inference fix 'apply assigned field type' failed
            java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
            	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
            	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
            	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
             */
            @Override // com.ibm.icu.impl.UCharacterProperty.BinaryProperty
            public boolean contains(int i4) {
                String decomposition = Norm2AllModes.getNFCInstance().impl.getDecomposition(i4);
                if (decomposition != null) {
                    i4 = decomposition.codePointAt(0);
                    if (Character.charCount(i4) != decomposition.length()) {
                        i4 = -1;
                    }
                } else if (i4 < 0) {
                    return false;
                }
                if (i4 < 0) {
                    return !UCharacter.foldCase(decomposition, true).equals(decomposition);
                }
                UCaseProps uCaseProps = UCaseProps.INSTANCE;
                StringBuilder sb = UCaseProps.dummyStringBuilder;
                sb.setLength(0);
                return uCaseProps.toFullFolding(i4, sb, 0) >= 0;
            }
        }, new CaseBinaryProperty(55), new BinaryProperty(10) { // from class: com.ibm.icu.impl.UCharacterProperty.12
            /* JADX WARN: Type inference fix 'apply assigned field type' failed
            java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
            	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
            	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
            	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
             */
            @Override // com.ibm.icu.impl.UCharacterProperty.BinaryProperty
            public boolean contains(int i4) {
                Normalizer2Impl normalizer2Impl = Norm2AllModes.getNFKC_CFInstance().impl;
                String strValueOf = UTF16.valueOf(i4);
                StringBuilder sb = new StringBuilder();
                normalizer2Impl.compose(strValueOf, 0, strValueOf.length(), false, true, new Normalizer2Impl.ReorderingBuffer(normalizer2Impl, sb, 5));
                return !Normalizer2Impl.UTF16Plus.equal(sb, strValueOf);
            }
        }, new EmojiBinaryProperty(57), new EmojiBinaryProperty(58), new EmojiBinaryProperty(59), new EmojiBinaryProperty(60), new EmojiBinaryProperty(61), new BinaryProperty(2) { // from class: com.ibm.icu.impl.UCharacterProperty.13
            @Override // com.ibm.icu.impl.UCharacterProperty.BinaryProperty
            public boolean contains(int i4) {
                return 127462 <= i4 && i4 <= 127487;
            }
        }, new BinaryProperty(1, Integer.MIN_VALUE), new EmojiBinaryProperty(64), new EmojiBinaryProperty(65), new EmojiBinaryProperty(66), new EmojiBinaryProperty(67), new EmojiBinaryProperty(68), new EmojiBinaryProperty(69), new EmojiBinaryProperty(70), new EmojiBinaryProperty(71), new BinaryProperty(16) { // from class: com.ibm.icu.impl.UCharacterProperty.14
            @Override // com.ibm.icu.impl.UCharacterProperty.BinaryProperty
            public boolean contains(int i4) {
                return 12286 <= i4 && i4 <= 12287;
            }
        }, new MathCompatBinaryProperty(73), new MathCompatBinaryProperty(74), new MCMBinaryProperty()};
        int i4 = 1;
        int i5 = 2;
        int i6 = 8;
        this.intProps = new IntProperty[]{new BiDiIntProperty() { // from class: com.ibm.icu.impl.UCharacterProperty.15
            @Override // com.ibm.icu.impl.UCharacterProperty.IntProperty
            public int getValue(int i7) {
                return UBiDiProps.INSTANCE.getClass(i7);
            }
        }, new IntProperty(18) { // from class: com.ibm.icu.impl.UCharacterProperty.16
            @Override // com.ibm.icu.impl.UCharacterProperty.IntProperty
            public int getMaxValue(int i7) {
                return UCharacterProperty.this.m_maxValuesOther_ & 1023;
            }

            @Override // com.ibm.icu.impl.UCharacterProperty.IntProperty
            public int getValue(int i7) {
                if (i7 <= 1114111) {
                    i7 >>= 4;
                }
                return UCharacterProperty.this.m_blockTrie_.get(i7);
            }
        }, new CombiningClassIntProperty(8) { // from class: com.ibm.icu.impl.UCharacterProperty.17
            @Override // com.ibm.icu.impl.UCharacterProperty.IntProperty
            public int getValue(int i7) {
                return Normalizer2.getNFDInstance().getCombiningClass(i7);
            }
        }, new IntProperty(2, 31, 0), new IntProperty(0, 28672, 12), new IntProperty(i4) { // from class: com.ibm.icu.impl.UCharacterProperty.18
            @Override // com.ibm.icu.impl.UCharacterProperty.IntProperty
            public int getMaxValue(int i7) {
                return 29;
            }

            @Override // com.ibm.icu.impl.UCharacterProperty.IntProperty
            public int getValue(int i7) {
                return UCharacterProperty.this.getType(i7);
            }
        }, new BiDiIntProperty() { // from class: com.ibm.icu.impl.UCharacterProperty.19
            @Override // com.ibm.icu.impl.UCharacterProperty.IntProperty
            public int getValue(int i7) {
                return UBiDiProps.INSTANCE.getJoiningGroup(i7);
            }
        }, new BiDiIntProperty() { // from class: com.ibm.icu.impl.UCharacterProperty.20
            @Override // com.ibm.icu.impl.UCharacterProperty.IntProperty
            public int getValue(int i7) {
                return UBiDiProps.INSTANCE.getJoiningType(i7);
            }
        }, new IntProperty(2, LB_MASK, 20), new IntProperty(i4) { // from class: com.ibm.icu.impl.UCharacterProperty.21
            @Override // com.ibm.icu.impl.UCharacterProperty.IntProperty
            public int getMaxValue(int i7) {
                return 3;
            }

            @Override // com.ibm.icu.impl.UCharacterProperty.IntProperty
            public int getValue(int i7) {
                return UCharacterProperty.ntvGetType(UCharacterProperty.getNumericTypeValue(UCharacterProperty.this.getProperty(i7)));
            }
        }, new IntProperty(i5) { // from class: com.ibm.icu.impl.UCharacterProperty.22
            @Override // com.ibm.icu.impl.UCharacterProperty.IntProperty
            public int getMaxValue(int i7) {
                return UCharacterProperty.this.getMaxValues(0) & 1023;
            }

            @Override // com.ibm.icu.impl.UCharacterProperty.IntProperty
            public int getValue(int i7) {
                return UScript.getScript(i7);
            }
        }, new IntProperty(i5) { // from class: com.ibm.icu.impl.UCharacterProperty.23
            @Override // com.ibm.icu.impl.UCharacterProperty.IntProperty
            public int getMaxValue(int i7) {
                return 5;
            }

            @Override // com.ibm.icu.impl.UCharacterProperty.IntProperty
            public int getValue(int i7) {
                int additional;
                if (i7 <= 65535 && (additional = (UCharacterProperty.this.getAdditional(i7, 2) & UCharacterProperty.GCB_MASK) >>> 5) < UCharacterProperty.gcbToHst.length) {
                    return UCharacterProperty.gcbToHst[additional];
                }
                return 0;
            }
        }, new NormQuickCheckIntProperty(8, UProperty.NFD_QUICK_CHECK, 1), new NormQuickCheckIntProperty(9, UProperty.NFKD_QUICK_CHECK, 1), new NormQuickCheckIntProperty(8, UProperty.NFC_QUICK_CHECK, 2), new NormQuickCheckIntProperty(9, UProperty.NFKC_QUICK_CHECK, 2), new CombiningClassIntProperty(i6) { // from class: com.ibm.icu.impl.UCharacterProperty.24
            @Override // com.ibm.icu.impl.UCharacterProperty.IntProperty
            public int getValue(int i7) {
                return Norm2AllModes.getNFCInstance().impl.getFCD16(i7) >> 8;
            }
        }, new CombiningClassIntProperty(i6) { // from class: com.ibm.icu.impl.UCharacterProperty.25
            @Override // com.ibm.icu.impl.UCharacterProperty.IntProperty
            public int getValue(int i7) {
                return Norm2AllModes.getNFCInstance().impl.getFCD16(i7) & 255;
            }
        }, new IntProperty(2, GCB_MASK, 5), new IntProperty(2, SB_MASK, 15), new IntProperty(2, WB_MASK, 10), new BiDiIntProperty() { // from class: com.ibm.icu.impl.UCharacterProperty.26
            @Override // com.ibm.icu.impl.UCharacterProperty.IntProperty
            public int getValue(int i7) {
                return UBiDiProps.INSTANCE.getPairedBracketType(i7);
            }
        }, new IntProperty(12) { // from class: com.ibm.icu.impl.UCharacterProperty.27
            @Override // com.ibm.icu.impl.UCharacterProperty.IntProperty
            public int getMaxValue(int i7) {
                return LayoutProps.INSTANCE.maxInpcValue;
            }

            @Override // com.ibm.icu.impl.UCharacterProperty.IntProperty
            public int getValue(int i7) {
                CodePointTrie codePointTrie = LayoutProps.INSTANCE.inpcTrie;
                if (codePointTrie != null) {
                    return codePointTrie.get(i7);
                }
                return 0;
            }
        }, new IntProperty(13) { // from class: com.ibm.icu.impl.UCharacterProperty.28
            @Override // com.ibm.icu.impl.UCharacterProperty.IntProperty
            public int getMaxValue(int i7) {
                return LayoutProps.INSTANCE.maxInscValue;
            }

            @Override // com.ibm.icu.impl.UCharacterProperty.IntProperty
            public int getValue(int i7) {
                CodePointTrie codePointTrie = LayoutProps.INSTANCE.inscTrie;
                if (codePointTrie != null) {
                    return codePointTrie.get(i7);
                }
                return 0;
            }
        }, new IntProperty(14) { // from class: com.ibm.icu.impl.UCharacterProperty.29
            @Override // com.ibm.icu.impl.UCharacterProperty.IntProperty
            public int getMaxValue(int i7) {
                return LayoutProps.INSTANCE.maxVoValue;
            }

            @Override // com.ibm.icu.impl.UCharacterProperty.IntProperty
            public int getValue(int i7) {
                CodePointTrie codePointTrie = LayoutProps.INSTANCE.voTrie;
                if (codePointTrie != null) {
                    return codePointTrie.get(i7);
                }
                return 0;
            }
        }, new IntProperty(2) { // from class: com.ibm.icu.impl.UCharacterProperty.30
            @Override // com.ibm.icu.impl.UCharacterProperty.IntProperty
            public int getMaxValue(int i7) {
                return UCharacter.IdentifierStatus.ALLOWED.ordinal();
            }

            @Override // com.ibm.icu.impl.UCharacterProperty.IntProperty
            public int getValue(int i7) {
                return (UCharacterProperty.this.getAdditional(i7, 2) >>> 26) >= 60 ? UCharacter.IdentifierStatus.ALLOWED.ordinal() : UCharacter.IdentifierStatus.RESTRICTED.ordinal();
            }
        }, new IntProperty(0, INCB_MASK, 15)};
        if (this.binProps.length != 76) {
            og.q("binProps.length!=UProperty.BINARY_LIMIT");
            throw null;
        }
        ByteBuffer requiredData = ICUBinary.getRequiredData(DATA_FILE_NAME_);
        this.m_unicodeVersion_ = ICUBinary.readHeaderAndDataVersion(requiredData, DATA_FORMAT, new IsAcceptable(0));
        int i7 = requiredData.getInt();
        requiredData.getInt();
        requiredData.getInt();
        int i8 = requiredData.getInt();
        int i9 = requiredData.getInt();
        this.m_additionalColumnsCount_ = requiredData.getInt();
        int i10 = requiredData.getInt();
        int i11 = requiredData.getInt();
        int i12 = requiredData.getInt();
        requiredData.getInt();
        this.m_maxBlockScriptValue_ = requiredData.getInt();
        this.m_maxJTGValue_ = requiredData.getInt();
        this.m_maxValuesOther_ = requiredData.getInt();
        ICUBinary.skipBytes(requiredData, 12);
        Trie2_16 trie2_16CreateFromSerialized = Trie2_16.createFromSerialized(requiredData);
        this.m_trie_ = trie2_16CreateFromSerialized;
        int i13 = (i7 - 16) * 4;
        int serializedLength = trie2_16CreateFromSerialized.getSerializedLength();
        if (serializedLength > i13) {
            dk0.h("uprops.icu: not enough bytes for main trie");
            throw null;
        }
        ICUBinary.skipBytes(requiredData, i13 - serializedLength);
        ICUBinary.skipBytes(requiredData, (i8 - i7) * 4);
        if (this.m_additionalColumnsCount_ > 0) {
            Trie2_16 trie2_16CreateFromSerialized2 = Trie2_16.createFromSerialized(requiredData);
            this.m_additionalTrie_ = trie2_16CreateFromSerialized2;
            int i14 = (i9 - i8) * 4;
            int serializedLength2 = trie2_16CreateFromSerialized2.getSerializedLength();
            if (serializedLength2 > i14) {
                dk0.h("uprops.icu: not enough bytes for additional-properties trie");
                throw null;
            }
            ICUBinary.skipBytes(requiredData, i14 - serializedLength2);
            i = 0;
            this.m_additionalVectors_ = ICUBinary.getInts(requiredData, i10 - i9, 0);
        } else {
            i = 0;
        }
        int i15 = (i11 - i10) * 2;
        if (i15 > 0) {
            this.m_scriptExtensions_ = ICUBinary.getChars(requiredData, i15, i);
        }
        int i16 = (i12 - i11) * 4;
        int iPosition = requiredData.position();
        this.m_blockTrie_ = CodePointTrie.fromBinary(null, CodePointTrie.ValueWidth.BITS_16, requiredData);
        int iPosition2 = requiredData.position() - iPosition;
        if (iPosition2 > i16) {
            throw new ICUUncheckedIOException("uprops.icu: not enough bytes for blockTrie");
        }
        ICUBinary.skipBytes(requiredData, i16 - iPosition2);
    }

    public static int getEuropeanDigit(int i) {
        if (i > 122 && i < U_FW_A) {
            return -1;
        }
        if (i < 65) {
            return -1;
        }
        if ((i > 90 && i < 97) || i > U_FW_z) {
            return -1;
        }
        if (i > U_FW_Z && i < U_FW_a) {
            return -1;
        }
        if (i <= 122) {
            return (i + 10) - (i > 90 ? 97 : 65);
        }
        return i + (i <= U_FW_Z ? -65303 : -65335);
    }

    public static final int getMask(int i) {
        return 1 << i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int getNumericTypeValue(int i) {
        return i >> 6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isgraphPOSIX(int i) {
        return (getMask(UCharacter.getType(i)) & (((GC_CC_MASK | GC_CS_MASK) | GC_CN_MASK) | GC_Z_MASK)) == 0;
    }

    public static void mathCompat_addPropertyStarts(UnicodeSet unicodeSet) {
        for (int i : ID_COMPAT_MATH_CONTINUE) {
            unicodeSet.add(i);
        }
        for (int i2 : ID_COMPAT_MATH_START) {
            unicodeSet.add(i2);
            unicodeSet.add(i2 + 1);
        }
    }

    private static void maybeAddType(int i, int i2, UCharacter.IdentifierType identifierType, EnumSet<UCharacter.IdentifierType> enumSet) {
        if ((i & i2) != 0) {
            enumSet.add(identifierType);
        }
    }

    public static void mcm_addPropertyStarts(UnicodeSet unicodeSet) {
        for (int i : MODIFIER_COMBINING_MARK) {
            unicodeSet.add(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int ntvGetType(int i) {
        if (i == 0) {
            return 0;
        }
        if (i < 11) {
            return 1;
        }
        return i < 21 ? 2 : 3;
    }

    public static UnicodeSet ulayout_addPropertyStarts(int i, UnicodeSet unicodeSet) {
        return LayoutProps.INSTANCE.addPropertyStarts(i, unicodeSet);
    }

    public UnicodeSet addPropertyStarts(UnicodeSet unicodeSet) {
        for (Trie2.Range range : this.m_trie_) {
            if (range.leadSurrogate) {
                break;
            }
            unicodeSet.add(range.startCodePoint);
        }
        unicodeSet.add(9);
        unicodeSet.add(10);
        unicodeSet.add(14);
        unicodeSet.add(28);
        unicodeSet.add(32);
        unicodeSet.add(133);
        unicodeSet.add(134);
        unicodeSet.add(127);
        unicodeSet.add(HAIRSP);
        unicodeSet.add(8208);
        unicodeSet.add(INHSWAP);
        unicodeSet.add(8304);
        unicodeSet.add(ZWNBSP);
        unicodeSet.add(65280);
        unicodeSet.add(160);
        unicodeSet.add(161);
        unicodeSet.add(FIGURESP);
        unicodeSet.add(8200);
        unicodeSet.add(NNBSP);
        unicodeSet.add(8240);
        unicodeSet.add(12295);
        unicodeSet.add(12296);
        unicodeSet.add(19968);
        unicodeSet.add(19969);
        unicodeSet.add(20108);
        unicodeSet.add(20109);
        unicodeSet.add(19977);
        unicodeSet.add(19978);
        unicodeSet.add(22235);
        unicodeSet.add(22236);
        unicodeSet.add(20116);
        unicodeSet.add(20117);
        unicodeSet.add(20845);
        unicodeSet.add(20846);
        unicodeSet.add(19971);
        unicodeSet.add(19972);
        unicodeSet.add(20843);
        unicodeSet.add(20844);
        unicodeSet.add(20061);
        unicodeSet.add(20062);
        unicodeSet.add(97);
        unicodeSet.add(123);
        unicodeSet.add(65);
        unicodeSet.add(91);
        unicodeSet.add(U_FW_a);
        unicodeSet.add(65371);
        unicodeSet.add(U_FW_A);
        unicodeSet.add(65339);
        unicodeSet.add(103);
        unicodeSet.add(71);
        unicodeSet.add(65351);
        unicodeSet.add(65319);
        unicodeSet.add(WJ);
        unicodeSet.add(65520);
        unicodeSet.add(65532);
        unicodeSet.add(ArabicShaping.TASHKEEL_MASK);
        unicodeSet.add(921600);
        unicodeSet.add(CGJ);
        unicodeSet.add(848);
        return unicodeSet;
    }

    public int digit(int i) {
        int numericTypeValue = getNumericTypeValue(getProperty(i)) - 1;
        if (numericTypeValue <= 9) {
            return numericTypeValue;
        }
        return -1;
    }

    public int getAdditional(int i, int i2) {
        if (i2 >= this.m_additionalColumnsCount_) {
            return 0;
        }
        return this.m_additionalVectors_[this.m_additionalTrie_.get(i) + i2];
    }

    public VersionInfo getAge(int i) {
        int additional = getAdditional(i, 0) >>> 24;
        return VersionInfo.getInstance(additional >> 2, additional & 3, 0, 0);
    }

    public int getIDTypes(int i, EnumSet<UCharacter.IdentifierType> enumSet) {
        UCharacter.IdentifierType identifierType;
        enumSet.clear();
        int additional = getAdditional(i, 2) >>> 26;
        if ((additional & 48) != 48 && additional != 0) {
            maybeAddType(additional, 1, UCharacter.IdentifierType.NOT_XID, enumSet);
            maybeAddType(additional, 32, UCharacter.IdentifierType.EXCLUSION, enumSet);
            maybeAddType(additional, 2, UCharacter.IdentifierType.OBSOLETE, enumSet);
            maybeAddType(additional, 4, UCharacter.IdentifierType.TECHNICAL, enumSet);
            maybeAddType(additional, 8, UCharacter.IdentifierType.UNCOMMON_USE, enumSet);
            maybeAddType(additional, 16, UCharacter.IdentifierType.LIMITED_USE, enumSet);
            return enumSet.size();
        }
        if (additional == 0) {
            identifierType = UCharacter.IdentifierType.NOT_CHARACTER;
        } else if (additional == 62) {
            identifierType = UCharacter.IdentifierType.INCLUSION;
        } else if (additional != 63) {
            switch (additional) {
                case 48:
                    identifierType = UCharacter.IdentifierType.DEPRECATED;
                    break;
                case 49:
                    identifierType = UCharacter.IdentifierType.DEFAULT_IGNORABLE;
                    break;
                case 50:
                    identifierType = UCharacter.IdentifierType.NOT_NFKC;
                    break;
                default:
                    throw new IllegalStateException(String.format("unknown IdentifierType data value 0x%02x", Integer.valueOf(additional)));
            }
        } else {
            identifierType = UCharacter.IdentifierType.RECOMMENDED;
        }
        enumSet.add(identifierType);
        return 1;
    }

    public int getIntPropertyMaxValue(int i) {
        if (i < 4096) {
            return (i < 0 || i >= 76) ? -1 : 1;
        }
        if (i < 4123) {
            return this.intProps[i - 4096].getMaxValue(i);
        }
        return -1;
    }

    public int getIntPropertyValue(int i, int i2) {
        if (i2 < 4096) {
            if (i2 < 0 || i2 >= 76) {
                return 0;
            }
            return this.binProps[i2].contains(i) ? 1 : 0;
        }
        if (i2 < 4123) {
            return this.intProps[i2 - 4096].getValue(i);
        }
        if (i2 == 8192) {
            return getMask(getType(i));
        }
        return 0;
    }

    public int getMaxValues(int i) {
        if (i == 0) {
            return this.m_maxBlockScriptValue_;
        }
        if (i != 2) {
            return 0;
        }
        return this.m_maxJTGValue_;
    }

    public int getNumericValue(int i) {
        int numericTypeValue = getNumericTypeValue(getProperty(i));
        if (numericTypeValue == 0) {
            return getEuropeanDigit(i);
        }
        if (numericTypeValue < 11) {
            return numericTypeValue - 1;
        }
        if (numericTypeValue < 21) {
            return numericTypeValue - 11;
        }
        if (numericTypeValue < 176) {
            return numericTypeValue - 21;
        }
        if (numericTypeValue < NTV_LARGE_START_) {
            return -2;
        }
        if (numericTypeValue < 768) {
            int i2 = (numericTypeValue >> 5) - 14;
            int i3 = (numericTypeValue & 31) + 2;
            if (i3 >= 9 && (i3 != 9 || i2 > 2)) {
                return -2;
            }
            do {
                i2 *= 10;
                i3--;
            } while (i3 > 0);
            return i2;
        }
        if (numericTypeValue >= NTV_FRACTION20_START_) {
            return -2;
        }
        int i4 = (numericTypeValue >> 2) - 191;
        int i5 = (numericTypeValue & 3) + 1;
        if (i5 == 1) {
            return i4 * 60;
        }
        if (i5 == 2) {
            return i4 * 3600;
        }
        if (i5 != 3) {
            return i5 != 4 ? i4 : i4 * 12960000;
        }
        return i4 * 216000;
    }

    public final int getProperty(int i) {
        return this.m_trie_.get(i);
    }

    public final int getSource(int i) {
        if (i < 0) {
            return 0;
        }
        if (i < 76) {
            return this.binProps[i].getSource();
        }
        if (i < 4096) {
            return 0;
        }
        if (i < 4123) {
            return this.intProps[i - 4096].getSource();
        }
        if (i < 16384) {
            return (i == 8192 || i == 12288) ? 1 : 0;
        }
        if (i >= 16398) {
            return (i == 28672 || i == 28673) ? 2 : 0;
        }
        switch (i) {
            case 16384:
                return 2;
            case UProperty.BIDI_MIRRORING_GLYPH /* 16385 */:
                return 5;
            case UProperty.CASE_FOLDING /* 16386 */:
            case UProperty.LOWERCASE_MAPPING /* 16388 */:
            case UProperty.SIMPLE_CASE_FOLDING /* 16390 */:
            case UProperty.SIMPLE_LOWERCASE_MAPPING /* 16391 */:
            case UProperty.SIMPLE_TITLECASE_MAPPING /* 16392 */:
            case UProperty.SIMPLE_UPPERCASE_MAPPING /* 16393 */:
            case UProperty.TITLECASE_MAPPING /* 16394 */:
            case UProperty.UPPERCASE_MAPPING /* 16396 */:
                return 4;
            case UProperty.ISO_COMMENT /* 16387 */:
            case UProperty.NAME /* 16389 */:
            case UProperty.UNICODE_1_NAME /* 16395 */:
                return 3;
            default:
                return 0;
        }
    }

    public int getType(int i) {
        return getProperty(i) & 31;
    }

    public double getUnicodeNumericValue(int i) {
        int i2;
        int i3;
        int numericTypeValue = getNumericTypeValue(getProperty(i));
        if (numericTypeValue == 0) {
            return -1.23456789E8d;
        }
        if (numericTypeValue < 11) {
            i3 = numericTypeValue - 1;
        } else if (numericTypeValue < 21) {
            i3 = numericTypeValue - 11;
        } else {
            if (numericTypeValue >= 176) {
                if (numericTypeValue < NTV_LARGE_START_) {
                    return ((double) ((numericTypeValue >> 4) - 12)) / ((double) ((numericTypeValue & 15) + 1));
                }
                if (numericTypeValue < 768) {
                    int i4 = (numericTypeValue >> 5) - 14;
                    int i5 = (numericTypeValue & 31) + 2;
                    double d = i4;
                    while (i5 >= 4) {
                        d *= 10000.0d;
                        i5 -= 4;
                    }
                    if (i5 == 1) {
                        return d * 10.0d;
                    }
                    if (i5 != 2) {
                        return i5 != 3 ? d : d * 1000.0d;
                    }
                    return d * 100.0d;
                }
                if (numericTypeValue >= NTV_FRACTION20_START_) {
                    if (numericTypeValue < NTV_FRACTION32_START_) {
                        int i6 = numericTypeValue - NTV_FRACTION20_START_;
                        return ((double) (((i6 & 3) * 2) + 1)) / ((double) (20 << (i6 >> 2)));
                    }
                    if (numericTypeValue >= NTV_RESERVED_START_) {
                        return -1.23456789E8d;
                    }
                    int i7 = numericTypeValue - NTV_FRACTION32_START_;
                    return ((double) (((i7 & 3) * 2) + 1)) / ((double) (32 << (i7 >> 2)));
                }
                int i8 = (numericTypeValue >> 2) - 191;
                int i9 = (numericTypeValue & 3) + 1;
                if (i9 == 1) {
                    i8 *= 60;
                } else if (i9 != 2) {
                    if (i9 != 3) {
                        i2 = i9 == 4 ? 12960000 : 216000;
                    }
                    i8 *= i2;
                } else {
                    i8 *= 3600;
                }
                return i8;
            }
            i3 = numericTypeValue - 21;
        }
        return i3;
    }

    public boolean hasBinaryProperty(int i, int i2) {
        if (i2 < 0 || 76 <= i2) {
            return false;
        }
        return this.binProps[i2].contains(i);
    }

    public boolean hasIDType(int i, int i2) {
        if (i2 >= 0) {
            int[] iArr = idTypeToEncoded;
            if (i2 < iArr.length) {
                int i3 = iArr[i2];
                int additional = getAdditional(i, 2) >>> 26;
                if ((i3 & 128) != 0) {
                    return additional < 48 && (additional & i3) != 0;
                }
                if (additional == i3) {
                    return true;
                }
            }
        }
        return false;
    }

    public void ublock_addPropertyStarts(UnicodeSet unicodeSet) {
        CodePointMap.Range range = new CodePointMap.Range();
        for (int end = 0; end < 69632 && this.m_blockTrie_.getRange(end, null, range); end = range.getEnd() + 1) {
            unicodeSet.add(end << 4);
        }
    }

    public void upropsvec_addPropertyStarts(UnicodeSet unicodeSet) {
        if (this.m_additionalColumnsCount_ > 0) {
            for (Trie2.Range range : this.m_additionalTrie_) {
                if (range.leadSurrogate) {
                    return;
                } else {
                    unicodeSet.add(range.startCodePoint);
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class LayoutProps {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private static final int DATA_FORMAT = 1281456495;
        private static final int IX_INPC_TRIE_TOP = 1;
        private static final int IX_INSC_TRIE_TOP = 2;
        private static final int IX_MAX_VALUES = 9;
        private static final int IX_VO_TRIE_TOP = 3;
        private static final int MAX_INPC_SHIFT = 24;
        private static final int MAX_INSC_SHIFT = 16;
        private static final int MAX_VO_SHIFT = 8;
        CodePointTrie inpcTrie;
        CodePointTrie inscTrie;
        int maxInpcValue;
        int maxInscValue;
        int maxVoValue;
        CodePointTrie voTrie;
        private static final IsAcceptable IS_ACCEPTABLE = new IsAcceptable(0);
        static final LayoutProps INSTANCE = new LayoutProps();

        public LayoutProps() {
            this.inpcTrie = null;
            this.inscTrie = null;
            this.voTrie = null;
            this.maxInpcValue = 0;
            this.maxInscValue = 0;
            this.maxVoValue = 0;
            ByteBuffer requiredData = ICUBinary.getRequiredData("ulayout.icu");
            try {
                ICUBinary.readHeaderAndDataVersion(requiredData, DATA_FORMAT, IS_ACCEPTABLE);
                int iPosition = requiredData.position();
                int i = requiredData.getInt();
                if (i < 12) {
                    throw new ICUUncheckedIOException("Text layout properties data: not enough indexes");
                }
                int[] iArr = new int[i];
                iArr[0] = i;
                for (int i2 = 1; i2 < i; i2++) {
                    iArr[i2] = requiredData.getInt();
                }
                int i3 = iArr[1];
                if (i3 - (i * 4) >= 16) {
                    this.inpcTrie = CodePointTrie.fromBinary(null, null, requiredData);
                }
                ICUBinary.skipBytes(requiredData, i3 - (requiredData.position() - iPosition));
                int i4 = iArr[2];
                if (i4 - i3 >= 16) {
                    this.inscTrie = CodePointTrie.fromBinary(null, null, requiredData);
                }
                ICUBinary.skipBytes(requiredData, i4 - (requiredData.position() - iPosition));
                int i5 = iArr[3];
                if (i5 - i4 >= 16) {
                    this.voTrie = CodePointTrie.fromBinary(null, null, requiredData);
                }
                ICUBinary.skipBytes(requiredData, i5 - (requiredData.position() - iPosition));
                int i6 = iArr[9];
                this.maxInpcValue = i6 >>> 24;
                this.maxInscValue = (i6 >> 16) & 255;
                this.maxVoValue = (i6 >> 8) & 255;
            } catch (IOException e) {
                kf2.h(e);
                throw null;
            }
        }

        public UnicodeSet addPropertyStarts(int i, UnicodeSet unicodeSet) {
            CodePointTrie codePointTrie;
            switch (i) {
                case 12:
                    codePointTrie = this.inpcTrie;
                    break;
                case 13:
                    codePointTrie = this.inscTrie;
                    break;
                case 14:
                    codePointTrie = this.voTrie;
                    break;
                default:
                    throw new IllegalStateException();
            }
            if (codePointTrie == null) {
                throw new MissingResourceException(ky0.h(i, "no data for one of the text layout properties; src="), "LayoutProps", "");
            }
            CodePointMap.Range range = new CodePointMap.Range();
            for (int end = 0; codePointTrie.getRange(end, null, range); end = range.getEnd() + 1) {
                unicodeSet.add(end);
            }
            return unicodeSet;
        }

        /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
        public static final class IsAcceptable implements ICUBinary.Authenticate {
            public /* synthetic */ IsAcceptable(int i) {
                this();
            }

            @Override // com.ibm.icu.impl.ICUBinary.Authenticate
            public boolean isDataVersionAcceptable(byte[] bArr) {
                return bArr[0] == 1;
            }

            private IsAcceptable() {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class IsAcceptable implements ICUBinary.Authenticate {
        public /* synthetic */ IsAcceptable(int i) {
            this();
        }

        @Override // com.ibm.icu.impl.ICUBinary.Authenticate
        public boolean isDataVersionAcceptable(byte[] bArr) {
            return bArr[0] == 9;
        }

        private IsAcceptable() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public class BinaryProperty {
        int column;
        int mask;

        public BinaryProperty(int i) {
            this.column = i;
            this.mask = 0;
        }

        public boolean contains(int i) {
            return (this.mask & UCharacterProperty.this.getAdditional(i, this.column)) != 0;
        }

        public final int getSource() {
            if (this.mask == 0) {
                return this.column;
            }
            return 2;
        }

        public BinaryProperty(int i, int i2) {
            this.column = i;
            this.mask = i2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public class IntProperty {
        int column;
        int mask;
        int shift;

        public IntProperty(int i, int i2, int i3) {
            this.column = i;
            this.mask = i2;
            this.shift = i3;
        }

        public int getMaxValue(int i) {
            return (UCharacterProperty.this.getMaxValues(this.column) & this.mask) >>> this.shift;
        }

        public final int getSource() {
            if (this.mask == 0) {
                return this.column;
            }
            return 2;
        }

        public int getValue(int i) {
            return (UCharacterProperty.this.getAdditional(i, this.column) & this.mask) >>> this.shift;
        }

        public IntProperty(int i) {
            this.column = i;
            this.mask = 0;
        }
    }

    public boolean hasIDType(int i, UCharacter.IdentifierType identifierType) {
        return hasIDType(i, identifierType.ordinal());
    }
}
