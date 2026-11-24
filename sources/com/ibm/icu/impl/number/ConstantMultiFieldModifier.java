package com.ibm.icu.impl.number;

import com.ibm.icu.impl.FormattedStringBuilder;
import java.text.Format;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class ConstantMultiFieldModifier implements Modifier {
    private final boolean overwrite;
    private final Modifier.Parameters parameters;
    protected final char[] prefixChars;
    protected final Object[] prefixFields;
    private final boolean strong;
    protected final char[] suffixChars;
    protected final Object[] suffixFields;

    public ConstantMultiFieldModifier(FormattedStringBuilder formattedStringBuilder, FormattedStringBuilder formattedStringBuilder2, boolean z, boolean z2, Modifier.Parameters parameters) {
        this.prefixChars = formattedStringBuilder.toCharArray();
        this.suffixChars = formattedStringBuilder2.toCharArray();
        this.prefixFields = formattedStringBuilder.toFieldArray();
        this.suffixFields = formattedStringBuilder2.toFieldArray();
        this.overwrite = z;
        this.strong = z2;
        this.parameters = parameters;
    }

    @Override // com.ibm.icu.impl.number.Modifier
    public int apply(FormattedStringBuilder formattedStringBuilder, int i, int i2) {
        FormattedStringBuilder formattedStringBuilder2;
        int iInsert = formattedStringBuilder.insert(i, this.prefixChars, this.prefixFields);
        if (this.overwrite) {
            formattedStringBuilder2 = formattedStringBuilder;
            iInsert += formattedStringBuilder2.splice(i + iInsert, i2 + iInsert, "", 0, 0, null);
        } else {
            formattedStringBuilder2 = formattedStringBuilder;
        }
        return formattedStringBuilder2.insert(i2 + iInsert, this.suffixChars, this.suffixFields) + iInsert;
    }

    @Override // com.ibm.icu.impl.number.Modifier
    public boolean containsField(Format.Field field) {
        int i = 0;
        while (true) {
            Object[] objArr = this.prefixFields;
            if (i >= objArr.length) {
                int i2 = 0;
                while (true) {
                    Object[] objArr2 = this.suffixFields;
                    if (i2 >= objArr2.length) {
                        return false;
                    }
                    if (objArr2[i2] == field) {
                        return true;
                    }
                    i2++;
                }
            } else {
                if (objArr[i] == field) {
                    return true;
                }
                i++;
            }
        }
    }

    @Override // com.ibm.icu.impl.number.Modifier
    public int getCodePointCount() {
        char[] cArr = this.prefixChars;
        int iCodePointCount = Character.codePointCount(cArr, 0, cArr.length);
        char[] cArr2 = this.suffixChars;
        return Character.codePointCount(cArr2, 0, cArr2.length) + iCodePointCount;
    }

    @Override // com.ibm.icu.impl.number.Modifier
    public Modifier.Parameters getParameters() {
        return this.parameters;
    }

    @Override // com.ibm.icu.impl.number.Modifier
    public int getPrefixLength() {
        return this.prefixChars.length;
    }

    @Override // com.ibm.icu.impl.number.Modifier
    public boolean isStrong() {
        return this.strong;
    }

    @Override // com.ibm.icu.impl.number.Modifier
    public boolean strictEquals(Modifier modifier) {
        if (!(modifier instanceof ConstantMultiFieldModifier)) {
            return false;
        }
        ConstantMultiFieldModifier constantMultiFieldModifier = (ConstantMultiFieldModifier) modifier;
        return Arrays.equals(this.prefixChars, constantMultiFieldModifier.prefixChars) && Arrays.equals(this.prefixFields, constantMultiFieldModifier.prefixFields) && Arrays.equals(this.suffixChars, constantMultiFieldModifier.suffixChars) && Arrays.equals(this.suffixFields, constantMultiFieldModifier.suffixFields) && this.overwrite == constantMultiFieldModifier.overwrite && this.strong == constantMultiFieldModifier.strong;
    }

    public String toString() {
        FormattedStringBuilder formattedStringBuilder = new FormattedStringBuilder();
        apply(formattedStringBuilder, 0, 0);
        int prefixLength = getPrefixLength();
        return String.format("<ConstantMultiFieldModifier prefix:'%s' suffix:'%s'>", formattedStringBuilder.subSequence(0, prefixLength), formattedStringBuilder.subSequence(prefixLength, formattedStringBuilder.length()));
    }

    public ConstantMultiFieldModifier(FormattedStringBuilder formattedStringBuilder, FormattedStringBuilder formattedStringBuilder2, boolean z, boolean z2) {
        this(formattedStringBuilder, formattedStringBuilder2, z, z2, null);
    }
}
