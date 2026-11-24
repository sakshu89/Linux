package com.ibm.icu.text;

import java.text.ParsePosition;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public interface SymbolTable {
    public static final char SYMBOL_REF = '$';

    char[] lookup(String str);

    UnicodeMatcher lookupMatcher(int i);

    @Deprecated
    default UnicodeSet lookupSet(String str) {
        return null;
    }

    String parseReference(String str, ParsePosition parsePosition, int i);
}
