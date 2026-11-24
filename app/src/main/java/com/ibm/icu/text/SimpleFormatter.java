package com.ibm.icu.text;

import com.ibm.icu.impl.SimpleFormatterImpl;
import defpackage.cq;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class SimpleFormatter {
    private final String compiledPattern;

    private SimpleFormatter(String str) {
        this.compiledPattern = str;
    }

    public static SimpleFormatter compile(CharSequence charSequence) {
        return compileMinMaxArguments(charSequence, 0, Integer.MAX_VALUE);
    }

    public static SimpleFormatter compileMinMaxArguments(CharSequence charSequence, int i, int i2) {
        return new SimpleFormatter(SimpleFormatterImpl.compileToStringMinMaxArguments(charSequence, new StringBuilder(), i, i2));
    }

    public String format(CharSequence... charSequenceArr) {
        return SimpleFormatterImpl.formatCompiledPattern(this.compiledPattern, charSequenceArr);
    }

    public StringBuilder formatAndAppend(StringBuilder sb, int[] iArr, CharSequence... charSequenceArr) {
        return SimpleFormatterImpl.formatAndAppend(this.compiledPattern, sb, iArr, charSequenceArr);
    }

    public StringBuilder formatAndReplace(StringBuilder sb, int[] iArr, CharSequence... charSequenceArr) {
        return SimpleFormatterImpl.formatAndReplace(this.compiledPattern, sb, iArr, charSequenceArr);
    }

    public int getArgumentLimit() {
        return SimpleFormatterImpl.getArgumentLimit(this.compiledPattern);
    }

    public String getTextWithNoArguments() {
        return SimpleFormatterImpl.getTextWithNoArguments(this.compiledPattern);
    }

    public String toString() {
        int argumentLimit = getArgumentLimit();
        String[] strArr = new String[argumentLimit];
        for (int i = 0; i < argumentLimit; i++) {
            strArr[i] = cq.h("{", i, "}");
        }
        return formatAndAppend(new StringBuilder(), null, strArr).toString();
    }
}
