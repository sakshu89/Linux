package com.ibm.icu.impl;

import com.ibm.icu.text.TimeZoneNames;
import com.ibm.icu.util.ULocale;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class TimeZoneNamesFactoryImpl extends TimeZoneNames.Factory {
    @Override // com.ibm.icu.text.TimeZoneNames.Factory
    public TimeZoneNames getTimeZoneNames(ULocale uLocale) {
        return new TimeZoneNamesImpl(uLocale);
    }
}
