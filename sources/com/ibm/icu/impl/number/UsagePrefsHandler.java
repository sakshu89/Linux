package com.ibm.icu.impl.number;

import com.ibm.icu.impl.units.ComplexUnitsConverter;
import com.ibm.icu.impl.units.MeasureUnitImpl;
import com.ibm.icu.impl.units.UnitsRouter;
import com.ibm.icu.util.Measure;
import com.ibm.icu.util.MeasureUnit;
import com.ibm.icu.util.ULocale;
import java.math.BigDecimal;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class UsagePrefsHandler implements MicroPropsGenerator {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final MicroPropsGenerator fParent;
    private UnitsRouter fUnitsRouter;

    public UsagePrefsHandler(ULocale uLocale, MeasureUnit measureUnit, String str, MicroPropsGenerator microPropsGenerator) {
        this.fParent = microPropsGenerator;
        this.fUnitsRouter = new UnitsRouter(MeasureUnitImpl.forIdentifier(measureUnit.getIdentifier()), uLocale, str);
    }

    public static void mixedMeasuresToMicros(ComplexUnitsConverter.ComplexConverterResult complexConverterResult, DecimalQuantity decimalQuantity, MicroProps microProps) {
        List<Measure> list = complexConverterResult.measures;
        microProps.mixedMeasures = list;
        int i = complexConverterResult.indexOfQuantity;
        microProps.indexOfQuantity = i;
        decimalQuantity.setToBigDecimal((BigDecimal) list.get(i).getNumber());
    }

    public List<MeasureUnit> getOutputUnits() {
        return this.fUnitsRouter.getOutputUnits();
    }

    @Override // com.ibm.icu.impl.number.MicroPropsGenerator
    public MicroProps processQuantity(DecimalQuantity decimalQuantity) {
        MicroProps microPropsProcessQuantity = this.fParent.processQuantity(decimalQuantity);
        decimalQuantity.roundToInfinity();
        UnitsRouter.RouteResult routeResultRoute = this.fUnitsRouter.route(decimalQuantity.toBigDecimal(), microPropsProcessQuantity);
        microPropsProcessQuantity.outputUnit = routeResultRoute.outputUnit.build();
        mixedMeasuresToMicros(routeResultRoute.complexConverterResult, decimalQuantity, microPropsProcessQuantity);
        return microPropsProcessQuantity;
    }
}
