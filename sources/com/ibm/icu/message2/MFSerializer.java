package com.ibm.icu.message2;

import com.ibm.icu.impl.PatternTokenizer;
import defpackage.cq;
import defpackage.ky0;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class MFSerializer {
    private boolean shouldDoubleQuotePattern = false;
    private boolean needSpace = false;
    private final StringBuilder result = new StringBuilder();

    @Deprecated
    public MFSerializer() {
    }

    private void addSpaceIfNeeded() {
        if (this.needSpace) {
            this.result.append(' ');
            this.needSpace = false;
        }
    }

    private void attributesToString(List<MFDataModel.Attribute> list) {
        if (list == null) {
            return;
        }
        for (MFDataModel.Attribute attribute : list) {
            this.result.append(" @");
            this.result.append(attribute.name);
            if (attribute.value != null) {
                this.result.append('=');
                literalOrVariableRefToString(attribute.value);
            }
        }
    }

    @Deprecated
    public static String dataModelToString(MFDataModel.Message message) {
        return new MFSerializer().messageToString(message);
    }

    private void declarationsToString(List<MFDataModel.Declaration> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        this.shouldDoubleQuotePattern = true;
        for (MFDataModel.Declaration declaration : list) {
            if (declaration instanceof MFDataModel.LocalDeclaration) {
                localDeclarationToString((MFDataModel.LocalDeclaration) declaration);
            } else if (declaration instanceof MFDataModel.InputDeclaration) {
                inputDeclarationToString((MFDataModel.InputDeclaration) declaration);
            } else {
                errorType("Declaration", declaration);
            }
        }
    }

    private void error(String str, Object obj) {
        error(ky0.j(str, obj.getClass().getName()));
    }

    private void errorType(String str, Object obj) {
        error(cq.v("Unexpected '", str, "' type: "), obj);
    }

    private void expressionToString(MFDataModel.Expression expression) {
        if (expression == null) {
            return;
        }
        if (expression instanceof MFDataModel.LiteralExpression) {
            literalExpressionToString((MFDataModel.LiteralExpression) expression);
            return;
        }
        if (expression instanceof MFDataModel.VariableExpression) {
            variableExpressionToString((MFDataModel.VariableExpression) expression);
            return;
        }
        if (expression instanceof MFDataModel.FunctionExpression) {
            functionExpressionToString((MFDataModel.FunctionExpression) expression);
        } else if (expression instanceof MFDataModel.Markup) {
            markupToString((MFDataModel.Markup) expression);
        } else {
            errorType("Expression", expression);
        }
    }

    private void functionExpressionToString(MFDataModel.FunctionExpression functionExpression) {
        this.result.append('{');
        functionToString(functionExpression.function);
        attributesToString(functionExpression.attributes);
        this.result.append('}');
    }

    private void functionToString(MFDataModel.FunctionRef functionRef) {
        if (functionRef == null) {
            return;
        }
        addSpaceIfNeeded();
        this.result.append(":");
        this.result.append(functionRef.name);
        optionsToString(functionRef.options);
    }

    private void inputDeclarationToString(MFDataModel.InputDeclaration inputDeclaration) {
        addSpaceIfNeeded();
        this.result.append(".input ");
        variableExpressionToString(inputDeclaration.value);
        this.needSpace = true;
    }

    private void literalExpressionToString(MFDataModel.LiteralExpression literalExpression) {
        this.result.append('{');
        literalOrVariableRefToString(literalExpression.arg);
        this.needSpace = true;
        functionToString(literalExpression.function);
        attributesToString(literalExpression.attributes);
        this.result.append('}');
    }

    private void literalOrVariableRefToString(MFDataModel.LiteralOrVariableRef literalOrVariableRef) {
        if (literalOrVariableRef instanceof MFDataModel.Literal) {
            literalToString((MFDataModel.Literal) literalOrVariableRef);
            return;
        }
        if (!(literalOrVariableRef instanceof MFDataModel.VariableRef)) {
            errorType("LiteralOrVariableRef", literalOrVariableRef);
            return;
        }
        this.result.append("$" + ((MFDataModel.VariableRef) literalOrVariableRef).name);
    }

    private void literalToString(MFDataModel.Literal literal) {
        String str = literal.value;
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        int iCharCount = 0;
        while (iCharCount < str.length()) {
            int iCodePointAt = str.codePointAt(iCharCount);
            if (iCodePointAt == 92 || iCodePointAt == 124) {
                sb.append(PatternTokenizer.BACK_SLASH);
            }
            sb.append(new String(Character.toChars(iCodePointAt)));
            if (!StringUtils.isNameChar(iCodePointAt)) {
                z = false;
            }
            iCharCount += Character.charCount(iCodePointAt);
        }
        if (z && sb.length() != 0) {
            this.result.append((CharSequence) sb);
            return;
        }
        this.result.append('|');
        this.result.append((CharSequence) sb);
        this.result.append('|');
    }

    private void localDeclarationToString(MFDataModel.LocalDeclaration localDeclaration) {
        addSpaceIfNeeded();
        this.result.append(".local $");
        this.result.append(localDeclaration.name);
        this.result.append(" = ");
        expressionToString(localDeclaration.value);
        this.needSpace = true;
    }

    private void markupToString(MFDataModel.Markup markup) {
        this.result.append('{');
        MFDataModel.Markup.Kind kind = markup.kind;
        MFDataModel.Markup.Kind kind2 = MFDataModel.Markup.Kind.CLOSE;
        StringBuilder sb = this.result;
        if (kind == kind2) {
            sb.append('/');
        } else {
            sb.append('#');
        }
        this.result.append(markup.name);
        optionsToString(markup.options);
        attributesToString(markup.attributes);
        if (markup.kind == MFDataModel.Markup.Kind.STANDALONE) {
            this.result.append('/');
        }
        this.result.append('}');
    }

    private String messageToString(MFDataModel.Message message) {
        if (message instanceof MFDataModel.PatternMessage) {
            patternMessageToString((MFDataModel.PatternMessage) message);
        } else if (message instanceof MFDataModel.SelectMessage) {
            selectMessageToString((MFDataModel.SelectMessage) message);
        } else {
            errorType("Message", message);
        }
        return this.result.toString();
    }

    private void optionsToString(Map<String, MFDataModel.Option> map) {
        for (MFDataModel.Option option : map.values()) {
            this.result.append(' ');
            this.result.append(option.name);
            this.result.append('=');
            literalOrVariableRefToString(option.value);
        }
    }

    private void patternMessageToString(MFDataModel.PatternMessage patternMessage) {
        declarationsToString(patternMessage.declarations);
        patternToString(patternMessage.pattern);
    }

    private void patternToString(MFDataModel.Pattern pattern) {
        addSpaceIfNeeded();
        if (this.shouldDoubleQuotePattern) {
            this.result.append("{{");
        }
        for (MFDataModel.PatternPart patternPart : pattern.parts) {
            if (patternPart instanceof MFDataModel.StringPart) {
                stringPartToString((MFDataModel.StringPart) patternPart);
            } else {
                expressionToString((MFDataModel.Expression) patternPart);
            }
        }
        if (this.shouldDoubleQuotePattern) {
            this.result.append("}}");
        }
    }

    private void selectMessageToString(MFDataModel.SelectMessage selectMessage) {
        declarationsToString(selectMessage.declarations);
        this.shouldDoubleQuotePattern = true;
        addSpaceIfNeeded();
        this.result.append(".match");
        for (MFDataModel.Expression expression : selectMessage.selectors) {
            this.result.append(' ');
            if (expression instanceof MFDataModel.VariableExpression) {
                literalOrVariableRefToString(((MFDataModel.VariableExpression) expression).arg);
            } else {
                expressionToString(expression);
            }
        }
        Iterator<MFDataModel.Variant> it = selectMessage.variants.iterator();
        while (it.hasNext()) {
            variantToString(it.next());
        }
    }

    private void stringPartToString(MFDataModel.StringPart stringPart) {
        if (stringPart.value.startsWith(".") && !this.shouldDoubleQuotePattern) {
            this.shouldDoubleQuotePattern = true;
            this.result.append("{{");
        }
        for (int i = 0; i < stringPart.value.length(); i++) {
            char cCharAt = stringPart.value.charAt(i);
            if (cCharAt == '\\' || cCharAt == '{' || cCharAt == '}') {
                this.result.append(PatternTokenizer.BACK_SLASH);
            }
            this.result.append(cCharAt);
        }
    }

    private void variableExpressionToString(MFDataModel.VariableExpression variableExpression) {
        if (variableExpression == null) {
            return;
        }
        this.result.append('{');
        literalOrVariableRefToString(variableExpression.arg);
        this.needSpace = true;
        functionToString(variableExpression.function);
        attributesToString(variableExpression.attributes);
        this.result.append('}');
        this.needSpace = false;
    }

    private void variantToString(MFDataModel.Variant variant) {
        for (MFDataModel.LiteralOrCatchallKey literalOrCatchallKey : variant.keys) {
            this.result.append(' ');
            if (literalOrCatchallKey instanceof MFDataModel.CatchallKey) {
                this.result.append('*');
            } else {
                literalToString((MFDataModel.Literal) literalOrCatchallKey);
            }
        }
        this.result.append(' ');
        patternToString(variant.value);
    }

    private void error(String str) {
        throw new RuntimeException(str);
    }
}
