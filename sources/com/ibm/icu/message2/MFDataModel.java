package com.ibm.icu.message2;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class MFDataModel {

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    @Deprecated
    public static class Attribute {

        @Deprecated
        public final String name;

        @Deprecated
        public final LiteralOrVariableRef value;

        @Deprecated
        public Attribute(String str, LiteralOrVariableRef literalOrVariableRef) {
            this.name = str;
            this.value = literalOrVariableRef;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    @Deprecated
    public static class CatchallKey implements LiteralOrCatchallKey {
        static final String AS_KEY_STRING = "<<::CatchallKey::>>";

        @Deprecated
        public CatchallKey() {
        }

        @Deprecated
        public static boolean isCatchAll(String str) {
            return AS_KEY_STRING.equals(str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    @Deprecated
    public interface Declaration {
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    @Deprecated
    public interface Expression extends PatternPart {
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    @Deprecated
    public static class FunctionExpression implements Expression {

        @Deprecated
        public final List<Attribute> attributes;

        @Deprecated
        public final FunctionRef function;

        @Deprecated
        public FunctionExpression(FunctionRef functionRef, List<Attribute> list) {
            this.function = functionRef;
            this.attributes = list;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    @Deprecated
    public static class FunctionRef {

        @Deprecated
        public final String name;

        @Deprecated
        public final Map<String, Option> options;

        @Deprecated
        public FunctionRef(String str, Map<String, Option> map) {
            this.name = str;
            this.options = map;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    @Deprecated
    public static class InputDeclaration implements Declaration {

        @Deprecated
        public final String name;

        @Deprecated
        public final VariableExpression value;

        @Deprecated
        public InputDeclaration(String str, VariableExpression variableExpression) {
            this.name = str;
            this.value = variableExpression;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    @Deprecated
    public static class Literal implements LiteralOrVariableRef, LiteralOrCatchallKey {

        @Deprecated
        public final String value;

        @Deprecated
        public Literal(String str) {
            this.value = str;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    @Deprecated
    public static class LiteralExpression implements Expression {

        @Deprecated
        public final Literal arg;

        @Deprecated
        public final List<Attribute> attributes;

        @Deprecated
        public final FunctionRef function;

        @Deprecated
        public LiteralExpression(Literal literal, FunctionRef functionRef, List<Attribute> list) {
            this.arg = literal;
            this.function = functionRef;
            this.attributes = list;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    @Deprecated
    public interface LiteralOrCatchallKey {
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    @Deprecated
    public interface LiteralOrVariableRef {
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    @Deprecated
    public static class LocalDeclaration implements Declaration {

        @Deprecated
        public final String name;

        @Deprecated
        public final Expression value;

        @Deprecated
        public LocalDeclaration(String str, Expression expression) {
            this.name = str;
            this.value = expression;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    @Deprecated
    public static class Markup implements Expression {

        @Deprecated
        public final List<Attribute> attributes;

        @Deprecated
        public final Kind kind;

        @Deprecated
        public final String name;

        @Deprecated
        public final Map<String, Option> options;

        /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
        public enum Kind {
            OPEN,
            CLOSE,
            STANDALONE
        }

        @Deprecated
        public Markup(Kind kind, String str, Map<String, Option> map, List<Attribute> list) {
            this.kind = kind;
            this.name = str;
            this.options = map;
            this.attributes = list;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    @Deprecated
    public interface Message {
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    @Deprecated
    public static class Option {

        @Deprecated
        public final String name;

        @Deprecated
        public final LiteralOrVariableRef value;

        @Deprecated
        public Option(String str, LiteralOrVariableRef literalOrVariableRef) {
            this.name = str;
            this.value = literalOrVariableRef;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    @Deprecated
    public static class Pattern {

        @Deprecated
        public final List<PatternPart> parts = new ArrayList();
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    @Deprecated
    public static class PatternMessage implements Message {

        @Deprecated
        public final List<Declaration> declarations;

        @Deprecated
        public final Pattern pattern;

        @Deprecated
        public PatternMessage(List<Declaration> list, Pattern pattern) {
            this.declarations = list;
            this.pattern = pattern;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    @Deprecated
    public interface PatternPart {
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    @Deprecated
    public static class SelectMessage implements Message {

        @Deprecated
        public final List<Declaration> declarations;

        @Deprecated
        public final List<Expression> selectors;

        @Deprecated
        public final List<Variant> variants;

        @Deprecated
        public SelectMessage(List<Declaration> list, List<Expression> list2, List<Variant> list3) {
            this.declarations = list;
            this.selectors = list2;
            this.variants = list3;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    @Deprecated
    public static class StringPart implements PatternPart {

        @Deprecated
        public final String value;

        public StringPart(String str) {
            this.value = str;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    @Deprecated
    public static class VariableExpression implements Expression {

        @Deprecated
        public final VariableRef arg;

        @Deprecated
        public final List<Attribute> attributes;

        @Deprecated
        public final FunctionRef function;

        @Deprecated
        public VariableExpression(VariableRef variableRef, FunctionRef functionRef, List<Attribute> list) {
            this.arg = variableRef;
            this.function = functionRef;
            this.attributes = list;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    @Deprecated
    public static class VariableRef implements LiteralOrVariableRef {

        @Deprecated
        public final String name;

        @Deprecated
        public VariableRef(String str) {
            this.name = str;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    @Deprecated
    public static class Variant implements LiteralOrCatchallKey {

        @Deprecated
        public final List<LiteralOrCatchallKey> keys;

        @Deprecated
        public final Pattern value;

        @Deprecated
        public Variant(List<LiteralOrCatchallKey> list, Pattern pattern) {
            this.keys = list;
            this.value = pattern;
        }
    }

    private MFDataModel() {
    }
}
