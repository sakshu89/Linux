package com.ibm.icu.impl.duration;

import java.util.TimeZone;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
abstract class PeriodBuilderImpl implements PeriodBuilder {
    protected BasicPeriodBuilderFactory.Settings settings;

    public PeriodBuilderImpl(BasicPeriodBuilderFactory.Settings settings) {
        this.settings = settings;
    }

    public long approximateDurationOf(TimeUnit timeUnit) {
        return BasicPeriodBuilderFactory.approximateDurationOf(timeUnit);
    }

    @Override // com.ibm.icu.impl.duration.PeriodBuilder
    public Period create(long j) {
        return createWithReferenceDate(j, System.currentTimeMillis());
    }

    @Override // com.ibm.icu.impl.duration.PeriodBuilder
    public Period createWithReferenceDate(long j, long j2) {
        boolean z = j < 0;
        if (z) {
            j = -j;
        }
        long j3 = j;
        Period periodCreateLimited = this.settings.createLimited(j3, z);
        if (periodCreateLimited != null) {
            return periodCreateLimited;
        }
        Period periodHandleCreate = handleCreate(j3, j2, z);
        return periodHandleCreate == null ? Period.lessThan(1.0f, this.settings.effectiveMinUnit()).inPast(z) : periodHandleCreate;
    }

    public abstract Period handleCreate(long j, long j2, boolean z);

    @Override // com.ibm.icu.impl.duration.PeriodBuilder
    public PeriodBuilder withLocale(String str) {
        BasicPeriodBuilderFactory.Settings locale = this.settings.setLocale(str);
        return locale != this.settings ? withSettings(locale) : this;
    }

    public abstract PeriodBuilder withSettings(BasicPeriodBuilderFactory.Settings settings);

    @Override // com.ibm.icu.impl.duration.PeriodBuilder
    public PeriodBuilder withTimeZone(TimeZone timeZone) {
        return this;
    }
}
