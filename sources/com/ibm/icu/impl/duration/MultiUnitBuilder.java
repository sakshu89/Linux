package com.ibm.icu.impl.duration;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
class MultiUnitBuilder extends PeriodBuilderImpl {
    private int nPeriods;

    public MultiUnitBuilder(int i, BasicPeriodBuilderFactory.Settings settings) {
        super(settings);
        this.nPeriods = i;
    }

    public static MultiUnitBuilder get(int i, BasicPeriodBuilderFactory.Settings settings) {
        if (i <= 0 || settings == null) {
            return null;
        }
        return new MultiUnitBuilder(i, settings);
    }

    @Override // com.ibm.icu.impl.duration.PeriodBuilderImpl
    public Period handleCreate(long j, long j2, boolean z) {
        short sEffectiveSet = this.settings.effectiveSet();
        Period periodInPast = null;
        int i = 0;
        int i2 = 0;
        while (true) {
            TimeUnit[] timeUnitArr = TimeUnit.units;
            if (i >= timeUnitArr.length) {
                break;
            }
            if (((1 << i) & sEffectiveSet) != 0) {
                TimeUnit timeUnit = timeUnitArr[i];
                if (i2 == this.nPeriods) {
                    break;
                }
                long jApproximateDurationOf = approximateDurationOf(timeUnit);
                if (j >= jApproximateDurationOf || i2 > 0) {
                    i2++;
                    double d = jApproximateDurationOf;
                    double dFloor = j / d;
                    if (i2 < this.nPeriods) {
                        dFloor = Math.floor(dFloor);
                        j -= (long) (d * dFloor);
                    }
                    periodInPast = periodInPast == null ? Period.at((float) dFloor, timeUnit).inPast(z) : periodInPast.and((float) dFloor, timeUnit);
                }
            }
            i++;
        }
        return periodInPast;
    }

    @Override // com.ibm.icu.impl.duration.PeriodBuilderImpl
    public PeriodBuilder withSettings(BasicPeriodBuilderFactory.Settings settings) {
        return get(this.nPeriods, settings);
    }
}
