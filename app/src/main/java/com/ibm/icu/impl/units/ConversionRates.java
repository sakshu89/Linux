package com.ibm.icu.impl.units;

import com.ibm.icu.impl.ICUData;
import com.ibm.icu.impl.ICUResourceBundle;
import com.ibm.icu.impl.IllegalIcuArgumentException;
import com.ibm.icu.impl.UResource;
import com.ibm.icu.impl.number.Padder;
import com.ibm.icu.util.MeasureUnit;
import com.ibm.icu.util.UResourceBundle;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class ConversionRates {
    private HashMap<String, ConversionRateInfo> mapToConversionRate;

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class ConversionRateInfo {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final String conversionRate;
        private final BigDecimal offset;
        private final String simpleUnit;
        private final String specialMappingName;
        private final String systems;
        private final String target;

        public ConversionRateInfo(String str, String str2, String str3, String str4, String str5, String str6) {
            this.simpleUnit = str;
            this.target = str2;
            this.conversionRate = str3;
            this.offset = forNumberWithDivision(str4);
            this.specialMappingName = str5;
            this.systems = str6;
        }

        private static BigDecimal forNumberWithDivision(String str) {
            String[] strArrSplit = str.split("/");
            return strArrSplit.length == 1 ? new BigDecimal(strArrSplit[0]) : new BigDecimal(strArrSplit[0]).divide(new BigDecimal(strArrSplit[1]), MathContext.DECIMAL128);
        }

        public String getConversionRate() {
            String str = this.conversionRate;
            if (str != null) {
                return str;
            }
            throw new IllegalIcuArgumentException("trying to use a null conversion rate (for special?)");
        }

        public BigDecimal getOffset() {
            return this.offset;
        }

        public String getSpecialMappingName() {
            return this.specialMappingName;
        }

        public String getSystems() {
            return this.systems;
        }

        public String getTarget() {
            return this.target;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class ConversionRatesSink extends UResource.Sink {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private HashMap<String, ConversionRateInfo> mapToConversionRate = new HashMap<>();

        public HashMap<String, ConversionRateInfo> getMapToConversionRate() {
            return this.mapToConversionRate;
        }

        @Override // com.ibm.icu.impl.UResource.Sink
        public void put(UResource.Key key, UResource.Value value, boolean z) {
            UResource.Table table = value.getTable();
            for (int i = 0; table.getKeyAndValue(i, key, value); i++) {
                String string = key.toString();
                UResource.Table table2 = value.getTable();
                String str = null;
                String str2 = null;
                String string2 = null;
                String str3 = "0";
                String str4 = null;
                for (int i2 = 0; table2.getKeyAndValue(i2, key, value); i2++) {
                    String string3 = key.toString();
                    String strReplace = value.toString().replace(Padder.FALLBACK_PADDING_STRING, "");
                    if ("target".equals(string3)) {
                        str4 = strReplace;
                    } else if ("factor".equals(string3)) {
                        str = strReplace;
                    } else if ("offset".equals(string3)) {
                        str3 = strReplace;
                    } else if ("special".equals(string3)) {
                        str2 = strReplace;
                    } else if ("systems".equals(string3)) {
                        string2 = value.toString();
                    }
                }
                this.mapToConversionRate.put(string, new ConversionRateInfo(string, str4, str, str3, str2, string2));
            }
        }
    }

    public ConversionRates() {
        ICUResourceBundle iCUResourceBundle = (ICUResourceBundle) UResourceBundle.getBundleInstance(ICUData.ICU_BASE_NAME, "units");
        ConversionRatesSink conversionRatesSink = new ConversionRatesSink();
        iCUResourceBundle.getAllItemsWithFallback(UnitsData.Constants.CONVERSION_UNIT_TABLE_NAME, conversionRatesSink);
        this.mapToConversionRate = conversionRatesSink.getMapToConversionRate();
    }

    private boolean checkSimpleUnit(MeasureUnitImpl measureUnitImpl) {
        if (measureUnitImpl.getComplexity() != MeasureUnit.Complexity.SINGLE) {
            return false;
        }
        SingleUnitImpl singleUnitImpl = measureUnitImpl.getSingleUnits().get(0);
        return singleUnitImpl.getPrefix() == MeasureUnit.MeasurePrefix.ONE && singleUnitImpl.getDimensionality() == 1;
    }

    public ArrayList<SingleUnitImpl> extractBaseUnits(MeasureUnitImpl measureUnitImpl) {
        ArrayList<SingleUnitImpl> arrayList = new ArrayList<>();
        ArrayList<SingleUnitImpl> singleUnits = measureUnitImpl.getSingleUnits();
        int size = singleUnits.size();
        int i = 0;
        while (i < size) {
            SingleUnitImpl singleUnitImpl = singleUnits.get(i);
            i++;
            arrayList.addAll(extractBaseUnits(singleUnitImpl));
        }
        return arrayList;
    }

    public MeasureUnitImpl extractCompoundBaseUnit(MeasureUnitImpl measureUnitImpl) {
        ArrayList<SingleUnitImpl> arrayListExtractBaseUnits = extractBaseUnits(measureUnitImpl);
        MeasureUnitImpl measureUnitImpl2 = new MeasureUnitImpl();
        int size = arrayListExtractBaseUnits.size();
        int i = 0;
        while (i < size) {
            SingleUnitImpl singleUnitImpl = arrayListExtractBaseUnits.get(i);
            i++;
            measureUnitImpl2.appendSingleUnit(singleUnitImpl);
        }
        return measureUnitImpl2;
    }

    public String extractSystems(SingleUnitImpl singleUnitImpl) {
        return this.mapToConversionRate.get(singleUnitImpl.getSimpleUnitID()).getSystems();
    }

    public UnitsConverter.Factor getFactorToBase(MeasureUnitImpl measureUnitImpl) {
        UnitsConverter.Factor factor = new UnitsConverter.Factor();
        ArrayList<SingleUnitImpl> singleUnits = measureUnitImpl.getSingleUnits();
        int size = singleUnits.size();
        int i = 0;
        while (i < size) {
            SingleUnitImpl singleUnitImpl = singleUnits.get(i);
            i++;
            factor = factor.multiply(getFactorToBase(singleUnitImpl));
        }
        return measureUnitImpl.getConstantDenominator() != 0 ? factor.divide(BigDecimal.valueOf(measureUnitImpl.getConstantDenominator())) : factor;
    }

    public BigDecimal getOffset(MeasureUnitImpl measureUnitImpl, MeasureUnitImpl measureUnitImpl2, UnitsConverter.Factor factor, UnitsConverter.Factor factor2, UnitsConverter.Convertibility convertibility) {
        if (convertibility != UnitsConverter.Convertibility.CONVERTIBLE) {
            return BigDecimal.valueOf(0L);
        }
        if (!checkSimpleUnit(measureUnitImpl) || !checkSimpleUnit(measureUnitImpl2)) {
            return BigDecimal.valueOf(0L);
        }
        return this.mapToConversionRate.get(measureUnitImpl.getSingleUnits().get(0).getSimpleUnitID()).getOffset().subtract(this.mapToConversionRate.get(measureUnitImpl2.getSingleUnits().get(0).getSimpleUnitID()).getOffset()).divide(factor2.getConversionRate(), MathContext.DECIMAL128);
    }

    public String getSpecialMappingName(MeasureUnitImpl measureUnitImpl) {
        if (!checkSimpleUnit(measureUnitImpl)) {
            return null;
        }
        return this.mapToConversionRate.get(measureUnitImpl.getSingleUnits().get(0).getSimpleUnitID()).getSpecialMappingName();
    }

    public ArrayList<SingleUnitImpl> extractBaseUnits(SingleUnitImpl singleUnitImpl) {
        MeasureUnitImpl forIdentifier = MeasureUnitImpl.UnitsParser.parseForIdentifier(this.mapToConversionRate.get(singleUnitImpl.getSimpleUnitID()).getTarget());
        forIdentifier.applyDimensionality(singleUnitImpl.getDimensionality());
        return forIdentifier.getSingleUnits();
    }

    private UnitsConverter.Factor getFactorToBase(SingleUnitImpl singleUnitImpl) {
        return UnitsConverter.Factor.processFactor(this.mapToConversionRate.get(singleUnitImpl.getSimpleUnitID()).getConversionRate()).applyPrefix(singleUnitImpl.getPrefix()).power(singleUnitImpl.getDimensionality());
    }
}
