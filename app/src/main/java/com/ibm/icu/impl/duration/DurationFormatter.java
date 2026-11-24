package com.ibm.icu.impl.duration;

import java.util.Date;
import java.util.TimeZone;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public interface DurationFormatter {
    String formatDurationFrom(long j, long j2);

    String formatDurationFromNow(long j);

    String formatDurationFromNowTo(Date date);

    DurationFormatter withLocale(String str);

    DurationFormatter withTimeZone(TimeZone timeZone);
}
