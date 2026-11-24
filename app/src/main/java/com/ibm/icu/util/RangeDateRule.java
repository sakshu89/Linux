package com.ibm.icu.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class RangeDateRule implements DateRule {
    List<Range> ranges = new ArrayList(2);

    private Range rangeAt(int i) {
        if (i < this.ranges.size()) {
            return this.ranges.get(i);
        }
        return null;
    }

    private int startIndex(Date date) {
        int i;
        int size = this.ranges.size();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            i = size;
            size = i3;
            if (size >= this.ranges.size() || date.before(this.ranges.get(size).start)) {
                break;
            }
            i2 = size + 1;
        }
        return i;
    }

    public void add(DateRule dateRule) {
        add(new Date(Long.MIN_VALUE), dateRule);
    }

    @Override // com.ibm.icu.util.DateRule
    public Date firstAfter(Date date) {
        DateRule dateRule;
        int iStartIndex = startIndex(date);
        if (iStartIndex == this.ranges.size()) {
            iStartIndex = 0;
        }
        Range rangeRangeAt = rangeAt(iStartIndex);
        Range rangeRangeAt2 = rangeAt(iStartIndex + 1);
        if (rangeRangeAt == null || (dateRule = rangeRangeAt.rule) == null) {
            return null;
        }
        return rangeRangeAt2 != null ? dateRule.firstBetween(date, rangeRangeAt2.start) : dateRule.firstAfter(date);
    }

    @Override // com.ibm.icu.util.DateRule
    public Date firstBetween(Date date, Date date2) {
        if (date2 == null) {
            return firstAfter(date);
        }
        int iStartIndex = startIndex(date);
        Range rangeRangeAt = rangeAt(iStartIndex);
        Date dateFirstBetween = null;
        while (dateFirstBetween == null && rangeRangeAt != null && !rangeRangeAt.start.after(date2)) {
            Range rangeRangeAt2 = rangeAt(iStartIndex + 1);
            if (rangeRangeAt.rule != null) {
                dateFirstBetween = rangeRangeAt.rule.firstBetween(date, (rangeRangeAt2 == null || rangeRangeAt2.start.after(date2)) ? date2 : rangeRangeAt2.start);
            }
            rangeRangeAt = rangeRangeAt2;
        }
        return dateFirstBetween;
    }

    @Override // com.ibm.icu.util.DateRule
    public boolean isBetween(Date date, Date date2) {
        return firstBetween(date, date2) == null;
    }

    @Override // com.ibm.icu.util.DateRule
    public boolean isOn(Date date) {
        DateRule dateRule;
        Range rangeRangeAt = rangeAt(startIndex(date));
        return (rangeRangeAt == null || (dateRule = rangeRangeAt.rule) == null || !dateRule.isOn(date)) ? false : true;
    }

    public void add(Date date, DateRule dateRule) {
        this.ranges.add(new Range(date, dateRule));
    }
}
