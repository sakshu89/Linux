package com.ibm.icu.util;

import com.ibm.icu.impl.number.Padder;
import defpackage.cq;
import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class DateInterval implements Serializable {
    private static final long serialVersionUID = 1;
    private final long fromDate;
    private final long toDate;

    public DateInterval(long j, long j2) {
        this.fromDate = j;
        this.toDate = j2;
    }

    public boolean equals(Object obj) {
        if (obj instanceof DateInterval) {
            DateInterval dateInterval = (DateInterval) obj;
            if (this.fromDate == dateInterval.fromDate && this.toDate == dateInterval.toDate) {
                return true;
            }
        }
        return false;
    }

    public long getFromDate() {
        return this.fromDate;
    }

    public long getToDate() {
        return this.toDate;
    }

    public int hashCode() {
        return (int) (this.fromDate + this.toDate);
    }

    public String toString() {
        return cq.k(String.valueOf(this.fromDate), Padder.FALLBACK_PADDING_STRING, String.valueOf(this.toDate));
    }
}
