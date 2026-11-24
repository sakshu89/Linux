package com.ibm.icu.text;

import com.ibm.icu.impl.CSCharacterIterator;
import com.ibm.icu.impl.CacheValue;
import com.ibm.icu.impl.ICUDebug;
import com.ibm.icu.impl.ICULocaleService;
import com.ibm.icu.util.ICUCloneNotSupportedException;
import com.ibm.icu.util.ULocale;
import defpackage.dk0;
import defpackage.og;
import java.text.CharacterIterator;
import java.util.Locale;
import java.util.MissingResourceException;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class BreakIterator implements Cloneable {
    public static final int DONE = -1;
    public static final int KIND_CHARACTER = 0;
    private static final int KIND_COUNT = 5;
    public static final int KIND_LINE = 2;
    public static final int KIND_SENTENCE = 3;

    @Deprecated
    public static final int KIND_TITLE = 4;
    public static final int KIND_WORD = 1;
    public static final int WORD_IDEO = 400;
    public static final int WORD_IDEO_LIMIT = 500;
    public static final int WORD_KANA = 300;
    public static final int WORD_KANA_LIMIT = 400;
    public static final int WORD_LETTER = 200;
    public static final int WORD_LETTER_LIMIT = 300;
    public static final int WORD_NONE = 0;
    public static final int WORD_NONE_LIMIT = 100;
    public static final int WORD_NUMBER = 100;
    public static final int WORD_NUMBER_LIMIT = 200;
    private static BreakIteratorServiceShim shim;
    private ULocale actualLocale;
    private ULocale validLocale;
    private static final boolean DEBUG = ICUDebug.enabled("breakiterator");
    private static final CacheValue<?>[] iterCache = new CacheValue[5];

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class BreakIteratorCache {
        private BreakIterator iter;
        private ULocale where;

        public BreakIteratorCache(ULocale uLocale, BreakIterator breakIterator) {
            this.where = uLocale;
            this.iter = breakIterator.mo5clone();
        }

        public BreakIterator createBreakInstance() {
            return this.iter.mo5clone();
        }

        public ULocale getLocale() {
            return this.where;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static abstract class BreakIteratorServiceShim {
        public abstract BreakIterator createBreakIterator(ULocale uLocale, int i);

        public abstract Locale[] getAvailableLocales();

        public abstract ULocale[] getAvailableULocales();

        public abstract Object registerInstance(BreakIterator breakIterator, ULocale uLocale, int i);

        public abstract boolean unregister(Object obj);
    }

    public static synchronized Locale[] getAvailableLocales() {
        return getShim().getAvailableLocales();
    }

    public static synchronized ULocale[] getAvailableULocales() {
        return getShim().getAvailableULocales();
    }

    @Deprecated
    public static BreakIterator getBreakInstance(ULocale uLocale, int i) {
        BreakIteratorCache breakIteratorCache;
        if (uLocale == null) {
            dk0.n("Specified locale is null");
            return null;
        }
        CacheValue<?>[] cacheValueArr = iterCache;
        CacheValue<?> cacheValue = cacheValueArr[i];
        if (cacheValue != null && (breakIteratorCache = (BreakIteratorCache) cacheValue.get()) != null && breakIteratorCache.getLocale().equals(uLocale)) {
            return breakIteratorCache.createBreakInstance();
        }
        BreakIterator breakIteratorCreateBreakIterator = getShim().createBreakIterator(uLocale, i);
        cacheValueArr[i] = CacheValue.getInstance(new BreakIteratorCache(uLocale, breakIteratorCreateBreakIterator));
        return breakIteratorCreateBreakIterator;
    }

    public static BreakIterator getCharacterInstance(Locale locale) {
        return getBreakInstance(ULocale.forLocale(locale), 0);
    }

    public static BreakIterator getLineInstance(Locale locale) {
        return getBreakInstance(ULocale.forLocale(locale), 2);
    }

    public static BreakIterator getSentenceInstance(Locale locale) {
        return getBreakInstance(ULocale.forLocale(locale), 3);
    }

    private static BreakIteratorServiceShim getShim() {
        if (shim == null) {
            try {
                ICULocaleService iCULocaleService = BreakIteratorFactory.service;
                shim = (BreakIteratorServiceShim) BreakIteratorFactory.class.newInstance();
            } catch (MissingResourceException e) {
                throw e;
            } catch (Exception e2) {
                if (DEBUG) {
                    e2.printStackTrace();
                }
                og.p(e2.getMessage());
                return null;
            }
        }
        return shim;
    }

    @Deprecated
    public static BreakIterator getTitleInstance(Locale locale) {
        return getBreakInstance(ULocale.forLocale(locale), 4);
    }

    public static BreakIterator getWordInstance(Locale locale) {
        return getBreakInstance(ULocale.forLocale(locale), 1);
    }

    public static Object registerInstance(BreakIterator breakIterator, ULocale uLocale, int i) {
        BreakIteratorCache breakIteratorCache;
        CacheValue<?>[] cacheValueArr = iterCache;
        CacheValue<?> cacheValue = cacheValueArr[i];
        if (cacheValue != null && (breakIteratorCache = (BreakIteratorCache) cacheValue.get()) != null && breakIteratorCache.getLocale().equals(uLocale)) {
            cacheValueArr[i] = null;
        }
        return getShim().registerInstance(breakIterator, uLocale, i);
    }

    public static boolean unregister(Object obj) {
        if (obj == null) {
            og.i("registry key must not be null");
            return false;
        }
        if (shim == null) {
            return false;
        }
        for (int i = 0; i < 5; i++) {
            iterCache[i] = null;
        }
        return shim.unregister(obj);
    }

    @Override // 
    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public BreakIterator mo5clone() {
        try {
            return (BreakIterator) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new ICUCloneNotSupportedException(e);
        }
    }

    public abstract int current();

    public abstract int first();

    public abstract int following(int i);

    public final ULocale getLocale(ULocale.Type type) {
        return type == ULocale.ACTUAL_LOCALE ? this.actualLocale : this.validLocale;
    }

    public int getRuleStatus() {
        return 0;
    }

    public int getRuleStatusVec(int[] iArr) {
        if (iArr == null || iArr.length <= 0) {
            return 1;
        }
        iArr[0] = 0;
        return 1;
    }

    public abstract CharacterIterator getText();

    public boolean isBoundary(int i) {
        return i == 0 || following(i + (-1)) == i;
    }

    public abstract int last();

    public abstract int next();

    public abstract int next(int i);

    public int preceding(int i) {
        if (i < 0) {
            return -1;
        }
        int iFollowing = following(i);
        while (iFollowing >= i && iFollowing != -1) {
            iFollowing = previous();
        }
        return iFollowing;
    }

    public abstract int previous();

    public final void setLocale(ULocale uLocale, ULocale uLocale2) {
        if ((uLocale == null) != (uLocale2 == null)) {
            dk0.v();
        } else {
            this.validLocale = uLocale;
            this.actualLocale = uLocale2;
        }
    }

    public void setText(String str) {
        setText(new java.text.StringCharacterIterator(str));
    }

    public abstract void setText(CharacterIterator characterIterator);

    public void setText(CharSequence charSequence) {
        setText(new CSCharacterIterator(charSequence));
    }

    public static BreakIterator getCharacterInstance() {
        return getCharacterInstance(ULocale.getDefault());
    }

    public static BreakIterator getLineInstance() {
        return getLineInstance(ULocale.getDefault());
    }

    public static BreakIterator getSentenceInstance() {
        return getSentenceInstance(ULocale.getDefault());
    }

    @Deprecated
    public static BreakIterator getTitleInstance() {
        return getTitleInstance(ULocale.getDefault());
    }

    public static BreakIterator getWordInstance() {
        return getWordInstance(ULocale.getDefault());
    }

    public static BreakIterator getCharacterInstance(ULocale uLocale) {
        return getBreakInstance(uLocale, 0);
    }

    public static BreakIterator getLineInstance(ULocale uLocale) {
        return getBreakInstance(uLocale, 2);
    }

    public static BreakIterator getSentenceInstance(ULocale uLocale) {
        return getBreakInstance(uLocale, 3);
    }

    @Deprecated
    public static BreakIterator getTitleInstance(ULocale uLocale) {
        return getBreakInstance(uLocale, 4);
    }

    public static BreakIterator getWordInstance(ULocale uLocale) {
        return getBreakInstance(uLocale, 1);
    }

    public static Object registerInstance(BreakIterator breakIterator, Locale locale, int i) {
        return registerInstance(breakIterator, ULocale.forLocale(locale), i);
    }
}
