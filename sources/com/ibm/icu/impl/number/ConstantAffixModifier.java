package com.ibm.icu.impl.number;

import com.ibm.icu.impl.FormattedStringBuilder;
import defpackage.ky0;
import java.text.Format;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class ConstantAffixModifier implements Modifier {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final ConstantAffixModifier EMPTY = new ConstantAffixModifier();
    private final Format.Field field;
    private final String prefix;
    private final boolean strong;
    private final String suffix;

    public ConstantAffixModifier(String str, String str2, Format.Field field, boolean z) {
        this.prefix = str == null ? "" : str;
        this.suffix = str2 == null ? "" : str2;
        this.field = field;
        this.strong = z;
    }

    @Override // com.ibm.icu.impl.number.Modifier
    public int apply(FormattedStringBuilder formattedStringBuilder, int i, int i2) {
        return formattedStringBuilder.insert(i, this.prefix, this.field) + formattedStringBuilder.insert(i2, this.suffix, this.field);
    }

    @Override // com.ibm.icu.impl.number.Modifier
    public boolean containsField(Format.Field field) {
        return false;
    }

    @Override // com.ibm.icu.impl.number.Modifier
    public int getCodePointCount() {
        String str = this.prefix;
        int iCodePointCount = str.codePointCount(0, str.length());
        String str2 = this.suffix;
        return str2.codePointCount(0, str2.length()) + iCodePointCount;
    }

    @Override // com.ibm.icu.impl.number.Modifier
    public Modifier.Parameters getParameters() {
        return null;
    }

    @Override // com.ibm.icu.impl.number.Modifier
    public int getPrefixLength() {
        return this.prefix.length();
    }

    @Override // com.ibm.icu.impl.number.Modifier
    public boolean isStrong() {
        return this.strong;
    }

    @Override // com.ibm.icu.impl.number.Modifier
    public boolean strictEquals(Modifier modifier) {
        if (!(modifier instanceof ConstantAffixModifier)) {
            return false;
        }
        ConstantAffixModifier constantAffixModifier = (ConstantAffixModifier) modifier;
        return this.prefix.equals(constantAffixModifier.prefix) && this.suffix.equals(constantAffixModifier.suffix) && this.field == constantAffixModifier.field && this.strong == constantAffixModifier.strong;
    }

    public String toString() {
        return ky0.l("<ConstantAffixModifier prefix:'", this.prefix, "' suffix:'", this.suffix, "'>");
    }

    public ConstantAffixModifier() {
        this.prefix = "";
        this.suffix = "";
        this.field = null;
        this.strong = false;
    }
}
