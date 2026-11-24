package com.ibm.icu.impl.number;

import com.ibm.icu.impl.units.ComplexUnitsConverter;
import com.ibm.icu.impl.units.ConversionRates;
import com.ibm.icu.impl.units.MeasureUnitImpl;
import com.ibm.icu.util.MeasureUnit;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class UnitConversionHandler implements MicroPropsGenerator {
    private ComplexUnitsConverter fComplexUnitConverter;
    private MeasureUnit fOutputUnit;
    private final MicroPropsGenerator fParent;

    public UnitConversionHandler(MeasureUnit measureUnit, MicroPropsGenerator microPropsGenerator) {
        this.fOutputUnit = measureUnit;
        this.fParent = microPropsGenerator;
        this.fComplexUnitConverter = new ComplexUnitsConverter(MeasureUnitImpl.forIdentifier(measureUnit.getIdentifier()), new ConversionRates());
    }

    @Override // com.ibm.icu.impl.number.MicroPropsGenerator
    public MicroProps processQuantity(DecimalQuantity decimalQuantity) {
        MicroProps microPropsProcessQuantity = this.fParent.processQuantity(decimalQuantity);
        decimalQuantity.roundToInfinity();
        ComplexUnitsConverter.ComplexConverterResult complexConverterResultConvert = this.fComplexUnitConverter.convert(decimalQuantity.toBigDecimal(), microPropsProcessQuantity.rounder);
        microPropsProcessQuantity.outputUnit = this.fOutputUnit;
        UsagePrefsHandler.mixedMeasuresToMicros(complexConverterResultConvert, decimalQuantity, microPropsProcessQuantity);
        return microPropsProcessQuantity;
    }
}
