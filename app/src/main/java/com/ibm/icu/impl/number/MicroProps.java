package com.ibm.icu.impl.number;

import com.ibm.icu.number.IntegerWidth;
import com.ibm.icu.number.NumberFormatter;
import com.ibm.icu.number.Precision;
import com.ibm.icu.text.DecimalFormatSymbols;
import com.ibm.icu.util.Measure;
import com.ibm.icu.util.MeasureUnit;
import defpackage.og;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class MicroProps implements Cloneable, MicroPropsGenerator {
    public String currencyAsDecimal;
    public NumberFormatter.DecimalSeparatorDisplay decimal;
    private volatile boolean exhausted;
    public String gender;
    public Grouper grouping;
    private final boolean immutable;
    public int indexOfQuantity = -1;
    public IntegerWidth integerWidth;
    public List<Measure> mixedMeasures;
    public Modifier modInner;
    public Modifier modMiddle;
    public Modifier modOuter;
    public String nsName;
    public MeasureUnit outputUnit;
    public Padder padding;
    public Precision rounder;
    public NumberFormatter.SignDisplay sign;
    public DecimalFormatSymbols symbols;
    public boolean useCurrency;

    public MicroProps(boolean z) {
        this.immutable = z;
    }

    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public MicroProps m11clone() {
        try {
            return (MicroProps) super.clone();
        } catch (CloneNotSupportedException e) {
            og.m(e);
            return null;
        }
    }

    @Override // com.ibm.icu.impl.number.MicroPropsGenerator
    public MicroProps processQuantity(DecimalQuantity decimalQuantity) {
        if (this.immutable) {
            return m11clone();
        }
        if (this.exhausted) {
            og.m("Cannot re-use a mutable MicroProps in the quantity chain");
            return null;
        }
        this.exhausted = true;
        return this;
    }
}
