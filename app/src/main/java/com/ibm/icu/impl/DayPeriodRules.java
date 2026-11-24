package com.ibm.icu.impl;

import com.ibm.icu.util.ULocale;
import defpackage.dk0;
import defpackage.og;
import defpackage.y90;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class DayPeriodRules {
    private static final DayPeriodRulesData DATA = loadData();
    private DayPeriod[] dayPeriodForHour;
    private boolean hasMidnight;
    private boolean hasNoon;

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public enum CutoffType {
        BEFORE,
        AFTER,
        FROM,
        AT;

        /* JADX INFO: Access modifiers changed from: private */
        public static CutoffType fromStringOrNull(CharSequence charSequence) {
            if ("from".contentEquals(charSequence)) {
                return FROM;
            }
            if ("before".contentEquals(charSequence)) {
                return BEFORE;
            }
            if ("after".contentEquals(charSequence)) {
                return AFTER;
            }
            if ("at".contentEquals(charSequence)) {
                return AT;
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public enum DayPeriod {
        MIDNIGHT,
        NOON,
        MORNING1,
        AFTERNOON1,
        EVENING1,
        NIGHT1,
        MORNING2,
        AFTERNOON2,
        EVENING2,
        NIGHT2,
        AM,
        PM;

        public static DayPeriod[] VALUES = values();

        /* JADX INFO: Access modifiers changed from: private */
        public static DayPeriod fromStringOrNull(CharSequence charSequence) {
            if ("midnight".contentEquals(charSequence)) {
                return MIDNIGHT;
            }
            if ("noon".contentEquals(charSequence)) {
                return NOON;
            }
            if ("morning1".contentEquals(charSequence)) {
                return MORNING1;
            }
            if ("afternoon1".contentEquals(charSequence)) {
                return AFTERNOON1;
            }
            if ("evening1".contentEquals(charSequence)) {
                return EVENING1;
            }
            if ("night1".contentEquals(charSequence)) {
                return NIGHT1;
            }
            if ("morning2".contentEquals(charSequence)) {
                return MORNING2;
            }
            if ("afternoon2".contentEquals(charSequence)) {
                return AFTERNOON2;
            }
            if ("evening2".contentEquals(charSequence)) {
                return EVENING2;
            }
            if ("night2".contentEquals(charSequence)) {
                return NIGHT2;
            }
            if ("am".contentEquals(charSequence)) {
                return AM;
            }
            if ("pm".contentEquals(charSequence)) {
                return PM;
            }
            return null;
        }
    }

    private DayPeriodRules() {
        this.hasMidnight = false;
        this.hasNoon = false;
        this.dayPeriodForHour = new DayPeriod[24];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void add(int i, int i2, DayPeriod dayPeriod) {
        while (i != i2) {
            if (i == 24) {
                i = 0;
            }
            this.dayPeriodForHour[i] = dayPeriod;
            i++;
        }
    }

    private static void deduplicateDayPeriodRulesData(DayPeriodRulesData dayPeriodRulesData) {
        DayPeriod[] dayPeriodArr;
        HashMap map = new HashMap();
        int i = 0;
        for (DayPeriodRules dayPeriodRules : dayPeriodRulesData.rules) {
            if (dayPeriodRules != null && (dayPeriodArr = dayPeriodRules.dayPeriodForHour) != null) {
                ArrayList arrayList = new ArrayList(dayPeriodArr.length);
                for (DayPeriod dayPeriod : dayPeriodArr) {
                    Objects.requireNonNull(dayPeriod);
                    arrayList.add(dayPeriod);
                }
                dayPeriodRules.dayPeriodForHour = (DayPeriod[]) map.computeIfAbsent(Collections.unmodifiableList(arrayList), new y90(i, dayPeriodArr));
            }
        }
    }

    private int getEndHourForDayPeriod(DayPeriod dayPeriod) {
        if (dayPeriod == DayPeriod.MIDNIGHT) {
            return 0;
        }
        if (dayPeriod == DayPeriod.NOON) {
            return 12;
        }
        DayPeriod[] dayPeriodArr = this.dayPeriodForHour;
        if (dayPeriodArr[0] == dayPeriod && dayPeriodArr[23] == dayPeriod) {
            for (int i = 1; i <= 22; i++) {
                if (this.dayPeriodForHour[i] != dayPeriod) {
                    return i;
                }
            }
        } else {
            for (int i2 = 23; i2 >= 0; i2--) {
                if (this.dayPeriodForHour[i2] == dayPeriod) {
                    return i2 + 1;
                }
            }
        }
        dk0.v();
        return 0;
    }

    public static DayPeriodRules getInstance(ULocale uLocale) {
        String baseName = uLocale.getBaseName();
        if (baseName.isEmpty()) {
            baseName = "root";
        }
        Integer num = null;
        while (num == null) {
            num = DATA.localesToRuleSetNumMap.get(baseName);
            if (num != null || baseName.equals("root")) {
                break;
            }
            baseName = ULocale.getFallback(baseName);
            if (baseName.isEmpty()) {
                baseName = "root";
            }
        }
        if (num != null) {
            DayPeriodRulesData dayPeriodRulesData = DATA;
            if (dayPeriodRulesData.rules[num.intValue()] != null) {
                return dayPeriodRulesData.rules[num.intValue()];
            }
        }
        return null;
    }

    private int getStartHourForDayPeriod(DayPeriod dayPeriod) {
        if (dayPeriod == DayPeriod.MIDNIGHT) {
            return 0;
        }
        if (dayPeriod == DayPeriod.NOON) {
            return 12;
        }
        DayPeriod[] dayPeriodArr = this.dayPeriodForHour;
        if (dayPeriodArr[0] == dayPeriod && dayPeriodArr[23] == dayPeriod) {
            for (int i = 22; i >= 1; i--) {
                if (this.dayPeriodForHour[i] != dayPeriod) {
                    return i + 1;
                }
            }
        } else {
            for (int i2 = 0; i2 <= 23; i2++) {
                if (this.dayPeriodForHour[i2] == dayPeriod) {
                    return i2;
                }
            }
        }
        dk0.v();
        return 0;
    }

    private static DayPeriodRulesData loadData() {
        int i = 0;
        DayPeriodRulesData dayPeriodRulesData = new DayPeriodRulesData(i);
        ICUResourceBundle bundleInstance = ICUResourceBundle.getBundleInstance(ICUData.ICU_BASE_NAME, "dayPeriods", ICUResourceBundle.ICU_DATA_CLASS_LOADER, true);
        bundleInstance.getAllItemsWithFallback("rules", new DayPeriodRulesCountSink(dayPeriodRulesData, i));
        dayPeriodRulesData.rules = new DayPeriodRules[dayPeriodRulesData.maxRuleSetNum + 1];
        bundleInstance.getAllItemsWithFallback("", new DayPeriodRulesDataSink(dayPeriodRulesData, i));
        deduplicateDayPeriodRulesData(dayPeriodRulesData);
        return dayPeriodRulesData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int parseSetNum(String str) {
        if (str.startsWith("set")) {
            return Integer.parseInt(str.substring(3));
        }
        og.q("Set number should start with \"set\".");
        return 0;
    }

    public DayPeriod getDayPeriodForHour(int i) {
        return this.dayPeriodForHour[i];
    }

    public double getMidPointForDayPeriod(DayPeriod dayPeriod) {
        int startHourForDayPeriod = getStartHourForDayPeriod(dayPeriod);
        int endHourForDayPeriod = getEndHourForDayPeriod(dayPeriod);
        double d = ((double) (startHourForDayPeriod + endHourForDayPeriod)) / 2.0d;
        if (startHourForDayPeriod <= endHourForDayPeriod) {
            return d;
        }
        double d2 = d + 12.0d;
        return d2 >= 24.0d ? d2 - 24.0d : d2;
    }

    public boolean hasMidnight() {
        return this.hasMidnight;
    }

    public boolean hasNoon() {
        return this.hasNoon;
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class DayPeriodRulesCountSink extends UResource.Sink {
        private DayPeriodRulesData data;

        private DayPeriodRulesCountSink(DayPeriodRulesData dayPeriodRulesData) {
            this.data = dayPeriodRulesData;
        }

        @Override // com.ibm.icu.impl.UResource.Sink
        public void put(UResource.Key key, UResource.Value value, boolean z) {
            UResource.Table table = value.getTable();
            for (int i = 0; table.getKeyAndValue(i, key, value); i++) {
                int setNum = DayPeriodRules.parseSetNum(key.toString());
                DayPeriodRulesData dayPeriodRulesData = this.data;
                if (setNum > dayPeriodRulesData.maxRuleSetNum) {
                    dayPeriodRulesData.maxRuleSetNum = setNum;
                }
            }
        }

        public /* synthetic */ DayPeriodRulesCountSink(DayPeriodRulesData dayPeriodRulesData, int i) {
            this(dayPeriodRulesData);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class DayPeriodRulesDataSink extends UResource.Sink {
        private CutoffType cutoffType;
        private int[] cutoffs;
        private DayPeriodRulesData data;
        private DayPeriod period;
        private int ruleSetNum;

        private DayPeriodRulesDataSink(DayPeriodRulesData dayPeriodRulesData) {
            this.cutoffs = new int[25];
            this.data = dayPeriodRulesData;
        }

        private void addCutoff(CutoffType cutoffType, String str) {
            if (cutoffType == null) {
                og.q("Cutoff type not recognized.");
                return;
            }
            int hour = parseHour(str);
            int[] iArr = this.cutoffs;
            iArr[hour] = (1 << cutoffType.ordinal()) | iArr[hour];
        }

        private static int parseHour(String str) {
            int iIndexOf = str.indexOf(58);
            if (iIndexOf < 0 || !str.substring(iIndexOf).equals(":00")) {
                og.q("Cutoff time must end in \":00\".");
                return 0;
            }
            String strSubstring = str.substring(0, iIndexOf);
            if (iIndexOf != 1 && iIndexOf != 2) {
                og.q("Cutoff time must begin with h: or hh:");
                return 0;
            }
            int i = Integer.parseInt(strSubstring);
            if (i >= 0 && i <= 24) {
                return i;
            }
            og.q("Cutoff hour must be between 0 and 24, inclusive.");
            return 0;
        }

        private void processRules(UResource.Table table, UResource.Key key, UResource.Value value) {
            int i = 0;
            for (int i2 = 0; table.getKeyAndValue(i2, key, value); i2++) {
                int setNum = DayPeriodRules.parseSetNum(key.toString());
                this.ruleSetNum = setNum;
                this.data.rules[setNum] = new DayPeriodRules(i);
                UResource.Table table2 = value.getTable();
                for (int i3 = 0; table2.getKeyAndValue(i3, key, value); i3++) {
                    DayPeriod dayPeriodFromStringOrNull = DayPeriod.fromStringOrNull(key);
                    this.period = dayPeriodFromStringOrNull;
                    if (dayPeriodFromStringOrNull == null) {
                        og.q("Unknown day period in data.");
                        return;
                    }
                    UResource.Table table3 = value.getTable();
                    for (int i4 = 0; table3.getKeyAndValue(i4, key, value); i4++) {
                        if (value.getType() == 0) {
                            addCutoff(CutoffType.fromStringOrNull(key), value.getString());
                        } else {
                            this.cutoffType = CutoffType.fromStringOrNull(key);
                            UResource.Array array = value.getArray();
                            int size = array.getSize();
                            for (int i5 = 0; i5 < size; i5++) {
                                array.getValue(i5, value);
                                addCutoff(this.cutoffType, value.getString());
                            }
                        }
                    }
                    setDayPeriodForHoursFromCutoffs();
                    int i6 = 0;
                    while (true) {
                        int[] iArr = this.cutoffs;
                        if (i6 < iArr.length) {
                            iArr[i6] = 0;
                            i6++;
                        }
                    }
                }
                for (DayPeriod dayPeriod : this.data.rules[this.ruleSetNum].dayPeriodForHour) {
                    if (dayPeriod == null) {
                        og.q("Rules in data don't cover all 24 hours (they should).");
                        return;
                    }
                }
            }
        }

        private void setDayPeriodForHoursFromCutoffs() {
            DayPeriodRules dayPeriodRules = this.data.rules[this.ruleSetNum];
            for (int i = 0; i <= 24; i++) {
                if ((this.cutoffs[i] & (1 << CutoffType.AT.ordinal())) > 0) {
                    if (i == 0 && this.period == DayPeriod.MIDNIGHT) {
                        dayPeriodRules.hasMidnight = true;
                    } else {
                        if (i != 12 || this.period != DayPeriod.NOON) {
                            og.q("AT cutoff must only be set for 0:00 or 12:00.");
                            return;
                        }
                        dayPeriodRules.hasNoon = true;
                    }
                }
                if ((this.cutoffs[i] & (1 << CutoffType.FROM.ordinal())) > 0 || (this.cutoffs[i] & (1 << CutoffType.AFTER.ordinal())) > 0) {
                    int i2 = i + 1;
                    while (true) {
                        if (i2 == i) {
                            og.q("FROM/AFTER cutoffs must have a matching BEFORE cutoff.");
                            return;
                        }
                        if (i2 == 25) {
                            i2 = 0;
                        }
                        if ((this.cutoffs[i2] & (1 << CutoffType.BEFORE.ordinal())) > 0) {
                            dayPeriodRules.add(i, i2, this.period);
                            break;
                        }
                        i2++;
                    }
                }
            }
        }

        @Override // com.ibm.icu.impl.UResource.Sink
        public void put(UResource.Key key, UResource.Value value, boolean z) {
            UResource.Table table = value.getTable();
            for (int i = 0; table.getKeyAndValue(i, key, value); i++) {
                if (key.contentEquals("locales")) {
                    UResource.Table table2 = value.getTable();
                    for (int i2 = 0; table2.getKeyAndValue(i2, key, value); i2++) {
                        this.data.localesToRuleSetNumMap.put(key.toString(), Integer.valueOf(DayPeriodRules.parseSetNum(value.getString())));
                    }
                } else if (key.contentEquals("rules")) {
                    processRules(value.getTable(), key, value);
                }
            }
        }

        public /* synthetic */ DayPeriodRulesDataSink(DayPeriodRulesData dayPeriodRulesData, int i) {
            this(dayPeriodRulesData);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class DayPeriodRulesData {
        Map<String, Integer> localesToRuleSetNumMap;
        int maxRuleSetNum;
        DayPeriodRules[] rules;

        private DayPeriodRulesData() {
            this.localesToRuleSetNumMap = new HashMap();
            this.maxRuleSetNum = -1;
        }

        public /* synthetic */ DayPeriodRulesData(int i) {
            this();
        }
    }

    public /* synthetic */ DayPeriodRules(int i) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ DayPeriod[] lambda$deduplicateDayPeriodRulesData$0(DayPeriod[] dayPeriodArr, List list) {
        return dayPeriodArr;
    }
}
