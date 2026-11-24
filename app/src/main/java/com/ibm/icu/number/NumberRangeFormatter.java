package com.ibm.icu.number;

import com.ibm.icu.text.UFormat;
import com.ibm.icu.util.ULocale;
import defpackage.kf2;
import java.io.InvalidObjectException;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class NumberRangeFormatter {
    private static final UnlocalizedNumberRangeFormatter BASE = new UnlocalizedNumberRangeFormatter();

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public enum RangeCollapse {
        AUTO,
        NONE,
        UNIT,
        ALL
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public enum RangeIdentityFallback {
        SINGLE_VALUE,
        APPROXIMATELY_OR_SINGLE_VALUE,
        APPROXIMATELY,
        RANGE
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public enum RangeIdentityResult {
        EQUAL_BEFORE_ROUNDING,
        EQUAL_AFTER_ROUNDING,
        NOT_EQUAL
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class SpanField extends UFormat.SpanField {
        public static final SpanField NUMBER_RANGE_SPAN = new SpanField("number-range-span");
        private static final long serialVersionUID = 8750397196515368729L;

        private SpanField(String str) {
            super(str);
        }

        @Override // java.text.AttributedCharacterIterator.Attribute
        @Deprecated
        public Object readResolve() throws InvalidObjectException {
            String name = getName();
            SpanField spanField = NUMBER_RANGE_SPAN;
            if (name.equals(spanField.getName())) {
                return spanField;
            }
            kf2.i("An invalid object.");
            return null;
        }
    }

    private NumberRangeFormatter() {
    }

    public static UnlocalizedNumberRangeFormatter with() {
        return BASE;
    }

    public static LocalizedNumberRangeFormatter withLocale(Locale locale) {
        return BASE.locale(locale);
    }

    public static LocalizedNumberRangeFormatter withLocale(ULocale uLocale) {
        return BASE.locale(uLocale);
    }
}
