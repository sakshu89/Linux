package com.ibm.icu.util;

import java.util.Date;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public interface DateRule {
    Date firstAfter(Date date);

    Date firstBetween(Date date, Date date2);

    boolean isBetween(Date date, Date date2);

    boolean isOn(Date date);
}
