package com.ibm.icu.impl.number;

import com.ibm.icu.impl.FormattedStringBuilder;
import com.ibm.icu.impl.SimpleFormatterImpl;
import com.ibm.icu.impl.number.range.PrefixInfixSuffixLengthHelper;
import com.ibm.icu.util.ICUException;
import java.text.Format;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class SimpleModifier implements Modifier {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int ARG_NUM_LIMIT = 256;
    private final String compiledPattern;
    private final Format.Field field;
    private final Modifier.Parameters parameters;
    private final boolean strong;

    public SimpleModifier(String str, Format.Field field, boolean z, Modifier.Parameters parameters) {
        this.compiledPattern = str;
        this.field = field;
        this.strong = z;
        this.parameters = parameters;
    }

    public static void formatTwoArgPattern(String str, FormattedStringBuilder formattedStringBuilder, int i, PrefixInfixSuffixLengthHelper prefixInfixSuffixLengthHelper, Format.Field field) {
        int i2;
        int i3;
        int i4;
        if (SimpleFormatterImpl.getArgumentLimit(str) != 2) {
            throw new ICUException();
        }
        char cCharAt = str.charAt(1);
        int iCharAt = 0;
        int i5 = 2;
        if (cCharAt < 256) {
            i3 = 0;
            i2 = 0;
        } else {
            i2 = cCharAt - 256;
            formattedStringBuilder.insert(i, str, 2, cCharAt - 254, field);
            i5 = cCharAt - 253;
            i3 = i2;
        }
        char cCharAt2 = str.charAt(i5);
        int i6 = i5 + 1;
        if (cCharAt2 < 256) {
            i4 = 0;
        } else {
            i4 = cCharAt2 - 256;
            int i7 = i6 + i4;
            formattedStringBuilder.insert(i + i2, str, i6, i7, field);
            i2 += i4;
            i6 = i7 + 1;
        }
        if (i6 != str.length()) {
            iCharAt = str.charAt(i6) - 256;
            int i8 = i6 + 1;
            formattedStringBuilder.insert(i + i2, str, i8, i8 + iCharAt, field);
        }
        prefixInfixSuffixLengthHelper.lengthPrefix = i3;
        prefixInfixSuffixLengthHelper.lengthInfix = i4;
        prefixInfixSuffixLengthHelper.lengthSuffix = iCharAt;
    }

    @Override // com.ibm.icu.impl.number.Modifier
    public int apply(FormattedStringBuilder formattedStringBuilder, int i, int i2) {
        return SimpleFormatterImpl.formatPrefixSuffix(this.compiledPattern, this.field, i, i2, formattedStringBuilder);
    }

    @Override // com.ibm.icu.impl.number.Modifier
    public boolean containsField(Format.Field field) {
        return false;
    }

    @Override // com.ibm.icu.impl.number.Modifier
    public int getCodePointCount() {
        return SimpleFormatterImpl.getLength(this.compiledPattern, true);
    }

    @Override // com.ibm.icu.impl.number.Modifier
    public Modifier.Parameters getParameters() {
        return this.parameters;
    }

    @Override // com.ibm.icu.impl.number.Modifier
    public int getPrefixLength() {
        return SimpleFormatterImpl.getPrefixLength(this.compiledPattern);
    }

    @Override // com.ibm.icu.impl.number.Modifier
    public boolean isStrong() {
        return this.strong;
    }

    @Override // com.ibm.icu.impl.number.Modifier
    public boolean strictEquals(Modifier modifier) {
        if (!(modifier instanceof SimpleModifier)) {
            return false;
        }
        SimpleModifier simpleModifier = (SimpleModifier) modifier;
        return this.compiledPattern.equals(simpleModifier.compiledPattern) && this.field == simpleModifier.field && this.strong == simpleModifier.strong;
    }

    public SimpleModifier(String str, Format.Field field, boolean z) {
        this(str, field, z, null);
    }
}
