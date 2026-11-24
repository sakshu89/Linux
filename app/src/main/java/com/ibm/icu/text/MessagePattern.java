package com.ibm.icu.text;

import com.ibm.icu.impl.ICUConfig;
import com.ibm.icu.impl.PatternProps;
import com.ibm.icu.impl.PatternTokenizer;
import com.ibm.icu.util.Freezable;
import com.ibm.icu.util.ICUCloneNotSupportedException;
import defpackage.cq;
import defpackage.dk0;
import defpackage.og;
import java.util.ArrayList;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class MessagePattern implements Cloneable, Freezable<MessagePattern> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int ARG_NAME_NOT_NUMBER = -1;
    public static final int ARG_NAME_NOT_VALID = -2;
    private static final int MAX_PREFIX_LENGTH = 24;
    public static final double NO_NUMERIC_VALUE = -1.23456789E8d;
    private ApostropheMode aposMode;
    private volatile boolean frozen;
    private boolean hasArgNames;
    private boolean hasArgNumbers;
    private String msg;
    private boolean needsAutoQuoting;
    private ArrayList<Double> numericValues;
    private ArrayList<Part> parts;
    private static final ApostropheMode defaultAposMode = ApostropheMode.valueOf(ICUConfig.get("com.ibm.icu.text.MessagePattern.ApostropheMode", "DOUBLE_OPTIONAL"));
    private static final ArgType[] argTypes = ArgType.values();

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public enum ApostropheMode {
        DOUBLE_OPTIONAL,
        DOUBLE_REQUIRED
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public enum ArgType {
        NONE,
        SIMPLE,
        CHOICE,
        PLURAL,
        SELECT,
        SELECTORDINAL;

        public boolean hasPluralStyle() {
            return this == PLURAL || this == SELECTORDINAL;
        }
    }

    public MessagePattern(String str) {
        this.parts = new ArrayList<>();
        this.aposMode = defaultAposMode;
        parse(str);
    }

    private void addArgDoublePart(double d, int i, int i2) {
        int size;
        ArrayList<Double> arrayList = this.numericValues;
        if (arrayList == null) {
            this.numericValues = new ArrayList<>();
            size = 0;
        } else {
            size = arrayList.size();
            if (size > 32767) {
                og.o("Too many numeric values");
                return;
            }
        }
        this.numericValues.add(Double.valueOf(d));
        addPart(Part.Type.ARG_DOUBLE, i, i2, size);
    }

    private void addLimitPart(int i, Part.Type type, int i2, int i3, int i4) {
        this.parts.get(i).limitPartIndex = this.parts.size();
        addPart(type, i2, i3, i4);
    }

    private void addPart(Part.Type type, int i, int i2, int i3) {
        this.parts.add(new Part(i, type, i2, i3, 0));
    }

    public static void appendReducedApostrophes(String str, int i, int i2, StringBuilder sb) {
        loop0: while (true) {
            int i3 = -1;
            while (true) {
                int iIndexOf = str.indexOf(39, i);
                if (iIndexOf < 0 || iIndexOf >= i2) {
                    break loop0;
                }
                if (iIndexOf == i3) {
                    break;
                }
                sb.append((CharSequence) str, i, iIndexOf);
                i = iIndexOf + 1;
                i3 = i;
            }
            sb.append(PatternTokenizer.SINGLE_QUOTE);
            i++;
        }
        sb.append((CharSequence) str, i, i2);
    }

    private boolean inMessageFormatPattern(int i) {
        return i > 0 || this.parts.get(0).type == Part.Type.MSG_START;
    }

    private boolean inTopLevelChoiceMessage(int i, ArgType argType) {
        return i == 1 && argType == ArgType.CHOICE && this.parts.get(0).type != Part.Type.MSG_START;
    }

    private static boolean isArgTypeChar(int i) {
        if (97 > i || i > 122) {
            return 65 <= i && i <= 90;
        }
        return true;
    }

    private boolean isChoice(int i) {
        int i2 = i + 1;
        char cCharAt = this.msg.charAt(i);
        if (cCharAt != 'c' && cCharAt != 'C') {
            return false;
        }
        int i3 = i + 2;
        char cCharAt2 = this.msg.charAt(i2);
        if (cCharAt2 != 'h' && cCharAt2 != 'H') {
            return false;
        }
        int i4 = i + 3;
        char cCharAt3 = this.msg.charAt(i3);
        if (cCharAt3 != 'o' && cCharAt3 != 'O') {
            return false;
        }
        int i5 = i + 4;
        char cCharAt4 = this.msg.charAt(i4);
        if (cCharAt4 != 'i' && cCharAt4 != 'I') {
            return false;
        }
        int i6 = i + 5;
        char cCharAt5 = this.msg.charAt(i5);
        if (cCharAt5 != 'c' && cCharAt5 != 'C') {
            return false;
        }
        char cCharAt6 = this.msg.charAt(i6);
        return cCharAt6 == 'e' || cCharAt6 == 'E';
    }

    private boolean isOrdinal(int i) {
        int i2 = i + 1;
        char cCharAt = this.msg.charAt(i);
        if (cCharAt != 'o' && cCharAt != 'O') {
            return false;
        }
        int i3 = i + 2;
        char cCharAt2 = this.msg.charAt(i2);
        if (cCharAt2 != 'r' && cCharAt2 != 'R') {
            return false;
        }
        int i4 = i + 3;
        char cCharAt3 = this.msg.charAt(i3);
        if (cCharAt3 != 'd' && cCharAt3 != 'D') {
            return false;
        }
        int i5 = i + 4;
        char cCharAt4 = this.msg.charAt(i4);
        if (cCharAt4 != 'i' && cCharAt4 != 'I') {
            return false;
        }
        int i6 = i + 5;
        char cCharAt5 = this.msg.charAt(i5);
        if (cCharAt5 != 'n' && cCharAt5 != 'N') {
            return false;
        }
        int i7 = i + 6;
        char cCharAt6 = this.msg.charAt(i6);
        if (cCharAt6 != 'a' && cCharAt6 != 'A') {
            return false;
        }
        char cCharAt7 = this.msg.charAt(i7);
        return cCharAt7 == 'l' || cCharAt7 == 'L';
    }

    private boolean isPlural(int i) {
        int i2 = i + 1;
        char cCharAt = this.msg.charAt(i);
        if (cCharAt != 'p' && cCharAt != 'P') {
            return false;
        }
        int i3 = i + 2;
        char cCharAt2 = this.msg.charAt(i2);
        if (cCharAt2 != 'l' && cCharAt2 != 'L') {
            return false;
        }
        int i4 = i + 3;
        char cCharAt3 = this.msg.charAt(i3);
        if (cCharAt3 != 'u' && cCharAt3 != 'U') {
            return false;
        }
        int i5 = i + 4;
        char cCharAt4 = this.msg.charAt(i4);
        if (cCharAt4 != 'r' && cCharAt4 != 'R') {
            return false;
        }
        int i6 = i + 5;
        char cCharAt5 = this.msg.charAt(i5);
        if (cCharAt5 != 'a' && cCharAt5 != 'A') {
            return false;
        }
        char cCharAt6 = this.msg.charAt(i6);
        return cCharAt6 == 'l' || cCharAt6 == 'L';
    }

    private boolean isSelect(int i) {
        int i2 = i + 1;
        char cCharAt = this.msg.charAt(i);
        if (cCharAt != 's' && cCharAt != 'S') {
            return false;
        }
        int i3 = i + 2;
        char cCharAt2 = this.msg.charAt(i2);
        if (cCharAt2 != 'e' && cCharAt2 != 'E') {
            return false;
        }
        int i4 = i + 3;
        char cCharAt3 = this.msg.charAt(i3);
        if (cCharAt3 != 'l' && cCharAt3 != 'L') {
            return false;
        }
        int i5 = i + 4;
        char cCharAt4 = this.msg.charAt(i4);
        if (cCharAt4 != 'e' && cCharAt4 != 'E') {
            return false;
        }
        int i6 = i + 5;
        char cCharAt5 = this.msg.charAt(i5);
        if (cCharAt5 != 'c' && cCharAt5 != 'C') {
            return false;
        }
        char cCharAt6 = this.msg.charAt(i6);
        return cCharAt6 == 't' || cCharAt6 == 'T';
    }

    /* JADX WARN: Code duplicated, block: B:56:0x00e9  */
    private int parseArg(int i, int i2, int i3) {
        int iSkipWhiteSpace;
        char cCharAt;
        ArgType argType;
        int choiceStyle;
        int size = this.parts.size();
        ArgType argType2 = ArgType.NONE;
        addPart(Part.Type.ARG_START, i, i2, argType2.ordinal());
        int iSkipWhiteSpace2 = skipWhiteSpace(i + i2);
        if (iSkipWhiteSpace2 == this.msg.length()) {
            og.i(cq.j("Unmatched '{' braces in message ", prefix()));
            return 0;
        }
        int iSkipIdentifier = skipIdentifier(iSkipWhiteSpace2);
        int argNumber = parseArgNumber(iSkipWhiteSpace2, iSkipIdentifier);
        if (argNumber >= 0) {
            int i4 = iSkipIdentifier - iSkipWhiteSpace2;
            if (i4 > 65535 || argNumber > 32767) {
                og.o(cq.j("Argument number too large: ", prefix(iSkipWhiteSpace2)));
                return 0;
            }
            this.hasArgNumbers = true;
            addPart(Part.Type.ARG_NUMBER, iSkipWhiteSpace2, i4, argNumber);
        } else {
            if (argNumber != -1) {
                og.i(cq.j("Bad argument syntax: ", prefix(iSkipWhiteSpace2)));
                return 0;
            }
            int i5 = iSkipIdentifier - iSkipWhiteSpace2;
            if (i5 > 65535) {
                og.o(cq.j("Argument name too long: ", prefix(iSkipWhiteSpace2)));
                return 0;
            }
            this.hasArgNames = true;
            addPart(Part.Type.ARG_NAME, iSkipWhiteSpace2, i5, 0);
        }
        int iSkipWhiteSpace3 = skipWhiteSpace(iSkipIdentifier);
        if (iSkipWhiteSpace3 == this.msg.length()) {
            og.i(cq.j("Unmatched '{' braces in message ", prefix()));
            return 0;
        }
        char cCharAt2 = this.msg.charAt(iSkipWhiteSpace3);
        if (cCharAt2 == '}') {
            iSkipWhiteSpace = iSkipWhiteSpace3;
        } else {
            if (cCharAt2 != ',') {
                og.i(cq.j("Bad argument syntax: ", prefix(iSkipWhiteSpace2)));
                return 0;
            }
            int iSkipWhiteSpace4 = skipWhiteSpace(iSkipWhiteSpace3 + 1);
            int i6 = iSkipWhiteSpace4;
            while (i6 < this.msg.length() && isArgTypeChar(this.msg.charAt(i6))) {
                i6++;
            }
            int i7 = i6 - iSkipWhiteSpace4;
            iSkipWhiteSpace = skipWhiteSpace(i6);
            if (iSkipWhiteSpace == this.msg.length()) {
                og.i(cq.j("Unmatched '{' braces in message ", prefix()));
                return 0;
            }
            if (i7 == 0 || !((cCharAt = this.msg.charAt(iSkipWhiteSpace)) == ',' || cCharAt == '}')) {
                og.i(cq.j("Bad argument syntax: ", prefix(iSkipWhiteSpace2)));
                return 0;
            }
            if (i7 > 65535) {
                og.o(cq.j("Argument type name too long: ", prefix(iSkipWhiteSpace2)));
                return 0;
            }
            ArgType argType3 = ArgType.SIMPLE;
            if (i7 == 6) {
                if (isChoice(iSkipWhiteSpace4)) {
                    argType = ArgType.CHOICE;
                } else if (isPlural(iSkipWhiteSpace4)) {
                    argType = ArgType.PLURAL;
                } else if (isSelect(iSkipWhiteSpace4)) {
                    argType = ArgType.SELECT;
                } else {
                    argType = argType3;
                }
            } else if (i7 == 13 && isSelect(iSkipWhiteSpace4) && isOrdinal(iSkipWhiteSpace4 + 6)) {
                argType = ArgType.SELECTORDINAL;
            } else {
                argType = argType3;
            }
            this.parts.get(size).value = (short) argType.ordinal();
            if (argType == argType3) {
                addPart(Part.Type.ARG_TYPE, iSkipWhiteSpace4, i7, 0);
            }
            if (cCharAt != '}') {
                int i8 = iSkipWhiteSpace + 1;
                if (argType == argType3) {
                    choiceStyle = parseSimpleStyle(i8);
                } else {
                    choiceStyle = argType == ArgType.CHOICE ? parseChoiceStyle(i8, i3) : parsePluralOrSelectStyle(argType, i8, i3);
                }
                iSkipWhiteSpace = choiceStyle;
            } else if (argType != argType3) {
                og.i(cq.j("No style field for complex argument: ", prefix(iSkipWhiteSpace2)));
                return 0;
            }
            argType2 = argType;
        }
        addLimitPart(size, Part.Type.ARG_LIMIT, iSkipWhiteSpace, 1, argType2.ordinal());
        return iSkipWhiteSpace + 1;
    }

    private static int parseArgNumber(CharSequence charSequence, int i, int i2) {
        int i3;
        if (i >= i2) {
            return -2;
        }
        int i4 = i + 1;
        char cCharAt = charSequence.charAt(i);
        boolean z = false;
        if (cCharAt == '0') {
            if (i4 == i2) {
                return 0;
            }
            i3 = 0;
            z = true;
        } else {
            if ('1' > cCharAt || cCharAt > '9') {
                return -1;
            }
            i3 = cCharAt - '0';
        }
        while (i4 < i2) {
            int i5 = i4 + 1;
            char cCharAt2 = charSequence.charAt(i4);
            if ('0' > cCharAt2 || cCharAt2 > '9') {
                return -1;
            }
            if (i3 >= 214748364) {
                z = true;
            } else {
                i3 = (i3 * 10) + (cCharAt2 - '0');
            }
            i4 = i5;
        }
        if (z) {
            return -2;
        }
        return i3;
    }

    private int parseChoiceStyle(int i, int i2) {
        int iSkipWhiteSpace = skipWhiteSpace(i);
        if (iSkipWhiteSpace == this.msg.length() || this.msg.charAt(iSkipWhiteSpace) == '}') {
            og.i(cq.j("Missing choice argument pattern in ", prefix()));
            return 0;
        }
        while (true) {
            int iSkipDouble = skipDouble(iSkipWhiteSpace);
            int i3 = iSkipDouble - iSkipWhiteSpace;
            if (i3 == 0) {
                og.i(cq.j("Bad choice pattern syntax: ", prefix(i)));
                return 0;
            }
            if (i3 > 65535) {
                og.o(cq.j("Choice number too long: ", prefix(iSkipWhiteSpace)));
                return 0;
            }
            parseDouble(iSkipWhiteSpace, iSkipDouble, true);
            int iSkipWhiteSpace2 = skipWhiteSpace(iSkipDouble);
            if (iSkipWhiteSpace2 == this.msg.length()) {
                og.i(cq.j("Bad choice pattern syntax: ", prefix(i)));
                return 0;
            }
            char cCharAt = this.msg.charAt(iSkipWhiteSpace2);
            if (cCharAt != '#' && cCharAt != '<' && cCharAt != 8804) {
                throw new IllegalArgumentException("Expected choice separator (#<≤) instead of '" + cCharAt + "' in choice pattern " + prefix(i));
            }
            addPart(Part.Type.ARG_SELECTOR, iSkipWhiteSpace2, 1, 0);
            int message = parseMessage(iSkipWhiteSpace2 + 1, 0, i2 + 1, ArgType.CHOICE);
            if (message != this.msg.length()) {
                if (this.msg.charAt(message) != '}') {
                    iSkipWhiteSpace = skipWhiteSpace(message + 1);
                } else if (!inMessageFormatPattern(i2)) {
                    og.i(cq.j("Bad choice pattern syntax: ", prefix(i)));
                    return 0;
                }
            }
            return message;
        }
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0030  */
    /* JADX WARN: Code duplicated, block: B:16:0x0036  */
    /* JADX WARN: Code duplicated, block: B:17:0x0039  */
    /* JADX WARN: Code duplicated, block: B:22:0x0052 A[LOOP:0: B:22:0x0052->B:35:0x0070, LOOP_START, PHI: r0 r1 r3
      0x0052: PHI (r0v6 char) = (r0v5 char), (r0v10 char) binds: [B:12:0x002e, B:35:0x0070] A[DONT_GENERATE, DONT_INLINE]
      0x0052: PHI (r1v4 int) = (r1v3 int), (r1v5 int) binds: [B:12:0x002e, B:35:0x0070] A[DONT_GENERATE, DONT_INLINE]
      0x0052: PHI (r3v1 int) = (r3v0 int), (r3v3 int) binds: [B:12:0x002e, B:35:0x0070] A[DONT_GENERATE, DONT_INLINE]] */
    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not found exit edge by exit block: B:23:0x0054
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.checkLoopExits(LoopRegionMaker.java:272)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeLoopRegion(LoopRegionMaker.java:237)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:80)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:49)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
        */
    private void parseDouble(int r7, int r8, boolean r9) {
        /*
            r6 = this;
            java.lang.String r0 = r6.msg
            int r1 = r7 + 1
            char r0 = r0.charAt(r7)
            r2 = 45
            r3 = 0
            if (r0 != r2) goto L1c
            if (r1 == r8) goto L40
            java.lang.String r0 = r6.msg
            int r2 = r7 + 2
            char r0 = r0.charAt(r1)
            r1 = 1
            r5 = r2
            r2 = r1
            r1 = r5
            goto L2c
        L1c:
            r2 = 43
            if (r0 != r2) goto L2b
            if (r1 == r8) goto L40
            java.lang.String r0 = r6.msg
            int r2 = r7 + 2
            char r0 = r0.charAt(r1)
            r1 = r2
        L2b:
            r2 = r3
        L2c:
            r4 = 8734(0x221e, float:1.2239E-41)
            if (r0 != r4) goto L52
            if (r9 == 0) goto L40
            if (r1 != r8) goto L40
            if (r2 == 0) goto L39
            r0 = -4503599627370496(0xfff0000000000000, double:-Infinity)
            goto L3b
        L39:
            r0 = 9218868437227405312(0x7ff0000000000000, double:Infinity)
        L3b:
            int r8 = r8 - r7
            r6.addArgDoublePart(r0, r7, r8)
            return
        L40:
            java.lang.NumberFormatException r9 = new java.lang.NumberFormatException
            java.lang.String r6 = r6.msg
            java.lang.String r6 = r6.substring(r7, r8)
            java.lang.String r7 = "Bad syntax for numeric value: "
            java.lang.String r6 = r7.concat(r6)
            r9.<init>(r6)
            throw r9
        L52:
            r9 = 48
            if (r9 > r0) goto L7b
            r9 = 57
            if (r0 > r9) goto L7b
            int r3 = r3 * 10
            int r0 = r0 + (-48)
            int r3 = r3 + r0
            int r9 = r2 + 32767
            if (r3 <= r9) goto L64
            goto L7b
        L64:
            if (r1 != r8) goto L70
            com.ibm.icu.text.MessagePattern$Part$Type r9 = com.ibm.icu.text.MessagePattern.Part.Type.ARG_INT
            int r8 = r8 - r7
            if (r2 == 0) goto L6c
            int r3 = -r3
        L6c:
            r6.addPart(r9, r7, r8, r3)
            return
        L70:
            java.lang.String r9 = r6.msg
            int r0 = r1 + 1
            char r9 = r9.charAt(r1)
            r1 = r0
            r0 = r9
            goto L52
        L7b:
            java.lang.String r9 = r6.msg
            java.lang.String r9 = r9.substring(r7, r8)
            double r0 = java.lang.Double.parseDouble(r9)
            int r8 = r8 - r7
            r6.addArgDoublePart(r0, r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ibm.icu.text.MessagePattern.parseDouble(int, int, boolean):void");
    }

    private int parseMessage(int i, int i2, int i3, ArgType argType) {
        int i4;
        char cCharAt;
        int arg;
        if (i3 > 32767) {
            throw new IndexOutOfBoundsException();
        }
        int size = this.parts.size();
        addPart(Part.Type.MSG_START, i, i2, i3);
        int i5 = i + i2;
        while (true) {
            if (i5 >= this.msg.length()) {
                MessagePattern messagePattern = this;
                int i6 = i3;
                if (i6 <= 0 || messagePattern.inTopLevelChoiceMessage(i6, argType)) {
                    messagePattern.addLimitPart(size, Part.Type.MSG_LIMIT, i5, 0, i6);
                    return i5;
                }
                og.i(cq.j("Unmatched '{' braces in message ", messagePattern.prefix()));
                return 0;
            }
            i4 = i5 + 1;
            cCharAt = this.msg.charAt(i5);
            if (cCharAt == '\'') {
                if (i4 == this.msg.length()) {
                    this.addPart(Part.Type.INSERT_CHAR, i4, 0, 39);
                    this.needsAutoQuoting = true;
                } else {
                    char cCharAt2 = this.msg.charAt(i4);
                    if (cCharAt2 == '\'') {
                        i5 += 2;
                        this.addPart(Part.Type.SKIP_SYNTAX, i4, 1, 0);
                    } else if (this.aposMode == ApostropheMode.DOUBLE_REQUIRED || cCharAt2 == '{' || cCharAt2 == '}' || ((argType == ArgType.CHOICE && cCharAt2 == '|') || (argType.hasPluralStyle() && cCharAt2 == '#'))) {
                        this.addPart(Part.Type.SKIP_SYNTAX, i5, 1, 0);
                        while (true) {
                            int iIndexOf = this.msg.indexOf(39, i4 + 1);
                            String str = this.msg;
                            if (iIndexOf >= 0) {
                                int i7 = iIndexOf + 1;
                                if (i7 >= str.length() || this.msg.charAt(i7) != '\'') {
                                    this.addPart(Part.Type.SKIP_SYNTAX, iIndexOf, 1, 0);
                                    i5 = i7;
                                    this = this;
                                } else {
                                    this.addPart(Part.Type.SKIP_SYNTAX, i7, 1, 0);
                                    i4 = i7;
                                }
                            } else {
                                arg = str.length();
                                this.addPart(Part.Type.INSERT_CHAR, arg, 0, 39);
                                this.needsAutoQuoting = true;
                                i5 = arg;
                            }
                        }
                    } else {
                        this.addPart(Part.Type.INSERT_CHAR, i4, 0, 39);
                        this.needsAutoQuoting = true;
                    }
                }
                this = this;
                i5 = i4;
            } else {
                if (!argType.hasPluralStyle() || cCharAt != '#') {
                    if (cCharAt != '{') {
                        if ((i3 > 0 && cCharAt == '}') || (argType == ArgType.CHOICE && cCharAt == '|')) {
                            break;
                        }
                    } else {
                        arg = this.parseArg(i5, 1, i3);
                        i5 = arg;
                    }
                } else {
                    this.addPart(Part.Type.REPLACE_NUMBER, i5, 1, 0);
                }
                this = this;
                i5 = i4;
            }
            this = this;
            i3 = i3;
        }
        ArgType argType2 = ArgType.CHOICE;
        this.addLimitPart(size, Part.Type.MSG_LIMIT, i5, (argType == argType2 && cCharAt == '}') ? 0 : 1, i3);
        return argType == argType2 ? i5 : i4;
    }

    private int parsePluralOrSelectStyle(ArgType argType, int i, int i2) {
        int iSkipWhiteSpace;
        boolean z;
        int iSkipIdentifier;
        int message = i;
        boolean z2 = true;
        boolean z3 = false;
        while (true) {
            iSkipWhiteSpace = skipWhiteSpace(message);
            z = iSkipWhiteSpace == this.msg.length();
            if (z || this.msg.charAt(iSkipWhiteSpace) == '}') {
                break;
            }
            if (argType.hasPluralStyle() && this.msg.charAt(iSkipWhiteSpace) == '=') {
                int i3 = iSkipWhiteSpace + 1;
                iSkipIdentifier = skipDouble(i3);
                int i4 = iSkipIdentifier - iSkipWhiteSpace;
                if (i4 == 1) {
                    og.i(cq.l("Bad ", argType.toString().toLowerCase(Locale.ENGLISH), " pattern syntax: ", prefix(i)));
                    return 0;
                }
                if (i4 > 65535) {
                    og.o(cq.j("Argument selector too long: ", prefix(iSkipWhiteSpace)));
                    return 0;
                }
                addPart(Part.Type.ARG_SELECTOR, iSkipWhiteSpace, i4, 0);
                parseDouble(i3, iSkipIdentifier, false);
            } else {
                iSkipIdentifier = skipIdentifier(iSkipWhiteSpace);
                int i5 = iSkipIdentifier - iSkipWhiteSpace;
                if (i5 == 0) {
                    og.i(cq.l("Bad ", argType.toString().toLowerCase(Locale.ENGLISH), " pattern syntax: ", prefix(i)));
                    return 0;
                }
                if (argType.hasPluralStyle() && i5 == 6 && iSkipIdentifier < this.msg.length() && this.msg.regionMatches(iSkipWhiteSpace, "offset:", 0, 7)) {
                    if (!z2) {
                        og.i(cq.j("Plural argument 'offset:' (if present) must precede key-message pairs: ", prefix(i)));
                        return 0;
                    }
                    int iSkipWhiteSpace2 = skipWhiteSpace(iSkipIdentifier + 1);
                    int iSkipDouble = skipDouble(iSkipWhiteSpace2);
                    if (iSkipDouble == iSkipWhiteSpace2) {
                        og.i(cq.j("Missing value for plural 'offset:' ", prefix(i)));
                        return 0;
                    }
                    if (iSkipDouble - iSkipWhiteSpace2 > 65535) {
                        og.o(cq.j("Plural offset value too long: ", prefix(iSkipWhiteSpace2)));
                        return 0;
                    }
                    parseDouble(iSkipWhiteSpace2, iSkipDouble, false);
                    message = iSkipDouble;
                } else {
                    if (i5 > 65535) {
                        og.o(cq.j("Argument selector too long: ", prefix(iSkipWhiteSpace)));
                        return 0;
                    }
                    addPart(Part.Type.ARG_SELECTOR, iSkipWhiteSpace, i5, 0);
                    if (this.msg.regionMatches(iSkipWhiteSpace, PluralRules.KEYWORD_OTHER, 0, i5)) {
                        z3 = true;
                    }
                }
                z2 = false;
            }
            int iSkipWhiteSpace3 = skipWhiteSpace(iSkipIdentifier);
            if (iSkipWhiteSpace3 == this.msg.length() || this.msg.charAt(iSkipWhiteSpace3) != '{') {
                og.i(cq.l("No message fragment after ", argType.toString().toLowerCase(Locale.ENGLISH), " selector: ", prefix(iSkipWhiteSpace)));
                return 0;
            }
            message = parseMessage(iSkipWhiteSpace3, 1, i2 + 1, argType);
            z2 = false;
        }
        if (z == inMessageFormatPattern(i2)) {
            og.i(cq.l("Bad ", argType.toString().toLowerCase(Locale.ENGLISH), " pattern syntax: ", prefix(i)));
            return 0;
        }
        if (z3) {
            return iSkipWhiteSpace;
        }
        og.i(cq.l("Missing 'other' keyword in ", argType.toString().toLowerCase(Locale.ENGLISH), " pattern in ", prefix()));
        return 0;
    }

    private int parseSimpleStyle(int i) {
        int i2 = i;
        int i3 = 0;
        while (i2 < this.msg.length()) {
            int i4 = i2 + 1;
            char cCharAt = this.msg.charAt(i2);
            if (cCharAt == '\'') {
                int iIndexOf = this.msg.indexOf(39, i4);
                if (iIndexOf < 0) {
                    og.i(cq.j("Quoted literal argument style text reaches to the end of the message: ", prefix(i)));
                    return 0;
                }
                i2 = iIndexOf + 1;
            } else {
                if (cCharAt == '{') {
                    i3++;
                } else if (cCharAt == '}') {
                    if (i3 <= 0) {
                        int i5 = i2 - i;
                        if (i5 <= 65535) {
                            addPart(Part.Type.ARG_STYLE, i, i5, 0);
                            return i2;
                        }
                        og.o(cq.j("Argument style text too long: ", prefix(i)));
                        return 0;
                    }
                    i3--;
                }
                i2 = i4;
            }
        }
        og.i(cq.j("Unmatched '{' braces in message ", prefix()));
        return 0;
    }

    private void preParse(String str) {
        if (isFrozen()) {
            dk0.r(cq.v("Attempt to parse(", prefix(str), ") on frozen MessagePattern instance."));
            return;
        }
        this.msg = str;
        this.hasArgNumbers = false;
        this.hasArgNames = false;
        this.needsAutoQuoting = false;
        this.parts.clear();
        ArrayList<Double> arrayList = this.numericValues;
        if (arrayList != null) {
            arrayList.clear();
        }
    }

    private static String prefix(String str, int i) {
        StringBuilder sb = new StringBuilder(44);
        if (i == 0) {
            sb.append("\"");
        } else {
            sb.append("[at pattern index ");
            sb.append(i);
            sb.append("] \"");
        }
        if (str.length() - i <= 24) {
            if (i != 0) {
                str = str.substring(i);
            }
            sb.append(str);
        } else {
            int i2 = i + 20;
            if (Character.isHighSurrogate(str.charAt(i + 19))) {
                i2 = i + 19;
            }
            sb.append((CharSequence) str, i, i2);
            sb.append(" ...");
        }
        sb.append("\"");
        return sb.toString();
    }

    private int skipDouble(int i) {
        char cCharAt;
        while (i < this.msg.length() && (((cCharAt = this.msg.charAt(i)) >= '0' || "+-.".indexOf(cCharAt) >= 0) && (cCharAt <= '9' || cCharAt == 'e' || cCharAt == 'E' || cCharAt == 8734))) {
            i++;
        }
        return i;
    }

    private int skipIdentifier(int i) {
        return PatternProps.skipIdentifier(this.msg, i);
    }

    private int skipWhiteSpace(int i) {
        return PatternProps.skipWhiteSpace(this.msg, i);
    }

    public static int validateArgumentName(String str) {
        if (PatternProps.isIdentifier(str)) {
            return parseArgNumber(str, 0, str.length());
        }
        return -2;
    }

    public String autoQuoteApostropheDeep() {
        if (!this.needsAutoQuoting) {
            return this.msg;
        }
        int iCountParts = countParts();
        StringBuilder sb = null;
        while (iCountParts > 0) {
            iCountParts--;
            Part part = getPart(iCountParts);
            if (part.getType() == Part.Type.INSERT_CHAR) {
                if (sb == null) {
                    sb = new StringBuilder(this.msg.length() + 10);
                    sb.append(this.msg);
                }
                sb.insert(part.index, (char) part.value);
            }
        }
        return sb == null ? this.msg : sb.toString();
    }

    public void clear() {
        if (isFrozen()) {
            dk0.r("Attempt to clear() a frozen MessagePattern instance.");
            return;
        }
        this.msg = null;
        this.hasArgNumbers = false;
        this.hasArgNames = false;
        this.needsAutoQuoting = false;
        this.parts.clear();
        ArrayList<Double> arrayList = this.numericValues;
        if (arrayList != null) {
            arrayList.clear();
        }
    }

    public void clearPatternAndSetApostropheMode(ApostropheMode apostropheMode) {
        clear();
        this.aposMode = apostropheMode;
    }

    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public MessagePattern m18clone() {
        return isFrozen() ? this : cloneAsThawed();
    }

    @Override // com.ibm.icu.util.Freezable
    public MessagePattern cloneAsThawed() {
        try {
            MessagePattern messagePattern = (MessagePattern) super.clone();
            messagePattern.parts = (ArrayList) this.parts.clone();
            ArrayList<Double> arrayList = this.numericValues;
            if (arrayList != null) {
                messagePattern.numericValues = (ArrayList) arrayList.clone();
            }
            messagePattern.frozen = false;
            return messagePattern;
        } catch (CloneNotSupportedException e) {
            throw new ICUCloneNotSupportedException(e);
        }
    }

    public int countParts() {
        return this.parts.size();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && MessagePattern.class == obj.getClass()) {
            MessagePattern messagePattern = (MessagePattern) obj;
            if (this.aposMode.equals(messagePattern.aposMode)) {
                String str = this.msg;
                String str2 = messagePattern.msg;
                if (str != null ? str.equals(str2) : str2 == null) {
                    if (this.parts.equals(messagePattern.parts)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public ApostropheMode getApostropheMode() {
        return this.aposMode;
    }

    public int getLimitPartIndex(int i) {
        int i2 = this.parts.get(i).limitPartIndex;
        return i2 < i ? i : i2;
    }

    public double getNumericValue(Part part) {
        Part.Type type = part.type;
        if (type == Part.Type.ARG_INT) {
            return part.value;
        }
        if (type == Part.Type.ARG_DOUBLE) {
            return this.numericValues.get(part.value).doubleValue();
        }
        return -1.23456789E8d;
    }

    public Part getPart(int i) {
        return this.parts.get(i);
    }

    public Part.Type getPartType(int i) {
        return this.parts.get(i).type;
    }

    public int getPatternIndex(int i) {
        return this.parts.get(i).index;
    }

    public String getPatternString() {
        return this.msg;
    }

    public double getPluralOffset(int i) {
        Part part = this.parts.get(i);
        if (part.type.hasNumericValue()) {
            return getNumericValue(part);
        }
        return 0.0d;
    }

    public String getSubstring(Part part) {
        int i = part.index;
        return this.msg.substring(i, part.length + i);
    }

    public boolean hasNamedArguments() {
        return this.hasArgNames;
    }

    public boolean hasNumberedArguments() {
        return this.hasArgNumbers;
    }

    public int hashCode() {
        int iHashCode = this.aposMode.hashCode() * 37;
        String str = this.msg;
        return this.parts.hashCode() + ((iHashCode + (str != null ? str.hashCode() : 0)) * 37);
    }

    @Override // com.ibm.icu.util.Freezable
    public boolean isFrozen() {
        return this.frozen;
    }

    public boolean jdkAposMode() {
        return this.aposMode == ApostropheMode.DOUBLE_REQUIRED;
    }

    public MessagePattern parse(String str) {
        preParse(str);
        parseMessage(0, 0, 0, ArgType.NONE);
        postParse();
        return this;
    }

    public MessagePattern parsePluralStyle(String str) {
        preParse(str);
        parsePluralOrSelectStyle(ArgType.PLURAL, 0, 0);
        postParse();
        return this;
    }

    public MessagePattern parseSelectStyle(String str) {
        preParse(str);
        parsePluralOrSelectStyle(ArgType.SELECT, 0, 0);
        postParse();
        return this;
    }

    public boolean partSubstringMatches(Part part, String str) {
        return part.length == str.length() && this.msg.regionMatches(part.index, str, 0, part.length);
    }

    public String toString() {
        return this.msg;
    }

    @Override // com.ibm.icu.util.Freezable
    public MessagePattern freeze() {
        this.frozen = true;
        return this;
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class Part {
        private static final int MAX_LENGTH = 65535;
        private static final int MAX_VALUE = 32767;
        private final int index;
        private final char length;
        private int limitPartIndex;
        private final Type type;
        private short value;

        /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
        public enum Type {
            MSG_START,
            MSG_LIMIT,
            SKIP_SYNTAX,
            INSERT_CHAR,
            REPLACE_NUMBER,
            ARG_START,
            ARG_LIMIT,
            ARG_NUMBER,
            ARG_NAME,
            ARG_TYPE,
            ARG_STYLE,
            ARG_SELECTOR,
            ARG_INT,
            ARG_DOUBLE;

            public boolean hasNumericValue() {
                return this == ARG_INT || this == ARG_DOUBLE;
            }
        }

        private Part(Type type, int i, int i2, int i3) {
            this.type = type;
            this.index = i;
            this.length = (char) i2;
            this.value = (short) i3;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && Part.class == obj.getClass()) {
                Part part = (Part) obj;
                if (this.type.equals(part.type) && this.index == part.index && this.length == part.length && this.value == part.value && this.limitPartIndex == part.limitPartIndex) {
                    return true;
                }
            }
            return false;
        }

        public ArgType getArgType() {
            Type type = getType();
            return (type == Type.ARG_START || type == Type.ARG_LIMIT) ? MessagePattern.argTypes[this.value] : ArgType.NONE;
        }

        public int getIndex() {
            return this.index;
        }

        public int getLength() {
            return this.length;
        }

        public int getLimit() {
            return this.index + this.length;
        }

        public Type getType() {
            return this.type;
        }

        public int getValue() {
            return this.value;
        }

        public int hashCode() {
            return (((((this.type.hashCode() * 37) + this.index) * 37) + this.length) * 37) + this.value;
        }

        public String toString() {
            Type type = this.type;
            String strName = (type == Type.ARG_START || type == Type.ARG_LIMIT) ? getArgType().name() : Integer.toString(this.value);
            return this.type.name() + "(" + strName + ")@" + this.index;
        }

        public /* synthetic */ Part(int i, Type type, int i2, int i3, int i4) {
            this(type, i, i2, i3);
        }
    }

    public MessagePattern(ApostropheMode apostropheMode) {
        this.parts = new ArrayList<>();
        this.aposMode = apostropheMode;
    }

    public MessagePattern() {
        this.parts = new ArrayList<>();
        this.aposMode = defaultAposMode;
    }

    private void postParse() {
    }

    private int parseArgNumber(int i, int i2) {
        return parseArgNumber(this.msg, i, i2);
    }

    private static String prefix(String str) {
        return prefix(str, 0);
    }

    private String prefix(int i) {
        return prefix(this.msg, i);
    }

    private String prefix() {
        return prefix(this.msg, 0);
    }

    public MessagePattern parseChoiceStyle(String str) {
        preParse(str);
        parseChoiceStyle(0, 0);
        postParse();
        return this;
    }
}
