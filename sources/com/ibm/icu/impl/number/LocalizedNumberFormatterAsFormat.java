package com.ibm.icu.impl.number;

import com.ibm.icu.impl.FormattedStringBuilder;
import com.ibm.icu.impl.FormattedValueStringBuilderImpl;
import com.ibm.icu.impl.Utility;
import com.ibm.icu.number.LocalizedNumberFormatter;
import com.ibm.icu.number.NumberFormatter;
import com.ibm.icu.util.ULocale;
import defpackage.dk0;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.text.AttributedCharacterIterator;
import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class LocalizedNumberFormatterAsFormat extends Format {
    private static final long serialVersionUID = 1;
    private final transient LocalizedNumberFormatter formatter;
    private final transient ULocale locale;

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class Proxy implements Externalizable {
        private static final long serialVersionUID = 1;
        String languageTag;
        String skeleton;

        private Object readResolve() {
            return NumberFormatter.forSkeleton(this.skeleton).locale(ULocale.forLanguageTag(this.languageTag)).toFormat();
        }

        @Override // java.io.Externalizable
        public void readExternal(ObjectInput objectInput) throws IOException {
            objectInput.readByte();
            this.languageTag = objectInput.readUTF();
            this.skeleton = objectInput.readUTF();
        }

        @Override // java.io.Externalizable
        public void writeExternal(ObjectOutput objectOutput) throws IOException {
            objectOutput.writeByte(0);
            objectOutput.writeUTF(this.languageTag);
            objectOutput.writeUTF(this.skeleton);
        }
    }

    public LocalizedNumberFormatterAsFormat(LocalizedNumberFormatter localizedNumberFormatter, ULocale uLocale) {
        this.formatter = localizedNumberFormatter;
        this.locale = uLocale;
    }

    private Object writeReplace() {
        Proxy proxy = new Proxy();
        proxy.languageTag = this.locale.toLanguageTag();
        proxy.skeleton = this.formatter.toSkeleton();
        return proxy;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof LocalizedNumberFormatterAsFormat)) {
            return this.formatter.equals(((LocalizedNumberFormatterAsFormat) obj).getNumberFormatter());
        }
        return false;
    }

    @Override // java.text.Format
    public StringBuffer format(Object obj, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        if (!(obj instanceof Number)) {
            dk0.v();
            return null;
        }
        DecimalQuantity_DualStorageBCD decimalQuantity_DualStorageBCD = new DecimalQuantity_DualStorageBCD((Number) obj);
        FormattedStringBuilder formattedStringBuilder = new FormattedStringBuilder();
        this.formatter.formatImpl(decimalQuantity_DualStorageBCD, formattedStringBuilder);
        fieldPosition.setBeginIndex(0);
        fieldPosition.setEndIndex(0);
        if (FormattedValueStringBuilderImpl.nextFieldPosition(formattedStringBuilder, fieldPosition) && stringBuffer.length() != 0) {
            fieldPosition.setBeginIndex(stringBuffer.length() + fieldPosition.getBeginIndex());
            fieldPosition.setEndIndex(stringBuffer.length() + fieldPosition.getEndIndex());
        }
        Utility.appendTo(formattedStringBuilder, stringBuffer);
        return stringBuffer;
    }

    @Override // java.text.Format
    public AttributedCharacterIterator formatToCharacterIterator(Object obj) {
        if (obj instanceof Number) {
            return this.formatter.format((Number) obj).toCharacterIterator();
        }
        dk0.v();
        return null;
    }

    public LocalizedNumberFormatter getNumberFormatter() {
        return this.formatter;
    }

    public int hashCode() {
        return this.formatter.hashCode();
    }

    @Override // java.text.Format
    public Object parseObject(String str, ParsePosition parsePosition) {
        throw new UnsupportedOperationException();
    }
}
