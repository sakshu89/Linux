package com.ibm.icu.impl.duration;

import java.util.TimeZone;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public interface PeriodBuilderFactory {
    PeriodBuilder getFixedUnitBuilder(TimeUnit timeUnit);

    PeriodBuilder getMultiUnitBuilder(int i);

    PeriodBuilder getOneOrTwoUnitBuilder();

    PeriodBuilder getSingleUnitBuilder();

    PeriodBuilderFactory setAllowMilliseconds(boolean z);

    PeriodBuilderFactory setAllowZero(boolean z);

    PeriodBuilderFactory setAvailableUnitRange(TimeUnit timeUnit, TimeUnit timeUnit2);

    PeriodBuilderFactory setLocale(String str);

    PeriodBuilderFactory setMaxLimit(float f);

    PeriodBuilderFactory setMinLimit(float f);

    PeriodBuilderFactory setTimeZone(TimeZone timeZone);

    PeriodBuilderFactory setUnitIsAvailable(TimeUnit timeUnit, boolean z);

    PeriodBuilderFactory setWeeksAloneOnly(boolean z);
}
