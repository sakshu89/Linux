package com.ibm.icu.impl.units;

import com.ibm.icu.impl.IllegalIcuArgumentException;
import com.ibm.icu.impl.number.MicroProps;
import com.ibm.icu.number.Precision;
import com.ibm.icu.util.MeasureUnit;
import com.ibm.icu.util.ULocale;
import defpackage.og;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class UnitsRouter {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private ArrayList<ConverterPreference> converterPreferences_;
    private ArrayList<MeasureUnit> outputUnits_;

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class RouteResult {
        public final ComplexUnitsConverter.ComplexConverterResult complexConverterResult;
        public final MeasureUnitImpl outputUnit;

        public RouteResult(ComplexUnitsConverter.ComplexConverterResult complexConverterResult, MeasureUnitImpl measureUnitImpl) {
            this.complexConverterResult = complexConverterResult;
            this.outputUnit = measureUnitImpl;
        }
    }

    public UnitsRouter(MeasureUnitImpl measureUnitImpl, ULocale uLocale, String str) {
        this.outputUnits_ = new ArrayList<>();
        this.converterPreferences_ = new ArrayList<>();
        UnitsData unitsData = new UnitsData();
        UnitPreferences.UnitPreference[] preferencesFor = unitsData.getPreferencesFor(unitsData.getCategory(measureUnitImpl), str, uLocale);
        for (UnitPreferences.UnitPreference unitPreference : preferencesFor) {
            MeasureUnitImpl forIdentifier = MeasureUnitImpl.UnitsParser.parseForIdentifier(unitPreference.getUnit());
            String skeleton = unitPreference.getSkeleton();
            if (!skeleton.isEmpty() && !skeleton.startsWith("precision-increment")) {
                og.m("Only `precision-increment` is allowed");
                throw null;
            }
            this.outputUnits_.add(forIdentifier.build());
            this.converterPreferences_.add(new ConverterPreference(measureUnitImpl, forIdentifier, unitPreference.getGeq(), skeleton, unitsData.getConversionRates()));
        }
    }

    private static Precision parseSkeletonToPrecision(String str) {
        if (str.startsWith("precision-increment/")) {
            return Precision.increment(new BigDecimal(str.substring(20)));
        }
        throw new IllegalIcuArgumentException("precisionSkeleton is only precision-increment");
    }

    public List<MeasureUnit> getOutputUnits() {
        return this.outputUnits_;
    }

    public RouteResult route(BigDecimal bigDecimal, MicroProps microProps) {
        ConverterPreference converterPreference = null;
        Precision precisionInto = microProps == null ? null : microProps.rounder;
        ArrayList<ConverterPreference> arrayList = this.converterPreferences_;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            ConverterPreference converterPreference2 = arrayList.get(i);
            i++;
            converterPreference = converterPreference2;
            if (converterPreference.converter.greaterThanOrEqual(bigDecimal.abs(), converterPreference.limit)) {
                break;
            }
        }
        if (precisionInto != null && (precisionInto instanceof Precision.BogusRounder)) {
            Precision.BogusRounder bogusRounder = (Precision.BogusRounder) precisionInto;
            precisionInto = converterPreference.precision.length() > 0 ? bogusRounder.into(parseSkeletonToPrecision(converterPreference.precision)) : bogusRounder.into(Precision.integer().withMinDigits(2));
        }
        if (microProps != null) {
            microProps.rounder = precisionInto;
        }
        return new RouteResult(converterPreference.converter.convert(bigDecimal, precisionInto), converterPreference.targetUnit);
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class ConverterPreference {
        final ComplexUnitsConverter converter;
        final BigDecimal limit;
        final String precision;
        final MeasureUnitImpl targetUnit;

        public ConverterPreference(MeasureUnitImpl measureUnitImpl, MeasureUnitImpl measureUnitImpl2, BigDecimal bigDecimal, String str, ConversionRates conversionRates) {
            this.converter = new ComplexUnitsConverter(measureUnitImpl, measureUnitImpl2, conversionRates);
            this.limit = bigDecimal;
            this.precision = str;
            this.targetUnit = measureUnitImpl2;
        }

        public ConverterPreference(MeasureUnitImpl measureUnitImpl, MeasureUnitImpl measureUnitImpl2, String str, ConversionRates conversionRates) {
            this(measureUnitImpl, measureUnitImpl2, BigDecimal.valueOf(Double.MIN_VALUE), str, conversionRates);
        }
    }

    public UnitsRouter(String str, ULocale uLocale, String str2) {
        this(MeasureUnitImpl.forIdentifier(str), uLocale, str2);
    }
}
