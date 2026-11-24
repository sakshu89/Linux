package com.ibm.icu.impl;

import com.ibm.icu.text.ConstrainedFieldPosition;
import com.ibm.icu.text.ListFormatter;
import com.ibm.icu.text.NumberFormat;
import com.ibm.icu.text.UFormat;
import com.ibm.icu.text.UnicodeSet;
import defpackage.cq;
import defpackage.og;
import java.text.AttributedCharacterIterator;
import java.text.AttributedString;
import java.text.FieldPosition;
import java.text.Format;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class FormattedValueStringBuilderImpl {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class NullField extends Format.Field {
        static final NullField END = new NullField("end");
        private static final long serialVersionUID = 1;

        private NullField(String str) {
            super(str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class SpanFieldPlaceholder implements FormattedStringBuilder.FieldWrapper {
        public int length;
        public Format.Field normalField;
        public UFormat.SpanField spanField;
        public int start;
        public Object value;

        @Override // com.ibm.icu.impl.FormattedStringBuilder.FieldWrapper
        public Format.Field unwrap() {
            return this.normalField;
        }
    }

    public static void applySpanRange(FormattedStringBuilder formattedStringBuilder, UFormat.SpanField spanField, Object obj, int i, int i2) {
        for (int i3 = formattedStringBuilder.zero + i; i3 < formattedStringBuilder.zero + i2; i3++) {
            Object obj2 = formattedStringBuilder.fields[i3];
            SpanFieldPlaceholder spanFieldPlaceholder = new SpanFieldPlaceholder();
            spanFieldPlaceholder.spanField = spanField;
            spanFieldPlaceholder.normalField = (Format.Field) obj2;
            spanFieldPlaceholder.value = obj;
            spanFieldPlaceholder.start = i;
            spanFieldPlaceholder.length = i2 - i;
            formattedStringBuilder.fields[i3] = spanFieldPlaceholder;
        }
    }

    public static int findSpan(FormattedStringBuilder formattedStringBuilder, Object obj) {
        for (int i = formattedStringBuilder.zero; i < formattedStringBuilder.zero + formattedStringBuilder.length; i++) {
            Object obj2 = formattedStringBuilder.fields[i];
            if ((obj2 instanceof SpanFieldPlaceholder) && ((SpanFieldPlaceholder) obj2).value.equals(obj)) {
                return i - formattedStringBuilder.zero;
            }
        }
        return -1;
    }

    private static boolean isIntOrGroup(Object obj) {
        Format.Field fieldUnwrapField = FormattedStringBuilder.unwrapField(obj);
        return fieldUnwrapField == NumberFormat.Field.INTEGER || fieldUnwrapField == NumberFormat.Field.GROUPING_SEPARATOR;
    }

    private static boolean isNumericField(Object obj) {
        Format.Field fieldUnwrapField = FormattedStringBuilder.unwrapField(obj);
        return fieldUnwrapField == null || NumberFormat.Field.class.isAssignableFrom(fieldUnwrapField.getClass());
    }

    private static boolean isTrimmable(Object obj) {
        return (obj == NumberFormat.Field.GROUPING_SEPARATOR || (obj instanceof ListFormatter.Field)) ? false : true;
    }

    public static boolean nextFieldPosition(FormattedStringBuilder formattedStringBuilder, FieldPosition fieldPosition) {
        Format.Field fieldAttribute = fieldPosition.getFieldAttribute();
        if (fieldAttribute == null) {
            if (fieldPosition.getField() == 0) {
                fieldAttribute = NumberFormat.Field.INTEGER;
            } else {
                if (fieldPosition.getField() != 1) {
                    return false;
                }
                fieldAttribute = NumberFormat.Field.FRACTION;
            }
        }
        if (!(fieldAttribute instanceof NumberFormat.Field)) {
            og.i(cq.j("You must pass an instance of com.ibm.icu.text.NumberFormat.Field as your FieldPosition attribute.  You passed: ", fieldAttribute.getClass().toString()));
            return false;
        }
        ConstrainedFieldPosition constrainedFieldPosition = new ConstrainedFieldPosition();
        constrainedFieldPosition.constrainField(fieldAttribute);
        constrainedFieldPosition.setState(fieldAttribute, null, fieldPosition.getBeginIndex(), fieldPosition.getEndIndex());
        if (nextPosition(formattedStringBuilder, constrainedFieldPosition, null)) {
            fieldPosition.setBeginIndex(constrainedFieldPosition.getStart());
            fieldPosition.setEndIndex(constrainedFieldPosition.getLimit());
            return true;
        }
        if (fieldAttribute == NumberFormat.Field.FRACTION && fieldPosition.getEndIndex() == 0) {
            int i = formattedStringBuilder.zero;
            boolean z = false;
            while (i < formattedStringBuilder.zero + formattedStringBuilder.length) {
                if (isIntOrGroup(formattedStringBuilder.fields[i]) || formattedStringBuilder.fields[i] == NumberFormat.Field.DECIMAL_SEPARATOR) {
                    z = true;
                } else if (z) {
                    break;
                }
                i++;
            }
            fieldPosition.setBeginIndex(i - formattedStringBuilder.zero);
            fieldPosition.setEndIndex(i - formattedStringBuilder.zero);
        }
        return false;
    }

    public static boolean nextPosition(FormattedStringBuilder formattedStringBuilder, ConstrainedFieldPosition constrainedFieldPosition, Format.Field field) {
        boolean z;
        Object obj;
        SpanFieldPlaceholder spanFieldPlaceholder;
        int i;
        boolean z2 = true;
        boolean z3 = constrainedFieldPosition.getLimit() > 0 && (constrainedFieldPosition.getField() instanceof UFormat.SpanField) && constrainedFieldPosition.getStart() < constrainedFieldPosition.getLimit();
        boolean z4 = field != null && constrainedFieldPosition.getField() == field;
        boolean z5 = constrainedFieldPosition.getField() == NumberFormat.Field.INTEGER;
        int limit = constrainedFieldPosition.getLimit() + formattedStringBuilder.zero;
        int iTrimFront = -1;
        Object obj2 = null;
        while (true) {
            int i2 = formattedStringBuilder.zero;
            int i3 = formattedStringBuilder.length;
            if (limit > i2 + i3) {
                Format.Field field2 = constrainedFieldPosition.getField();
                Object fieldValue = constrainedFieldPosition.getFieldValue();
                int i4 = formattedStringBuilder.length;
                constrainedFieldPosition.setState(field2, fieldValue, i4, i4);
                return false;
            }
            Object obj3 = limit < i3 + i2 ? formattedStringBuilder.fields[limit] : NullField.END;
            if (obj2 == null) {
                if (limit <= i2 || !z3) {
                    z = z2;
                } else {
                    Object[] objArr = formattedStringBuilder.fields;
                    SpanFieldPlaceholder spanFieldPlaceholder2 = (SpanFieldPlaceholder) objArr[limit - 1];
                    Format.Field field3 = spanFieldPlaceholder2.normalField;
                    z = z2;
                    ListFormatter.Field field4 = ListFormatter.Field.ELEMENT;
                    if (field3 != field4) {
                        limit -= spanFieldPlaceholder2.length;
                        obj3 = ((SpanFieldPlaceholder) objArr[limit]).normalField;
                    } else if (constrainedFieldPosition.matchesField(field4, null)) {
                        int i5 = limit - formattedStringBuilder.zero;
                        int i6 = spanFieldPlaceholder2.length;
                        int i7 = i5 - i6;
                        constrainedFieldPosition.setState(ListFormatter.Field.ELEMENT, null, i7, i6 + i7);
                        return z;
                    }
                }
                NumberFormat.Field field5 = NumberFormat.Field.INTEGER;
                if (constrainedFieldPosition.matchesField(field5, null) && limit > formattedStringBuilder.zero && !z5 && !z4) {
                    int i8 = limit - 1;
                    if (isIntOrGroup(formattedStringBuilder.fields[i8]) && !isIntOrGroup(obj3)) {
                        while (i8 >= formattedStringBuilder.zero && isIntOrGroup(formattedStringBuilder.fields[i8])) {
                            i8--;
                        }
                        NumberFormat.Field field6 = NumberFormat.Field.INTEGER;
                        int i9 = formattedStringBuilder.zero;
                        constrainedFieldPosition.setState(field6, null, (i8 - i9) + 1, limit - i9);
                        return z;
                    }
                }
                if (field != null && constrainedFieldPosition.matchesField(field, null) && limit > formattedStringBuilder.zero && !z4) {
                    int i10 = limit - 1;
                    if (isNumericField(formattedStringBuilder.fields[i10]) && !isNumericField(obj3)) {
                        while (i10 >= formattedStringBuilder.zero && isNumericField(formattedStringBuilder.fields[i10])) {
                            i10--;
                        }
                        int i11 = formattedStringBuilder.zero;
                        constrainedFieldPosition.setState(field, null, (i10 - i11) + 1, limit - i11);
                        return z;
                    }
                }
                if (obj3 instanceof SpanFieldPlaceholder) {
                    spanFieldPlaceholder = (SpanFieldPlaceholder) obj3;
                    obj = spanFieldPlaceholder.normalField;
                } else {
                    obj = obj3;
                    spanFieldPlaceholder = null;
                }
                if (spanFieldPlaceholder == null || !((i = spanFieldPlaceholder.start) == -1 || i == limit - formattedStringBuilder.zero)) {
                    if (obj != field5 && obj != null && obj != NullField.END && constrainedFieldPosition.matchesField((Format.Field) obj, null)) {
                        iTrimFront = limit - formattedStringBuilder.zero;
                        obj2 = obj;
                    }
                } else {
                    if (constrainedFieldPosition.matchesField(spanFieldPlaceholder.spanField, spanFieldPlaceholder.value)) {
                        int i12 = limit - formattedStringBuilder.zero;
                        constrainedFieldPosition.setState(spanFieldPlaceholder.spanField, spanFieldPlaceholder.value, i12, spanFieldPlaceholder.length + i12);
                        return z;
                    }
                    Format.Field field7 = spanFieldPlaceholder.normalField;
                    ListFormatter.Field field8 = ListFormatter.Field.ELEMENT;
                    if (field7 == field8) {
                        if (constrainedFieldPosition.matchesField(field8, null)) {
                            int i13 = limit - formattedStringBuilder.zero;
                            constrainedFieldPosition.setState(ListFormatter.Field.ELEMENT, null, i13, spanFieldPlaceholder.length + i13);
                            return z;
                        }
                        limit = (spanFieldPlaceholder.length - 1) + limit;
                    }
                }
                z3 = false;
                z4 = false;
                z5 = false;
            } else if (obj2 != obj3) {
                int iTrimBack = limit - i2;
                if (isTrimmable(obj2)) {
                    iTrimBack = trimBack(formattedStringBuilder, iTrimBack);
                }
                if (iTrimBack > iTrimFront) {
                    if (isTrimmable(obj2)) {
                        iTrimFront = trimFront(formattedStringBuilder, iTrimFront);
                    }
                    constrainedFieldPosition.setState((Format.Field) obj2, null, iTrimFront, iTrimBack);
                    return z2;
                }
                limit--;
                z = z2;
                iTrimFront = -1;
                obj2 = null;
            } else {
                z = z2;
            }
            limit++;
            z2 = z;
        }
    }

    public static AttributedCharacterIterator toCharacterIterator(FormattedStringBuilder formattedStringBuilder, Format.Field field) {
        ConstrainedFieldPosition constrainedFieldPosition = new ConstrainedFieldPosition();
        AttributedString attributedString = new AttributedString(formattedStringBuilder.toString());
        while (nextPosition(formattedStringBuilder, constrainedFieldPosition, field)) {
            Object fieldValue = constrainedFieldPosition.getFieldValue();
            if (fieldValue == null) {
                fieldValue = constrainedFieldPosition.getField();
            }
            attributedString.addAttribute(constrainedFieldPosition.getField(), fieldValue, constrainedFieldPosition.getStart(), constrainedFieldPosition.getLimit());
        }
        return attributedString.getIterator();
    }

    private static int trimBack(FormattedStringBuilder formattedStringBuilder, int i) {
        return StaticUnicodeSets.get(StaticUnicodeSets.Key.DEFAULT_IGNORABLES).spanBack(formattedStringBuilder, i, UnicodeSet.SpanCondition.CONTAINED);
    }

    private static int trimFront(FormattedStringBuilder formattedStringBuilder, int i) {
        return StaticUnicodeSets.get(StaticUnicodeSets.Key.DEFAULT_IGNORABLES).span(formattedStringBuilder, i, UnicodeSet.SpanCondition.CONTAINED);
    }
}
