package com.ibm.icu.text;

import com.ibm.icu.impl.CaseMapImpl;
import com.ibm.icu.impl.UCaseProps;
import com.ibm.icu.lang.UProperty;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class CaseMap {

    @Deprecated
    protected int internalOptions;

    private CaseMap(int i) {
        this.internalOptions = i;
    }

    public static Fold fold() {
        return Fold.DEFAULT;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int getCaseLocale(Locale locale) {
        if (locale == null) {
            locale = Locale.getDefault();
        }
        return UCaseProps.getCaseLocale(locale);
    }

    public static Lower toLower() {
        return Lower.DEFAULT;
    }

    public static Title toTitle() {
        return Title.DEFAULT;
    }

    public static Upper toUpper() {
        return Upper.DEFAULT;
    }

    public abstract CaseMap omitUnchangedText();

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class Lower extends CaseMap {
        private static final Lower DEFAULT = new Lower(0);
        private static final Lower OMIT_UNCHANGED = new Lower(16384);

        private Lower(int i) {
            super(i, 0);
        }

        public String apply(Locale locale, CharSequence charSequence) {
            return CaseMapImpl.toLower(CaseMap.getCaseLocale(locale), this.internalOptions, charSequence);
        }

        @Override // com.ibm.icu.text.CaseMap
        public Lower omitUnchangedText() {
            return OMIT_UNCHANGED;
        }

        public <A extends Appendable> A apply(Locale locale, CharSequence charSequence, A a, Edits edits) {
            return (A) CaseMapImpl.toLower(CaseMap.getCaseLocale(locale), this.internalOptions, charSequence, a, edits);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class Upper extends CaseMap {
        private static final Upper DEFAULT = new Upper(0);
        private static final Upper OMIT_UNCHANGED = new Upper(16384);

        private Upper(int i) {
            super(i, 0);
        }

        public String apply(Locale locale, CharSequence charSequence) {
            return CaseMapImpl.toUpper(CaseMap.getCaseLocale(locale), this.internalOptions, charSequence);
        }

        @Override // com.ibm.icu.text.CaseMap
        public Upper omitUnchangedText() {
            return OMIT_UNCHANGED;
        }

        public <A extends Appendable> A apply(Locale locale, CharSequence charSequence, A a, Edits edits) {
            return (A) CaseMapImpl.toUpper(CaseMap.getCaseLocale(locale), this.internalOptions, charSequence, a, edits);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class Fold extends CaseMap {
        private static final Fold DEFAULT = new Fold(0);
        private static final Fold TURKIC = new Fold(1);
        private static final Fold OMIT_UNCHANGED = new Fold(16384);
        private static final Fold TURKIC_OMIT_UNCHANGED = new Fold(UProperty.BIDI_MIRRORING_GLYPH);

        private Fold(int i) {
            super(i, 0);
        }

        public String apply(CharSequence charSequence) {
            return CaseMapImpl.fold(this.internalOptions, charSequence);
        }

        @Override // com.ibm.icu.text.CaseMap
        public Fold omitUnchangedText() {
            return (this.internalOptions & 1) == 0 ? OMIT_UNCHANGED : TURKIC_OMIT_UNCHANGED;
        }

        public Fold turkic() {
            return (this.internalOptions & 16384) == 0 ? TURKIC : TURKIC_OMIT_UNCHANGED;
        }

        public <A extends Appendable> A apply(CharSequence charSequence, A a, Edits edits) {
            return (A) CaseMapImpl.fold(this.internalOptions, charSequence, a, edits);
        }
    }

    public /* synthetic */ CaseMap(int i, int i2) {
        this(i);
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class Title extends CaseMap {
        private static final Title DEFAULT = new Title(0);
        private static final Title OMIT_UNCHANGED = new Title(16384);

        private Title(int i) {
            super(i, 0);
        }

        public Title adjustToCased() {
            return new Title(CaseMapImpl.addTitleAdjustmentOption(this.internalOptions, 1024));
        }

        public <A extends Appendable> A apply(Locale locale, BreakIterator breakIterator, CharSequence charSequence, A a, Edits edits) {
            if (breakIterator == null && locale == null) {
                locale = Locale.getDefault();
            }
            BreakIterator titleBreakIterator = CaseMapImpl.getTitleBreakIterator(locale, this.internalOptions, breakIterator);
            titleBreakIterator.setText(charSequence);
            return (A) CaseMapImpl.toTitle(CaseMap.getCaseLocale(locale), this.internalOptions, titleBreakIterator, charSequence, a, edits);
        }

        public Title noBreakAdjustment() {
            return new Title(CaseMapImpl.addTitleAdjustmentOption(this.internalOptions, 512));
        }

        public Title noLowercase() {
            return new Title(this.internalOptions | 256);
        }

        @Override // com.ibm.icu.text.CaseMap
        public Title omitUnchangedText() {
            int i = this.internalOptions;
            return (i == 0 || i == 16384) ? OMIT_UNCHANGED : new Title(i | 16384);
        }

        public Title sentences() {
            return new Title(CaseMapImpl.addTitleIteratorOption(this.internalOptions, 64));
        }

        public Title wholeString() {
            return new Title(CaseMapImpl.addTitleIteratorOption(this.internalOptions, 32));
        }

        public String apply(Locale locale, BreakIterator breakIterator, CharSequence charSequence) {
            if (breakIterator == null && locale == null) {
                locale = Locale.getDefault();
            }
            BreakIterator titleBreakIterator = CaseMapImpl.getTitleBreakIterator(locale, this.internalOptions, breakIterator);
            titleBreakIterator.setText(charSequence);
            return CaseMapImpl.toTitle(CaseMap.getCaseLocale(locale), this.internalOptions, titleBreakIterator, charSequence);
        }
    }
}
