package com.ibm.icu.impl;

import com.ibm.icu.lang.UCharacter;
import com.ibm.icu.lang.UCharacterEnums;
import com.ibm.icu.text.UnicodeSet;
import defpackage.ky0;
import java.io.IOException;
import java.util.Locale;
import java.util.MissingResourceException;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class UCharacterName {
    static final int EXTENDED_CATEGORY_ = 33;
    private static final String FILE_NAME_ = "unames.icu";
    private static final int GROUP_MASK_ = 31;
    private static final int GROUP_SHIFT_ = 5;
    public static final UCharacterName INSTANCE;
    private static final int LEAD_SURROGATE_ = 31;
    public static final int LINES_PER_GROUP_ = 32;
    private static final int NON_CHARACTER_ = 30;
    private static final int OFFSET_HIGH_OFFSET_ = 1;
    private static final int OFFSET_LOW_OFFSET_ = 2;
    private static final int SINGLE_NIBBLE_MAX_ = 11;
    private static final int TRAIL_SURROGATE_ = 32;
    private static final String[] TYPE_NAMES_;
    private static final String UNKNOWN_TYPE_NAME_ = "unknown";
    static int start;
    private AlgorithmName[] m_algorithm_;
    private char[] m_groupinfo_;
    private byte[] m_groupstring_;
    private int m_maxISOCommentLength_;
    private int m_maxNameLength_;
    private byte[] m_tokenstring_;
    private char[] m_tokentable_;
    public int m_groupcount_ = 0;
    int m_groupsize_ = 0;
    private char[] m_groupoffsets_ = new char[33];
    private char[] m_grouplengths_ = new char[33];
    private int[] m_nameSet_ = new int[8];
    private int[] m_ISOCommentSet_ = new int[8];
    private int[] m_utilIntBuffer_ = new int[2];

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class AlgorithmName {
        static final int TYPE_0_ = 0;
        static final int TYPE_1_ = 1;
        private char[] m_factor_;
        private byte[] m_factorstring_;
        private String m_prefix_;
        private int m_rangeend_;
        private int m_rangestart_;
        private byte m_type_;
        private byte m_variant_;

        private boolean compareFactorString(int[] iArr, int i, String str, int i2) {
            int length = this.m_factor_.length;
            if (iArr == null || i != length) {
                return false;
            }
            int i3 = length - 1;
            int iSkipNullTermByteSubString = 0;
            for (int i4 = 0; i4 <= i3; i4++) {
                char c = this.m_factor_[i4];
                iSkipNullTermByteSubString = UCharacterUtility.skipNullTermByteSubString(this.m_factorstring_, iSkipNullTermByteSubString, iArr[i4]);
                i2 = UCharacterUtility.compareNullTermByteSubString(str, this.m_factorstring_, i2, iSkipNullTermByteSubString);
                if (i2 < 0) {
                    return false;
                }
                if (i4 != i3) {
                    iSkipNullTermByteSubString = UCharacterUtility.skipNullTermByteSubString(this.m_factorstring_, iSkipNullTermByteSubString, c - iArr[i4]);
                }
            }
            return i2 == str.length();
        }

        private String getFactorString(int[] iArr, int i) {
            int length = this.m_factor_.length;
            if (iArr == null || i != length) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            int i2 = length - 1;
            int nullTermByteSubString = 0;
            for (int i3 = 0; i3 <= i2; i3++) {
                char c = this.m_factor_[i3];
                nullTermByteSubString = UCharacterUtility.getNullTermByteSubString(sb, this.m_factorstring_, UCharacterUtility.skipNullTermByteSubString(this.m_factorstring_, nullTermByteSubString, iArr[i3]));
                if (i3 != i2) {
                    nullTermByteSubString = UCharacterUtility.skipNullTermByteSubString(this.m_factorstring_, nullTermByteSubString, (c - iArr[i3]) - 1);
                }
            }
            return sb.toString();
        }

        public int add(int[] iArr, int i) {
            int iAdd = UCharacterName.add(iArr, this.m_prefix_);
            byte b = this.m_type_;
            if (b == 0) {
                iAdd += this.m_variant_;
            } else if (b == 1) {
                StringBuilder sb = new StringBuilder();
                for (int i2 = this.m_variant_ - 1; i2 > 0; i2--) {
                    int length = 0;
                    int nullTermByteSubString = 0;
                    for (int i3 = this.m_factor_[i2]; i3 > 0; i3--) {
                        sb.setLength(0);
                        nullTermByteSubString = UCharacterUtility.getNullTermByteSubString(sb, this.m_factorstring_, nullTermByteSubString);
                        UCharacterName.add(iArr, sb);
                        if (sb.length() > length) {
                            length = sb.length();
                        }
                    }
                    iAdd += length;
                }
            }
            return iAdd > i ? iAdd : i;
        }

        public void appendName(int i, StringBuilder sb) {
            sb.append(this.m_prefix_);
            byte b = this.m_type_;
            if (b == 0) {
                sb.append(Utility.hex(i, this.m_variant_));
                return;
            }
            if (b != 1) {
                return;
            }
            int i2 = i - this.m_rangestart_;
            int i3 = this.m_variant_;
            int[] iArr = new int[i3];
            for (int i4 = i3 - 1; i4 > 0; i4--) {
                int i5 = this.m_factor_[i4] & 255;
                iArr[i4] = i2 % i5;
                i2 /= i5;
            }
            iArr[0] = i2;
            sb.append(getFactorString(iArr, this.m_variant_));
        }

        public boolean contains(int i) {
            return this.m_rangestart_ <= i && i <= this.m_rangeend_;
        }

        public int getChar(CharacterNameQuery characterNameQuery) {
            this.m_prefix_.getClass();
            CharacterNameQuery.Matcher matcher = characterNameQuery.matcher();
            if (!matcher.consistentWith(this.m_prefix_)) {
                return -1;
            }
            byte b = this.m_type_;
            if (b == 0) {
                try {
                    int i = Integer.parseInt(matcher.remainingSignificantCharacters().toString(), 16);
                    if (this.m_rangestart_ <= i && i <= this.m_rangeend_) {
                        return i;
                    }
                } catch (NumberFormatException unused) {
                }
            } else if (b == 1) {
                for (int i2 = this.m_rangestart_; i2 <= this.m_rangeend_; i2++) {
                    int i3 = i2 - this.m_rangestart_;
                    int i4 = this.m_variant_;
                    int[] iArr = new int[i4];
                    for (int i5 = i4 - 1; i5 > 0; i5--) {
                        int i6 = this.m_factor_[i5] & 255;
                        iArr[i5] = i3 % i6;
                        i3 /= i6;
                    }
                    iArr[0] = i3;
                    if (compareFactorString(iArr, this.m_variant_, matcher.remainingSignificantCharacters().toString(), 0)) {
                        return i2;
                    }
                }
            }
            return -1;
        }

        public boolean setFactor(char[] cArr) {
            if (cArr.length != this.m_variant_) {
                return false;
            }
            this.m_factor_ = cArr;
            return true;
        }

        public boolean setFactorString(byte[] bArr) {
            this.m_factorstring_ = bArr;
            return true;
        }

        public boolean setInfo(int i, int i2, byte b, byte b2) {
            if (i < 0 || i > i2 || i2 > 1114111) {
                return false;
            }
            if (b != 0 && b != 1) {
                return false;
            }
            this.m_rangestart_ = i;
            this.m_rangeend_ = i2;
            this.m_type_ = b;
            this.m_variant_ = b2;
            return true;
        }

        public boolean setPrefix(String str) {
            if (str == null || str.length() <= 0) {
                return false;
            }
            this.m_prefix_ = str;
            return true;
        }
    }

    static {
        try {
            INSTANCE = new UCharacterName();
            TYPE_NAMES_ = new String[]{"unassigned", "uppercase letter", "lowercase letter", "titlecase letter", "modifier letter", "other letter", "non spacing mark", "enclosing mark", "combining spacing mark", "decimal digit number", "letter number", "other number", "space separator", "line separator", "paragraph separator", "control", "format", "private use area", "surrogate", "dash punctuation", "start punctuation", "end punctuation", "connector punctuation", "other punctuation", "math symbol", "currency symbol", "modifier symbol", "other symbol", "initial punctuation", "final punctuation", "noncharacter", "lead surrogate", "trail surrogate"};
        } catch (IOException unused) {
            throw new MissingResourceException("Could not construct UCharacterName. Missing unames.icu", "", "");
        }
    }

    private UCharacterName() throws IOException {
        new UCharacterNameReader(ICUBinary.getRequiredData(FILE_NAME_)).read(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int add(int[] iArr, CharSequence charSequence) {
        int length = charSequence.length();
        for (int i = length - 1; i >= 0; i--) {
            add(iArr, charSequence.charAt(i));
        }
        return length;
    }

    private int addAlgorithmName(int i) {
        for (int length = this.m_algorithm_.length - 1; length >= 0; length--) {
            int iAdd = this.m_algorithm_[length].add(this.m_nameSet_, i);
            if (iAdd > i) {
                i = iAdd;
            }
        }
        return i;
    }

    private int addExtendedName(int i) {
        for (int length = TYPE_NAMES_.length - 1; length >= 0; length--) {
            int iAdd = add(this.m_nameSet_, TYPE_NAMES_[length]) + 9;
            if (iAdd > i) {
                i = iAdd;
            }
        }
        return i;
    }

    private int[] addGroupName(int i, int i2, byte[] bArr, int[] iArr) {
        int i3 = 0;
        int i4 = 0;
        while (i3 < i2) {
            byte[] bArr2 = this.m_groupstring_;
            char c = (char) (bArr2[i + i3] & UCharacterEnums.ECharacterDirection.DIRECTIONALITY_UNDEFINED);
            int i5 = i3 + 1;
            if (c == ';') {
                i3 = i5;
                break;
            }
            char[] cArr = this.m_tokentable_;
            if (c >= cArr.length) {
                add(iArr, c);
            } else {
                char c2 = cArr[c & 255];
                if (c2 == 65534) {
                    c = (char) ((bArr2[i5 + i] & UCharacterEnums.ECharacterDirection.DIRECTIONALITY_UNDEFINED) | (c << '\b'));
                    c2 = cArr[c];
                    i5 = i3 + 2;
                }
                if (c2 == 65535) {
                    add(iArr, c);
                } else {
                    byte bAdd = bArr[c];
                    if (bAdd == 0) {
                        StringBuilder sb = new StringBuilder();
                        UCharacterUtility.getNullTermByteSubString(sb, this.m_tokenstring_, c2);
                        bAdd = (byte) add(iArr, sb);
                        bArr[c] = bAdd;
                    }
                    i4 += bAdd;
                }
                i3 = i5;
            }
            i4++;
            i3 = i5;
        }
        int[] iArr2 = this.m_utilIntBuffer_;
        iArr2[0] = i4;
        iArr2[1] = i3;
        return iArr2;
    }

    private static boolean contains(int[] iArr, char c) {
        return (iArr[c >>> 5] & (1 << (c & 31))) != 0;
    }

    private void convert(int[] iArr, UnicodeSet unicodeSet) {
        unicodeSet.clear();
        if (initNameSetsLengths()) {
            for (char c = 255; c > 0; c = (char) (c - 1)) {
                if (contains(iArr, c)) {
                    unicodeSet.add(c);
                }
            }
        }
    }

    private String getAlgName(int i, int i2) {
        if (i2 != 0 && i2 != 2) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (int length = this.m_algorithm_.length - 1; length >= 0; length--) {
            if (this.m_algorithm_[length].contains(i)) {
                this.m_algorithm_[length].appendName(i, sb);
                return sb.toString();
            }
        }
        return null;
    }

    public static int getCodepointMSB(int i) {
        return i >> 5;
    }

    private static int getExtendedChar(String str, int i) {
        int iLastIndexOf;
        int i2;
        int i3;
        if (str.charAt(0) != '<') {
            return -2;
        }
        if (i == 2) {
            int length = str.length() - 1;
            if (str.charAt(length) == '>' && (iLastIndexOf = str.lastIndexOf(45)) >= 0 && (i3 = length - (i2 = iLastIndexOf + 1)) >= 1 && 8 >= i3) {
                try {
                    int i4 = Integer.parseInt(str.substring(i2, length), 16);
                    if (i4 >= 0 && 1114111 >= i4) {
                        int type = getType(i4);
                        String strSubstring = str.substring(1, iLastIndexOf);
                        int length2 = TYPE_NAMES_.length;
                        for (int i5 = 0; i5 < length2; i5++) {
                            if (strSubstring.compareTo(TYPE_NAMES_[i5]) == 0) {
                                if (type == i5) {
                                    return i4;
                                }
                            }
                        }
                    }
                } catch (NumberFormatException unused) {
                }
            }
        }
        return -1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0, types: [char] */
    /* JADX WARN: Type inference failed for: r7v1, types: [int] */
    /* JADX WARN: Type inference failed for: r7v2, types: [int] */
    /* JADX WARN: Type inference failed for: r7v3, types: [int] */
    private int getGroupChar(int i, char[] cArr, CharacterNameQuery characterNameQuery, int i2) {
        int i3;
        int i4 = i;
        int i5 = 0;
        while (i5 <= 32) {
            CharacterNameQuery.Matcher matcher = characterNameQuery.matcher();
            char c = cArr[i5];
            if (i2 != 0) {
                if (i2 != 2) {
                    int i6 = i2 != 4 ? i2 : 2;
                    do {
                        int iSkipByteSubString = UCharacterUtility.skipByteSubString(this.m_groupstring_, i4, c, (byte) 59) + i4;
                        c -= iSkipByteSubString - i4;
                        i6--;
                        i4 = iSkipByteSubString;
                    } while (i6 > 0);
                }
            }
            int i7 = 0;
            while (true) {
                if (i7 < c) {
                    byte[] bArr = this.m_groupstring_;
                    byte b = bArr[i4 + i7];
                    int i8 = i7 + 1;
                    char[] cArr2 = this.m_tokentable_;
                    if (b < cArr2.length) {
                        int i9 = b & UCharacterEnums.ECharacterDirection.DIRECTIONALITY_UNDEFINED;
                        char c2 = cArr2[i9];
                        if (c2 == 65534) {
                            i7 += 2;
                            i3 = cArr2[(bArr[i8 + i4] & UCharacterEnums.ECharacterDirection.DIRECTIONALITY_UNDEFINED) | (b << 8)];
                        } else {
                            i7 = i8;
                            i3 = c2;
                        }
                        if (i3 == 65535) {
                            char c3 = (char) i9;
                            if (c3 != ';') {
                                if (!matcher.consistentWith(c3)) {
                                }
                            }
                            i5++;
                            i4 += c;
                        } else {
                            while (true) {
                                byte b2 = this.m_tokenstring_[i3];
                                if (b2 == 0) {
                                    continue;
                                } else if (matcher.consistentWith((char) (b2 & UCharacterEnums.ECharacterDirection.DIRECTIONALITY_UNDEFINED))) {
                                    i3++;
                                } else {
                                    i5++;
                                    i4 += c;
                                }
                            }
                        }
                    } else if (matcher.consistentWith((char) (b & UCharacterEnums.ECharacterDirection.DIRECTIONALITY_UNDEFINED))) {
                        i7 = i8;
                    } else {
                        i5++;
                        i4 += c;
                    }
                }
                if (matcher.matches()) {
                    return i5;
                }
                i5++;
                i4 += c;
            }
        }
        return -1;
    }

    public static int getGroupLimit(int i) {
        return (i << 5) + 32;
    }

    public static int getGroupMin(int i) {
        return i << 5;
    }

    public static int getGroupMinFromCodepoint(int i) {
        return i & (-32);
    }

    public static int getGroupOffset(int i) {
        return i & 31;
    }

    private static int getType(int i) {
        if (UCharacterUtility.isNonCharacter(i)) {
            return 30;
        }
        int type = UCharacter.getType(i);
        if (type == 18) {
            return i <= 56319 ? 31 : 32;
        }
        return type;
    }

    private boolean initNameSetsLengths() {
        if (this.m_maxNameLength_ > 0) {
            return true;
        }
        for (int i = 18; i >= 0; i--) {
            add(this.m_nameSet_, "0123456789ABCDEF<>-".charAt(i));
        }
        int iAddAlgorithmName = addAlgorithmName(0);
        this.m_maxNameLength_ = iAddAlgorithmName;
        int iAddExtendedName = addExtendedName(iAddAlgorithmName);
        this.m_maxNameLength_ = iAddExtendedName;
        addGroupName(iAddExtendedName);
        return true;
    }

    public int getAlgorithmEnd(int i) {
        return this.m_algorithm_[i].m_rangeend_;
    }

    public int getAlgorithmLength() {
        return this.m_algorithm_.length;
    }

    public String getAlgorithmName(int i, int i2) {
        StringBuilder sb = new StringBuilder();
        this.m_algorithm_[i].appendName(i2, sb);
        return sb.toString();
    }

    public int getAlgorithmStart(int i) {
        return this.m_algorithm_[i].m_rangestart_;
    }

    public int getCharFromName(int i, String str) {
        if (i >= 4 || str == null || str.length() == 0) {
            return -1;
        }
        int extendedChar = getExtendedChar(str.toLowerCase(Locale.ENGLISH), i);
        if (extendedChar >= -1) {
            return extendedChar;
        }
        CharacterNameQuery characterNameQuery = new CharacterNameQuery(str);
        if (i == 0 || i == 2) {
            AlgorithmName[] algorithmNameArr = this.m_algorithm_;
            for (int length = (algorithmNameArr != null ? algorithmNameArr.length : 0) - 1; length >= 0; length--) {
                int i2 = this.m_algorithm_[length].getChar(characterNameQuery);
                if (i2 >= 0) {
                    return i2;
                }
            }
        }
        if (i != 2) {
            return getGroupChar(characterNameQuery, i);
        }
        int groupChar = getGroupChar(characterNameQuery, 0);
        return groupChar == -1 ? getGroupChar(characterNameQuery, 3) : groupChar;
    }

    public void getCharNameCharacters(UnicodeSet unicodeSet) {
        convert(this.m_nameSet_, unicodeSet);
    }

    public String getExtendedName(int i) {
        String name = getName(i, 0);
        return name == null ? getExtendedOr10Name(i) : name;
    }

    public String getExtendedOr10Name(int i) {
        int type = getType(i);
        String[] strArr = TYPE_NAMES_;
        String str = type >= strArr.length ? UNKNOWN_TYPE_NAME_ : strArr[type];
        StringBuilder sb = new StringBuilder("<");
        sb.append(str);
        sb.append('-');
        String upperCase = Integer.toHexString(i).toUpperCase(Locale.ENGLISH);
        for (int length = 4 - upperCase.length(); length > 0; length--) {
            sb.append('0');
        }
        return ky0.n(sb, upperCase, '>');
    }

    public int getGroup(int i) {
        int i2 = this.m_groupcount_;
        int codepointMSB = getCodepointMSB(i);
        int i3 = 0;
        while (i3 < i2 - 1) {
            int i4 = (i3 + i2) >> 1;
            if (codepointMSB < getGroupMSB(i4)) {
                i2 = i4;
            } else {
                i3 = i4;
            }
        }
        return i3;
    }

    public int getGroupLengths(int i, char[] cArr, char[] cArr2) {
        int i2 = i * this.m_groupsize_;
        char[] cArr3 = this.m_groupinfo_;
        int i3 = UCharacterUtility.toInt(cArr3[i2 + 1], cArr3[i2 + 2]);
        int i4 = 0;
        cArr[0] = 0;
        byte b = 65535;
        while (i4 < 32) {
            byte b2 = this.m_groupstring_[i3];
            for (int i5 = 4; i5 >= 0; i5 -= 4) {
                byte b3 = (byte) ((b2 >> i5) & 15);
                if (b != 65535 || b3 <= 11) {
                    if (b != 65535) {
                        cArr2[i4] = (char) ((b | b3) + 12);
                    } else {
                        cArr2[i4] = (char) b3;
                    }
                    if (i4 < 32) {
                        cArr[i4 + 1] = (char) (cArr[i4] + cArr2[i4]);
                    }
                    i4++;
                    b = 65535;
                } else {
                    b = (char) ((b3 - 12) << 4);
                }
            }
            i3++;
        }
        return i3;
    }

    public int getGroupMSB(int i) {
        if (i >= this.m_groupcount_) {
            return -1;
        }
        return this.m_groupinfo_[i * this.m_groupsize_];
    }

    public String getGroupName(int i, int i2, int i3) {
        int i4 = 0;
        if (i3 != 0 && i3 != 2) {
            char[] cArr = this.m_tokentable_;
            if (59 >= cArr.length || cArr[59] == 65535) {
                int i5 = i3 == 4 ? 2 : i3;
                do {
                    int iSkipByteSubString = UCharacterUtility.skipByteSubString(this.m_groupstring_, i, i2, (byte) 59) + i;
                    i2 -= iSkipByteSubString - i;
                    i5--;
                    i = iSkipByteSubString;
                } while (i5 > 0);
            } else {
                i2 = 0;
            }
        }
        StringBuilder sb = new StringBuilder();
        while (i4 < i2) {
            byte[] bArr = this.m_groupstring_;
            byte b = bArr[i + i4];
            int i6 = i4 + 1;
            char[] cArr2 = this.m_tokentable_;
            if (b < cArr2.length) {
                int i7 = b & UCharacterEnums.ECharacterDirection.DIRECTIONALITY_UNDEFINED;
                char c = cArr2[i7];
                if (c == 65534) {
                    c = cArr2[(bArr[i6 + i] & UCharacterEnums.ECharacterDirection.DIRECTIONALITY_UNDEFINED) | (b << 8)];
                    i4 += 2;
                } else {
                    i4 = i6;
                }
                if (c != 65535) {
                    UCharacterUtility.getNullTermByteSubString(sb, this.m_tokenstring_, c);
                } else if (b != 59) {
                    sb.append((char) i7);
                } else if (sb.length() != 0 || i3 != 2) {
                    break;
                }
            } else {
                if (b == 59) {
                    break;
                }
                sb.append((int) b);
                i4 = i6;
            }
        }
        if (sb.length() > 0) {
            return sb.toString();
        }
        return null;
    }

    public void getISOCommentCharacters(UnicodeSet unicodeSet) {
        convert(this.m_ISOCommentSet_, unicodeSet);
    }

    public int getMaxCharNameLength() {
        if (initNameSetsLengths()) {
            return this.m_maxNameLength_;
        }
        return 0;
    }

    public int getMaxISOCommentLength() {
        if (initNameSetsLengths()) {
            return this.m_maxISOCommentLength_;
        }
        return 0;
    }

    public String getName(int i, int i2) {
        if (i < 0 || i > 1114111 || i2 > 4) {
            return null;
        }
        String algName = getAlgName(i, i2);
        if (algName == null || algName.length() == 0) {
            return i2 == 2 ? getExtendedName(i) : getGroupName(i, i2);
        }
        return algName;
    }

    public boolean setAlgorithm(AlgorithmName[] algorithmNameArr) {
        if (algorithmNameArr == null || algorithmNameArr.length == 0) {
            return false;
        }
        this.m_algorithm_ = algorithmNameArr;
        return true;
    }

    public boolean setGroup(char[] cArr, byte[] bArr) {
        if (cArr == null || bArr == null || cArr.length <= 0 || bArr.length <= 0) {
            return false;
        }
        this.m_groupinfo_ = cArr;
        this.m_groupstring_ = bArr;
        return true;
    }

    public boolean setGroupCountSize(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            return false;
        }
        this.m_groupcount_ = i;
        this.m_groupsize_ = i2;
        return true;
    }

    public boolean setToken(char[] cArr, byte[] bArr) {
        if (cArr == null || bArr == null || cArr.length <= 0 || bArr.length <= 0) {
            return false;
        }
        this.m_tokentable_ = cArr;
        this.m_tokenstring_ = bArr;
        return true;
    }

    private static void add(int[] iArr, char c) {
        int i = c >>> 5;
        iArr[i] = (1 << (c & 31)) | iArr[i];
    }

    private void addGroupName(int i) {
        char[] cArr = new char[34];
        char[] cArr2 = new char[34];
        byte[] bArr = new byte[this.m_tokentable_.length];
        int i2 = 0;
        for (int i3 = 0; i3 < this.m_groupcount_; i3++) {
            int groupLengths = getGroupLengths(i3, cArr, cArr2);
            for (int i4 = 0; i4 < 32; i4++) {
                int i5 = cArr[i4] + groupLengths;
                char c = cArr2[i4];
                if (c != 0) {
                    int[] iArrAddGroupName = addGroupName(i5, c, bArr, this.m_nameSet_);
                    int i6 = iArrAddGroupName[0];
                    if (i6 > i) {
                        i = i6;
                    }
                    int i7 = iArrAddGroupName[1];
                    int i8 = i5 + i7;
                    if (i7 < c) {
                        int i9 = c - i7;
                        int[] iArrAddGroupName2 = addGroupName(i8, i9, bArr, this.m_nameSet_);
                        int i10 = iArrAddGroupName2[0];
                        if (i10 > i) {
                            i = i10;
                        }
                        int i11 = iArrAddGroupName2[1];
                        int i12 = i8 + i11;
                        if (i11 < i9) {
                            int i13 = i9 - i11;
                            if (addGroupName(i12, i13, bArr, this.m_ISOCommentSet_)[1] > i2) {
                                i2 = i13;
                            }
                        }
                    }
                }
            }
        }
        this.m_maxISOCommentLength_ = i2;
        this.m_maxNameLength_ = i;
    }

    public synchronized String getGroupName(int i, int i2) {
        int codepointMSB = getCodepointMSB(i);
        int group = getGroup(i);
        if (codepointMSB != this.m_groupinfo_[this.m_groupsize_ * group]) {
            return null;
        }
        int i3 = i & 31;
        return getGroupName(getGroupLengths(group, this.m_groupoffsets_, this.m_grouplengths_) + this.m_groupoffsets_[i3], this.m_grouplengths_[i3], i2);
    }

    private synchronized int getGroupChar(CharacterNameQuery characterNameQuery, int i) {
        for (int i2 = 0; i2 < this.m_groupcount_; i2++) {
            int groupLengths = getGroupLengths(i2, this.m_groupoffsets_, this.m_grouplengths_);
            start = this.m_groupinfo_[this.m_groupsize_ * i2] << 5;
            int groupChar = getGroupChar(groupLengths, this.m_grouplengths_, characterNameQuery, i);
            if (groupChar != -1) {
                return (this.m_groupinfo_[i2 * this.m_groupsize_] << 5) | groupChar;
            }
        }
        return -1;
    }
}
