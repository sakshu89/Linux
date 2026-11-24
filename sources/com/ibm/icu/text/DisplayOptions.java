package com.ibm.icu.text;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class DisplayOptions {
    private final Capitalization capitalization;
    private final DisplayLength displayLength;
    private final GrammaticalCase grammaticalCase;
    private final NameStyle nameStyle;
    private final NounClass nounClass;
    private final PluralCategory pluralCategory;
    private final SubstituteHandling substituteHandling;

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public enum Capitalization {
        UNDEFINED,
        BEGINNING_OF_SENTENCE,
        MIDDLE_OF_SENTENCE,
        STANDALONE,
        UI_LIST_OR_MENU;

        public static final List<Capitalization> VALUES = Collections.unmodifiableList(Arrays.asList(values()));
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public enum DisplayLength {
        UNDEFINED,
        LENGTH_FULL,
        LENGTH_SHORT;

        public static final List<DisplayLength> VALUES = Collections.unmodifiableList(Arrays.asList(values()));
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public enum GrammaticalCase {
        UNDEFINED("undefined"),
        ABLATIVE("ablative"),
        ACCUSATIVE("accusative"),
        COMITATIVE("comitative"),
        DATIVE("dative"),
        ERGATIVE("ergative"),
        GENITIVE("genitive"),
        INSTRUMENTAL("instrumental"),
        LOCATIVE("locative"),
        LOCATIVE_COPULATIVE("locative_copulative"),
        NOMINATIVE("nominative"),
        OBLIQUE("oblique"),
        PREPOSITIONAL("prepositional"),
        SOCIATIVE("sociative"),
        VOCATIVE("vocative");

        public static final List<GrammaticalCase> VALUES = Collections.unmodifiableList(Arrays.asList(values()));
        private final String identifier;

        GrammaticalCase(String str) {
            this.identifier = str;
        }

        public static final GrammaticalCase fromIdentifier(String str) {
            if (str == null) {
                return UNDEFINED;
            }
            for (GrammaticalCase grammaticalCase : VALUES) {
                if (str.equals(grammaticalCase.getIdentifier())) {
                    return grammaticalCase;
                }
            }
            return UNDEFINED;
        }

        public final String getIdentifier() {
            return this.identifier;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public enum NameStyle {
        UNDEFINED,
        STANDARD_NAMES,
        DIALECT_NAMES;

        public static final List<NameStyle> VALUES = Collections.unmodifiableList(Arrays.asList(values()));
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public enum NounClass {
        UNDEFINED("undefined"),
        OTHER(PluralRules.KEYWORD_OTHER),
        NEUTER("neuter"),
        FEMININE("feminine"),
        MASCULINE("masculine"),
        ANIMATE("animate"),
        INANIMATE("inanimate"),
        PERSONAL("personal"),
        COMMON("common");

        public static final List<NounClass> VALUES = Collections.unmodifiableList(Arrays.asList(values()));
        private final String identifier;

        NounClass(String str) {
            this.identifier = str;
        }

        public static final NounClass fromIdentifier(String str) {
            if (str == null) {
                return UNDEFINED;
            }
            for (NounClass nounClass : VALUES) {
                if (str.equals(nounClass.getIdentifier())) {
                    return nounClass;
                }
            }
            return UNDEFINED;
        }

        public final String getIdentifier() {
            return this.identifier;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public enum PluralCategory {
        UNDEFINED("undefined"),
        ZERO(PluralRules.KEYWORD_ZERO),
        ONE(PluralRules.KEYWORD_ONE),
        TWO(PluralRules.KEYWORD_TWO),
        FEW(PluralRules.KEYWORD_FEW),
        MANY(PluralRules.KEYWORD_MANY),
        OTHER(PluralRules.KEYWORD_OTHER);

        public static final List<PluralCategory> VALUES = Collections.unmodifiableList(Arrays.asList(values()));
        private final String identifier;

        PluralCategory(String str) {
            this.identifier = str;
        }

        public static final PluralCategory fromIdentifier(String str) {
            if (str == null) {
                return UNDEFINED;
            }
            for (PluralCategory pluralCategory : VALUES) {
                if (str.equals(pluralCategory.getIdentifier())) {
                    return pluralCategory;
                }
            }
            return UNDEFINED;
        }

        public final String getIdentifier() {
            return this.identifier;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public enum SubstituteHandling {
        UNDEFINED,
        SUBSTITUTE,
        NO_SUBSTITUTE;

        public static final List<SubstituteHandling> VALUES = Collections.unmodifiableList(Arrays.asList(values()));
    }

    private DisplayOptions(Builder builder) {
        this.grammaticalCase = builder.grammaticalCase;
        this.nounClass = builder.nounClass;
        this.pluralCategory = builder.pluralCategory;
        this.capitalization = builder.capitalization;
        this.nameStyle = builder.nameStyle;
        this.displayLength = builder.displayLength;
        this.substituteHandling = builder.substituteHandling;
    }

    public static Builder builder() {
        return new Builder(0);
    }

    public Builder copyToBuilder() {
        return new Builder(this, 0);
    }

    public Capitalization getCapitalization() {
        return this.capitalization;
    }

    public DisplayLength getDisplayLength() {
        return this.displayLength;
    }

    public GrammaticalCase getGrammaticalCase() {
        return this.grammaticalCase;
    }

    public NameStyle getNameStyle() {
        return this.nameStyle;
    }

    public NounClass getNounClass() {
        return this.nounClass;
    }

    public PluralCategory getPluralCategory() {
        return this.pluralCategory;
    }

    public SubstituteHandling getSubstituteHandling() {
        return this.substituteHandling;
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class Builder {
        private Capitalization capitalization;
        private DisplayLength displayLength;
        private GrammaticalCase grammaticalCase;
        private NameStyle nameStyle;
        private NounClass nounClass;
        private PluralCategory pluralCategory;
        private SubstituteHandling substituteHandling;

        private Builder(DisplayOptions displayOptions) {
            this.grammaticalCase = displayOptions.grammaticalCase;
            this.nounClass = displayOptions.nounClass;
            this.pluralCategory = displayOptions.pluralCategory;
            this.capitalization = displayOptions.capitalization;
            this.nameStyle = displayOptions.nameStyle;
            this.displayLength = displayOptions.displayLength;
            this.substituteHandling = displayOptions.substituteHandling;
        }

        public DisplayOptions build() {
            return new DisplayOptions(this, 0);
        }

        public Builder setCapitalization(Capitalization capitalization) {
            this.capitalization = capitalization;
            return this;
        }

        public Builder setDisplayLength(DisplayLength displayLength) {
            this.displayLength = displayLength;
            return this;
        }

        public Builder setGrammaticalCase(GrammaticalCase grammaticalCase) {
            this.grammaticalCase = grammaticalCase;
            return this;
        }

        public Builder setNameStyle(NameStyle nameStyle) {
            this.nameStyle = nameStyle;
            return this;
        }

        public Builder setNounClass(NounClass nounClass) {
            this.nounClass = nounClass;
            return this;
        }

        public Builder setPluralCategory(PluralCategory pluralCategory) {
            this.pluralCategory = pluralCategory;
            return this;
        }

        public Builder setSubstituteHandling(SubstituteHandling substituteHandling) {
            this.substituteHandling = substituteHandling;
            return this;
        }

        public /* synthetic */ Builder(DisplayOptions displayOptions, int i) {
            this(displayOptions);
        }

        private Builder() {
            this.grammaticalCase = GrammaticalCase.UNDEFINED;
            this.nounClass = NounClass.UNDEFINED;
            this.pluralCategory = PluralCategory.UNDEFINED;
            this.capitalization = Capitalization.UNDEFINED;
            this.nameStyle = NameStyle.UNDEFINED;
            this.displayLength = DisplayLength.UNDEFINED;
            this.substituteHandling = SubstituteHandling.UNDEFINED;
        }

        public /* synthetic */ Builder(int i) {
            this();
        }
    }

    public /* synthetic */ DisplayOptions(Builder builder, int i) {
        this(builder);
    }
}
