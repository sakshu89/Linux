package com.ibm.icu.number;

import com.ibm.icu.impl.number.DecimalFormatProperties;
import com.ibm.icu.text.DecimalFormatSymbols;
import com.ibm.icu.util.ULocale;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class NumberFormatter {
    private static final UnlocalizedNumberFormatter BASE = new UnlocalizedNumberFormatter();
    static final long DEFAULT_THRESHOLD = 3;

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public enum DecimalSeparatorDisplay {
        AUTO,
        ALWAYS
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public enum GroupingStrategy {
        OFF,
        MIN2,
        AUTO,
        ON_ALIGNED,
        THOUSANDS
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public enum RoundingPriority {
        RELAXED,
        STRICT
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public enum SignDisplay {
        AUTO,
        ALWAYS,
        NEVER,
        ACCOUNTING,
        ACCOUNTING_ALWAYS,
        EXCEPT_ZERO,
        ACCOUNTING_EXCEPT_ZERO,
        NEGATIVE,
        ACCOUNTING_NEGATIVE
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public enum TrailingZeroDisplay {
        AUTO,
        HIDE_IF_WHOLE
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public enum UnitWidth {
        NARROW,
        SHORT,
        FULL_NAME,
        ISO_CODE,
        FORMAL,
        VARIANT,
        HIDDEN
    }

    private NumberFormatter() {
    }

    public static UnlocalizedNumberFormatter forSkeleton(String str) {
        return NumberSkeletonImpl.getOrCreate(str);
    }

    @Deprecated
    public static UnlocalizedNumberFormatter fromDecimalFormat(DecimalFormatProperties decimalFormatProperties, DecimalFormatSymbols decimalFormatSymbols, DecimalFormatProperties decimalFormatProperties2) {
        return NumberPropertyMapper.create(decimalFormatProperties, decimalFormatSymbols, decimalFormatProperties2);
    }

    public static UnlocalizedNumberFormatter with() {
        return BASE;
    }

    public static LocalizedNumberFormatter withLocale(Locale locale) {
        return BASE.locale(locale);
    }

    public static LocalizedNumberFormatter withLocale(ULocale uLocale) {
        return BASE.locale(uLocale);
    }
}
