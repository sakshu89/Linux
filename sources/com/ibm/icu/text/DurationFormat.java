package com.ibm.icu.text;

import com.ibm.icu.impl.duration.BasicDurationFormat;
import com.ibm.icu.util.ULocale;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.util.Date;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public abstract class DurationFormat extends UFormat {
    private static final long serialVersionUID = -2076961954727774282L;

    @Deprecated
    public DurationFormat(ULocale uLocale) {
        setLocale(uLocale, uLocale);
    }

    @Deprecated
    public static DurationFormat getInstance(ULocale uLocale) {
        return BasicDurationFormat.getInstance(uLocale);
    }

    @Override // java.text.Format
    @Deprecated
    public abstract StringBuffer format(Object obj, StringBuffer stringBuffer, FieldPosition fieldPosition);

    @Deprecated
    public abstract String formatDurationFrom(long j, long j2);

    @Deprecated
    public abstract String formatDurationFromNow(long j);

    @Deprecated
    public abstract String formatDurationFromNowTo(Date date);

    @Override // java.text.Format
    @Deprecated
    public Object parseObject(String str, ParsePosition parsePosition) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public DurationFormat() {
    }
}
