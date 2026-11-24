package com.ibm.icu.impl;

import com.ibm.icu.text.PluralRules;
import defpackage.og;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public enum StandardPlural {
    ZERO(PluralRules.KEYWORD_ZERO),
    ONE(PluralRules.KEYWORD_ONE),
    TWO(PluralRules.KEYWORD_TWO),
    FEW(PluralRules.KEYWORD_FEW),
    MANY(PluralRules.KEYWORD_MANY),
    OTHER(PluralRules.KEYWORD_OTHER),
    EQ_0("=0"),
    EQ_1("=1");

    public static final int COUNT;
    public static final int OTHER_INDEX = OTHER.ordinal();
    public static final List<StandardPlural> VALUES;
    private final String keyword;

    static {
        List<StandardPlural> listUnmodifiableList = Collections.unmodifiableList(Arrays.asList(values()));
        VALUES = listUnmodifiableList;
        COUNT = listUnmodifiableList.size();
    }

    StandardPlural(String str) {
        this.keyword = str;
    }

    public static final StandardPlural fromString(CharSequence charSequence) {
        StandardPlural standardPluralOrNullFromString = orNullFromString(charSequence);
        if (standardPluralOrNullFromString != null) {
            return standardPluralOrNullFromString;
        }
        og.i(charSequence.toString());
        return null;
    }

    public static final int indexFromString(CharSequence charSequence) {
        StandardPlural standardPluralOrNullFromString = orNullFromString(charSequence);
        if (standardPluralOrNullFromString != null) {
            return standardPluralOrNullFromString.ordinal();
        }
        og.i(charSequence.toString());
        return 0;
    }

    public static final int indexOrNegativeFromString(CharSequence charSequence) {
        StandardPlural standardPluralOrNullFromString = orNullFromString(charSequence);
        if (standardPluralOrNullFromString != null) {
            return standardPluralOrNullFromString.ordinal();
        }
        return -1;
    }

    public static final int indexOrOtherIndexFromString(CharSequence charSequence) {
        StandardPlural standardPluralOrNullFromString = orNullFromString(charSequence);
        return standardPluralOrNullFromString != null ? standardPluralOrNullFromString.ordinal() : OTHER.ordinal();
    }

    public static final StandardPlural orNullFromString(CharSequence charSequence) {
        int length = charSequence.length();
        if (length == 1) {
            if (charSequence.charAt(0) == '0') {
                return EQ_0;
            }
            if (charSequence.charAt(0) == '1') {
                return EQ_1;
            }
            return null;
        }
        if (length == 2) {
            if ("=0".contentEquals(charSequence)) {
                return EQ_0;
            }
            if ("=1".contentEquals(charSequence)) {
                return EQ_1;
            }
            return null;
        }
        if (length == 3) {
            if (PluralRules.KEYWORD_ONE.contentEquals(charSequence)) {
                return ONE;
            }
            if (PluralRules.KEYWORD_TWO.contentEquals(charSequence)) {
                return TWO;
            }
            if (PluralRules.KEYWORD_FEW.contentEquals(charSequence)) {
                return FEW;
            }
            return null;
        }
        if (length != 4) {
            if (length == 5 && PluralRules.KEYWORD_OTHER.contentEquals(charSequence)) {
                return OTHER;
            }
            return null;
        }
        if (PluralRules.KEYWORD_MANY.contentEquals(charSequence)) {
            return MANY;
        }
        if (PluralRules.KEYWORD_ZERO.contentEquals(charSequence)) {
            return ZERO;
        }
        return null;
    }

    public static final StandardPlural orOtherFromString(CharSequence charSequence) {
        StandardPlural standardPluralOrNullFromString = orNullFromString(charSequence);
        return standardPluralOrNullFromString != null ? standardPluralOrNullFromString : OTHER;
    }

    public final String getKeyword() {
        return this.keyword;
    }
}
