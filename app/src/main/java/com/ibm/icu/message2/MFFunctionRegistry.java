package com.ibm.icu.message2;

import com.ibm.icu.util.Calendar;
import com.ibm.icu.util.CurrencyAmount;
import java.time.DayOfWeek;
import java.time.Month;
import java.time.temporal.Temporal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class MFFunctionRegistry {
    private static final MFFunctionRegistry STANDARD_FUNCTIONS = initStandardFunctions();
    private final Map<Class<?>, String> classToFunction;
    private final Map<String, FunctionFactory> functionMap;

    private MFFunctionRegistry(Builder builder) {
        this.functionMap = new HashMap(builder.functionMap);
        this.classToFunction = new HashMap(builder.classToFunction);
    }

    @Deprecated
    public static Builder builder() {
        return new Builder(0);
    }

    @Deprecated
    public static MFFunctionRegistry getStandardFunctionsRegistry() {
        return STANDARD_FUNCTIONS;
    }

    private static MFFunctionRegistry initStandardFunctions() {
        return builder().setFunction("datetime", new DateTimeFunctionFactory("datetime")).setFunction("date", new DateTimeFunctionFactory("date")).setFunction("time", new DateTimeFunctionFactory("time")).setDefaultFunctionNameForType(Date.class, "datetime").setDefaultFunctionNameForType(Calendar.class, "datetime").setDefaultFunctionNameForType(java.util.Calendar.class, "datetime").setDefaultFunctionNameForType(Temporal.class, "datetime").setDefaultFunctionNameForType(DayOfWeek.class, "date").setDefaultFunctionNameForType(Month.class, "date").setFunction("number", new NumberFunctionFactory("number")).setFunction("integer", new NumberFunctionFactory("integer")).setFunction("currency", new NumberFunctionFactory("currency")).setFunction("percent", new NumberFunctionFactory("percent")).setFunction("offset", new NumberFunctionFactory("offset")).setDefaultFunctionNameForType(Integer.class, "number").setDefaultFunctionNameForType(Double.class, "number").setDefaultFunctionNameForType(Number.class, "number").setDefaultFunctionNameForType(CurrencyAmount.class, "currency").setFunction("string", new TextFunctionFactory()).setDefaultFunctionNameForType(String.class, "string").setDefaultFunctionNameForType(CharSequence.class, "string").setFunction("icu:gender", new TextFunctionFactory()).build();
    }

    @Deprecated
    public String getDefaultFunctionNameForType(Class<?> cls) {
        String str = this.classToFunction.get(cls);
        if (str != null) {
            return str;
        }
        for (Map.Entry<Class<?>, String> entry : this.classToFunction.entrySet()) {
            if (entry.getKey().isAssignableFrom(cls)) {
                return entry.getValue();
            }
        }
        return null;
    }

    @Deprecated
    public Set<Class<?>> getDefaultFunctionTypes() {
        return this.classToFunction.keySet();
    }

    @Deprecated
    public FunctionFactory getFunction(String str) {
        return this.functionMap.get(StringUtils.toNfc(str));
    }

    @Deprecated
    public Set<String> getFunctionNames() {
        return this.functionMap.keySet();
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    @Deprecated
    public static class Builder {
        private final Map<Class<?>, String> classToFunction;
        private final Map<String, FunctionFactory> functionMap;

        private Builder() {
            this.functionMap = new HashMap();
            this.classToFunction = new HashMap();
        }

        @Deprecated
        public Builder addAll(MFFunctionRegistry mFFunctionRegistry) {
            this.functionMap.putAll(mFFunctionRegistry.functionMap);
            this.classToFunction.putAll(mFFunctionRegistry.classToFunction);
            return this;
        }

        @Deprecated
        public MFFunctionRegistry build() {
            return new MFFunctionRegistry(this, 0);
        }

        @Deprecated
        public Builder clearDefaultFunctionNames() {
            this.classToFunction.clear();
            return this;
        }

        @Deprecated
        public Builder clearFunctions() {
            this.functionMap.clear();
            return this;
        }

        @Deprecated
        public Builder removeDefaultFunctionNameForType(Class<?> cls) {
            this.classToFunction.remove(cls);
            return this;
        }

        @Deprecated
        public Builder removeFunction(String str) {
            this.functionMap.remove(StringUtils.toNfc(str));
            return this;
        }

        @Deprecated
        public Builder setDefaultFunctionNameForType(Class<?> cls, String str) {
            this.classToFunction.put(cls, StringUtils.toNfc(str));
            return this;
        }

        @Deprecated
        public Builder setFunction(String str, FunctionFactory functionFactory) {
            this.functionMap.put(StringUtils.toNfc(str), functionFactory);
            return this;
        }

        public /* synthetic */ Builder(int i) {
            this();
        }
    }

    public /* synthetic */ MFFunctionRegistry(Builder builder, int i) {
        this(builder);
    }
}
