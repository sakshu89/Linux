package com.ibm.icu.impl.number;

import com.ibm.icu.impl.FormattedStringBuilder;
import defpackage.ky0;
import defpackage.og;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class Padder {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final String FALLBACK_PADDING_STRING = " ";
    public static final Padder NONE = new Padder(null, -1, null);
    String paddingString;
    PadPosition position;
    int targetWidth;

    /* JADX INFO: renamed from: com.ibm.icu.impl.number.Padder$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ibm$icu$impl$number$Padder$PadPosition;

        static {
            int[] iArr = new int[PadPosition.values().length];
            $SwitchMap$com$ibm$icu$impl$number$Padder$PadPosition = iArr;
            try {
                iArr[PadPosition.BEFORE_PREFIX.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ibm$icu$impl$number$Padder$PadPosition[PadPosition.AFTER_PREFIX.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$ibm$icu$impl$number$Padder$PadPosition[PadPosition.BEFORE_SUFFIX.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$ibm$icu$impl$number$Padder$PadPosition[PadPosition.AFTER_SUFFIX.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public enum PadPosition {
        BEFORE_PREFIX,
        AFTER_PREFIX,
        BEFORE_SUFFIX,
        AFTER_SUFFIX;

        public static PadPosition fromOld(int i) {
            if (i == 0) {
                return BEFORE_PREFIX;
            }
            if (i == 1) {
                return AFTER_PREFIX;
            }
            if (i == 2) {
                return BEFORE_SUFFIX;
            }
            if (i == 3) {
                return AFTER_SUFFIX;
            }
            og.i(ky0.h(i, "Don't know how to map "));
            return null;
        }

        public int toOld() {
            int i = AnonymousClass1.$SwitchMap$com$ibm$icu$impl$number$Padder$PadPosition[ordinal()];
            if (i == 1) {
                return 0;
            }
            if (i == 2) {
                return 1;
            }
            if (i != 3) {
                return i != 4 ? -1 : 3;
            }
            return 2;
        }
    }

    public Padder(String str, int i, PadPosition padPosition) {
        this.paddingString = str == null ? FALLBACK_PADDING_STRING : str;
        this.targetWidth = i;
        this.position = padPosition == null ? PadPosition.BEFORE_PREFIX : padPosition;
    }

    private static int addPaddingHelper(String str, int i, FormattedStringBuilder formattedStringBuilder, int i2) {
        for (int i3 = 0; i3 < i; i3++) {
            formattedStringBuilder.insert(i2, str, (Object) null);
        }
        return str.length() * i;
    }

    public static Padder codePoints(int i, int i2, PadPosition padPosition) {
        if (i2 >= 0) {
            return new Padder(String.valueOf(Character.toChars(i)), i2, padPosition);
        }
        og.i("Padding width must not be negative");
        return null;
    }

    public static Padder forProperties(DecimalFormatProperties decimalFormatProperties) {
        return new Padder(decimalFormatProperties.getPadString(), decimalFormatProperties.getFormatWidth(), decimalFormatProperties.getPadPosition());
    }

    public static Padder none() {
        return NONE;
    }

    public boolean isValid() {
        return this.targetWidth > 0;
    }

    public int padAndApply(Modifier modifier, Modifier modifier2, FormattedStringBuilder formattedStringBuilder, int i, int i2) {
        int iAddPaddingHelper;
        int iAddPaddingHelper2;
        int codePointCount = (this.targetWidth - (modifier2.getCodePointCount() + modifier.getCodePointCount())) - formattedStringBuilder.codePointCount();
        if (codePointCount <= 0) {
            int iApply = modifier.apply(formattedStringBuilder, i, i2);
            return modifier2.apply(formattedStringBuilder, i, i2 + iApply) + iApply;
        }
        PadPosition padPosition = this.position;
        if (padPosition == PadPosition.AFTER_PREFIX) {
            iAddPaddingHelper = addPaddingHelper(this.paddingString, codePointCount, formattedStringBuilder, i);
        } else {
            iAddPaddingHelper = padPosition == PadPosition.BEFORE_SUFFIX ? addPaddingHelper(this.paddingString, codePointCount, formattedStringBuilder, i2) : 0;
        }
        int iApply2 = modifier.apply(formattedStringBuilder, i, i2 + iAddPaddingHelper) + iAddPaddingHelper;
        int iApply3 = modifier2.apply(formattedStringBuilder, i, i2 + iApply2) + iApply2;
        PadPosition padPosition2 = this.position;
        if (padPosition2 == PadPosition.BEFORE_PREFIX) {
            iAddPaddingHelper2 = addPaddingHelper(this.paddingString, codePointCount, formattedStringBuilder, i);
        } else {
            if (padPosition2 != PadPosition.AFTER_SUFFIX) {
                return iApply3;
            }
            iAddPaddingHelper2 = addPaddingHelper(this.paddingString, codePointCount, formattedStringBuilder, i2 + iApply3);
        }
        return iApply3 + iAddPaddingHelper2;
    }
}
