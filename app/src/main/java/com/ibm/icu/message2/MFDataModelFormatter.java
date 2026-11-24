package com.ibm.icu.message2;

import defpackage.cq;
import defpackage.ky0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
class MFDataModelFormatter {
    private static final char FSI = 8296;
    private static final char LRI = 8294;
    private static final char PDI = 8297;
    private static final char RLI = 8295;
    private final MessageFormatter.BidiIsolation bidiIsolation;
    private final MFFunctionRegistry customFunctions;
    private final MFDataModel.Message dm;
    private final MessageFormatter.ErrorHandlingBehavior errorHandlingBehavior;
    private final Locale locale;
    private static final MFFunctionRegistry standardFunctions = MFFunctionRegistry.getStandardFunctionsRegistry();
    private static final MFFunctionRegistry EMPTY_REGISTY = MFFunctionRegistry.builder().build();

    /* JADX INFO: renamed from: com.ibm.icu.message2.MFDataModelFormatter$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ibm$icu$message2$Directionality;

        static {
            int[] iArr = new int[Directionality.values().length];
            $SwitchMap$com$ibm$icu$message2$Directionality = iArr;
            try {
                iArr[Directionality.LTR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ibm$icu$message2$Directionality[Directionality.RTL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class IntVarTuple {
        int integer;
        final MFDataModel.Variant variant;

        public IntVarTuple(int i, MFDataModel.Variant variant) {
            this.integer = i;
            this.variant = variant;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class ResolvedExpression implements MFDataModel.Expression {
        final Object argument;
        final String functionName;
        final Map<String, ?> options;

        public ResolvedExpression(Object obj, String str, Map<String, ?> map) {
            this.argument = obj;
            this.functionName = StringUtils.toNfc(str);
            this.options = map;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class ResolvedSelector {
        final Object argument;
        final MapWithNfcKeys options;
        final Function selectorFunction;

        public ResolvedSelector(Object obj, MapWithNfcKeys mapWithNfcKeys, Function function) {
            this.argument = obj;
            this.options = new MapWithNfcKeys(mapWithNfcKeys);
            this.selectorFunction = function;
        }
    }

    public MFDataModelFormatter(MFDataModel.Message message, Locale locale, MessageFormatter.ErrorHandlingBehavior errorHandlingBehavior, MessageFormatter.BidiIsolation bidiIsolation, MFFunctionRegistry mFFunctionRegistry) {
        this.locale = locale;
        this.errorHandlingBehavior = errorHandlingBehavior == null ? MessageFormatter.ErrorHandlingBehavior.BEST_EFFORT : errorHandlingBehavior;
        this.bidiIsolation = bidiIsolation == null ? MessageFormatter.BidiIsolation.NONE : bidiIsolation;
        this.dm = message;
        this.customFunctions = mFFunctionRegistry == null ? EMPTY_REGISTY : mFFunctionRegistry;
    }

    private static MapWithNfcKeys convertOptions(Map<String, MFDataModel.Option> map, MapWithNfcKeys mapWithNfcKeys, MapWithNfcKeys mapWithNfcKeys2) {
        MapWithNfcKeys mapWithNfcKeys3 = new MapWithNfcKeys();
        for (MFDataModel.Option option : map.values()) {
            mapWithNfcKeys3.put(option.name, resolveLiteralOrVariable(option.value, mapWithNfcKeys, mapWithNfcKeys2));
        }
        return mapWithNfcKeys3;
    }

    private static void fatalFormattingError(String str) {
        throw new IllegalArgumentException(str);
    }

    private MFDataModel.Pattern findBestMatchingPattern(MFDataModel.SelectMessage selectMessage, MapWithNfcKeys mapWithNfcKeys, MapWithNfcKeys mapWithNfcKeys2) {
        int iIndexOf;
        Object objResolveLiteralOrVariable;
        List<MFDataModel.Expression> list = selectMessage.selectors;
        ArrayList arrayList = new ArrayList(list.size());
        for (MFDataModel.Expression expression : list) {
            String str = null;
            FormattedPlaceholder expression2 = expression instanceof MFDataModel.VariableExpression ? (FormattedPlaceholder) mapWithNfcKeys.get(((MFDataModel.VariableExpression) expression).arg.name) : null;
            if (expression2 == null) {
                expression2 = formatExpression(expression, mapWithNfcKeys, mapWithNfcKeys2);
            }
            MapWithNfcKeys mapWithNfcKeys3 = new MapWithNfcKeys();
            if (expression2.getInput() instanceof ResolvedExpression) {
                ResolvedExpression resolvedExpression = (ResolvedExpression) expression2.getInput();
                Object obj = resolvedExpression.argument;
                String str2 = resolvedExpression.functionName;
                mapWithNfcKeys3.putAll(resolvedExpression.options);
                objResolveLiteralOrVariable = obj;
                str = str2;
            } else if (expression2.getInput() instanceof MFDataModel.VariableExpression) {
                MFDataModel.VariableExpression variableExpression = (MFDataModel.VariableExpression) expression2.getInput();
                objResolveLiteralOrVariable = resolveLiteralOrVariable(variableExpression.arg, mapWithNfcKeys, mapWithNfcKeys2);
                if (variableExpression.function != null) {
                    str = variableExpression.function.name;
                }
            } else if (expression2.getInput() instanceof MFDataModel.LiteralExpression) {
                MFDataModel.LiteralExpression literalExpression = (MFDataModel.LiteralExpression) expression2.getInput();
                objResolveLiteralOrVariable = literalExpression.arg;
                if (literalExpression.function != null) {
                    str = literalExpression.function.name;
                }
            } else {
                objResolveLiteralOrVariable = null;
            }
            FunctionFactory function = this.customFunctions.getFunction(str);
            if (function == null) {
                function = standardFunctions.getFunction(str);
            }
            if (function != null) {
                arrayList.add(new ResolvedSelector(objResolveLiteralOrVariable, mapWithNfcKeys3, function.create(this.locale, mapWithNfcKeys3.getMap())));
            } else {
                fatalFormattingError(cq.j("Unknown selector type: ", str));
            }
        }
        if (arrayList.size() != list.size()) {
            fatalFormattingError(ky0.i("Something went wrong, not enough selector functions, ", arrayList.size(), list.size(), " vs. "));
        }
        ArrayList arrayList2 = new ArrayList();
        int i = 0;
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            ArrayList arrayList3 = new ArrayList();
            Iterator<MFDataModel.Variant> it = selectMessage.variants.iterator();
            while (it.hasNext()) {
                MFDataModel.LiteralOrCatchallKey literalOrCatchallKey = it.next().keys.get(i2);
                if (literalOrCatchallKey instanceof MFDataModel.CatchallKey) {
                    arrayList3.add("<<::CatchallKey::>>");
                } else if (literalOrCatchallKey instanceof MFDataModel.Literal) {
                    arrayList3.add(((MFDataModel.Literal) literalOrCatchallKey).value);
                } else {
                    fatalFormattingError("Literal expected, but got ".concat(String.valueOf(literalOrCatchallKey)));
                }
            }
            arrayList2.add(matchSelectorKeys((ResolvedSelector) arrayList.get(i2), arrayList3));
        }
        ArrayList arrayList4 = new ArrayList();
        for (MFDataModel.Variant variant : selectMessage.variants) {
            int i3 = 0;
            for (int i4 = 0; i4 < arrayList2.size(); i4++) {
                MFDataModel.LiteralOrCatchallKey literalOrCatchallKey2 = variant.keys.get(i4);
                if (!(literalOrCatchallKey2 instanceof MFDataModel.CatchallKey)) {
                    if (!(literalOrCatchallKey2 instanceof MFDataModel.Literal)) {
                        fatalFormattingError("Literal expected");
                    }
                    if (!((List) arrayList2.get(i4)).contains(((MFDataModel.Literal) literalOrCatchallKey2).value)) {
                        break;
                    }
                }
                i3++;
            }
            if (i3 == arrayList2.size()) {
                arrayList4.add(variant);
            }
        }
        ArrayList arrayList5 = new ArrayList();
        int size = arrayList4.size();
        int i5 = 0;
        while (i5 < size) {
            Object obj2 = arrayList4.get(i5);
            i5++;
            arrayList5.add(new IntVarTuple(-1, (MFDataModel.Variant) obj2));
        }
        for (int size2 = arrayList2.size() - 1; size2 >= 0; size2--) {
            List list2 = (List) arrayList2.get(size2);
            int size3 = list2.size();
            int size4 = arrayList5.size();
            int i6 = 0;
            while (i6 < size4) {
                Object obj3 = arrayList5.get(i6);
                i6++;
                IntVarTuple intVarTuple = (IntVarTuple) obj3;
                MFDataModel.LiteralOrCatchallKey literalOrCatchallKey3 = intVarTuple.variant.keys.get(size2);
                if (literalOrCatchallKey3 instanceof MFDataModel.CatchallKey) {
                    iIndexOf = size3;
                } else {
                    if (!(literalOrCatchallKey3 instanceof MFDataModel.Literal)) {
                        fatalFormattingError("Literal expected");
                    }
                    iIndexOf = list2.indexOf(((MFDataModel.Literal) literalOrCatchallKey3).value);
                }
                intVarTuple.integer = iIndexOf;
            }
            arrayList5.sort(new a(i));
        }
        MFDataModel.Pattern pattern = ((IntVarTuple) arrayList5.get(0)).variant.value;
        if (pattern == null) {
            fatalFormattingError("The selection went wrong, cannot select any option.");
        }
        return pattern;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x006d A[PHI: r1 r2 r4
      0x006d: PHI (r1v16 java.lang.Object) = (r1v12 java.lang.Object), (r1v23 java.lang.Object), (r1v25 java.lang.Object) binds: [B:14:0x0056, B:5:0x0023, B:7:0x002d] A[DONT_GENERATE, DONT_INLINE]
      0x006d: PHI (r2v7 java.lang.String) = (r2v5 java.lang.String), (r2v11 java.lang.String), (r2v11 java.lang.String) binds: [B:14:0x0056, B:5:0x0023, B:7:0x002d] A[DONT_GENERATE, DONT_INLINE]
      0x006d: PHI (r4v5 com.ibm.icu.message2.MFDataModel$FunctionRef) = 
      (r4v1 com.ibm.icu.message2.MFDataModel$FunctionRef)
      (r4v12 com.ibm.icu.message2.MFDataModel$FunctionRef)
      (r4v12 com.ibm.icu.message2.MFDataModel$FunctionRef)
     binds: [B:14:0x0056, B:5:0x0023, B:7:0x002d] A[DONT_GENERATE, DONT_INLINE]] */
    private FormattedPlaceholder formatExpression(MFDataModel.Expression expression, MapWithNfcKeys mapWithNfcKeys, MapWithNfcKeys mapWithNfcKeys2) {
        String strV;
        Object objResolveLiteralOrVariable;
        MFDataModel.FunctionRef functionRef;
        String str;
        HashMap map = new HashMap();
        if (expression instanceof MFDataModel.VariableExpression) {
            MFDataModel.VariableExpression variableExpression = (MFDataModel.VariableExpression) expression;
            strV = cq.v("{$", variableExpression.arg.name, "}");
            functionRef = variableExpression.function;
            objResolveLiteralOrVariable = resolveLiteralOrVariable(variableExpression.arg, mapWithNfcKeys, mapWithNfcKeys2);
            if (objResolveLiteralOrVariable instanceof FormattedPlaceholder) {
                objResolveLiteralOrVariable = ((FormattedPlaceholder) objResolveLiteralOrVariable).getInput();
                if (objResolveLiteralOrVariable instanceof ResolvedExpression) {
                    ResolvedExpression resolvedExpression = (ResolvedExpression) objResolveLiteralOrVariable;
                    Object obj = resolvedExpression.argument;
                    str = resolvedExpression.functionName;
                    map.putAll(resolvedExpression.options);
                    objResolveLiteralOrVariable = obj;
                } else {
                    str = null;
                }
            } else {
                str = null;
            }
        } else if (expression instanceof MFDataModel.FunctionExpression) {
            MFDataModel.FunctionExpression functionExpression = (MFDataModel.FunctionExpression) expression;
            strV = cq.v("{:", functionExpression.function.name, "}");
            functionRef = functionExpression.function;
            objResolveLiteralOrVariable = null;
            str = null;
        } else if (expression instanceof MFDataModel.LiteralExpression) {
            MFDataModel.LiteralExpression literalExpression = (MFDataModel.LiteralExpression) expression;
            functionRef = literalExpression.function;
            strV = cq.v("{|", literalExpression.arg.value, "|}");
            objResolveLiteralOrVariable = resolveLiteralOrVariable(literalExpression.arg, mapWithNfcKeys, mapWithNfcKeys2);
            str = null;
        } else {
            if (expression instanceof MFDataModel.Markup) {
                return new FormattedPlaceholder(expression, new PlainStringFormattedValue(""));
            }
            if (expression == null) {
                fatalFormattingError("unexpected null expression");
            } else {
                fatalFormattingError("unknown expression type ".concat(expression.getClass().getName()));
            }
            strV = "{�}";
            objResolveLiteralOrVariable = null;
            functionRef = null;
            str = null;
        }
        if (functionRef != null) {
            str = functionRef.name;
            map.putAll(convertOptions(functionRef.options, mapWithNfcKeys, mapWithNfcKeys2).getMap());
        }
        FunctionFactory formattingFunctionFactoryByName = getFormattingFunctionFactoryByName(objResolveLiteralOrVariable, str);
        MessageFormatter.ErrorHandlingBehavior errorHandlingBehavior = this.errorHandlingBehavior;
        if (formattingFunctionFactoryByName == null) {
            if (errorHandlingBehavior == MessageFormatter.ErrorHandlingBehavior.STRICT) {
                fatalFormattingError("unable to find function at ".concat(strV));
            }
            return new FormattedPlaceholder(expression, new PlainStringFormattedValue(strV));
        }
        map.put("icu:impl:errorPolicy", errorHandlingBehavior.name());
        FormattedPlaceholder formattedPlaceholder = formattingFunctionFactoryByName.create(this.locale, map).format(objResolveLiteralOrVariable, mapWithNfcKeys2.getMap());
        String string = formattedPlaceholder != null ? formattedPlaceholder.toString() : null;
        if (string != null) {
            strV = string;
        } else if (this.errorHandlingBehavior == MessageFormatter.ErrorHandlingBehavior.STRICT) {
            fatalFormattingError("unable to format string at ".concat(strV));
        }
        if (formattedPlaceholder != null) {
            objResolveLiteralOrVariable = formattedPlaceholder.getInput();
        }
        ResolvedExpression resolvedExpression2 = new ResolvedExpression(objResolveLiteralOrVariable, str, map);
        return formattedPlaceholder == null ? new FormattedPlaceholder(resolvedExpression2, new PlainStringFormattedValue(strV)) : new FormattedPlaceholder(resolvedExpression2, new PlainStringFormattedValue(strV), formattedPlaceholder.getDirectionality(), formattedPlaceholder.getIsolate());
    }

    private FunctionFactory getFormattingFunctionFactoryByName(Object obj, String str) {
        if (str == null || str.isEmpty()) {
            if (obj == null) {
                return null;
            }
            Class<?> cls = obj.getClass();
            String defaultFunctionNameForType = this.customFunctions.getDefaultFunctionNameForType(cls);
            str = defaultFunctionNameForType == null ? standardFunctions.getDefaultFunctionNameForType(cls) : defaultFunctionNameForType;
            if (str == null) {
                fatalFormattingError("Object to format without a function, and unknown type: ".concat(obj.getClass().getName()));
            }
        }
        FunctionFactory function = this.customFunctions.getFunction(str);
        return function == null ? standardFunctions.getFunction(str) : function;
    }

    private void implementBiDiDefault(StringBuilder sb, Directionality directionality, FormattedPlaceholder formattedPlaceholder) {
        String string = formattedPlaceholder.getFormattedValue().toString();
        Directionality directionality2 = formattedPlaceholder.getDirectionality();
        boolean isolate = formattedPlaceholder.getIsolate();
        int i = AnonymousClass1.$SwitchMap$com$ibm$icu$message2$Directionality[directionality2.ordinal()];
        if (i == 1) {
            if (directionality == Directionality.LTR && !isolate) {
                sb.append(string);
                return;
            }
            sb.append(LRI);
            sb.append(string);
            sb.append(PDI);
            return;
        }
        if (i != 2) {
            sb.append(FSI);
            sb.append(string);
            sb.append(PDI);
        } else {
            sb.append(RLI);
            sb.append(string);
            sb.append(PDI);
        }
    }

    private List<String> matchSelectorKeys(ResolvedSelector resolvedSelector, List<String> list) {
        return resolvedSelector.selectorFunction.matches(resolvedSelector.argument, list, resolvedSelector.options.getMap());
    }

    private MapWithNfcKeys resolveDeclarations(List<MFDataModel.Declaration> list, MapWithNfcKeys mapWithNfcKeys) {
        String str;
        MFDataModel.Expression expression;
        MapWithNfcKeys mapWithNfcKeys2 = new MapWithNfcKeys();
        if (list != null) {
            for (MFDataModel.Declaration declaration : list) {
                try {
                    if (declaration instanceof MFDataModel.InputDeclaration) {
                        MFDataModel.InputDeclaration inputDeclaration = (MFDataModel.InputDeclaration) declaration;
                        str = inputDeclaration.name;
                        expression = inputDeclaration.value;
                    } else if (declaration instanceof MFDataModel.LocalDeclaration) {
                        MFDataModel.LocalDeclaration localDeclaration = (MFDataModel.LocalDeclaration) declaration;
                        str = localDeclaration.name;
                        expression = localDeclaration.value;
                    } else {
                        continue;
                    }
                    mapWithNfcKeys2.put(StringUtils.toNfc(str), formatExpression(expression, mapWithNfcKeys2, mapWithNfcKeys));
                } catch (IllegalArgumentException e) {
                    if (this.errorHandlingBehavior == MessageFormatter.ErrorHandlingBehavior.STRICT) {
                        throw e;
                    }
                } catch (Exception unused) {
                }
            }
        }
        return mapWithNfcKeys2;
    }

    private static Object resolveLiteralOrVariable(MFDataModel.LiteralOrVariableRef literalOrVariableRef, MapWithNfcKeys mapWithNfcKeys, MapWithNfcKeys mapWithNfcKeys2) {
        if (literalOrVariableRef instanceof MFDataModel.Literal) {
            return ((MFDataModel.Literal) literalOrVariableRef).value;
        }
        if (!(literalOrVariableRef instanceof MFDataModel.VariableRef)) {
            return literalOrVariableRef;
        }
        String str = ((MFDataModel.VariableRef) literalOrVariableRef).name;
        Object obj = mapWithNfcKeys.get(str);
        if (obj == null) {
            obj = mapWithNfcKeys.get(str);
        }
        return obj == null ? mapWithNfcKeys2.get(StringUtils.toNfc(str)) : obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int sortVariants(IntVarTuple intVarTuple, IntVarTuple intVarTuple2) {
        int iCompare = Integer.compare(intVarTuple.integer, intVarTuple2.integer);
        if (iCompare != 0) {
            return iCompare;
        }
        List<MFDataModel.LiteralOrCatchallKey> list = intVarTuple.variant.keys;
        if (list.size() != list.size()) {
            fatalFormattingError("The number of keys is not equal.");
        }
        for (int i = 0; i < list.size(); i++) {
            MFDataModel.LiteralOrCatchallKey literalOrCatchallKey = list.get(i);
            MFDataModel.LiteralOrCatchallKey literalOrCatchallKey2 = list.get(i);
            int iCompareTo = (literalOrCatchallKey instanceof MFDataModel.Literal ? ((MFDataModel.Literal) literalOrCatchallKey).value : "<<::CatchallKey::>>").compareTo(literalOrCatchallKey2 instanceof MFDataModel.Literal ? ((MFDataModel.Literal) literalOrCatchallKey2).value : "<<::CatchallKey::>>");
            if (iCompareTo != 0) {
                return iCompareTo;
            }
        }
        return 0;
    }

    public String format(Map<String, ?> map) {
        MapWithNfcKeys mapWithNfcKeysResolveDeclarations;
        MFDataModel.Pattern patternFindBestMatchingPattern;
        MapWithNfcKeys mapWithNfcKeys = new MapWithNfcKeys(map);
        MFDataModel.Message message = this.dm;
        if (message instanceof MFDataModel.PatternMessage) {
            MFDataModel.PatternMessage patternMessage = (MFDataModel.PatternMessage) message;
            mapWithNfcKeysResolveDeclarations = resolveDeclarations(patternMessage.declarations, mapWithNfcKeys);
            if (patternMessage.pattern == null) {
                fatalFormattingError("The PatternMessage is null.");
            }
            patternFindBestMatchingPattern = patternMessage.pattern;
        } else {
            if (!(message instanceof MFDataModel.SelectMessage)) {
                fatalFormattingError("Unknown message type.");
                return "ERROR!";
            }
            MFDataModel.SelectMessage selectMessage = (MFDataModel.SelectMessage) message;
            mapWithNfcKeysResolveDeclarations = resolveDeclarations(selectMessage.declarations, mapWithNfcKeys);
            patternFindBestMatchingPattern = findBestMatchingPattern(selectMessage, mapWithNfcKeysResolveDeclarations, mapWithNfcKeys);
            if (patternFindBestMatchingPattern == null) {
                fatalFormattingError("Cannor find a match for the selector.");
            }
        }
        Directionality directionality = Directionality.LTR;
        StringBuilder sb = new StringBuilder();
        for (MFDataModel.PatternPart patternPart : patternFindBestMatchingPattern.parts) {
            if (patternPart instanceof MFDataModel.StringPart) {
                sb.append(((MFDataModel.StringPart) patternPart).value);
            } else if (patternPart instanceof MFDataModel.Expression) {
                FormattedPlaceholder expression = formatExpression((MFDataModel.Expression) patternPart, mapWithNfcKeysResolveDeclarations, mapWithNfcKeys);
                if (this.bidiIsolation == MessageFormatter.BidiIsolation.DEFAULT) {
                    implementBiDiDefault(sb, directionality, expression);
                } else {
                    sb.append(expression.getFormattedValue().toString());
                }
            } else if (!(patternPart instanceof MFDataModel.Markup)) {
                fatalFormattingError("Unknown part type: ".concat(String.valueOf(patternPart)));
            }
        }
        return sb.toString();
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class MapWithNfcKeys {
        private final Map<String, Object> theMap;

        public MapWithNfcKeys(Map<String, ?> map) {
            this.theMap = new HashMap();
            if (map != null) {
                for (Map.Entry<String, ?> entry : map.entrySet()) {
                    put(StringUtils.toNfc(entry.getKey()), entry.getValue());
                }
            }
        }

        public Object get(String str) {
            return this.theMap.get(str);
        }

        public Map<String, ?> getMap() {
            return this.theMap;
        }

        public Object put(String str, Object obj) {
            return this.theMap.put(StringUtils.toNfc(str), obj);
        }

        public void putAll(Map<? extends String, ?> map) {
            this.theMap.putAll(map);
        }

        public MapWithNfcKeys(MapWithNfcKeys mapWithNfcKeys) {
            HashMap map = new HashMap();
            this.theMap = map;
            map.putAll(mapWithNfcKeys.getMap());
        }

        public MapWithNfcKeys() {
            this.theMap = new HashMap();
        }
    }
}
