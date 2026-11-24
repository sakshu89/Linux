package com.ibm.icu.impl.duration.impl;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
interface RecordWriter {
    void bool(String str, boolean z);

    void boolArray(String str, boolean[] zArr);

    void character(String str, char c);

    void characterArray(String str, char[] cArr);

    boolean close();

    void namedIndex(String str, String[] strArr, int i);

    void namedIndexArray(String str, String[] strArr, byte[] bArr);

    boolean open(String str);

    void string(String str, String str2);

    void stringArray(String str, String[] strArr);

    void stringTable(String str, String[][] strArr);
}
