package com.ibm.icu.util;

import com.ibm.icu.impl.Grego;
import com.ibm.icu.lang.UCharacterEnums;
import defpackage.cq;
import defpackage.dk0;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Date;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class SimpleTimeZone extends BasicTimeZone implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int DOM_MODE = 1;
    private static final int DOW_GE_DOM_MODE = 3;
    private static final int DOW_IN_MONTH_MODE = 2;
    private static final int DOW_LE_DOM_MODE = 4;
    public static final int STANDARD_TIME = 1;
    public static final int UTC_TIME = 2;
    public static final int WALL_TIME = 0;
    private static final long serialVersionUID = -7034676239311322769L;
    private static final byte[] staticMonthLength = {31, 29, 31, UCharacterEnums.ECharacterCategory.CHAR_CATEGORY_COUNT, 31, UCharacterEnums.ECharacterCategory.CHAR_CATEGORY_COUNT, 31, 31, UCharacterEnums.ECharacterCategory.CHAR_CATEGORY_COUNT, 31, UCharacterEnums.ECharacterCategory.CHAR_CATEGORY_COUNT, 31};
    private int dst;
    private transient AnnualTimeZoneRule dstRule;
    private int endDay;
    private int endDayOfWeek;
    private int endMode;
    private int endMonth;
    private int endTime;
    private int endTimeMode;
    private transient TimeZoneTransition firstTransition;
    private transient InitialTimeZoneRule initialRule;
    private volatile transient boolean isFrozen;
    private int raw;
    private int startDay;
    private int startDayOfWeek;
    private int startMode;
    private int startMonth;
    private int startTime;
    private int startTimeMode;
    private int startYear;
    private transient AnnualTimeZoneRule stdRule;
    private transient boolean transitionRulesInitialized;
    private boolean useDaylight;
    private STZInfo xinfo;

    public SimpleTimeZone(int i, String str, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12) {
        super(str);
        this.dst = 3600000;
        this.xinfo = null;
        this.isFrozen = false;
        construct(i, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11, i12);
    }

    private int compareToRule(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12) {
        int i13;
        int i14 = i6 + i7;
        while (i14 >= 86400000) {
            i14 -= Grego.MILLIS_PER_DAY;
            i4++;
            i5 = (i5 % 7) + 1;
            if (i4 > i2) {
                i++;
                i4 = 1;
            }
        }
        while (i14 < 0) {
            i4--;
            i5 = ((i5 + 5) % 7) + 1;
            if (i4 < 1) {
                i--;
                i4 = i3;
            }
            i14 += Grego.MILLIS_PER_DAY;
        }
        if (i < i9) {
            return -1;
        }
        if (i > i9) {
            return 1;
        }
        if (i11 > i2) {
            i11 = i2;
        }
        if (i8 != 1) {
            if (i8 != 2) {
                if (i8 != 3) {
                    i11 = i8 != 4 ? 0 : i11 - (((((49 - i10) + i11) + i5) - i4) % 7);
                } else {
                    i13 = ((((i10 + 49) - i11) - i5) + i4) % 7;
                    i11 += i13;
                }
            } else if (i11 > 0) {
                i11 = ((i11 - 1) * 7) + 1;
                i13 = ((i10 + 7) - ((i5 - i4) + 1)) % 7;
                i11 += i13;
            } else {
                i11 = (((i11 + 1) * 7) + i2) - (((((i5 + i2) - i4) + 7) - i10) % 7);
            }
        }
        if (i4 < i11) {
            return -1;
        }
        if (i4 > i11) {
            return 1;
        }
        if (i14 < i12) {
            return -1;
        }
        return i14 > i12 ? 1 : 0;
    }

    private void construct(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12) {
        this.raw = i;
        this.startMonth = i2;
        this.startDay = i3;
        this.startDayOfWeek = i4;
        this.startTime = i5;
        this.startTimeMode = i6;
        this.endMonth = i7;
        this.endDay = i8;
        this.endDayOfWeek = i9;
        this.endTime = i10;
        this.endTimeMode = i11;
        this.dst = i12;
        this.startYear = 0;
        this.startMode = 1;
        this.endMode = 1;
        decodeRules();
        if (i12 != 0) {
            return;
        }
        dk0.v();
    }

    private void decodeEndRule() {
        int i;
        boolean z = (this.startDay == 0 || this.endDay == 0) ? false : true;
        this.useDaylight = z;
        if (z && this.dst == 0) {
            this.dst = Grego.MILLIS_PER_DAY;
        }
        int i2 = this.endDay;
        if (i2 != 0) {
            int i3 = this.endMonth;
            if (i3 < 0 || i3 > 11) {
                dk0.v();
                return;
            }
            int i4 = this.endTime;
            if (i4 < 0 || i4 > 86400000 || (i = this.endTimeMode) < 0 || i > 2) {
                dk0.v();
                return;
            }
            int i5 = this.endDayOfWeek;
            if (i5 == 0) {
                this.endMode = 1;
            } else {
                if (i5 > 0) {
                    this.endMode = 2;
                } else {
                    this.endDayOfWeek = -i5;
                    if (i2 > 0) {
                        this.endMode = 3;
                    } else {
                        this.endDay = -i2;
                        this.endMode = 4;
                    }
                }
                if (this.endDayOfWeek > 7) {
                    dk0.v();
                    return;
                }
            }
            int i6 = this.endMode;
            int i7 = this.endDay;
            if (i6 == 2) {
                if (i7 < -5 || i7 > 5) {
                    dk0.v();
                    return;
                }
                return;
            }
            if (i7 < 1 || i7 > staticMonthLength[i3]) {
                dk0.v();
            }
        }
    }

    private void decodeRules() {
        decodeStartRule();
        decodeEndRule();
    }

    private void decodeStartRule() {
        int i;
        int i2 = this.startDay;
        boolean z = (i2 == 0 || this.endDay == 0) ? false : true;
        this.useDaylight = z;
        if (z && this.dst == 0) {
            this.dst = Grego.MILLIS_PER_DAY;
        }
        if (i2 != 0) {
            int i3 = this.startMonth;
            if (i3 < 0 || i3 > 11) {
                dk0.v();
                return;
            }
            int i4 = this.startTime;
            if (i4 < 0 || i4 > 86400000 || (i = this.startTimeMode) < 0 || i > 2) {
                dk0.v();
                return;
            }
            int i5 = this.startDayOfWeek;
            if (i5 == 0) {
                this.startMode = 1;
            } else {
                if (i5 > 0) {
                    this.startMode = 2;
                } else {
                    this.startDayOfWeek = -i5;
                    if (i2 > 0) {
                        this.startMode = 3;
                    } else {
                        this.startDay = -i2;
                        this.startMode = 4;
                    }
                }
                if (this.startDayOfWeek > 7) {
                    dk0.v();
                    return;
                }
            }
            int i6 = this.startMode;
            int i7 = this.startDay;
            if (i6 == 2) {
                if (i7 < -5 || i7 > 5) {
                    dk0.v();
                    return;
                }
                return;
            }
            if (i7 < 1 || i7 > staticMonthLength[i3]) {
                dk0.v();
            }
        }
    }

    private int getOffset(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        int iCompareToRule;
        int i9;
        int i10;
        if ((i != 1 && i != 0) || i3 < 0 || i3 > 11 || i4 < 1 || i4 > i7 || i5 < 1 || i5 > 7 || i6 < 0 || i6 >= 86400000 || i7 < 28 || i7 > 31 || i8 < 28 || i8 > 31) {
            dk0.v();
            return 0;
        }
        int i11 = this.raw;
        if (!this.useDaylight || i2 < this.startYear || i != 1) {
            return i11;
        }
        int i12 = this.startMonth;
        boolean z = i12 > this.endMonth;
        int iCompareToRule2 = compareToRule(i3, i7, i8, i4, i5, i6, this.startTimeMode == 2 ? -i11 : 0, this.startMode, i12, this.startDayOfWeek, this.startDay, this.startTime);
        if (z != (iCompareToRule2 >= 0)) {
            int i13 = this.endTimeMode;
            if (i13 == 0) {
                i10 = this.dst;
            } else {
                if (i13 == 2) {
                    i10 = -this.raw;
                } else {
                    i9 = 0;
                }
                iCompareToRule = compareToRule(i3, i7, i8, i4, i5, i6, i9, this.endMode, this.endMonth, this.endDayOfWeek, this.endDay, this.endTime);
            }
            i9 = i10;
            iCompareToRule = compareToRule(i3, i7, i8, i4, i5, i6, i9, this.endMode, this.endMonth, this.endDayOfWeek, this.endDay, this.endTime);
        } else {
            iCompareToRule = 0;
        }
        if (z || iCompareToRule2 < 0 || iCompareToRule >= 0) {
            if (!z) {
                return i11;
            }
            if (iCompareToRule2 < 0 && iCompareToRule >= 0) {
                return i11;
            }
        }
        return i11 + this.dst;
    }

    private STZInfo getSTZInfo() {
        if (this.xinfo == null) {
            this.xinfo = new STZInfo();
        }
        return this.xinfo;
    }

    private boolean idEquals(String str, String str2) {
        if (str == null && str2 == null) {
            return true;
        }
        if (str == null || str2 == null) {
            return false;
        }
        return str.equals(str2);
    }

    /* JADX WARN: Code duplicated, block: B:32:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:33:0x00a7 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:34:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:35:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:38:0x00b2 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:39:0x00b4 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:40:0x00b6 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:41:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:42:0x00bb A[Catch: all -> 0x003c, TryCatch #0 {all -> 0x003c, blocks: (B:4:0x0003, B:8:0x0009, B:10:0x000f, B:16:0x001b, B:30:0x0069, B:36:0x00ae, B:47:0x0113, B:49:0x014f, B:52:0x01b8, B:50:0x017f, B:42:0x00bb, B:44:0x00d5, B:45:0x00ed, B:46:0x0105, B:23:0x002b, B:27:0x003f, B:28:0x004e, B:29:0x005d, B:51:0x01a9), top: B:57:0x0003 }] */
    /* JADX WARN: Code duplicated, block: B:44:0x00d5 A[Catch: all -> 0x003c, TryCatch #0 {all -> 0x003c, blocks: (B:4:0x0003, B:8:0x0009, B:10:0x000f, B:16:0x001b, B:30:0x0069, B:36:0x00ae, B:47:0x0113, B:49:0x014f, B:52:0x01b8, B:50:0x017f, B:42:0x00bb, B:44:0x00d5, B:45:0x00ed, B:46:0x0105, B:23:0x002b, B:27:0x003f, B:28:0x004e, B:29:0x005d, B:51:0x01a9), top: B:57:0x0003 }] */
    /* JADX WARN: Code duplicated, block: B:45:0x00ed A[Catch: all -> 0x003c, TryCatch #0 {all -> 0x003c, blocks: (B:4:0x0003, B:8:0x0009, B:10:0x000f, B:16:0x001b, B:30:0x0069, B:36:0x00ae, B:47:0x0113, B:49:0x014f, B:52:0x01b8, B:50:0x017f, B:42:0x00bb, B:44:0x00d5, B:45:0x00ed, B:46:0x0105, B:23:0x002b, B:27:0x003f, B:28:0x004e, B:29:0x005d, B:51:0x01a9), top: B:57:0x0003 }] */
    /* JADX WARN: Code duplicated, block: B:46:0x0105 A[Catch: all -> 0x003c, TryCatch #0 {all -> 0x003c, blocks: (B:4:0x0003, B:8:0x0009, B:10:0x000f, B:16:0x001b, B:30:0x0069, B:36:0x00ae, B:47:0x0113, B:49:0x014f, B:52:0x01b8, B:50:0x017f, B:42:0x00bb, B:44:0x00d5, B:45:0x00ed, B:46:0x0105, B:23:0x002b, B:27:0x003f, B:28:0x004e, B:29:0x005d, B:51:0x01a9), top: B:57:0x0003 }] */
    /* JADX WARN: Code duplicated, block: B:49:0x014f A[Catch: all -> 0x003c, TryCatch #0 {all -> 0x003c, blocks: (B:4:0x0003, B:8:0x0009, B:10:0x000f, B:16:0x001b, B:30:0x0069, B:36:0x00ae, B:47:0x0113, B:49:0x014f, B:52:0x01b8, B:50:0x017f, B:42:0x00bb, B:44:0x00d5, B:45:0x00ed, B:46:0x0105, B:23:0x002b, B:27:0x003f, B:28:0x004e, B:29:0x005d, B:51:0x01a9), top: B:57:0x0003 }] */
    /* JADX WARN: Code duplicated, block: B:50:0x017f A[Catch: all -> 0x003c, TryCatch #0 {all -> 0x003c, blocks: (B:4:0x0003, B:8:0x0009, B:10:0x000f, B:16:0x001b, B:30:0x0069, B:36:0x00ae, B:47:0x0113, B:49:0x014f, B:52:0x01b8, B:50:0x017f, B:42:0x00bb, B:44:0x00d5, B:45:0x00ed, B:46:0x0105, B:23:0x002b, B:27:0x003f, B:28:0x004e, B:29:0x005d, B:51:0x01a9), top: B:57:0x0003 }] */
    /* JADX WARN: Instruction removed from duplicated block: B:49:0x014f, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:50:0x017f, please report this as an issue */
    private synchronized void initTransitionRules() {
        int i;
        DateTimeRule dateTimeRule;
        DateTimeRule dateTimeRule2;
        long time;
        int i2;
        int i3;
        int i4;
        DateTimeRule dateTimeRule3;
        long time2;
        DateTimeRule dateTimeRule4;
        DateTimeRule dateTimeRule5;
        try {
            if (this.transitionRulesInitialized) {
                return;
            }
            if (this.useDaylight) {
                int i5 = this.startTimeMode;
                if (i5 == 1) {
                    i = 1;
                } else {
                    i = i5 == 2 ? 2 : 0;
                }
                int i6 = this.startMode;
                if (i6 != 1) {
                    if (i6 == 2) {
                        dateTimeRule5 = new DateTimeRule(this.startMonth, this.startDay, this.startDayOfWeek, this.startTime, i);
                    } else if (i6 == 3) {
                        dateTimeRule5 = new DateTimeRule(this.startMonth, this.startDay, this.startDayOfWeek, true, this.startTime, i);
                    } else if (i6 != 4) {
                        dateTimeRule = null;
                    } else {
                        dateTimeRule5 = new DateTimeRule(this.startMonth, this.startDay, this.startDayOfWeek, false, this.startTime, i);
                    }
                    dateTimeRule2 = dateTimeRule5;
                    AnnualTimeZoneRule annualTimeZoneRule = new AnnualTimeZoneRule(getID() + "(DST)", getRawOffset(), getDSTSavings(), dateTimeRule2, this.startYear, Integer.MAX_VALUE);
                    this.dstRule = annualTimeZoneRule;
                    time = annualTimeZoneRule.getFirstStart(getRawOffset(), 0).getTime();
                    i2 = this.endTimeMode;
                    if (i2 == 1) {
                        i3 = 1;
                    } else if (i2 == 2) {
                        i3 = 2;
                    } else {
                        i3 = 0;
                    }
                    i4 = this.endMode;
                    if (i4 != 1) {
                        if (i4 != 2) {
                            dateTimeRule4 = new DateTimeRule(this.endMonth, this.endDay, this.endDayOfWeek, this.endTime, i3);
                        } else if (i4 != 3) {
                            dateTimeRule4 = new DateTimeRule(this.endMonth, this.endDay, this.endDayOfWeek, true, this.endTime, i3);
                        } else if (i4 != 4) {
                            dateTimeRule3 = dateTimeRule2;
                        } else {
                            dateTimeRule4 = new DateTimeRule(this.endMonth, this.endDay, this.endDayOfWeek, false, this.endTime, i3);
                        }
                        dateTimeRule3 = dateTimeRule4;
                    } else {
                        dateTimeRule3 = new DateTimeRule(this.endMonth, this.endDay, this.endTime, i3);
                    }
                    AnnualTimeZoneRule annualTimeZoneRule2 = new AnnualTimeZoneRule(getID() + "(STD)", getRawOffset(), 0, dateTimeRule3, this.startYear, Integer.MAX_VALUE);
                    this.stdRule = annualTimeZoneRule2;
                    time2 = annualTimeZoneRule2.getFirstStart(getRawOffset(), this.dstRule.getDSTSavings()).getTime();
                    if (time2 < time) {
                        InitialTimeZoneRule initialTimeZoneRule = new InitialTimeZoneRule(getID() + "(DST)", getRawOffset(), this.dstRule.getDSTSavings());
                        this.initialRule = initialTimeZoneRule;
                        this.firstTransition = new TimeZoneTransition(time2, initialTimeZoneRule, this.stdRule);
                    } else {
                        InitialTimeZoneRule initialTimeZoneRule2 = new InitialTimeZoneRule(getID() + "(STD)", getRawOffset(), 0);
                        this.initialRule = initialTimeZoneRule2;
                        this.firstTransition = new TimeZoneTransition(time, initialTimeZoneRule2, this.dstRule);
                    }
                } else {
                    dateTimeRule = new DateTimeRule(this.startMonth, this.startDay, this.startTime, i);
                }
                dateTimeRule2 = dateTimeRule;
                AnnualTimeZoneRule annualTimeZoneRule3 = new AnnualTimeZoneRule(getID() + "(DST)", getRawOffset(), getDSTSavings(), dateTimeRule2, this.startYear, Integer.MAX_VALUE);
                this.dstRule = annualTimeZoneRule3;
                time = annualTimeZoneRule3.getFirstStart(getRawOffset(), 0).getTime();
                i2 = this.endTimeMode;
                if (i2 == 1) {
                    i3 = 1;
                } else if (i2 == 2) {
                    i3 = 2;
                } else {
                    i3 = 0;
                }
                i4 = this.endMode;
                if (i4 != 1) {
                    if (i4 != 2) {
                        dateTimeRule4 = new DateTimeRule(this.endMonth, this.endDay, this.endDayOfWeek, this.endTime, i3);
                    } else if (i4 != 3) {
                        dateTimeRule4 = new DateTimeRule(this.endMonth, this.endDay, this.endDayOfWeek, true, this.endTime, i3);
                    } else if (i4 != 4) {
                        dateTimeRule3 = dateTimeRule2;
                    } else {
                        dateTimeRule4 = new DateTimeRule(this.endMonth, this.endDay, this.endDayOfWeek, false, this.endTime, i3);
                    }
                    dateTimeRule3 = dateTimeRule4;
                } else {
                    dateTimeRule3 = new DateTimeRule(this.endMonth, this.endDay, this.endTime, i3);
                }
                AnnualTimeZoneRule annualTimeZoneRule4 = new AnnualTimeZoneRule(getID() + "(STD)", getRawOffset(), 0, dateTimeRule3, this.startYear, Integer.MAX_VALUE);
                this.stdRule = annualTimeZoneRule4;
                time2 = annualTimeZoneRule4.getFirstStart(getRawOffset(), this.dstRule.getDSTSavings()).getTime();
                if (time2 < time) {
                    InitialTimeZoneRule initialTimeZoneRule3 = new InitialTimeZoneRule(getID() + "(DST)", getRawOffset(), this.dstRule.getDSTSavings());
                    this.initialRule = initialTimeZoneRule3;
                    this.firstTransition = new TimeZoneTransition(time2, initialTimeZoneRule3, this.stdRule);
                } else {
                    InitialTimeZoneRule initialTimeZoneRule4 = new InitialTimeZoneRule(getID() + "(STD)", getRawOffset(), 0);
                    this.initialRule = initialTimeZoneRule4;
                    this.firstTransition = new TimeZoneTransition(time, initialTimeZoneRule4, this.dstRule);
                }
            } else {
                this.initialRule = new InitialTimeZoneRule(getID(), getRawOffset(), 0);
            }
            this.transitionRulesInitialized = true;
        } catch (Throwable th) {
            throw th;
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        STZInfo sTZInfo = this.xinfo;
        if (sTZInfo != null) {
            sTZInfo.applyTo(this);
        }
    }

    @Override // com.ibm.icu.util.TimeZone
    /* JADX INFO: renamed from: clone */
    public SimpleTimeZone mo3clone() {
        return isFrozen() ? this : cloneAsThawed();
    }

    @Override // com.ibm.icu.util.TimeZone, com.ibm.icu.util.Freezable
    public SimpleTimeZone cloneAsThawed() {
        SimpleTimeZone simpleTimeZone = (SimpleTimeZone) super.cloneAsThawed();
        simpleTimeZone.isFrozen = false;
        return simpleTimeZone;
    }

    @Override // com.ibm.icu.util.TimeZone
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            SimpleTimeZone simpleTimeZone = (SimpleTimeZone) obj;
            if (this.raw == simpleTimeZone.raw && this.useDaylight == simpleTimeZone.useDaylight && idEquals(getID(), simpleTimeZone.getID()) && (!this.useDaylight || (this.dst == simpleTimeZone.dst && this.startMode == simpleTimeZone.startMode && this.startMonth == simpleTimeZone.startMonth && this.startDay == simpleTimeZone.startDay && this.startDayOfWeek == simpleTimeZone.startDayOfWeek && this.startTime == simpleTimeZone.startTime && this.startTimeMode == simpleTimeZone.startTimeMode && this.endMode == simpleTimeZone.endMode && this.endMonth == simpleTimeZone.endMonth && this.endDay == simpleTimeZone.endDay && this.endDayOfWeek == simpleTimeZone.endDayOfWeek && this.endTime == simpleTimeZone.endTime && this.endTimeMode == simpleTimeZone.endTimeMode && this.startYear == simpleTimeZone.startYear))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.ibm.icu.util.TimeZone
    public int getDSTSavings() {
        return this.dst;
    }

    @Override // com.ibm.icu.util.BasicTimeZone
    public TimeZoneTransition getNextTransition(long j, boolean z) {
        if (!this.useDaylight) {
            return null;
        }
        initTransitionRules();
        long time = this.firstTransition.getTime();
        if (j < time || (z && j == time)) {
            return this.firstTransition;
        }
        Date nextStart = this.stdRule.getNextStart(j, this.dstRule.getRawOffset(), this.dstRule.getDSTSavings(), z);
        Date nextStart2 = this.dstRule.getNextStart(j, this.stdRule.getRawOffset(), this.stdRule.getDSTSavings(), z);
        if (nextStart != null && (nextStart2 == null || nextStart.before(nextStart2))) {
            return new TimeZoneTransition(nextStart.getTime(), this.dstRule, this.stdRule);
        }
        if (nextStart2 == null || !(nextStart == null || nextStart2.before(nextStart))) {
            return null;
        }
        return new TimeZoneTransition(nextStart2.getTime(), this.stdRule, this.dstRule);
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0053  */
    @Override // com.ibm.icu.util.BasicTimeZone
    public void getOffsetFromLocal(long j, BasicTimeZone.LocalOption localOption, BasicTimeZone.LocalOption localOption2, int[] iArr) {
        int dSTSavings;
        boolean z;
        long j2 = j;
        int localOptionValue = BasicTimeZone.getLocalOptionValue(localOption);
        int localOptionValue2 = BasicTimeZone.getLocalOptionValue(localOption2);
        iArr[0] = getRawOffset();
        int[] iArr2 = new int[6];
        Grego.timeToFields(j2, iArr2);
        int offset = getOffset(1, iArr2[0], iArr2[1], iArr2[2], iArr2[3], iArr2[5]) - iArr[0];
        iArr[1] = offset;
        if (offset > 0) {
            int i = localOptionValue & 3;
            if (i == 1 || !(i == 3 || (localOptionValue & 12) == 12)) {
                dSTSavings = getDSTSavings();
                j2 -= (long) dSTSavings;
                z = true;
            } else {
                z = false;
            }
        } else {
            int i2 = localOptionValue2 & 3;
            if (i2 == 3 || (i2 != 1 && (localOptionValue2 & 12) == 4)) {
                dSTSavings = getDSTSavings();
                j2 -= (long) dSTSavings;
                z = true;
            } else {
                z = false;
            }
        }
        if (z) {
            Grego.timeToFields(j2, iArr2);
            iArr[1] = getOffset(1, iArr2[0], iArr2[1], iArr2[2], iArr2[3], iArr2[5]) - iArr[0];
        }
    }

    @Override // com.ibm.icu.util.BasicTimeZone
    public TimeZoneTransition getPreviousTransition(long j, boolean z) {
        if (!this.useDaylight) {
            return null;
        }
        initTransitionRules();
        long time = this.firstTransition.getTime();
        if (j >= time && (z || j != time)) {
            Date previousStart = this.stdRule.getPreviousStart(j, this.dstRule.getRawOffset(), this.dstRule.getDSTSavings(), z);
            Date previousStart2 = this.dstRule.getPreviousStart(j, this.stdRule.getRawOffset(), this.stdRule.getDSTSavings(), z);
            if (previousStart != null && (previousStart2 == null || previousStart.after(previousStart2))) {
                return new TimeZoneTransition(previousStart.getTime(), this.dstRule, this.stdRule);
            }
            if (previousStart2 != null && (previousStart == null || previousStart2.after(previousStart))) {
                return new TimeZoneTransition(previousStart2.getTime(), this.stdRule, this.dstRule);
            }
        }
        return null;
    }

    @Override // com.ibm.icu.util.TimeZone
    public int getRawOffset() {
        return this.raw;
    }

    @Override // com.ibm.icu.util.BasicTimeZone
    public TimeZoneRule[] getTimeZoneRules() {
        initTransitionRules();
        boolean z = this.useDaylight;
        TimeZoneRule[] timeZoneRuleArr = new TimeZoneRule[z ? 3 : 1];
        timeZoneRuleArr[0] = this.initialRule;
        if (z) {
            timeZoneRuleArr[1] = this.stdRule;
            timeZoneRuleArr[2] = this.dstRule;
        }
        return timeZoneRuleArr;
    }

    @Override // com.ibm.icu.util.TimeZone
    public boolean hasSameRules(TimeZone timeZone) {
        boolean z;
        if (this == timeZone) {
            return true;
        }
        if (!(timeZone instanceof SimpleTimeZone)) {
            return false;
        }
        SimpleTimeZone simpleTimeZone = (SimpleTimeZone) timeZone;
        return this.raw == simpleTimeZone.raw && (z = this.useDaylight) == simpleTimeZone.useDaylight && (!z || (this.dst == simpleTimeZone.dst && this.startMode == simpleTimeZone.startMode && this.startMonth == simpleTimeZone.startMonth && this.startDay == simpleTimeZone.startDay && this.startDayOfWeek == simpleTimeZone.startDayOfWeek && this.startTime == simpleTimeZone.startTime && this.startTimeMode == simpleTimeZone.startTimeMode && this.endMode == simpleTimeZone.endMode && this.endMonth == simpleTimeZone.endMonth && this.endDay == simpleTimeZone.endDay && this.endDayOfWeek == simpleTimeZone.endDayOfWeek && this.endTime == simpleTimeZone.endTime && this.endTimeMode == simpleTimeZone.endTimeMode && this.startYear == simpleTimeZone.startYear));
    }

    @Override // com.ibm.icu.util.TimeZone
    public int hashCode() {
        int iHashCode = super.hashCode();
        int i = this.raw;
        boolean z = this.useDaylight;
        int i2 = (iHashCode + i) ^ ((i >>> 8) + (!z ? 1 : 0));
        if (z) {
            return i2;
        }
        int i3 = this.dst;
        int i4 = this.startMode;
        int i5 = i3 ^ ((i3 >>> 10) + i4);
        int i6 = i4 >>> 11;
        int i7 = this.startMonth;
        int i8 = i5 ^ (i6 + i7);
        int i9 = i7 >>> 12;
        int i10 = this.startDay;
        int i11 = i8 ^ (i9 + i10);
        int i12 = i10 >>> 13;
        int i13 = this.startDayOfWeek;
        int i14 = i11 ^ (i12 + i13);
        int i15 = i13 >>> 14;
        int i16 = this.startTime;
        int i17 = i14 ^ (i15 + i16);
        int i18 = i16 >>> 15;
        int i19 = this.startTimeMode;
        int i20 = i17 ^ (i18 + i19);
        int i21 = i19 >>> 16;
        int i22 = this.endMode;
        int i23 = i20 ^ (i21 + i22);
        int i24 = i22 >>> 17;
        int i25 = this.endMonth;
        int i26 = i23 ^ (i24 + i25);
        int i27 = i25 >>> 18;
        int i28 = this.endDay;
        int i29 = i26 ^ (i27 + i28);
        int i30 = i28 >>> 19;
        int i31 = this.endDayOfWeek;
        int i32 = i29 ^ (i30 + i31);
        int i33 = i31 >>> 20;
        int i34 = this.endTime;
        int i35 = i32 ^ (i33 + i34);
        int i36 = i34 >>> 21;
        int i37 = this.endTimeMode;
        int i38 = this.startYear;
        return i2 + ((i38 >>> 23) ^ ((i35 ^ (i36 + i37)) ^ ((i37 >>> 22) + i38)));
    }

    @Override // com.ibm.icu.util.TimeZone
    public boolean inDaylightTime(Date date) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar(this);
        gregorianCalendar.setTime(date);
        return gregorianCalendar.inDaylightTime();
    }

    @Override // com.ibm.icu.util.TimeZone, com.ibm.icu.util.Freezable
    public boolean isFrozen() {
        return this.isFrozen;
    }

    @Override // com.ibm.icu.util.TimeZone
    public boolean observesDaylightTime() {
        return this.useDaylight;
    }

    public void setDSTSavings(int i) {
        if (isFrozen()) {
            dk0.r("Attempt to modify a frozen SimpleTimeZone instance.");
        } else if (i == 0) {
            dk0.v();
        } else {
            this.dst = i;
            this.transitionRulesInitialized = false;
        }
    }

    public void setEndRule(int i, int i2, int i3, int i4) {
        if (isFrozen()) {
            dk0.r("Attempt to modify a frozen SimpleTimeZone instance.");
        } else {
            getSTZInfo().setEnd(i, i2, i3, i4, -1, false);
            setEndRule(i, i2, i3, i4, 0);
        }
    }

    @Override // com.ibm.icu.util.TimeZone
    public void setID(String str) {
        if (isFrozen()) {
            dk0.r("Attempt to modify a frozen SimpleTimeZone instance.");
        } else {
            super.setID(str);
            this.transitionRulesInitialized = false;
        }
    }

    @Override // com.ibm.icu.util.TimeZone
    public void setRawOffset(int i) {
        if (isFrozen()) {
            dk0.r("Attempt to modify a frozen SimpleTimeZone instance.");
        } else {
            this.raw = i;
            this.transitionRulesInitialized = false;
        }
    }

    public void setStartRule(int i, int i2, int i3, int i4) {
        if (isFrozen()) {
            dk0.r("Attempt to modify a frozen SimpleTimeZone instance.");
        } else {
            getSTZInfo().setStart(i, i2, i3, i4, -1, false);
            setStartRule(i, i2, i3, i4, 0);
        }
    }

    public void setStartYear(int i) {
        if (isFrozen()) {
            dk0.r("Attempt to modify a frozen SimpleTimeZone instance.");
            return;
        }
        getSTZInfo().sy = i;
        this.startYear = i;
        this.transitionRulesInitialized = false;
    }

    public String toString() {
        return cq.j("SimpleTimeZone: ", getID());
    }

    @Override // com.ibm.icu.util.TimeZone
    public boolean useDaylightTime() {
        return this.useDaylight;
    }

    @Override // com.ibm.icu.util.TimeZone, com.ibm.icu.util.Freezable
    public TimeZone freeze() {
        this.isFrozen = true;
        return this;
    }

    private void setStartRule(int i, int i2, int i3, int i4, int i5) {
        this.startMonth = i;
        this.startDay = i2;
        this.startDayOfWeek = i3;
        this.startTime = i4;
        this.startTimeMode = i5;
        decodeStartRule();
        this.transitionRulesInitialized = false;
    }

    public void setEndRule(int i, int i2, int i3) {
        if (!isFrozen()) {
            getSTZInfo().setEnd(i, -1, -1, i3, i2, false);
            setEndRule(i, i2, 0, i3);
        } else {
            dk0.r("Attempt to modify a frozen SimpleTimeZone instance.");
        }
    }

    public SimpleTimeZone(int i, String str, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        super(str);
        this.dst = 3600000;
        this.xinfo = null;
        this.isFrozen = false;
        construct(i, i2, i3, i4, i5, 0, i6, i7, i8, i9, 0, 3600000);
    }

    public void setEndRule(int i, int i2, int i3, int i4, boolean z) {
        if (!isFrozen()) {
            getSTZInfo().setEnd(i, -1, i3, i4, i2, z);
            setEndRule(i, i2, i3, i4, 0, z);
        } else {
            dk0.r("Attempt to modify a frozen SimpleTimeZone instance.");
        }
    }

    public SimpleTimeZone(int i, String str) {
        super(str);
        this.dst = 3600000;
        this.xinfo = null;
        this.isFrozen = false;
        construct(i, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3600000);
    }

    public void setStartRule(int i, int i2, int i3) {
        if (!isFrozen()) {
            getSTZInfo().setStart(i, -1, -1, i3, i2, false);
            setStartRule(i, i2, 0, i3, 0);
        } else {
            dk0.r("Attempt to modify a frozen SimpleTimeZone instance.");
        }
    }

    private void setEndRule(int i, int i2, int i3, int i4, int i5, boolean z) {
        if (!z) {
            i2 = -i2;
        }
        setEndRule(i, i2, -i3, i4, i5);
    }

    private void setEndRule(int i, int i2, int i3, int i4, int i5) {
        this.endMonth = i;
        this.endDay = i2;
        this.endDayOfWeek = i3;
        this.endTime = i4;
        this.endTimeMode = i5;
        decodeEndRule();
        this.transitionRulesInitialized = false;
    }

    public SimpleTimeZone(int i, String str, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        super(str);
        this.dst = 3600000;
        this.xinfo = null;
        this.isFrozen = false;
        construct(i, i2, i3, i4, i5, 0, i6, i7, i8, i9, 0, i10);
    }

    public void setStartRule(int i, int i2, int i3, int i4, boolean z) {
        if (!isFrozen()) {
            getSTZInfo().setStart(i, -1, i3, i4, i2, z);
            setStartRule(i, z ? i2 : -i2, -i3, i4, 0);
        } else {
            dk0.r("Attempt to modify a frozen SimpleTimeZone instance.");
        }
    }

    @Deprecated
    public int getOffset(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        if (i3 >= 0 && i3 <= 11) {
            return getOffset(i, i2, i3, i4, i5, i6, Grego.monthLength(i2, i3), Grego.previousMonthLength(i2, i3));
        }
        dk0.v();
        return 0;
    }

    @Override // com.ibm.icu.util.TimeZone
    public int getOffset(int i, int i2, int i3, int i4, int i5, int i6) {
        if (i3 >= 0 && i3 <= 11) {
            return getOffset(i, i2, i3, i4, i5, i6, Grego.monthLength(i2, i3));
        }
        dk0.v();
        return 0;
    }
}
