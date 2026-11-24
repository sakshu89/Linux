package com.ibm.icu.impl.duration;

import com.ibm.icu.text.DurationFormat;
import com.ibm.icu.util.ULocale;
import defpackage.og;
import java.text.FieldPosition;
import java.util.Date;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.Duration;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class BasicDurationFormat extends DurationFormat {
    private static final long serialVersionUID = -3146984141909457700L;
    transient DurationFormatter formatter;
    transient PeriodFormatter pformatter;
    transient PeriodFormatterService pfs;

    public BasicDurationFormat(ULocale uLocale) {
        super(uLocale);
        this.pfs = null;
        BasicPeriodFormatterService basicPeriodFormatterService = BasicPeriodFormatterService.getInstance();
        this.pfs = basicPeriodFormatterService;
        this.formatter = basicPeriodFormatterService.newDurationFormatterFactory().setLocale(uLocale.getName()).getFormatter();
        this.pformatter = this.pfs.newPeriodFormatterFactory().setDisplayPastFuture(false).setLocale(uLocale.getName()).getFormatter();
    }

    public static BasicDurationFormat getInstance(ULocale uLocale) {
        return new BasicDurationFormat(uLocale);
    }

    @Override // com.ibm.icu.text.DurationFormat, java.text.Format
    public StringBuffer format(Object obj, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        if (obj instanceof Long) {
            stringBuffer.append(formatDurationFromNow(((Long) obj).longValue()));
            return stringBuffer;
        }
        if (obj instanceof Date) {
            stringBuffer.append(formatDurationFromNowTo((Date) obj));
            return stringBuffer;
        }
        if (obj instanceof Duration) {
            stringBuffer.append(formatDuration(obj));
            return stringBuffer;
        }
        og.i("Cannot format given Object as a Duration");
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0079  */
    public String formatDuration(Object obj) {
        boolean z;
        float f;
        TimeUnit timeUnit;
        DatatypeConstants.Field[] fieldArr = {DatatypeConstants.YEARS, DatatypeConstants.MONTHS, DatatypeConstants.DAYS, DatatypeConstants.HOURS, DatatypeConstants.MINUTES, DatatypeConstants.SECONDS};
        TimeUnit[] timeUnitArr = {TimeUnit.YEAR, TimeUnit.MONTH, TimeUnit.DAY, TimeUnit.HOUR, TimeUnit.MINUTE, TimeUnit.SECOND};
        Duration durationNegate = (Duration) obj;
        if (durationNegate.getSign() < 0) {
            durationNegate = durationNegate.negate();
            z = true;
        } else {
            z = false;
        }
        boolean z2 = false;
        Period periodAt = null;
        for (int i = 0; i < 6; i++) {
            if (durationNegate.isSet(fieldArr[i])) {
                Number field = durationNegate.getField(fieldArr[i]);
                if (field.intValue() != 0 || z2) {
                    float fFloatValue = field.floatValue();
                    if (timeUnitArr[i] == TimeUnit.SECOND) {
                        double d = fFloatValue;
                        double dFloor = Math.floor(d);
                        double d2 = (d - dFloor) * 1000.0d;
                        if (d2 > 0.0d) {
                            float f2 = (float) d2;
                            timeUnit = TimeUnit.MILLISECOND;
                            fFloatValue = (float) dFloor;
                            f = f2;
                        } else {
                            f = 0.0f;
                            timeUnit = null;
                        }
                    } else {
                        f = 0.0f;
                        timeUnit = null;
                    }
                    periodAt = periodAt == null ? Period.at(fFloatValue, timeUnitArr[i]) : periodAt.and(fFloatValue, timeUnitArr[i]);
                    if (timeUnit != null) {
                        periodAt = periodAt.and(f, timeUnit);
                    }
                    z2 = true;
                }
            }
        }
        if (periodAt == null) {
            return formatDurationFromNow(0L);
        }
        return this.pformatter.format(z ? periodAt.inPast() : periodAt.inFuture());
    }

    @Override // com.ibm.icu.text.DurationFormat
    public String formatDurationFrom(long j, long j2) {
        return this.formatter.formatDurationFrom(j, j2);
    }

    @Override // com.ibm.icu.text.DurationFormat
    public String formatDurationFromNow(long j) {
        return this.formatter.formatDurationFromNow(j);
    }

    @Override // com.ibm.icu.text.DurationFormat
    public String formatDurationFromNowTo(Date date) {
        return this.formatter.formatDurationFromNowTo(date);
    }

    public BasicDurationFormat() {
        this.pfs = null;
        BasicPeriodFormatterService basicPeriodFormatterService = BasicPeriodFormatterService.getInstance();
        this.pfs = basicPeriodFormatterService;
        this.formatter = basicPeriodFormatterService.newDurationFormatterFactory().getFormatter();
        this.pformatter = this.pfs.newPeriodFormatterFactory().setDisplayPastFuture(false).getFormatter();
    }
}
