package com.ibm.icu.text;

import com.ibm.icu.impl.personname.PersonNameFormatterImpl;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class PersonNameFormatter {
    private final PersonNameFormatterImpl impl;

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public enum DisplayOrder {
        DEFAULT,
        SORTING,
        FORCE_GIVEN_FIRST,
        FORCE_SURNAME_FIRST
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public enum Formality {
        FORMAL,
        INFORMAL,
        DEFAULT
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public enum Length {
        LONG,
        MEDIUM,
        SHORT,
        DEFAULT
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public enum Usage {
        ADDRESSING,
        REFERRING,
        MONOGRAM
    }

    private PersonNameFormatter(Locale locale, Length length, Usage usage, Formality formality, DisplayOrder displayOrder, boolean z) {
        this.impl = new PersonNameFormatterImpl(locale, length, usage, formality, displayOrder, z);
    }

    public static Builder builder() {
        return new Builder(0);
    }

    public String formatToString(PersonName personName) {
        return this.impl.formatToString(personName);
    }

    public Builder toBuilder() {
        Builder builder = builder();
        builder.setLocale(this.impl.getLocale());
        builder.setLength(this.impl.getLength());
        builder.setUsage(this.impl.getUsage());
        builder.setFormality(this.impl.getFormality());
        builder.setDisplayOrder(this.impl.getDisplayOrder());
        builder.setSurnameAllCaps(this.impl.getSurnameAllCaps());
        return builder;
    }

    public String toString() {
        return this.impl.toString();
    }

    public /* synthetic */ PersonNameFormatter(Locale locale, Length length, Usage usage, Formality formality, DisplayOrder displayOrder, boolean z, int i) {
        this(locale, length, usage, formality, displayOrder, z);
    }

    @Deprecated
    public PersonNameFormatter(Locale locale, String[] strArr, String[] strArr2, String[] strArr3, String[] strArr4) {
        this.impl = new PersonNameFormatterImpl(locale, strArr, strArr2, strArr3, strArr4);
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class Builder {
        private DisplayOrder displayOrder;
        private Formality formality;
        private Length length;
        private Locale locale;
        private boolean surnameAllCaps;
        private Usage usage;

        private Builder() {
            this.locale = Locale.getDefault();
            this.length = Length.DEFAULT;
            this.usage = Usage.REFERRING;
            this.formality = Formality.DEFAULT;
            this.displayOrder = DisplayOrder.DEFAULT;
            this.surnameAllCaps = false;
        }

        public PersonNameFormatter build() {
            return new PersonNameFormatter(this.locale, this.length, this.usage, this.formality, this.displayOrder, this.surnameAllCaps, 0);
        }

        public Builder setDisplayOrder(DisplayOrder displayOrder) {
            this.displayOrder = displayOrder;
            return this;
        }

        public Builder setFormality(Formality formality) {
            this.formality = formality;
            return this;
        }

        public Builder setLength(Length length) {
            this.length = length;
            return this;
        }

        public Builder setLocale(Locale locale) {
            if (locale != null) {
                this.locale = locale;
            }
            return this;
        }

        public Builder setSurnameAllCaps(boolean z) {
            this.surnameAllCaps = z;
            return this;
        }

        public Builder setUsage(Usage usage) {
            this.usage = usage;
            return this;
        }

        public /* synthetic */ Builder(int i) {
            this();
        }
    }
}
