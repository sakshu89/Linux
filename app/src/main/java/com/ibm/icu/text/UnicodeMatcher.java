package com.ibm.icu.text;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public interface UnicodeMatcher {
    public static final char ETHER = 65535;
    public static final int U_MATCH = 2;
    public static final int U_MISMATCH = 0;
    public static final int U_PARTIAL_MATCH = 1;

    void addMatchSetTo(UnicodeSet unicodeSet);

    int matches(Replaceable replaceable, int[] iArr, int i, boolean z);

    boolean matchesIndexValue(int i);

    String toPattern(boolean z);
}
