package com.ibm.icu.impl;

import com.ibm.icu.text.ConstrainedFieldPosition;
import java.text.AttributedCharacterIterator;
import java.text.AttributedString;
import java.text.FieldPosition;
import java.text.Format;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class FormattedValueFieldPositionIteratorImpl {

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class FieldWithValue extends Format.Field {
        private static final long serialVersionUID = -3850076447157793465L;
        public final Format.Field field;
        public final int value;

        public FieldWithValue(Format.Field field, int i) {
            super(field.toString());
            this.field = field;
            this.value = i;
        }
    }

    private FormattedValueFieldPositionIteratorImpl() {
    }

    public static void addOverlapSpans(List<FieldPosition> list, Format.Field field, int i) {
        int size = list.size();
        int i2 = 0;
        int iMin = Integer.MAX_VALUE;
        int iMin2 = Integer.MAX_VALUE;
        int iMax = 0;
        int iMax2 = 0;
        while (i2 < size) {
            FieldPosition fieldPosition = list.get(i2);
            i2++;
            for (int i3 = i2; i3 < size; i3++) {
                FieldPosition fieldPosition2 = list.get(i3);
                if (fieldPosition.getFieldAttribute() == fieldPosition2.getFieldAttribute()) {
                    iMin = Math.min(iMin, fieldPosition.getBeginIndex());
                    iMax = Math.max(iMax, fieldPosition.getEndIndex());
                    iMin2 = Math.min(iMin2, fieldPosition2.getBeginIndex());
                    iMax2 = Math.max(iMax2, fieldPosition2.getEndIndex());
                    break;
                }
            }
        }
        if (iMin != Integer.MAX_VALUE) {
            FieldPosition fieldPosition3 = new FieldPosition(new FieldWithValue(field, i));
            fieldPosition3.setBeginIndex(iMin);
            fieldPosition3.setEndIndex(iMax);
            list.add(fieldPosition3);
            FieldPosition fieldPosition4 = new FieldPosition(new FieldWithValue(field, 1 - i));
            fieldPosition4.setBeginIndex(iMin2);
            fieldPosition4.setEndIndex(iMax2);
            list.add(fieldPosition4);
        }
    }

    public static boolean nextPosition(List<FieldPosition> list, ConstrainedFieldPosition constrainedFieldPosition) {
        Integer numValueOf;
        int size = list.size();
        int int64IterationContext = (int) constrainedFieldPosition.getInt64IterationContext();
        while (int64IterationContext < size) {
            FieldPosition fieldPosition = list.get(int64IterationContext);
            Format.Field fieldAttribute = fieldPosition.getFieldAttribute();
            if (fieldAttribute instanceof FieldWithValue) {
                FieldWithValue fieldWithValue = (FieldWithValue) fieldAttribute;
                numValueOf = Integer.valueOf(fieldWithValue.value);
                fieldAttribute = fieldWithValue.field;
            } else {
                numValueOf = null;
            }
            if (constrainedFieldPosition.matchesField(fieldAttribute, numValueOf)) {
                constrainedFieldPosition.setState(fieldAttribute, numValueOf, fieldPosition.getBeginIndex(), fieldPosition.getEndIndex());
                break;
            }
            int64IterationContext++;
        }
        constrainedFieldPosition.setInt64IterationContext(int64IterationContext == size ? int64IterationContext : int64IterationContext + 1);
        return int64IterationContext < size;
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0076  */
    /* JADX WARN: Code duplicated, block: B:34:0x007d A[SYNTHETIC] */
    public static void sort(List<FieldPosition> list) {
        boolean z;
        long j;
        int iHashCode;
        int iHashCode2;
        int size = list.size();
        do {
            int i = 0;
            z = true;
            while (i < size - 1) {
                FieldPosition fieldPosition = list.get(i);
                int i2 = i + 1;
                FieldPosition fieldPosition2 = list.get(i2);
                if (fieldPosition.getBeginIndex() != fieldPosition2.getBeginIndex()) {
                    iHashCode = fieldPosition2.getBeginIndex();
                    iHashCode2 = fieldPosition.getBeginIndex();
                } else if (fieldPosition.getEndIndex() != fieldPosition2.getEndIndex()) {
                    iHashCode = fieldPosition.getEndIndex();
                    iHashCode2 = fieldPosition2.getEndIndex();
                } else {
                    if (fieldPosition.getFieldAttribute() != fieldPosition2.getFieldAttribute()) {
                        boolean z2 = fieldPosition.getFieldAttribute() instanceof FieldWithValue;
                        boolean z3 = fieldPosition2.getFieldAttribute() instanceof FieldWithValue;
                        if (z2 && !z3) {
                            j = 1;
                        } else if (!z3 || z2) {
                            iHashCode = fieldPosition.hashCode();
                            iHashCode2 = fieldPosition2.hashCode();
                        } else {
                            j = -1;
                        }
                    } else {
                        j = 0;
                    }
                    if (j < 0) {
                        list.set(i, fieldPosition2);
                        list.set(i2, fieldPosition);
                        z = false;
                    }
                    i = i2;
                }
                j = iHashCode - iHashCode2;
                if (j < 0) {
                    list.set(i, fieldPosition2);
                    list.set(i2, fieldPosition);
                    z = false;
                }
                i = i2;
            }
        } while (!z);
    }

    public static AttributedCharacterIterator toCharacterIterator(CharSequence charSequence, List<FieldPosition> list) {
        Object objValueOf;
        AttributedString attributedString = new AttributedString(charSequence.toString());
        for (int i = 0; i < list.size(); i++) {
            FieldPosition fieldPosition = list.get(i);
            Format.Field fieldAttribute = fieldPosition.getFieldAttribute();
            if (fieldAttribute instanceof FieldWithValue) {
                FieldWithValue fieldWithValue = (FieldWithValue) fieldAttribute;
                objValueOf = Integer.valueOf(fieldWithValue.value);
                fieldAttribute = fieldWithValue.field;
            } else {
                objValueOf = fieldAttribute;
            }
            attributedString.addAttribute(fieldAttribute, objValueOf, fieldPosition.getBeginIndex(), fieldPosition.getEndIndex());
        }
        return attributedString.getIterator();
    }
}
