package com.ibm.icu.impl.locale;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class Extension {
    private char _key;
    protected String _value;

    public Extension(char c, String str) {
        this._key = c;
        this._value = str;
    }

    public String getID() {
        return this._key + LanguageTag.SEP + this._value;
    }

    public char getKey() {
        return this._key;
    }

    public String getValue() {
        return this._value;
    }

    public String toString() {
        return getID();
    }

    public Extension(char c) {
        this._key = c;
    }
}
