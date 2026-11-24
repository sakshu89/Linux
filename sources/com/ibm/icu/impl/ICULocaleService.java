package com.ibm.icu.impl;

import com.ibm.icu.util.ULocale;
import com.ibm.icu.util.UResourceBundle;
import defpackage.cq;
import defpackage.ky0;
import java.util.Collections;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class ICULocaleService extends ICUService {
    private ULocale fallbackLocale;
    private String fallbackLocaleName;

    public ICULocaleService() {
    }

    @Override // com.ibm.icu.impl.ICUService
    public ICUService.Key createKey(String str) {
        return LocaleKey.createWithCanonicalFallback(str, validateFallbackLocale());
    }

    public Object get(ULocale uLocale, int i, ULocale[] uLocaleArr) {
        ICUService.Key keyCreateKey = createKey(uLocale, i);
        if (uLocaleArr == null) {
            return getKey(keyCreateKey);
        }
        String[] strArr = new String[1];
        Object key = getKey(keyCreateKey, strArr);
        if (key != null) {
            int iIndexOf = strArr[0].indexOf("/");
            if (iIndexOf >= 0) {
                strArr[0] = strArr[0].substring(iIndexOf + 1);
            }
            uLocaleArr[0] = new ULocale(strArr[0]);
        }
        return key;
    }

    public Locale[] getAvailableLocales() {
        Set<String> visibleIDs = getVisibleIDs();
        Locale[] localeArr = new Locale[visibleIDs.size()];
        Iterator<String> it = visibleIDs.iterator();
        int i = 0;
        while (it.hasNext()) {
            localeArr[i] = LocaleUtility.getLocaleFromName(it.next());
            i++;
        }
        return localeArr;
    }

    public ULocale[] getAvailableULocales() {
        Set<String> visibleIDs = getVisibleIDs();
        ULocale[] uLocaleArr = new ULocale[visibleIDs.size()];
        Iterator<String> it = visibleIDs.iterator();
        int i = 0;
        while (it.hasNext()) {
            uLocaleArr[i] = new ULocale(it.next());
            i++;
        }
        return uLocaleArr;
    }

    public ICUService.Factory registerObject(Object obj, ULocale uLocale, int i, boolean z) {
        return registerFactory(new SimpleLocaleKeyFactory(obj, uLocale, i, z));
    }

    public String validateFallbackLocale() {
        ULocale uLocale = ULocale.getDefault();
        if (uLocale != this.fallbackLocale) {
            synchronized (this) {
                try {
                    if (uLocale != this.fallbackLocale) {
                        this.fallbackLocaleName = uLocale.getBaseName();
                        clearServiceCache();
                        this.fallbackLocale = uLocale;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return this.fallbackLocaleName;
    }

    public ICULocaleService(String str) {
        super(str);
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class ICUResourceBundleFactory extends LocaleKeyFactory {
        protected final String bundleName;

        public ICUResourceBundleFactory(String str) {
            super(true);
            this.bundleName = str;
        }

        @Override // com.ibm.icu.impl.ICULocaleService.LocaleKeyFactory
        public Set<String> getSupportedIDs() {
            return ICUResourceBundle.getFullLocaleNameSet(this.bundleName, loader());
        }

        @Override // com.ibm.icu.impl.ICULocaleService.LocaleKeyFactory
        public Object handleCreate(ULocale uLocale, int i, ICUService iCUService) {
            return UResourceBundle.getBundleInstance(this.bundleName, uLocale, loader());
        }

        public ClassLoader loader() {
            return ClassLoaderUtil.getClassLoader(getClass());
        }

        @Override // com.ibm.icu.impl.ICULocaleService.LocaleKeyFactory
        public String toString() {
            return cq.k(super.toString(), ", bundle: ", this.bundleName);
        }

        @Override // com.ibm.icu.impl.ICULocaleService.LocaleKeyFactory, com.ibm.icu.impl.ICUService.Factory
        public void updateVisibleIDs(Map<String, ICUService.Factory> map) {
            Iterator<String> it = ICUResourceBundle.getAvailableLocaleNameSet(this.bundleName, loader()).iterator();
            while (it.hasNext()) {
                map.put(it.next(), this);
            }
        }

        public ICUResourceBundleFactory() {
            this(ICUData.ICU_BASE_NAME);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static abstract class LocaleKeyFactory implements ICUService.Factory {
        public static final boolean INVISIBLE = false;
        public static final boolean VISIBLE = true;
        protected final String name;
        protected final boolean visible;

        public LocaleKeyFactory(boolean z) {
            this.visible = z;
            this.name = null;
        }

        @Override // com.ibm.icu.impl.ICUService.Factory
        public Object create(ICUService.Key key, ICUService iCUService) {
            if (!handlesKey(key)) {
                return null;
            }
            LocaleKey localeKey = (LocaleKey) key;
            return handleCreate(localeKey.currentLocale(), localeKey.kind(), iCUService);
        }

        @Override // com.ibm.icu.impl.ICUService.Factory
        public String getDisplayName(String str, ULocale uLocale) {
            return uLocale == null ? str : new ULocale(str).getDisplayName(uLocale);
        }

        public Set<String> getSupportedIDs() {
            return Collections.EMPTY_SET;
        }

        public Object handleCreate(ULocale uLocale, int i, ICUService iCUService) {
            return null;
        }

        public boolean handlesKey(ICUService.Key key) {
            if (key == null) {
                return false;
            }
            return getSupportedIDs().contains(key.currentID());
        }

        public boolean isSupportedID(String str) {
            return getSupportedIDs().contains(str);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(super.toString());
            if (this.name != null) {
                sb.append(", name: ");
                sb.append(this.name);
            }
            sb.append(", visible: ");
            sb.append(this.visible);
            return sb.toString();
        }

        @Override // com.ibm.icu.impl.ICUService.Factory
        public void updateVisibleIDs(Map<String, ICUService.Factory> map) {
            for (String str : getSupportedIDs()) {
                if (this.visible) {
                    map.put(str, this);
                } else {
                    map.remove(str);
                }
            }
        }

        public LocaleKeyFactory(boolean z, String str) {
            this.visible = z;
            this.name = str;
        }
    }

    public ICUService.Key createKey(String str, int i) {
        return LocaleKey.createWithCanonicalFallback(str, validateFallbackLocale(), i);
    }

    public ICUService.Key createKey(ULocale uLocale, int i) {
        return LocaleKey.createWithCanonical(uLocale, validateFallbackLocale(), i);
    }

    public ICUService.Factory registerObject(Object obj, ULocale uLocale, boolean z) {
        return registerObject(obj, uLocale, -1, z);
    }

    public ICUService.Factory registerObject(Object obj, ULocale uLocale, int i) {
        return registerObject(obj, uLocale, i, true);
    }

    public ICUService.Factory registerObject(Object obj, ULocale uLocale) {
        return registerObject(obj, uLocale, -1, true);
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class LocaleKey extends ICUService.Key {
        public static final int KIND_ANY = -1;
        private String currentID;
        private String fallbackID;
        private int kind;
        private String primaryID;
        private int varstart;

        public LocaleKey(String str, String str2, String str3, int i) {
            String str4;
            super(str);
            this.kind = i;
            if (str2 == null || str2.equalsIgnoreCase("root")) {
                this.primaryID = "";
                this.fallbackID = null;
            } else {
                int iIndexOf = str2.indexOf(64);
                if (iIndexOf == 4) {
                    str4 = str2;
                    if (str4.regionMatches(true, 0, "root", 0, 4)) {
                        this.primaryID = str4.substring(4);
                        this.varstart = 0;
                        this.fallbackID = null;
                    }
                } else {
                    str4 = str2;
                }
                this.primaryID = str4;
                this.varstart = iIndexOf;
                if (str3 == null || str4.equals(str3)) {
                    this.fallbackID = "";
                } else {
                    this.fallbackID = str3;
                }
            }
            int i2 = this.varstart;
            String str5 = this.primaryID;
            this.currentID = i2 != -1 ? str5.substring(0, i2) : str5;
        }

        public static LocaleKey createWithCanonical(ULocale uLocale, String str, int i) {
            if (uLocale == null) {
                return null;
            }
            String name = uLocale.getName();
            return new LocaleKey(name, name, str, i);
        }

        public static LocaleKey createWithCanonicalFallback(String str, String str2, int i) {
            if (str == null) {
                return null;
            }
            return new LocaleKey(str, ULocale.getName(str), str2, i);
        }

        @Override // com.ibm.icu.impl.ICUService.Key
        public String canonicalID() {
            return this.primaryID;
        }

        public ULocale canonicalLocale() {
            return new ULocale(this.primaryID);
        }

        @Override // com.ibm.icu.impl.ICUService.Key
        public String currentDescriptor() {
            String strCurrentID = currentID();
            if (strCurrentID == null) {
                return strCurrentID;
            }
            StringBuilder sb = new StringBuilder();
            if (this.kind != -1) {
                sb.append(prefix());
            }
            sb.append('/');
            sb.append(strCurrentID);
            int i = this.varstart;
            if (i != -1) {
                String str = this.primaryID;
                sb.append(str.substring(i, str.length()));
            }
            return sb.toString();
        }

        @Override // com.ibm.icu.impl.ICUService.Key
        public String currentID() {
            return this.currentID;
        }

        public ULocale currentLocale() {
            return this.varstart == -1 ? new ULocale(this.currentID) : new ULocale(ky0.j(this.currentID, this.primaryID.substring(this.varstart)));
        }

        @Override // com.ibm.icu.impl.ICUService.Key
        public boolean fallback() {
            int iLastIndexOf = this.currentID.lastIndexOf(95);
            if (iLastIndexOf != -1) {
                while (true) {
                    int i = iLastIndexOf - 1;
                    if (i < 0 || this.currentID.charAt(i) != '_') {
                        break;
                    }
                    iLastIndexOf = i;
                }
                this.currentID = this.currentID.substring(0, iLastIndexOf);
                return true;
            }
            String str = this.fallbackID;
            if (str == null) {
                this.currentID = null;
                return false;
            }
            this.currentID = str;
            if (str.length() == 0) {
                this.fallbackID = null;
            } else {
                this.fallbackID = "";
            }
            return true;
        }

        @Override // com.ibm.icu.impl.ICUService.Key
        public boolean isFallbackOf(String str) {
            return LocaleUtility.isFallbackOf(canonicalID(), str);
        }

        public int kind() {
            return this.kind;
        }

        public String prefix() {
            if (this.kind == -1) {
                return null;
            }
            return Integer.toString(kind());
        }

        public static LocaleKey createWithCanonicalFallback(String str, String str2) {
            return createWithCanonicalFallback(str, str2, -1);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class SimpleLocaleKeyFactory extends LocaleKeyFactory {
        private final String id;
        private final int kind;
        private final Object obj;

        public SimpleLocaleKeyFactory(Object obj, ULocale uLocale, int i, boolean z, String str) {
            super(z, str);
            this.obj = obj;
            this.id = uLocale.getBaseName();
            this.kind = i;
        }

        @Override // com.ibm.icu.impl.ICULocaleService.LocaleKeyFactory, com.ibm.icu.impl.ICUService.Factory
        public Object create(ICUService.Key key, ICUService iCUService) {
            if (!(key instanceof LocaleKey)) {
                return null;
            }
            LocaleKey localeKey = (LocaleKey) key;
            int i = this.kind;
            if ((i == -1 || i == localeKey.kind()) && this.id.equals(localeKey.currentID())) {
                return this.obj;
            }
            return null;
        }

        @Override // com.ibm.icu.impl.ICULocaleService.LocaleKeyFactory
        public boolean isSupportedID(String str) {
            return this.id.equals(str);
        }

        @Override // com.ibm.icu.impl.ICULocaleService.LocaleKeyFactory
        public String toString() {
            return super.toString() + ", id: " + this.id + ", kind: " + this.kind;
        }

        @Override // com.ibm.icu.impl.ICULocaleService.LocaleKeyFactory, com.ibm.icu.impl.ICUService.Factory
        public void updateVisibleIDs(Map<String, ICUService.Factory> map) {
            boolean z = this.visible;
            String str = this.id;
            if (z) {
                map.put(str, this);
            } else {
                map.remove(str);
            }
        }

        public SimpleLocaleKeyFactory(Object obj, ULocale uLocale, int i, boolean z) {
            this(obj, uLocale, i, z, null);
        }
    }

    public Object get(ULocale uLocale, int i) {
        return get(uLocale, i, null);
    }

    public Object get(ULocale uLocale, ULocale[] uLocaleArr) {
        return get(uLocale, -1, uLocaleArr);
    }

    public Object get(ULocale uLocale) {
        return get(uLocale, -1, null);
    }
}
