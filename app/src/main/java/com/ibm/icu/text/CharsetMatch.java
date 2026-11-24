package com.ibm.icu.text;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class CharsetMatch implements Comparable<CharsetMatch> {
    private String fCharsetName;
    private int fConfidence;
    private InputStream fInputStream;
    private String fLang;
    private byte[] fRawInput;
    private int fRawLength;

    public CharsetMatch(CharsetDetector charsetDetector, CharsetRecognizer charsetRecognizer, int i) {
        this.fRawInput = null;
        this.fInputStream = null;
        this.fConfidence = i;
        InputStream inputStream = charsetDetector.fInputStream;
        if (inputStream == null) {
            this.fRawInput = charsetDetector.fRawInput;
            this.fRawLength = charsetDetector.fRawLength;
        }
        this.fInputStream = inputStream;
        this.fCharsetName = charsetRecognizer.getName();
        this.fLang = charsetRecognizer.getLanguage();
    }

    @Override // java.lang.Comparable
    public int compareTo(CharsetMatch charsetMatch) {
        int i = this.fConfidence;
        int i2 = charsetMatch.fConfidence;
        if (i > i2) {
            return 1;
        }
        return i < i2 ? -1 : 0;
    }

    public int getConfidence() {
        return this.fConfidence;
    }

    public String getLanguage() {
        return this.fLang;
    }

    public String getName() {
        return this.fCharsetName;
    }

    public Reader getReader() {
        InputStream byteArrayInputStream = this.fInputStream;
        if (byteArrayInputStream == null) {
            byteArrayInputStream = new ByteArrayInputStream(this.fRawInput, 0, this.fRawLength);
        }
        try {
            byteArrayInputStream.reset();
            return new InputStreamReader(byteArrayInputStream, getName());
        } catch (IOException unused) {
            return null;
        }
    }

    public String getString(int i) throws IOException {
        if (this.fInputStream == null) {
            String name = getName();
            int iIndexOf = name.indexOf(name.indexOf("_rtl") < 0 ? "_ltr" : "_rtl");
            if (iIndexOf > 0) {
                name = name.substring(0, iIndexOf);
            }
            return new String(this.fRawInput, name);
        }
        StringBuilder sb = new StringBuilder();
        char[] cArr = new char[1024];
        Reader reader = getReader();
        if (i < 0) {
            i = Integer.MAX_VALUE;
        }
        while (true) {
            int i2 = reader.read(cArr, 0, Math.min(i, 1024));
            if (i2 < 0) {
                reader.close();
                return sb.toString();
            }
            sb.append(cArr, 0, i2);
            i -= i2;
        }
    }

    public CharsetMatch(CharsetDetector charsetDetector, CharsetRecognizer charsetRecognizer, int i, String str, String str2) {
        this.fRawInput = null;
        this.fInputStream = null;
        this.fConfidence = i;
        InputStream inputStream = charsetDetector.fInputStream;
        if (inputStream == null) {
            this.fRawInput = charsetDetector.fRawInput;
            this.fRawLength = charsetDetector.fRawLength;
        }
        this.fInputStream = inputStream;
        this.fCharsetName = str;
        this.fLang = str2;
    }

    public String getString() {
        return getString(-1);
    }
}
