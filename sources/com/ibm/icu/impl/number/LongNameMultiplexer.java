package com.ibm.icu.impl.number;

import com.ibm.icu.number.NumberFormatter;
import com.ibm.icu.text.PluralRules;
import com.ibm.icu.util.MeasureUnit;
import com.ibm.icu.util.ULocale;
import defpackage.og;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class LongNameMultiplexer implements MicroPropsGenerator {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private List<ParentlessMicroPropsGenerator> fHandlers;
    private List<MeasureUnit> fMeasureUnits;
    private final MicroPropsGenerator fParent;

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public interface ParentlessMicroPropsGenerator {
        MicroProps processQuantityWithMicros(DecimalQuantity decimalQuantity, MicroProps microProps);
    }

    public LongNameMultiplexer(MicroPropsGenerator microPropsGenerator) {
        this.fParent = microPropsGenerator;
    }

    public static LongNameMultiplexer forMeasureUnits(ULocale uLocale, List<MeasureUnit> list, NumberFormatter.UnitWidth unitWidth, String str, PluralRules pluralRules, MicroPropsGenerator microPropsGenerator) {
        ULocale uLocale2;
        NumberFormatter.UnitWidth unitWidth2;
        String str2;
        PluralRules pluralRules2;
        LongNameMultiplexer longNameMultiplexer = new LongNameMultiplexer(microPropsGenerator);
        longNameMultiplexer.fMeasureUnits = new ArrayList();
        longNameMultiplexer.fHandlers = new ArrayList();
        int i = 0;
        while (i < list.size()) {
            MeasureUnit measureUnit = list.get(i);
            longNameMultiplexer.fMeasureUnits.add(measureUnit);
            if (measureUnit.getComplexity() == MeasureUnit.Complexity.MIXED) {
                uLocale2 = uLocale;
                unitWidth2 = unitWidth;
                str2 = str;
                pluralRules2 = pluralRules;
                longNameMultiplexer.fHandlers.add(MixedUnitLongNameHandler.forMeasureUnit(uLocale2, measureUnit, unitWidth2, str2, pluralRules2, null));
            } else {
                uLocale2 = uLocale;
                unitWidth2 = unitWidth;
                str2 = str;
                pluralRules2 = pluralRules;
                longNameMultiplexer.fHandlers.add(LongNameHandler.forMeasureUnit(uLocale2, measureUnit, unitWidth2, str2, pluralRules2, null));
            }
            i++;
            uLocale = uLocale2;
            unitWidth = unitWidth2;
            str = str2;
            pluralRules = pluralRules2;
        }
        return longNameMultiplexer;
    }

    @Override // com.ibm.icu.impl.number.MicroPropsGenerator
    public MicroProps processQuantity(DecimalQuantity decimalQuantity) {
        MicroProps microPropsProcessQuantity = this.fParent.processQuantity(decimalQuantity);
        for (int i = 0; i < this.fHandlers.size(); i++) {
            if (this.fMeasureUnits.get(i).equals(microPropsProcessQuantity.outputUnit)) {
                return this.fHandlers.get(i).processQuantityWithMicros(decimalQuantity, microPropsProcessQuantity);
            }
        }
        og.m(" We shouldn't receive any outputUnit for which we haven't already got a LongNameHandler");
        return null;
    }
}
