package com.ibm.icu.util;

import com.ibm.icu.impl.CollectionSet;
import com.ibm.icu.impl.ICUData;
import com.ibm.icu.impl.ICUResourceBundle;
import com.ibm.icu.impl.UResource;
import com.ibm.icu.impl.locale.LanguageTag;
import com.ibm.icu.impl.units.MeasureUnitImpl;
import com.ibm.icu.impl.units.SingleUnitImpl;
import com.ibm.icu.text.UnicodeSet;
import defpackage.cq;
import defpackage.dk0;
import defpackage.mc1;
import defpackage.og;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class MeasureUnit implements Serializable {
    private static final long serialVersionUID = -1839973855554750484L;
    private MeasureUnitImpl measureUnitImpl;

    @Deprecated
    protected final String subType;

    @Deprecated
    protected final String type;
    private static final Map<String, Map<String, MeasureUnit>> cache = new ConcurrentHashMap();
    private static volatile boolean cacheIsPopulated = false;
    private static boolean cacheIsLoading = false;
    private static final Object MEASURE_UNIT_LOCK = new Object();
    static final UnicodeSet ASCII = new UnicodeSet(97, 122).freeze();
    static final UnicodeSet ASCII_HYPHEN_DIGITS = new UnicodeSet(45, 45, 48, 57, 97, 122).freeze();
    private static final Factory UNIT_FACTORY = new Factory() { // from class: com.ibm.icu.util.MeasureUnit.1
        @Override // com.ibm.icu.util.MeasureUnit.Factory
        public MeasureUnit create(String str, String str2) {
            return new MeasureUnit(str, str2);
        }
    };
    static final Factory CURRENCY_FACTORY = new Factory() { // from class: com.ibm.icu.util.MeasureUnit.2
        @Override // com.ibm.icu.util.MeasureUnit.Factory
        public MeasureUnit create(String str, String str2) {
            return new Currency(str2);
        }
    };
    static final Factory TIMEUNIT_FACTORY = new Factory() { // from class: com.ibm.icu.util.MeasureUnit.3
        @Override // com.ibm.icu.util.MeasureUnit.Factory
        public MeasureUnit create(String str, String str2) {
            return new TimeUnit(str, str2);
        }
    };
    public static final MeasureUnit G_FORCE = internalGetInstance("acceleration", "g-force");
    public static final MeasureUnit METER_PER_SECOND_SQUARED = internalGetInstance("acceleration", "meter-per-square-second");
    public static final MeasureUnit ARC_MINUTE = internalGetInstance("angle", "arc-minute");
    public static final MeasureUnit ARC_SECOND = internalGetInstance("angle", "arc-second");
    public static final MeasureUnit DEGREE = internalGetInstance("angle", "degree");
    public static final MeasureUnit RADIAN = internalGetInstance("angle", "radian");
    public static final MeasureUnit REVOLUTION_ANGLE = internalGetInstance("angle", "revolution");
    public static final MeasureUnit STERADIAN = internalGetInstance("angle", "steradian");
    public static final MeasureUnit ACRE = internalGetInstance("area", "acre");
    public static final MeasureUnit BU_JP = internalGetInstance("area", "bu-jp");
    public static final MeasureUnit CHO = internalGetInstance("area", "cho");
    public static final MeasureUnit DUNAM = internalGetInstance("area", "dunam");
    public static final MeasureUnit HECTARE = internalGetInstance("area", "hectare");
    public static final MeasureUnit SE_JP = internalGetInstance("area", "se-jp");
    public static final MeasureUnit SQUARE_CENTIMETER = internalGetInstance("area", "square-centimeter");
    public static final MeasureUnit SQUARE_FOOT = internalGetInstance("area", "square-foot");
    public static final MeasureUnit SQUARE_INCH = internalGetInstance("area", "square-inch");
    public static final MeasureUnit SQUARE_KILOMETER = internalGetInstance("area", "square-kilometer");
    public static final MeasureUnit SQUARE_METER = internalGetInstance("area", "square-meter");
    public static final MeasureUnit SQUARE_MILE = internalGetInstance("area", "square-mile");
    public static final MeasureUnit SQUARE_YARD = internalGetInstance("area", "square-yard");
    public static final MeasureUnit ITEM = internalGetInstance("concentr", "item");
    public static final MeasureUnit KARAT = internalGetInstance("concentr", "karat");
    public static final MeasureUnit KATAL = internalGetInstance("concentr", "katal");
    public static final MeasureUnit MILLIGRAM_OFGLUCOSE_PER_DECILITER = internalGetInstance("concentr", "milligram-ofglucose-per-deciliter");

    @Deprecated
    public static final MeasureUnit MILLIGRAM_PER_DECILITER = internalGetInstance("concentr", "milligram-ofglucose-per-deciliter");
    public static final MeasureUnit MILLIMOLE_PER_LITER = internalGetInstance("concentr", "millimole-per-liter");
    public static final MeasureUnit MOLE = internalGetInstance("concentr", "mole");
    public static final MeasureUnit OFGLUCOSE = internalGetInstance("concentr", "ofglucose");
    public static final MeasureUnit PART = internalGetInstance("concentr", "part");
    public static final MeasureUnit PART_PER_1E6 = internalGetInstance("concentr", "part-per-1e6");
    public static final MeasureUnit PART_PER_MILLION = internalGetInstance("concentr", "part-per-1e6");
    public static final MeasureUnit PART_PER_1E9 = internalGetInstance("concentr", "part-per-1e9");
    public static final MeasureUnit PERCENT = internalGetInstance("concentr", "percent");
    public static final MeasureUnit PERMILLE = internalGetInstance("concentr", "permille");
    public static final MeasureUnit PERMYRIAD = internalGetInstance("concentr", "permyriad");
    public static final MeasureUnit LITER_PER_100KILOMETERS = internalGetInstance("consumption", "liter-per-100-kilometer");
    public static final MeasureUnit LITER_PER_KILOMETER = internalGetInstance("consumption", "liter-per-kilometer");
    public static final MeasureUnit MILE_PER_GALLON = internalGetInstance("consumption", "mile-per-gallon");
    public static final MeasureUnit MILE_PER_GALLON_IMPERIAL = internalGetInstance("consumption", "mile-per-gallon-imperial");
    public static final MeasureUnit BIT = internalGetInstance("digital", "bit");
    public static final MeasureUnit BYTE = internalGetInstance("digital", "byte");
    public static final MeasureUnit GIGABIT = internalGetInstance("digital", "gigabit");
    public static final MeasureUnit GIGABYTE = internalGetInstance("digital", "gigabyte");
    public static final MeasureUnit KILOBIT = internalGetInstance("digital", "kilobit");
    public static final MeasureUnit KILOBYTE = internalGetInstance("digital", "kilobyte");
    public static final MeasureUnit MEGABIT = internalGetInstance("digital", "megabit");
    public static final MeasureUnit MEGABYTE = internalGetInstance("digital", "megabyte");
    public static final MeasureUnit PETABYTE = internalGetInstance("digital", "petabyte");
    public static final MeasureUnit TERABIT = internalGetInstance("digital", "terabit");
    public static final MeasureUnit TERABYTE = internalGetInstance("digital", "terabyte");
    public static final MeasureUnit CENTURY = internalGetInstance("duration", "century");
    public static final TimeUnit DAY = (TimeUnit) internalGetInstance("duration", "day");
    public static final MeasureUnit DAY_PERSON = internalGetInstance("duration", "day-person");
    public static final MeasureUnit DECADE = internalGetInstance("duration", "decade");
    public static final MeasureUnit FORTNIGHT = internalGetInstance("duration", "fortnight");
    public static final TimeUnit HOUR = (TimeUnit) internalGetInstance("duration", "hour");
    public static final MeasureUnit MICROSECOND = internalGetInstance("duration", "microsecond");
    public static final MeasureUnit MILLISECOND = internalGetInstance("duration", "millisecond");
    public static final TimeUnit MINUTE = (TimeUnit) internalGetInstance("duration", "minute");
    public static final TimeUnit MONTH = (TimeUnit) internalGetInstance("duration", "month");
    public static final MeasureUnit MONTH_PERSON = internalGetInstance("duration", "month-person");
    public static final MeasureUnit NANOSECOND = internalGetInstance("duration", "nanosecond");
    public static final MeasureUnit NIGHT = internalGetInstance("duration", "night");
    public static final MeasureUnit QUARTER = internalGetInstance("duration", "quarter");
    public static final TimeUnit SECOND = (TimeUnit) internalGetInstance("duration", "second");
    public static final TimeUnit WEEK = (TimeUnit) internalGetInstance("duration", "week");
    public static final MeasureUnit WEEK_PERSON = internalGetInstance("duration", "week-person");
    public static final TimeUnit YEAR = (TimeUnit) internalGetInstance("duration", "year");
    public static final MeasureUnit YEAR_PERSON = internalGetInstance("duration", "year-person");
    public static final MeasureUnit AMPERE = internalGetInstance("electric", "ampere");
    public static final MeasureUnit COULOMB = internalGetInstance("electric", "coulomb");
    public static final MeasureUnit FARAD = internalGetInstance("electric", "farad");
    public static final MeasureUnit HENRY = internalGetInstance("electric", "henry");
    public static final MeasureUnit MILLIAMPERE = internalGetInstance("electric", "milliampere");
    public static final MeasureUnit OHM = internalGetInstance("electric", "ohm");
    public static final MeasureUnit SIEMENS = internalGetInstance("electric", "siemens");
    public static final MeasureUnit VOLT = internalGetInstance("electric", "volt");
    public static final MeasureUnit BECQUEREL = internalGetInstance("energy", "becquerel");
    public static final MeasureUnit BRITISH_THERMAL_UNIT = internalGetInstance("energy", "british-thermal-unit");
    public static final MeasureUnit BRITISH_THERMAL_UNIT_IT = internalGetInstance("energy", "british-thermal-unit-it");
    public static final MeasureUnit CALORIE = internalGetInstance("energy", "calorie");
    public static final MeasureUnit CALORIE_IT = internalGetInstance("energy", "calorie-it");
    public static final MeasureUnit ELECTRONVOLT = internalGetInstance("energy", "electronvolt");
    public static final MeasureUnit FOODCALORIE = internalGetInstance("energy", "foodcalorie");
    public static final MeasureUnit GRAY = internalGetInstance("energy", "gray");
    public static final MeasureUnit JOULE = internalGetInstance("energy", "joule");
    public static final MeasureUnit KILOCALORIE = internalGetInstance("energy", "kilocalorie");
    public static final MeasureUnit KILOJOULE = internalGetInstance("energy", "kilojoule");
    public static final MeasureUnit KILOWATT_HOUR = internalGetInstance("energy", "kilowatt-hour");
    public static final MeasureUnit SIEVERT = internalGetInstance("energy", "sievert");
    public static final MeasureUnit THERM_US = internalGetInstance("energy", "therm-us");
    public static final MeasureUnit DYNE = internalGetInstance("force", "dyne");
    public static final MeasureUnit KILOGRAM_FORCE = internalGetInstance("force", "kilogram-force");
    public static final MeasureUnit KILOWATT_HOUR_PER_100_KILOMETER = internalGetInstance("force", "kilowatt-hour-per-100-kilometer");
    public static final MeasureUnit NEWTON = internalGetInstance("force", "newton");
    public static final MeasureUnit POUND_FORCE = internalGetInstance("force", "pound-force");
    public static final MeasureUnit POUNDAL = internalGetInstance("force", "poundal");
    public static final MeasureUnit GIGAHERTZ = internalGetInstance("frequency", "gigahertz");
    public static final MeasureUnit HERTZ = internalGetInstance("frequency", "hertz");
    public static final MeasureUnit KILOHERTZ = internalGetInstance("frequency", "kilohertz");
    public static final MeasureUnit MEGAHERTZ = internalGetInstance("frequency", "megahertz");
    public static final MeasureUnit DOT = internalGetInstance("graphics", "dot");
    public static final MeasureUnit DOT_PER_CENTIMETER = internalGetInstance("graphics", "dot-per-centimeter");
    public static final MeasureUnit DOT_PER_INCH = internalGetInstance("graphics", "dot-per-inch");
    public static final MeasureUnit EM = internalGetInstance("graphics", "em");
    public static final MeasureUnit MEGAPIXEL = internalGetInstance("graphics", "megapixel");
    public static final MeasureUnit PIXEL = internalGetInstance("graphics", "pixel");
    public static final MeasureUnit PIXEL_PER_CENTIMETER = internalGetInstance("graphics", "pixel-per-centimeter");
    public static final MeasureUnit PIXEL_PER_INCH = internalGetInstance("graphics", "pixel-per-inch");
    public static final MeasureUnit ASTRONOMICAL_UNIT = internalGetInstance("length", "astronomical-unit");
    public static final MeasureUnit CENTIMETER = internalGetInstance("length", "centimeter");
    public static final MeasureUnit CHAIN = internalGetInstance("length", "chain");
    public static final MeasureUnit DECIMETER = internalGetInstance("length", "decimeter");
    public static final MeasureUnit EARTH_RADIUS = internalGetInstance("length", "earth-radius");
    public static final MeasureUnit FATHOM = internalGetInstance("length", "fathom");
    public static final MeasureUnit FOOT = internalGetInstance("length", "foot");
    public static final MeasureUnit FURLONG = internalGetInstance("length", "furlong");
    public static final MeasureUnit INCH = internalGetInstance("length", "inch");
    public static final MeasureUnit JO_JP = internalGetInstance("length", "jo-jp");
    public static final MeasureUnit KEN = internalGetInstance("length", "ken");
    public static final MeasureUnit KILOMETER = internalGetInstance("length", "kilometer");
    public static final MeasureUnit LIGHT_YEAR = internalGetInstance("length", "light-year");
    public static final MeasureUnit METER = internalGetInstance("length", "meter");
    public static final MeasureUnit MICROMETER = internalGetInstance("length", "micrometer");
    public static final MeasureUnit MILE = internalGetInstance("length", "mile");
    public static final MeasureUnit MILE_SCANDINAVIAN = internalGetInstance("length", "mile-scandinavian");
    public static final MeasureUnit MILLIINCH = internalGetInstance("length", "milliinch");
    public static final MeasureUnit MILLIMETER = internalGetInstance("length", "millimeter");
    public static final MeasureUnit NANOMETER = internalGetInstance("length", "nanometer");
    public static final MeasureUnit NAUTICAL_MILE = internalGetInstance("length", "nautical-mile");
    public static final MeasureUnit PARSEC = internalGetInstance("length", "parsec");
    public static final MeasureUnit PICOMETER = internalGetInstance("length", "picometer");
    public static final MeasureUnit POINT = internalGetInstance("length", "point");
    public static final MeasureUnit RI_JP = internalGetInstance("length", "ri-jp");
    public static final MeasureUnit RIN = internalGetInstance("length", "rin");
    public static final MeasureUnit ROD = internalGetInstance("length", "rod");
    public static final MeasureUnit SHAKU_CLOTH = internalGetInstance("length", "shaku-cloth");
    public static final MeasureUnit SHAKU_LENGTH = internalGetInstance("length", "shaku-length");
    public static final MeasureUnit SOLAR_RADIUS = internalGetInstance("length", "solar-radius");
    public static final MeasureUnit SUN = internalGetInstance("length", "sun");
    public static final MeasureUnit YARD = internalGetInstance("length", "yard");
    public static final MeasureUnit CANDELA = internalGetInstance("light", "candela");
    public static final MeasureUnit LUMEN = internalGetInstance("light", "lumen");
    public static final MeasureUnit LUX = internalGetInstance("light", "lux");
    public static final MeasureUnit SOLAR_LUMINOSITY = internalGetInstance("light", "solar-luminosity");
    public static final MeasureUnit TESLA = internalGetInstance("magnetic", "tesla");
    public static final MeasureUnit WEBER = internalGetInstance("magnetic", "weber");
    public static final MeasureUnit CARAT = internalGetInstance("mass", "carat");
    public static final MeasureUnit DALTON = internalGetInstance("mass", "dalton");
    public static final MeasureUnit EARTH_MASS = internalGetInstance("mass", "earth-mass");
    public static final MeasureUnit FUN = internalGetInstance("mass", "fun");
    public static final MeasureUnit GRAIN = internalGetInstance("mass", "grain");
    public static final MeasureUnit GRAM = internalGetInstance("mass", "gram");
    public static final MeasureUnit KILOGRAM = internalGetInstance("mass", "kilogram");
    public static final MeasureUnit MICROGRAM = internalGetInstance("mass", "microgram");
    public static final MeasureUnit MILLIGRAM = internalGetInstance("mass", "milligram");
    public static final MeasureUnit OUNCE = internalGetInstance("mass", "ounce");
    public static final MeasureUnit OUNCE_TROY = internalGetInstance("mass", "ounce-troy");
    public static final MeasureUnit POUND = internalGetInstance("mass", "pound");
    public static final MeasureUnit SLUG = internalGetInstance("mass", "slug");
    public static final MeasureUnit SOLAR_MASS = internalGetInstance("mass", "solar-mass");
    public static final MeasureUnit STONE = internalGetInstance("mass", "stone");
    public static final MeasureUnit TON = internalGetInstance("mass", "ton");
    public static final MeasureUnit TONNE = internalGetInstance("mass", "tonne");

    @Deprecated
    public static final MeasureUnit METRIC_TON = internalGetInstance("mass", "tonne");
    public static final MeasureUnit GIGAWATT = internalGetInstance("power", "gigawatt");
    public static final MeasureUnit HORSEPOWER = internalGetInstance("power", "horsepower");
    public static final MeasureUnit KILOWATT = internalGetInstance("power", "kilowatt");
    public static final MeasureUnit MEGAWATT = internalGetInstance("power", "megawatt");
    public static final MeasureUnit MILLIWATT = internalGetInstance("power", "milliwatt");
    public static final MeasureUnit WATT = internalGetInstance("power", "watt");
    public static final MeasureUnit ATMOSPHERE = internalGetInstance("pressure", "atmosphere");
    public static final MeasureUnit BAR = internalGetInstance("pressure", "bar");
    public static final MeasureUnit GASOLINE_ENERGY_DENSITY = internalGetInstance("pressure", "gasoline-energy-density");
    public static final MeasureUnit HECTOPASCAL = internalGetInstance("pressure", "hectopascal");
    public static final MeasureUnit INCH_HG = internalGetInstance("pressure", "inch-ofhg");
    public static final MeasureUnit KILOPASCAL = internalGetInstance("pressure", "kilopascal");
    public static final MeasureUnit MEGAPASCAL = internalGetInstance("pressure", "megapascal");
    public static final MeasureUnit MILLIBAR = internalGetInstance("pressure", "millibar");
    public static final MeasureUnit MILLIMETER_OF_MERCURY = internalGetInstance("pressure", "millimeter-ofhg");
    public static final MeasureUnit OFHG = internalGetInstance("pressure", "ofhg");
    public static final MeasureUnit PASCAL = internalGetInstance("pressure", "pascal");
    public static final MeasureUnit POUND_PER_SQUARE_INCH = internalGetInstance("pressure", "pound-force-per-square-inch");
    public static final MeasureUnit BEAUFORT = internalGetInstance("speed", "beaufort");
    public static final MeasureUnit KILOMETER_PER_HOUR = internalGetInstance("speed", "kilometer-per-hour");
    public static final MeasureUnit KNOT = internalGetInstance("speed", "knot");
    public static final MeasureUnit LIGHT_SPEED = internalGetInstance("speed", "light-speed");
    public static final MeasureUnit METER_PER_SECOND = internalGetInstance("speed", "meter-per-second");
    public static final MeasureUnit MILE_PER_HOUR = internalGetInstance("speed", "mile-per-hour");
    public static final MeasureUnit CELSIUS = internalGetInstance("temperature", "celsius");
    public static final MeasureUnit FAHRENHEIT = internalGetInstance("temperature", "fahrenheit");
    public static final MeasureUnit GENERIC_TEMPERATURE = internalGetInstance("temperature", "generic");
    public static final MeasureUnit KELVIN = internalGetInstance("temperature", "kelvin");
    public static final MeasureUnit RANKINE = internalGetInstance("temperature", "rankine");
    public static final MeasureUnit NEWTON_METER = internalGetInstance("torque", "newton-meter");
    public static final MeasureUnit POUND_FOOT = internalGetInstance("torque", "pound-force-foot");
    public static final MeasureUnit ACRE_FOOT = internalGetInstance("volume", "acre-foot");
    public static final MeasureUnit BARREL = internalGetInstance("volume", "barrel");
    public static final MeasureUnit BUSHEL = internalGetInstance("volume", "bushel");
    public static final MeasureUnit CENTILITER = internalGetInstance("volume", "centiliter");
    public static final MeasureUnit CUBIC_CENTIMETER = internalGetInstance("volume", "cubic-centimeter");
    public static final MeasureUnit CUBIC_FOOT = internalGetInstance("volume", "cubic-foot");
    public static final MeasureUnit CUBIC_INCH = internalGetInstance("volume", "cubic-inch");
    public static final MeasureUnit CUBIC_KILOMETER = internalGetInstance("volume", "cubic-kilometer");
    public static final MeasureUnit CUBIC_METER = internalGetInstance("volume", "cubic-meter");
    public static final MeasureUnit CUBIC_MILE = internalGetInstance("volume", "cubic-mile");
    public static final MeasureUnit CUBIC_YARD = internalGetInstance("volume", "cubic-yard");
    public static final MeasureUnit CUP = internalGetInstance("volume", "cup");
    public static final MeasureUnit CUP_IMPERIAL = internalGetInstance("volume", "cup-imperial");
    public static final MeasureUnit CUP_JP = internalGetInstance("volume", "cup-jp");
    public static final MeasureUnit CUP_METRIC = internalGetInstance("volume", "cup-metric");
    public static final MeasureUnit DECILITER = internalGetInstance("volume", "deciliter");
    public static final MeasureUnit DESSERT_SPOON = internalGetInstance("volume", "dessert-spoon");
    public static final MeasureUnit DESSERT_SPOON_IMPERIAL = internalGetInstance("volume", "dessert-spoon-imperial");
    public static final MeasureUnit DRAM = internalGetInstance("volume", "dram");
    public static final MeasureUnit DROP = internalGetInstance("volume", "drop");
    public static final MeasureUnit FLUID_OUNCE = internalGetInstance("volume", "fluid-ounce");
    public static final MeasureUnit FLUID_OUNCE_IMPERIAL = internalGetInstance("volume", "fluid-ounce-imperial");
    public static final MeasureUnit FLUID_OUNCE_METRIC = internalGetInstance("volume", "fluid-ounce-metric");
    public static final MeasureUnit GALLON = internalGetInstance("volume", "gallon");
    public static final MeasureUnit GALLON_IMPERIAL = internalGetInstance("volume", "gallon-imperial");
    public static final MeasureUnit HECTOLITER = internalGetInstance("volume", "hectoliter");
    public static final MeasureUnit JIGGER = internalGetInstance("volume", "jigger");
    public static final MeasureUnit KOKU = internalGetInstance("volume", "koku");
    public static final MeasureUnit KOSAJI = internalGetInstance("volume", "kosaji");
    public static final MeasureUnit LITER = internalGetInstance("volume", "liter");
    public static final MeasureUnit MEGALITER = internalGetInstance("volume", "megaliter");
    public static final MeasureUnit MILLILITER = internalGetInstance("volume", "milliliter");
    public static final MeasureUnit OSAJI = internalGetInstance("volume", "osaji");
    public static final MeasureUnit PINCH = internalGetInstance("volume", "pinch");
    public static final MeasureUnit PINT = internalGetInstance("volume", "pint");
    public static final MeasureUnit PINT_IMPERIAL = internalGetInstance("volume", "pint-imperial");
    public static final MeasureUnit PINT_METRIC = internalGetInstance("volume", "pint-metric");
    public static final MeasureUnit QUART = internalGetInstance("volume", "quart");
    public static final MeasureUnit QUART_IMPERIAL = internalGetInstance("volume", "quart-imperial");
    public static final MeasureUnit SAI = internalGetInstance("volume", "sai");
    public static final MeasureUnit SHAKU = internalGetInstance("volume", "shaku");
    public static final MeasureUnit TABLESPOON = internalGetInstance("volume", "tablespoon");
    public static final MeasureUnit TEASPOON = internalGetInstance("volume", "teaspoon");
    public static final MeasureUnit TO_JP = internalGetInstance("volume", "to-jp");

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public enum Complexity {
        SINGLE,
        COMPOUND,
        MIXED
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    @Deprecated
    public interface Factory {
        @Deprecated
        MeasureUnit create(String str, String str2);
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public enum MeasurePrefix {
        QUETTA(30, "quetta", 10),
        RONNA(27, "ronna", 10),
        YOTTA(24, "yotta", 10),
        ZETTA(21, "zetta", 10),
        EXA(18, "exa", 10),
        PETA(15, "peta", 10),
        TERA(12, "tera", 10),
        GIGA(9, "giga", 10),
        MEGA(6, "mega", 10),
        KILO(3, "kilo", 10),
        HECTO(2, "hecto", 10),
        DEKA(1, "deka", 10),
        ONE(0, "", 10),
        DECI(-1, "deci", 10),
        CENTI(-2, "centi", 10),
        MILLI(-3, "milli", 10),
        MICRO(-6, "micro", 10),
        NANO(-9, "nano", 10),
        PICO(-12, "pico", 10),
        FEMTO(-15, "femto", 10),
        ATTO(-18, "atto", 10),
        ZEPTO(-21, "zepto", 10),
        YOCTO(-24, "yocto", 10),
        RONTO(-27, "ronto", 10),
        QUECTO(-30, "quecto", 10),
        KIBI(1, "kibi", 1024),
        MEBI(2, "mebi", 1024),
        GIBI(3, "gibi", 1024),
        TEBI(4, "tebi", 1024),
        PEBI(5, "pebi", 1024),
        EXBI(6, "exbi", 1024),
        ZEBI(7, "zebi", 1024),
        YOBI(8, "yobi", 1024);

        private final int base;
        private final String identifier;
        private final int power;

        MeasurePrefix(int i, String str, int i2) {
            this.base = i2;
            this.power = i;
            this.identifier = str;
        }

        public int getBase() {
            return this.base;
        }

        @Deprecated
        public String getIdentifier() {
            return this.identifier;
        }

        public int getPower() {
            return this.power;
        }
    }

    private MeasureUnit(MeasureUnitImpl measureUnitImpl) {
        this.type = null;
        this.subType = null;
        this.measureUnitImpl = measureUnitImpl.copy();
    }

    @Deprecated
    public static MeasureUnit addUnit(String str, String str2, Factory factory) {
        Map<String, MeasureUnit> mapComputeIfAbsent = cache.computeIfAbsent(str, new mc1(3));
        MeasureUnit measureUnit = mapComputeIfAbsent.get(str2);
        if (measureUnit != null) {
            return measureUnit;
        }
        synchronized (mapComputeIfAbsent) {
            try {
                MeasureUnit measureUnit2 = mapComputeIfAbsent.get(str2);
                if (measureUnit2 != null) {
                    return measureUnit2;
                }
                if (!mapComputeIfAbsent.isEmpty()) {
                    str = mapComputeIfAbsent.values().iterator().next().type;
                }
                MeasureUnit measureUnitCreate = factory.create(str, str2);
                mapComputeIfAbsent.put(str2, measureUnitCreate);
                return measureUnitCreate;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Deprecated
    public static MeasureUnit findBySubType(String str) {
        populateCache();
        for (Map<String, MeasureUnit> map : cache.values()) {
            if (map.containsKey(str)) {
                return map.get(str);
            }
        }
        return null;
    }

    public static MeasureUnit forIdentifier(String str) {
        return (str == null || str.isEmpty()) ? NoUnit.BASE : MeasureUnitImpl.forIdentifier(str).build();
    }

    @Deprecated
    public static MeasureUnit fromMeasureUnitImpl(MeasureUnitImpl measureUnitImpl) {
        measureUnitImpl.serialize();
        MeasureUnit measureUnitFindBySubType = findBySubType(measureUnitImpl.getIdentifier());
        return measureUnitFindBySubType != null ? measureUnitFindBySubType : new MeasureUnit(measureUnitImpl);
    }

    public static Set<MeasureUnit> getAvailable() {
        HashSet hashSet = new HashSet();
        Iterator it = new HashSet(getAvailableTypes()).iterator();
        while (it.hasNext()) {
            Iterator<MeasureUnit> it2 = getAvailable((String) it.next()).iterator();
            while (it2.hasNext()) {
                hashSet.add(it2.next());
            }
        }
        return Collections.unmodifiableSet(hashSet);
    }

    public static Set<String> getAvailableTypes() {
        populateCache();
        return Collections.unmodifiableSet(cache.keySet());
    }

    private MeasureUnitImpl getMaybeReferenceOfMeasureUnitImpl() {
        MeasureUnitImpl measureUnitImpl = this.measureUnitImpl;
        return measureUnitImpl == null ? MeasureUnitImpl.forIdentifier(getIdentifier()) : measureUnitImpl;
    }

    private SingleUnitImpl getSingleUnitImpl() {
        MeasureUnitImpl measureUnitImpl = this.measureUnitImpl;
        return measureUnitImpl == null ? MeasureUnitImpl.forIdentifier(getIdentifier()).getSingleUnitImpl() : measureUnitImpl.getSingleUnitImpl();
    }

    @Deprecated
    public static MeasureUnit getUnit(String str, String str2) {
        populateCache();
        Map<String, MeasureUnit> map = cache.get(str);
        if (map != null) {
            return map.get(str2);
        }
        return null;
    }

    @Deprecated
    public static MeasureUnit internalGetInstance(String str, String str2) {
        Factory factory;
        if (str == null || str2 == null) {
            dk0.n("Type and subType must be non-null");
            return null;
        }
        if (!"currency".equals(str) && (!ASCII.containsAll(str) || !ASCII_HYPHEN_DIGITS.containsAll(str2))) {
            og.i("The type or subType are invalid.");
            return null;
        }
        if ("currency".equals(str)) {
            factory = CURRENCY_FACTORY;
        } else {
            factory = "duration".equals(str) ? TIMEUNIT_FACTORY : UNIT_FACTORY;
        }
        return addUnit(str, str2, factory);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Map lambda$addUnit$0(String str) {
        return new ConcurrentHashMap();
    }

    private static void populateCache() {
        if (cacheIsPopulated) {
            return;
        }
        synchronized (MEASURE_UNIT_LOCK) {
            try {
                if (cacheIsPopulated) {
                    return;
                }
                if (cacheIsLoading) {
                    return;
                }
                cacheIsLoading = true;
                int i = 0;
                try {
                    ((ICUResourceBundle) UResourceBundle.getBundleInstance(ICUData.ICU_UNIT_BASE_NAME, "en")).getAllItemsWithFallback("units", new MeasureUnitSink(i));
                    ((ICUResourceBundle) UResourceBundle.getBundleInstance(ICUData.ICU_BASE_NAME, "currencyNumericCodes", ICUResourceBundle.ICU_DATA_CLASS_LOADER)).getAllItemsWithFallback("codeMap", new CurrencyNumericCodeSink(i));
                    cacheIsPopulated = true;
                    cacheIsLoading = false;
                } catch (Throwable th) {
                    cacheIsLoading = false;
                    throw th;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Deprecated
    public static MeasureUnit validateAndGet(String str, String str2) {
        MeasureUnit unit = getUnit(str, str2);
        if (unit == null) {
            try {
                unit = forIdentifier(str2);
                if (!unit.getType().equals(str)) {
                    return null;
                }
            } catch (IllegalArgumentException unused) {
            }
        }
        return unit;
    }

    private Object writeReplace() {
        return new MeasureUnitProxy(this.type, this.subType);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof MeasureUnit) {
            return getIdentifier().equals(((MeasureUnit) obj).getIdentifier());
        }
        return false;
    }

    public Complexity getComplexity() {
        MeasureUnitImpl measureUnitImpl = this.measureUnitImpl;
        return measureUnitImpl == null ? MeasureUnitImpl.forIdentifier(getIdentifier()).getComplexity() : measureUnitImpl.getComplexity();
    }

    public long getConstantDenominator() {
        MeasureUnitImpl copyOfMeasureUnitImpl = getCopyOfMeasureUnitImpl();
        if (copyOfMeasureUnitImpl.getComplexity() == Complexity.COMPOUND || copyOfMeasureUnitImpl.getComplexity() == Complexity.SINGLE) {
            return copyOfMeasureUnitImpl.getConstantDenominator();
        }
        dk0.r("Constant denominator is only supported for COMPOUND & SINGLE units");
        return 0L;
    }

    @Deprecated
    public MeasureUnitImpl getCopyOfMeasureUnitImpl() {
        MeasureUnitImpl measureUnitImpl = this.measureUnitImpl;
        return measureUnitImpl == null ? MeasureUnitImpl.forIdentifier(getIdentifier()) : measureUnitImpl.copy();
    }

    public int getDimensionality() {
        return getSingleUnitImpl().getDimensionality();
    }

    public String getIdentifier() {
        MeasureUnitImpl measureUnitImpl = this.measureUnitImpl;
        String subtype = measureUnitImpl == null ? getSubtype() : measureUnitImpl.getIdentifier();
        return subtype == null ? "" : subtype;
    }

    public MeasurePrefix getPrefix() {
        return getSingleUnitImpl().getPrefix();
    }

    public String getSubtype() {
        return this.subType;
    }

    public String getType() {
        return this.type;
    }

    public int hashCode() {
        return this.subType.hashCode() + (this.type.hashCode() * 31);
    }

    public MeasureUnit product(MeasureUnit measureUnit) {
        MeasureUnitImpl copyOfMeasureUnitImpl = getCopyOfMeasureUnitImpl();
        if (measureUnit == null) {
            return copyOfMeasureUnitImpl.build();
        }
        MeasureUnitImpl maybeReferenceOfMeasureUnitImpl = measureUnit.getMaybeReferenceOfMeasureUnitImpl();
        Complexity complexity = copyOfMeasureUnitImpl.getComplexity();
        Complexity complexity2 = Complexity.MIXED;
        if (complexity == complexity2 || maybeReferenceOfMeasureUnitImpl.getComplexity() == complexity2) {
            dk0.p();
            return null;
        }
        ArrayList<SingleUnitImpl> singleUnits = maybeReferenceOfMeasureUnitImpl.getSingleUnits();
        int size = singleUnits.size();
        int i = 0;
        while (i < size) {
            SingleUnitImpl singleUnitImpl = singleUnits.get(i);
            i++;
            copyOfMeasureUnitImpl.appendSingleUnit(singleUnitImpl);
        }
        long constantDenominator = copyOfMeasureUnitImpl.getConstantDenominator();
        long constantDenominator2 = maybeReferenceOfMeasureUnitImpl.getConstantDenominator();
        if (constantDenominator == 0 || constantDenominator2 == 0) {
            copyOfMeasureUnitImpl.setConstantDenominator(Math.max(constantDenominator, constantDenominator2));
            return copyOfMeasureUnitImpl.build();
        }
        dk0.r("Cannot multiply units that both of them have a constant denominator");
        return null;
    }

    public MeasureUnit reciprocal() {
        if (getComplexity() == Complexity.COMPOUND && getConstantDenominator() != 0) {
            dk0.r("Cannot take reciprocal of a unit with a constant denominator");
            return null;
        }
        MeasureUnitImpl copyOfMeasureUnitImpl = getCopyOfMeasureUnitImpl();
        copyOfMeasureUnitImpl.takeReciprocal();
        return copyOfMeasureUnitImpl.build();
    }

    public List<MeasureUnit> splitToSingleUnits() {
        ArrayList<SingleUnitImpl> singleUnits = getMaybeReferenceOfMeasureUnitImpl().getSingleUnits();
        ArrayList arrayList = new ArrayList(singleUnits.size());
        int size = singleUnits.size();
        int i = 0;
        while (i < size) {
            SingleUnitImpl singleUnitImpl = singleUnits.get(i);
            i++;
            arrayList.add(singleUnitImpl.build());
        }
        return arrayList;
    }

    public String toString() {
        MeasureUnitImpl measureUnitImpl = this.measureUnitImpl;
        String strK = measureUnitImpl == null ? cq.k(this.type, LanguageTag.SEP, this.subType) : measureUnitImpl.getIdentifier();
        return strK == null ? "" : strK;
    }

    public MeasureUnit withConstantDenominator(long j) {
        if (j < 0) {
            og.i("Denominator cannot be negative");
            return null;
        }
        Complexity complexity = getComplexity();
        Complexity complexity2 = Complexity.COMPOUND;
        if (complexity != complexity2 && getComplexity() != Complexity.SINGLE) {
            dk0.r("Constant denominator can only be applied to COMPOUND & SINGLE units");
            return null;
        }
        MeasureUnitImpl copyOfMeasureUnitImpl = getCopyOfMeasureUnitImpl();
        copyOfMeasureUnitImpl.setConstantDenominator(j);
        if (j == 0 && copyOfMeasureUnitImpl.getSingleUnits().size() < 2) {
            complexity2 = Complexity.SINGLE;
        }
        copyOfMeasureUnitImpl.setComplexity(complexity2);
        return copyOfMeasureUnitImpl.build();
    }

    public MeasureUnit withDimensionality(int i) {
        SingleUnitImpl singleUnitImpl = getSingleUnitImpl();
        singleUnitImpl.setDimensionality(i);
        return singleUnitImpl.build();
    }

    public MeasureUnit withPrefix(MeasurePrefix measurePrefix) {
        SingleUnitImpl singleUnitImpl = getSingleUnitImpl();
        singleUnitImpl.setPrefix(measurePrefix);
        return singleUnitImpl.build();
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class CurrencyNumericCodeSink extends UResource.Sink {
        public /* synthetic */ CurrencyNumericCodeSink(int i) {
            this();
        }

        @Override // com.ibm.icu.impl.UResource.Sink
        public void put(UResource.Key key, UResource.Value value, boolean z) {
            UResource.Table table = value.getTable();
            for (int i = 0; table.getKeyAndValue(i, key, value); i++) {
                MeasureUnit.internalGetInstance("currency", key.toString());
            }
        }

        private CurrencyNumericCodeSink() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class MeasureUnitSink extends UResource.Sink {
        public /* synthetic */ MeasureUnitSink(int i) {
            this();
        }

        @Override // com.ibm.icu.impl.UResource.Sink
        public void put(UResource.Key key, UResource.Value value, boolean z) {
            UResource.Table table = value.getTable();
            for (int i = 0; table.getKeyAndValue(i, key, value); i++) {
                if (!key.contentEquals("compound") && !key.contentEquals("coordinate")) {
                    String string = key.toString();
                    UResource.Table table2 = value.getTable();
                    for (int i2 = 0; table2.getKeyAndValue(i2, key, value); i2++) {
                        MeasureUnit.internalGetInstance(string, key.toString());
                    }
                }
            }
        }

        private MeasureUnitSink() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class MeasureUnitProxy implements Externalizable {
        private static final long serialVersionUID = -3910681415330989598L;
        private String subType;
        private String type;

        public MeasureUnitProxy(String str, String str2) {
            this.type = str;
            this.subType = str2;
        }

        private Object readResolve() {
            return MeasureUnit.internalGetInstance(this.type, this.subType);
        }

        @Override // java.io.Externalizable
        public void readExternal(ObjectInput objectInput) throws IOException {
            objectInput.readByte();
            this.type = objectInput.readUTF();
            this.subType = objectInput.readUTF();
            int i = objectInput.readShort();
            if (i > 0) {
                objectInput.read(new byte[i], 0, i);
            }
        }

        @Override // java.io.Externalizable
        public void writeExternal(ObjectOutput objectOutput) throws IOException {
            objectOutput.writeByte(0);
            objectOutput.writeUTF(this.type);
            objectOutput.writeUTF(this.subType);
            objectOutput.writeShort(0);
        }

        public MeasureUnitProxy() {
        }
    }

    @Deprecated
    public MeasureUnit(String str, String str2) {
        this.type = str;
        this.subType = str2;
    }

    public static Set<MeasureUnit> getAvailable(String str) {
        populateCache();
        Map<String, MeasureUnit> map = cache.get(str);
        if (map == null) {
            return Collections.EMPTY_SET;
        }
        return Collections.unmodifiableSet(new CollectionSet(map.values()));
    }
}
