package com.ibm.icu.impl;

import com.ibm.icu.impl.locale.AsciiUtil;
import defpackage.og;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class LocaleIDParser {
    private static final char COMMA = ',';
    private static final char DONE = 65535;
    private static final char DOT = '.';
    private static final char HYPHEN = '-';
    private static final char ITEM_SEPARATOR = ';';
    private static final char KEYWORD_ASSIGN = '=';
    private static final char KEYWORD_SEPARATOR = '@';
    private static final int MAX_VARIANTS_LENGTH = 179;
    private static final char UNDERSCORE = '_';
    String baseName;
    private StringBuilder buffer;
    private boolean canonicalize;
    private boolean hadCountry;
    private char[] id;
    private int index;
    Map<String, String> keywords;

    public LocaleIDParser(String str, boolean z) {
        char[] charArray = str.toCharArray();
        this.id = charArray;
        this.index = 0;
        this.buffer = new StringBuilder(charArray.length + 5);
        this.canonicalize = z;
    }

    private void addSeparator() {
        append(UNDERSCORE);
    }

    private void append(char c) {
        this.buffer.append(c);
    }

    private boolean atTerminator() {
        int i = this.index;
        char[] cArr = this.id;
        return i >= cArr.length || isTerminator(cArr[i]);
    }

    private Comparator<String> getKeyComparator() {
        return new Comparator<String>() { // from class: com.ibm.icu.impl.LocaleIDParser.1
            @Override // java.util.Comparator
            public int compare(String str, String str2) {
                return str.compareTo(str2);
            }
        };
    }

    private String getKeyword() {
        int i = this.index;
        while (!isDoneOrKeywordAssign(next())) {
        }
        int i2 = this.index - 1;
        this.index = i2;
        return AsciiUtil.toLowerString(new String(this.id, i, i2 - i).trim());
    }

    private String getString(int i) {
        return this.buffer.substring(i);
    }

    private String getValue() {
        int i = this.index;
        while (!isDoneOrItemSeparator(next())) {
        }
        int i2 = this.index - 1;
        this.index = i2;
        return new String(this.id, i, i2 - i).trim();
    }

    private boolean haveExperimentalLanguagePrefix() {
        char c;
        char[] cArr = this.id;
        if (cArr.length <= 2 || !((c = cArr[1]) == '-' || c == '_')) {
            return false;
        }
        char c2 = cArr[0];
        return c2 == 'x' || c2 == 'X' || c2 == 'i' || c2 == 'I';
    }

    private boolean haveKeywordAssign() {
        int i = this.index;
        while (true) {
            char[] cArr = this.id;
            if (i >= cArr.length) {
                return false;
            }
            if (cArr[i] == '=') {
                return true;
            }
            i++;
        }
    }

    private static boolean isDoneOrItemSeparator(char c) {
        return c == 65535 || c == ';';
    }

    private static boolean isDoneOrKeywordAssign(char c) {
        return c == 65535 || c == '=';
    }

    private boolean isTerminator(char c) {
        return c == '@' || c == 65535 || c == '.';
    }

    private boolean isTerminatorOrIDSeparator(char c) {
        return c == '_' || c == '-' || isTerminator(c);
    }

    private char next() {
        int i = this.index;
        char[] cArr = this.id;
        if (i == cArr.length) {
            this.index = i + 1;
            return (char) 65535;
        }
        this.index = i + 1;
        return cArr[i];
    }

    private int parseCountry() {
        String strThreeToTwoLetterRegion;
        if (atTerminator()) {
            return this.buffer.length();
        }
        int i = this.index;
        this.index = i + 1;
        int length = this.buffer.length();
        boolean z = true;
        while (true) {
            char next = next();
            if (isTerminatorOrIDSeparator(next)) {
                break;
            }
            if (z) {
                this.hadCountry = true;
                addSeparator();
                length++;
                z = false;
            }
            append(AsciiUtil.toUpper(next));
        }
        this.index--;
        int length2 = this.buffer.length() - length;
        if (length2 != 0) {
            if (length2 < 2 || length2 > 3) {
                this.index = i;
                int i2 = length - 1;
                StringBuilder sb = this.buffer;
                sb.delete(i2, sb.length());
                this.hadCountry = false;
                return i2;
            }
            if (length2 == 3 && (strThreeToTwoLetterRegion = LocaleIDs.threeToTwoLetterRegion(getString(length))) != null) {
                set(length, strThreeToTwoLetterRegion);
            }
        }
        return length;
    }

    private int parseKeywords() {
        int length = this.buffer.length();
        Map<String, String> keywordMap = getKeywordMap();
        if (keywordMap.isEmpty()) {
            return length;
        }
        boolean z = true;
        for (Map.Entry<String, String> entry : keywordMap.entrySet()) {
            append(z ? KEYWORD_SEPARATOR : ITEM_SEPARATOR);
            append(entry.getKey());
            append(KEYWORD_ASSIGN);
            append(entry.getValue());
            z = false;
        }
        return !z ? length + 1 : length;
    }

    private int parseLanguage() {
        String strThreeToTwoLetterLanguage;
        int length = this.buffer.length();
        if (haveExperimentalLanguagePrefix()) {
            append(AsciiUtil.toLower(this.id[0]));
            append(HYPHEN);
            this.index = 2;
        }
        while (true) {
            char next = next();
            if (isTerminatorOrIDSeparator(next)) {
                break;
            }
            append(AsciiUtil.toLower(next));
        }
        this.index--;
        if (this.buffer.length() - length == 3 && (strThreeToTwoLetterLanguage = LocaleIDs.threeToTwoLetterLanguage(getString(0))) != null) {
            set(0, strThreeToTwoLetterLanguage);
        }
        return 0;
    }

    private int parseScript() {
        if (atTerminator()) {
            return this.buffer.length();
        }
        int i = this.index;
        this.index = i + 1;
        int length = this.buffer.length();
        boolean z = true;
        while (true) {
            char next = next();
            if (isTerminatorOrIDSeparator(next) || !AsciiUtil.isAlpha(next)) {
                break;
            }
            if (z) {
                addSeparator();
                append(AsciiUtil.toUpper(next));
                z = false;
            } else {
                append(AsciiUtil.toLower(next));
            }
        }
        int i2 = this.index - 1;
        this.index = i2;
        if (i2 - i == 5) {
            return length + 1;
        }
        this.index = i;
        StringBuilder sb = this.buffer;
        sb.delete(length, sb.length());
        return length;
    }

    private int parseVariant() {
        int length = this.buffer.length();
        boolean z = true;
        boolean z2 = true;
        boolean z3 = true;
        boolean z4 = false;
        while (true) {
            char next = next();
            if (next == 65535) {
                break;
            }
            if (next == '.') {
                z4 = true;
            } else if (next != '@') {
                char c = UNDERSCORE;
                if (z) {
                    if (next != '_' && next != '-') {
                        this.index--;
                    }
                } else if (z4) {
                    continue;
                } else {
                    if (z2) {
                        if (z3 && !this.hadCountry) {
                            addSeparator();
                            length++;
                        }
                        addSeparator();
                        if (z3) {
                            length++;
                            z2 = false;
                            z3 = false;
                        } else {
                            z2 = false;
                        }
                    }
                    char upper = AsciiUtil.toUpper(next);
                    if (upper != '-' && upper != ',') {
                        c = upper;
                    }
                    append(c);
                    if (this.buffer.length() - length > 179) {
                        og.i("variants is too long");
                        return 0;
                    }
                }
            } else {
                if (haveKeywordAssign()) {
                    break;
                }
                z2 = true;
                z = false;
                z4 = false;
            }
            z = false;
        }
        this.index--;
        return length;
    }

    private void reset() {
        this.index = 0;
        this.buffer = new StringBuilder(this.id.length + 5);
    }

    private void set(int i, String str) {
        StringBuilder sb = this.buffer;
        sb.delete(i, sb.length());
        this.buffer.insert(i, str);
    }

    private void setKeywordValue(String str, String str2, boolean z) {
        if (str == null) {
            if (z) {
                this.keywords = Collections.EMPTY_MAP;
                return;
            }
            return;
        }
        String lowerString = AsciiUtil.toLowerString(str.trim());
        if (lowerString.length() == 0) {
            og.i("keyword must not be empty");
            return;
        }
        if (str2 != null) {
            str2 = str2.trim();
            if (str2.length() == 0) {
                og.i("value must not be empty");
                return;
            }
        }
        Map<String, String> keywordMap = getKeywordMap();
        if (keywordMap.isEmpty()) {
            if (str2 != null) {
                TreeMap treeMap = new TreeMap(getKeyComparator());
                this.keywords = treeMap;
                treeMap.put(lowerString, str2.trim());
                return;
            }
            return;
        }
        if (z || !keywordMap.containsKey(lowerString)) {
            if (str2 != null) {
                keywordMap.put(lowerString, str2);
                return;
            }
            keywordMap.remove(lowerString);
            if (keywordMap.isEmpty()) {
                this.keywords = Collections.EMPTY_MAP;
            }
        }
    }

    private boolean setToKeywordStart() {
        int i = this.index;
        while (true) {
            char[] cArr = this.id;
            if (i >= cArr.length) {
                return false;
            }
            if (cArr[i] != '@') {
                i++;
            } else {
                if (!this.canonicalize) {
                    int i2 = i + 1;
                    if (i2 >= cArr.length) {
                        return false;
                    }
                    this.index = i2;
                    return true;
                }
                int i3 = i + 1;
                int i4 = i3;
                while (true) {
                    char[] cArr2 = this.id;
                    if (i4 >= cArr2.length) {
                        return false;
                    }
                    if (cArr2[i4] == '=') {
                        this.index = i3;
                        return true;
                    }
                    i4++;
                }
            }
        }
    }

    private void skipCountry() {
        if (atTerminator()) {
            return;
        }
        char[] cArr = this.id;
        int i = this.index;
        char c = cArr[i];
        if (c == '_' || c == '-') {
            this.index = i + 1;
        }
        int i2 = this.index;
        skipUntilTerminatorOrIDSeparator();
        int i3 = this.index - i2;
        if (i3 < 2 || i3 > 3) {
            this.index = i2;
        }
    }

    private void skipLanguage() {
        if (haveExperimentalLanguagePrefix()) {
            this.index = 2;
        }
        skipUntilTerminatorOrIDSeparator();
    }

    private void skipScript() {
        char next;
        if (atTerminator()) {
            return;
        }
        int i = this.index;
        this.index = i + 1;
        do {
            next = next();
            if (isTerminatorOrIDSeparator(next)) {
                break;
            }
        } while (AsciiUtil.isAlpha(next));
        int i2 = this.index - 1;
        this.index = i2;
        if (i2 - i != 5) {
            this.index = i;
        }
    }

    private void skipUntilTerminatorOrIDSeparator() {
        while (!isTerminatorOrIDSeparator(next())) {
        }
        this.index--;
    }

    public void defaultKeywordValue(String str, String str2) {
        setKeywordValue(str, str2, false);
    }

    public String getBaseName() {
        String str = this.baseName;
        if (str != null) {
            return str;
        }
        parseBaseName();
        return getString(0);
    }

    public String getCountry() {
        reset();
        skipLanguage();
        skipScript();
        return getString(parseCountry());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.util.Map<java.lang.String, java.lang.String>] */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.util.TreeMap] */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.util.TreeMap] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9 */
    public Map<String, String> getKeywordMap() {
        Object treeMap;
        if (this.keywords == null) {
            var r1 = 0;
            r1 = 0;
            if (setToKeywordStart()) {
                do {
                    String keyword = getKeyword();
                    if (keyword.length() == 0) {
                        break;
                    }
                    char next = next();
                    if (next != '=') {
                        r1 = r1;
                        if (next != 65535) {
                            break;
                        }
                        break;
                    }
                    String value = getValue();
                    r1 = r1;
                    if (value.length() != 0) {
                        if (r1 == 0) {
                            treeMap = new TreeMap(getKeyComparator());
                        } else {
                            boolean zContainsKey = r1.containsKey(keyword);
                            r1 = r1;
                            treeMap = r1;
                            if (!zContainsKey) {
                            }
                        }
                        treeMap.put(keyword, value);
                        r1 = treeMap;
                    }
                } while (next() == ';');
            }
            if (r1 == 0) {
                r1 = Collections.EMPTY_MAP;
            }
            this.keywords = r1;
        }
        return this.keywords;
    }

    public String getKeywordValue(String str) {
        Map<String, String> keywordMap = getKeywordMap();
        if (keywordMap.isEmpty()) {
            return null;
        }
        return keywordMap.get(AsciiUtil.toLowerString(str.trim()));
    }

    public Iterator<String> getKeywords() {
        Map<String, String> keywordMap = getKeywordMap();
        if (keywordMap.isEmpty()) {
            return null;
        }
        return keywordMap.keySet().iterator();
    }

    public String getLanguage() {
        reset();
        return getString(parseLanguage());
    }

    public String[] getLanguageScriptCountryVariant() {
        reset();
        return new String[]{getString(parseLanguage()), getString(parseScript()), getString(parseCountry()), getString(parseVariant())};
    }

    public String getName() {
        parseBaseName();
        parseKeywords();
        return getString(0);
    }

    public String getScript() {
        reset();
        skipLanguage();
        return getString(parseScript());
    }

    public String getVariant() {
        reset();
        skipLanguage();
        skipScript();
        skipCountry();
        return getString(parseVariant());
    }

    public void parseBaseName() {
        String str = this.baseName;
        if (str != null) {
            set(0, str);
            return;
        }
        reset();
        parseLanguage();
        parseScript();
        parseCountry();
        parseVariant();
        int length = this.buffer.length();
        if (length > 0) {
            int i = length - 1;
            if (this.buffer.charAt(i) == '_') {
                this.buffer.deleteCharAt(i);
            }
        }
    }

    public void setBaseName(String str) {
        this.baseName = str;
    }

    private void append(String str) {
        this.buffer.append(str);
    }

    public LocaleIDParser(String str) {
        this(str, false);
    }

    public void setKeywordValue(String str, String str2) {
        setKeywordValue(str, str2, true);
    }
}
