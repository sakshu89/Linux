package com.ibm.icu.text;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
abstract class CharsetRecognizer {
    public String getLanguage() {
        return null;
    }

    public abstract String getName();

    public abstract CharsetMatch match(CharsetDetector charsetDetector);
}
