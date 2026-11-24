package com.ibm.icu.impl.units;

import com.ibm.icu.impl.IllegalIcuArgumentException;
import com.ibm.icu.util.MeasureUnit;
import defpackage.ky0;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class UnitsConverter {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final BigDecimal[] minMetersPerSecForBeaufort = {BigDecimal.valueOf(0.0d), BigDecimal.valueOf(0.3d), BigDecimal.valueOf(1.6d), BigDecimal.valueOf(3.4d), BigDecimal.valueOf(5.5d), BigDecimal.valueOf(8.0d), BigDecimal.valueOf(10.8d), BigDecimal.valueOf(13.9d), BigDecimal.valueOf(17.2d), BigDecimal.valueOf(20.8d), BigDecimal.valueOf(24.5d), BigDecimal.valueOf(28.5d), BigDecimal.valueOf(32.7d), BigDecimal.valueOf(36.9d), BigDecimal.valueOf(41.4d), BigDecimal.valueOf(46.1d), BigDecimal.valueOf(51.1d), BigDecimal.valueOf(55.8d), BigDecimal.valueOf(61.4d)};
    private BigDecimal conversionRate;
    private BigDecimal offset;
    private boolean reciprocal;
    private String specialSource;
    private String specialTarget;

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class ConversionInfo {
        public BigDecimal conversionRate;
        public BigDecimal offset;
        public boolean reciprocal;
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public enum Convertibility {
        CONVERTIBLE,
        RECIPROCAL,
        UNCONVERTIBLE
    }

    public UnitsConverter(MeasureUnitImpl measureUnitImpl, MeasureUnitImpl measureUnitImpl2, ConversionRates conversionRates) {
        Convertibility convertibilityExtractConvertibility = extractConvertibility(measureUnitImpl, measureUnitImpl2, conversionRates);
        Convertibility convertibility = Convertibility.CONVERTIBLE;
        if (convertibilityExtractConvertibility != convertibility && convertibilityExtractConvertibility != Convertibility.RECIPROCAL) {
            throw new IllegalIcuArgumentException("input units must be convertible or reciprocal");
        }
        this.specialSource = conversionRates.getSpecialMappingName(measureUnitImpl);
        String specialMappingName = conversionRates.getSpecialMappingName(measureUnitImpl2);
        this.specialTarget = specialMappingName;
        String str = this.specialSource;
        if (str == null && specialMappingName == null) {
            Factor factorToBase = conversionRates.getFactorToBase(measureUnitImpl);
            Factor factorToBase2 = conversionRates.getFactorToBase(measureUnitImpl2);
            if (convertibilityExtractConvertibility == convertibility) {
                this.conversionRate = factorToBase.divide(factorToBase2).getConversionRate();
            } else {
                this.conversionRate = factorToBase.multiply(factorToBase2).getConversionRate();
            }
            this.reciprocal = convertibilityExtractConvertibility == Convertibility.RECIPROCAL;
            this.offset = conversionRates.getOffset(measureUnitImpl, measureUnitImpl2, factorToBase, factorToBase2, convertibilityExtractConvertibility);
            return;
        }
        this.reciprocal = false;
        this.offset = BigDecimal.ZERO;
        if (str == null) {
            this.conversionRate = conversionRates.getFactorToBase(measureUnitImpl).getConversionRate();
        } else if (specialMappingName == null) {
            this.conversionRate = conversionRates.getFactorToBase(measureUnitImpl2).getConversionRate();
        } else {
            this.conversionRate = BigDecimal.ONE;
        }
    }

    private static boolean areDimensionsZeroes(HashMap<String, Integer> map) {
        Iterator<Integer> it = map.values().iterator();
        while (it.hasNext()) {
            if (!it.next().equals(0)) {
                return false;
            }
        }
        return true;
    }

    private BigDecimal baseToScale(BigDecimal bigDecimal, BigDecimal[] bigDecimalArr) {
        int iBinarySearch = Arrays.binarySearch(bigDecimalArr, bigDecimal.abs());
        if (iBinarySearch < 0) {
            iBinarySearch = (-iBinarySearch) - 2;
        }
        int length = bigDecimalArr.length - 2;
        if (iBinarySearch > length) {
            iBinarySearch = length;
        }
        return BigDecimal.valueOf(iBinarySearch);
    }

    public static Convertibility extractConvertibility(MeasureUnitImpl measureUnitImpl, MeasureUnitImpl measureUnitImpl2, ConversionRates conversionRates) {
        ArrayList<SingleUnitImpl> arrayListExtractBaseUnits = conversionRates.extractBaseUnits(measureUnitImpl);
        ArrayList<SingleUnitImpl> arrayListExtractBaseUnits2 = conversionRates.extractBaseUnits(measureUnitImpl2);
        HashMap map = new HashMap();
        insertInMap(map, arrayListExtractBaseUnits, 1);
        insertInMap(map, arrayListExtractBaseUnits2, -1);
        if (areDimensionsZeroes(map)) {
            return Convertibility.CONVERTIBLE;
        }
        insertInMap(map, arrayListExtractBaseUnits2, 2);
        return areDimensionsZeroes(map) ? Convertibility.RECIPROCAL : Convertibility.UNCONVERTIBLE;
    }

    private static void insertInMap(HashMap<String, Integer> map, ArrayList<SingleUnitImpl> arrayList, int i) {
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            SingleUnitImpl singleUnitImpl = arrayList.get(i2);
            i2++;
            SingleUnitImpl singleUnitImpl2 = singleUnitImpl;
            if (map.containsKey(singleUnitImpl2.getSimpleUnitID())) {
                map.put(singleUnitImpl2.getSimpleUnitID(), Integer.valueOf((singleUnitImpl2.getDimensionality() * i) + map.get(singleUnitImpl2.getSimpleUnitID()).intValue()));
            } else {
                map.put(singleUnitImpl2.getSimpleUnitID(), Integer.valueOf(singleUnitImpl2.getDimensionality() * i));
            }
        }
    }

    private BigDecimal scaleToBase(BigDecimal bigDecimal, BigDecimal[] bigDecimalArr) {
        BigDecimal bigDecimalValueOf = BigDecimal.valueOf(0.5d);
        int iIntValue = bigDecimal.abs().add(bigDecimalValueOf).min(BigDecimal.valueOf(bigDecimalArr.length - 2)).intValue();
        return bigDecimalArr[iIntValue].add(bigDecimalArr[iIntValue + 1]).multiply(bigDecimalValueOf);
    }

    public BigDecimal convert(BigDecimal bigDecimal) {
        String str = this.specialSource;
        if (str == null && this.specialTarget == null) {
            BigDecimal bigDecimalAdd = bigDecimal.multiply(this.conversionRate).add(this.offset);
            if (!this.reciprocal) {
                return bigDecimalAdd;
            }
            BigDecimal bigDecimal2 = BigDecimal.ZERO;
            return bigDecimalAdd.compareTo(bigDecimal2) == 0 ? bigDecimal2 : BigDecimal.ONE.divide(bigDecimalAdd, MathContext.DECIMAL128);
        }
        if (str == null) {
            bigDecimal = bigDecimal.multiply(this.conversionRate);
        } else if (str.equals("beaufort")) {
            bigDecimal = scaleToBase(bigDecimal, minMetersPerSecForBeaufort);
        }
        String str2 = this.specialTarget;
        if (str2 != null) {
            return str2.equals("beaufort") ? baseToScale(bigDecimal, minMetersPerSecForBeaufort) : bigDecimal;
        }
        return bigDecimal.divide(this.conversionRate, MathContext.DECIMAL128);
    }

    public BigDecimal convertInverse(BigDecimal bigDecimal) {
        if (this.specialSource == null && this.specialTarget == null) {
            if (this.reciprocal) {
                BigDecimal bigDecimal2 = BigDecimal.ZERO;
                if (bigDecimal.compareTo(bigDecimal2) == 0) {
                    return bigDecimal2;
                }
                bigDecimal = BigDecimal.ONE.divide(bigDecimal, MathContext.DECIMAL128);
            }
            return bigDecimal.subtract(this.offset).divide(this.conversionRate, MathContext.DECIMAL128);
        }
        String str = this.specialTarget;
        if (str == null) {
            bigDecimal = bigDecimal.multiply(this.conversionRate);
        } else if (str.equals("beaufort")) {
            bigDecimal = scaleToBase(bigDecimal, minMetersPerSecForBeaufort);
        }
        String str2 = this.specialSource;
        if (str2 != null) {
            return str2.equals("beaufort") ? baseToScale(bigDecimal, minMetersPerSecForBeaufort) : bigDecimal;
        }
        return bigDecimal.divide(this.conversionRate, MathContext.DECIMAL128);
    }

    public ConversionInfo getConversionInfo() {
        ConversionInfo conversionInfo = new ConversionInfo();
        conversionInfo.conversionRate = this.conversionRate;
        conversionInfo.offset = this.offset;
        conversionInfo.reciprocal = this.reciprocal;
        return conversionInfo;
    }

    public String toString() {
        return ky0.l("UnitsConverter [conversionRate=", String.valueOf(this.conversionRate), ", offset=", String.valueOf(this.offset), "]");
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class Factor {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private int exponentFtToM = 0;
        private int exponentPi = 0;
        private int exponentGravity = 0;
        private int exponentG = 0;
        private int exponentGalImpToM3 = 0;
        private int exponentLbToKg = 0;
        private int exponentGlucoseMolarMass = 0;
        private int exponentItemPerMole = 0;
        private int exponentMetersPerAU = 0;
        private int exponentSecPerJulianYear = 0;
        private int exponentSpeedOfLightMetersPerSecond = 0;
        private int exponentShoToM3 = 0;
        private int exponentTsuboToM2 = 0;
        private int exponentShakuToM = 0;
        private int exponentAMU = 0;
        private BigDecimal factorNum = BigDecimal.valueOf(1L);
        private BigDecimal factorDen = BigDecimal.valueOf(1L);

        private void addEntity(String str, int i) {
            if ("ft_to_m".equals(str)) {
                this.exponentFtToM += i;
                return;
            }
            if ("ft2_to_m2".equals(str)) {
                this.exponentFtToM = (i * 2) + this.exponentFtToM;
                return;
            }
            if ("ft3_to_m3".equals(str)) {
                this.exponentFtToM = (i * 3) + this.exponentFtToM;
                return;
            }
            if ("in3_to_m3".equals(str)) {
                this.exponentFtToM = (i * 3) + this.exponentFtToM;
                this.factorDen = this.factorDen.multiply(BigDecimal.valueOf(Math.pow(12.0d, 3.0d)));
                return;
            }
            if ("gal_to_m3".equals(str)) {
                this.factorNum = this.factorNum.multiply(BigDecimal.valueOf(231L));
                this.exponentFtToM = (i * 3) + this.exponentFtToM;
                this.factorDen = this.factorDen.multiply(BigDecimal.valueOf(1728L));
                return;
            }
            if ("gal_imp_to_m3".equals(str)) {
                this.exponentGalImpToM3 += i;
                return;
            }
            if ("G".equals(str)) {
                this.exponentG += i;
                return;
            }
            if ("gravity".equals(str)) {
                this.exponentGravity += i;
                return;
            }
            if ("lb_to_kg".equals(str)) {
                this.exponentLbToKg += i;
                return;
            }
            if ("glucose_molar_mass".equals(str)) {
                this.exponentGlucoseMolarMass += i;
                return;
            }
            if ("item_per_mole".equals(str)) {
                this.exponentItemPerMole += i;
                return;
            }
            if ("meters_per_AU".equals(str)) {
                this.exponentMetersPerAU += i;
                return;
            }
            if ("PI".equals(str)) {
                this.exponentPi += i;
                return;
            }
            if ("sec_per_julian_year".equals(str)) {
                this.exponentSecPerJulianYear += i;
                return;
            }
            if ("speed_of_light_meters_per_second".equals(str)) {
                this.exponentSpeedOfLightMetersPerSecond += i;
                return;
            }
            if ("sho_to_m3".equals(str)) {
                this.exponentShoToM3 += i;
                return;
            }
            if ("tsubo_to_m2".equals(str)) {
                this.exponentTsuboToM2 += i;
                return;
            }
            if ("shaku_to_m".equals(str)) {
                this.exponentShakuToM += i;
            } else if ("AMU".equals(str)) {
                this.exponentAMU += i;
            } else {
                this.factorNum = this.factorNum.multiply(new BigDecimal(str).pow(i, MathContext.DECIMAL128));
            }
        }

        private void addPoweredEntity(String str) {
            String[] strArrSplit = str.split(Pattern.quote("^"));
            addEntity(strArrSplit[0], strArrSplit.length == 2 ? Integer.parseInt(strArrSplit[1]) : 1);
        }

        public static Factor processFactor(String str) {
            String[] strArrSplit = str.replaceAll("\\s+", "").split("/");
            return strArrSplit.length == 1 ? processFactorWithoutDivision(strArrSplit[0]) : processFactorWithoutDivision(strArrSplit[0]).divide(processFactorWithoutDivision(strArrSplit[1]));
        }

        private static Factor processFactorWithoutDivision(String str) {
            Factor factor = new Factor();
            for (String str2 : str.split(Pattern.quote("*"))) {
                factor.addPoweredEntity(str2);
            }
            return factor;
        }

        public Factor applyPrefix(MeasureUnit.MeasurePrefix measurePrefix) {
            Factor factorCopy = copy();
            if (measurePrefix == MeasureUnit.MeasurePrefix.ONE) {
                return factorCopy;
            }
            int base = measurePrefix.getBase();
            int power = measurePrefix.getPower();
            BigDecimal bigDecimalPow = BigDecimal.valueOf(base).pow(Math.abs(power), MathContext.DECIMAL128);
            if (power < 0) {
                factorCopy.factorDen = this.factorDen.multiply(bigDecimalPow);
                return factorCopy;
            }
            factorCopy.factorNum = this.factorNum.multiply(bigDecimalPow);
            return factorCopy;
        }

        public Factor copy() {
            Factor factor = new Factor();
            factor.factorNum = this.factorNum;
            factor.factorDen = this.factorDen;
            factor.exponentFtToM = this.exponentFtToM;
            factor.exponentPi = this.exponentPi;
            factor.exponentGravity = this.exponentGravity;
            factor.exponentG = this.exponentG;
            factor.exponentGalImpToM3 = this.exponentGalImpToM3;
            factor.exponentLbToKg = this.exponentLbToKg;
            factor.exponentGlucoseMolarMass = this.exponentGlucoseMolarMass;
            factor.exponentItemPerMole = this.exponentItemPerMole;
            factor.exponentMetersPerAU = this.exponentMetersPerAU;
            factor.exponentSecPerJulianYear = this.exponentSecPerJulianYear;
            factor.exponentSpeedOfLightMetersPerSecond = this.exponentSpeedOfLightMetersPerSecond;
            factor.exponentShoToM3 = this.exponentShoToM3;
            factor.exponentTsuboToM2 = this.exponentTsuboToM2;
            factor.exponentShakuToM = this.exponentShakuToM;
            factor.exponentAMU = this.exponentAMU;
            return factor;
        }

        public Factor divide(Factor factor) {
            Factor factor2 = new Factor();
            factor2.factorNum = this.factorNum.multiply(factor.factorDen);
            factor2.factorDen = this.factorDen.multiply(factor.factorNum);
            factor2.exponentFtToM = this.exponentFtToM - factor.exponentFtToM;
            factor2.exponentPi = this.exponentPi - factor.exponentPi;
            factor2.exponentGravity = this.exponentGravity - factor.exponentGravity;
            factor2.exponentG = this.exponentG - factor.exponentG;
            factor2.exponentGalImpToM3 = this.exponentGalImpToM3 - factor.exponentGalImpToM3;
            factor2.exponentLbToKg = this.exponentLbToKg - factor.exponentLbToKg;
            factor2.exponentGlucoseMolarMass = this.exponentGlucoseMolarMass - factor.exponentGlucoseMolarMass;
            factor2.exponentItemPerMole = this.exponentItemPerMole - factor.exponentItemPerMole;
            factor2.exponentMetersPerAU = this.exponentMetersPerAU - factor.exponentMetersPerAU;
            factor2.exponentSecPerJulianYear = this.exponentSecPerJulianYear - factor.exponentSecPerJulianYear;
            factor2.exponentSpeedOfLightMetersPerSecond = this.exponentSpeedOfLightMetersPerSecond - factor.exponentSpeedOfLightMetersPerSecond;
            factor2.exponentShoToM3 = this.exponentShoToM3 - factor.exponentShoToM3;
            factor2.exponentTsuboToM2 = this.exponentTsuboToM2 - factor.exponentTsuboToM2;
            factor2.exponentShakuToM = this.exponentShakuToM - factor.exponentShakuToM;
            factor2.exponentAMU = this.exponentAMU - factor.exponentAMU;
            return factor2;
        }

        public BigDecimal getConversionRate() {
            Factor factorCopy = copy();
            factorCopy.multiply(new BigDecimal("0.3048"), this.exponentFtToM);
            BigDecimal bigDecimal = new BigDecimal("411557987.0");
            BigDecimal bigDecimal2 = new BigDecimal("131002976.0");
            MathContext mathContext = MathContext.DECIMAL128;
            factorCopy.multiply(bigDecimal.divide(bigDecimal2, mathContext), this.exponentPi);
            factorCopy.multiply(new BigDecimal("9.80665"), this.exponentGravity);
            factorCopy.multiply(new BigDecimal("6.67408E-11"), this.exponentG);
            factorCopy.multiply(new BigDecimal("0.00454609"), this.exponentGalImpToM3);
            factorCopy.multiply(new BigDecimal("0.45359237"), this.exponentLbToKg);
            factorCopy.multiply(new BigDecimal("180.1557"), this.exponentGlucoseMolarMass);
            factorCopy.multiply(new BigDecimal("6.02214076E+23"), this.exponentItemPerMole);
            factorCopy.multiply(new BigDecimal("149597870700"), this.exponentMetersPerAU);
            factorCopy.multiply(new BigDecimal("31557600"), this.exponentSecPerJulianYear);
            factorCopy.multiply(new BigDecimal("299792458"), this.exponentSpeedOfLightMetersPerSecond);
            factorCopy.multiply(new BigDecimal("0.001803906836964688204"), this.exponentShoToM3);
            factorCopy.multiply(new BigDecimal("3.305785123966942"), this.exponentTsuboToM2);
            factorCopy.multiply(new BigDecimal("0.033057851239669"), this.exponentShakuToM);
            factorCopy.multiply(new BigDecimal("1.66053878283E-27"), this.exponentAMU);
            return factorCopy.factorNum.divide(factorCopy.factorDen, mathContext);
        }

        public Factor multiply(Factor factor) {
            Factor factor2 = new Factor();
            factor2.factorNum = this.factorNum.multiply(factor.factorNum);
            factor2.factorDen = this.factorDen.multiply(factor.factorDen);
            factor2.exponentFtToM = this.exponentFtToM + factor.exponentFtToM;
            factor2.exponentPi = this.exponentPi + factor.exponentPi;
            factor2.exponentGravity = this.exponentGravity + factor.exponentGravity;
            factor2.exponentG = this.exponentG + factor.exponentG;
            factor2.exponentGalImpToM3 = this.exponentGalImpToM3 + factor.exponentGalImpToM3;
            factor2.exponentLbToKg = this.exponentLbToKg + factor.exponentLbToKg;
            factor2.exponentGlucoseMolarMass = this.exponentGlucoseMolarMass + factor.exponentGlucoseMolarMass;
            factor2.exponentItemPerMole = this.exponentItemPerMole + factor.exponentItemPerMole;
            factor2.exponentMetersPerAU = this.exponentMetersPerAU + factor.exponentMetersPerAU;
            factor2.exponentSecPerJulianYear = this.exponentSecPerJulianYear + factor.exponentSecPerJulianYear;
            factor2.exponentSpeedOfLightMetersPerSecond = this.exponentSpeedOfLightMetersPerSecond + factor.exponentSpeedOfLightMetersPerSecond;
            factor2.exponentShoToM3 = this.exponentShoToM3 + factor.exponentShoToM3;
            factor2.exponentTsuboToM2 = this.exponentTsuboToM2 + factor.exponentTsuboToM2;
            factor2.exponentShakuToM = this.exponentShakuToM + factor.exponentShakuToM;
            factor2.exponentAMU = this.exponentAMU + factor.exponentAMU;
            return factor2;
        }

        public Factor power(int i) {
            Factor factor = new Factor();
            if (i == 0) {
                return factor;
            }
            if (i > 0) {
                factor.factorNum = this.factorNum.pow(i);
                factor.factorDen = this.factorDen.pow(i);
            } else {
                int i2 = i * (-1);
                factor.factorNum = this.factorDen.pow(i2);
                factor.factorDen = this.factorNum.pow(i2);
            }
            factor.exponentFtToM = this.exponentFtToM * i;
            factor.exponentPi = this.exponentPi * i;
            factor.exponentGravity = this.exponentGravity * i;
            factor.exponentG = this.exponentG * i;
            factor.exponentGalImpToM3 = this.exponentGalImpToM3 * i;
            factor.exponentLbToKg = this.exponentLbToKg * i;
            factor.exponentGlucoseMolarMass = this.exponentGlucoseMolarMass * i;
            factor.exponentItemPerMole = this.exponentItemPerMole * i;
            factor.exponentMetersPerAU = this.exponentMetersPerAU * i;
            factor.exponentSecPerJulianYear = this.exponentSecPerJulianYear * i;
            factor.exponentSpeedOfLightMetersPerSecond = this.exponentSpeedOfLightMetersPerSecond * i;
            factor.exponentShoToM3 = this.exponentShoToM3 * i;
            factor.exponentTsuboToM2 = this.exponentTsuboToM2 * i;
            factor.exponentShakuToM = this.exponentShakuToM * i;
            factor.exponentAMU = this.exponentAMU * i;
            return factor;
        }

        private void multiply(BigDecimal bigDecimal, int i) {
            if (i == 0) {
                return;
            }
            BigDecimal bigDecimalPow = bigDecimal.pow(Math.abs(i), MathContext.DECIMAL128);
            if (i > 0) {
                this.factorNum = this.factorNum.multiply(bigDecimalPow);
            } else {
                this.factorDen = this.factorDen.multiply(bigDecimalPow);
            }
        }

        public Factor divide(BigDecimal bigDecimal) {
            Factor factorCopy = copy();
            factorCopy.factorDen = this.factorDen.multiply(bigDecimal);
            return factorCopy;
        }
    }

    public UnitsConverter(String str, String str2) {
        this(MeasureUnitImpl.forIdentifier(str), MeasureUnitImpl.forIdentifier(str2), new ConversionRates());
    }
}
