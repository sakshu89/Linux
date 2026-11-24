package com.ibm.icu.number;

import com.ibm.icu.util.ULocale;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class UnlocalizedNumberFormatter extends NumberFormatterSettings<UnlocalizedNumberFormatter> {
    public UnlocalizedNumberFormatter() {
        super(null, 14, 3L);
    }

    @Override // com.ibm.icu.number.NumberFormatterSettings
    public UnlocalizedNumberFormatter create(int i, Object obj) {
        return new UnlocalizedNumberFormatter(this, i, obj);
    }

    public LocalizedNumberFormatter locale(Locale locale) {
        return new LocalizedNumberFormatter(this, 1, ULocale.forLocale(locale));
    }

    public LocalizedNumberFormatter locale(ULocale uLocale) {
        return new LocalizedNumberFormatter(this, 1, uLocale);
    }

    public UnlocalizedNumberFormatter(NumberFormatterSettings<?> numberFormatterSettings, int i, Object obj) {
        super(numberFormatterSettings, i, obj);
    }
}
