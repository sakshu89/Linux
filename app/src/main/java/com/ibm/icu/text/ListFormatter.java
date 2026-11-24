package com.ibm.icu.text;

import com.ibm.icu.impl.FormattedStringBuilder;
import com.ibm.icu.impl.FormattedValueStringBuilderImpl;
import com.ibm.icu.impl.ICUCache;
import com.ibm.icu.impl.ICUData;
import com.ibm.icu.impl.ICUResourceBundle;
import com.ibm.icu.impl.SimpleCache;
import com.ibm.icu.impl.SimpleFormatterImpl;
import com.ibm.icu.impl.Utility;
import com.ibm.icu.util.ULocale;
import com.ibm.icu.util.UResourceBundle;
import defpackage.cq;
import defpackage.kf2;
import defpackage.og;
import java.io.InvalidObjectException;
import java.text.AttributedCharacterIterator;
import java.text.Format;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ListFormatter {
    private final ULocale locale;
    private final String middle;
    private final PatternHandler patternHandler;
    private final String start;
    private static final String compiledY = compilePattern("{0} y {1}", new StringBuilder());
    private static final String compiledE = compilePattern("{0} e {1}", new StringBuilder());
    private static final String compiledO = compilePattern("{0} o {1}", new StringBuilder());
    private static final String compiledU = compilePattern("{0} u {1}", new StringBuilder());
    private static final Pattern changeToE = Pattern.compile("(i.*|hi|hi[^ae].*)", 2);
    private static final Pattern changeToU = Pattern.compile("((o|ho|8).*|11)", 2);
    private static final String compiledVav = compilePattern("{0} ו{1}", new StringBuilder());
    private static final String compiledVavDash = compilePattern("{0} ו-{1}", new StringBuilder());
    private static final Pattern changeToVavDash = Pattern.compile("^[\\P{InHebrew}].*$");
    static Cache cache = new Cache(0);

    /* JADX INFO: renamed from: com.ibm.icu.text.ListFormatter$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ibm$icu$text$ListFormatter$Type;
        static final /* synthetic */ int[] $SwitchMap$com$ibm$icu$text$ListFormatter$Width;

        static {
            int[] iArr = new int[Type.values().length];
            $SwitchMap$com$ibm$icu$text$ListFormatter$Type = iArr;
            try {
                iArr[Type.AND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ibm$icu$text$ListFormatter$Type[Type.OR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$ibm$icu$text$ListFormatter$Type[Type.UNITS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[Width.values().length];
            $SwitchMap$com$ibm$icu$text$ListFormatter$Width = iArr2;
            try {
                iArr2[Width.WIDE.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$ibm$icu$text$ListFormatter$Width[Width.SHORT.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$ibm$icu$text$ListFormatter$Width[Width.NARROW.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class ContextualHandler implements PatternHandler {
        private final String elseEndPattern;
        private final String elseTwoPattern;
        private final Pattern regexp;
        private final String thenEndPattern;
        private final String thenTwoPattern;

        public ContextualHandler(Pattern pattern, String str, String str2, String str3, String str4) {
            this.regexp = pattern;
            this.thenTwoPattern = str;
            this.elseTwoPattern = str2;
            this.thenEndPattern = str3;
            this.elseEndPattern = str4;
        }

        @Override // com.ibm.icu.text.ListFormatter.PatternHandler
        public String getEndPattern(String str) {
            return this.regexp.matcher(str).matches() ? this.thenEndPattern : this.elseEndPattern;
        }

        @Override // com.ibm.icu.text.ListFormatter.PatternHandler
        public String getTwoPattern(String str) {
            return this.regexp.matcher(str).matches() ? this.thenTwoPattern : this.elseTwoPattern;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class Field extends Format.Field {
        private static final long serialVersionUID = -8071145668708265437L;
        public static Field LITERAL = new Field("literal");
        public static Field ELEMENT = new Field("element");

        private Field(String str) {
            super(str);
        }

        @Override // java.text.AttributedCharacterIterator.Attribute
        @Deprecated
        public Object readResolve() throws InvalidObjectException {
            if (getName().equals(LITERAL.getName())) {
                return LITERAL;
            }
            if (getName().equals(ELEMENT.getName())) {
                return ELEMENT;
            }
            kf2.i("An invalid object.");
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class FormattedList implements FormattedValue {
        private final FormattedStringBuilder string;

        public FormattedList(FormattedStringBuilder formattedStringBuilder) {
            this.string = formattedStringBuilder;
        }

        @Override // com.ibm.icu.text.FormattedValue
        public <A extends Appendable> A appendTo(A a) {
            return (A) Utility.appendTo(this.string, a);
        }

        @Override // java.lang.CharSequence
        public char charAt(int i) {
            return this.string.charAt(i);
        }

        @Override // java.lang.CharSequence
        public int length() {
            return this.string.length();
        }

        @Override // com.ibm.icu.text.FormattedValue
        public boolean nextPosition(ConstrainedFieldPosition constrainedFieldPosition) {
            return FormattedValueStringBuilderImpl.nextPosition(this.string, constrainedFieldPosition, null);
        }

        @Override // java.lang.CharSequence
        public CharSequence subSequence(int i, int i2) {
            return this.string.subString(i, i2);
        }

        @Override // com.ibm.icu.text.FormattedValue
        public AttributedCharacterIterator toCharacterIterator() {
            return FormattedValueStringBuilderImpl.toCharacterIterator(this.string, null);
        }

        @Override // com.ibm.icu.text.FormattedValue, java.lang.CharSequence
        public String toString() {
            return this.string.toString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class FormattedListBuilder {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        boolean needsFields;
        private FormattedStringBuilder string;

        public FormattedListBuilder(Object obj, boolean z) {
            FormattedStringBuilder formattedStringBuilder = new FormattedStringBuilder();
            this.string = formattedStringBuilder;
            this.needsFields = z;
            formattedStringBuilder.setAppendableField(Field.LITERAL);
            appendElement(obj, 0);
        }

        private void appendElement(Object obj, int i) {
            String string = obj.toString();
            if (!this.needsFields) {
                this.string.append(string, (Object) null);
                return;
            }
            FormattedValueStringBuilderImpl.SpanFieldPlaceholder spanFieldPlaceholder = new FormattedValueStringBuilderImpl.SpanFieldPlaceholder();
            spanFieldPlaceholder.spanField = SpanField.LIST_SPAN;
            spanFieldPlaceholder.normalField = Field.ELEMENT;
            spanFieldPlaceholder.value = Integer.valueOf(i);
            spanFieldPlaceholder.start = -1;
            spanFieldPlaceholder.length = string.length();
            this.string.append(string, spanFieldPlaceholder);
        }

        public FormattedListBuilder append(String str, Object obj, int i) {
            this.string.setAppendIndex(0);
            long jStep = 0;
            while (true) {
                jStep = SimpleFormatterImpl.IterInternal.step(jStep, str, this.string);
                if (jStep == -1) {
                    return this;
                }
                if (SimpleFormatterImpl.IterInternal.getArgIndex(jStep) == 0) {
                    FormattedStringBuilder formattedStringBuilder = this.string;
                    formattedStringBuilder.setAppendIndex(formattedStringBuilder.length());
                } else {
                    appendElement(obj, i);
                }
            }
        }

        public void appendTo(Appendable appendable) {
            Utility.appendTo(this.string, appendable);
        }

        public int getOffset(int i) {
            return FormattedValueStringBuilderImpl.findSpan(this.string, Integer.valueOf(i));
        }

        public String toString() {
            return this.string.toString();
        }

        public FormattedList toValue() {
            return new FormattedList(this.string);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public interface PatternHandler {
        String getEndPattern(String str);

        String getTwoPattern(String str);
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class SpanField extends UFormat.SpanField {
        public static final SpanField LIST_SPAN = new SpanField("list-span");
        private static final long serialVersionUID = 3563544214705634403L;

        private SpanField(String str) {
            super(str);
        }

        @Override // java.text.AttributedCharacterIterator.Attribute
        @Deprecated
        public Object readResolve() throws InvalidObjectException {
            String name = getName();
            SpanField spanField = LIST_SPAN;
            if (name.equals(spanField.getName())) {
                return spanField;
            }
            kf2.i("An invalid object.");
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class StaticHandler implements PatternHandler {
        private final String endPattern;
        private final String twoPattern;

        public StaticHandler(String str, String str2) {
            this.twoPattern = str;
            this.endPattern = str2;
        }

        @Override // com.ibm.icu.text.ListFormatter.PatternHandler
        public String getEndPattern(String str) {
            return this.endPattern;
        }

        @Override // com.ibm.icu.text.ListFormatter.PatternHandler
        public String getTwoPattern(String str) {
            return this.twoPattern;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public enum Type {
        AND,
        OR,
        UNITS
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public enum Width {
        WIDE,
        SHORT,
        NARROW
    }

    @Deprecated
    public ListFormatter(String str, String str2, String str3, String str4) {
        this(compilePattern(str, new StringBuilder()), compilePattern(str2, new StringBuilder()), compilePattern(str3, new StringBuilder()), compilePattern(str4, new StringBuilder()), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String compilePattern(String str, StringBuilder sb) {
        return SimpleFormatterImpl.compileToStringMinMaxArguments(str, sb, 2, 2);
    }

    private PatternHandler createPatternHandler(String str, String str2) {
        String str3;
        String str4;
        String str5;
        String str6;
        ULocale uLocale = this.locale;
        if (uLocale != null) {
            String language = uLocale.getLanguage();
            if (language.equals("es")) {
                String str7 = compiledY;
                boolean zEquals = str.equals(str7);
                boolean zEquals2 = str2.equals(str7);
                if (zEquals || zEquals2) {
                    return new ContextualHandler(changeToE, zEquals ? compiledE : str, str, zEquals2 ? compiledE : str2, str2);
                }
                String str8 = compiledO;
                boolean zEquals3 = str.equals(str8);
                boolean zEquals4 = str2.equals(str8);
                if (zEquals3 || zEquals4) {
                    Pattern pattern = changeToU;
                    String str9 = zEquals3 ? compiledU : str;
                    if (zEquals4) {
                        str5 = compiledU;
                        str6 = str2;
                    } else {
                        str5 = str2;
                        str6 = str5;
                    }
                    return new ContextualHandler(pattern, str9, str, str5, str6);
                }
                str3 = str;
                str4 = str2;
            } else {
                str3 = str;
                str4 = str2;
                if (language.equals("he") || language.equals("iw")) {
                    String str10 = compiledVav;
                    boolean zEquals5 = str3.equals(str10);
                    boolean zEquals6 = str4.equals(str10);
                    if (zEquals5 || zEquals6) {
                        return new ContextualHandler(changeToVavDash, zEquals5 ? compiledVavDash : str3, str3, zEquals6 ? compiledVavDash : str4, str4);
                    }
                }
            }
        } else {
            str3 = str;
            str4 = str2;
        }
        return new StaticHandler(str3, str4);
    }

    public static ListFormatter getInstance(ULocale uLocale, Type type, Width width) {
        String strTypeWidthToStyleString = typeWidthToStyleString(type, width);
        if (strTypeWidthToStyleString != null) {
            return cache.get(uLocale, strTypeWidthToStyleString);
        }
        og.i("Invalid list format type/width");
        return null;
    }

    public static String typeWidthToStyleString(Type type, Width width) {
        int i = AnonymousClass1.$SwitchMap$com$ibm$icu$text$ListFormatter$Type[type.ordinal()];
        if (i == 1) {
            int i2 = AnonymousClass1.$SwitchMap$com$ibm$icu$text$ListFormatter$Width[width.ordinal()];
            if (i2 == 1) {
                return "standard";
            }
            if (i2 == 2) {
                return "standard-short";
            }
            if (i2 != 3) {
                return null;
            }
            return "standard-narrow";
        }
        if (i == 2) {
            int i3 = AnonymousClass1.$SwitchMap$com$ibm$icu$text$ListFormatter$Width[width.ordinal()];
            if (i3 == 1) {
                return "or";
            }
            if (i3 == 2) {
                return "or-short";
            }
            if (i3 != 3) {
                return null;
            }
            return "or-narrow";
        }
        if (i != 3) {
            return null;
        }
        int i4 = AnonymousClass1.$SwitchMap$com$ibm$icu$text$ListFormatter$Width[width.ordinal()];
        if (i4 == 1) {
            return "unit";
        }
        if (i4 == 2) {
            return "unit-short";
        }
        if (i4 != 3) {
            return null;
        }
        return "unit-narrow";
    }

    public String format(Collection<?> collection) {
        return formatImpl(collection, false).toString();
    }

    public FormattedListBuilder formatImpl(Collection<?> collection, boolean z) {
        Iterator<?> it = collection.iterator();
        int size = collection.size();
        if (size == 0) {
            return new FormattedListBuilder("", z);
        }
        if (size == 1) {
            return new FormattedListBuilder(it.next(), z);
        }
        int i = 2;
        if (size == 2) {
            Object next = it.next();
            Object next2 = it.next();
            return new FormattedListBuilder(next, z).append(this.patternHandler.getTwoPattern(String.valueOf(next2)), next2, 1);
        }
        FormattedListBuilder formattedListBuilder = new FormattedListBuilder(it.next(), z);
        formattedListBuilder.append(this.start, it.next(), 1);
        while (true) {
            int i2 = size - 1;
            if (i >= i2) {
                Object next3 = it.next();
                return formattedListBuilder.append(this.patternHandler.getEndPattern(String.valueOf(next3)), next3, i2);
            }
            formattedListBuilder.append(this.middle, it.next(), i);
            i++;
        }
    }

    public FormattedList formatToValue(Collection<?> collection) {
        return formatImpl(collection, true).toValue();
    }

    @Deprecated
    public ULocale getLocale() {
        return this.locale;
    }

    public String getPatternForNumItems(int i) {
        if (i <= 0) {
            og.i("count must be > 0");
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < i; i2++) {
            arrayList.add(String.format("{%d}", Integer.valueOf(i2)));
        }
        return format(arrayList);
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class Cache {
        private final ICUCache<String, ListFormatter> cache;

        private Cache() {
            this.cache = new SimpleCache();
        }

        private static ListFormatter load(ULocale uLocale, String str) {
            ICUResourceBundle iCUResourceBundle = (ICUResourceBundle) UResourceBundle.getBundleInstance(ICUData.ICU_BASE_NAME, uLocale);
            StringBuilder sb = new StringBuilder();
            return new ListFormatter(ListFormatter.compilePattern(iCUResourceBundle.getWithFallback("listPattern/" + str + "/2").getString(), sb), ListFormatter.compilePattern(iCUResourceBundle.getWithFallback("listPattern/" + str + "/start").getString(), sb), ListFormatter.compilePattern(iCUResourceBundle.getWithFallback("listPattern/" + str + "/middle").getString(), sb), ListFormatter.compilePattern(iCUResourceBundle.getWithFallback("listPattern/" + str + "/end").getString(), sb), uLocale, 0);
        }

        public ListFormatter get(ULocale uLocale, String str) {
            String strK = cq.k(uLocale.toString(), ":", str);
            ListFormatter listFormatter = this.cache.get(strK);
            if (listFormatter != null) {
                return listFormatter;
            }
            ListFormatter listFormatterLoad = load(uLocale, str);
            this.cache.put(strK, listFormatterLoad);
            return listFormatterLoad;
        }

        public /* synthetic */ Cache(int i) {
            this();
        }
    }

    public String format(Object... objArr) {
        return format(Arrays.asList(objArr));
    }

    public FormattedList formatToValue(Object... objArr) {
        return formatToValue(Arrays.asList(objArr));
    }

    public static ListFormatter getInstance(Locale locale, Type type, Width width) {
        return getInstance(ULocale.forLocale(locale), type, width);
    }

    public static ListFormatter getInstance(ULocale uLocale) {
        return getInstance(uLocale, Type.AND, Width.WIDE);
    }

    public static ListFormatter getInstance(Locale locale) {
        return getInstance(ULocale.forLocale(locale), Type.AND, Width.WIDE);
    }

    public static ListFormatter getInstance() {
        return getInstance(ULocale.getDefault(ULocale.Category.FORMAT));
    }

    public /* synthetic */ ListFormatter(String str, String str2, String str3, String str4, ULocale uLocale, int i) {
        this(str, str2, str3, str4, uLocale);
    }

    private ListFormatter(String str, String str2, String str3, String str4, ULocale uLocale) {
        this.start = str2;
        this.middle = str3;
        this.locale = uLocale;
        this.patternHandler = createPatternHandler(str, str4);
    }
}
