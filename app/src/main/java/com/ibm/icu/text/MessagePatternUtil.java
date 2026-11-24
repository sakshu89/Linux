package com.ibm.icu.text;

import defpackage.cq;
import defpackage.og;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class MessagePatternUtil {

    /* JADX INFO: renamed from: com.ibm.icu.text.MessagePatternUtil$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ibm$icu$text$MessagePattern$ArgType;

        static {
            int[] iArr = new int[MessagePattern.ArgType.values().length];
            $SwitchMap$com$ibm$icu$text$MessagePattern$ArgType = iArr;
            try {
                iArr[MessagePattern.ArgType.SIMPLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ibm$icu$text$MessagePattern$ArgType[MessagePattern.ArgType.CHOICE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$ibm$icu$text$MessagePattern$ArgType[MessagePattern.ArgType.PLURAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$ibm$icu$text$MessagePattern$ArgType[MessagePattern.ArgType.SELECT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$ibm$icu$text$MessagePattern$ArgType[MessagePattern.ArgType.SELECTORDINAL.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class ArgNode extends MessageContentsNode {
        private MessagePattern.ArgType argType;
        private ComplexArgStyleNode complexStyle;
        private String name;
        private int number;
        private String style;
        private String typeName;

        private ArgNode() {
            super(MessageContentsNode.Type.ARG, 0);
            this.number = -1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static ArgNode createArgNode() {
            return new ArgNode();
        }

        public MessagePattern.ArgType getArgType() {
            return this.argType;
        }

        public ComplexArgStyleNode getComplexStyle() {
            return this.complexStyle;
        }

        public String getName() {
            return this.name;
        }

        public int getNumber() {
            return this.number;
        }

        public String getSimpleStyle() {
            return this.style;
        }

        public String getTypeName() {
            return this.typeName;
        }

        @Override // com.ibm.icu.text.MessagePatternUtil.MessageContentsNode
        public String toString() {
            StringBuilder sb = new StringBuilder("{");
            sb.append(this.name);
            if (this.argType != MessagePattern.ArgType.NONE) {
                sb.append(',');
                sb.append(this.typeName);
                if (this.argType != MessagePattern.ArgType.SIMPLE) {
                    sb.append(',');
                    sb.append(this.complexStyle.toString());
                } else if (this.style != null) {
                    sb.append(',');
                    sb.append(this.style);
                }
            }
            sb.append('}');
            return sb.toString();
        }
    }

    private MessagePatternUtil() {
    }

    private static ArgNode buildArgNode(MessagePattern messagePattern, int i, int i2) {
        ArgNode argNodeCreateArgNode = ArgNode.createArgNode();
        MessagePattern.ArgType argType = messagePattern.getPart(i).getArgType();
        argNodeCreateArgNode.argType = argType;
        MessagePattern.Part part = messagePattern.getPart(i + 1);
        argNodeCreateArgNode.name = messagePattern.getSubstring(part);
        if (part.getType() == MessagePattern.Part.Type.ARG_NUMBER) {
            argNodeCreateArgNode.number = part.getValue();
        }
        int i3 = i + 2;
        int i4 = AnonymousClass1.$SwitchMap$com$ibm$icu$text$MessagePattern$ArgType[argType.ordinal()];
        if (i4 == 1) {
            int i5 = i + 3;
            argNodeCreateArgNode.typeName = messagePattern.getSubstring(messagePattern.getPart(i3));
            if (i5 < i2) {
                argNodeCreateArgNode.style = messagePattern.getSubstring(messagePattern.getPart(i5));
            }
        } else {
            if (i4 == 2) {
                argNodeCreateArgNode.typeName = "choice";
                argNodeCreateArgNode.complexStyle = buildChoiceStyleNode(messagePattern, i3, i2);
                return argNodeCreateArgNode;
            }
            if (i4 == 3) {
                argNodeCreateArgNode.typeName = "plural";
                argNodeCreateArgNode.complexStyle = buildPluralStyleNode(messagePattern, i3, i2, argType);
                return argNodeCreateArgNode;
            }
            if (i4 == 4) {
                argNodeCreateArgNode.typeName = "select";
                argNodeCreateArgNode.complexStyle = buildSelectStyleNode(messagePattern, i3, i2);
                return argNodeCreateArgNode;
            }
            if (i4 == 5) {
                argNodeCreateArgNode.typeName = "selectordinal";
                argNodeCreateArgNode.complexStyle = buildPluralStyleNode(messagePattern, i3, i2, argType);
                return argNodeCreateArgNode;
            }
        }
        return argNodeCreateArgNode;
    }

    private static ComplexArgStyleNode buildChoiceStyleNode(MessagePattern messagePattern, int i, int i2) {
        int i3 = 0;
        ComplexArgStyleNode complexArgStyleNode = new ComplexArgStyleNode(i3, MessagePattern.ArgType.CHOICE);
        while (i < i2) {
            double numericValue = messagePattern.getNumericValue(messagePattern.getPart(i));
            int i4 = i + 2;
            int limitPartIndex = messagePattern.getLimitPartIndex(i4);
            VariantNode variantNode = new VariantNode(i3);
            variantNode.selector = messagePattern.getSubstring(messagePattern.getPart(i + 1));
            variantNode.numericValue = numericValue;
            variantNode.msgNode = buildMessageNode(messagePattern, i4, limitPartIndex);
            complexArgStyleNode.addVariant(variantNode);
            i = limitPartIndex + 1;
        }
        return complexArgStyleNode.freeze();
    }

    private static MessageNode buildMessageNode(MessagePattern messagePattern, int i, int i2) {
        int limit = messagePattern.getPart(i).getLimit();
        int i3 = 0;
        MessageNode messageNode = new MessageNode(i3);
        while (true) {
            i++;
            MessagePattern.Part part = messagePattern.getPart(i);
            int index = part.getIndex();
            if (limit < index) {
                messageNode.addContentsNode(new TextNode(messagePattern.getPatternString().substring(limit, index), i3));
            }
            if (i == i2) {
                return messageNode.freeze();
            }
            MessagePattern.Part.Type type = part.getType();
            if (type == MessagePattern.Part.Type.ARG_START) {
                int limitPartIndex = messagePattern.getLimitPartIndex(i);
                messageNode.addContentsNode(buildArgNode(messagePattern, i, limitPartIndex));
                part = messagePattern.getPart(limitPartIndex);
                i = limitPartIndex;
            } else if (type == MessagePattern.Part.Type.REPLACE_NUMBER) {
                messageNode.addContentsNode(MessageContentsNode.createReplaceNumberNode());
            }
            limit = part.getLimit();
        }
    }

    private static ComplexArgStyleNode buildPluralStyleNode(MessagePattern messagePattern, int i, int i2, MessagePattern.ArgType argType) {
        double numericValue;
        int i3 = 0;
        ComplexArgStyleNode complexArgStyleNode = new ComplexArgStyleNode(i3, argType);
        MessagePattern.Part part = messagePattern.getPart(i);
        if (part.getType().hasNumericValue()) {
            complexArgStyleNode.explicitOffset = true;
            complexArgStyleNode.offset = messagePattern.getNumericValue(part);
            i++;
        }
        while (i < i2) {
            int i4 = i + 1;
            MessagePattern.Part part2 = messagePattern.getPart(i);
            MessagePattern.Part part3 = messagePattern.getPart(i4);
            if (part3.getType().hasNumericValue()) {
                numericValue = messagePattern.getNumericValue(part3);
                i4 = i + 2;
            } else {
                numericValue = -1.23456789E8d;
            }
            int limitPartIndex = messagePattern.getLimitPartIndex(i4);
            VariantNode variantNode = new VariantNode(i3);
            variantNode.selector = messagePattern.getSubstring(part2);
            variantNode.numericValue = numericValue;
            variantNode.msgNode = buildMessageNode(messagePattern, i4, limitPartIndex);
            complexArgStyleNode.addVariant(variantNode);
            i = limitPartIndex + 1;
        }
        return complexArgStyleNode.freeze();
    }

    private static ComplexArgStyleNode buildSelectStyleNode(MessagePattern messagePattern, int i, int i2) {
        int i3 = 0;
        ComplexArgStyleNode complexArgStyleNode = new ComplexArgStyleNode(i3, MessagePattern.ArgType.SELECT);
        while (i < i2) {
            int i4 = i + 1;
            MessagePattern.Part part = messagePattern.getPart(i);
            int limitPartIndex = messagePattern.getLimitPartIndex(i4);
            VariantNode variantNode = new VariantNode(i3);
            variantNode.selector = messagePattern.getSubstring(part);
            variantNode.msgNode = buildMessageNode(messagePattern, i4, limitPartIndex);
            complexArgStyleNode.addVariant(variantNode);
            i = limitPartIndex + 1;
        }
        return complexArgStyleNode.freeze();
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class Node {
        public /* synthetic */ Node(int i) {
            this();
        }

        private Node() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class MessageContentsNode extends Node {
        private Type type;

        /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
        public enum Type {
            TEXT,
            ARG,
            REPLACE_NUMBER
        }

        private MessageContentsNode(Type type) {
            super(0);
            this.type = type;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static MessageContentsNode createReplaceNumberNode() {
            return new MessageContentsNode(Type.REPLACE_NUMBER);
        }

        public Type getType() {
            return this.type;
        }

        public String toString() {
            return "{REPLACE_NUMBER}";
        }

        public /* synthetic */ MessageContentsNode(Type type, int i) {
            this(type);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class TextNode extends MessageContentsNode {
        private String text;

        private TextNode(String str) {
            super(MessageContentsNode.Type.TEXT, 0);
            this.text = str;
        }

        public String getText() {
            return this.text;
        }

        @Override // com.ibm.icu.text.MessagePatternUtil.MessageContentsNode
        public String toString() {
            return cq.v("«", this.text, "»");
        }

        public /* synthetic */ TextNode(String str, int i) {
            this(str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class MessageNode extends Node {
        private volatile List<MessageContentsNode> list;

        private MessageNode() {
            super(0);
            this.list = new ArrayList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addContentsNode(MessageContentsNode messageContentsNode) {
            if ((messageContentsNode instanceof TextNode) && !this.list.isEmpty()) {
                MessageContentsNode messageContentsNode2 = this.list.get(this.list.size() - 1);
                if (messageContentsNode2 instanceof TextNode) {
                    TextNode textNode = (TextNode) messageContentsNode2;
                    textNode.text = textNode.text + ((TextNode) messageContentsNode).text;
                    return;
                }
            }
            this.list.add(messageContentsNode);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public MessageNode freeze() {
            this.list = Collections.unmodifiableList(this.list);
            return this;
        }

        public List<MessageContentsNode> getContents() {
            return this.list;
        }

        public String toString() {
            return this.list.toString();
        }

        public /* synthetic */ MessageNode(int i) {
            this();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class VariantNode extends Node {
        private MessageNode msgNode;
        private double numericValue;
        private String selector;

        private VariantNode() {
            super(0);
            this.numericValue = -1.23456789E8d;
        }

        public MessageNode getMessage() {
            return this.msgNode;
        }

        public String getSelector() {
            return this.selector;
        }

        public double getSelectorValue() {
            return this.numericValue;
        }

        public boolean isSelectorNumeric() {
            return this.numericValue != -1.23456789E8d;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            if (isSelectorNumeric()) {
                sb.append(this.numericValue);
                sb.append(" (");
                sb.append(this.selector);
                sb.append(") {");
            } else {
                sb.append(this.selector);
                sb.append(" {");
            }
            sb.append(this.msgNode.toString());
            sb.append('}');
            return sb.toString();
        }

        public /* synthetic */ VariantNode(int i) {
            this();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class ComplexArgStyleNode extends Node {
        private MessagePattern.ArgType argType;
        private boolean explicitOffset;
        private volatile List<VariantNode> list;
        private double offset;

        private ComplexArgStyleNode(MessagePattern.ArgType argType) {
            super(0);
            this.list = new ArrayList();
            this.argType = argType;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addVariant(VariantNode variantNode) {
            this.list.add(variantNode);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public ComplexArgStyleNode freeze() {
            this.list = Collections.unmodifiableList(this.list);
            return this;
        }

        public MessagePattern.ArgType getArgType() {
            return this.argType;
        }

        public double getOffset() {
            return this.offset;
        }

        public List<VariantNode> getVariants() {
            return this.list;
        }

        public VariantNode getVariantsByType(List<VariantNode> list, List<VariantNode> list2) {
            if (list != null) {
                list.clear();
            }
            list2.clear();
            VariantNode variantNode = null;
            for (VariantNode variantNode2 : this.list) {
                if (variantNode2.isSelectorNumeric()) {
                    list.add(variantNode2);
                } else if (!PluralRules.KEYWORD_OTHER.equals(variantNode2.getSelector())) {
                    list2.add(variantNode2);
                } else if (variantNode == null) {
                    variantNode = variantNode2;
                }
            }
            return variantNode;
        }

        public boolean hasExplicitOffset() {
            return this.explicitOffset;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("(");
            sb.append(this.argType.toString());
            sb.append(" style) ");
            if (hasExplicitOffset()) {
                sb.append("offset:");
                sb.append(this.offset);
                sb.append(' ');
            }
            sb.append(this.list.toString());
            return sb.toString();
        }

        public /* synthetic */ ComplexArgStyleNode(int i, MessagePattern.ArgType argType) {
            this(argType);
        }
    }

    public static MessageNode buildMessageNode(MessagePattern messagePattern) {
        int iCountParts = messagePattern.countParts() - 1;
        if (iCountParts >= 0) {
            if (messagePattern.getPartType(0) == MessagePattern.Part.Type.MSG_START) {
                return buildMessageNode(messagePattern, 0, iCountParts);
            }
            og.i("The MessagePattern does not represent a MessageFormat pattern");
            return null;
        }
        og.i("The MessagePattern is empty");
        return null;
    }

    public static MessageNode buildMessageNode(String str) {
        return buildMessageNode(new MessagePattern(str));
    }
}
