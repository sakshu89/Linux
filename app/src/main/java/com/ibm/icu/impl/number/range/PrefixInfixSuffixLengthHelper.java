package com.ibm.icu.impl.number.range;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class PrefixInfixSuffixLengthHelper {
    public int lengthPrefix = 0;
    public int length1 = 0;
    public int lengthInfix = 0;
    public int length2 = 0;
    public int lengthSuffix = 0;

    public int index0() {
        return this.lengthPrefix;
    }

    public int index1() {
        return this.lengthPrefix + this.length1;
    }

    public int index2() {
        return this.lengthPrefix + this.length1 + this.lengthInfix;
    }

    public int index3() {
        return this.lengthPrefix + this.length1 + this.lengthInfix + this.length2;
    }

    public int index4() {
        return this.lengthPrefix + this.length1 + this.lengthInfix + this.length2 + this.lengthSuffix;
    }
}
