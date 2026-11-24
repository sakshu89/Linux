package com.ibm.icu.impl;

import com.ibm.icu.lang.UCharacterEnums;
import com.ibm.icu.util.AnnualTimeZoneRule;
import com.ibm.icu.util.BasicTimeZone;
import com.ibm.icu.util.DateTimeRule;
import com.ibm.icu.util.InitialTimeZoneRule;
import com.ibm.icu.util.SimpleTimeZone;
import com.ibm.icu.util.TimeArrayTimeZoneRule;
import com.ibm.icu.util.TimeZone;
import com.ibm.icu.util.TimeZoneRule;
import com.ibm.icu.util.TimeZoneTransition;
import com.ibm.icu.util.UResourceBundle;
import defpackage.dk0;
import defpackage.ky0;
import defpackage.og;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Arrays;
import java.util.Date;
import java.util.MissingResourceException;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class OlsonTimeZone extends BasicTimeZone implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final boolean DEBUG = ICUDebug.enabled("olson");
    private static final int MAX_OFFSET_SECONDS = 86400;
    private static final int SECONDS_PER_DAY = 86400;
    private static final String ZONEINFORES = "zoneinfo64";
    private static final int currentSerialVersion = 1;
    static final long serialVersionUID = -6281977362477515376L;
    private volatile String canonicalID;
    private double finalStartMillis;
    private int finalStartYear;
    private SimpleTimeZone finalZone;
    private transient SimpleTimeZone finalZoneWithStartYear;
    private transient TimeZoneTransition firstFinalTZTransition;
    private transient TimeZoneTransition firstTZTransition;
    private transient int firstTZTransitionIdx;
    private transient TimeArrayTimeZoneRule[] historicRules;
    private transient InitialTimeZoneRule initialRule;
    private volatile transient boolean isFrozen;
    private int serialVersionOnStream;
    private int transitionCount;
    private transient boolean transitionRulesInitialized;
    private long[] transitionTimes64;
    private int typeCount;
    private byte[] typeMapData;
    private int[] typeOffsets;

    public OlsonTimeZone(String str) {
        super(str);
        this.finalStartYear = Integer.MAX_VALUE;
        this.finalStartMillis = Double.MAX_VALUE;
        this.finalZone = null;
        this.canonicalID = null;
        this.serialVersionOnStream = 1;
        this.isFrozen = false;
        UResourceBundle bundleInstance = UResourceBundle.getBundleInstance(ICUData.ICU_BASE_NAME, ZONEINFORES, ICUResourceBundle.ICU_DATA_CLASS_LOADER);
        construct(bundleInstance, ZoneMeta.openOlsonResource(bundleInstance, str), str);
    }

    private void construct(UResourceBundle uResourceBundle, UResourceBundle uResourceBundle2, String str) {
        int[] intVector;
        int[] intVector2;
        int[] intVector3;
        int i;
        int i2;
        char c;
        int i3;
        if (uResourceBundle == null || uResourceBundle2 == null) {
            dk0.v();
            return;
        }
        if (DEBUG) {
            System.out.println("OlsonTimeZone(" + uResourceBundle2.getKey() + ")");
        }
        int i4 = 0;
        this.transitionCount = 0;
        try {
            intVector = uResourceBundle2.get("transPre32").getIntVector();
            try {
                if (intVector.length % 2 != 0) {
                    throw new IllegalArgumentException("Invalid Format");
                }
                this.transitionCount += intVector.length / 2;
                try {
                    intVector2 = uResourceBundle2.get("trans").getIntVector();
                    try {
                        this.transitionCount += intVector2.length;
                    } catch (MissingResourceException unused) {
                    }
                } catch (MissingResourceException unused2) {
                    intVector2 = null;
                }
                try {
                    intVector3 = uResourceBundle2.get("transPost32").getIntVector();
                    try {
                        if (intVector3.length % 2 != 0) {
                            throw new IllegalArgumentException("Invalid Format");
                        }
                        this.transitionCount += intVector3.length / 2;
                        int i5 = this.transitionCount;
                        int i6 = 1;
                        if (i5 > 0) {
                            this.transitionTimes64 = new long[i5];
                            if (intVector != null) {
                                int i7 = 0;
                                i3 = 0;
                                c = ' ';
                                while (i7 < intVector.length / 2) {
                                    int i8 = i7 * 2;
                                    int i9 = i4;
                                    this.transitionTimes64[i3] = ((((long) intVector[i8]) & 4294967295L) << 32) | (((long) intVector[i8 + 1]) & 4294967295L);
                                    i7++;
                                    i3++;
                                    i6 = i6;
                                    i4 = i9;
                                }
                                i = i4;
                            } else {
                                i = 0;
                                c = ' ';
                                i3 = 0;
                            }
                            i2 = i6;
                            if (intVector2 != null) {
                                int i10 = i;
                                while (i10 < intVector2.length) {
                                    this.transitionTimes64[i3] = intVector2[i10];
                                    i10++;
                                    i3++;
                                }
                            }
                            if (intVector3 != null) {
                                int i11 = i;
                                while (i11 < intVector3.length / 2) {
                                    int i12 = i11 * 2;
                                    this.transitionTimes64[i3] = ((((long) intVector3[i12]) & 4294967295L) << c) | (((long) intVector3[i12 + 1]) & 4294967295L);
                                    i11++;
                                    i3++;
                                }
                            }
                        } else {
                            i = 0;
                            i2 = 1;
                            this.transitionTimes64 = null;
                        }
                        int[] intVector4 = uResourceBundle2.get("typeOffsets").getIntVector();
                        this.typeOffsets = intVector4;
                        if (intVector4.length < 2 || intVector4.length > 32766 || intVector4.length % 2 != 0) {
                            og.i("Invalid Format");
                            return;
                        }
                        this.typeCount = intVector4.length / 2;
                        if (this.transitionCount > 0) {
                            byte[] binary = uResourceBundle2.get("typeMap").getBinary(null);
                            this.typeMapData = binary;
                            if (binary == null || binary.length != this.transitionCount) {
                                og.i("Invalid Format");
                                return;
                            }
                        } else {
                            this.typeMapData = null;
                        }
                        this.finalZone = null;
                        this.finalStartYear = Integer.MAX_VALUE;
                        this.finalStartMillis = Double.MAX_VALUE;
                        try {
                            String string = uResourceBundle2.getString("finalRule");
                            int i13 = uResourceBundle2.get("finalRaw").getInt() * 1000;
                            int[] intVector5 = loadRule(uResourceBundle, string).getIntVector();
                            if (intVector5 == null || intVector5.length != 11) {
                                throw new IllegalArgumentException("Invalid Format");
                            }
                            this.finalZone = new SimpleTimeZone(i13, str, intVector5[i], intVector5[i2], intVector5[2], intVector5[3] * 1000, intVector5[4], intVector5[5], intVector5[6], intVector5[7], intVector5[8] * 1000, intVector5[9], intVector5[10] * 1000);
                            int i14 = uResourceBundle2.get("finalYear").getInt();
                            this.finalStartYear = i14;
                            this.finalStartMillis = Grego.fieldsToDay(i14, i, i2) * CalendarAstronomer.DAY_MS;
                        } catch (MissingResourceException unused3) {
                            if (0 == 0) {
                                return;
                            }
                            og.i("Invalid Format");
                        }
                    } catch (MissingResourceException unused4) {
                    }
                } catch (MissingResourceException unused5) {
                    intVector3 = null;
                }
            } catch (MissingResourceException unused6) {
            }
        } catch (MissingResourceException unused7) {
            intVector = null;
        }
    }

    private void constructEmpty() {
        this.transitionCount = 0;
        this.transitionTimes64 = null;
        this.typeMapData = null;
        this.typeCount = 1;
        this.typeOffsets = new int[]{0, 0};
        this.finalZone = null;
        this.finalStartYear = Integer.MAX_VALUE;
        this.finalStartMillis = Double.MAX_VALUE;
        this.transitionRulesInitialized = false;
    }

    private int dstOffsetAt(int i) {
        return this.typeOffsets[(i >= 0 ? getInt(this.typeMapData[i]) * 2 : 0) + 1];
    }

    private void getHistoricalOffset(long j, boolean z, int i, int i2, int[] iArr) {
        int i3;
        int i4;
        if (this.transitionCount == 0) {
            iArr[0] = initialRawOffset() * 1000;
            iArr[1] = initialDstOffset() * 1000;
            return;
        }
        long jFloorDivide = Grego.floorDivide(j, 1000L);
        if (!z && jFloorDivide < this.transitionTimes64[0]) {
            iArr[0] = initialRawOffset() * 1000;
            iArr[1] = initialDstOffset() * 1000;
            return;
        }
        int i5 = this.transitionCount - 1;
        while (i5 >= 0) {
            long j2 = this.transitionTimes64[i5];
            if (z && jFloorDivide >= j2 - 86400) {
                int i6 = i5 - 1;
                int iZoneOffsetAt = zoneOffsetAt(i6);
                boolean z2 = dstOffsetAt(i6) != 0;
                int iZoneOffsetAt2 = zoneOffsetAt(i5);
                boolean z3 = dstOffsetAt(i5) != 0;
                boolean z4 = z2 && !z3;
                boolean z5 = !z2 && z3;
                j2 += (iZoneOffsetAt2 - iZoneOffsetAt < 0 ? !((i3 = i2 & 3) == 1 && z4) && (!(i3 == 3 && z5) && ((i3 == 1 && z5) || ((i3 == 3 && z4) || (i2 & 12) == 4))) : ((i4 = i & 3) == 1 && z4) || ((i4 == 3 && z5) || (!(i4 == 1 && z5) && (!(i4 == 3 && z4) && (i & 12) == 12)))) ? iZoneOffsetAt : iZoneOffsetAt2;
            }
            if (jFloorDivide >= j2) {
                break;
            } else {
                i5--;
            }
        }
        iArr[0] = rawOffsetAt(i5) * 1000;
        iArr[1] = dstOffsetAt(i5) * 1000;
    }

    private int getInt(byte b) {
        return b & UCharacterEnums.ECharacterDirection.DIRECTIONALITY_UNDEFINED;
    }

    private synchronized void initTransitionRules() {
        TimeZoneRule timeArrayTimeZoneRule;
        int i;
        long j;
        try {
            if (this.transitionRulesInitialized) {
                return;
            }
            this.initialRule = null;
            this.firstTZTransition = null;
            this.firstFinalTZTransition = null;
            this.historicRules = null;
            this.firstTZTransitionIdx = 0;
            this.finalZoneWithStartYear = null;
            String str = getID() + "(STD)";
            String str2 = getID() + "(DST)";
            int iInitialRawOffset = initialRawOffset() * 1000;
            int iInitialDstOffset = initialDstOffset() * 1000;
            this.initialRule = new InitialTimeZoneRule(iInitialDstOffset == 0 ? str : str2, iInitialRawOffset, iInitialDstOffset);
            if (this.transitionCount > 0) {
                int i2 = 0;
                while (i2 < this.transitionCount && getInt(this.typeMapData[i2]) == 0) {
                    this.firstTZTransitionIdx++;
                    i2++;
                }
                int i3 = this.transitionCount;
                if (i2 != i3) {
                    long[] jArr = new long[i3];
                    int i4 = 0;
                    while (true) {
                        long j2 = 1000;
                        if (i4 >= this.typeCount) {
                            break;
                        }
                        int i5 = this.firstTZTransitionIdx;
                        int i6 = 0;
                        while (i5 < this.transitionCount) {
                            if (i4 == getInt(this.typeMapData[i5])) {
                                long j3 = this.transitionTimes64[i5] * j2;
                                j = j2;
                                i = i4;
                                if (j3 < this.finalStartMillis) {
                                    jArr[i6] = j3;
                                    i6++;
                                }
                            } else {
                                i = i4;
                                j = j2;
                            }
                            i5++;
                            j2 = j;
                            i4 = i;
                        }
                        int i7 = i4;
                        if (i6 > 0) {
                            long[] jArr2 = new long[i6];
                            System.arraycopy(jArr, 0, jArr2, 0, i6);
                            int[] iArr = this.typeOffsets;
                            int i8 = i7 * 2;
                            int i9 = iArr[i8] * 1000;
                            int i10 = iArr[i8 + 1] * 1000;
                            if (this.historicRules == null) {
                                this.historicRules = new TimeArrayTimeZoneRule[this.typeCount];
                            }
                            this.historicRules[i7] = new TimeArrayTimeZoneRule(i10 == 0 ? str : str2, i9, i10, jArr2, 2);
                        }
                        i4 = i7 + 1;
                    }
                    this.firstTZTransition = new TimeZoneTransition(this.transitionTimes64[this.firstTZTransitionIdx] * 1000, this.initialRule, this.historicRules[getInt(this.typeMapData[this.firstTZTransitionIdx])]);
                }
            }
            SimpleTimeZone simpleTimeZone = this.finalZone;
            if (simpleTimeZone != null) {
                long time = (long) this.finalStartMillis;
                boolean zUseDaylightTime = simpleTimeZone.useDaylightTime();
                SimpleTimeZone simpleTimeZone2 = this.finalZone;
                if (zUseDaylightTime) {
                    SimpleTimeZone simpleTimeZoneMo3clone = simpleTimeZone2.mo3clone();
                    this.finalZoneWithStartYear = simpleTimeZoneMo3clone;
                    simpleTimeZoneMo3clone.setStartYear(this.finalStartYear);
                    TimeZoneTransition nextTransition = this.finalZoneWithStartYear.getNextTransition(time, false);
                    timeArrayTimeZoneRule = nextTransition.getTo();
                    time = nextTransition.getTime();
                } else {
                    this.finalZoneWithStartYear = simpleTimeZone2;
                    timeArrayTimeZoneRule = new TimeArrayTimeZoneRule(simpleTimeZone2.getID(), this.finalZone.getRawOffset(), 0, new long[]{time}, 2);
                }
                int i11 = this.transitionCount;
                TimeZoneRule timeZoneRule = i11 > 0 ? this.historicRules[getInt(this.typeMapData[i11 - 1])] : null;
                if (timeZoneRule == null) {
                    timeZoneRule = this.initialRule;
                }
                this.firstFinalTZTransition = new TimeZoneTransition(time, timeZoneRule, timeArrayTimeZoneRule);
            }
            this.transitionRulesInitialized = true;
        } catch (Throwable th) {
            throw th;
        }
    }

    private int initialDstOffset() {
        return this.typeOffsets[1];
    }

    private int initialRawOffset() {
        return this.typeOffsets[0];
    }

    private static UResourceBundle loadRule(UResourceBundle uResourceBundle, String str) {
        return uResourceBundle.get("Rules").get(str);
    }

    private int rawOffsetAt(int i) {
        return this.typeOffsets[i >= 0 ? getInt(this.typeMapData[i]) * 2 : 0];
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        if (this.serialVersionOnStream < 1) {
            String id = getID();
            if (id != null) {
                try {
                    UResourceBundle bundleInstance = UResourceBundle.getBundleInstance(ICUData.ICU_BASE_NAME, ZONEINFORES, ICUResourceBundle.ICU_DATA_CLASS_LOADER);
                    construct(bundleInstance, ZoneMeta.openOlsonResource(bundleInstance, id), id);
                } catch (Exception unused) {
                    constructEmpty();
                }
            } else {
                constructEmpty();
            }
        }
        this.transitionRulesInitialized = false;
    }

    private int zoneOffsetAt(int i) {
        int i2 = i >= 0 ? getInt(this.typeMapData[i]) * 2 : 0;
        int[] iArr = this.typeOffsets;
        return iArr[i2] + iArr[i2 + 1];
    }

    @Override // com.ibm.icu.util.TimeZone
    /* JADX INFO: renamed from: clone */
    public OlsonTimeZone mo3clone() {
        return isFrozen() ? this : cloneAsThawed();
    }

    @Override // com.ibm.icu.util.TimeZone, com.ibm.icu.util.Freezable
    public OlsonTimeZone cloneAsThawed() {
        OlsonTimeZone olsonTimeZone = (OlsonTimeZone) super.cloneAsThawed();
        SimpleTimeZone simpleTimeZone = this.finalZone;
        if (simpleTimeZone != null) {
            olsonTimeZone.finalZone = simpleTimeZone.mo3clone();
        }
        olsonTimeZone.isFrozen = false;
        return olsonTimeZone;
    }

    @Override // com.ibm.icu.util.TimeZone
    public boolean equals(Object obj) {
        SimpleTimeZone simpleTimeZone;
        if (!super.equals(obj)) {
            return false;
        }
        OlsonTimeZone olsonTimeZone = (OlsonTimeZone) obj;
        if (Utility.arrayEquals(this.typeMapData, (Object) olsonTimeZone.typeMapData)) {
            return true;
        }
        if (this.finalStartYear == olsonTimeZone.finalStartYear) {
            SimpleTimeZone simpleTimeZone2 = this.finalZone;
            if (simpleTimeZone2 == null && olsonTimeZone.finalZone == null) {
                return true;
            }
            if (simpleTimeZone2 != null && (simpleTimeZone = olsonTimeZone.finalZone) != null && simpleTimeZone2.equals(simpleTimeZone) && this.transitionCount == olsonTimeZone.transitionCount && this.typeCount == olsonTimeZone.typeCount && Utility.arrayEquals((Object) this.transitionTimes64, (Object) olsonTimeZone.transitionTimes64) && Utility.arrayEquals(this.typeOffsets, (Object) olsonTimeZone.typeOffsets) && Utility.arrayEquals(this.typeMapData, (Object) olsonTimeZone.typeMapData)) {
                return true;
            }
        }
        return false;
    }

    public String getCanonicalID() {
        if (this.canonicalID == null) {
            synchronized (this) {
                try {
                    if (this.canonicalID == null) {
                        this.canonicalID = TimeZone.getCanonicalID(getID());
                        if (this.canonicalID == null) {
                            this.canonicalID = getID();
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return this.canonicalID;
    }

    @Override // com.ibm.icu.util.TimeZone
    public int getDSTSavings() {
        SimpleTimeZone simpleTimeZone = this.finalZone;
        return simpleTimeZone != null ? simpleTimeZone.getDSTSavings() : super.getDSTSavings();
    }

    @Override // com.ibm.icu.util.BasicTimeZone
    public TimeZoneTransition getNextTransition(long j, boolean z) {
        int i;
        initTransitionRules();
        if (this.finalZone != null) {
            if (z && j == this.firstFinalTZTransition.getTime()) {
                return this.firstFinalTZTransition;
            }
            if (j >= this.firstFinalTZTransition.getTime()) {
                if (this.finalZone.useDaylightTime()) {
                    return this.finalZoneWithStartYear.getNextTransition(j, z);
                }
                return null;
            }
        }
        if (this.historicRules == null) {
            return null;
        }
        int i2 = this.transitionCount;
        while (true) {
            i2--;
            i = this.firstTZTransitionIdx;
            if (i2 < i) {
                break;
            }
            long j2 = this.transitionTimes64[i2] * 1000;
            if (j > j2 || (!z && j == j2)) {
                break;
            }
        }
        if (i2 == this.transitionCount - 1) {
            return this.firstFinalTZTransition;
        }
        if (i2 < i) {
            return this.firstTZTransition;
        }
        int i3 = i2 + 1;
        TimeArrayTimeZoneRule timeArrayTimeZoneRule = this.historicRules[getInt(this.typeMapData[i3])];
        TimeArrayTimeZoneRule timeArrayTimeZoneRule2 = this.historicRules[getInt(this.typeMapData[i2])];
        long j3 = this.transitionTimes64[i3] * 1000;
        return (timeArrayTimeZoneRule2.getName().equals(timeArrayTimeZoneRule.getName()) && timeArrayTimeZoneRule2.getRawOffset() == timeArrayTimeZoneRule.getRawOffset() && timeArrayTimeZoneRule2.getDSTSavings() == timeArrayTimeZoneRule.getDSTSavings()) ? getNextTransition(j3, false) : new TimeZoneTransition(j3, timeArrayTimeZoneRule2, timeArrayTimeZoneRule);
    }

    public int getOffset(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        if ((i != 1 && i != 0) || i3 < 0 || i3 > 11 || i4 < 1 || i4 > i7 || i5 < 1 || i5 > 7 || i6 < 0 || i6 >= 86400000 || i7 < 28 || i7 > 31) {
            dk0.v();
            return 0;
        }
        if (i == 0) {
            i2 = -i2;
        }
        int i8 = i2;
        SimpleTimeZone simpleTimeZone = this.finalZone;
        if (simpleTimeZone != null && i8 >= this.finalStartYear) {
            return simpleTimeZone.getOffset(i, i8, i3, i4, i5, i6);
        }
        int[] iArr = new int[2];
        getHistoricalOffset((Grego.fieldsToDay(i8, i3, i4) * CalendarAstronomer.DAY_MS) + ((long) i6), true, 3, 1, iArr);
        return iArr[0] + iArr[1];
    }

    @Override // com.ibm.icu.util.BasicTimeZone
    public void getOffsetFromLocal(long j, BasicTimeZone.LocalOption localOption, BasicTimeZone.LocalOption localOption2, int[] iArr) {
        SimpleTimeZone simpleTimeZone = this.finalZone;
        if (simpleTimeZone == null || j < this.finalStartMillis) {
            getHistoricalOffset(j, true, BasicTimeZone.getLocalOptionValue(localOption), BasicTimeZone.getLocalOptionValue(localOption2), iArr);
        } else {
            simpleTimeZone.getOffsetFromLocal(j, localOption, localOption2, iArr);
        }
    }

    @Override // com.ibm.icu.util.BasicTimeZone
    public TimeZoneTransition getPreviousTransition(long j, boolean z) {
        int i;
        initTransitionRules();
        if (this.finalZone != null) {
            if (z && j == this.firstFinalTZTransition.getTime()) {
                return this.firstFinalTZTransition;
            }
            if (j > this.firstFinalTZTransition.getTime()) {
                return this.finalZone.useDaylightTime() ? this.finalZoneWithStartYear.getPreviousTransition(j, z) : this.firstFinalTZTransition;
            }
        }
        if (this.historicRules == null) {
            return null;
        }
        int i2 = this.transitionCount;
        while (true) {
            i2--;
            i = this.firstTZTransitionIdx;
            if (i2 < i) {
                break;
            }
            long j2 = this.transitionTimes64[i2] * 1000;
            if (j > j2 || (z && j == j2)) {
                break;
            }
        }
        if (i2 < i) {
            return null;
        }
        if (i2 == i) {
            return this.firstTZTransition;
        }
        TimeArrayTimeZoneRule timeArrayTimeZoneRule = this.historicRules[getInt(this.typeMapData[i2])];
        TimeArrayTimeZoneRule timeArrayTimeZoneRule2 = this.historicRules[getInt(this.typeMapData[i2 - 1])];
        long j3 = this.transitionTimes64[i2] * 1000;
        return (timeArrayTimeZoneRule2.getName().equals(timeArrayTimeZoneRule.getName()) && timeArrayTimeZoneRule2.getRawOffset() == timeArrayTimeZoneRule.getRawOffset() && timeArrayTimeZoneRule2.getDSTSavings() == timeArrayTimeZoneRule.getDSTSavings()) ? getPreviousTransition(j3, false) : new TimeZoneTransition(j3, timeArrayTimeZoneRule2, timeArrayTimeZoneRule);
    }

    @Override // com.ibm.icu.util.TimeZone
    public int getRawOffset() {
        int[] iArr = new int[2];
        getOffset(System.currentTimeMillis(), false, iArr);
        return iArr[0];
    }

    @Override // com.ibm.icu.util.BasicTimeZone
    public TimeZoneRule[] getTimeZoneRules() {
        int i;
        int i2;
        initTransitionRules();
        if (this.historicRules != null) {
            int i3 = 0;
            i = 1;
            while (true) {
                TimeArrayTimeZoneRule[] timeArrayTimeZoneRuleArr = this.historicRules;
                if (i3 >= timeArrayTimeZoneRuleArr.length) {
                    break;
                }
                if (timeArrayTimeZoneRuleArr[i3] != null) {
                    i++;
                }
                i3++;
            }
        } else {
            i = 1;
        }
        SimpleTimeZone simpleTimeZone = this.finalZone;
        if (simpleTimeZone != null) {
            i = simpleTimeZone.useDaylightTime() ? i + 2 : i + 1;
        }
        TimeZoneRule[] timeZoneRuleArr = new TimeZoneRule[i];
        timeZoneRuleArr[0] = this.initialRule;
        if (this.historicRules != null) {
            int i4 = 0;
            i2 = 1;
            while (true) {
                TimeArrayTimeZoneRule[] timeArrayTimeZoneRuleArr2 = this.historicRules;
                if (i4 >= timeArrayTimeZoneRuleArr2.length) {
                    break;
                }
                TimeArrayTimeZoneRule timeArrayTimeZoneRule = timeArrayTimeZoneRuleArr2[i4];
                if (timeArrayTimeZoneRule != null) {
                    timeZoneRuleArr[i2] = timeArrayTimeZoneRule;
                    i2++;
                }
                i4++;
            }
        } else {
            i2 = 1;
        }
        SimpleTimeZone simpleTimeZone2 = this.finalZone;
        if (simpleTimeZone2 != null) {
            if (simpleTimeZone2.useDaylightTime()) {
                TimeZoneRule[] timeZoneRules = this.finalZoneWithStartYear.getTimeZoneRules();
                timeZoneRuleArr[i2] = timeZoneRules[1];
                timeZoneRuleArr[i2 + 1] = timeZoneRules[2];
                return timeZoneRuleArr;
            }
            timeZoneRuleArr[i2] = new TimeArrayTimeZoneRule(ky0.j(getID(), "(STD)"), this.finalZone.getRawOffset(), 0, new long[]{(long) this.finalStartMillis}, 2);
        }
        return timeZoneRuleArr;
    }

    @Override // com.ibm.icu.util.TimeZone
    public boolean hasSameRules(TimeZone timeZone) {
        if (this == timeZone) {
            return true;
        }
        if (!super.hasSameRules(timeZone) || !(timeZone instanceof OlsonTimeZone)) {
            return false;
        }
        OlsonTimeZone olsonTimeZone = (OlsonTimeZone) timeZone;
        SimpleTimeZone simpleTimeZone = this.finalZone;
        SimpleTimeZone simpleTimeZone2 = olsonTimeZone.finalZone;
        if (simpleTimeZone != null) {
            if (simpleTimeZone2 != null && this.finalStartYear == olsonTimeZone.finalStartYear && simpleTimeZone.hasSameRules(simpleTimeZone2)) {
            }
        }
        if (simpleTimeZone2 != null) {
            return false;
        }
        return this.transitionCount == olsonTimeZone.transitionCount && Arrays.equals(this.transitionTimes64, olsonTimeZone.transitionTimes64) && this.typeCount == olsonTimeZone.typeCount && Arrays.equals(this.typeMapData, olsonTimeZone.typeMapData) && Arrays.equals(this.typeOffsets, olsonTimeZone.typeOffsets);
    }

    @Override // com.ibm.icu.util.TimeZone
    public int hashCode() {
        int i = this.finalStartYear;
        int i2 = this.transitionCount;
        int i3 = i ^ ((i >>> 4) + i2);
        int i4 = i2 >>> 6;
        int i5 = this.typeCount;
        long j = i3 ^ (i4 + i5);
        long jDoubleToLongBits = Double.doubleToLongBits(this.finalStartMillis) + ((long) (i5 >>> 8));
        SimpleTimeZone simpleTimeZone = this.finalZone;
        int i6 = 0;
        int iHashCode = (int) (j ^ ((jDoubleToLongBits + ((long) (simpleTimeZone == null ? 0 : simpleTimeZone.hashCode()))) + ((long) super.hashCode())));
        if (this.transitionTimes64 != null) {
            int i7 = 0;
            while (true) {
                long[] jArr = this.transitionTimes64;
                if (i7 >= jArr.length) {
                    break;
                }
                long j2 = jArr[i7];
                iHashCode = (int) (((long) iHashCode) + (j2 ^ (j2 >>> 8)));
                i7++;
            }
        }
        int i8 = 0;
        while (true) {
            int[] iArr = this.typeOffsets;
            if (i8 >= iArr.length) {
                break;
            }
            int i9 = iArr[i8];
            iHashCode += i9 ^ (i9 >>> 8);
            i8++;
        }
        if (this.typeMapData != null) {
            while (true) {
                byte[] bArr = this.typeMapData;
                if (i6 >= bArr.length) {
                    break;
                }
                iHashCode += bArr[i6] & UCharacterEnums.ECharacterDirection.DIRECTIONALITY_UNDEFINED;
                i6++;
            }
        }
        return iHashCode;
    }

    @Override // com.ibm.icu.util.TimeZone
    public boolean inDaylightTime(Date date) {
        int[] iArr = new int[2];
        getOffset(date.getTime(), false, iArr);
        return iArr[1] != 0;
    }

    @Override // com.ibm.icu.util.TimeZone, com.ibm.icu.util.Freezable
    public boolean isFrozen() {
        return this.isFrozen;
    }

    @Override // com.ibm.icu.util.TimeZone
    public boolean observesDaylightTime() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        SimpleTimeZone simpleTimeZone = this.finalZone;
        if (simpleTimeZone != null) {
            if (simpleTimeZone.useDaylightTime()) {
                return true;
            }
            if (jCurrentTimeMillis >= this.finalStartMillis) {
                return false;
            }
        }
        long jFloorDivide = Grego.floorDivide(jCurrentTimeMillis, 1000L);
        int i = this.transitionCount - 1;
        if (dstOffsetAt(i) != 0) {
            return true;
        }
        while (i >= 0 && this.transitionTimes64[i] > jFloorDivide) {
            if (dstOffsetAt(i - 1) != 0) {
                return true;
            }
            i--;
        }
        return false;
    }

    @Override // com.ibm.icu.util.TimeZone
    public void setID(String str) {
        if (isFrozen()) {
            dk0.r("Attempt to modify a frozen OlsonTimeZone instance.");
            return;
        }
        if (this.canonicalID == null) {
            this.canonicalID = TimeZone.getCanonicalID(getID());
            if (this.canonicalID == null) {
                this.canonicalID = getID();
            }
        }
        SimpleTimeZone simpleTimeZone = this.finalZone;
        if (simpleTimeZone != null) {
            simpleTimeZone.setID(str);
        }
        super.setID(str);
        this.transitionRulesInitialized = false;
    }

    /* JADX WARN: Code duplicated, block: B:27:0x00ab  */
    @Override // com.ibm.icu.util.TimeZone
    public void setRawOffset(int i) {
        int i2;
        DateTimeRule rule;
        DateTimeRule rule2;
        TimeZoneTransition previousTransition;
        if (isFrozen()) {
            dk0.r("Attempt to modify a frozen OlsonTimeZone instance.");
            return;
        }
        if (getRawOffset() == i) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis < this.finalStartMillis) {
            SimpleTimeZone simpleTimeZone = new SimpleTimeZone(i, getID());
            boolean zUseDaylightTime = useDaylightTime();
            if (zUseDaylightTime) {
                TimeZoneRule[] simpleTimeZoneRulesNear = getSimpleTimeZoneRulesNear(jCurrentTimeMillis);
                if (simpleTimeZoneRulesNear.length != 3 && (previousTransition = getPreviousTransition(jCurrentTimeMillis, false)) != null) {
                    simpleTimeZoneRulesNear = getSimpleTimeZoneRulesNear(previousTransition.getTime() - 1);
                }
                if (simpleTimeZoneRulesNear.length == 3) {
                    TimeZoneRule timeZoneRule = simpleTimeZoneRulesNear[1];
                    if (timeZoneRule instanceof AnnualTimeZoneRule) {
                        TimeZoneRule timeZoneRule2 = simpleTimeZoneRulesNear[2];
                        if (timeZoneRule2 instanceof AnnualTimeZoneRule) {
                            AnnualTimeZoneRule annualTimeZoneRule = (AnnualTimeZoneRule) timeZoneRule;
                            AnnualTimeZoneRule annualTimeZoneRule2 = (AnnualTimeZoneRule) timeZoneRule2;
                            int dSTSavings = annualTimeZoneRule.getDSTSavings() + annualTimeZoneRule.getRawOffset();
                            int dSTSavings2 = annualTimeZoneRule2.getDSTSavings() + annualTimeZoneRule2.getRawOffset();
                            if (dSTSavings > dSTSavings2) {
                                rule = annualTimeZoneRule.getRule();
                                rule2 = annualTimeZoneRule2.getRule();
                                i2 = dSTSavings - dSTSavings2;
                            } else {
                                DateTimeRule rule3 = annualTimeZoneRule2.getRule();
                                DateTimeRule rule4 = annualTimeZoneRule.getRule();
                                i2 = dSTSavings2 - dSTSavings;
                                rule = rule3;
                                rule2 = rule4;
                            }
                            simpleTimeZone.setStartRule(rule.getRuleMonth(), rule.getRuleWeekInMonth(), rule.getRuleDayOfWeek(), rule.getRuleMillisInDay());
                            simpleTimeZone.setEndRule(rule2.getRuleMonth(), rule2.getRuleWeekInMonth(), rule2.getRuleDayOfWeek(), rule2.getRuleMillisInDay());
                            simpleTimeZone.setDSTSavings(i2);
                        } else {
                            simpleTimeZone.setStartRule(0, 1, 0);
                            simpleTimeZone.setEndRule(11, 31, 86399999);
                        }
                    } else {
                        simpleTimeZone.setStartRule(0, 1, 0);
                        simpleTimeZone.setEndRule(11, 31, 86399999);
                    }
                } else {
                    simpleTimeZone.setStartRule(0, 1, 0);
                    simpleTimeZone.setEndRule(11, 31, 86399999);
                }
            }
            int iTimeToYear = Grego.timeToYear(jCurrentTimeMillis);
            this.finalStartYear = iTimeToYear;
            this.finalStartMillis = Grego.fieldsToDay(iTimeToYear, 0, 1);
            if (zUseDaylightTime) {
                simpleTimeZone.setStartYear(this.finalStartYear);
            }
            this.finalZone = simpleTimeZone;
        } else {
            this.finalZone.setRawOffset(i);
        }
        this.transitionRulesInitialized = false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append('[');
        sb.append("transitionCount=" + this.transitionCount);
        sb.append(",typeCount=" + this.typeCount);
        sb.append(",transitionTimes=");
        if (this.transitionTimes64 != null) {
            sb.append('[');
            for (int i = 0; i < this.transitionTimes64.length; i++) {
                if (i > 0) {
                    sb.append(',');
                }
                sb.append(Long.toString(this.transitionTimes64[i]));
            }
            sb.append(']');
        } else {
            sb.append("null");
        }
        sb.append(",typeOffsets=");
        if (this.typeOffsets != null) {
            sb.append('[');
            for (int i2 = 0; i2 < this.typeOffsets.length; i2++) {
                if (i2 > 0) {
                    sb.append(',');
                }
                sb.append(Integer.toString(this.typeOffsets[i2]));
            }
            sb.append(']');
        } else {
            sb.append("null");
        }
        sb.append(",typeMapData=");
        if (this.typeMapData != null) {
            sb.append('[');
            for (int i3 = 0; i3 < this.typeMapData.length; i3++) {
                if (i3 > 0) {
                    sb.append(',');
                }
                sb.append(Byte.toString(this.typeMapData[i3]));
            }
        } else {
            sb.append("null");
        }
        sb.append(",finalStartYear=" + this.finalStartYear);
        sb.append(",finalStartMillis=" + this.finalStartMillis);
        sb.append(",finalZone=".concat(String.valueOf(this.finalZone)));
        sb.append(']');
        return sb.toString();
    }

    @Override // com.ibm.icu.util.TimeZone
    public boolean useDaylightTime() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        SimpleTimeZone simpleTimeZone = this.finalZone;
        if (simpleTimeZone != null && jCurrentTimeMillis >= this.finalStartMillis) {
            return simpleTimeZone != null && simpleTimeZone.useDaylightTime();
        }
        int iTimeToYear = Grego.timeToYear(jCurrentTimeMillis);
        long jFieldsToDay = Grego.fieldsToDay(iTimeToYear, 0, 1) * 86400;
        long jFieldsToDay2 = Grego.fieldsToDay(iTimeToYear + 1, 0, 1) * 86400;
        for (int i = 0; i < this.transitionCount; i++) {
            long j = this.transitionTimes64[i];
            if (j >= jFieldsToDay2) {
                break;
            }
            if ((j >= jFieldsToDay && dstOffsetAt(i) != 0) || (this.transitionTimes64[i] > jFieldsToDay && i > 0 && dstOffsetAt(i - 1) != 0)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.ibm.icu.util.TimeZone, com.ibm.icu.util.Freezable
    public TimeZone freeze() {
        this.isFrozen = true;
        return this;
    }

    public OlsonTimeZone(UResourceBundle uResourceBundle, UResourceBundle uResourceBundle2, String str) {
        super(str);
        this.finalStartYear = Integer.MAX_VALUE;
        this.finalStartMillis = Double.MAX_VALUE;
        this.finalZone = null;
        this.canonicalID = null;
        this.serialVersionOnStream = 1;
        this.isFrozen = false;
        construct(uResourceBundle, uResourceBundle2, str);
    }

    @Override // com.ibm.icu.util.TimeZone
    public int getOffset(int i, int i2, int i3, int i4, int i5, int i6) {
        if (i3 >= 0 && i3 <= 11) {
            return getOffset(i, i2, i3, i4, i5, i6, Grego.monthLength(i2, i3));
        }
        og.i(ky0.h(i3, "Month is not in the legal range: "));
        return 0;
    }

    @Override // com.ibm.icu.util.TimeZone
    public void getOffset(long j, boolean z, int[] iArr) {
        SimpleTimeZone simpleTimeZone = this.finalZone;
        if (simpleTimeZone != null && j >= this.finalStartMillis) {
            simpleTimeZone.getOffset(j, z, iArr);
        } else {
            getHistoricalOffset(j, z, 4, 12, iArr);
        }
    }
}
