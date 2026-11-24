package com.ibm.icu.impl.duration;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public interface PeriodFormatterFactory {
    PeriodFormatter getFormatter();

    PeriodFormatterFactory setCountVariant(int i);

    PeriodFormatterFactory setDisplayLimit(boolean z);

    PeriodFormatterFactory setDisplayPastFuture(boolean z);

    PeriodFormatterFactory setLocale(String str);

    PeriodFormatterFactory setSeparatorVariant(int i);

    PeriodFormatterFactory setUnitVariant(int i);
}
