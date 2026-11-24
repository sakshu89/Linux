package com.ibm.icu.text;

import defpackage.cq;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class BidiRun {
    int insertRemove;
    byte level;
    int limit;
    int start;

    public BidiRun(int i, int i2, byte b) {
        this.start = i;
        this.limit = i2;
        this.level = b;
    }

    public void copyFrom(BidiRun bidiRun) {
        this.start = bidiRun.start;
        this.limit = bidiRun.limit;
        this.level = bidiRun.level;
        this.insertRemove = bidiRun.insertRemove;
    }

    public byte getDirection() {
        return (byte) (this.level & 1);
    }

    public byte getEmbeddingLevel() {
        return this.level;
    }

    public int getLength() {
        return this.limit - this.start;
    }

    public int getLimit() {
        return this.limit;
    }

    public int getStart() {
        return this.start;
    }

    public boolean isEvenRun() {
        return (this.level & 1) == 0;
    }

    public boolean isOddRun() {
        return (this.level & 1) == 1;
    }

    public String toString() {
        int i = this.start;
        int i2 = this.limit;
        byte b = this.level;
        StringBuilder sbP = cq.p("BidiRun ", i, " - ", i2, " @ ");
        sbP.append((int) b);
        return sbP.toString();
    }

    public BidiRun() {
        this(0, 0, (byte) 0);
    }
}
