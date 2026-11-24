package com.ibm.icu.text;

import com.ibm.icu.lang.UCharacter;
import defpackage.dk0;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class BidiTransform {
    private Bidi bidi;
    private int reorderingOptions;
    private int shapingOptions;
    private String text;

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public enum Mirroring {
        OFF,
        ON
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public enum Order {
        LOGICAL,
        VISUAL
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean IsLTR(byte b) {
        return (b & 1) == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean IsLogical(Order order) {
        return Order.LOGICAL.equals(order);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean IsRTL(byte b) {
        return (b & 1) == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean IsVisual(Order order) {
        return Order.VISUAL.equals(order);
    }

    private ReorderingScheme findMatchingScheme(byte b, Order order, byte b2, Order order2) {
        for (ReorderingScheme reorderingScheme : ReorderingScheme.values()) {
            if (reorderingScheme.matches(b, order, b2, order2)) {
                return reorderingScheme;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mirror() {
        if ((this.reorderingOptions & 2) == 0) {
            return;
        }
        StringBuffer stringBuffer = new StringBuffer(this.text.length() * 2);
        byte[] levels = this.bidi.getLevels();
        int length = levels.length;
        int i = 0;
        while (i < length) {
            int iCharAt = UTF16.charAt(this.text, i);
            int charCount = UTF16.getCharCount(iCharAt);
            if ((levels[i] & 1) != 0) {
                iCharAt = UCharacter.getMirror(iCharAt);
            }
            UTF16.append(stringBuffer, iCharAt);
            i += charCount;
        }
        this.text = stringBuffer.toString();
        this.reorderingOptions &= -3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reorder() {
        this.text = this.bidi.writeReordered(this.reorderingOptions);
        this.reorderingOptions = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resolve(byte b, int i) {
        this.bidi.setInverse((i & 5) != 0);
        this.bidi.setReorderingMode(i);
        this.bidi.setPara(this.text, b, (byte[]) null);
    }

    private void resolveBaseDirection(byte[] bArr) {
        if (Bidi.IsDefaultLevel(bArr[0])) {
            byte baseDirection = Bidi.getBaseDirection(this.text);
            if (baseDirection == 3) {
                baseDirection = bArr[0] == 127 ? (byte) 1 : (byte) 0;
            }
            bArr[0] = baseDirection;
        } else {
            bArr[0] = (byte) (bArr[0] & 1);
        }
        if (Bidi.IsDefaultLevel(bArr[1])) {
            bArr[1] = bArr[0];
        } else {
            bArr[1] = (byte) (bArr[1] & 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reverse() {
        this.text = Bidi.writeReverse(this.text, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void shapeArabic(int i, int i2) {
        int i3 = this.shapingOptions;
        if (i == i2) {
            shapeArabic(i | i3);
        } else {
            shapeArabic(i | (i3 & (-25)));
            shapeArabic((this.shapingOptions & (-225)) | i2);
        }
    }

    public String transform(CharSequence charSequence, byte b, Order order, byte b2, Order order2, Mirroring mirroring, int i) {
        if (charSequence == null || order == null || order2 == null || mirroring == null) {
            dk0.v();
            return null;
        }
        this.text = charSequence.toString();
        byte[] bArr = {b, b2};
        resolveBaseDirection(bArr);
        ReorderingScheme reorderingSchemeFindMatchingScheme = findMatchingScheme(bArr[0], order, bArr[1], order2);
        if (reorderingSchemeFindMatchingScheme != null) {
            this.bidi = new Bidi();
            this.reorderingOptions = Mirroring.ON.equals(mirroring) ? 2 : 0;
            this.shapingOptions = i & (-5);
            reorderingSchemeFindMatchingScheme.doTransform(this);
        }
        return this.text;
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static abstract class ReorderingScheme {
        private static final /* synthetic */ ReorderingScheme[] $VALUES;
        public static final ReorderingScheme LOG_LTR_TO_LOG_LTR;
        public static final ReorderingScheme LOG_LTR_TO_LOG_RTL;
        public static final ReorderingScheme LOG_LTR_TO_VIS_LTR;
        public static final ReorderingScheme LOG_LTR_TO_VIS_RTL;
        public static final ReorderingScheme LOG_RTL_TO_LOG_LTR;
        public static final ReorderingScheme LOG_RTL_TO_LOG_RTL;
        public static final ReorderingScheme LOG_RTL_TO_VIS_LTR;
        public static final ReorderingScheme LOG_RTL_TO_VIS_RTL;
        public static final ReorderingScheme VIS_LTR_TO_LOG_LTR;
        public static final ReorderingScheme VIS_LTR_TO_LOG_RTL;
        public static final ReorderingScheme VIS_LTR_TO_VIS_LTR;
        public static final ReorderingScheme VIS_LTR_TO_VIS_RTL;
        public static final ReorderingScheme VIS_RTL_TO_LOG_LTR;
        public static final ReorderingScheme VIS_RTL_TO_LOG_RTL;
        public static final ReorderingScheme VIS_RTL_TO_VIS_LTR;
        public static final ReorderingScheme VIS_RTL_TO_VIS_RTL;

        static {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1();
            LOG_LTR_TO_VIS_LTR = anonymousClass1;
            AnonymousClass2 anonymousClass2 = new AnonymousClass2();
            LOG_RTL_TO_VIS_LTR = anonymousClass2;
            AnonymousClass3 anonymousClass3 = new AnonymousClass3();
            LOG_LTR_TO_VIS_RTL = anonymousClass3;
            AnonymousClass4 anonymousClass4 = new AnonymousClass4();
            LOG_RTL_TO_VIS_RTL = anonymousClass4;
            AnonymousClass5 anonymousClass5 = new AnonymousClass5();
            VIS_LTR_TO_LOG_RTL = anonymousClass5;
            AnonymousClass6 anonymousClass6 = new AnonymousClass6();
            VIS_RTL_TO_LOG_RTL = anonymousClass6;
            AnonymousClass7 anonymousClass7 = new AnonymousClass7();
            VIS_LTR_TO_LOG_LTR = anonymousClass7;
            AnonymousClass8 anonymousClass8 = new AnonymousClass8();
            VIS_RTL_TO_LOG_LTR = anonymousClass8;
            AnonymousClass9 anonymousClass9 = new AnonymousClass9();
            LOG_LTR_TO_LOG_RTL = anonymousClass9;
            AnonymousClass10 anonymousClass10 = new AnonymousClass10();
            LOG_RTL_TO_LOG_LTR = anonymousClass10;
            AnonymousClass11 anonymousClass11 = new AnonymousClass11();
            VIS_LTR_TO_VIS_RTL = anonymousClass11;
            AnonymousClass12 anonymousClass12 = new AnonymousClass12();
            VIS_RTL_TO_VIS_LTR = anonymousClass12;
            AnonymousClass13 anonymousClass13 = new AnonymousClass13();
            LOG_LTR_TO_LOG_LTR = anonymousClass13;
            AnonymousClass14 anonymousClass14 = new AnonymousClass14();
            LOG_RTL_TO_LOG_RTL = anonymousClass14;
            AnonymousClass15 anonymousClass15 = new AnonymousClass15();
            VIS_LTR_TO_VIS_LTR = anonymousClass15;
            AnonymousClass16 anonymousClass16 = new AnonymousClass16();
            VIS_RTL_TO_VIS_RTL = anonymousClass16;
            $VALUES = new ReorderingScheme[]{anonymousClass1, anonymousClass2, anonymousClass3, anonymousClass4, anonymousClass5, anonymousClass6, anonymousClass7, anonymousClass8, anonymousClass9, anonymousClass10, anonymousClass11, anonymousClass12, anonymousClass13, anonymousClass14, anonymousClass15, anonymousClass16};
        }

        public /* synthetic */ ReorderingScheme(String str, int i, int i2) {
            this(str, i);
        }

        public static ReorderingScheme valueOf(String str) {
            return (ReorderingScheme) Enum.valueOf(ReorderingScheme.class, str);
        }

        public static ReorderingScheme[] values() {
            return (ReorderingScheme[]) $VALUES.clone();
        }

        public abstract void doTransform(BidiTransform bidiTransform);

        public abstract boolean matches(byte b, Order order, byte b2, Order order2);

        private ReorderingScheme(String str, int i) {
            super(str, i);
        }

        /* JADX INFO: renamed from: com.ibm.icu.text.BidiTransform$ReorderingScheme$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
        public final enum AnonymousClass1 extends ReorderingScheme {
            public /* synthetic */ AnonymousClass1() {
                this("LOG_LTR_TO_VIS_LTR", 0);
            }

            @Override // com.ibm.icu.text.BidiTransform.ReorderingScheme
            public void doTransform(BidiTransform bidiTransform) {
                bidiTransform.shapeArabic(0, 0);
                bidiTransform.resolve((byte) 0, 0);
                bidiTransform.reorder();
            }

            @Override // com.ibm.icu.text.BidiTransform.ReorderingScheme
            public boolean matches(byte b, Order order, byte b2, Order order2) {
                return BidiTransform.IsLTR(b) && BidiTransform.IsLogical(order) && BidiTransform.IsLTR(b2) && BidiTransform.IsVisual(order2);
            }

            private AnonymousClass1(String str, int i) {
                super(str, i, 0);
            }
        }

        /* JADX INFO: renamed from: com.ibm.icu.text.BidiTransform$ReorderingScheme$2, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
        public final enum AnonymousClass2 extends ReorderingScheme {
            public /* synthetic */ AnonymousClass2() {
                this("LOG_RTL_TO_VIS_LTR", 1);
            }

            @Override // com.ibm.icu.text.BidiTransform.ReorderingScheme
            public void doTransform(BidiTransform bidiTransform) {
                bidiTransform.resolve((byte) 1, 0);
                bidiTransform.reorder();
                bidiTransform.shapeArabic(0, 4);
            }

            @Override // com.ibm.icu.text.BidiTransform.ReorderingScheme
            public boolean matches(byte b, Order order, byte b2, Order order2) {
                return BidiTransform.IsRTL(b) && BidiTransform.IsLogical(order) && BidiTransform.IsLTR(b2) && BidiTransform.IsVisual(order2);
            }

            private AnonymousClass2(String str, int i) {
                super(str, i, 0);
            }
        }

        /* JADX INFO: renamed from: com.ibm.icu.text.BidiTransform$ReorderingScheme$3, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
        public final enum AnonymousClass3 extends ReorderingScheme {
            public /* synthetic */ AnonymousClass3() {
                this("LOG_LTR_TO_VIS_RTL", 2);
            }

            @Override // com.ibm.icu.text.BidiTransform.ReorderingScheme
            public void doTransform(BidiTransform bidiTransform) {
                bidiTransform.shapeArabic(0, 0);
                bidiTransform.resolve((byte) 0, 0);
                bidiTransform.reorder();
                bidiTransform.reverse();
            }

            @Override // com.ibm.icu.text.BidiTransform.ReorderingScheme
            public boolean matches(byte b, Order order, byte b2, Order order2) {
                return BidiTransform.IsLTR(b) && BidiTransform.IsLogical(order) && BidiTransform.IsRTL(b2) && BidiTransform.IsVisual(order2);
            }

            private AnonymousClass3(String str, int i) {
                super(str, i, 0);
            }
        }

        /* JADX INFO: renamed from: com.ibm.icu.text.BidiTransform$ReorderingScheme$4, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
        public final enum AnonymousClass4 extends ReorderingScheme {
            public /* synthetic */ AnonymousClass4() {
                this("LOG_RTL_TO_VIS_RTL", 3);
            }

            @Override // com.ibm.icu.text.BidiTransform.ReorderingScheme
            public void doTransform(BidiTransform bidiTransform) {
                bidiTransform.resolve((byte) 1, 0);
                bidiTransform.reorder();
                bidiTransform.shapeArabic(0, 4);
                bidiTransform.reverse();
            }

            @Override // com.ibm.icu.text.BidiTransform.ReorderingScheme
            public boolean matches(byte b, Order order, byte b2, Order order2) {
                return BidiTransform.IsRTL(b) && BidiTransform.IsLogical(order) && BidiTransform.IsRTL(b2) && BidiTransform.IsVisual(order2);
            }

            private AnonymousClass4(String str, int i) {
                super(str, i, 0);
            }
        }

        /* JADX INFO: renamed from: com.ibm.icu.text.BidiTransform$ReorderingScheme$5, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
        public final enum AnonymousClass5 extends ReorderingScheme {
            public /* synthetic */ AnonymousClass5() {
                this("VIS_LTR_TO_LOG_RTL", 4);
            }

            @Override // com.ibm.icu.text.BidiTransform.ReorderingScheme
            public void doTransform(BidiTransform bidiTransform) {
                bidiTransform.shapeArabic(0, 4);
                bidiTransform.resolve((byte) 1, 5);
                bidiTransform.reorder();
            }

            @Override // com.ibm.icu.text.BidiTransform.ReorderingScheme
            public boolean matches(byte b, Order order, byte b2, Order order2) {
                return BidiTransform.IsLTR(b) && BidiTransform.IsVisual(order) && BidiTransform.IsRTL(b2) && BidiTransform.IsLogical(order2);
            }

            private AnonymousClass5(String str, int i) {
                super(str, i, 0);
            }
        }

        /* JADX INFO: renamed from: com.ibm.icu.text.BidiTransform$ReorderingScheme$6, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
        public final enum AnonymousClass6 extends ReorderingScheme {
            public /* synthetic */ AnonymousClass6() {
                this("VIS_RTL_TO_LOG_RTL", 5);
            }

            @Override // com.ibm.icu.text.BidiTransform.ReorderingScheme
            public void doTransform(BidiTransform bidiTransform) {
                bidiTransform.reverse();
                bidiTransform.shapeArabic(0, 4);
                bidiTransform.resolve((byte) 1, 5);
                bidiTransform.reorder();
            }

            @Override // com.ibm.icu.text.BidiTransform.ReorderingScheme
            public boolean matches(byte b, Order order, byte b2, Order order2) {
                return BidiTransform.IsRTL(b) && BidiTransform.IsVisual(order) && BidiTransform.IsRTL(b2) && BidiTransform.IsLogical(order2);
            }

            private AnonymousClass6(String str, int i) {
                super(str, i, 0);
            }
        }

        /* JADX INFO: renamed from: com.ibm.icu.text.BidiTransform$ReorderingScheme$7, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
        public final enum AnonymousClass7 extends ReorderingScheme {
            public /* synthetic */ AnonymousClass7() {
                this("VIS_LTR_TO_LOG_LTR", 6);
            }

            @Override // com.ibm.icu.text.BidiTransform.ReorderingScheme
            public void doTransform(BidiTransform bidiTransform) {
                bidiTransform.resolve((byte) 0, 5);
                bidiTransform.reorder();
                bidiTransform.shapeArabic(0, 0);
            }

            @Override // com.ibm.icu.text.BidiTransform.ReorderingScheme
            public boolean matches(byte b, Order order, byte b2, Order order2) {
                return BidiTransform.IsLTR(b) && BidiTransform.IsVisual(order) && BidiTransform.IsLTR(b2) && BidiTransform.IsLogical(order2);
            }

            private AnonymousClass7(String str, int i) {
                super(str, i, 0);
            }
        }

        /* JADX INFO: renamed from: com.ibm.icu.text.BidiTransform$ReorderingScheme$8, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
        public final enum AnonymousClass8 extends ReorderingScheme {
            public /* synthetic */ AnonymousClass8() {
                this("VIS_RTL_TO_LOG_LTR", 7);
            }

            @Override // com.ibm.icu.text.BidiTransform.ReorderingScheme
            public void doTransform(BidiTransform bidiTransform) {
                bidiTransform.reverse();
                bidiTransform.resolve((byte) 0, 5);
                bidiTransform.reorder();
                bidiTransform.shapeArabic(0, 0);
            }

            @Override // com.ibm.icu.text.BidiTransform.ReorderingScheme
            public boolean matches(byte b, Order order, byte b2, Order order2) {
                return BidiTransform.IsRTL(b) && BidiTransform.IsVisual(order) && BidiTransform.IsLTR(b2) && BidiTransform.IsLogical(order2);
            }

            private AnonymousClass8(String str, int i) {
                super(str, i, 0);
            }
        }

        /* JADX INFO: renamed from: com.ibm.icu.text.BidiTransform$ReorderingScheme$10, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
        public final enum AnonymousClass10 extends ReorderingScheme {
            public /* synthetic */ AnonymousClass10() {
                this("LOG_RTL_TO_LOG_LTR", 9);
            }

            @Override // com.ibm.icu.text.BidiTransform.ReorderingScheme
            public void doTransform(BidiTransform bidiTransform) {
                bidiTransform.resolve((byte) 1, 0);
                bidiTransform.mirror();
                bidiTransform.resolve((byte) 1, 3);
                bidiTransform.reorder();
                bidiTransform.shapeArabic(0, 0);
            }

            @Override // com.ibm.icu.text.BidiTransform.ReorderingScheme
            public boolean matches(byte b, Order order, byte b2, Order order2) {
                return BidiTransform.IsRTL(b) && BidiTransform.IsLogical(order) && BidiTransform.IsLTR(b2) && BidiTransform.IsLogical(order2);
            }

            private AnonymousClass10(String str, int i) {
                super(str, i, 0);
            }
        }

        /* JADX INFO: renamed from: com.ibm.icu.text.BidiTransform$ReorderingScheme$11, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
        public final enum AnonymousClass11 extends ReorderingScheme {
            public /* synthetic */ AnonymousClass11() {
                this("VIS_LTR_TO_VIS_RTL", 10);
            }

            @Override // com.ibm.icu.text.BidiTransform.ReorderingScheme
            public void doTransform(BidiTransform bidiTransform) {
                bidiTransform.resolve((byte) 0, 0);
                bidiTransform.mirror();
                bidiTransform.shapeArabic(0, 4);
                bidiTransform.reverse();
            }

            @Override // com.ibm.icu.text.BidiTransform.ReorderingScheme
            public boolean matches(byte b, Order order, byte b2, Order order2) {
                return BidiTransform.IsLTR(b) && BidiTransform.IsVisual(order) && BidiTransform.IsRTL(b2) && BidiTransform.IsVisual(order2);
            }

            private AnonymousClass11(String str, int i) {
                super(str, i, 0);
            }
        }

        /* JADX INFO: renamed from: com.ibm.icu.text.BidiTransform$ReorderingScheme$12, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
        public final enum AnonymousClass12 extends ReorderingScheme {
            public /* synthetic */ AnonymousClass12() {
                this("VIS_RTL_TO_VIS_LTR", 11);
            }

            @Override // com.ibm.icu.text.BidiTransform.ReorderingScheme
            public void doTransform(BidiTransform bidiTransform) {
                bidiTransform.reverse();
                bidiTransform.resolve((byte) 0, 0);
                bidiTransform.mirror();
                bidiTransform.shapeArabic(0, 4);
            }

            @Override // com.ibm.icu.text.BidiTransform.ReorderingScheme
            public boolean matches(byte b, Order order, byte b2, Order order2) {
                return BidiTransform.IsRTL(b) && BidiTransform.IsVisual(order) && BidiTransform.IsLTR(b2) && BidiTransform.IsVisual(order2);
            }

            private AnonymousClass12(String str, int i) {
                super(str, i, 0);
            }
        }

        /* JADX INFO: renamed from: com.ibm.icu.text.BidiTransform$ReorderingScheme$13, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
        public final enum AnonymousClass13 extends ReorderingScheme {
            public /* synthetic */ AnonymousClass13() {
                this("LOG_LTR_TO_LOG_LTR", 12);
            }

            @Override // com.ibm.icu.text.BidiTransform.ReorderingScheme
            public void doTransform(BidiTransform bidiTransform) {
                bidiTransform.resolve((byte) 0, 0);
                bidiTransform.mirror();
                bidiTransform.shapeArabic(0, 0);
            }

            @Override // com.ibm.icu.text.BidiTransform.ReorderingScheme
            public boolean matches(byte b, Order order, byte b2, Order order2) {
                return BidiTransform.IsLTR(b) && BidiTransform.IsLogical(order) && BidiTransform.IsLTR(b2) && BidiTransform.IsLogical(order2);
            }

            private AnonymousClass13(String str, int i) {
                super(str, i, 0);
            }
        }

        /* JADX INFO: renamed from: com.ibm.icu.text.BidiTransform$ReorderingScheme$14, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
        public final enum AnonymousClass14 extends ReorderingScheme {
            public /* synthetic */ AnonymousClass14() {
                this("LOG_RTL_TO_LOG_RTL", 13);
            }

            @Override // com.ibm.icu.text.BidiTransform.ReorderingScheme
            public void doTransform(BidiTransform bidiTransform) {
                bidiTransform.resolve((byte) 1, 0);
                bidiTransform.mirror();
                bidiTransform.shapeArabic(4, 0);
            }

            @Override // com.ibm.icu.text.BidiTransform.ReorderingScheme
            public boolean matches(byte b, Order order, byte b2, Order order2) {
                return BidiTransform.IsRTL(b) && BidiTransform.IsLogical(order) && BidiTransform.IsRTL(b2) && BidiTransform.IsLogical(order2);
            }

            private AnonymousClass14(String str, int i) {
                super(str, i, 0);
            }
        }

        /* JADX INFO: renamed from: com.ibm.icu.text.BidiTransform$ReorderingScheme$15, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
        public final enum AnonymousClass15 extends ReorderingScheme {
            public /* synthetic */ AnonymousClass15() {
                this("VIS_LTR_TO_VIS_LTR", 14);
            }

            @Override // com.ibm.icu.text.BidiTransform.ReorderingScheme
            public void doTransform(BidiTransform bidiTransform) {
                bidiTransform.resolve((byte) 0, 0);
                bidiTransform.mirror();
                bidiTransform.shapeArabic(0, 4);
            }

            @Override // com.ibm.icu.text.BidiTransform.ReorderingScheme
            public boolean matches(byte b, Order order, byte b2, Order order2) {
                return BidiTransform.IsLTR(b) && BidiTransform.IsVisual(order) && BidiTransform.IsLTR(b2) && BidiTransform.IsVisual(order2);
            }

            private AnonymousClass15(String str, int i) {
                super(str, i, 0);
            }
        }

        /* JADX INFO: renamed from: com.ibm.icu.text.BidiTransform$ReorderingScheme$16, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
        public final enum AnonymousClass16 extends ReorderingScheme {
            public /* synthetic */ AnonymousClass16() {
                this("VIS_RTL_TO_VIS_RTL", 15);
            }

            @Override // com.ibm.icu.text.BidiTransform.ReorderingScheme
            public void doTransform(BidiTransform bidiTransform) {
                bidiTransform.reverse();
                bidiTransform.resolve((byte) 0, 0);
                bidiTransform.mirror();
                bidiTransform.shapeArabic(0, 4);
                bidiTransform.reverse();
            }

            @Override // com.ibm.icu.text.BidiTransform.ReorderingScheme
            public boolean matches(byte b, Order order, byte b2, Order order2) {
                return BidiTransform.IsRTL(b) && BidiTransform.IsVisual(order) && BidiTransform.IsRTL(b2) && BidiTransform.IsVisual(order2);
            }

            private AnonymousClass16(String str, int i) {
                super(str, i, 0);
            }
        }

        /* JADX INFO: renamed from: com.ibm.icu.text.BidiTransform$ReorderingScheme$9, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
        public final enum AnonymousClass9 extends ReorderingScheme {
            public /* synthetic */ AnonymousClass9() {
                this("LOG_LTR_TO_LOG_RTL", 8);
            }

            @Override // com.ibm.icu.text.BidiTransform.ReorderingScheme
            public void doTransform(BidiTransform bidiTransform) {
                bidiTransform.shapeArabic(0, 0);
                bidiTransform.resolve((byte) 0, 0);
                bidiTransform.mirror();
                bidiTransform.resolve((byte) 0, 3);
                bidiTransform.reorder();
            }

            @Override // com.ibm.icu.text.BidiTransform.ReorderingScheme
            public boolean matches(byte b, Order order, byte b2, Order order2) {
                return BidiTransform.IsLTR(b) && BidiTransform.IsLogical(order) && BidiTransform.IsRTL(b2) && BidiTransform.IsLogical(order2);
            }

            private AnonymousClass9(String str, int i) {
                super(str, i, 0);
            }
        }
    }

    private void shapeArabic(int i) {
        if (i != 0) {
            try {
                this.text = new ArabicShaping(i).shape(this.text);
            } catch (ArabicShapingException unused) {
            }
        }
    }
}
