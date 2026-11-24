package com.ibm.icu.impl.locale;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class LocaleSyntaxException extends Exception {
    private static final long serialVersionUID = 1;
    private int _index;

    public LocaleSyntaxException(String str, int i) {
        super(str);
        this._index = i;
    }

    public int getErrorIndex() {
        return this._index;
    }

    public LocaleSyntaxException(String str) {
        this(str, 0);
    }
}
