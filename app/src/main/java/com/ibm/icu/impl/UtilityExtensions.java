package com.ibm.icu.impl;

import com.ibm.icu.text.Replaceable;
import com.ibm.icu.text.ReplaceableString;
import com.ibm.icu.text.Transliterator;
import com.ibm.icu.text.UnicodeMatcher;
import defpackage.cq;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class UtilityExtensions {
    public static void appendToRule(StringBuilder sb, String str, boolean z, boolean z2, StringBuilder sb2) {
        for (int i = 0; i < str.length(); i++) {
            Utility.appendToRule(sb, str.charAt(i), z, z2, sb2);
        }
    }

    public static StringBuilder formatInput(StringBuilder sb, ReplaceableString replaceableString, Transliterator.Position position) {
        int i;
        int i2;
        int i3;
        int i4 = position.contextStart;
        if (i4 >= 0 && i4 <= (i = position.start) && i <= (i2 = position.limit) && i2 <= (i3 = position.contextLimit) && i3 <= replaceableString.length()) {
            String strSubstring = replaceableString.substring(position.contextStart, position.start);
            String strSubstring2 = replaceableString.substring(position.start, position.limit);
            String strSubstring3 = replaceableString.substring(position.limit, position.contextLimit);
            sb.append('{');
            sb.append(strSubstring);
            sb.append('|');
            sb.append(strSubstring2);
            sb.append('|');
            sb.append(strSubstring3);
            sb.append('}');
            return sb;
        }
        int i5 = position.contextStart;
        int i6 = position.start;
        int i7 = position.limit;
        int i8 = position.contextLimit;
        String strValueOf = String.valueOf(replaceableString);
        StringBuilder sbP = cq.p("INVALID Position {cs=", i5, ", s=", i6, ", l=");
        sbP.append(i7);
        sbP.append(", cl=");
        sbP.append(i8);
        sbP.append("} on ");
        sbP.append(strValueOf);
        sb.append(sbP.toString());
        return sb;
    }

    public static void appendToRule(StringBuilder sb, UnicodeMatcher unicodeMatcher, boolean z, StringBuilder sb2) {
        if (unicodeMatcher != null) {
            appendToRule(sb, unicodeMatcher.toPattern(z), true, z, sb2);
        }
    }

    public static String formatInput(ReplaceableString replaceableString, Transliterator.Position position) {
        StringBuilder sb = new StringBuilder();
        formatInput(sb, replaceableString, position);
        return Utility.escape(sb.toString());
    }

    public static String formatInput(Replaceable replaceable, Transliterator.Position position) {
        return formatInput((ReplaceableString) replaceable, position);
    }

    public static StringBuilder formatInput(StringBuilder sb, Replaceable replaceable, Transliterator.Position position) {
        return formatInput(sb, (ReplaceableString) replaceable, position);
    }
}
