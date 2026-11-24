package com.ibm.icu.message2;

import com.ibm.icu.util.ULocale;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public enum Directionality {
    UNKNOWN,
    LTR,
    RTL,
    AUTO,
    INHERIT;

    public static Directionality of(Locale locale) {
        if (locale == null) {
            return INHERIT;
        }
        return ULocale.forLocale(locale).isRightToLeft() ? RTL : LTR;
    }
}
