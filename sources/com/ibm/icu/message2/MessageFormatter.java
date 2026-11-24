package com.ibm.icu.message2;

import defpackage.ky0;
import defpackage.og;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class MessageFormatter {
    private final BidiIsolation bidiIsolation;
    private final MFDataModel.Message dataModel;
    private final ErrorHandlingBehavior errorHandlingBehavior;
    private final MFFunctionRegistry functionRegistry;
    private final Locale locale;
    private final MFDataModelFormatter modelFormatter;
    private final String pattern;

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public enum BidiIsolation {
        NONE,
        DEFAULT
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public enum ErrorHandlingBehavior {
        BEST_EFFORT,
        STRICT
    }

    private MessageFormatter(Builder builder) {
        Locale locale = builder.locale;
        this.locale = locale;
        MFFunctionRegistry mFFunctionRegistry = builder.functionRegistry;
        this.functionRegistry = mFFunctionRegistry;
        ErrorHandlingBehavior errorHandlingBehavior = builder.errorHandlingBehavior;
        this.errorHandlingBehavior = errorHandlingBehavior;
        BidiIsolation bidiIsolation = builder.bidiIsolation;
        this.bidiIsolation = bidiIsolation;
        if ((builder.pattern == null && builder.dataModel == null) || (builder.pattern != null && builder.dataModel != null)) {
            og.i("You need to set either a pattern, or a dataModel, but not both.");
            throw null;
        }
        if (builder.dataModel != null) {
            MFDataModel.Message message = builder.dataModel;
            this.dataModel = message;
            this.pattern = MFSerializer.dataModelToString(message);
        } else {
            String str = builder.pattern;
            this.pattern = str;
            try {
                this.dataModel = MFParser.parse(str);
            } catch (MFParseException e) {
                og.i(ky0.l("Parse error:\nMessage: <<", this.pattern, ">>\nError: ", e.getMessage(), "\n"));
                throw null;
            }
        }
        this.modelFormatter = new MFDataModelFormatter(this.dataModel, locale, errorHandlingBehavior, bidiIsolation, mFFunctionRegistry);
    }

    public static Builder builder() {
        return new Builder(0);
    }

    @Deprecated
    public FormattedMessage format(Map<String, ?> map) {
        throw new RuntimeException("Not yet implemented.");
    }

    public String formatToString(Map<String, ?> map) {
        return this.modelFormatter.format(map);
    }

    public BidiIsolation getBidiIsolation() {
        return this.bidiIsolation;
    }

    @Deprecated
    public MFDataModel.Message getDataModel() {
        return this.dataModel;
    }

    public ErrorHandlingBehavior getErrorHandlingBehavior() {
        return this.errorHandlingBehavior;
    }

    public Locale getLocale() {
        return this.locale;
    }

    public String getPattern() {
        return this.pattern;
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class Builder {
        private BidiIsolation bidiIsolation;
        private MFDataModel.Message dataModel;
        private ErrorHandlingBehavior errorHandlingBehavior;
        private MFFunctionRegistry functionRegistry;
        private Locale locale;
        private String pattern;

        private Builder() {
            this.locale = Locale.getDefault(Locale.Category.FORMAT);
            this.pattern = null;
            this.errorHandlingBehavior = ErrorHandlingBehavior.BEST_EFFORT;
            this.bidiIsolation = BidiIsolation.NONE;
            this.functionRegistry = MFFunctionRegistry.builder().build();
            this.dataModel = null;
        }

        public MessageFormatter build() {
            return new MessageFormatter(this, 0);
        }

        public Builder setBidiIsolation(BidiIsolation bidiIsolation) {
            this.bidiIsolation = bidiIsolation;
            return this;
        }

        @Deprecated
        public Builder setDataModel(MFDataModel.Message message) {
            this.dataModel = message;
            this.pattern = null;
            return this;
        }

        public Builder setErrorHandlingBehavior(ErrorHandlingBehavior errorHandlingBehavior) {
            this.errorHandlingBehavior = errorHandlingBehavior;
            return this;
        }

        @Deprecated
        public Builder setFunctionRegistry(MFFunctionRegistry mFFunctionRegistry) {
            this.functionRegistry = mFFunctionRegistry;
            return this;
        }

        public Builder setLocale(Locale locale) {
            this.locale = locale;
            return this;
        }

        public Builder setPattern(String str) {
            this.pattern = str;
            this.dataModel = null;
            return this;
        }

        public /* synthetic */ Builder(int i) {
            this();
        }
    }

    public /* synthetic */ MessageFormatter(Builder builder, int i) {
        this(builder);
    }
}
