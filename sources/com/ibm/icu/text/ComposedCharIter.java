package com.ibm.icu.text;

import com.ibm.icu.impl.Norm2AllModes;
import com.ibm.icu.impl.Normalizer2Impl;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public final class ComposedCharIter {

    @Deprecated
    public static final char DONE = 65535;
    private int curChar;
    private String decompBuf;
    private final Normalizer2Impl n2impl;
    private int nextChar;

    @Deprecated
    public ComposedCharIter(boolean z, int i) {
        this.curChar = 0;
        this.nextChar = -1;
        if (z) {
            this.n2impl = Norm2AllModes.getNFKCInstance().impl;
        } else {
            this.n2impl = Norm2AllModes.getNFCInstance().impl;
        }
    }

    private void findNextChar() {
        int i = this.curChar + 1;
        this.decompBuf = null;
        while (i < 65535) {
            String decomposition = this.n2impl.getDecomposition(i);
            this.decompBuf = decomposition;
            if (decomposition != null) {
                this.nextChar = i;
            }
            i++;
        }
        i = -1;
        this.nextChar = i;
    }

    @Deprecated
    public String decomposition() {
        String str = this.decompBuf;
        return str != null ? str : "";
    }

    @Deprecated
    public boolean hasNext() {
        if (this.nextChar == -1) {
            findNextChar();
        }
        return this.nextChar != -1;
    }

    @Deprecated
    public char next() {
        if (this.nextChar == -1) {
            findNextChar();
        }
        int i = this.nextChar;
        this.curChar = i;
        this.nextChar = -1;
        return (char) i;
    }

    @Deprecated
    public ComposedCharIter() {
        this(false, 0);
    }
}
