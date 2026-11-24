package com.ibm.icu.util;

import java.io.Serializable;
import java.util.Date;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class TimeZoneRule implements Serializable {
    private static final long serialVersionUID = 6374143828553768100L;
    private final int dstSavings;
    private final String name;
    private final int rawOffset;

    public TimeZoneRule(String str, int i, int i2) {
        this.name = str;
        this.rawOffset = i;
        this.dstSavings = i2;
    }

    public int getDSTSavings() {
        return this.dstSavings;
    }

    public abstract Date getFinalStart(int i, int i2);

    public abstract Date getFirstStart(int i, int i2);

    public String getName() {
        return this.name;
    }

    public abstract Date getNextStart(long j, int i, int i2, boolean z);

    public abstract Date getPreviousStart(long j, int i, int i2, boolean z);

    public int getRawOffset() {
        return this.rawOffset;
    }

    public boolean isEquivalentTo(TimeZoneRule timeZoneRule) {
        return this.rawOffset == timeZoneRule.rawOffset && this.dstSavings == timeZoneRule.dstSavings;
    }

    public abstract boolean isTransitionRule();

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("name=" + this.name);
        sb.append(", stdOffset=" + this.rawOffset);
        sb.append(", dstSaving=" + this.dstSavings);
        return sb.toString();
    }
}
