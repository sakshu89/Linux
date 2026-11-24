package com.ibm.icu.impl;

import com.ibm.icu.lang.UCharacter;
import com.ibm.icu.text.BreakIterator;
import com.ibm.icu.text.DateFormat;
import com.ibm.icu.text.DisplayContext;
import com.ibm.icu.text.MessageFormat;
import com.ibm.icu.text.SimpleDateFormat;
import com.ibm.icu.util.Calendar;
import com.ibm.icu.util.TimeZone;
import com.ibm.icu.util.ULocale;
import com.ibm.icu.util.UResourceBundle;
import defpackage.cq;
import defpackage.og;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.MissingResourceException;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class RelativeDateFormat extends DateFormat {
    private static final long serialVersionUID = 1131984966440549435L;
    private MessageFormat fCombinedFormat;
    private DateFormat fDateFormat;
    private String fDatePattern;
    int fDateStyle;
    private SimpleDateFormat fDateTimeFormat;
    ULocale fLocale;
    private DateFormat fTimeFormat;
    private String fTimePattern;
    int fTimeStyle;
    private transient List<URelativeString> fDates = null;
    private boolean combinedFormatHasDateAtStart = false;
    private boolean capitalizationInfoIsSet = false;
    private boolean capitalizationOfRelativeUnitsForListOrMenu = false;
    private boolean capitalizationOfRelativeUnitsForStandAlone = false;
    private transient BreakIterator capitalizationBrkIter = null;

    public RelativeDateFormat(int i, int i2, ULocale uLocale, Calendar calendar) {
        this.fDateTimeFormat = null;
        this.fDatePattern = null;
        this.fTimePattern = null;
        this.calendar = calendar;
        this.fLocale = uLocale;
        this.fTimeStyle = i;
        this.fDateStyle = i2;
        if (i2 != -1) {
            DateFormat dateInstance = DateFormat.getDateInstance(i2 & (-129), uLocale);
            if (!(dateInstance instanceof SimpleDateFormat)) {
                og.i("Can't create SimpleDateFormat for date style");
                throw null;
            }
            SimpleDateFormat simpleDateFormat = (SimpleDateFormat) dateInstance;
            this.fDateTimeFormat = simpleDateFormat;
            this.fDatePattern = simpleDateFormat.toPattern();
            int i3 = this.fTimeStyle;
            if (i3 != -1) {
                DateFormat timeInstance = DateFormat.getTimeInstance(i3 & (-129), uLocale);
                if (timeInstance instanceof SimpleDateFormat) {
                    this.fTimePattern = ((SimpleDateFormat) timeInstance).toPattern();
                }
            }
        } else {
            DateFormat timeInstance2 = DateFormat.getTimeInstance(i & (-129), uLocale);
            if (!(timeInstance2 instanceof SimpleDateFormat)) {
                og.i("Can't create SimpleDateFormat for time style");
                throw null;
            }
            SimpleDateFormat simpleDateFormat2 = (SimpleDateFormat) timeInstance2;
            this.fDateTimeFormat = simpleDateFormat2;
            this.fTimePattern = simpleDateFormat2.toPattern();
        }
        initializeCalendar(null, this.fLocale);
        loadDates();
        initializeCombinedFormat(this.calendar, this.fLocale);
    }

    private static int dayDifference(Calendar calendar) {
        Calendar calendarMo22clone = calendar.mo22clone();
        Date date = new Date(System.currentTimeMillis());
        calendarMo22clone.clear();
        calendarMo22clone.setTime(date);
        return calendar.get(20) - calendarMo22clone.get(20);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getStringForDay(int i) {
        if (this.fDates == null) {
            loadDates();
        }
        for (URelativeString uRelativeString : this.fDates) {
            if (uRelativeString.offset == i) {
                return uRelativeString.string;
            }
        }
        return null;
    }

    private void initCapitalizationContextInfo(ULocale uLocale) {
        try {
            int[] intVector = ((ICUResourceBundle) UResourceBundle.getBundleInstance(ICUData.ICU_BASE_NAME, uLocale)).getWithFallback("contextTransforms/relative").getIntVector();
            if (intVector.length >= 2) {
                this.capitalizationOfRelativeUnitsForListOrMenu = intVector[0] != 0;
                this.capitalizationOfRelativeUnitsForStandAlone = intVector[1] != 0;
            }
        } catch (MissingResourceException unused) {
        }
    }

    private Calendar initializeCalendar(TimeZone timeZone, ULocale uLocale) {
        if (this.calendar == null) {
            if (timeZone == null) {
                this.calendar = Calendar.getInstance(uLocale);
            } else {
                this.calendar = Calendar.getInstance(timeZone, uLocale);
            }
        }
        return this.calendar;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0060  */
    private MessageFormat initializeCombinedFormat(Calendar calendar, ULocale uLocale) {
        String string;
        int i;
        ICUResourceBundle iCUResourceBundle = (ICUResourceBundle) UResourceBundle.getBundleInstance(ICUData.ICU_BASE_NAME, uLocale);
        ICUResourceBundle iCUResourceBundleFindWithFallback = iCUResourceBundle.findWithFallback("calendar/" + calendar.getType() + "/DateTimePatterns");
        if (iCUResourceBundleFindWithFallback == null && !calendar.getType().equals("gregorian")) {
            iCUResourceBundleFindWithFallback = iCUResourceBundle.findWithFallback("calendar/gregorian/DateTimePatterns");
        }
        if (iCUResourceBundleFindWithFallback == null || iCUResourceBundleFindWithFallback.getSize() < 9) {
            string = "{1} {0}";
        } else {
            if (iCUResourceBundleFindWithFallback.getSize() < 13) {
                i = 8;
            } else {
                int i2 = this.fDateStyle;
                if (i2 >= 0 && i2 <= 3) {
                    i = i2 + 9;
                } else if (i2 < 128 || i2 > 131) {
                    i = 8;
                } else {
                    i = i2 - 119;
                }
            }
            string = iCUResourceBundleFindWithFallback.get(i).getType() == 8 ? iCUResourceBundleFindWithFallback.get(i).getString(0) : iCUResourceBundleFindWithFallback.getString(i);
        }
        this.combinedFormatHasDateAtStart = string.startsWith("{1}");
        MessageFormat messageFormat = new MessageFormat(string, uLocale);
        this.fCombinedFormat = messageFormat;
        return messageFormat;
    }

    private synchronized void loadDates() {
        ICUResourceBundle iCUResourceBundle = (ICUResourceBundle) UResourceBundle.getBundleInstance(ICUData.ICU_BASE_NAME, this.fLocale);
        this.fDates = new ArrayList();
        iCUResourceBundle.getAllItemsWithFallback("fields/day/relative", new RelDateFmtDataSink(this, 0));
    }

    @Override // com.ibm.icu.text.DateFormat
    public StringBuffer format(Calendar calendar, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        String strV;
        DisplayContext context = getContext(DisplayContext.Type.CAPITALIZATION);
        String stringForDay = this.fDateStyle != -1 ? getStringForDay(dayDifference(calendar)) : null;
        SimpleDateFormat simpleDateFormat = this.fDateTimeFormat;
        if (simpleDateFormat != null) {
            if (stringForDay == null || this.fDatePattern == null || !(this.fTimePattern == null || this.fCombinedFormat == null || this.combinedFormatHasDateAtStart)) {
                simpleDateFormat.setContext(context);
            } else {
                if (stringForDay.length() > 0 && UCharacter.isLowerCase(stringForDay.codePointAt(0)) && (context == DisplayContext.CAPITALIZATION_FOR_BEGINNING_OF_SENTENCE || ((context == DisplayContext.CAPITALIZATION_FOR_UI_LIST_OR_MENU && this.capitalizationOfRelativeUnitsForListOrMenu) || (context == DisplayContext.CAPITALIZATION_FOR_STANDALONE && this.capitalizationOfRelativeUnitsForStandAlone)))) {
                    if (this.capitalizationBrkIter == null) {
                        this.capitalizationBrkIter = BreakIterator.getSentenceInstance(this.fLocale);
                    }
                    stringForDay = UCharacter.toTitleCase(this.fLocale, stringForDay, this.capitalizationBrkIter, 768);
                }
                this.fDateTimeFormat.setContext(DisplayContext.CAPITALIZATION_NONE);
            }
        }
        SimpleDateFormat simpleDateFormat2 = this.fDateTimeFormat;
        if (simpleDateFormat2 == null || ((strV = this.fDatePattern) == null && this.fTimePattern == null)) {
            DateFormat dateFormat = this.fDateFormat;
            if (dateFormat != null) {
                if (stringForDay != null) {
                    stringBuffer.append(stringForDay);
                    return stringBuffer;
                }
                dateFormat.format(calendar, stringBuffer, fieldPosition);
            }
            return stringBuffer;
        }
        String str = this.fTimePattern;
        if (strV == null) {
            simpleDateFormat2.applyPattern(str);
            this.fDateTimeFormat.format(calendar, stringBuffer, fieldPosition);
            return stringBuffer;
        }
        if (str == null) {
            if (stringForDay != null) {
                stringBuffer.append(stringForDay);
                return stringBuffer;
            }
            simpleDateFormat2.applyPattern(strV);
            this.fDateTimeFormat.format(calendar, stringBuffer, fieldPosition);
            return stringBuffer;
        }
        if (stringForDay != null) {
            strV = cq.v("'", stringForDay.replace("'", "''"), "'");
        }
        StringBuffer stringBuffer2 = new StringBuffer("");
        this.fCombinedFormat.format(new Object[]{this.fTimePattern, strV}, stringBuffer2, new FieldPosition(0));
        this.fDateTimeFormat.applyPattern(stringBuffer2.toString());
        this.fDateTimeFormat.format(calendar, stringBuffer, fieldPosition);
        return stringBuffer;
    }

    @Override // com.ibm.icu.text.DateFormat
    public void parse(String str, Calendar calendar, ParsePosition parsePosition) {
        throw new UnsupportedOperationException("Relative Date parse is not implemented yet");
    }

    @Override // com.ibm.icu.text.DateFormat
    public void setContext(DisplayContext displayContext) {
        super.setContext(displayContext);
        if (!this.capitalizationInfoIsSet && (displayContext == DisplayContext.CAPITALIZATION_FOR_UI_LIST_OR_MENU || displayContext == DisplayContext.CAPITALIZATION_FOR_STANDALONE)) {
            initCapitalizationContextInfo(this.fLocale);
            this.capitalizationInfoIsSet = true;
        }
        if (this.capitalizationBrkIter == null) {
            if (displayContext == DisplayContext.CAPITALIZATION_FOR_BEGINNING_OF_SENTENCE || ((displayContext == DisplayContext.CAPITALIZATION_FOR_UI_LIST_OR_MENU && this.capitalizationOfRelativeUnitsForListOrMenu) || (displayContext == DisplayContext.CAPITALIZATION_FOR_STANDALONE && this.capitalizationOfRelativeUnitsForStandAlone))) {
                this.capitalizationBrkIter = BreakIterator.getSentenceInstance(this.fLocale);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public final class RelDateFmtDataSink extends UResource.Sink {
        private RelDateFmtDataSink() {
        }

        @Override // com.ibm.icu.impl.UResource.Sink
        public void put(UResource.Key key, UResource.Value value, boolean z) {
            if (value.getType() == 3) {
                return;
            }
            UResource.Table table = value.getTable();
            for (int i = 0; table.getKeyAndValue(i, key, value); i++) {
                try {
                    int i2 = Integer.parseInt(key.toString());
                    if (RelativeDateFormat.this.getStringForDay(i2) == null) {
                        RelativeDateFormat.this.fDates.add(new URelativeString(i2, value.getString()));
                    }
                } catch (NumberFormatException unused) {
                    return;
                }
            }
        }

        public /* synthetic */ RelDateFmtDataSink(RelativeDateFormat relativeDateFormat, int i) {
            this();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class URelativeString {
        public int offset;
        public String string;

        public URelativeString(String str, String str2) {
            this.offset = Integer.parseInt(str);
            this.string = str2;
        }

        public URelativeString(int i, String str) {
            this.offset = i;
            this.string = str;
        }
    }
}
