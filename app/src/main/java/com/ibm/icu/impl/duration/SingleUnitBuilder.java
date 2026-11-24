package com.ibm.icu.impl.duration;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
class SingleUnitBuilder extends PeriodBuilderImpl {
    public SingleUnitBuilder(BasicPeriodBuilderFactory.Settings settings) {
        super(settings);
    }

    public static SingleUnitBuilder get(BasicPeriodBuilderFactory.Settings settings) {
        if (settings == null) {
            return null;
        }
        return new SingleUnitBuilder(settings);
    }

    @Override // com.ibm.icu.impl.duration.PeriodBuilderImpl
    public Period handleCreate(long j, long j2, boolean z) {
        short sEffectiveSet = this.settings.effectiveSet();
        int i = 0;
        while (true) {
            TimeUnit[] timeUnitArr = TimeUnit.units;
            if (i >= timeUnitArr.length) {
                return null;
            }
            if (((1 << i) & sEffectiveSet) != 0) {
                TimeUnit timeUnit = timeUnitArr[i];
                long jApproximateDurationOf = approximateDurationOf(timeUnit);
                if (j >= jApproximateDurationOf) {
                    return Period.at((float) (j / jApproximateDurationOf), timeUnit).inPast(z);
                }
            }
            i++;
        }
    }

    @Override // com.ibm.icu.impl.duration.PeriodBuilderImpl
    public PeriodBuilder withSettings(BasicPeriodBuilderFactory.Settings settings) {
        return get(settings);
    }
}
