package com.ibm.icu.impl.duration;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
class OneOrTwoUnitBuilder extends PeriodBuilderImpl {
    public OneOrTwoUnitBuilder(BasicPeriodBuilderFactory.Settings settings) {
        super(settings);
    }

    public static OneOrTwoUnitBuilder get(BasicPeriodBuilderFactory.Settings settings) {
        if (settings == null) {
            return null;
        }
        return new OneOrTwoUnitBuilder(settings);
    }

    @Override // com.ibm.icu.impl.duration.PeriodBuilderImpl
    public Period handleCreate(long j, long j2, boolean z) {
        short sEffectiveSet = this.settings.effectiveSet();
        Period periodInPast = null;
        int i = 0;
        while (true) {
            TimeUnit[] timeUnitArr = TimeUnit.units;
            if (i >= timeUnitArr.length) {
                break;
            }
            if (((1 << i) & sEffectiveSet) != 0) {
                TimeUnit timeUnit = timeUnitArr[i];
                long jApproximateDurationOf = approximateDurationOf(timeUnit);
                if (j >= jApproximateDurationOf || periodInPast != null) {
                    double d = j / jApproximateDurationOf;
                    if (periodInPast != null) {
                        if (d < 1.0d) {
                            break;
                        }
                        return periodInPast.and((float) d, timeUnit);
                    }
                    if (d >= 2.0d) {
                        return Period.at((float) d, timeUnit);
                    }
                    periodInPast = Period.at(1.0f, timeUnit).inPast(z);
                    j -= jApproximateDurationOf;
                }
            }
            i++;
        }
        return periodInPast;
    }

    @Override // com.ibm.icu.impl.duration.PeriodBuilderImpl
    public PeriodBuilder withSettings(BasicPeriodBuilderFactory.Settings settings) {
        return get(settings);
    }
}
