package com.ibm.icu.impl.locale;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class BaseLocale {
    private static final boolean JDKIMPL = false;
    public static final String SEP = "_";
    private volatile transient int _hash;
    private String _language;
    private String _region;
    private String _script;
    private String _variant;
    private static final Cache CACHE = new Cache();
    public static final BaseLocale ROOT = getInstance("", "", "", "");

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class Key implements Comparable<Key> {
        private volatile int _hash;
        private String _lang;
        private String _regn;
        private String _scrt;
        private String _vart;

        public Key(String str, String str2, String str3, String str4) {
            this._lang = "";
            this._scrt = "";
            this._regn = "";
            this._vart = "";
            if (str != null) {
                this._lang = str;
            }
            if (str2 != null) {
                this._scrt = str2;
            }
            if (str3 != null) {
                this._regn = str3;
            }
            if (str4 != null) {
                this._vart = str4;
            }
        }

        public static Key normalize(Key key) {
            return new Key(AsciiUtil.toLowerString(key._lang).intern(), AsciiUtil.toTitleString(key._scrt).intern(), AsciiUtil.toUpperString(key._regn).intern(), AsciiUtil.toUpperString(key._vart).intern());
        }

        @Override // java.lang.Comparable
        public int compareTo(Key key) {
            int iCaseIgnoreCompare = AsciiUtil.caseIgnoreCompare(this._lang, key._lang);
            return (iCaseIgnoreCompare == 0 && (iCaseIgnoreCompare = AsciiUtil.caseIgnoreCompare(this._scrt, key._scrt)) == 0 && (iCaseIgnoreCompare = AsciiUtil.caseIgnoreCompare(this._regn, key._regn)) == 0) ? AsciiUtil.caseIgnoreCompare(this._vart, key._vart) : iCaseIgnoreCompare;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Key)) {
                return false;
            }
            Key key = (Key) obj;
            return AsciiUtil.caseIgnoreMatch(key._lang, this._lang) && AsciiUtil.caseIgnoreMatch(key._scrt, this._scrt) && AsciiUtil.caseIgnoreMatch(key._regn, this._regn) && AsciiUtil.caseIgnoreMatch(key._vart, this._vart);
        }

        public int hashCode() {
            int lower = this._hash;
            if (lower == 0) {
                for (int i = 0; i < this._lang.length(); i++) {
                    lower = (lower * 31) + AsciiUtil.toLower(this._lang.charAt(i));
                }
                for (int i2 = 0; i2 < this._scrt.length(); i2++) {
                    lower = (lower * 31) + AsciiUtil.toLower(this._scrt.charAt(i2));
                }
                for (int i3 = 0; i3 < this._regn.length(); i3++) {
                    lower = (lower * 31) + AsciiUtil.toLower(this._regn.charAt(i3));
                }
                for (int i4 = 0; i4 < this._vart.length(); i4++) {
                    lower = (lower * 31) + AsciiUtil.toLower(this._vart.charAt(i4));
                }
                this._hash = lower;
            }
            return lower;
        }
    }

    private BaseLocale(String str, String str2, String str3, String str4) {
        this._language = "";
        this._script = "";
        this._region = "";
        this._variant = "";
        this._hash = 0;
        if (str != null) {
            this._language = AsciiUtil.toLowerString(str).intern();
        }
        if (str2 != null) {
            this._script = AsciiUtil.toTitleString(str2).intern();
        }
        if (str3 != null) {
            this._region = AsciiUtil.toUpperString(str3).intern();
        }
        if (str4 != null) {
            this._variant = AsciiUtil.toUpperString(str4).intern();
        }
    }

    public static BaseLocale getInstance(String str, String str2, String str3, String str4) {
        return CACHE.get(new Key(str, str2, str3, str4));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BaseLocale)) {
            return false;
        }
        BaseLocale baseLocale = (BaseLocale) obj;
        return hashCode() == baseLocale.hashCode() && this._language.equals(baseLocale._language) && this._script.equals(baseLocale._script) && this._region.equals(baseLocale._region) && this._variant.equals(baseLocale._variant);
    }

    public String getLanguage() {
        return this._language;
    }

    public String getRegion() {
        return this._region;
    }

    public String getScript() {
        return this._script;
    }

    public String getVariant() {
        return this._variant;
    }

    public int hashCode() {
        int iCharAt = this._hash;
        if (iCharAt == 0) {
            for (int i = 0; i < this._language.length(); i++) {
                iCharAt = (iCharAt * 31) + this._language.charAt(i);
            }
            for (int i2 = 0; i2 < this._script.length(); i2++) {
                iCharAt = (iCharAt * 31) + this._script.charAt(i2);
            }
            for (int i3 = 0; i3 < this._region.length(); i3++) {
                iCharAt = (iCharAt * 31) + this._region.charAt(i3);
            }
            for (int i4 = 0; i4 < this._variant.length(); i4++) {
                iCharAt = (iCharAt * 31) + this._variant.charAt(i4);
            }
            this._hash = iCharAt;
        }
        return iCharAt;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this._language.length() > 0) {
            sb.append("language=");
            sb.append(this._language);
        }
        if (this._script.length() > 0) {
            if (sb.length() > 0) {
                sb.append(", ");
            }
            sb.append("script=");
            sb.append(this._script);
        }
        if (this._region.length() > 0) {
            if (sb.length() > 0) {
                sb.append(", ");
            }
            sb.append("region=");
            sb.append(this._region);
        }
        if (this._variant.length() > 0) {
            if (sb.length() > 0) {
                sb.append(", ");
            }
            sb.append("variant=");
            sb.append(this._variant);
        }
        return sb.toString();
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class Cache extends LocaleObjectCache<Key, BaseLocale> {
        @Override // com.ibm.icu.impl.locale.LocaleObjectCache
        public BaseLocale createObject(Key key) {
            return new BaseLocale(key._lang, key._scrt, key._regn, key._vart, 0);
        }

        @Override // com.ibm.icu.impl.locale.LocaleObjectCache
        public Key normalizeKey(Key key) {
            return Key.normalize(key);
        }
    }

    public /* synthetic */ BaseLocale(String str, String str2, String str3, String str4, int i) {
        this(str, str2, str3, str4);
    }
}
