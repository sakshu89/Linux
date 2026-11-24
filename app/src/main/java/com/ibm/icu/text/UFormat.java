package com.ibm.icu.text;

import com.ibm.icu.util.ULocale;
import defpackage.dk0;
import java.text.Format;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class UFormat extends Format {
    private static final long serialVersionUID = -4964390515840164416L;
    private ULocale actualLocale;
    private ULocale validLocale;

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static abstract class SpanField extends Format.Field {
        private static final long serialVersionUID = -4732719509273350606L;

        public SpanField(String str) {
            super(str);
        }
    }

    public final ULocale getLocale(ULocale.Type type) {
        return type == ULocale.ACTUAL_LOCALE ? this.actualLocale : this.validLocale;
    }

    public final void setLocale(ULocale uLocale, ULocale uLocale2) {
        if ((uLocale == null) != (uLocale2 == null)) {
            dk0.v();
        } else {
            this.validLocale = uLocale;
            this.actualLocale = uLocale2;
        }
    }
}
