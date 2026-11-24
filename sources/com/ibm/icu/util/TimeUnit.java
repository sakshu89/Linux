package com.ibm.icu.util;

import defpackage.kf2;
import defpackage.ky0;
import java.io.InvalidObjectException;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class TimeUnit extends MeasureUnit {
    private static final long serialVersionUID = -2839973855554750484L;
    private final int index;

    public TimeUnit(String str, String str2) {
        super(str, str2);
        this.index = 0;
    }

    private Object readResolve() throws InvalidObjectException {
        int i = this.index;
        switch (i) {
            case 0:
                return MeasureUnit.YEAR;
            case 1:
                return MeasureUnit.MONTH;
            case 2:
                return MeasureUnit.WEEK;
            case 3:
                return MeasureUnit.DAY;
            case 4:
                return MeasureUnit.HOUR;
            case 5:
                return MeasureUnit.MINUTE;
            case 6:
                return MeasureUnit.SECOND;
            default:
                kf2.i(ky0.h(i, "Bad index: "));
                return null;
        }
    }

    public static TimeUnit[] values() {
        return new TimeUnit[]{MeasureUnit.SECOND, MeasureUnit.MINUTE, MeasureUnit.HOUR, MeasureUnit.DAY, MeasureUnit.WEEK, MeasureUnit.MONTH, MeasureUnit.YEAR};
    }

    private Object writeReplace() {
        return new MeasureUnit.MeasureUnitProxy(this.type, this.subType);
    }
}
