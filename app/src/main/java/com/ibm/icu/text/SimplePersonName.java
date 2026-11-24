package com.ibm.icu.text;

import com.ibm.icu.impl.locale.LanguageTag;
import com.ibm.icu.impl.number.Padder;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class SimplePersonName implements PersonName {
    private final Map<String, String> fieldValues;
    private final Locale nameLocale;
    private final PersonName.PreferredOrder preferredOrder;

    private SimplePersonName(Locale locale, PersonName.PreferredOrder preferredOrder, Map<String, String> map) {
        this.nameLocale = locale;
        this.preferredOrder = preferredOrder;
        this.fieldValues = new HashMap(map);
    }

    public static Builder builder() {
        return new Builder(0);
    }

    private static String makeModifiedFieldName(PersonName.NameField nameField, Collection<PersonName.FieldModifier> collection) {
        StringBuilder sb = new StringBuilder();
        sb.append(nameField);
        TreeSet<String> treeSet = new TreeSet();
        Iterator<PersonName.FieldModifier> it = collection.iterator();
        while (it.hasNext()) {
            treeSet.add(it.next().toString());
        }
        for (String str : treeSet) {
            sb.append(LanguageTag.SEP);
            sb.append(str);
        }
        return sb.toString();
    }

    private static Set<PersonName.FieldModifier> makeModifiersFromName(String str) {
        StringTokenizer stringTokenizer = new StringTokenizer(str, LanguageTag.SEP);
        HashSet hashSet = new HashSet();
        stringTokenizer.nextToken();
        while (stringTokenizer.hasMoreTokens()) {
            hashSet.add(PersonName.FieldModifier.forString(stringTokenizer.nextToken()));
        }
        return hashSet;
    }

    @Override // com.ibm.icu.text.PersonName
    public String getFieldValue(PersonName.NameField nameField, Set<PersonName.FieldModifier> set) {
        String string = nameField.toString();
        String str = this.fieldValues.get(makeModifiedFieldName(nameField, set));
        if (str != null) {
            set.clear();
            return str;
        }
        String str2 = this.fieldValues.get(string);
        if (str2 == null) {
            return null;
        }
        if (set.size() == 1) {
            return str2;
        }
        int size = 0;
        String str3 = string;
        for (String str4 : this.fieldValues.keySet()) {
            if (str4.startsWith(string)) {
                Set<PersonName.FieldModifier> setMakeModifiersFromName = makeModifiersFromName(str4);
                if (set.containsAll(setMakeModifiersFromName) && (setMakeModifiersFromName.size() > size || (setMakeModifiersFromName.size() == size && str4.compareTo(str3) < 0))) {
                    size = setMakeModifiersFromName.size();
                    str3 = str4;
                }
            }
        }
        String str5 = this.fieldValues.get(str3);
        set.removeAll(makeModifiersFromName(str3));
        return str5;
    }

    @Override // com.ibm.icu.text.PersonName
    public Locale getNameLocale() {
        return this.nameLocale;
    }

    @Override // com.ibm.icu.text.PersonName
    public PersonName.PreferredOrder getPreferredOrder() {
        return this.preferredOrder;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String str : this.fieldValues.keySet()) {
            if (sb.length() > 0) {
                sb.append(",");
            }
            sb.append(str + "=" + this.fieldValues.get(str));
        }
        sb.append(",locale=".concat(String.valueOf(this.nameLocale)));
        return sb.toString();
    }

    public /* synthetic */ SimplePersonName(Locale locale, PersonName.PreferredOrder preferredOrder, Map map, int i) {
        this(locale, preferredOrder, map);
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class Builder {
        private Map<String, String> fieldValues;
        private Locale locale;
        private PersonName.PreferredOrder preferredOrder;

        private Builder() {
            this.locale = null;
            this.preferredOrder = PersonName.PreferredOrder.DEFAULT;
            this.fieldValues = new HashMap();
        }

        public Builder addField(PersonName.NameField nameField, Collection<PersonName.FieldModifier> collection, String str) {
            TreeSet<String> treeSet = new TreeSet();
            if (collection != null) {
                Iterator<PersonName.FieldModifier> it = collection.iterator();
                while (it.hasNext()) {
                    treeSet.add(it.next().toString());
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append(nameField.toString());
            for (String str2 : treeSet) {
                sb.append(LanguageTag.SEP);
                sb.append(str2);
            }
            this.fieldValues.put(sb.toString(), str);
            return this;
        }

        public SimplePersonName build() {
            if (this.fieldValues.get("surname") == null) {
                String str = this.fieldValues.get("surname-prefix");
                String str2 = this.fieldValues.get("surname-core");
                if (str != null && str2 != null) {
                    this.fieldValues.put("surname", str + Padder.FALLBACK_PADDING_STRING + str2);
                } else if (str != null) {
                    this.fieldValues.put("surname", str);
                } else if (str2 != null) {
                    this.fieldValues.put("surname", str2);
                }
            }
            return new SimplePersonName(this.locale, this.preferredOrder, this.fieldValues, 0);
        }

        public Builder setLocale(Locale locale) {
            this.locale = locale;
            return this;
        }

        public Builder setPreferredOrder(PersonName.PreferredOrder preferredOrder) {
            this.preferredOrder = preferredOrder;
            return this;
        }

        public /* synthetic */ Builder(int i) {
            this();
        }
    }
}
