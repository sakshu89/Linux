package com.ibm.icu.util;

import com.ibm.icu.impl.CalendarAstronomer;
import com.ibm.icu.impl.Grego;
import java.util.Date;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class AnnualTimeZoneRule extends TimeZoneRule {
    public static final int MAX_YEAR = Integer.MAX_VALUE;
    private static final long serialVersionUID = -8870666707791230688L;
    private final DateTimeRule dateTimeRule;
    private final int endYear;
    private final int startYear;

    public AnnualTimeZoneRule(String str, int i, int i2, DateTimeRule dateTimeRule, int i3, int i4) {
        super(str, i, i2);
        this.dateTimeRule = dateTimeRule;
        this.startYear = i3;
        this.endYear = i4;
    }

    public int getEndYear() {
        return this.endYear;
    }

    @Override // com.ibm.icu.util.TimeZoneRule
    public Date getFinalStart(int i, int i2) {
        int i3 = this.endYear;
        if (i3 == Integer.MAX_VALUE) {
            return null;
        }
        return getStartInYear(i3, i, i2);
    }

    @Override // com.ibm.icu.util.TimeZoneRule
    public Date getFirstStart(int i, int i2) {
        return getStartInYear(this.startYear, i, i2);
    }

    @Override // com.ibm.icu.util.TimeZoneRule
    public Date getNextStart(long j, int i, int i2, boolean z) {
        int iTimeToYear = Grego.timeToYear(j);
        if (iTimeToYear < this.startYear) {
            return getFirstStart(i, i2);
        }
        Date startInYear = getStartInYear(iTimeToYear, i, i2);
        return (startInYear == null || (startInYear.getTime() >= j && (z || startInYear.getTime() != j))) ? startInYear : getStartInYear(iTimeToYear + 1, i, i2);
    }

    @Override // com.ibm.icu.util.TimeZoneRule
    public Date getPreviousStart(long j, int i, int i2, boolean z) {
        int iTimeToYear = Grego.timeToYear(j);
        if (iTimeToYear > this.endYear) {
            return getFinalStart(i, i2);
        }
        Date startInYear = getStartInYear(iTimeToYear, i, i2);
        return (startInYear == null || (startInYear.getTime() <= j && (z || startInYear.getTime() != j))) ? startInYear : getStartInYear(iTimeToYear - 1, i, i2);
    }

    public DateTimeRule getRule() {
        return this.dateTimeRule;
    }

    /* JADX WARN: Code duplicated, block: B:29:0x0088 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:30:0x008a  */
    /* JADX WARN: Code duplicated, block: B:31:0x008d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:32:0x008f  */
    public Date getStartInYear(int i, int i2, int i3) {
        long jFieldsToDay;
        long jFieldsToDay2;
        int ruleDayOfWeek;
        long jFieldsToDay3;
        if (i < this.startYear || i > this.endYear) {
            return null;
        }
        int dateRuleType = this.dateTimeRule.getDateRuleType();
        if (dateRuleType == 0) {
            jFieldsToDay3 = Grego.fieldsToDay(i, this.dateTimeRule.getRuleMonth(), this.dateTimeRule.getRuleDayOfMonth());
        } else {
            DateTimeRule dateTimeRule = this.dateTimeRule;
            boolean z = false;
            boolean z2 = true;
            if (dateRuleType == 1) {
                int ruleWeekInMonth = dateTimeRule.getRuleWeekInMonth();
                DateTimeRule dateTimeRule2 = this.dateTimeRule;
                if (ruleWeekInMonth > 0) {
                    jFieldsToDay2 = Grego.fieldsToDay(i, dateTimeRule2.getRuleMonth(), 1) + ((long) ((ruleWeekInMonth - 1) * 7));
                } else {
                    jFieldsToDay = ((long) ((ruleWeekInMonth + 1) * 7)) + Grego.fieldsToDay(i, dateTimeRule2.getRuleMonth(), Grego.monthLength(i, this.dateTimeRule.getRuleMonth()));
                }
                ruleDayOfWeek = this.dateTimeRule.getRuleDayOfWeek() - Grego.dayOfWeek(jFieldsToDay2);
                if (z2) {
                    if (ruleDayOfWeek < 0) {
                        ruleDayOfWeek += 7;
                    }
                } else if (ruleDayOfWeek > 0) {
                    ruleDayOfWeek -= 7;
                }
                jFieldsToDay3 = jFieldsToDay2 + ((long) ruleDayOfWeek);
            } else {
                int ruleMonth = dateTimeRule.getRuleMonth();
                int ruleDayOfMonth = this.dateTimeRule.getRuleDayOfMonth();
                if (dateRuleType != 3) {
                    z = true;
                } else if (ruleMonth == 1 && ruleDayOfMonth == 29 && !Grego.isLeapYear(i)) {
                    ruleDayOfMonth--;
                }
                jFieldsToDay = Grego.fieldsToDay(i, ruleMonth, ruleDayOfMonth);
            }
            z2 = z;
            jFieldsToDay2 = jFieldsToDay;
            ruleDayOfWeek = this.dateTimeRule.getRuleDayOfWeek() - Grego.dayOfWeek(jFieldsToDay2);
            if (z2) {
                if (ruleDayOfWeek < 0) {
                    ruleDayOfWeek += 7;
                }
            } else if (ruleDayOfWeek > 0) {
                ruleDayOfWeek -= 7;
            }
            jFieldsToDay3 = jFieldsToDay2 + ((long) ruleDayOfWeek);
        }
        long ruleMillisInDay = (jFieldsToDay3 * CalendarAstronomer.DAY_MS) + ((long) this.dateTimeRule.getRuleMillisInDay());
        if (this.dateTimeRule.getTimeRuleType() != 2) {
            ruleMillisInDay -= (long) i2;
        }
        if (this.dateTimeRule.getTimeRuleType() == 0) {
            ruleMillisInDay -= (long) i3;
        }
        return new Date(ruleMillisInDay);
    }

    public int getStartYear() {
        return this.startYear;
    }

    @Override // com.ibm.icu.util.TimeZoneRule
    public boolean isEquivalentTo(TimeZoneRule timeZoneRule) {
        if (!(timeZoneRule instanceof AnnualTimeZoneRule)) {
            return false;
        }
        AnnualTimeZoneRule annualTimeZoneRule = (AnnualTimeZoneRule) timeZoneRule;
        if (this.startYear == annualTimeZoneRule.startYear && this.endYear == annualTimeZoneRule.endYear && this.dateTimeRule.equals(annualTimeZoneRule.dateTimeRule)) {
            return super.isEquivalentTo(timeZoneRule);
        }
        return false;
    }

    @Override // com.ibm.icu.util.TimeZoneRule
    public boolean isTransitionRule() {
        return true;
    }

    @Override // com.ibm.icu.util.TimeZoneRule
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(", rule={" + String.valueOf(this.dateTimeRule) + "}");
        sb.append(", startYear=" + this.startYear);
        sb.append(", endYear=");
        int i = this.endYear;
        if (i == Integer.MAX_VALUE) {
            sb.append("max");
        } else {
            sb.append(i);
        }
        return sb.toString();
    }
}
