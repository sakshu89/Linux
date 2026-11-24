package com.ibm.icu.impl.links;

import com.ibm.icu.impl.UnicodeMap;
import com.ibm.icu.impl.Utility;
import com.ibm.icu.impl.links.LinkHandlingUtilities;
import com.ibm.icu.impl.locale.XCldrStub;
import com.ibm.icu.impl.number.Padder;
import com.ibm.icu.lang.UCharacter;
import com.ibm.icu.lang.UCharacterEnums;
import com.ibm.icu.text.UnicodeSet;
import com.ibm.icu.util.Output;
import defpackage.cq;
import defpackage.dk0;
import defpackage.mc1;
import defpackage.og;
import defpackage.y90;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.Objects;
import java.util.Set;
import java.util.Stack;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class LinkHandlingUtilities {
    static final UnicodeSet EMAIL_ASCII_INCLUDES;
    private static final Pattern ESCAPED_BYTE_PATTERN;
    private static final Pattern ESCAPED_SINGLE;
    private static final UnicodeSet SOFAR = new UnicodeSet();
    static final UnicodeSet VALID_EMAIL_LOCAL_PART;

    /* JADX INFO: renamed from: com.ibm.icu.impl.links.LinkHandlingUtilities$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ibm$icu$impl$links$LinkHandlingUtilities$LinkTermination;
        static final /* synthetic */ int[] $SwitchMap$com$ibm$icu$impl$links$LinkHandlingUtilities$Part;
        static final /* synthetic */ int[] $SwitchMap$com$ibm$icu$impl$links$LinkHandlingUtilities$Structure;

        static {
            int[] iArr = new int[Structure.values().length];
            $SwitchMap$com$ibm$icu$impl$links$LinkHandlingUtilities$Structure = iArr;
            try {
                iArr[Structure.single.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ibm$icu$impl$links$LinkHandlingUtilities$Structure[Structure.listP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$ibm$icu$impl$links$LinkHandlingUtilities$Structure[Structure.listF.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$ibm$icu$impl$links$LinkHandlingUtilities$Structure[Structure.listQ2.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[LinkTermination.values().length];
            $SwitchMap$com$ibm$icu$impl$links$LinkHandlingUtilities$LinkTermination = iArr2;
            try {
                iArr2[LinkTermination.INCLUDE.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$ibm$icu$impl$links$LinkHandlingUtilities$LinkTermination[LinkTermination.HARD.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$ibm$icu$impl$links$LinkHandlingUtilities$LinkTermination[LinkTermination.SOFT.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$ibm$icu$impl$links$LinkHandlingUtilities$LinkTermination[LinkTermination.OPEN.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$ibm$icu$impl$links$LinkHandlingUtilities$LinkTermination[LinkTermination.CLOSE.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            int[] iArr3 = new int[Part.values().length];
            $SwitchMap$com$ibm$icu$impl$links$LinkHandlingUtilities$Part = iArr3;
            try {
                iArr3[Part.PROTOCOL.ordinal()] = 1;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public enum LinkTermination {
        HARD("[\\p{whitespace}\\p{NChar}[\\p{C}-\\p{Cf}]\\p{deprecated}]"),
        SOFT("[\\p{Term}\\p{lb=qu}-\\p{deprecated}]"),
        CLOSE("[\\p{Bidi_Paired_Bracket_Type=Close}[>]-\\p{deprecated}]"),
        OPEN("[\\p{Bidi_Paired_Bracket_Type=Open}[<]-\\p{deprecated}]"),
        INCLUDE(null);

        private static final UnicodeMap<LinkTermination> PROPERTY_MAP = new UnicodeMap<>();
        private final UnicodeSet base;

        static {
            for (LinkTermination linkTermination : values()) {
                for (LinkTermination linkTermination2 : values()) {
                    if (linkTermination.compareTo(linkTermination2) > 0 && linkTermination.base.containsSome(linkTermination2.base)) {
                        String strValueOf = String.valueOf(linkTermination);
                        String strValueOf2 = String.valueOf(linkTermination2);
                        String strValueOf3 = String.valueOf(new UnicodeSet(linkTermination.base).retainAll(linkTermination2.base));
                        StringBuilder sbQ = cq.q("Values in LinkTermination overlap! ", strValueOf, ", ", strValueOf2, ": ");
                        sbQ.append(strValueOf3);
                        throw new IllegalArgumentException(sbQ.toString());
                    }
                }
            }
            for (LinkTermination linkTermination3 : values()) {
                PROPERTY_MAP.putAll(linkTermination3.base, linkTermination3);
            }
            PROPERTY_MAP.freeze();
        }

        LinkTermination(String str) {
            if (str == null) {
                this.base = LinkHandlingUtilities.SOFAR.complement().freeze();
                return;
            }
            UnicodeSet unicodeSetFreeze = new UnicodeSet(str).freeze();
            this.base = unicodeSetFreeze;
            LinkHandlingUtilities.SOFAR.addAll(unicodeSetFreeze);
        }
    }

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'PROTOCOL' uses external variables
    	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:485)
    	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:422)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:351)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:284)
    	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:153)
    	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
     */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class Part {
        private static final /* synthetic */ Part[] $VALUES;
        static final Set<Part> ALL;
        public static final Part FRAGMENT;
        static final int[] FRAGMENT_DIRECTIVE_STRING;
        public static final Part HOST;
        public static final Part PATH;
        public static final Part PROTOCOL;
        public static final Part QUERY;
        final UnicodeSet clearStack;
        final int initiator;
        public final Structure structure;
        final UnicodeSet terminators;
        final UnicodeSet whatwg_quoted;

        static {
            Structure structure = Structure.single;
            Part part = new Part("PROTOCOL", 0, structure, (char) 0, "[{//}]", "[]", "[]", null);
            PROTOCOL = part;
            Part part2 = new Part("HOST", 1, structure, (char) 0, "[/?#]", "[]", "[]", null);
            HOST = part2;
            Part part3 = new Part("PATH", 2, Structure.listP, '/', "[?#]", "[/]", "[]", WhatWgPercentEncoded.PATH);
            PATH = part3;
            Part part4 = new Part("QUERY", 3, Structure.listQ2, '?', "[#]", "[=\\&]", "[+]", WhatWgPercentEncoded.SPECIAL_QUERY);
            QUERY = part4;
            Part part5 = new Part("FRAGMENT", 4, Structure.listF, '#', "[]", "[{:~:}]", "[]", WhatWgPercentEncoded.FRAGMENT);
            FRAGMENT = part5;
            $VALUES = new Part[]{part, part2, part3, part4, part5};
            ALL = XCldrStub.setofOrdered(values());
            FRAGMENT_DIRECTIVE_STRING = ":~:".codePoints().toArray();
        }

        private Part(String str, int i, Structure structure, char c, String str2, String str3, String str4, WhatWgPercentEncoded whatWgPercentEncoded) {
            super(str, i);
            this.structure = structure;
            this.initiator = c;
            UnicodeSet unicodeSetFreeze = new UnicodeSet(str2).freeze();
            this.terminators = unicodeSetFreeze;
            UnicodeSet unicodeSetFreeze2 = new UnicodeSet(str3).freeze();
            this.clearStack = unicodeSetFreeze2;
            new UnicodeSet(str4).addAll(unicodeSetFreeze2).addAll(unicodeSetFreeze).freeze();
            this.whatwg_quoted = whatWgPercentEncoded == null ? UnicodeSet.EMPTY : whatWgPercentEncoded.getSet();
        }

        public static Part fromInitiator(int i) {
            for (Part part : values()) {
                if (part.initiator == i) {
                    return part;
                }
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String fullEscape(List<List<String>> list) {
            if (list.isEmpty()) {
                return "";
            }
            if (this.structure == Structure.single) {
                return list.get(0).get(0);
            }
            StringBuilder sbAppendCodePoint = new StringBuilder().appendCodePoint(this.initiator);
            UnicodeSet unicodeSet = this.whatwg_quoted;
            boolean z = true;
            for (List<String> list2 : list) {
                if (z) {
                    z = false;
                } else {
                    sbAppendCodePoint.append(this.structure.sub);
                }
                if (this.structure.sub2 == null) {
                    sbAppendCodePoint.append(LinkHandlingUtilities.escape(list2.get(0), unicodeSet));
                } else {
                    boolean z2 = true;
                    for (String str : list2) {
                        if (z2) {
                            z2 = false;
                        } else {
                            sbAppendCodePoint.append(this.structure.sub2);
                        }
                        sbAppendCodePoint.append(LinkHandlingUtilities.escape(str, unicodeSet));
                    }
                }
            }
            return sbAppendCodePoint.toString();
        }

        public static Part valueOf(String str) {
            return (Part) Enum.valueOf(Part.class, str);
        }

        public static Part[] values() {
            return (Part[]) $VALUES.clone();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public enum WhatWgPercentEncoded {
        C0(null, "[\\u0000-\\u001F\\u007E-\\x{10FFFF}]"),
        FRAGMENT(C0, "[\\ \"<>`]"),
        QUERY(C0, "[\\ \"<>]"),
        SPECIAL_QUERY(QUERY, "[']"),
        PATH(QUERY, "[?\\^`\\{\\}]"),
        USERINFO(PATH, "[/:;=@\\[-\\]|]"),
        COMPONENT(USERINFO, "[\\$-\\&+,]");

        private final UnicodeSet set;

        WhatWgPercentEncoded(WhatWgPercentEncoded whatWgPercentEncoded, String str) {
            this.set = new UnicodeSet(str).addAll(whatWgPercentEncoded == null ? UnicodeSet.EMPTY : whatWgPercentEncoded.getSet()).freeze();
        }

        public UnicodeSet getSet() {
            return this.set;
        }
    }

    static {
        UnicodeSet unicodeSetFreeze = new UnicodeSet("[[a-zA-Z][0-9][_ \\- ! ? ' \\{ \\} * / \\& # % ` \\^ + = | ~ \\$]]").add(46).freeze();
        EMAIL_ASCII_INCLUDES = unicodeSetFreeze;
        VALID_EMAIL_LOCAL_PART = new UnicodeSet("[\\p{XID_Continue}-\\p{block=basic_latin}]").addAll(unicodeSetFreeze).freeze();
        ESCAPED_BYTE_PATTERN = Pattern.compile("(%[a-fA-F0-9][a-fA-F0-9])+");
        ESCAPED_SINGLE = Pattern.compile("%[a-fA-F0-9][a-fA-F0-9]");
    }

    private static void appendCheckingPercent(StringBuilder sb, String str, int i, int i2) {
        int iIndexOf = str.indexOf("%", i);
        if (iIndexOf < 0 || iIndexOf >= i2) {
            sb.append((CharSequence) str, i, i2);
        } else {
            sb.append(ESCAPED_SINGLE.matcher(str.substring(i, i2)).replaceAll(new mc1(2)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void appendCodePointsBetween(StringBuilder sb, int[] iArr, int i, int i2) {
        while (i < i2) {
            sb.appendCodePoint(iArr[i]);
            i++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void appendPercentEscaped(StringBuilder sb, int i) {
        for (byte b : new String(Character.toChars(i)).getBytes(StandardCharsets.UTF_8)) {
            sb.append('%');
            sb.append(Utility.hex(b & UCharacterEnums.ECharacterDirection.DIRECTIONALITY_UNDEFINED, 2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<List<String>> cleanList(Part part, String str) {
        return (List) splitList(part, part.structure.sub, str).stream().map(new mc1(0)).collect(Collectors.toUnmodifiableList());
    }

    public static String escape(String str, UnicodeSet unicodeSet) {
        StringBuilder sb = new StringBuilder();
        int iSpan = 0;
        do {
            int iSpan2 = unicodeSet.span(str, iSpan, UnicodeSet.SpanCondition.NOT_CONTAINED);
            appendCheckingPercent(sb, str, iSpan, iSpan2);
            if (iSpan2 == str.length()) {
                break;
            }
            iSpan = unicodeSet.span(str, iSpan2, UnicodeSet.SpanCondition.SIMPLE);
            appendPercentEscaped(sb, str.substring(iSpan2, iSpan));
        } while (iSpan != str.length());
        return sb.toString();
    }

    public static Map<String, List<List<String>>> getInternals(String str) {
        UrlInternals urlInternalsFrom = UrlInternals.from(str.toString());
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Part part : Part.values()) {
            List<List<String>> list = urlInternalsFrom.get(part);
            if (list != null) {
                linkedHashMap.put(part.toString(), list);
            }
        }
        return linkedHashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int getOpening(int i) {
        if (i == 62) {
            return 60;
        }
        return UCharacter.getBidiPairedBracket(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String joinListEscaping(String str, UnicodeSet unicodeSet, List<String> list) {
        return str == null ? escape(list.get(0), unicodeSet) : (String) list.stream().map(new y90(1, unicodeSet)).collect(Collectors.joining(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String joinListListEscaping(String str, final String str2, List<List<String>> list) {
        if (str.codePointCount(0, str.length()) == 0 || (str2 != null && str2.codePointCount(0, str2.length()) == 0)) {
            dk0.v();
            return null;
        }
        final UnicodeSet unicodeSetAdd = new UnicodeSet().add(str);
        if (str2 != null) {
            unicodeSetAdd.add(str2);
        }
        return (String) list.stream().map(new Function() { // from class: lc1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return LinkHandlingUtilities.joinListEscaping(str2, unicodeSetAdd, (List) obj);
            }
        }).collect(Collectors.joining(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$appendCheckingPercent$5(MatchResult matchResult) {
        return "%25".concat(matchResult.group(0).substring(1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List lambda$cleanList$2(String str) {
        ArrayList arrayList = new ArrayList(1);
        Object obj = new Object[]{str}[0];
        Objects.requireNonNull(obj);
        arrayList.add(obj);
        return Collections.unmodifiableList(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$joinListEscaping$1(UnicodeSet unicodeSet, String str) {
        return escape(str, unicodeSet);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$unescape$4(UnicodeSet unicodeSet, StringBuilder sb, int i) {
        if (unicodeSet.contains(i)) {
            appendPercentEscaped(sb, i);
        } else {
            sb.appendCodePoint(i);
        }
    }

    private static boolean matches(int[] iArr, int i, int[] iArr2) {
        if (iArr2.length + i > iArr.length) {
            return false;
        }
        for (int i2 = 0; i2 < iArr2.length; i2++) {
            if (iArr[i2 + i] != iArr2[i2]) {
                return false;
            }
        }
        return true;
    }

    public static int parsePathQueryFragment(String str, int i) {
        Part partFromInitiator;
        int[] array = str.codePoints().toArray();
        Stack stack = new Stack();
        Part part = null;
        LinkTermination linkTermination = LinkTermination.SOFT;
        int i2 = i;
        while (i < array.length) {
            int i3 = array[i];
            if (part == null) {
                partFromInitiator = Part.fromInitiator(i3);
                if (partFromInitiator == null) {
                    return i;
                }
                part = partFromInitiator;
                i2 = i + 1;
            } else {
                linkTermination = (LinkTermination) LinkTermination.PROPERTY_MAP.get(i3);
                if (part.terminators.contains(i3)) {
                    partFromInitiator = Part.fromInitiator(i3);
                    if (partFromInitiator == null) {
                        return i;
                    }
                    part = partFromInitiator;
                    i2 = i + 1;
                } else {
                    if (part.clearStack.contains(i3)) {
                        stack.clear();
                    } else if (part == Part.FRAGMENT && matches(array, i, Part.FRAGMENT_DIRECTIVE_STRING)) {
                        stack.clear();
                    }
                    int i4 = AnonymousClass1.$SwitchMap$com$ibm$icu$impl$links$LinkHandlingUtilities$LinkTermination[linkTermination.ordinal()];
                    if (i4 != 1) {
                        if (i4 != 2) {
                            if (i4 == 4) {
                                stack.push(Integer.valueOf(i3));
                            } else if (i4 != 5) {
                                continue;
                            } else if (stack.empty() || getOpening(i3) != ((Integer) stack.pop()).intValue()) {
                            }
                            i2 = i + 1;
                        }
                        return i2;
                    }
                    i2 = i + 1;
                }
            }
            i++;
        }
        if (linkTermination != LinkTermination.SOFT) {
            return array.length;
        }
        return i2;
    }

    private static String percentUnescape(String str) {
        byte[] bArr = new byte[str.length() / 3];
        int i = 0;
        int i2 = 0;
        while (i < str.length()) {
            if (str.charAt(i) != '%') {
                dk0.v();
                return null;
            }
            int i3 = i + 1;
            i += 3;
            bArr[i2] = (byte) Integer.parseInt(str.substring(i3, i), 16);
            i2++;
        }
        return new String(bArr, StandardCharsets.UTF_8);
    }

    public static int scanEmailBackwards(CharSequence charSequence, int i, int i2) {
        if (charSequence.charAt(i2) != '@') {
            og.i("Scanning must start backwards from the '@' sign position");
            return 0;
        }
        int iSpanBack = VALID_EMAIL_LOCAL_PART.spanBack(charSequence, i2, UnicodeSet.SpanCondition.SIMPLE);
        if (iSpanBack != i2) {
            if (iSpanBack >= i) {
                i = iSpanBack;
            }
            String string = charSequence.subSequence(i, i2).toString();
            if (!string.startsWith(".") && !string.endsWith(".") && !string.contains("..")) {
                return i;
            }
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<String> splitList(Part part, String str, String str2) {
        return (List) XCldrStub.Splitter.on(str).splitToStream(str2).map(new mc1(1)).collect(Collectors.toList());
    }

    private static String unescape(String str, final UnicodeSet unicodeSet) {
        final StringBuilder sb = new StringBuilder();
        Matcher matcher = ESCAPED_BYTE_PATTERN.matcher(str);
        int iEnd = 0;
        while (matcher.find(iEnd)) {
            sb.append(str.substring(iEnd, matcher.start()));
            percentUnescape(matcher.group()).chars().forEach(new IntConsumer() { // from class: nc1
                @Override // java.util.function.IntConsumer
                public final void accept(int i) {
                    LinkHandlingUtilities.lambda$unescape$4(unicodeSet, sb, i);
                }
            });
            iEnd = matcher.end();
        }
        sb.append(str.substring(iEnd, str.length()));
        return sb.toString();
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public enum Structure {
        single,
        listP("/", "𝑷"),
        listF(":~:", "𝑭"),
        listQ2("&", "𝑸", "=", "𝑽");

        public final String prefix;
        public final String prefix2;
        public final String sub;
        public final String sub2;

        Structure(String str, String str2, String str3, String str4) {
            this.sub = str;
            this.sub2 = str3;
            this.prefix = str2;
            this.prefix2 = str4;
        }

        Structure(String str, String str2) {
            this(str, str2, null, null);
        }

        Structure() {
            this(null, null, null, null);
        }
    }

    private static void appendPercentEscaped(StringBuilder sb, String str) {
        for (byte b : str.getBytes(StandardCharsets.UTF_8)) {
            sb.append('%');
            sb.append(Utility.hex(b & UCharacterEnums.ECharacterDirection.DIRECTIONALITY_UNDEFINED, 2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String unescape(String str) {
        return unescape(str, UnicodeSet.EMPTY);
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class UrlInternals {
        private NavigableMap<Part, List<List<String>>> data;

        /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
        public enum EndStatus {
            MEDIAL,
            FINAL
        }

        private UrlInternals(Map<Part, List<List<String>>> map) {
            this.data = XCldrStub.immutableSortedMap(map);
        }

        public static UrlInternals from(String str) {
            EnumMap enumMap = new EnumMap(Part.class);
            int i = 0;
            for (final Part part : Part.values()) {
                if (AnonymousClass1.$SwitchMap$com$ibm$icu$impl$links$LinkHandlingUtilities$Part[part.ordinal()] != 1) {
                    int iSpan = part.terminators.span(str, i, UnicodeSet.SpanCondition.NOT_CONTAINED);
                    if (i != iSpan) {
                        if (part != Part.HOST) {
                            i++;
                        }
                        String strSubstring = str.substring(i, iSpan);
                        Structure structure = part.structure;
                        String str2 = structure.sub;
                        if (str2 == null) {
                            ArrayList arrayList = new ArrayList(1);
                            Object obj = new Object[]{strSubstring}[0];
                            Objects.requireNonNull(obj);
                            arrayList.add(obj);
                            Object[] objArr = {Collections.unmodifiableList(arrayList)};
                            ArrayList arrayList2 = new ArrayList(1);
                            Object obj2 = objArr[0];
                            Objects.requireNonNull(obj2);
                            arrayList2.add(obj2);
                            enumMap.put(part, Collections.unmodifiableList(arrayList2));
                        } else if (structure.sub2 == null) {
                            enumMap.put(part, LinkHandlingUtilities.cleanList(part, strSubstring));
                        } else {
                            enumMap.put(part, (List) XCldrStub.Splitter.on(str2).splitToStream(strSubstring).map(new Function() { // from class: com.ibm.icu.impl.links.a
                                @Override // java.util.function.Function
                                public final Object apply(Object obj3) {
                                    return LinkHandlingUtilities.UrlInternals.lambda$from$0(part, (String) obj3);
                                }
                            }).collect(Collectors.toList()));
                        }
                    }
                    if (iSpan == str.length()) {
                        break;
                    }
                    i = iSpan;
                } else {
                    int iIndexOf = str.indexOf("://");
                    if (iIndexOf > 0) {
                        i = iIndexOf + 3;
                        Part part2 = Part.PROTOCOL;
                        Object[] objArr2 = {str.substring(0, i)};
                        ArrayList arrayList3 = new ArrayList(1);
                        Object obj3 = objArr2[0];
                        Objects.requireNonNull(obj3);
                        arrayList3.add(obj3);
                        Object[] objArr3 = {Collections.unmodifiableList(arrayList3)};
                        ArrayList arrayList4 = new ArrayList(1);
                        Object obj4 = objArr3[0];
                        Objects.requireNonNull(obj4);
                        arrayList4.add(obj4);
                        enumMap.put(part2, Collections.unmodifiableList(arrayList4));
                    }
                }
            }
            return new UrlInternals(enumMap);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ List lambda$from$0(Part part, String str) {
            return LinkHandlingUtilities.splitList(part, part.structure.sub2, str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Type inference failed for: r0v1, types: [T, com.ibm.icu.impl.links.LinkHandlingUtilities$Part] */
        public static /* synthetic */ String lambda$fullEscape$1(Output output, Map.Entry entry) {
            ?? r0 = (Part) entry.getKey();
            output.value = r0;
            return r0.fullEscape((List) entry.getValue());
        }

        public boolean equals(Object obj) {
            if (obj instanceof UrlInternals) {
                return this.data.equals(((UrlInternals) obj).data);
            }
            return false;
        }

        public String fullEscape() {
            Output output = new Output();
            String str = (String) this.data.entrySet().stream().map(new y90(2, output)).collect(Collectors.joining());
            T t = output.value;
            if (t == 0 || t == Part.HOST || t == Part.PROTOCOL) {
                return str;
            }
            int iCodePointBefore = str.codePointBefore(str.length());
            if (!LinkTermination.SOFT.base.contains(iCodePointBefore)) {
                return str;
            }
            StringBuilder sb = new StringBuilder(str.substring(0, str.length() - Character.charCount(iCodePointBefore)));
            LinkHandlingUtilities.appendPercentEscaped(sb, iCodePointBefore);
            return sb.toString();
        }

        public List<List<String>> get(Part part) {
            return this.data.get(part);
        }

        public int hashCode() {
            return Objects.hash(this.data);
        }

        public String minimalEscape(EndStatus endStatus) {
            StringBuilder sb = new StringBuilder();
            Set<Map.Entry<Part, List<List<String>>>> setEntrySet = this.data.entrySet();
            ArrayList arrayList = new ArrayList(setEntrySet.size());
            for (Map.Entry<Part, List<List<String>>> entry : setEntrySet) {
                Objects.requireNonNull(entry);
                arrayList.add(entry);
            }
            List<Map.Entry> listUnmodifiableList = Collections.unmodifiableList(arrayList);
            Part part = null;
            for (Map.Entry entry2 : listUnmodifiableList) {
                if (!((List) entry2.getValue()).isEmpty()) {
                    part = (Part) entry2.getKey();
                }
            }
            for (Map.Entry entry3 : listUnmodifiableList) {
                Part part2 = (Part) entry3.getKey();
                List list = (List) entry3.getValue();
                if (!list.isEmpty()) {
                    Structure structure = part2.structure;
                    String str = structure.sub;
                    int i = 0;
                    if (str == null) {
                        sb.append((String) ((List) list.get(0)).get(0));
                    } else {
                        int[] array = LinkHandlingUtilities.joinListListEscaping(str, structure.sub2, list).codePoints().toArray();
                        int length = array.length;
                        int i2 = array[0];
                        int i3 = part2.initiator;
                        if (i2 != i3) {
                            sb.appendCodePoint(i3);
                        }
                        Stack stack = new Stack();
                        int i4 = 0;
                        while (i < length) {
                            int i5 = array[i];
                            if (i5 != 92) {
                                int i6 = AnonymousClass1.$SwitchMap$com$ibm$icu$impl$links$LinkHandlingUtilities$LinkTermination[(part2.terminators.contains(i5) ? LinkTermination.HARD : (LinkTermination) LinkTermination.PROPERTY_MAP.get(i5)).ordinal()];
                                if (i6 == 1) {
                                    LinkHandlingUtilities.appendCodePointsBetween(sb, array, i4, i);
                                    sb.appendCodePoint(i5);
                                } else if (i6 == 2) {
                                    LinkHandlingUtilities.appendCodePointsBetween(sb, array, i4, i);
                                    LinkHandlingUtilities.appendPercentEscaped(sb, i5);
                                } else if (i6 == 3) {
                                    continue;
                                } else if (i6 == 4) {
                                    stack.push(Integer.valueOf(i5));
                                    LinkHandlingUtilities.appendCodePointsBetween(sb, array, i4, i);
                                    sb.appendCodePoint(i5);
                                } else {
                                    if (i6 != 5) {
                                        dk0.v();
                                        return null;
                                    }
                                    if (stack.empty()) {
                                        LinkHandlingUtilities.appendCodePointsBetween(sb, array, i4, i);
                                        LinkHandlingUtilities.appendPercentEscaped(sb, i5);
                                    } else if (LinkHandlingUtilities.getOpening(i5) == ((Integer) stack.pop()).intValue()) {
                                        LinkHandlingUtilities.appendCodePointsBetween(sb, array, i4, i);
                                        sb.appendCodePoint(i5);
                                    } else {
                                        LinkHandlingUtilities.appendCodePointsBetween(sb, array, i4, i);
                                        LinkHandlingUtilities.appendPercentEscaped(sb, i5);
                                    }
                                }
                                i4 = i + 1;
                            } else {
                                LinkHandlingUtilities.appendCodePointsBetween(sb, array, i4, i);
                                if (i < length - 1) {
                                    int i7 = i + 1;
                                    LinkHandlingUtilities.appendPercentEscaped(sb, array[i7]);
                                    i4 = i + 2;
                                    i = i7;
                                } else {
                                    LinkHandlingUtilities.appendPercentEscaped(sb, i5);
                                    i4 = i + 1;
                                }
                            }
                            i++;
                        }
                        if (endStatus == EndStatus.MEDIAL || part2 != part) {
                            LinkHandlingUtilities.appendCodePointsBetween(sb, array, i4, length);
                        } else if (i4 < length) {
                            int i8 = length - 1;
                            LinkHandlingUtilities.appendCodePointsBetween(sb, array, i4, i8);
                            LinkHandlingUtilities.appendPercentEscaped(sb, array[i8]);
                        }
                    }
                }
            }
            return sb.toString();
        }

        public String toString(Set<Part> set) {
            StringBuilder sb = new StringBuilder("{");
            for (Map.Entry<Part, List<List<String>>> entry : this.data.entrySet()) {
                Part key = entry.getKey();
                Iterator<List<String>> it = entry.getValue().iterator();
                int i = -1;
                while (it.hasNext()) {
                    i++;
                    int i2 = -1;
                    for (String str : it.next()) {
                        i2++;
                        if (sb.length() != 1) {
                            sb.append(Padder.FALLBACK_PADDING_STRING);
                        }
                        int i3 = AnonymousClass1.$SwitchMap$com$ibm$icu$impl$links$LinkHandlingUtilities$Structure[key.structure.ordinal()];
                        if (i3 == 1) {
                            sb.append(key == Part.PROTOCOL ? "𝑺" : "𝑯");
                        } else if (i3 == 2) {
                            sb.append(key.structure.prefix);
                        } else if (i3 == 3) {
                            sb.append(i == 0 ? key.structure.prefix : "𝑫");
                        } else if (i3 == 4) {
                            Structure structure = key.structure;
                            sb.append(i2 == 0 ? structure.prefix : structure.prefix2);
                        }
                        sb.append('=');
                        sb.append(str);
                    }
                }
            }
            sb.append("}");
            return sb.toString();
        }

        public String toString() {
            return toString(Part.ALL);
        }
    }
}
