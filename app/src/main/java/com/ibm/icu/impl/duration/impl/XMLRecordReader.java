package com.ibm.icu.impl.duration.impl;

import com.ibm.icu.lang.UCharacter;
import defpackage.cq;
import defpackage.ky0;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class XMLRecordReader implements RecordReader {
    private boolean atTag;
    private List<String> nameStack = new ArrayList();
    private Reader r;
    private String tag;

    public XMLRecordReader(Reader reader) {
        this.r = reader;
        if (getTag().startsWith("?xml")) {
            advance();
        }
        if (getTag().startsWith("!--")) {
            advance();
        }
    }

    private void advance() {
        this.tag = null;
    }

    private String getTag() {
        if (this.tag == null) {
            this.tag = readNextTag();
        }
        return this.tag;
    }

    private boolean match(String str) {
        if (!getTag().equals(str)) {
            return false;
        }
        advance();
        return true;
    }

    private String readData() {
        int i;
        int i2;
        StringBuilder sb = new StringBuilder();
        boolean z = false;
        while (true) {
            i = readChar();
            if (i == -1 || i == 60) {
                break;
            }
            if (i == 38) {
                int i3 = readChar();
                if (i3 == 35) {
                    StringBuilder sb2 = new StringBuilder();
                    int i4 = readChar();
                    if (i4 == 120) {
                        i4 = readChar();
                        i2 = 16;
                    } else {
                        i2 = 10;
                    }
                    while (i4 != 59 && i4 != -1) {
                        sb2.append((char) i4);
                        i4 = readChar();
                    }
                    try {
                        i = (char) Integer.parseInt(sb2.toString(), i2);
                    } catch (NumberFormatException e) {
                        System.err.println("numbuf: " + sb2.toString() + " radix: " + i2);
                        throw e;
                    }
                } else {
                    StringBuilder sb3 = new StringBuilder();
                    while (i3 != 59 && i3 != -1) {
                        sb3.append((char) i3);
                        i3 = readChar();
                    }
                    String string = sb3.toString();
                    if (string.equals("lt")) {
                        i = 60;
                    } else if (string.equals("gt")) {
                        i = 62;
                    } else if (string.equals("quot")) {
                        i = 34;
                    } else if (string.equals("apos")) {
                        i = 39;
                    } else if (string.equals("amp")) {
                        i = 38;
                    } else {
                        System.err.println("unrecognized character entity: '" + string + "'");
                    }
                }
            }
            if (!UCharacter.isWhitespace(i)) {
                z = false;
            } else if (!z) {
                i = 32;
                z = true;
            }
            sb.append((char) i);
        }
        this.atTag = i == 60;
        return sb.toString();
    }

    private String readNextTag() {
        while (!this.atTag) {
            int i = readChar();
            if (i == 60 || i == -1) {
                if (i != 60) {
                    break;
                }
                this.atTag = true;
                break;
            }
            if (!UCharacter.isWhitespace(i)) {
                ky0.y("Unexpected non-whitespace character ", Integer.toHexString(i), System.err);
                break;
            }
        }
        if (!this.atTag) {
            return null;
        }
        this.atTag = false;
        StringBuilder sb = new StringBuilder();
        while (true) {
            int i2 = readChar();
            if (i2 == 62 || i2 == -1) {
                break;
            }
            sb.append((char) i2);
        }
        return sb.toString();
    }

    @Override // com.ibm.icu.impl.duration.impl.RecordReader
    public boolean bool(String str) {
        String strString = string(str);
        if (strString != null) {
            return "true".equals(strString);
        }
        return false;
    }

    @Override // com.ibm.icu.impl.duration.impl.RecordReader
    public boolean[] boolArray(String str) {
        String[] strArrStringArray = stringArray(str);
        if (strArrStringArray == null) {
            return null;
        }
        boolean[] zArr = new boolean[strArrStringArray.length];
        for (int i = 0; i < strArrStringArray.length; i++) {
            zArr[i] = "true".equals(strArrStringArray[i]);
        }
        return zArr;
    }

    @Override // com.ibm.icu.impl.duration.impl.RecordReader
    public char character(String str) {
        String strString = string(str);
        if (strString != null) {
            return strString.charAt(0);
        }
        return (char) 65535;
    }

    @Override // com.ibm.icu.impl.duration.impl.RecordReader
    public char[] characterArray(String str) {
        String[] strArrStringArray = stringArray(str);
        if (strArrStringArray == null) {
            return null;
        }
        char[] cArr = new char[strArrStringArray.length];
        for (int i = 0; i < strArrStringArray.length; i++) {
            cArr[i] = strArrStringArray[i].charAt(0);
        }
        return cArr;
    }

    @Override // com.ibm.icu.impl.duration.impl.RecordReader
    public boolean close() {
        int size = this.nameStack.size() - 1;
        String str = this.nameStack.get(size);
        if (!getTag().equals("/" + str)) {
            return false;
        }
        this.nameStack.remove(size);
        advance();
        return true;
    }

    @Override // com.ibm.icu.impl.duration.impl.RecordReader
    public byte namedIndex(String str, String[] strArr) {
        String strString = string(str);
        if (strString == null) {
            return (byte) -1;
        }
        for (int i = 0; i < strArr.length; i++) {
            if (strString.equals(strArr[i])) {
                return (byte) i;
            }
        }
        return (byte) -1;
    }

    @Override // com.ibm.icu.impl.duration.impl.RecordReader
    public byte[] namedIndexArray(String str, String[] strArr) {
        String[] strArrStringArray = stringArray(str);
        if (strArrStringArray == null) {
            return null;
        }
        byte[] bArr = new byte[strArrStringArray.length];
        for (int i = 0; i < strArrStringArray.length; i++) {
            String str2 = strArrStringArray[i];
            int i2 = 0;
            while (true) {
                if (i2 >= strArr.length) {
                    bArr[i] = -1;
                    break;
                }
                if (strArr[i2].equals(str2)) {
                    bArr[i] = (byte) i2;
                    break;
                }
                i2++;
            }
        }
        return bArr;
    }

    @Override // com.ibm.icu.impl.duration.impl.RecordReader
    public boolean open(String str) {
        if (!getTag().equals(str)) {
            return false;
        }
        this.nameStack.add(str);
        advance();
        return true;
    }

    public int readChar() {
        try {
            return this.r.read();
        } catch (IOException unused) {
            return -1;
        }
    }

    @Override // com.ibm.icu.impl.duration.impl.RecordReader
    public String string(String str) {
        if (!match(str)) {
            return null;
        }
        String data = readData();
        if (match(cq.j("/", str))) {
            return data;
        }
        return null;
    }

    @Override // com.ibm.icu.impl.duration.impl.RecordReader
    public String[] stringArray(String str) {
        if (match(ky0.j(str, "List"))) {
            ArrayList arrayList = new ArrayList();
            while (true) {
                String strString = string(str);
                if (strString == null) {
                    break;
                }
                if ("Null".equals(strString)) {
                    strString = null;
                }
                arrayList.add(strString);
            }
            if (match(cq.v("/", str, "List"))) {
                return (String[]) arrayList.toArray(new String[arrayList.size()]);
            }
        }
        return null;
    }

    @Override // com.ibm.icu.impl.duration.impl.RecordReader
    public String[][] stringTable(String str) {
        if (!match(ky0.j(str, "Table"))) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        while (true) {
            String[] strArrStringArray = stringArray(str);
            if (strArrStringArray == null) {
                break;
            }
            arrayList.add(strArrStringArray);
        }
        if (match(cq.v("/", str, "Table"))) {
            return (String[][]) arrayList.toArray(new String[arrayList.size()][]);
        }
        return null;
    }
}
