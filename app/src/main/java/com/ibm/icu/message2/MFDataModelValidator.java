package com.ibm.icu.message2;

import defpackage.cq;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringJoiner;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
class MFDataModelValidator {
    private final Set<String> declaredVars = new HashSet();
    private final MFDataModel.Message message;

    public MFDataModelValidator(MFDataModel.Message message) {
        this.message = message;
    }

    private boolean addVariableDeclaration(String str) throws MFParseException {
        if (this.declaredVars.contains(str)) {
            error(cq.v("Variable '", str, "' already declared"));
            return false;
        }
        this.declaredVars.add(str);
        return true;
    }

    private void error(String str) throws MFParseException {
        throw new MFParseException(str, -1);
    }

    private boolean validateDeclarations(List<MFDataModel.Declaration> list) throws MFParseException {
        if (list != null && !list.isEmpty()) {
            for (MFDataModel.Declaration declaration : list) {
                if (declaration instanceof MFDataModel.LocalDeclaration) {
                    MFDataModel.LocalDeclaration localDeclaration = (MFDataModel.LocalDeclaration) declaration;
                    validateExpression(localDeclaration.value, false);
                    addVariableDeclaration(localDeclaration.name);
                } else if (declaration instanceof MFDataModel.InputDeclaration) {
                    validateExpression(((MFDataModel.InputDeclaration) declaration).value, true);
                }
            }
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x002e  */
    /* JADX WARN: Type inference incomplete: some casts might be missing */
    private void validateExpression(MFDataModel.Expression expression, boolean z) throws MFParseException {
        String str;
        Map<String, MFDataModel.Option> map;
        MFDataModel.FunctionRef functionRef;
        MFDataModel.FunctionRef functionRef2 = null;
        String str2 = null;
        boolean z2 = false;
        if (expression instanceof MFDataModel.Literal) {
            str = null;
        } else {
            if (expression instanceof MFDataModel.LiteralExpression) {
                MFDataModel.LiteralExpression literalExpression = (MFDataModel.LiteralExpression) expression;
                str2 = literalExpression.arg.value;
                functionRef = literalExpression.function;
                z2 = true;
            } else if (expression instanceof MFDataModel.VariableExpression) {
                MFDataModel.VariableExpression variableExpression = (MFDataModel.VariableExpression) expression;
                str2 = variableExpression.arg.name;
                functionRef = variableExpression.function;
            } else if (expression instanceof MFDataModel.FunctionExpression) {
                functionRef = ((MFDataModel.FunctionExpression) expression).function;
            } else {
                str = null;
            }
            String str3 = str2;
            functionRef2 = functionRef;
            str = str3;
        }
        if (functionRef2 != null && (map = functionRef2.options) != null) {
            Iterator<MFDataModel.Option> it = map.values().iterator();
            while (it.hasNext()) {
                MFDataModel.LiteralOrVariableRef literalOrVariableRef = it.next().value;
                if (literalOrVariableRef instanceof MFDataModel.VariableRef) {
                    addVariableDeclaration(((MFDataModel.VariableRef) literalOrVariableRef).name);
                }
            }
        }
        if (str != null) {
            if (z) {
                addVariableDeclaration(str);
            } else {
                if (z2) {
                    return;
                }
                this.declaredVars.add(str);
            }
        }
    }

    private boolean validateSelectors(List<MFDataModel.Expression> list) throws MFParseException {
        if (list != null && !list.isEmpty()) {
            return true;
        }
        error("Selection messages must have selectors");
        return true;
    }

    private boolean validateVariants(List<MFDataModel.Variant> list, int i) throws MFParseException {
        if (list == null || list.isEmpty()) {
            error("Selection messages must have at least one variant");
        }
        HashSet hashSet = new HashSet();
        boolean z = false;
        for (MFDataModel.Variant variant : list) {
            List<MFDataModel.LiteralOrCatchallKey> list2 = variant.keys;
            if (list2 == null || list2.isEmpty()) {
                error("Selection variants must have at least one key");
            }
            if (variant.keys.size() != i) {
                error("Selection variants must have the same number of variants as the selectors.");
            }
            StringJoiner stringJoiner = new StringJoiner("<<::>>");
            int i2 = 0;
            for (MFDataModel.LiteralOrCatchallKey literalOrCatchallKey : variant.keys) {
                if (literalOrCatchallKey instanceof MFDataModel.CatchallKey) {
                    i2++;
                    stringJoiner.add("<<::CatchallKey::>>");
                } else if (literalOrCatchallKey instanceof MFDataModel.Literal) {
                    stringJoiner.add(((MFDataModel.Literal) literalOrCatchallKey).value);
                }
            }
            if (hashSet.contains(stringJoiner.toString())) {
                error("Dumplicate combination of keys");
            } else {
                hashSet.add(stringJoiner.toString());
            }
            if (i2 == i) {
                z = true;
            }
        }
        if (!z) {
            error("There must be one variant with all the keys being '*'");
        }
        return true;
    }

    public boolean validate() throws MFParseException {
        MFDataModel.Message message = this.message;
        if (message instanceof MFDataModel.PatternMessage) {
            validateDeclarations(((MFDataModel.PatternMessage) message).declarations);
            return true;
        }
        if (!(message instanceof MFDataModel.SelectMessage)) {
            return true;
        }
        MFDataModel.SelectMessage selectMessage = (MFDataModel.SelectMessage) message;
        validateDeclarations(selectMessage.declarations);
        validateSelectors(selectMessage.selectors);
        validateVariants(selectMessage.variants, selectMessage.selectors.size());
        return true;
    }
}
