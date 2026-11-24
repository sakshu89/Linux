package com.ibm.icu.text;

import com.ibm.icu.impl.CacheBase;
import com.ibm.icu.impl.FormattedStringBuilder;
import com.ibm.icu.impl.FormattedValueStringBuilderImpl;
import com.ibm.icu.impl.ICUData;
import com.ibm.icu.impl.ICUResourceBundle;
import com.ibm.icu.impl.SimpleFormatterImpl;
import com.ibm.icu.impl.SoftCache;
import com.ibm.icu.impl.StandardPlural;
import com.ibm.icu.impl.UResource;
import com.ibm.icu.impl.Utility;
import com.ibm.icu.impl.number.DecimalQuantity_DualStorageBCD;
import com.ibm.icu.lang.UCharacter;
import com.ibm.icu.util.Calendar;
import com.ibm.icu.util.ULocale;
import com.ibm.icu.util.UResourceBundle;
import defpackage.cq;
import defpackage.dk0;
import defpackage.kf2;
import defpackage.og;
import java.io.InvalidObjectException;
import java.lang.reflect.Array;
import java.text.AttributedCharacterIterator;
import java.text.Format;
import java.util.EnumMap;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class RelativeDateTimeFormatter {
    private final BreakIterator breakIterator;
    private final DisplayContext capitalizationContext;
    private final String combinedDateAndTime;
    private final DateFormatSymbols dateFormatSymbols;
    private final ULocale locale;
    private final NumberFormat numberFormat;
    private final EnumMap<Style, EnumMap<RelativeUnit, String[][]>> patternMap;
    private final PluralRules pluralRules;
    private final EnumMap<Style, EnumMap<AbsoluteUnit, EnumMap<Direction, String>>> qualitativeUnitMap;
    private final Style style;
    private int[] styleToDateFormatSymbolsWidth = {1, 3, 2};
    private static final Style[] fallbackCache = new Style[3];
    private static final Cache cache = new Cache(0);

    /* JADX INFO: renamed from: com.ibm.icu.text.RelativeDateTimeFormatter$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ibm$icu$text$RelativeDateTimeFormatter$RelativeDateTimeUnit;
        static final /* synthetic */ int[] $SwitchMap$com$ibm$icu$text$RelativeDateTimeFormatter$Style;

        static {
            int[] iArr = new int[Style.values().length];
            $SwitchMap$com$ibm$icu$text$RelativeDateTimeFormatter$Style = iArr;
            try {
                iArr[Style.SHORT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ibm$icu$text$RelativeDateTimeFormatter$Style[Style.NARROW.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[RelativeDateTimeUnit.values().length];
            $SwitchMap$com$ibm$icu$text$RelativeDateTimeFormatter$RelativeDateTimeUnit = iArr2;
            try {
                iArr2[RelativeDateTimeUnit.YEAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$ibm$icu$text$RelativeDateTimeFormatter$RelativeDateTimeUnit[RelativeDateTimeUnit.QUARTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$ibm$icu$text$RelativeDateTimeFormatter$RelativeDateTimeUnit[RelativeDateTimeUnit.MONTH.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$ibm$icu$text$RelativeDateTimeFormatter$RelativeDateTimeUnit[RelativeDateTimeUnit.WEEK.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$ibm$icu$text$RelativeDateTimeFormatter$RelativeDateTimeUnit[RelativeDateTimeUnit.DAY.ordinal()] = 5;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$ibm$icu$text$RelativeDateTimeFormatter$RelativeDateTimeUnit[RelativeDateTimeUnit.HOUR.ordinal()] = 6;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$ibm$icu$text$RelativeDateTimeFormatter$RelativeDateTimeUnit[RelativeDateTimeUnit.MINUTE.ordinal()] = 7;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$ibm$icu$text$RelativeDateTimeFormatter$RelativeDateTimeUnit[RelativeDateTimeUnit.SECOND.ordinal()] = 8;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$ibm$icu$text$RelativeDateTimeFormatter$RelativeDateTimeUnit[RelativeDateTimeUnit.SUNDAY.ordinal()] = 9;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$ibm$icu$text$RelativeDateTimeFormatter$RelativeDateTimeUnit[RelativeDateTimeUnit.MONDAY.ordinal()] = 10;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$ibm$icu$text$RelativeDateTimeFormatter$RelativeDateTimeUnit[RelativeDateTimeUnit.TUESDAY.ordinal()] = 11;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$ibm$icu$text$RelativeDateTimeFormatter$RelativeDateTimeUnit[RelativeDateTimeUnit.WEDNESDAY.ordinal()] = 12;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$com$ibm$icu$text$RelativeDateTimeFormatter$RelativeDateTimeUnit[RelativeDateTimeUnit.THURSDAY.ordinal()] = 13;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$com$ibm$icu$text$RelativeDateTimeFormatter$RelativeDateTimeUnit[RelativeDateTimeUnit.FRIDAY.ordinal()] = 14;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$com$ibm$icu$text$RelativeDateTimeFormatter$RelativeDateTimeUnit[RelativeDateTimeUnit.SATURDAY.ordinal()] = 15;
            } catch (NoSuchFieldError unused17) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public enum AbsoluteUnit {
        SUNDAY,
        MONDAY,
        TUESDAY,
        WEDNESDAY,
        THURSDAY,
        FRIDAY,
        SATURDAY,
        DAY,
        WEEK,
        MONTH,
        YEAR,
        NOW,
        QUARTER,
        HOUR,
        MINUTE
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public enum Direction {
        LAST_2,
        LAST,
        THIS,
        NEXT,
        NEXT_2,
        PLAIN
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class Field extends Format.Field {
        public static final Field LITERAL = new Field("literal");
        public static final Field NUMERIC = new Field("numeric");
        private static final long serialVersionUID = -5327685528663492325L;

        private Field(String str) {
            super(str);
        }

        @Override // java.text.AttributedCharacterIterator.Attribute
        @Deprecated
        public Object readResolve() throws InvalidObjectException {
            String name = getName();
            Field field = LITERAL;
            if (name.equals(field.getName())) {
                return field;
            }
            String name2 = getName();
            Field field2 = NUMERIC;
            if (name2.equals(field2.getName())) {
                return field2;
            }
            kf2.i("An invalid object.");
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class Loader {
        private final ULocale ulocale;

        public Loader(ULocale uLocale) {
            this.ulocale = uLocale;
        }

        private String getDateTimePattern() {
            return Calendar.getDateAtTimePattern(Calendar.getInstance(this.ulocale), this.ulocale, 2);
        }

        public RelativeDateTimeFormatterData load() {
            Style style;
            RelDateTimeDataSink relDateTimeDataSink = new RelDateTimeDataSink();
            ((ICUResourceBundle) UResourceBundle.getBundleInstance(ICUData.ICU_BASE_NAME, this.ulocale)).getAllItemsWithFallback("fields", relDateTimeDataSink);
            for (Style style2 : Style.values()) {
                Style style3 = RelativeDateTimeFormatter.fallbackCache[style2.ordinal()];
                if (style3 != null && (style = RelativeDateTimeFormatter.fallbackCache[style3.ordinal()]) != null && RelativeDateTimeFormatter.fallbackCache[style.ordinal()] != null) {
                    og.n("Style fallback too deep");
                    return null;
                }
            }
            return new RelativeDateTimeFormatterData(relDateTimeDataSink.qualitativeUnitMap, relDateTimeDataSink.styleRelUnitPatterns, getDateTimePattern());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class RelDateTimeDataSink extends UResource.Sink {
        int pastFutureIndex;
        Style style;
        DateTimeUnit unit;
        EnumMap<Style, EnumMap<AbsoluteUnit, EnumMap<Direction, String>>> qualitativeUnitMap = new EnumMap<>(Style.class);
        EnumMap<Style, EnumMap<RelativeUnit, String[][]>> styleRelUnitPatterns = new EnumMap<>(Style.class);
        StringBuilder sb = new StringBuilder();

        /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
        public enum DateTimeUnit {
            SECOND(RelativeUnit.SECONDS, null),
            MINUTE(RelativeUnit.MINUTES, AbsoluteUnit.MINUTE),
            HOUR(RelativeUnit.HOURS, AbsoluteUnit.HOUR),
            DAY(RelativeUnit.DAYS, AbsoluteUnit.DAY),
            WEEK(RelativeUnit.WEEKS, AbsoluteUnit.WEEK),
            MONTH(RelativeUnit.MONTHS, AbsoluteUnit.MONTH),
            QUARTER(RelativeUnit.QUARTERS, AbsoluteUnit.QUARTER),
            YEAR(RelativeUnit.YEARS, AbsoluteUnit.YEAR),
            SUNDAY(RelativeUnit.SUNDAYS, AbsoluteUnit.SUNDAY),
            MONDAY(RelativeUnit.MONDAYS, AbsoluteUnit.MONDAY),
            TUESDAY(RelativeUnit.TUESDAYS, AbsoluteUnit.TUESDAY),
            WEDNESDAY(RelativeUnit.WEDNESDAYS, AbsoluteUnit.WEDNESDAY),
            THURSDAY(RelativeUnit.THURSDAYS, AbsoluteUnit.THURSDAY),
            FRIDAY(RelativeUnit.FRIDAYS, AbsoluteUnit.FRIDAY),
            SATURDAY(RelativeUnit.SATURDAYS, AbsoluteUnit.SATURDAY);

            AbsoluteUnit absUnit;
            RelativeUnit relUnit;

            DateTimeUnit(RelativeUnit relativeUnit, AbsoluteUnit absoluteUnit) {
                this.relUnit = relativeUnit;
                this.absUnit = absoluteUnit;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final DateTimeUnit orNullFromString(CharSequence charSequence) {
                int length = charSequence.length();
                if (length == 3) {
                    if ("day".contentEquals(charSequence)) {
                        return DAY;
                    }
                    if ("sun".contentEquals(charSequence)) {
                        return SUNDAY;
                    }
                    if ("mon".contentEquals(charSequence)) {
                        return MONDAY;
                    }
                    if ("tue".contentEquals(charSequence)) {
                        return TUESDAY;
                    }
                    if ("wed".contentEquals(charSequence)) {
                        return WEDNESDAY;
                    }
                    if ("thu".contentEquals(charSequence)) {
                        return THURSDAY;
                    }
                    if ("fri".contentEquals(charSequence)) {
                        return FRIDAY;
                    }
                    if ("sat".contentEquals(charSequence)) {
                        return SATURDAY;
                    }
                    return null;
                }
                if (length == 4) {
                    if ("hour".contentEquals(charSequence)) {
                        return HOUR;
                    }
                    if ("week".contentEquals(charSequence)) {
                        return WEEK;
                    }
                    if ("year".contentEquals(charSequence)) {
                        return YEAR;
                    }
                    return null;
                }
                if (length == 5) {
                    if ("month".contentEquals(charSequence)) {
                        return MONTH;
                    }
                    return null;
                }
                if (length != 6) {
                    if (length == 7 && "quarter".contentEquals(charSequence)) {
                        return QUARTER;
                    }
                    return null;
                }
                if ("minute".contentEquals(charSequence)) {
                    return MINUTE;
                }
                if ("second".contentEquals(charSequence)) {
                    return SECOND;
                }
                return null;
            }
        }

        private void handleAlias(UResource.Key key, UResource.Value value, boolean z) {
            Style styleStyleFromKey = styleFromKey(key);
            if (DateTimeUnit.orNullFromString(key.substring(0, key.length() - styleSuffixLength(styleStyleFromKey))) != null) {
                Style styleStyleFromAlias = styleFromAlias(value);
                if (styleStyleFromKey == styleStyleFromAlias) {
                    og.q(cq.v("Invalid style fallback from ", String.valueOf(styleStyleFromKey), " to itself"));
                } else if (RelativeDateTimeFormatter.fallbackCache[styleStyleFromKey.ordinal()] == null) {
                    RelativeDateTimeFormatter.fallbackCache[styleStyleFromKey.ordinal()] = styleStyleFromAlias;
                } else {
                    if (RelativeDateTimeFormatter.fallbackCache[styleStyleFromKey.ordinal()] == styleStyleFromAlias) {
                        return;
                    }
                    og.q(cq.l("Inconsistent style fallback for style ", String.valueOf(styleStyleFromKey), " to ", String.valueOf(styleStyleFromAlias)));
                }
            }
        }

        private void handlePlainDirection(UResource.Key key, UResource.Value value) {
            AbsoluteUnit absoluteUnit = this.unit.absUnit;
            if (absoluteUnit == null) {
                return;
            }
            EnumMap<AbsoluteUnit, EnumMap<Direction, String>> enumMap = this.qualitativeUnitMap.get(this.style);
            if (enumMap == null) {
                enumMap = new EnumMap<>(AbsoluteUnit.class);
                this.qualitativeUnitMap.put(this.style, enumMap);
            }
            EnumMap<Direction, String> enumMap2 = enumMap.get(absoluteUnit);
            if (enumMap2 == null) {
                enumMap2 = new EnumMap<>(Direction.class);
                enumMap.put(absoluteUnit, enumMap2);
            }
            Direction direction = Direction.PLAIN;
            if (enumMap2.get(direction) == null) {
                enumMap2.put(direction, value.toString());
            }
        }

        private Style styleFromAlias(UResource.Value value) {
            String aliasString = value.getAliasString();
            if (aliasString.endsWith("-short")) {
                return Style.SHORT;
            }
            return aliasString.endsWith("-narrow") ? Style.NARROW : Style.LONG;
        }

        private Style styleFromKey(UResource.Key key) {
            if (key.endsWith("-short")) {
                return Style.SHORT;
            }
            return key.endsWith("-narrow") ? Style.NARROW : Style.LONG;
        }

        private static int styleSuffixLength(Style style) {
            int i = AnonymousClass1.$SwitchMap$com$ibm$icu$text$RelativeDateTimeFormatter$Style[style.ordinal()];
            if (i != 1) {
                return i != 2 ? 0 : 7;
            }
            return 6;
        }

        public void consumeTableRelative(UResource.Key key, UResource.Value value) {
            AbsoluteUnit absoluteUnit;
            UResource.Table table = value.getTable();
            for (int i = 0; table.getKeyAndValue(i, key, value); i++) {
                if (value.getType() == 0) {
                    String string = value.getString();
                    EnumMap<AbsoluteUnit, EnumMap<Direction, String>> enumMap = this.qualitativeUnitMap.get(this.style);
                    if (this.unit.relUnit == RelativeUnit.SECONDS && key.contentEquals("0")) {
                        AbsoluteUnit absoluteUnit2 = AbsoluteUnit.NOW;
                        EnumMap<Direction, String> enumMap2 = enumMap.get(absoluteUnit2);
                        if (enumMap2 == null) {
                            enumMap2 = new EnumMap<>(Direction.class);
                            enumMap.put(absoluteUnit2, enumMap2);
                        }
                        Direction direction = Direction.PLAIN;
                        if (enumMap2.get(direction) == null) {
                            enumMap2.put(direction, string);
                        }
                    } else {
                        Direction directionKeyToDirection = RelativeDateTimeFormatter.keyToDirection(key);
                        if (directionKeyToDirection != null && (absoluteUnit = this.unit.absUnit) != null) {
                            if (enumMap == null) {
                                enumMap = new EnumMap<>(AbsoluteUnit.class);
                                this.qualitativeUnitMap.put(this.style, enumMap);
                            }
                            EnumMap<Direction, String> enumMap3 = enumMap.get(absoluteUnit);
                            if (enumMap3 == null) {
                                enumMap3 = new EnumMap<>(Direction.class);
                                enumMap.put(absoluteUnit, enumMap3);
                            }
                            if (enumMap3.get(directionKeyToDirection) == null) {
                                enumMap3.put(directionKeyToDirection, value.getString());
                            }
                        }
                    }
                }
            }
        }

        public void consumeTableRelativeTime(UResource.Key key, UResource.Value value) {
            if (this.unit.relUnit == null) {
                return;
            }
            UResource.Table table = value.getTable();
            for (int i = 0; table.getKeyAndValue(i, key, value); i++) {
                if (key.contentEquals("past")) {
                    this.pastFutureIndex = 0;
                } else {
                    if (key.contentEquals("future")) {
                        this.pastFutureIndex = 1;
                    }
                }
                consumeTimeDetail(key, value);
            }
        }

        public void consumeTimeDetail(UResource.Key key, UResource.Value value) {
            UResource.Table table = value.getTable();
            EnumMap<RelativeUnit, String[][]> enumMap = this.styleRelUnitPatterns.get(this.style);
            if (enumMap == null) {
                enumMap = new EnumMap<>(RelativeUnit.class);
                this.styleRelUnitPatterns.put(this.style, enumMap);
            }
            String[][] strArr = enumMap.get(this.unit.relUnit);
            if (strArr == null) {
                strArr = (String[][]) Array.newInstance((Class<?>) String.class, 2, StandardPlural.COUNT);
                enumMap.put(this.unit.relUnit, strArr);
            }
            for (int i = 0; table.getKeyAndValue(i, key, value); i++) {
                if (value.getType() == 0) {
                    int iIndexFromString = StandardPlural.indexFromString(key.toString());
                    String[] strArr2 = strArr[this.pastFutureIndex];
                    if (strArr2[iIndexFromString] == null) {
                        strArr2[iIndexFromString] = SimpleFormatterImpl.compileToStringMinMaxArguments(value.getString(), this.sb, 0, 1);
                    }
                }
            }
        }

        public void consumeTimeUnit(UResource.Key key, UResource.Value value) {
            UResource.Table table = value.getTable();
            for (int i = 0; table.getKeyAndValue(i, key, value); i++) {
                if (key.contentEquals("dn") && value.getType() == 0) {
                    handlePlainDirection(key, value);
                }
                if (value.getType() == 2) {
                    if (key.contentEquals("relative")) {
                        consumeTableRelative(key, value);
                    } else if (key.contentEquals("relativeTime")) {
                        consumeTableRelativeTime(key, value);
                    }
                }
            }
        }

        @Override // com.ibm.icu.impl.UResource.Sink
        public void put(UResource.Key key, UResource.Value value, boolean z) {
            if (value.getType() == 3) {
                return;
            }
            UResource.Table table = value.getTable();
            for (int i = 0; table.getKeyAndValue(i, key, value); i++) {
                if (value.getType() == 3) {
                    handleAlias(key, value, z);
                } else {
                    this.style = styleFromKey(key);
                    DateTimeUnit dateTimeUnitOrNullFromString = DateTimeUnit.orNullFromString(key.substring(0, key.length() - styleSuffixLength(this.style)));
                    this.unit = dateTimeUnitOrNullFromString;
                    if (dateTimeUnitOrNullFromString != null) {
                        consumeTimeUnit(key, value);
                    }
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class RelativeDateTimeFormatterData {
        public final String dateTimePattern;
        public final EnumMap<Style, EnumMap<AbsoluteUnit, EnumMap<Direction, String>>> qualitativeUnitMap;
        EnumMap<Style, EnumMap<RelativeUnit, String[][]>> relUnitPatternMap;

        public RelativeDateTimeFormatterData(EnumMap<Style, EnumMap<AbsoluteUnit, EnumMap<Direction, String>>> enumMap, EnumMap<Style, EnumMap<RelativeUnit, String[][]>> enumMap2, String str) {
            this.qualitativeUnitMap = enumMap;
            this.relUnitPatternMap = enumMap2;
            this.dateTimePattern = str;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public enum RelativeDateTimeUnit {
        YEAR,
        QUARTER,
        MONTH,
        WEEK,
        DAY,
        HOUR,
        MINUTE,
        SECOND,
        SUNDAY,
        MONDAY,
        TUESDAY,
        WEDNESDAY,
        THURSDAY,
        FRIDAY,
        SATURDAY
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public enum RelativeUnit {
        SECONDS,
        MINUTES,
        HOURS,
        DAYS,
        WEEKS,
        MONTHS,
        YEARS,
        QUARTERS,
        SUNDAYS,
        MONDAYS,
        TUESDAYS,
        WEDNESDAYS,
        THURSDAYS,
        FRIDAYS,
        SATURDAYS
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public enum Style {
        LONG,
        SHORT,
        NARROW;

        private static final int INDEX_COUNT = 3;
    }

    private RelativeDateTimeFormatter(EnumMap<Style, EnumMap<AbsoluteUnit, EnumMap<Direction, String>>> enumMap, EnumMap<Style, EnumMap<RelativeUnit, String[][]>> enumMap2, String str, PluralRules pluralRules, NumberFormat numberFormat, Style style, DisplayContext displayContext, BreakIterator breakIterator, ULocale uLocale) {
        this.qualitativeUnitMap = enumMap;
        this.patternMap = enumMap2;
        this.combinedDateAndTime = str;
        this.pluralRules = pluralRules;
        this.numberFormat = numberFormat;
        this.style = style;
        if (displayContext.type() != DisplayContext.Type.CAPITALIZATION) {
            og.g(displayContext);
            throw null;
        }
        this.capitalizationContext = displayContext;
        this.breakIterator = breakIterator;
        this.locale = uLocale;
        this.dateFormatSymbols = new DateFormatSymbols(uLocale);
    }

    private String adjustForContext(String str) {
        String titleCase;
        if (this.breakIterator == null || str.length() == 0 || !UCharacter.isLowerCase(UCharacter.codePointAt(str, 0))) {
            return str;
        }
        synchronized (this.breakIterator) {
            titleCase = UCharacter.toTitleCase(this.locale, str, this.breakIterator, 768);
        }
        return titleCase;
    }

    private void checkNoAdjustForContext() {
        if (this.breakIterator == null) {
            return;
        }
        dk0.r("Capitalization context is not supported in formatV");
    }

    private String formatAbsoluteImpl(Direction direction, AbsoluteUnit absoluteUnit) {
        if (absoluteUnit == AbsoluteUnit.NOW && direction != Direction.PLAIN) {
            og.i("NOW can only accept direction PLAIN.");
            return null;
        }
        if (direction == Direction.PLAIN) {
            AbsoluteUnit absoluteUnit2 = AbsoluteUnit.SUNDAY;
            if (absoluteUnit2.ordinal() <= absoluteUnit.ordinal() && absoluteUnit.ordinal() <= AbsoluteUnit.SATURDAY.ordinal()) {
                return this.dateFormatSymbols.getWeekdays(1, this.styleToDateFormatSymbolsWidth[this.style.ordinal()])[(absoluteUnit.ordinal() - absoluteUnit2.ordinal()) + 1];
            }
        }
        return getAbsoluteUnitString(this.style, absoluteUnit, direction);
    }

    private FormattedStringBuilder formatImpl(double d, Direction direction, RelativeUnit relativeUnit) {
        String str;
        String strSelect;
        if (direction != Direction.LAST && direction != Direction.NEXT) {
            og.i("direction must be NEXT or LAST");
            return null;
        }
        int i = direction == Direction.NEXT ? 1 : 0;
        FormattedStringBuilder formattedStringBuilder = new FormattedStringBuilder();
        NumberFormat numberFormat = this.numberFormat;
        if (numberFormat instanceof DecimalFormat) {
            DecimalQuantity_DualStorageBCD decimalQuantity_DualStorageBCD = new DecimalQuantity_DualStorageBCD(d);
            ((DecimalFormat) this.numberFormat).toNumberFormatter().formatImpl(decimalQuantity_DualStorageBCD, formattedStringBuilder);
            strSelect = this.pluralRules.select(decimalQuantity_DualStorageBCD);
        } else {
            synchronized (numberFormat) {
                str = this.numberFormat.format(d);
            }
            formattedStringBuilder.append(str, (Object) null);
            strSelect = this.pluralRules.select(d);
        }
        SimpleFormatterImpl.formatPrefixSuffix(getRelativeUnitPluralPattern(this.style, relativeUnit, i, StandardPlural.orOtherFromString(strSelect)), Field.LITERAL, 0, formattedStringBuilder.length(), formattedStringBuilder);
        return formattedStringBuilder;
    }

    private FormattedStringBuilder formatNumericImpl(double d, RelativeDateTimeUnit relativeDateTimeUnit) {
        RelativeUnit relativeUnit = RelativeUnit.SECONDS;
        switch (AnonymousClass1.$SwitchMap$com$ibm$icu$text$RelativeDateTimeFormatter$RelativeDateTimeUnit[relativeDateTimeUnit.ordinal()]) {
            case 1:
                relativeUnit = RelativeUnit.YEARS;
                break;
            case 2:
                relativeUnit = RelativeUnit.QUARTERS;
                break;
            case 3:
                relativeUnit = RelativeUnit.MONTHS;
                break;
            case 4:
                relativeUnit = RelativeUnit.WEEKS;
                break;
            case 5:
                relativeUnit = RelativeUnit.DAYS;
                break;
            case 6:
                relativeUnit = RelativeUnit.HOURS;
                break;
            case 7:
                relativeUnit = RelativeUnit.MINUTES;
                break;
            case 9:
                relativeUnit = RelativeUnit.SUNDAYS;
                break;
            case 10:
                relativeUnit = RelativeUnit.MONDAYS;
                break;
            case 11:
                relativeUnit = RelativeUnit.TUESDAYS;
                break;
            case 12:
                relativeUnit = RelativeUnit.WEDNESDAYS;
                break;
            case 13:
                relativeUnit = RelativeUnit.THURSDAYS;
                break;
            case 14:
                relativeUnit = RelativeUnit.FRIDAYS;
                break;
            case 15:
                relativeUnit = RelativeUnit.SATURDAYS;
                break;
        }
        Direction direction = Direction.NEXT;
        if (Double.compare(d, 0.0d) < 0) {
            direction = Direction.LAST;
            d = -d;
        }
        return formatImpl(d, direction, relativeUnit);
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0047  */
    private CharSequence formatRelativeImpl(double d, RelativeDateTimeUnit relativeDateTimeUnit) {
        Direction direction;
        boolean z;
        String absoluteImpl;
        Direction direction2 = Direction.THIS;
        boolean z2 = true;
        if (d <= -2.1d || d >= 2.1d) {
            direction = direction2;
            z = true;
        } else {
            double d2 = 100.0d * d;
            int i = (int) (d2 < 0.0d ? d2 - 0.5d : d2 + 0.5d);
            z = false;
            if (i == -200) {
                direction = Direction.LAST_2;
            } else if (i == -100) {
                direction = Direction.LAST;
            } else if (i == 0) {
                direction = direction2;
            } else if (i == 100) {
                direction = Direction.NEXT;
            } else if (i != 200) {
                direction = direction2;
                z = true;
            } else {
                direction = Direction.NEXT_2;
            }
        }
        AbsoluteUnit absoluteUnit = AbsoluteUnit.NOW;
        switch (AnonymousClass1.$SwitchMap$com$ibm$icu$text$RelativeDateTimeFormatter$RelativeDateTimeUnit[relativeDateTimeUnit.ordinal()]) {
            case 1:
                absoluteUnit = AbsoluteUnit.YEAR;
                z2 = z;
                break;
            case 2:
                absoluteUnit = AbsoluteUnit.QUARTER;
                z2 = z;
                break;
            case 3:
                absoluteUnit = AbsoluteUnit.MONTH;
                z2 = z;
                break;
            case 4:
                absoluteUnit = AbsoluteUnit.WEEK;
                z2 = z;
                break;
            case 5:
                absoluteUnit = AbsoluteUnit.DAY;
                z2 = z;
                break;
            case 6:
                absoluteUnit = AbsoluteUnit.HOUR;
                z2 = z;
                break;
            case 7:
                absoluteUnit = AbsoluteUnit.MINUTE;
                z2 = z;
                break;
            case 8:
                if (direction == direction2) {
                    direction = Direction.PLAIN;
                    z2 = z;
                }
                break;
            case 9:
                absoluteUnit = AbsoluteUnit.SUNDAY;
                z2 = z;
                break;
            case 10:
                absoluteUnit = AbsoluteUnit.MONDAY;
                z2 = z;
                break;
            case 11:
                absoluteUnit = AbsoluteUnit.TUESDAY;
                z2 = z;
                break;
            case 12:
                absoluteUnit = AbsoluteUnit.WEDNESDAY;
                z2 = z;
                break;
            case 13:
                absoluteUnit = AbsoluteUnit.THURSDAY;
                z2 = z;
                break;
            case 14:
                absoluteUnit = AbsoluteUnit.FRIDAY;
                z2 = z;
                break;
            case 15:
                absoluteUnit = AbsoluteUnit.SATURDAY;
                z2 = z;
                break;
        }
        return (z2 || (absoluteImpl = formatAbsoluteImpl(direction, absoluteUnit)) == null || absoluteImpl.length() <= 0) ? formatNumericImpl(d, relativeDateTimeUnit) : absoluteImpl;
    }

    private String getAbsoluteUnitString(Style style, AbsoluteUnit absoluteUnit, Direction direction) {
        EnumMap<Direction, String> enumMap;
        String str;
        do {
            EnumMap<AbsoluteUnit, EnumMap<Direction, String>> enumMap2 = this.qualitativeUnitMap.get(style);
            if (enumMap2 != null && (enumMap = enumMap2.get(absoluteUnit)) != null && (str = enumMap.get(direction)) != null) {
                return str;
            }
            style = fallbackCache[style.ordinal()];
        } while (style != null);
        return null;
    }

    public static RelativeDateTimeFormatter getInstance(ULocale uLocale, NumberFormat numberFormat, Style style, DisplayContext displayContext) {
        RelativeDateTimeFormatterData relativeDateTimeFormatterData = cache.get(uLocale);
        return new RelativeDateTimeFormatter(relativeDateTimeFormatterData.qualitativeUnitMap, relativeDateTimeFormatterData.relUnitPatternMap, SimpleFormatterImpl.compileToStringMinMaxArguments(relativeDateTimeFormatterData.dateTimePattern, new StringBuilder(), 2, 2), PluralRules.forLocale(uLocale), numberFormat == null ? NumberFormat.getInstance(uLocale) : numberFormat.clone(), style, displayContext, displayContext == DisplayContext.CAPITALIZATION_FOR_BEGINNING_OF_SENTENCE ? BreakIterator.getSentenceInstance(uLocale) : null, uLocale);
    }

    private String getRelativeUnitPattern(Style style, RelativeUnit relativeUnit, int i, StandardPlural standardPlural) {
        String[][] strArr;
        String str;
        int iOrdinal = standardPlural.ordinal();
        do {
            EnumMap<RelativeUnit, String[][]> enumMap = this.patternMap.get(style);
            if (enumMap != null && (strArr = enumMap.get(relativeUnit)) != null && (str = strArr[i][iOrdinal]) != null) {
                return str;
            }
            style = fallbackCache[style.ordinal()];
        } while (style != null);
        return null;
    }

    private String getRelativeUnitPluralPattern(Style style, RelativeUnit relativeUnit, int i, StandardPlural standardPlural) {
        String relativeUnitPattern;
        StandardPlural standardPlural2 = StandardPlural.OTHER;
        return (standardPlural == standardPlural2 || (relativeUnitPattern = getRelativeUnitPattern(style, relativeUnit, i, standardPlural)) == null) ? getRelativeUnitPattern(style, relativeUnit, i, standardPlural2) : relativeUnitPattern;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Direction keyToDirection(UResource.Key key) {
        if (key.contentEquals("-2")) {
            return Direction.LAST_2;
        }
        if (key.contentEquals("-1")) {
            return Direction.LAST;
        }
        if (key.contentEquals("0")) {
            return Direction.THIS;
        }
        if (key.contentEquals("1")) {
            return Direction.NEXT;
        }
        if (key.contentEquals("2")) {
            return Direction.NEXT_2;
        }
        return null;
    }

    public String combineDateAndTime(String str, String str2) {
        return SimpleFormatterImpl.formatCompiledPattern(this.combinedDateAndTime, str2, str);
    }

    public String format(double d, Direction direction, RelativeUnit relativeUnit) {
        return adjustForContext(formatImpl(d, direction, relativeUnit).toString());
    }

    public String formatNumeric(double d, RelativeDateTimeUnit relativeDateTimeUnit) {
        return adjustForContext(formatNumericImpl(d, relativeDateTimeUnit).toString());
    }

    public FormattedRelativeDateTime formatNumericToValue(double d, RelativeDateTimeUnit relativeDateTimeUnit) {
        checkNoAdjustForContext();
        return new FormattedRelativeDateTime(formatNumericImpl(d, relativeDateTimeUnit), 0);
    }

    public FormattedRelativeDateTime formatToValue(double d, RelativeDateTimeUnit relativeDateTimeUnit) {
        FormattedStringBuilder formattedStringBuilder;
        checkNoAdjustForContext();
        CharSequence relativeImpl = formatRelativeImpl(d, relativeDateTimeUnit);
        if (relativeImpl instanceof FormattedStringBuilder) {
            formattedStringBuilder = (FormattedStringBuilder) relativeImpl;
        } else {
            FormattedStringBuilder formattedStringBuilder2 = new FormattedStringBuilder();
            formattedStringBuilder2.append(relativeImpl, Field.LITERAL);
            formattedStringBuilder = formattedStringBuilder2;
        }
        return new FormattedRelativeDateTime(formattedStringBuilder, 0);
    }

    public DisplayContext getCapitalizationContext() {
        return this.capitalizationContext;
    }

    public Style getFormatStyle() {
        return this.style;
    }

    public NumberFormat getNumberFormat() {
        NumberFormat numberFormatClone;
        synchronized (this.numberFormat) {
            numberFormatClone = this.numberFormat.clone();
        }
        return numberFormatClone;
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class FormattedRelativeDateTime implements FormattedValue {
        private final FormattedStringBuilder string;

        private FormattedRelativeDateTime(FormattedStringBuilder formattedStringBuilder) {
            this.string = formattedStringBuilder;
        }

        @Override // com.ibm.icu.text.FormattedValue
        public <A extends Appendable> A appendTo(A a) {
            return (A) Utility.appendTo(this.string, a);
        }

        @Override // java.lang.CharSequence
        public char charAt(int i) {
            return this.string.charAt(i);
        }

        @Override // java.lang.CharSequence
        public int length() {
            return this.string.length();
        }

        @Override // com.ibm.icu.text.FormattedValue
        public boolean nextPosition(ConstrainedFieldPosition constrainedFieldPosition) {
            return FormattedValueStringBuilderImpl.nextPosition(this.string, constrainedFieldPosition, Field.NUMERIC);
        }

        @Override // java.lang.CharSequence
        public CharSequence subSequence(int i, int i2) {
            return this.string.subString(i, i2);
        }

        @Override // com.ibm.icu.text.FormattedValue
        public AttributedCharacterIterator toCharacterIterator() {
            return FormattedValueStringBuilderImpl.toCharacterIterator(this.string, Field.NUMERIC);
        }

        @Override // com.ibm.icu.text.FormattedValue, java.lang.CharSequence
        public String toString() {
            return this.string.toString();
        }

        public /* synthetic */ FormattedRelativeDateTime(FormattedStringBuilder formattedStringBuilder, int i) {
            this(formattedStringBuilder);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class Cache {
        private final CacheBase<String, RelativeDateTimeFormatterData, ULocale> cache;

        private Cache() {
            this.cache = new SoftCache<String, RelativeDateTimeFormatterData, ULocale>() { // from class: com.ibm.icu.text.RelativeDateTimeFormatter.Cache.1
                @Override // com.ibm.icu.impl.CacheBase
                public RelativeDateTimeFormatterData createInstance(String str, ULocale uLocale) {
                    return new Loader(uLocale).load();
                }
            };
        }

        public RelativeDateTimeFormatterData get(ULocale uLocale) {
            return this.cache.getInstance(uLocale.toString(), uLocale);
        }

        public /* synthetic */ Cache(int i) {
            this();
        }
    }

    public String format(Direction direction, AbsoluteUnit absoluteUnit) {
        String absoluteImpl = formatAbsoluteImpl(direction, absoluteUnit);
        if (absoluteImpl != null) {
            return adjustForContext(absoluteImpl);
        }
        return null;
    }

    public String format(double d, RelativeDateTimeUnit relativeDateTimeUnit) {
        return adjustForContext(formatRelativeImpl(d, relativeDateTimeUnit).toString());
    }

    public FormattedRelativeDateTime formatToValue(Direction direction, AbsoluteUnit absoluteUnit) {
        checkNoAdjustForContext();
        String absoluteImpl = formatAbsoluteImpl(direction, absoluteUnit);
        if (absoluteImpl == null) {
            return null;
        }
        FormattedStringBuilder formattedStringBuilder = new FormattedStringBuilder();
        formattedStringBuilder.append(absoluteImpl, Field.LITERAL);
        return new FormattedRelativeDateTime(formattedStringBuilder, 0);
    }

    public FormattedRelativeDateTime formatToValue(double d, Direction direction, RelativeUnit relativeUnit) {
        checkNoAdjustForContext();
        return new FormattedRelativeDateTime(formatImpl(d, direction, relativeUnit), 0);
    }

    public static RelativeDateTimeFormatter getInstance(ULocale uLocale) {
        return getInstance(uLocale, null, Style.LONG, DisplayContext.CAPITALIZATION_NONE);
    }

    public static RelativeDateTimeFormatter getInstance(Locale locale) {
        return getInstance(ULocale.forLocale(locale));
    }

    public static RelativeDateTimeFormatter getInstance(ULocale uLocale, NumberFormat numberFormat) {
        return getInstance(uLocale, numberFormat, Style.LONG, DisplayContext.CAPITALIZATION_NONE);
    }

    public static RelativeDateTimeFormatter getInstance() {
        return getInstance(ULocale.getDefault(), null, Style.LONG, DisplayContext.CAPITALIZATION_NONE);
    }

    public static RelativeDateTimeFormatter getInstance(Locale locale, NumberFormat numberFormat) {
        return getInstance(ULocale.forLocale(locale), numberFormat);
    }
}
