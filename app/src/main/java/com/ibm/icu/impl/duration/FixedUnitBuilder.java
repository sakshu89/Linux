package com.ibm.icu.impl.duration;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
class FixedUnitBuilder extends PeriodBuilderImpl {
    private TimeUnit unit;

    public FixedUnitBuilder(TimeUnit timeUnit, BasicPeriodBuilderFactory.Settings settings) {
        super(settings);
        this.unit = timeUnit;
    }

    public static FixedUnitBuilder get(TimeUnit timeUnit, BasicPeriodBuilderFactory.Settings settings) {
        if (settings == null || (settings.effectiveSet() & (1 << timeUnit.ordinal)) == 0) {
            return null;
        }
        return new FixedUnitBuilder(timeUnit, settings);
    }

    @Override // com.ibm.icu.impl.duration.PeriodBuilderImpl
    public Period handleCreate(long j, long j2, boolean z) {
        TimeUnit timeUnit = this.unit;
        if (timeUnit == null) {
            return null;
        }
        return Period.at((float) (j / approximateDurationOf(timeUnit)), this.unit).inPast(z);
    }

    @Override // com.ibm.icu.impl.duration.PeriodBuilderImpl
    public PeriodBuilder withSettings(BasicPeriodBuilderFactory.Settings settings) {
        return get(this.unit, settings);
    }
}
