package com.ibm.icu.impl.units;

import com.ibm.icu.util.MeasureUnit;
import defpackage.og;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class SingleUnitImpl {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private int index = -1;
    private String simpleUnitID = "";
    private int dimensionality = 1;
    private MeasureUnit.MeasurePrefix unitPrefix = MeasureUnit.MeasurePrefix.ONE;

    public MeasureUnit build() {
        return new MeasureUnitImpl(this).build();
    }

    public int compareTo(SingleUnitImpl singleUnitImpl) {
        int categoryIndexOfSimpleUnit;
        int categoryIndexOfSimpleUnit2;
        int i = this.dimensionality;
        if (i < 0 && singleUnitImpl.dimensionality > 0) {
            return 1;
        }
        if ((i > 0 && singleUnitImpl.dimensionality < 0) || (categoryIndexOfSimpleUnit = UnitsData.getCategoryIndexOfSimpleUnit(this.index)) < (categoryIndexOfSimpleUnit2 = UnitsData.getCategoryIndexOfSimpleUnit(singleUnitImpl.index))) {
            return -1;
        }
        if (categoryIndexOfSimpleUnit > categoryIndexOfSimpleUnit2) {
            return 1;
        }
        int i2 = this.index;
        int i3 = singleUnitImpl.index;
        if (i2 < i3) {
            return -1;
        }
        if (i2 > i3) {
            return 1;
        }
        int base = this.unitPrefix.getBase();
        int base2 = singleUnitImpl.unitPrefix.getBase();
        MeasureUnit.MeasurePrefix measurePrefix = this.unitPrefix;
        int power = base == 1024 ? measurePrefix.getPower() * 3 : measurePrefix.getPower();
        MeasureUnit.MeasurePrefix measurePrefix2 = singleUnitImpl.unitPrefix;
        int power2 = base2 == 1024 ? measurePrefix2.getPower() * 3 : measurePrefix2.getPower();
        if (power < power2) {
            return 1;
        }
        if (power > power2) {
            return -1;
        }
        if (base < base2) {
            return 1;
        }
        return base > base2 ? -1 : 0;
    }

    public SingleUnitImpl copy() {
        SingleUnitImpl singleUnitImpl = new SingleUnitImpl();
        singleUnitImpl.index = this.index;
        singleUnitImpl.dimensionality = this.dimensionality;
        singleUnitImpl.simpleUnitID = this.simpleUnitID;
        singleUnitImpl.unitPrefix = this.unitPrefix;
        return singleUnitImpl;
    }

    public int getDimensionality() {
        return this.dimensionality;
    }

    public int getIndex() {
        return this.index;
    }

    public String getNeutralIdentifier() {
        StringBuilder sb = new StringBuilder();
        int iAbs = Math.abs(getDimensionality());
        if (iAbs != 1) {
            if (iAbs == 2) {
                sb.append("square-");
            } else if (iAbs == 3) {
                sb.append("cubic-");
            } else {
                if (iAbs > 15) {
                    og.i("Unit Identifier Syntax Error");
                    return null;
                }
                sb.append("pow");
                sb.append(iAbs);
                sb.append('-');
            }
        }
        sb.append(getPrefix().getIdentifier());
        sb.append(getSimpleUnitID());
        return sb.toString();
    }

    public MeasureUnit.MeasurePrefix getPrefix() {
        return this.unitPrefix;
    }

    public String getSimpleUnitID() {
        return this.simpleUnitID;
    }

    public boolean isCompatibleWith(SingleUnitImpl singleUnitImpl) {
        return compareTo(singleUnitImpl) == 0;
    }

    public void setDimensionality(int i) {
        this.dimensionality = i;
    }

    public void setPrefix(MeasureUnit.MeasurePrefix measurePrefix) {
        this.unitPrefix = measurePrefix;
    }

    public void setSimpleUnit(int i, String[] strArr) {
        this.index = i;
        this.simpleUnitID = strArr[i];
    }
}
