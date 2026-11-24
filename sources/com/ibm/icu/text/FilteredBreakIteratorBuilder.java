package com.ibm.icu.text;

import com.ibm.icu.impl.SimpleFilteredSentenceBreakIterator;
import com.ibm.icu.util.ULocale;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class FilteredBreakIteratorBuilder {
    @Deprecated
    public FilteredBreakIteratorBuilder() {
    }

    public static final FilteredBreakIteratorBuilder getEmptyInstance() {
        return new SimpleFilteredSentenceBreakIterator.Builder();
    }

    public static final FilteredBreakIteratorBuilder getInstance(Locale locale) {
        return new SimpleFilteredSentenceBreakIterator.Builder(locale);
    }

    public abstract boolean suppressBreakAfter(CharSequence charSequence);

    public abstract boolean unsuppressBreakAfter(CharSequence charSequence);

    public abstract BreakIterator wrapIteratorWithFilter(BreakIterator breakIterator);

    public static final FilteredBreakIteratorBuilder getInstance(ULocale uLocale) {
        return new SimpleFilteredSentenceBreakIterator.Builder(uLocale);
    }
}
