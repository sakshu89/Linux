package com.ibm.icu.impl;

import com.ibm.icu.lang.UCharacter;
import com.ibm.icu.text.UTF16;
import com.ibm.icu.text.UnicodeSet;
import com.ibm.icu.util.ULocale;
import defpackage.dk0;
import defpackage.kf2;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class UCaseProps {
    private static final int ABOVE = 64;
    private static final int CLOSURE_MAX_LENGTH = 15;
    private static final String DATA_FILE_NAME = "ucase.icu";
    private static final String DATA_NAME = "ucase";
    private static final String DATA_TYPE = "icu";
    private static final int DELTA_SHIFT = 7;
    private static final int DOT_MASK = 96;
    private static final int EXCEPTION = 8;
    private static final int EXC_CLOSURE = 6;
    private static final int EXC_CONDITIONAL_FOLD = 32768;
    private static final int EXC_CONDITIONAL_SPECIAL = 16384;
    private static final int EXC_DELTA = 4;
    private static final int EXC_DELTA_IS_NEGATIVE = 1024;
    private static final int EXC_DOT_SHIFT = 7;
    private static final int EXC_DOUBLE_SLOTS = 256;
    private static final int EXC_FOLD = 1;
    private static final int EXC_FULL_MAPPINGS = 7;
    private static final int EXC_LOWER = 0;
    private static final int EXC_NO_SIMPLE_CASE_FOLDING = 512;
    private static final int EXC_SENSITIVE = 2048;
    private static final int EXC_SHIFT = 4;
    private static final int EXC_TITLE = 3;
    private static final int EXC_UPPER = 2;
    private static final int FMT = 1665225541;
    static final int FOLD_CASE_OPTIONS_MASK = 7;
    private static final int FULL_LOWER = 15;
    static final int IGNORABLE = 4;
    public static final UCaseProps INSTANCE;
    private static final int IX_EXC_LENGTH = 3;
    private static final int IX_TOP = 16;
    private static final int IX_TRIE_SIZE = 2;
    private static final int IX_UNFOLD_LENGTH = 4;
    static final int LOC_ARMENIAN = 6;
    public static final int LOC_DUTCH = 5;
    static final int LOC_GREEK = 4;
    static final int LOC_LITHUANIAN = 3;
    public static final int LOC_ROOT = 1;
    static final int LOC_TURKISH = 2;
    public static final int LOWER = 1;
    public static final int MAX_STRING_LENGTH = 31;
    public static final int NONE = 0;
    private static final int OTHER_ACCENT = 96;
    private static final int SENSITIVE = 16;
    private static final int SOFT_DOTTED = 32;
    public static final int TITLE = 3;
    public static final int TYPE_MASK = 3;
    private static final int UNFOLD_ROWS = 0;
    private static final int UNFOLD_ROW_WIDTH = 1;
    private static final int UNFOLD_STRING_WIDTH = 2;
    public static final int UPPER = 2;
    private static final String iDot = "i̇";
    private static final String iDotAcute = "i̇́";
    private static final String iDotGrave = "i̇̀";
    private static final String iDotTilde = "i̇̃";
    private static final String iOgonekDot = "į̇";
    private static final String jDot = "j̇";
    private String exceptions;
    private int[] indexes;
    private Trie2_16 trie;
    private char[] unfold;
    private static final byte[] flagsOffset = {0, 1, 1, 2, 1, 2, 2, 3, 1, 2, 2, 3, 2, 3, 3, 4, 1, 2, 2, 3, 2, 3, 3, 4, 2, 3, 3, 4, 3, 4, 4, 5, 1, 2, 2, 3, 2, 3, 3, 4, 2, 3, 3, 4, 3, 4, 4, 5, 2, 3, 3, 4, 3, 4, 4, 5, 3, 4, 4, 5, 4, 5, 5, 6, 1, 2, 2, 3, 2, 3, 3, 4, 2, 3, 3, 4, 3, 4, 4, 5, 2, 3, 3, 4, 3, 4, 4, 5, 3, 4, 4, 5, 4, 5, 5, 6, 2, 3, 3, 4, 3, 4, 4, 5, 3, 4, 4, 5, 4, 5, 5, 6, 3, 4, 4, 5, 4, 5, 5, 6, 4, 5, 5, 6, 5, 6, 6, 7, 1, 2, 2, 3, 2, 3, 3, 4, 2, 3, 3, 4, 3, 4, 4, 5, 2, 3, 3, 4, 3, 4, 4, 5, 3, 4, 4, 5, 4, 5, 5, 6, 2, 3, 3, 4, 3, 4, 4, 5, 3, 4, 4, 5, 4, 5, 5, 6, 3, 4, 4, 5, 4, 5, 5, 6, 4, 5, 5, 6, 5, 6, 6, 7, 2, 3, 3, 4, 3, 4, 4, 5, 3, 4, 4, 5, 4, 5, 5, 6, 3, 4, 4, 5, 4, 5, 5, 6, 4, 5, 5, 6, 5, 6, 6, 7, 3, 4, 4, 5, 4, 5, 5, 6, 4, 5, 5, 6, 5, 6, 6, 7, 4, 5, 5, 6, 5, 6, 6, 7, 5, 6, 6, 7, 6, 7, 7, 8};
    public static final StringBuilder dummyStringBuilder = new StringBuilder();

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public interface ContextIterator {
        int next();

        void reset(int i);
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class LatinCase {
        static final byte EXC = -128;
        static final char LIMIT = 384;
        static final char LONG_S = 383;
        static final byte[] TO_LOWER_NORMAL = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -128, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 0, 32, 32, 32, 32, 32, 32, 32, -128, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, -128, 0, 1, 0, 1, 0, 1, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, -128, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, -121, 1, 0, 1, 0, 1, 0, -128};
        static final byte[] TO_LOWER_TR_LT = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 32, 32, 32, 32, 32, 32, 32, 32, -128, -128, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -128, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, -128, -128, 32, 32, 32, 32, 32, 32, 32, 32, 32, 0, 32, 32, 32, 32, 32, 32, 32, -128, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, -128, 0, 1, 0, 1, 0, -128, 0, -128, 0, 1, 0, 1, 0, 1, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, -128, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, -121, 1, 0, 1, 0, 1, 0, -128};
        static final byte[] TO_UPPER_NORMAL = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -32, -32, -32, -32, -32, -32, -32, -32, -32, -32, -32, -32, -32, -32, -32, -32, -32, -32, -32, -32, -32, -32, -32, -32, -32, -32, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -128, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -128, -32, -32, -32, -32, -32, -32, -32, -32, -32, -32, -32, -32, -32, -32, -32, -32, -32, -32, -32, -32, -32, -32, -32, 0, -32, -32, -32, -32, -32, -32, -32, 121, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, -128, 0, -1, 0, -1, 0, -1, 0, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, -128, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, 0, -1, 0, -1, 0, -1, -128};
        static final byte[] TO_UPPER_TR = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -32, -32, -32, -32, -32, -32, -32, -32, -128, -32, -32, -32, -32, -32, -32, -32, -32, -32, -32, -32, -32, -32, -32, -32, -32, -32, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -128, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -128, -32, -32, -32, -32, -32, -32, -32, -32, -32, -32, -32, -32, -32, -32, -32, -32, -32, -32, -32, -32, -32, -32, -32, 0, -32, -32, -32, -32, -32, -32, -32, 121, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, -128, 0, -1, 0, -1, 0, -1, 0, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, -128, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, 0, -1, 0, -1, 0, -1, -128};
    }

    static {
        try {
            INSTANCE = new UCaseProps();
        } catch (IOException e) {
            kf2.h(e);
        }
    }

    private UCaseProps() throws IOException {
        readData(ICUBinary.getRequiredData(DATA_FILE_NAME));
    }

    private static final int getCaseLocale(String str) {
        if (str.length() == 2) {
            if (str.equals("en") || str.charAt(0) > 't') {
                return 1;
            }
            if (str.equals("tr") || str.equals("az")) {
                return 2;
            }
            if (str.equals("el")) {
                return 4;
            }
            if (str.equals("lt")) {
                return 3;
            }
            if (str.equals("nl")) {
                return 5;
            }
            if (str.equals("hy")) {
                return 6;
            }
        } else if (str.length() == 3) {
            if (str.equals("tur") || str.equals("aze")) {
                return 2;
            }
            if (str.equals("ell")) {
                return 4;
            }
            if (str.equals("lit")) {
                return 3;
            }
            if (str.equals("nld")) {
                return 5;
            }
            if (str.equals("hye")) {
                return 6;
            }
        }
        return 1;
    }

    public static final int getDelta(int i) {
        return ((short) i) >> 7;
    }

    private static final int getExceptionsOffset(int i) {
        return i >> 4;
    }

    private final int getSlotValue(int i, int i2, int i3) {
        if ((i & 256) == 0) {
            return this.exceptions.charAt(i3 + slotOffset(i, i2));
        }
        int iSlotOffset = (slotOffset(i, i2) * 2) + i3;
        int i4 = iSlotOffset + 1;
        return this.exceptions.charAt(i4) | (this.exceptions.charAt(iSlotOffset) << 16);
    }

    private final long getSlotValueAndOffset(int i, int i2, int i3) {
        int iSlotOffset;
        long jCharAt;
        if ((i & 256) == 0) {
            iSlotOffset = i3 + slotOffset(i, i2);
            jCharAt = this.exceptions.charAt(iSlotOffset);
        } else {
            int iSlotOffset2 = (slotOffset(i, i2) * 2) + i3;
            iSlotOffset = iSlotOffset2 + 1;
            jCharAt = (((long) this.exceptions.charAt(iSlotOffset2)) << 16) | ((long) this.exceptions.charAt(iSlotOffset));
        }
        return jCharAt | (((long) iSlotOffset) << 32);
    }

    public static Trie2_16 getTrie() {
        return INSTANCE.trie;
    }

    private static final int getTypeAndIgnorableFromProps(int i) {
        return i & 7;
    }

    public static final int getTypeFromProps(int i) {
        return i & 3;
    }

    private static final boolean hasSlot(int i, int i2) {
        return (i & (1 << i2)) != 0;
    }

    private final boolean isFollowedByCasedLetter(ContextIterator contextIterator, int i) {
        int typeOrIgnorable;
        if (contextIterator == null) {
            return false;
        }
        contextIterator.reset(i);
        do {
            int next = contextIterator.next();
            if (next >= 0) {
                typeOrIgnorable = getTypeOrIgnorable(next);
            }
        } while ((typeOrIgnorable & 4) != 0);
        return typeOrIgnorable != 0;
    }

    private final boolean isFollowedByDotAbove(ContextIterator contextIterator) {
        int next;
        if (contextIterator == null) {
            return false;
        }
        contextIterator.reset(1);
        do {
            next = contextIterator.next();
            if (next < 0) {
                break;
            }
            if (next == 775) {
                return true;
            }
        } while (getDotType(next) == 96);
        return false;
    }

    private final boolean isFollowedByMoreAbove(ContextIterator contextIterator) {
        int dotType;
        if (contextIterator == null) {
            return false;
        }
        contextIterator.reset(1);
        do {
            int next = contextIterator.next();
            if (next < 0) {
                break;
            }
            dotType = getDotType(next);
            if (dotType == 64) {
                return true;
            }
        } while (dotType == 96);
        return false;
    }

    private final boolean isPrecededBySoftDotted(ContextIterator contextIterator) {
        int dotType;
        if (contextIterator == null) {
            return false;
        }
        contextIterator.reset(-1);
        do {
            int next = contextIterator.next();
            if (next < 0) {
                break;
            }
            dotType = getDotType(next);
            if (dotType == 32) {
                return true;
            }
        } while (dotType == 96);
        return false;
    }

    private final boolean isPrecededBy_I(ContextIterator contextIterator) {
        int next;
        if (contextIterator == null) {
            return false;
        }
        contextIterator.reset(-1);
        do {
            next = contextIterator.next();
            if (next < 0) {
                break;
            }
            if (next == 73) {
                return true;
            }
        } while (getDotType(next) == 96);
        return false;
    }

    public static final boolean isUpperOrTitleFromProps(int i) {
        return (i & 2) != 0;
    }

    public static final boolean propsHasException(int i) {
        return (i & 8) != 0;
    }

    private final void readData(ByteBuffer byteBuffer) throws IOException {
        ICUBinary.readHeader(byteBuffer, FMT, new IsAcceptable(0));
        int i = byteBuffer.getInt();
        if (i < 16) {
            dk0.h("indexes[0] too small in ucase.icu");
            return;
        }
        int[] iArr = new int[i];
        this.indexes = iArr;
        iArr[0] = i;
        for (int i2 = 1; i2 < i; i2++) {
            this.indexes[i2] = byteBuffer.getInt();
        }
        Trie2_16 trie2_16CreateFromSerialized = Trie2_16.createFromSerialized(byteBuffer);
        this.trie = trie2_16CreateFromSerialized;
        int i3 = this.indexes[2];
        int serializedLength = trie2_16CreateFromSerialized.getSerializedLength();
        if (serializedLength > i3) {
            dk0.h("ucase.icu: not enough bytes for the trie");
            return;
        }
        ICUBinary.skipBytes(byteBuffer, i3 - serializedLength);
        int i4 = this.indexes[3];
        if (i4 > 0) {
            this.exceptions = ICUBinary.getString(byteBuffer, i4, 0);
        }
        int i5 = this.indexes[4];
        if (i5 > 0) {
            this.unfold = ICUBinary.getChars(byteBuffer, i5, 0);
        }
    }

    private static final byte slotOffset(int i, int i2) {
        return flagsOffset[i & ((1 << i2) - 1)];
    }

    private final int strcmpMax(String str, int i, int i2) {
        int length = str.length();
        int i3 = i2 - length;
        int i4 = 0;
        while (true) {
            int i5 = i4 + 1;
            char cCharAt = str.charAt(i4);
            char[] cArr = this.unfold;
            int i6 = i + 1;
            char c = cArr[i];
            if (c == 0) {
                return 1;
            }
            int i7 = cCharAt - c;
            if (i7 != 0) {
                return i7;
            }
            length--;
            if (length <= 0) {
                if (i3 == 0 || cArr[i6] == 0) {
                    return 0;
                }
                return -i3;
            }
            i4 = i5;
            i = i6;
        }
    }

    private final int toUpperOrTitle(int i, ContextIterator contextIterator, Appendable appendable, int i2, boolean z) {
        int slotValue;
        int i3 = this.trie.get(i);
        if (propsHasException(i3)) {
            int exceptionsOffset = getExceptionsOffset(i3);
            int i4 = exceptionsOffset + 1;
            char cCharAt = this.exceptions.charAt(exceptionsOffset);
            int i5 = 3;
            if ((cCharAt & 16384) != 0) {
                if (i2 == 2 && i == 105) {
                    return UCharacter.UnicodeBlock.KHITAN_SMALL_SCRIPT_ID;
                }
                if (i2 == 3 && i == 775 && isPrecededBySoftDotted(contextIterator)) {
                    return 0;
                }
                if (i == 1415) {
                    try {
                        if (i2 == 6) {
                            appendable.append(z ? "ԵՎ" : "Եվ");
                        } else {
                            appendable.append(z ? "ԵՒ" : "Եւ");
                        }
                        return 2;
                    } catch (IOException e) {
                        kf2.h(e);
                        return 0;
                    }
                }
            } else if (hasSlot(cCharAt, 7)) {
                long slotValueAndOffset = getSlotValueAndOffset(cCharAt, 7, i4);
                int i6 = (int) slotValueAndOffset;
                int i7 = 65535 & i6;
                int i8 = ((int) (slotValueAndOffset >> 32)) + 1 + (i6 & 15) + ((i7 >> 4) & 15);
                int i9 = i7 >> 8;
                if (!z) {
                    i8 += i9 & 15;
                    i9 = i7 >> 12;
                }
                int i10 = i9 & 15;
                if (i10 != 0) {
                    try {
                        appendable.append(this.exceptions, i8, i8 + i10);
                        return i10;
                    } catch (IOException e2) {
                        kf2.h(e2);
                        return 0;
                    }
                }
            }
            if (hasSlot(cCharAt, 4) && getTypeFromProps(i3) == 1) {
                int slotValue2 = getSlotValue(cCharAt, 4, i4);
                return (cCharAt & 1024) == 0 ? i + slotValue2 : i - slotValue2;
            }
            if (z || !hasSlot(cCharAt, 3)) {
                if (!hasSlot(cCharAt, 2)) {
                    return ~i;
                }
                i5 = 2;
            }
            slotValue = getSlotValue(cCharAt, i5, i4);
        } else {
            slotValue = getTypeFromProps(i3) == 1 ? getDelta(i3) + i : i;
        }
        return slotValue == i ? ~slotValue : slotValue;
    }

    public final void addCaseClosure(int i, UnicodeSet unicodeSet) {
        int i2;
        int delta;
        int i3 = this.trie.get(i);
        if (!propsHasException(i3)) {
            if (getTypeFromProps(i3) == 0 || (delta = getDelta(i3)) == 0) {
                return;
            }
            unicodeSet.add(i + delta);
            return;
        }
        int exceptionsOffset = getExceptionsOffset(i3);
        int i4 = exceptionsOffset + 1;
        char cCharAt = this.exceptions.charAt(exceptionsOffset);
        if ((32768 & cCharAt) != 0) {
            if (i == 73) {
                unicodeSet.add(105);
                return;
            } else if (i == 304) {
                unicodeSet.add(iDot);
                return;
            }
        } else if (i == 105) {
            unicodeSet.add(73);
            return;
        } else if (i == 305) {
            return;
        }
        int iCharCount = 0;
        for (int i5 = 0; i5 <= 3; i5++) {
            if (hasSlot(cCharAt, i5)) {
                unicodeSet.add(getSlotValue(cCharAt, i5, i4));
            }
        }
        if (hasSlot(cCharAt, 4)) {
            int slotValue = getSlotValue(cCharAt, 4, i4);
            unicodeSet.add((cCharAt & 1024) == 0 ? i + slotValue : i - slotValue);
        }
        if (hasSlot(cCharAt, 6)) {
            long slotValueAndOffset = getSlotValueAndOffset(cCharAt, 6, i4);
            iCharCount = ((int) (slotValueAndOffset >> 32)) + 1;
            i2 = ((int) slotValueAndOffset) & 15;
        } else {
            i2 = 0;
        }
        if (hasSlot(cCharAt, 7)) {
            long slotValueAndOffset2 = getSlotValueAndOffset(cCharAt, 7, i4);
            int i6 = (int) slotValueAndOffset2;
            int i7 = 65535 & i6;
            int i8 = ((int) (slotValueAndOffset2 >> 32)) + 1 + (i6 & 15);
            int i9 = (i7 >> 4) & 15;
            if (i9 != 0) {
                int i10 = i9 + i8;
                unicodeSet.add(this.exceptions.substring(i8, i10));
                i8 = i10;
            }
            iCharCount = (i7 >> 12) + i8 + ((i7 >> 8) & 15);
        }
        int i11 = i2 + iCharCount;
        while (iCharCount < i11) {
            int iCodePointAt = this.exceptions.codePointAt(iCharCount);
            iCharCount += Character.charCount(iCodePointAt);
            unicodeSet.add(iCodePointAt);
        }
    }

    public final void addPropertyStarts(UnicodeSet unicodeSet) {
        for (Trie2.Range range : this.trie) {
            if (range.leadSurrogate) {
                return;
            } else {
                unicodeSet.add(range.startCodePoint);
            }
        }
    }

    public final void addSimpleCaseClosure(int i, UnicodeSet unicodeSet) {
        int iCharCount;
        int delta;
        int i2 = this.trie.get(i);
        if (!propsHasException(i2)) {
            if (getTypeFromProps(i2) == 0 || (delta = getDelta(i2)) == 0) {
                return;
            }
            unicodeSet.add(i + delta);
            return;
        }
        int exceptionsOffset = getExceptionsOffset(i2);
        int i3 = exceptionsOffset + 1;
        char cCharAt = this.exceptions.charAt(exceptionsOffset);
        if ((32768 & cCharAt) != 0) {
            if (i == 73) {
                unicodeSet.add(105);
                return;
            } else if (i == 304) {
                return;
            }
        } else if (i == 105) {
            unicodeSet.add(73);
            return;
        } else if (i == 305) {
            return;
        }
        int i4 = 0;
        for (int i5 = 0; i5 <= 3; i5++) {
            if (hasSlot(cCharAt, i5)) {
                unicodeSet.add(getSlotValue(cCharAt, i5, i3));
            }
        }
        if (hasSlot(cCharAt, 4)) {
            int slotValue = getSlotValue(cCharAt, 4, i3);
            unicodeSet.add((cCharAt & 1024) == 0 ? i + slotValue : i - slotValue);
        }
        if (hasSlot(cCharAt, 6)) {
            long slotValueAndOffset = getSlotValueAndOffset(cCharAt, 6, i3);
            i4 = ((int) slotValueAndOffset) & 15;
            iCharCount = ((int) (slotValueAndOffset >> 32)) + 1;
        } else {
            iCharCount = 0;
        }
        if (i4 > 0 && hasSlot(cCharAt, 7)) {
            long slotValueAndOffset2 = getSlotValueAndOffset(cCharAt, 7, i3);
            int i6 = (int) slotValueAndOffset2;
            int i7 = ((int) (slotValueAndOffset2 >> 32)) + 1;
            int i8 = 65535 & i6;
            iCharCount = (i8 >> 12) + i7 + (i6 & 15) + ((i8 >> 4) & 15) + ((i8 >> 8) & 15);
        }
        int i9 = i4 + iCharCount;
        while (iCharCount < i9) {
            int iCodePointAt = this.exceptions.codePointAt(iCharCount);
            iCharCount += Character.charCount(iCodePointAt);
            unicodeSet.add(iCodePointAt);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r3v1, types: [char, int] */
    /* JADX WARN: Type inference failed for: r3v2, types: [int] */
    /* JADX WARN: Type inference failed for: r3v3, types: [int] */
    /* JADX WARN: Type inference failed for: r4v0, types: [char] */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3 */
    public final boolean addStringCaseClosure(String str, UnicodeSet unicodeSet) {
        int length;
        if (this.unfold == null || str == null || (length = str.length()) <= 1) {
            return false;
        }
        char[] cArr = this.unfold;
        char c = cArr[0];
        char c2 = cArr[1];
        char charCount = cArr[2];
        if (length > charCount) {
            return false;
        }
        int i = 0;
        while (i < c) {
            int i2 = (i + (c == true ? 1 : 0)) / 2;
            int i3 = i2 + 1;
            int i4 = i3 * c2;
            int iStrcmpMax = strcmpMax(str, i4, charCount);
            if (iStrcmpMax == 0) {
                while (charCount < c2) {
                    char[] cArr2 = this.unfold;
                    if (cArr2[i4 + charCount] == 0) {
                        break;
                    }
                    int iCharAt = UTF16.charAt(cArr2, i4, cArr2.length, charCount);
                    unicodeSet.add(iCharAt);
                    addCaseClosure(iCharAt, unicodeSet);
                    charCount += UTF16.getCharCount(iCharAt);
                }
                return true;
            }
            if (iStrcmpMax < 0) {
                c = i2;
            } else {
                i = i3;
            }
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0047  */
    /* JADX WARN: Code duplicated, block: B:37:0x0068  */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x006d, code lost:
    
        if (hasSlot(r1, 0) != false) goto L39;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int fold(int r7, int r8) {
        /*
            r6 = this;
            com.ibm.icu.impl.Trie2_16 r0 = r6.trie
            int r0 = r0.get(r7)
            boolean r1 = propsHasException(r0)
            if (r1 != 0) goto L18
            boolean r6 = isUpperOrTitleFromProps(r0)
            if (r6 == 0) goto L74
            int r6 = getDelta(r0)
            int r6 = r6 + r7
            return r6
        L18:
            int r1 = getExceptionsOffset(r0)
            java.lang.String r2 = r6.exceptions
            int r3 = r1 + 1
            char r1 = r2.charAt(r1)
            r2 = 32768(0x8000, float:4.5918E-41)
            r2 = r2 & r1
            if (r2 == 0) goto L42
            r8 = r8 & 7
            r2 = 304(0x130, float:4.26E-43)
            r4 = 105(0x69, float:1.47E-43)
            r5 = 73
            if (r8 != 0) goto L3a
            if (r7 != r5) goto L37
            return r4
        L37:
            if (r7 != r2) goto L42
            goto L74
        L3a:
            if (r7 != r5) goto L3f
            r6 = 305(0x131, float:4.27E-43)
            return r6
        L3f:
            if (r7 != r2) goto L42
            return r4
        L42:
            r8 = r1 & 512(0x200, float:7.17E-43)
            if (r8 == 0) goto L47
            goto L74
        L47:
            r8 = 4
            boolean r2 = hasSlot(r1, r8)
            if (r2 == 0) goto L60
            boolean r0 = isUpperOrTitleFromProps(r0)
            if (r0 == 0) goto L60
            int r6 = r6.getSlotValue(r1, r8, r3)
            r8 = r1 & 1024(0x400, float:1.435E-42)
            if (r8 != 0) goto L5e
            int r7 = r7 + r6
            return r7
        L5e:
            int r7 = r7 - r6
            return r7
        L60:
            r8 = 1
            boolean r0 = hasSlot(r1, r8)
            if (r0 == 0) goto L68
            goto L6f
        L68:
            r8 = 0
            boolean r0 = hasSlot(r1, r8)
            if (r0 == 0) goto L74
        L6f:
            int r6 = r6.getSlotValue(r1, r8, r3)
            return r6
        L74:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ibm.icu.impl.UCaseProps.fold(int, int):int");
    }

    public final int getDotType(int i) {
        int i2 = this.trie.get(i);
        return !propsHasException(i2) ? i2 & 96 : (this.exceptions.charAt(getExceptionsOffset(i2)) >> 7) & 96;
    }

    public final int getType(int i) {
        return getTypeFromProps(this.trie.get(i));
    }

    public final int getTypeOrIgnorable(int i) {
        return getTypeAndIgnorableFromProps(this.trie.get(i));
    }

    public final boolean hasBinaryProperty(int i, int i2) {
        if (i2 == 22) {
            return 1 == getType(i);
        }
        if (i2 == 27) {
            return isSoftDotted(i);
        }
        if (i2 == 30) {
            return 2 == getType(i);
        }
        if (i2 == 34) {
            return isCaseSensitive(i);
        }
        if (i2 == 55) {
            StringBuilder sb = dummyStringBuilder;
            sb.setLength(0);
            return toFullLower(i, null, sb, 1) >= 0 || toFullUpper(i, null, sb, 1) >= 0 || toFullTitle(i, null, sb, 1) >= 0;
        }
        switch (i2) {
            case 49:
                return getType(i) != 0;
            case 50:
                return (getTypeOrIgnorable(i) >> 2) != 0;
            case 51:
                StringBuilder sb2 = dummyStringBuilder;
                sb2.setLength(0);
                return toFullLower(i, null, sb2, 1) >= 0;
            case 52:
                StringBuilder sb3 = dummyStringBuilder;
                sb3.setLength(0);
                return toFullUpper(i, null, sb3, 1) >= 0;
            case 53:
                StringBuilder sb4 = dummyStringBuilder;
                sb4.setLength(0);
                return toFullTitle(i, null, sb4, 1) >= 0;
            default:
                return false;
        }
    }

    public final boolean isCaseSensitive(int i) {
        int i2 = this.trie.get(i);
        if (propsHasException(i2)) {
            return (this.exceptions.charAt(getExceptionsOffset(i2)) & 2048) != 0;
        }
        return (i2 & 16) != 0;
    }

    public final boolean isSoftDotted(int i) {
        return getDotType(i) == 32;
    }

    public final int toFullFolding(int i, Appendable appendable, int i2) {
        int slotValue;
        int i3 = this.trie.get(i);
        if (propsHasException(i3)) {
            int exceptionsOffset = getExceptionsOffset(i3);
            int i4 = exceptionsOffset + 1;
            char cCharAt = this.exceptions.charAt(exceptionsOffset);
            int i5 = 1;
            if ((32768 & cCharAt) != 0) {
                if ((i2 & 7) == 0) {
                    if (i == 73) {
                        return 105;
                    }
                    if (i == 304) {
                        try {
                            appendable.append(iDot);
                            return 2;
                        } catch (IOException e) {
                            kf2.h(e);
                            return 0;
                        }
                    }
                } else {
                    if (i == 73) {
                        return UCharacter.UnicodeBlock.LISU_SUPPLEMENT_ID;
                    }
                    if (i == 304) {
                        return 105;
                    }
                }
            } else if (hasSlot(cCharAt, 7)) {
                long slotValueAndOffset = getSlotValueAndOffset(cCharAt, 7, i4);
                int i6 = (int) slotValueAndOffset;
                int i7 = ((int) (slotValueAndOffset >> 32)) + 1 + (i6 & 15);
                int i8 = ((65535 & i6) >> 4) & 15;
                if (i8 != 0) {
                    try {
                        appendable.append(this.exceptions, i7, i7 + i8);
                        return i8;
                    } catch (IOException e2) {
                        kf2.h(e2);
                        return 0;
                    }
                }
            }
            if ((cCharAt & 512) != 0) {
                return ~i;
            }
            if (hasSlot(cCharAt, 4) && isUpperOrTitleFromProps(i3)) {
                int slotValue2 = getSlotValue(cCharAt, 4, i4);
                return (cCharAt & 1024) == 0 ? i + slotValue2 : i - slotValue2;
            }
            if (!hasSlot(cCharAt, 1)) {
                i5 = 0;
                if (!hasSlot(cCharAt, 0)) {
                    return ~i;
                }
            }
            slotValue = getSlotValue(cCharAt, i5, i4);
        } else {
            slotValue = isUpperOrTitleFromProps(i3) ? getDelta(i3) + i : i;
        }
        return slotValue == i ? ~slotValue : slotValue;
    }

    /* JADX WARN: Code duplicated, block: B:96:0x0124  */
    public final int toFullLower(int i, ContextIterator contextIterator, Appendable appendable, int i2) {
        int i3;
        int slotValue;
        int i4 = this.trie.get(i);
        if (propsHasException(i4)) {
            int exceptionsOffset = getExceptionsOffset(i4);
            int i5 = exceptionsOffset + 1;
            char cCharAt = this.exceptions.charAt(exceptionsOffset);
            if ((cCharAt & 16384) != 0) {
                if (i2 == 3) {
                    i3 = 0;
                    if (((i == 73 || i == 74 || i == 302) && isFollowedByMoreAbove(contextIterator)) || i == 204 || i == 205 || i == 296) {
                        try {
                            if (i == 73) {
                                appendable.append(iDot);
                                return 2;
                            }
                            if (i == 74) {
                                appendable.append(jDot);
                                return 2;
                            }
                            if (i == 204) {
                                appendable.append(iDotGrave);
                                return 3;
                            }
                            if (i == 205) {
                                appendable.append(iDotAcute);
                                return 3;
                            }
                            if (i == 296) {
                                appendable.append(iDotTilde);
                                return 3;
                            }
                            if (i != 302) {
                                return 0;
                            }
                            appendable.append(iOgonekDot);
                            return 2;
                        } catch (IOException e) {
                            kf2.h(e);
                            return 0;
                        }
                    }
                } else {
                    i3 = 0;
                }
                if (i2 == 2 && i == 304) {
                    return 105;
                }
                if (i2 == 2 && i == 775 && isPrecededBy_I(contextIterator)) {
                    return i3;
                }
                if (i2 == 2 && i == 73 && !isFollowedByDotAbove(contextIterator)) {
                    return UCharacter.UnicodeBlock.LISU_SUPPLEMENT_ID;
                }
                if (i == 304) {
                    try {
                        appendable.append(iDot);
                        return 2;
                    } catch (IOException e2) {
                        kf2.h(e2);
                        return 0;
                    }
                }
                if (i == 931 && !isFollowedByCasedLetter(contextIterator, 1) && isFollowedByCasedLetter(contextIterator, -1)) {
                    return 962;
                }
            } else {
                i3 = 0;
                if (hasSlot(cCharAt, 7)) {
                    long slotValueAndOffset = getSlotValueAndOffset(cCharAt, 7, i5);
                    int i6 = ((int) slotValueAndOffset) & 15;
                    if (i6 != 0) {
                        int i7 = ((int) (slotValueAndOffset >> 32)) + 1;
                        try {
                            appendable.append(this.exceptions, i7, i7 + i6);
                            return i6;
                        } catch (IOException e3) {
                            kf2.h(e3);
                            return 0;
                        }
                    }
                }
            }
            if (hasSlot(cCharAt, 4) && isUpperOrTitleFromProps(i4)) {
                int slotValue2 = getSlotValue(cCharAt, 4, i5);
                return (cCharAt & 1024) == 0 ? slotValue2 + i : i - slotValue2;
            }
            int i8 = i3;
            if (hasSlot(cCharAt, i8)) {
                slotValue = getSlotValue(cCharAt, i8, i5);
            } else {
                slotValue = i;
            }
        } else if (isUpperOrTitleFromProps(i4)) {
            slotValue = getDelta(i4) + i;
        } else {
            slotValue = i;
        }
        return slotValue == i ? ~slotValue : slotValue;
    }

    public final int toFullTitle(int i, ContextIterator contextIterator, Appendable appendable, int i2) {
        return toUpperOrTitle(i, contextIterator, appendable, i2, false);
    }

    public final int toFullUpper(int i, ContextIterator contextIterator, Appendable appendable, int i2) {
        return toUpperOrTitle(i, contextIterator, appendable, i2, true);
    }

    public final int tolower(int i) {
        int i2 = this.trie.get(i);
        if (propsHasException(i2)) {
            int exceptionsOffset = getExceptionsOffset(i2);
            int i3 = exceptionsOffset + 1;
            char cCharAt = this.exceptions.charAt(exceptionsOffset);
            if (hasSlot(cCharAt, 4) && isUpperOrTitleFromProps(i2)) {
                int slotValue = getSlotValue(cCharAt, 4, i3);
                return (cCharAt & 1024) == 0 ? i + slotValue : i - slotValue;
            }
            if (hasSlot(cCharAt, 0)) {
                return getSlotValue(cCharAt, 0, i3);
            }
        } else if (isUpperOrTitleFromProps(i2)) {
            return getDelta(i2) + i;
        }
        return i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x004b, code lost:
    
        if (hasSlot(r1, 2) != false) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int totitle(int r7) {
        /*
            r6 = this;
            com.ibm.icu.impl.Trie2_16 r0 = r6.trie
            int r0 = r0.get(r7)
            boolean r1 = propsHasException(r0)
            r2 = 1
            if (r1 != 0) goto L19
            int r6 = getTypeFromProps(r0)
            if (r6 != r2) goto L52
            int r6 = getDelta(r0)
            int r6 = r6 + r7
            return r6
        L19:
            int r1 = getExceptionsOffset(r0)
            java.lang.String r3 = r6.exceptions
            int r4 = r1 + 1
            char r1 = r3.charAt(r1)
            r3 = 4
            boolean r5 = hasSlot(r1, r3)
            if (r5 == 0) goto L3e
            int r0 = getTypeFromProps(r0)
            if (r0 != r2) goto L3e
            int r6 = r6.getSlotValue(r1, r3, r4)
            r0 = r1 & 1024(0x400, float:1.435E-42)
            if (r0 != 0) goto L3c
            int r7 = r7 + r6
            return r7
        L3c:
            int r7 = r7 - r6
            return r7
        L3e:
            r0 = 3
            boolean r2 = hasSlot(r1, r0)
            if (r2 == 0) goto L46
            goto L4d
        L46:
            r0 = 2
            boolean r2 = hasSlot(r1, r0)
            if (r2 == 0) goto L52
        L4d:
            int r6 = r6.getSlotValue(r1, r0, r4)
            return r6
        L52:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ibm.icu.impl.UCaseProps.totitle(int):int");
    }

    public final int toupper(int i) {
        int i2 = this.trie.get(i);
        if (propsHasException(i2)) {
            int exceptionsOffset = getExceptionsOffset(i2);
            int i3 = exceptionsOffset + 1;
            char cCharAt = this.exceptions.charAt(exceptionsOffset);
            if (hasSlot(cCharAt, 4) && getTypeFromProps(i2) == 1) {
                int slotValue = getSlotValue(cCharAt, 4, i3);
                return (cCharAt & 1024) == 0 ? i + slotValue : i - slotValue;
            }
            if (hasSlot(cCharAt, 2)) {
                return getSlotValue(cCharAt, 2, i3);
            }
        } else if (getTypeFromProps(i2) == 1) {
            return getDelta(i2) + i;
        }
        return i;
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class IsAcceptable implements ICUBinary.Authenticate {
        public /* synthetic */ IsAcceptable(int i) {
            this();
        }

        @Override // com.ibm.icu.impl.ICUBinary.Authenticate
        public boolean isDataVersionAcceptable(byte[] bArr) {
            return bArr[0] == 4;
        }

        private IsAcceptable() {
        }
    }

    public static final int getCaseLocale(ULocale uLocale) {
        return getCaseLocale(uLocale.getLanguage());
    }

    public static final int getCaseLocale(Locale locale) {
        return getCaseLocale(locale.getLanguage());
    }
}
