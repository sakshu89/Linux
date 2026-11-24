package com.ibm.icu.text;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public interface Replaceable {
    int char32At(int i);

    char charAt(int i);

    void copy(int i, int i2, int i3);

    void getChars(int i, int i2, char[] cArr, int i3);

    boolean hasMetaData();

    int length();

    void replace(int i, int i2, String str);

    void replace(int i, int i2, char[] cArr, int i3, int i4);
}
