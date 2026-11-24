package com.ibm.icu.util;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
final class STZInfo implements Serializable {
    private static final long serialVersionUID = -7849612037842370168L;
    boolean ea;
    int edm;
    int edw;
    int edwm;
    int et;
    boolean sa;
    int sdm;
    int sdw;
    int sdwm;
    int st;
    int sy = -1;
    int sm = -1;
    int em = -1;

    public void applyTo(SimpleTimeZone simpleTimeZone) {
        SimpleTimeZone simpleTimeZone2;
        int i = this.sy;
        if (i != -1) {
            simpleTimeZone.setStartYear(i);
        }
        int i2 = this.sm;
        if (i2 == -1) {
            simpleTimeZone2 = simpleTimeZone;
        } else {
            int i3 = this.sdm;
            if (i3 == -1) {
                simpleTimeZone.setStartRule(i2, this.sdwm, this.sdw, this.st);
            } else {
                int i4 = this.sdw;
                int i5 = this.st;
                if (i4 == -1) {
                    simpleTimeZone.setStartRule(i2, i3, i5);
                } else {
                    simpleTimeZone2 = simpleTimeZone;
                    simpleTimeZone2.setStartRule(i2, i3, i4, i5, this.sa);
                }
            }
            simpleTimeZone2 = simpleTimeZone;
        }
        int i6 = this.em;
        if (i6 != -1) {
            int i7 = this.edm;
            if (i7 == -1) {
                simpleTimeZone2.setEndRule(i6, this.edwm, this.edw, this.et);
                return;
            }
            int i8 = this.edw;
            int i9 = this.et;
            if (i8 == -1) {
                simpleTimeZone2.setEndRule(i6, i7, i9);
            } else {
                simpleTimeZone2.setEndRule(i6, i7, i8, i9, this.ea);
            }
        }
    }

    public void setEnd(int i, int i2, int i3, int i4, int i5, boolean z) {
        this.em = i;
        this.edwm = i2;
        this.edw = i3;
        this.et = i4;
        this.edm = i5;
        this.ea = z;
    }

    public void setStart(int i, int i2, int i3, int i4, int i5, boolean z) {
        this.sm = i;
        this.sdwm = i2;
        this.sdw = i3;
        this.st = i4;
        this.sdm = i5;
        this.sa = z;
    }
}
