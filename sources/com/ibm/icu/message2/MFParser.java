package com.ibm.icu.message2;

import defpackage.cq;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class MFParser {
    private static final int EOF = -1;
    private final InputSource input;

    public MFParser(String str) {
        this.input = new InputSource(str);
    }

    private void checkCondition(boolean z, String str) throws MFParseException {
        if (z) {
            return;
        }
        error(str);
    }

    private void error(String str) throws MFParseException {
        StringBuilder sb = new StringBuilder();
        InputSource inputSource = this.input;
        if (inputSource != null) {
            int position = inputSource.getPosition();
            sb.append("Parse error [" + this.input.getPosition() + "]: ");
            sb.append(str);
            sb.append("\n");
            InputSource inputSource2 = this.input;
            if (position != -1) {
                sb.append(inputSource2.buffer.substring(0, position));
                sb.append("^^^");
                sb.append(this.input.buffer.substring(position));
            } else {
                sb.append(inputSource2.buffer);
                sb.append("^^^");
            }
        } else {
            sb.append("Parse error: ");
            sb.append(str);
        }
        throw new MFParseException(sb.toString(), this.input.getPosition());
    }

    private MFDataModel.Attribute getAttribute() throws MFParseException {
        int position = this.input.getPosition();
        skipOptionalWhitespaces();
        int iPeekChar = this.input.peekChar();
        InputSource inputSource = this.input;
        MFDataModel.Literal literal = null;
        if (iPeekChar != 64) {
            inputSource.gotoPosition(position);
            return null;
        }
        inputSource.readCodePoint();
        String identifier = getIdentifier();
        int iSkipOptionalWhitespaces = skipOptionalWhitespaces();
        int iPeekChar2 = this.input.peekChar();
        InputSource inputSource2 = this.input;
        if (iPeekChar2 == 61) {
            inputSource2.readCodePoint();
            skipOptionalWhitespaces();
            literal = getLiteral(false);
            checkCondition(literal != null, "Attributes must have a value after `=`");
        } else {
            inputSource2.backup(iSkipOptionalWhitespaces);
        }
        return new MFDataModel.Attribute(identifier, literal);
    }

    private List<MFDataModel.Attribute> getAttributes() throws MFParseException {
        ArrayList arrayList = new ArrayList();
        while (true) {
            MFDataModel.Attribute attribute = getAttribute();
            if (attribute == null) {
                return arrayList;
            }
            arrayList.add(attribute);
        }
    }

    private MFDataModel.Message getComplexMessage() throws MFParseException {
        ArrayList arrayList = new ArrayList();
        while (true) {
            MFDataModel.Declaration declaration = getDeclaration();
            if (declaration == null) {
                skipOptionalWhitespaces();
                checkCondition(this.input.peekChar() != -1, "Expected a quoted pattern or .match; got end-of-input");
                MFDataModel.Pattern quotedPattern = getQuotedPattern();
                skipOptionalWhitespaces();
                checkCondition(this.input.atEnd(), "Content detected after the end of the message.");
                return new MFDataModel.PatternMessage(arrayList, quotedPattern);
            }
            if (declaration instanceof MatchDeclaration) {
                return getMatch(arrayList);
            }
            arrayList.add(declaration);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    private MFDataModel.Declaration getDeclaration() throws MFParseException {
        int position = this.input.getPosition();
        skipOptionalWhitespaces();
        if (this.input.readCodePoint() != 46) {
            this.input.gotoPosition(position);
            return null;
        }
        String name = getName();
        Object[] objArr = 0;
        checkCondition(name != null, "Expected a declaration after the '.'");
        name.getClass();
        switch (name) {
            case "input":
                skipOptionalWhitespaces();
                MFDataModel.Expression placeholder = getPlaceholder();
                checkCondition(placeholder instanceof MFDataModel.VariableExpression, "Variable expression required in .input declaration");
                MFDataModel.VariableExpression variableExpression = (MFDataModel.VariableExpression) placeholder;
                return new MFDataModel.InputDeclaration(variableExpression.arg.name, variableExpression);
            case "local":
                skipRequiredWhitespaces();
                MFDataModel.VariableRef variableRef = getVariableRef();
                skipOptionalWhitespaces();
                checkCondition(this.input.readCodePoint() == 61, name);
                skipOptionalWhitespaces();
                MFDataModel.Expression placeholder2 = getPlaceholder();
                if (variableRef != null) {
                    return new MFDataModel.LocalDeclaration(variableRef.name, placeholder2);
                }
                return null;
            case "match":
                return new MatchDeclaration(objArr == true ? 1 : 0);
            default:
                return null;
        }
    }

    private MFDataModel.FunctionRef getFunction(boolean z) throws MFParseException {
        int position = this.input.getPosition();
        if (this.input.peekChar() == 125) {
            return null;
        }
        int iSkipRequiredWhitespaces = z ? skipRequiredWhitespaces() : skipOptionalWhitespaces();
        int iPeekChar = this.input.peekChar();
        if (iPeekChar == 58) {
            this.input.readCodePoint();
            String identifier = getIdentifier();
            checkCondition(identifier != null, "Function name missing");
            return new MFDataModel.FunctionRef(identifier, getOptions());
        }
        InputSource inputSource = this.input;
        if (iPeekChar != 125) {
            inputSource.gotoPosition(position);
            return null;
        }
        inputSource.backup(iSkipRequiredWhitespaces);
        return null;
    }

    private MFDataModel.Expression getFunctionExpression() throws MFParseException {
        MFDataModel.FunctionRef function = getFunction(false);
        List<MFDataModel.Attribute> attributes = getAttributes();
        if (function != null) {
            return new MFDataModel.FunctionExpression(function, attributes);
        }
        error("Unexpected function : ".concat(String.valueOf(function)));
        return null;
    }

    private String getIdentifier() throws MFParseException {
        String name = getName();
        if (name == null) {
            return null;
        }
        int position = this.input.getPosition();
        if (this.input.readCodePoint() != 58) {
            this.input.gotoPosition(position);
            return name;
        }
        String name2 = getName();
        checkCondition(name2 != null, cq.v("Expected name after namespace '", name, "'"));
        return cq.k(name, ":", name2);
    }

    private MFDataModel.LiteralOrCatchallKey getKey(boolean z) {
        if (this.input.peekChar() == 123) {
            return null;
        }
        int iSkipRequiredWhitespaces = z ? skipRequiredWhitespaces() : skipOptionalWhitespaces();
        int iPeekChar = this.input.peekChar();
        if (iPeekChar == 42) {
            this.input.readCodePoint();
            return new MFDataModel.CatchallKey();
        }
        if (iPeekChar != -1) {
            return getLiteral(true);
        }
        this.input.backup(iSkipRequiredWhitespaces);
        return null;
    }

    private MFDataModel.Literal getLiteral(boolean z) {
        return this.input.peekChar() != 124 ? getUnQuotedLiteral(z) : getQuotedLiteral(z);
    }

    private MFDataModel.Expression getLiteralExpression() throws MFParseException {
        MFDataModel.Literal literal = getLiteral(true);
        checkCondition(literal != null, "Literal expression expected.");
        MFDataModel.FunctionRef function = StringUtils.isWhitespace(this.input.peekChar()) ? getFunction(true) : null;
        boolean zIsWhitespace = StringUtils.isWhitespace(this.input.peekChar());
        List<MFDataModel.Attribute> attributes = getAttributes();
        if (!zIsWhitespace && !attributes.isEmpty()) {
            error("syntax-error: missing space before attributes");
        }
        return new MFDataModel.LiteralExpression(literal, function, attributes);
    }

    private MFDataModel.LiteralOrVariableRef getLiteralOrVariableRef() {
        return this.input.peekChar() == 36 ? getVariableRef() : getLiteral(false);
    }

    private MFDataModel.Markup getMarkup() throws MFParseException {
        int iPeekChar = this.input.peekChar();
        checkCondition(iPeekChar == 35 || iPeekChar == 47, "Should not happen. Expecting a markup.");
        MFDataModel.Markup.Kind kind = iPeekChar == 47 ? MFDataModel.Markup.Kind.CLOSE : MFDataModel.Markup.Kind.OPEN;
        MFDataModel.FunctionRef markupFunction = getMarkupFunction();
        List<MFDataModel.Attribute> attributes = getAttributes();
        skipOptionalWhitespaces();
        if (this.input.peekChar() == 47) {
            kind = MFDataModel.Markup.Kind.STANDALONE;
            this.input.readCodePoint();
        }
        if (markupFunction != null) {
            return new MFDataModel.Markup(kind, markupFunction.name, markupFunction.options, attributes);
        }
        return null;
    }

    private MFDataModel.FunctionRef getMarkupFunction() throws MFParseException {
        skipOptionalWhitespaces();
        int iPeekChar = this.input.peekChar();
        if (iPeekChar != 35 && iPeekChar != 47) {
            return null;
        }
        this.input.readCodePoint();
        String identifier = getIdentifier();
        checkCondition(identifier != null, "Function name missing");
        return new MFDataModel.FunctionRef(identifier, getOptions());
    }

    private MFDataModel.SelectMessage getMatch(List<MFDataModel.Declaration> list) throws MFParseException {
        MFDataModel.VariableRef variableRef;
        ArrayList arrayList = new ArrayList();
        while (true) {
            skipRequiredWhitespaces();
            if (this.input.peekChar() != 36 || (variableRef = getVariableRef()) == null) {
                break;
            }
            arrayList.add(new MFDataModel.VariableExpression(variableRef, null, new ArrayList()));
        }
        checkCondition(!arrayList.isEmpty(), "There should be at least one selector expression.");
        ArrayList arrayList2 = new ArrayList();
        while (true) {
            MFDataModel.Variant variant = getVariant();
            if (variant == null) {
                checkCondition(this.input.atEnd(), "Content detected after the end of the message.");
                return new MFDataModel.SelectMessage(list, arrayList, arrayList2);
            }
            arrayList2.add(variant);
        }
    }

    private String getName() throws MFParseException {
        int codePoint;
        int position = this.input.getPosition();
        StringBuilder sb = new StringBuilder();
        skipOneOptionalBidi();
        int codePoint2 = this.input.readCodePoint();
        checkCondition(codePoint2 != -1, "Expected name or namespace.");
        if (!StringUtils.isNameStart(codePoint2)) {
            this.input.gotoPosition(position);
            return null;
        }
        sb.appendCodePoint(codePoint2);
        while (true) {
            codePoint = this.input.readCodePoint();
            if (!StringUtils.isNameChar(codePoint)) {
                break;
            }
            sb.appendCodePoint(codePoint);
        }
        if (codePoint != -1) {
            this.input.backup(Character.charCount(codePoint));
        }
        skipOneOptionalBidi();
        return StringUtils.toNfc(sb.toString());
    }

    private MFDataModel.Option getOption() throws MFParseException {
        int position = this.input.getPosition();
        skipOptionalWhitespaces();
        String identifier = getIdentifier();
        if (identifier == null) {
            this.input.gotoPosition(position);
            return null;
        }
        skipOptionalWhitespaces();
        checkCondition(this.input.readCodePoint() == 61, "Expected '='");
        skipOptionalWhitespaces();
        MFDataModel.LiteralOrVariableRef literalOrVariableRef = getLiteralOrVariableRef();
        if (literalOrVariableRef == null) {
            error("Options must have a value. An empty string should be quoted.");
        }
        return new MFDataModel.Option(identifier, literalOrVariableRef);
    }

    private Map<String, MFDataModel.Option> getOptions() throws MFParseException {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        boolean z = true;
        int iSkipOptionalWhitespaces = 0;
        while (true) {
            MFDataModel.Option option = getOption();
            if (option == null) {
                this.input.backup(iSkipOptionalWhitespaces);
                return linkedHashMap;
            }
            checkCondition(z || iSkipOptionalWhitespaces != 0, cq.j("Expected whitespace before option ", option.name));
            if (linkedHashMap.containsKey(option.name)) {
                error(cq.v("Duplicated option '", option.name, "'"));
            }
            linkedHashMap.put(option.name, option);
            iSkipOptionalWhitespaces = skipOptionalWhitespaces();
            z = false;
        }
    }

    private MFDataModel.Pattern getPattern() {
        MFDataModel.Pattern pattern = new MFDataModel.Pattern();
        while (true) {
            MFDataModel.PatternPart patternPart = getPatternPart();
            if (patternPart == null) {
                return pattern;
            }
            pattern.parts.add(patternPart);
        }
    }

    private MFDataModel.PatternPart getPatternPart() {
        int iPeekChar = this.input.peekChar();
        if (iPeekChar == -1) {
            return null;
        }
        if (iPeekChar == 123) {
            return getPlaceholder();
        }
        if (iPeekChar != 125) {
            return new MFDataModel.StringPart(getTextCharOrEscapedChar());
        }
        return null;
    }

    private MFDataModel.Expression getPlaceholder() throws MFParseException {
        MFDataModel.Expression markup;
        if (this.input.peekChar() != 123) {
            return null;
        }
        this.input.readCodePoint();
        skipOptionalWhitespaces();
        int iPeekChar = this.input.peekChar();
        if (iPeekChar == 35 || iPeekChar == 47) {
            markup = getMarkup();
        } else if (iPeekChar == 36) {
            markup = getVariableExpression();
        } else {
            markup = StringUtils.isFunctionSigil(iPeekChar) ? getFunctionExpression() : getLiteralExpression();
        }
        skipOptionalWhitespaces();
        checkCondition(this.input.readCodePoint() == 125, "Unclosed placeholder");
        return markup;
    }

    private MFDataModel.Literal getQuotedLiteral(boolean z) throws MFParseException {
        int codePoint;
        StringBuilder sb = new StringBuilder();
        checkCondition(this.input.readCodePoint() == 124, "expected starting '|'");
        while (true) {
            codePoint = this.input.readCodePoint();
            if (codePoint == -1) {
                break;
            }
            if (!StringUtils.isQuotedChar(codePoint)) {
                if (codePoint != 92) {
                    break;
                }
                int codePoint2 = this.input.readCodePoint();
                checkCondition(codePoint2 == 124 || codePoint2 == 92 || codePoint2 == 123 || codePoint2 == 125, "Invalid escape sequence inside quoted literal");
                sb.appendCodePoint(codePoint2);
            } else {
                sb.appendCodePoint(codePoint);
            }
        }
        checkCondition(codePoint == 124, "expected ending '|'");
        return new MFDataModel.Literal(z ? StringUtils.toNfc(sb) : sb.toString());
    }

    private MFDataModel.Pattern getQuotedPattern() throws MFParseException {
        checkCondition(this.input.readCodePoint() == 123, "Expected { for a complex body");
        checkCondition(this.input.readCodePoint() == 123, "Expected second { for a complex body");
        MFDataModel.Pattern pattern = getPattern();
        checkCondition(this.input.readCodePoint() == 125, "Expected } to end a complex body");
        checkCondition(this.input.readCodePoint() == 125, "Expected second } to end a complex body");
        return pattern;
    }

    private String getTextCharOrEscapedChar() {
        StringBuilder sb = new StringBuilder();
        while (true) {
            int codePoint = this.input.readCodePoint();
            if (codePoint == -1) {
                return sb.toString();
            }
            if (codePoint == 92) {
                int codePoint2 = this.input.readCodePoint();
                if (codePoint2 != 92 && codePoint2 != 123) {
                    if (!((codePoint2 == 124) | (codePoint2 == 125))) {
                        sb.appendCodePoint(92);
                        sb.appendCodePoint(codePoint2);
                    }
                }
                sb.appendCodePoint(codePoint2);
            } else {
                if (!StringUtils.isTextChar(codePoint)) {
                    this.input.backup(Character.charCount(codePoint));
                    return sb.toString();
                }
                sb.appendCodePoint(codePoint);
            }
        }
    }

    private MFDataModel.Literal getUnQuotedLiteral(boolean z) throws MFParseException {
        int codePoint;
        int position = this.input.getPosition();
        StringBuilder sb = new StringBuilder();
        int codePoint2 = this.input.readCodePoint();
        checkCondition(codePoint2 != -1, "Expected unquoted-literal.");
        if (!StringUtils.isNameChar(codePoint2)) {
            this.input.gotoPosition(position);
            return null;
        }
        sb.appendCodePoint(codePoint2);
        while (true) {
            codePoint = this.input.readCodePoint();
            if (!StringUtils.isNameChar(codePoint)) {
                break;
            }
            sb.appendCodePoint(codePoint);
        }
        if (codePoint != -1) {
            this.input.backup(Character.charCount(codePoint));
        }
        return new MFDataModel.Literal(z ? StringUtils.toNfc(sb.toString()) : sb.toString());
    }

    private MFDataModel.VariableExpression getVariableExpression() {
        return new MFDataModel.VariableExpression(getVariableRef(), getFunction(true), getAttributes());
    }

    private MFDataModel.VariableRef getVariableRef() throws MFParseException {
        int codePoint = this.input.readCodePoint();
        if (codePoint != 36) {
            checkCondition(codePoint == 36, "We can't get here");
        }
        String name = getName();
        checkCondition(name != null, "Invalid variable reference following $");
        return new MFDataModel.VariableRef(name);
    }

    private MFDataModel.Variant getVariant() throws MFParseException {
        ArrayList arrayList = new ArrayList();
        while (true) {
            MFDataModel.LiteralOrCatchallKey key = getKey(!arrayList.isEmpty());
            if (key == null) {
                break;
            }
            arrayList.add(key);
        }
        skipOptionalWhitespaces();
        if (!this.input.atEnd()) {
            return new MFDataModel.Variant(arrayList, getQuotedPattern());
        }
        checkCondition(arrayList.isEmpty(), "After selector keys it is mandatory to have a pattern.");
        return null;
    }

    @Deprecated
    public static MFDataModel.Message parse(String str) {
        return new MFParser(str).parseImpl();
    }

    private MFDataModel.Message parseImpl() throws MFParseException {
        MFDataModel.PatternMessage patternMessage;
        MFDataModel.Message complexMessage;
        int position = this.input.getPosition();
        skipOptionalWhitespaces();
        int iPeekChar = this.input.peekChar();
        if (iPeekChar == 46) {
            complexMessage = getComplexMessage();
        } else {
            InputSource inputSource = this.input;
            if (iPeekChar == 123) {
                inputSource.readCodePoint();
                int iPeekChar2 = this.input.peekChar();
                InputSource inputSource2 = this.input;
                if (iPeekChar2 == 123) {
                    inputSource2.backup(1);
                    MFDataModel.Pattern quotedPattern = getQuotedPattern();
                    skipOptionalWhitespaces();
                    patternMessage = new MFDataModel.PatternMessage(new ArrayList(), quotedPattern);
                } else {
                    inputSource2.gotoPosition(position);
                    patternMessage = new MFDataModel.PatternMessage(new ArrayList(), getPattern());
                }
            } else {
                inputSource.gotoPosition(position);
                patternMessage = new MFDataModel.PatternMessage(new ArrayList(), getPattern());
            }
            complexMessage = patternMessage;
        }
        checkCondition(this.input.atEnd(), "Content detected after the end of the message.");
        new MFDataModelValidator(complexMessage).validate();
        return complexMessage;
    }

    private int skipOneOptionalBidi() {
        if (!StringUtils.isBidi(this.input.peekChar())) {
            return 0;
        }
        this.input.readCodePoint();
        return 1;
    }

    private int skipOptionalBidi() {
        int i = 0;
        while (StringUtils.isBidi(this.input.peekChar())) {
            i++;
            this.input.readCodePoint();
        }
        return i;
    }

    private int skipOptionalWhitespaces() {
        int i = 0;
        while (true) {
            int iPeekChar = this.input.peekChar();
            if (!StringUtils.isWhitespace(iPeekChar) && !StringUtils.isBidi(iPeekChar)) {
                return i;
            }
            this.input.readCodePoint();
            i++;
        }
    }

    private int skipRequiredWhitespaces() throws MFParseException {
        this.input.getPosition();
        skipOptionalBidi();
        int iSkipWhitespaces = skipWhitespaces();
        checkCondition(iSkipWhitespaces > 0, "Space expected");
        skipOptionalWhitespaces();
        return iSkipWhitespaces;
    }

    private int skipWhitespaces() {
        int i = 0;
        while (StringUtils.isWhitespace(this.input.peekChar())) {
            i++;
            this.input.readCodePoint();
        }
        return i;
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class MatchDeclaration implements MFDataModel.Declaration {
        public /* synthetic */ MatchDeclaration(int i) {
            this();
        }

        private MatchDeclaration() {
        }
    }
}
