package com.ibm.icu.util;

import defpackage.og;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class StringTrieBuilder {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private Node root;
    private State state = State.ADDING;

    @Deprecated
    protected StringBuilder strings = new StringBuilder();
    private HashMap<Node, Node> nodes = new HashMap<>();
    private ValueNode lookupFinalValueNode = new ValueNode();

    /* JADX INFO: renamed from: com.ibm.icu.util.StringTrieBuilder$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ibm$icu$util$StringTrieBuilder$State;

        static {
            int[] iArr = new int[State.values().length];
            $SwitchMap$com$ibm$icu$util$StringTrieBuilder$State = iArr;
            try {
                iArr[State.ADDING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ibm$icu$util$StringTrieBuilder$State[State.BUILDING_FAST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$ibm$icu$util$StringTrieBuilder$State[State.BUILDING_SMALL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$ibm$icu$util$StringTrieBuilder$State[State.BUILT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class BranchHeadNode extends ValueNode {
        private int length;
        private Node next;

        public BranchHeadNode(int i, Node node) {
            this.length = i;
            this.next = node;
        }

        @Override // com.ibm.icu.util.StringTrieBuilder.ValueNode, com.ibm.icu.util.StringTrieBuilder.Node
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!super.equals(obj)) {
                return false;
            }
            BranchHeadNode branchHeadNode = (BranchHeadNode) obj;
            return this.length == branchHeadNode.length && this.next == branchHeadNode.next;
        }

        @Override // com.ibm.icu.util.StringTrieBuilder.ValueNode, com.ibm.icu.util.StringTrieBuilder.Node
        public int hashCode() {
            return ((this.length + 248302782) * 37) + this.next.hashCode();
        }

        @Override // com.ibm.icu.util.StringTrieBuilder.Node
        public int markRightEdgesFirst(int i) {
            if (this.offset != 0) {
                return i;
            }
            int iMarkRightEdgesFirst = this.next.markRightEdgesFirst(i);
            this.offset = iMarkRightEdgesFirst;
            return iMarkRightEdgesFirst;
        }

        @Override // com.ibm.icu.util.StringTrieBuilder.ValueNode, com.ibm.icu.util.StringTrieBuilder.Node
        public void write(StringTrieBuilder stringTrieBuilder) {
            this.next.write(stringTrieBuilder);
            if (this.length <= stringTrieBuilder.getMinLinearMatch()) {
                this.offset = stringTrieBuilder.writeValueAndType(this.hasValue, this.value, this.length - 1);
            } else {
                stringTrieBuilder.write(this.length - 1);
                this.offset = stringTrieBuilder.writeValueAndType(this.hasValue, this.value, 0);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static abstract class BranchNode extends Node {
        protected int firstEdgeNumber;
        protected int hash;

        @Override // com.ibm.icu.util.StringTrieBuilder.Node
        public int hashCode() {
            return this.hash;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class IntermediateValueNode extends ValueNode {
        private Node next;

        public IntermediateValueNode(int i, Node node) {
            this.next = node;
            setValue(i);
        }

        @Override // com.ibm.icu.util.StringTrieBuilder.ValueNode, com.ibm.icu.util.StringTrieBuilder.Node
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return super.equals(obj) && this.next == ((IntermediateValueNode) obj).next;
        }

        @Override // com.ibm.icu.util.StringTrieBuilder.ValueNode, com.ibm.icu.util.StringTrieBuilder.Node
        public int hashCode() {
            return ((this.value + 82767594) * 37) + this.next.hashCode();
        }

        @Override // com.ibm.icu.util.StringTrieBuilder.Node
        public int markRightEdgesFirst(int i) {
            if (this.offset != 0) {
                return i;
            }
            int iMarkRightEdgesFirst = this.next.markRightEdgesFirst(i);
            this.offset = iMarkRightEdgesFirst;
            return iMarkRightEdgesFirst;
        }

        @Override // com.ibm.icu.util.StringTrieBuilder.ValueNode, com.ibm.icu.util.StringTrieBuilder.Node
        public void write(StringTrieBuilder stringTrieBuilder) {
            this.next.write(stringTrieBuilder);
            this.offset = stringTrieBuilder.writeValueAndFinal(this.value, false);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class LinearMatchNode extends ValueNode {
        private int hash;
        private int length;
        private Node next;
        private int stringOffset;
        private CharSequence strings;

        public LinearMatchNode(CharSequence charSequence, int i, int i2, Node node) {
            this.strings = charSequence;
            this.stringOffset = i;
            this.length = i2;
            this.next = node;
        }

        private void setHashCode() {
            int iHashCode = ((this.length + 124151391) * 37) + this.next.hashCode();
            this.hash = iHashCode;
            if (this.hasValue) {
                this.hash = (iHashCode * 37) + this.value;
            }
            int i = this.stringOffset;
            int i2 = this.length + i;
            while (i < i2) {
                this.hash = this.strings.charAt(i) + (this.hash * 37);
                i++;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v10, types: [com.ibm.icu.util.StringTrieBuilder$Node] */
        /* JADX WARN: Type inference failed for: r0v16 */
        /* JADX WARN: Type inference failed for: r0v5 */
        /* JADX WARN: Type inference failed for: r0v9 */
        /* JADX WARN: Type inference failed for: r10v1 */
        /* JADX WARN: Type inference failed for: r10v2 */
        /* JADX WARN: Type inference failed for: r10v3, types: [com.ibm.icu.util.StringTrieBuilder$Node] */
        /* JADX WARN: Type inference failed for: r10v4 */
        /* JADX WARN: Type inference failed for: r10v6 */
        /* JADX WARN: Type inference failed for: r10v7 */
        /* JADX WARN: Type inference failed for: r10v8 */
        /* JADX WARN: Type inference failed for: r4v0, types: [com.ibm.icu.util.StringTrieBuilder$DynamicBranchNode, com.ibm.icu.util.StringTrieBuilder$Node, com.ibm.icu.util.StringTrieBuilder$ValueNode] */
        @Override // com.ibm.icu.util.StringTrieBuilder.ValueNode, com.ibm.icu.util.StringTrieBuilder.Node
        public Node add(StringTrieBuilder stringTrieBuilder, CharSequence charSequence, int i, int i2) {
            ?? r0;
            ?? r10;
            if (i == charSequence.length()) {
                if (this.hasValue) {
                    og.i("Duplicate string.");
                    return null;
                }
                setValue(i2);
                return this;
            }
            int i3 = this.stringOffset;
            int i4 = this.length + i3;
            while (i3 < i4) {
                if (i == charSequence.length()) {
                    int i5 = i3 - this.stringOffset;
                    LinearMatchNode linearMatchNode = new LinearMatchNode(this.strings, i3, this.length - i5, this.next);
                    linearMatchNode.setValue(i2);
                    this.length = i5;
                    this.next = linearMatchNode;
                    return this;
                }
                char cCharAt = this.strings.charAt(i3);
                char cCharAt2 = charSequence.charAt(i);
                if (cCharAt != cCharAt2) {
                    ?? dynamicBranchNode = new DynamicBranchNode();
                    int i6 = this.stringOffset;
                    if (i3 == i6) {
                        if (this.hasValue) {
                            dynamicBranchNode.setValue(this.value);
                            this.value = 0;
                            this.hasValue = false;
                        }
                        this.stringOffset++;
                        int i7 = this.length - 1;
                        this.length = i7;
                        ?? r11 = this;
                        if (i7 <= 0) {
                            r11 = this.next;
                        }
                        r0 = dynamicBranchNode;
                        r10 = r11;
                    } else if (i3 == i4 - 1) {
                        this.length--;
                        Node node = this.next;
                        this.next = dynamicBranchNode;
                        r0 = this;
                        r10 = node;
                    } else {
                        int i8 = i3 - i6;
                        LinearMatchNode linearMatchNode2 = new LinearMatchNode(this.strings, i3 + 1, this.length - (i8 + 1), this.next);
                        this.length = i8;
                        this.next = dynamicBranchNode;
                        r0 = this;
                        r10 = linearMatchNode2;
                    }
                    ValueNode valueNodeCreateSuffixNode = stringTrieBuilder.createSuffixNode(charSequence, i + 1, i2);
                    dynamicBranchNode.add(cCharAt, r10);
                    dynamicBranchNode.add(cCharAt2, valueNodeCreateSuffixNode);
                    return r0;
                }
                i3++;
                i++;
            }
            this.next = this.next.add(stringTrieBuilder, charSequence, i, i2);
            return this;
        }

        @Override // com.ibm.icu.util.StringTrieBuilder.ValueNode, com.ibm.icu.util.StringTrieBuilder.Node
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!super.equals(obj)) {
                return false;
            }
            LinearMatchNode linearMatchNode = (LinearMatchNode) obj;
            int i = this.length;
            if (i != linearMatchNode.length || this.next != linearMatchNode.next) {
                return false;
            }
            int i2 = this.stringOffset;
            int i3 = linearMatchNode.stringOffset;
            int i4 = i + i2;
            while (i2 < i4) {
                if (this.strings.charAt(i2) != this.strings.charAt(i3)) {
                    return false;
                }
                i2++;
                i3++;
            }
            return true;
        }

        @Override // com.ibm.icu.util.StringTrieBuilder.ValueNode, com.ibm.icu.util.StringTrieBuilder.Node
        public int hashCode() {
            return this.hash;
        }

        @Override // com.ibm.icu.util.StringTrieBuilder.Node
        public int markRightEdgesFirst(int i) {
            if (this.offset != 0) {
                return i;
            }
            int iMarkRightEdgesFirst = this.next.markRightEdgesFirst(i);
            this.offset = iMarkRightEdgesFirst;
            return iMarkRightEdgesFirst;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [com.ibm.icu.util.StringTrieBuilder$Node] */
        /* JADX WARN: Type inference failed for: r5v4 */
        /* JADX WARN: Type inference failed for: r5v5 */
        @Override // com.ibm.icu.util.StringTrieBuilder.Node
        public Node register(StringTrieBuilder stringTrieBuilder) {
            ?? intermediateValueNode;
            this.next = this.next.register(stringTrieBuilder);
            int maxLinearMatchLength = stringTrieBuilder.getMaxLinearMatchLength();
            while (true) {
                int i = this.length;
                if (i <= maxLinearMatchLength) {
                    break;
                }
                int i2 = (this.stringOffset + i) - maxLinearMatchLength;
                this.length = i - maxLinearMatchLength;
                LinearMatchNode linearMatchNode = new LinearMatchNode(this.strings, i2, maxLinearMatchLength, this.next);
                linearMatchNode.setHashCode();
                this.next = stringTrieBuilder.registerNode(linearMatchNode);
            }
            if (!this.hasValue || stringTrieBuilder.matchNodesCanHaveValues()) {
                setHashCode();
                this = this;
            } else {
                int i3 = this.value;
                this.value = 0;
                this.hasValue = false;
                setHashCode();
                intermediateValueNode = new IntermediateValueNode(i3, stringTrieBuilder.registerNode(this));
            }
            return stringTrieBuilder.registerNode(intermediateValueNode);
        }

        @Override // com.ibm.icu.util.StringTrieBuilder.ValueNode, com.ibm.icu.util.StringTrieBuilder.Node
        public void write(StringTrieBuilder stringTrieBuilder) {
            this.next.write(stringTrieBuilder);
            stringTrieBuilder.write(this.stringOffset, this.length);
            this.offset = stringTrieBuilder.writeValueAndType(this.hasValue, this.value, (stringTrieBuilder.getMinLinearMatch() + this.length) - 1);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public enum Option {
        FAST,
        SMALL
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class SplitBranchNode extends BranchNode {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private Node greaterOrEqual;
        private Node lessThan;
        private char unit;

        public SplitBranchNode(char c, Node node, Node node2) {
            this.hash = ((((206918985 + c) * 37) + node.hashCode()) * 37) + node2.hashCode();
            this.unit = c;
            this.lessThan = node;
            this.greaterOrEqual = node2;
        }

        @Override // com.ibm.icu.util.StringTrieBuilder.Node
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!super.equals(obj)) {
                return false;
            }
            SplitBranchNode splitBranchNode = (SplitBranchNode) obj;
            return this.unit == splitBranchNode.unit && this.lessThan == splitBranchNode.lessThan && this.greaterOrEqual == splitBranchNode.greaterOrEqual;
        }

        @Override // com.ibm.icu.util.StringTrieBuilder.BranchNode, com.ibm.icu.util.StringTrieBuilder.Node
        public int hashCode() {
            return super.hashCode();
        }

        @Override // com.ibm.icu.util.StringTrieBuilder.Node
        public int markRightEdgesFirst(int i) {
            if (this.offset != 0) {
                return i;
            }
            this.firstEdgeNumber = i;
            int iMarkRightEdgesFirst = this.lessThan.markRightEdgesFirst(this.greaterOrEqual.markRightEdgesFirst(i) - 1);
            this.offset = iMarkRightEdgesFirst;
            return iMarkRightEdgesFirst;
        }

        @Override // com.ibm.icu.util.StringTrieBuilder.Node
        public void write(StringTrieBuilder stringTrieBuilder) {
            this.lessThan.writeUnlessInsideRightEdge(this.firstEdgeNumber, this.greaterOrEqual.getOffset(), stringTrieBuilder);
            this.greaterOrEqual.write(stringTrieBuilder);
            stringTrieBuilder.writeDeltaTo(this.lessThan.getOffset());
            this.offset = stringTrieBuilder.write(this.unit);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public enum State {
        ADDING,
        BUILDING_FAST,
        BUILDING_SMALL,
        BUILT
    }

    @Deprecated
    public StringTrieBuilder() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ValueNode createSuffixNode(CharSequence charSequence, int i, int i2) {
        ValueNode valueNodeRegisterFinalValue = registerFinalValue(i2);
        if (i >= charSequence.length()) {
            return valueNodeRegisterFinalValue;
        }
        int length = this.strings.length();
        this.strings.append(charSequence, i, charSequence.length());
        return new LinearMatchNode(this.strings, length, charSequence.length() - i, valueNodeRegisterFinalValue);
    }

    private final ValueNode registerFinalValue(int i) {
        this.lookupFinalValueNode.setFinalValue(i);
        Node node = this.nodes.get(this.lookupFinalValueNode);
        if (node != null) {
            return (ValueNode) node;
        }
        ValueNode valueNode = new ValueNode(i);
        this.nodes.put(valueNode, valueNode);
        return valueNode;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Node registerNode(Node node) {
        if (this.state == State.BUILDING_FAST) {
            return node;
        }
        Node node2 = this.nodes.get(node);
        if (node2 != null) {
            return node2;
        }
        this.nodes.put(node, node);
        return node;
    }

    @Deprecated
    public void addImpl(CharSequence charSequence, int i) {
        if (this.state != State.ADDING) {
            og.n("Cannot add (string, value) pairs after build().");
            return;
        }
        if (charSequence.length() > 65535) {
            og.o("The maximum string length is 0xffff.");
            return;
        }
        Node node = this.root;
        if (node == null) {
            this.root = createSuffixNode(charSequence, 0, i);
        } else {
            this.root = node.add(this, charSequence, 0, i);
        }
    }

    @Deprecated
    public final void buildImpl(Option option) {
        int i = AnonymousClass1.$SwitchMap$com$ibm$icu$util$StringTrieBuilder$State[this.state.ordinal()];
        if (i != 1) {
            if (i == 2 || i == 3) {
                og.n("Builder failed and must be clear()ed.");
                return;
            } else if (i == 4) {
                return;
            }
        } else if (this.root == null) {
            og.o("No (string, value) pairs were added.");
            return;
        } else if (option == Option.FAST) {
            this.state = State.BUILDING_FAST;
        } else {
            this.state = State.BUILDING_SMALL;
        }
        Node nodeRegister = this.root.register(this);
        this.root = nodeRegister;
        nodeRegister.markRightEdgesFirst(-1);
        this.root.write(this);
        this.state = State.BUILT;
    }

    @Deprecated
    public void clearImpl() {
        this.strings.setLength(0);
        this.nodes.clear();
        this.root = null;
        this.state = State.ADDING;
    }

    @Deprecated
    public abstract int getMaxBranchLinearSubNodeLength();

    @Deprecated
    public abstract int getMaxLinearMatchLength();

    @Deprecated
    public abstract int getMinLinearMatch();

    @Deprecated
    public abstract boolean matchNodesCanHaveValues();

    @Deprecated
    public abstract int write(int i);

    @Deprecated
    public abstract int write(int i, int i2);

    @Deprecated
    public abstract int writeDeltaTo(int i);

    @Deprecated
    public abstract int writeValueAndFinal(int i, boolean z);

    @Deprecated
    public abstract int writeValueAndType(boolean z, int i, int i2);

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class ValueNode extends Node {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        protected boolean hasValue;
        protected int value;

        public ValueNode(int i) {
            this.hasValue = true;
            this.value = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setFinalValue(int i) {
            this.hasValue = true;
            this.value = i;
        }

        @Override // com.ibm.icu.util.StringTrieBuilder.Node
        public Node add(StringTrieBuilder stringTrieBuilder, CharSequence charSequence, int i, int i2) {
            if (i == charSequence.length()) {
                og.i("Duplicate string.");
                return null;
            }
            ValueNode valueNodeCreateSuffixNode = stringTrieBuilder.createSuffixNode(charSequence, i, i2);
            valueNodeCreateSuffixNode.setValue(this.value);
            return valueNodeCreateSuffixNode;
        }

        @Override // com.ibm.icu.util.StringTrieBuilder.Node
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!super.equals(obj)) {
                return false;
            }
            ValueNode valueNode = (ValueNode) obj;
            boolean z = this.hasValue;
            return z == valueNode.hasValue && (!z || this.value == valueNode.value);
        }

        @Override // com.ibm.icu.util.StringTrieBuilder.Node
        public int hashCode() {
            if (this.hasValue) {
                return 41383797 + this.value;
            }
            return 1118481;
        }

        public final void setValue(int i) {
            this.hasValue = true;
            this.value = i;
        }

        @Override // com.ibm.icu.util.StringTrieBuilder.Node
        public void write(StringTrieBuilder stringTrieBuilder) {
            this.offset = stringTrieBuilder.writeValueAndFinal(this.value, true);
        }

        public ValueNode() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static abstract class Node {
        protected int offset = 0;

        public boolean equals(Object obj) {
            return this == obj || getClass() == obj.getClass();
        }

        public final int getOffset() {
            return this.offset;
        }

        public abstract int hashCode();

        public int markRightEdgesFirst(int i) {
            if (this.offset == 0) {
                this.offset = i;
            }
            return i;
        }

        public abstract void write(StringTrieBuilder stringTrieBuilder);

        public final void writeUnlessInsideRightEdge(int i, int i2, StringTrieBuilder stringTrieBuilder) {
            int i3 = this.offset;
            if (i3 < 0) {
                if (i3 < i2 || i < i3) {
                    write(stringTrieBuilder);
                }
            }
        }

        public Node register(StringTrieBuilder stringTrieBuilder) {
            return this;
        }

        public Node add(StringTrieBuilder stringTrieBuilder, CharSequence charSequence, int i, int i2) {
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class ListBranchNode extends BranchNode {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private Node[] equal;
        private int length;
        private char[] units;
        private int[] values;

        public ListBranchNode(int i) {
            this.hash = 165535188 + i;
            this.equal = new Node[i];
            this.values = new int[i];
            this.units = new char[i];
        }

        public void add(int i, Node node) {
            char[] cArr = this.units;
            int i2 = this.length;
            cArr[i2] = (char) i;
            this.equal[i2] = node;
            this.values[i2] = 0;
            this.length = i2 + 1;
            this.hash = (((this.hash * 37) + i) * 37) + node.hashCode();
        }

        @Override // com.ibm.icu.util.StringTrieBuilder.Node
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!super.equals(obj)) {
                return false;
            }
            ListBranchNode listBranchNode = (ListBranchNode) obj;
            for (int i = 0; i < this.length; i++) {
                if (this.units[i] != listBranchNode.units[i] || this.values[i] != listBranchNode.values[i] || this.equal[i] != listBranchNode.equal[i]) {
                    return false;
                }
            }
            return true;
        }

        @Override // com.ibm.icu.util.StringTrieBuilder.BranchNode, com.ibm.icu.util.StringTrieBuilder.Node
        public int hashCode() {
            return super.hashCode();
        }

        @Override // com.ibm.icu.util.StringTrieBuilder.Node
        public int markRightEdgesFirst(int i) {
            if (this.offset != 0) {
                return i;
            }
            this.firstEdgeNumber = i;
            int i2 = this.length;
            int i3 = 0;
            while (true) {
                i2--;
                Node node = this.equal[i2];
                if (node != null) {
                    i = node.markRightEdgesFirst(i - i3);
                }
                if (i2 <= 0) {
                    this.offset = i;
                    return i;
                }
                i3 = 1;
            }
        }

        @Override // com.ibm.icu.util.StringTrieBuilder.Node
        public void write(StringTrieBuilder stringTrieBuilder) {
            int offset;
            boolean z;
            int i = this.length - 1;
            Node node = this.equal[i];
            int offset2 = node == null ? this.firstEdgeNumber : node.getOffset();
            do {
                i--;
                Node node2 = this.equal[i];
                if (node2 != null) {
                    node2.writeUnlessInsideRightEdge(this.firstEdgeNumber, offset2, stringTrieBuilder);
                }
            } while (i > 0);
            int i2 = this.length - 1;
            if (node == null) {
                stringTrieBuilder.writeValueAndFinal(this.values[i2], true);
            } else {
                node.write(stringTrieBuilder);
            }
            this.offset = stringTrieBuilder.write(this.units[i2]);
            while (true) {
                i2--;
                if (i2 < 0) {
                    return;
                }
                Node node3 = this.equal[i2];
                if (node3 == null) {
                    offset = this.values[i2];
                    z = true;
                } else {
                    offset = this.offset - node3.getOffset();
                    z = false;
                }
                stringTrieBuilder.writeValueAndFinal(offset, z);
                this.offset = stringTrieBuilder.write(this.units[i2]);
            }
        }

        public void add(int i, int i2) {
            char[] cArr = this.units;
            int i3 = this.length;
            cArr[i3] = (char) i;
            this.equal[i3] = null;
            this.values[i3] = i2;
            this.length = i3 + 1;
            this.hash = (((this.hash * 37) + i) * 37) + i2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class DynamicBranchNode extends ValueNode {
        private StringBuilder chars = new StringBuilder();
        private ArrayList<Node> equal = new ArrayList<>();

        private int find(char c) {
            int length = this.chars.length();
            int i = 0;
            while (i < length) {
                int i2 = (i + length) / 2;
                char cCharAt = this.chars.charAt(i2);
                if (c < cCharAt) {
                    length = i2;
                } else {
                    if (c == cCharAt) {
                        return i2;
                    }
                    i = i2 + 1;
                }
            }
            return i;
        }

        private Node register(StringTrieBuilder stringTrieBuilder, int i, int i2) {
            int i3 = i2 - i;
            if (i3 > stringTrieBuilder.getMaxBranchLinearSubNodeLength()) {
                int i4 = (i3 / 2) + i;
                return stringTrieBuilder.registerNode(new SplitBranchNode(this.chars.charAt(i4), register(stringTrieBuilder, i, i4), register(stringTrieBuilder, i4, i2)));
            }
            ListBranchNode listBranchNode = new ListBranchNode(i3);
            do {
                char cCharAt = this.chars.charAt(i);
                Node node = this.equal.get(i);
                if (node.getClass() == ValueNode.class) {
                    listBranchNode.add(cCharAt, ((ValueNode) node).value);
                } else {
                    listBranchNode.add(cCharAt, node.register(stringTrieBuilder));
                }
                i++;
            } while (i < i2);
            return stringTrieBuilder.registerNode(listBranchNode);
        }

        @Override // com.ibm.icu.util.StringTrieBuilder.ValueNode, com.ibm.icu.util.StringTrieBuilder.Node
        public Node add(StringTrieBuilder stringTrieBuilder, CharSequence charSequence, int i, int i2) {
            if (i == charSequence.length()) {
                if (this.hasValue) {
                    og.i("Duplicate string.");
                    return null;
                }
                setValue(i2);
                return this;
            }
            int i3 = i + 1;
            char cCharAt = charSequence.charAt(i);
            int iFind = find(cCharAt);
            if (iFind >= this.chars.length() || cCharAt != this.chars.charAt(iFind)) {
                this.chars.insert(iFind, cCharAt);
                this.equal.add(iFind, stringTrieBuilder.createSuffixNode(charSequence, i3, i2));
                return this;
            }
            ArrayList<Node> arrayList = this.equal;
            arrayList.set(iFind, arrayList.get(iFind).add(stringTrieBuilder, charSequence, i3, i2));
            return this;
        }

        public void add(char c, Node node) {
            int iFind = find(c);
            this.chars.insert(iFind, c);
            this.equal.add(iFind, node);
        }

        @Override // com.ibm.icu.util.StringTrieBuilder.Node
        public Node register(StringTrieBuilder stringTrieBuilder) {
            ValueNode branchHeadNode = new BranchHeadNode(this.chars.length(), register(stringTrieBuilder, 0, this.chars.length()));
            if (this.hasValue) {
                boolean zMatchNodesCanHaveValues = stringTrieBuilder.matchNodesCanHaveValues();
                int i = this.value;
                if (zMatchNodesCanHaveValues) {
                    branchHeadNode.setValue(i);
                } else {
                    branchHeadNode = new IntermediateValueNode(i, stringTrieBuilder.registerNode(branchHeadNode));
                }
            }
            return stringTrieBuilder.registerNode(branchHeadNode);
        }
    }
}
