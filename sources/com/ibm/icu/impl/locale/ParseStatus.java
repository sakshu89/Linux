package com.ibm.icu.impl.locale;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class ParseStatus {
    int _parseLength = 0;
    int _errorIndex = -1;
    String _errorMsg = null;

    public int getErrorIndex() {
        return this._errorIndex;
    }

    public String getErrorMessage() {
        return this._errorMsg;
    }

    public int getParseLength() {
        return this._parseLength;
    }

    public boolean isError() {
        return this._errorIndex >= 0;
    }

    public void reset() {
        this._parseLength = 0;
        this._errorIndex = -1;
        this._errorMsg = null;
    }
}
