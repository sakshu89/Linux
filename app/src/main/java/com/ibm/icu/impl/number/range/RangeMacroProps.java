package com.ibm.icu.impl.number.range;

import com.ibm.icu.number.NumberRangeFormatter;
import com.ibm.icu.number.UnlocalizedNumberFormatter;
import com.ibm.icu.util.ULocale;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class RangeMacroProps {
    public NumberRangeFormatter.RangeCollapse collapse;
    public UnlocalizedNumberFormatter formatter1;
    public UnlocalizedNumberFormatter formatter2;
    public NumberRangeFormatter.RangeIdentityFallback identityFallback;
    public ULocale loc;
    public int sameFormatters = -1;

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RangeMacroProps)) {
            return false;
        }
        RangeMacroProps rangeMacroProps = (RangeMacroProps) obj;
        return Objects.equals(this.formatter1, rangeMacroProps.formatter1) && Objects.equals(this.formatter2, rangeMacroProps.formatter2) && Objects.equals(this.collapse, rangeMacroProps.collapse) && Objects.equals(this.identityFallback, rangeMacroProps.identityFallback) && Objects.equals(this.loc, rangeMacroProps.loc);
    }

    public int hashCode() {
        return Objects.hash(this.formatter1, this.formatter2, this.collapse, this.identityFallback, this.loc);
    }
}
