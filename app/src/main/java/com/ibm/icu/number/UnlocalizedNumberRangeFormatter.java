package com.ibm.icu.number;

import com.ibm.icu.util.ULocale;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class UnlocalizedNumberRangeFormatter extends NumberRangeFormatterSettings<UnlocalizedNumberRangeFormatter> {
    public UnlocalizedNumberRangeFormatter() {
        super(null, 0, null);
    }

    @Override // com.ibm.icu.number.NumberRangeFormatterSettings
    public UnlocalizedNumberRangeFormatter create(int i, Object obj) {
        return new UnlocalizedNumberRangeFormatter(this, i, obj);
    }

    public LocalizedNumberRangeFormatter locale(Locale locale) {
        return new LocalizedNumberRangeFormatter(this, 1, ULocale.forLocale(locale));
    }

    public UnlocalizedNumberRangeFormatter(NumberRangeFormatterSettings<?> numberRangeFormatterSettings, int i, Object obj) {
        super(numberRangeFormatterSettings, i, obj);
    }

    public LocalizedNumberRangeFormatter locale(ULocale uLocale) {
        return new LocalizedNumberRangeFormatter(this, 1, uLocale);
    }
}
