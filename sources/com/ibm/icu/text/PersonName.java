package com.ibm.icu.text;

import defpackage.cq;
import defpackage.og;
import java.util.Locale;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public interface PersonName {

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public enum FieldModifier {
        INFORMAL("informal"),
        PREFIX("prefix"),
        CORE("core"),
        INITIAL("initial"),
        MONOGRAM("monogram"),
        ALL_CAPS("allCaps"),
        RETAIN("retain"),
        INITIAL_CAP("initialCap"),
        GENITIVE("genitive"),
        VOCATIVE("vocative");

        private final String name;

        FieldModifier(String str) {
            this.name = str;
        }

        public static FieldModifier forString(String str) {
            for (FieldModifier fieldModifier : values()) {
                if (fieldModifier.name.equals(str)) {
                    return fieldModifier;
                }
            }
            og.i(cq.j("Invalid modifier name ", str));
            return null;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.name;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public enum NameField {
        TITLE("title"),
        GIVEN("given"),
        GIVEN2("given2"),
        SURNAME("surname"),
        SURNAME2("surname2"),
        GENERATION("generation"),
        CREDENTIALS("credentials");

        private final String name;

        NameField(String str) {
            this.name = str;
        }

        @Deprecated
        public static NameField forString(String str) {
            for (NameField nameField : values()) {
                if (nameField.name.equals(str)) {
                    return nameField;
                }
            }
            og.i(cq.j("Invalid field name ", str));
            return null;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.name;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public enum PreferredOrder {
        DEFAULT,
        GIVEN_FIRST,
        SURNAME_FIRST
    }

    String getFieldValue(NameField nameField, Set<FieldModifier> set);

    Locale getNameLocale();

    PreferredOrder getPreferredOrder();
}
