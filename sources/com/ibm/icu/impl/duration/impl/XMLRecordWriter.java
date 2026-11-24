package com.ibm.icu.impl.duration.impl;

import com.ibm.icu.lang.UCharacter;
import defpackage.cq;
import defpackage.ky0;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class XMLRecordWriter implements RecordWriter {
    private static final String INDENT = "    ";
    static final String NULL_NAME = "Null";
    private List<String> nameStack = new ArrayList();
    private Writer w;

    public XMLRecordWriter(Writer writer) {
        this.w = writer;
    }

    private static String ctos(char c) {
        if (c == '<') {
            return "&lt;";
        }
        return c == '&' ? "&amp;" : String.valueOf(c);
    }

    private void internalString(String str, String str2) {
        if (str2 != null) {
            newline();
            writeString(cq.n(cq.q("<", str, ">", str2, "</"), str, ">"));
        }
    }

    private void internalStringArray(String str, String[] strArr) {
        if (strArr != null) {
            push(ky0.j(str, "List"));
            for (String str2 : strArr) {
                if (str2 == null) {
                    str2 = NULL_NAME;
                }
                string(str, str2);
            }
            pop();
        }
    }

    private void newline() {
        writeString("\n");
        for (int i = 0; i < this.nameStack.size(); i++) {
            writeString(INDENT);
        }
    }

    public static String normalize(String str) {
        StringBuilder sb = null;
        if (str == null) {
            return null;
        }
        boolean z = false;
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            boolean z2 = true;
            if (UCharacter.isWhitespace(cCharAt)) {
                if (sb == null && (z || cCharAt != ' ')) {
                    sb = new StringBuilder(str.substring(0, i));
                }
                if (!z) {
                    cCharAt = ' ';
                    z = true;
                    z2 = false;
                }
            } else {
                if (cCharAt != '<' && cCharAt != '&') {
                    z2 = false;
                }
                if (z2 && sb == null) {
                    sb = new StringBuilder(str.substring(0, i));
                }
                z = false;
            }
            if (sb != null) {
                if (z2) {
                    sb.append(cCharAt == '<' ? "&lt;" : "&amp;");
                } else {
                    sb.append(cCharAt);
                }
            }
        }
        return sb != null ? sb.toString() : str;
    }

    private void pop() {
        String strRemove = this.nameStack.remove(this.nameStack.size() - 1);
        newline();
        writeString(cq.v("</", strRemove, ">"));
    }

    private void push(String str) {
        newline();
        writeString(cq.v("<", str, ">"));
        this.nameStack.add(str);
    }

    private void writeString(String str) {
        Writer writer = this.w;
        if (writer != null) {
            try {
                writer.write(str);
            } catch (IOException e) {
                System.err.println(e.getMessage());
                this.w = null;
            }
        }
    }

    @Override // com.ibm.icu.impl.duration.impl.RecordWriter
    public void bool(String str, boolean z) {
        internalString(str, String.valueOf(z));
    }

    @Override // com.ibm.icu.impl.duration.impl.RecordWriter
    public void boolArray(String str, boolean[] zArr) {
        if (zArr != null) {
            String[] strArr = new String[zArr.length];
            for (int i = 0; i < zArr.length; i++) {
                strArr[i] = String.valueOf(zArr[i]);
            }
            stringArray(str, strArr);
        }
    }

    @Override // com.ibm.icu.impl.duration.impl.RecordWriter
    public void character(String str, char c) {
        if (c != 65535) {
            internalString(str, ctos(c));
        }
    }

    @Override // com.ibm.icu.impl.duration.impl.RecordWriter
    public void characterArray(String str, char[] cArr) {
        if (cArr != null) {
            String[] strArr = new String[cArr.length];
            for (int i = 0; i < cArr.length; i++) {
                char c = cArr[i];
                if (c == 65535) {
                    strArr[i] = NULL_NAME;
                } else {
                    strArr[i] = ctos(c);
                }
            }
            internalStringArray(str, strArr);
        }
    }

    @Override // com.ibm.icu.impl.duration.impl.RecordWriter
    public boolean close() {
        int size = this.nameStack.size() - 1;
        if (size < 0) {
            return false;
        }
        String strRemove = this.nameStack.remove(size);
        newline();
        writeString(cq.v("</", strRemove, ">"));
        return true;
    }

    public void flush() {
        try {
            this.w.flush();
        } catch (IOException unused) {
        }
    }

    @Override // com.ibm.icu.impl.duration.impl.RecordWriter
    public void namedIndex(String str, String[] strArr, int i) {
        if (i >= 0) {
            internalString(str, strArr[i]);
        }
    }

    @Override // com.ibm.icu.impl.duration.impl.RecordWriter
    public void namedIndexArray(String str, String[] strArr, byte[] bArr) {
        if (bArr != null) {
            String[] strArr2 = new String[bArr.length];
            for (int i = 0; i < bArr.length; i++) {
                byte b = bArr[i];
                if (b < 0) {
                    strArr2[i] = NULL_NAME;
                } else {
                    strArr2[i] = strArr[b];
                }
            }
            internalStringArray(str, strArr2);
        }
    }

    @Override // com.ibm.icu.impl.duration.impl.RecordWriter
    public boolean open(String str) {
        newline();
        writeString(cq.v("<", str, ">"));
        this.nameStack.add(str);
        return true;
    }

    @Override // com.ibm.icu.impl.duration.impl.RecordWriter
    public void string(String str, String str2) {
        internalString(str, normalize(str2));
    }

    @Override // com.ibm.icu.impl.duration.impl.RecordWriter
    public void stringArray(String str, String[] strArr) {
        if (strArr != null) {
            push(ky0.j(str, "List"));
            for (String str2 : strArr) {
                String strNormalize = normalize(str2);
                if (strNormalize == null) {
                    strNormalize = NULL_NAME;
                }
                internalString(str, strNormalize);
            }
            pop();
        }
    }

    @Override // com.ibm.icu.impl.duration.impl.RecordWriter
    public void stringTable(String str, String[][] strArr) {
        if (strArr != null) {
            push(ky0.j(str, "Table"));
            for (String[] strArr2 : strArr) {
                if (strArr2 == null) {
                    internalString(ky0.j(str, "List"), NULL_NAME);
                } else {
                    stringArray(str, strArr2);
                }
            }
            pop();
        }
    }
}
