package com.ibm.icu.impl;

import defpackage.cq;
import java.util.Date;
import java.util.TimeZone;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class TimeZoneAdapter extends TimeZone implements Cloneable {
    static final long serialVersionUID = -2040072218820018557L;
    private com.ibm.icu.util.TimeZone zone;

    public TimeZoneAdapter(com.ibm.icu.util.TimeZone timeZone) {
        this.zone = timeZone;
        super.setID(timeZone.getID());
    }

    public static TimeZone wrap(com.ibm.icu.util.TimeZone timeZone) {
        return new TimeZoneAdapter(timeZone);
    }

    @Override // java.util.TimeZone
    public TimeZoneAdapter clone() {
        return new TimeZoneAdapter(this.zone.mo3clone());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TimeZoneAdapter)) {
            return false;
        }
        return this.zone.equals(((TimeZoneAdapter) obj).zone);
    }

    @Override // java.util.TimeZone
    public int getOffset(int i, int i2, int i3, int i4, int i5, int i6) {
        return this.zone.getOffset(i, i2, i3, i4, i5, i6);
    }

    @Override // java.util.TimeZone
    public int getRawOffset() {
        return this.zone.getRawOffset();
    }

    @Override // java.util.TimeZone
    public boolean hasSameRules(TimeZone timeZone) {
        return (timeZone instanceof TimeZoneAdapter) && this.zone.hasSameRules(((TimeZoneAdapter) timeZone).zone);
    }

    public synchronized int hashCode() {
        return this.zone.hashCode();
    }

    @Override // java.util.TimeZone
    public boolean inDaylightTime(Date date) {
        return this.zone.inDaylightTime(date);
    }

    @Override // java.util.TimeZone
    public void setID(String str) {
        super.setID(str);
        this.zone.setID(str);
    }

    @Override // java.util.TimeZone
    public void setRawOffset(int i) {
        this.zone.setRawOffset(i);
    }

    public String toString() {
        return cq.j("TimeZoneAdapter: ", this.zone.toString());
    }

    public com.ibm.icu.util.TimeZone unwrap() {
        return this.zone;
    }

    @Override // java.util.TimeZone
    public boolean useDaylightTime() {
        return this.zone.useDaylightTime();
    }
}
