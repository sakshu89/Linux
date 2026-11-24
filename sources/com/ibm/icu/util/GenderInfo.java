package com.ibm.icu.util;

import com.ibm.icu.impl.ICUCache;
import com.ibm.icu.impl.ICUData;
import com.ibm.icu.impl.ICUResourceBundle;
import com.ibm.icu.impl.SimpleCache;
import defpackage.cq;
import defpackage.og;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class GenderInfo {
    private final ListGenderStyle style;
    private static GenderInfo neutral = new GenderInfo(ListGenderStyle.NEUTRAL);
    private static Cache genderInfoCache = new Cache(0);

    /* JADX INFO: renamed from: com.ibm.icu.util.GenderInfo$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ibm$icu$util$GenderInfo$Gender;
        static final /* synthetic */ int[] $SwitchMap$com$ibm$icu$util$GenderInfo$ListGenderStyle;

        static {
            int[] iArr = new int[ListGenderStyle.values().length];
            $SwitchMap$com$ibm$icu$util$GenderInfo$ListGenderStyle = iArr;
            try {
                iArr[ListGenderStyle.NEUTRAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ibm$icu$util$GenderInfo$ListGenderStyle[ListGenderStyle.MIXED_NEUTRAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$ibm$icu$util$GenderInfo$ListGenderStyle[ListGenderStyle.MALE_TAINTS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[Gender.values().length];
            $SwitchMap$com$ibm$icu$util$GenderInfo$Gender = iArr2;
            try {
                iArr2[Gender.FEMALE.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$ibm$icu$util$GenderInfo$Gender[Gender.MALE.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$ibm$icu$util$GenderInfo$Gender[Gender.OTHER.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    @Deprecated
    public enum Gender {
        MALE,
        FEMALE,
        OTHER
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    @Deprecated
    public enum ListGenderStyle {
        NEUTRAL,
        MIXED_NEUTRAL,
        MALE_TAINTS;

        private static Map<String, ListGenderStyle> fromNameMap;

        static {
            ListGenderStyle listGenderStyle = NEUTRAL;
            ListGenderStyle listGenderStyle2 = MIXED_NEUTRAL;
            ListGenderStyle listGenderStyle3 = MALE_TAINTS;
            HashMap map = new HashMap(3);
            fromNameMap = map;
            map.put("neutral", listGenderStyle);
            fromNameMap.put("maleTaints", listGenderStyle3);
            fromNameMap.put("mixedNeutral", listGenderStyle2);
        }

        @Deprecated
        public static ListGenderStyle fromName(String str) {
            ListGenderStyle listGenderStyle = fromNameMap.get(str);
            if (listGenderStyle != null) {
                return listGenderStyle;
            }
            og.i(cq.j("Unknown gender style name: ", str));
            return null;
        }
    }

    @Deprecated
    public GenderInfo(ListGenderStyle listGenderStyle) {
        this.style = listGenderStyle;
    }

    @Deprecated
    public static GenderInfo getInstance(Locale locale) {
        return getInstance(ULocale.forLocale(locale));
    }

    @Deprecated
    public Gender getListGender(List<Gender> list) {
        if (list.size() == 0) {
            return Gender.OTHER;
        }
        boolean z = false;
        if (list.size() == 1) {
            return list.get(0);
        }
        int i = AnonymousClass1.$SwitchMap$com$ibm$icu$util$GenderInfo$ListGenderStyle[this.style.ordinal()];
        if (i == 1) {
            return Gender.OTHER;
        }
        if (i != 2) {
            if (i != 3) {
                return Gender.OTHER;
            }
            Iterator<Gender> it = list.iterator();
            while (it.hasNext()) {
                if (it.next() != Gender.FEMALE) {
                    return Gender.MALE;
                }
            }
            return Gender.FEMALE;
        }
        Iterator<Gender> it2 = list.iterator();
        boolean z2 = false;
        while (it2.hasNext()) {
            int i2 = AnonymousClass1.$SwitchMap$com$ibm$icu$util$GenderInfo$Gender[it2.next().ordinal()];
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 == 3) {
                        return Gender.OTHER;
                    }
                } else {
                    if (z2) {
                        return Gender.OTHER;
                    }
                    z = true;
                }
            } else {
                if (z) {
                    return Gender.OTHER;
                }
                z2 = true;
            }
        }
        return z ? Gender.MALE : Gender.FEMALE;
    }

    @Deprecated
    public static GenderInfo getInstance(ULocale uLocale) {
        return genderInfoCache.get(uLocale);
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class Cache {
        private final ICUCache<ULocale, GenderInfo> cache;

        private Cache() {
            this.cache = new SimpleCache();
        }

        private static GenderInfo load(ULocale uLocale) {
            try {
                return new GenderInfo(ListGenderStyle.fromName(UResourceBundle.getBundleInstance(ICUData.ICU_BASE_NAME, "genderList", ICUResourceBundle.ICU_DATA_CLASS_LOADER, true).get("genderList").getString(uLocale.toString())));
            } catch (MissingResourceException unused) {
                return null;
            }
        }

        public GenderInfo get(ULocale uLocale) {
            GenderInfo genderInfoLoad = this.cache.get(uLocale);
            if (genderInfoLoad == null) {
                genderInfoLoad = load(uLocale);
                if (genderInfoLoad == null) {
                    ULocale fallback = uLocale.getFallback();
                    genderInfoLoad = fallback == null ? GenderInfo.neutral : get(fallback);
                }
                this.cache.put(uLocale, genderInfoLoad);
            }
            return genderInfoLoad;
        }

        public /* synthetic */ Cache(int i) {
            this();
        }
    }

    @Deprecated
    public Gender getListGender(Gender... genderArr) {
        return getListGender(Arrays.asList(genderArr));
    }
}
