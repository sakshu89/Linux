package com.ibm.icu.impl.number;

import com.ibm.icu.number.Scale;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class MultiplierFormatHandler implements MicroPropsGenerator {
    final Scale multiplier;
    final MicroPropsGenerator parent;

    public MultiplierFormatHandler(Scale scale, MicroPropsGenerator microPropsGenerator) {
        this.multiplier = scale;
        this.parent = microPropsGenerator;
    }

    @Override // com.ibm.icu.impl.number.MicroPropsGenerator
    public MicroProps processQuantity(DecimalQuantity decimalQuantity) {
        MicroProps microPropsProcessQuantity = this.parent.processQuantity(decimalQuantity);
        this.multiplier.applyTo(decimalQuantity);
        return microPropsProcessQuantity;
    }
}
