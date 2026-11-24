package com.ibm.icu.number;

import com.ibm.icu.text.CompactDecimalFormat;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class Notation {
    private static final CompactNotation COMPACT_LONG;
    private static final CompactNotation COMPACT_SHORT;
    private static final ScientificNotation ENGINEERING;
    private static final ScientificNotation SCIENTIFIC;
    private static final SimpleNotation SIMPLE;

    static {
        NumberFormatter.SignDisplay signDisplay = NumberFormatter.SignDisplay.AUTO;
        SCIENTIFIC = new ScientificNotation(1, false, 1, signDisplay);
        ENGINEERING = new ScientificNotation(3, false, 1, signDisplay);
        COMPACT_SHORT = new CompactNotation(CompactDecimalFormat.CompactStyle.SHORT);
        COMPACT_LONG = new CompactNotation(CompactDecimalFormat.CompactStyle.LONG);
        SIMPLE = new SimpleNotation();
    }

    public static CompactNotation compactLong() {
        return COMPACT_LONG;
    }

    public static CompactNotation compactShort() {
        return COMPACT_SHORT;
    }

    public static ScientificNotation engineering() {
        return ENGINEERING;
    }

    public static ScientificNotation scientific() {
        return SCIENTIFIC;
    }

    public static SimpleNotation simple() {
        return SIMPLE;
    }
}
