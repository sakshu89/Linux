package com.ibm.icu.impl.duration.impl;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
interface RecordReader {
    boolean bool(String str);

    boolean[] boolArray(String str);

    char character(String str);

    char[] characterArray(String str);

    boolean close();

    byte namedIndex(String str, String[] strArr);

    byte[] namedIndexArray(String str, String[] strArr);

    boolean open(String str);

    String string(String str);

    String[] stringArray(String str);

    String[][] stringTable(String str);
}
