package com.ibm.icu.text;

import com.ibm.icu.impl.ICUResourceBundle;
import com.ibm.icu.util.Calendar;
import com.ibm.icu.util.ChineseCalendar;
import com.ibm.icu.util.ULocale;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class ChineseDateFormatSymbols extends DateFormatSymbols {
    static final long serialVersionUID = 6827816119783952890L;
    String[] isLeapMonth;

    @Deprecated
    public ChineseDateFormatSymbols() {
        this(ULocale.getDefault(ULocale.Category.FORMAT));
    }

    private void initializeIsLeapMonth() {
        String[] strArr = new String[2];
        this.isLeapMonth = strArr;
        strArr[0] = "";
        String[] strArr2 = this.leapMonthPatterns;
        strArr[1] = strArr2 != null ? strArr2[0].replace("{0}", "") : "";
    }

    @Deprecated
    public String getLeapMonth(int i) {
        return this.isLeapMonth[i];
    }

    @Override // com.ibm.icu.text.DateFormatSymbols
    public void initializeData(DateFormatSymbols dateFormatSymbols) {
        super.initializeData(dateFormatSymbols);
        if (dateFormatSymbols instanceof ChineseDateFormatSymbols) {
            this.isLeapMonth = ((ChineseDateFormatSymbols) dateFormatSymbols).isLeapMonth;
        } else {
            initializeIsLeapMonth();
        }
    }

    @Deprecated
    public ChineseDateFormatSymbols(Locale locale) {
        super((Class<? extends Calendar>) ChineseCalendar.class, ULocale.forLocale(locale));
    }

    @Deprecated
    public ChineseDateFormatSymbols(ULocale uLocale) {
        super((Class<? extends Calendar>) ChineseCalendar.class, uLocale);
    }

    @Deprecated
    public ChineseDateFormatSymbols(Calendar calendar, Locale locale) {
        super((Class<? extends Calendar>) calendar.getClass(), locale);
    }

    @Deprecated
    public ChineseDateFormatSymbols(Calendar calendar, ULocale uLocale) {
        super((Class<? extends Calendar>) calendar.getClass(), uLocale);
    }

    @Override // com.ibm.icu.text.DateFormatSymbols
    @Deprecated
    public void initializeData(ULocale uLocale, ICUResourceBundle iCUResourceBundle, String str) {
        super.initializeData(uLocale, iCUResourceBundle, str);
        initializeIsLeapMonth();
    }
}
