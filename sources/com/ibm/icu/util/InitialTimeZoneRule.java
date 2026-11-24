package com.ibm.icu.util;

import java.util.Date;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class InitialTimeZoneRule extends TimeZoneRule {
    private static final long serialVersionUID = 1876594993064051206L;

    public InitialTimeZoneRule(String str, int i, int i2) {
        super(str, i, i2);
    }

    @Override // com.ibm.icu.util.TimeZoneRule
    public Date getFinalStart(int i, int i2) {
        return null;
    }

    @Override // com.ibm.icu.util.TimeZoneRule
    public Date getFirstStart(int i, int i2) {
        return null;
    }

    @Override // com.ibm.icu.util.TimeZoneRule
    public Date getNextStart(long j, int i, int i2, boolean z) {
        return null;
    }

    @Override // com.ibm.icu.util.TimeZoneRule
    public Date getPreviousStart(long j, int i, int i2, boolean z) {
        return null;
    }

    @Override // com.ibm.icu.util.TimeZoneRule
    public boolean isEquivalentTo(TimeZoneRule timeZoneRule) {
        if (timeZoneRule instanceof InitialTimeZoneRule) {
            return super.isEquivalentTo(timeZoneRule);
        }
        return false;
    }

    @Override // com.ibm.icu.util.TimeZoneRule
    public boolean isTransitionRule() {
        return false;
    }
}
