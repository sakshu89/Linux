package com.ibm.icu.util;

import java.util.Date;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class BuddhistCalendar extends GregorianCalendar {
    public static final int BE = 0;
    private static final int BUDDHIST_ERA_START = -543;
    private static final int GREGORIAN_EPOCH = 1970;
    private static final long serialVersionUID = 2583005278132380631L;

    public BuddhistCalendar(Date date) {
        this();
        setTime(date);
    }

    @Override // com.ibm.icu.util.GregorianCalendar, com.ibm.icu.util.Calendar
    public String getType() {
        return "buddhist";
    }

    @Override // com.ibm.icu.util.GregorianCalendar, com.ibm.icu.util.Calendar
    public void handleComputeFields(int i) {
        super.handleComputeFields(i);
        int iInternalGet = internalGet(19) + 543;
        internalSet(0, 0);
        internalSet(1, iInternalGet);
    }

    @Override // com.ibm.icu.util.GregorianCalendar, com.ibm.icu.util.Calendar
    public int handleComputeMonthStart(int i, int i2, boolean z) {
        return super.handleComputeMonthStart(i, i2, z);
    }

    @Override // com.ibm.icu.util.GregorianCalendar, com.ibm.icu.util.Calendar
    public int handleGetExtendedYear() {
        return newerField(19, 1) == 19 ? internalGet(19, GREGORIAN_EPOCH) : internalGet(1, 2513) + BUDDHIST_ERA_START;
    }

    @Override // com.ibm.icu.util.GregorianCalendar, com.ibm.icu.util.Calendar
    public int handleGetLimit(int i, int i2) {
        if (i == 0) {
            return 0;
        }
        return super.handleGetLimit(i, i2);
    }

    @Override // com.ibm.icu.util.GregorianCalendar, com.ibm.icu.util.Calendar
    @Deprecated
    public boolean isEra0CountingBackward() {
        return false;
    }

    public BuddhistCalendar(TimeZone timeZone) {
        super(timeZone);
    }

    public BuddhistCalendar(Locale locale) {
        super(locale);
    }

    public BuddhistCalendar(ULocale uLocale) {
        super(uLocale);
    }

    public BuddhistCalendar(TimeZone timeZone, Locale locale) {
        super(timeZone, locale);
    }

    public BuddhistCalendar(TimeZone timeZone, ULocale uLocale) {
        super(timeZone, uLocale);
    }

    public BuddhistCalendar() {
    }

    public BuddhistCalendar(int i, int i2, int i3) {
        super(i, i2, i3);
    }

    public BuddhistCalendar(int i, int i2, int i3, int i4, int i5, int i6) {
        super(i, i2, i3, i4, i5, i6);
    }
}
