package com.ibm.icu.impl.duration;

import com.ibm.icu.impl.duration.impl.PeriodFormatterData;
import defpackage.og;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
class BasicPeriodFormatter implements PeriodFormatter {
    private BasicPeriodFormatterFactory.Customizations customs;
    private PeriodFormatterData data;
    private BasicPeriodFormatterFactory factory;
    private String localeName;

    public BasicPeriodFormatter(BasicPeriodFormatterFactory basicPeriodFormatterFactory, String str, PeriodFormatterData periodFormatterData, BasicPeriodFormatterFactory.Customizations customizations) {
        this.factory = basicPeriodFormatterFactory;
        this.localeName = str;
        this.data = periodFormatterData;
        this.customs = customizations;
    }

    /* JADX WARN: Code duplicated, block: B:39:0x007c  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private String format(int i, boolean z, int[] iArr) {
        int i2;
        boolean z2;
        boolean z3;
        int i3;
        int i4;
        boolean z4;
        boolean zAppendUnitSeparator;
        int i5 = 0;
        int i6 = 0;
        while (true) {
            i2 = 1;
            if (i5 >= iArr.length) {
                break;
            }
            if (iArr[i5] > 0) {
                i6 |= 1 << i5;
            }
            i5++;
        }
        if (!this.data.allowZero()) {
            int i7 = 1;
            int i8 = 0;
            while (i8 < iArr.length) {
                if ((i6 & i7) != 0 && iArr[i8] == 1) {
                    i6 &= ~i7;
                }
                i8++;
                i7 <<= 1;
            }
            if (i6 == 0) {
                return null;
            }
        }
        if (this.data.useMilliseconds() != 0) {
            byte b = TimeUnit.MILLISECOND.ordinal;
            if (((1 << b) & i6) != 0) {
                byte b2 = TimeUnit.SECOND.ordinal;
                int i9 = 1 << b2;
                int i10 = 1 << b;
                int iUseMilliseconds = this.data.useMilliseconds();
                if (iUseMilliseconds == 1) {
                    if ((i6 & i9) == 0) {
                        i6 |= i9;
                        iArr[b2] = 1;
                    }
                    iArr[b2] = ((iArr[b] - 1) / 1000) + iArr[b2];
                } else if (iUseMilliseconds == 2 && (i9 & i6) != 0) {
                    iArr[b2] = ((iArr[b] - 1) / 1000) + iArr[b2];
                } else {
                    z2 = false;
                }
                i6 &= ~i10;
                z2 = true;
            } else {
                z2 = false;
            }
        } else {
            z2 = false;
        }
        int length = iArr.length - 1;
        int i11 = 0;
        while (i11 < iArr.length && ((1 << i11) & i6) == 0) {
            i11++;
        }
        while (length > i11 && ((1 << length) & i6) == 0) {
            length--;
        }
        int i12 = i11;
        while (true) {
            if (i12 > length) {
                z3 = true;
                break;
            }
            if (((1 << i12) & i6) != 0 && iArr[i12] > 1) {
                z3 = false;
                break;
            }
            i12++;
        }
        StringBuffer stringBuffer = new StringBuffer();
        BasicPeriodFormatterFactory.Customizations customizations = this.customs;
        int i13 = (!customizations.displayLimit || z3) ? 0 : i;
        if (!customizations.displayDirection || z3) {
            i3 = 0;
        } else {
            i3 = z ? 2 : 1;
        }
        boolean zAppendPrefix = this.data.appendPrefix(i13, i3, stringBuffer);
        boolean z5 = i11 != length;
        boolean z6 = this.customs.separatorVariant != 0;
        boolean z7 = true;
        boolean z8 = zAppendPrefix;
        int i14 = 0;
        int i15 = i11;
        while (i15 <= length) {
            if (i14 != 0) {
                this.data.appendSkippedUnit(stringBuffer);
                z4 = i2;
                i4 = 0;
            } else {
                i4 = i14;
                z4 = z7;
            }
            while (true) {
                i15 += i2;
                if (i15 >= length || ((i2 << i15) & i6) != 0) {
                    break;
                }
                i4 = i2;
            }
            TimeUnit timeUnit = TimeUnit.units[i15];
            int i16 = iArr[i15] - 1;
            BasicPeriodFormatterFactory.Customizations customizations2 = this.customs;
            int i17 = customizations2.countVariant;
            if (i15 != length) {
                i17 = 0;
            } else if (z2) {
                i17 = 5;
            }
            StringBuffer stringBuffer2 = stringBuffer;
            boolean z9 = z6;
            int i18 = i15;
            int i19 = i17;
            int i20 = i13;
            int i21 = i4 | (this.data.appendUnit(timeUnit, i16, i19, customizations2.unitVariant, z9, z8, z5, i15 == length, z4, stringBuffer2) ? 1 : 0);
            byte b3 = this.customs.separatorVariant;
            if (b3 == 0 || i15 > length) {
                stringBuffer = stringBuffer2;
                zAppendUnitSeparator = false;
            } else {
                stringBuffer = stringBuffer2;
                zAppendUnitSeparator = this.data.appendUnitSeparator(timeUnit, b3 == 2, i18 == i11, i15 == length, stringBuffer);
            }
            i13 = i20;
            z6 = z9;
            i14 = i21;
            i2 = 1;
            z7 = false;
            z8 = zAppendUnitSeparator;
            i15 = i15;
        }
        this.data.appendSuffix(i13, i3, stringBuffer);
        return stringBuffer.toString();
    }

    @Override // com.ibm.icu.impl.duration.PeriodFormatter
    public PeriodFormatter withLocale(String str) {
        if (this.localeName.equals(str)) {
            return this;
        }
        return new BasicPeriodFormatter(this.factory, str, this.factory.getData(str), this.customs);
    }

    @Override // com.ibm.icu.impl.duration.PeriodFormatter
    public String format(Period period) {
        if (period.isSet()) {
            return format(period.timeLimit, period.inFuture, period.counts);
        }
        og.i("period is not set");
        return null;
    }
}
