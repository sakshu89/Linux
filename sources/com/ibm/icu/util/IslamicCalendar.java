package com.ibm.icu.util;

import com.ibm.icu.impl.CalendarAstronomer;
import com.ibm.icu.impl.CalendarCache;
import com.ibm.icu.impl.CalendarUtil;
import com.ibm.icu.lang.UCharacter;
import defpackage.x31;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Date;
import java.util.Locale;
import java.util.function.IntConsumer;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class IslamicCalendar extends Calendar {
    private static final long ASTRONOMICAL_EPOCH = 1948439;
    private static Algorithm CIVIL_ALGORITHM = null;
    private static final long CIVIL_EPOCH = 1948440;
    public static final int DHU_AL_HIJJAH = 11;
    public static final int DHU_AL_QIDAH = 10;
    private static final long HIJRA_MILLIS = -42521587200000L;
    private static Algorithm ISLAMIC_ALGORITHM = null;
    public static final int JUMADA_1 = 4;
    public static final int JUMADA_2 = 5;
    public static final int MUHARRAM = 0;
    public static final int RABI_1 = 2;
    public static final int RABI_2 = 3;
    public static final int RAJAB = 6;
    public static final int RAMADAN = 8;
    public static final int SAFAR = 1;
    public static final int SHABAN = 7;
    public static final int SHAWWAL = 9;
    private static Algorithm TBLA_ALGORITHM = null;
    private static Algorithm UMALQURA_ALGORITHM = null;
    private static final int UMALQURA_YEAR_END = 1600;
    private static final int UMALQURA_YEAR_START = 1300;
    private static final long serialVersionUID = -6253365474073869325L;
    private transient Algorithm algorithm;
    private CalculationType cType;
    private boolean civil;
    private static final int[][] LIMITS = {new int[]{0, 0, 0, 0}, new int[]{1, 1, 5000000, 5000000}, new int[]{0, 0, 11, 11}, new int[]{1, 1, 50, 51}, new int[0], new int[]{1, 1, 29, 30}, new int[]{1, 1, UCharacter.UnicodeBlock.COUNT, 355}, new int[0], new int[]{-1, -1, 5, 5}, new int[0], new int[0], new int[0], new int[0], new int[0], new int[0], new int[0], new int[0], new int[]{1, 1, 5000000, 5000000}, new int[0], new int[]{1, 1, 5000000, 5000000}, new int[0], new int[0], new int[0], new int[]{0, 0, 11, 11}};
    private static final int[] UMALQURA_MONTHLENGTH = {2730, 3412, 3785, 1748, 1770, 876, 2733, 1365, 1705, 1938, 2985, 1492, 2778, 1372, 3373, 1685, 1866, 2900, 2922, 1453, 1198, 2639, 1303, 1675, 1701, 2773, 726, 2395, 1181, 2637, 3366, 3477, 1452, 2486, 698, 2651, 1323, 2709, 1738, 2793, 756, 2422, 694, 2390, 2762, 2980, 3026, 1497, 732, 2413, 1357, 2725, 2898, 2981, 1460, 2486, 1367, 663, 1355, 1699, 1874, 2917, 1386, 2731, 1323, 3221, 3402, 3493, 1482, 2774, 2391, 1195, 2379, 2725, 2898, 2922, 1397, 630, 2231, 1115, 1365, 1449, 1460, 2522, 1245, 622, 2358, 2730, 3412, 3506, 1493, 730, 2395, 1195, 2645, 2889, 2916, 2929, 1460, 2741, 2645, 3365, 3730, 3785, 1748, 2793, 2411, 1195, 2707, 3401, 3492, 3506, 2745, 1210, 2651, 1323, 2709, 2858, 2901, 1372, 1213, 573, 2333, 2709, 2890, 2906, 1389, 694, 2363, 1179, 1621, 1705, 1876, 2922, 1388, 2733, 1365, 2857, 2962, 2985, 1492, 2778, 1370, 2731, 1429, 1865, 1892, 2986, 1461, 694, 2646, 3661, 2853, 2898, 2922, 1453, 686, 2351, 1175, 1611, 1701, 1708, 2774, 1373, 1181, 2637, 3350, 3477, 1450, 1461, 730, 2395, 1197, 1429, 1738, 1764, 2794, 1269, 694, 2390, 2730, 2900, 3026, 1497, 746, 2413, 1197, 2709, 2890, 2981, 1458, 2485, 1238, 2711, 1351, 1683, 1865, 2901, 1386, 2667, 1323, 2699, 3398, 3491, 1482, 2774, 1243, 619, 2379, 2725, 2898, 2921, 1397, 374, 2231, 603, 1323, 1381, 1460, 2522, 1261, 365, 2230, 2726, 3410, 3497, 1492, 2778, 2395, 1195, 1619, 1833, 1890, 2985, 1458, 2741, 1365, 2853, 3474, 3785, 1746, 2793, 1387, 1195, 2645, 3369, 3412, 3498, 2485, 1210, 2619, 1179, 2637, 2730, 2773, 730, 2397, 1118, 2606, 3226, 3413, 1714, 1721, 1210, 2653, 1325, 2709, 2898, 2984, 2996, 1465, 730, 2394, 2890, 3492, 3793, 1768, 2922, 1389, 1333, 1685, 3402, 3496, 3540, 1754, 1371, 669, 1579, 2837, 2890, 2965, 1450, 2734, 2350, 3215, 1319, 1685, 1706, 2774, 1373, 669};
    private static final byte[] UMALQURA_YEAR_START_ESTIMATE_FIX = {0, 0, -1, 0, -1, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, -1, 0, 1, 0, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, -1, -1, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 1, 1, 0, 0, -1, 0, 1, 0, 1, 1, 0, 0, -1, 0, 1, 0, 0, 0, -1, 0, 1, 0, 1, 0, 0, 0, -1, 0, 0, 0, 0, -1, -1, 0, -1, 0, 1, 0, 0, 0, -1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, -1, -1, 0, 0, 0, 1, 0, 0, -1, -1, 0, -1, 0, 0, -1, -1, 0, -1, 0, -1, 0, 0, -1, -1, 0, 0, 0, 0, 0, 0, -1, 0, 1, 0, 1, 1, 0, 0, -1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, -1, 0, 1, 0, 0, -1, -1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 1, 1, 0, 0, -1, 0, 1, 0, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, -1, 0, 0, 0, 1, 0, 0, 0, -1, 0, 0, 0, 0, 0, -1, 0, -1, 0, 1, 0, 0, 0, -1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 1, 0, 0, 0, -1, 0, 0, 0, 0, -1, -1, 0, -1, 0, 1, 0, 0, -1, -1, 0, 0, 1, 1, 0, 0, -1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1};
    private static CalendarCache cache = new CalendarCache();

    /* JADX INFO: renamed from: com.ibm.icu.util.IslamicCalendar$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ibm$icu$util$IslamicCalendar$CalculationType;

        static {
            int[] iArr = new int[CalculationType.values().length];
            $SwitchMap$com$ibm$icu$util$IslamicCalendar$CalculationType = iArr;
            try {
                iArr[CalculationType.ISLAMIC_UMALQURA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ibm$icu$util$IslamicCalendar$CalculationType[CalculationType.ISLAMIC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$ibm$icu$util$IslamicCalendar$CalculationType[CalculationType.ISLAMIC_TBLA.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$ibm$icu$util$IslamicCalendar$CalculationType[CalculationType.ISLAMIC_CIVIL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public interface Algorithm {
        void compute(long j, long j2, IntConsumer intConsumer, IntConsumer intConsumer2, IntConsumer intConsumer3, IntConsumer intConsumer4);

        long epoch();

        CalculationType getType();

        boolean isCivil();

        int monthLength(int i, int i2);

        long monthStart(int i, int i2);

        int yearLength(int i);

        long yearStart(int i);
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public enum CalculationType {
        ISLAMIC("islamic"),
        ISLAMIC_CIVIL("islamic-civil"),
        ISLAMIC_UMALQURA("islamic-umalqura"),
        ISLAMIC_TBLA("islamic-tbla");

        private String bcpType;

        CalculationType(String str) {
            this.bcpType = str;
        }

        public String bcpType() {
            return this.bcpType;
        }
    }

    static {
        int i = 0;
        ISLAMIC_ALGORITHM = new IslamicAlgorithm(i);
        CIVIL_ALGORITHM = new CivilAlgorithm(i);
        TBLA_ALGORITHM = new TBLAAlgorithm(i);
        UMALQURA_ALGORITHM = new UmalquraAlgorithm(i);
    }

    public IslamicCalendar(int i, int i2, int i3, int i4, int i5, int i6) {
        super(TimeZone.getDefault(), ULocale.getDefault(ULocale.Category.FORMAT));
        this.civil = true;
        this.cType = CalculationType.ISLAMIC_CIVIL;
        this.algorithm = CIVIL_ALGORITHM;
        set(1, i);
        set(2, i2);
        set(5, i3);
        set(11, i4);
        set(12, i5);
        set(13, i6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean civilLeapYear(int i) {
        return ((i * 11) + 14) % 30 < 11;
    }

    /* JADX WARN: Code duplicated, block: B:6:0x0012 A[PHI: r4
      0x0012: PHI (r4v5 int) = (r4v2 int), (r4v7 int) binds: [B:9:0x001f, B:5:0x0010] A[DONT_GENERATE, DONT_INLINE]] */
    private static int firstIslamicStartYearFromGrego(int i) {
        int i2;
        int i3 = 0;
        if (i >= 1977) {
            int i4 = i - 1977;
            i2 = (i4 / 65) * 2;
            if (i4 % 65 >= 32) {
                i3 = 1;
            }
        } else {
            int i5 = i - 1976;
            i2 = ((i5 / 65) - 1) * 2;
            if ((-i5) % 65 <= 32) {
                i3 = 1;
            }
        }
        return (i - 579) + i2 + i3;
    }

    /* JADX WARN: Code duplicated, block: B:6:0x0012 A[PHI: r4
      0x0012: PHI (r4v5 int) = (r4v2 int), (r4v7 int) binds: [B:9:0x001f, B:5:0x0010] A[DONT_GENERATE, DONT_INLINE]] */
    private static final int gregoYearFromIslamicStart(int i) {
        int i2;
        int i3 = 0;
        if (i >= 1397) {
            int i4 = i - 1397;
            i2 = (i4 / 67) * 2;
            if (i4 % 67 >= 33) {
                i3 = 1;
            }
        } else {
            int i5 = i - 1396;
            i2 = ((i5 / 67) - 1) * 2;
            if ((-i5) % 67 <= 33) {
                i3 = 1;
            }
        }
        return (i + 579) - (i2 + i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleComputeFields$0(int i) {
        internalSet(0, 0);
        internalSet(1, i);
        internalSet(19, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleComputeFields$1(int i) {
        internalSet(2, i);
        internalSet(23, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleComputeFields$2(int i) {
        internalSet(5, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleComputeFields$3(int i) {
        internalSet(6, i);
    }

    public static final double moonAge(long j) {
        double moonAge = (new CalendarAstronomer(j).getMoonAge() * 180.0d) / 3.141592653589793d;
        return moonAge > 180.0d ? moonAge - 360.0d : moonAge;
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        if (this.cType == null) {
            this.cType = this.civil ? CalculationType.ISLAMIC_CIVIL : CalculationType.ISLAMIC;
        }
        setCalculationType(this.cType);
    }

    private void setCalcTypeForLocale(ULocale uLocale) {
        String calendarType = CalendarUtil.getCalendarType(uLocale);
        if ("islamic-civil".equals(calendarType)) {
            setCalculationType(CalculationType.ISLAMIC_CIVIL);
            return;
        }
        if ("islamic-umalqura".equals(calendarType)) {
            setCalculationType(CalculationType.ISLAMIC_UMALQURA);
            return;
        }
        if ("islamic-tbla".equals(calendarType)) {
            setCalculationType(CalculationType.ISLAMIC_TBLA);
        } else if (calendarType.startsWith("islamic")) {
            setCalculationType(CalculationType.ISLAMIC);
        } else {
            setCalculationType(CalculationType.ISLAMIC_CIVIL);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long trueMonthStart(long j) {
        long j2 = cache.get(j);
        if (j2 != CalendarCache.EMPTY) {
            return j2;
        }
        long jFloor = (((long) Math.floor(j * 29.530588853d)) * CalendarAstronomer.DAY_MS) + HIJRA_MILLIS;
        moonAge(jFloor);
        if (moonAge(jFloor) >= 0.0d) {
            do {
                jFloor -= CalendarAstronomer.DAY_MS;
            } while (moonAge(jFloor) >= 0.0d);
        } else {
            do {
                jFloor += CalendarAstronomer.DAY_MS;
            } while (moonAge(jFloor) < 0.0d);
        }
        long j3 = ((jFloor - HIJRA_MILLIS) / CalendarAstronomer.DAY_MS) + 1;
        cache.put(j, j3);
        return j3;
    }

    public CalculationType getCalculationType() {
        return this.algorithm.getType();
    }

    @Override // com.ibm.icu.util.Calendar
    @Deprecated
    public final int getRelatedYear() {
        return gregoYearFromIslamicStart(get(19));
    }

    @Override // com.ibm.icu.util.Calendar
    public String getType() {
        return this.algorithm.getType().bcpType();
    }

    @Override // com.ibm.icu.util.Calendar
    public void handleComputeFields(int i) {
        this.algorithm.compute(i, internalGetTimeInMillis(), new x31(0, this), new x31(1, this), new x31(2, this), new x31(3, this));
    }

    @Override // com.ibm.icu.util.Calendar
    public int handleComputeMonthStart(int i, int i2, boolean z) {
        return (int) ((this.algorithm.monthStart(i, i2) + this.algorithm.epoch()) - 1);
    }

    @Override // com.ibm.icu.util.Calendar
    public int handleGetExtendedYear() {
        return newerField(19, 1) == 19 ? internalGet(19, 1) : internalGet(1, 1);
    }

    @Override // com.ibm.icu.util.Calendar
    public int handleGetLimit(int i, int i2) {
        return LIMITS[i][i2];
    }

    @Override // com.ibm.icu.util.Calendar
    public int handleGetMonthLength(int i, int i2) {
        return this.algorithm.monthLength(i, i2);
    }

    @Override // com.ibm.icu.util.Calendar
    public int handleGetYearLength(int i) {
        return this.algorithm.yearLength(i);
    }

    @Override // com.ibm.icu.util.Calendar
    public boolean inTemporalLeapYear() {
        return getActualMaximum(6) == 355;
    }

    public boolean isCivil() {
        return this.algorithm.isCivil();
    }

    public void setCalculationType(CalculationType calculationType) {
        this.cType = calculationType;
        int i = AnonymousClass1.$SwitchMap$com$ibm$icu$util$IslamicCalendar$CalculationType[calculationType.ordinal()];
        if (i == 1) {
            this.algorithm = UMALQURA_ALGORITHM;
        } else if (i == 2) {
            this.algorithm = ISLAMIC_ALGORITHM;
        } else if (i != 3) {
            this.algorithm = CIVIL_ALGORITHM;
        } else {
            this.algorithm = TBLA_ALGORITHM;
        }
        this.civil = this.algorithm.isCivil();
    }

    /* JADX WARN: Code duplicated, block: B:6:0x0019 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:7:0x001b  */
    /* JADX WARN: Code duplicated, block: B:9:0x0021  */
    public void setCivil(boolean z) {
        CalculationType calculationType;
        CalculationType calculationType2;
        if (z) {
            CalculationType calculationType3 = this.cType;
            CalculationType calculationType4 = CalculationType.ISLAMIC_CIVIL;
            if (calculationType3 != calculationType4) {
                long timeInMillis = getTimeInMillis();
                this.cType = calculationType4;
                this.algorithm = CIVIL_ALGORITHM;
                clear();
                setTimeInMillis(timeInMillis);
            } else if (!z) {
                calculationType = this.cType;
                calculationType2 = CalculationType.ISLAMIC;
                if (calculationType != calculationType2) {
                    long timeInMillis2 = getTimeInMillis();
                    this.cType = calculationType2;
                    this.algorithm = ISLAMIC_ALGORITHM;
                    clear();
                    setTimeInMillis(timeInMillis2);
                }
            }
        } else if (!z) {
            calculationType = this.cType;
            calculationType2 = CalculationType.ISLAMIC;
            if (calculationType != calculationType2) {
                long timeInMillis3 = getTimeInMillis();
                this.cType = calculationType2;
                this.algorithm = ISLAMIC_ALGORITHM;
                clear();
                setTimeInMillis(timeInMillis3);
            }
        }
        this.civil = this.algorithm.isCivil();
    }

    @Override // com.ibm.icu.util.Calendar
    @Deprecated
    public final void setRelatedYear(int i) {
        set(19, firstIslamicStartYearFromGrego(i));
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class CivilAlgorithm implements Algorithm {
        public /* synthetic */ CivilAlgorithm(int i) {
            this();
        }

        @Override // com.ibm.icu.util.IslamicCalendar.Algorithm
        public void compute(long j, long j2, IntConsumer intConsumer, IntConsumer intConsumer2, IntConsumer intConsumer3, IntConsumer intConsumer4) {
            long jEpoch = j - epoch();
            int iFloor = (int) Math.floor(((30 * jEpoch) + 10646) / 10631.0d);
            int iMin = Math.min((int) Math.ceil(((jEpoch - 29) - yearStart(iFloor)) / 29.5d), 11);
            intConsumer.accept(iFloor);
            intConsumer2.accept(iMin);
            intConsumer3.accept(((int) (jEpoch - monthStart(iFloor, iMin))) + 1);
            intConsumer4.accept((int) ((jEpoch - yearStart(iFloor)) + 1));
        }

        @Override // com.ibm.icu.util.IslamicCalendar.Algorithm
        public long epoch() {
            return IslamicCalendar.CIVIL_EPOCH;
        }

        @Override // com.ibm.icu.util.IslamicCalendar.Algorithm
        public CalculationType getType() {
            return CalculationType.ISLAMIC_CIVIL;
        }

        @Override // com.ibm.icu.util.IslamicCalendar.Algorithm
        public boolean isCivil() {
            return true;
        }

        @Override // com.ibm.icu.util.IslamicCalendar.Algorithm
        public int monthLength(int i, int i2) {
            int i3 = i2 % 2 == 0 ? 30 : 29;
            return (i2 == 11 && IslamicCalendar.civilLeapYear(i)) ? i3 + 1 : i3;
        }

        @Override // com.ibm.icu.util.IslamicCalendar.Algorithm
        public long monthStart(int i, int i2) {
            return ((long) Math.ceil(((double) (i2 % 12)) * 29.5d)) + yearStart((i2 / 12) + i);
        }

        @Override // com.ibm.icu.util.IslamicCalendar.Algorithm
        public int yearLength(int i) {
            return (IslamicCalendar.civilLeapYear(i) ? 1 : 0) + UCharacter.UnicodeBlock.COUNT;
        }

        @Override // com.ibm.icu.util.IslamicCalendar.Algorithm
        public long yearStart(int i) {
            return ((long) ((i - 1) * UCharacter.UnicodeBlock.COUNT)) + ((long) Math.floor(((double) ((i * 11) + 3)) / 30.0d));
        }

        private CivilAlgorithm() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class IslamicAlgorithm implements Algorithm {
        public /* synthetic */ IslamicAlgorithm(int i) {
            this();
        }

        @Override // com.ibm.icu.util.IslamicCalendar.Algorithm
        public void compute(long j, long j2, IntConsumer intConsumer, IntConsumer intConsumer2, IntConsumer intConsumer3, IntConsumer intConsumer4) {
            long jEpoch = j - epoch();
            int iFloor = (int) Math.floor(jEpoch / 29.530588853d);
            if (jEpoch - ((long) Math.floor((((double) iFloor) * 29.530588853d) - 1.0d)) >= 25 && IslamicCalendar.moonAge(j2) > 0.0d) {
                iFloor++;
            }
            while (IslamicCalendar.trueMonthStart(iFloor) > jEpoch) {
                iFloor--;
            }
            int i = iFloor >= 0 ? (iFloor / 12) + 1 : (iFloor + 1) / 12;
            int i2 = ((iFloor % 12) + 12) % 12;
            intConsumer.accept(i);
            intConsumer2.accept(i2);
            intConsumer3.accept(((int) (jEpoch - monthStart(i, i2))) + 1);
            intConsumer4.accept((int) ((jEpoch - yearStart(i)) + 1));
        }

        @Override // com.ibm.icu.util.IslamicCalendar.Algorithm
        public long epoch() {
            return IslamicCalendar.CIVIL_EPOCH;
        }

        @Override // com.ibm.icu.util.IslamicCalendar.Algorithm
        public CalculationType getType() {
            return CalculationType.ISLAMIC;
        }

        @Override // com.ibm.icu.util.IslamicCalendar.Algorithm
        public boolean isCivil() {
            return false;
        }

        @Override // com.ibm.icu.util.IslamicCalendar.Algorithm
        public int monthLength(int i, int i2) {
            int i3 = ((i - 1) * 12) + i2;
            return (int) (IslamicCalendar.trueMonthStart(i3 + 1) - IslamicCalendar.trueMonthStart(i3));
        }

        @Override // com.ibm.icu.util.IslamicCalendar.Algorithm
        public long monthStart(int i, int i2) {
            return IslamicCalendar.trueMonthStart((i2 % 12) + ((((i2 / 12) + i) - 1) * 12));
        }

        @Override // com.ibm.icu.util.IslamicCalendar.Algorithm
        public int yearLength(int i) {
            int i2 = (i - 1) * 12;
            return (int) (IslamicCalendar.trueMonthStart(i2 + 12) - IslamicCalendar.trueMonthStart(i2));
        }

        @Override // com.ibm.icu.util.IslamicCalendar.Algorithm
        public long yearStart(int i) {
            return monthStart(i, 0);
        }

        private IslamicAlgorithm() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class UmalquraAlgorithm implements Algorithm {
        public /* synthetic */ UmalquraAlgorithm(int i) {
            this();
        }

        @Override // com.ibm.icu.util.IslamicCalendar.Algorithm
        public void compute(long j, long j2, IntConsumer intConsumer, IntConsumer intConsumer2, IntConsumer intConsumer3, IntConsumer intConsumer4) {
            int i;
            long jEpoch = j - epoch();
            if (jEpoch < yearStart(IslamicCalendar.UMALQURA_YEAR_START)) {
                IslamicCalendar.CIVIL_ALGORITHM.compute(j, j2, intConsumer, intConsumer2, intConsumer3, intConsumer4);
                return;
            }
            int i2 = ((int) ((jEpoch - 460322.55d) / 354.3672d)) + 1299;
            long j3 = 1;
            while (true) {
                i = 0;
                if (j3 <= 0) {
                    break;
                }
                i2++;
                long jYearStart = (jEpoch - yearStart(i2)) + 1;
                long jYearLength = yearLength(i2);
                if (jYearStart == jYearLength) {
                    i = 11;
                    break;
                }
                if (jYearStart < jYearLength) {
                    int iMonthLength = monthLength(i2, 0);
                    while (true) {
                        long j4 = iMonthLength;
                        if (jYearStart <= j4) {
                            break;
                        }
                        jYearStart -= j4;
                        i++;
                        iMonthLength = monthLength(i2, i);
                    }
                } else {
                    j3 = jYearStart;
                }
            }
            intConsumer.accept(i2);
            intConsumer2.accept(i);
            intConsumer3.accept(((int) (jEpoch - monthStart(i2, i))) + 1);
            intConsumer4.accept((int) ((jEpoch - yearStart(i2)) + 1));
        }

        @Override // com.ibm.icu.util.IslamicCalendar.Algorithm
        public long epoch() {
            return IslamicCalendar.CIVIL_EPOCH;
        }

        @Override // com.ibm.icu.util.IslamicCalendar.Algorithm
        public CalculationType getType() {
            return CalculationType.ISLAMIC_UMALQURA;
        }

        @Override // com.ibm.icu.util.IslamicCalendar.Algorithm
        public boolean isCivil() {
            return false;
        }

        @Override // com.ibm.icu.util.IslamicCalendar.Algorithm
        public int monthLength(int i, int i2) {
            if (i < IslamicCalendar.UMALQURA_YEAR_START || i > IslamicCalendar.UMALQURA_YEAR_END) {
                return IslamicCalendar.CIVIL_ALGORITHM.monthLength(i, i2);
            }
            return ((1 << (11 - i2)) & IslamicCalendar.UMALQURA_MONTHLENGTH[i - IslamicCalendar.UMALQURA_YEAR_START]) != 0 ? 30 : 29;
        }

        @Override // com.ibm.icu.util.IslamicCalendar.Algorithm
        public long monthStart(int i, int i2) {
            int i3 = (i2 / 12) + i;
            int i4 = i2 % 12;
            if (i3 < IslamicCalendar.UMALQURA_YEAR_START) {
                return IslamicCalendar.CIVIL_ALGORITHM.monthStart(i3, i4);
            }
            long jYearStart = yearStart(i3);
            for (int i5 = 0; i5 < i4; i5++) {
                jYearStart += (long) monthLength(i3, i5);
            }
            return jYearStart;
        }

        @Override // com.ibm.icu.util.IslamicCalendar.Algorithm
        public int yearLength(int i) {
            if (i < IslamicCalendar.UMALQURA_YEAR_START || i > IslamicCalendar.UMALQURA_YEAR_END) {
                return IslamicCalendar.CIVIL_ALGORITHM.yearLength(i);
            }
            int iMonthLength = 0;
            for (int i2 = 0; i2 < 12; i2++) {
                iMonthLength += monthLength(i, i2);
            }
            return iMonthLength;
        }

        @Override // com.ibm.icu.util.IslamicCalendar.Algorithm
        public long yearStart(int i) {
            if (i < IslamicCalendar.UMALQURA_YEAR_START || i > IslamicCalendar.UMALQURA_YEAR_END) {
                return IslamicCalendar.CIVIL_ALGORITHM.yearStart(i);
            }
            int i2 = i - IslamicCalendar.UMALQURA_YEAR_START;
            return ((int) ((((double) i2) * 354.3672d) + 460322.05d + 0.5d)) + IslamicCalendar.UMALQURA_YEAR_START_ESTIMATE_FIX[i2];
        }

        private UmalquraAlgorithm() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class TBLAAlgorithm extends CivilAlgorithm {
        private TBLAAlgorithm() {
            super(0);
        }

        @Override // com.ibm.icu.util.IslamicCalendar.CivilAlgorithm, com.ibm.icu.util.IslamicCalendar.Algorithm
        public long epoch() {
            return IslamicCalendar.ASTRONOMICAL_EPOCH;
        }

        @Override // com.ibm.icu.util.IslamicCalendar.CivilAlgorithm, com.ibm.icu.util.IslamicCalendar.Algorithm
        public CalculationType getType() {
            return CalculationType.ISLAMIC_TBLA;
        }

        @Override // com.ibm.icu.util.IslamicCalendar.CivilAlgorithm, com.ibm.icu.util.IslamicCalendar.Algorithm
        public boolean isCivil() {
            return false;
        }

        public /* synthetic */ TBLAAlgorithm(int i) {
            this();
        }
    }

    public IslamicCalendar(TimeZone timeZone) {
        this(timeZone, ULocale.getDefault(ULocale.Category.FORMAT));
    }

    public IslamicCalendar(Locale locale) {
        this(TimeZone.forLocaleOrDefault(locale), locale);
    }

    public IslamicCalendar(ULocale uLocale) {
        this(TimeZone.forULocaleOrDefault(uLocale), uLocale);
    }

    public IslamicCalendar(TimeZone timeZone, Locale locale) {
        this(timeZone, ULocale.forLocale(locale));
    }

    public IslamicCalendar(TimeZone timeZone, ULocale uLocale) {
        super(timeZone, uLocale);
        this.civil = true;
        this.cType = CalculationType.ISLAMIC_CIVIL;
        this.algorithm = CIVIL_ALGORITHM;
        setCalcTypeForLocale(uLocale);
        setTimeInMillis(System.currentTimeMillis());
    }

    public IslamicCalendar(Date date) {
        super(TimeZone.getDefault(), ULocale.getDefault(ULocale.Category.FORMAT));
        this.civil = true;
        this.cType = CalculationType.ISLAMIC_CIVIL;
        this.algorithm = CIVIL_ALGORITHM;
        setTime(date);
    }

    public IslamicCalendar(int i, int i2, int i3) {
        super(TimeZone.getDefault(), ULocale.getDefault(ULocale.Category.FORMAT));
        this.civil = true;
        this.cType = CalculationType.ISLAMIC_CIVIL;
        this.algorithm = CIVIL_ALGORITHM;
        set(1, i);
        set(2, i2);
        set(5, i3);
    }

    public IslamicCalendar() {
        this(TimeZone.getDefault(), ULocale.getDefault(ULocale.Category.FORMAT));
    }
}
