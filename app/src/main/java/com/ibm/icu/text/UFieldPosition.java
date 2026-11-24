package com.ibm.icu.text;

import java.text.FieldPosition;
import java.text.Format;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class UFieldPosition extends FieldPosition {
    private int countVisibleFractionDigits;
    private long fractionDigits;

    @Deprecated
    public UFieldPosition() {
        super(-1);
        this.countVisibleFractionDigits = -1;
        this.fractionDigits = 0L;
    }

    @Deprecated
    public int getCountVisibleFractionDigits() {
        return this.countVisibleFractionDigits;
    }

    @Deprecated
    public long getFractionDigits() {
        return this.fractionDigits;
    }

    @Deprecated
    public void setFractionDigits(int i, long j) {
        this.countVisibleFractionDigits = i;
        this.fractionDigits = j;
    }

    @Deprecated
    public UFieldPosition(int i) {
        super(i);
        this.countVisibleFractionDigits = -1;
        this.fractionDigits = 0L;
    }

    @Deprecated
    public UFieldPosition(Format.Field field, int i) {
        super(field, i);
        this.countVisibleFractionDigits = -1;
        this.fractionDigits = 0L;
    }

    @Deprecated
    public UFieldPosition(Format.Field field) {
        super(field);
        this.countVisibleFractionDigits = -1;
        this.fractionDigits = 0L;
    }
}
