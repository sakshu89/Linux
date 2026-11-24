package com.ibm.icu.util;

import java.util.Date;
import java.util.Locale;
import java.util.MissingResourceException;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class Holiday implements DateRule {
    private static Holiday[] noHolidays = new Holiday[0];
    private String name;
    private DateRule rule;

    public Holiday(String str, DateRule dateRule) {
        this.name = str;
        this.rule = dateRule;
    }

    public static Holiday[] getHolidays(ULocale uLocale) {
        try {
            return (Holiday[]) UResourceBundle.getBundleInstance("com.ibm.icu.impl.data.HolidayBundle", uLocale).getObject("holidays");
        } catch (MissingResourceException unused) {
            return noHolidays;
        }
    }

    @Override // com.ibm.icu.util.DateRule
    public Date firstAfter(Date date) {
        return this.rule.firstAfter(date);
    }

    @Override // com.ibm.icu.util.DateRule
    public Date firstBetween(Date date, Date date2) {
        return this.rule.firstBetween(date, date2);
    }

    public String getDisplayName(ULocale uLocale) {
        try {
            return UResourceBundle.getBundleInstance("com.ibm.icu.impl.data.HolidayBundle", uLocale).getString(this.name);
        } catch (MissingResourceException unused) {
            return this.name;
        }
    }

    public DateRule getRule() {
        return this.rule;
    }

    @Override // com.ibm.icu.util.DateRule
    public boolean isBetween(Date date, Date date2) {
        return this.rule.isBetween(date, date2);
    }

    @Override // com.ibm.icu.util.DateRule
    public boolean isOn(Date date) {
        return this.rule.isOn(date);
    }

    public void setRule(DateRule dateRule) {
        this.rule = dateRule;
    }

    public String getDisplayName(Locale locale) {
        return getDisplayName(ULocale.forLocale(locale));
    }

    public String getDisplayName() {
        return getDisplayName(ULocale.getDefault(ULocale.Category.DISPLAY));
    }

    public static Holiday[] getHolidays(Locale locale) {
        return getHolidays(ULocale.forLocale(locale));
    }

    public static Holiday[] getHolidays() {
        return getHolidays(ULocale.getDefault(ULocale.Category.FORMAT));
    }
}
