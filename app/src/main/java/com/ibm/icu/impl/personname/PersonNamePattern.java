package com.ibm.icu.impl.personname;

import com.ibm.icu.impl.locale.LanguageTag;
import com.ibm.icu.text.PersonName;
import defpackage.cq;
import defpackage.og;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
class PersonNamePattern {
    private Element[] patternElements;
    private String patternText;

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public interface Element {
        String format(PersonName personName);

        boolean isLiteral();

        boolean isPopulated(PersonName personName);
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class GivenToSurnamePersonName implements PersonName {
        private PersonName underlyingPersonName;

        public GivenToSurnamePersonName(PersonName personName) {
            this.underlyingPersonName = personName;
        }

        @Override // com.ibm.icu.text.PersonName
        public String getFieldValue(PersonName.NameField nameField, Set<PersonName.FieldModifier> set) {
            if (nameField == PersonName.NameField.SURNAME) {
                return this.underlyingPersonName.getFieldValue(PersonName.NameField.GIVEN, set);
            }
            if (nameField == PersonName.NameField.GIVEN) {
                return null;
            }
            return this.underlyingPersonName.getFieldValue(nameField, set);
        }

        @Override // com.ibm.icu.text.PersonName
        public Locale getNameLocale() {
            return this.underlyingPersonName.getNameLocale();
        }

        @Override // com.ibm.icu.text.PersonName
        public PersonName.PreferredOrder getPreferredOrder() {
            return this.underlyingPersonName.getPreferredOrder();
        }

        public String toString() {
            return cq.j("Inverted version of ", this.underlyingPersonName.toString());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class LiteralText implements Element {
        private String text;

        public LiteralText(String str) {
            this.text = str;
        }

        @Override // com.ibm.icu.impl.personname.PersonNamePattern.Element
        public String format(PersonName personName) {
            return this.text;
        }

        @Override // com.ibm.icu.impl.personname.PersonNamePattern.Element
        public boolean isLiteral() {
            return true;
        }

        @Override // com.ibm.icu.impl.personname.PersonNamePattern.Element
        public boolean isPopulated(PersonName personName) {
            return false;
        }

        public String toString() {
            return this.text;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class NameFieldImpl implements Element {
        private PersonName.NameField fieldID;
        private Map<PersonName.FieldModifier, FieldModifierImpl> modifiers;

        public NameFieldImpl(String str, PersonNameFormatterImpl personNameFormatterImpl) {
            ArrayList arrayList = new ArrayList();
            StringTokenizer stringTokenizer = new StringTokenizer(str, LanguageTag.SEP);
            this.fieldID = PersonName.NameField.forString(stringTokenizer.nextToken());
            while (stringTokenizer.hasMoreTokens()) {
                arrayList.add(PersonName.FieldModifier.forString(stringTokenizer.nextToken()));
            }
            if (this.fieldID == PersonName.NameField.SURNAME && personNameFormatterImpl.shouldCapitalizeSurname()) {
                arrayList.add(PersonName.FieldModifier.ALL_CAPS);
            }
            this.modifiers = new HashMap();
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                PersonName.FieldModifier fieldModifier = (PersonName.FieldModifier) obj;
                this.modifiers.put(fieldModifier, FieldModifierImpl.forName(fieldModifier, personNameFormatterImpl));
            }
            if (this.modifiers.containsKey(PersonName.FieldModifier.RETAIN)) {
                Map<PersonName.FieldModifier, FieldModifierImpl> map = this.modifiers;
                PersonName.FieldModifier fieldModifier2 = PersonName.FieldModifier.INITIAL;
                if (map.containsKey(fieldModifier2)) {
                    ((FieldModifierImpl.InitialModifier) this.modifiers.get(fieldModifier2)).setRetainPunctuation(true);
                }
            }
        }

        @Override // com.ibm.icu.impl.personname.PersonNamePattern.Element
        public String format(PersonName personName) {
            HashSet hashSet = new HashSet(this.modifiers.keySet());
            String fieldValue = personName.getFieldValue(this.fieldID, hashSet);
            if (fieldValue != null) {
                Iterator it = hashSet.iterator();
                while (it.hasNext()) {
                    fieldValue = this.modifiers.get((PersonName.FieldModifier) it.next()).modifyField(fieldValue);
                }
            }
            return fieldValue;
        }

        @Override // com.ibm.icu.impl.personname.PersonNamePattern.Element
        public boolean isLiteral() {
            return false;
        }

        @Override // com.ibm.icu.impl.personname.PersonNamePattern.Element
        public boolean isPopulated(PersonName personName) {
            String str = format(personName);
            return (str == null || str.isEmpty()) ? false : true;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("{");
            sb.append(this.fieldID);
            for (PersonName.FieldModifier fieldModifier : this.modifiers.keySet()) {
                sb.append(LanguageTag.SEP);
                sb.append(fieldModifier.toString());
            }
            sb.append("}");
            return sb.toString();
        }
    }

    private PersonNamePattern(String str, PersonNameFormatterImpl personNameFormatterImpl) {
        this.patternText = str;
        ArrayList arrayList = new ArrayList();
        StringBuilder sb = new StringBuilder();
        boolean z = false;
        boolean z2 = false;
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (z) {
                sb.append(cCharAt);
                z = false;
            } else if (cCharAt == '\\') {
                z = true;
            } else if (cCharAt == '{') {
                if (z2) {
                    og.i("Nested braces are not allowed in name patterns");
                    throw null;
                }
                if (sb.length() > 0) {
                    arrayList.add(new LiteralText(sb.toString()));
                    sb = new StringBuilder();
                }
                z2 = true;
            } else if (cCharAt != '}') {
                sb.append(cCharAt);
            } else {
                if (!z2) {
                    og.i("Unmatched closing brace in literal text");
                    throw null;
                }
                if (sb.length() <= 0) {
                    og.i("No field name inside braces");
                    throw null;
                }
                arrayList.add(new NameFieldImpl(sb.toString(), personNameFormatterImpl));
                sb = new StringBuilder();
                z2 = false;
            }
        }
        if (sb.length() > 0) {
            arrayList.add(new LiteralText(sb.toString()));
        }
        this.patternElements = (Element[]) arrayList.toArray(new Element[0]);
    }

    private String coalesce(StringBuilder sb, StringBuilder sb2) {
        if (endsWith(sb, sb2)) {
            sb2.setLength(0);
        }
        int i = 0;
        while (i < sb.length() && !Character.isWhitespace(sb.charAt(i))) {
            i++;
        }
        int length = sb2.length() - 1;
        while (length >= 0 && !Character.isWhitespace(sb2.charAt(length))) {
            length--;
        }
        if (i < sb.length()) {
            i++;
        } else if (length >= 0) {
            length--;
        }
        String str = sb.substring(0, i) + sb2.substring(length + 1);
        sb.setLength(0);
        sb2.setLength(0);
        return str;
    }

    private boolean endsWith(StringBuilder sb, StringBuilder sb2) {
        int length = sb.length() - 1;
        int length2 = sb2.length() - 1;
        while (length >= 0 && length2 >= 0 && sb.charAt(length) == sb2.charAt(length2)) {
            length--;
            length2--;
        }
        return length2 < 0;
    }

    private PersonName hackNameForEmptyFields(PersonName personName) {
        if (personName.getFieldValue(PersonName.NameField.SURNAME, Collections.EMPTY_SET) == null) {
            for (Element element : this.patternElements) {
                if (!element.isLiteral()) {
                    NameFieldImpl nameFieldImpl = (NameFieldImpl) element;
                    if (nameFieldImpl.fieldID != PersonName.NameField.GIVEN || nameFieldImpl.modifiers.containsKey(PersonName.FieldModifier.INITIAL)) {
                    }
                }
            }
            return new GivenToSurnamePersonName(personName);
        }
        return personName;
    }

    public static PersonNamePattern[] makePatterns(String[] strArr, PersonNameFormatterImpl personNameFormatterImpl) {
        PersonNamePattern[] personNamePatternArr = new PersonNamePattern[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            personNamePatternArr[i] = new PersonNamePattern(strArr[i], personNameFormatterImpl);
        }
        return personNamePatternArr;
    }

    public String format(PersonName personName) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sb3 = new StringBuilder();
        PersonName personNameHackNameForEmptyFields = hackNameForEmptyFields(personName);
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        for (Element element : this.patternElements) {
            if (!element.isLiteral()) {
                String str = element.format(personNameHackNameForEmptyFields);
                if (str != null && !str.isEmpty()) {
                    if (z) {
                        sb.append(coalesce(sb2, sb3));
                        sb.append(str);
                        z = false;
                        z2 = false;
                    } else {
                        sb.append((CharSequence) sb2);
                        sb2.setLength(0);
                        sb.append(element.format(personNameHackNameForEmptyFields));
                        z2 = false;
                    }
                    z3 = true;
                } else if (z3) {
                    sb3.setLength(0);
                    z = true;
                } else {
                    sb2.setLength(0);
                    z2 = true;
                }
            } else if (!z2) {
                if (z) {
                    sb3.append(element.format(personNameHackNameForEmptyFields));
                } else {
                    sb2.append(element.format(personNameHackNameForEmptyFields));
                }
            }
        }
        if (!z) {
            sb.append((CharSequence) sb2);
        }
        return sb.toString();
    }

    public int numEmptyFields(PersonName personName) {
        int i = 0;
        for (Element element : this.patternElements) {
            i += (element.isLiteral() || element.isPopulated(personName)) ? 0 : 1;
        }
        return i;
    }

    public int numPopulatedFields(PersonName personName) {
        int i = 0;
        for (Element element : this.patternElements) {
            i += element.isPopulated(personName) ? 1 : 0;
        }
        return i;
    }

    public String toString() {
        return this.patternText;
    }
}
