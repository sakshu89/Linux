package com.ibm.icu.util;

import com.ibm.icu.impl.CalType;
import com.ibm.icu.impl.EraRules;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class JapaneseCalendar extends GregorianCalendar {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int CURRENT_ERA;
    private static final EraRules ERA_RULES;
    private static final int GREGORIAN_EPOCH = 1970;
    public static final int HEISEI;
    public static final int MEIJI;
    public static final int REIWA;
    public static final int SHOWA;
    public static final int TAISHO;
    private static final long serialVersionUID = -2977189902603704691L;

    static {
        EraRules eraRules = EraRules.getInstance(CalType.JAPANESE, enableTentativeEra());
        ERA_RULES = eraRules;
        MEIJI = 232;
        TAISHO = 233;
        SHOWA = 234;
        HEISEI = 235;
        REIWA = 236;
        CURRENT_ERA = eraRules.getCurrentEraCode();
    }

    public JapaneseCalendar(int i, int i2, int i3) {
        super(i, i2, i3);
        set(0, CURRENT_ERA);
    }

    @Deprecated
    public static boolean enableTentativeEra() {
        String property = System.getProperty("ICU_ENABLE_TENTATIVE_ERA");
        if (property == null) {
            property = System.getenv("ICU_ENABLE_TENTATIVE_ERA");
        }
        if (property != null) {
            return property.equalsIgnoreCase("true");
        }
        return System.getProperty("jdk.calendar.japanese.supplemental.era") != null;
    }

    @Override // com.ibm.icu.util.GregorianCalendar, com.ibm.icu.util.Calendar
    public int getActualMaximum(int i) {
        if (i != 1) {
            return super.getActualMaximum(i);
        }
        int i2 = get(0);
        EraRules eraRules = ERA_RULES;
        if (i2 >= eraRules.getMaxEraCode()) {
            return handleGetLimit(1, 3);
        }
        if (i2 == 0) {
            return super.getActualMaximum(1);
        }
        int[] startDate = eraRules.getStartDate(eraRules.getNextEraCode(i2), null);
        int i3 = startDate[0];
        int i4 = startDate[1];
        int i5 = startDate[2];
        int startYear = i3 - eraRules.getStartYear(i2);
        return (i4 == 1 && i5 == 1) ? startYear : startYear + 1;
    }

    @Override // com.ibm.icu.util.Calendar
    public int getDefaultDayInMonth(int i, int i2) {
        int iInternalGet = internalGet(0, CURRENT_ERA);
        if (iInternalGet == 0) {
            return super.getDefaultDayInMonth(i, i2);
        }
        int[] startDate = ERA_RULES.getStartDate(iInternalGet, null);
        if (i == startDate[0] && i2 == startDate[1] - 1) {
            return startDate[2];
        }
        return 1;
    }

    @Override // com.ibm.icu.util.Calendar
    public int getDefaultMonthInYear(int i) {
        int iInternalGet = internalGet(0, CURRENT_ERA);
        if (iInternalGet == 0) {
            return super.getDefaultMonthInYear(i);
        }
        int[] startDate = ERA_RULES.getStartDate(iInternalGet, null);
        if (i == startDate[0]) {
            return startDate[1] - 1;
        }
        return 0;
    }

    @Override // com.ibm.icu.util.GregorianCalendar, com.ibm.icu.util.Calendar
    public String getType() {
        return "japanese";
    }

    @Override // com.ibm.icu.util.GregorianCalendar, com.ibm.icu.util.Calendar
    public void handleComputeFields(int i) {
        super.handleComputeFields(i);
        int iInternalGet = internalGet(19);
        EraRules eraRules = ERA_RULES;
        int eraCode = eraRules.getEraCode(iInternalGet, internalGet(2) + 1, internalGet(5));
        internalSet(0, eraCode);
        if (eraCode == 0) {
            iInternalGet = 1 - iInternalGet;
        } else if (eraCode != 1) {
            iInternalGet = (iInternalGet - eraRules.getStartYear(eraCode)) + 1;
        }
        internalSet(1, iInternalGet);
    }

    @Override // com.ibm.icu.util.GregorianCalendar, com.ibm.icu.util.Calendar
    public int handleGetExtendedYear() {
        if (newerField(19, 1) == 19 && newerField(19, 0) == 19) {
            return internalGet(19, GREGORIAN_EPOCH);
        }
        int iInternalGet = internalGet(0, CURRENT_ERA);
        int iInternalGet2 = internalGet(1, 1);
        return iInternalGet == 0 ? 1 - iInternalGet2 : (ERA_RULES.getStartYear(iInternalGet) + iInternalGet2) - 1;
    }

    @Override // com.ibm.icu.util.GregorianCalendar, com.ibm.icu.util.Calendar
    public int handleGetLimit(int i, int i2) {
        if (i == 0) {
            if (i2 == 0 || i2 == 1) {
                return 0;
            }
            return ERA_RULES.getMaxEraCode();
        }
        if (i == 1) {
            if (i2 == 0 || i2 == 1 || i2 == 2) {
                return 1;
            }
            if (i2 == 3) {
                return super.handleGetLimit(i, 3) - ERA_RULES.getStartYear(CURRENT_ERA);
            }
        }
        return super.handleGetLimit(i, i2);
    }

    @Override // com.ibm.icu.util.Calendar
    @Deprecated
    public boolean haveDefaultCentury() {
        return false;
    }

    @Override // com.ibm.icu.util.GregorianCalendar, com.ibm.icu.util.Calendar
    @Deprecated
    public boolean isEra0CountingBackward() {
        return true;
    }

    public JapaneseCalendar(TimeZone timeZone) {
        super(timeZone);
    }

    public JapaneseCalendar(Locale locale) {
        super(locale);
    }

    public JapaneseCalendar(ULocale uLocale) {
        super(uLocale);
    }

    public JapaneseCalendar(TimeZone timeZone, Locale locale) {
        super(timeZone, locale);
    }

    public JapaneseCalendar(TimeZone timeZone, ULocale uLocale) {
        super(timeZone, uLocale);
    }

    public JapaneseCalendar(Date date) {
        this();
        setTime(date);
    }

    public JapaneseCalendar(int i, int i2, int i3, int i4) {
        super(i2, i3, i4);
        set(0, i);
    }

    public JapaneseCalendar() {
    }

    public JapaneseCalendar(int i, int i2, int i3, int i4, int i5, int i6) {
        super(i, i2, i3, i4, i5, i6);
        set(0, CURRENT_ERA);
    }
}
