package com.ibm.icu.util;

import com.ibm.icu.impl.CalendarAstronomer;
import com.ibm.icu.impl.Grego;
import defpackage.dk0;
import defpackage.og;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class RuleBasedTimeZone extends BasicTimeZone implements Cloneable {
    private static final long serialVersionUID = 7580833058949327935L;
    private AnnualTimeZoneRule[] finalRules;
    private List<TimeZoneRule> historicRules;
    private transient List<TimeZoneTransition> historicTransitions;
    private final InitialTimeZoneRule initialRule;
    private volatile transient boolean isFrozen;
    private transient boolean upToDate;

    public RuleBasedTimeZone(String str, InitialTimeZoneRule initialTimeZoneRule) {
        super(str);
        this.isFrozen = false;
        this.initialRule = initialTimeZoneRule;
    }

    /* JADX WARN: Code duplicated, block: B:50:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:53:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:60:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:64:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:66:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:81:0x00de A[EDGE_INSN: B:81:0x00de->B:63:0x00de BREAK  A[LOOP:0: B:18:0x0032->B:67:0x00eb], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:83:0x00eb A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:93:0x00d9 A[SYNTHETIC] */
    private void complete() {
        char c;
        long j;
        int i;
        AnnualTimeZoneRule annualTimeZoneRule;
        Date nextStart;
        long time;
        if (this.upToDate) {
            return;
        }
        AnnualTimeZoneRule[] annualTimeZoneRuleArr = this.finalRules;
        if (annualTimeZoneRuleArr != null && annualTimeZoneRuleArr[1] == null) {
            og.n("Incomplete final rules");
            return;
        }
        List<TimeZoneRule> list = this.historicRules;
        if (list != null || annualTimeZoneRuleArr != null) {
            TimeZoneRule timeZoneRule = this.initialRule;
            if (list != null) {
                BitSet bitSet = new BitSet(this.historicRules.size());
                long j2 = -184303902528000000L;
                loop0: while (true) {
                    int rawOffset = timeZoneRule.getRawOffset();
                    int dSTSavings = timeZoneRule.getDSTSavings();
                    long j3 = 183882168921600000L;
                    TimeZoneRule timeZoneRule2 = null;
                    for (int i2 = 0; i2 < this.historicRules.size(); i2++) {
                        if (!bitSet.get(i2)) {
                            TimeZoneRule timeZoneRule3 = this.historicRules.get(i2);
                            Date nextStart2 = timeZoneRule3.getNextStart(j2, rawOffset, dSTSavings, false);
                            if (nextStart2 == null) {
                                bitSet.set(i2);
                            } else if (timeZoneRule3 != timeZoneRule) {
                                if (!timeZoneRule3.getName().equals(timeZoneRule.getName()) || timeZoneRule3.getRawOffset() != timeZoneRule.getRawOffset() || timeZoneRule3.getDSTSavings() != timeZoneRule.getDSTSavings()) {
                                    long time2 = nextStart2.getTime();
                                    if (time2 < j3) {
                                        timeZoneRule2 = timeZoneRule3;
                                        j3 = time2;
                                    }
                                }
                            }
                        }
                    }
                    c = 0;
                    if (timeZoneRule2 == null) {
                        int i3 = 0;
                        while (true) {
                            if (i3 >= this.historicRules.size()) {
                                break loop0;
                            } else if (!bitSet.get(i3)) {
                                break;
                            } else {
                                i3++;
                            }
                        }
                        if (this.finalRules != null) {
                            for (i = 0; i < 2; i++) {
                                annualTimeZoneRule = this.finalRules[i];
                                if (annualTimeZoneRule != timeZoneRule && (nextStart = annualTimeZoneRule.getNextStart(j2, rawOffset, dSTSavings, false)) != null) {
                                    time = nextStart.getTime();
                                    if (time < j3) {
                                        timeZoneRule2 = this.finalRules[i];
                                        j3 = time;
                                    }
                                }
                            }
                        }
                        if (timeZoneRule2 == null) {
                            break;
                        }
                        if (this.historicTransitions == null) {
                            this.historicTransitions = new ArrayList();
                        }
                        this.historicTransitions.add(new TimeZoneTransition(j3, timeZoneRule, timeZoneRule2));
                        timeZoneRule = timeZoneRule2;
                        j2 = j3;
                    } else {
                        if (this.finalRules != null) {
                            while (i < 2) {
                                annualTimeZoneRule = this.finalRules[i];
                                if (annualTimeZoneRule != timeZoneRule) {
                                    time = nextStart.getTime();
                                    if (time < j3) {
                                        timeZoneRule2 = this.finalRules[i];
                                        j3 = time;
                                    }
                                }
                            }
                        }
                        if (timeZoneRule2 == null) {
                            break;
                            break;
                        }
                        if (this.historicTransitions == null) {
                            this.historicTransitions = new ArrayList();
                        }
                        this.historicTransitions.add(new TimeZoneTransition(j3, timeZoneRule, timeZoneRule2));
                        timeZoneRule = timeZoneRule2;
                        j2 = j3;
                    }
                }
                j = j2;
            } else {
                c = 0;
                j = -184303902528000000L;
            }
            if (this.finalRules != null) {
                if (this.historicTransitions == null) {
                    this.historicTransitions = new ArrayList();
                }
                Date nextStart3 = this.finalRules[c].getNextStart(j, timeZoneRule.getRawOffset(), timeZoneRule.getDSTSavings(), false);
                Date nextStart4 = this.finalRules[1].getNextStart(j, timeZoneRule.getRawOffset(), timeZoneRule.getDSTSavings(), false);
                boolean zAfter = nextStart4.after(nextStart3);
                List<TimeZoneTransition> list2 = this.historicTransitions;
                if (zAfter) {
                    list2.add(new TimeZoneTransition(nextStart3.getTime(), timeZoneRule, this.finalRules[c]));
                    Date nextStart5 = this.finalRules[1].getNextStart(nextStart3.getTime(), this.finalRules[c].getRawOffset(), this.finalRules[c].getDSTSavings(), false);
                    List<TimeZoneTransition> list3 = this.historicTransitions;
                    long time3 = nextStart5.getTime();
                    AnnualTimeZoneRule[] annualTimeZoneRuleArr2 = this.finalRules;
                    list3.add(new TimeZoneTransition(time3, annualTimeZoneRuleArr2[c], annualTimeZoneRuleArr2[1]));
                } else {
                    list2.add(new TimeZoneTransition(nextStart4.getTime(), timeZoneRule, this.finalRules[1]));
                    Date nextStart6 = this.finalRules[c].getNextStart(nextStart4.getTime(), this.finalRules[1].getRawOffset(), this.finalRules[1].getDSTSavings(), false);
                    List<TimeZoneTransition> list4 = this.historicTransitions;
                    long time4 = nextStart6.getTime();
                    AnnualTimeZoneRule[] annualTimeZoneRuleArr3 = this.finalRules;
                    list4.add(new TimeZoneTransition(time4, annualTimeZoneRuleArr3[1], annualTimeZoneRuleArr3[c]));
                }
            }
        }
        this.upToDate = true;
    }

    private TimeZoneRule findRuleInFinal(long j, boolean z, int i, int i2) {
        AnnualTimeZoneRule annualTimeZoneRule;
        AnnualTimeZoneRule[] annualTimeZoneRuleArr = this.finalRules;
        if (annualTimeZoneRuleArr != null && annualTimeZoneRuleArr.length == 2 && annualTimeZoneRuleArr[0] != null && (annualTimeZoneRule = annualTimeZoneRuleArr[1]) != null) {
            long localDelta = z ? j - ((long) getLocalDelta(annualTimeZoneRule.getRawOffset(), this.finalRules[1].getDSTSavings(), this.finalRules[0].getRawOffset(), this.finalRules[0].getDSTSavings(), i, i2)) : j;
            AnnualTimeZoneRule[] annualTimeZoneRuleArr2 = this.finalRules;
            Date previousStart = annualTimeZoneRuleArr2[0].getPreviousStart(localDelta, annualTimeZoneRuleArr2[1].getRawOffset(), this.finalRules[1].getDSTSavings(), true);
            if (z) {
                j -= (long) getLocalDelta(this.finalRules[0].getRawOffset(), this.finalRules[0].getDSTSavings(), this.finalRules[1].getRawOffset(), this.finalRules[1].getDSTSavings(), i, i2);
            }
            long j2 = j;
            AnnualTimeZoneRule[] annualTimeZoneRuleArr3 = this.finalRules;
            Date previousStart2 = annualTimeZoneRuleArr3[1].getPreviousStart(j2, annualTimeZoneRuleArr3[0].getRawOffset(), this.finalRules[0].getDSTSavings(), true);
            if (previousStart != null && previousStart2 != null) {
                boolean zAfter = previousStart.after(previousStart2);
                AnnualTimeZoneRule[] annualTimeZoneRuleArr4 = this.finalRules;
                return zAfter ? annualTimeZoneRuleArr4[0] : annualTimeZoneRuleArr4[1];
            }
            if (previousStart != null) {
                return this.finalRules[0];
            }
            if (previousStart2 != null) {
                return this.finalRules[1];
            }
        }
        return null;
    }

    private static int getLocalDelta(int i, int i2, int i3, int i4, int i5, int i6) {
        int i7;
        int i8;
        int i9 = i + i2;
        int i10 = i3 + i4;
        boolean z = false;
        boolean z2 = i2 != 0 && i4 == 0;
        if (i2 == 0 && i4 != 0) {
            z = true;
        }
        return (i10 - i9 < 0 ? !((i7 = i6 & 3) == 1 && z2) && (!(i7 == 3 && z) && ((i7 == 1 && z) || ((i7 == 3 && z2) || (i6 & 12) == 4))) : ((i8 = i5 & 3) == 1 && z2) || ((i8 == 3 && z) || (!(i8 == 1 && z) && (!(i8 == 3 && z2) && (i5 & 12) == 12)))) ? i9 : i10;
    }

    private void getOffset(long j, boolean z, int i, int i2, int[] iArr) {
        TimeZoneRule to;
        complete();
        List<TimeZoneTransition> list = this.historicTransitions;
        if (list != null && j >= getTransitionTime(list.get(0), z, i, i2)) {
            int size = this.historicTransitions.size() - 1;
            if (j > getTransitionTime(this.historicTransitions.get(size), z, i, i2)) {
                TimeZoneRule timeZoneRuleFindRuleInFinal = this.finalRules != null ? findRuleInFinal(j, z, i, i2) : null;
                to = timeZoneRuleFindRuleInFinal == null ? this.historicTransitions.get(size).getTo() : timeZoneRuleFindRuleInFinal;
            } else {
                while (size >= 0 && j < getTransitionTime(this.historicTransitions.get(size), z, i, i2)) {
                    size--;
                }
                to = this.historicTransitions.get(size).getTo();
            }
        } else {
            to = this.initialRule;
        }
        iArr[0] = to.getRawOffset();
        iArr[1] = to.getDSTSavings();
    }

    private static long getTransitionTime(TimeZoneTransition timeZoneTransition, boolean z, int i, int i2) {
        long time = timeZoneTransition.getTime();
        return z ? time + ((long) getLocalDelta(timeZoneTransition.getFrom().getRawOffset(), timeZoneTransition.getFrom().getDSTSavings(), timeZoneTransition.getTo().getRawOffset(), timeZoneTransition.getTo().getDSTSavings(), i, i2)) : time;
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0037  */
    /* JADX WARN: Code duplicated, block: B:20:0x003b  */
    public void addTransitionRule(TimeZoneRule timeZoneRule) {
        if (isFrozen()) {
            dk0.r("Attempt to modify a frozen RuleBasedTimeZone instance.");
            return;
        }
        if (!timeZoneRule.isTransitionRule()) {
            og.i("Rule must be a transition rule");
            return;
        }
        if (timeZoneRule instanceof AnnualTimeZoneRule) {
            AnnualTimeZoneRule annualTimeZoneRule = (AnnualTimeZoneRule) timeZoneRule;
            if (annualTimeZoneRule.getEndYear() == Integer.MAX_VALUE) {
                AnnualTimeZoneRule[] annualTimeZoneRuleArr = this.finalRules;
                if (annualTimeZoneRuleArr == null) {
                    AnnualTimeZoneRule[] annualTimeZoneRuleArr2 = new AnnualTimeZoneRule[2];
                    this.finalRules = annualTimeZoneRuleArr2;
                    annualTimeZoneRuleArr2[0] = annualTimeZoneRule;
                } else {
                    if (annualTimeZoneRuleArr[1] != null) {
                        og.n("Too many final rules");
                        return;
                    }
                    annualTimeZoneRuleArr[1] = annualTimeZoneRule;
                }
            } else {
                if (this.historicRules == null) {
                    this.historicRules = new ArrayList();
                }
                this.historicRules.add(timeZoneRule);
            }
        } else {
            if (this.historicRules == null) {
                this.historicRules = new ArrayList();
            }
            this.historicRules.add(timeZoneRule);
        }
        this.upToDate = false;
    }

    @Override // com.ibm.icu.util.TimeZone
    /* JADX INFO: renamed from: clone */
    public RuleBasedTimeZone mo3clone() {
        return isFrozen() ? this : cloneAsThawed();
    }

    @Override // com.ibm.icu.util.TimeZone, com.ibm.icu.util.Freezable
    public RuleBasedTimeZone cloneAsThawed() {
        RuleBasedTimeZone ruleBasedTimeZone = (RuleBasedTimeZone) super.cloneAsThawed();
        if (this.historicRules != null) {
            ruleBasedTimeZone.historicRules = new ArrayList(this.historicRules);
        }
        AnnualTimeZoneRule[] annualTimeZoneRuleArr = this.finalRules;
        if (annualTimeZoneRuleArr != null) {
            ruleBasedTimeZone.finalRules = (AnnualTimeZoneRule[]) annualTimeZoneRuleArr.clone();
        }
        ruleBasedTimeZone.isFrozen = false;
        return ruleBasedTimeZone;
    }

    @Override // com.ibm.icu.util.TimeZone, com.ibm.icu.util.Freezable
    public TimeZone freeze() {
        complete();
        this.isFrozen = true;
        return this;
    }

    @Override // com.ibm.icu.util.BasicTimeZone
    public TimeZoneTransition getNextTransition(long j, boolean z) {
        boolean z2;
        complete();
        List<TimeZoneTransition> list = this.historicTransitions;
        if (list == null) {
            return null;
        }
        TimeZoneTransition timeZoneTransition = list.get(0);
        long time = timeZoneTransition.getTime();
        if (time > j || (z && time == j)) {
            z2 = false;
        } else {
            int size = this.historicTransitions.size();
            TimeZoneTransition timeZoneTransition2 = this.historicTransitions.get(size - 1);
            long time2 = timeZoneTransition2.getTime();
            if (z && time2 == j) {
                z2 = false;
                timeZoneTransition = timeZoneTransition2;
            } else if (time2 <= j) {
                AnnualTimeZoneRule[] annualTimeZoneRuleArr = this.finalRules;
                if (annualTimeZoneRuleArr == null) {
                    return null;
                }
                z2 = true;
                Date nextStart = annualTimeZoneRuleArr[0].getNextStart(j, annualTimeZoneRuleArr[1].getRawOffset(), this.finalRules[1].getDSTSavings(), z);
                AnnualTimeZoneRule[] annualTimeZoneRuleArr2 = this.finalRules;
                Date nextStart2 = annualTimeZoneRuleArr2[1].getNextStart(j, annualTimeZoneRuleArr2[0].getRawOffset(), this.finalRules[0].getDSTSavings(), z);
                if (nextStart2.after(nextStart)) {
                    long time3 = nextStart.getTime();
                    AnnualTimeZoneRule[] annualTimeZoneRuleArr3 = this.finalRules;
                    timeZoneTransition = new TimeZoneTransition(time3, annualTimeZoneRuleArr3[1], annualTimeZoneRuleArr3[0]);
                } else {
                    long time4 = nextStart2.getTime();
                    AnnualTimeZoneRule[] annualTimeZoneRuleArr4 = this.finalRules;
                    timeZoneTransition = new TimeZoneTransition(time4, annualTimeZoneRuleArr4[0], annualTimeZoneRuleArr4[1]);
                }
            } else {
                int i = size - 2;
                while (i > 0) {
                    TimeZoneTransition timeZoneTransition3 = this.historicTransitions.get(i);
                    long time5 = timeZoneTransition3.getTime();
                    if (time5 < j || (!z && time5 == j)) {
                        break;
                    }
                    i--;
                    timeZoneTransition2 = timeZoneTransition3;
                }
                z2 = false;
                timeZoneTransition = timeZoneTransition2;
            }
        }
        TimeZoneRule from = timeZoneTransition.getFrom();
        TimeZoneRule to = timeZoneTransition.getTo();
        if (from.getRawOffset() != to.getRawOffset() || from.getDSTSavings() != to.getDSTSavings()) {
            return timeZoneTransition;
        }
        if (z2) {
            return null;
        }
        return getNextTransition(timeZoneTransition.getTime(), false);
    }

    @Override // com.ibm.icu.util.BasicTimeZone
    public void getOffsetFromLocal(long j, BasicTimeZone.LocalOption localOption, BasicTimeZone.LocalOption localOption2, int[] iArr) {
        getOffset(j, true, BasicTimeZone.getLocalOptionValue(localOption), BasicTimeZone.getLocalOptionValue(localOption2), iArr);
    }

    @Override // com.ibm.icu.util.BasicTimeZone
    public TimeZoneTransition getPreviousTransition(long j, boolean z) {
        complete();
        List<TimeZoneTransition> list = this.historicTransitions;
        if (list == null) {
            return null;
        }
        TimeZoneTransition timeZoneTransition = list.get(0);
        long time = timeZoneTransition.getTime();
        if (!z || time != j) {
            if (time >= j) {
                return null;
            }
            int size = this.historicTransitions.size();
            TimeZoneTransition timeZoneTransition2 = this.historicTransitions.get(size - 1);
            long time2 = timeZoneTransition2.getTime();
            if (z && time2 == j) {
                timeZoneTransition = timeZoneTransition2;
            } else {
                if (time2 < j) {
                    AnnualTimeZoneRule[] annualTimeZoneRuleArr = this.finalRules;
                    if (annualTimeZoneRuleArr != null) {
                        Date previousStart = annualTimeZoneRuleArr[0].getPreviousStart(j, annualTimeZoneRuleArr[1].getRawOffset(), this.finalRules[1].getDSTSavings(), z);
                        AnnualTimeZoneRule[] annualTimeZoneRuleArr2 = this.finalRules;
                        Date previousStart2 = annualTimeZoneRuleArr2[1].getPreviousStart(j, annualTimeZoneRuleArr2[0].getRawOffset(), this.finalRules[0].getDSTSavings(), z);
                        if (previousStart2.before(previousStart)) {
                            long time3 = previousStart.getTime();
                            AnnualTimeZoneRule[] annualTimeZoneRuleArr3 = this.finalRules;
                            timeZoneTransition = new TimeZoneTransition(time3, annualTimeZoneRuleArr3[1], annualTimeZoneRuleArr3[0]);
                        } else {
                            long time4 = previousStart2.getTime();
                            AnnualTimeZoneRule[] annualTimeZoneRuleArr4 = this.finalRules;
                            timeZoneTransition = new TimeZoneTransition(time4, annualTimeZoneRuleArr4[0], annualTimeZoneRuleArr4[1]);
                        }
                    }
                } else {
                    for (int i = size - 2; i >= 0; i--) {
                        timeZoneTransition2 = this.historicTransitions.get(i);
                        long time5 = timeZoneTransition2.getTime();
                        if (time5 < j || (z && time5 == j)) {
                            break;
                        }
                    }
                }
                timeZoneTransition = timeZoneTransition2;
            }
        }
        TimeZoneRule from = timeZoneTransition.getFrom();
        TimeZoneRule to = timeZoneTransition.getTo();
        return (from.getRawOffset() == to.getRawOffset() && from.getDSTSavings() == to.getDSTSavings()) ? getPreviousTransition(timeZoneTransition.getTime(), false) : timeZoneTransition;
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
        List<TimeZoneRule> list = this.historicRules;
        int size = list != null ? list.size() + 1 : 1;
        AnnualTimeZoneRule[] annualTimeZoneRuleArr = this.finalRules;
        if (annualTimeZoneRuleArr != null) {
            size = annualTimeZoneRuleArr[1] != null ? size + 2 : size + 1;
        }
        TimeZoneRule[] timeZoneRuleArr = new TimeZoneRule[size];
        timeZoneRuleArr[0] = this.initialRule;
        if (this.historicRules != null) {
            i = 1;
            while (i < this.historicRules.size() + 1) {
                timeZoneRuleArr[i] = this.historicRules.get(i - 1);
                i++;
            }
        } else {
            i = 1;
        }
        AnnualTimeZoneRule[] annualTimeZoneRuleArr2 = this.finalRules;
        if (annualTimeZoneRuleArr2 != null) {
            int i2 = i + 1;
            timeZoneRuleArr[i] = annualTimeZoneRuleArr2[0];
            AnnualTimeZoneRule annualTimeZoneRule = annualTimeZoneRuleArr2[1];
            if (annualTimeZoneRule != null) {
                timeZoneRuleArr[i2] = annualTimeZoneRule;
            }
        }
        return timeZoneRuleArr;
    }

    @Override // com.ibm.icu.util.TimeZone
    public boolean hasSameRules(TimeZone timeZone) {
        AnnualTimeZoneRule annualTimeZoneRule;
        if (this == timeZone) {
            return true;
        }
        if (!(timeZone instanceof RuleBasedTimeZone)) {
            return false;
        }
        RuleBasedTimeZone ruleBasedTimeZone = (RuleBasedTimeZone) timeZone;
        if (!this.initialRule.isEquivalentTo(ruleBasedTimeZone.initialRule)) {
            return false;
        }
        AnnualTimeZoneRule[] annualTimeZoneRuleArr = this.finalRules;
        if (annualTimeZoneRuleArr == null || ruleBasedTimeZone.finalRules == null) {
            if (annualTimeZoneRuleArr == null && ruleBasedTimeZone.finalRules == null) {
            }
            return false;
        }
        int i = 0;
        while (true) {
            AnnualTimeZoneRule[] annualTimeZoneRuleArr2 = this.finalRules;
            if (i >= annualTimeZoneRuleArr2.length) {
                break;
            }
            AnnualTimeZoneRule annualTimeZoneRule2 = annualTimeZoneRuleArr2[i];
            if (!(annualTimeZoneRule2 == null && ruleBasedTimeZone.finalRules[i] == null) && (annualTimeZoneRule2 == null || (annualTimeZoneRule = ruleBasedTimeZone.finalRules[i]) == null || !annualTimeZoneRule2.isEquivalentTo(annualTimeZoneRule))) {
                return false;
            }
            i++;
        }
        List<TimeZoneRule> list = this.historicRules;
        if (list != null && ruleBasedTimeZone.historicRules != null) {
            if (list.size() != ruleBasedTimeZone.historicRules.size()) {
                return false;
            }
            for (TimeZoneRule timeZoneRule : this.historicRules) {
                Iterator<TimeZoneRule> it = ruleBasedTimeZone.historicRules.iterator();
                while (it.hasNext()) {
                    if (timeZoneRule.isEquivalentTo(it.next())) {
                    }
                }
                return false;
            }
        }
        if (list != null || ruleBasedTimeZone.historicRules != null) {
            return false;
        }
        return true;
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
        int[] iArr = new int[2];
        getOffset(jCurrentTimeMillis, false, iArr);
        if (iArr[1] != 0) {
            return true;
        }
        BitSet bitSet = this.finalRules == null ? null : new BitSet(this.finalRules.length);
        while (true) {
            TimeZoneTransition nextTransition = getNextTransition(jCurrentTimeMillis, false);
            if (nextTransition == null) {
                break;
            }
            TimeZoneRule to = nextTransition.getTo();
            if (to.getDSTSavings() != 0) {
                return true;
            }
            if (bitSet != null) {
                int i = 0;
                while (true) {
                    AnnualTimeZoneRule[] annualTimeZoneRuleArr = this.finalRules;
                    if (i >= annualTimeZoneRuleArr.length) {
                        break;
                    }
                    if (annualTimeZoneRuleArr[i].equals(to)) {
                        bitSet.set(i);
                    }
                    i++;
                }
                if (bitSet.cardinality() == this.finalRules.length) {
                    break;
                }
            }
            jCurrentTimeMillis = nextTransition.getTime();
        }
        return false;
    }

    @Override // com.ibm.icu.util.TimeZone
    public void setRawOffset(int i) {
        throw new UnsupportedOperationException("setRawOffset in RuleBasedTimeZone is not supported.");
    }

    @Override // com.ibm.icu.util.TimeZone
    public boolean useDaylightTime() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        int[] iArr = new int[2];
        getOffset(jCurrentTimeMillis, false, iArr);
        if (iArr[1] != 0) {
            return true;
        }
        TimeZoneTransition nextTransition = getNextTransition(jCurrentTimeMillis, false);
        return (nextTransition == null || nextTransition.getTo().getDSTSavings() == 0) ? false : true;
    }

    @Override // com.ibm.icu.util.TimeZone
    public void getOffset(long j, boolean z, int[] iArr) {
        getOffset(j, z, 4, 12, iArr);
    }

    @Override // com.ibm.icu.util.TimeZone
    public int getOffset(int i, int i2, int i3, int i4, int i5, int i6) {
        if (i == 0) {
            i2 = 1 - i2;
        }
        int[] iArr = new int[2];
        getOffset((Grego.fieldsToDay(i2, i3, i4) * CalendarAstronomer.DAY_MS) + ((long) i6), true, 3, 1, iArr);
        return iArr[0] + iArr[1];
    }
}
