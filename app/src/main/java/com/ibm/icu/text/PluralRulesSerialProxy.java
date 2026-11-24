package com.ibm.icu.text;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
class PluralRulesSerialProxy implements Serializable {
    private static final long serialVersionUID = 42;
    private final String data;

    public PluralRulesSerialProxy(String str) {
        this.data = str;
    }

    private Object readResolve() {
        return PluralRules.createRules(this.data);
    }
}
