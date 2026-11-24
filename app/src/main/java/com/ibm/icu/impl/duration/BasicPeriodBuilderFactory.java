package com.ibm.icu.impl.duration;

import com.ibm.icu.impl.duration.impl.PeriodFormatterData;
import com.ibm.icu.impl.duration.impl.PeriodFormatterDataService;
import defpackage.ky0;
import defpackage.og;
import java.util.TimeZone;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
class BasicPeriodBuilderFactory implements PeriodBuilderFactory {
    private static final short allBits = 255;
    private PeriodFormatterDataService ds;
    private Settings settings = new Settings();

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public class Settings {
        boolean inUse;
        int maxLimit;
        int minLimit;
        boolean weeksAloneOnly;
        short uset = BasicPeriodBuilderFactory.allBits;
        TimeUnit maxUnit = TimeUnit.YEAR;
        TimeUnit minUnit = TimeUnit.MILLISECOND;
        boolean allowZero = true;
        boolean allowMillis = true;

        public Settings() {
        }

        public Settings copy() {
            Settings settings = BasicPeriodBuilderFactory.this.new Settings();
            settings.inUse = this.inUse;
            settings.uset = this.uset;
            settings.maxUnit = this.maxUnit;
            settings.minUnit = this.minUnit;
            settings.maxLimit = this.maxLimit;
            settings.minLimit = this.minLimit;
            settings.allowZero = this.allowZero;
            settings.weeksAloneOnly = this.weeksAloneOnly;
            settings.allowMillis = this.allowMillis;
            return settings;
        }

        public Period createLimited(long j, boolean z) {
            if (this.maxLimit > 0) {
                long jApproximateDurationOf = BasicPeriodBuilderFactory.approximateDurationOf(this.maxUnit);
                long j2 = j * 1000;
                int i = this.maxLimit;
                if (j2 > ((long) i) * jApproximateDurationOf) {
                    return Period.moreThan(i / 1000.0f, this.maxUnit).inPast(z);
                }
            }
            if (this.minLimit <= 0) {
                return null;
            }
            TimeUnit timeUnitEffectiveMinUnit = effectiveMinUnit();
            long jApproximateDurationOf2 = BasicPeriodBuilderFactory.approximateDurationOf(timeUnitEffectiveMinUnit);
            TimeUnit timeUnit = this.minUnit;
            long jMax = timeUnitEffectiveMinUnit == timeUnit ? this.minLimit : Math.max(1000L, (BasicPeriodBuilderFactory.approximateDurationOf(timeUnit) * ((long) this.minLimit)) / jApproximateDurationOf2);
            if (j * 1000 < jApproximateDurationOf2 * jMax) {
                return Period.lessThan(jMax / 1000.0f, timeUnitEffectiveMinUnit).inPast(z);
            }
            return null;
        }

        public TimeUnit effectiveMinUnit() {
            if (this.allowMillis || this.minUnit != TimeUnit.MILLISECOND) {
                return this.minUnit;
            }
            int length = TimeUnit.units.length - 1;
            do {
                length--;
                if (length < 0) {
                    return TimeUnit.SECOND;
                }
            } while ((this.uset & (1 << length)) == 0);
            return TimeUnit.units[length];
        }

        public short effectiveSet() {
            boolean z = this.allowMillis;
            short s = this.uset;
            return z ? s : (short) (s & (~(1 << TimeUnit.MILLISECOND.ordinal)));
        }

        public Settings setAllowMilliseconds(boolean z) {
            if (this.allowMillis == z) {
                return this;
            }
            if (this.inUse) {
                this = copy();
            }
            this.allowMillis = z;
            return this;
        }

        public Settings setAllowZero(boolean z) {
            if (this.allowZero == z) {
                return this;
            }
            if (this.inUse) {
                this = copy();
            }
            this.allowZero = z;
            return this;
        }

        public Settings setInUse() {
            this.inUse = true;
            return this;
        }

        public Settings setLocale(String str) {
            PeriodFormatterData periodFormatterData = BasicPeriodBuilderFactory.this.ds.get(str);
            return setAllowZero(periodFormatterData.allowZero()).setWeeksAloneOnly(periodFormatterData.weeksAloneOnly()).setAllowMilliseconds(periodFormatterData.useMilliseconds() != 1);
        }

        public Settings setMaxLimit(float f) {
            int i = f <= 0.0f ? 0 : (int) (1000.0f * f);
            if (f == i) {
                return this;
            }
            if (this.inUse) {
                this = copy();
            }
            this.maxLimit = i;
            return this;
        }

        public Settings setMinLimit(float f) {
            int i = f <= 0.0f ? 0 : (int) (1000.0f * f);
            if (f == i) {
                return this;
            }
            if (this.inUse) {
                this = copy();
            }
            this.minLimit = i;
            return this;
        }

        public Settings setUnits(int i) {
            TimeUnit[] timeUnitArr;
            if (this.uset == i) {
                return this;
            }
            if (this.inUse) {
                this = copy();
            }
            this.uset = (short) i;
            if ((i & 255) == 255) {
                this.uset = BasicPeriodBuilderFactory.allBits;
                this.maxUnit = TimeUnit.YEAR;
                this.minUnit = TimeUnit.MILLISECOND;
                return this;
            }
            int i2 = 0;
            int i3 = -1;
            while (true) {
                timeUnitArr = TimeUnit.units;
                if (i2 >= timeUnitArr.length) {
                    break;
                }
                if (((1 << i2) & i) != 0) {
                    if (i3 == -1) {
                        this.maxUnit = timeUnitArr[i2];
                    }
                    i3 = i2;
                }
                i2++;
            }
            if (i3 != -1) {
                this.minUnit = timeUnitArr[i3];
                return this;
            }
            this.maxUnit = null;
            this.minUnit = null;
            return this;
        }

        public Settings setWeeksAloneOnly(boolean z) {
            if (this.weeksAloneOnly == z) {
                return this;
            }
            if (this.inUse) {
                this = copy();
            }
            this.weeksAloneOnly = z;
            return this;
        }
    }

    public BasicPeriodBuilderFactory(PeriodFormatterDataService periodFormatterDataService) {
        this.ds = periodFormatterDataService;
    }

    public static long approximateDurationOf(TimeUnit timeUnit) {
        return TimeUnit.approxDurations[timeUnit.ordinal];
    }

    private Settings getSettings() {
        if (this.settings.effectiveSet() == 0) {
            return null;
        }
        return this.settings.setInUse();
    }

    @Override // com.ibm.icu.impl.duration.PeriodBuilderFactory
    public PeriodBuilder getFixedUnitBuilder(TimeUnit timeUnit) {
        return FixedUnitBuilder.get(timeUnit, getSettings());
    }

    @Override // com.ibm.icu.impl.duration.PeriodBuilderFactory
    public PeriodBuilder getMultiUnitBuilder(int i) {
        return MultiUnitBuilder.get(i, getSettings());
    }

    @Override // com.ibm.icu.impl.duration.PeriodBuilderFactory
    public PeriodBuilder getOneOrTwoUnitBuilder() {
        return OneOrTwoUnitBuilder.get(getSettings());
    }

    @Override // com.ibm.icu.impl.duration.PeriodBuilderFactory
    public PeriodBuilder getSingleUnitBuilder() {
        return SingleUnitBuilder.get(getSettings());
    }

    @Override // com.ibm.icu.impl.duration.PeriodBuilderFactory
    public PeriodBuilderFactory setAllowMilliseconds(boolean z) {
        this.settings = this.settings.setAllowMilliseconds(z);
        return this;
    }

    @Override // com.ibm.icu.impl.duration.PeriodBuilderFactory
    public PeriodBuilderFactory setAllowZero(boolean z) {
        this.settings = this.settings.setAllowZero(z);
        return this;
    }

    @Override // com.ibm.icu.impl.duration.PeriodBuilderFactory
    public PeriodBuilderFactory setAvailableUnitRange(TimeUnit timeUnit, TimeUnit timeUnit2) {
        int i = 0;
        for (int i2 = timeUnit2.ordinal; i2 <= timeUnit.ordinal; i2++) {
            i |= 1 << i2;
        }
        if (i != 0) {
            this.settings = this.settings.setUnits(i);
            return this;
        }
        og.i(ky0.l("range ", String.valueOf(timeUnit), " to ", String.valueOf(timeUnit2), " is empty"));
        return null;
    }

    @Override // com.ibm.icu.impl.duration.PeriodBuilderFactory
    public PeriodBuilderFactory setLocale(String str) {
        this.settings = this.settings.setLocale(str);
        return this;
    }

    @Override // com.ibm.icu.impl.duration.PeriodBuilderFactory
    public PeriodBuilderFactory setMaxLimit(float f) {
        this.settings = this.settings.setMaxLimit(f);
        return this;
    }

    @Override // com.ibm.icu.impl.duration.PeriodBuilderFactory
    public PeriodBuilderFactory setMinLimit(float f) {
        this.settings = this.settings.setMinLimit(f);
        return this;
    }

    @Override // com.ibm.icu.impl.duration.PeriodBuilderFactory
    public PeriodBuilderFactory setUnitIsAvailable(TimeUnit timeUnit, boolean z) {
        Settings settings = this.settings;
        short s = settings.uset;
        this.settings = settings.setUnits(z ? (1 << timeUnit.ordinal) | s : (~(1 << timeUnit.ordinal)) & s);
        return this;
    }

    @Override // com.ibm.icu.impl.duration.PeriodBuilderFactory
    public PeriodBuilderFactory setWeeksAloneOnly(boolean z) {
        this.settings = this.settings.setWeeksAloneOnly(z);
        return this;
    }

    @Override // com.ibm.icu.impl.duration.PeriodBuilderFactory
    public PeriodBuilderFactory setTimeZone(TimeZone timeZone) {
        return this;
    }
}
