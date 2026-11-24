package com.ibm.icu.util;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class TimeZoneTransition {
    private final TimeZoneRule from;
    private final long time;
    private final TimeZoneRule to;

    public TimeZoneTransition(long j, TimeZoneRule timeZoneRule, TimeZoneRule timeZoneRule2) {
        this.time = j;
        this.from = timeZoneRule;
        this.to = timeZoneRule2;
    }

    public TimeZoneRule getFrom() {
        return this.from;
    }

    public long getTime() {
        return this.time;
    }

    public TimeZoneRule getTo() {
        return this.to;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("time=" + this.time);
        sb.append(", from={" + String.valueOf(this.from) + "}");
        sb.append(", to={" + String.valueOf(this.to) + "}");
        return sb.toString();
    }
}
