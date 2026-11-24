package com.ibm.icu.impl;

import com.ibm.icu.util.TimeZone;
import com.ibm.icu.util.UResourceBundle;
import com.ibm.icu.util.UResourceBundleIterator;
import defpackage.cq;
import defpackage.ky0;
import defpackage.og;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class EraRules {
    private static final int DAY_MASK = 255;
    private static final int MAX_ENCODED_START_YEAR = 32767;
    private static final int MONTH_MASK = 65280;
    private static final int YEAR_MASK = -65536;
    private String calTypeId;
    private int currentEra;
    private EraRules inheritEraRules;
    private int minEra;
    private int numEras;
    private int[] startDates;
    private static final int MIN_ENCODED_START_YEAR = -32768;
    public static final int MIN_ENCODED_START = encodeDate(MIN_ENCODED_START_YEAR, 1, 1);

    private EraRules(String str, int[] iArr, int i, int i2) {
        this.calTypeId = str;
        this.startDates = iArr;
        this.minEra = i;
        this.numEras = i2;
        initCurrentEra();
    }

    private static int compareEncodedDateWithYMD(int i, int i2, int i3, int i4) {
        int iEncodeDate;
        if (i2 < MIN_ENCODED_START_YEAR) {
            if (i == MIN_ENCODED_START) {
                return (i2 > Integer.MIN_VALUE || i3 > 1 || i4 > 1) ? -1 : 0;
            }
            return 1;
        }
        if (i2 <= MAX_ENCODED_START_YEAR && i >= (iEncodeDate = encodeDate(i2, i3, i4))) {
            return i == iEncodeDate ? 0 : 1;
        }
        return -1;
    }

    private static int[] decodeDate(int i, int[] iArr) {
        int i2;
        int i3;
        int i4;
        if (i == MIN_ENCODED_START) {
            i4 = Integer.MIN_VALUE;
            i3 = 1;
            i2 = 1;
        } else {
            int i5 = (YEAR_MASK & i) >> 16;
            i2 = (MONTH_MASK & i) >> 8;
            i3 = i & 255;
            i4 = i5;
        }
        if (iArr == null || iArr.length < 3) {
            return new int[]{i4, i2, i3};
        }
        iArr[0] = i4;
        iArr[1] = i2;
        iArr[2] = i3;
        return iArr;
    }

    private static int encodeDate(int i, int i2, int i3) {
        return (i << 16) | (i2 << 8) | i3;
    }

    public static EraRules getInstance(String str, boolean z) {
        int i;
        UResourceBundleIterator uResourceBundleIterator;
        char c;
        UResourceBundle uResourceBundle = UResourceBundle.getBundleInstance(ICUData.ICU_BASE_NAME, "supplementalData", ICUResourceBundle.ICU_DATA_CLASS_LOADER).get("calendarData").get(str);
        String string = uResourceBundle.containsKey("inheritEras") ? uResourceBundle.getString("inheritEras") : null;
        UResourceBundle uResourceBundle2 = uResourceBundle.get("eras");
        int size = uResourceBundle2.getSize();
        ArrayList arrayList = new ArrayList(size);
        UResourceBundleIterator iterator = uResourceBundle2.getIterator();
        int i2 = Integer.MAX_VALUE;
        while (true) {
            char c2 = 0;
            if (!iterator.hasNext()) {
                int i3 = 0;
                if (!z) {
                    while (i2 < arrayList.size()) {
                        int size2 = arrayList.size() - 1;
                        if (isSet(((Integer) arrayList.get(size2)).intValue())) {
                            size--;
                        }
                        arrayList.remove(size2);
                    }
                    while (arrayList.size() > 0 && !isSet(((Integer) arrayList.get(arrayList.size() - 1)).intValue())) {
                        arrayList.remove(arrayList.size() - 1);
                    }
                }
                int i4 = 0;
                while (true) {
                    if (arrayList.size() <= 0) {
                        i = i3;
                        break;
                    }
                    i = i3;
                    if (isSet(((Integer) arrayList.get(i)).intValue())) {
                        break;
                    }
                    arrayList.remove(i);
                    i4++;
                    i3 = i;
                }
                int[] iArr = new int[arrayList.size()];
                for (int i5 = i; i5 < arrayList.size(); i5++) {
                    iArr[i5] = ((Integer) arrayList.get(i5)).intValue();
                }
                EraRules eraRules = new EraRules(str, iArr, i4, size);
                if (string != null) {
                    eraRules.inheritEraRules = getInstance(string, z);
                }
                return eraRules;
            }
            UResourceBundle next = iterator.next();
            String key = next.getKey();
            try {
                int i6 = Integer.parseInt(key);
                if (i6 < 0) {
                    og.q(ky0.l("Era rule key:", key, " in era rule data for ", str, " must be >= 0"));
                    return null;
                }
                int i7 = i6 + 1;
                if (i7 > arrayList.size()) {
                    arrayList.ensureCapacity(i7);
                    while (arrayList.size() < i7) {
                        arrayList.add(0);
                    }
                }
                if (isSet(((Integer) arrayList.get(i6)).intValue())) {
                    og.q(cq.l("Duplicated era rule for rule key:", key, " in era rule data for ", str));
                    return null;
                }
                UResourceBundleIterator iterator2 = next.getIterator();
                boolean z2 = false;
                char c3 = 1;
                while (iterator2.hasNext()) {
                    UResourceBundle next2 = iterator2.next();
                    String key2 = next2.getKey();
                    if (key2.equals("start")) {
                        int[] intVector = next2.getIntVector();
                        c = c2;
                        if (intVector.length == 3) {
                            uResourceBundleIterator = iterator;
                            if (isValidRuleStartDate(intVector[c], intVector[1], intVector[2])) {
                                arrayList.set(i6, Integer.valueOf(encodeDate(intVector[c], intVector[1], intVector[2])));
                            }
                        }
                        og.q(cq.l("Invalid era rule date data:", Arrays.toString(intVector), " in era rule data for ", str));
                        return null;
                    }
                    uResourceBundleIterator = iterator;
                    c = c2;
                    if (key2.equals("named")) {
                        if (next2.getString().equals("false")) {
                            c3 = c;
                        }
                    } else if (key2.equals("end")) {
                        z2 = true;
                    }
                    c2 = c;
                    iterator = uResourceBundleIterator;
                }
                UResourceBundleIterator uResourceBundleIterator2 = iterator;
                if (!isSet(((Integer) arrayList.get(i6)).intValue())) {
                    if (!z2) {
                        og.q(cq.l("Missing era start/end rule date for key:", key, " in era rule data for ", str));
                        return null;
                    }
                    arrayList.set(i6, Integer.valueOf(MIN_ENCODED_START));
                }
                if (c3 != 0) {
                    if (i6 >= i2) {
                        og.q(cq.h("Non-tentative era(", i6, ") must be placed before the first tentative era"));
                        return null;
                    }
                } else if (i6 < i2) {
                    i2 = i6;
                }
                iterator = uResourceBundleIterator2;
            } catch (NumberFormatException unused) {
                og.q(cq.l("Invalid era rule key:", key, " in era rule data for ", str));
                return null;
            }
        }
    }

    private void initCurrentEra() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        int[] iArrTimeToFields = Grego.timeToFields(jCurrentTimeMillis + ((long) TimeZone.getDefault().getOffset(jCurrentTimeMillis)), null);
        this.currentEra = getEraCode(iArrTimeToFields[0], iArrTimeToFields[1] + 1, iArrTimeToFields[2]);
    }

    private static boolean isSet(int i) {
        return i != 0;
    }

    private static boolean isValidRuleStartDate(int i, int i2, int i3) {
        return i >= MIN_ENCODED_START_YEAR && i <= MAX_ENCODED_START_YEAR && i2 >= 1 && i2 <= 12 && i3 >= 1 && i3 <= 31;
    }

    public String getCalendarTypeId() {
        return this.calTypeId;
    }

    public int getCurrentEraCode() {
        return this.currentEra;
    }

    public int getEraCode(int i, int i2, int i3) {
        if (i2 < 1 || i2 > 12 || i3 < 1 || i3 > 31) {
            og.e(i3, cq.p("Illegal date - year:", i, "month:", i2, "day:"));
            return 0;
        }
        if (this.numEras > 1) {
            int[] iArr = this.startDates;
            if (iArr[iArr.length - 1] == MIN_ENCODED_START) {
                int i4 = 0;
                while (true) {
                    int[] iArr2 = this.startDates;
                    if (i4 >= iArr2.length) {
                        return (this.minEra + iArr2.length) - 1;
                    }
                    if (isSet(iArr2[i4]) && compareEncodedDateWithYMD(this.startDates[i4], i, i2, i3) <= 0) {
                        return this.minEra + i4;
                    }
                    i4++;
                }
            }
        }
        int length = this.startDates.length;
        while (length > 0) {
            length--;
            if (isSet(this.startDates[length]) && compareEncodedDateWithYMD(this.startDates[length], i, i2, i3) <= 0) {
                return this.minEra + length;
            }
        }
        EraRules eraRules = this.inheritEraRules;
        return eraRules != null ? eraRules.getEraCode(i, i2, i3) : this.minEra;
    }

    public EraRules getInheritEraRules() {
        return this.inheritEraRules;
    }

    public int getMaxEraCode() {
        return (this.minEra + this.startDates.length) - 1;
    }

    public int getMinEraCode() {
        int i = this.minEra;
        EraRules eraRules = this.inheritEraRules;
        return eraRules != null ? eraRules.getMinEraCode() : i;
    }

    public int getNextEraCode(int i) {
        int i2 = i + 1;
        int i3 = this.minEra;
        if (i2 >= i3) {
            int maxEraCode = getMaxEraCode();
            return i2 > maxEraCode ? maxEraCode : i2;
        }
        EraRules eraRules = this.inheritEraRules;
        if (eraRules != null) {
            return i2 > eraRules.getMaxEraCode() ? this.minEra : this.inheritEraRules.getNextEraCode(i);
        }
        return i3;
    }

    public int getNumberOfEras() {
        EraRules eraRules = this.inheritEraRules;
        int i = this.numEras;
        return eraRules == null ? i : eraRules.getNumberOfEras() + i;
    }

    /* JADX WARN: Code duplicated, block: B:14:0x001d  */
    /* JADX WARN: Code duplicated, block: B:16:0x0022  */
    public int[] getStartDate(int i, int[] iArr) {
        int i2;
        int i3 = this.minEra;
        if (i >= i3) {
            int i4 = i - i3;
            int[] iArr2 = this.startDates;
            i2 = i4 < iArr2.length ? iArr2[i4] : 0;
            if (isSet(i2)) {
                return decodeDate(i2, iArr);
            }
            og.i("eraCode is not found in our data");
            return null;
        }
        EraRules eraRules = this.inheritEraRules;
        if (eraRules != null) {
            return eraRules.getStartDate(i, iArr);
        }
        if (isSet(i2)) {
            return decodeDate(i2, iArr);
        }
        og.i("eraCode is not found in our data");
        return null;
    }

    public int getStartYear(int i) {
        return getStartDate(i, null)[0];
    }

    public static EraRules getInstance(CalType calType, boolean z) {
        return getInstance(calType.getId(), z);
    }
}
