package com.ibm.icu.impl;

import com.ibm.icu.text.StringTransform;
import com.ibm.icu.text.SymbolTable;
import com.ibm.icu.text.UnicodeSet;
import com.ibm.icu.util.Freezable;
import defpackage.cq;
import defpackage.dk0;
import defpackage.og;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParsePosition;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class UnicodeRegex implements Cloneable, Freezable<UnicodeRegex>, StringTransform {
    private SymbolTable symbolTable;
    private static final Pattern SUPP_ESCAPE = Pattern.compile("\\\\U00([0-9a-fA-F]{6})");
    private static final UnicodeRegex STANDARD = new UnicodeRegex();
    private String bnfCommentString = "#";
    private String bnfVariableInfix = "=";
    private String bnfLineSeparator = "\n";
    private Comparator<Object> LongestFirst = new Comparator<Object>() { // from class: com.ibm.icu.impl.UnicodeRegex.1
        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            String string = obj.toString();
            String string2 = obj2.toString();
            int length = string.length();
            int length2 = string2.length();
            return length != length2 ? length2 - length : string.compareTo(string2);
        }
    };

    public static List<String> appendLines(List<String> list, InputStream inputStream, String str) throws IOException {
        if (str == null) {
            str = "UTF-8";
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, str));
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                return list;
            }
            list.add(line);
        }
    }

    public static Pattern compile(String str) {
        return Pattern.compile(STANDARD.transform(str));
    }

    public static String fix(String str) {
        return STANDARD.transform(str);
    }

    private Map<String, String> getVariables(List<String> list) {
        int iIndexOf;
        TreeMap treeMap = new TreeMap(this.LongestFirst);
        StringBuffer stringBuffer = new StringBuffer();
        String strTrim = null;
        int i = 0;
        for (String strSubstring : list) {
            i++;
            if (strSubstring.length() != 0) {
                if (strSubstring.charAt(0) == 65279) {
                    strSubstring = strSubstring.substring(1);
                }
                String str = this.bnfCommentString;
                if (str != null && (iIndexOf = strSubstring.indexOf(str)) >= 0) {
                    strSubstring = strSubstring.substring(0, iIndexOf);
                }
                String strTrim2 = strSubstring.trim();
                if (strTrim2.length() != 0 && strSubstring.trim().length() != 0) {
                    boolean zEndsWith = strTrim2.endsWith(";");
                    String strSubstring2 = zEndsWith ? strSubstring.substring(0, strSubstring.lastIndexOf(59)) : strSubstring;
                    int iIndexOf2 = strSubstring2.indexOf(this.bnfVariableInfix);
                    if (iIndexOf2 >= 0) {
                        if (strTrim != null) {
                            throw new IllegalArgumentException("Missing ';' before " + i + ") " + strSubstring);
                        }
                        strTrim = strSubstring2.substring(0, iIndexOf2).trim();
                        if (treeMap.containsKey(strTrim)) {
                            og.i("Duplicate variable definition in ".concat(strSubstring));
                            return null;
                        }
                        stringBuffer.append(strSubstring2.substring(iIndexOf2 + 1).trim());
                    } else {
                        if (strTrim == null) {
                            throw new IllegalArgumentException("Missing '=' at " + i + ") " + strSubstring);
                        }
                        stringBuffer.append(this.bnfLineSeparator);
                        stringBuffer.append(strSubstring2);
                    }
                    if (zEndsWith) {
                        treeMap.put(strTrim, stringBuffer.toString());
                        stringBuffer.setLength(0);
                        strTrim = null;
                    }
                }
            }
        }
        if (strTrim == null) {
            return treeMap;
        }
        og.i("Missing ';' at end");
        return null;
    }

    private int processSet(String str, int i, StringBuilder sb, UnicodeSet unicodeSet, ParsePosition parsePosition) {
        try {
            parsePosition.setIndex(i);
            UnicodeSet unicodeSetApplyPattern = unicodeSet.clear().applyPattern(str, parsePosition, this.symbolTable, 0);
            unicodeSetApplyPattern.complement().complement();
            String pattern = unicodeSetApplyPattern.toPattern(false);
            if (pattern.contains("\\U")) {
                pattern = SUPP_ESCAPE.matcher(pattern).replaceAll("\\\\x{$1}");
            }
            sb.append(pattern);
            return parsePosition.getIndex() - 1;
        } catch (Exception e) {
            throw ((IllegalArgumentException) new IllegalArgumentException(cq.j("Error in ", str)).initCause(e));
        }
    }

    @Override // com.ibm.icu.util.Freezable
    public UnicodeRegex cloneAsThawed() {
        try {
            return (UnicodeRegex) clone();
        } catch (CloneNotSupportedException unused) {
            dk0.v();
            return null;
        }
    }

    public String compileBnf(List<String> list) {
        Map<String, String> variables = getVariables(list);
        LinkedHashSet linkedHashSet = new LinkedHashSet(variables.keySet());
        for (int i = 0; i < 2; i++) {
            for (Map.Entry<String, String> entry : variables.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                for (Map.Entry<String, String> entry2 : variables.entrySet()) {
                    String key2 = entry2.getKey();
                    String value2 = entry2.getValue();
                    if (!key.equals(key2)) {
                        String strReplace = value2.replace(key, value);
                        if (!strReplace.equals(value2)) {
                            linkedHashSet.remove(key);
                            variables.put(key2, strReplace);
                        }
                    }
                }
            }
        }
        if (linkedHashSet.size() == 1) {
            return variables.get(linkedHashSet.iterator().next());
        }
        og.i("Not a single root: ".concat(String.valueOf(linkedHashSet)));
        return null;
    }

    public String getBnfCommentString() {
        return this.bnfCommentString;
    }

    public String getBnfLineSeparator() {
        return this.bnfLineSeparator;
    }

    public String getBnfVariableInfix() {
        return this.bnfVariableInfix;
    }

    public SymbolTable getSymbolTable() {
        return this.symbolTable;
    }

    @Override // com.ibm.icu.util.Freezable
    public boolean isFrozen() {
        return true;
    }

    public void setBnfCommentString(String str) {
        this.bnfCommentString = str;
    }

    public void setBnfLineSeparator(String str) {
        this.bnfLineSeparator = str;
    }

    public void setBnfVariableInfix(String str) {
        this.bnfVariableInfix = str;
    }

    public UnicodeRegex setSymbolTable(SymbolTable symbolTable) {
        this.symbolTable = symbolTable;
        return this;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x002f  */
    /* JADX WARN: Code duplicated, block: B:17:0x0035  */
    @Override // com.ibm.icu.text.StringTransform, com.ibm.icu.text.Transform
    public String transform(String str) {
        String str2;
        StringBuilder sb = new StringBuilder();
        UnicodeSet unicodeSet = new UnicodeSet();
        ParsePosition parsePosition = new ParsePosition(0);
        int iProcessSet = 0;
        char c = 0;
        while (iProcessSet < str.length()) {
            char cCharAt = str.charAt(iProcessSet);
            if (c == 0) {
                if (cCharAt != '\\') {
                    this = this;
                    str2 = str;
                    if (cCharAt == '[' && UnicodeSet.resemblesPattern(str2, iProcessSet)) {
                        iProcessSet = this.processSet(str2, iProcessSet, sb, unicodeSet, parsePosition);
                    }
                } else if (UnicodeSet.resemblesPattern(str, iProcessSet)) {
                    this = this;
                    str2 = str;
                    iProcessSet = this.processSet(str2, iProcessSet, sb, unicodeSet, parsePosition);
                } else {
                    this = this;
                    str2 = str;
                    c = 1;
                }
                iProcessSet++;
                this = this;
                str = str2;
            } else if (c != 1) {
                if (c != 2) {
                    if (c == 3) {
                        if (cCharAt == 'E') {
                            this = this;
                            str2 = str;
                            c = 0;
                        } else {
                            if (cCharAt != '\\') {
                                c = 2;
                            }
                            str2 = str;
                        }
                    }
                } else if (cCharAt == '\\') {
                    this = this;
                    str2 = str;
                    c = 3;
                }
                str2 = str;
            } else if (cCharAt == 'Q') {
                c = 2;
                str2 = str;
            } else {
                this = this;
                str2 = str;
                c = 0;
            }
            sb.append(cCharAt);
            iProcessSet++;
            this = this;
            str = str2;
        }
        return sb.toString();
    }

    @Override // com.ibm.icu.util.Freezable
    public UnicodeRegex freeze() {
        return this;
    }

    public static Pattern compile(String str, int i) {
        return Pattern.compile(STANDARD.transform(str), i);
    }

    public static List<String> appendLines(List<String> list, String str, String str2) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(str);
        try {
            return appendLines(list, fileInputStream, str2);
        } finally {
            fileInputStream.close();
        }
    }

    public String compileBnf(String str) {
        return compileBnf(Arrays.asList(str.split("\\r\\n?|\\n")));
    }
}
