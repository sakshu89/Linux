package com.ibm.icu.impl.duration;

import java.util.Locale;
import java.util.TimeZone;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
class BasicDurationFormatterFactory implements DurationFormatterFactory {
    private PeriodBuilder builder;
    private BasicDurationFormatter f;
    private DateFormatter fallback;
    private long fallbackLimit;
    private PeriodFormatter formatter;
    private BasicPeriodFormatterService ps;
    private String localeName = Locale.getDefault().toString();
    private TimeZone timeZone = TimeZone.getDefault();

    public BasicDurationFormatterFactory(BasicPeriodFormatterService basicPeriodFormatterService) {
        this.ps = basicPeriodFormatterService;
    }

    public BasicDurationFormatter createFormatter() {
        return new BasicDurationFormatter(this.formatter, this.builder, this.fallback, this.fallbackLimit, this.localeName, this.timeZone);
    }

    public DateFormatter getFallback() {
        return this.fallback;
    }

    public long getFallbackLimit() {
        if (this.fallback == null) {
            return 0L;
        }
        return this.fallbackLimit;
    }

    @Override // com.ibm.icu.impl.duration.DurationFormatterFactory
    public DurationFormatter getFormatter() {
        if (this.f == null) {
            DateFormatter dateFormatter = this.fallback;
            if (dateFormatter != null) {
                this.fallback = dateFormatter.withLocale(this.localeName).withTimeZone(this.timeZone);
            }
            this.formatter = getPeriodFormatter();
            this.builder = getPeriodBuilder();
            this.f = createFormatter();
        }
        return this.f;
    }

    public String getLocaleName() {
        return this.localeName;
    }

    public PeriodBuilder getPeriodBuilder() {
        if (this.builder == null) {
            this.builder = this.ps.newPeriodBuilderFactory().setLocale(this.localeName).setTimeZone(this.timeZone).getSingleUnitBuilder();
        }
        return this.builder;
    }

    public PeriodFormatter getPeriodFormatter() {
        if (this.formatter == null) {
            this.formatter = this.ps.newPeriodFormatterFactory().setLocale(this.localeName).getFormatter();
        }
        return this.formatter;
    }

    public TimeZone getTimeZone() {
        return this.timeZone;
    }

    public void reset() {
        this.f = null;
    }

    @Override // com.ibm.icu.impl.duration.DurationFormatterFactory
    public DurationFormatterFactory setFallback(DateFormatter dateFormatter) {
        DateFormatter dateFormatter2 = this.fallback;
        if (dateFormatter != null) {
            if (!dateFormatter.equals(dateFormatter2)) {
            }
            return this;
        }
        if (dateFormatter2 == null) {
            return this;
        }
        this.fallback = dateFormatter;
        reset();
        return this;
    }

    @Override // com.ibm.icu.impl.duration.DurationFormatterFactory
    public DurationFormatterFactory setFallbackLimit(long j) {
        if (j < 0) {
            j = 0;
        }
        if (j != this.fallbackLimit) {
            this.fallbackLimit = j;
            reset();
        }
        return this;
    }

    @Override // com.ibm.icu.impl.duration.DurationFormatterFactory
    public DurationFormatterFactory setLocale(String str) {
        if (!str.equals(this.localeName)) {
            this.localeName = str;
            PeriodBuilder periodBuilder = this.builder;
            if (periodBuilder != null) {
                this.builder = periodBuilder.withLocale(str);
            }
            PeriodFormatter periodFormatter = this.formatter;
            if (periodFormatter != null) {
                this.formatter = periodFormatter.withLocale(str);
            }
            reset();
        }
        return this;
    }

    @Override // com.ibm.icu.impl.duration.DurationFormatterFactory
    public DurationFormatterFactory setPeriodBuilder(PeriodBuilder periodBuilder) {
        if (periodBuilder != this.builder) {
            this.builder = periodBuilder;
            reset();
        }
        return this;
    }

    @Override // com.ibm.icu.impl.duration.DurationFormatterFactory
    public DurationFormatterFactory setPeriodFormatter(PeriodFormatter periodFormatter) {
        if (periodFormatter != this.formatter) {
            this.formatter = periodFormatter;
            reset();
        }
        return this;
    }

    @Override // com.ibm.icu.impl.duration.DurationFormatterFactory
    public DurationFormatterFactory setTimeZone(TimeZone timeZone) {
        if (!timeZone.equals(this.timeZone)) {
            this.timeZone = timeZone;
            PeriodBuilder periodBuilder = this.builder;
            if (periodBuilder != null) {
                this.builder = periodBuilder.withTimeZone(timeZone);
            }
            reset();
        }
        return this;
    }
}
