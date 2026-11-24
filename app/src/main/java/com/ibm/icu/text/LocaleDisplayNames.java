package com.ibm.icu.text;

import com.ibm.icu.impl.ICUConfig;
import com.ibm.icu.lang.UScript;
import com.ibm.icu.util.ULocale;
import defpackage.cq;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class LocaleDisplayNames {
    private static final Method FACTORY_DIALECTHANDLING;
    private static final Method FACTORY_DISPLAYCONTEXT;

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public enum DialectHandling {
        STANDARD_NAMES,
        DIALECT_NAMES
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class UiListItem {
        public final ULocale minimized;
        public final ULocale modified;
        public final String nameInDisplayLocale;
        public final String nameInSelf;

        /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
        public static class UiListItemComparator implements Comparator<UiListItem> {
            private final Comparator<Object> collator;
            private final boolean useSelf;

            public UiListItemComparator(Comparator<Object> comparator, boolean z) {
                this.collator = comparator;
                this.useSelf = z;
            }

            @Override // java.util.Comparator
            public int compare(UiListItem uiListItem, UiListItem uiListItem2) {
                boolean z = this.useSelf;
                Comparator<Object> comparator = this.collator;
                int iCompare = z ? comparator.compare(uiListItem.nameInSelf, uiListItem2.nameInSelf) : comparator.compare(uiListItem.nameInDisplayLocale, uiListItem2.nameInDisplayLocale);
                return iCompare != 0 ? iCompare : uiListItem.modified.compareTo(uiListItem2.modified);
            }
        }

        public UiListItem(ULocale uLocale, ULocale uLocale2, String str, String str2) {
            this.minimized = uLocale;
            this.modified = uLocale2;
            this.nameInDisplayLocale = str;
            this.nameInSelf = str2;
        }

        public static Comparator<UiListItem> getComparator(Comparator<Object> comparator, boolean z) {
            return new UiListItemComparator(comparator, z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && (obj instanceof UiListItem)) {
                UiListItem uiListItem = (UiListItem) obj;
                if (this.nameInDisplayLocale.equals(uiListItem.nameInDisplayLocale) && this.nameInSelf.equals(uiListItem.nameInSelf) && this.minimized.equals(uiListItem.minimized) && this.modified.equals(uiListItem.modified)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return this.nameInDisplayLocale.hashCode() ^ this.modified.hashCode();
        }

        public String toString() {
            String strValueOf = String.valueOf(this.minimized);
            String strValueOf2 = String.valueOf(this.modified);
            String str = this.nameInDisplayLocale;
            String str2 = this.nameInSelf;
            StringBuilder sbQ = cq.q("{", strValueOf, ", ", strValueOf2, ", ");
            sbQ.append(str);
            sbQ.append(", ");
            sbQ.append(str2);
            sbQ.append("}");
            return sbQ.toString();
        }
    }

    static {
        Method method;
        Method method2 = null;
        try {
            Class<?> cls = Class.forName(ICUConfig.get("com.ibm.icu.text.LocaleDisplayNames.impl", "com.ibm.icu.impl.LocaleDisplayNamesImpl"));
            try {
                method = cls.getMethod("getInstance", ULocale.class, DialectHandling.class);
            } catch (NoSuchMethodException unused) {
                method = null;
            }
            try {
                method2 = cls.getMethod("getInstance", ULocale.class, DisplayContext[].class);
            } catch (ClassNotFoundException | NoSuchMethodException unused2) {
            }
        } catch (ClassNotFoundException unused3) {
            method = null;
        }
        FACTORY_DIALECTHANDLING = method;
        FACTORY_DISPLAYCONTEXT = method2;
    }

    @Deprecated
    public LocaleDisplayNames() {
    }

    public static LocaleDisplayNames getInstance(ULocale uLocale, DialectHandling dialectHandling) {
        Method method = FACTORY_DIALECTHANDLING;
        LocaleDisplayNames localeDisplayNames = null;
        if (method != null) {
            try {
                localeDisplayNames = (LocaleDisplayNames) method.invoke(null, uLocale, dialectHandling);
            } catch (IllegalAccessException | InvocationTargetException unused) {
            }
        }
        return localeDisplayNames == null ? new LastResortLocaleDisplayNames(uLocale, dialectHandling, 0) : localeDisplayNames;
    }

    public abstract DisplayContext getContext(DisplayContext.Type type);

    public abstract DialectHandling getDialectHandling();

    public abstract ULocale getLocale();

    public List<UiListItem> getUiList(Set<ULocale> set, boolean z, Comparator<Object> comparator) {
        return getUiListCompareWholeItems(set, UiListItem.getComparator(comparator, z));
    }

    public abstract List<UiListItem> getUiListCompareWholeItems(Set<ULocale> set, Comparator<UiListItem> comparator);

    public abstract String keyDisplayName(String str);

    public abstract String keyValueDisplayName(String str, String str2);

    public abstract String languageDisplayName(String str);

    public abstract String localeDisplayName(ULocale uLocale);

    public abstract String localeDisplayName(String str);

    public abstract String localeDisplayName(Locale locale);

    public abstract String regionDisplayName(String str);

    public abstract String scriptDisplayName(int i);

    public abstract String scriptDisplayName(String str);

    @Deprecated
    public String scriptDisplayNameInContext(String str) {
        return scriptDisplayName(str);
    }

    public abstract String variantDisplayName(String str);

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class LastResortLocaleDisplayNames extends LocaleDisplayNames {
        private DisplayContext[] contexts;
        private ULocale locale;

        private LastResortLocaleDisplayNames(ULocale uLocale, DialectHandling dialectHandling) {
            this.locale = uLocale;
            this.contexts = new DisplayContext[]{dialectHandling == DialectHandling.DIALECT_NAMES ? DisplayContext.DIALECT_NAMES : DisplayContext.STANDARD_NAMES};
        }

        @Override // com.ibm.icu.text.LocaleDisplayNames
        public DisplayContext getContext(DisplayContext.Type type) {
            DisplayContext displayContext = DisplayContext.STANDARD_NAMES;
            for (DisplayContext displayContext2 : this.contexts) {
                if (displayContext2.type() == type) {
                    return displayContext2;
                }
            }
            return displayContext;
        }

        @Override // com.ibm.icu.text.LocaleDisplayNames
        public DialectHandling getDialectHandling() {
            DialectHandling dialectHandling = DialectHandling.STANDARD_NAMES;
            for (DisplayContext displayContext : this.contexts) {
                if (displayContext.type() == DisplayContext.Type.DIALECT_HANDLING && displayContext.value() == DisplayContext.DIALECT_NAMES.ordinal()) {
                    return DialectHandling.DIALECT_NAMES;
                }
            }
            return dialectHandling;
        }

        @Override // com.ibm.icu.text.LocaleDisplayNames
        public ULocale getLocale() {
            return this.locale;
        }

        @Override // com.ibm.icu.text.LocaleDisplayNames
        public List<UiListItem> getUiListCompareWholeItems(Set<ULocale> set, Comparator<UiListItem> comparator) {
            return Collections.EMPTY_LIST;
        }

        @Override // com.ibm.icu.text.LocaleDisplayNames
        public String localeDisplayName(String str) {
            return new ULocale(str).getName();
        }

        @Override // com.ibm.icu.text.LocaleDisplayNames
        public String scriptDisplayName(int i) {
            return UScript.getShortName(i);
        }

        @Override // com.ibm.icu.text.LocaleDisplayNames
        public String scriptDisplayName(String str) {
            return str;
        }

        @Override // com.ibm.icu.text.LocaleDisplayNames
        public String localeDisplayName(Locale locale) {
            return ULocale.forLocale(locale).getName();
        }

        @Override // com.ibm.icu.text.LocaleDisplayNames
        public String localeDisplayName(ULocale uLocale) {
            return uLocale.getName();
        }

        public /* synthetic */ LastResortLocaleDisplayNames(ULocale uLocale, DisplayContext[] displayContextArr, int i) {
            this(uLocale, displayContextArr);
        }

        public /* synthetic */ LastResortLocaleDisplayNames(ULocale uLocale, DialectHandling dialectHandling, int i) {
            this(uLocale, dialectHandling);
        }

        private LastResortLocaleDisplayNames(ULocale uLocale, DisplayContext... displayContextArr) {
            this.locale = uLocale;
            DisplayContext[] displayContextArr2 = new DisplayContext[displayContextArr.length];
            this.contexts = displayContextArr2;
            System.arraycopy(displayContextArr, 0, displayContextArr2, 0, displayContextArr.length);
        }

        @Override // com.ibm.icu.text.LocaleDisplayNames
        public String keyDisplayName(String str) {
            return str;
        }

        @Override // com.ibm.icu.text.LocaleDisplayNames
        public String languageDisplayName(String str) {
            return str;
        }

        @Override // com.ibm.icu.text.LocaleDisplayNames
        public String regionDisplayName(String str) {
            return str;
        }

        @Override // com.ibm.icu.text.LocaleDisplayNames
        public String variantDisplayName(String str) {
            return str;
        }

        @Override // com.ibm.icu.text.LocaleDisplayNames
        public String keyValueDisplayName(String str, String str2) {
            return str2;
        }
    }

    public static LocaleDisplayNames getInstance(Locale locale) {
        return getInstance(ULocale.forLocale(locale));
    }

    public static LocaleDisplayNames getInstance(ULocale uLocale) {
        return getInstance(uLocale, DialectHandling.STANDARD_NAMES);
    }

    public static LocaleDisplayNames getInstance(ULocale uLocale, DisplayContext... displayContextArr) {
        Method method = FACTORY_DISPLAYCONTEXT;
        LocaleDisplayNames localeDisplayNames = null;
        if (method != null) {
            try {
                localeDisplayNames = (LocaleDisplayNames) method.invoke(null, uLocale, displayContextArr);
            } catch (IllegalAccessException | InvocationTargetException unused) {
            }
        }
        return localeDisplayNames == null ? new LastResortLocaleDisplayNames(uLocale, displayContextArr, 0) : localeDisplayNames;
    }

    public static LocaleDisplayNames getInstance(Locale locale, DisplayContext... displayContextArr) {
        return getInstance(ULocale.forLocale(locale), displayContextArr);
    }
}
