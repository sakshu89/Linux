package com.ibm.icu.util;

import com.ibm.icu.impl.Grego;
import defpackage.og;
import java.util.BitSet;
import java.util.Date;
import java.util.LinkedList;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class BasicTimeZone extends TimeZone {

    @Deprecated
    protected static final int FORMER_LATTER_MASK = 12;

    @Deprecated
    protected static final int LOCAL_DST = 3;

    @Deprecated
    protected static final int LOCAL_FORMER = 4;

    @Deprecated
    protected static final int LOCAL_LATTER = 12;

    @Deprecated
    protected static final int LOCAL_STD = 1;
    private static final long MILLIS_PER_YEAR = 31536000000L;

    @Deprecated
    protected static final int STD_DST_MASK = 3;
    private static final long serialVersionUID = -3204278532246180932L;

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public enum LocalOption {
        FORMER(4),
        LATTER(12),
        STANDARD_FORMER(5),
        STANDARD_LATTER(13),
        DAYLIGHT_FORMER(7),
        DAYLIGHT_LATTER(15);

        private int flagVal;

        LocalOption(int i) {
            this.flagVal = i;
        }
    }

    public BasicTimeZone() {
    }

    @Deprecated
    public static int getLocalOptionValue(LocalOption localOption) {
        return localOption.flagVal;
    }

    public abstract TimeZoneTransition getNextTransition(long j, boolean z);

    public void getOffsetFromLocal(long j, LocalOption localOption, LocalOption localOption2, int[] iArr) {
        throw new IllegalStateException("Not implemented");
    }

    public abstract TimeZoneTransition getPreviousTransition(long j, boolean z);

    /* JADX WARN: Code duplicated, block: B:66:0x02b8  */
    /* JADX WARN: Code duplicated, block: B:68:0x02bd  */
    public TimeZoneRule[] getSimpleTimeZoneRulesNear(long j) {
        int i;
        char c;
        InitialTimeZoneRule initialTimeZoneRule;
        int i2;
        int dSTSavings;
        long j2;
        char c2;
        AnnualTimeZoneRule[] annualTimeZoneRuleArr;
        int i3;
        TimeZoneTransition previousTransition;
        TimeZoneTransition nextTransition;
        long j3 = j;
        TimeZoneTransition nextTransition2 = getNextTransition(j3, false);
        AnnualTimeZoneRule[] annualTimeZoneRuleArr2 = null;
        if (nextTransition2 == null) {
            i = 3;
            TimeZoneTransition previousTransition2 = getPreviousTransition(j3, true);
            if (previousTransition2 != null) {
                initialTimeZoneRule = new InitialTimeZoneRule(previousTransition2.getTo().getName(), previousTransition2.getTo().getRawOffset(), previousTransition2.getTo().getDSTSavings());
            } else {
                int[] iArr = new int[2];
                c = 0;
                getOffset(j3, false, iArr);
                initialTimeZoneRule = new InitialTimeZoneRule(getID(), iArr[0], iArr[1]);
            }
            if (annualTimeZoneRuleArr2 == null) {
                TimeZoneRule[] timeZoneRuleArr = new TimeZoneRule[1];
                timeZoneRuleArr[c] = initialTimeZoneRule;
                return timeZoneRuleArr;
            }
            TimeZoneRule[] timeZoneRuleArr2 = new TimeZoneRule[i];
            timeZoneRuleArr2[c] = initialTimeZoneRule;
            timeZoneRuleArr2[1] = annualTimeZoneRuleArr2[c];
            timeZoneRuleArr2[2] = annualTimeZoneRuleArr2[1];
            return timeZoneRuleArr2;
        }
        String name = nextTransition2.getFrom().getName();
        int rawOffset = nextTransition2.getFrom().getRawOffset();
        int dSTSavings2 = nextTransition2.getFrom().getDSTSavings();
        long time = nextTransition2.getTime();
        if (((nextTransition2.getFrom().getDSTSavings() != 0 || nextTransition2.getTo().getDSTSavings() == 0) && (nextTransition2.getFrom().getDSTSavings() == 0 || nextTransition2.getTo().getDSTSavings() != 0)) || j3 + MILLIS_PER_YEAR <= time) {
            i2 = dSTSavings2;
            i = 3;
        } else {
            AnnualTimeZoneRule[] annualTimeZoneRuleArr3 = new AnnualTimeZoneRule[2];
            i = 3;
            int[] iArrTimeToFields = Grego.timeToFields(((long) nextTransition2.getFrom().getRawOffset()) + time + ((long) nextTransition2.getFrom().getDSTSavings()), null);
            annualTimeZoneRuleArr3[0] = new AnnualTimeZoneRule(nextTransition2.getTo().getName(), rawOffset, nextTransition2.getTo().getDSTSavings(), new DateTimeRule(iArrTimeToFields[1], Grego.getDayOfWeekInMonth(iArrTimeToFields[0], iArrTimeToFields[1], iArrTimeToFields[2]), iArrTimeToFields[3], iArrTimeToFields[5], 0), iArrTimeToFields[0], Integer.MAX_VALUE);
            if (nextTransition2.getTo().getRawOffset() != rawOffset || (nextTransition = getNextTransition(time, false)) == null || (((nextTransition.getFrom().getDSTSavings() != 0 || nextTransition.getTo().getDSTSavings() == 0) && (nextTransition.getFrom().getDSTSavings() == 0 || nextTransition.getTo().getDSTSavings() != 0)) || time + MILLIS_PER_YEAR <= nextTransition.getTime())) {
                j2 = time;
                c2 = 5;
                annualTimeZoneRuleArr = annualTimeZoneRuleArr3;
                i3 = dSTSavings2;
            } else {
                c2 = 5;
                annualTimeZoneRuleArr = annualTimeZoneRuleArr3;
                iArrTimeToFields = Grego.timeToFields(nextTransition.getTime() + ((long) nextTransition.getFrom().getRawOffset()) + ((long) nextTransition.getFrom().getDSTSavings()), iArrTimeToFields);
                AnnualTimeZoneRule annualTimeZoneRule = new AnnualTimeZoneRule(nextTransition.getTo().getName(), nextTransition.getTo().getRawOffset(), nextTransition.getTo().getDSTSavings(), new DateTimeRule(iArrTimeToFields[1], Grego.getDayOfWeekInMonth(iArrTimeToFields[0], iArrTimeToFields[1], iArrTimeToFields[2]), iArrTimeToFields[3], iArrTimeToFields[5], 0), iArrTimeToFields[0] - 1, Integer.MAX_VALUE);
                j2 = time;
                i3 = dSTSavings2;
                Date previousStart = annualTimeZoneRule.getPreviousStart(j3, nextTransition.getFrom().getRawOffset(), nextTransition.getFrom().getDSTSavings(), true);
                j3 = j3;
                if (previousStart != null && previousStart.getTime() <= j3 && rawOffset == nextTransition.getTo().getRawOffset() && i3 == nextTransition.getTo().getDSTSavings()) {
                    annualTimeZoneRuleArr[1] = annualTimeZoneRule;
                }
            }
            if (annualTimeZoneRuleArr[1] != null || (previousTransition = getPreviousTransition(j3, true)) == null || ((previousTransition.getFrom().getDSTSavings() != 0 || previousTransition.getTo().getDSTSavings() == 0) && (previousTransition.getFrom().getDSTSavings() == 0 || previousTransition.getTo().getDSTSavings() != 0))) {
                i2 = i3;
            } else {
                int[] iArrTimeToFields2 = Grego.timeToFields(previousTransition.getTime() + ((long) previousTransition.getFrom().getRawOffset()) + ((long) previousTransition.getFrom().getDSTSavings()), iArrTimeToFields);
                i2 = i3;
                AnnualTimeZoneRule annualTimeZoneRule2 = new AnnualTimeZoneRule(previousTransition.getTo().getName(), rawOffset, i2, new DateTimeRule(iArrTimeToFields2[1], Grego.getDayOfWeekInMonth(iArrTimeToFields2[0], iArrTimeToFields2[1], iArrTimeToFields2[2]), iArrTimeToFields2[3], iArrTimeToFields2[c2], 0), annualTimeZoneRuleArr[0].getStartYear() - 1, Integer.MAX_VALUE);
                if (annualTimeZoneRule2.getNextStart(j3, previousTransition.getFrom().getRawOffset(), previousTransition.getFrom().getDSTSavings(), false).getTime() > j2) {
                    annualTimeZoneRuleArr[1] = annualTimeZoneRule2;
                }
            }
            if (annualTimeZoneRuleArr[1] != null) {
                name = annualTimeZoneRuleArr[0].getName();
                rawOffset = annualTimeZoneRuleArr[0].getRawOffset();
                dSTSavings = annualTimeZoneRuleArr[0].getDSTSavings();
                annualTimeZoneRuleArr2 = annualTimeZoneRuleArr;
            }
            initialTimeZoneRule = new InitialTimeZoneRule(name, rawOffset, dSTSavings);
        }
        dSTSavings = i2;
        initialTimeZoneRule = new InitialTimeZoneRule(name, rawOffset, dSTSavings);
        c = 0;
        if (annualTimeZoneRuleArr2 == null) {
            TimeZoneRule[] timeZoneRuleArr3 = new TimeZoneRule[1];
            timeZoneRuleArr3[c] = initialTimeZoneRule;
            return timeZoneRuleArr3;
        }
        TimeZoneRule[] timeZoneRuleArr4 = new TimeZoneRule[i];
        timeZoneRuleArr4[c] = initialTimeZoneRule;
        timeZoneRuleArr4[1] = annualTimeZoneRuleArr2[c];
        timeZoneRuleArr4[2] = annualTimeZoneRuleArr2[1];
        return timeZoneRuleArr4;
    }

    public abstract TimeZoneRule[] getTimeZoneRules();

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v1 */
    /* JADX WARN: Type inference failed for: r15v2, types: [int] */
    /* JADX WARN: Type inference failed for: r15v4 */
    public TimeZoneRule[] getTimeZoneRules(long j) {
        boolean z;
        BitSet bitSet;
        TimeZoneTransition nextTransition;
        long j2 = j;
        TimeZoneRule[] timeZoneRules = getTimeZoneRules();
        int i = 1;
        TimeZoneTransition previousTransition = getPreviousTransition(j2, true);
        if (previousTransition == null) {
            return timeZoneRules;
        }
        BitSet bitSet2 = new BitSet(timeZoneRules.length);
        LinkedList linkedList = new LinkedList();
        InitialTimeZoneRule initialTimeZoneRule = new InitialTimeZoneRule(previousTransition.getTo().getName(), previousTransition.getTo().getRawOffset(), previousTransition.getTo().getDSTSavings());
        linkedList.add(initialTimeZoneRule);
        boolean z2 = false;
        bitSet2.set(0);
        int i2 = 1;
        while (i2 < timeZoneRules.length) {
            if (timeZoneRules[i2].getNextStart(j2, initialTimeZoneRule.getRawOffset(), initialTimeZoneRule.getDSTSavings(), false) == null) {
                bitSet2.set(i2);
            }
            i2++;
            j2 = j;
        }
        long j3 = j;
        boolean z3 = false;
        boolean z4 = false;
        while (true) {
            if (z3 && z4) {
                break;
            }
            TimeZoneTransition nextTransition2 = getNextTransition(j3, z2);
            if (nextTransition2 == null) {
                break;
            }
            long time = nextTransition2.getTime();
            TimeZoneRule to = nextTransition2.getTo();
            int i3 = i;
            while (i3 < timeZoneRules.length && !timeZoneRules[i3].equals(to)) {
                i3++;
            }
            if (i3 >= timeZoneRules.length) {
                og.n("The rule was not found");
                return null;
            }
            if (!bitSet2.get(i3)) {
                if (to instanceof TimeArrayTimeZoneRule) {
                    TimeArrayTimeZoneRule timeArrayTimeZoneRule = (TimeArrayTimeZoneRule) to;
                    long time2 = j;
                    while (true) {
                        nextTransition = getNextTransition(time2, z2);
                        if (nextTransition == null || nextTransition.getTo().equals(timeArrayTimeZoneRule)) {
                            break;
                        }
                        time2 = nextTransition.getTime();
                        bitSet2 = bitSet2;
                        i = 1;
                    }
                    if (nextTransition == null) {
                        bitSet2 = bitSet2;
                        z = z2;
                    } else if (timeArrayTimeZoneRule.getFirstStart(nextTransition.getFrom().getRawOffset(), nextTransition.getFrom().getDSTSavings()).getTime() > j) {
                        linkedList.add(timeArrayTimeZoneRule);
                        bitSet2 = bitSet2;
                        z = z2;
                    } else {
                        long[] startTimes = timeArrayTimeZoneRule.getStartTimes();
                        int timeType = timeArrayTimeZoneRule.getTimeType();
                        var r15 = z2;
                        while (true) {
                            if (r15 >= startTimes.length) {
                                bitSet2 = bitSet2;
                                break;
                            }
                            long dSTSavings = startTimes[r15];
                            if (timeType == i) {
                                dSTSavings -= (long) nextTransition.getFrom().getRawOffset();
                            }
                            if (timeType == 0) {
                                dSTSavings -= (long) nextTransition.getFrom().getDSTSavings();
                            }
                            if (dSTSavings > j) {
                                break;
                            }
                            bitSet2 = bitSet2;
                            i = 1;
                            r15++;
                        }
                        int length = startTimes.length - r15;
                        if (length > 0) {
                            long[] jArr = new long[length];
                            z = false;
                            System.arraycopy(startTimes, r15, jArr, 0, length);
                            linkedList.add(new TimeArrayTimeZoneRule(timeArrayTimeZoneRule.getName(), timeArrayTimeZoneRule.getRawOffset(), timeArrayTimeZoneRule.getDSTSavings(), jArr, timeArrayTimeZoneRule.getTimeType()));
                        } else {
                            z = false;
                        }
                    }
                } else {
                    bitSet2 = bitSet2;
                    z = z2;
                    if (to instanceof AnnualTimeZoneRule) {
                        AnnualTimeZoneRule annualTimeZoneRule = (AnnualTimeZoneRule) to;
                        if (annualTimeZoneRule.getFirstStart(nextTransition2.getFrom().getRawOffset(), nextTransition2.getFrom().getDSTSavings()).getTime() == nextTransition2.getTime()) {
                            linkedList.add(annualTimeZoneRule);
                        } else {
                            linkedList.add(new AnnualTimeZoneRule(annualTimeZoneRule.getName(), annualTimeZoneRule.getRawOffset(), annualTimeZoneRule.getDSTSavings(), annualTimeZoneRule.getRule(), Grego.timeToYear(nextTransition2.getTime()), annualTimeZoneRule.getEndYear()));
                        }
                        if (annualTimeZoneRule.getEndYear() == Integer.MAX_VALUE) {
                            if (annualTimeZoneRule.getDSTSavings() == 0) {
                                bitSet = bitSet2;
                                z3 = true;
                            } else {
                                bitSet = bitSet2;
                                z4 = true;
                            }
                        }
                    }
                    bitSet.set(i3);
                    z2 = z;
                    i = 1;
                    bitSet2 = bitSet;
                }
                bitSet = bitSet2;
                bitSet.set(i3);
                z2 = z;
                i = 1;
                bitSet2 = bitSet;
            }
            j3 = time;
        }
        return (TimeZoneRule[]) linkedList.toArray(new TimeZoneRule[linkedList.size()]);
    }

    public boolean hasEquivalentTransitions(TimeZone timeZone, long j, long j2, boolean z) {
        if (this == timeZone) {
            return true;
        }
        if (!(timeZone instanceof BasicTimeZone)) {
            return false;
        }
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        getOffset(j, false, iArr);
        timeZone.getOffset(j, false, iArr2);
        if (!z) {
            if (iArr[0] == iArr2[0] && iArr[1] == iArr2[1]) {
            }
            return false;
        }
        int i = iArr[0];
        int i2 = iArr[1];
        int i3 = i + i2;
        int i4 = iArr2[0];
        int i5 = iArr2[1];
        if (i3 != i4 + i5 || ((i2 != 0 && i5 == 0) || (i2 == 0 && i5 != 0))) {
            return false;
        }
        while (true) {
            TimeZoneTransition nextTransition = getNextTransition(j, false);
            BasicTimeZone basicTimeZone = (BasicTimeZone) timeZone;
            TimeZoneTransition nextTransition2 = basicTimeZone.getNextTransition(j, false);
            if (z) {
                while (nextTransition != null && nextTransition.getTime() <= j2) {
                    if (nextTransition.getFrom().getDSTSavings() + nextTransition.getFrom().getRawOffset() != nextTransition.getTo().getDSTSavings() + nextTransition.getTo().getRawOffset() || nextTransition.getFrom().getDSTSavings() == 0 || nextTransition.getTo().getDSTSavings() == 0) {
                        break;
                    }
                    nextTransition = getNextTransition(nextTransition.getTime(), false);
                }
                while (nextTransition2 != null && nextTransition2.getTime() <= j2) {
                    if (nextTransition2.getFrom().getDSTSavings() + nextTransition2.getFrom().getRawOffset() != nextTransition2.getTo().getDSTSavings() + nextTransition2.getTo().getRawOffset() || nextTransition2.getFrom().getDSTSavings() == 0 || nextTransition2.getTo().getDSTSavings() == 0) {
                        break;
                    }
                    nextTransition2 = basicTimeZone.getNextTransition(nextTransition2.getTime(), false);
                }
            }
            boolean z2 = nextTransition != null && nextTransition.getTime() <= j2;
            boolean z3 = nextTransition2 != null && nextTransition2.getTime() <= j2;
            if (!z2 && !z3) {
                return true;
            }
            if (!z2 || !z3 || nextTransition.getTime() != nextTransition2.getTime()) {
                return false;
            }
            if (z) {
                if (nextTransition.getTo().getDSTSavings() + nextTransition.getTo().getRawOffset() != nextTransition2.getTo().getDSTSavings() + nextTransition2.getTo().getRawOffset() || ((nextTransition.getTo().getDSTSavings() != 0 && nextTransition2.getTo().getDSTSavings() == 0) || (nextTransition.getTo().getDSTSavings() == 0 && nextTransition2.getTo().getDSTSavings() != 0))) {
                    return false;
                }
            } else if (nextTransition.getTo().getRawOffset() != nextTransition2.getTo().getRawOffset() || nextTransition.getTo().getDSTSavings() != nextTransition2.getTo().getDSTSavings()) {
                return false;
            }
            j = nextTransition.getTime();
        }
    }

    @Deprecated
    public BasicTimeZone(String str) {
        super(str);
    }

    public boolean hasEquivalentTransitions(TimeZone timeZone, long j, long j2) {
        return hasEquivalentTransitions(timeZone, j, j2, false);
    }
}
