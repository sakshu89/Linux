package com.ibm.icu.impl.number.parse;

import com.ibm.icu.impl.number.DecimalQuantity_DualStorageBCD;
import com.ibm.icu.number.Scale;
import defpackage.cq;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class MultiplierParseHandler extends ValidationMatcher {
    private final Scale multiplier;

    public MultiplierParseHandler(Scale scale) {
        this.multiplier = scale;
    }

    @Override // com.ibm.icu.impl.number.parse.NumberParseMatcher
    public void postProcess(ParsedNumber parsedNumber) {
        DecimalQuantity_DualStorageBCD decimalQuantity_DualStorageBCD = parsedNumber.quantity;
        if (decimalQuantity_DualStorageBCD != null) {
            this.multiplier.applyReciprocalTo(decimalQuantity_DualStorageBCD);
        }
    }

    public String toString() {
        return cq.v("<MultiplierHandler ", String.valueOf(this.multiplier), ">");
    }
}
