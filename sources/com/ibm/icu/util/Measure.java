package com.ibm.icu.util;

import com.ibm.icu.impl.number.Padder;
import defpackage.cq;
import defpackage.dk0;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class Measure {
    private final Number number;
    private final MeasureUnit unit;

    public Measure(Number number, MeasureUnit measureUnit) {
        if (number == null || measureUnit == null) {
            dk0.n("Number and MeasureUnit must not be null");
            throw null;
        }
        this.number = number;
        this.unit = measureUnit;
    }

    private static boolean numbersEqual(Number number, Number number2) {
        return number.equals(number2) || number.doubleValue() == number2.doubleValue();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Measure)) {
            return false;
        }
        Measure measure = (Measure) obj;
        return this.unit.equals(measure.unit) && numbersEqual(this.number, measure.number);
    }

    public Number getNumber() {
        return this.number;
    }

    public MeasureUnit getUnit() {
        return this.unit;
    }

    public int hashCode() {
        return this.unit.hashCode() + (Double.valueOf(this.number.doubleValue()).hashCode() * 31);
    }

    public String toString() {
        return cq.k(this.number.toString(), Padder.FALLBACK_PADDING_STRING, this.unit.toString());
    }
}
