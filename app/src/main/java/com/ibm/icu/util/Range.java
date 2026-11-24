package com.ibm.icu.util;

import java.util.Date;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
class Range {
    public DateRule rule;
    public Date start;

    public Range(Date date, DateRule dateRule) {
        this.start = date;
        this.rule = dateRule;
    }
}
